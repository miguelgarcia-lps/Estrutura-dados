package service;

import java.util.HashSet;
import java.util.Set;

public class Sabores {
	 private Set<String> lista;
	    public Sabores() { lista = new HashSet<>(); }
	    public boolean add(String s) { return lista.add(s); }
	    public boolean remove(String s) { return lista.remove(s); }
	    public boolean existe(String s) { return lista.contains(s); }
	    public void listar() { lista.forEach(System.out::println); }
}
