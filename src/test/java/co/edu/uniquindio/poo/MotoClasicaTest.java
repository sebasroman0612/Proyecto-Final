package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MotoClasicaTest{
    public class MotoClasica extends Vehiculo{
        public MotoClasica(String placa, String modelo, String propietario) {
            super(placa, modelo, propietario);
    
        }
    }  
    @Test 
    public void MotoClasica(){
        MotoClasica moto = new MotoClasica("AUE45B", "2003", "Santiago Montolla");
        assertEquals("AUE45B", moto.getPlaca());
        assertEquals("2003", moto.getModelo());
        assertEquals("Santiago Montolla", moto.getPropietario());
    } 

    @Test
    public void datosNulos(){
        assertThrows(IllegalArgumentException.class, () -> new MotoClasica(null, "2006", "Ana Carmona"));
    }
   
   
    @Test
    public void ActualizarPropietario() {
    MotoClasica motoClasica = new MotoClasica("TEN20C", "1900", "Lina Rosas");
    motoClasica.setPropietario("Lina Rosas");
    assertEquals("Lina Rosas", motoClasica.getPropietario());
    }


    @Test
    public void RelacionPadreHijo() {
        MotoClasica motoClasica = new MotoClasica("DEF456", "1990", "Jennifer Londoño");
        assertTrue(motoClasica instanceof MotoClasica);
        assertTrue(motoClasica instanceof Vehiculo);
    }

    @Test
    public void EstablecerTarifaPorHora() {
        MotoClasica motoClasica = new MotoClasica("YEF24F", "1997", "Maria Rodriguez");
        motoClasica.setTarifaPorHora(1500);
        assertEquals(1500, motoClasica.getTarifaPorHora());
    }

    @Test
    public void ActualizarTarifaPorHora() {
        MotoClasica motoClasica = new MotoClasica("XYZ123", "2020", "Luz Gutierrez");
        motoClasica.setTarifaPorHora(5000);
        motoClasica.setTarifaPorHora(1000);
        assertEquals(1000, motoClasica.getTarifaPorHora());
    }

    @Test
    public void EstablecerTarifaPorHoraNegativa() {
        MotoClasica motoClasica = new MotoClasica("TUY56A", "1997", "Ana Maria");
        assertThrows(IllegalArgumentException.class, () -> motoClasica.setTarifaPorHora(-1500), 
                     "La tarifa por hora no puede ser negativa.");
    }


}

