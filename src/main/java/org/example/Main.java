package org.example;
import org.example.service.ZooService;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       ZooService zooService = new ZooService();

       zooService.createTable("FUNCIONARIO");
       zooService.createTable("ANIMAL");
       zooService.createTable("LISTA_SERVICOS");
    }
}