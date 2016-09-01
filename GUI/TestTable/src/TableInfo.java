import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class TableInfo extends JFrame implements ActionListener{

    Container container;
    JPanel pane;
    GridBagConstraints gbc;
    JLabel userInfo;
    JTextField firstInput, lastInput;
    JButton deleteButton, addButton, modifyButton;
    JTable table;
    PersonTableModel personTable;
    JDialog noPersonDiag;


    public TableInfo(){
        super("K.pack(ganern)");
        initComponent();

        // -- labels -- //
        gbc.gridwidth = 1;
        gbc.insets = new Insets(15, 15, 1, 5);

        userInfo = new JLabel("First Name");
        modulePos(0, 0);
        pane.add(userInfo, gbc);

        gbc.insets = new Insets(1, 15, 0, 5);

        userInfo = new JLabel("Last Name");
        modulePos(0, 1);
        pane.add(userInfo, gbc);

        // -- fields -- //
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 1, 1, 15);

        firstInput = new JTextField(17);
        modulePos(1, 0);
        pane.add(firstInput, gbc);

        gbc.insets = new Insets(1, 1, 0, 15);

        lastInput = new JTextField(17);
        modulePos(1, 1);
        pane.add(lastInput, gbc);

        // -- buttons -- //
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(10, 1, 0, 5);

        addButton = new JButton("Add");
        addButton.addActionListener(this);
        addButton.setBackground(Color.decode("#5D9CEC"));
        addButton.setBorderPainted(false);
        addButton.setForeground(Color.decode("#D7E4F5"));
        modulePos(1, 2);
        pane.add(addButton, gbc);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        deleteButton.setBackground(Color.decode("#ED5565"));
        deleteButton.setBorderPainted(false);
        deleteButton.setForeground(Color.decode("#F2D3D6"));
        modulePos(2, 2);
        pane.add(deleteButton, gbc);

        modifyButton = new JButton("Modify");
        modifyButton.addActionListener(this);
        modifyButton.setBackground(Color.decode("#CCD1D9"));
        modifyButton.setBorderPainted(false);
        modulePos(3, 2);
        pane.add(modifyButton, gbc);

        // -- tables -- //
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 5;
        gbc.insets = new Insets(10, 0, 0, 0);

        personTable = new PersonTableModel();
        table = new JTable(personTable);
        modulePos(0, 3);
        pane.add(new JScrollPane(table), gbc);

        containerSettings();
    }

    // -- static modules -- //
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
        container.add(pane);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // -- /static modules -- //

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){
            personTable.getPersons().add(new Person(firstInput.getText(), lastInput.getText()));
        }else if(e.getSource() == deleteButton){
            personTable.getPersons().remove(table.getSelectedRow());
        }else if(e.getSource() == modifyButton){
            if(table.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null, "Please select a person.");
            }else{
                modifyModal thisModal = new modifyModal("Person# " + (table.getSelectedRow() +1));
                Person thisPerson = personTable.getPersons().get(table.getSelectedRow());
                thisModal.setFirstNameField(thisPerson.getFirstName());
                thisModal.setLastNameField(thisPerson.getLastName());
                thisModal.saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        thisPerson.setFirstName(thisModal.fName.getText());
                        thisPerson.setLastName(thisModal.lName.getText());
                        personTable.fireTableDataChanged();
                        thisModal.setVisible(false);
                    }
                });
                thisModal.cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        thisModal.setVisible(false);
                    }
                });
            }
        }
        personTable.fireTableDataChanged();
        clearFieldInput();
    }
    public void clearFieldInput(){
        firstInput.setText(null);
        lastInput.setText(null);
    }
}
