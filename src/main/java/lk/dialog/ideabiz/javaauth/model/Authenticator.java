package lk.dialog.ideabiz.javaauth.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lk.dialog.ideabiz.javaauth.model.Data.DataInterface;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by anushkas on 10/19/15.
 */
public class Authenticator {


    String accessToken;
     DataInterface dataInterface;
     String body="grant_type=refresh_token&refresh_token=";
     String urlPara ="token";
     RequestHandller requestHandller;
     ApplicationInformation applicationInformation;

    public Authenticator(DataInterface dataInterface){
        this.dataInterface = dataInterface;
      applicationInformation = dataInterface.loadPropFile();
        setAccessToken(applicationInformation);
      requestHandller = new RequestHandller();
         }

    public  boolean renewToken() {

        String apiCallurl = applicationInformation.getTokenAPIURL()+urlPara;
        String bodyFull = body+applicationInformation.getRefreshToken();
        String enc = base64Enc(applicationInformation.getConsumerKey(),applicationInformation.getConsumerSecret());
        try {
        JsonParser parser = new JsonParser();
        JsonObject tokenOut = (JsonObject)parser.parse(requestHandller.putHTTP(apiCallurl,bodyFull,enc));

            applicationInformation.setRefreshToken(tokenOut.get("refresh_token").toString().replace("\"", ""));
            applicationInformation.setAccessToken(tokenOut.get("access_token").toString().replace("\"", ""));
        }
        catch (Exception e){
            System.out.println("Please insert valid configs");
        }
       return dataInterface.saveTokenFile(applicationInformation);

    }

    public  String base64Enc(String consumerKey,String consumerSecret){
        String enc = consumerKey+":"+consumerSecret;
        byte[] encodedBytes = Base64.encodeBase64(enc.getBytes());
        return new String(encodedBytes);
    }

    public String getAccessToken(){
        return  accessToken;
    }
    public void setAccessToken(ApplicationInformation applicationInformation) {
        this.accessToken = applicationInformation.getAccessToken();
    }


}
