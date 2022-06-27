package clinicamedica;

import java.util.ArrayList;
import java.util.Scanner;

public class ClinicaMedica {
    // Listas que armazenam os objetos instanciados
    static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    static ArrayList<Medico> medicos = new ArrayList<>();
    static ArrayList<Paciente> pacientes = new ArrayList<>();
    static ArrayList<Consulta> consultas = new ArrayList<>();
    
    public static void main(String[] args) {
        menu();
    }
        
    public static void menu(){
        Scanner scan = new Scanner(System.in);
        int opc;
        boolean continuar = true;
        
        while(continuar){
            System.out.println("MENU");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Editar ou Excluir");
            System.out.println("4. Marcar Consulta");
            System.out.println("Other. Sair");
            opc = scan.nextInt();
            switch(opc){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    editarExcluir();
                    break;
                case 4:
                    Consulta.marcarConsulta();
                    break;
                default:
                    System.out.println("Saindo...");
                    continuar = false;
            }
        }
    }


    // Função que chama as funções de cadastro das classes
    public static void cadastrar(){
        Scanner scan = new Scanner(System.in);
        int opc;
        
        System.out.println("CADASTRO");
        System.out.println("1. Funcionário");
        System.out.println("2. Médico");
        System.out.println("3. Paciente");
        System.out.println("Other. Cancelar");
        opc = scan.nextInt();
        switch(opc) {
            case 1:
                Funcionario funcio = Funcionario.cadastrar();
                funcionarios.add(funcio);
                break;
            case 2:
                Medico medic = Medico.cadastrar();
                medicos.add(medic);
                break;
            case 3:
                Paciente paci = Paciente.cadastrar();
                pacientes.add(paci);
                break;
            default:
                System.out.println("Cancelando...");    
        }   
    }

    
    // Função que lista os elementos das listas de forma formatada
    public static void listar(){
        Scanner scan = new Scanner(System.in);
        int opc;
        
        System.out.println("LISTAGEM");
        System.out.println("1. Funcionários e Médicos");
        System.out.println("2. Pacientes");
        System.out.println("3. Consultas");
        System.out.println("Other. Cancelar");
        opc = scan.nextInt();
        switch(opc) {
            case 1:
                for(int i = 0; i < funcionarios.size(); i++){
                    funcionarios.get(i).exibirFormatado();
                }
                for(int i = 0; i < medicos.size(); i++){
                    medicos.get(i).exibirFormatado();
                }
                break;
            case 2:
                for(int i = 0; i < pacientes.size(); i++){
                    pacientes.get(i).exibirFormatado();
                }
                break;
            case 3:
                for(int i = 0; i < consultas.size(); i++){
                    consultas.get(i).exibirFormatado();
                }
                break;
            default:
                System.out.println("Cancelando...");
        }
    }
    
    
    // Edita ou excluir objetos instanciados (Obs: ID e CPF não podem ser modificados)
    public static void editarExcluir(){
        Scanner scan = new Scanner(System.in);
        int opc;
        int opcEdEx;
        boolean naoAchou;
        
        System.out.println("Editar ou Excluir: ");
        System.out.println("1. Funcionários e Médicos");
        System.out.println("2. Pacientes");
        System.out.println("Other. Cancelar");
        opc = scan.nextInt();
        switch(opc) {
            case 1:
                naoAchou = true;
                
                // Identifcação do Funcionário via ID
                System.out.println("Forneça o ID do Funcionário: ");
                int id = scan.nextInt();
                
                // Iteração dentro da lista de Funcionários
                for(int i = 0; i < funcionarios.size(); i++){
                    if(id == funcionarios.get(i).getId()){
                        System.out.println("Funcionário: ");
                        funcionarios.get(i).exibirFormatado();
                        naoAchou = false;
                        
                        // Opções - Edição ou Exclusão
                        System.out.println("1. Editar");
                        System.out.println("2. Excluir");
                        System.out.println("3. Cancelar");
                        opcEdEx = scan.nextInt();
                        switch(opcEdEx) {
                            case 1:
                                funcionarios.get(i).editar();
                                System.out.println("Edição Concluída!");
                                break;
                            case 2:
                                funcionarios.remove(i);
                                System.out.println("Excluído com sucesso!");
                                break;
                            default:
                                System.out.println("Cancelando...");    
                        }
                        break;
                    }
                }
                // Iteração dentro da lista de Médicos 
                for(int i = 0; i < medicos.size(); i++){
                    if(id == medicos.get(i).getId()){
                        System.out.println("Médico: ");
                        medicos.get(i).exibirFormatado();
                        naoAchou = false;
                        
                        // Opções - Edição ou Exclusão
                        System.out.println("1. Editar");
                        System.out.println("2. Excluir");
                        System.out.println("3. Cancelar");
                        opcEdEx = scan.nextInt();
                        switch(opcEdEx) {
                            case 1:
                                medicos.get(i).editar();
                                System.out.println("Edição Concluída!");
                                break;
                            case 2:
                                medicos.remove(i);
                                System.out.println("Excluído com sucesso!");
                                break;
                            default:
                                System.out.println("Cancelando...");    
                        }
                        break;
                    }
                }
                if(naoAchou){
                    System.out.println("ID não encontrado!");
                }
                break;
            case 2:
                naoAchou = true;
                
                // Identificação do Paciente via CPF
                System.out.println("Forneça o CPF do paciente: ");
                int cpf = scan.nextInt();
                
                // Iteração na lista de Pacientes
                for(int i = 0; i < pacientes.size(); i++){
                    if(cpf == pacientes.get(i).getCpf()){
                        System.out.println("Paciente: ");
                        pacientes.get(i).exibirFormatado();
                        naoAchou = false;
                        
                        // Opções - Edição ou Exclusão
                        System.out.println("1. Editar");
                        System.out.println("2. Excluir");
                        System.out.println("3. Cancelar");
                        opcEdEx = scan.nextInt();
                        switch(opcEdEx) {
                            case 1:
                                pacientes.get(i).editar();
                                System.out.println("Edição Concluída!");
                                break;
                            case 2:
                                pacientes.remove(i);
                                System.out.println("Excluído com sucesso!");
                                break;
                            default:
                                System.out.println("Cancelando...");    
                        }
                    }
                }
                if(naoAchou){
                    System.out.println("CPF não encontrado!");
                }
                break;
            default:
                System.out.println("Cancelando...");
        }
    } 
}
