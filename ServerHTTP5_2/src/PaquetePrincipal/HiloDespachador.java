/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaquetePrincipal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class HiloDespachador extends Thread {

    private final Socket socketCliente;

    public HiloDespachador(Socket socketCliente) {

        this.socketCliente = socketCliente;

    }
    
    
    
    private static void procesaPeticion(Socket socketCliente) throws IOException {
    //variables locales
    String peticion;
    String html;

    //Flujo de entrada
    InputStreamReader inSR = new InputStreamReader(
            socketCliente.getInputStream());
    //espacio en memoria para la entrada de peticiones
    BufferedReader bufLeer = new BufferedReader(inSR);

    //objeto de java.io que entre otras características, permite escribir 
    //'línea a línea' en un flujo de salida
    PrintWriter printWriter = new PrintWriter(
            socketCliente.getOutputStream(), true);

    //mensaje petición cliente
    peticion = bufLeer.readLine();

    //para compactar la petición y facilitar así su análisis, suprimimos todos 
    //los espacios en blanco que contenga
    peticion = peticion.replaceAll(" ", "");

    //si realmente se trata de una petición 'GET' (que es la única que vamos a
    //implementar en nuestro Servidor)
    if (peticion.startsWith("GET")) {
      //extrae la subcadena entre 'GET' y 'HTTP/1.1'
      peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));

      //si corresponde a la página de inicio
      if (peticion.length() == 0 || peticion.equals("/")) {
        //sirve la página
        html = Paginas.html_index;
        printWriter.println(Mensajes.lineaInicial_OK);
        printWriter.println(Paginas.primeraCabecera);
        printWriter.println("Content-Length: " + html.length() + 1);
        printWriter.println("\n");
        printWriter.println(html);
                /*--------------------
        MODIFICACION TAREA 5.1
        ----------------------*/
        printWriter.println(Paginas.dateTarea);
        /*        
        */
      } //si corresponde a la página del Quijote
      else if (peticion.equals("/quijote")) {
        //sirve la página
        html = Paginas.html_quijote;
        printWriter.println(Mensajes.lineaInicial_OK);
        printWriter.println(Paginas.primeraCabecera);
        printWriter.println("Content-Length: " + html.length() + 1);
        printWriter.println("\n");
        printWriter.println(html);
                /*--------------------
        MODIFICACION TAREA 5.1
        ----------------------*/
        printWriter.println(Paginas.dateTarea);
        /*        
        */
      } //en cualquier otro caso
      else {
        //sirve la página
        html = Paginas.html_noEncontrado;
        printWriter.println(Mensajes.lineaInicial_NotFound);
        printWriter.println(Paginas.primeraCabecera);
        printWriter.println("Content-Length: " + html.length() + 1);
        printWriter.println("\n");
        printWriter.println(html);
                /*--------------------
        MODIFICACION TAREA 5.1
        ----------------------*/
        printWriter.println(Paginas.dateTarea);
        /*        
        */
      }
    
    }
  }

    public void run() {

        try {

            //variables locales
    String peticion;
    String html;

    //Flujo de entrada
    InputStreamReader inSR = new InputStreamReader(
            socketCliente.getInputStream());
    //espacio en memoria para la entrada de peticiones
    BufferedReader bufLeer = new BufferedReader(inSR);

    //objeto de java.io que entre otras características, permite escribir 
    //'línea a línea' en un flujo de salida
    PrintWriter printWriter = new PrintWriter(
            socketCliente.getOutputStream(), true);

    //mensaje petición cliente
    peticion = bufLeer.readLine();

    //para compactar la petición y facilitar así su análisis, suprimimos todos 
    //los espacios en blanco que contenga
    peticion = peticion.replaceAll(" ", "");

    //si realmente se trata de una petición 'GET' (que es la única que vamos a
    //implementar en nuestro Servidor)
    if (peticion.startsWith("GET")) {
      //extrae la subcadena entre 'GET' y 'HTTP/1.1'
      peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));

      //si corresponde a la página de inicio
      if (peticion.length() == 0 || peticion.equals("/")) {
        //sirve la página
        html = Paginas.html_index;
        printWriter.println(Mensajes.lineaInicial_OK);
        printWriter.println(Paginas.primeraCabecera);
        printWriter.println("Content-Length: " + html.length() + 1);
        printWriter.println("\n");
        printWriter.println(html);
                /*--------------------
        MODIFICACION TAREA 5.1
        ----------------------*/
        printWriter.println(Paginas.dateTarea);
        /*        
        */
      } //si corresponde a la página del Quijote
      else if (peticion.equals("/quijote")) {
        //sirve la página
        html = Paginas.html_quijote;
        printWriter.println(Mensajes.lineaInicial_OK);
        printWriter.println(Paginas.primeraCabecera);
        printWriter.println("Content-Length: " + html.length() + 1);
        printWriter.println("\n");
        printWriter.println(html);
                /*--------------------
        MODIFICACION TAREA 5.1
        ----------------------*/
        printWriter.println(Paginas.dateTarea);
        /*        
        */
      } //en cualquier otro caso
      else {
        //sirve la página
        html = Paginas.html_noEncontrado;
        printWriter.println(Mensajes.lineaInicial_NotFound);
        printWriter.println(Paginas.primeraCabecera);
        printWriter.println("Content-Length: " + html.length() + 1);
        printWriter.println("\n");
        printWriter.println(html);
                /*--------------------
        MODIFICACION TAREA 5.1
        ----------------------*/
        printWriter.println(Paginas.dateTarea);
        /*        
        */
      }
    
    }
        } catch (IOException ex) {
            System.err.println("Error, Excepción IO");
        }

        HiloDespachador.interrupted();
    }

}
