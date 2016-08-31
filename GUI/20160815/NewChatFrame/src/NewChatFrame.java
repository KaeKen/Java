import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NewChatFrame extends JFrame{

    Container container;

    JPanel chatPanel, textPanel, headingPanel, buttonPanel;
    JTextField messageField;
    JTextArea chatArea, sideArea;
    JButton sendButton;

    public NewChatFrame(){

        super("Keen");

        container = this.getContentPane();

        headingPanel = new JPanel();
        chatPanel = new JPanel();
        sideArea = new JTextArea(600,12);
        chatArea = new JTextArea(600,40);
        textPanel = new JPanel();
        messageField = new JTextField(35);
        buttonPanel = new JPanel();
        sendButton = new JButton("Send");

        container.setLayout(new BorderLayout());
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        chatPanel.setLayout(new FlowLayout());
        textPanel.setLayout(new FlowLayout());
        messageField.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        headingPanel.add(new JLabel("Chat  v2"));
        chatPanel.add(sideArea, BorderLayout.WEST);
        chatPanel.add(chatArea, BorderLayout.EAST);
        buttonPanel.add(sendButton);
        textPanel.add(messageField);
        textPanel.add(buttonPanel);

        container.add(headingPanel, BorderLayout.NORTH);
        container.add(chatPanel, BorderLayout. CENTER);
        container.add(textPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}