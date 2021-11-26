#language: pt
#encoding: utf-8
Funcionalidade: Compras no advantageOnline

  @validarEspecificacoesProduto
  Cenario: Validar especificacoes do produto
    Dado que acesso o sistema na url "advantageOnline" com o browser "chrome"
    E acesso o menu "SPECIAL OFFER"
    E clico no botao "SEE OFFER"
    Entao valido as especificacoes do produto com a base

  @validarAlteracaoCor
  Cenario: Validar alteracao de cor do produto no carrinho
    Dado que acesso o sistema na url "advantageOnline" com o browser "chrome"
    E acesso o menu "SPECIAL OFFER"
    E clico no botao "SEE OFFER"
    E altero a cor do produto
    Entao adiciono o produto ao carrinho
    E valido que o produto foi adicionado com a cor selecionada

  @validarSomaDeValores
  Cenario: Validar pagina de checkout
    Dado que acesso o sistema na url "advantageOnline" com o browser "chrome"
    E acesso o menu "SPECIAL OFFER"
    E clico no botao "SEE OFFER"
    E altero a cor e quantidade do produto
    Entao adiciono o produto ao carrinho
    E acesso a pagina de checkout
    Entao valido a soma do preco dos produtos
    E realizo alteracao do banco para a cor selecionada

  @RemoverProduto
  Cenario: Remover produto do carrinho de compras
    Dado que acesso o sistema na url "advantageOnline" com o browser "chrome"
    E acesso o menu "SPECIAL OFFER"
    E clico no botao "SEE OFFER"
    Entao adiciono o produto ao carrinho
    E acesso a pagina de checkout
    Entao removo o produto do carrinho
    E valido se o carrinho esta vazio
