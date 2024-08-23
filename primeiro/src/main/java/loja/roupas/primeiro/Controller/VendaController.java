package loja.roupas.primeiro.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import loja.roupas.primeiro.entity.Venda;
import loja.roupas.primeiro.service.VendaService;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/save")
    public ResponseEntity<Venda> save(@RequestBody Venda venda) {
        try {
            Venda savedVenda = vendaService.save(venda);
            return new ResponseEntity<>(savedVenda, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Venda>> findAll() {
        List<Venda> vendas = vendaService.findAll();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
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
}
