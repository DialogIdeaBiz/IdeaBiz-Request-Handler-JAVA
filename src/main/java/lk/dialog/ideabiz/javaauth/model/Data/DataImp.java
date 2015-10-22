package lk.dialog.ideabiz.javaauth.model.Data;

import lk.dialog.ideabiz.javaauth.model.ApplicationInformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by anushkas on 10/19/15.
 */
public class DataImp implements DataInterface {


    @Override
    public ApplicationInformation getAppInfo(String applicationId) {
        ApplicationInformation applicationInformation =  new ApplicationInformation();


        return applicationInformation;
    }

    @Override
    public ApplicationInformation loadPropFile() {
        ApplicationInformation applicationInformation =  new ApplicationInformation();
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = getClass().getClassLoader().getResourceAsStream("config.properties");;
            prop.load(input);
            applicationInformation.setRefreshToken(prop.getProperty("auth_refreshToken"));
            applicationInformation.setTokenAPIURL(prop.getProperty("auth_url"));
            applicationInformation.setConsumerSecret(prop.getProperty("auth_consumerSecret"));
            applicationInformation.setConsumerKey(prop.getProperty("auth_consumerKey"));
            applicationInformation.setAccessToken(prop.getProperty("auth_accessToken"));
            applicationInformation.setApplicationId(prop.getProperty("app_id"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return applicationInformation;
    }

    @Override
    public boolean saveTokenFile(ApplicationInformation applicationInformation) {
        Properties prop = new Properties();
        OutputStream output = null;

        try {


            output = new FileOutputStream(getClass().getClassLoader().getResource("config.properties").getFile());

            prop.setProperty("auth_url", applicationInformation.getTokenAPIURL());
            prop.setProperty("auth_consumerKey", applicationInformation.getConsumerKey());
            prop.setProperty("auth_consumerSecret", applicationInformation.getConsumerSecret());
            prop.setProperty("auth_refreshToken", applicationInformation.getRefreshToken());
            prop.setProperty("auth_accessToken", applicationInformation.getAccessToken());
            prop.setProperty("auth_scope", "PRODUCTION");
            prop.setProperty("app_id", "206");

            // save properties to project root folder
            prop.store(output, null);
            return true;

        } catch (IOException io) {
            io.printStackTrace();
            return false;
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }





}
