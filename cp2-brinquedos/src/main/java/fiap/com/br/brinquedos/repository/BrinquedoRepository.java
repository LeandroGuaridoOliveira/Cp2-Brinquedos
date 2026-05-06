package fiap.com.br.brinquedos.repository;

import fiap.com.br.brinquedos.model.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {

    // Busca por tipo (ex: "Boneca", "Carrinho")
    List<Brinquedo> findByTipoIgnoreCase(String tipo);

    // Busca por classificação etária
    List<Brinquedo> findByClassificacao(String classificacao);
}
