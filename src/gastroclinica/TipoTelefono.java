/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gastroclinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo López
 */
public class TipoTelefono extends javax.swing.JFrame {

    Connection conexion;
    int idTipo=0;String tipo="";
    /**
     * Creates new form CrearTelefono
     */
    public TipoTelefono() {
        initComponents();
        this.setLocationRelativeTo(null);
        jButton4.setEnabled(false);
        establecerConexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tipo:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(jTextField1.getText()!=null&&jTextField1.getText().compareTo("")!=0){
            tipo=jTextField1.getText();
            ResultSet verificar=devolverResultado("Select* from Tipo_Telefono where Tipo=\""+tipo+"\";");
            try {
                if(verificar.next()==true){
                    JOptionPane.showMessageDialog(null,"El tipo de telefono ingresado ya existe en la base de datos","",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    consultaInsertar("insert into Tipo_Telefono(Tipo) values(\""+tipo+"\");");
                    JOptionPane.showMessageDialog(null,"Tipo de telefono creado con exito.","",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            //this.show(false);
        }
        else{
            JOptionPane.showMessageDialog(null,"Ingrese el tipo de telefono.","",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jTextField1.getText()!=null&&jTextField1.getText().compareTo("")!=0){
            tipo=jTextField1.getText();
            ResultSet verificar=devolverResultado("Select* from Tipo_Telefono where Tipo=\""+tipo+"\";");
            try {
                if(verificar.next()==true){
                    JOptionPane.showMessageDialog(null,"Tipo de telefono encontrado.","",JOptionPane.INFORMATION_MESSAGE);
                    jButton2.setEnabled(false);jButton4.setEnabled(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Tipo de telefono no encontrado.","",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            //this.show(false);
        }
        else{
            JOptionPane.showMessageDialog(null,"Ingrese el tipo de telefono.","",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:    
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoTelefono.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(jTextField1.getText()!=null&&jTextField1.getText().compareTo("")!=0){
            String anterior=tipo;
            tipo=jTextField1.getText();
            ResultSet verificar=devolverResultado("Select* from Tipo_Telefono where Tipo=\""+tipo+"\";");
            try {
                if(verificar.next()==true){
                    JOptionPane.showMessageDialog(null,"Imposible renombrar, tipo de telefono existente.","",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String modificar="update Tipo_Telefono set Tipo=\""+tipo+"\" where Tipo=\""+anterior+"\";";
                    consultaInsertar(modificar);
                    JOptionPane.showMessageDialog(null,"Tipo de telefono renombrado.","",JOptionPane.INFORMATION_MESSAGE);
                    jButton2.setEnabled(true);jButton4.setEnabled(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            //this.show(false);
        }
        else{
            JOptionPane.showMessageDialog(null,"Ingrese el tipo de telefono.","",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    public ResultSet devolverResultado(String consulta){
            ResultSet devolver = null;
        try {
            Statement s=conexion.createStatement();
            devolver=s.executeQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(TipoTelefono.class.getName()).log(Level.SEVERE, null, ex);
        }
        return devolver;
    }
    public void consultaInsertar(String sql){
        try {
            Statement insertar=conexion.createStatement();
            insertar.executeUpdate(sql);
            //JOptionPane.showMessageDialog(null, "Consulta realizada con exito", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de almacenar la informacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/DBGastroClinica", "root", "ingenieria");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //return false;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
           // return false;
        }
        //return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TipoTelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoTelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoTelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoTelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TipoTelefono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
