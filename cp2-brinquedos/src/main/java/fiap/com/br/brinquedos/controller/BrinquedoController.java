package fiap.com.br.brinquedos.controller;

import fiap.com.br.brinquedos.dto.BrinquedoDto;
import fiap.com.br.brinquedos.model.Brinquedo;
import fiap.com.br.brinquedos.service.BrinquedoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService service;

    // ============================================
    // POST /brinquedos  →  Criar novo brinquedo
    // ============================================
    @PostMapping
    public ResponseEntity<Brinquedo> criar(@Valid @RequestBody BrinquedoDto dto) {
        Brinquedo criado = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    // ============================================
    // GET /brinquedos  →  Listar todos
    // ============================================
    @GetMapping
    public ResponseEntity<List<Brinquedo>> listarTodos() {
        List<Brinquedo> lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    // ============================================
    // GET /brinquedos/{id}  →  Buscar por ID
    // ============================================
    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> buscarPorId(@PathVariable Long id) {
        Brinquedo brinquedo = service.buscarPorId(id);
        return ResponseEntity.ok(brinquedo);
    }

    // ============================================
    // PUT /brinquedos/{id}  →  Atualizar
    // ============================================
    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody BrinquedoDto dto) {
        Brinquedo atualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    // ============================================
    // DELETE /brinquedos/{id}  →  Excluir por ID
    // ============================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
