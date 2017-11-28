/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Daniel Lucas
 */
@Entity
@Table(name = "AGENDAMENTO", catalog = "ClinicaMedica", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Agendamento.findAll", query = "SELECT a FROM Agendamento a")
    , @NamedQuery(name = "Agendamento.findByIdagendamento", query = "SELECT a FROM Agendamento a WHERE a.idagendamento = :idagendamento")
    , @NamedQuery(name = "Agendamento.findByStatusconsulta", query = "SELECT a FROM Agendamento a WHERE a.statusconsulta = :statusconsulta")
    , @NamedQuery(name = "Agendamento.findByIdpaciente", query = "SELECT a FROM Agendamento a WHERE a.idpaciente = :idpaciente")
    , @NamedQuery(name = "Agendamento.findByIdmedico", query = "SELECT a FROM Agendamento a WHERE a.idmedico = :idmedico")
    , @NamedQuery(name = "Agendamento.findByIdespecialidade", query = "SELECT a FROM Agendamento a WHERE a.idespecialidade = :idespecialidade")
    , @NamedQuery(name = "Agendamento.findByTurno", query = "SELECT a FROM Agendamento a WHERE a.turno = :turno")
    , @NamedQuery(name = "Agendamento.findByDtagendamento", query = "SELECT a FROM Agendamento a WHERE a.dtagendamento = :dtagendamento")
    , @NamedQuery(name = "Agendamento.findByMotivo", query = "SELECT a FROM Agendamento a WHERE a.motivo = :motivo")
    , @NamedQuery(name = "Agendamento.findByDatainclusao", query = "SELECT a FROM Agendamento a WHERE a.datainclusao = :datainclusao")
    , @NamedQuery(name = "Agendamento.findByRetorno", query = "SELECT a FROM Agendamento a WHERE a.retorno = :retorno")})
public class Agendamento implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDAGENDAMENTO")
    private Integer idagendamento;
    @Basic(optional = false)
    @Column(name = "STATUSCONSULTA")
    private String statusconsulta;
    @Basic(optional = false)
    @Column(name = "IDPACIENTE")
    private int idpaciente;
    @Basic(optional = false)
    @Column(name = "IDMEDICO")
    private int idmedico;
    @Basic(optional = false)
    @Column(name = "IDESPECIALIDADE")
    private int idespecialidade;
    @Basic(optional = false)
    @Column(name = "TURNO")
    private String turno;
    @Basic(optional = false)
    @Column(name = "DTAGENDAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtagendamento;
    @Basic(optional = false)
    @Column(name = "MOTIVO")
    private String motivo;
    @Column(name = "DATAINCLUSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainclusao;
    @Column(name = "RETORNO")
    private Integer retorno;

    public Agendamento() {
    }

    public Agendamento(Integer idagendamento) {
        this.idagendamento = idagendamento;
    }

    public Agendamento(Integer idagendamento, String statusconsulta, int idpaciente, int idmedico, int idespecialidade, String turno, Date dtagendamento, String motivo) {
        this.idagendamento = idagendamento;
        this.statusconsulta = statusconsulta;
        this.idpaciente = idpaciente;
        this.idmedico = idmedico;
        this.idespecialidade = idespecialidade;
        this.turno = turno;
        this.dtagendamento = dtagendamento;
        this.motivo = motivo;
    }

    public Integer getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(Integer idagendamento) {
        Integer oldIdagendamento = this.idagendamento;
        this.idagendamento = idagendamento;
        changeSupport.firePropertyChange("idagendamento", oldIdagendamento, idagendamento);
    }

    public String getStatusconsulta() {
        return statusconsulta;
    }

    public void setStatusconsulta(String statusconsulta) {
        String oldStatusconsulta = this.statusconsulta;
        this.statusconsulta = statusconsulta;
        changeSupport.firePropertyChange("statusconsulta", oldStatusconsulta, statusconsulta);
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        int oldIdpaciente = this.idpaciente;
        this.idpaciente = idpaciente;
        changeSupport.firePropertyChange("idpaciente", oldIdpaciente, idpaciente);
    }

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        int oldIdmedico = this.idmedico;
        this.idmedico = idmedico;
        changeSupport.firePropertyChange("idmedico", oldIdmedico, idmedico);
    }

    public int getIdespecialidade() {
        return idespecialidade;
    }

    public void setIdespecialidade(int idespecialidade) {
        int oldIdespecialidade = this.idespecialidade;
        this.idespecialidade = idespecialidade;
        changeSupport.firePropertyChange("idespecialidade", oldIdespecialidade, idespecialidade);
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        String oldTurno = this.turno;
        this.turno = turno;
        changeSupport.firePropertyChange("turno", oldTurno, turno);
    }

    public Date getDtagendamento() {
        return dtagendamento;
    }

    public void setDtagendamento(Date dtagendamento) {
        Date oldDtagendamento = this.dtagendamento;
        this.dtagendamento = dtagendamento;
        changeSupport.firePropertyChange("dtagendamento", oldDtagendamento, dtagendamento);
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        String oldMotivo = this.motivo;
        this.motivo = motivo;
        changeSupport.firePropertyChange("motivo", oldMotivo, motivo);
    }

    public Date getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        Date oldDatainclusao = this.datainclusao;
        this.datainclusao = datainclusao;
        changeSupport.firePropertyChange("datainclusao", oldDatainclusao, datainclusao);
    }

    public Integer getRetorno() {
        return retorno;
    }

    public void setRetorno(Integer retorno) {
        Integer oldRetorno = this.retorno;
        this.retorno = retorno;
        changeSupport.firePropertyChange("retorno", oldRetorno, retorno);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idagendamento != null ? idagendamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendamento)) {
            return false;
        }
        Agendamento other = (Agendamento) object;
        if ((this.idagendamento == null && other.idagendamento != null) || (this.idagendamento != null && !this.idagendamento.equals(other.idagendamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "visao.Agendamento[ idagendamento=" + idagendamento + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
