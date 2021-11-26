package attributes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.BasePage;

public class CartAtt extends BasePage{

	
	@FindBy(id="menuCart")
	protected WebElement menuCart;
	
	@FindBy(xpath="//td//label[contains(.,'Color')]/span")
	protected WebElement productColor;
	
	@FindBy(xpath="//div[@id='shoppingCart']//button")
	protected WebElement checkoutBtn;
	
	@FindBy(xpath="//*[@id='shoppingCart']//td[contains(.,'QUANTITY')]/label[2]")
	protected WebElement qntLabel;
	
	@FindBy(xpath="//*[@id='shoppingCart']//td[contains(.,'PRICE')]/p")
	protected WebElement priceLabel;
	
	@FindBy(xpath="//*[@id='shoppingCart']//a[text()='REMOVE']")
	protected WebElement removeBtn;
	
	@FindBy(xpath="//*[@id='shoppingCart']/div/label")
	protected WebElement emptyMsg;
	
}
