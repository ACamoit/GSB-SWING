package fr.gsb.editeurs;
import javax.swing.*;
import javax.swing.table.TableCellEditor;

import fr.gsb.controleurs.controleurBoutonVoirRapports;

import java.awt.*;
import java.awt.event.*;

public class editeurBoutonVoirRapports extends DefaultCellEditor{
	
	protected JButton button = new JButton();
	private controleurBoutonVoirRapports ctrl = new controleurBoutonVoirRapports() ;
	
	public editeurBoutonVoirRapports(){
		
		super(new JCheckBox());
		this.button.addActionListener(this.ctrl);
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		
		super.getTableCellEditorComponent(table, value, isSelected, row, column);
		
		this.ctrl.setRow(row);
		this.ctrl.setMatricule(Integer.parseInt(table.getValueAt(row,0).toString()));
	
		if(value == null){
			this.button.setText("");
		}
		
		else{
			this.button.setText(value.toString());
		}
		
		return this.button;
	}

}
