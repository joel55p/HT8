package com.example;

import java.util.Scanner;
/*Universidad del valle de Guatemala
 * Algoritmos y estructuras de datos
 * autor: Joel Nerio 24253 y Fabian Prado 23427
 * fecha: 3 Abril del 2025
 * Descripcion: Es lo mismo que el main, pero usando la interfaz de Java. Se le da la opcion al usuario de cargar pacientes desde un archivo, agregar nuevos pacientes y atender pacientes. Se utiliza una cola de prioridad para manejar los pacientes en orden de prioridad.
 * Se puede elegir entre usar un VectorHeap o la PriorityQueue de Java.
 * */

public class MainJCF {
    public static void main(String[] args) {
        HospitalJCF hospital = new HospitalJCF(); /*Importante no olvidar que es de HospitalJCF */
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Hospital:"); /*opciones */
            System.out.println("1. Cargar pacientes desde archivo");
            System.out.println("2. Agregar nuevo paciente");
            System.out.println("3. Atender pacientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); /*Para limpiar Buffer */

            switch (opcion) { /*Simple menu de opciones  */
                case 1:
                    System.out.println(hospital.cargarPacientesDesdeArchivo());
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la enfermedad del paciente: ");
                    String enfermedad = scanner.nextLine();
                    System.out.print("Ingrese el código de prioridad (A = alta, B = media, C = baja): ");
                    char codigo = scanner.next().charAt(0);
                    scanner.nextLine();
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

        scanner.close(); /*cerrar scanner */
    }
}
