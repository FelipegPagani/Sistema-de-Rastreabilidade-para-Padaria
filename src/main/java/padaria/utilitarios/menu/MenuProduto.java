package padaria.utilitarios.menu;

import java.util.ArrayList;

public class MenuProduto {

    private MenuProduto() {
    }

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<String>();
        opcoes.add("Listar produtos");
        opcoes.add("Cadastrar produto");
        opcoes.add("Excluir produto via Id");
        opcoes.add("Excluir produto via nome");
        opcoes.add("Buscar produto via Id");
        opcoes.add("Buscar produto via nome");
        opcoes.add("Voltar");

        Menu menu = new Menu("CRUD Produto", opcoes);
        return menu.exibir();
    }
}
