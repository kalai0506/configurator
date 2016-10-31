import com.kalaiworld.libs.Configurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by kalai on 2/14/16.
 */
public class ConfiguratorTest {
    @Test
    public void testConfigParameter1(){
        Configurator configurator=new Configurator("src/test/resources/config-example.xml",null);
        HashMap<String,String> parameters=configurator.getAllParameters();
        for(int i=0;i<parameters.size();i++){
            System.out.println(""+parameters.toString());
        }
    }

//    @Test
//    public void testConfigParameter2(){
//        Configurator configurator=new Configurator();
//        String parameterName=configurator.getParameterValue("src/test/resources/config-example.xml",
//                "com.kalaiworld.application.dbPassword");
//        Assert.assertEquals(parameterName,"WRE67IYWT90fg","parameter value differs");
//    }
}
