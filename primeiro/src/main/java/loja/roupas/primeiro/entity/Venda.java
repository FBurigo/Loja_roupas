package loja.roupas.primeiro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Não pode estar vazio")
    private String enderecoDaEntrega;
    
    @DecimalMin(value = "0.00", message = "Valor deve ser maior ou igual a 0.00")
    private Double valorTotal;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Cliente cliente;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Funcionario funcionario;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
        name = "venda_produto",
        joinColumns = @JoinColumn(name = "venda_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;
}
