package com.utn.TP1_Persistencia.entidades;

import com.utn.TP1_Persistencia.enumeraciones.FormaDePago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad {

    private int numero;
    private LocalDate fecha;
    private double descuento;
    private FormaDePago formaPago;
    private int total;
}
