package com.muggle.poseidon.config.security.properties;

/**
 * @program: poseidon-cloud-starter
 * @description:
 * @author: muggle
 * @create: 2019-11-05
 **/

public interface SecurityMessageProperties {
    String BAD_TOKEN="BAD_TOKEN";
    String SUBJECT ="POSEIDON_CLAIM";
    String ISSUER ="POSEIDON-CLOUD";
    String RANDOM = "RANDOM";
    String LOGIN_TYPE="loginType";
    String VERIFICATION="auth:verification:";
    String USER_NAME="auth:username:";
    String LOGOUT ="/logout" ;
    String LOGIN_URL = "/sign_in";
}
