package attributes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import utils.BasePage;

public class ProductAtt extends BasePage{

	@FindBy(xpath="//span[@id='bunny']")
	protected WebElement colors;
	
	@FindBy(xpath="//input[@name='quantity']")
	protected WebElement quantityInput;
	
	@FindBy(xpath="//*[@id='Description']/h2")
	protected WebElement productValueH2;
	
}
