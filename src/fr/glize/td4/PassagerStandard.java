package fr.glize.td4;

import fr.georgy.Position;

//source sans la documentation produite par javadoc.

class PassagerStandard {
	
	final private String m_nom;
	private int m_destination;
	private Position m_position;

	public PassagerStandard(String nom, int destination) {
		m_nom = nom;
		m_destination = destination;
		m_position = new Position();
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
		m_position = m_position.dehors();
	}
	
	public void changerEnAssis() {
		m_position = m_position.assis();
	}
	
	public void changerEnDebout() {
		m_position = m_position.debout();
	}
	
	public void monterDans(Autobus t) {
		System.out.println(m_nom + " essaye de monter dans l'autobus");
		if (!estDehors()) {
			System.out.println(m_nom + " n'est pas dehors, il ne peut donc pas monter dans l'autobus");
			return;
		}
		
		if (!t.monteeDemanderAssis(this)) {
			if (!t.monteeDemanderDebout(this)) {
				System.out.println("Le passager " + m_nom + " ne peut pas monter dans l'autobus car il n'y a plus de place");
			}
		}
	}
	
	public void nouvelArret(Autobus bus, int numeroArret) {
		if (numeroArret == m_destination) {
			bus.arretDemanderSortie(this);
		}
	}
	
	@Override
	public String toString() {
		return "Passager : " + m_nom + " destination : " + m_destination + " Position : " + m_position;
	}
}
