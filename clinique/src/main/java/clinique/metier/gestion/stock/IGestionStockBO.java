package clinique.metier.gestion.stock;

import org.apache.struts.action.ActionMessages;

import clinique.model.gestion.stock.GestionStockForm;

public interface IGestionStockBO {

	public static final String NAME = "IGestionStockBO";

	public abstract ActionMessages checkEntreeStock(GestionStockForm formulaire);

	public abstract ActionMessages checkFounisseur(GestionStockForm formulaire);

	public abstract ActionMessages checkProduit(GestionStockForm formulaire);

	public abstract ActionMessages checkSortieStock(GestionStockForm formulaire);

	public abstract ActionMessages getErrors();

	public abstract boolean getListJournalStock(GestionStockForm formulaire)
			throws Exception;

	public abstract boolean getListProduits(GestionStockForm formulaire)
			throws Exception;

	public abstract void initialiserCombosClasses(GestionStockForm formulaire);

	public abstract void initialiserCombosFournisseurs(
			GestionStockForm formulaire);

	public abstract void initialiserCombosProduits(GestionStockForm formulaire);

	public abstract String saveEntreeStock(GestionStockForm formulaire);

	public abstract String saveFounisseur(GestionStockForm formulaire);

	public abstract String saveProduit(GestionStockForm formulaire);

	public abstract String saveSortieStock(GestionStockForm formulaire);

	public abstract void setErrors(ActionMessages errors);

}