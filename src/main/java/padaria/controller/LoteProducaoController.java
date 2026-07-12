package padaria.controller;

import java.util.List;

import padaria.model.LoteProducao;
import padaria.repository.LoteIngredienteRepository;
import padaria.service.LoteIngredienteService;
import padaria.service.LoteProducaoService;
import padaria.utilitarios.Teclado;
import padaria.utilitarios.Video;
import padaria.model.LoteIngrediente;
import java.util.NoSuchElementException;

public class LoteProducaoController implements ControllerInterface<LoteProducao>{

    private LoteProducaoService loteProducaoService;
    LoteIngredienteRepository LIRepository = new LoteIngredienteRepository();
    LoteIngredienteService LIService = new LoteIngredienteService(LIRepository);

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
        String nome = Teclado.readString("Nome do lote de produção: ");
        
        try {
            
            LoteIngrediente loteIngrediente = LIService.buscarLoteIngrediente(Teclado.solicitarString("Digite o lote de ingrediente utilizado: "));
            LoteProducao lote = LoteProducao.builder()
                    .setNome(nome)
                    .setLoteIngrediente(loteIngrediente)
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