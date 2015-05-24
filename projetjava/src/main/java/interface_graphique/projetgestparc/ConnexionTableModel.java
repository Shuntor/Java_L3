/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_graphique.projetgestparc;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import parcinfo.Connexion;
import parcinfo.Equipement;


/**
 *
 * @author KENT
 */
public class ConnexionTableModel extends AbstractTableModel{
    private final List<Connexion> con;

    /**
     *
     */
    public ConnexionTableModel() {  
        con = new ArrayList<>();
    
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
            return "EquipementA";
        }
        if (a == 1) {
            return "EquipementB";
        }
        return null;
    }

    @Override
    public int getRowCount() {
        if (con == null) {
            return 0;
        }
        return con.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return con.get(row).getEquipementA();
            case 1:
                return con.get(row).getEquipementB();
            }
        return null;
    }

    public void addConnexion(Connexion c) {
        con.add(c);
        fireTableStructureChanged();
    }
    
    public void supprConnexion(int row) {
        con.remove(row);
        fireTableStructureChanged();
    }
}
