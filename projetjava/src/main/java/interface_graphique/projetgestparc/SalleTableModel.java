/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_graphique.projetgestparc;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 21408234
 */
public class SalleTableModel extends DefaultTableModel {

    private List<Salle> lsalle = new ArrayList<>();

    public SalleTableModel() {
        lsalle = new ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 2;

    }

    /*public void setValueAt(Object value, int row, int col) {
     data[row][col] = value;
     fireTableCellUpdated(row, col);
     }*/
    public String getColumnName(int a) {
        if (a == 0) {
            return "Nom";
        }
        if (a == 1) {
            return "Local";
        }
        
        return null;
    }

    @Override
    public int getRowCount() {
        if (lsalle == null) {
            return 0;
        }
        return lsalle.size();
    }

    @Override
    public Object getValueAt(int row, int column) {        
        switch(column){
            case 0:
                return lsalle.get(row).getNom();
            case 1:
                return lsalle.get(row).getNomLocalSalle();
            }
                
           /* return lcl.get(row).getAdresse();
            return lcl.get(row).getTaille();*/
        return null;
            
        }

    public void addSalle(Salle sal) {
        lsalle.add(sal);
        fireTableStructureChanged();
    }
    
    public void supprSalle(int row) {
        lsalle.remove(row);
        fireTableStructureChanged();
    }
}
