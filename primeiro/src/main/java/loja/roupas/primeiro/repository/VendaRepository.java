package loja.roupas.primeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import loja.roupas.primeiro.entity.Cliente;
import loja.roupas.primeiro.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	
    @Query("SELECT v FROM Venda v WHERE v.funcionario.id = :funcionarioId")
    List<Venda> findByFuncionarioId(Long funcionarioId);

    @Query("SELECT v FROM Venda v JOIN v.produtos p WHERE p.id = :produtoId")
    List<Venda> findByProdutoId(Long produtoId);

	List<Venda> findByValorTotalGreaterThan(Double valorTotal);

	List<Venda> findByEnderecoDaEntregaContaining(String endereco);

	List<Venda> findByCliente(Cliente cliente);
}
