package lk.dialog.ideabiz.javaauth;

import lk.dialog.ideabiz.javaauth.model.RequestMethod;

/**
 * Created by anushkas on 10/22/15.
 */
public class Main {

    public static void main(String[] args) {
        String url = "https://ideabiz.lk/apicall/subscription/v1/subscribe";
        RequestMethod requestMethod = RequestMethod.POST;
        IdeaBizAPIHandler ideaBizAPIHandler = new IdeaBizAPIHandler();
        String body = "{\n" +
                "  \"msisdn\": [\n" +
                "    \"9477231234\"\n" +
                "  ]\n" +
                "}";
        
        try {
          ideaBizAPIHandler.sendAPICall(url,requestMethod,body,"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

