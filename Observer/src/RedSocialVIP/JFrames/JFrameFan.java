/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package RedSocialVIP.JFrames;

import RedSocialVIP.Objetos.Artista;
import RedSocialVIP.Objetos.Fan;
import Subasta.JFrames.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author oscfr
 */
public class JFrameFan extends javax.swing.JFrame {

    /**
     * Creates new form JFrameOferente
     */
    Fan fan;
    ArrayList<Artista> ListaArtistas;
    
    public void addArtistas(ArrayList<Artista> artistas){
        int selected = BoxArtista.getSelectedIndex();
        BoxArtista.removeAllItems();
        ListaArtistas = artistas;
        for (int i=0;i<artistas.size();i++) {
            addArtista(artistas.get(i).getNick());
        }
        if(BoxPublicacion.getSelectedItem() != null){
            BoxArtista.setSelectedIndex(selected);
            addMensajes(getArtista(BoxArtista.getSelectedItem().toString()));
            String texto = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).getContenido();
            int Likes = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).getLikes();
            int Dislikes = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).getDislikes();
            int seguidores = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getSeguidores();
            jTMensajes.setText(texto);
            LblLikes.setText(""+Likes);
            LblDislikes.setText(""+Dislikes);
            lblSeguidores.setText(""+seguidores);
        }
    }
    public void addMensajes(int key){
        BoxPublicacion.removeAllItems();
        for (int i=0;i<ListaArtistas.get(key).getListaPublicaciones().size();i++) {
            addMensaje(i+"");
        }
    }
    public void addNotif(String artista ,String notif){
        if(fan.getListaArtistas().contains(artista)){
            jTNotificaciones.setText(jTNotificaciones.getText() + notif + "\n");
        }
    }
    public int getArtista(String selected){
        for (int i=0;i<ListaArtistas.size();i++) {
            if (ListaArtistas.get(i).getNick() == selected){
                return i;
            }
        }
        return 0;
    }
    public void addArtista(String nombre){
        BoxArtista.addItem(nombre);
    }
    public void addMensaje(String mensaje){
        BoxPublicacion.addItem(mensaje);
    }
    public void setFan(Fan fan) {
        this.fan = fan;
    }
    public JFrameFan() {
        initComponents();
    }
    public void setNombre(String nombre){
        this.lblNombre.setText(nombre);
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMensajes = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTNotificaciones = new javax.swing.JTextArea();
        BoxPublicacion = new javax.swing.JComboBox<>();
        BtnLike = new javax.swing.JButton();
        BtnDislike = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        BoxArtista = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        BtnSeguir = new javax.swing.JButton();
        LblLikes = new javax.swing.JLabel();
        LblDislikes = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSeguidores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Notificaciones");

        jLabel2.setText("Mensaje seleccionado");

        jTMensajes.setColumns(20);
        jTMensajes.setRows(5);
        jScrollPane1.setViewportView(jTMensajes);

        jTNotificaciones.setColumns(20);
        jTNotificaciones.setRows(5);
        jScrollPane2.setViewportView(jTNotificaciones);

        BoxPublicacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BoxPublicacionItemStateChanged(evt);
            }
        });
        BoxPublicacion.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                BoxPublicacionPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        BoxPublicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BoxPublicacionMouseClicked(evt);
            }
        });
        BoxPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxPublicacionActionPerformed(evt);
            }
        });

        BtnLike.setText("Like");
        BtnLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLikeActionPerformed(evt);
            }
        });

        BtnDislike.setText("Dislike");
        BtnDislike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDislikeActionPerformed(evt);
            }
        });

        jLabel6.setText("Artista seleccionado");

        BoxArtista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BoxArtistaItemStateChanged(evt);
            }
        });
        BoxArtista.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                BoxArtistaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        BoxArtista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BoxArtistaMouseClicked(evt);
            }
        });
        BoxArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxArtistaActionPerformed(evt);
            }
        });

        jLabel3.setText("Likes:");

        jLabel4.setText("Dislikes:");

        lblNombre.setText("Nombre:");

        BtnSeguir.setText("Seguir");
        BtnSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeguirActionPerformed(evt);
            }
        });

        LblLikes.setText("0");

        LblDislikes.setText("0");

        jLabel5.setText("Seguidores:");

        lblSeguidores.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel6)
                                .addGap(128, 128, 128))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSeguidores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnSeguir))
                                    .addComponent(BoxArtista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(68, 68, 68))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblLikes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblDislikes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BoxPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addGap(54, 54, 54)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnLike)
                                .addGap(90, 90, 90)
                                .addComponent(BtnDislike)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoxArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSeguir)
                    .addComponent(jLabel5)
                    .addComponent(lblSeguidores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoxPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(LblLikes)
                    .addComponent(LblDislikes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnLike)
                    .addComponent(BtnDislike))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblNombre)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoxArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxArtistaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BoxArtistaActionPerformed

    private void BoxPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxPublicacionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BoxPublicacionActionPerformed

    private void BoxArtistaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BoxArtistaItemStateChanged
        
    }//GEN-LAST:event_BoxArtistaItemStateChanged

    private void BoxPublicacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BoxPublicacionItemStateChanged
        
    }//GEN-LAST:event_BoxPublicacionItemStateChanged

    private void BoxArtistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoxArtistaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BoxArtistaMouseClicked

    private void BoxPublicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoxPublicacionMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BoxPublicacionMouseClicked

    private void BoxArtistaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_BoxArtistaPopupMenuWillBecomeInvisible
        if (fan.getListaArtistas().contains(BoxArtista.getSelectedItem().toString())){
           addMensajes(getArtista(BoxArtista.getSelectedItem().toString()));
        }
        else{
            jTMensajes.setText("No sigues a este artista");
            LblLikes.setText("0");
            LblDislikes.setText("0");
        }
    }//GEN-LAST:event_BoxArtistaPopupMenuWillBecomeInvisible

    private void BoxPublicacionPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_BoxPublicacionPopupMenuWillBecomeInvisible
        if (BoxPublicacion.getSelectedItem() != null && fan.getListaArtistas().contains(BoxArtista.getSelectedItem().toString())){
            String texto = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).getContenido();
            int Likes = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).getLikes();
            int Dislikes = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).getDislikes();
            jTMensajes.setText(texto);
            LblLikes.setText(""+Likes);
            LblDislikes.setText(""+Dislikes);
        }
    }//GEN-LAST:event_BoxPublicacionPopupMenuWillBecomeInvisible

    private void BtnLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLikeActionPerformed
        // TODO add your handling code here:
        if (BoxPublicacion.getSelectedItem() != null){
            ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).addLikes();
            String nombre = BoxArtista.getSelectedItem().toString();
            Artista artista = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString()));
            String texto = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).getContenido();
            int Likes = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).getLikes();
            jTMensajes.setText(texto);
            LblLikes.setText(""+Likes);
            
            fan.sendLikesandDislikes(nombre,artista);
            if((Likes % 10) == 0){
                fan.notif10("La publicacion #"+ BoxPublicacion.getSelectedItem().toString() +" de "+ BoxArtista.getSelectedItem().toString() +" llego a "+ Likes + " Likes!!!", BoxArtista.getSelectedItem().toString());
            }
        }
        
    }//GEN-LAST:event_BtnLikeActionPerformed

    private void BtnDislikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDislikeActionPerformed
        // TODO add your handling code here:
        if (BoxPublicacion.getSelectedItem() != null){
            ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).addDislikes();
            String nombre = BoxArtista.getSelectedItem().toString();
            Artista artista = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString()));
            String texto = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).getContenido();
            jTMensajes.setText(texto);
            int Dislikes = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getListaPublicaciones().get(Integer.parseInt(BoxPublicacion.getSelectedItem().toString())).getDislikes();
            LblDislikes.setText("" + Dislikes);
            fan.sendLikesandDislikes(nombre,artista);
            
            if((Dislikes % 10) == 0){
                fan.notif10("La publicacion #"+ BoxPublicacion.getSelectedItem().toString() +" de "+ BoxArtista.getSelectedItem().toString() +" llego a "+ Dislikes + " Dislikes :(", BoxArtista.getSelectedItem().toString());
            }
        }
        
    }//GEN-LAST:event_BtnDislikeActionPerformed

    private void BtnSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeguirActionPerformed
        if (!fan.getListaArtistas().contains(BoxArtista.getSelectedItem().toString())){
            fan.addListaArtistas(BoxArtista.getSelectedItem().toString());
            addMensajes(getArtista(BoxArtista.getSelectedItem().toString()));
            ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).anadirSeguidor(fan);
            if(ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getSeguidores() % 10 == 0){
                int Seguidores = ListaArtistas.get(getArtista(BoxArtista.getSelectedItem().toString())).getSeguidores();
                fan.notif10("El artista #"+ BoxArtista.getSelectedItem().toString() +" llego a "+ Seguidores + " seguidores!!!", BoxArtista.getSelectedItem().toString());
            }
        }
    }//GEN-LAST:event_BtnSeguirActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameFan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameFan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameFan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameFan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameFan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxArtista;
    private javax.swing.JComboBox<String> BoxPublicacion;
    private javax.swing.JButton BtnDislike;
    private javax.swing.JButton BtnLike;
    private javax.swing.JButton BtnSeguir;
    private javax.swing.JLabel LblDislikes;
    private javax.swing.JLabel LblLikes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTMensajes;
    private javax.swing.JTextArea jTNotificaciones;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSeguidores;
    // End of variables declaration//GEN-END:variables
}
