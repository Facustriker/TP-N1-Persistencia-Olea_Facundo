package com.utn.TP1_Persistencia.entidades;

import com.utn.TP1_Persistencia.enumeraciones.Estado;
import com.utn.TP1_Persistencia.enumeraciones.TipoDeEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad {

    private Estado estado;
    private Date fecha;
    private TipoDeEnvio tipoEnvio;
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
