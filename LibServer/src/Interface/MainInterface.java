/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Cliente.Cliente;
import Utils.ID;

/**
 *
 * @author Usuario
 */
public class MainInterface extends javax.swing.JFrame {

    private Cliente jugador;
    
    public MainInterface(Cliente jugador) {
        this.jugador = jugador;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public MainInterface() {
        initComponents();
    }

    public void appendConsola(String texto){
        txaConsola.append(texto);
        txaConsola.append("\n");
    }
    public void appendBitacora(String resumen){
        txaBitacora.append(resumen);
    }
    private void accion(){
     //Obtiene el texto enviado
        String txt = txfEscribirConsola.getText();
        //Lo muestra en la consola
        appendConsola("EJECUTANDO  >> " + txt);
        //Separa el string recibido
        String[] parts = txt.split("-");
        switch(parts[0]){
            case "Name":
                jugador.hiloCliente.escribir(ID.SETNAME);
                jugador.hiloCliente.escribir(parts[1]);
                 ((MainInterface)jugador.getRefPantalla()).lblName.setText(parts[1]);
                this.setTitle(parts[1]);//coloca el nombre en el titulo de la pantalla
            break;
            case "Chat":
                jugador.hiloCliente.escribir(ID.CHAT);
                jugador.hiloCliente.escribir(parts[1]);
            break;
            default:
                appendConsola("Ups, comando inexistente!");
            break;
        }
        //limpia
        txfEscribirConsola.setText("");
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfEscribirConsola = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaConsola = new javax.swing.JTextArea();
        lblName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaBitacora = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txfEscribirConsola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfEscribirConsolaActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txaConsola.setColumns(20);
        txaConsola.setRows(5);
        jScrollPane1.setViewportView(txaConsola);

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblName.setText("jLabel1");

        txaBitacora.setColumns(20);
        txaBitacora.setRows(5);
        jScrollPane2.setViewportView(txaBitacora);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txfEscribirConsola, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(btnEnviar)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfEscribirConsola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnviar))
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfEscribirConsolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfEscribirConsolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEscribirConsolaActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        accion();
    }//GEN-LAST:event_btnEnviarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextArea txaBitacora;
    private javax.swing.JTextArea txaConsola;
    private javax.swing.JTextField txfEscribirConsola;
    // End of variables declaration//GEN-END:variables
}
