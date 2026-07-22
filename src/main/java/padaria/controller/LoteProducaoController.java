package padaria.controller;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import padaria.model.Ingredientes;
import padaria.model.LoteIngrediente;
import padaria.model.LoteProducao;
import padaria.model.Produto;
import padaria.service.LoteProducaoService;
import padaria.service.ProdutoService;
import padaria.service.LoteIngredienteService;
import padaria.utilitarios.Teclado;
import padaria.utilitarios.Video;
import java.util.NoSuchElementException;

public class LoteProducaoController implements ControllerInterface<LoteProducao>{

    private LoteIngredienteService loteIngredienteService;
    private LoteProducaoService loteProducaoService;
    private ProdutoService produtoService;

    public LoteProducaoController(LoteProducaoService loteProducaoService, ProdutoService produtoService, LoteIngredienteService loteIngredientesService) {
        this.loteProducaoService = loteProducaoService;
        this.produtoService = produtoService;
        this.loteIngredienteService = loteIngredientesService;
    }

    @Override
    public void listar() {

        try {
            List<LoteProducao> lotes = loteProducaoService.listar();

            for (LoteProducao lote : lotes) {
                Video.println(lote.toString());
            }

        } catch (IllegalStateException e) {
            Video.mensagemErro(e.getMessage());

        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void excluir() {
        String nome = Teclado.readString("Nome do lote de produção para excluir: ");

        try {
            loteProducaoService.excluir(nome);
            Video.mensagemOk("Lote de produção excluído!");

        } catch (IllegalStateException e) {
            Video.mensagemErro(e.getMessage());

        } catch (NoSuchElementException e) {
            Video.mensagemErro(e.getMessage());

        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void buscar() {
        String nome = Teclado.readString("Nome do lote de produção para buscar: ");

        try {
            LoteProducao resultado = loteProducaoService.buscarViaNome(nome);

            Video.println(resultado.toString());

        } catch (IllegalStateException e) {
            Video.mensagemErro(e.getMessage());

        } catch (NoSuchElementException e) {
            Video.mensagemErro(e.getMessage());

        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void cadastrar() {
        Produto produto;

        String nomeLote = Teclado.readString("Nome do lote de produção: ");
        
        try {
            produto = produtoService.buscarViaNome(Teclado.readString("Informe o nome do produto produzido: "));
        } catch (EmptyStackException e) {
            return;
        }

        List<LoteIngrediente> lotesUsados = new ArrayList<>();

        for(Ingredientes ingrediente : produto.getIngredientes()) {

            Video.mensagemInfo(
                "Escolha o lote de: " + ingrediente.getNome()
            );

            List<LoteIngrediente> lotes = loteIngredienteService.buscarPorIngrediente(ingrediente.getNome());

            for(LoteIngrediente lote : lotes){
                 Video.print(lote.toString());
            }

            String loteEscolhido =
                    Teclado.readString("Informe o lote usado: ");

            LoteIngrediente loteIngrediente = loteIngredienteService.buscarLoteIngrediente(loteEscolhido);

            lotesUsados.add(loteIngrediente);
        }
        
        try {
            LoteProducao lote = LoteProducao.builder()
                    .setNome(nomeLote)
                    .setProduto(produto)
                    .setLotesIngredientesUsados(lotesUsados)
                    .construir();

            loteProducaoService.adicionar(lote);
            Video.mensagemOk("Lote de produção cadastrado!");

            } catch (IllegalArgumentException e) {
                Video.mensagemErro(e.getMessage());

            } catch (Exception e) {
                e.printStackTrace();
                Video.mensagemErro("Erro não previsto!");
            }
        }
}