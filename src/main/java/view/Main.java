/* 
    Nombre del programa: Program_4
    Nombre: Andrés David Mojica Ospina
    Fecha: 14-03-2016
    Descripción: Permite ejecutar la aplicación en la web de heroku
*/
package view;

import controller.Reporte;
import static spark.Spark.*;
import static spark.Spark.get;

public class Main 
{
    /* Metodo de set-up del programa */
    public static void main(String[] args)
    {
      port(Integer.valueOf(System.getenv("PORT")));
      staticFileLocation("/public");

      Reporte reporte = new Reporte();
      String resultado = reporte.getReporte();

      get("/", (req, res) -> resultado);
    }
}
