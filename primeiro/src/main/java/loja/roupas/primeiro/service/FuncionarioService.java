package loja.roupas.primeiro.service;

import java.util.List;
import java.util.Optional;

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
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return funcionario.orElse(null);
    }

    public void deleteById(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public List<Funcionario> findByNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }
}
