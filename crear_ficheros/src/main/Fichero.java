package main;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {

	File archivo;
	FileReader arch_Read;
	BufferedWriter bW;
	BufferedReader bR;
	
	// The method constructor of class
	// Metodo constructor de la clase
	public Fichero(String ruta){
		setArchivo(ruta);
	}
	// Make a file
	// Crea un fichero
	public void crearFichero(){
		try {
				if(!archivo.exists()){
					archivo.createNewFile();
					System.out.println("Creado");
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
	}
	// Read the selected file
	// Lee el fichero seleccionado
	public String leerFichero(){
		String linea,texto="";
		bR = new BufferedReader(arch_Read);
		try {
			while((linea = bR.readLine())!=null)
				texto = texto.concat(linea.concat("\n"));
			bR.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return texto;
	}
	// Check that the selected file have content
	// Comprueba que el fichero tenga contenido
	public boolean tieneContenido(){
		boolean content=false;
		bR = new BufferedReader(arch_Read);
		try {
			if(bR.readLine()!=null)
				content=true;
			bR.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return content;
	}
	// Empty file (delete and make the file)
	// Vaciar el fichero(borrar y crear el fichero)
	public void vaciarFichero(){
		eliminarFichero();
		crearFichero();
	}
	// Write the file
	// Escribir en el fichero
	public void escribirFichero(String texto){
		try {
			bW = new BufferedWriter(new FileWriter(archivo,true));
			bW.write(texto);
			bW.newLine();
			bW.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	// Open the file
	// Abrir el fichero
	public void abrirArchivo(){
		try {
			Desktop.getDesktop().open(archivo);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	// Delete file
	// Borra el fichero
	public void eliminarFichero(){
		archivo.delete();
	}
	// Set the path of file
	// Definir ruta al archivo
	public void setArchivo(String ruta){
		archivo = new File(ruta);
		try {
			arch_Read = new FileReader(ruta);
		} catch (FileNotFoundException e) {
			crearFichero();
			try {
				arch_Read = new FileReader(ruta);
			} catch (Exception e1) {
				System.out.println(e.getMessage());
			}
		}
	}
	// Return the path of file
	// Devuelve la ruta del archivo
	public String getArchivo(){
		return archivo.getPath();
	}
	// Check that file exist
	// Comprueba que el fichero existe
	public boolean checkArchivo(){
		if(archivo.exists())
			return true;
		return false;
	}
	
}
