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
public class Producto extends BaseEntidad {

    private String tipo;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String receta;
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Producto")
    @Builder.Default
    private List<DetallePedido> detallesPedidos = new ArrayList<>();

    public void agregarDetallesPedidos(DetallePedido detallesPedido){
        detallesPedidos.add(detallesPedido);
    }
}