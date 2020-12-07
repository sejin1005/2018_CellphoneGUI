
package pkg201401950_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame { 
    
    JLabel l1 = new JLabel("번호");
    JTextField t1 = new JTextField(15);
    JButton b1 = new JButton("전화");
    JLabel lbl = new JLabel("번호를 입력해주세요.");
    JCheckBox chkBx = new JCheckBox("발신표시제한하기"); 
    ButtonGroup g = new ButtonGroup();
    JRadioButton rb1 = new JRadioButton("진동");
    JRadioButton rb2 = new JRadioButton("무음");
    JPanel p1 = new JPanel();
    
    Main(){ 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("전화기");
        setLayout(new FlowLayout());
        msMouseListener msml = new msMouseListener(); //마우스 이벤트 생성
        b1.addMouseListener(msml); 
        
        l1.setPreferredSize(new Dimension(50,25));       
        l1.setForeground(Color.black);
        l1.setBackground(Color.orange);
        l1.setOpaque(true);  
        
        b1.setForeground(Color.red); 
        b1.setBackground(Color.white);
        btnActionListener btnal = new btnActionListener(); 
        b1.addActionListener(btnal); 
        
        chkBx.addItemListener(new chkbxItemListener());
        
        add(l1);
        add(t1); 
        add(b1);
        p1.add(lbl);
        add(p1);
        
        add(chkBx);
        g.add(rb1);
        g.add(rb2);
        
        rdoItemListener rdoil = new rdoItemListener();
        rb1.addItemListener(new rdoltemListener());
        rb2.addItemListener(new rdoltemListener());
        add(rb1);
        add(rb2);
        
        setSize(340,200);
        setVisible(true);
 
    }
    private static class rdoItemListener {

        public rdoItemListener() {
        }
    }
    class btnActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String str1 = t1.getText(); 
            lbl.setText("010 1234 5678님이 "+str1+" 에게 전화를 거는 중..");   
        }
    }
    class chkbxItemListener implements ItemListener { 
        public void itemStateChanged(ItemEvent e) {
            if(chkBx.isSelected()) {
                String str2 = t1.getText(); 
                lbl.setText("1004님이 "+str2+" 에게 전화를 거는 중..");
            }
        }
    }
    class rdoltemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            String str = "";
            if(rb1.isSelected()){
                str = "벨소리를 진동으로 설정합니다.";
            }
            else {
                str = "벨소리를 무음으로 설정합니다.";
            }
            lbl.setText(str);
        }
    }
     class msMouseListener implements MouseListener { //마우스 메소드
        public void mouseEntered(MouseEvent e) {
            System.out.println("MOUSE IN");
        }
        public void mouseExited(MouseEvent e) {
            System.out.println("MOUSE OUT");
        }
        public void mousePressed(MouseEvent e){
            System.out.println("MOUSE PRESSED");
        }
        public void mouseReleased(MouseEvent e){
            System.out.println("MOUSE RELEASED");
        }
        public void mouseClicked(MouseEvent e){
            b1.setBackground(Color.yellow);
            System.out.println("MOUSE CLICKED");
        }
    }
    public static void main(String[] args) {
        new Main(); 
    }
} 