package uy.edu.ucu.aed.tdas;

import java.util.Arrays;

public class Almacen implements IAlmacen {
    private String direccion;
    private String telefono;
    private String nombre;
    private Lista<Producto> listaProductos;

    public Almacen(String direccion, String telefono, String nombre) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        this.listaProductos = new Lista<Producto>();
    }

    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Lista<Producto> getListaProductos() {
        return this.listaProductos;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        if (buscarPorCodigo(unProducto.getEtiqueta()) == null) {
            listaProductos.insertar(unProducto, unProducto.getEtiqueta());
        }
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return listaProductos.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        return listaProductos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return listaProductos.imprimir(separador);
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Producto producto = buscarPorCodigo(clave);
        if (producto != null) {
            producto.setStock(producto.getStock() + cantidad);
            return true;
        }
        return false;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        Producto producto = buscarPorCodigo(clave);
        if (producto != null) {
            Integer nuevoStock = Math.max(0, producto.getStock() - cantidad);
            Integer restado = producto.getStock() - nuevoStock;
            producto.setStock(nuevoStock);
            return restado;
        }
        return null;    
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        return listaProductos.buscar(clave);
    }

    @Override
    public int cantidadProductos() {
        return listaProductos.cantElementos();
    }

    @Override
    public void listarOrdenadoPorNombre() {
        String productosPorEtiqueta = listaProductos.imprimir(",");
        String[] arrayEtiquetas = productosPorEtiqueta.split(",");
        Producto[] productos = new Producto[arrayEtiquetas.length];
        for (int i = 0; i < arrayEtiquetas.length; i++) {
            Comparable codigo = arrayEtiquetas[i];
            productos[i] = buscarPorCodigo(codigo);
        }
        Arrays.sort(productos, (p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
        for (Producto producto : productos) {
            System.out.println(producto.getEtiqueta() + " " + producto.getNombre() + " " + producto.getPrecio() + " " + producto.getStock());
        }
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        return null;
    }

   
}

