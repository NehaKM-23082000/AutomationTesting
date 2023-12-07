import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		
		//predicate helps you to create a filter condition
		Predicate<URI> uriPredicate=uri->uri.getHost().contains("http://httpbin.org");
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo","bar"));
		driver.get("https://httpbin.org/basic-auth/foo/bar");
		System.out.println("hello new changes made");
		System.out.println("hello new changes made by second user");
		}
	
	public void notdata()
	{
		//changes to be made
		System.out.println("New changes");
	}
	
	public void newbranch()
	{
		//changes to be made
		System.out.println("New changes");
	}

}
