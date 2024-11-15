package genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtiity {
private static final WebElement WebElement = null;
/**
 * This method is used to maximize the window
 * @param driver
 */
	public void maximizeWindow(WebDriver  driver) {
		driver.manage().window().maximize();
	
		
	}
	/**
	 * this method is used to get height and width of the web Element
	 * @param driver
	 * @return
	 */
	
	public Dimension getSize(WebDriver driver) {
    return driver.manage().window().getSize();
	}
	/**
	 * this method is used to switch driver control to window based on url
	 * @param driver
	 * @param url
	 */
	public void switchToWindow(WebDriver driver,String url) {
		//step1 : capture window ids
		Set<String> allWindowIds = driver.getWindowHandles();
		//step2: navigate Through all the windows
		
		for(String id:allWindowIds) {
			
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			
			if(actUrl.contains(url)) {
				break;
			}
		
		}
		
		}
		public void rightClick(WebDriver driver) {
			Actions act=new Actions(driver);
			act.contextClick().perform();
			act.clickAndHold().perform();
	}
	
	public void clickAndHold(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	public void mouseHover(WebDriver driver,int x, int y) {
		Actions act=new Actions(driver);
		act.moveByOffset(x, y);
	}
	
	public void dragAndDrop(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.dragAndDrop(element, element);
	}
	
	public void switchToFrameByIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
		
	}
	
	public void switchToFrameById(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrameByElement(WebDriver driver,String Element) {
		driver.switchTo().frame(Element);
	}
	
	public void switchBackToMainPage(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	public void selectDropDownByIndex(WebElement element,int index) {
		Select st=new Select(element);
		st.selectByIndex(index);
	}
	
	public void selectDropDownByValue(WebElement element,String Element) {
		Select st=new Select(element);
		st.selectByValue("Element");
	}
	
	public void selectDropDownByVisibleText(WebElement element,String Bengaluru) {
		Select st=new Select(element);
		st.selectByVisibleText("Bengaluru");
	}
	
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToAlertAndSendKeys(WebDriver driver,String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	
	public void jsScroll(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+" )");
	}
	
	public void screenShot(WebDriver driver) throws IOException {
		String time = LocalDateTime.now().toString().replace(":", "-");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots"+time+".png");
	FileHandler.copy(temp, dest);
	}
	
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick();
		
	}

	public void switchToAlertAndGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
}
