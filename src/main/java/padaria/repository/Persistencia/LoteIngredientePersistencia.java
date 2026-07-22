package padaria.repository.Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import padaria.model.LoteIngrediente;
import padaria.utilitarios.Video;

public class LoteIngredientePersistencia {

    String ARQUIVO = "lotesIngredientes.dat";

    public void salvarLotesIngredientes(List<LoteIngrediente> lista) {

        try {
            FileOutputStream fos = new FileOutputStream(ARQUIVO);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(lista);

            System.out.println("Objetos salvos em " + ARQUIVO);

            oos.close();

        } catch (Exception e) {
            Video.mensagemErro("Falha ao salvar os lotes de ingredientes!");
        }
    }

    public List<LoteIngrediente> carregarLotesIngredientes() {

        try {
            FileInputStream fis = new FileInputStream(ARQUIVO);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<LoteIngrediente> recuperados = (List<LoteIngrediente>) ois.readObject();
            System.out.println("\nObjetos recuperados do arquivo!");
            ois.close();

            return recuperados;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}