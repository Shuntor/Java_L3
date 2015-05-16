/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_graphique.projetgestparc;

import java.util.ArrayList;
import java.util.List;
import parcinfo.Equipement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KENT
 */
public class EquipementTableModel extends DefaultTableModel{
    private final List<Equipement> equ;

    /**
     *
     */
    public EquipementTableModel() {  
        equ = new ArrayList<>();
    
    }

    @Override
    public int getColumnCount() {
        return 6;

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
            return "@MAC";
        }
        if (a == 2) {
            return "Local";
        }
        if (a == 3) {
            return "Salle";
        }
        if (a == 4) {
            return "Etat";
        }
        if (a == 5) {
            return "Système d'exploitation";
        }
        
        return null;
    }

    @Override
    public int getRowCount() {
        if (equ == null) {
            return 0;
        }
        return equ.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (column == 0) {
            return equ.get(row).getNom();
        }
        return "";
    }

    public void addEquipement(Equipement eq) {
        equ.add(eq);
        fireTableStructureChanged();
    }
}
