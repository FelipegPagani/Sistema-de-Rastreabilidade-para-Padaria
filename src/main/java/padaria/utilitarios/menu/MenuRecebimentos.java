package padaria.utilitarios.menu;

import java.util.ArrayList;

public class MenuRecebimentos {

    private MenuRecebimentos() {
    }

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<String>();
        opcoes.add("Listar recebimentos");
        opcoes.add("Cadastrar recebimento");
        opcoes.add("Excluir recebimento via Id");
        opcoes.add("Excluir recebimento via lote");
        opcoes.add("Buscar recebimento via id");
        opcoes.add("Buscar recebimento via lote");
        opcoes.add("Buscar recebimento via ingrediente");
        opcoes.add("Buscar recebimento via fornecedor");
        opcoes.add("Voltar");

        Menu menu = new Menu("CRUD Ingredientes", opcoes);
        return menu.exibir();
    }
}
