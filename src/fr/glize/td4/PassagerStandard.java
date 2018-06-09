package fr.glize.td4;

import fr.georgy.Position;

//source sans la documentation produite par javadoc.

public class PassagerStandard implements Usager, Passager {
	
	final private String m_nom;
	private int m_destination;
	private Position m_position;

	public PassagerStandard(String nom, int destination) {
		m_nom = nom;
		m_destination = destination;
		changerEnDehors();
	}

	public String nom() {
	  return m_nom;
	}
	
	public boolean estDehors() { 
	  return m_position.estDehors();
	}
	
	public boolean estAssis() {
	  return m_position.estAssis();
	}
	
	public boolean estDebout() {
	  return m_position.estDebout();
	}
	
	public void changerEnDehors() {
		m_position = Position.dehors();
	}
	
	public void changerEnAssis() {
		m_position = m_position.assis();
	}
	
	public void changerEnDebout() {
		m_position = m_position.debout();
	}
	
	public void monterDans(Transport t) {
		VehiculeMontee v = (VehiculeMontee) t;
		// System.out.println(m_nom + " essaye de monter dans l'autobus");
		if (!estDehors()) {
			// System.out.println(m_nom + " n'est pas dehors, il ne peut donc pas monter dans l'autobus");
			return;
		}
		
		if (v.aPlaceAssise()) {
			v.monteeDemanderAssis(this);
		}
		else if (v.aPlaceDebout()) {
			v.monteeDemanderDebout(this);
		}
	}
	
	public void nouvelArret(VehiculeArret v, int numeroArret) {
		if (numeroArret == m_destination) {
			v.arretDemanderSortie(this);
		}
	}
	
	@Override
	public String toString() {
		return "PassagerStandard : " + m_nom + " destination : " + m_destination + " Position : " + m_position;
	}
}
