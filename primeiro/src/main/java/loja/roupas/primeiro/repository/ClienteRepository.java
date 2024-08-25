package loja.roupas.primeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import loja.roupas.primeiro.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNomeContaining(String nome);

	List<Cliente> findByCpf(String cpf);

	List<Cliente> findByIdadeGreaterThanEqual(Integer idade);
}
