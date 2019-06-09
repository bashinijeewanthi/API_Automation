package CalculatorPkg;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;
import org.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class CalculatorClass {
	    private static WindowsDriver CalculatorSession = null;
	    private static WebElement CalculatorResult = null;
	@BeforeClass
    public static void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
            Assert.assertNotNull(CalculatorResult);

        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
    }


    protected String _GetCalculatorResultText()
    {
        // trim extra text and whitespace off of the display value
        return CalculatorResult.getText().replace("Display is", "").trim();
    }
	
@Test
public void testCalc()
{
	  CalculatorSession.findElementByAccessibilityId ("num2Button").click();
      CalculatorSession.findElementByName("Plus").click();
      CalculatorSession.findElementByName("Three").click();
      CalculatorSession.findElementByName("Equals").click();
      Assert.assertEquals("5", _GetCalculatorResultText());
}
	
}
