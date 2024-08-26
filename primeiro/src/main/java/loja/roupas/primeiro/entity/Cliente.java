package loja.roupas.primeiro.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ'\\s]+$", message = "Nome inválido: O nome deve conter apenas letras, acentos, apóstrofos e espaços.")
    private String nome;
    
    @CPF(message = "CPF invalido")
    private String cpf;
    	
    @Min(value = 0, message = "Idade nao pode ser menor que 0")	
    private Integer idade;
    	
    
    @Pattern(regexp = "^\\(?(\\d{2})\\)?\\s?\\d{4,5}-?\\d{4}$", message = "Telefone inválido: O telefone deve seguir o formato (11) 91234-5678 ou 11912345678.")
   private String telefone;

}
