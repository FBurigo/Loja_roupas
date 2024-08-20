package loja.roupas.primeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import loja.roupas.primeiro.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
