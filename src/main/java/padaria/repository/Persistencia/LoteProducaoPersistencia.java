package padaria.repository.Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import padaria.model.LoteProducao;
import padaria.utilitarios.Video;

public class LoteProducaoPersistencia {

    String ARQUIVO = "lotesProducao.dat";

    public void salvarLotesProducao(List<LoteProducao> lista) {

        try {
            FileOutputStream fos = new FileOutputStream(ARQUIVO);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(lista);

            System.out.println("Objetos salvos em " + ARQUIVO);

            oos.close();

        } catch (Exception e) {
            Video.mensagemErro("Falha ao salvar os lotes de produção!");
        }
    }

    public List<LoteProducao> carregarLotesProducao() {

        try {
            FileInputStream fis = new FileInputStream(ARQUIVO);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<LoteProducao> recuperados = (List<LoteProducao>) ois.readObject();
            System.out.println("\nObjetos recuperados do arquivo!");
            ois.close();

            return recuperados;
        } catch (Exception e) {
            Video.mensagemErro("Falha ao carregar os lotes de produção!");
            return new ArrayList<>();
        }
    }
}