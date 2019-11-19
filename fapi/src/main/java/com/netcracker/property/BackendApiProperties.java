package com.netcracker.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BackendApiProperties {

    @Value("${back.server.uri}")
    private String backUri;

    public String getCategoryUri() {
        return backUri + "/category";
    }

    public String getCompanyUri() {
        return backUri + "/company";
    }

    public String getEWalletUri() {
        return backUri + "/ewallet";
    }

    public String getLoginUri() {
        return backUri + "/login";
    }

    public String getServicesUri() {
        return backUri + "/services";
    }

    public String getSubscriptionUri() {
        return backUri + "/subscription";
    }

    public String getUserUri() {
        return backUri + "/user";
    }


}
