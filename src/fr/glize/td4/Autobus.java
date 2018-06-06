package fr.glize.td4;

import fr.georgy.Jauge;

//source sans la documentation produite par javadoc.

public class Autobus {
	
	private Jauge m_jauge_assis;
	private Jauge m_jauge_debout;
	
	private int m_arret = 0;
	private int m_nb_passager = 0;
	
	private PassagerStandard[] m_passager_standard; 

	public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
		m_jauge_assis = new Jauge(nbPlaceAssise, 0);
		m_jauge_debout = new Jauge(nbPlaceDebout, 0);
		
		m_passager_standard = new PassagerStandard[nbPlaceAssise + nbPlaceDebout];
	}
	
	public int getArret() {
		return m_arret;
	}

	public boolean aPlaceAssise() {
		return m_jauge_assis.estVert();
	}
	
	public boolean aPlaceDebout() {
		return m_jauge_debout.estVert();
	}
	
	public boolean monteeDemanderAssis(PassagerStandard p) {
		if (!p.estDehors() || !aPlaceAssise()) {
			// System.out.println("Montee demander assis impossible");
			return false;
		}
		
		m_jauge_assis.incrementer();
		p.changerEnAssis();
		m_passager_standard[m_nb_passager] = p;
		m_nb_passager++;
		return true;
	}
	
	public boolean monteeDemanderDebout(PassagerStandard p) {
		if (!p.estDehors() || !aPlaceDebout()) {
			// System.out.println("Montee demander debout impossible");
			return false;
		}
		
		m_jauge_debout.incrementer();
		p.changerEnDebout();
		m_passager_standard[m_nb_passager] = p;
		m_nb_passager++;
		return true;
	}
	
	public void allerArretSuivant() {
		m_arret++;
		
		for (int i = 0; i < m_passager_standard.length; i++) {
			if (m_passager_standard[i] != null) {
				m_passager_standard[i].nouvelArret(this, m_arret);
			}
		}
	}
	
	public void arretDemanderAssis(PassagerStandard p) {
		if (!aPlaceAssise() || p.estAssis()) {
			System.out.println("Demande assis impossible");
			return;
		}
		
		m_jauge_assis.incrementer();
		m_jauge_debout.decrementer();
		
		p.changerEnAssis();
	}
	
	public void arretDemanderDebout(PassagerStandard p) {
		if (!aPlaceDebout() ||p.estDebout()) {
			System.out.println("Demande debout impossible");
			return;
		}
		
		m_jauge_debout.incrementer();
		m_jauge_assis.decrementer();
		
		p.changerEnDebout();
	}
	
	public void arretDemanderSortie(PassagerStandard p) {
		if (p.estDehors()) {
			return;
		}
		
		if (p.estAssis()) {
			m_jauge_assis.decrementer();
		}
		else if (p.estDebout()) {
			m_jauge_debout.decrementer();
		}
		else {
			return;
		}
		
		for (int i = 0; i < m_passager_standard.length; i++) {
			if (m_passager_standard[i] == p) {
				m_passager_standard[i] = null;
			}
		}
		
		p.changerEnDehors();
		m_nb_passager--;
	}
	
	@Override
	public String toString() {
		return "Arrêt en cours : " + m_arret +
				"\n  Jauge Assis : " + m_jauge_assis + 
				"\n  Jauge Debout : " + m_jauge_debout;
	}
}
