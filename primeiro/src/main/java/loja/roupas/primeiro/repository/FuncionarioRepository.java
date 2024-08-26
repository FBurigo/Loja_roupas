package loja.roupas.primeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import loja.roupas.primeiro.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
    @Query("SELECT f FROM Funcionario f WHERE f.nome LIKE %:nome%")
    List<Funcionario> findByNomeContaining(String nome);

    @Query("SELECT f FROM Funcionario f WHERE f.matricula = :matricula AND f.idade = :idade")
    Funcionario findByMatriculaAndIdade(String matricula, int idade);

	List<Funcionario> findByIdadeGreaterThanEqual(Integer idade);

	List<Funcionario> findByMatricula(String matricula);
}
	