package fr.georgy;

/* source avec la documentation produite par javadoc sans les accents */

/**
 * Realisation d'une jauge avec un intervalle d'entiers.
 * <p>
 * Un objet Jauge definit un niveau dans un intervalle [0, vigieMax[. 
 * Le niveau d'une jauge n'est pas limite aux valeurs dans l'intervalle.
 * <p>
 * L'etat d'une jauge correspond a la position de son niveau par rapport a 
 * l'intervalle [0, vigieMax[.
 * Une jauge definit deux etats : 
 * <ul>
 * <li>rouge niveau superieur a l'intervalle,
 * <li>vert niveau dans l'intervalle, 
 * </ul>
 * 
 * @author georgy
 * @since 2006-2016
 */
public class Jauge { 
  private int valeur;
  private final int max;

  /**
   * Construit une instance en precisant la valeur de depart de la Jauge
   * et l'intervalle de vigie.
   * 
   * @param vigieMax valeur maximale > 0 de l'intervalle de vigie.
   * @param depart       valeur initiale du niveau.
   */
  public Jauge(int vigieMax, int depart) {
    valeur = depart;
    max = vigieMax;
  }

  /**
   * Le niveau de la jauge est-il au-dessus de vigieMax ?
   *
   * @return vrai si niveau >=  vigieMax.
   *
   */
  public boolean estRouge() {
    return valeur >= max;
  }

  /**
   * Le niveau de la jauge est-il dans l'intervalle ?
   *
   * @return vrai si niveau appartient a [0, vigieMax[.
   *
   */
  public boolean estVert() {
    return valeur >= 0 && !estRouge();
  }

  /**
   * Incremente le niveau d'une unite.
   * Le niveau peut devenir superieur a vigieMax.
   */
  public void incrementer() {
    valeur++;
  }

  /**
   * Decremente le niveau d'une unite.
   */
  public void decrementer() {
      valeur--;
  }

  /**
   * Cette methode est heritee de la classe {@link java.lang.Object}.
   * Tres utile pour le debogage, elle permet de fournir une 
   * chaine de caracteres correspondant a l'etat d'un objet.
   * Mais, il faut adapter son code a chaque classe.
   *
   * @return la chaine "<7 [0,23[>" si l'etat d'une jauge est 
   * vigieMax=23, niveau=7.
   */
  @Override
  public String toString() {
    return "<" + valeur + " [0," + max + "[>"; 
  }
}
