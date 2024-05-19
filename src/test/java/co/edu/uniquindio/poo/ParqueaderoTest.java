
package co.edu.uniquindio.poo;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;



/**
 * Unit test for simple App.
 */

 public class VeterinariaTest {
    private static final Logger LOG = Logger.getLogger(MascotaTest.class.getName());


    @Test
    public void datosCompletos() {
        LOG.info("Inicio datosCompletos");

        var veterinaria = new Veterinaria("Peluditos");

        assertEquals("Peluditos", veterinaria.getNombre());

        LOG.info("Finalizando datosCompletos");

    }


    @Test
    public void agregarMascota() {
        LOG.info("Iniciando agergarMascota");

        var veterinaria = new Veterinaria("Peluditos");
        var mascota = new Mascota(1424, "Tom", Especie.GATO, Raza.ANGORA, 6, Genero.MACHO, Color.GRIS, 10);

        veterinaria.agregarMascota(mascota);

        assertTrue(veterinaria.getMascotas().contains(mascota));
        assertEquals(1, veterinaria.getMascotas().size());

        LOG.info("Finalizando agregarMascota");
    }

    @Test
    public void datosNulos() {
        LOG.info("Iniciando datosNulos");
        assertThrows(Throwable.class, () -> new Veterinaria(null));
        LOG.info("Finalizando datoNulos");
    }

    @Test
    public void agregarMascotaRepetida() {
        LOG.info("Iniciando agregarMascotaRepetida");
        var veterinaria = new Veterinaria("Peluditos");
        var mascota1 = new Mascota(1424, "Tom", Especie.GATO, Raza.ANGORA, 6, Genero.MACHO, Color.GRIS, 10);
        var mascota2 = new Mascota(1424, "Max", Especie.PERRO, Raza.PASTOR_ALEMAN, 5, Genero.MACHO, Color.NEGRO, 14);

        veterinaria.agregarMascota(mascota1);
        assertThrows(Throwable.class, () -> veterinaria.agregarMascota(mascota2));

        LOG.info("Finalizando agregarMascotaRepetida");

    }


    @Test
    public void obtenerListadoAlfabetico() {
        LOG.info("Iniciando obtenerListadoAlfabetico");

        var veterinaria = new Veterinaria("Peluditos");
        var Estrella = new Mascota(2314, "Estrella", Especie.REPTIL, Raza.OTRO, 1, Genero.HEMBRA, Color.OTRO, 2);
        var Arenita = new Mascota(2324, "Arenita", Especie.HAMSTER, Raza.OTRO, 2, Genero.HEMBRA, Color.BLANCO, 1);
        var Tom = new Mascota(3424, "Tom", Especie.GATO, Raza.ANGORA, 6, Genero.MACHO, Color.GRIS, 10);
        var Max = new Mascota(2498, "Max", Especie.PERRO, Raza.PASTOR_ALEMAN, 5, Genero.MACHO, Color.NEGRO, 14);

        veterinaria.agregarMascota(Estrella);
        veterinaria.agregarMascota(Arenita);
        veterinaria.agregarMascota(Tom);
        veterinaria.agregarMascota(Max);

        Collection<Mascota> listaEsperada = List.of(Tom, Max, Estrella, Arenita);

        assertIterableEquals(listaEsperada, veterinaria.getListadoAlfabetico());
        LOG.info("Finalizando obtenerListadoAlfabetico");
    }

    @Test
    public void obtenerListadoEdadDescendente() {
        LOG.info("Iniciando obtenerListadoEdadDescendente");

        var veterinaria = new Veterinaria("Peluditos");
        var Estrella = new Mascota(5314, "estrella", Especie.REPTIL, Raza.OTRO, 1, Genero.HEMBRA, Color.OTRO, 2);
        var Arenita = new Mascota(4324, "arenita", Especie.HAMSTER, Raza.OTRO, 2, Genero.HEMBRA, Color.BLANCO, 1);
        var Tom = new Mascota(1424, "Tom", Especie.GATO, Raza.ANGORA, 6, Genero.MACHO, Color.GRIS, 10);
        var Max = new Mascota(2498, "Max", Especie.PERRO, Raza.PASTOR_ALEMAN, 5, Genero.MACHO, Color.NEGRO, 14);

        veterinaria.agregarMascota(Estrella);
        veterinaria.agregarMascota(Arenita);
        veterinaria.agregarMascota(Tom);
        veterinaria.agregarMascota(Max);

        var listaEsperada = List.of(Tom, Max, Arenita, Estrella);
        assertIterableEquals(listaEsperada, veterinaria.getListadoedadDescendente());

        LOG.info("Finalizando obtenerListadoEdadDescendente");

    }

    @Test
    public void obtenerListadoMayoresEdad() {
        LOG.info("Iniciando obtenerListadoMayoresedad");

        var veterinaria = new Veterinaria("Peluditos");
        var Estrella = new Mascota(5314, "estrella", Especie.REPTIL, Raza.OTRO, 1, Genero.HEMBRA, Color.OTRO, 2);
        var Arenita = new Mascota(4324, "arenita", Especie.HAMSTER, Raza.OTRO, 2, Genero.HEMBRA, Color.BLANCO, 1);
        var Tom = new Mascota(1424, "Tom", Especie.GATO, Raza.ANGORA, 6, Genero.MACHO, Color.GRIS, 10);
        var Max = new Mascota(2498, "Max", Especie.PERRO, Raza.PASTOR_ALEMAN, 5, Genero.MACHO, Color.NEGRO, 14);

        veterinaria.agregarMascota(Estrella);
        veterinaria.agregarMascota(Arenita);
        veterinaria.agregarMascota(Tom);
        veterinaria.agregarMascota(Max);

        Collection<Mascota> listaEsperada = List.of(Tom, Max);
        assertIterableEquals(listaEsperada, veterinaria.getListadoMayoresEdad());
        LOG.info("Finalizando obtenerListadoMayoresEdad");
    }



 }


