package padaria.model;

import java.io.Serializable;
import java.util.ArrayList;

import padaria.utilitarios.Video;

public class LoteIngrediente implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private ArrayList<Ingredientes> Ingredientes;

    public LoteIngrediente(LoteIngredienteBuilder loteIngredienteBuilder){
        this.nome = loteIngredienteBuilder.nome;
        this.id = loteIngredienteBuilder.id;
    }

    public static LoteIngredienteBuilder builder(){
        return new LoteIngredienteBuilder();
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

    public static class LoteIngredienteBuilder{

        private String nome;
        private int id;

        public LoteIngredienteBuilder setNome(String nome){

            if(nome == null || nome.trim().isEmpty()){
                Video.mensagemErro("Nome inválido!");
                System.exit(0);
            }

            this.nome = nome;
            return this;
        }

        public LoteIngredienteBuilder setId(int id){

            if(id < 0){
                Video.mensagemErro("Id inválido!");
                System.exit(0);
            }

            this.id = id;
            return this;
        }

        public LoteIngrediente construir(){
            return new LoteIngrediente(this);
        }
    }

}
