package org.example;
import org.example.DB.DBManager;

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
            System.out.println("1. Listar Registros \n2. Insertar Registro \n3. Actualizar Registro \n4. Eliminar Registro \n5. Salir");
            System.out.println("Seleccione una opción: ");
            option = Integer.parseInt(System.console().readLine());

            switch (option) {
                case 1:
                    dbManager.listRecords("vehiculos");
                    System.out.println("test");
                    break;
                case 2:
//                    dbManager.insertRecord();
                    break;
                case 3:
//                    dbManager.updateRecord();
                    break;
                case 4:
//                    dbManager.deleteRecord();
                    break;
                case 5:
                    result = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }
    }
}