package ModeloBeans;

import java.util.Date;

public class BeansAgendamentoMelhoria {

    private Integer agendaCod;
    private String nomeMedico;
    private String nomePaciente;
    private Integer idHora;
    private String data;
    private String status;
    private String motivo;
    private Integer AEspecialidade;
    private Integer AIdPaciente;
    private Integer AIdMedico;
    private String ARetorno;
    private String dtNascPaciente;
    // private Integer Idade;

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

    public Integer getAgendaCod() {
        return agendaCod;
    }

    public void setAgendaCod(Integer agendaCod) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    /**
     * @return the dtNascPaciente
     */
    public String getDtNascPaciente() {
        return dtNascPaciente;
    }

    /**
     * @param dtNascPaciente the dtNascPaciente to set
     */
    public void setDtNascPaciente(String dtNascPaciente) {
        this.dtNascPaciente = dtNascPaciente;
    }

//    public Integer getIdade() {
//        return Idade;
//    }
//
//    public void setIdade(Integer Idade) {
//        this.Idade = Idade;
//    }
    public Integer getIdHora() {
        return idHora;
    }

    public void setIdHora(Integer idHora) {
        this.idHora = idHora;
    }

}
