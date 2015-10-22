package lk.dialog.ideabiz.javaauth.model;

import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;

/**
 * Created by anushkas on 10/19/15.
 */
public class RequestHandller {
    public String getHTTP (String url,String key){

       return getResponse(url,"",RequestMethod.GET,key,"{}");
    }
    public String  postHTTP (String url,String body,String key,String jsonBody){
       return getResponse(url,body,RequestMethod.POST,key,jsonBody);
    }
    public String  putHTTP (String url,String body,String key){
        return getResponse(url,body,RequestMethod.PUT,key,"{}");
    }

    private String getResponse(String url,String body,RequestMethod requestMethod,String key,String jsonBody ){
        String output ="{}" ;
        try {

            Client client = Client.create();
            client.addFilter(new LoggingFilter(System.out));

            WebResource webResource = client
                    .resource(url+"?"+body);

            ClientResponse response ;
            JsonParser parser = new JsonParser();
            switch (requestMethod) {
                case GET:
                   response = webResource.header("Content-Type","application/json").header("Accept", "application/json").header("Authorization:","Bearer "+key)
                           .post(ClientResponse.class);

                    output = response.getEntity(String.class);

                    break;
                case POST:

                    response = webResource.header("Content-Type","application/json").header("Accept", "application/json").header("Authorization","Bearer "+key)
                            .post(ClientResponse.class,jsonBody);

                    output = response.getEntity(String.class);


                    break;
                case PUT:
                    response = webResource.header("Content-Type","application/x-www-form-urlencoded").header("Accept", "application/json").header("Authorization","Basic "+key)
                            .post(ClientResponse.class);

                   output = response.getEntity(String.class);

                    break;
            }


        } catch (Exception e) {

            e.printStackTrace();

        }
        return output;
    }




}
