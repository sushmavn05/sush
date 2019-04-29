package c3;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class c3 {
	WebDriver driver;
	
	@Given("opens the browser and enter the testme app url")
	public void opens_the_browser_and_enter_the_testme_app_url() {
	    // Write code here that turns the phrase above into concrete actions
	   //throw new cucumber.api.PendingException();
		System.setProperty("webdriver.chrome.driver", "C:\\training testing\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
	}

	@Given("admin enters login credential")
	public void admin_enters_login_credential(io.cucumber.datatable.DataTable dataTable01) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();//signin
		List<Map<String,String>> 
		list=dataTable01.asMaps(String.class, String.class);
			String user=list.get(0).get("username");
			String pass=list.get(0).get("password");
			driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys(user);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
		driver.findElement(By.name("Login")).click();
	}

	@Then("click on add to category and enter category and subcategory names")
	public void click_on_add_to_category_and_enter_category_and_subcategory_names(io.cucumber.datatable.DataTable dataTable02) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/button")).click();//add category
		
		List<Map<String,String>> 
		list=dataTable02.asMaps(String.class, String.class);
		String cat=	list.get(0).get("category");
		String subcat=list.get(0).get("subcategory");
		
		driver.findElement(By.xpath("//*[@id=\"catgName\"]")).sendKeys(cat);//category name
		driver.findElement(By.xpath("//*[@id=\"catgDesc\"]")).sendKeys("ghdg");//category description
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div/div[3]/center/div[1]/input")).click();//add
		driver.navigate().back();
		driver.navigate().back();
		
		driver.findElement(By.xpath("/html/body/main/div/div/div/div[3]/button/h4")).click();//add subcategory
		WebElement cat1=driver.findElement(By.xpath("//*[@id=\"subCatgId\"]"));
		Select cat_01=new Select(cat1);
		cat_01.selectByVisibleText(cat);
		
		driver.findElement(By.xpath("//*[@id=\"subCatgName\"]")).sendKeys(subcat);
		driver.findElement(By.xpath("//*[@id=\"subCatgDesc\"]")).sendKeys("hgds");
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div/div[3]/center/div[1]/input")).click();//add
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
		
driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/button/h4")).click();//add product
		
		WebElement cat_02=driver.findElement(By.xpath("//*[@id=\"categorydropid\"]"));
		Select cat2=new Select(cat_02);
		cat2.selectByVisibleText(cat);
		
		WebElement cat_03=driver.findElement(By.xpath("//*[@id=\"subcategorydropid\"]"));
		Select cat3=new Select(cat_03);
		cat3.selectByVisibleText(subcat);
		
		
	}

	@Then("enter the product name and price")
	public void enter_the_product_name_and_price(io.cucumber.datatable.DataTable dataTable03) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new cucumber.api.PendingException();
		List<Map<String,String>> 
		list=dataTable03.asMaps(String.class, String.class);
		String product=	list.get(0).get("product");
		String price=list.get(0).get("price");
		
		driver.findElement(By.xpath("//*[@id=\"prodid\"]")).sendKeys(product);//product name
		driver.findElement(By.xpath("//*[@id=\"priceid\"]")).sendKeys(price);//price
		
	}

	@Then("enter the quantity and brand")
	public void enter_the_quantity_and_brand(io.cucumber.datatable.DataTable dataTable04) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new cucumber.api.PendingException();
		List<Map<String,String>> 
		list=dataTable04.asMaps(String.class, String.class);
		String quantity=list.get(0).get("Quantity");
		String brand=list.get(0).get("brand");
		
		driver.findElement(By.xpath("//*[@id=\"quantityid\"]")).sendKeys(quantity);
		driver.findElement(By.xpath("//*[@id=\"brandid\"]")).sendKeys(brand);
		
	}

	@Then("enter the decsription for the product")
	public void enter_the_decsription_for_the_product(io.cucumber.datatable.DataTable dataTable05) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new cucumber.api.PendingException();
		List<Map<String,String>> 
		list=dataTable05.asMaps(String.class, String.class);
		String desc=list.get(0).get("description");
		
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys(desc);
		WebElement element=driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[8]/div/div/div/div/div/div[1]/span/div/div/div/input"));//adding image
		element.sendKeys("C:\\Users\\sushma.v.n\\Downloads\\laptop.jpg");
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[10]/div/input[1]")).click();
		System.out.println("Product added");
		driver.findElement(By.linkText("Home")).click();
	}

	@Then("close the application and browser")
	public void close_the_application_and_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		
		
		driver.findElement(By.linkText("SignOut")).click();
		driver.close();
	}



}
