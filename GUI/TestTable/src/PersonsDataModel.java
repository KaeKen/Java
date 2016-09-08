import java.sql.*;

public class PersonsDataModel {
    public static void main(String[] args){
        try{
            String url = "jdbc:sqlite:mydb.db";
            Connection conn = DriverManager.getConnection(url);

            Statement statement = conn.createStatement();

            String sql = "select * from persons;";

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString("first_name") + ", " + rs.getString("first_name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
