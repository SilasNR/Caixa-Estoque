package inicio;


import Conection.ConnectionFactory;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import view.Tela_Login;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author User
 */
public class CaixaEstoque {

    public static void main(String[] args) throws Exception {
        java.awt.EventQueue.invokeLater(() -> {
            new Tela_Login().setVisible(true);
        });
    }
}
