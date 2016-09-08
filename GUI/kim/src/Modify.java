import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Modify extends JFrame{

    JLabel firstnamelabel, lastnamelabel;
    JTextField firstnamefield, lastnamefield;
    JButton save, cancel;
    Container container;
    GridBagLayout layout;
    GridBagConstraints g;

    public Modify(){
        init();
        add();

        this.pack();
    }

    private void init(){
        this.setVisible(false);

        firstnamelabel = new JLabel("Firstname");
        lastnamelabel = new JLabel("Lastname");

        firstnamefield = new JTextField();
        lastnamefield = new JTextField();

        save = new JButton("Save");
        cancel = new JButton("Cancel");

        container = this.getContentPane();
        this.layout = new GridBagLayout();
        g = new GridBagConstraints();
        container.setLayout(this.layout);


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
        container.add(cancel, g);

    }

}
