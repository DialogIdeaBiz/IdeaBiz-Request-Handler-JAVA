package lk.dialog.ideabiz.javaauth.model;

/**
 * Created by Malinda on 10/19/2015.
 */
public class ApplicationInformation {
    private String applicationId;
    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String refreshToken;
    private String tokenAPIURL;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getTokenAPIURL() {
        return tokenAPIURL;
    }

    public void setTokenAPIURL(String tokenAPIURL) {
        this.tokenAPIURL = tokenAPIURL;
    }
}
