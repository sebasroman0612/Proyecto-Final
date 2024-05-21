package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private String propietario;
    private double tarifaPorHora;
    private Map<LocalDate, Double> gananciasDiarias;

    public Vehiculo(String placa, String modelo, String propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
        this.gananciasDiarias = new HashMap<>();
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPropietario() {
        return propietario;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    public void registrarPago(LocalDate fecha, double monto) {
        gananciasDiarias.put(fecha, gananciasDiarias.getOrDefault(fecha, 0.0) + monto);
    }

    public double obtenerGananciasPorFecha(LocalDate fecha) {
        return gananciasDiarias.getOrDefault(fecha, 0.0);
    }

    public double obtenerGananciasPorMes(YearMonth fecha) {
        double gananciasDelMes = 0.0;
        for (LocalDate fechaDia : gananciasDiarias.keySet()) {
            if (YearMonth.from(fechaDia).equals(fecha)) {
                gananciasDelMes += gananciasDiarias.get(fechaDia);
            }
        }
        return gananciasDelMes;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Modelo: " + modelo + ", Propietario: " + propietario;
    }
}
