/**
 * Clase que registra los préstamos de libros.
 * @param inventario El gestor de biblioteca que contiene los libros.
 */
class RegistroPrestamos(private val inventario: GestorBiblioteca) {
    /**
     * Registra un préstamo de un libro dado su ID.
     * @param id El ID del libro.
     */
    fun prestarLibro(id: String) {
        if (inventario.estaDisponible(id)) {
            inventario.cambiarEstadoLibro(id, EstadoLibro.PRESTADO)
            GestorMensajes.log("Libro prestado con ID: $id")
        } else {
            GestorMensajes.error("El libro con ID $id no está disponible para préstamo.")
        }
    }

    /**
     * Registra la devolución de un libro dado su ID.
     * @param id El ID del libro.
     */
    fun devolverLibro(id: String)  {
        if (inventario.estaPrestado(id)) {
            inventario.cambiarEstadoLibro(id, EstadoLibro.DISPONIBLE)
            GestorMensajes.log("Libro devuelto con ID: $id")
        } else {
            GestorMensajes.error("El libro con ID $id ya está en el inventario.")
        }
    }
}