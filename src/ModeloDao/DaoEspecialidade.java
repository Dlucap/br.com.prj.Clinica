/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloBeans.BeansEspecialidade;
import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Lucas
 */
public class DaoEspecialidade {

    ConexaoBd conex = new ConexaoBd();
    BeansEspecialidade beansEspec = new BeansEspecialidade();
    PreparedStatement pstEspec;

    public void salvar(BeansEspecialidade beansEspec) {
        conex.conectarBd();
        String sql = "INSERT INTO ESPECIALIDADE (ESPEC ,ATIVO) VALUES (?,?)";
        try {
            pstEspec = conex.con.prepareStatement(sql);

            pstEspec.setString(1, beansEspec.getEspecialidade());
            pstEspec.setBoolean(2, beansEspec.getAtivo());

            pstEspec.execute();

            JOptionPane.showMessageDialog(null, "Especialidade " + beansEspec.getEspecialidade() + " inserida com sucesso!!!");
        } catch (SQLException ex) {
            // med.HabilitarCampos();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a beansEspecialidade: " + beansEspec.getEspecialidade() + "\n\n" + ex.getMessage() + "\n");
        }
        conex.DesconectarBd();
    }

    public BeansEspecialidade buscaEspecialidade(BeansEspecialidade beansEspec) {

        conex.conectarBd();

        String sql1 = "SELECT ESPEC,ATIVO FROM ESPECIALIDADE WHERE ESPEC like '%" + beansEspec.getPesquisa() + "%'";

        conex.executaSql(sql1);

        try {
            conex.rs.first();
            beansEspec.setEspecialidade(conex.rs.getString("ESPEC"));
            beansEspec.setAtivo(conex.rs.getBoolean("ATIVO"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados do medico!\nErro: " + ex.getMessage());
        }
        conex.DesconectarBd();
        return beansEspec;
    }

    public void Editar(BeansEspecialidade beansEspec) {
        conex.conectarBd();

        String sql4 = "UPDATE ESPECIALIDADE SET ESPEC = ?, ATIVO = ? WHERE IDESPECIALIDADE = ?";

        try {
            //PreparedStatement pst = conex.con.prepareStatement(sql);    
            pstEspec = conex.con.prepareStatement(sql4);

            pstEspec.setString(1, beansEspec.getEspecialidade());
            pstEspec.setBoolean(2, beansEspec.getAtivo());
            pstEspec.setInt(3, beansEspec.getIdEspecialidade());

            pstEspec.execute();

            JOptionPane.showMessageDialog(null, "Especialidade alterado com sucesso.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração da especialidade:\nErro: " + ex.getMessage());
        }

        conex.DesconectarBd();
    }

}
