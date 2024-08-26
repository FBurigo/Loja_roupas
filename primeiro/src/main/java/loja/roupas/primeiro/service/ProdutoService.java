package loja.roupas.primeiro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import loja.roupas.primeiro.entity.Produto;
import loja.roupas.primeiro.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto update(Long id, Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return produtoRepository.save(produto);
        }
        return null;
    }

    public List<Produto> findByValorLessThan(double valor) {
        return produtoRepository.findByValorLessThan(valor);
    }
    
    public List<Produto> findByNomeContaining(String nome) {
        return produtoRepository.findByNomeContaining(nome);
    }

    public List<Produto> findByValorGreaterThanEqual(Double valor) {
        return produtoRepository.findByValorGreaterThanEqual(valor);
    }
}
