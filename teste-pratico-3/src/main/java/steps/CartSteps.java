package steps;

import java.sql.SQLException;

import org.junit.Assert;

import io.cucumber.java.pt.*;
import page.CartPage;
import page.ProductPage;

public class CartSteps {
	
	@Entao("valido a soma do preco dos produtos")
	public void validoSomaPrecos() {
		Assert.assertTrue(new CartPage().checkValue(new ProductPage().productValue));
	}
	
	@E("acesso a pagina de checkout")
	public void acessoPaginaCheckout() {
		new CartPage().enterCart();
	}

	@Entao("realizo alteracao do banco para a cor selecionada")
	public void realizoUpdateParaCor() {
		try {
			new CartPage().updateColor();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Entao("removo o produto do carrinho")
	public void removoProduto() {
		new CartPage().removeProduct();
	}
	
	@E("valido se o carrinho esta vazio")
	public void validoCarrinhoVazio() {
		Assert.assertTrue(new CartPage().verifyEmptyCart());
	}
}
