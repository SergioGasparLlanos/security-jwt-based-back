package org.sergiosoft.securityjwtbasedback.authentication.constants;

public class RoleConstants {

    public static final String ADMIN_ROLE = "ADMIN";
    public static final String ADMIN_ROLE_PREAUTHORIZE = "hasAuthority('" + ADMIN_ROLE + "')";

    public static final String USER_ROLE = "USER";
    public static final String USER_ROLE_PREAUTHORIZE = "hasAuthority('" + USER_ROLE + "')";
}
