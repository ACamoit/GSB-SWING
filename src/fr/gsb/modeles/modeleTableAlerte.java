package fr.gsb.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.gsb.entites.Rapport;
import fr.gsb.entites.Visiteur;

public class modeleTableAlerte extends AbstractTableModel {
	

	private List<Visiteur> lesVisiteurs;
	private String [] entetes = {"Matricule", "Nom","Objectif", "Resultat"};
	
	public modeleTableAlerte(List<Visiteur> lesVisiteurs) {
		super();
		this.lesVisiteurs = lesVisiteurs;
		
	}
	
	
	public int getRowCount() {
		
		return this.lesVisiteurs.size();
		
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
				return String.class ;
				
			case 1 : 
				return String.class ;
				
			case 2 : 
				return int.class ;
				
			case 3 :
				return int.class ;
				
		}
		
		return null;
		
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		
		if(columnIndex == 0){
			
			return this.lesVisiteurs.get(rowIndex).getMatricule();
					
		}
		else if(columnIndex == 1){
			return this.lesVisiteurs.get(rowIndex).getNom()+" "+this.lesVisiteurs.get(rowIndex).getPrenom();
		}
		
		else if(columnIndex == 2){
			return this.lesVisiteurs.get(rowIndex).getObjectif();
			
		}else if(columnIndex == 3){
			
			return this.lesVisiteurs.get(rowIndex).getNbRapports();
			
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
