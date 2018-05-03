package fr.gsb.rendus;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class renduTableRapport extends DefaultTableCellRenderer  {

	public renduTableRapport(){
		super() ;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		DefaultTableCellRenderer composant = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		if(table.getValueAt(row, 5).toString().equals("true")){
			composant.setBackground(Color.WHITE);
		}
		else{
			composant.setBackground(Color.LIGHT_GRAY);
		}
		
		return composant ;
	}
	
	

}
