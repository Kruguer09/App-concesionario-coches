/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Acceso;
import Modelo.Coche;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Consultas extends javax.swing.JDialog {

    /**
     * Creates new form Consultas
     */
    public Consultas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Consultas en la Base de Datos de Coches");
        ImageIcon imgIcono=new ImageIcon("src/favicon.png");
        setIconImage(imgIcono.getImage());
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupConsultas = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        rButtonCochesVendidos = new javax.swing.JRadioButton();
        rButtonCochesMenosKm = new javax.swing.JRadioButton();
        rButtonCochesDispon = new javax.swing.JRadioButton();
        buttonMostrar = new javax.swing.JButton();
        buttonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Seleccione el listado que desea visualizar");

        buttonGroupConsultas.add(rButtonCochesVendidos);
        rButtonCochesVendidos.setText("Coches Vendidos");

        buttonGroupConsultas.add(rButtonCochesMenosKm);
        rButtonCochesMenosKm.setText("Menos de 20.000 kms");

        buttonGroupConsultas.add(rButtonCochesDispon);
        rButtonCochesDispon.setText("Coches Disponlibles Gasolina");

        buttonMostrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonMostrar.setForeground(new java.awt.Color(0, 102, 255));
        buttonMostrar.setText("Mostrar");
        buttonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMostrarActionPerformed(evt);
            }
        });

        buttonCerrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonCerrar.setForeground(new java.awt.Color(204, 0, 0));
        buttonCerrar.setText("Cerrar");
        buttonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rButtonCochesMenosKm)
                    .addComponent(rButtonCochesVendidos)
                    .addComponent(rButtonCochesDispon)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(buttonCerrar)))
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(rButtonCochesVendidos)
                .addGap(18, 18, 18)
                .addComponent(rButtonCochesMenosKm)
                .addGap(18, 18, 18)
                .addComponent(rButtonCochesDispon)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMostrar)
                    .addComponent(buttonCerrar))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMostrarActionPerformed
        String sSalidaSeleccion = "Datos de vehículos:\n";
        int iTotalRegistros = 0;
        Acceso acc = new Acceso();
        ArrayList<Coche> listaCoches = acc.readfCoches();
        
        if (rButtonCochesDispon.isSelected()) {

            for (Coche coche : listaCoches) {
                if (coche.getCombustible().equals("Gasolina")&&!coche.getVendido()) {
                    sSalidaSeleccion = sSalidaSeleccion + ("Matrícula: " + coche.getMatricula() + " - Marca: " + coche.getMarca() + " - Modelo: " + coche.getModelo() + " - Combustible: " + coche.getCombustible() +" - Kms: "+coche.getKilometros()+" -¿Vendido?" + ((coche.getVendido()) ? "Sí" : "No") + "\n");
                    iTotalRegistros++;
                }
                
            }
            sSalidaSeleccion= sSalidaSeleccion+("\nTotal de registros: "+iTotalRegistros);
        } else if (rButtonCochesMenosKm.isSelected()) {
            for (Coche coche : listaCoches) {
                if (coche.getKilometros() < 20000) {
                    sSalidaSeleccion = sSalidaSeleccion + ("Matrícula: " + coche.getMatricula() + " - Marca: " + coche.getMarca() + " - Modelo: " + coche.getModelo() + " - Combustible: " + coche.getCombustible() +" - Kms: "+coche.getKilometros()+ " -¿Vendido?" + ((coche.getVendido()) ? "Sí" : "No") + "\n");
                    iTotalRegistros++;
                }
                
            }
            sSalidaSeleccion= sSalidaSeleccion+("\nTotal de registros: "+iTotalRegistros);

        } else if (rButtonCochesVendidos.isSelected()) {
            for (Coche coche : listaCoches) {
                if (coche.getVendido()) {
                    sSalidaSeleccion = sSalidaSeleccion + ("Matrícula: " + coche.getMatricula() + " - Marca: " + coche.getMarca() + " - Modelo: " + coche.getModelo() + " - Combustible: " + coche.getCombustible() +" - Kms: "+coche.getKilometros()+" -¿Vendido?" + ((coche.getVendido()) ? "Sí" : "No") + "\n");
                    iTotalRegistros++;
                }
                
            }
            sSalidaSeleccion= sSalidaSeleccion+("\nTotal de registros: "+iTotalRegistros);

        } else {
            int v = JOptionPane.showConfirmDialog(null, "No ha hecho ninguna selección, ¿desea salir?", "Mensaje de confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (v == 0) {
                this.dispose();
            }

        }
        JOptionPane.showMessageDialog(null, sSalidaSeleccion,
                "Información solicitada", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_buttonMostrarActionPerformed

    private void buttonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Consultas dialog = new Consultas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCerrar;
    private javax.swing.ButtonGroup buttonGroupConsultas;
    private javax.swing.JButton buttonMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rButtonCochesDispon;
    private javax.swing.JRadioButton rButtonCochesMenosKm;
    private javax.swing.JRadioButton rButtonCochesVendidos;
    // End of variables declaration//GEN-END:variables
}
