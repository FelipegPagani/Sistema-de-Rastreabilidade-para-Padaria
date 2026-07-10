package padaria.controller;

import java.util.List;

import padaria.model.LoteIngrediente;
import padaria.model.LoteProducao;
import padaria.service.LoteIngredienteService;
import padaria.service.RastrearService;
import padaria.utilitarios.Teclado;
import padaria.utilitarios.Video;

public class RastrearController{

    private RastrearService rastrearService;
    private LoteIngredienteService loteIngredienteService;

    public RastrearController(RastrearService rastrearService, LoteIngredienteService loteIngredienteService) {
        this.rastrearService = rastrearService;
        this.loteIngredienteService = loteIngredienteService;
    }

    public void rastrearPorLoteIngrediente() {
        Video.mensagemInfo("Rastreamento por lote de ingrediente: ");

        String nome = Teclado.readString("Informe o nome do lote de ingrediente: ");

        try {
            List<LoteProducao> lotesProducao = rastrearService.buscarProducoesPorLoteIngrediente(nome);

            if (lotesProducao == null || lotesProducao.isEmpty()) {
                Video.mensagemErro("Nao foi encontrado nenhum lote de produção com este ingrediente!");
                return;
            }

            Video.mensagemInfo("Os lotes de produção encontrados foram: ");

            for (LoteProducao loteProducao : lotesProducao) {
                Video.print(loteProducao.toString());
            }

        } catch (Exception e) {
            Video.mensagemErro("Erro!, Lote de Ingredientes nao encontrado.");
        }
    }

    public void listarLotesIngredientes() {

        try {

            Video.mensagemInfo("Lista dos Lotes de Ingrediente:");

            List<LoteIngrediente> lotes = loteIngredienteService.listarLotesIngredientes();

            if (lotes == null || lotes.isEmpty()) {
                Video.mensagemErro("Nenhum lote encontrado!");
                return;
            }

            for (LoteIngrediente lote : lotes) {
                Video.print(lote.toString());
            }

        } catch (Exception e) {
            Video.mensagemErro("Erro ao listar lotes!");
        }
    }
}
