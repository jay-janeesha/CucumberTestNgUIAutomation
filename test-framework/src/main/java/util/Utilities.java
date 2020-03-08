package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import selenium.BaseTest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import static org.bitbucket.dollar.Dollar.$;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	private static final Logger LOGGER = LoggerFactory.getLogger(Utilities.class);
	 private static final Set<String> USED_UNIQUE_STRING = new HashSet<>();

   public static WebElement waitForElement(By locator, int timeout) {
       return new WebDriverWait(BaseTest.getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
   }

   public static WebElement waitForClassName(String className) {
       return waitForClassName(className, 60);
   }

   public static WebElement waitForName(String name) {
       return waitForName(name, 60);
   }

   public static WebElement waitForName(String name, int timeout) {
       return waitForElement(By.name(name), timeout);
   }

   public static WebElement waitForClassName(String className, int timeout) {
       return waitForElement(By.className(className), timeout);
   }

   public static WebElement waitForElementId(String id) {
       return waitForElementId(id, 60);
   }
   
   public static WebElement waitForElementXpath(String xpath) {
       return waitForElementXpath(xpath, 60);
   }

   public static WebElement waitForElementId(String id, int timeout) {
       return waitForElement(By.id(id), timeout);
   }
   
   public static WebElement waitForElementXpath(String xpath, int timeout) {
       return waitForElement(By.xpath(xpath), timeout);
   }
   
  
   public static String generateRandomDate(int addValue) {
       Calendar randomDate = Calendar.getInstance();
       randomDate.add(Calendar.YEAR, addValue);
       return new SimpleDateFormat("yyyy").format(randomDate.getTime())
               + "-" + new SimpleDateFormat("MMM").format(randomDate.getTime())
               + "-" + new SimpleDateFormat("dd").format(randomDate.getTime());

   }
   
   public static String getNextUniqueString() {
       String randomStr = $('a', 'z').join();
       return USED_UNIQUE_STRING.add($(randomStr).shuffle().slice(4).toString()) ? "Susan"+String.valueOf($(randomStr).shuffle().slice(4).toString())  : getNextUniqueString();
   }

}
