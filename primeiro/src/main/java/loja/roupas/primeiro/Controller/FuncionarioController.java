package loja.roupas.primeiro.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import loja.roupas.primeiro.entity.Funcionario;
import loja.roupas.primeiro.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/save")
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario funcionario) {
        return new ResponseEntity<>(funcionarioService.save(funcionario), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Funcionario>> findAll() {
        return new ResponseEntity<>(funcionarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.findById(id);
        if (funcionario != null) {
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        funcionarioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
