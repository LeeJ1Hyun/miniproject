package com.my.view;

import mycom.my.student.model.StudentsDAO;
import mycom.my.student.model.StudentsDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.*;
import java.text.*;

public class AddStudents extends javax.swing.JFrame implements ActionListener {

    private Menu menu;
    private StudentsDAO studentDao;
    private String[] strokeArr = {"자유형", "배영", "평영", "접영"};

    DecimalFormat formatter;

    public AddStudents() {
        initComponents();
        init();
        addEvent();
        formatter = new DecimalFormat("#,###");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfteachername = new javax.swing.JTextField();
        tfNo = new javax.swing.JTextField();
        cbStroke = new javax.swing.JComboBox<>();
        btRegister = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("신규 수강생 등록창");

        jLabel1.setText("이름");

        jLabel2.setText("강사명");

        jLabel3.setText("영법");

        jLabel4.setText("관리자번호");

        cbStroke.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "자유형", "배영", "평영", "접영" }));

        btRegister.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace_list\\nb_ws\\myproject\\src\\main\\java\\img\\icons8_save_15px.png")); // NOI18N
        btRegister.setText("저 장");

        jLabel6.setText("신규 수강생 등록");

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace_list\\nb_ws\\myproject\\src\\main\\java\\img\\taxi-sing-in.png")); // NOI18N
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addComponent(btRegister))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfName)
                            .addComponent(tfteachername)
                            .addComponent(cbStroke, 0, 182, Short.MAX_VALUE)
                            .addComponent(tfNo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel6)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfteachername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbStroke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addComponent(btRegister)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegister;
    public javax.swing.JComboBox<String> cbStroke;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tfName;
    public javax.swing.JTextField tfNo;
    private javax.swing.JTextField tfteachername;
    // End of variables declaration//GEN-END:variables

    private void init() {
        studentDao = new StudentsDAO();

        DefaultComboBoxModel cmodel = new DefaultComboBoxModel(strokeArr);
        cbStroke.setModel(cmodel);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addEvent() {
        btRegister.addActionListener(this);
        cbStroke.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("1.선택된 항목:" + e.getItem());
                    System.out.println("2.선택된 항목:" + cbStroke.getSelectedItem()
                            + ", 선택된 index:" + cbStroke.getSelectedIndex());
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btRegister) {
            try {
                SaveStudents();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void SaveStudents() throws SQLException {
        String name = tfName.getText();
        String teachername = tfteachername.getText();
        String stroke = (String) cbStroke.getSelectedItem();
        String No = (String) tfNo.getText(); //(String) 안해줘도 오류 안떴음 why?

        if (tfName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "이름을 작성해주세요.");
            tfName.requestFocus();
            return;
        } else if (tfteachername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "강사명을 작성해주세요.");
            tfteachername.requestFocus();
            return;
        } else if (tfNo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "관리자번호를 작성해주세요.");
            tfNo.requestFocus();
            return;
        }

        StudentsDTO dto = new StudentsDTO();
        dto.setName(name);
        dto.setTeachername(teachername);
        dto.setStroke(stroke);
        dto.setNo(Integer.parseInt(No));

        int cnt = studentDao.insertStudents(dto);
        String msg = "";
        if (cnt > 0) {
            msg = "새로운 수강생이 등록되었습니다!";
            this.dispose();
        } else {
            msg = "회원가입 실패";
        }
        JOptionPane.showMessageDialog(this, msg);
    }
}
