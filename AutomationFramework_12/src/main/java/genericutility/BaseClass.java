package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelComePage;

public class BaseClass {
	// class is modified in github
	public static ExtentReports extReport;
	public WebDriver driver;
	public static ExtentTest test;
    public static WebDriver sdriver;
	
    public WebDriverUtiity wUtil=new WebDriverUtiity();
	public FileUtility fUtil=new FileUtility();
    public JavaUtility jUtil=new JavaUtility();
    public ExcelUtility eUtil=new ExcelUtility();

     public WelComePage wp;
    public LoginPage lp;
    public HomePage hp;
    
@BeforeSuite
public void reportConfig() {
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReport_"+jUtil.getSystemTime());
	extReport=new ExtentReports();
	extReport.attachReporter(spark);
}

@Parameters("Browser")
@BeforeClass
public void launchBrowser(@Optional("chrome") String browserName) throws IOException  {
	if(browserName.equals("chrome")) {
		driver=new ChromeDriver();
	}else if(browserName.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}else if(browserName.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
	sdriver=driver;
	wUtil.maximizeWindow(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get(fUtil.getDataFromProperty("url"));
	
}

@BeforeMethod
public void login() throws IOException {
	wp=new WelComePage(driver);
	wp.getLoginLink().click();
	
	lp=new LoginPage(driver);
	lp.getEmailTextField().sendKeys(fUtil.getDataFromProperty("email"));
	lp.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("Password"));
	lp.getLoginButton().click();
}
@AfterMethod
public void logout() {
	hp=new HomePage(driver);
	hp.getLogoutLink().click();
}
@AfterClass
public void closeBrowser() {
	driver.quit();
}

@AfterSuite
public void reportBackup() {
	extReport.flush();
}
}
