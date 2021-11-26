package steps;

import io.cucumber.java.pt.*;
import page.AdvantageOnlinePage;
import utils.TestRule;

public class advantageOnlineSteps {

	@Dado("que acesso o sistema na url {string} com o browser {string}")
	public void queAcessoOSistemaAtravesDaUrlNoComOBrowser(String url, String browser) {
		TestRule.openApplication(browser,url );
	}
	
	@E("acesso o menu {string}")
	public void acessoOMenu(String menu) {
		new AdvantageOnlinePage().clickMenu(menu);
	}
	
	@E("clico no botao {string}")
	public void clicloNoBotao(String btn) {
		new AdvantageOnlinePage().clickBtnByText(btn);;
	}

}
