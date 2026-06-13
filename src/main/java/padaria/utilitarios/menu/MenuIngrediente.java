package padaria.utilitarios.menu;

import java.util.ArrayList;

public class MenuIngrediente {

    private MenuIngrediente() {
    }

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<String>();
        opcoes.add("Listar ingredientes");
        opcoes.add("Cadastrar ingrediente");
        opcoes.add("Excluir ingrediente via Id");
        opcoes.add("Excluir ingrediente via nome");
        opcoes.add("Buscar ingrediente via id");
        opcoes.add("Buscar ingrediente via nome");
        opcoes.add("Voltar");

        Menu menu = new Menu("CRUD Ingredientes", opcoes);
        return menu.exibir();
    }
}
