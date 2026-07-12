package padaria.model;

import java.io.Serializable;

import padaria.utilitarios.GeradorIdentificadorUnico;
import padaria.utilitarios.Video;

public class LoteIngrediente implements Serializable{

    private static final long serialVersionUID = 1L;

    private String nome;
    private int id;
    private Ingredientes ingrediente;


    public LoteIngrediente(LoteIngredienteBuilder loteIngredienteBuilder){
        this.nome = loteIngredienteBuilder.nome;
        this.id = loteIngredienteBuilder.id;
        this.ingrediente = loteIngredienteBuilder.ingrediente;
    }

    public static LoteIngredienteBuilder builder(){
        return new LoteIngredienteBuilder();
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "| Id: " + id +
        "\nIngrediente: \n" + ingrediente.toString();
        
    }

    public static class LoteIngredienteBuilder{

        private String nome;
        private int id = GeradorIdentificadorUnico.gerarIDUnicoInt();
        private Ingredientes ingrediente;

        public LoteIngredienteBuilder setNome(String nome){

            if(nome == null || nome.trim().isEmpty()){
                Video.mensagemErro("Nome inválido!");
                System.exit(0);
            }

            this.nome = nome;
            return this;
        }

        public LoteIngredienteBuilder setIngredientes(Ingredientes ingrediente){

            if(ingrediente == null){
                throw new IllegalArgumentException();
            }

            this.ingrediente = ingrediente;
            return this;
        }

        public LoteIngrediente construir(){
            return new LoteIngrediente(this);
        }
    }

}
