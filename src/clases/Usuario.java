package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Usuario {
		
	private int id;
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String contraseña;
	private boolean activo;
	
	public Usuario() {
		
	}
	
	//con parametros
	public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contraseña, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.activo = activo;
	}
	public static ArrayList<Usuario> cargarDatos (String Nombre_fichero) throws FileNotFoundException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		//crear la lista 
		//abrir el fichero 
		File file = new File(Nombre_fichero);
		try (Scanner lectorFichero = new Scanner(file)) {
			String linea;
			String[] partes;
			
			
			
			while(lectorFichero.hasNextLine()) {
				linea = lectorFichero.nextLine();
				partes = linea.split(":");
				
				Usuario usua = new Usuario(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4], (Boolean.parseBoolean(partes [5]))); 
				usuarios.add(usua);
				
			//ir leendo linea a linea
			//por cada linea
				//crear un usuario y rellenarlo con las partes
				//añadir el usuario a la lista
			
			//devolver la lista
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
		
	}
	
	
	public static void guardarUsuarios(String Nombre_fichero, ArrayList<Usuario> usuarios) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(Nombre_fichero);
		
		for (int i = 0; i < usuarios.size(); i++) {
			writer.println(usuarios.get(i).paraFichero());
			
		}writer.close();
	}
	
	public static boolean stringtoBool(String activo) {
		int activoSN = Integer.parseInt(activo);
		if (activoSN == 0) {
			return false;
		}else {
			return true;
		}
	}
	//sin parametros
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public String toString() {
		return "id = " + id + ", nombre = " + nombre + ", apellido = " + apellido  + ", contraseña = " + contraseña + ", activo = " + activo;
	}
	public String paraFichero() {
		return this.id + ":" + ":" + this.nombre + ":" + this.apellido + ":" + this.nombreUsuario + ":" + this.contraseña + ":" + boolToInt(this.activo);
	}
	public static int boolToInt (Boolean b) {
		return b ? 1 : 0;
	}
}


