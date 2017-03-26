
package ModeloBeans;

import java.util.Date;


public class BeansAgendamento {
    
    private int agendaCod;
    private String nomeMedico;
    private String nomePaciente;

    public String getAPacenteNasc() {
        return APacenteNasc;
    }

    public void setAPacenteNasc(String APacenteNasc) {
        this.APacenteNasc = APacenteNasc;
    }
    private String ATurno;
    private Date AData;
    private String AStatus;
    private String AMotivo;
    private Integer AEspecialidade;
    private Integer AIdPaciente;
    private Integer AIdMedico;
    private String ARetorno;
    private String APacenteNasc;

    public String getARetorno() {
        return ARetorno;
    }

    public void setARetorno(String ARetorno) {
        this.ARetorno = ARetorno;
    }

          
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

    public String getATurno() {
        return ATurno;
    }

    public void setATurno(String ATurno) {
        this.ATurno = ATurno;
    }

    public Date getAData() {
        return AData;
    }

    public void setAData(Date AData) {
        this.AData = AData;
    }

    public String getAStatus() {
        return AStatus;
    }

    public void setAStatus(String AStatus) {
        this.AStatus = AStatus;
    }

    public String getAMotivo() {
        return AMotivo;
    }

    public void setAMotivo(String AMotivo) {
        this.AMotivo = AMotivo;
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
