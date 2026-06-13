package padaria.utilitarios.menu;

import java.util.ArrayList;

public class MenuClientes {

    private MenuClientes() {
    }

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<String>();

        opcoes.add("Listar clientes");
        opcoes.add("Cadastrar cliente");
        opcoes.add("Excluir cliente via CPF");
        opcoes.add("Excluir cliente via nome");
        opcoes.add("Buscar cliente via nome");
        opcoes.add("Buscar cliente via CPF");
        opcoes.add("Voltar");

        Menu menu = new Menu("CRUD Clientes", opcoes);
        return menu.exibir();
    }
}