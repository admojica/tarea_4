/* 
    Nombre del programa: Program_4
    Nombre: Andrés David Mojica Ospina
    Fecha: 14-03-2016
    Descripción: Clase que permite probar los metodos del programa 4
*/
package test;

import controller.Estadistica;
import controller.Reporte;
import java.text.DecimalFormat;
import java.util.LinkedList;
import model.AbrirDatos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestProgram 
{
    private final Estadistica estadistica = new Estadistica();
    private final AbrirDatos abrir_datos = new AbrirDatos();
    private final Reporte reporte = new Reporte();
    
    LinkedList loc_method;
    LinkedList pgs_chapter;
    LinkedList loc_method_logaritmo;
    LinkedList loc_menos_promedio;
    LinkedList rangos_logaritmicos;
    LinkedList rangos;
    Double promedio;
    Double varianza;
    Double desviacion_estandar;
    
    
    @Before
    public void setUp() 
    {
        
        loc_method = abrir_datos.llenarLista("src/main/java/data/loc-method.txt");
        
        loc_method_logaritmo = estadistica.logaritmoNeperiano(loc_method);
        promedio = estadistica.obtenerPromedio(loc_method_logaritmo);
        loc_menos_promedio = estadistica.obtenerLogartimoMenosPromedio(loc_method_logaritmo, promedio);
        varianza = estadistica.obtenerVarianza(loc_menos_promedio);
        desviacion_estandar = estadistica.obtenerDesviacionEstandar(varianza);
        rangos_logaritmicos = estadistica.obtenerRangosLogaritmicos(promedio, desviacion_estandar);
        rangos = estadistica.obtenerAntilogaritmo(rangos_logaritmicos);  
        
        // Clase reporte
    }
    
    // Test de la clase AbrirDatos
    @Test
    public void testAbrirDatos()
    {
        assertNotNull(loc_method);
    }
    
    // Test de la clase Estadistica
    @Test
    public void testLogaritmoNeperiano()
    {
        assertEquals(1.7918, Math.round((double) loc_method_logaritmo.get(0)*10000.0)/10000.0, 0);        
    }
    
    @Test
    public void testObtenerPromedio()
    {
        assertEquals(2.8015, Math.round(promedio * 10000.0)/10000.0, 0);        
    }
    
    @Test
    public void testObtenerLogartimoMenosPromedio()
    {
        assertEquals(1.0196, Math.round((double) loc_menos_promedio.get(0)*10000.0)/10000.0, 0);
    }
    
    @Test
    public void testObtenerVarianza()
    {
        assertEquals(0.4363, Math.round(varianza * 10000.0)/10000.0, 0);        
    }
    
    @Test
    public void testObtenerDesviacionEstandar()
    {
        assertEquals(0.6605, Math.round(desviacion_estandar * 10000.0)/10000.0, 0);        
    }
    
    @Test
    public void testObtenerRangosLogaritmicos()
    {
        assertEquals(1.4805, Math.round((double) rangos_logaritmicos.get(0)*10000.0)/10000.0, 0);
    }
    
    @Test
    public void testObtenerAntilogaritmo()
    {
        assertEquals(4.3953, Math.round((double) rangos.get(0)*10000.0)/10000.0, 0);
    }
    
}
