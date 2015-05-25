/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_graphique.projetgestparc;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author KENT
 */
public class Couleur extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent (JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
    Component cell = super.getTableCellRendererComponent
    (table,value,isSelected,hasFocus,row,column);

    if ((value != null) && (value.equals("HS"))) {
        cell.setBackground(Color.RED);
    }
    else {
        cell.setBackground(Color.white);

    
    }
    return cell;

    }
}
