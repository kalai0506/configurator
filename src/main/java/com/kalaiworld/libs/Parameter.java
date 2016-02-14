package com.kalaiworld.libs;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kalai on 2/14/16.
 */
//Mapping with the paramater in the config XML
@XmlRootElement(name="parameter")
public class Parameter {
    String parameterName;
    String parameterValue;


    @XmlAttribute(name="name")
    public String getName(){
        return parameterName;
    }

    public void setName(String parameterName){
        this.parameterName=parameterName;
    }

    @XmlElement(name="value")
    public String getParameterValue(){
        return parameterValue;
    }

    public void setParameterValue(String parameterValue){
        this.parameterValue=parameterValue;
    }
}
