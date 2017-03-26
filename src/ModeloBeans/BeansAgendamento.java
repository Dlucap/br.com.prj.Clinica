
package ModeloBeans;

import java.util.Date;


public class BeansAgendamento {
    
    private int agendaCod;
    private String nomeMedico;
    private String nomePaciente;
    private String Turno;
    private Date data;
    private String status;
    private String motivo;
    private Integer AEspecialidade;
    private Integer AIdPaciente;
    private Integer AIdMedico;

          
    public void setAIdPaciente(Integer AIdPaciente) {
        this.AIdPaciente = AIdPaciente;
    }

    public void setAIdMedico(Integer AIdMedico) {
        this.AIdMedico = AIdMedico;
    }
    
   
    public Integer getAEspecialidade() {
        return AEspecialidade;
    }

    public void setAEspecialidade(Integer AEspecialidade) {
        this.AEspecialidade = AEspecialidade;
    }

    public int getAgendaCod() {
        return agendaCod;
    }

    public void setAgendaCod(int agendaCod) {
        this.agendaCod = agendaCod;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the AIdPaciente
     */
    public Integer getAIdPaciente() {
        return AIdPaciente;
    }

    /**
     * @return the AIdMedico
     */
    public Integer getAIdMedico() {
        return AIdMedico;
    }
    
}
