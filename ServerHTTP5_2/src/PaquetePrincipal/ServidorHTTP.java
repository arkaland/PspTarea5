package PaquetePrincipal;

import java.io.BufferedReader;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

class ServidorHTTP {

    public static void main(String[] args) throws IOException, Exception {

        try {

            ServerSocket socServidor = new ServerSocket(8066);
            Socket socketCliente;

            while (true) {

                //acepta una petición, y le asigna un socket cliente para la respuesta
                socketCliente = socServidor.accept();

                //crea un nuevo hilo para despacharla por el socketCliente que le asignó
                HiloDespachador hilo = new HiloDespachador(socketCliente);

                hilo.start();

            }

        } catch (IOException ex) {

        }

    }

    
        private static void procesaPeticion(Socket socketCliente) throws IOException {

  }
    
    
  private static void imprimeDisponible() {

    System.out.println("El Servidor WEB se está ejecutando y permanece a la "
            + "escucha por el puerto 8066.\nEscribe en la barra de direcciones "
            + "de tu explorador preferido:\n\nhttp://localhost:8066\npara "
            + "solicitar la página de bienvenida\n\nhttp://localhost:8066/"
            + "quijote\n para solicitar una página del Quijote,\n\nhttp://"
            + "localhost:8066/q\n para simular un error");
  }

}
