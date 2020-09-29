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
public class Venta {

    private int cantidadProductos;
    private char tipoProducto;
    private int propina;
    private Cliente cliente;

    public Venta() {
    }

    public Venta(int cantidadProductos, char tipoProducto, int propina, Cliente cliente) {
        this.setCantidadProductos(cantidadProductos);
        this.setTipoProducto(tipoProducto);
        this.setPropina(propina);
        this.setCliente(cliente);

    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        if (cantidadProductos < 1) {
            throw new IllegalArgumentException("La cantidad debe ser minima de 1");
        }
        this.cantidadProductos = cantidadProductos;
    }

    public char getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(char tipoProducto) {

//        if (tipoProducto.equals("E") == false
//                && tipoProducto.equals("T") == false
//                && tipoProducto.equals("A") == false) {

        
        this.tipoProducto = tipoProducto;
    }

    public int getPropina() {
        return propina;
    }

    public void setPropina(int propina) {
        this.propina = propina;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venta{" + "cantidadProductos=" + cantidadProductos + ", tipoProducto=" + tipoProducto + ", propina=" + propina + ", cliente=" + cliente + '}';
    }

    public int calcularVenta() {

//precios de los productos
// empanada= 3000 terremoto = 2000 anticucho = 5000
        float monto = 0;

        if (this.getTipoProducto()=='E'){
            monto = 3000;

        } else if (this.getTipoProducto()=='T'){
            monto = 2000;

        } else if (this.getTipoProducto()=='A'){
            monto = 5000;
        }

        monto = monto * this.getCantidadProductos();

        //descuento del cliente
        //frecuente = 5.5%  vip =3.6%  cliente normal multa = 500 
        if (this.getCliente().getTipoCliente() == 'F') {
            monto = monto * 0.945f;

        } else if (this.getCliente().getTipoCliente() == 'V') {
            monto = monto * 0.964f;
        } else if (this.getCliente().getTipoCliente() == 'N') {
            monto = monto + 500;
        }

//         descuento de edad
//         sobre 65 hasta 99 desceunto del 4%
        if (this.getCliente().getEdad() >= 65
                && this.getCliente().getEdad() <= 99) {
            monto = monto * 0.96f;
        } else if (this.getCliente().getEdad() > 99) {
            monto = 1000;

        }
        //monto = monto + this.propina;
//         agregar iva a todos los clientes incluso la tecera edad
        monto = monto * 1.19f;

        return (int) monto;

    }

    public void imprimirVenta() {
        String producto = "";
        if (this.getTipoProducto()=='E'){
            producto = "Empanada";
        }else if(this.getTipoProducto()=='T'){
            producto = "Terremoto";
        }else if (this.getTipoProducto()=='A'){
            producto ="Anticucho";
        }
        
    
        

            System.out.println("            DATOS DE VENTA");
            System.out.println("--------------------------------------");
            System.out.println("cant: " + this.getCantidadProductos() + ", Tipo de producto: " + producto + ", total a pagar: $" + this.calcularVenta());
            System.out.println("----------------------------------------");
        }

    }
