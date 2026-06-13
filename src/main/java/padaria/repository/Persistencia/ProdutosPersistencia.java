package padaria.repository.Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import padaria.model.Produto;
import padaria.utilitarios.Video;

public class ProdutosPersistencia {
    String ARQUIVO = "produtos.dat";

    public void salvarProdutos(List<Produto> lista){

    try {
        FileOutputStream fos = new FileOutputStream(ARQUIVO);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lista);
        System.out.println("Objetos salvos em " + ARQUIVO);
        oos.close();
    }
        catch (Exception e) {
            Video.mensagemErro("Falha ao salvar os dados de produto!");
        }
}   

    public List<Produto> carregarProdutos(){
        try {
        FileInputStream fis = new FileInputStream(ARQUIVO);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Produto> recuperados = (List<Produto>) ois.readObject();
        ois.close();

        return recuperados;

    }
        catch (Exception e) {
            Video.mensagemErro("Falha ao carregar os dados de produto!");
            return new ArrayList<>();
        }
    }

}

