package examen;

import examen.controller.ClienteController;
import examen.controller.FacturaController;
import examen.directory.IClienteRepository;
import examen.directory.IFacturaRepository;
import examen.entity.Cliente;
import examen.entity.Factura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class App implements CommandLineRunner {

    private final IClienteRepository clienteRepository;
    private final ClienteController clienteController;
    private final IFacturaRepository facturaRepository;
    private final FacturaController facturaController;

    private static int currentScreen = 0;

    public App(IClienteRepository clienteRepository, ClienteController clienteController, IFacturaRepository facturaRepository, FacturaController facturaController) {
        this.clienteRepository = clienteRepository;
        this.clienteController = clienteController;
        this.facturaRepository = facturaRepository;
        this.facturaController = facturaController;
    }

    @Autowired


    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
    private static int obtenerOpcion() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        try {
            opcion = Integer.parseInt(sc.next());
            if (currentScreen == 0 && opcion < 1 || opcion > 6) {
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Opción incorrecta");
        }
        return opcion;
    }

    private static void imprimirMenu() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("0 Salir | 1 Todos los Clientes | 2 Guardar Clientes | 3 Borrar Clientes | 4 Modificar Clientes | 5 Guardar Facturas  | 6 Listar todas las facturas con el nombre del cliente | 7 Listar las facturas de un solo cliente | 8 Listar las facturas que superen un importe determinado");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void run(String... args) {
        System.out.println("***************************************************************************************************************************************************************************************************************************************************************");
        int opcion;
        while (true) {
            imprimirMenu();
            opcion = obtenerOpcion();
            if (opcion == 0) break;
            if (currentScreen == 0) {
                switch (opcion) {
                    case 1:
                        // Todos los Clientes
                        clienteRepository.findAll().forEach(System.out::println);
                        break;
                    case 2:
                        // Guardar Clientes
                        clienteController.crearCliente();
                        break;
                    case 3:
                        // Borrar Clientes si no tienen facturas
                        clienteController.borrarCliente();
                        break;
                    case 4:
                        // Modificar Clientes
                        clienteController.modificarCliente();
                        break;
                    case 5:
                        // Guardar Facturas
                        facturaController.crearFactura();
                        break;
                    case 6:
                        // Listar todas las facturas con el nombre del cliente
                        facturaController.listarFacturasNombre();
                        break;
                    case 7:
                        // Listar las facturas de un solo cliente
                        facturaController.listarFacturasId();
                        break;
                    case 8:
                        // Listar las facturas que superen un importe determinado
                        facturaController.listarFacturaImporte();
                        break;
                }
            }
        }
        System.out.println("***************************************************************************************************************************************************************************************************************************************************************");
    }
}