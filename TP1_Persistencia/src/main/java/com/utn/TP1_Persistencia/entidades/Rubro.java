package com.utn.TP1_Persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rubro extends BaseEntidad {

    private String denominacion;
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro_ID")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public void agregarProductos(Producto produ){
        productos.add(produ);
    }
}

