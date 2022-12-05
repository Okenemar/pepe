package principal;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import clases.Usuario;
public class GestionDeUsuarios {

	public static void main(String[] args) throws FileNotFoundException  {
		final String NOMBRE_FICHERO = "Recursos/usuarios.txt";
		ArrayList<Usuario> usuarios = Usuario.cargarDatos(NOMBRE_FICHERO);
		final int MOSTRAR = 1;
		final int ELIMINAR = 2;
		final int CREAR = 3;
		final int MODIFICAR = 4;
		final int SALIR = 0;
		
		Scanner scan = new Scanner(System.in);
		int opcion_menu;
		
		do {
			System.out.println("------MENU-------");
			System.out.println(MOSTRAR +". Mostrar Usuarios");
			System.out.println(ELIMINAR + ". Eliminar Usuario");
			System.out.println(CREAR + ". Crear Usuario");
			System.out.println(MODIFICAR + ". Modificiar Usuario");
			System.out.println(SALIR + ". Salir");
			System.out.println("Elije una de las opciones");
			opcion_menu = Integer.parseInt(scan.nextLine());
			
			switch (opcion_menu) {
			case MOSTRAR:
				System.out.println("Opcion de mostrar usuarios seleccionada\n");
				for (Usuario usuario:usuarios) {
					System.out.println(usuario);
				}
				break;
			case ELIMINAR:
				System.out.println("Opcion de eliminar usuario seleccionada\n");
				System.out.println("Introduce el id del usuario que quieres eliminar");
			
				eliminarUsuario(usuarios);
				break;
			case CREAR:
				System.out.println("Opcion de crear usuario seleccionada\n");
				crearUsuario(usuarios);
				break;
			case MODIFICAR:
				System.out.println("Opcion de modificar usuario seleccionada\n");
				modificarUsuario(usuarios);
				break;
			case SALIR:
				System.out.println("ADIOS");
				break;
			default:
				System.out.println("Opcion incorrecta!");
			}
			
		} while (opcion_menu != SALIR);
		Usuario.guardarUsuarios(NOMBRE_FICHERO, usuarios);
		System.out.println("los datos se han guardado con éxito");
		scan.close();
	
	}
	
	private static void modificarUsuario(ArrayList<Usuario> usuarios) {
		int id_usuario = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el id del usuario a modificar");
		id_usuario = Integer.parseInt("");
		
		Iterator<Usuario> it = usuarios.iterator();
		while(it.hasNext()) {
			Usuario usuario = it.next();
			if(id_usuario == usuario.getId()) {
				
			
		
		final int MODIFICAR_NOMBRE = 1;
		final int MODIFICAR_APELLIDO = 2;
		final int MODIFICAR_NOMBREUSUARIO = 3;
		final int MODIFICAR_CONTRASEÑA = 4;
		final int MODIFICAR_ESTADO = 5;
		final int SALIR = 0;
		
		
		
		int modificar;
		String nuevoNombre;
		String nuevoApellido;
		String nuevoUsuario;
		String nuevaContraseña;
		String nuevoEstado;
		
		do {
			System.out.println("------MODIFICAR USUARIO-------");
			System.out.println(MODIFICAR_NOMBRE +". Modificar nombre");
			System.out.println(MODIFICAR_APELLIDO + ". Modificar apellido");
			System.out.println(MODIFICAR_NOMBREUSUARIO + ". Modificar nombre usuario");
			System.out.println(MODIFICAR_CONTRASEÑA + ". Modificar contraseña");
			System.out.println(MODIFICAR_ESTADO + ". Modificar estado");
			System.out.println(SALIR + ". Guardar");
			System.out.println("Elije una de las opciones");
			
			modificar = Integer.parseInt(scan.nextLine());
			
			
			switch (modificar) {
			case MODIFICAR_NOMBRE:
				System.out.println("Opcion de modificar nombre seleccionada\n");
				System.out.println("Introduce el nuevo nombre");
				nuevoNombre = scan.nextLine();
				break;
			case MODIFICAR_APELLIDO:
				System.out.println("Opcion de modificar apellido seleccionada\n");
				System.out.println("Introduce el nuevo apellido");
				nuevoApellido = scan.nextLine();
				
				break;
			case MODIFICAR_NOMBREUSUARIO:
				System.out.println("Opcion de modificar nombre usuario seleccionada\n");
				System.out.println("Introduce el nuevo nombre de usuario");
				nuevoUsuario = scan.nextLine();
				break;
			case MODIFICAR_CONTRASEÑA:
				System.out.println("Opcion de modificar contraseña seleccionada\n");
				System.out.println("Introduce la nueva contraseña");
				nuevaContraseña = scan.nextLine();
				break;
			case MODIFICAR_ESTADO:
				System.out.println("Opcion de modificar estado seleccionada\n");
				System.out.println("Introduce el nuevo estado");
				nuevoEstado = scan.nextLine();
				break;
			case SALIR:
				System.out.println("Datos modificados\n");
				
				break;
			default:
				System.out.println("Opcion incorrecta!");
			
		
			}
		} while (modificar != SALIR);
		scan.close();
			}
		}
	}

	private static void crearUsuario(ArrayList<Usuario> usuarios) {
		try (Scanner teclado = new Scanner (System.in)) {
			int idUsuario;
			String nombre;
			String nombreUsuario;
			String apellido;
			String contraseña;
			String activo;
			
			System.out.println("Introduce los datos necesarios\n");
			System.out.println("Introduce el ID\n");
			idUsuario = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Introduce el nombre\n");
			nombre = teclado.nextLine();
			System.out.println("Introduce el apellido\n");
			apellido = teclado.nextLine();
			System.out.println("Introduce el nombre de usuario\n");
			nombreUsuario = teclado.nextLine();
			System.out.println("Introduce la contraseña\n");
			contraseña = teclado.nextLine();
			System.out.println("Introduce si esta activo o no\n");
			activo = teclado.nextLine();
			while (!activo.equals("0") && !activo.equals("1")) {
				System.out.println("Introduce si esta activo o no\\n");
				activo = teclado.nextLine();
			}
				
			
			Usuario nuevoUsuario = new Usuario();
			nuevoUsuario.setId(idUsuario);
			nuevoUsuario.setNombre(nombre);
			nuevoUsuario.setNombreUsuario(nombreUsuario);
			nuevoUsuario.setApellido(apellido);
			nuevoUsuario.setContraseña(contraseña);
			nuevoUsuario.setActivo(Usuario.stringtoBool(activo));
			
			usuarios.add(nuevoUsuario);
		}
	}

	private static void eliminarUsuario(ArrayList<Usuario> usuarios) {
		try (Scanner teclado = new Scanner (System.in)) {
			String nombreUsuario;
			System.out.println("Introduce el nombre de usuario a eliminar\n");
			nombreUsuario = teclado.nextLine();
			
			Iterator<Usuario> it = usuarios.iterator();
			while(it.hasNext()) {
				Usuario usuario = it.next();
				if(nombreUsuario.equals(usuario.getNombreUsuario())) {
					it.remove();
				}
			}
		}
		
	}

	

}
