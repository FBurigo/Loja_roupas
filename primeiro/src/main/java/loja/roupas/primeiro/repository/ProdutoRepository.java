package loja.roupas.primeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import loja.roupas.primeiro.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
    @Query("SELECT p FROM Produto p WHERE p.valor < :valor")
    List<Produto> findByValorLessThan(double valor);

	List<Produto> findByNomeContaining(String nome);

	List<Produto> findByValorGreaterThanEqual(Double valor);
}
