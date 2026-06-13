package padaria.utilitarios.menu;

import java.util.ArrayList;

public class MenuPrincipal {

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Produtos");
        opcoes.add("Ingredientes");
        opcoes.add("Fornecedores");
        opcoes.add("Recebimentos");
        opcoes.add("Clientes");
        opcoes.add("Lote Ingrediente");
        opcoes.add("Lote Produção");
        opcoes.add("Rastrear");
        opcoes.add("Sair");
        Menu menu = new Menu("Menu Principal", opcoes);
        return menu.exibir();
    }

}
