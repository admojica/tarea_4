/* 
    Nombre del programa: Program_4
    Nombre: Andrés David Mojica Ospina
    Fecha: 14-03-2016
    Descripción: Clase que permite realizar el reporte de una operación
*/
package controller;

import java.text.DecimalFormat;
import java.util.LinkedList;
import model.AbrirDatos;

public final class Reporte 
{
    AbrirDatos abrir_datos = new AbrirDatos();
    Estadistica estadistica = new Estadistica();
    String reporte;
    /* Metodo constructor de la clase */
    public Reporte()
    {
        reporte = " <table style='width:400px;border:1px solid black;'><tr><td></td><td>VS</td><td>S</td><td>M</td><td>L</td><td>VL</td></tr>";
        generarReporte("src/main/java/data/loc-method.txt", "LOC/Method");
        generarReporte("src/main/java/data/pgs-chapter.txt", "Pgs/Chapter");          
        reporte += "</table>";
    }
    
    /* Metodo para retornar el resultado del reporte */
    public String getReporte()
    {
        return this.reporte;
    }
    
    /* Metodo de set-up para obtener el reporte */
    public void generarReporte(String ruta, String titulo)
    {        
        LinkedList loc_method = abrir_datos.llenarLista(ruta);
        LinkedList loc_method_logaritmo = estadistica.logaritmoNeperiano(loc_method);
        Double promedio = estadistica.obtenerPromedio(loc_method_logaritmo);
        LinkedList loc_menos_promedio = estadistica.obtenerLogartimoMenosPromedio(loc_method_logaritmo, promedio);
        Double varianza = estadistica.obtenerVarianza(loc_menos_promedio);
        Double desviacion_estandar = estadistica.obtenerDesviacionEstandar(varianza);
        LinkedList rangos_logaritmicos = estadistica.obtenerRangosLogaritmicos(promedio, desviacion_estandar);
        LinkedList rangos = estadistica.obtenerAntilogaritmo(rangos_logaritmicos);    
        organizarReporte(rangos, titulo);
    }
    
    /* Metodo para organizar la impresión del reporte */
    public void organizarReporte(LinkedList lista, String titulo)
    {
        LinkedList lista_nueva = new LinkedList();
        for(int i = 0; i < lista.size(); i++)
        {
            
            DecimalFormat formato = new DecimalFormat("##0.0000");
            String impresion = formato.format(lista.get(i));
            lista_nueva.add(i, impresion);            
        }
        reporte += "<tr><td>" + titulo + "</td><td>" + lista_nueva.get(0) + "</td><td>" + lista_nueva.get(1) + "</td><td>" + lista_nueva.get(2) + "</td><td>" + lista_nueva.get(3) + "</td><td>" + lista_nueva.get(4) + "</td></tr>";       
    }
}