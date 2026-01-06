package com.fbn.utils;

/**
 * Config file to store configuration settings.
 *
 * This is preferred over configuration in non code file since storing this here provides us type-safety
 * and other static code analysis checks.
 */
public abstract class Config {
    private Config(){}

    public static final String BASE_URL = "http://128.251.99.120/obnadminportal";
    public static final String LOGIN_URL = "/login";

    public static final int TIMEOUT_IN_SECONDS = 10;
}