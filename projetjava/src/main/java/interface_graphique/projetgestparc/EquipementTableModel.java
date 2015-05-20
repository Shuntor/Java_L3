/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_graphique.projetgestparc;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import parcinfo.Equipement;


/**
 *
 * @author KENT
 */
public class EquipementTableModel extends AbstractTableModel{
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
            return "Type";
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
        switch(column){
            case 0:
                return equ.get(row).getNom();
            case 1:
                return equ.get(row).getAdresse();
            case 2:
                return equ.get(row).getType();
            case 3:
                return equ.get(row).getSalle();
            case 4:
                return equ.get(row).getEtat();
            case 5:
                return equ.get(row).getOs();
            
            }
        return null;
    }

    public void addEquipement(Equipement eq) {
        equ.add(eq);
        fireTableStructureChanged();
    }
    
    public void supprEquipement(int row) {
        equ.remove(row);
        fireTableStructureChanged();
    }
}
