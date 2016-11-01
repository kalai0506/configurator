package com.kalaiworld.configurator.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/*
 * Mapping with the paramater in the config XML
 */
@XmlRootElement(name="parameter")
public class Parameter {
    private String parameterName;
    private ArrayList<Value> parameterValue;

    @XmlAttribute(name="name")
    public String getName(){
        return parameterName;
    }

    public void setName(String parameterName){
        this.parameterName=parameterName;
    }

    @XmlElement(name="value")
    public ArrayList<Value> getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(ArrayList<Value> parameterValue) {
        this.parameterValue = parameterValue;
    }
}
