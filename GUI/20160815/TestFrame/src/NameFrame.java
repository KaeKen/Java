import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;



public class NameFrame extends JFrame {

    JLabel label;
    Container container;
    JTextField nameField;
    JButton saveButton;
    ButtonActionListener button;

    public NameFrame(String title){

        super(title);

        container = this.getContentPane();
        container.setLayout(new FlowLayout());

        label = new JLabel("name");
        nameField = new JTextField(10);
        saveButton = new JButton("Submit");
        //saveButton.addActionListener(this);
        saveButton.addActionListener(button);

        container.add(label);
        container.add(nameField);
        container.add(saveButton);

        this.setVisible(true);
        this.setSize(450,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent arg0){

    }

}
