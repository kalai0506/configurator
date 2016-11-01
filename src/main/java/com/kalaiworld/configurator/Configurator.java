package com.kalaiworld.configurator;

import com.kalaiworld.configurator.exceptions.ConfiguratorException;
import com.kalaiworld.configurator.jaxb.Config;
import com.kalaiworld.configurator.jaxb.Parameter;
import com.kalaiworld.configurator.jaxb.Value;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;

public class Configurator {
    private String envParamName="environment";
    private String fileName;
    private String environment="dev";
    private HashMap<String,String> parameters=new HashMap<String, String>();

    public Configurator(){
        this.fileName="config.xml";
    }

    public Configurator(String fileName){
        this.fileName=fileName;
    }

    public ArrayList<Parameter> getParameters(String fileSource) throws ConfiguratorException{
        File configXMLFile=new File(fileSource);
        verifyFile(configXMLFile);
        Config config;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            config = (Config) unmarshaller.unmarshal(configXMLFile);
        }catch (JAXBException je){
            System.out.print("Issue in Unmarshalling: "+ je);
            throw new ConfiguratorException("Exception while reading the parameters", je);
        }
        ArrayList<Parameter> parameterList=config.getParameterList();
        return parameterList;
    }

    public void verifyFile(File configXMLFile) throws ConfiguratorException{
            if(!configXMLFile.exists()){
                throw new ConfiguratorException("config xml file is not found in class path");
            }else if(!configXMLFile.isFile()){
                throw new ConfiguratorException("config xml file is not a valid file");
            }else if(!configXMLFile.canRead()){
                throw new ConfiguratorException("Unable to read config xml file");
            }
    }

    /**
     * This method is used to retrieve value of a parameter
     * @return
     */
    public HashMap<String,String> getAllParameters() throws ConfiguratorException {
        getEnvironmentValue();
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
     * @return
     */
    private void getEnvironmentValue() throws ConfiguratorException {
        ArrayList<Parameter> parameterList=getParameters(fileName);
        for(Parameter parameter:parameterList){
            if(parameter.getName().equalsIgnoreCase(envParamName)){
                ArrayList<Value> valueList=parameter.getParameterValue();
                environment=valueList.get(0).getEnvValue();
                break;
            }
        }
    }

    /**
     * This method is used to retrieve value of a parameter
     * @param parameterName
     * @return
     */
    public String getParameterValue(String parameterName) throws ConfiguratorException {
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
