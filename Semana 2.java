VendaProduto[] vendas = new VendaProduto[5];

for (int i = 0; i < vendas.length; i++) {
    System.out.println("\nVenda " + (i + 1));

    System.out.print("Número da venda: ");
    int numero = sc.nextInt();

    System.out.print("Quantidade: ");
    int quantidade = sc.nextInt();

    System.out.print("Valor unitário: ");
    double valorUnitario = sc.nextDouble();

    vendas[i] = new VendaProduto(numero, quantidade, valorUnitario);
}

System.out.println("\nLista de vendas:");
for (int i = 0; i < vendas.length; i++) {
    System.out.println("Venda " + (i + 1));
    System.out.println("Número: " + vendas[i].getNumero());
    System.out.println("Quantidade: " + vendas[i].getQuantidade());
    System.out.println("Valor unitário: " + vendas[i].getValorUnitario());
    System.out.println("Total: " + vendas[i].valorPagar());
}
