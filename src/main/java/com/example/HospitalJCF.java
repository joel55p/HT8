package com.example;

/*Clase igual de importnate que basicmaente usa como tal el JCF */
/*CLase que forma parte de la otra version en donde se usa el JCF para la cola de prioridad */

import java.io.*;
import java.util.PriorityQueue; /*diferencia entre Hospital normal */

public class HospitalJCF {
    private PriorityQueue<Paciente> colaPacientes;
    private final String archivoPacientes = "demo\\src\\main\\java\\com\\example\\pacientes.txt";

    public HospitalJCF() {
        this.colaPacientes = new PriorityQueue<>();/* Usamos la cola de prioridad de Java */
    }

    public String cargarPacientesDesdeArchivo() {/*se va especifica que cada item del paciente esta separado por , */
        StringBuilder resultado = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoPacientes))) {/*Misma logica que Hospital.java */
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String nombre = datos[0].trim();
                    String enfermedad = datos[1].trim();
                    char codigo = datos[2].trim().charAt(0);
                    colaPacientes.add(new Paciente(nombre, enfermedad, codigo));
                    resultado.append("Paciente cargado: ").append(nombre).append("\n");
                }
            }
        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }
        return resultado.toString();/*se devuelve el resultado de la carga de pacientes */
    }

    public String agregarPaciente(Paciente paciente) {/*se agrega a la cola */
        colaPacientes.add(paciente);
        guardarPacienteEnArchivo(paciente);
        return "Paciente agregado: " + paciente.getNombre();
    }

    private void guardarPacienteEnArchivo(Paciente paciente) {/*se guarda en el archivo */
        try (FileWriter fw = new FileWriter(archivoPacientes, true);/*misma logica que Hospital.java */
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(paciente.getNombre() + "," + paciente.getEnfermedad() + "," + paciente.getCodigo());
        } catch (IOException e) {
            System.err.println("Error al guardar el paciente en el archivo: " + e.getMessage());
        }
    }

    public String atenderPacientes() {/*se atiende al paciente que tiene mayor prioridad, osea el primero de la cola  */
        if (colaPacientes.isEmpty()) {
            return "No hay pacientes para atender.";
        }
        Paciente atendido = colaPacientes.poll();
        return "Atendiendo: " + atendido;
    }

    public boolean hayPacientes() {
        return !colaPacientes.isEmpty();
    }
}
