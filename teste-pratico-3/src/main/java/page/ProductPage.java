package page;

import java.sql.SQLException;
import java.util.Random;

import org.json.JSONException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import DAO.BaseDAO;
import DAO.BaseRepository;
import attributes.ProductAtt;
import utils.TestRule;

public class ProductPage extends ProductAtt{
	
	public double productValue;

	public ProductPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
		setProductValue();
	}
	
	//muda para a cor q foi retornada do banco
	public void changeProductColor() throws JSONException, ClassNotFoundException, SQLException {
		waitElement(colors, 15);
		
		String color = new BaseRepository().getProduct().getString("COLOR");
		driver.findElement(By.xpath("//span[@id='bunny' and @title='"+ color +"']")).click();
	}
	
	//recebe a cor do banco de dados e seleciona aleatoriamente outra cor, exceto a retornada do banco
	public void changeProductColorDiffBD() throws JSONException, ClassNotFoundException, SQLException {
		waitElement(colors, 15);
		String color = new BaseRepository().getProduct().getString("COLOR");
		driver.findElements(By.xpath("//span[@id='bunny' and @title!='"+ color +"']"))
		.get(new Random().nextInt(5)).click();
	}
	
	//apaga o campo de quantidade e insere um numero aleatório de 2 a 9
	public void changeQnt() {
		String numberQnt = Integer.toString(new Random().nextInt((9+2)+2));
		quantityInput.sendKeys(Keys.BACK_SPACE);
		quantityInput.sendKeys(numberQnt);
	}
	
	//captura o valor do produto
	private void setProductValue() {
		waitElement(productValueH2, 15);
		String price = productValueH2.getText().replaceAll("[^0-9]", "");
		productValue = Double.parseDouble(price)/100;
	}
	
	//assert em cada campo da tabelo junto a base
	public void verifySpec() throws JSONException, ClassNotFoundException, SQLException {
		Assert.assertTrue(driver.findElement(By.xpath("//article[contains(.,'SPECIFICATIONS')]/div[contains(.,'CUSTOMIZATION')]/label[2]")).getText().equals(new BaseDAO().getProduct().get("CUSTOMIZATION")));
		Assert.assertTrue(driver.findElement(By.xpath("//article[contains(.,'SPECIFICATIONS')]/div[contains(.,'DISPLAY')]/label[2]")).getText().equals(new BaseDAO().getProduct().get("DISPLAY")));
		Assert.assertTrue(driver.findElement(By.xpath("//article[contains(.,'SPECIFICATIONS')]/div[contains(.,'DISPLAY RESOLUTION')]/label[2]")).getText().equals(new BaseDAO().getProduct().get("DISPLAY_RESOLUTION")));
		Assert.assertTrue(driver.findElement(By.xpath("//article[contains(.,'SPECIFICATIONS')]/div[contains(.,'DISPLAY SIZE')]/label[2]")).getText().equals(new BaseDAO().getProduct().get("DISPLAY_SIZE")));
		Assert.assertTrue(driver.findElement(By.xpath("//article[contains(.,'SPECIFICATIONS')]/div[contains(.,'MEMORY')]/label[2]")).getText().equals(new BaseDAO().getProduct().get("MEMORY")));
		Assert.assertTrue(driver.findElement(By.xpath("//article[contains(.,'SPECIFICATIONS')]/div[contains(.,'OPERATING SYSTEM')]/label[2]")).getText().equals(new BaseDAO().getProduct().get("OPERATING_SYSTEM")));
		Assert.assertTrue(driver.findElement(By.xpath("//article[contains(.,'SPECIFICATIONS')]/div[contains(.,'PROCESSOR')]/label[2]")).getText().equals(new BaseDAO().getProduct().get("PROCESSOR")));
		Assert.assertTrue(driver.findElement(By.xpath("//article[contains(.,'SPECIFICATIONS')]/div[contains(.,'TOUCHSCREEN')]/label[2]")).getText().equals(new BaseDAO().getProduct().get("TOUCHSCREEN")));
		Assert.assertTrue(driver.findElement(By.xpath("//article[contains(.,'SPECIFICATIONS')]/div[contains(.,'WEIGHT')]/label[2]")).getText().equals(new BaseDAO().getProduct().get("WEIGHT")));
	}
	
}