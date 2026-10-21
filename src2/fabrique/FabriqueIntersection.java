package fabrique;

/**
 * modelise une fabrique correspondant � une intersection
 * 
 */
public class FabriqueIntersection implements FabriqueVehicule {

	/**
	 * les probabilit�s d'arriv�e
	 */
	double probaVoiture, probaBus, probaByc, probaPieton;

	/**
	 * constructeur vide, construit par defaut 
	 */
	public FabriqueIntersection() {
		this.probaBus = 0.10;
		this.probaByc = 0.05;
		this.probaPieton = 0.05;
		this.probaVoiture = 0.80;
	}

	/**
	 * donne les probas � la construction
	 * @param bus les probas d'avoir un bus
	 * @param byc une bicyclette
	 * @param voit une voiture
	 * @param piet un pietno
	 */
	public FabriqueIntersection(double bus, double byc, double voit, double piet) {
		this.probaBus = bus;
		this.probaByc = byc;
		this.probaPieton = piet;
		this.probaVoiture = voit;
	}

	@Override
	/**
	 * methode de la fabrique surcharg�e
	 * choisit un v�hicule selon une distribution de probabilit� donn�e par les attributs
	 */
	public Vehicule creerVehicule() {

		double random = Math.random();
		//on regarde si cela correspond à la proba de l'événement bus
		if (random < probaBus)
			return new Bus();
		//on retire la proba de la distribution
		random = random - probaBus;
		//on recommence
		if (random < probaByc)
			return new Bicyclette();
		random = random - probaByc;
		if (random < probaVoiture)
			return new Voiture();
		return new Pieton();
	}

}
