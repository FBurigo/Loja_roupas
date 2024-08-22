package loja.roupas.primeiro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ'\\s]+$", message = "Nome inválido: O nome deve conter apenas letras, acentos, apóstrofos e espaços.")
    private String nome;
    
    @Min(value = 0, message = "Idade nao pode ser menor que 0")
    private Integer idade;
    
    private String matricula;

}
