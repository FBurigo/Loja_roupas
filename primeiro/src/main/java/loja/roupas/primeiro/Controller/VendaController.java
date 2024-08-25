package loja.roupas.primeiro.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import loja.roupas.primeiro.entity.Venda;
import loja.roupas.primeiro.service.VendaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/save")
    public ResponseEntity<Venda> save(@Valid @RequestBody Venda venda) {
        return new ResponseEntity<>(vendaService.save(venda), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Venda>> findAll() {
        return new ResponseEntity<>(vendaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Venda> findById(@PathVariable Long id) {
        Venda venda = vendaService.findById(id);
        if (venda != null) {
            return new ResponseEntity<>(venda, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        vendaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Venda> update(@PathVariable Long id, @Valid @RequestBody Venda venda) {
        Venda updatedVenda = vendaService.update(id, venda);
        if (updatedVenda != null) {
            return new ResponseEntity<>(updatedVenda, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByValorTotalGreaterThan/{valorTotal}")
    public ResponseEntity<List<Venda>> findByValorTotalGreaterThan(@PathVariable Double valorTotal) {
        return new ResponseEntity<>(vendaService.findByValorTotalGreaterThan(valorTotal), HttpStatus.OK);
    }

    @GetMapping("/findByEnderecoDaEntrega/{endereco}")
    public ResponseEntity<List<Venda>> findByEnderecoDaEntregaContaining(@PathVariable String endereco) {
        return new ResponseEntity<>(vendaService.findByEnderecoDaEntregaContaining(endereco), HttpStatus.OK);
    }

    @GetMapping("/findByCliente/{clienteId}")
    public ResponseEntity<List<Venda>> findByCliente(@PathVariable Long clienteId) {
        return new ResponseEntity<>(vendaService.findByCliente(clienteId), HttpStatus.OK);
    }
}
