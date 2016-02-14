package com.kalaiworld.libs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by kalai on 2/14/16.
 */
@XmlRootElement(name="config")
public class Config {

    ArrayList<Parameter> parameterList;

    @XmlElement(name="parameter")
    public ArrayList<Parameter> getParameterList(){
        return parameterList;
    }

    public void setParameterList(ArrayList<Parameter> parameterList){
        this.parameterList=parameterList;
    }

}
