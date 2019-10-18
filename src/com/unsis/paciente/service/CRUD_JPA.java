package com.unsis.paciente.service;

import com.unsis.paciente.entity.Paciente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CRUD_JPA {
    private EntityManagerFactory entityMF = null;
    private EntityManager entityM = null;

    public void crearPaciente(Paciente paciente) {
        inicializarManejadorJPA();
        entityM.persist(paciente);
        entityM.getTransaction().commit();
        cerrarManejadorJPA();
    }

    public Paciente obtenerPaciente(int id) {
        inicializarManejadorJPA();
        Paciente paciente = entityM.find(Paciente.class, id);
        cerrarManejadorJPA();
        return paciente;
    }
    public void actualizarPaciente(Paciente p) {
        inicializarManejadorJPA();
        Paciente paciente = entityM.find(Paciente.class, 1);
        paciente.setNombre(p.getNombre());
        paciente.setPeso(p.getPeso());
        paciente.setSexo(p.getSexo());
        entityM.getTransaction().commit();
        cerrarManejadorJPA();
    }
    public void eliminarPaciente(int id) {
        inicializarManejadorJPA();
        Paciente paciente = entityM.find(Paciente.class, id);
        entityM.remove(paciente);
        entityM.getTransaction().commit();
        cerrarManejadorJPA();
    }
    public void inicializarManejadorJPA() {
        entityMF = Persistence.createEntityManagerFactory("proyectoJPA");
        entityM = entityMF.createEntityManager();
        entityM.getTransaction().begin();
    }
    public void cerrarManejadorJPA() {
        entityM.close();
        entityMF.close();
    }

    public static void main(String[] args) {
        CRUD_JPA crud_jpa= new CRUD_JPA();
        Paciente paciente=new Paciente();
        //crear un paciente
        //paciente= new Paciente("Juan",12,"M");
        //crud_jpa.crearPaciente(paciente);

        //obtenerPaciente
        //paciente=crud_jpa.obtenerPaciente(1);
        //System.out.println(paciente.toString());

        //actualizarPaciente
        //paciente= new Paciente("Juan",14,"M");
        //paciente.setId(1);
        //crud_jpa.actualizarPaciente(paciente);

        //eliminarPaciente
        crud_jpa.eliminarPaciente(1);

    }
}
