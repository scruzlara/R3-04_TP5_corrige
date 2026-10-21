package fabrique;

/**
 * une fabrique composite, qui creer en choisissant aternativement un de ses attributs
 * repr�sente une rencontre de deux routes qui fusionnent
 */
public class FabriqueJonction implements FabriqueVehicule {

	/**
	 * les fabriques qui composent la fabriquejonction
	 */
	FabriqueVehicule gauche,droite;
	/**
	 * determination de la fabrique a utiliser
	 */
	boolean origineGauche;
	
	/**
	 * constructeur 
	 * @param g fabrique gauche
	 * @param d fabrique droite
	 */
	public FabriqueJonction(FabriqueVehicule g, FabriqueVehicule d)
	{
		this.gauche=g;
		this.droite=d;
		this.origineGauche=true;
	}

	@Override
	/**
	 * surcharge de la m�thode du patron fabrique
	 * en fonction de l'aternative, construit un vehicule venant de  gauche ou de droite
	 */
	public Vehicule creerVehicule() {
		if (origineGauche)
		{
			origineGauche=false;
			return(gauche.creerVehicule());
		}
		else
		{
			origineGauche=true;
			return(droite.creerVehicule());
		}
	}
}
