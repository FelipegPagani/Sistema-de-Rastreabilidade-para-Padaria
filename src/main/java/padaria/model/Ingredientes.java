package padaria.model;

import java.io.Serializable;

import padaria.utilitarios.GeradorIdentificadorUnico;

public class Ingredientes implements Serializable{
    private String nome;
    private int id;
    private String loteIngrediente;

    private static final long serialVersionUID = 1L;
    
    public Ingredientes(IngredientesBuilder ingredientesBuilder){
        this.nome = ingredientesBuilder.nome;
        this.id = ingredientesBuilder.id;
        this.loteIngrediente = ingredientesBuilder.loteIngrediente;
    }

    public static IngredientesBuilder builder(){
        return new IngredientesBuilder();
    }

    public String getNome() {
        return nome;
    }
    
    public int getId() {
        return id;
    }

    public String getlote(){
        return loteIngrediente;
    }

    @Override
    public String toString(){
        return "Nome do ingrediente: " + nome + "| Id: "+ id + "\n";
    }

    public static class IngredientesBuilder{
        private String nome;
        private int id = GeradorIdentificadorUnico.gerarIDUnicoInt();
        private String loteIngrediente;
        
        public IngredientesBuilder setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        if(!nome.matches("[a-zA-ZÀ-ú\\s]+")){//valida que a string contenha apenas letras e espaços, sem números ou caracteres especiais
            throw new NumberFormatException();
        }
        this.nome = nome;
        return this;
        }

        public IngredientesBuilder setLote(String loteIngrediente){
            if(loteIngrediente == null){
                throw new IllegalArgumentException();
            }
            this.loteIngrediente = loteIngrediente;
            return this;
        }

        public Ingredientes construir(){
            return new Ingredientes(this);
        }

    }
}

