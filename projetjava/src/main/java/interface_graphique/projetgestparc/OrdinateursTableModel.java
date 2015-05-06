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
public class OrdinateursTableModel extends DefaultTableModel {

    private List<Ordinateur> ordi = new ArrayList<>();

    public OrdinateursTableModel() {
        ordi = new ArrayList<>();
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
        if (ordi == null) {
            return 0;
        }
        return ordi.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (column == 0) {
            return ordi.get(row).getNom();
        }
        return "";
    }

    void addOrdinateur(Ordinateur ord) {
        ordi.add(ord);
        fireTableStructureChanged();
    }
}
