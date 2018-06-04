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

  private final int DEHORS = 1;
  private final int ASSIS  = 2;
  private final int DEBOUT = 3;

  private final int courant;

  /**
   * construit une l'instance dans la position dehors.
   * 
   */
  public Position() {
    courant = DEHORS;
  }

  /**
   * Construit une instance en precisant un des positions du passager.
   * 
   * @param e valeur de l'etat.
   */
  private Position(int e) {
    courant = e;
  }

  /**
   * La position est-elle dehors ?
   *
   * @return vrai si l'etat de l'instance est dehors;
   */
  public boolean estDehors() {
    return courant != ASSIS && courant != DEBOUT;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai si l'etat de l'instance est assis;
   */
  public boolean estAssis() {
    return courant == ASSIS;
  }

  /**
   * La position est-elle debout ?
   *
   * @return vrai si l'etat de l'instance est debout;
   */
  public boolean estDebout() {
    return courant == DEBOUT;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai la position est assis ou debout.
   */
  public boolean estInterieur() {
    return courant != DEHORS;
  }


  /**
   * Fournit une position assis.
   *
   * @return instance dans l'etat assis.
   */
  public Position assis() {
    return new Position(ASSIS); 
  }

  /**
   * Fournit une position debout.
   *
   * @return instance dans l'etat debout.
   */
  public Position debout() {
    return new Position(DEBOUT);
  }

  /**
   * Fournit une position dehors.
   *
   * @return instance dans l'etat dehors.
   */
  public Position dehors() {
    return new Position(DEHORS);
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
    switch(courant) {
    case DEHORS :
      nom = "endehors";
      break;
    case ASSIS :
      nom = "assis";
      break;
    case DEBOUT :
      nom = "debout";
      break;
    }
    return "<" + nom + ">";
  }
}
