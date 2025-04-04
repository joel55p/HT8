package com.example;

import java.io.*; /*importante ya que servira para interactuar con user  */
import java.util.ArrayList;

/*Esta clase es como la hace management de literalmente las colas, en donde estan los pacientes  */
public class Hospital {
    private PriorityQueue<Paciente> colaPacientes;
    private final String archivoPacientes = "demo\\src\\main\\java\\com\\example\\pacientes.txt"; // Ruta del archivo relativo, solo asi funcion JAJ

    public Hospital(boolean useHeap) {
        this.colaPacientes = PriorityQueueFactory.getPriorityQueue(useHeap); // Usar el factory para crear la cola de prioridad
    }

    public String cargarPacientesDesdeArchivo(String archivo) { /*se va especifica que cada item del paciente esta separado por , */
        StringBuilder resultado = new StringBuilder(); /*importante mencionar que esta clase como tal va a permitir carga de pacientes  donde cada linea tiene que tener el formato especificado */
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) { /*mientras se lea algo */
                String[] datos = linea.split(","); /*separar por comas */
                if (datos.length == 3) {
                    String nombre = datos[0].trim();
                    String enfermedad = datos[1].trim();
                    char codigo = datos[2].trim().charAt(0);
                    colaPacientes.add(new Paciente(nombre, enfermedad, codigo));
                    resultado.append("Paciente cargado: ").append(nombre).append("\n");/*para verificar que si se agrego paciente */
                }
            }
        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }
        return resultado.toString();
    }

    public String agregarPaciente(Paciente paciente) {
        colaPacientes.add(paciente); /*se agrega a la cola */
        guardarPacienteEnArchivo(paciente); /*se guarda en el archivo */
        return "Paciente agregado: " + paciente.getNombre();
    }

    private void guardarPacienteEnArchivo(Paciente paciente) {
        try (FileWriter fw = new FileWriter(archivoPacientes, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(paciente.getNombre() + "," + paciente.getEnfermedad() + "," + paciente.getCodigo());/*Ademas que se guarda se dice que cada item se separa por coma */
        } catch (IOException e) {
          
        }
    }

    public String atenderPacientes() { /*se atiende al paciente que tiene mayor prioridad, osea el primero de la cola  */
        if (colaPacientes.isEmpty()) {
            return "No hay pacientes para atender.";
        }
        Paciente atendido = colaPacientes.remove();/*se elimina el paciente que se atendio */
        return "Atendiendo: " + atendido;
    }

    public boolean hayPacientes() {
        return !colaPacientes.isEmpty();
    }   
}
