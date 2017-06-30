/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloBeans.BeansPaciente;
import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Lucas
 */
public class DaoPaciente {

    ConexaoBd conex = new ConexaoBd();
  
    PreparedStatement pstP;

    public void salvar(BeansPaciente pac) {
        conex.conectarBd();
        String sql = "INSERT INTO PACIENTE (NOMEPACIENTE ,CPF ,RG ,DATANASCIMENTO, TELRESIDENCIAL, TELCELULAR ,LOGRADOURO ,NUMERO ,BAIRRO ,"
                + "CIDADE ,ESTADO ,CEP ,COMPL ,EMAIL ,CENOME ,CETELRESIDENCIAL, CETELCELULAR) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstP = conex.con.prepareStatement(sql);

            pstP.setString(1, pac.getPNome());
            pstP.setString(2, pac.getPCpf());
            pstP.setString(3, pac.getPRg());
            pstP.setString(4, pac.getPDtNascimento());
            pstP.setString(5, pac.getPTelResidencial());
            pstP.setString(6, pac.getPTelCelular());
            pstP.setString(7, pac.getPLogradouro());
            pstP.setInt(8, pac.getPNumero());
            pstP.setString(9, pac.getPBairro());
            pstP.setString(10, pac.getPCidade());
            pstP.setString(11, pac.getPUf());
            pstP.setString(12, pac.getPCep());
            pstP.setString(13, pac.getPCompl());
            pstP.setString(14, pac.getPEmail());
            pstP.setString(15, pac.getPEmerNome());
            pstP.setString(16, pac.getPEmerTelResidencial());
            pstP.setString(17, pac.getPEmerTelCelular());

            pstP.execute();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");
        } catch (SQLException ex) {
            // med.HabilitarCampos();
            JOptionPane.showMessageDialog(null, "\n Não foi possível realizar a inserção dos dados. \n\n" + ex.getMessage() + "\n");
             JOptionPane.showMessageDialog(null, "\n Não foi possível realizar a inserção dos dados. \n\n" + ex + "\n");
                   }
        conex.DesconectarBd();
    }

    public void Editar(BeansPaciente pac) {
        conex.conectarBd();

        String sql = "UPDATE PACIENTE SET NOMEPACIENTE = ? ,CPF = ? ,RG = ? ,DATANASCIMENTO = ?, TELRESIDENCIAL = ?, TELCELULAR = ?,LOGRADOURO = ?,"
                + "NUMERO = ?,BAIRRO = ?,CIDADE = ?,ESTADO = ?,CEP = ?,COMPL = ?,EMAIL = ?,CENOME = ?,CETELRESIDENCIAL = ?, CETELCELULAR = ? "
                + "WHERE IDPACIENTE = ?";

        try {
           // PreparedStatement pst = conex.con.prepareStatement(sql);    
            pstP = conex.con.prepareStatement(sql);

            pstP.setString(1, pac.getPNome());
            pstP.setString(2, pac.getPCpf());
            pstP.setString(3, pac.getPRg());
            pstP.setString(4, pac.getPDtNascimento());
            pstP.setString(5, pac.getPTelResidencial());
            pstP.setString(6, pac.getPTelCelular());
            pstP.setString(7, pac.getPLogradouro());
            pstP.setInt(8, pac.getPNumero());
            pstP.setString(9, pac.getPBairro());
            pstP.setString(10, (pac.getPCidade()));
            pstP.setString(11, (pac.getPUf()));
            pstP.setString(12, pac.getPCep());
            pstP.setString(13, pac.getPCompl());    
            pstP.setString(14, pac.getPEmail());
            pstP.setString(15, pac.getPEmerNome());
            pstP.setString(16, pac.getPEmerTelResidencial());
            pstP.setString(17,pac.getPEmerTelCelular());
            pstP.setInt(18, pac.getPCod());
            pstP.execute();

            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! \nErro: " + ex.getMessage());
        }

        conex.DesconectarBd();
    }

    public BeansPaciente buscaPaciente(BeansPaciente pac) {

        conex.conectarBd();

        String sql1 = "SELECT * FROM PACIENTE WHERE NOMEPACIENTE like '%" + pac.getPesquisa() + "%'";
 
       try {
             conex.executaSql(sql1);
            conex.rs.first();
            
            pac.setPCod(conex.rs.getInt("IDPACIENTE"));
            pac.setPNome(conex.rs.getString("NOMEPACIENTE"));
            pac.setPLogradouro(conex.rs.getString("LOGRADOURO"));
            pac.setPNumero(conex.rs.getInt("NUMERO"));
            pac.setPBairro(conex.rs.getString("BAIRRO"));
            pac.setPCpf(conex.rs.getString("CPF"));
            pac.setPRg(conex.rs.getString("RG"));
            pac.setPTelResidencial(conex.rs.getString("TELRESIDENCIAL"));
            pac.setPTelCelular(conex.rs.getString("TELCELULAR"));
            pac.setPCep(conex.rs.getString("CEP"));
            pac.setPCompl(conex.rs.getString("COMPL"));
            pac.setPCidade(conex.rs.getString("CIDADE"));
            pac.setPUf(conex.rs.getString("ESTADO"));
            pac.setPEmail(conex.rs.getString("EMAIL"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados do paciente!\nErro: " + ex.getMessage());
        }
        conex.DesconectarBd();
        return pac;
    }

    public void Excluir(BeansPaciente pac) {
        conex.conectarBd();
        String sql = "DELETE FROM PACIENTE WHERE IDPACIENTE = ? ";

        try {
            pstP = conex.con.prepareStatement(sql);
            pstP.setInt(1, pac.getPCod());
            pstP.execute();
            JOptionPane.showMessageDialog(null, "Dados  excluidos com sucesso!");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Medico não cadastrado na base de dados!\nErro: " + ex.getMessage());
        }
        conex.DesconectarBd();
    }
}
