import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modifyModal extends JFrame implements ActionListener{


    Container container;
    GridBagConstraints gbc;
    JLabel userInfo;
    JButton saveButton, cancelButton;
    JPanel pane;
    JTextField fName, lName;

    public modifyModal(String msg){
        super(msg);
        container = getContentPane();
        pane = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        userInfo = new JLabel("First Name");
        modulePos(0, 0);
        pane.add(userInfo, gbc);

        userInfo = new JLabel("Last Name");
        modulePos(0, 1);
        pane.add(userInfo, gbc);

        fName = new JTextField(17);
        gbc.gridwidth = 3;
        modulePos(1, 0);
        pane.add(fName, gbc);

        lName = new JTextField(17);
        modulePos(1, 1);
        pane.add(lName, gbc);

        gbc.insets = new Insets(5, 2, 5, 2);

        saveButton = new JButton("Save");
        saveButton.setBackground(Color.decode("#5D9CEC"));
        saveButton.setBorderPainted(false);
        saveButton.setForeground(Color.decode("#D7E4F5"));
        gbc.gridwidth = 1;
        modulePos(1, 2);
        pane.add(saveButton, gbc);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.decode("#CCD1D9"));
        cancelButton.setBorderPainted(false);
        modulePos(2, 2);
        pane.add(cancelButton, gbc);

        container.add(pane);

        pack();
        setVisible(true);
    }

    public void modulePos(int x, int y){
        gbc.gridx = x;
        gbc.gridy = y;
    }

    public void setFirstNameField(String name){
        fName.setText(name);
    }
    public void setLastNameField(String name){
        lName.setText(name);
    }
    @Override
    public void actionPerformed(ActionEvent e){}
}
