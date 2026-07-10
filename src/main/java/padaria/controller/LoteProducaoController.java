package padaria.controller;

import java.util.List;

import padaria.model.LoteProducao;
import padaria.service.LoteProducaoService;
import padaria.utilitarios.Teclado;
import padaria.utilitarios.Video;
import padaria.model.LoteIngrediente;
import java.util.NoSuchElementException;

public class LoteProducaoController implements ControllerInterface<LoteProducao>{

    private LoteProducaoService loteProducaoService;

    public LoteProducaoController(LoteProducaoService loteProducaoService) {
        this.loteProducaoService = loteProducaoService;
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
            Object resultado = loteProducaoService.buscarViaNome(nome);

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
        String nome = Teclado.readString("Nome do lote de produção: ");
        int id = Teclado.readInteger("ID: ");

        try {
            LoteProducao lote = LoteProducao.builder()
                    .setId(id)
                    .setNome(nome)
                    .construir();

            String nomeIngrediente = Teclado.readString("Nome do lote de ingrediente usado: ");
            int idIngrediente = Teclado.readInteger("ID do lote de ingrediente usado: ");

            LoteIngrediente loteIngrediente = LoteIngrediente.builder()
                    .setId(idIngrediente)
                    .setNome(nomeIngrediente)
                    .construir();

            loteProducaoService.adicionarIngredienteAoLote(lote, loteIngrediente);
            loteProducaoService.adicionar(lote);

            Video.mensagemOk("Lote de produção cadastrado!");

        } catch (IllegalArgumentException e) {
            Video.mensagemErro(e.getMessage());

        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }
}