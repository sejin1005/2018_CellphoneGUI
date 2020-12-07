
package pkg201401950_1;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame { 
    
    Main() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("전화번호 입력창");
        
        setLayout(new FlowLayout());
        
        JLabel l1 = new JLabel("번호 "); 
        l1.setPreferredSize(new Dimension(50,25));
        l1.setForeground(Color.black); //글씨 색
        l1.setBackground(Color.orange);//배경 색
        l1.setOpaque(true); //배경색 보이게 설정. 
        
        JTextField t1 = new JTextField(15);
        
        JButton b1 = new JButton("전화");
        b1.setForeground(Color.red);  //글씨 색
        b1.setBackground(Color.yellow); //배경 색
        
        add(l1);
        add(t1); 
        add(b1);
        
        JPanel p1 = new JPanel(); 
        p1.setLayout(new GridLayout(2,2));
        JButton c1 = new JButton("1");
        JButton c2 = new JButton("2");
        JButton c3 = new JButton("3");
        JButton c4 = new JButton("4");
        JButton c5 = new JButton("5");
        JButton c6 = new JButton("6");
        JButton c7 = new JButton("7");
        JButton c8 = new JButton("8");
        JButton c9 = new JButton("9");
        JButton c0 = new JButton("0");
        
        p1.add(c1); 
        p1.add(c2); 
        p1.add(c3); 
        p1.add(c4);
        p1.add(c5);
        p1.add(c6);
        p1.add(c7);
        p1.add(c8);
        p1.add(c9);
        p1.add(c0);
        add(p1);
        
        setSize(400,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Main(); 
    }  
}