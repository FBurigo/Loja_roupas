package loja.roupas.primeiro.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import loja.roupas.primeiro.entity.Funcionario;
import loja.roupas.primeiro.service.FuncionarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/save")
    public ResponseEntity<Funcionario> save(@Valid @RequestBody Funcionario funcionario) {
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

    @PutMapping("/update/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        Funcionario updatedFuncionario = funcionarioService.update(id, funcionario);
        if (updatedFuncionario != null) {
            return new ResponseEntity<>(updatedFuncionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByNome/{nome}")
    public ResponseEntity<List<Funcionario>> findByNomeContaining(@PathVariable String nome) {
        return new ResponseEntity<>(funcionarioService.findByNomeContaining(nome), HttpStatus.OK);
    }

    @GetMapping("/findByIdadeGreaterThan/{idade}")
    public ResponseEntity<List<Funcionario>> findByIdadeGreaterThanEqual(@PathVariable Integer idade) {
        return new ResponseEntity<>(funcionarioService.findByIdadeGreaterThanEqual(idade), HttpStatus.OK);
    }

    @GetMapping("/findByMatricula/{matricula}")
    public ResponseEntity<List<Funcionario>> findByMatricula(@PathVariable String matricula) {
        return new ResponseEntity<>(funcionarioService.findByMatricula(matricula), HttpStatus.OK);
    }
}
