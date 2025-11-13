package service;

import Model.Pedido;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Comparator;

public class Entrega {
	private Queue<Pedido> fila;
    private PriorityQueue<Pedido> prioridade;
    private Stack<Pedido> cancelados;

    public Entrega() {
        fila = new LinkedList<>();
        prioridade = new PriorityQueue<>(Comparator.comparingInt(Pedido::getTempo));
        cancelados = new Stack<>();
    }

    public void addFila(Pedido p) { fila.add(p); }
    public Pedido entregarFila() { return fila.poll(); }
    public Pedido proximoFila() { return fila.peek(); }
    public boolean vaziaFila() { return fila.isEmpty(); }

    public void addPrioridade(Pedido p) { prioridade.add(p); }
    public Pedido entregarPrioridade() { return prioridade.poll(); }

    public void cancelar(Pedido p) { cancelados.push(p); }
    public Pedido recuperar() { return cancelados.pop(); }
    public Pedido ultimoCancelado() { return cancelados.peek(); }
	
}
