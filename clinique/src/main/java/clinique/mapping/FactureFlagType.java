package clinique.mapping;

public enum FactureFlagType {

	ORIGINAL("ORIGINAL"), DUPLICATA("DUPLICATA");

	private final String printName;

	private FactureFlagType(String printName) {
		this.printName = printName;
	}

	public String getPrintName() {
		return printName;
	}
}
