import java.sql.*;


public class PersonsDataModel {
    Connection conn;
    Statement statement;
    PreparedStatement preparedStatement;


    public PersonsDataModel(){
        try{

            connectDB();

            String sql = "create table if not exists students (" +
                    "first_name text, " +
                    "last_name text, " +
                    "id integer primary key," +
                    "student_no text);";

            statement.execute(sql);

        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void addStudent(String firstName, String lastName, String studentNo){
        try {
            String insertQuery = "insert into students (" +
                    "first_name, " +
                    "last_name, " +
                    "student_no)" +
                    " values (?,?,?);";
            preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, studentNo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet populateData(){
        ResultSet resultSet = null;
        try {
            String personsQuery = "select * from students;";
            connectDB();
            resultSet = statement.executeQuery(personsQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
//
//    public void deleteData(int id){
//        try {
//            connectDB();
//            String personsQuery = "delete from students where id = ?;";
//            preparedStatement = conn.prepareStatement(personsQuery);
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void updateData(String setFirstName, String setLastName, int id){
        try {
            connectDB();
            String personsQuery = "update students set " +
                    "first_name = ?, last_name = ? " +
                    "where id = ?;";
            preparedStatement = conn.prepareStatement(personsQuery);
            preparedStatement.setString(1, setFirstName);
            preparedStatement.setString(2, setLastName);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connectDB(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:persons.db");
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}