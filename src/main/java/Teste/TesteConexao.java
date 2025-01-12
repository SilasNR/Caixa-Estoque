package Teste;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Conection.ConnectionFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class TesteConexao {
    public static void main(String[] args) throws IOException{        
        try {
           //Properties properties = carregarConfiguracoes("conf.properties");
            ConnectionFactory factory = new ConnectionFactory();
            
            try (var minhaConexao = factory.Conectar("Teste Conexão")) {
                JOptionPane.showMessageDialog(null, "Conexão estabelecida com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static Properties carregarConfiguracoes(String caminhoArquivo) throws IOException {
        File configFile = new File(caminhoArquivo);
        if (!configFile.exists()) {
            throw new IOException("Arquivo de configuração não encontrado: " + caminhoArquivo);
        }

        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(configFile)) {
            properties.load(fis);
        }

        // Validação de propriedades essenciais
        if (!properties.containsKey("url") || !properties.containsKey("username") || !properties.containsKey("password")) {
            throw new IOException("Arquivo de configuração está incompleto. Verifique se 'url', 'username' e 'password' estão definidos.");
        }

        return properties;
    }
}
