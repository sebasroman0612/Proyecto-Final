package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CarroTest {
    public class Carro extends Vehiculo {
        public Carro(String placa, String modelo, String propietario) {
            super(placa, modelo, propietario);
        }
    }

    @Test
    public void testCarro() {
        Carro carro = new Carro("XYT67A", "2015", "Alejandro Murillo");
        assertEquals("XYT67A", carro.getPlaca());
        assertEquals("2015", carro.getModelo());
        assertEquals("Alejandro Murillo", carro.getPropietario());
    }
     @Test
    public void datosNulos(){
        assertThrows(IllegalArgumentException.class, () -> new Carro("EJT12A", "1986",null));
    }





    @Test
    public void RelacionPadreHijo() {
        Carro carro = new Carro("DEF456", "1990", "Jennifer Londoño");
        assertTrue(carro instanceof Carro);
        assertTrue(carro instanceof Vehiculo);
    }

    @Test
    public void EstablecerTarifaPorHora() {
        Carro carro = new Carro("ASS98A", "2009", "Jimena Perez");
        carro.setTarifaPorHora(4000);
        assertEquals(4000, carro.getTarifaPorHora());
    }

    @Test
    public void ActualizarTarifaPorHora() {
        Carro carro = new Carro("XYZ123", "2020", "Luz Gutierrez");
        carro.setTarifaPorHora(3000);
        carro.setTarifaPorHora(5000);
        assertEquals(5000, carro.getTarifaPorHora());
    }

}