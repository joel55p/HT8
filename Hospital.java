package com.example;

import java.io.*;
import java.util.ArrayList;

public class Hospital {
    private PriorityQueue<Paciente> colaPacientes;
    private final String archivoPacientes = "src\\main\\java\\com\\example\\pacientes.txt"; // Ruta del archivo

    public Hospital(boolean useHeap) {
        this.colaPacientes = PriorityQueueFactory.getPriorityQueue(useHeap);
    }

    public String cargarPacientesDesdeArchivo(String archivo) {
        StringBuilder resultado = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
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
        return resultado.toString();
    }

    public String agregarPaciente(Paciente paciente) {
        colaPacientes.add(paciente);
        guardarPacienteEnArchivo(paciente); // Guardar en el archivo
        return "Paciente agregado: " + paciente.getNombre();
    }

    private void guardarPacienteEnArchivo(Paciente paciente) {
        try (FileWriter fw = new FileWriter(archivoPacientes, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(paciente.getNombre() + "," + paciente.getEnfermedad() + "," + paciente.getCodigo());
        } catch (IOException e) {
            System.out.println("Error al guardar el paciente en el archivo: " + e.getMessage());
        }
    }

    public String atenderPacientes() {
        if (colaPacientes.isEmpty()) {
            return "No hay pacientes para atender.";
        }
        Paciente atendido = colaPacientes.remove();
        return "Atendiendo: " + atendido;
    }

    public boolean hayPacientes() {
        return !colaPacientes.isEmpty();
    }
}
