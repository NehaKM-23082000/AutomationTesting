import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		
		//using google earth and setting the location to madrid
		Map<String,Object> data=new HashMap<String,Object>();
		data.put("latitude",40);
		data.put("longitude",3);
		data.put("accuracy",1);
		driver.executeCdpCommand("Emulation.setGeolocationOverride",data);
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		Thread.sleep(5000);
		//System.out.println(driver.findElement(By.cssSelector("default-ltr-cache-tf8uj4 euy28771")).getText());
		
		
	}

}
