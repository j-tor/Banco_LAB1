/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aleja
 */
public class Banco {

    private CuentaBancaria[] cuentas;
    private static final double tasaInteres = 0.05; 

    public Banco(int capacidad) {
        cuentas = new CuentaBancaria[capacidad];
    }

    public CuentaBancaria buscar(int codigo) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta != null && cuenta.getCodigo() == codigo) {
                return cuenta;
            }
        }
        return null;
    }

    public boolean agregar(int codigo, String nombre) {
        if (buscar(codigo) != null) {
         
            return false;
        }

        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = new CuentaBancaria(codigo, nombre);
                return true;
            }
        }

        return false;
    }

    public boolean transferir(int origen, int destino, double monto) {
        CuentaBancaria cuentaOrigen = buscar(origen);
        CuentaBancaria cuentaDestino = buscar(destino);

        if (cuentaOrigen != null && cuentaDestino != null && cuentaOrigen.retirar(monto)) {
            cuentaDestino.depositar(monto);
            return true;
        }

        return false;
    }

    public void intereses() {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta != null) {
                double interesMensual = cuenta.getSaldo() * tasaInteres;
                cuenta.depositar(interesMensual);
            }
        }
    }

    public void lista(double montoMinimo) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta != null && cuenta.getSaldo() >= montoMinimo) {
                System.out.println(cuenta);
            }
        }
    }

}
