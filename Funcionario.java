package clinicamedica;

import static clinicamedica.ClinicaMedica.funcionarios;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    protected int id;
    protected double salario;
    protected int cargaHoraria;
    protected String funcao;

    
    public Funcionario(String nome, String telefone, String email, int id, double salario, int cargaHoraria, String funcao) {
        super(nome, telefone, email);
        this.id = id;
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.funcao = funcao;
    }

    
    public static Funcionario cadastrar(){
        Scanner scan = new Scanner(System.in);
        String nome;
        String telefone;
        String email;
        int id;
        double salario;
        int cargaHoraria;
        String funcao;
        
        System.out.println("Cadastro de Funcionário: ");
        System.out.println("Nome: ");
        nome = scan.nextLine();
        System.out.println("Telefone: ");
        telefone = scan.next();
        System.out.println("E-mail: ");
        email = scan.next();
        System.out.println("Número de Identificação: ");
        id = scan.nextInt();
        System.out.println("Salário: ");
        salario = scan.nextDouble();
        System.out.println("Carga Horária: ");
        cargaHoraria = scan.nextInt();
        System.out.println("Função: ");
        funcao = scan.next();
        Funcionario funcio = new Funcionario(nome, telefone, email, id, salario, cargaHoraria, funcao);
        return funcio;
    }
    
    
    public void editar(){
        Scanner scan = new Scanner(System.in);
        String nome;
        String telefone;
        String email;
        double salario;
        int cargaHoraria;
        String funcao;
        
        System.out.println("Novo Cadastro: ");
        System.out.println("Nome: ");
        nome = scan.nextLine();
        System.out.println("Telefone: ");
        telefone = scan.next();
        System.out.println("E-mail: ");
        email = scan.next();
        System.out.println("Salário: ");
        salario = scan.nextDouble();
        System.out.println("Carga Horária: ");
        cargaHoraria = scan.nextInt();
        System.out.println("Função: ");
        funcao = scan.next();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.funcao = funcao;
    }
    
    
    public void exibirFormatado(){
        System.out.printf("Id: %d Nome: %s Função: %s\n", this.id, this.nome, this.funcao);
    }

    
// Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }        
}
