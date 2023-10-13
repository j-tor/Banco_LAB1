/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aleja
 */
import java.util.Scanner;

public class CuentaBancaria {
    private final String nombreCliente;
    private double saldo;
    private final int codigo;

    public CuentaBancaria(int codigo, String nombreCliente) {
        this.codigo = codigo;
        this.nombreCliente = nombreCliente;
        this.saldo = 500.0;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre del Cliente: " + nombreCliente);
        System.out.println("Saldo de Cuenta: " + saldo);
    }

    
}
