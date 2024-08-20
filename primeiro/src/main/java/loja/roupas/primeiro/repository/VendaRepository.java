package loja.roupas.primeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import loja.roupas.primeiro.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
