import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Viewer {

    JFrame jframe;
    JPanel jpanel;
    //JTextArea textArea;
    JScrollPane scroll;


    Viewer(){
        Controller controller = new Controller(this);
        jframe = new JFrame("SQL QUERY");

        /*JScrollBar sb = new JScrollBar();
        sb.setOrientation(1);
        sb.setBackground(Color.black);
        sb.setBounds(0,0,10,10);
        sb.setVisible(true);*/

        JPanel panelButtons = new JPanel();

        Border border1 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

        TitledBorder border2 = BorderFactory.createTitledBorder(border1, "Interaction into Suppliers Table in DataBase");
        border2.setTitleJustification(TitledBorder.CENTER);

        Border border3 = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border border4 = BorderFactory.createCompoundBorder(border3, border2);
        panelButtons.setBorder(border4);

        BoxLayout boxLayout = new BoxLayout(panelButtons, BoxLayout.Y_AXIS);
        panelButtons.setLayout(boxLayout);

        jpanel = new JPanel();
        jpanel.setBackground(Color.white);
        jpanel.setBounds(50,250,500,300);

        //textArea = new JTextArea();
        //textArea.setBounds(55,255,540,350);
        scroll = new JScrollPane();
        scroll.setBounds(0,0,540,350);
        //scroll.setHorizontalScrollBar(sb);


        jpanel.setLayout(null);

        jpanel.add(scroll);

        JButton BTN1 = new JButton("Button 1");
        BTN1.setAlignmentX(panelButtons.CENTER_ALIGNMENT);
        BTN1.addActionListener(controller);
        BTN1.setActionCommand("B1");

        JButton BTN2 = new JButton("Button 2");

        JButton BTN3 = new JButton("Button 3");

        JButton BTN4 = new JButton("Button 4");

        JButton BTN5 = new JButton("Button 5");

        //BTN1.setBounds(250,50,100,40);
        BTN2.setBounds(250,100,100,40);
        BTN3.setBounds(250,150,100,40);
        BTN4.setBounds(250,200,100,40);
        BTN5.setBounds(250,600,100,40);

        panelButtons.add(BTN1);

        jframe.add(BTN1);
        jframe.add(BTN2);
        jframe.add(BTN3);
        jframe.add(BTN4);
        jframe.add(BTN5);
        jframe.add(jpanel);
        jframe.getContentPane().add(panelButtons, BorderLayout.NORTH);
        //jpanel.add(textArea);
        jframe.setSize(600,700);
        jframe.setLayout(null);
        jframe.setVisible(true);
    }

    void updateTextArea(String text){
        //textArea.setText(text);
    }
    void updateTextArea(JTable table){
        if (table != null){
            //table.setBounds(0,0,500,300);
            //jpanel.add(table);

            //JTable tableSuppliers = table;
            JViewport port = scroll.getViewport();
            port.add(table);
        }

        //textArea.setText(text);
    }
}
