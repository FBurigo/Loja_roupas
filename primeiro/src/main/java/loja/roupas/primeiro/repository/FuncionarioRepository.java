package loja.roupas.primeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import loja.roupas.primeiro.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	List<Funcionario> findByNomeContaining(String nome);

	List<Funcionario> findByIdadeGreaterThanEqual(Integer idade);

	List<Funcionario> findByMatricula(String matricula);
}
