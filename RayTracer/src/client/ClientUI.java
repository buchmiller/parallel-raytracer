package client;

import common.scene.Scene;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;

public class ClientUI extends javax.swing.JFrame
{
   DefaultListModel<String> listModel = new DefaultListModel<>();
   Client client = new Client(3000);

   /**
    * Creates new form ClientUI
    */
   public ClientUI()
   {
      UIManager.put("ProgressBar.repaintInterval", new Integer(50));
      UIManager.put("ProgressBar.cycleTime", new Integer(1000));
      initComponents();
      jProgressBar1.setVisible(false);
      jComboBox2.setModel(new DefaultComboBoxModel<>(Scene.Type.values()));
      jComboBox3.setModel(new DefaultComboBoxModel<>(Scene.RenderMethod.values()));
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
      jLabel4 = new javax.swing.JLabel();
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
      jLabel2 = new javax.swing.JLabel();
      jComboBox1 = new javax.swing.JComboBox();
      jProgressBar1 = new javax.swing.JProgressBar();
      jButton9 = new javax.swing.JButton();
      jPanel1 = new javax.swing.JPanel();
      jComboBox2 = new javax.swing.JComboBox<Scene.Type>();
      jLabel6 = new javax.swing.JLabel();
      jTextField5 = new javax.swing.JTextField();
      jLabel7 = new javax.swing.JLabel();
      jTextField4 = new javax.swing.JTextField();
      jLabel9 = new javax.swing.JLabel();
      jSpinner1 = new javax.swing.JSpinner();
      jLabel8 = new javax.swing.JLabel();
      jSpinner2 = new javax.swing.JSpinner();
      jComboBox3 = new javax.swing.JComboBox<Scene.RenderMethod>();

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

      jLabel4.setText("Connected servers");

      jButton3.setText("Next");
      jButton3.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton3ActionPerformed(evt);
         }
      });

      jTextField3.setText("3000");
      jTextField3.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jTextField3ActionPerformed(evt);
         }
      });

      jLabel5.setText("Port number:");

      javax.swing.GroupLayout SetupPanelLayout = new javax.swing.GroupLayout(SetupPanel);
      SetupPanel.setLayout(SetupPanelLayout);
      SetupPanelLayout.setHorizontalGroup(
         SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jSeparator2)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SetupPanelLayout.createSequentialGroup()
            .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel4))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2))
         .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SetupPanelLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SetupPanelLayout.createSequentialGroup()
                  .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(SetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(SetupPanelLayout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
               .addGroup(SetupPanelLayout.createSequentialGroup()
                  .addComponent(jButton2)
                  .addGap(0, 74, Short.MAX_VALUE))
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton3))
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

      jLabel3.setText("Time:");

      jTextField2.setFocusable(false);
      jTextField2.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jTextField2ActionPerformed(evt);
         }
      });

      jButton8.setText("Render on Servers");
      jButton8.setEnabled(false);
      jButton8.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton8ActionPerformed(evt);
         }
      });

      jLabel2.setText("Number of Cores:");

      jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

      jProgressBar1.setIndeterminate(true);

      jButton9.setText("Render locally");
      jButton9.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton9ActionPerformed(evt);
         }
      });

      jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
      jPanel1.setName(""); // NOI18N

      jComboBox2.setToolTipText("which scene to render");

      jLabel6.setText("Width:");

      jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
      jTextField5.setText("640");

      jLabel7.setText("Height:");

      jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
      jTextField4.setText("480");

      jLabel9.setText("AA mult:");
      jLabel9.setToolTipText("antialiasing multiplier (smoother edges)");

      jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

      jLabel8.setText("Max. Depth:");
      jLabel8.setToolTipText("number of times to reflect");

      jSpinner2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(2), Integer.valueOf(0), null, Integer.valueOf(1)));

      jComboBox3.setToolTipText("which method to use for rendering a pixel");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jLabel9)
                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                              .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(jSpinner1)
                           .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                           .addComponent(jSpinner2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))))))
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel6))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel9))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel8)
               .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
      );

      javax.swing.GroupLayout CompletePanelLayout = new javax.swing.GroupLayout(CompletePanel);
      CompletePanel.setLayout(CompletePanelLayout);
      CompletePanelLayout.setHorizontalGroup(
         CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(CompletePanelLayout.createSequentialGroup()
            .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jButton7)
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(CompletePanelLayout.createSequentialGroup()
                  .addGap(0, 50, Short.MAX_VALUE)
                  .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CompletePanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CompletePanelLayout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(CompletePanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                           .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))))
      );
      CompletePanelLayout.setVerticalGroup(
         CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CompletePanelLayout.createSequentialGroup()
            .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(CompletePanelLayout.createSequentialGroup()
                  .addComponent(jButton6)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton5)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel3)
                     .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel2))
                  .addGap(25, 25, 25))
               .addGroup(CompletePanelLayout.createSequentialGroup()
                  .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jButton8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(CompletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton7)
               .addComponent(jButton9)))
      );

      jProgressBar1.getAccessibleContext().setAccessibleName("");

      mainPanel.add(CompletePanel, "card1");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 313, Short.MAX_VALUE)
         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
               .addContainerGap()))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 239, Short.MAX_VALUE)
         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private boolean setupScene()
   {
      jTextField4.setBackground(Color.WHITE);
      jTextField5.setBackground(Color.WHITE);

      try
      {
         Scene.Type type = (Scene.Type) jComboBox2.getSelectedItem();
         int width = Integer.parseInt(jTextField5.getText());
         int height = Integer.parseInt(jTextField4.getText());
         int depth = (Integer) jSpinner2.getValue();
         int aa = (Integer) jSpinner1.getValue();
         Scene.RenderMethod method = (Scene.RenderMethod) jComboBox3.getSelectedItem();

         if (width < 1 || height < 1)
         {
            throw new NumberFormatException();
         }

         client.chooseScene(type, width, height, depth, aa, method);
      }
      catch (NumberFormatException e)
      {
         //mark input fields red and return false
         jTextField4.setBackground(Color.RED);
         jTextField5.setBackground(Color.RED);
         jTextField5.requestFocus();
         return false;
      }

      return true;
   }

   private void connectToServer()
   {
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
         jButton8.setEnabled(true); //enable Render button
      }
      catch (Exception e)
      {
         jTextField1.setBackground(Color.RED);
         jTextField1.requestFocus();
      }
   }

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

      if (size > 0) //list not empty - select an index
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
            jButton8.setEnabled(false); //disable Render button
         }
         else //selection
         {
            jButton2.setEnabled(true); //enable Disconnect button
            jButton8.setEnabled(true); //enable Render button
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

   private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField3ActionPerformed
   {//GEN-HEADEREND:event_jTextField3ActionPerformed
      connectToServer(); //enter key pressed in textfield
   }//GEN-LAST:event_jTextField3ActionPerformed

   private void jButton9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton9ActionPerformed
   {//GEN-HEADEREND:event_jButton9ActionPerformed
      final int numCores = Integer.parseInt((String) jComboBox1.getSelectedItem());
      final boolean isConnected = jButton8.isEnabled(); //'Render on servers' button enabled
      if (!setupScene())
      {
         return;
      }

      jTextField2.setText(""); //reset time field

      //disable buttons until rendering is complete
      jButton7.setEnabled(false); //Disable 'Back'
      jButton8.setEnabled(false); //Disable 'Render on servers'
      jButton9.setEnabled(false); //Disable 'Render locally'
      jButton5.setEnabled(false); //Disable 'Display image'
      jButton6.setEnabled(false); //Disable 'Save image'

      //      mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      jProgressBar1.setVisible(true);

      new Thread()
      {
         @Override
         public void run()
         {
            long startTime = System.currentTimeMillis();
            client.runLocally(numCores);
            long endTime = System.currentTimeMillis();

            jTextField2.setText("" + ((endTime - startTime) / 1000.0) + " seconds");
            jButton7.setEnabled(true); //Enable 'Back'
            jButton8.setEnabled(isConnected); //Restore state of 'Render on servers'
            jButton9.setEnabled(true); //Enable 'Render locally'
            jButton5.setEnabled(true); //Enable 'Display image'
            jButton6.setEnabled(true); //Enable 'Save image'

            //            mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            jProgressBar1.setVisible(false);
         }
      }.start();
   }//GEN-LAST:event_jButton9ActionPerformed

   private void jButton8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton8ActionPerformed
   {//GEN-HEADEREND:event_jButton8ActionPerformed
      final int numCores = Integer.parseInt((String) jComboBox1.getSelectedItem());
      if (!setupScene())
      {
         return;
      }

      jTextField2.setText(""); //reset time field

      //disable buttons until rendering is complete
      jButton7.setEnabled(false); //Disable 'Back'
      jButton8.setEnabled(false); //Disable 'Render on servers'
      jButton9.setEnabled(false); //Disable 'Render locally'
      jButton5.setEnabled(false); //Disable 'Display image'
      jButton6.setEnabled(false); //Disable 'Save image'

      //      mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      jProgressBar1.setVisible(true);

      new Thread()
      {
         @Override
         public void run()
         {
            long startTime = System.currentTimeMillis();
            client.startRunnables(numCores);
            long endTime = System.currentTimeMillis();

            jTextField2.setText("" + ((endTime - startTime) / 1000.0) + " seconds");
            jButton7.setEnabled(true); //Enable 'Back'
            jButton8.setEnabled(true); //Enable 'Render on servers'
            jButton9.setEnabled(true); //Enable 'Render locally'
            jButton5.setEnabled(true); //Enable 'Display image'
            jButton6.setEnabled(true); //Enable 'Save image'

            //            mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            jProgressBar1.setVisible(false);
         }
      }.start();
   }//GEN-LAST:event_jButton8ActionPerformed

   private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField2ActionPerformed
   {//GEN-HEADEREND:event_jTextField2ActionPerformed
      //This is the amount of time it took to render
   }//GEN-LAST:event_jTextField2ActionPerformed

   private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton7ActionPerformed
   {//GEN-HEADEREND:event_jButton7ActionPerformed
      //Back button pressed
      CardLayout cl = (CardLayout) mainPanel.getLayout();
      cl.previous(mainPanel);
   }//GEN-LAST:event_jButton7ActionPerformed

   private void jButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton6ActionPerformed
   {//GEN-HEADEREND:event_jButton6ActionPerformed
      client.saveImageToFile(); //'Save image' pressed
   }//GEN-LAST:event_jButton6ActionPerformed

   private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton5ActionPerformed
   {//GEN-HEADEREND:event_jButton5ActionPerformed
      client.displayImage();
   }//GEN-LAST:event_jButton5ActionPerformed

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
         for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
         {
            if ("Nimbus".equals(info.getName()))
            {
               UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      }
      catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
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
   private javax.swing.JButton jButton5;
   private javax.swing.JButton jButton6;
   private javax.swing.JButton jButton7;
   private javax.swing.JButton jButton8;
   private javax.swing.JButton jButton9;
   private javax.swing.JComboBox jComboBox1;
   private javax.swing.JComboBox<Scene.Type> jComboBox2;
   private javax.swing.JComboBox<Scene.RenderMethod> jComboBox3;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel jLabel9;
   private javax.swing.JList jList1;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JProgressBar jProgressBar1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JSeparator jSeparator2;
   private javax.swing.JSpinner jSpinner1;
   private javax.swing.JSpinner jSpinner2;
   private javax.swing.JTextField jTextField1;
   private javax.swing.JTextField jTextField2;
   private javax.swing.JTextField jTextField3;
   private javax.swing.JTextField jTextField4;
   private javax.swing.JTextField jTextField5;
   private javax.swing.JPanel mainPanel;
   // End of variables declaration//GEN-END:variables
}
