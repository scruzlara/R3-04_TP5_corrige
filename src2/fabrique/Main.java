package fabrique;

public class Main {

	public static void main(String[] args) {
		
		Simulateur s;
		s=new Simulateur(new FabriqueVoiture());
		s.afficherStats();
		
		s=new Simulateur(new FabriquePieton());
		s.afficherStats();
		
		s=new Simulateur(new FabriqueIntersection());
		s.afficherStats();
		s.dessinerStats();
		
		/*s=new Simulateur(new FabriqueJonction(new FabriqueVoiture(),new FabriquePieton()));
		s.afficherStats();
		s.dessinerStats();*/
		
		
	}
	
}
