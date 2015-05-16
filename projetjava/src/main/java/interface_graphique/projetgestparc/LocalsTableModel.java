package interface_graphique.projetgestparc;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author 21408234
 */
public class LocalsTableModel extends DefaultTableModel {

    private List<Locals> lcl = new ArrayList<>();

    public LocalsTableModel() {
        lcl = new ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 2;

    }

    /*public void setValueAt(Object value, int row, int col) {
     data[row][col] = value;
     fireTableCellUpdated(row, col);
     }*/
    @Override
    public String getColumnName(int a) {
        if (a == 0) {
            return "Nom";
        }
        if (a == 1) {
            return "adresse";
        }
        else
        
        return null;
        
    }

    @Override
    public int getRowCount() {
        if (lcl == null) {
            return 0;
        }
        return lcl.size();
    }

    @Override
    public Object getValueAt(int row, int column) {        
        switch(column){
            case 0:
                return lcl.get(row).getNom();
            case 1:
                return lcl.get(row).getAdresse();
            }
                
           /* return lcl.get(row).getAdresse();
            return lcl.get(row).getTaille();*/
        return null;
            
        }
        
    

    public void addLocal(Locals lc) {
        lcl.add(lc);
        fireTableStructureChanged();
    }
}
