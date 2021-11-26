package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import attributes.AdvantageOnlineAtt;
import utils.TestRule;

public class AdvantageOnlinePage extends AdvantageOnlineAtt{
	
	public AdvantageOnlinePage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	
	//acessa o menu de direcionamento
	public void clickMenu(String menu) {
		String xpath = "//a[.='"+ menu + "']";
		waitForElement(By.id("see_offer_btn"), 20);
		driver.findElement(By.xpath(xpath)).click();;
	}
	
	//click direto no botão see offer
	public void seeOffer() {
		seeOfferBtn.click();
	}

}
