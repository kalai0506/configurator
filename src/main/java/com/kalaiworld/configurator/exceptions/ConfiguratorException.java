package com.kalaiworld.configurator.exceptions;

public class ConfiguratorException extends Exception {

    public ConfiguratorException(){

    }

    public ConfiguratorException(String message){
        super(message);
    }

    public ConfiguratorException(Throwable throwable){
        super(throwable);
    }

    public ConfiguratorException(String message,Throwable throwable){
        super(message,throwable);
    }

}
