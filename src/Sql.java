import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.util.Vector;
import javax.swing.JTable;

class Sql {
    Connection connection;
    private String outQuery;
    Sql(){
        try{
            System.out.println("Start Connect");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?autoRecconect=true&useSSL=false","root","root");
            System.out.println("Connect ok");
        }catch (ClassNotFoundException cne){
            System.out.println("Error EXEPTION: "+cne);
        }catch (SQLException sqle){
            System.out.println("Error SQL: "+sqle);
        }

    }

    public JTable query(){
        JTable table = null;
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sqlQuery = "SELECT * FROM employees";

            ResultSet resultSet = statement.executeQuery(sqlQuery);
            resultSet = statement.executeQuery(sqlQuery);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int numColumn = metaData.getColumnCount();

            Vector columnIdentifiers = new Vector();

            for(int column=0;column<numColumn;column++){
                String value = metaData.getColumnLabel(column+1);
                columnIdentifiers.addElement(value);
            }

            Vector dataVector = new Vector<Vector>();

            while (resultSet.next()) {
                Vector<String> rowTable = new Vector<String>();
                for (int i = 1; i <= numColumn; i++) {
                    String value = resultSet.getString(i);
                    //outQuery = outQuery+value+" | ";
                    rowTable.addElement(value);
                }
                //outQuery = outQuery+"/n";
                dataVector.addElement(rowTable);
            }

            table = new JTable(dataVector,columnIdentifiers);


        }catch (SQLException sqle){
            outQuery = ""+sqle;
        }

        if (table != null){
            return table;
        }

        return null;

    }

}