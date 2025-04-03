package com.example;
public class Paciente implements  Comparable<Paciente> { /*tiene que tener la interfaz Comparable  */
    private String nombre; /*nombre del paciente */
    private String enfermedad; /*info extra */
    private char codigo; /*Esto es lo mas importante y va a ser de tipo caracter  */

    public Paciente(String nombre, String enfermedad, char Codigo) { /*Constructor */
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.codigo = Codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public char getCodigo() { /*importante */
        return codigo;
    }

    public String getEnfermedad() {
        return enfermedad;
    }


    @Override

    public int  compareTo(Paciente o) { /*para comparar los objetos */

        return Character.compare(this.codigo, o.codigo);
    }

    @Override
    public String toString() { /*para imprimir el objeto, el toString*/
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", enfermedad='" + enfermedad + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}