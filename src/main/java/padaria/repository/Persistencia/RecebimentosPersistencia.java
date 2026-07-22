package padaria.repository.Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import padaria.model.Recebimentos;
import padaria.utilitarios.Video;

public class RecebimentosPersistencia {
    String ARQUIVO = "recebimentos.dat";

    public void salvarRecebimentos(List<Recebimentos> lista){

    try {
        FileOutputStream fos = new FileOutputStream(ARQUIVO);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lista);
        System.out.println("Objetos salvos em " + ARQUIVO);
        oos.close();
    }
        catch (Exception e) {
            Video.mensagemErro("Falha ao salvar os dados de recebimentos!");
        }
}   

    public List<Recebimentos> carregarRecebimentos(){
        try {
        FileInputStream fis = new FileInputStream(ARQUIVO);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Recebimentos> recuperados = (List<Recebimentos>) ois.readObject();
        ois.close();

        return recuperados;

    }
        catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
