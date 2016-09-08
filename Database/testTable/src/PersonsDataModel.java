import java.sql.*;


public class PersonsDataModel {
    Connection conn;
    Statement statement;
    PreparedStatement preparedStatement;

    public PersonsDataModel(){
        try{

            conn = DriverManager.getConnection("jdbc:sqlite:persons.db");
            statement = conn.createStatement();

            String sql = "create table if not exists students (" +
                    "last_name text, " +
                    "first_name text, " +
                    "student_no text);";

            statement.execute(sql);

            String insertQuery = "insert into students (" +
                    "first_name, " +
                    "last_name, " +
                    "student_no)" +
                    " values (?,?,?);";

            preparedStatement = conn.prepareStatement(insertQuery);

        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void addStudent(String firstName, String lastName, String studentNo){
        try {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, studentNo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}