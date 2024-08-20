package loja.roupas.primeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import loja.roupas.primeiro.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
