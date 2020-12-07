
package pkg201401950_9;

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
    JLabel TELlbl;
    JComboBox cb;
            
    Main() {
        
        l1 = new JLabel("번호");
        t1 = new JTextField(" ",15);
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
        jl = new JList(note);
        notelbl = new JLabel("메모 >> ");
        
        String[] TEL = {"     점장님     ","     (애칭)강아지들     ","     한국장학재단     "}; 
        cb = new JComboBox(TEL); // 콤보박스 생성
        cb.addActionListener(new cbAL()); //콤보박스 리스너 연결
        TELlbl = new JLabel(" 주소록 >> ");
        
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
        
        p4.add(TELlbl);
        p4.add(cb);
        
        p5.add(notelbl);
        DefaultListModel dlm = new DefaultListModel();
        jl = new JList(dlm);
        for(int i = 0; i< note.length; i++)
            dlm.add(i,note[i]);
        Note read = new Note();
        dlm.addElement(read.nt);
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
    class cbAL implements ActionListener { //콤보박스 메소드
        public void actionPerformed(ActionEvent e) {
            String cbItem = (String)cb.getSelectedItem();
            TEL tel = new TEL(cbItem); //TEL라는 외부클래스 객체 생성
            String print = tel.add(); //TEL에 있는 add메소드 사용
            outclass oc = new outclass(t1,cbItem);
            lbl.setText(print); 
        }
    }
    public static void main(String[] args) {
        new Main(); 
    }
    class outclass {
        JTextField tf;
        String outStr;
        outclass(JTextField t, String s){
            tf = t;
            outStr = s;
            tf.setText(outStr);
        }
    }
} 