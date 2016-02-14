package com.kalaiworld.libs;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.io.File;

/**
 * Created by kalai on 2/14/16.
 */
public class Configurator {

    public ArrayList<Parameter> getParameters(String fileSource){
        File configXMLFile=new File(fileSource);
        Config config = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            config = (Config) unmarshaller.unmarshal(configXMLFile);
        }catch (JAXBException je){
            System.out.print("Issue in Unmarshalling: "+ je);
        }
        ArrayList<Parameter> parameterList=config.getParameterList();
        return parameterList;
    }

    /**
     * This method is used to retrieve value of a parameter
     * @param fileName with proper path if different from project home
     * @param parameterName
     * @return
     */
    public String getParameterValue(String fileName,String parameterName)  {
        String parameterValue=null;
        ArrayList<Parameter> parameterList=getParameters(fileName);
        for(Parameter parameter:parameterList){
            if(parameter.getName().equalsIgnoreCase(parameterName)){
                parameterValue=parameter.getParameterValue();
                break;
            }
        }
        return parameterValue;
    }
}
