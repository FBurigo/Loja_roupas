package loja.roupas.primeiro.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import loja.roupas.primeiro.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String nome);
}
