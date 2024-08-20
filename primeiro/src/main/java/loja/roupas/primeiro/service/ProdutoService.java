package loja.roupas.primeiro.service;

import java.util.List;
import java.util.Optional;

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
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> findByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }
}
