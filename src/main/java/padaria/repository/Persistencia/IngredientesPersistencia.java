package padaria.repository.Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import padaria.model.Ingredientes;
import padaria.utilitarios.Video;

public class IngredientesPersistencia {
    String ARQUIVO = "ingredientes.dat";

    public void salvarIngredientes(List<Ingredientes> lista){

    try {
        FileOutputStream fos = new FileOutputStream(ARQUIVO);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lista);
        System.out.println("Objetos salvos em " + ARQUIVO);
        oos.close();
    }
        catch (Exception e) {
            Video.mensagemErro("Falha ao salvar os dados de ingredientes!");
        }
}   

    public List<Ingredientes> carregarIngredientes(){
        try {
        FileInputStream fis = new FileInputStream(ARQUIVO);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Ingredientes> recuperados = (List<Ingredientes>) ois.readObject();
        ois.close();

        return recuperados;

    }
        catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
