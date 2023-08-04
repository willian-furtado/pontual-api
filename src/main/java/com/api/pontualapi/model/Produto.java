package com.api.pontualapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor(force = true)
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String codigo;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false)
    private String modelo;

    @Column(length = 255)
    private String descricao;

    @Column(length = 150, nullable = false)
    private BigDecimal valor;

}
