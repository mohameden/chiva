package clinique.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import clinique.servlets.InitServlet;


public class ChargementProjetProperties {
	
	private static Properties props;
	private static ChargementProjetProperties instance = new ChargementProjetProperties();
	public void load () throws Exception
	{
		if (props == null)
		{
			File f = new File (InitServlet.CHEMIN_ROOT+"paramsConfigs/projet.properties");
			FileInputStream in = new FileInputStream (f);
			props = new Properties();
			props.load(in);
		}
	}
	
	private ChargementProjetProperties ()
	{
		super();
		try {
			load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static ChargementProjetProperties getInstance() {
		return instance;
	}


	public String getValueByKey (String key) throws Exception
	{
		String value = null;
		load();
		if (props.containsKey(key))
		{
			value = props.getProperty(key);
		}
		else
		{
			throw new Exception ("La clé est inéxistante dans le fichier properties du projet");
		}
		return value;
	}

}
