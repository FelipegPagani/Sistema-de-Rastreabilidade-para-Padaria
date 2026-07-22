package padaria.config;

import padaria.controller.*;
import padaria.repository.*;
import padaria.service.*;

public class AplicacaoFactory {

    private ProdutosRepository produtosRepository;
    private IngredientesRepository ingredientesRepository;
    private FornecedoresRepository fornecedoresRepository;
    private RecebimentosRepository recebimentosRepository;
    private ClientesRepository clientesRepository;
    private LoteIngredienteRepository loteIngredienteRepository;
    private LoteProducaoRepository loteProducaoRepository;

    private ProdutoService produtoService;
    private IngredientesService ingredientesService;
    private FornecedoresService fornecedoresService;
    private RecebimentosService recebimentosService;
    private ClientesService clientesService;
    private LoteIngredienteService loteIngredienteService;
    private LoteProducaoService loteProducaoService;
    private RastrearService rastrearService;

    private ProdutoController produtoController;
    private IngredientesController ingredientesController;
    private FornecedorController fornecedorController;
    private RecebimentosController recebimentosController;
    private ClientesController clientesController;
    private LoteIngredienteController loteIngredienteController;
    private LoteProducaoController loteProducaoController;
    private RastrearController rastrearController;

    private ProdutosRepository getProdutosRepository() {
        if (produtosRepository == null)
            produtosRepository = new ProdutosRepository();
        return produtosRepository;
    }

    private IngredientesRepository getIngredientesRepository() {
        if (ingredientesRepository == null)
            ingredientesRepository = new IngredientesRepository();
        return ingredientesRepository;
    }

    private FornecedoresRepository getFornecedoresRepository() {
        if (fornecedoresRepository == null)
            fornecedoresRepository = new FornecedoresRepository();
        return fornecedoresRepository;
    }

    private RecebimentosRepository getRecebimentosRepository() {
        if (recebimentosRepository == null)
            recebimentosRepository = new RecebimentosRepository();
        return recebimentosRepository;
    }

    private ClientesRepository getClientesRepository() {
        if (clientesRepository == null)
            clientesRepository = new ClientesRepository();
        return clientesRepository;
    }

    private LoteIngredienteRepository getLoteIngredienteRepository() {
        if (loteIngredienteRepository == null)
            loteIngredienteRepository = new LoteIngredienteRepository();
        return loteIngredienteRepository;
    }

    private LoteProducaoRepository getLoteProducaoRepository() {
        if (loteProducaoRepository == null)
            loteProducaoRepository = new LoteProducaoRepository();
        return loteProducaoRepository;
    }

    public ProdutoService getProdutoService() {
        if (produtoService == null)
            produtoService = new ProdutoService(getProdutosRepository());
        return produtoService;
    }

    public IngredientesService getIngredientesService() {
        if (ingredientesService == null)
            ingredientesService = new IngredientesService(getIngredientesRepository());
        return ingredientesService;
    }

    public FornecedoresService getFornecedoresService() {
        if (fornecedoresService == null)
            fornecedoresService = new FornecedoresService(getFornecedoresRepository());
        return fornecedoresService;
    }

    public RecebimentosService getRecebimentosService() {
        if (recebimentosService == null)
            recebimentosService = new RecebimentosService(getRecebimentosRepository());
        return recebimentosService;
    }

    public ClientesService getClientesService() {
        if (clientesService == null)
            clientesService = new ClientesService(getClientesRepository());
        return clientesService;
    }

    public LoteIngredienteService getLoteIngredienteService() {
        if (loteIngredienteService == null)
            loteIngredienteService = new LoteIngredienteService(getLoteIngredienteRepository());
        return loteIngredienteService;
    }

    public LoteProducaoService getLoteProducaoService() {
        if (loteProducaoService == null)
            loteProducaoService = new LoteProducaoService(getLoteProducaoRepository());
        return loteProducaoService;
    }

    public RastrearService getRastrearService() {
        if (rastrearService == null)
            rastrearService = new RastrearService(getLoteProducaoRepository());
        return rastrearService;
    }

    public ProdutoController getProdutoController() {
        if (produtoController == null)
            produtoController = new ProdutoController(getProdutoService(), getIngredientesService());
        return produtoController;
    }

    public IngredientesController getIngredientesController() {
        if (ingredientesController == null)
            ingredientesController = new IngredientesController(
                    getIngredientesService(),
                    getLoteIngredienteService());
        return ingredientesController;
    }

    public FornecedorController getFornecedorController() {
        if (fornecedorController == null)
            fornecedorController = new FornecedorController(getFornecedoresService());
        return fornecedorController;
    }

    public RecebimentosController getRecebimentosController() {
        if (recebimentosController == null)
            recebimentosController = new RecebimentosController(
                    getRecebimentosService(),
                    getFornecedoresService(),
                    getLoteIngredienteService(),
                    getIngredientesService());
        return recebimentosController;
    }

    public ClientesController getClientesController() {
        if (clientesController == null)
            clientesController = new ClientesController(getClientesService());
        return clientesController;
    }

    public LoteIngredienteController getLoteIngredienteController() {
        if (loteIngredienteController == null)
            loteIngredienteController = new LoteIngredienteController(getLoteIngredienteService());
        return loteIngredienteController;
    }

    public LoteProducaoController getLoteProducaoController() {
        if (loteProducaoController == null)
            loteProducaoController = new LoteProducaoController(
                    getLoteProducaoService(),
                    getProdutoService(),
                    getLoteIngredienteService());
        return loteProducaoController;
    }

    public RastrearController getRastrearController() {
        if (rastrearController == null)
            rastrearController = new RastrearController(
                    getRastrearService(),
                    getLoteIngredienteService());
        return rastrearController;
    }
}