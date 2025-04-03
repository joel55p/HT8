package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital(true); // true para usar VectorHeap, false para usar PriorityQueue de Java
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Hospital:");
            System.out.println("1. Cargar pacientes desde archivo");
            System.out.println("2. Agregar nuevo paciente");
            System.out.println("3. Atender pacientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println(hospital.cargarPacientesDesdeArchivo("src\\main\\java\\com\\example\\pacientes.txt"));
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese la enfermedad del paciente: ");
                    String enfermedad = scanner.nextLine();

                    System.out.print("Ingrese el código de prioridad (A = alta, B = media, C = baja): ");
                    char codigo = scanner.next().charAt(0);
                    scanner.nextLine(); // Limpiar buffer

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
        } while (opcion != 4);

        scanner.close();
    }
}
