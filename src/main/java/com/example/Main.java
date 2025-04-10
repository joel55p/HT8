package com.example;

import java.util.Scanner;

/*Universidad del valle de Guatemala
 * Algoritmos y estructuras de datos
 * autor: Joel Nerio 24253 y Fabian Prado 23427
 * fecha: 3 Abril del 2025
 * Descripcion: Este es el main, donde se ejecuta el programa. Se le da la opcion al usuario de cargar pacientes desde un archivo, agregar nuevos pacientes y atender pacientes. Se utiliza una cola de prioridad para manejar los pacientes en orden de prioridad.
 * Se puede elegir entre usar un VectorHeap o la PriorityQueue de Java.
 */
public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital(true); /*Importante mencionar que true para usar VectorHeap, false para usar PriorityQueue de Java */ 
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {// Se muestra el menú al usuario y se le pide que seleccione una opción
            System.out.println("\nMenú de Hospital:");
            System.out.println("1. Cargar pacientes desde archivo");
            System.out.println("2. Agregar nuevo paciente");
            System.out.println("3. Atender pacientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); /*Para limpiar Buffer */

            switch (opcion) { /*Simple menu de opciones  */
                case 1:
                    System.out.println(hospital.cargarPacientesDesdeArchivo("demo\\src\\main\\java\\com\\example\\pacientes.txt"));
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese la enfermedad del paciente: ");
                    String enfermedad = scanner.nextLine();

                    System.out.print("Ingrese el código de prioridad (A = alta, B = media, C = baja): ");
                    char codigo = scanner.next().charAt(0);
                    scanner.nextLine(); /*Limpiar buffer */

                    Paciente nuevoPaciente = new Paciente(nombre, enfermedad, codigo);
                    System.out.println(hospital.agregarPaciente(nuevoPaciente));
                    break;
                case 3:
                    while (hospital.hayPacientes()) {
                        System.out.println(hospital.atenderPacientes());
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);/*salir */

        scanner.close();
    }
}
