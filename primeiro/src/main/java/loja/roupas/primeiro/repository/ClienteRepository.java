package loja.roupas.primeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import loja.roupas.primeiro.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
    @Query("SELECT c FROM Cliente c WHERE c.idade BETWEEN :idadeMin AND :idadeMax")
    List<Cliente> findByIdadeBetween(int idadeMin, int idadeMax);

	List<Cliente> findByNomeContaining(String nome);

	List<Cliente> findByCpf(String cpf);

	List<Cliente> findByIdadeGreaterThanEqual(Integer idade);
}
