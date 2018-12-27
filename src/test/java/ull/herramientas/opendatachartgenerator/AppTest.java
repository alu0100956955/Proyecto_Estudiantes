package ull.herramientas.opendatachartgenerator;

import java.util.logging.Level;

import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ull.herramientas.opendatachartgenerator.salida.IGenerarSalida;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	
	//String urlDataset1 = "C:/Users/usuario/Downloads/Proyecto_Estudiantes-master/barrios.txt";
	String urlDataset1 = "http://www.santacruzdetenerife.es/opendata/dataset/8363b662-0bdc-47e1-b9f6-65b536714f29/resource/ee814891-ba52-4e7c-b9e6-017c1bc43b6b/download/barrios.csv";
	//String urlDataset2 = "C:/Users/usuario/Downloads/Proyecto_Estudiantes-master/barrios.csv";
	String urlDataset2 = "http://www.santacruzdetenerife.es/opendata/dataset/8363b662-0bdc-47e1-b9f6-65b536714f29/resource/1f86d613-d406-418e-8757-46bea561d9ed/download/barrios.xls";
	Dataset dataset1 = null;
	Dataset dataset2 = null;
	
	private IGenerarSalida salida;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
        //return new TestSuite( AppTest.leerTodo());
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    
    /**
     *	Prueba para evaluar los conjuntos
     */
    /*
    public void testGetReader() {
    	try {
    	//urlDataset1 = "https://rawgit.com/alu0100773408/OpenDataChartGenerator-ODCG/master/barrios.txt";
    	dataset1 = new Dataset(urlDataset1,0);
    	
    	//urlDataset2 = "http://www.santacruzdetenerife.es/opendata/dataset/8363b662-0bdc-47e1-b9f6-65b536714f29/resource/ee814891-ba52-4e7c-b9e6-017c1bc43b6b/download/barrios.csv";
    	dataset2 = new Dataset(urlDataset2,1);
    	
    	//System.out.print(dataset1.getReader());
    	//IReader aux = ull.herramientas.opendatachartgenerator.Readercsv@41a2befb;
    	assertEquals(dataset1.getReader(),dataset2.getReader());
    		
    	}catch(IOException a) {
    		System.out.printf("fallo al abrir el fichero",a);
    		assertTrue(false);
    	}
    }
    */
    /**
     * test para el metodo size
     */
    public void testSize() {
    	try {
	    	dataset1 = new Dataset(urlDataset1,0);
	    	//System.out.print(dataset1.size());
	    	assertTrue(dataset1.size() == 80);
    	}catch(IOException a) {
    		System.out.printf("fallo al abrir el fichero",a);
    		assertTrue(false);
    	}
    }
    
    /**
     * Prueba del metodo getNombreAtributo
     */
    public void testGetNombreAtributo() {
    	try {
	    	dataset1 = new Dataset(urlDataset1,0);
	    	dataset2 = new Dataset(urlDataset2,1);
	    	assertEquals(dataset1.getNombreAtributo(8),dataset2.getNombreAtributo(8));
	    	assertEquals(dataset1.getNombreAtributo(20),dataset2.getNombreAtributo(20));
    	}catch(IOException a) {
    		System.out.printf("fallo al abrir el fichero",a);
    		assertTrue(false);
    	}
    }
    
    /**
     * Prueba para el metodo numero_de_atributos()
     */
    public void testNumero_de_atributos() {
    	try {
    		dataset1 = new Dataset(urlDataset1,0);
	    	assertTrue(dataset1.numero_de_atributos() == 54);
    	}catch(IOException a) {
    		System.out.printf("fallo al abrir el fichero",a);
    		assertTrue(false);
    	}
    }
    
    /**
     * Prueba que salta error debido a falta de datos
     */
    public void testException() {
    	try {
    		salida.salidaPDF();
    		fail("faltan valores para generar el pdf");
    	} catch (Exception x) {
    		assertTrue(true);
    	}
    	
    }
    
}
