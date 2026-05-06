package fiap.com.br.brinquedos.service;

import fiap.com.br.brinquedos.dto.BrinquedoDto;
import fiap.com.br.brinquedos.model.Brinquedo;
import fiap.com.br.brinquedos.repository.BrinquedoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrinquedoService {

    @Autowired
    private BrinquedoRepository repository;

    // ---- CREATE ----
    public Brinquedo criar(BrinquedoDto dto) {
        Brinquedo brinquedo = converterDtoParaEntidade(dto);
        return repository.save(brinquedo);
    }

    // ---- READ - Todos ----
    public List<Brinquedo> listarTodos() {
        return repository.findAll();
    }

    // ---- READ - Por ID ----
    public Brinquedo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Brinquedo com ID " + id + " não encontrado."));
    }

    // ---- UPDATE ----
    public Brinquedo atualizar(Long id, BrinquedoDto dto) {
        Brinquedo existente = buscarPorId(id);
        existente.setNome(dto.getNome());
        existente.setTipo(dto.getTipo());
        existente.setClassificacao(dto.getClassificacao());
        existente.setTamanho(dto.getTamanho());
        existente.setPreco(dto.getPreco());
        return repository.save(existente);
    }

    // ---- DELETE ----
    public void deletar(Long id) {
        Brinquedo existente = buscarPorId(id);
        repository.delete(existente);
    }

    // ---- Conversão DTO -> Entidade ----
    private Brinquedo converterDtoParaEntidade(BrinquedoDto dto) {
        return new Brinquedo(
                dto.getNome(),
                dto.getTipo(),
                dto.getClassificacao(),
                dto.getTamanho(),
                dto.getPreco()
        );
    }
}
