package com.inditex.products.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STOCKS")
public class StockEntity {

    @Id
    @NotNull
    @Column(name = "SIZEID")
    private Integer id;

    @Column(name = "QUANTITY")
    private Integer quantity;

}
