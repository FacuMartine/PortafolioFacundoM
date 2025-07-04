package uy.edu.ucu.aed.tdas;

public class Producto implements IProducto {
    private String nombre;
    private String etiqueta;
    private Integer precio;
    private int stock;

    public Producto(String nombre, String etiqueta, Integer precio, int stock){
        this.nombre = nombre;
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.stock = stock;
    }
    
    public String getEtiqueta() {
        return etiqueta;
    }

    public Integer getPrecio() {
        return this.precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

