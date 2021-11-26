package attributes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.BasePage;

public class AdvantageOnlineAtt extends BasePage{
	
	@FindBy(id = "see_offer_btn")
	protected WebElement seeOfferBtn;

}
