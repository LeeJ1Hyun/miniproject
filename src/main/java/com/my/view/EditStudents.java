package com.my.view;

import mycom.my.student.model.StudentsService;
import mycom.my.student.model.StudentsDAO;
import mycom.my.student.model.StudentsDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditStudents extends javax.swing.JFrame implements ActionListener {

    private Menu menu;
    private StudentsDAO studentDao;
    private String[] strokeArr = {"자유형", "배영", "평영", "접영"};

    DecimalFormat formatter;

    public EditStudents() {
        initComponents();
        init();
        addEvent();
        formatter = new DecimalFormat("#,###");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        btEdit = new javax.swing.JButton();
        btDel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("수강생 정보 수정창");

        jLabel1.setText("수강생 정보 수정");

        jLabel3.setText("이름");

        jLabel4.setText("강사명");

        jLabel5.setText("영법");

        jLabel6.setText("관리자 번호");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "자유형", "배영", "평영", "접영" }));

        btEdit.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace_list\\nb_ws\\myproject\\src\\main\\java\\img\\icons8_check_file_15px.png")); // NOI18N
        btEdit.setText("수 정");

        btDel.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace_list\\nb_ws\\myproject\\src\\main\\java\\img\\icons8_Delete_15px.png")); // NOI18N
        btDel.setText("삭 제");

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace_list\\nb_ws\\myproject\\src\\main\\java\\img\\taxi-diver.png")); // NOI18N
        jLabel7.setText("jLabel7");

        btSearch.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace_list\\nb_ws\\myproject\\src\\main\\java\\img\\icons8_search_15px.png")); // NOI18N
        btSearch.setText("조 회");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, 212, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(btEdit)
                        .addGap(47, 47, 47)
                        .addComponent(btDel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSearch)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSearch))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btEdit)
                            .addComponent(btDel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDel;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btSearch;
    public javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    private void init() {
        studentDao = new StudentsDAO();

        DefaultComboBoxModel cmodel = new DefaultComboBoxModel(strokeArr);
        jComboBox2.setModel(cmodel);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addEvent() {
        btEdit.addActionListener(this);
        btDel.addActionListener(this);
        btSearch.addActionListener(this);
        jComboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("1.선택된 항목:" + e.getItem());
                    System.out.println("2.선택된 항목:" + jComboBox2.getSelectedItem()
                            + ", 선택된 index:" + jComboBox2.getSelectedIndex());
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btSearch) {
            try {
                SearchStudents();
            } catch (SQLException ex) {
                Logger.getLogger(EditStudents.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == btEdit) {
            try {
                EditStudents();
            } catch (SQLException ex) {
                Logger.getLogger(EditStudents.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == btDel) {
            try {
                DelStudents();
            } catch (SQLException ex) {
                Logger.getLogger(EditStudents.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void SearchStudents() throws SQLException {
        String name = jTextField1.getText();

        StudentsDTO dto = studentDao.selectStudents(name);

        jTextField1.setText(dto.getName());
        jTextField2.setText(dto.getTeachername());
        jComboBox2.setSelectedItem(dto.getStroke());
        jTextField3.setText(Integer.toString(dto.getNo()));
    }

    private void EditStudents() throws SQLException {
        String name = jTextField1.getText();

        String teachername = jTextField2.getText();
        String stroke = (String) jComboBox2.getSelectedItem();
        String No = jTextField3.getText();

        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "수강생명을 반드시 조회하세요");
            jTextField1.requestFocus();
            return;
        }

        StudentsDTO dto = new StudentsDTO();

          dto.setTeachername(teachername);
          dto.setStroke(stroke);
          dto.setNo(Integer.parseInt(No));
          dto.setName(name);

        int cnt = studentDao.updateStudents(dto);

        String msg = "";
        if (cnt > 0) {
            msg = "수강생 정보를 수정하였습니다.";
        } else {
            msg = "수정에 실패하였습니다.";
        }

        JOptionPane.showMessageDialog(this, msg);

    }

    private void DelStudents() throws SQLException {
        String name = jTextField1.getText();

        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "수강생명을 반드시 조회하세요");
            jTextField1.requestFocus();
            return;
        }

        String teachername = jTextField2.getText();
        String stroke = (String) jComboBox2.getSelectedItem();
        String No = jTextField3.getText();

        StudentsDTO dto = new StudentsDTO();

          dto.setTeachername(teachername);
          dto.setStroke(stroke);
          dto.setNo(Integer.parseInt(No));
          dto.setName(name);

        int cnt = studentDao.deleteStudents2(dto);

        String msg = "";
        if (cnt > 0) {
            msg = "수강생 정보를 삭제하였습니다.";
        } else {
            msg = "삭제에 실패하였습니다.";
        }

        JOptionPane.showMessageDialog(this, msg);

    }

}
