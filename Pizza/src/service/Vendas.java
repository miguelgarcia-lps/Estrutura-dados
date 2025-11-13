package service;

import java.util.HashMap;
import java.util.Map;

public class Vendas {
	
	private Map<String,Integer> mapa;

    public Vendas() { mapa = new HashMap<>(); }
    public void registrar(String s) { mapa.put(s, mapa.getOrDefault(s,0)+1); }
    public void total(String s) { System.out.println(mapa.getOrDefault(s,0)); }
    public void ranking() {
        mapa.entrySet().stream()
            .sorted((a,b)->b.getValue().compareTo(a.getValue()))
            .forEach(e->System.out.println(e.getKey()+" - "+e.getValue()));
    }
    public void listarTodos() { mapa.keySet().forEach(System.out::println); }
}
