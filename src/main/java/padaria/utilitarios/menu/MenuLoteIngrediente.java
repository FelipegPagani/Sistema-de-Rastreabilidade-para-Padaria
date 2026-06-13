package padaria.utilitarios.menu;

import java.util.ArrayList;

public class MenuLoteIngrediente {

    private MenuLoteIngrediente() {
    }

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<String>();

        opcoes.add("Listar lotes de ingrediente");
        opcoes.add("Cadastrar lote de ingrediente");
        opcoes.add("Excluir lote de ingrediente");
        opcoes.add("Buscar lote de ingrediente");
        opcoes.add("Voltar");

        Menu menu = new Menu("CRUD Lote Ingrediente", opcoes);
        return menu.exibir();
    }
}