package fr.georgy;

/* source avec la documentation produite par javadoc sans les accents */

/**
 * Cette classe represente la position d'un passager par rapport a un transport.
 * Une position a trois etats possibles : assis dans un transport, 
 * debout dans un transport et dehors d'un transport.
 *
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2016
 **/
public class Position {
	
  private static Position positionDehors = new Position();
  private static Position positionAssis = new Position();
  private static Position positionDebout = new Position();

  /**
   * construit une l'instance dans la position dehors.
   * 
   */
  private Position() {
  }

  /**
   * La position est-elle dehors ?
   *
   * @return vrai si l'etat de l'instance est dehors;
   */
  public boolean estDehors() {
	  return this != positionAssis && this != positionDebout;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai si l'etat de l'instance est assis;
   */
  public boolean estAssis() {
	  return this == positionAssis;
  }

  /**
   * La position est-elle debout ?
   *
   * @return vrai si l'etat de l'instance est debout;
   */
  public boolean estDebout() {
	  return this == positionDebout;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai la position est assis ou debout.
   */
  public boolean estInterieur() {
	  return this != positionDehors;
  }


  /**
   * Fournit une position assis.
   *
   * @return instance dans l'etat assis.
   */
  public Position assis() {
	  return positionAssis; 
  }

  /**
   * Fournit une position debout.
   *
   * @return instance dans l'etat debout.
   */
  public Position debout() {
    return positionDebout;
  }

  /**
   * Fournit une position dehors.
   *
   * @return instance dans l'etat dehors.
   */
  public static Position dehors() {
    return positionDehors;
  }

  /**
   * Cette methode est heritee de la classe {@link java.lang.Object}.
   * Tres utile pour le debogage, elle permet de fournir une 
   * chaine de caracteres correspondant a l'etat d'un objet.
   * Mais, il faut adapter le code de cette methode a chaque classe.
   *
   * @return une des chaines "<endehors>", "<assis>", "<debout>"
   * en fonction de la position courante.
   */
  @Override
  public String toString() {
    String nom = null;
    
    if (this == positionDehors) {
    	nom = "endehors";
    }
    else if (this == positionDebout) {
    	nom = "debout";
    }
    else if (this == positionDehors) {
    	nom = "dehors";
    }
    
    return "<" + nom + ">";
  }
}
