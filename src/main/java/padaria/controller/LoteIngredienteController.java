package padaria.controller;

import java.util.List;

import padaria.model.Ingredientes;
import padaria.model.LoteIngrediente;
import padaria.repository.IngredientesRepository;
import padaria.service.IngredientesService;
import padaria.service.LoteIngredienteService;
import padaria.utilitarios.Teclado;
import padaria.utilitarios.Video;
import java.util.NoSuchElementException;

public class LoteIngredienteController implements ControllerInterface<LoteIngrediente>{

    private LoteIngredienteService loteIngredienteService;
    IngredientesRepository IR = new IngredientesRepository();
    IngredientesService IS = new IngredientesService(IR);

    public LoteIngredienteController(LoteIngredienteService loteIngredienteService) {
        this.loteIngredienteService = loteIngredienteService;
    }

    @Override
    public void cadastrar() {
        String nome = Teclado.readString("Nome do lote: ");
        
        try {
            Ingredientes ingrediente = IS.buscarViaNome(Teclado.solicitarString("Digite o nome do ingrediente do lote: "));
            LoteIngrediente loteIngrediente = LoteIngrediente.builder()
                .setNome(nome)
                .setIngredientes(ingrediente)
                .construir();
                
            loteIngredienteService.adicionarLote(loteIngrediente);
            Video.mensagemOk("Lote cadastrado!");

        } catch (IllegalArgumentException e) {
            Video.mensagemErro(e.getMessage());

        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void listar() {

        try {
            List<LoteIngrediente> lotes = loteIngredienteService.listarLotesIngredientes();

            for (LoteIngrediente lote : lotes) {
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
        String nome = Teclado.readString("Nome do lote para excluir: ");

        try {
            loteIngredienteService.excluirLoteIngrediente(nome);
            Video.mensagemOk("Lote excluído!");

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
        String nome = Teclado.readString("Nome do lote para buscar: ");

        try {
            Object resultado = loteIngredienteService.buscarLoteIngrediente(nome);

            Video.println(resultado.toString());

        } catch (IllegalStateException e) {
            Video.mensagemErro(e.getMessage());

        } catch (NoSuchElementException e) {
            Video.mensagemErro(e.getMessage());

        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }
}
