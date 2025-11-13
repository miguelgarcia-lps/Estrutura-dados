package App;


import Model.Pedido;
import service.*;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
        Sabores sabores = new Sabores();
        Pedidos pedidos = new Pedidos();
        Entrega entrega = new Entrega();
        Vendas vendas = new Vendas();

        sabores.add("Calabresa");
        sabores.add("Mussarela");
        sabores.add("Portuguesa");
        sabores.listar();

        Random r = new Random();
        Pedido p1 = new Pedido(1,"João","Calabresa","M",35.0,r.nextInt(30));
        Pedido p2 = new Pedido(2,"Maria","Mussarela","G",40.0,r.nextInt(30));
        Pedido p3 = new Pedido(3,"Carlos","Portuguesa","P",25.0,r.nextInt(30));

        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);

        pedidos.listar();
        pedidos.ordenarValor();
        pedidos.listar();

        entrega.addFila(p1);
        entrega.addFila(p2);
        entrega.addPrioridade(p3);

        entrega.entregarFila();
        entrega.entregarPrioridade();

        entrega.cancelar(p2);
        entrega.ultimoCancelado();

        vendas.registrar(p1.getSabor());
        vendas.registrar(p1.getSabor());
        vendas.registrar(p2.getSabor());
        vendas.ranking();
    }
}
