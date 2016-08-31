import javax.swing.*;
import java.awt.*;

public class GridBag extends JFrame{

    Container container;
    JPanel pane;
    GridBagConstraints gbc;
    JLabel userInfo;
    JTextField userInput;
    JButton saveButton;

    public GridBag(){
        initComponent();

        gbc.gridwidth = 1;
        addModule(userInfo, "User name", 0, 0);
        gbc.gridwidth = 2;
        addModule(userInput, 17, 1, 0);
        gbc.gridwidth = 1;
        addModule(userInfo, "Last name", 0, 1);
        gbc.gridwidth = 2;
        addModule(userInput, 17, 1, 1);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        addModule(saveButton, "save", 1, 2);
        addModule(saveButton, "Cancel", 2, 2);

        container.add(pane);
        containerSettings();
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

}
