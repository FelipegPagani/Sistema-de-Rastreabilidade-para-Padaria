package padaria.model;

import padaria.utilitarios.Video;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoteProducao implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private List<LoteIngrediente> lotesIngredientes;

    public LoteProducao(LoteProducaoBuilder loteProducaoBuilder){
        this.nome = loteProducaoBuilder.nome;
        this.id = loteProducaoBuilder.id;
        this.lotesIngredientes = new ArrayList<LoteIngrediente>();
    }

    public static LoteProducaoBuilder builder(){
        return new LoteProducaoBuilder();
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome;
    }

    public void adicionarLoteIngrediente(LoteIngrediente loteIngrediente) {
    if (loteIngrediente != null) {
        lotesIngredientes.add(loteIngrediente);
    }
    }

    public List<LoteIngrediente> getLotesIngredientes() {
        return lotesIngredientes;
    }

    public boolean possuiLoteIngrediente(String nome) {
        for (LoteIngrediente loteIngrediente : lotesIngredientes) {
            if (loteIngrediente.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
    }
        return false;
    }

    public static class LoteProducaoBuilder{

        private String nome;
        private int id;

        public LoteProducaoBuilder setNome(String nome){

            if(nome == null || nome.trim().isEmpty()){
                Video.mensagemErro("Nome inválido!");
                System.exit(0);
            }

            this.nome = nome;
            return this;
        }

        public LoteProducaoBuilder setId(int id){

            if(id < 0){
                Video.mensagemErro("Id inválido!");
                System.exit(0);
            }

            this.id = id;
            return this;
        }

        public LoteProducao construir(){
            return new LoteProducao(this);
        }
    }

}
