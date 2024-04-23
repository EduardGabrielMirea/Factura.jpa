package examen.controller;

import examen.directory.IClienteRepository;
import examen.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.List;

@Component
public class ClienteController {

    private final IClienteRepository clienteRepository;

    public ClienteController(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void modificarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del cliente que desea modificar:");
        long id = Long.parseLong(scanner.nextLine());
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            System.out.println("Ingrese el nuevo nombre del cliente:");
            cliente.setNombre(scanner.nextLine());
            clienteRepository.save(cliente);
            System.out.println("Cliente modificado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }


    public void listarCliente() {
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre());
            }
        }
    }

    public void borrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del cliente que desea borrar:");
        long id = Long.parseLong(scanner.nextLine());
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            clienteRepository.delete(cliente);
            System.out.println("Cliente borrado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void crearCliente() {
        Cliente cliente = new Cliente();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente:");
        cliente.setNombre(scanner.nextLine());
        clienteRepository.save(cliente);
        System.out.println("Cliente creado exitosamente.");
    }
}
