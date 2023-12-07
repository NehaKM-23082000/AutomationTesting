import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.model.Request;
import org.openqa.selenium.devtools.v119.network.model.Response;
import org.openqa.selenium.devtools.v119.network.Network;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver=new ChromeDriver();
		
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		

		devtools.addListener(Network.requestWillBeSent(),request->{
			Request req=request.getRequest();
			System.out.println(req.getUrl());
			
		});
		
		//responseReceived event will get fired when a response is received. Below selenium code is to catch that event
		devtools.addListener(Network.responseReceived(), response->
		{
			Response res=response.getResponse();
			System.out.println(res.getUrl());		
			System.out.println(res.getStatus());
			if(res.getStatus().toString().startsWith("4"))
			{
				System.out.println(res.getUrl()+" is failing with status code"+res.getStatusText());
			}
			
		});
		
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

	}

}
