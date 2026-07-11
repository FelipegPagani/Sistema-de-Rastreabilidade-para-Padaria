package padaria.model;

import padaria.utilitarios.Video;

import java.io.Serializable;

public class LoteProducao implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private LoteIngrediente loteIngredienteUsado;

    public LoteProducao(LoteProducaoBuilder loteProducaoBuilder){
        this.nome = loteProducaoBuilder.nome;
        this.id = loteProducaoBuilder.id;
        this.loteIngredienteUsado = loteProducaoBuilder.loteIngredienteUsado;
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
        return "ID: " + id + " | Nome: " + nome +
        "\nLote de ingrediente: " + loteIngredienteUsado.getNome();
    }

    public static class LoteProducaoBuilder{

        private String nome;
        private int id;
        private LoteIngrediente loteIngredienteUsado;

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

        public LoteProducaoBuilder setLoteIngrediente(LoteIngrediente lotesIngredientes){
            if(lotesIngredientes == null){
                throw new IllegalArgumentException();
            }

            this.loteIngredienteUsado = lotesIngredientes;
            return this;
        }

        public LoteProducao construir(){
            return new LoteProducao(this);
        }
    }

}
