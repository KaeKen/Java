import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GridBag extends JFrame implements ActionListener{

    JLabel firstnamelabel, lastnamelabel;
    JTextField firstnamefield, lastnamefield;
    JButton save, delete, modify;
    JTable table;
    JScrollPane scroll;
    TableModel tablemodel;
    Container container;
    GridBagLayout layout;
    GridBagConstraints g;
    Modify edit;

    public GridBag(){
        init();
        add();

        this.pack();
    }

    private void init(){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstnamelabel = new JLabel("Firstname");
        lastnamelabel = new JLabel("Lastname");

        firstnamefield = new JTextField();
        lastnamefield = new JTextField();

        save = new JButton("Save");
        delete = new JButton("Delete");
        modify = new JButton("Modify");

        tablemodel = new TableModel();
        table = new JTable(tablemodel);
        scroll = new JScrollPane(table);

        edit = new Modify();

        container = this.getContentPane();
        this.layout = new GridBagLayout();
        g = new GridBagConstraints();
        container.setLayout(this.layout);

        save.addActionListener(this);
        delete.addActionListener(this);
        modify.addActionListener(this);

    }

    private void add(){
//		text
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 1;
        container.add(firstnamelabel, g);
        g.gridx = 0;
        g.gridy = 1;
        container.add(lastnamelabel, g);
//		textfield
        g.gridx = 1;
        g.gridy = 0;
        g.gridwidth = 3;
        g.fill = GridBagConstraints.HORIZONTAL;
        container.add(firstnamefield, g);
        g.gridy = 1;
        g.gridx = 1;
        container.add(lastnamefield, g);
//		button
        g.gridx = 1;
        g.gridy = 2;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.NONE;
        container.add(save, g);
        g.gridx = 2;
        g.gridy = 2;
        container.add(delete, g);
        g.gridx = 3;
        g.gridy = 2;
        g.anchor = GridBagConstraints.LAST_LINE_START;
        container.add(modify, g);
//		table
        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 4;
        g.anchor = GridBagConstraints.CENTER;
        container.add(scroll, g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save){
            tablemodel.persons.add(new Person(firstnamefield.getText(), lastnamefield.getText()));
            clearfield();
        }else if (e.getSource() == delete){
            tablemodel.persons.remove(table.getSelectedRow());
        }else if(e.getSource() == modify){
            int s = table.getSelectedRow();
            if(s == -1){
                JOptionPane.showMessageDialog(null, "Please Select a Row");
            }else{
                edit.setVisible(true);
                edit.firstnamefield.setText(tablemodel.persons.get(s).getFirstname());
                edit.lastnamefield.setText(tablemodel.persons.get(s).getLastname());
                edit.save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        tablemodel.persons.get(s).setFirstname(edit.firstnamefield.getText());
                        tablemodel.persons.get(s).setLastname(edit.lastnamefield.getText());
                        tablemodel.fireTableDataChanged();
                        edit.setVisible(false);
                    }
                });
                edit.cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        edit.setVisible(false);
                    }
                });
            }
        }
        tablemodel.fireTableDataChanged();

    }

    public void clearfield(){
        firstnamefield.setText(null);
        lastnamefield.setText(null);
    }
}
