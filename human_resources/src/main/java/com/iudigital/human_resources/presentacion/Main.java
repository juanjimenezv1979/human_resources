package com.iudigital.human_resources.presentacion;

import com.iudigital.human_resources.controller.WorkerController;
import com.iudigital.human_resources.domain.Worker;
import java.lang.ModuleLayer.Controller;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Juan Camilo Jimenez
 */
public class Main {

    public static void getWorker(WorkerController wController) {
        try {
            List<Worker> workers = Controller.getWorker();
            if (worker.isEmpty()) {
                System.out.println("No hay datos");
            } else {
                workers.forEach(worker -> {
                    System.out.println("id: " + worker.getId());
                    System.out.println("Numero de documento" + worker.getIdentification_number());
                    System.out.println("Nombres" + worker.getNames());
                    System.out.println("Apellidos" + worker.getSurnames());
                    System.out.println("Sexo" + worker.getSex());
                    System.out.println("Direccion" + worker.getAdress());
                    System.out.println("Telefono" + worker.getPhone());
                    System.out.println("Fecha de Nacimiento" + worker.getBirthdate());
                    System.out.println("------------------- ");
                    System.out.println("------------------- ");
                }      
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   public static void create(WorkerController workerController) {
    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite por favor su número de documento: ");
        String identification_number = sc.nextLine();
        System.out.println("Su número de documento es: " + identification_number);
        System.out.println("-------------------");
        System.out.println("-------------------");

        System.out.println("Digite por favor sus nombres completos: ");
        String names = sc.nextLine();
        System.out.println("Su nombre completo es: " + names);
        System.out.println("-------------------");
        System.out.println("-------------------");

        System.out.println("Digite por favor sus apellidos completos: ");
        String surnames = sc.nextLine();
        System.out.println("Sus apellidos son: " + surnames);
        System.out.println("-------------------");
        System.out.println("-------------------");

        System.out.println("Digite por favor su sexo, M para masculino y F para femenino: ");
        String sex = sc.nextLine();
        System.out.println("Su sexo es: " + sex);
        System.out.println("-------------------");
        System.out.println("-------------------");

        System.out.println("Digite por favor la direccion de su residencia: ");
        String adress = sc.nextLine();
        System.out.println("Su direccion actual es: " + adress);
        System.out.println("-------------------");
        System.out.println("-------------------");

        System.out.println("Digite por favor su número telefónico: ");
        String phone = sc.nextLine();
        System.out.println("Sus número telefónico es: " + phone);
        System.out.println("-------------------");
        System.out.println("-------------------");

        System.out.println("Digite por favor su fecha de nacimiento en el formato AAAA/MM/DD: ");
        String birthdate = sc.nextLine();
        System.out.println("Su fecha de nacimiento es: " + birthdate);
        System.out.println("-------------------");
        System.out.println("-------------------");

        Worker worker = new Worker();
        worker.setIdentification_number(identification_number);
        worker.setNames(names);
        worker.setSurnames(surnames);
        worker.setSex(sex);
        worker.setAdress(adress);
        worker.setPhone(phone);
        worker.setBirthdate(birthdate);

        workerController.createWorker(worker);
        System.out.println("¡FUNCIONARIO CREADO EXITOSAMENTE!");
        getWorker(workerController);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
public static void deleteWorker(WorkerController workerController) {
    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite por favor el ID del funcionario: ");
        int id = sc.nextInt();
        System.out.println("El ID del funcionario seleccionado es: " + id);

        Worker workerExist = workerController.getWorker(id);
        if (workerExist == null) {
            System.out.println("No existe ningún funcionario que se relacione con el ID digitado.");
            return;
        }
        workerController.deleteWorker(id);
        System.out.println("El funcionario ha sido borrado de la base de datos exitosamente.");
        getWorker(workerController);
        System.out.println("-------------------");
        System.out.println("-------------------");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


    public static void main(String[] args) {

        int opcion = -1;
        Scanner scanner = new Scanner(System.in);

        WorkerController workerController = new WorkerController();
        while (opcion != 0) {
            System.out.println("------------------- ");
            System.out.println("ELIGE UNA OPCION POR FAVOR: ");
            System.out.println("1.LISTAR FUNCIONARIOS");
            System.out.println("2 CREAR FUNCIONARIO");
            System.out.println("3.ELIMINAR FUNCIONARIO");
            System.out.println("4.LISTAR FUNCIONARIO POR ID");
            //System.out.println("5.ACTUALIZAR FUNCIONARIO");
            //System.out.println("------------------- ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 0:
                    System.out.println("Ha salido de la aplicación");
                    break;

                case 1:
                    getWorker(workerController);
                    break;

                case 2:
                    create(workerController);
                    break;

                case 3:
                    deleteWorker(workerController);
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }

    }
}
