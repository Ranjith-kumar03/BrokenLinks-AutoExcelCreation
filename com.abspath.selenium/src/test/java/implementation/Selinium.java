package implementation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Selinium {
	private static final String string = null;
	public WebDriver driver;
	public WebElement element;
	static int pass =0, fail =0,count=1,wholecount=1;
	FileOutputStream foutnew;
	static List<WebElement> list;
	static String testme;
	static String response;
	Create_Write_Excel obj1=new Create_Write_Excel();
	 
	
	@Given("^open the explorer$")
	public void open_the_explorer() throws Throwable {
		
		
	    
		System.setProperty("webdriver.chrome.driver", "./Browser_Driver/chromedriver.exe");
		 driver = new ChromeDriver();
		 System.out.println(driver.manage().window().getSize()+"---Size of the browser");
		 System.out.println(driver.manage().window().getPosition()+"---posistion of the browser");
		 driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		 
		list= driver.findElements(By.xpath("//*[@href]"));
		
		System.out.println("Number of Links is ----"+list.size());
		
		for (int i=0;i<list.size();i++)
		{
			element=list.get(i);
			String testme= element.getAttribute("href");
			System.out.println(wholecount+"--"+testme);
			wholecount=wholecount+1;
			
		}
		
		
		for (int i=0;i<list.size();i++)
		{
			element=list.get(i);
			testme= element.getAttribute("href");
			
			Send_Link_for_test(testme);
		}
		System.out.println("Number of Links is ----"+list.size());
		System.out.println("Total Number of Passed Link is ---"+ pass);
		System.out.println("Total Number of failed Link is ---"+ fail);
		
		obj1.closing();
		
				driver.quit();
		
	}

	private void Send_Link_for_test(String testme) {
		
		
		try {
			URL links =new URL(testme);
			 
				HttpURLConnection connection = (HttpURLConnection)links.openConnection();
				connection.setConnectTimeout(1000);
				connection.connect();
				if(connection.getResponseCode()==200)
				{
					
					
					System.out.println(count+"-"+testme+ " - Link is Sucessful");
					response=connection.getResponseMessage();
					foutnew=obj1.execute();
					
					
					
												
					count=count+1;
					
					pass++;
				}
				
				if(connection.getResponseCode()!=200)
				{
					System.out.println(count+"-"+testme+ " - Link is UNSucessful Reason --"+connection.getResponseCode());
					response=connection.getResponseMessage();
					foutnew=obj1.execute();
					
					count=count+1;
					fail++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
		

	}
		
		
			
		
		
		
		
	
	

}
