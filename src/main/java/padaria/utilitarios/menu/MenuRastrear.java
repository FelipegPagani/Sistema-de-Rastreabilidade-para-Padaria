package padaria.utilitarios.menu;

import java.util.ArrayList;

public class MenuRastrear {

    private MenuRastrear() {
    }

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<String>();
        opcoes.add("Rastrear produções por lote de ingrediente");
        opcoes.add("Voltar");

        Menu menu = new Menu("Menu de Rastreabilidade", opcoes);
        return menu.exibir();
    }
}
