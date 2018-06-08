package fr.glize.td4;

interface VehiculeMontee {
	public boolean aPlaceAssise();
	public boolean aPlaceDebout();
	
	public boolean monteeDemanderAssis(Passager p);
	public boolean monteeDemanderDebout(Passager p);
}
