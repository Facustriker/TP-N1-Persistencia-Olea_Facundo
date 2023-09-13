package com.utn.TP1_Persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad {

    private String estado;
    private LocalDate fecha;
    private String tipoEnvio;
    private double total;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Pedido")
    @Builder.Default
    private List<DetallePedido> detallesPedidos = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    private Factura factura;

    public void agregarDetallesPedidos(DetallePedido detallesPedido){
        detallesPedidos.add(detallesPedido);
    }

    public void mostrarDetallesPedidos(){
        for (DetallePedido detalles: detallesPedidos){
            System.out.println("La cantidad es: " + detalles.getCantidad()
                            + " y el subtotal es: " + detalles.getSubtotal());
        }
    }
}
