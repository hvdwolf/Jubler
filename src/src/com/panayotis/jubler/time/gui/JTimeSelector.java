/*
 * JTimeSelector.java
 *
 * Created on March 12, 2008, 3:46 PM
 */
package com.panayotis.jubler.time.gui;

import com.panayotis.jubler.time.Time;
import static com.panayotis.jubler.i18n.I18N._;
import com.panayotis.jubler.time.gui.JTimeSpinner;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author  teras
 */
public class JTimeSelector extends JPanel {

    private JTimeSpinner spinner;
    private boolean is_start_position;
    private Time selected_time;

    /** Creates new form JTimeSelector */
    public JTimeSelector(boolean start_position) {
        initComponents();
        spinner = new JTimeSpinner();
        add(spinner, BorderLayout.CENTER);

        is_start_position = start_position;
        if (start_position) {
            InfoL.setText(_("Begin"));
            SelectM.setText(_("Set time to start of selected subtitles"));
            EdgeM.setText(_("Set time to minimum"));
        } else {
            InfoL.setText(_("Finish"));
            SelectM.setText(_("Set time to end of selected subtitles"));
            EdgeM.setText(_("Set time to maximum"));
        }
    }

    public void setEnabled(boolean status) {
        super.setEnabled(status);
        InfoL.setEnabled(status);
        EdgeB.setEnabled(status);
        spinner.setEnabled(status);
    }

    void setSelectedTime (Time t) {
        selected_time = t;
        spinner.setTimeValue(t);
    }
    
    double getTime() {
        return spinner.getTimeValue().toSeconds();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PredefM = new javax.swing.JPopupMenu();
        SelectM = new javax.swing.JMenuItem();
        EdgeM = new javax.swing.JMenuItem();
        InfoL = new javax.swing.JLabel();
        EdgeB = new javax.swing.JButton();

        SelectM.setText("Item");
        SelectM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectMActionPerformed(evt);
            }
        });
        PredefM.add(SelectM);

        EdgeM.setText("Item");
        EdgeM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdgeMActionPerformed(evt);
            }
        });
        PredefM.add(EdgeM);

        setLayout(new java.awt.BorderLayout());
        add(InfoL, java.awt.BorderLayout.PAGE_START);

        EdgeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gear.png"))); // NOI18N
        EdgeB.setToolTipText(_("Use predifined time positions"));
        EdgeB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EdgeBMousePressed(evt);
            }
        });
        add(EdgeB, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents
    private void EdgeBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EdgeBMousePressed
        if (EdgeB.isEnabled())
            PredefM.show(EdgeB, evt.getX(), evt.getY());
    }//GEN-LAST:event_EdgeBMousePressed

    private void EdgeMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdgeMActionPerformed
        if (is_start_position)
            spinner.setTimeValue(new Time(0));
        else
            spinner.setTimeValue(new Time(Time.MAX_TIME));
}//GEN-LAST:event_EdgeMActionPerformed

    private void SelectMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectMActionPerformed
        spinner.setTimeValue(selected_time);
    }//GEN-LAST:event_SelectMActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EdgeB;
    private javax.swing.JMenuItem EdgeM;
    private javax.swing.JLabel InfoL;
    private javax.swing.JPopupMenu PredefM;
    private javax.swing.JMenuItem SelectM;
    // End of variables declaration//GEN-END:variables
}
