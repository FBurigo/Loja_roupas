package loja.roupas.primeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import loja.roupas.primeiro.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
