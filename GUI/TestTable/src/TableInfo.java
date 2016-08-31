import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableInfo extends JFrame implements ActionListener{

    Container container;
    JPanel pane;
    GridBagConstraints gbc;
    JLabel userInfo;
    JTextField firstInput, lastInput;
    JButton deleteButton, addButton, modifyButton;
    JTable table;
    PersonTableModel personTable;

    public TableInfo(){
        initComponent();

        // -- labels -- //
        gbc.gridwidth = 1;

        addModule(userInfo, "First name", 0, 0);
        addModule(userInfo, "Last name", 0, 1);

        // -- fields -- //
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        firstInput = new JTextField(17);
        addModule(firstInput, 1, 0);
        lastInput = new JTextField(17);
        addModule(lastInput, 1, 1);

        // -- buttons -- //
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;

        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                personTable.getPersons().add(new Person(firstInput.getText(), lastInput.getText()));
                personTable.fireTableDataChanged();
                clearFieldInput();
            }
        });
        addModule(addButton, 1, 2);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                personTable.getPersons().remove(table.getSelectedRow());
                personTable.fireTableDataChanged();
                clearFieldInput();
            }
        });
        addModule(deleteButton, 2, 2);
        modifyButton = new JButton("Modify");
        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Person thisPerson = personTable.getPersons().get(table.getSelectedRow());
                thisPerson.setFirstName(firstInput.getText());
                thisPerson.setLastName(lastInput.getText());
                personTable.fireTableDataChanged();
                clearFieldInput();
            }
        });
        addModule(modifyButton, 3, 2);

        // -- tables -- //
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 5;

        modulePos(0, 3);
        personTable = new PersonTableModel();
        table = new JTable(personTable);
        pane.add(new JScrollPane(table), gbc);

        container.add(pane);
        containerSettings();
        pack();
    }

    // -- static modules -- //
    public void addModule(JLabel thisLabel, String msg, int x, int y){
        thisLabel = new JLabel(msg);
        modulePos(x, y);
        pane.add(thisLabel, gbc);
    }
    public void addModule(JTextField thisField, int x, int y){
        modulePos(x, y);
        pane.add(thisField, gbc);
    }
    public void addModule(JButton thisButton, int x, int y){
        modulePos(x, y);
        pane.add(thisButton, gbc);
    }
    public void modulePos(int x, int y){
        gbc.gridx = x;
        gbc.gridy = y;
    }
    public void initComponent(){
        container = getContentPane();
        pane = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
    }
    public void containerSettings(){
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // -- /static modules -- //

    @Override
    public void actionPerformed(ActionEvent e) {}
    public void clearFieldInput(){
        firstInput.setText("");
        lastInput.setText("");
    }
}
