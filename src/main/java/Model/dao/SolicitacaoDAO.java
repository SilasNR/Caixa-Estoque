/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Conection.ConnectionFactory;
import Model.bean.Solicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SolicitacaoDAO {

    private int id;
    private int idUser;
    private String cn;
    private int quant;
    private boolean conf1;
    private boolean conf2;
    private String status;
    private String data;
    private String hora;
    private Date atual = new Date();
    private List<Solicitacao> lista = new ArrayList<>();

    //--- Inserir dados no banco de dados
    public void criar(Solicitacao solicitacao) {
        Connection con = ConnectionFactory.Conectar("solicitação DAO - criar");
        PreparedStatement stmt = null;
        

        try {
            stmt = con.prepareStatement("INSERT INTO `SOLICITACAO` (`CN`,`QUANTIDADE`,`DATA`, `HORA`) VALUES (?,?,?,?)");
            
            stmt.setString(1, solicitacao.getCn());
            stmt.setInt(2, solicitacao.getQuant());
            stmt.setString(3, new SimpleDateFormat("DD/MM").format(atual));
            stmt.setString(4, new SimpleDateFormat("HH:mm").format(atual));

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Solicitado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar solicitacão" + ex);
        } finally {
            ConnectionFactory.closeConection(con, stmt);
        }
    }

    //--- Puxar todos os dados da tabela Solicitacao
    public List<Solicitacao> todasSolicitacao() throws ParseException {
        lista.clear();
        Connection con = ConnectionFactory.Conectar("solicitação DAO - todasSolicitacao");
        PreparedStatement stmt = null;
       
        String sql = "SELECT * FROM `SOLICITACAO`";

        try {
            stmt = con.prepareStatement(sql);

            try (ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    id = rs.getInt("ID_SOLICITACAO");
                    idUser = rs.getInt("ID_USUARIO");
                    cn =  rs.getString("CN");
                    quant = rs.getInt("QUANTIDADE");
                    conf1 = rs.getBoolean("CONF1");
                    conf2 = rs.getBoolean("CONF2");
                    data = rs.getString("DATA");
                    hora = rs.getString("HORA");

                    Solicitacao solicitacao = new Solicitacao(id, idUser, cn, quant, conf1, conf2, data, hora);

                    lista.add(solicitacao);
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não conectado - " + ex);
        } finally {
            ConnectionFactory.closeConection(con, stmt);
        }

        return lista;
    }
    
    //--Busca apenas os confirmados
    public List<Solicitacao> todaSolicitacaoConfirmada() throws ParseException {
        lista.clear();
        Connection con = ConnectionFactory.Conectar("solicitação DAO - todasSolicitacao");
        PreparedStatement stmt = null;
       

        String sql = "SELECT * FROM `SOLICITACAO` WHERE `CONF1` = true";

        try {
            stmt = con.prepareStatement(sql);

            try (ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    id = rs.getInt("ID_SOLICITACAO");
                    idUser = rs.getInt("ID_USUARIO");
                    cn =  rs.getString("CN");
                    quant = rs.getInt("QUANTIDADE");
                    conf1 = rs.getBoolean("CONF1");
                    conf2 = rs.getBoolean("CONF2");
                    data = rs.getString("DATA");
                    hora = rs.getString("HORA");

                    Solicitacao solicitacao = new Solicitacao(id, idUser, cn, quant, conf1, conf2, data, hora);

                    lista.add(solicitacao);
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não conectado - " + ex);
        } finally {
            ConnectionFactory.closeConection(con, stmt);
        }
        return lista;
    }
    
    
    public void deletar(int indice) {
        Connection con = ConnectionFactory.Conectar("solicitação DAO - Deletar");
        PreparedStatement stmt = null;
        int id = lista.get(indice).getId();
        
        
        //JOptionPane.showMessageDialog(null,lista.get(indice).getId() + " " + lista.get(indice).getCn());

        try {
            stmt = con.prepareStatement("DELETE FROM `SOLICITACAO` WHERE `ID_SOLICITACAO` = ?");
            
            stmt.setInt(1,id);

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir solicitação" + ex);
        } finally {
            ConnectionFactory.closeConection(con, stmt);
        }
    }
}
