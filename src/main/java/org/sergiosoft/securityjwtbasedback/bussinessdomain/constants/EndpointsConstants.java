package org.sergiosoft.securityjwtbasedback.bussinessdomain.constants;

public class EndpointsConstants {

    private static final String API = "/api";
    private static final String V1 = "/v1";

    public static final String ADMINS_CONTROLLER_ENDPOINT = API + "/administrators" + V1;
    public static final String USERS_CONTROLLER_ENDPOINT = API + "/users" + V1;
    public static final String GUESTS_CONTROLLER_ENDPOINT = API + "/guests" + V1;
}
