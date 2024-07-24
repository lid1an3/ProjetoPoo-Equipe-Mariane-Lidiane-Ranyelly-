import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario {
    private String nome;
    private double quantiaPorHora;
    private int horas;

    public Funcionario(String nome, int horas, double quantiaPorHora) {
        this.nome = nome;
        this.quantiaPorHora = quantiaPorHora;
        this.horas = horas;
    }

    public String getNome() {
        return nome;
    }

    public double pagamento() {
        return horas * quantiaPorHora;
    }
}

class Terceirizado extends Funcionario {
    private double adicional;

    public Terceirizado(String nome, int horas, double quantiaPorHora, double adicional) {
        super(nome, horas, quantiaPorHora);
        this.adicional = adicional;
    }
    
    public double pagamento() {
        double pagamentoBase = super.pagamento() + adicional;
        return pagamentoBase * 2.10; 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        System.out.print("Exponha a quantidade de funcionários: ");
        int N = scanner.nextInt();
        

        for (int i = 0; i < N; i++) {
            System.out.print("Primeiro Nome: ");
            String nome = scanner.next();
            System.out.print("Qual a quantia por hora: ");
            double valorPorHora = scanner.nextDouble();
            System.out.print("Quantidade de horas trabalhada: ");
            int horas = scanner.nextInt();
            System.out.print(" Funcionario Terceirizado sim/não? ");
            char tipo = scanner.next().charAt(0);

            if (tipo == 's' || tipo == 'S') {
                double adicional = 0.0;
                boolean entradaValida = false;

                while (entradaValida) {
                    System.out.print("Adicional: ");
                    if (scanner.hasNextDouble()) {
                        adicional = scanner.nextDouble();
                        entradaValida = true;
                    } else {
                       
                    }
                }

                funcionarios.add(new Terceirizado(nome, horas, valorPorHora, adicional));
            } else {
                funcionarios.add(new Funcionario(nome, horas, valorPorHora));
            }
        }

        System.out.println("\nVALOR FINAL:");
        for (Funcionario emp : funcionarios) {
System.out.println("R$ " + String.format("%.2f",emp.pagamento()));
            System.out.println("A pontualidade do funcionário fala qual profissional ele é, não se atrase!");
        }

        scanner.close();
    }
}
