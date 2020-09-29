/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramada;

import java.util.Scanner;

/**
 *
 * @author Nicolas Zuñiga
 */
public class Ramada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        Cliente cliente = new Cliente();
        Venta venta = new Venta();

        int opcion = 0;
// TODO code application logic here

        do {
            try {

                System.out.println("Bienvenidos\n ");
                System.out.println("Ingrese una Opción\n");
                System.out.println("--------------------------------------");
                System.out.println("1.- Ingresar cliente");
                System.out.println("2.- Ingresa venta");
                System.out.println("3.- Calcular total de Venta");
                System.out.println("4.- Ver datos del Cliente");
                System.out.println("5.- Ver datos de Venta");
                System.out.println("6.- Salir");
                System.out.println("--------------------------------------");

                String op = sn.nextLine();
                if (!op.matches("\\d+")
                        || Integer.parseInt(op) < 1
                        || Integer.parseInt(op) > 6) {
                    System.out.println("Igrese una opcion valida");
                    System.out.println("Pulse un tecla para continuar");
                    sn.nextLine();
                    continue;
                }

                opcion = Integer.parseInt(op);

                if (opcion == 1) {

                    System.out.println("Ingrese los datos del cliente");

                    System.out.println("\nIngrese el Rut");
                    cliente.setRut(sn.nextLine());

                    System.out.println("\nIngrese el Nombre");
                    cliente.setNombre(sn.nextLine());

                    System.out.println("\nIngrese Edad");
                    String age = sn.nextLine();
                    if (!age.matches("\\d+")) {
                        throw new IllegalArgumentException("Solo puede ingresar numeros");
                    }
                    cliente.setEdad(Integer.parseInt(age));

                    System.out.println("\nIngrese Sexo");
                    System.out.println("Masculino - M - y Femenino - F - ");
                    cliente.setSexo(sn.nextLine().toUpperCase().charAt(0));

                    System.out.println("\nIngrese el tipo de cliente");
                    System.out.println("Cliente Normal, Frecuente, Vip");
                    System.out.println("N--F--V");
                    cliente.setTipoCliente(sn.nextLine().toUpperCase().charAt(0));

                    System.out.println("\nSE REGISTRO CORRECTAMENTE EL CLIENTE \n");

                } else if (opcion == 2) {

                    System.out.println("Ingrese los datos de la venta");
                    System.out.println("Seleccione el producto");
                    System.out.println("Empanada, Terremoto, Anticucho");
                    System.out.println(" E, T, A ");
                    venta.setTipoProducto(sn.nextLine().toUpperCase().charAt(0));

                    System.out.println("Ingrese la cantidad que desea");
                    String cant = sn.nextLine();
                    if (!cant.matches("\\d+")) {
                        throw new IllegalArgumentException("Debe ser mayor a 1");
                    }
                    venta.setCantidadProductos(Integer.parseInt(cant));

                    System.out.println("Ingrese propina ");
                    String pro = sn.nextLine();
                    if (!pro.matches("\\d+")) {
                        throw new IllegalArgumentException("Solo puede ingresar numeros");
                    }
                    venta.setPropina(Integer.parseInt(pro));

                    venta.setCliente(cliente);

                } else if (opcion == 3) {
                    System.out.println("El total de la venta es: $" + venta.calcularVenta());

                } else if (opcion == 4) {

                    cliente.imprimir();

                } else if (opcion == 5) {
                    venta.imprimirVenta();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Presione enter para continuar");
                sn.nextLine();

            }
        }while (opcion != 6);

        }


    }
