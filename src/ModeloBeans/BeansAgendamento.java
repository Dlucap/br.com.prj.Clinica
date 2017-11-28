
package ModeloBeans;

import java.util.Date;


public class BeansAgendamento {
    
    private Integer agendaCod;
    private String agenNomeMedico;
    private String agenNomePaciente;
    private String agenTurno;
    private Date agenData;
    private String agenStatus;
    private String agenMotivo;
    private Integer agenEspecialidade;
    private Integer agenIdPaciente;
    private Integer agenIdMedico;
    private String agenRetorno;
    private String agenDtNascPaciente;
   // private Integer Idade;

    public String getARetorno() {
        return agenRetorno;
    }

    public void setARetorno(String ARetorno) {
        this.agenRetorno = ARetorno;
    }

          
    public void setAIdPaciente(Integer AIdPaciente) {
        this.agenIdPaciente = AIdPaciente;
    }

    public void setAIdMedico(Integer AIdMedico) {
        this.agenIdMedico = AIdMedico;
    }
    
   
    public Integer getAEspecialidade() {
        return agenEspecialidade;
    }

    public void setAEspecialidade(Integer AEspecialidade) {
        this.agenEspecialidade = AEspecialidade;
    }

    public Integer getAgendaCod() {
        return agendaCod;
    }

    public void setAgendaCod(Integer agendaCod) {
        this.agendaCod = agendaCod;
    }

    public String getNomeMedico() {
        return agenNomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.agenNomeMedico = nomeMedico;
    }

    public String getNomePaciente() {
        return agenNomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.agenNomePaciente = nomePaciente;
    }

    public String getTurno() {
        return agenTurno;
    }

    public void setTurno(String Turno) {
        this.agenTurno = Turno;
    }

    public Date getData() {
        return agenData;
    }

    public void setData(Date data) {
        this.agenData = data;
    }

    public String getStatus() {
        return agenStatus;
    }

    public void setStatus(String status) {
        this.agenStatus = status;
    }

    public String getMotivo() {
        return agenMotivo;
    }

    public void setMotivo(String motivo) {
        this.agenMotivo = motivo;
    }

    /**
     * @return the AIdPaciente
     */
    public Integer getAIdPaciente() {
        return agenIdPaciente;
    }

    /**
     * @return the AIdMedico
     */
    public Integer getAIdMedico() {
        return agenIdMedico;
    }

    /**
     * @return the dtNascPaciente
     */
    public String getDtNascPaciente() {
        return agenDtNascPaciente;
    }

    /**
     * @param dtNascPaciente the dtNascPaciente to set
     */
    public void setDtNascPaciente(String dtNascPaciente) {
        this.agenDtNascPaciente = dtNascPaciente;
    }

//    public Integer getIdade() {
//        return Idade;
//    }
//
//    public void setIdade(Integer Idade) {
//        this.Idade = Idade;
//    }
    
}
