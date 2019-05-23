import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

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

    public String query(){
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sqlQuery = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numColumn = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= numColumn; i++) {
                    String value = resultSet.getString(i);
                    outQuery = outQuery+value+" | ";
                }
                outQuery = outQuery+"/n";
            }


        }catch (SQLException sqle){
            outQuery = ""+sqle;
        }

        return outQuery;
    }

}