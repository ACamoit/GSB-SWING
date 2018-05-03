package fr.gsb.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.gsb.entites.Rapport;

public class modeleTableRapport extends AbstractTableModel {

	
	private List<Rapport> lesRapports;
	private String [] entetes = {"Numéro", "Date","Ville", "Praticien", "Button", "Consulté"};
	
	public modeleTableRapport(List<Rapport> lesRapports) {
		super();
		this.lesRapports = lesRapports;
		
	}
	
	
	public int getRowCount() {
		
		return this.lesRapports.size();
		
	}
	
	public int getColumnCount() {
		
		return entetes.length;
	}
	
	public String getColumnName(int column) {
		
		return entetes[column];
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		
	
		switch (columnIndex){
			
			case 0 : 
				return int.class ;
				
			case 1 : 
				return String.class ;
				
			case 2 : 
				return String.class ;
				
			case 3 :
				return String.class ;
				
			case 4 :
				return String.class ;
			
			case 5 :
				return Boolean.class ;
		}
		
		return null;
		
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		
		if(columnIndex == 0){
			
			return this.lesRapports.get(rowIndex).getNumRapport();
					
		}
		else if(columnIndex == 1){
			return this.lesRapports.get(rowIndex).getRapDate();
		}
		
		else if(columnIndex == 2){
			return this.lesRapports.get(rowIndex).getRapVille();
			
		}else if(columnIndex == 3){
			
			return this.lesRapports.get(rowIndex).getNomPraticien();
			
		}else if(columnIndex == 4){
			
			return "Voir";
		}else if(columnIndex == 5){
			
			return this.lesRapports.get(rowIndex).getEstVu();
		}
		
		return null;
		
	}
	
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		if(columnIndex == 4){
			
			return true ;
		}
		else{
			
			return false;
		}
		
	}


	public void actualiser(){
		this.fireTableDataChanged();
	}
	

}


