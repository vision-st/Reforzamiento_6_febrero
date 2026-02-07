package com.duoc.refor.ejemplo03;

public class Paciente implements Comparable<Paciente> {

    private String nombre;
    private int nivelPriodidad;

    public Paciente(String nombre, int nivelPriodidad) {
        this.nombre = nombre;
        this.nivelPriodidad = nivelPriodidad;
    }

    @Override
    public int compareTo(Paciente otro){
        return Integer.compare(this.nivelPriodidad, otro.nivelPriodidad);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", nivelPriodidad=" + nivelPriodidad +
                '}';
    }
}
