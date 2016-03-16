/* 
    Nombre del programa: Program_3
    Nombre: Andrés David Mojica Ospina
    Fecha: 29-02-2016
    Descripción: Clase que permite probar los metodos del programa 3
*/
import controller.Desviacion;
import java.util.LinkedList;
import model.AbrirDatos;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestFuncionamiento
{
    
    //private Desviacion desviacion = new Desviacion();
    private final AbrirDatos abrir_datos = new AbrirDatos();
    private final Desviacion desviacion = new Desviacion();
    
    LinkedList lista_prueba_1;
    LinkedList lista_prueba_2;
    LinkedList prueba_multiplicacion;
    LinkedList prueba_cuadrado;
    Double prueba_sumatoria;
    
    @Before
    public void setUp() 
    {
        lista_prueba_1 = abrir_datos.llenarLista("src/main/java/data/estimated.txt");
        lista_prueba_2 = abrir_datos.llenarLista("src/main/java/data/actual_added.txt");
        prueba_cuadrado = desviacion.potenciaCuadrado(lista_prueba_1);
        prueba_multiplicacion = desviacion.multiplicacion(lista_prueba_1, lista_prueba_2);
        prueba_sumatoria = desviacion.sumatoria(lista_prueba_1);
    }
    
    @Test
    public void testAbrirDatos()
    {
        assertNotNull(lista_prueba_1);
        assertNotNull(lista_prueba_2);
    }
    
    @Test
    public void testDesviacion()
    {
        assertEquals(16900.0, prueba_cuadrado.get(0));
        assertEquals(454350.0, prueba_multiplicacion.get(1));
        assertEquals(3828.0, prueba_sumatoria, 0);        
    }
    
}
