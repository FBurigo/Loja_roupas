package loja.roupas.primeiro.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import loja.roupas.primeiro.entity.Produto;
import loja.roupas.primeiro.service.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/save")
    public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Produto>> findAll() {
        return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        if (produto != null) {
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        produtoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        Produto updatedProduto = produtoService.update(id, produto);
        if (updatedProduto != null) {
            return new ResponseEntity<>(updatedProduto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    @GetMapping("/findByValorLessThan/{valor}")
    public ResponseEntity<List<Produto>> findByValorLessThan(@PathVariable double valor) {
        return new ResponseEntity<>(produtoService.findByValorLessThan(valor), HttpStatus.OK);
    }

    @GetMapping("/findByNome/{nome}")
    public ResponseEntity<List<Produto>> findByNomeContaining(@PathVariable String nome) {
        return new ResponseEntity<>(produtoService.findByNomeContaining(nome), HttpStatus.OK);
    }

    @GetMapping("/findByValorGreaterThan/{valor}")
    public ResponseEntity<List<Produto>> findByValorGreaterThanEqual(@PathVariable Double valor) {
        return new ResponseEntity<>(produtoService.findByValorGreaterThanEqual(valor), HttpStatus.OK);
    }
}
