package c4;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class C4 {
	WebDriver driver;
	
	@Given("open the browser and enter the url of the app")
	public void open_the_browser_and_enter_the_url_of_the_app() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		System.setProperty("webdriver.chrome.driver", "C:\\training testing\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
	}

	@And("give the login credentials of the admin")
	public void give_the_login_credentials_of_the_admin() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();//signin
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password456");
		driver.findElement(By.name("Login")).click();
	}

	@Then("click on the add category")
	public void click_on_the_add_category(io.cucumber.datatable.DataTable dataTable02) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new cucumber.api.PendingException();
		List<Map<String,String>> 
		list=dataTable02.asMaps(String.class, String.class);
		
		for(int i=0;i<list.size();i++) {
		String subcat=list.get(i).get("subcategory");
		String pro = list.get(i).get("Product");
		
		
		driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/button")).click();//add category
		driver.findElement(By.xpath("//*[@id=\"catgName\"]")).sendKeys("Sports005");//category name
		driver.findElement(By.xpath("//*[@id=\"catgDesc\"]")).sendKeys("ghdg");//category description
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div/div[3]/center/div[1]/input")).click();//add
		driver.navigate().back();
		driver.navigate().back();
		
		driver.findElement(By.xpath("/html/body/main/div/div/div/div[3]/button/h4")).click();//add subcategory
		
		WebElement cat1=driver.findElement(By.xpath("//*[@id=\"subCatgId\"]"));
		Select cat_01=new Select(cat1);
		cat_01.selectByVisibleText("Sports005");
		
		driver.findElement(By.xpath("//*[@id=\"subCatgName\"]")).sendKeys(subcat);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"subCatgDesc\"]")).sendKeys("hgds");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div/div[3]/center/div[1]/input")).click();//add
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
		
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div/div[3]/center/div[1]/input")).click();//add product
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		WebElement cat_02=driver.findElement(By.xpath("//*[@id=\"categorydropid\"]"));
		Select cat2=new Select(cat_02);
		cat2.selectByVisibleText("Sports005");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		WebElement cat_03=driver.findElement(By.xpath("//*[@id=\"subcategorydropid\"]"));
		Select cat3=new Select(cat_03);
		cat3.selectByVisibleText(subcat);
		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"prodid\"]")).sendKeys(pro);//product name
		driver.findElement(By.xpath("//*[@id=\"priceid\"]")).sendKeys("630");//price
		driver.findElement(By.xpath("//*[@id=\"quantityid\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"brandid\"]")).sendKeys("Hp");
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("gdf");
		
		if(pro=="Basketball") {
		WebElement element=driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[8]/div/div/div/div/div/div[1]/span/div/div/div/input"));//adding image
		element.sendKeys("C:\\Users\\sushma.v.n\\Downloads\\basketball.jpg");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		else {
			WebElement element=driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[8]/div/div/div/div/div/div[1]/span/div/div/div/input"));//adding image
			element.sendKeys("C:\\Users\\sushma.v.n\\Downloads\\volleyball.jpg");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[10]/div/input[1]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println("Product added");
		driver.findElement(By.linkText("Home")).click();
	}}
	 

	@And("execute next scenario")
	public void execute_next_scenario() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	@Given("User should be logged in")
	public void user_should_be_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}
	@Then("check the {string} of the page")
	public void check_the_of_the_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}



}
