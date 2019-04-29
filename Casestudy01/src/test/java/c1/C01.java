package c1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class C01 {
	WebDriver driver;
	
	@Given("opens the browser url")
	public void opens_the_browser_url() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		
		System.setProperty("webdriver.chrome.driver", "C:\\training testing\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
	}

	@And("admin enters login credentials")
	public void admin_enters_login_credentials() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();//signin
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password456");
		driver.findElement(By.name("Login")).click();
	}

	@And("add new product")
	public void add_new_product() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/button")).click();//add category
		driver.findElement(By.xpath("//*[@id=\"catgName\"]")).sendKeys("Electronics_05");//category name
		driver.findElement(By.xpath("//*[@id=\"catgDesc\"]")).sendKeys("Laptops");//category description
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div/div[3]/center/div[1]/input")).click();//add
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.xpath("/html/body/main/div/div/div/div[3]/button/h4")).click();//add subcategory
		
		WebElement cat=driver.findElement(By.xpath("//*[@id=\"subCatgId\"]"));
		Select cat1=new Select(cat);
		cat1.selectByVisibleText("Electronics_05");
		
		driver.findElement(By.xpath("//*[@id=\"subCatgName\"]")).sendKeys("Lappie");
		driver.findElement(By.xpath("//*[@id=\"subCatgDesc\"]")).sendKeys("hgds");
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div/div[3]/center/div[1]/input")).click();//add
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
		
	}

	@When("admin click on add product")
	public void admin_click_on_add_product() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/button/h4")).click();//add product
		
		WebElement cat_02=driver.findElement(By.xpath("//*[@id=\"categorydropid\"]"));
		Select cat2=new Select(cat_02);
		cat2.selectByVisibleText("Electronics_05");
		
		WebElement cat_03=driver.findElement(By.xpath("//*[@id=\"subcategorydropid\"]"));
		Select cat3=new Select(cat_03);
		cat3.selectByVisibleText("Lappie");
		
		driver.findElement(By.xpath("//*[@id=\"prodid\"]")).sendKeys("HP Laptop_01");//product name
		driver.findElement(By.xpath("//*[@id=\"priceid\"]")).sendKeys("630");//price
		driver.findElement(By.xpath("//*[@id=\"quantityid\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"brandid\"]")).sendKeys("HP");
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("gdf");
		WebElement element=driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[8]/div/div/div/div/div/div[1]/span/div/div/div/input"));//adding image
		element.sendKeys("C:\\Users\\sushma.v.n\\Downloads\\laptop.jpg");
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[10]/div/input[1]")).click();
		System.out.println("Product added");
		driver.findElement(By.linkText("Home")).click();
	}

	@Then("product is added")
	public void product_is_added() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("/html/body/main/div/div/div/div[4]/button/h4")).click();
		WebElement cat_02=driver.findElement(By.xpath("//*[@id=\"categorydropid\"]"));
		Select cat2=new Select(cat_02);
		cat2.selectByVisibleText("Electronics_05");
		
		WebElement cat_03=driver.findElement(By.xpath("//*[@id=\"subcategorydropid\"]"));
		Select cat3=new Select(cat_03);
		cat3.selectByVisibleText("Lappie");
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/table/tbody/tr/td[5]/input")).click();
		driver.findElement(By.linkText("SignOut")).click();
		driver.close();
	}




}
