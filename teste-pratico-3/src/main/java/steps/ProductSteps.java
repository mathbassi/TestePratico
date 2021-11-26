package steps;

import java.sql.SQLException;

import org.json.JSONException;
import org.junit.Assert;

import DAO.BaseRepository;
import io.cucumber.java.pt.*;
import page.CartPage;
import page.ProductPage;

public class ProductSteps {
	
	@E("altero a cor do produto")
	public void alteroACorDoProduto() {
		try {
			new ProductPage().changeProductColor();
		} catch (JSONException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@E("altero a cor e quantidade do produto")
	public void alteroCorEQuantidade() {
		try {
			new ProductPage().changeProductColorDiffBD();
		} catch (JSONException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		new ProductPage().changeQnt();
	}
	
	@Entao("adiciono o produto ao carrinho")
	public void adicionoAoCarrinho() {
		new ProductPage().clickBtnByText("ADD TO CART");
	}
	
	@E("valido que o produto foi adicionado com a cor selecionada")
	public void validoCorProduto() {
		try {
			Assert.assertTrue(new CartPage().checkProductColor(new BaseRepository().getProduct().getString("COLOR")));
		} catch (JSONException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Entao("valido as especificacoes do produto com a base")
	public void validoEspecificacoesBase() {
		try {
			new ProductPage().verifySpec();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
