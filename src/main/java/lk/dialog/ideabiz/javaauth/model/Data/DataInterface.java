package lk.dialog.ideabiz.javaauth.model.Data;

import lk.dialog.ideabiz.javaauth.model.ApplicationInformation;

/**
 * Created by Malinda on 10/19/2015.
 *
 * Impliment this interface depend on database connection
 */
public interface DataInterface {
    public ApplicationInformation getAppInfo(String applicationId);
    public ApplicationInformation loadPropFile();
    boolean saveTokenFile(ApplicationInformation applicationInformation);
}
