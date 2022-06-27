package clinicamedica;

import static clinicamedica.ClinicaMedica.consultas;
import java.util.Calendar;
import java.util.Scanner;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private Calendar data;

    
    public Consulta(Medico medico, Paciente paciente, Calendar data) {
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
    }
    
    
    public static void marcarConsulta(){
        Scanner scan = new Scanner(System.in);
        int idMedico;
        Medico medico;
        int cpfPaciente;
        Paciente paciente;
        Calendar data = Calendar.getInstance();
        int ano, mes, dia, hora, min;
        
        System.out.println("ID do Médico: ");
        idMedico = scan.nextInt();
        medico = Medico.buscarMedico(idMedico);
        if(medico == null){
            System.out.println("Erro! Médico não localizado");
            return;
        }
        
        System.out.println("CPF do Paciente: ");
        cpfPaciente = scan.nextInt();
        paciente = Paciente.buscarPaciente(cpfPaciente);
        if(paciente == null){
            System.out.println("Erro! Paciente não localizado");
            return;
        }
        
        System.out.println("Data: ");
        System.out.println("Ano: ");
        ano = scan.nextInt();
        System.out.println("Mês (Numérico): ");
        mes = scan.nextInt();
        mes = mes - 1; // Mes vai de 0 a 11 Sendo 0 Janeiro e 11 Dezembro
        System.out.println("Dia: ");
        dia = scan.nextInt();
        System.out.println("Hora: ");
        hora = scan.nextInt();
        System.out.println("Minutos: ");
        min = scan.nextInt();
        data.set(ano, mes, dia, hora, min);
    
        Consulta consulta = new Consulta(medico, paciente, data);
        consultas.add(consulta);
    }
    
    
    public void exibirFormatado(){
        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH);
        int ano = data.get(Calendar.YEAR);
        int hora = data.get(Calendar.HOUR_OF_DAY);
        int min = data.get(Calendar.MINUTE);
        
        System.out.printf("Médico: %d %s\n", this.medico.getId(), this.medico.getNome());
        System.out.printf("Paciente %d %s\n", this.paciente.getCpf(), this.paciente.getNome());
        System.out.printf("Data: %02d/%02d/%d %02d:%02d\n", dia, (mes+1), ano, hora, min);
    }
    
}