/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewForm;

import communication.Operation;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import controller.Controller;
import domen.Booking;
import domen.Movie;
import domen.Show;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aleks
 */
public class FrmClient extends javax.swing.JFrame {

    private List<Movie> movies;
    private List<Show> shows;
    private List<Booking> bookings;
    
    public FrmClient() {
        initComponents();
        napuniCb(jComboBox1);
        getBookings();
        
        //combo box u tabeli
        /*
        JComboBox<String> cb = JComboBox<>(); // slicno je i za check box
        cb.addItem(nekiItem);
        TableColumn tc = jTable.getColumnModel().getColumn(0);
        tc.setCellEditor(new DefaultCellEditor(cb));
        */
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Movie");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Movie", "Hall", "Amount", "Price", "Date & time"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Date");

        jButton2.setText("Set date");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Number of seats");

        jTextField1.setEnabled(false);

        jLabel4.setText("Pick time");

        jComboBox2.setEnabled(false);

        jButton1.setText("Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Your bookings");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("New booking");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(0, 101, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton3)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Movie movie = movies.get(jComboBox1.getSelectedIndex());
        if (this.jFormattedTextField1.getText().length() > 0) {
            java.util.Date d = java.util.Date.from(Instant.now());
            try {
                this.jFormattedTextField1.commitEdit();
                d = (java.util.Date) jFormattedTextField1.getValue();
            } catch (ParseException ex) {
                Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println(date);
            Date date = new Date(d.getTime());
            System.out.println(movie.getName() + " " + date);
            List<Show> shows = getAllShow(movie, date);
            if (shows.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sorry we dont have any showing for your criteria.");
            } else {
                this.jComboBox2.removeAllItems();
                for (Show s : shows) {
                    this.jComboBox2.addItem(s.getTimeStart().toString());
                }
                this.jComboBox2.setEnabled(true);
                this.jTextField1.setEnabled(true);
            }
        }else {
            JOptionPane.showMessageDialog(this, "You must set date first!");
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (jTextField1.getText().length() > 0) {
            if (Integer.parseInt(jTextField1.getText()) > shows.get(jComboBox2.getSelectedIndex()).getAvailableSeats()) {
                JOptionPane.showMessageDialog(this, "There is not enough seats in your selected time!");
                return;
            }

            long s = shows.get(jComboBox2.getSelectedIndex()).getDate().getTime() + shows.get(jComboBox2.getSelectedIndex()).getTimeStart().getTime() + 3600000;
            Timestamp d = new Timestamp(s);
            System.out.println(d);
            Booking booking = new Booking(
                    shows.get(jComboBox2.getSelectedIndex()).getIdShow(),
                    Controller.getInstance().getUser().getIdUser(),
                    Integer.parseInt(jTextField1.getText()),
                    movies.get(jComboBox1.getSelectedIndex()).getPrice() * Integer.parseInt(jTextField1.getText()),
                    movies.get(jComboBox1.getSelectedIndex()).getName(),
                    shows.get(jComboBox2.getSelectedIndex()).getHall(),
                    d);
            book(booking);
        }else {
            JOptionPane.showMessageDialog(this, "Please enter number of seats.");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Booking booking = bookings.get(jTable1.getSelectedRow());
        deleteBooking(booking);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void napuniCb(JComboBox<String> jComboBox1) {
        try {
            //napravi request
            Request request = new Request(Operation.GET_ALL_MOVIES, null);
            
            //posalji request i upisi response
            Response response = Controller.getInstance().ucitajCb(request);
            
            //vidi kakav je odgovor servera
            if(response.getResponseType().equals(ResponseType.SUCCESS)){
                movies = (List<Movie>) response.getResult();
                for (Movie m : movies) {
                    jComboBox1.addItem(m.getName());
                }
            }else{
                JOptionPane.showMessageDialog(this,"Error occured: " +response.getException().getMessage());
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<Show> getAllShow(Movie movie, Date date) {
        try {
            Show s = new Show(movie.getIdMovie(), date);
            Request request = new Request(Operation.GET_ALL_SHOWS,s);
            Response response = Controller.getInstance().getAllShows(request);
            if(response.getResponseType().equals(ResponseType.SUCCESS)){
                shows = (List<Show>) response.getResult();
                return shows;
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    private void book(Booking booking) {
        try {
            Request request = new Request(Operation.BOOK,booking);
            Response response = Controller.getInstance().book(request);
            if(response.getResponseType().equals(ResponseType.SUCCESS)){
                System.out.println("BOOK");
                getBookings();
            }else{
                JOptionPane.showMessageDialog(this, "Error!");
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getBookings() {
        try {
            Request request = new Request(Operation.GET_ALL_BOOKINGS,Controller.getInstance().getUser());
            Response response = Controller.getInstance().getAllBookings(request);
            if(response.getResponseType().equals(ResponseType.SUCCESS)){
                bookings = (List<Booking>) response.getResult();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                bookings.forEach(b -> {
                    model.addRow(new Object[]{b.getMovie(), b.getHall(), b.getAmount(), b.getPrice(), b.getStart()});
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteBooking(Booking booking) {
        try {
            Request request = new Request(Operation.DELETE_BOOKING,booking);
            Response response = Controller.getInstance().deleteBooking(request);
            if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                getBookings();
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
