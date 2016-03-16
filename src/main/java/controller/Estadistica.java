/* 
    Nombre del programa: Program_4
    Nombre: Andrés David Mojica Ospina
    Fecha: 14-03-2016
    Descripción: Permite obtener diversos datos estadísticos
*/
package controller;

import java.util.LinkedList;

public class Estadistica 
{
    // Metodo que determina el logaritmo neperiano de una lista ligada
    public LinkedList logaritmoNeperiano(LinkedList lista)
    {
        for(int i = 0; i < lista.size(); i++)
        {
            Double logaritmo = Math.log((double) lista.get(i));
            lista.set(i, logaritmo);
        }
        return lista;
    }
    
    // Metodo que obtiene el promedio de una lista
    public Double obtenerPromedio(LinkedList lista)
    {
        Double promedio = 0.0;
        for(int i = 0; i < lista.size(); i++)
        {
            promedio = promedio + (Double) lista.get(i);
        }
        promedio = promedio / lista.size();
        return promedio;
    }
    
    // Metodo para obtener el logaritmo menos el promedio elevado al cuadrado
    public LinkedList obtenerLogartimoMenosPromedio(LinkedList lista, Double promedio)
    {
        LinkedList lista_nueva = new LinkedList();
        for(int i = 0; i < lista.size(); i++)
        {
            Double resta_logaritmo = Math.pow((Double) lista.get(i) - promedio, 2);
            lista_nueva.add(i, resta_logaritmo);
        }        
        return lista_nueva;
    }
    
    // Metodo para obtener la varianza
    public Double obtenerVarianza(LinkedList lista)
    {
        Double varianza = 0.0;
        for(int i = 0; i < lista.size(); i++)
        {
            varianza = varianza + (Double) lista.get(i);
        }
        varianza = varianza / (lista.size() - 1);
        return varianza;
    }
    
    // Metodo para obtener la desviacion estandar
    public Double obtenerDesviacionEstandar(Double varianza)
    {
        Double desviacion_estandar = Math.sqrt(varianza);        
        return desviacion_estandar;        
    }
    
    // Metodo para obtener los rangos logaritmicos a partir de la desviación estandar
    public LinkedList obtenerRangosLogaritmicos(Double promedio, Double desviacion_estandar)
    {
        LinkedList lista = new LinkedList();
        
        lista.add(promedio - (2 * desviacion_estandar));
        lista.add(promedio - desviacion_estandar);
        lista.add(promedio);
        lista.add(promedio + desviacion_estandar);
        lista.add(promedio + (2 * desviacion_estandar));
        
        return lista;
    }
    
    // Metodo para obtener el antilogaritmo de una lista dada
    public LinkedList obtenerAntilogaritmo(LinkedList lista)
    {
        LinkedList lista_nueva = new LinkedList();
        for(int i = 0; i < lista.size(); i++)
        {
            Double antilogaritmo = Math.exp((double) lista.get(i));
            lista_nueva.add(i, antilogaritmo);
        }
        return lista_nueva;
    }    
}