import javax.swing.*;
import java.awt.*;

public class RegisterData extends JFrame{

    Container container;
    JPanel userDataPanel, productDataPanel, formPanel, formContainerPanel;
    JLabel userLabel, productLabel;

    public RegisterData(){

        container = getContentPane();

        userDataPanel = new JPanel();
        productDataPanel = new JPanel();
        formPanel = new JPanel();
        formContainerPanel = new JPanel();
        userLabel = new JLabel();
        productLabel = new JLabel();

        formPanel.setLayout(new GridLayout(1,5));
        formContainerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        userDataPanel.add(new JLabel("User name"), FlowLayout.LEFT);
        userDataPanel.add(new JTextField(17));
        formPanel.add(userDataPanel);
        userDataPanel.add(new JLabel("Full name"), FlowLayout.LEFT);
        userDataPanel.add(new JTextField(17));
        formPanel.add(userDataPanel);
        userDataPanel.add(new JLabel("Email Address"), FlowLayout.LEFT);
        userDataPanel.add(new JTextField(12));
        formPanel.add(userDataPanel);
        userDataPanel.add(new JLabel("Password"), FlowLayout.LEFT);
        userDataPanel.add(new JTextField(12));
        formPanel.add(userDataPanel);
        userDataPanel.add(new JLabel("Confirm Password"), FlowLayout.LEFT);
        userDataPanel.add(new JTextField(12));
        formPanel.add(userDataPanel);

        formContainerPanel.add(formPanel);
        add(formContainerPanel, BorderLayout.CENTER);


        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
