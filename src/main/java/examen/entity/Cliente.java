package examen.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Factura> facturas;

    public Cliente(Long id, String nombre, List<Factura> facturas) {
        this.id = id;
        this.nombre = nombre;
        this.facturas = facturas;
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    @Override
    public String toString() {
        return "Cliente {" + "id: " + id + ", nombre=" + nombre+" }";
    }
}
