package fr.glize.td4;

interface VehiculeArret {
	public boolean aPlaceAssise();
	public boolean aPlaceDebout();
	
	public void arretDemanderDebout(Passager p);
	public void arretDemanderAssis(Passager p);
	public void arretDemanderSortie(Passager p);
}
