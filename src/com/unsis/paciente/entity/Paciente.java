package com.unsis.paciente.entity;

import javax.persistence.*;

@Entity
@Table (name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nombre",length = 50, nullable = false)
    private String nombre;

    @Column(name = "peso", nullable = true)
    private double peso;

    @Column(name = "sexo", nullable = true)
    private String sexo;

    public Paciente() {
    }

    public Paciente(String nombre, double peso, String sexo) {
        this.nombre = nombre;
        this.peso = peso;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
