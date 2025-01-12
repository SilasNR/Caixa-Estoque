/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.bean;

import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Solicitacao {

    private int id;
    private int idUser;
    private int idProduto;
    private String cn;
    private int quant;
    private boolean conf1;
    private boolean conf2;
    private String status;
    private String data;
    private String hora;

    public Solicitacao() {
    }

    public Solicitacao(int id, int idUser, String cn, int quant,boolean conf1, boolean conf2, String data, String hora) {
        this.id = id;
        this.idUser = idUser;
        this.cn = cn;
        this.quant = quant;
        this.conf2 = conf2;
        this.data = data;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public boolean isConf1() {
        return conf1;
    }

    public void setConf1(boolean conf1) {
        this.conf1 = conf1;
    }

    public boolean isConf2() {
        return conf2;
    }

    public void setConf2(boolean conf2) {
        this.conf2 = conf2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
