/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package RedSocialVIP.JFrames;

import RedSocialVIP.Objetos.Artista;
import Subasta.JFrames.*;
import Subasta.Objetos.Producto;
import Utils.ID;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author oscfr
 */
public class JFrameArtista extends javax.swing.JFrame {

    /**
     * Creates new form JFrameSubastador
     */
    Artista artista;

    public Artista getArtista() {
        return artista;
    }
    public void updateArtista(String nombre, Artista artista){
        int selected = 0;
        if (BoxPublicaciones.getSelectedItem() != null){
            selected = BoxPublicaciones.getSelectedIndex();
        }
        BoxPublicaciones.removeAllItems();
        if (artista.getNick().equals(nombre)){
            this.artista.setListaPublicaciones(artista.getListaPublicaciones());
            for (int i=0;i<this.artista.getListaPublicaciones().size();i++) {
                addPublicaciones(""+i);
            }
        }
        BoxPublicaciones.setSelectedIndex(selected);
        updateCombobox();
    }
    public void addPublicaciones(String ob){
        BoxPublicaciones.addItem(ob);

    }
    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    public JFrameArtista() {
        initComponents();
    }
    public void setNombre(String nombre){
        this.lblNombre.setText(nombre);
    }
    public void updateCombobox(){
        if (BoxPublicaciones.getSelectedItem() != null){
            String texto = artista.getListaPublicaciones().get(Integer.parseInt(BoxPublicaciones.getSelectedItem().toString())).getContenido();
            int Likes = artista.getListaPublicaciones().get(Integer.parseInt(BoxPublicaciones.getSelectedItem().toString())).getLikes();
            int Dislikes = artista.getListaPublicaciones().get(Integer.parseInt(BoxPublicaciones.getSelectedItem().toString())).getDislikes();
            txtPublica.setText(texto);
            lblLikes.setText(""+Likes);
            lblDislikes.setText(""+Dislikes);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnPublicar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TxtPublicacion = new javax.swing.JTextField();
        DarmeDeBaja = new javax.swing.JButton();
        BtnAnadirSeguidor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BoxPublicaciones = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPublica = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        btnLikes = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblLikes = new javax.swing.JLabel();
        lblDislikes = new javax.swing.JLabel();
        btnDislikes = new javax.swing.JButton();
        lblSeguidores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnPublicar.setText("Publicar");
        BtnPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPublicarActionPerformed(evt);
            }
        });

        jLabel1.setText("Escribir publicacion");

        DarmeDeBaja.setText("Darse de baja");
        DarmeDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DarmeDeBajaActionPerformed(evt);
            }
        });

        BtnAnadirSeguidor.setText("Anadir Seguidor");
        BtnAnadirSeguidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnadirSeguidorActionPerformed(evt);
            }
        });

        jLabel2.setText("Seguidores:");

        BoxPublicaciones.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                BoxPublicacionesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        BoxPublicaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxPublicacionesActionPerformed(evt);
            }
        });

        jLabel4.setText("Mis Publicaciones");

        jScrollPane1.setViewportView(txtPublica);

        jLabel5.setText("Likes:");

        btnLikes.setText("Subir Likes");
        btnLikes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLikesActionPerformed(evt);
            }
        });

        jLabel6.setText("Dislikes:");

        lblNombre.setText("Nombre");

        lblLikes.setText("0");

        lblDislikes.setText("0");

        btnDislikes.setText("Subir Dislikes");
        btnDislikes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDislikesActionPerformed(evt);
            }
        });

        lblSeguidores.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TxtPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnAnadirSeguidor)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(DarmeDeBaja)
                                .addComponent(BtnPublicar)))))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(BoxPublicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLikes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDislikes)))
                        .addGap(0, 71, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSeguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDislikes, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblLikes, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lblSeguidores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnPublicar)
                    .addComponent(BoxPublicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(DarmeDeBaja))
                        .addGap(32, 32, 32)
                        .addComponent(BtnAnadirSeguidor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblDislikes))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblNombre)
                    .addComponent(lblLikes))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLikes)
                    .addComponent(btnDislikes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPublicarActionPerformed
        if (!TxtPublicacion.getText().isBlank() ){
            artista.postearMensaje(TxtPublicacion.getText());
        }
        else{
           JOptionPane.showMessageDialog(null, "No se puede hacer una publicacion en blanco!!"); 
        }
    }//GEN-LAST:event_BtnPublicarActionPerformed

    private void DarmeDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DarmeDeBajaActionPerformed
        artista.darseDeBaja();
    }//GEN-LAST:event_DarmeDeBajaActionPerformed

    private void BoxPublicacionesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_BoxPublicacionesPopupMenuWillBecomeInvisible
        if(BoxPublicaciones.getSelectedItem() != null){
            updateCombobox();
        }
    }//GEN-LAST:event_BoxPublicacionesPopupMenuWillBecomeInvisible

    private void btnLikesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLikesActionPerformed
        if(BoxPublicaciones.getSelectedItem() != null){
            artista.getListaPublicaciones().get(Integer.parseInt(BoxPublicaciones.getSelectedItem().toString())).addLikes();
            artista.sendLikesandDislikes(artista.getNick(), artista);
            int Likes = artista.getListaPublicaciones().get(Integer.parseInt(BoxPublicaciones.getSelectedItem().toString())).getLikes();
            lblLikes.setText(""+Likes);
            if((Likes % 10) == 0){
                artista.notif10("La publicacion #"+ BoxPublicaciones.getSelectedItem().toString() +" de "+ artista.getNick() +" llego a "+ Likes + " Likes!!!", artista.getNick());
            }
            BoxPublicaciones.setSelectedIndex(Integer.parseInt(BoxPublicaciones.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_btnLikesActionPerformed

    private void btnDislikesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDislikesActionPerformed
        if(BoxPublicaciones.getSelectedItem() != null){
            artista.getListaPublicaciones().get(Integer.parseInt(BoxPublicaciones.getSelectedItem().toString())).addDislikes();
            artista.sendLikesandDislikes(artista.getNick(), artista);
            int Dislikes = artista.getListaPublicaciones().get(Integer.parseInt(BoxPublicaciones.getSelectedItem().toString())).getDislikes();
            lblDislikes.setText(""+Dislikes);
            if((Dislikes % 10) == 0){
                artista.notif10("La publicacion #"+ BoxPublicaciones.getSelectedItem().toString() +" de "+ artista.getNick() +" llego a "+ Dislikes + " Dislikes :(", artista.getNick());
            }
        }
    }//GEN-LAST:event_btnDislikesActionPerformed

    private void BtnAnadirSeguidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnadirSeguidorActionPerformed
        artista.anadirSeguidor();
        int Seguidores = artista.getSeguidores();
        lblSeguidores.setText("" + Seguidores);
    }//GEN-LAST:event_BtnAnadirSeguidorActionPerformed

    private void BoxPublicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxPublicacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxPublicacionesActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameArtista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxPublicaciones;
    private javax.swing.JButton BtnAnadirSeguidor;
    private javax.swing.JButton BtnPublicar;
    private javax.swing.JButton DarmeDeBaja;
    private javax.swing.JTextField TxtPublicacion;
    private javax.swing.JButton btnDislikes;
    private javax.swing.JButton btnLikes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDislikes;
    private javax.swing.JLabel lblLikes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSeguidores;
    private javax.swing.JTextPane txtPublica;
    // End of variables declaration//GEN-END:variables
}
