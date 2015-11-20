# IdeaBiz-Request-Handler-JAVA

This will handle the API call. and also it handle to token. If need,it will refresh existing token automatically . So you only need to make API call via this SDK

##Configuration
* Make **resources/config.properties** writable
* Change resources/config.properties files properties based on your application

Application token Details[ refer Documentation](https://ideabiz.lk/tools/token.html)

To get refresh token, you have to use **token api** with username once [ refer Documentation](http://docs.ideabiz.lk/en/Authorization/Authorization%20v1)

## Use
Once config.json is configured, you can import `lk.dialog.ideabiz.javaauth.model.RequestMethod` to your code.Then create `IdeaBizAPIHandler` object using `IdeaBizAPIHandler.java` class then call `sendAPICall` method with correct parameters. 

For example

```
import lk.dialog.ideabiz.javaauth.model.RequestMethod;
```
Creating `IdeaBizAPIHandler` object.
````
        IdeaBizAPIHandler ideaBizAPIHandler = new IdeaBizAPIHandler();
```

## Parameters
### URL
 complete URL of ideabiz api. Example for sms `https://ideabiz.lk/apicall/subscription/v1/subscribe`
### Method
 its a HTTP method. you can use `RequestMethod` Enum for that. this accepts string as well such as "POST and "GET". RequestMethod enum contains

```
RequestMethod::POST
RequestMethod::GET
RequestMethod::DELETE
RequestMethod::PUT

```

### Example code
Please refer `Main.java`
````
 public static void main(String[] args) {
        String url = "https://ideabiz.lk/apicall/subscription/v1/subscribe";
        
        RequestMethod requestMethod = RequestMethod.POST;
        
        IdeaBizAPIHandler ideaBizAPIHandler = new IdeaBizAPIHandler();
        
             String body = "{ "msisdn": ["94777123455] }";
             String urlPra = "";

        try {
          ideaBizAPIHandler.sendAPICall(url,requestMethod,body,urlPra);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
`````


