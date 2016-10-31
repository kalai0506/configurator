package com.kalaiworld.libs;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;


@XmlRootElement(name="value")
public class Value {
    private String envType;
    private String envValue;

    @XmlAttribute(name="env")
    public String getEnvType() {
        return envType;
    }

    public void setEnvType(String envType) {
        this.envType = envType;
    }

    @XmlValue
    public String getEnvValue(){
        return envValue;
    }

    public void setEnvValue(String envValue){
        this.envValue = envValue;
    }

}
