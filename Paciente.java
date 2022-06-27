package clinicamedica;

import static clinicamedica.ClinicaMedica.pacientes;
import java.util.Scanner;

public class Paciente extends Pessoa {
    private int cpf;
    private String endereco;
    private int idade;
    private String sexo;

    
    public Paciente(String nome, String telefone, String email, int cpf, String endereco, int idade, String sexo) {
        super(nome, telefone, email);
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    
    public static Paciente cadastrar(){
        Scanner scan = new Scanner(System.in);
        String nome;
        String telefone;
        String email;
        int cpf;
        String endereco;
        int idade;
        String sexo;
        
        System.out.println("Cadastro de Paciente: ");
        System.out.println("Nome: ");
        nome = scan.nextLine();
        System.out.println("Telefone: ");
        telefone = scan.next();
        System.out.println("E-mail: ");
        email = scan.next();
        System.out.println("CPF: ");
        cpf = scan.nextInt();
        System.out.println("Endereço: ");
        endereco = scan.nextLine();
        System.out.println("Idade: ");
        idade = scan.nextInt();
        System.out.println("Sexo");
        sexo = scan.next();
        Paciente paci = new Paciente(nome, telefone, email, cpf, endereco, idade, sexo); 
        return paci;
    }
    
    
    public void editar(){
        Scanner scan = new Scanner(System.in);
        String nome;
        String telefone;
        String email;
        String endereco;
        int idade;
        String sexo;
        
        System.out.println("Novo Cadastro: ");
        System.out.println("Nome: ");
        nome = scan.nextLine();
        System.out.println("Telefone: ");
        telefone = scan.next();
        System.out.println("E-mail: ");
        email = scan.next();
        System.out.println("Endereço: ");
        endereco = scan.nextLine();
        System.out.println("Idade: ");
        idade = scan.nextInt();
        System.out.println("Sexo: ");
        sexo = scan.next();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    
    public static Paciente buscarPaciente(int cpf){
        Paciente paciente = null;
        for(int i = 0; i < pacientes.size(); i++){
            if(cpf == pacientes.get(i).getCpf()){
                paciente = pacientes.get(i);
                break;
            }
        }
        return paciente;
    }
    
    
    public void exibirFormatado(){
        System.out.printf("CPF: %s Nome: %s Idade: %d Sexo: %s\n", this.cpf, this.nome, this.idade, this.sexo);
    }
    
    // Getters e Setters
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
