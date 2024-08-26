package loja.roupas.primeiro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import loja.roupas.primeiro.entity.Cliente;
import loja.roupas.primeiro.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente update(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public List<Cliente> findByIdadeBetween(int idadeMin, int idadeMax) {
        return clienteRepository.findByIdadeBetween(idadeMin, idadeMax);
    }
    
    public List<Cliente> findByNomeContaining(String nome) {
        return clienteRepository.findByNomeContaining(nome);
    }

    public List<Cliente> findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> findByIdadeGreaterThanEqual(Integer idade) {
        return clienteRepository.findByIdadeGreaterThanEqual(idade);
    }
}
