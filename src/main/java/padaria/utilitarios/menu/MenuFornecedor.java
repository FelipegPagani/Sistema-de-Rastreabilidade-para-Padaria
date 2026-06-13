package padaria.utilitarios.menu;

import java.util.ArrayList;

public class MenuFornecedor {
    private MenuFornecedor() {
    }

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<String>();
        opcoes.add("Listar fornecedores");
        opcoes.add("Cadastrar fornecedor");
        opcoes.add("Excluir fornecedor via CNPJ");
        opcoes.add("Excluir fornecedor via nome");
        opcoes.add("Buscar fornecedor via cnpj");
        opcoes.add("Buscar fornecedor via nome");
        opcoes.add("Voltar");

        Menu menu = new Menu("CRUD fornecedores", opcoes);
        return menu.exibir();
    }
}
