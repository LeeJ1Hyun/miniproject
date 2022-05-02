package com.my.view;

import mycom.my.stroke.model.StrokeDAO;
import mycom.my.stroke.model.StrokeDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AddNewStroke extends javax.swing.JFrame implements ActionListener {

    private Menu menu;
    private StrokeDAO strokeDao;
    DecimalFormat formatter;

    public AddNewStroke() {
        initComponents();
        formatter = new DecimalFormat("#,###");
        init();
        addEvent();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfStroke = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfPrice = new javax.swing.JTextField();
        btSave = new javax.swing.JButton();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("새로운 영법 추가창");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("새로운 영법을 추가하려면 아래의 항목을 채워주세요");

        jLabel2.setText("영법 종류");

        jLabel3.setText("강습비용");

        btSave.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace_list\\nb_ws\\myproject\\src\\main\\java\\img\\icons8_save_15px.png")); // NOI18N
        btSave.setText("저 장");

        img.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace_list\\nb_ws\\myproject\\src\\main\\java\\img\\taxi-sing-in.png")); // NOI18N
        img.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfStroke, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btSave)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfStroke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btSave)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewStroke().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSave;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfStroke;
    // End of variables declaration//GEN-END:variables

    private void init() {
        strokeDao = new StrokeDAO();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addEvent() {
        btSave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btSave) {
            try {
                SaveStroke();
            } catch (Exception ex) {
                Logger.getLogger(AddNewStroke.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void SaveStroke() throws SQLException {
        String nameOfstroke = tfStroke.getText().trim();
        String price = tfPrice.getText().trim();

        if (tfStroke.getText() == null || tfStroke.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "영법 종류를 작성해주세요.");
            tfStroke.requestFocus();
            return;
        } else if (tfPrice.getText() == null || tfPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "강습비용을 작성해주세요.");
            tfPrice.requestFocus();
            return;
        }

        StrokeDTO dto = new StrokeDTO();

        dto.setNameOfstroke(nameOfstroke);
        dto.setPrice(Double.parseDouble(price));

        int cnt = strokeDao.insertStroke(dto);

        String msg = "";
        if (cnt > 0) {
            msg = "새로운 영법이 등록되었습니다!";
            this.dispose();
        } else if(cnt < 0){
            msg = "영법 등록 실패";
        }
        JOptionPane.showMessageDialog(this, msg);
    }
}
