import java.util.Arrays;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.fetch.Fetch;
import org.openqa.selenium.devtools.v119.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v119.network.model.ErrorReason;

public class NetworkFailedRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		RequestPattern pattern=new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty());
		Arrays.asList(pattern);
		devtools.send(Fetch.enable(Optional.of(Arrays.asList(pattern)), Optional.empty()));
		
		devtools.addListener(Fetch.requestPaused(), request->{
			devtools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		//The result should be a blank page
	}

}
