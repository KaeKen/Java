import java.lang.reflect.Array;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class PersonTableModel extends AbstractTableModel{

    private  ArrayList<Person> persons;

    public PersonTableModel(){
        persons = new ArrayList<>();
    }

    public String getColumnName(int c){
        if(c == 0){
            return "First Name";
        }else{
            return "Last Name";
        }
    }


    @Override
    public int getColumnCount(){
        return 2;
    }

    @Override
    public int getRowCount(){
        return persons.size();
    }

    @Override
    public String getValueAt(int r, int c){
       if(c == 0){
           return persons.get(r).getFirstName();
       }else if(c == 1){
           return persons.get(r).getLastName();
       }
       return null;
    }

//    public ArrayList<Person> getSelectedRow(){
//        return
//    }

    public ArrayList<Person> getPersons(){
        return persons;
    }

}
