package page;

import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;

import DAO.BaseDAO;
import attributes.CartAtt;
import utils.TestRule;

public class CartPage extends CartAtt{

	public CartPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	
	//método para entrar no carrinho
	public void enterCart() {
		menuCart.click();
	}
	
	//faz a verificação se a cor do produto no carrinho corresponde a cor selecionada
	public boolean checkProductColor(String color) {
		waitElement(productColor, 10);
		if(productColor.getText().equals(color)){
			return true;
		} else {
			return false;
		}
	}
	
	//invoca a classe de DAO pra realizar o UPDATE da cor selecionada no sistema
	public void updateColor() throws ClassNotFoundException, SQLException {
		new BaseDAO().updateColor(productColor.getText());
	}
	
	//recebe por parâmetro o valor do produto sozinho e faz o cálculo juntamente com a verificação do valor total no carrinho
	public boolean checkValue(double vlProduct) {
		waitElement(checkoutBtn, 15);
		
		int qntProducts = Integer.parseInt(qntLabel.getText());
		String price = priceLabel.getText().replaceAll("[^0-9]", "");
		double priceTotal = Double.parseDouble(price)/100;
		
		double totalCalculated = vlProduct*qntProducts;
		
		if(totalCalculated == priceTotal) {
			return true;
		} else {
			return false;
		}
	}
	
	//remove o produto do carrinho
	public void removeProduct() {
		waitElement(checkoutBtn, 15);
		
		removeBtn.click();
	}
	
	//verifica se a mensagem apresentada é de carrinho vazio
	public boolean verifyEmptyCart() {
		waitElement(emptyMsg, 10);
		
		if(emptyMsg.getText().contains("Your shopping cart is empty")) {
			return true;
		} else {
			return false;
		}
	}
}
