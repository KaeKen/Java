import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{

    ArrayList<Person> persons = new ArrayList<>();

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 2;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return persons.size();
    }

    @Override
    public Object getValueAt(int r, int c) {
        if(c == 0){
            return persons.get(r).getFirstname();
        } else {
            return persons.get(r).getLastname();
        }
    }

    @Override
    public String getColumnName(int c) {
        // TODO Auto-generated method stub
        if(c == 0){
            return "Firstname";
        } else{
            return "Lastname";
        }
    }
}
