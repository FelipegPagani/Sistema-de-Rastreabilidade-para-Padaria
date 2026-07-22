package padaria.model;

import padaria.utilitarios.GeradorIdentificadorUnico;
import padaria.utilitarios.Video;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import java.io.Serializable;

public class LoteProducao implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private Produto produto;
    private List<LoteIngrediente> lotesIngredientesUsados;

    public LoteProducao(LoteProducaoBuilder loteProducaoBuilder){
        this.nome = loteProducaoBuilder.nome;
        this.id = loteProducaoBuilder.id;
        this.produto = loteProducaoBuilder.produto;
        this.lotesIngredientesUsados = loteProducaoBuilder.lotesIngredientesUsados;
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

    public List<LoteIngrediente> getLotesIngredientesUsados() {
    return lotesIngredientesUsados;
    }

    public boolean possuiLoteIngrediente(String nomeLoteIngrediente){

    for(LoteIngrediente lote : lotesIngredientesUsados){

        if(lote.getNome().equalsIgnoreCase(nomeLoteIngrediente)){
            return true;
        }
    }

    return false;
}


    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome +
        "\nProduto produzido: " + produto.toString();
    }

    public static class LoteProducaoBuilder{

        private String nome;
        private int id = GeradorIdentificadorUnico.gerarIDUnicoInt();
        private List<LoteIngrediente> lotesIngredientesUsados;
        private Produto produto;

        public LoteProducaoBuilder setNome(String nome){

            if(nome == null || nome.trim().isEmpty()){
                Video.mensagemErro("Nome inválido!");
                System.exit(0);
            }

            this.nome = nome;
            return this;
        }

        public LoteProducaoBuilder setProduto(Produto produto){
            if(produto == null){
                throw new IllegalArgumentException();
            }

            this.produto = produto;
            return this;
        }

        public LoteProducaoBuilder setLotesIngredientesUsados(List<LoteIngrediente> lotes) {
            if(lotes.isEmpty()){
                throw new EmptyStackException();
            }
            this.lotesIngredientesUsados = lotes;
            return this;
        }

        public LoteProducao construir(){
            return new LoteProducao(this);
        }
    }

}
