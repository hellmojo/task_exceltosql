package db;

import model.Task;

import java.sql.*;
import java.util.List;

public class DBAction {
        static final String DATABASE_URL = "jdbc:mysql://localhost/test";
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

        static final String USER = "root";
        static final String PASSWORD = "";
        static final String TABLE = "task";


        public static void makeTable() throws SQLException {
            Connection connection = null;
            Statement statement = null;
            try {
                Class.forName(JDBC_DRIVER);

                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

                statement = connection.createStatement();

                String SQL = "CREATE TABLE " + TABLE +
                        " (id INTEGER not NULL, " +
                        " company VARCHAR(50), " +
                        " date VARCHAR(50), " +
                        " factQliqData1 INTEGER not NULL, " +
                        " factQliqData2 INTEGER not NULL, " +
                        " factQoilData1 INTEGER not NULL, " +
                        " factQoilData2 INTEGER not NULL, " +
                        " forecastQliqData1 INTEGER not NULL, " +
                        " forecastQliqData2 INTEGER not NULL, " +
                        " forecastQoilData1 INTEGER not NULL, " +
                        " forecastQoilData2 INTEGER not NULL, " +
                        " PRIMARY KEY (id))";

                statement.executeUpdate(SQL);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if(statement!=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }
        }

        public static void fillTable(List<Task> actualTask) throws SQLException {
            Connection connection = null;
            PreparedStatement psFill = null;
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                String SQL = "INSERT INTO "+TABLE+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                psFill = connection.prepareStatement(SQL);
                for(Task taskFill : actualTask) {
                    psFill.setInt(1, taskFill.getId());
                    psFill.setString(2, taskFill.getCompany());
                    psFill.setString(3,taskFill.getDate());
                    psFill.setInt(4, taskFill.getFactQlicData1());
                    psFill.setInt(5, taskFill.getFactQlicData2());
                    psFill.setInt(6, taskFill.getFactQoilData1());
                    psFill.setInt(7, taskFill.getFactQoilData2());
                    psFill.setInt(8, taskFill.getForecastQlicData1());
                    psFill.setInt(9, taskFill.getForecastQlicData2());
                    psFill.setInt(10, taskFill.getForecastQoilData1());
                    psFill.setInt(11, taskFill.getForecastQlicData2());

                    psFill.addBatch();
                }
                psFill.executeBatch(); 
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }finally {
                if(psFill!=null){
                    psFill.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }
        }

        public static void totalSum() throws SQLException {
            Connection connection = null;
            Statement stmt = null;
            ResultSet rs = null;
            try{
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                String SQL = "SELECT date, SUM(factQliqData1), SUM(factQliqData2), SUM(forecastQliqData1), SUM(forecastQoilData2) FROM "+TABLE+" GROUP BY date";
                stmt = connection.createStatement();
                rs = stmt.executeQuery(SQL);
                while(rs.next()){
                    //Display values
                    System.out.print("Date: " + rs.getString("date"));
                    System.out.print(", Fact Qliq total: " + rs.getInt("SUM(factQliqData1)"));
                    System.out.print(", Fact Qoil total: " + rs.getInt("SUM(factQliqData2)"));
                    System.out.print(", Forecast Qliq total: " + rs.getInt("SUM(forecastQliqData1)"));
                    System.out.println(", Forecast Qoil total: " + rs.getInt("SUM(forecastQoilData2)"));
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                if(rs!=null){
                    rs.close();
                }
                if(stmt!=null){
                    stmt.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }
        }
    }

