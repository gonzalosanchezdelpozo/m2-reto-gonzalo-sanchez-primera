package com.example.m2retogonzalosanchezprimera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class M2RetoGonzaloSanchezPrimeraApplication {

		@Autowired
		LibroRepository libroRepository;

	public static void main(String[] args) {
		SpringApplication.run(M2RetoGonzaloSanchezPrimeraApplication.class, args);
	}

	public void showMenu(){
		System.out.println("Bienvenido/a a su libreria, seleccione una opción:");
		System.out.println("0 - Salir");
		System.out.println("1 - Ver todos los libros");
		System.out.println("2 - Ver un libro por id");
		System.out.println("3 - Crear un nuevo libro");
		System.out.println("4 - Modificar/Actualizar un libro existente");
		System.out.println("5 - Borrar un libro existente por id");
		System.out.println("6 - Borrar todos los libros");
		System.out.println("7 - Ver todos los libros filtrando por editorial");
		System.out.println("8 - Ver todos los libros filtrando por editorial y autor");
		System.out.println(("9 - Ver todos los libros con menos páginas que: "));
	}

	@Override
	public void run(String... args){


		while (true) {
			Scanner scanner = new Scanner(System.in);
			showMenu();
			try { // pedir una opción por consola
				int opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion == 0) {
					System.out.println("Hasta la próxima");
					break;
				} else if (opcion == 1) {
					// Buscar todos los libros que hay en la base de datos
					List<Libro> libros = libroRepository.findAll();
					// comprobar si la longitud es 0, si es 0 imprimir que no hay libros
					if (libros.isEmpty()) {
						System.out.println("No hay libros en la librería.");
					} else {
						System.out.println(libros);
					}

				} else if (opcion == 2) {
					System.out.println("Por favor, introduzca el id del libro que desea ver");
					Long id = scanner.nextLong();
                /*
                 Optional actúa como contenedor, dos posibilidades:
                    - Si el libro existe el Optional lo contiene
                    - Si el libro no existe el Optional está empty
                 */
					Optional<Libro> libroOptional = libroRepository.findById(id);
					// comprobar si dentro del optional hay un libro
					if (libroOptional.isPresent()) { // si hay libro entonces lo recupero con get()
						Libro libro = libroOptional.get();
						System.out.println(libro);
					} else { // si no hay libro entonces imprimo un texto
						System.out.println("No existe el libro solicitado");
					}

				} else if (opcion == 3) { // Crear un nuevo libro
					// 1. Leer atributos para el nuevo libro

					// id
					System.out.println("Introduce el id");
					Long id = scanner.nextLong();

					// Título
					System.out.println("Introduce un título: ");
					String titulo = scanner.nextLine();

					// Autor
					System.out.println("Introduce el autor: ");
					String autor = scanner.nextLine();

					// Número de páginas
					System.out.println("Introduce el número de páginas: ");
					Integer numero_paginas = scanner.nextInt();
					scanner.nextLine();

					// Editorial
					System.out.println("Introduce la editorial: ");
					String editorial = scanner.nextLine();

					// Encuadernacion
					System.out.println("Introduce la encuadernación: ");
					String encuadernacion = scanner.nextLine();

					// Encuadernacion
					System.out.println("Introduce la ISBN: ");
					String isbn = scanner.nextLine();

					// Año de publicación
					System.out.println("Introduce el año de publicación: ");
					Integer anio = scanner.nextInt();

					// Plaza de publicación
					System.out.println("Introduce la plaza de edición: ");
					String  plaza_edicion = scanner.nextLine();


					// 2. Crear el objeto laptop
					Libro libroFlamante = new Libro (id, titulo, autor, numero_paginas, editorial, encuadernacion, isbn, anio, plaza_edicion);

					// 3. Guardar el objeto libro en base de datos
					libroRepository.save(libroFlamante);
					System.out.println("Libro creado correctamente");
				} else if (opcion == 4) {
					System.out.println("Por favor, introduzca el id del libro que desea modificar");
					Long id = scanner.nextLong();
					scanner.nextLine();
					Optional<Libro> libroOptional = libroRepository.findById(id);

					if (libroOptional.isEmpty()) {
						System.out.println("No existe el libro solicitado");
						continue; // salta la siguiente iteración
					}
					Libro libro = libroOptional.get();

					// titulo
					System.out.println("Introduce un titulo (actual: " + libro.getTitulo() + ")");
					String titulo = scanner.nextLine();
					libro.setTitulo(titulo);

					// autor
					System.out.println("Introduce un autor (actual: " + libro.getAutor() + ")");
					String autor = scanner.nextLine();
					libro.setAutor(autor);

					// numero de páginas
					System.out.println("Introduce el número de páginas(actual: " + libro.getNumero_paginas() + ")");
					Integer numero_paginas = scanner.nextInt();
					scanner.nextLine();
					libro.setNumero_paginas(numero_paginas);

					// editorial
					System.out.println("Introduce la editorial (actual: " + libro.getEditorial() + ")");
					String editorial = scanner.nextLine();
					libro.setEditorial(editorial);

					// encuadernacion
					System.out.println("Introduce la encuadernación (actual: " + libro.getEncuadernacion() + ")");
					String encuadernacion = scanner.nextLine();
					libro.setEncuadernacion(encuadernacion);

					// isbn
					System.out.println("Introduce el isbn (actual: " + libro.getIsbn() + ")");
					String isbn = scanner.nextLine();
					libro.setIsbn(isbn);

					// Año
					System.out.println("Introduce el año (actual: " + libro.getAnio() + ")");
					Integer anio = scanner.nextInt();
					scanner.nextLine();
					libro.setAnio(anio);

					// Plaza de edición
					System.out.println("Introduce la plaza de edición (actual: " + libro.getPlaza_edicion() + ")");
					String plaza_edicion = scanner.nextLine();
					libro.setPlaza_edicion(plaza_edicion);


					// guardar de nuevo el libro para trasladar los cambios a la base de datos:
					libroRepository.save(libro);
					System.out.println("Libro actualizado correctamente!");
				} else if (opcion == 5) {
					System.out.println("Introduzca el id del libro que desea borrar");
					Long id = scanner.nextLong();
					boolean exists = libroRepository.existsById(id);

					if (exists) {
						libroRepository.deleteById(id); // SQL: DELETE FROM laptop WHERE id = X
						System.out.println("Libro borrado");
					} else {
						System.out.println("No existe el libro solicitado");
					}


				} else if (opcion == 6) {

					System.out.println("Esto borrará todos los libros, ¿está seguro? (true o false)");
					boolean confirm = scanner.nextBoolean();

					if (!confirm) continue;

					libroRepository.deleteAll();
					System.out.println("Libros borrados correctamente");

				} else if(opcion == 7){

					System.out.println("Introduzca la editorial: ");
					String editorial = scanner.nextLine();
					List<Libro> libros = libroRepository.findByEditorial(editorial);
					for (Libro libro : libros)
						System.out.println(libro);


				} else if (opcion == 8){

					System.out.println("Introduzca la editorial: ");
					String editorial = scanner.nextLine();
					System.out.println("Introduzca la autor: ");
					String autor = scanner.nextLine();

					List<Libro> libros = libroRepository.findByEditorialAndAutor(editorial, autor);
					for (Libro libro : libros)
						System.out.println(libro);
				}
				else if (opcion == 9){

					System.out.println("Introduzca el numero de páginas: ");
					Integer numero_paginas = scanner.nextInt();


					for (Libro libro : libroRepository.findByNumero_PaginasLessThan(numero_paginas))
						System.out.println(libro);

				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}


