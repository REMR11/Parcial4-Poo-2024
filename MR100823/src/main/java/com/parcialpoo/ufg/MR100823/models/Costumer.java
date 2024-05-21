package com.parcialpoo.ufg.MR100823.models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Clase que representa un cliente.
 */
@Entity
@Table(name = "COSTUMER")
public class Costumer {

    /**
     * Identificador único del cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costumer_Id;

    /**
     * Nombre del cliente.
     */
    private String name;

    /**
     * Email del cliente.
     */
    private String email;

    /**
     * Contraseña del cliente.
     */
    private String password;

    /**
     * Número de teléfono del cliente.
     */
    @Column(length = 11)
    private Integer phone;

    /**
     * Lista de reservaciones del cliente.
     */
    @OneToMany(mappedBy = "costumer")
    private List<Reservation> reservaciones;

    @OneToOne(cascade = CascadeType.ALL)
    private Order order;
    /**
     * Constructor por defecto.
     */
    public Costumer() {}

    /**
     * Constructor con todos los atributos.
     *
     * @param costumer_Id Identificador único del cliente.
     * @param name Nombre del cliente.
     * @param email Email del cliente.
     * @param password Contraseña del cliente.
     * @param phone Número de teléfono del cliente.
     * @param reservaciones Lista de reservaciones del cliente.
     */
    public Costumer(Integer costumer_Id, String name, String email, String password, Integer phone, List<Reservation> reservaciones) {
        this.costumer_Id = costumer_Id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.reservaciones = reservaciones;
    }

    // Getters and setters

    public Integer getCostumer_Id() {
        return costumer_Id;
    }

    public void setCostumer_Id(Integer costumer_Id) {
        this.costumer_Id = costumer_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public List<Reservation> getReservaciones() {
        return reservaciones;
    }

    public void setReservaciones(List<Reservation> reservaciones) {
        this.reservaciones = reservaciones;
    }

    @Override
    public int hashCode() {
        return Objects.hash(costumer_Id, email, name, password, phone, reservaciones);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Costumer other = (Costumer) obj;
        return Objects.equals(costumer_Id, other.costumer_Id) && Objects.equals(email, other.email)
                && Objects.equals(name, other.name) && Objects.equals(password, other.password)
                && Objects.equals(phone, other.phone) && Objects.equals(reservaciones, other.reservaciones);
    }

    @Override
    public String toString() {
        return "Costumer [costumer_Id=" + costumer_Id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone + ", reservaciones=" + reservaciones + "]";
    }

}