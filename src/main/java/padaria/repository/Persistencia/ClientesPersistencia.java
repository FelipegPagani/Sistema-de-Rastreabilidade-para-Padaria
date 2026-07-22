package padaria.repository.Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import padaria.model.Clientes;
import padaria.utilitarios.Video;

public class ClientesPersistencia {

    String ARQUIVO = "clientes.dat";

    public void salvarClientes(List<Clientes> lista) {

        try {
            FileOutputStream fos = new FileOutputStream(ARQUIVO);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(lista);

            System.out.println("Objetos salvos em " + ARQUIVO);

            oos.close();

        } catch (Exception e) {
            Video.mensagemErro("Falha ao salvar os dados dos clientes!");
        }
    }

    public List<Clientes> carregarClientes() {

        try {
            FileInputStream fis = new FileInputStream(ARQUIVO);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<Clientes> recuperados = (List<Clientes>) ois.readObject();
            System.out.println("\nObjetos recuperados do arquivo!");
            ois.close();

            return recuperados;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}