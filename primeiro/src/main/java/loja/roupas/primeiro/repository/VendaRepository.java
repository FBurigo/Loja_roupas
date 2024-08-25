package loja.roupas.primeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import loja.roupas.primeiro.entity.Cliente;
import loja.roupas.primeiro.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

	List<Venda> findByValorTotalGreaterThan(Double valorTotal);

	List<Venda> findByEnderecoDaEntregaContaining(String endereco);

	List<Venda> findByCliente(Cliente cliente);
}
