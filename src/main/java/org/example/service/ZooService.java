package org.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;

public class ZooService {

    //Dados de conexão
    String driverClassName = "org.postgresql.Driver";
    String url = "jdbc:postgresql://babar.db.elephantsql.com:5432/xhjbnqbb";
    String user = "xhjbnqbb";
    String password = "VgxXRZffm5nXkBfIIngOQHxLNHtcYdCV";
    public void createTable(String nomeTable) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
//        int count = 0;

        if (nomeTable.equals("FUNCIONARIO")) {
            String queryFuncionario = "CREATE TABLE FUNCIONARIO (ID_FUNCIONARIO SERIAL PRIMARY KEY, NOME VARCHAR(255), CPF VARCHAR(13), CARGO VARCHAR(255));";
            st.executeUpdate(queryFuncionario);

        }

        if (nomeTable.equals("ANIMAL")) {
            String queryAnimais = "CREATE TABLE ANIMAL (ID_ANIMAL SERIAL PRIMARY KEY,\n" +
                    "\tESPECIE VARCHAR(255), NOME VARCHAR(255), DESCRICAO \tVARCHAR(255), ID_RESPONSAVEL INTEGER, ATIVO BOOLEAN,\n" +
                    "    CONSTRAINT FK_RESPONSAVEL FOREIGN KEY (ID_RESPONSAVEL) REFERENCES FUNCIONARIO(ID_FUNCIONARIO));";
            st.executeUpdate(queryAnimais);

        }

        if (nomeTable.equals("LISTA_SERVICOS")) {
            String queryListaServico = "CREATE TABLE LISTA_SERVICOS (ID_SERVICO SERIAL PRIMARY KEY, DESCRICAO VARCHAR(255), DATA DATE,  ID_ANIMAL INTEGER, ID_RESPONSAVEL INTEGER, \n" +
                    "\t CONCLUIDO BOOLEAN, CONSTRAINT FK_ANIMAL FOREIGN KEY (ID_ANIMAL) REFERENCES ANIMAL(ID_ANIMAL),\n" +
                    "\t CONSTRAINT FK_RESPONSAVEL FOREIGN KEY (ID_RESPONSAVEL) REFERENCES FUNCIONARIO(ID_FUNCIONARIO));";
            st.executeUpdate(queryListaServico);
        }
        con.close();
    }

//    public void validaQuery(int count) {
//        if(count == 1) {
//            System.out.println("===========================");
//            System.out.println("Query returned successfully");
//            System.out.println("===========================");
//        }
//    }
}
