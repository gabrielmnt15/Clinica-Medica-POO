package clinicamedica;

import static clinicamedica.ClinicaMedica.medicos;
import java.util.Scanner;

public class Medico extends Funcionario {
    private String especializacao;

    
    public Medico(String nome, String telefone, String email, int id, double salario, int cargaHoraria, String funcao, String especializacao) {
        super(nome, telefone, email, id, salario, cargaHoraria, funcao);
        this.especializacao = especializacao;
    }

    
    public static Medico cadastrar(){
        Scanner scan = new Scanner(System.in);
        String nome;
        String telefone;
        String email;
        int id;
        double salario;
        int cargaHoraria;
        String especializacao;
        
        System.out.println("Cadastro de Médico: ");
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
        System.out.println("Especialização: ");
        especializacao = scan.next();
        Medico medic = new Medico(nome, telefone, email, id, salario, cargaHoraria, "Médico", especializacao);
        return medic;
    }

    
    @Override
    public void editar(){
        Scanner scan = new Scanner(System.in);
        super.editar();
        System.out.println("Especialização: ");
        String especializacao = scan.next();
        this.especializacao = especializacao;
    }
    
    
    public static Medico buscarMedico(int id){
        Medico medico = null;
        for(int i = 0; i < medicos.size(); i++){
            if(id == medicos.get(i).getId()){
                medico = medicos.get(i);
                break;
            }
        }
        return medico;
    }
    
    
    @Override
    public void exibirFormatado(){
        System.out.printf("Id: %d Nome: %s Função: %s Especialização: %s\n", this.id, this.nome, this.funcao, this.especializacao);
    }
    
    
    // Getters e Setters
    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}
