import com.kalaiworld.libs.Configurator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kalai on 2/14/16.
 */
public class ConfiguratorTest {
    @Test
    public void testConfigParameter1(){
        Configurator configurator=new Configurator();
        String parameterName=configurator.getParameterValue("src/test/resources/config-example.xml",
                "com.kalaiworld.application.dbHost");
        Assert.assertEquals(parameterName,"kalaiworld.com","parameter value differs");
    }

    @Test
    public void testConfigParameter2(){
        Configurator configurator=new Configurator();
        String parameterName=configurator.getParameterValue("src/test/resources/config-example.xml",
                "com.kalaiworld.application.dbPassword");
        Assert.assertEquals(parameterName,"WRE67IYWT90fg","parameter value differs");
    }
}
