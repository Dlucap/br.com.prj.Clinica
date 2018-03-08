
package ModeloBeans;

import java.util.Date;


public class BeansAgendamento {
    
    private Integer agendaCod;
    private String agenNomeMedico;
    private String agenNomePaciente;
    private Integer agenIdHora;
    private String agenHora;
    private Date agenData;
    private String agenStatus;
    private String agenMotivo;
    private Integer agenEspecialidade;
    private String agenNomeEspecialidade;
    private Integer agenIdPaciente;
    private Integer agenIdMedico;
    private String agenRetorno; 
    private String agenDtNascPaciente;
    private Integer agenIdConsultaRetorno;
    
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

    public Integer getAgenIdHora() {
        return agenIdHora;
    }

    public void setAgenIdHora(Integer agenIdHora) {
        this.agenIdHora = agenIdHora;
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

    /**
     * @return the agenIdConsultaRetorno
     */
    public Integer getAgenIdConsultaRetorno() {
        return agenIdConsultaRetorno;
    }

    /**
     * @param agenIdConsultaRetorno the agenIdConsultaRetorno to set
     */
    public void setAgenIdConsultaRetorno(Integer agenIdConsultaRetorno) {
        this.agenIdConsultaRetorno = agenIdConsultaRetorno;
    }

    /**
     * @return the agenHora
     */
    public String getAgenHora() {
        return agenHora;
    }

    /**
     * @param agenHora the agenHora to set
     */
    public void setAgenHora(String agenHora) {
        this.agenHora = agenHora;
    }

    /**
     * @return the agenNomeEspecialidade
     */
    public String getAgenNomeEspecialidade() {
        return agenNomeEspecialidade;
    }

    /**
     * @param agenNomeEspecialidade the agenNomeEspecialidade to set
     */
    public void setAgenNomeEspecialidade(String agenNomeEspecialidade) {
        this.agenNomeEspecialidade = agenNomeEspecialidade;
    }
    
}
