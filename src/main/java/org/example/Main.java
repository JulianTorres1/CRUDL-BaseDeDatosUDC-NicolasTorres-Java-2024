package org.example;
import org.example.DB.DBManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Testing connection to the database...");

        DBManager dbManager = new DBManager();

        boolean result = false;

        if (dbManager.testConnection()) {
            result = true;
        } else {
            System.out.println("Connection failed!");
        }

        int option = 0;
        while (result) {
            System.out.println("1. Listar Registros \n2. Insertar Registro \n3. Actualizar Registro \n4. Eliminar Registro \n5. Filtrar por Precio ( Desendente ) \n6. Filtrar por Precio ( Acendente ) \n7. Salir");
            System.out.println("Seleccione una opción: ");
            option = Integer.parseInt(System.console().readLine());

            switch (option) {
                case 1:
                    dbManager.listRecords("vehiculos");
                    System.out.println("test");
                    break;
                case 2:
                    Scanner scanner = new Scanner(System.in);

                    System.out.print("Enter num_bastidor: ");
                    String numBastidor = scanner.nextLine();

                    System.out.print("Enter nombre_modelo: ");
                    String nombreModelo = scanner.nextLine();

                    System.out.print("Enter precio: ");
                    double precio = scanner.nextDouble();

                    System.out.print("Enter descuento: ");
                    double descuento = scanner.nextDouble();

                    System.out.print("Enter potencia_fiscal: ");
                    int potenciaFiscal = scanner.nextInt();

                    System.out.print("Enter cilindrada: ");
                    int cilindrada = scanner.nextInt();

                    System.out.print("Enter en_stock (true/false): ");
                    boolean enStock = scanner.nextBoolean();

                    System.out.print("Enter id_concesionario: ");
                    int idConcesionario = scanner.nextInt();

                    System.out.print("Enter id_servicio: ");
                    int idServicio = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter fecha_agregado (YYYY-MM-DD format or leave blank for default): ");
                    String fechaAgregado = scanner.nextLine();

                    String query;
                    if (fechaAgregado.isEmpty()) {
                        query = String.format("(num_bastidor, nombre_modelo, precio, descuento, potencia_fiscal, cilindrada, en_stock, id_concesionario, id_servicio) VALUES ('%s', '%s', %.2f, %.2f, %d, %d, %b, %d, %d)",
                                numBastidor, nombreModelo, precio, descuento, potenciaFiscal, cilindrada, enStock, idConcesionario, idServicio);
                    } else {
                        query = String.format("(num_bastidor, nombre_modelo, precio, descuento, potencia_fiscal, cilindrada, en_stock, id_concesionario, id_servicio, fecha_agregado) VALUES ('%s', '%s', %.2f, %.2f, %d, %d, %b, %d, %d, '%s')",
                                numBastidor, nombreModelo, precio, descuento, potenciaFiscal, cilindrada, enStock, idConcesionario, idServicio, fechaAgregado);
                    }

                    dbManager.insertRecord("vehiculos", query);

                    break;
                case 3:
                    // Update record
                    Scanner updateScanner = new Scanner(System.in);

                    boolean valid = false;

                    while (valid != true) {
                        try {
                            System.out.print("Ingrese el Numero del Bastidor del Vehiculo a modificar: ");
                            String num_bastidor_id = updateScanner.nextLine();

                            System.out.print("Ingrese el dato a modificar: ");
                            String updateColumn = updateScanner.nextLine();

                            System.out.print("Enter the new value: ");
                            String newValue = updateScanner.nextLine();

                            String updateQuery = updateColumn + " = '" + newValue + "' WHERE num_bastidor = '" + num_bastidor_id + "'";

                            dbManager.updateRecord("vehiculos", updateQuery);
                            valid = true;
                        } catch (Exception e) {
                            System.out.println("An error occurred: " + e.getMessage());
                        }
                    }


                    break;
                case 4:
                    // Delete record

                    try {
                        Scanner deleteScanner = new Scanner(System.in);

                        System.out.print("Ingrese el Numero del Bastidor del Vehiculo a eliminar: ");
                        String num_bastidor_id = deleteScanner.nextLine();

                        dbManager.deleteRecord("vehiculos", num_bastidor_id);
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;
                case 5:
                    dbManager.filterRecordsByPriceDESC("vehiculos");
                    break;
                case 6:
                    dbManager.filterRecordsByPriceASC("vehiculos");
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    result = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }
    }
}
