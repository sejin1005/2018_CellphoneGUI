
package move;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class move extends javax.swing.JFrame {
    btnActionListener btnal; //버튼 이벤트 생성
    rdoItemListener rdoil; //라디오버튼 이벤트 생성
    msMouseListener msml; //마우스 이벤트 생성
    File file;
    smile gsmile;
    
    public move() throws FileNotFoundException {
        setTitle("스마트폰");
        initComponents();
        btnal = new btnActionListener();
        b1.setBackground(Color.white);
        b1.addActionListener(btnal);//버튼 리스너에 연결
        rdoil = new rdoItemListener(); 
        rb1.addItemListener(new rdoltemListener()); //라디오버튼 리스너에 연결
        rb2.addItemListener(new rdoltemListener()); //라디오버튼 리스너에 연결
        msml = new msMouseListener();
        b1.addMouseListener(msml);
        chkBx.addItemListener(new chkbxItemListener());
        t1.addKeyListener(new kbdKeyListener()); //체크박스 리스너에 연결 
        t1.setFocusable(true);
        cb.addActionListener(new cbAL());
        sld = new JSlider(JSlider.HORIZONTAL,0,200,50);//슬라이드 범위 지정
        sld.setPaintTicks(true); //눈금 표시
        sld.setMajorTickSpacing(100); //큰 눈금 간격
        sld.setMinorTickSpacing(50); //작은 눈금 간격
        sld.setPaintLabels(true); //눈금에 숫자 표시 
        sld.setForeground(new Color(0,200,0)); // 슬라이드 눈금색: 녹색
        
        file = new File("ebook.txt"); //ebook.txt 파일의 열기
        Scanner sc = new Scanner(file); //스캐너 생성
        while(sc.hasNext()) { 
                String rent = sc.nextLine(); //한 줄 씩 스캔
                ebook.append(rent + "\n"); //한 줄 씩 출력
        }
        
        gsmile = new smile(); 
        gsmile.setPreferredSize(new Dimension(60,60));
        
        airplx.addActionListener(new AirplEvent());
        airplo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b1.setText("비행기 모드: 전화X");
                lbl.setOpaque(false);
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        l1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        b1 = new javax.swing.JButton();
        ebooklbl = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        sld = new javax.swing.JSlider();
        rb1 = new javax.swing.JRadioButton();
        chkBx = new javax.swing.JCheckBox();
        sldlbl = new javax.swing.JLabel();
        psmile = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        rb2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ebook = new javax.swing.JTextArea();
        mb = new javax.swing.JMenuBar();
        mn = new javax.swing.JMenu();
        airplo = new javax.swing.JMenuItem();
        airplx = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        l1.setBackground(new java.awt.Color(204, 255, 255));
        l1.setText("                 번호");
        l1.setOpaque(true);

        b1.setText("전화");

        ebooklbl.setBackground(new java.awt.Color(255, 255, 153));
        ebooklbl.setText("                                                                   e-book 대출 목록         ");
        ebooklbl.setOpaque(true);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "점장님", "강아지들", "한국장학재단" }));
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });

        rb1.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup2.add(rb1);
        rb1.setText("          진동");

        chkBx.setBackground(new java.awt.Color(255, 255, 204));
        chkBx.setText("          발신 표시 제한");
        chkBx.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxItemStateChanged(evt);
            }
        });

        sldlbl.setBackground(new java.awt.Color(204, 255, 255));
        sldlbl.setText("           통화소리조절");
        sldlbl.setOpaque(true);

        psmile.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout psmileLayout = new javax.swing.GroupLayout(psmile);
        psmile.setLayout(psmileLayout);
        psmileLayout.setHorizontalGroup(
            psmileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        psmileLayout.setVerticalGroup(
            psmileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        lbl.setText("           번호를 입력해주세요.");

        rb2.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup2.add(rb2);
        rb2.setText("          무음");

        ebook.setColumns(20);
        ebook.setRows(5);
        jScrollPane1.setViewportView(ebook);

        mn.setText("비행기모드");

        airplo.setText("설정");
        mn.add(airplo);

        airplx.setText("해제");
        mn.add(airplx);

        mb.add(mn);

        setJMenuBar(mb);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ebooklbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(l1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(psmile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sldlbl, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(rb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(sld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rb2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(chkBx, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb1)
                    .addComponent(rb2)
                    .addComponent(chkBx))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldlbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psmile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ebooklbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbActionPerformed

    private void chkBxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBxItemStateChanged

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new move().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(move.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem airplo;
    private javax.swing.JMenuItem airplx;
    private javax.swing.JButton b1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JCheckBox chkBx;
    private javax.swing.JTextArea ebook;
    private javax.swing.JLabel ebooklbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel lbl;
    private javax.swing.JMenuBar mb;
    private javax.swing.JMenu mn;
    private javax.swing.JPanel psmile;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JSlider sld;
    private javax.swing.JLabel sldlbl;
    private javax.swing.JTextField t1;
    // End of variables declaration//GEN-END:variables
    class btnActionListener implements ActionListener { //버튼 메소드
        public void actionPerformed(ActionEvent e){
            String str1 = t1.getText(); 
            lbl.setText("   010-1234-5678   >>>>>>>>>   "+str1);
            sld.addChangeListener(new sldL());
            lbl.setOpaque(true);
            psmile.add(gsmile);
            
        }
    }
    class chkbxItemListener implements ItemListener { //체크박스 메소드
        public void itemStateChanged(ItemEvent e) {
            if(chkBx.isSelected()) {
                String str2 = t1.getText(); 
                lbl.setText("    1004   >>>>>>>>>   "+str2);
            }
        }
    }
    private static class rdoItemListener {

        public rdoItemListener() {
        }
    }
    class rdoltemListener implements ItemListener { //라디오버튼 메소드
        public void itemStateChanged(ItemEvent e) {
            String str = "";
            if(rb1.isSelected()){
                lbl.setOpaque(false); 
                b1.setBackground(Color.white);
                str = "벨소리를 진동으로 설정합니다.";
            }
            else {
                lbl.setOpaque(false); 
                b1.setBackground(Color.white);
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
    class kbdKeyListener implements KeyListener { //키보드 메소드
        public void keyPressed(KeyEvent e) {
            char key = e.getKeyChar();
            System.out.println(key + "를 눌렀습니다."); 
        }
        public void keyReleased(KeyEvent e) {
            
        }
        public void keyTyped(KeyEvent e) {
            
        }    
    }
    class cbAL implements ActionListener { //콤보박스 메소드
        public void actionPerformed(ActionEvent e) {
            String cbItem = (String)cb.getSelectedItem();
            TEL tel = new TEL(cbItem);
            String print = tel.add();
            outclass oc = new outclass(t1,cbItem);
            sld.addChangeListener(new sldL());
            b1.setBackground(Color.yellow);
            lbl.setOpaque(true);
            lbl.setText(print);
        }
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
    class sldL implements ChangeListener { //슬라이드 메소드
        public void stateChanged(ChangeEvent e) {
            JSlider s = (JSlider) e.getSource();
            int gr = sld.getValue();
            System.out.println("통화소리크기는 " + gr + " 입니다.");
            lbl.setBackground(new Color(gr,255,0)); 
        }
    }
    class smile extends JPanel { //그래픽 메소드
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
}
