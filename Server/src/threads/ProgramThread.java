/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import controller.Controller;
import domen.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aleks
 */
public class ProgramThread extends Thread{
    
    private final JTable table;

    public ProgramThread(JTable table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().interrupted()) {
            Controller.getInstance();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            while (true) {
                noviModel(model);
                table.setModel(model);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    //Logger.getLogger(ProgramThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void noviModel(DefaultTableModel model) {
        try {
            model.setRowCount(0);
            List<Query> data = Controller.getInstance().getQuery(); //umesto Object napravi klasu koju ce da vraca
            for(Query o : data){
                model.addRow(new Object[]{o.getHall(), o.getMovie(), o.getDate(), o.getTimeStart(), o.getAvailableSeats()});//umesto o.toString nazivi kolona
            }
        } catch (Exception ex) {
            Logger.getLogger(ProgramThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
