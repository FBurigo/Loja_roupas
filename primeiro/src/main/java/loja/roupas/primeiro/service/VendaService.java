package loja.roupas.primeiro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loja.roupas.primeiro.entity.Cliente;
import loja.roupas.primeiro.entity.Venda;
import loja.roupas.primeiro.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda save(Venda venda) {
        return vendaRepository.save(venda);
    }

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Venda findById(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        vendaRepository.deleteById(id);
    }

    public Venda update(Long id, Venda venda) {
        if (vendaRepository.existsById(id)) {
            venda.setId(id);
            return vendaRepository.save(venda);
        }
        return null;
    }
    
    public List<Venda> findByFuncionarioId(Long funcionarioId) {
        return vendaRepository.findByFuncionarioId(funcionarioId);
    }

    public List<Venda> findByProdutoId(Long produtoId) {
        return vendaRepository.findByProdutoId(produtoId);
    }

    public List<Venda> findByValorTotalGreaterThan(Double valorTotal) {
        return vendaRepository.findByValorTotalGreaterThan(valorTotal);
    }

    public List<Venda> findByEnderecoDaEntregaContaining(String endereco) {
        return vendaRepository.findByEnderecoDaEntregaContaining(endereco);
    }

    public List<Venda> findByCliente(Long clienteId) {
        return vendaRepository.findByCliente(new Cliente(clienteId, null, null, null, null));
    }
}
