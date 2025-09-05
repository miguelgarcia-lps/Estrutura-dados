// ------------------------------ OrdenaProdutos ------------------------------
package controle;

import java.util.Scanner;

public class OrdenaProdutos {
    public static void main(String[] args) {
        // Criamos o Scanner para capturar as entradas do usuário
        Scanner leitor = new Scanner(System.in);
        String[] nomesDosProdutos = new String[10];  // Lista para guardar os nomes dos produtos
        double[] precosDosProdutos = new double[10];  // Lista para guardar os preços dos produtos

        // Solicitamos ao usuário que digite os nomes e preços
        System.out.println("Por favor, insira o nome e o preço de 10 produtos:");
        for (int i = 0; i < 10; i++) {  // Repetimos esse processo para 10 produtos
            System.out.print("Digite o nome do produto " + (i + 1) + ": ");
            nomesDosProdutos[i] = leitor.nextLine();  // Captura o nome do produto
            System.out.print("Agora, informe o preço do produto " + (i + 1) + ": ");
            precosDosProdutos[i] = leitor.nextDouble();  // Captura o preço do produto
            leitor.nextLine();  // Limpa a linha deixada pelo nextDouble()
        }

        // Organizando os produtos pelo preço de forma decrescente (Bubble Sort)
        for (int i = 0; i < precosDosProdutos.length - 1; i++) {  // Percorre todos os preços
            for (int j = 0; j < precosDosProdutos.length - i - 1; j++) {  // Compara preços adjacentes
                if (precosDosProdutos[j] < precosDosProdutos[j + 1]) {  // Se o preço da posição j for menor que o j+1, troca
                    double precoTemporario = precosDosProdutos[j];  // Armazena o preço temporariamente
                    precosDosProdutos[j] = precosDosProdutos[j + 1];  // Troca os preços
                    precosDosProdutos[j + 1] = precoTemporario;

                    // Agora, trocamos os nomes dos produtos para que fiquem na ordem correta
                    String nomeTemporario = nomesDosProdutos[j];
                    nomesDosProdutos[j] = nomesDosProdutos[j + 1];
                    nomesDosProdutos[j + 1] = nomeTemporario;
                }
            }
        }

        // Exibimos os produtos ordenados do mais caro para o mais barato
        System.out.println("\nAqui estão os produtos organizados do mais caro para o mais barato:");
        for (int i = 0; i < 10; i++) {  // Mostramos a lista dos produtos organizados
            System.out.println(nomesDosProdutos[i] + " - R$ " + String.format("%.2f", precosDosProdutos[i]));
        }

        leitor.close();  // Fechamos o Scanner após o uso
    }
}

// ------------------------------ ControlePessoas ------------------------------
package controle;

import dominio.Pessoa;
import java.util.Scanner;

public class ControlePessoas {
    private Pessoa[] listaDePessoas;  // Lista para armazenar as pessoas cadastradas
    private Scanner leitor;  // Scanner para ler as entradas do usuário

    public ControlePessoas() {
        listaDePessoas = new Pessoa[5];  // Definimos que vamos cadastrar 5 pessoas
        leitor = new Scanner(System.in);  // Inicializamos o Scanner
    }

    public void cadastrarPessoas() {
        System.out.println("Vamos cadastrar 5 pessoas:");
        for (int i = 0; i < listaDePessoas.length; i++) {  // Laço para cadastrar as 5 pessoas
            System.out.println("\nPessoa " + (i + 1));  // Exibimos o número da pessoa
            System.out.print("Digite o nome: ");
            String nome = leitor.nextLine();  // Lemos o nome da pessoa
            System.out.print("Digite a idade: ");
            int idade = leitor.nextInt();  // Lemos a idade da pessoa
            System.out.print("Digite a altura (em metros): ");
            double altura = leitor.nextDouble();  // Lemos a altura da pessoa
            leitor.nextLine();  // Limpamos a linha que sobra após o nextDouble()
            listaDePessoas[i] = new Pessoa(nome, idade, altura);  // Criamos um novo objeto Pessoa e o adicionamos na lista
        }
    }

    public void mostrarMenu() {
        System.out.println("\nEscolha o tipo de ordenação:");
        System.out.println("1 - Ordenar por nome (alfabético)");
        System.out.println("2 - Ordenar por idade (do mais jovem ao mais velho)");
        System.out.println("3 - Ordenar por altura (do mais baixo ao mais alto)");
        System.out.print("Digite sua opção: ");
        int opcao = leitor.nextInt();  // Capturamos a opção do usuário

        // Dependendo da opção escolhida, ordenamos de uma forma ou de outra
        switch (opcao) {
            case 1:
                ordenarPorNome();  // Ordena por nome
                break;
            case 2:
                ordenarPorIdade();  // Ordena por idade
                break;
            case 3:
                ordenarPorAltura();  // Ordena por altura
                break;
            default:
                System.out.println("Opção inválida!");  // Caso a opção seja inválida
                return;
        }

        listarPessoas();  // Exibimos a lista de pessoas ordenadas
    }

    // Ordena as pessoas por nome (alfabeticamente) utilizando Bubble Sort
    private void ordenarPorNome() {
        for (int i = 0; i < listaDePessoas.length - 1; i++) {
            for (int j = 0; j < listaDePessoas.length - i - 1; j++) {
                if (listaDePessoas[j].getNome().compareToIgnoreCase(listaDePessoas[j + 1].getNome()) > 0) {
                    Pessoa pessoaTemporaria = listaDePessoas[j];
                    listaDePessoas[j] = listaDePessoas[j + 1];
                    listaDePessoas[j + 1] = pessoaTemporaria;
                }
            }
        }
    }

    // Ordena as pessoas por idade (do mais jovem ao mais velho)
    private void ordenarPorIdade() {
        for (int i = 0; i < listaDePessoas.length - 1; i++) {
            for (int j = 0; j < listaDePessoas.length - i - 1; j++) {
                if (listaDePessoas[j].getIdade() > listaDePessoas[j + 1].getIdade()) {
                    Pessoa pessoaTemporaria = listaDePessoas[j];
                    listaDePessoas[j] = listaDePessoas[j + 1];
                    listaDePessoas[j + 1] = pessoaTemporaria;
                }
            }
        }
    }

    // Ordena as pessoas por altura (do mais baixo ao mais alto)
    private void ordenarPorAltura() {
        for (int i = 0; i < listaDePessoas.length - 1; i++) {
            for (int j = 0; j < listaDePessoas.length - i - 1; j++) {
                if (listaDePessoas[j].getAltura() > listaDePessoas[j + 1].getAltura()) {
                    Pessoa pessoaTemporaria = listaDePessoas[j];
                    listaDePessoas[j] = listaDePessoas[j + 1];
                    listaDePessoas[j + 1] = pessoaTemporaria;
                }
            }
        }
    }

    // Exibe a lista de pessoas cadastradas
    private void listarPessoas() {
        System.out.println("\nAqui estão as pessoas cadastradas:");
        for (Pessoa pessoa : listaDePessoas) {
            System.out.println(pessoa);  // Chama automaticamente o método toString da classe Pessoa
        }
    }
}

// ------------------------------ Pessoa ------------------------------
package dominio;

public class Pessoa {
    private String nome;  // Nome da pessoa
    private int idade;  // Idade da pessoa
    private double altura;  // Altura da pessoa

    public Pessoa(String nome, int idade, double altura) {  // Construtor que inicializa os dados
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    // Métodos de acesso (getters) para obter os valores dos atributos
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    // Método que formata a saída dos dados de uma pessoa
    @Override
    public String toString() {
        return String.format("Nome: %s | Idade: %d | Altura: %.2f m", nome, idade, altura);
    }
}

// ------------------------------ Principal ------------------------------
import controle.ControlePessoas;

public class Principal {
    public static void main(String[] args) {
        ControlePessoas controle = new ControlePessoas();  // Criamos o controle para gerenciar o cadastro
        controle.cadastrarPessoas();  // Chama o método para cadastrar as 5 pessoas
        controle.mostrarMenu();  // Exibe o menu de opções para o usuário escolher como ordenar as pessoas
    }
}

// ------------------------------ OrdenarNumeros ------------------------------
package controle;

import java.util.Scanner;

public class OrdenarNumeros {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] listaDeNumeros = new int[10];  // Lista para armazenar os 10 números inteiros

        System.out.println("Por favor, insira 10 números inteiros:");
        for (int i = 0; i < listaDeNumeros.length; i++) {
            listaDeNumeros[i] = leitor.nextInt();  // Lê o número informado pelo usuário
        }

        // Organiza os números em ordem crescente usando o algoritmo Bubble Sort
        for (int i = 0; i < listaDeNumeros.length - 1; i++) {
            for (int j = 0; j < listaDeNumeros.length - i - 1; j++) {
                if (listaDeNumeros[j] > listaDeNumeros[j + 1]) {  // Se o número da posição j for maior que o próximo, troca
                    int numeroTemporario = listaDeNumeros[j];
                    listaDeNumeros[j] = listaDeNumeros[j + 1];
                    listaDeNumeros[j + 1] = numeroTemporario;
                }
            }
        }

        // Exibe os números organizados em ordem crescente
        System.out.println("Aqui estão os números em ordem crescente:");
        for (int numero : listaDeNumeros) {
            System.out.print(numero + " ");  // Exibe cada número na lista ordenada
        }

        leitor.close();  // Fecha o Scanner
    }
}
