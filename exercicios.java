package Exer1;

import java.util.Arrays;
import java.util.Scanner;

// ==============================
class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[20];
        System.out.println("Ex1 -> Digite 20 números inteiros:");
        for(int i=0;i<n.length;i++) {
            System.out.print("Número "+(i+1)+": ");
            n[i] = sc.nextInt();
        }
        int p=0,i=0;
        for(int x : n) 
            if(x%2==0) p++; 
            else i++;
        System.out.println("Pares: "+p+" Ímpares: "+i);
        sc.close();
    }
}

//============================================
class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[10];
        System.out.println("Ex2 -> Digite 10 números inteiros:");
        for(int i=0;i<n.length;i++) {
            System.out.print("Número "+(i+1)+": ");
            n[i] = sc.nextInt();
        }
        System.out.print("Digite um número para procurar: ");
        int num = sc.nextInt();
        boolean achou=false;
        for(int j=0;j<n.length;j++) 
            if(n[j]==num) {
                System.out.println("Achado na posição: "+j); 
                achou=true;
            }
        if(!achou)
            System.out.println("Não encontrado");
        sc.close();
    }
}

// =========================================
class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nomes = new String[10];
        System.out.println("Ex3 -> Digite 10 nomes:");
        for(int i=0;i<nomes.length;i++) {
            System.out.print("Nome "+(i+1)+": ");
            nomes[i] = sc.nextLine();
        }
        System.out.print("Digite um nome para remover: "); 
        String rem = sc.nextLine(); 
        boolean ok=false;
        for(int j=0;j<nomes.length;j++) 
            if(nomes[j].equalsIgnoreCase(rem)){
                nomes[j]="---"; ok=true;
            }
        System.out.println(ok?"Removido":"Não achado");
        System.out.println(Arrays.toString(nomes));
        sc.close();
    }
}

// ================================
class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[10];
        System.out.println("Ex4 -> Digite 10 números inteiros:");
        for(int i=0;i<n.length;i++) {
            System.out.print("Número "+(i+1)+": ");
            n[i] = sc.nextInt();
        }
        for(int i=0;i<n.length;i++){
            int c=0;
            for(int j=0;j<n.length;j++) 
                if(n[i]==n[j]) c++;
            System.out.println("Num "+n[i]+" aparece "+c+" vezes");
        }
        sc.close();
    }
}

// ==============================================
class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[10];
        System.out.println("Ex5 -> Digite 10 números inteiros para ordenar:");
        for(int i=0;i<n.length;i++) {
            System.out.print("Número "+(i+1)+": ");
            n[i] = sc.nextInt();
        }
        for(int i=0;i<n.length-1;i++) 
            for(int j=0;j<n.length-i-1;j++) 
                if(n[j]>n[j+1]){
                    int t=n[j]; n[j]=n[j+1]; n[j+1]=t;
                }
        System.out.println("Ordenado: "+Arrays.toString(n));
        sc.close();
    }
}
