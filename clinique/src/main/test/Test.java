import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	private String result = "";
	private final String case1 = "AXXXXXXX";
	private final String case2 = "XXXXXXXY";
	private final String case3 = "YXXXXXXY";

	private final String case4 = "ABXXXXXX";
	private final String case5 = "XXXXXXYY";

	private final String case6 = "ABXXXYYY";
	private final String case7 = "ABCDXXYY";
	private final String case8 = "ABXYXYXY";
	private final String case9 = "ABCXXXXX";
	private final String case10 = "ABCDXXXX";

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean checkNum(String num) {

		num = num.trim();
		if (num.length() != 8) {
			System.out.println("Num�ro incorrecte");
			return false;
		}

		char p1 = num.charAt(0);
		char p2 = num.charAt(1);
		char p3 = num.charAt(2);
		char p4 = num.charAt(3);
		char p5 = num.charAt(4);
		char p6 = num.charAt(5);
		char p7 = num.charAt(6);
		char p8 = num.charAt(7);

		if (checkPlatin(p1, p2, p3, p4, p5, p6, p7, p8)) {
			System.out.println("Numero Platin de type de " + getResult());
			return true;
		} else if (checkOr(p1, p2, p3, p4, p5, p6, p7, p8)) {
			System.out.println("Numero Or de type de " + getResult());
			return true;
		} else if (checkArgent(p1, p2, p3, p4, p5, p6, p7, p8)) {
			System.out.println("Numero Argent de type de " + getResult());
			return true;
		}

		System.out.println("Num�ro normal");
		return false;
	}

	public boolean checkPlatin(char p1, char p2, char p3, char p4, char p5,
			char p6, char p7, char p8) {
		// case AXXX XXXX
		if (p8 == p7 & p8 == p6 & p8 == p5 & p8 == p4 & p8 == p3 & p8 == p2) {
			setResult(case1);
			return true;
		}

		// case XXXX XXXY
		else if (p2 == p1 & p2 == p7 & p2 == p6 & p2 == p5 & p2 == p4
				& p2 == p3 & p2 != p8) {
			setResult(case2);
			return true;
		}

		// case YXXX XXXY
		else if (p8 == p1 & p2 != p8 & p2 == p7 & p2 == p6 & p2 == p5
				& p2 == p4 & p2 == p3) {
			setResult(case3);
			return true;
		}

		return false;
	}

	public boolean checkOr(char p1, char p2, char p3, char p4, char p5,
			char p6, char p7, char p8) {
		// case ABXXXYYY
		if (p8 == p7 & p8 == p6 & p8 == p5 & p8 == p4 & p8 == p3) {
			setResult(case4);
			return true;
		}

		// case XXXXXXYY
		else if (p8 == p7 & p2 == p6 & p2 == p5 & p2 == p4 & p2 == p3
				& p2 == p1) {
			setResult(case5);
			return true;
		}

		// case YXXX XXXY
		else if (p8 == p1 & p2 != p8 & p2 == p7 & p2 == p6 & p2 == p5
				& p2 == p4 & p2 == p3) {
			setResult(case3);
			return true;
		}

		return false;
	}

	public boolean checkArgent(char p1, char p2, char p3, char p4, char p5,
			char p6, char p7, char p8) {
		// case ABXXXYYY
		if (p8 == p7 & p8 == p6 & p8 != p5 & p5 == p4 & p5 == p3) {
			setResult(case6);
			return true;
		}

		// case ABCDXXYY
		else if (p8 == p7 & p5 == p6 & p6 != p8) {
			setResult(case7);
			return true;
		}

		// case ABXYXYXY
		else if (p8 == p6 & p6 == p4 & p5 == p7 & p5 == p3 & p8 != p7) {
			setResult(case8);
			return true;
		}

		// case ABCXXXXX
		else if (p8 == p7 & p7 == p6 & p6 == p5 & p5 == p4) {
			setResult(case9);
			return true;
		}

		// case ABCDXXXX
		else if (p8 == p7 & p7 == p6 & p6 == p5) {
			setResult(case10);
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		testMapping();
		// try {
		// Test test = new Test();
		// // test.checkNum("37777773");
		// Date date = new Date();
		// System.out.println(date.getHours());
		//
		// } catch (Exception e) {
		// System.out.println(e);
		// }

	}

	public static void testIt() {
		Scanner s;
		try {
			s = new Scanner(new FileInputStream(
					"C:/workspace/babs/GestionClinique/chiva/clinique/l.txt"));
			while (s.hasNextLine()) {
				System.out.println(s.nextLine().substring(36));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testMapping() {
		Scanner s;
		try {
			s = new Scanner(
					new FileInputStream(
							"C:/workspace/babs/GestionClinique/chiva/clinique/mapping.txt"));
			while (s.hasNextLine()) {
				String line = s.nextLine();
				int j = line.lastIndexOf('"');
				System.out.println("<value>" + line.substring(21, j)
						+ "</value>");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}