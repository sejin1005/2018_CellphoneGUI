
package pkg201401950_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame { 
    
    JLabel l1;
    JTextField t1;
    JButton b1;
    JLabel lbl;
    JCheckBox chkBx; 
    ButtonGroup g; 
    JRadioButton rb1;
    JRadioButton rb2;
    JPanel p1;
    JPanel p2;
    JPanel p3;
    JPanel p4;
    JPanel p5;
    JTextArea ta;
    JScrollPane sp; 
    JList jl;
    JLabel notelbl;
            
    Main(){
        l1 = new JLabel("번호");
        t1 = new JTextField(15);
        b1 = new JButton("전화");
        lbl = new JLabel("번호를 입력해주세요.");
        chkBx = new JCheckBox("발신표시제한하기"); 
        g = new ButtonGroup(); 
        rb1 = new JRadioButton("진동");
        rb2 = new JRadioButton("무음");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        ta = new JTextArea();
        sp = new JScrollPane(ta);
        
        String[] note = {"1. 점장님한테 7월 대청소 빠진다고 연락하기", 
                         "2. 고3때 친구들이랑 여행약속잡기"};
        jl = new JList(note); //note에 저장된 값을 JList로 생성
        notelbl = new JLabel("메모 >> ");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("전화기");
        setLayout(new GridLayout(5,0));
        
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
        ta.append("           당일 발신표시제한 발신 목록     >>    \n");
        chkBx.addActionListener(new tfAL());
        
        p5.add(notelbl);
        DefaultListModel dlm = new DefaultListModel(); //DefaultListMOdel 생성
        jl = new JList(dlm); //JList에 DefaultListModel 연결
        for(int i = 0; i< note.length; i++)
            dlm.add(i,note[i]); //dlm에 JList 값 출력
        Note read = new Note(); //노트메소드 객체 생성
        dlm.addElement(read.nt); //노트메소드에 저장된 값 dlm에 출력
        p5.add(jl);
        
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        
        setSize(350,400);
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
    class tfAL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ta.append(t1.getText()+"\n");
            t1.setText("");      
        }
    }
    public static void main(String[] args) {
        new Main(); 
    }
} 