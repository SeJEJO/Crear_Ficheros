package main;

import java.io.IOException;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		Fichero fich1 = new Fichero("D:\\cascas.txt");
		existeArchivo(fich1);
		
		fich1.crearFichero();
		existeArchivo(fich1);
		
		fich1.escribirFichero("Paco el botero.");
		fich1.escribirFichero("Vaya porro fuman algunos.");
		
		System.out.println(fich1.leerFichero());
		
		fich1.abrirArchivo();
		
		try{
			Thread.sleep(4000);
			fich1.eliminarFichero();
		}catch(Exception e){
		}
	}	
	
	public static void existeArchivo(Object obj){
		if(((Fichero) obj).checkArchivo())
			System.out.println("Pasa");
		else
			System.out.println("No Pasa");
	}
}
