package lk.dialog.ideabiz.javaauth;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lk.dialog.ideabiz.javaauth.model.Authenticator;
import lk.dialog.ideabiz.javaauth.model.RequestHandller;
import lk.dialog.ideabiz.javaauth.model.RequestMethod;

/**
 * Created by snushka on 08/23/2015.
 */
public class IdeaBizAPIHandler {


    public  String sendAPICall(String url,RequestMethod requestMethod,String body,String urlPara) throws Exception {
        RequestHandller requestHandller = new RequestHandller();
        Authenticator authenticator = new Authenticator();
        String results = "{}";
        JsonParser parser = new JsonParser();
     switch (requestMethod){
         case GET:
              results = requestHandller.getHTTP(url, authenticator.getAccessToken());
             try {

                 results = requestHandller.getHTTP(url, authenticator.getAccessToken());
                 JsonObject tokenOut = (JsonObject)parser.parse(results );
                 return results;
             }
             catch(Exception e){
                 if(results.contains("Access Token")){
                     authenticator.renewToken();
                     sendAPICall(url,requestMethod,body,urlPara);
                 }else {
                     throw e;
                 }
             }
             break;
         case POST:

            try {

                results = requestHandller.postHTTP(url, urlPara, authenticator.getAccessToken(), body);

                JsonObject tokenOut = (JsonObject)parser.parse(results );
                return results;
            }
            catch(Exception e){
                    if(results.contains("Access Token")){
                        authenticator.renewToken();
                        sendAPICall(url,requestMethod,body,urlPara);
                    }else {
                        throw e;
                    }
                }
             break;
     }
        return results;

    }
}
