package rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cliente")

public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_cliente")
    private Long idCliente;

    @Column(name="ds_nome")
    private String nome;

    @Column(name="ds_telefone")
    private String telefone;

    @Column(name="ds_rg")
    private String rg;

    @Column(name="ds_cpf")
    private String cpf;

    @Column(name="ds_email")
    private String email;

}
