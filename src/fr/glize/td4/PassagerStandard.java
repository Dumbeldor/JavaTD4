package fr.glize.td4;

//source sans la documentation produite par javadoc.

public class PassagerStandard extends PassagerAbstrait {

	public PassagerStandard(String nom, int destination) {
		super(nom, destination);
	}

	// monterDans
	@Override
	protected void choixPlaceMontee(VehiculeMontee v) {
		if (v.aPlaceAssise()) {
			v.monteeDemanderAssis(this);
		}
		else if (v.aPlaceDebout()) {
			v.monteeDemanderDebout(this);
		}				
	}

	// nouvelArret
	@Override
	protected void choixChangerPlace(VehiculeArret v, int arret) {}
	
}
