package Model;

public class Pedido {
	    private int num;
	    private String cliente;
	    private String sabor;
	    private String tamanho;
	    private double valor;
	    private int tempo;

	    public Pedido(int num, String cliente, String sabor, String tamanho, double valor, int tempo) {
	        this.num = num;
	        this.cliente = cliente;
	        this.sabor = sabor;
	        this.tamanho = tamanho;
	        this.valor = valor;
	        this.tempo = tempo;
	    }

	    public int getNum() { return num; }
	    public String getCliente() { return cliente; }
	    public String getSabor() { return sabor; }
	    public String getTamanho() { return tamanho; }
	    public double getValor() { return valor; }
	    public int getTempo() { return tempo; }

	    @Override
	    public String toString() {
	        return "Pedido{" +
	                "num=" + num +
	                ", cliente='" + cliente + '\'' +
	                ", sabor='" + sabor + '\'' +
	                ", tamanho='" + tamanho + '\'' +
	                ", valor=" + valor +
	                ", tempo=" + tempo +
	                '}';
	    }
}
