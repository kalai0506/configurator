import com.kalaiworld.configurator.Configurator;
import com.kalaiworld.configurator.exceptions.ConfiguratorException;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ConfiguratorTest {
    @Test
    public void testConfigParameter1() throws ConfiguratorException {
        Configurator configurator=new Configurator("src/test/resources/config-example.xml");
        HashMap<String,String> parameters=configurator.getAllParameters();
            System.out.println(""+parameters.toString());
    }

    @Test
    public void testConfigParameter2() throws ConfiguratorException {
        Configurator configurator=new Configurator();
        HashMap<String,String> parameters=configurator.getAllParameters();
        System.out.println(""+parameters.toString());
    }

}
