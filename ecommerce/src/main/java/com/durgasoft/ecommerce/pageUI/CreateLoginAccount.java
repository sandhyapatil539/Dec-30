package com.durgasoft.ecommerce.pageUI;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.durgasoft.ecommerce.basepage.Basepage;


public class CreateLoginAccount extends Basepage{
	  public static final Logger log=Logger.getLogger(CreateLoginAccount.class.getName());
		 
		 @FindBy(linkText = "Sign in") WebElement linkSignIN;
		 @FindBy(id = "email_create") WebElement txtemailID;
		 @FindBy(id = "SubmitCreat") WebElement btnCreateAnAccount;
		 @FindBy(xpath="//h1[text()='Create an account']")WebElement txtCreateAnAccount;
		 @FindBy(id="id_gender1") WebElement btnRadioMr; 
		 @FindBy(id= "customer_firstname")WebElement txtFirstName;
		 @FindBy(id= "customer_lastname")WebElement txtLastName;
		 @FindBy(id="passwd") WebElement txtPassword;
		 @FindBy(id="days") WebElement ddDays;
		 @FindBy(id="months") WebElement ddMonth; 
		 @FindBy(id= "years") WebElement ddYear; 
		 @FindBy(id ="address1") WebElement txtAddress1;
		 @FindBy(id="city") WebElement txtCity;

		 @FindBy(id="id_state") WebElement ddState;

		 @FindBy(id="postcode") WebElement txtZipCode; 
		 @FindBy(id="id_country") WebElement ddCountry; 
		 @FindBy(id= "phone_mobile") WebElement txtMobile;

		 @FindBy(id="alias")WebElement txtAliasAddress;

		 @FindBy(id= "submitAccount") WebElement btnRegister;
		 @FindBy(xpath="//h1[text()='MY account']")WebElement txtMyAccount;
		 
		 public CreateLoginAccount(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		 }

		 public void createAccount() throws Exception {
		  linkSignIN.click();
		  log.info("Clicked on SignIn button with object:"+linkSignIN.toString());
		  txtemailID.sendKeys(getData("firstname")+getData("lastname")+randomNumber()+getData("domainname"));
		  log.info("Entering EmailID:"+txtemailID.getAttribute("value")+"using object:"+txtemailID.toString());
		  btnCreateAnAccount.click();
		  log.info("Clicking on create an account:"+btnCreateAnAccount.toString());
		  Thread.sleep(15000);
		 assertEquals(txtCreateAnAccount.getText(),"CREATE AN ACCOUNT");
		 log.info("Verifying customer info page by using object:"+txtCreateAnAccount.toString());
		 
		         btnRadioMr.click();
		         log.info("Clicking on Mr.radio button by using object:"+btnRadioMr.toString());
		         txtFirstName.sendKeys("Mahesh");
		         log.info("Entering first name by using object:"+txtFirstName.toString());
			     txtLastName.sendKeys("D"); 
			     log.info("Entering last name by using object:"+txtLastName.toString());
				 txtPassword.sendKeys("abc@gmail.com"); 
				 log.info("Entering password by using object:"+txtPassword.toString());
				 ddDays.sendKeys("10");
				 ddMonth.sendKeys(" May");

				 ddYear.sendKeys("1990");

				 txtAddress1.sendKeys( "Mumbai");
				 txtCity.sendKeys("Hyderabad");

				 ddState.sendKeys(" Alabama");

				 txtZipCode.sendKeys("12345");

				 ddCountry.sendKeys("United States");

				 txtMobile.sendKeys("9087654321");

				 txtAliasAddress.sendKeys("UP");
			
				 btnRegister.click();
				  Thread .sleep(6000);
		
		 }

		
			
		}

	
		
		






