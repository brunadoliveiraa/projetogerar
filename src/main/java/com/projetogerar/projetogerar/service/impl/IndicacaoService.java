package com.projetogerar.projetogerar.service.impl;
import com.projetogerar.projetogerar.model.Indicacao;
import com.projetogerar.projetogerar.repository.IndicacaoRepository;
import com.projetogerar.projetogerar.service.IndicacaoServiceInterface;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IndicacaoService implements IndicacaoServiceInterface {

    private final IndicacaoRepository repository;

    public IndicacaoService(IndicacaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Indicacao> listar() {
        return repository.findAll();
    }

    public Optional<Indicacao> buscarPorId(int id) {
        return repository.findById(id);
    }

    @Override
    public Indicacao salvar(Indicacao indicacao) {
        return repository.save(indicacao);
    }

    @Override
    public Indicacao atualizar(int id, Indicacao indicacao) {
        return repository.findById(id)
                .map(indicacaoExistente -> {
                    indicacaoExistente.setEndereco(indicacao.getEndereco());
                    indicacaoExistente.setDescricao(indicacao.getDescricao());
                    indicacaoExistente.setTelefone(indicacao.getTelefone());

                    return repository.save(indicacaoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Indicacao com id " + id +" não encontrada."));
    }

    @Override
    public Indicacao adicionarNota(int id, int nota) {
        return repository.findById(id)
                .map(indicacaoExistente -> {
                    indicacaoExistente.setNumNotas(indicacaoExistente.getNumNotas()+1);
                    indicacaoExistente.setSumNotas(indicacaoExistente.getSumNotas()+ nota);

                    return repository.save(indicacaoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Indicacao com id " + id +" não encontrada."));
    }

    @Override
    public Indicacao atualizarNota(int id, int notaAntiga, int notaNova) {
        return repository.findById(id)
                .map(indicacaoExistente -> {
                    indicacaoExistente.setSumNotas(
                            indicacaoExistente.getSumNotas()
                            + notaNova - notaAntiga);

                    return repository.save(indicacaoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Indicacao com id " + id +" não encontrada."));
    }

    @Override
    public void deletar(int id) {
        repository.deleteById(id);
    }
}
