package padaria.service;

import java.util.List;

import padaria.model.LoteIngrediente;
import padaria.repository.LoteIngredienteRepository;

public class LoteIngredienteService {

    private LoteIngredienteRepository loteIngredienteRepository;

    public LoteIngredienteService(LoteIngredienteRepository loteIngredienteRepository) {
        this.loteIngredienteRepository = new LoteIngredienteRepository();
    }

    public void cadastrarLoteIngrediente(LoteIngrediente loteIngrediente) {
        loteIngredienteRepository.adicionar(loteIngrediente);
    }

    public List<LoteIngrediente> listarLotesIngredientes() {
        return loteIngredienteRepository.listar();
    }

    public LoteIngrediente buscarLoteIngrediente(String nome) {
        return loteIngredienteRepository.buscar(nome);
    }

    public void excluirLoteIngrediente(String nome) {
        loteIngredienteRepository.excluir(nome);
    }
}