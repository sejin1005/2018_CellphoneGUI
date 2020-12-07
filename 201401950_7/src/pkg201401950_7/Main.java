
package pkg201401950_7;

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
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JTextArea ta = new JTextArea(); //텍스트에어리어 생성
    JScrollPane sp = new JScrollPane(ta); //스크롤바 생성 후 텍스트에어리어 연결
            
    Main(){ 
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("전화기");
        setLayout(new GridLayout(4,0));
        
        l1.setPreferredSize(new Dimension(50,25));          
        l1.setForeground(Color.black);
        l1.setBackground(Color.orange);
        l1.setOpaque(true);  
        
        b1.setForeground(Color.red); 
        b1.setBackground(Color.yellow);
        btnActionListener btnal = new btnActionListener(); 
        b1.addActionListener(btnal); 
        
        chkBx.addItemListener(new chkbxItemListener());
        
        p1.add(l1);
        p1.add(t1); 
        p1.add(b1);
        
        p2.add(lbl);
       
        p3.add(chkBx);
        g.add(rb1);
        g.add(rb2);
        
        rdoItemListener rdoil = new rdoItemListener();
        rb1.addItemListener(new rdoltemListener());
        rb2.addItemListener(new rdoltemListener());
        p3.add(rb1);
        p3.add(rb2);
        
        p4.add(sp);
        ta.append("당일 발신표시제한 발신 목록 >> \n"); //텍스트에어리어 첫줄에 표시
        chkBx.addActionListener(new tfAL());
        
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        
        setSize(340,300);
        setVisible(true);
    }
    private static class rdoItemListener {

        public rdoItemListener() {
        }
    }
    class btnActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String str1 = t1.getText(); 
            lbl.setText("010-1234-5678   >>>>>>>>>   "+str1); 
        }
    }
    class chkbxItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if(chkBx.isSelected()) {
                String str2 = t1.getText(); 
                lbl.setText("    1004   >>>>>>>>>   "+str2);
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
    class tfAL implements ActionListener { //텍스트에어리어 메소드
        public void actionPerformed(ActionEvent e) {
            ta.append(t1.getText()+"\n");
            t1.setText(""); //텍스트필드 클리어 = 중복텍스트 방지.       
        }
    }
    public static void main(String[] args) {
        new Main(); 
    }
} 