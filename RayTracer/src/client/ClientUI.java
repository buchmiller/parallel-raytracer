package client;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ClientUI extends javax.swing.JFrame
{
   DefaultListModel<String> listModel = new DefaultListModel<>();
   Client client = new Client(3000);

   /**
    * Creates new form ClientUI
    */
   public ClientUI()
   {
      initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      mainPanel = new javax.swing.JPanel();
      SetupPanel = new javax.swing.JPanel();
      jTextField1 = new javax.swing.JTextField();
      jLabel1 = new javax.swing.JLabel();
      jButton1 = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      jList1 = new javax.swing.JList(listModel);
      jButton2 = new javax.swing.JButton();
      jComboBox1 = new javax.swing.JComboBox();
      jLabel2 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jButton4 = new javax.swing.JButton();
      jButton3 = new javax.swing.JButton();
      jSeparator1 = new javax.swing.JSeparator();
      jSeparator2 = new javax.swing.JSeparator();
      jTextField3 = new javax.swing.JTextField();
      jLabel5 = new javax.swing.JLabel();
      CompletePanel = new javax.swing.JPanel();
      jButton5 = new javax.swing.JButton();
      jButton6 = new javax.swing.JButton();
      jButton7 = new javax.swing.JButton();
      jLabel3 = new javax.swing.JLabel();
      jTextField2 = new javax.swing.JTextField();
      jButton8 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      mainPanel.setLayout(new java.awt.CardLayout());

      jTextField1.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jTextField1ActionPerformed(evt);
         }
      });

      jLabel1.setText("Host name:");

      jButton1.setText("Connect");
      jButton1.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton1ActionPerformed(evt);
         }
      });

      jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener()
      {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt)
         {
            serverSelected(evt);
         }
      });
      jScrollPane1.setViewportView(jList1);

      jButton2.setText("Disconnect");
      jButton2.setEnabled(false);
      jButton2.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton2ActionPerformed(evt);
         }
      });

      jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
      jComboBox1.setEnabled(false);

      jLabel2.setText("Cores");

      jLabel4.setText("Connected servers");

      jButton4.setText("Open scene file");
      jButton4.setEnabled(false);

      jButton3.setText("Next");
      jButton3.setEnabled(false);
      jButton3.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton3ActionPerformed(evt);
         }
      });

      jTextField3.setText("3000");

      jLabel5.setText("Port number:");

      javax.swing.GroupLayout SetupPanelLayout = new javax.swing.GroupLayout(SetupPanel);
      SetupPanel.setLayout(SetupPanelLayout);
      SetupPanelLayout.setHorizontalGroup(
         SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jSeparator2)
         .addGroup(SetupPanelLayout.createSequentialGroup()
            .addComponent(jButton4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SetupPanelLayout.createSequentialGroup()
            .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel4))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SetupPanelLayout.createSequentialGroup()
                  .addComponent(jLabel2)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(jButton2)))
         .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SetupPanelLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(SetupPanelLayout.createSequentialGroup()
                  .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(85, 85, 85)
                  .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
      );
      SetupPanelLayout.setVerticalGroup(
         SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(SetupPanelLayout.createSequentialGroup()
            .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel5)
               .addComponent(jButton1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(SetupPanelLayout.createSequentialGroup()
                  .addComponent(jButton2)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel2))))
            .addGap(7, 7, 7)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton4)
               .addComponent(jButton3)))
      );

      mainPanel.add(SetupPanel, "card2");

      jButton5.setText("Display image");
      jButton5.setEnabled(false);
      jButton5.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton5ActionPerformed(evt);
         }
      });

      jButton6.setText("Save image");
      jButton6.setEnabled(false);
      jButton6.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton6ActionPerformed(evt);
         }
      });

      jButton7.setText("Back");
      jButton7.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton7ActionPerformed(evt);
         }
      });

      jLabel3.setText("Time");

      jTextField2.setFocusable(false);
      jTextField2.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jTextField2ActionPerformed(evt);
         }
      });

      jButton8.setText("Render");
      jButton8.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton8ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout CompletePanelLayout = new javax.swing.GroupLayout(CompletePanel);
      CompletePanel.setLayout(CompletePanelLayout);
      CompletePanelLayout.setHorizontalGroup(
         CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(CompletePanelLayout.createSequentialGroup()
            .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
               .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
            .addGap(4, 4, 4))
         .addGroup(CompletePanelLayout.createSequentialGroup()
            .addComponent(jButton7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton8))
      );
      CompletePanelLayout.setVerticalGroup(
         CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CompletePanelLayout.createSequentialGroup()
            .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(CompletePanelLayout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel3)
                     .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(CompletePanelLayout.createSequentialGroup()
                  .addComponent(jButton5)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton6)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
            .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton7)
               .addComponent(jButton8)))
      );

      mainPanel.add(CompletePanel, "card1");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 313, Short.MAX_VALUE)
         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addContainerGap()))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 240, Short.MAX_VALUE)
         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void connectToServer()
   {
      //TODO connect to the server first and set # of cores

      String hostName = jTextField1.getText();
      int portNum = Integer.parseInt(jTextField3.getText());
      jTextField1.setBackground(Color.WHITE);

      try
      {
         if (listModel.contains(hostName)) //already connected to this host
         {
            throw new Exception();
         }

         client.connectTo(hostName, portNum);
         listModel.addElement(hostName + ":" + portNum);
         jButton3.setEnabled(true); //enable Render button
      }
      catch (Exception e)
      {
         jTextField1.setBackground(Color.RED);
         jTextField1.requestFocus();
      }
   }

   private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton5ActionPerformed
   {//GEN-HEADEREND:event_jButton5ActionPerformed
      client.displayImage();
   }//GEN-LAST:event_jButton5ActionPerformed

   private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField2ActionPerformed
   {//GEN-HEADEREND:event_jTextField2ActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_jTextField2ActionPerformed

   private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton7ActionPerformed
   {//GEN-HEADEREND:event_jButton7ActionPerformed
      //Back button pressed
      CardLayout cl = (CardLayout) mainPanel.getLayout();
      cl.previous(mainPanel);
   }//GEN-LAST:event_jButton7ActionPerformed

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
   {//GEN-HEADEREND:event_jButton3ActionPerformed
      //Next button pressed
      CardLayout cl = (CardLayout) mainPanel.getLayout();
      cl.next(mainPanel);
   }//GEN-LAST:event_jButton3ActionPerformed

   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
   {//GEN-HEADEREND:event_jButton2ActionPerformed
      //Item changed in list (removed)

      int index = jList1.getSelectedIndex();
      try
      {
         client.disconnectFrom(listModel.elementAt(index));
         listModel.remove(index);
      }
      catch (IOException e)
      {
         return;
      }

      int size = listModel.getSize();

      if (size == 0) //list is empty
      {
         //jButton2.setEnabled(false); //disable 'Disconnect'
      }
      else //select an index
      {
         if (index == listModel.getSize()) //removed item in last position
         {
            index--;
         }

         jList1.setSelectedIndex(index);
         jList1.ensureIndexIsVisible(index);
      }
   }//GEN-LAST:event_jButton2ActionPerformed

   private void serverSelected(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_serverSelected
   {//GEN-HEADEREND:event_serverSelected
      //Server selected in list
      if (evt.getValueIsAdjusting() == false)
      {
         if (jList1.getSelectedIndex() == -1) //No selection
         {
            jButton2.setEnabled(false); //disable Disconnect button
            jComboBox1.setEnabled(false); //disable Core# selector
            jButton3.setEnabled(false); //disalbe Render button
         }
         else //selection
         {
            jButton2.setEnabled(true); //enable Disconnect button
            jComboBox1.setEnabled(true); //enable Core# selector
            jButton3.setEnabled(true); //enable Render button
         }
      }
   }//GEN-LAST:event_serverSelected

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
   {//GEN-HEADEREND:event_jButton1ActionPerformed
      connectToServer(); //'Connect' pressed
   }//GEN-LAST:event_jButton1ActionPerformed

   private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField1ActionPerformed
   {//GEN-HEADEREND:event_jTextField1ActionPerformed
      connectToServer(); //enter key pressed in textfield
   }//GEN-LAST:event_jTextField1ActionPerformed

   private void jButton8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton8ActionPerformed
   {//GEN-HEADEREND:event_jButton8ActionPerformed
      client.startRunnables(); //'Render' pressed
      jButton5.setEnabled(true); //Enable 'Display image'
      jButton6.setEnabled(true); //Enable 'Save image'
   }//GEN-LAST:event_jButton8ActionPerformed

   private void jButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton6ActionPerformed
   {//GEN-HEADEREND:event_jButton6ActionPerformed
      client.saveImageToFile(); //'Save image' pressed
   }//GEN-LAST:event_jButton6ActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[])
   {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
       * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try
      {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
         {
            if ("Nimbus".equals(info.getName()))
            {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      }
      catch (ClassNotFoundException ex)
      {
         java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (InstantiationException ex)
      {
         java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (IllegalAccessException ex)
      {
         java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
         java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new ClientUI().setVisible(true);
         }
      });
   }
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JPanel CompletePanel;
   private javax.swing.JPanel SetupPanel;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JButton jButton4;
   private javax.swing.JButton jButton5;
   private javax.swing.JButton jButton6;
   private javax.swing.JButton jButton7;
   private javax.swing.JButton jButton8;
   private javax.swing.JComboBox jComboBox1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JList jList1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JSeparator jSeparator2;
   private javax.swing.JTextField jTextField1;
   private javax.swing.JTextField jTextField2;
   private javax.swing.JTextField jTextField3;
   private javax.swing.JPanel mainPanel;
   // End of variables declaration//GEN-END:variables
}
