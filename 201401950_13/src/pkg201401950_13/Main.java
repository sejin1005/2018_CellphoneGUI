
package pkg201401950_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
    JPanel psld;
    JPanel pebook;
    JTextArea ta;
    JScrollPane sp; 
    JList jl;
    JLabel notelbl;
    JLabel TELlbl;
    JComboBox cb;
    JSlider sld;
    JLabel sldlbl;
    JTextArea ebook;
    JLabel ebooklbl;
    File file;
    smile gsmile;
    JMenuBar mb; //메뉴바 생성
    JMenu mn; // 메뉴 생성
    JMenuItem airplo, airplx; //메뉴 아이템 생성
            
    Main() throws FileNotFoundException {
        l1 = new JLabel("번호");
        t1 = new JTextField(" ",15);
        b1 = new JButton("전화");
        lbl = new JLabel("번호를 입력해주세요.");
        chkBx = new JCheckBox("발신표시제한하기"); 
        g = new ButtonGroup(); 
        rb1 = new JRadioButton("진동");
        rb2 = new JRadioButton("무음");
        psld = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        pebook = new JPanel();
        mb = new JMenuBar();
        mn = new JMenu("비행기모드");
        airplo = new JMenuItem("설정"); //비행기모드가 실행되서 통화 불가능
        airplx = new JMenuItem("해제"); //비행기모드가 해제되서 통화 가능

        ta = new JTextArea();
        sp = new JScrollPane(ta);
        ebook = new JTextArea();
        ebooklbl = new JLabel("<<  e-book 대출 목록  >> ");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("스마트폰");
        setLayout(new GridLayout(7,0));
        
        String[] note = {"1. 점장님한테 7월 대청소 빠진다고 연락하기",
                         "2. 고3때 친구들이랑 여행약속잡기"};
        jl = new JList(note);
        notelbl = new JLabel("메모 >> ");
        
        String[] TEL = {"     점장님     ","     (애칭)강아지들     ","     한국장학재단     "};
        cb = new JComboBox(TEL);
        cb.addActionListener(new cbAL());
        TELlbl = new JLabel(" 주소록 >> ");
        
        sldlbl = new JLabel("통화소리조절 >> ");
        sld = new JSlider(JSlider.HORIZONTAL,0,200,50);
        sld.setPaintTicks(true); //눈금 표시
        sld.setMajorTickSpacing(100); //큰 눈금 간격
        sld.setMinorTickSpacing(50); //작은 눈금 간격
        sld.setPaintLabels(true); //눈금에 숫자 표시 
        sld.setForeground(new Color(0,200,0));
        sldlbl.setForeground(new Color(0,200,0));
                
        psld.add(sldlbl);
        psld.add(sld);
        
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
        
        gsmile = new smile();
        gsmile.setPreferredSize(new Dimension(75,75));
        
        lbl.setOpaque(true);
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
        
        file = new File("ebook.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNext()) {
                String rent = sc.nextLine();
                ebook.append(rent + "\n");
        }
        pebook.add(ebooklbl);
        pebook.add(ebook);
          
        mn.add(airplo); // 윈도우 화면에 출력
        mn.add(airplx); // 윈도우 화면에 출력
        mb.add(mn); // 윈도우 화면에 출력
        this.setJMenuBar(mb); // 윈도우 화면에 출력
        airplx.addActionListener(new AirplEvent());
        airplo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b1.setText("비행기 모드: 전화X");
                lbl.setOpaque(false);
            }
        });
        
        add(psld);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(pebook);
        
        setSize(400,750);
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
            sld.addChangeListener(new sldL());
            p2.add(gsmile); //윈도우화면에 그래픽 출력됨.
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
                lbl.setOpaque(false); 
                str = "벨소리를 진동으로 설정합니다.";
            }
            else {
                lbl.setOpaque(false); 
                str = "벨소리를 무음으로 설정합니다.";
            }
            lbl.setText(str);
        }
    }
    class cbAL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cbItem = (String)cb.getSelectedItem();
            TEL tel = new TEL(cbItem);
            String print = tel.add();
            outclass oc = new outclass(t1,cbItem);
            sld.addChangeListener(new sldL());
            lbl.setText(print);
        }
    }
    class sldL implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            JSlider s = (JSlider) e.getSource();
            int gr = sld.getValue();
            System.out.println("통화소리크기는 " + gr + " 입니다.");
            lbl.setBackground(new Color(gr,255,0)); 
        }
    }
    class smile extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.yellow);
            g.fillOval(10, 20, 50, 50); //얼굴
            g.setColor(Color.black);
            g.drawArc(20, 30, 12, 12, 180,-180); //왼쪽눈
            g.drawArc(40, 30, 12, 12, 180,-180); //오른쪽눈
            g.drawArc(30, 40, 15, 15, 180, 180); //입
        }
    }
    class AirplEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            b1.setText("전화");
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
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
