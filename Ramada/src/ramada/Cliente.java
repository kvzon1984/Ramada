/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramada;

/**
 *
 * @author Nicolas Zuñiga
 */
public class Cliente {

    private String rut;
    private String nombre;
    private int edad;
    private char sexo;
    private char tipoCliente;

    public Cliente() {
    }

    public Cliente(String rut, String nombre, int edad, char sexo, char tipoCliente) {
        this.setRut(rut);
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setSexo(sexo);
        this.setTipoCliente(tipoCliente);

    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (rut.length() < 7 || rut.length() > 10) {
            throw new IllegalArgumentException("El rut ingresado es INVALIDO");
        }
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() < 3 || nombre.length() > 25) {
            throw new IllegalArgumentException("El nombre debe tener entre 3 y 25 caracteres.");
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 14 || edad > 130) {
            throw new IllegalArgumentException("Ingrese una edad valida");
        }
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(char tipoCliente) {
        
         if(tipoCliente != 'N' && tipoCliente != 'V' && tipoCliente != 'F') {
            throw new IllegalArgumentException("El tipo de cliente solo puede ser N, V o F");
        }
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "rut=" + rut + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", tipoCliente=" + tipoCliente + '}';
    }

    public void imprimir() {
        String tipocliente = "";
        if (this.getTipoCliente() == 'N') {
            tipocliente = "Normal ";

        } else if (this.getTipoCliente() == 'V') {
            tipocliente = "Vip";
        } else if (this.getTipoCliente() == 'F') {
            tipocliente = "Frecuente";
        }

        System.out.println("               CLIENTE");
        System.out.println("_________________________________________________");
        System.out.println("       " + this.getRut() + "    " + this.getNombre() + "  Cliente: " + tipocliente);
        System.out.println("-------------------------------------------------");

    }
}
