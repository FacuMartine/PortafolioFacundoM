package uy.edu.ucu.aed.tdas;

public class Lista<T> implements ILista<T> {

    private class Nodo<T> {

        private final Comparable etiqueta;
        private T dato;
        private Nodo<T> siguiente = null;
    
        public Nodo(Comparable etiqueta, T dato ) {
            this.etiqueta = etiqueta;
            this.dato = dato;
        }
    }

    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public Lista() {
        primero = null;
        ultimo = null;
    }

    @Override
    public void insertar(T dato, Comparable etiqueta ) {
        Nodo<T> nodo = new Nodo<T>(etiqueta, dato);
        if (esVacia()) {
            primero = nodo;
            ultimo = nodo;
            return;
        }
        ultimo.siguiente = nodo;
        ultimo = nodo;
    }

    @Override
    public T buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        }
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.etiqueta.compareTo(clave) == 0) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.etiqueta.compareTo(clave) == 0) {
            primero = primero.siguiente;
            return true;
        }
        Nodo<T> actual = primero;
        while (actual.siguiente != null) {
            if (actual.siguiente.etiqueta.compareTo(clave) == 0) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public String imprimir() {
        String resultado = "";
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado += actual.etiqueta.toString();
            actual = actual.siguiente;
        }
        return resultado;
    }

    @Override
    public String imprimir(String separador) {
        String resultado = "";
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado += actual.etiqueta;
            if (actual.siguiente != null) {
                resultado += separador; 
            }
            actual = actual.siguiente;
        }
        return resultado;
    }

    @Override
    public int cantElementos() {
        int resultado = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado++;
            actual = actual.siguiente;
        }
        return resultado;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }
}
