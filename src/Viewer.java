import javax.swing.*;
import java.awt.*;

public class Viewer {

    JFrame jframe;
    JPanel jpanel;
    JTextArea textArea;

    Viewer(){
        Controller controller = new Controller(this);
        jframe = new JFrame("SQL QUERY");

        jpanel = new JPanel();
        jpanel.setBackground(Color.white);
        jpanel.setBounds(50,250,500,300);

        textArea = new JTextArea();
        textArea.setBounds(55,255,540,350);

        JButton BTN1 = new JButton("Button 1");
        BTN1.addActionListener(controller);
        BTN1.setActionCommand("B1");

        JButton BTN2 = new JButton("Button 2");

        JButton BTN3 = new JButton("Button 3");

        JButton BTN4 = new JButton("Button 4");

        BTN1.setBounds(250,50,100,40);
        BTN2.setBounds(250,100,100,40);
        BTN3.setBounds(250,150,100,40);
        BTN4.setBounds(250,200,100,40);



        jframe.add(BTN1);
        jframe.add(BTN2);
        jframe.add(BTN3);
        jframe.add(BTN4);
        jframe.add(jpanel);
        jpanel.add(textArea);
        jframe.setSize(600,600);
        jframe.setLayout(null);
        jframe.setVisible(true);
    }

    void updateTextArea(String text){
        textArea.setText(text);
    }
}
