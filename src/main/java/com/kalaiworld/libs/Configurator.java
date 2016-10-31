package com.kalaiworld.libs;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;

public class Configurator {
    private String fileName;
    private String environment;
    private HashMap<String,String> parameters=new HashMap<String, String>();

    public Configurator(){
    }

    public Configurator(String fileName, String environment){
        this.fileName=fileName;
        this.environment=environment;
    }

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
     * @return
     */
    public HashMap<String,String> getAllParameters()  {
        ArrayList<Parameter> parameterList=getParameters(fileName);
        for(Parameter parameter:parameterList){
            String paramValue=null;
            if(parameter.getParameterValue().size()>0){
                ArrayList<Value> valueList=parameter.getParameterValue();
                for(Value value:valueList){
                    if(value.getEnvType()==null){
                        paramValue=value.getEnvValue();
                        break;
                    }else if(value.getEnvType().equalsIgnoreCase(environment)){
                        paramValue=value.getEnvValue();
                        break;
                    }
                }
            }
            parameters.put(parameter.getName(),paramValue);
        }
        return parameters;
    }

    /**
     * This method is used to retrieve value of a parameter
     * @param fileName with proper path if different from project home
     * @param parameterName
     * @return
     */
    public String getEnvironmentValue(String fileName,String parameterName)  {
        String parameterValue="dev";
        ArrayList<Parameter> parameterList=getParameters(fileName);
        for(Parameter parameter:parameterList){
            if(parameter.getName().equalsIgnoreCase(parameterName)){
                ArrayList<Value> valueList=parameter.getParameterValue();
                for(Value value:valueList){
                    parameterValue=value.getEnvValue();
                }
                break;
            }
        }
        return parameterValue;
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
                ArrayList<Value> valueList=parameter.getParameterValue();
                for(Value value:valueList){
                    parameterValue=value.getEnvValue();
                }
                break;
            }
        }
        return parameterValue;
    }
}
