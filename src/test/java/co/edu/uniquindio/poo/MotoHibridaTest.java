package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MotoHibridaTest{
    public class MotoHibrida extends Vehiculo{
        public MotoHibrida(String placa, String modelo, String propietario) {
            super(placa, modelo, propietario);
    
        }
    }  
    @Test 
    public void MotoHibrida(){
        MotoHibrida moto = new MotoHibrida("ACB23C", "2024", "Sebastian Niño");
        assertEquals("ACB23C", moto.getPlaca());
        assertEquals("2024", moto.getModelo());
        assertEquals("Sebastian Niño", moto.getPropietario());
    } 
     @Test
    public void datosNulos(){
        assertThrows(IllegalArgumentException.class, () -> new MotoHibrida("AEB28E", null, "Vanesa Rodriguez"));
    }

    @Test
    public void ActualizarPropietario() {
    MotoHibrida motoHibrida = new MotoHibrida("VEN12A", "2025", "Marcela Toro");
    motoHibrida.setPropietario("Marcela Toro");
    assertEquals("Marcela Toro", motoHibrida.getPropietario());
    }


    @Test
    public void RelacionPadreHijo() {
        MotoHibrida motoHibrida = new MotoHibrida("GEN66E", "2022", "Camila Ruiz");
        assertTrue(motoHibrida instanceof MotoHibrida);
        assertTrue(motoHibrida instanceof Vehiculo);
    }

    @Test
    public void EstablecerTarifaPorHora() {
        MotoHibrida motoHibrida = new MotoHibrida("ASE65A", "2024", "Liliana Puerto");
        motoHibrida.setTarifaPorHora(2000);
        assertEquals(2000, motoHibrida.getTarifaPorHora());
    }

    @Test
    public void ActualizarTarifaPorHora() {
        MotoHibrida motoHibrida = new MotoHibrida("XYZ123", "2023", "Anastasia Melo");
        motoHibrida.setTarifaPorHora(2000);
        motoHibrida.setTarifaPorHora(1800);
        assertEquals(1800, motoHibrida.getTarifaPorHora());
    }

    @Test
    public void EstablecerTarifaPorHoraNegativa() {
        MotoHibrida motoHibrida = new MotoHibrida("MAR22A", "2024", "Claudia Ron");
        assertThrows(IllegalArgumentException.class, () -> motoHibrida.setTarifaPorHora(-2000), 
                     "La tarifa por hora no puede ser negativa.");
    }

}