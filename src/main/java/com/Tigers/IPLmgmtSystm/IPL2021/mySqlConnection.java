package com.Tigers.IPLmgmtSystm.IPL2021;

//import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mySqlConnection {

        public static void main(String[] args) {
            try {

//                final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//                final String DB_URL = "jdbc:mysql://localhost:3306/database1";
//                final String USER = "root";
//                final String PASS = "Shashi@15*";

               // Class.forName(JDBC_DRIVER);



                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1\"","root","Shashi@15*");
                System.out.println("1: The total ....");
                Statement s = connection.createStatement();
                ResultSet resultSet = s.executeQuery("select * from table xyz");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("P_name"));

                }
            }catch (Exception e){
                e.printStackTrace();
            }
            }
        }