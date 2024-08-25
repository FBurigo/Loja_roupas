package loja.roupas.primeiro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import loja.roupas.primeiro.entity.Funcionario;
import loja.roupas.primeiro.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario update(Long id, Funcionario funcionario) {
        if (funcionarioRepository.existsById(id)) {
            funcionario.setId(id);
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }

    public List<Funcionario> findByNomeContaining(String nome) {
        return funcionarioRepository.findByNomeContaining(nome);
    }

    public List<Funcionario> findByIdadeGreaterThanEqual(Integer idade) {
        return funcionarioRepository.findByIdadeGreaterThanEqual(idade);
    }

    public List<Funcionario> findByMatricula(String matricula) {
        return funcionarioRepository.findByMatricula(matricula);
    }
}
