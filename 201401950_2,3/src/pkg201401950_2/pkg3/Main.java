
package pkg201401950_2.pkg3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    
    JLabel l1 = new JLabel("번호");
    JTextField t1 = new JTextField(10);
    JButton b1 = new JButton("전화");
    JLabel lbl = new JLabel("번호를 입력해주세요.");
    JCheckBox chkBx = new JCheckBox("발신표시제한하기"); //체크박스 생성
    
    Main() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("전화기");
        setLayout(new FlowLayout());
        
        l1.setPreferredSize(new Dimension(50,25));          
        l1.setForeground(Color.black);
        l1.setBackground(Color.orange);
        l1.setOpaque(true);  
        
        b1.setForeground(Color.red); 
        b1.setBackground(Color.yellow);
        btnActionListener btnal = new btnActionListener(); 
        b1.addActionListener(btnal); 
        
        chkBx.addItemListener(new chkbxItemListener()); //체크박스 리스너
       
        add(l1);
        add(t1); 
        add(b1);
        add(lbl);
        add(chkBx);
        setSize(340,200);
        setVisible(true);
 
    }
    class btnActionListener implements ActionListener { //버튼 메소드
        public void actionPerformed(ActionEvent e){
            String str1 = t1.getText(); 
            lbl.setText("010 1234 5678님이 "+str1+" 에게 전화를 거는 중..");   
        }
    }
    class chkbxItemListener implements ItemListener { //체크박스 메소드
        public void itemStateChanged(ItemEvent e) {
            if(chkBx.isSelected()) {
                String str2 = t1.getText(); 
                lbl.setText("1004님이 "+str2+" 에게 전화를 거는 중..");
            }
        }
    }
    public static void main(String[] args) {
        new Main(); 
    }
} 