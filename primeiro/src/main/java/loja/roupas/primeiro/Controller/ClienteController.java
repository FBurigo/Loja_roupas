package loja.roupas.primeiro.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import loja.roupas.primeiro.entity.Cliente;
import loja.roupas.primeiro.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Cliente>> findAll() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        clienteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.update(id, cliente);
        if (updatedCliente != null) {
            return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/findByIdadeBetween/{idadeMin}/{idadeMax}")
    public ResponseEntity<List<Cliente>> findByIdadeBetween(
            @PathVariable int idadeMin, @PathVariable int idadeMax) {
        return new ResponseEntity<>(clienteService.findByIdadeBetween(idadeMin, idadeMax), HttpStatus.OK);
    }
    @GetMapping("/findByNome/{nome}")
    public ResponseEntity<List<Cliente>> findByNomeContaining(@PathVariable String nome) {
        return new ResponseEntity<>(clienteService.findByNomeContaining(nome), HttpStatus.OK);
    }

    @GetMapping("/findByCpf/{cpf}")
    public ResponseEntity<List<Cliente>> findByCpf(@PathVariable String cpf) {
        return new ResponseEntity<>(clienteService.findByCpf(cpf), HttpStatus.OK);
    }

    @GetMapping("/findByIdadeGreaterThan/{idade}")
    public ResponseEntity<List<Cliente>> findByIdadeGreaterThanEqual(@PathVariable Integer idade) {
        return new ResponseEntity<>(clienteService.findByIdadeGreaterThanEqual(idade), HttpStatus.OK);
    }
}
