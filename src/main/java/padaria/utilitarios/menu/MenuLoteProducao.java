package padaria.utilitarios.menu;

import java.util.ArrayList;

public class MenuLoteProducao {

    private MenuLoteProducao() {
    }

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<String>();

        opcoes.add("Listar lotes de produção");
        opcoes.add("Cadastrar lote de produção");
        opcoes.add("Excluir lote de produção");
        opcoes.add("Buscar lote de produção");
        opcoes.add("Voltar");

        Menu menu = new Menu("CRUD Lote Produção", opcoes);
        return menu.exibir();
    }
}