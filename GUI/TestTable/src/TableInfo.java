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
    JTextArea textArea;
    JButton button, saveButton;
    JTable table;
    PersonTableModel personTable;
    JScrollPane scrollTable;

    public TableInfo(){
        initComponent();

        gbc.gridwidth = 1;
        addModule(userInfo, "First name", 0, 0);

        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //addModule(firstInput, 17, 1, 0);

        firstInput = new JTextField(17);
        gbc.gridx = 1;
        gbc.gridy = 0;
        pane.add(firstInput, gbc);

        gbc.gridwidth = 1;
        addModule(userInfo, "Last name", 0, 1);

        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        lastInput = new JTextField(17);
        gbc.gridx = 1;
        gbc.gridy = 1;
        pane.add(lastInput, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        saveButton = new JButton("Add");
        gbc.gridx = 1;
        gbc.gridy = 2;
        saveButton.addActionListener(this);
        pane.add(saveButton, gbc);
        addModule(button, "Delete", 2, 2);
        gbc.gridwidth = 1;
        addModule(button, "Modify", 3, 2);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 6;
        personTable = new PersonTableModel();
        table = new JTable(personTable);
        pane.add(new JScrollPane(table), gbc);




        container.add(pane);
        containerSettings();
        pack();
    }

    public void addModule(JLabel thisLabel, String msg, int x, int y){
        thisLabel = new JLabel(msg);
        modulePos(x, y);
        pane.add(thisLabel, gbc);
    }
    public void addModule(JTextField thisField, int length, int x, int y){
        thisField = new JTextField(length);
        modulePos(x, y);
        pane.add(thisField, gbc);
    }
    public void addModule(JButton thisButton, String msg, int x, int y){
        thisButton = new JButton(msg);
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

    @Override
    public void actionPerformed(ActionEvent e){
        personTable.getPersons().add(new Person(firstInput.getText(), lastInput.getText()));
        personTable.fireTableDataChanged();
    }

}
