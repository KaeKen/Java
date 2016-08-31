    import javax.swing.*;
    import java.awt.*;
import java.awt.event.*;

public class BorderFrame extends JFrame implements ActionListener{

    JPanel buttonsPanel;
    Container container;
    JButton cancelButton;
    JPanel cancelButtonPanel;
    JTextField digitField;

    public BorderFrame(){


        digitField = new JTextField(10);

        buttonsPanel = new JPanel(new GridLayout(5,4));
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        cancelButtonPanel = new JPanel(new GridLayout(1,1));

        cancelButtonPanel.add(new JButton("Clear"));

        String[] buttonString = {"7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "/",
                ".", "0", "*", "=",
                "+/-", "√", "^2", "%"};

        for(int i = 0; i < buttonString.length; buttonsPanel.add(new JButton(buttonString[i])), i++); // one-liner


        container.add(buttonsPanel, BorderLayout.CENTER);
        container.add(digitField, BorderLayout.NORTH);
        container.add(cancelButtonPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        digitField.setText("test");
    }

}







