package service;

import Model.Pedido;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pedidos {
	private List<Pedido> lista;

    public Pedidos() { lista = new ArrayList<>(); }
    public void add(Pedido p) { lista.add(p); }
    public void listar() { lista.forEach(System.out::println); }
    public Pedido buscar(int num) {
        for (Pedido p : lista) { if (p.getNum() == num) return p; }
        return null;
    }
    public void ordenarValor() { Collections.sort(lista, Comparator.comparingDouble(Pedido::getValor)); }
    public void ordenarCliente() { Collections.sort(lista, Comparator.comparing(Pedido::getCliente)); }
	
}
