import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonActionListener extends JButton implements ActionListener{

    NameFrame frame;

    public ButtonActionListener(NameFrame thisFrame){
        frame = thisFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, frame.nameField.getText());
    }
}
