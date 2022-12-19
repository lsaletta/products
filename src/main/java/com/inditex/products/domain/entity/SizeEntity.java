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
@Table(name = "SIZES")
public class SizeEntity {

    @Id
    @NotNull
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PRODUCTID")
    private Integer productId;

    @Column(name = "BACKSOON")
    private Boolean backSoon;

    @Column(name = "SPECIAL")
    private Boolean special;

}
