package fabrique;
import java.util.HashMap;
import java.util.Map;

/**
 * calcule des statistiques associées à une fabrique.
 * Cela permet de montrer comment la fabrique doit etre utilisée
 * 
 * On attend une Fabrique interface, on passe une fabrique concrete qui genere les objets concrets qu'on souhaite
 * 
 *
 */
public class Simulateur {

	/**
	 * la fabrique utilisée
	 */
	FabriqueVehicule generateur;
	
	/**
	 * constructeur d'un simulateur
	 * @param f fabrique utile
	 */
	public Simulateur(FabriqueVehicule f)
	{
		this.generateur=f;
	}
	
	/**
	 * genere les statistiques sur 100 vehicules
	 * @return table associative [type -> nb véhicules]
	 */
	public Map<String,Integer> genererStats()
	{
		Map<String,Integer> res=new HashMap<String,Integer>();
		for (int i=0;i<100;i++)
		{
			int ancien=0;
			Vehicule v=this.generateur.creerVehicule();
			String typeVehicule = v.getType();
			if (res.containsKey(typeVehicule))
				ancien=res.get(typeVehicule);
			res.put(typeVehicule,ancien+1);
		}
		return(res);
	}
	
	/**
	 * genere et affiche les statistiques dans la console
	 */
	public void afficherStats()
	{
		Map<String,Integer> res=genererStats();
		System.out.println("*********************");
		for (String s:res.keySet())
		{
			System.out.println(""+s+" -> "+res.get(s));
		}
	}
	
	/**
	 * genere et affiche les staitistuqyes dans une fenetre grace à la classe
	 * AfficheurStat.
	 */
	public void dessinerStats()
	{
		Map<String,Integer> res=genererStats();
		AfficheurStat st=new AfficheurStat(res,200);
		st.display();
	}
	
	
}
