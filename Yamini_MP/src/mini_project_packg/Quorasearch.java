package mini_project_packg;
//package quora.search;

import java.io.File;

//*********MINI PROJECT***********//

//********    [ PROJECT NAME  -  QUORA SEARCH ]     *********//

//***********IMPORTS****************//

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.io.FileHandler;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Quorasearch {

	
	                        //******** Launch the QUORA SEARCH using CHROME *********//
@Test

	public void TESTCHROME() throws IOException{
	
	 // ***URL****QUORA SEARCH*****//
		
		String URL = "https://www.quora.com/profile/Quora";
		
		//Open the URL in CHROME
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mounika Chandra\\Documents\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//To maximize the Browser
				
		driver.get(URL);
		driver.manage().window().maximize();
		
		
		//Search the topic 'Testing'
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@placeholder='Search for questions, people, and topics']")).sendKeys("Testing");
			
	
		//Select the first option that appears in the search suggestion  
		
				WebDriverWait wait = new WebDriverWait(driver, 30);
				
				wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@id=\"selector-option-1\"]/div/div/div/div[2]/div/div/div"))));
				
				List<WebElement> autoSuggets = driver.findElements(By.xpath("//*[@id=\"selector-option-1\"]/div/div/div/div[2]/div/div/div"));
				autoSuggets.get(0).click();
				
				
		//Verify the title of the page which contains ‘Testing’ 
				
				String pagetitle = driver.getTitle();
				System.out.println("We get the Title " +pagetitle);
				Assert.assertEquals(pagetitle,"Transportation Insider" );
				
				
	   //Also verify if the text “Results for testing” is displayed in the result page otherwise fail the test case  
				
				String Result = driver.getPageSource();
				Result=driver.getPageSource();
				if(driver.getPageSource().contains("Result for Testing"+Result));
				
				
				//Capture the screenshot of the Results 
                 
                  
				File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String screenshot1 = "shot_chrome";
				FileHandler.copy(file, new File("C:\\Users\\Mounika Chandra\\Downloads\\YMPSS"+screenshot1+".png"));
		
				

				// close the browser

				driver.close();
				
				//-------------------------------------------------------------------------------------------------------------------------------------------------//
	
				//******** TO PRINT THE MESSAGE WHEN IT IS PASSED *****************//
				
				System.out.println("************** QUORA SEARCH  IS  SUCCESSFULLY PASSED  IN CHROME *****************");
}
      //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      //------------------------------------------------------------------------------------------------------------------------------------------------------------------

                       //********* Launch the QUORA SEARCH using FIREFOX ********//

  @Test
  
  public void TESTFIREFOX() throws IOException {
 	 
 	// ***URL****QUORA SEARCH*****//
 	 
  String URL = "https://www.quora.com/profile/Quora";
  
	
	//Open the URL Using FIREFOX
  
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mounika Chandra\\Downloads\\geckodriver-v0.29.0-win32\\geckodriver.exe");
	
	WebDriver driver = new FirefoxDriver();
	
	
	//To maximize the Browser
			
			driver.get(URL);
			driver.manage().window().maximize();
			
			
			//Search the topic 'Testing'
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//input[@placeholder='Search for questions, people, and topics']")).sendKeys("Testing");
			
			
			//Select the first option that appears in the search suggestion  
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@id='selector-option-0']"))));
		
			List<WebElement> autoSuggets = driver.findElements(By.xpath("//*[@id='selector-option-0']"));
			autoSuggets.get(0).click();
			
			
			// Verify the title of the page which contains ‘Testing’ 
			
			String pagetitle = driver.getTitle();
			System.out.println("We get the Title " +pagetitle);
			Assert.assertEquals(pagetitle,"Search" );
			
			
			//Also verify if the text “Results for testing” is displayedin the result page otherwise fail the test case  
			
			String Result = driver.getPageSource();
			Result=driver.getPageSource();
			if(driver.getPageSource().contains("Result for Testing"+Result));
			
			
			//Capture the screenshot of the Results 

			File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String screenshot2 = "shot_firefox";
			FileHandler.copy(file1, new File("C:\\Users\\Mounika Chandra\\Downloads\\YMPSS"+screenshot2+".png"));
			

			// close the browser

			driver.close();
			
			//----------------------------------------------------------------------------------------------------------------------------------------------------//

			//******** TO PRINT THE MESSAGE WHEN IT IS PASSED *****************//
			
			System.out.println("************** QUORA SEARCH  IS  SUCCESSFULLY PASSED IN FIREFOX*****************");
}
}

