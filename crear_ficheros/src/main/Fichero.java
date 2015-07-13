package main;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author SeJEJO
 * @version 1.0
 * @since JDK1.8.0_25
 * @see <a href="https://github.com/SeJEJO"> SeJEJO - GitHub </a>
 * 
 * ESP -- Descripción de la clase:
 * Esta clase contiene distintos métodos para el tratamiento de archivos con Java
 * 
 * ING -- Description of class:
 * This class have distinct methods for use of file with Java
 * 
 */

public class Fichero {

	/**
	 * ESP -- Descripción de variables:
	 * 
	 * archivo:		Es donde almacenamos la ruta del archivo a tratar 
	 * arch_Read:	Es donde almacenamos la ruta del archivo a leer
	 * bW:			Es una variable para la ejecución de escritura sobre "archivo"
	 * bR:			Es una variable para la lectura del archivo
	 * 
	 * ENG -- Description of variables:
	 * 
	 * archivo:		It is where we store the file path to use
	 * arch_Read:	It is where we store the file path to read
	 * bW:			It is a variable for writing on "archivo"
	 * bR:			It is a variable for reading the file "arch_Read"
	 * 
	 */
	
	File archivo;
	FileReader arch_Read;
	BufferedWriter bW;
	BufferedReader bR;
	
	/**
	 * ESP -- Descripcion de Fichero(String ruta):
	 * Metodo constructor de la clase
	 * @param ruta	-- 	Es la ruta al fichero
	 * @see setArchivo(ruta)
	 * @throws IOException: Cuando la ruta al archivo no es correcta y no este se puede crear
	 * 
	 * ENG -- Description of Fichero(String ruta):
	 * The method constructor of class
	 * @param ruta	--	It is the file path
	 * @see setArchivo(ruta)
	 * @throws IOException: If the file path is not correct and not this can create
	 * 
	 */
	public Fichero(String ruta) throws IOException {
		setArchivo(ruta);
	}
	
	/**
	 * ESP -- Descripcion de crearFichero():
	 * Crea un fichero
	 * @throws IOException: Cuando el archivo no se puede crear
	 * 
	 * ENG -- Description of crearFichero():
	 * Make a file
	 * @throws IOException: When the file can not be created
	 * 
	 */
	public void crearFichero() throws IOException {
		if(!archivo.exists())
			archivo.createNewFile();
	}

	/**
	 * ESP -- Descripcion de leerFichero():
	 * Lee el fichero seleccionado
	 * @return El texto extraido del fichero linea a linea
	 * @throws IOException: Cuando el archivo no se puede leer
	 * 
	 * ENG -- Description of leerFichero():
	 * Read the selected file
	 * @return The text extract to file line to line
	 * throws IOException: When the file can not be read
	 * 
	 */
	public String leerFichero() throws IOException {
		String linea,texto="";
		bR = new BufferedReader(arch_Read);
		while((linea = bR.readLine())!=null)
			texto = texto.concat(linea.concat("\n"));
		bR.close();
		return texto;
	}
	
	/**
	 * ESP -- Descripcion de tieneContenido():
	 * Comprueba que el fichero tenga contenido
	 * @return Si el fichero contiene texto
	 * @throws IOException: Cuando el archivo no se puede leer
	 * 
	 * ENG -- Description of tieneContenido():
	 * Check that the selected file have content
	 * @return If file have text
	 * @throws IOException: When the file can not be read
	 * 
	 */
	public boolean tieneContenido() throws IOException {
		boolean content=false;
		bR = new BufferedReader(arch_Read);
		if(bR.readLine()!=null)
			content=true;
		bR.close();
		return content;
	}
	
	/**
	 * ESP -- Descripcion de vaciarFichero():
	 * Vaciar el fichero(borrar y crear el fichero)
	 * @throws IOException: Cuando el archivo no se puede leer ni crear
	 * 
	 * ENG -- Description of vaciarFichero():
	 * Empty file (delete and make the file)
	 * @throws IOException: When the file can not be read or create
	 * 
	 */
	public void vaciarFichero() throws IOException {
		eliminarFichero();
		crearFichero();
	}
	
	/**
	 * ESP -- Descripcion de escribirFichero(String texto):
	 * Escribir en el fichero
	 * @param texto	-- 	Es el texto a escribir en el fichero
	 * @throws IOException: Cuando el archivo no se puede escribir
	 * 
	 * ENG -- Description of escribirFichero(String texto):
	 * Write in the file
	 * @param texto	--	It is the text to writer in file
	 * @throws IOException: When the file can not be written
	 * 
	 */
	public void escribirFichero(String texto) throws IOException {
		bW = new BufferedWriter(new FileWriter(archivo,true));
		bW.write(texto);
		bW.newLine();
		bW.close();
	}
	
	/**
	 * ESP -- Descripcion de abrirArchivo():
	 * Abrir el fichero con el programa predeterminado
	 * @throws IOException: Cuando el archivo no se puede abrir con la aplicacion predeterminada
	 * 
	 * ENG -- Description of abrirArchivo():
	 * Open the file with the default program
	 * @throws IOException: When the file can not be opened with the default application
	 * 
	 */	
	public void abrirArchivo() throws IOException {
		Desktop.getDesktop().open(archivo);
	}
	
	/**
	 * ESP -- Descripcion de eliminarFichero():
	 * Borra el fichero
	 * 
	 * ENG -- Description of eliminarFichero():
	 * Delete file
	 * 
	 */	
	public void eliminarFichero(){
		archivo.delete();
	}
	
	/**
	 * ESP -- Descripcion de setArchivo(String ruta):
	 * Definir ruta al archivo
	 * @param ruta	-- 	Es la ruta al fichero
	 * @see crearFichero()
	 * @exception Si el fichero no existe se crea
	 * @throws IOException: Cuando la ruta al archivo no es correcta y no este se puede crear
	 * 
	 * ENG -- Description of setArchivo(String ruta):
	 * Set the path of file
	 * @param ruta	--	It is the file path
	 * @see crearFichero()
	 * @exception exception If the file does not exist is created
	 * @throws IOException: If the file path is not correct and not this can create
	 * 
	 */
	public void setArchivo(String ruta) throws IOException{
		archivo = new File(ruta);
		try {
			arch_Read = new FileReader(ruta);
		} catch (FileNotFoundException e) {
			crearFichero();
			arch_Read = new FileReader(ruta);
		}
	}
	
	/**
	 * ESP -- Descripcion de getArchivo():
	 * Devuelve la ruta del archivo
	 * @return La ruta del archivo
	 * 
	 * ENG -- Description of getArchivo():
	 * Return the path of file
	 * @return The path of file
	 * 
	 */
	public String getArchivo(){
		return archivo.getPath();
	}
	
	/**
	 * ESP -- Descripcion de checkArchivo():
	 * Comprueba que el fichero existe
	 * @return Si el fichero existe
	 * 
	 * ENG -- Description of checkArchivo():
	 * Check that file exist
	 * @return If exist the file
	 * 
	 */
	public boolean checkArchivo(){
		if(archivo.exists())
			return true;
		return false;
	}
	
}
