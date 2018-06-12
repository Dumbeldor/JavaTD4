package fr.glize.main;

import fr.glize.td4.Autobus;
import fr.glize.td4.FabriqueTec;
import fr.glize.td4.NavetteTerminus;
import fr.glize.td4.Usager;


class Simple {

  static public void main (String[] args) {
	  System.out.println("Début des tests");
	  Autobus serenity = FabriqueTec.faireAutobus(10, 20);
	  NavetteTerminus navTerm = FabriqueTec.faireNavetteTerminus(10, 20);

	  Usager kaylee = FabriqueTec.fairePassagerLunatique("Kaylee", 10);
	  Usager jayne = FabriqueTec.fairePassagerLunatique("Jayne", 4);
	  Usager inara = FabriqueTec.fairePassagerStresse("Inara", 5);
	  Usager cailloux = FabriqueTec.fairePassagerStresse("Cailloux", 5);
	  
	  cailloux.changerEnDehors();

	  System.out.println(serenity);

	  serenity.allerArretSuivant();
	  //1
	  kaylee.monterDans(serenity);
	  
	  System.out.println(serenity);
	  System.out.println(kaylee);
	  System.out.println(cailloux);

	  serenity.allerArretSuivant();
    //2
	  jayne.monterDans(serenity);
	  cailloux.monterDans(serenity);

	  System.out.println(serenity);
	  System.out.println(kaylee);
	  System.out.println(jayne);
	  System.out.println(cailloux);

	  serenity.allerArretSuivant();
	  //3
	  inara.monterDans(serenity);
	  
	  System.out.println(serenity);
	  System.out.println(kaylee);
	  System.out.println(jayne);
	  System.out.println(inara);
	  System.out.println(cailloux);

	  serenity.allerArretSuivant();
    //4
	  System.out.println(serenity);
	  System.out.println(kaylee);
	  System.out.println(jayne);
	  System.out.println(inara);
	  System.out.println(cailloux);

	  serenity.allerArretSuivant();
	  //5
	  System.out.println(serenity);
	  System.out.println(kaylee);
	  System.out.println(jayne);
	  System.out.println(inara);
	  System.out.println(cailloux);
	  
	  System.out.println("Fin des tests");
    
  }
}

/* Resultat de l'execution.
[arret:0, assis:<0 [0,1[>, debout: <0 [0,2[>]
[arret:1, assis:<1 [0,1[>, debout: <0 [0,2[>]
Kaylee <assis>
[arret:2, assis:<1 [0,1[>, debout: <1 [0,2[>]
Kaylee <assis>
Jayne <debout>
[arret:3, assis:<1 [0,1[>, debout: <2 [0,2[>]
Kaylee <assis>
Jayne <debout>
Inara <debout>
[arret:4, assis:<0 [0,1[>, debout: <1 [0,2[>]
Kaylee <endehors>
Jayne <endehors>
Inara <debout>
[arret:5, assis:<0 [0,1[>, debout: <0 [0,2[>]
Kaylee <endehors>
Jayne <endehors>
Inara <endehors>
*/
