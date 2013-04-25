/**
 *
 */
package clinique.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Admin
 * 
 */
public final class UtilDate {

	private static final UtilDate INSTANCE = new UtilDate();
	
	private static final String FORMATMYSQL = "yyyy-MM-dd";
	private static final String FORMAT = "dd/MM/yyyy";
	public static final String FORMAT_DATE_MORPHO = "yyyy-MM-dd HH:mm:ss";

	/**
	 * @return the instance
	 */
	public static UtilDate getInstance() {
		return INSTANCE;
	}

	public Date stringToDate(String t) {
		try {
			if(t == null) return null;
			Date d = new SimpleDateFormat(FORMAT).parse(t);
			return d;
		} catch (Exception e) {
			return null;
		}
	}
	

	
	public Date stringToDateFormatMysql(String t) {
		try {
			if(t == null) return null;
			Date d = new SimpleDateFormat(FORMATMYSQL).parse(t);
			return d;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String stringToDateMysql(String t) {
		try {
			if(t == null) return null;
			String d = getFormatDate(stringToDate(t),FORMATMYSQL);
			return d;
		} catch (Exception e) {
			return null;
		}
	}

	public String dateToString(Date val) {
		if(val == null) return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
		String dateString = dateFormat.format(val);
		return dateString;
	}
	
	public String dateToStringMysql(Date val) {
		if(val == null) return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(FORMATMYSQL);
		String dateString = dateFormat.format(val);
		return dateString;
	}
	
	

	
	public String getDateForId()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date today = new Date();
		return formatter.format(new Timestamp(today.getTime()));

	}
	
	public String getDateForId2()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date today = new Date();
		return formatter.format(new Timestamp(today.getTime()));

	}
	
	public Date getDateToday()
	{
		Date aujourdhui = new Date(); 
		SimpleDateFormat  formater = new SimpleDateFormat("yyyy-MM-dd");
		
		return stringToDateFormatMysql(formater.format(aujourdhui));
	}
	
	
	
	public Boolean beforeDateJour(Date val1) {
		if(val1 == null) return Boolean.FALSE;
		Calendar dateJour = Calendar.getInstance();
    	Calendar date1 = (Calendar) dateJour.clone();
    	date1.setTime(val1);
    	return Boolean.valueOf(date1.before(dateJour));
	}
	
	public Boolean beforeDateJour(String val1) {
    	return beforeDateJour(stringToDate(val1));
	}
	
	//if date1 after date2 return true
	public Boolean date1AfterDate2(String date1,String date2) {
		
    	return date1AfterDate2(stringToDate(date1),stringToDate(date2));
	}
	
    public Boolean date1AfterOrEqualDate2(String date1,String date2) {
		
    	return date1AfterOrEqualDate2(stringToDate(date1),stringToDate(date2));
	}
	
	
	
	//if date1 after date2 return true
	public Boolean date1AfterDate2(Date val1,Date val2) {
		if(val1 == null) return Boolean.FALSE;
		if(val2 == null) return Boolean.TRUE;
		Calendar dateJour = Calendar.getInstance();
    	Calendar date1 = (Calendar) dateJour.clone();
    	Calendar date2 = (Calendar) dateJour.clone();
    	date1.setTime(val1);
    	date2.setTime(val2);
    	//if date1 after date2 return true
    	return Boolean.valueOf(date1.after(date2));
	}
	
	public Boolean date1AfterOrEqualDate2(Date val1,Date val2) {
		if(val1 == null) return Boolean.FALSE;
		if(val2 == null) return Boolean.TRUE;
		Calendar dateJour = Calendar.getInstance();
    	Calendar date1 = (Calendar) dateJour.clone();
    	Calendar date2 = (Calendar) dateJour.clone();
    	date1.setTime(val1);
    	date2.setTime(val2);
    	//if date1 after date2 return true
    	if (date1.equals(date2))return true;
    	else return Boolean.valueOf(date1.after(date2));
	}
	
	
	//if dateActe+3mois after ajourdhui return true
	public Boolean afterTroisMois(Date dateActe) throws Exception
	{
		if(dateActe == null) return Boolean.FALSE;
		//if(val2 == null) return Boolean.TRUE;
		Calendar dateJour = Calendar.getInstance();
    	Calendar date1 = (Calendar) dateJour.clone();
    	Calendar date2 = (Calendar) dateJour.clone();
    	date1.setTime(dateActe);
    	
    	date1.add(Calendar.MONTH, +Integer.parseInt(ChargementProjetProperties.getInstance().getValueByKey("DUREE_DELAI_LEGAL").toString()));
    	return Boolean.valueOf(date1.after(date2));
	}
	
	
	public Date plusUnMois(Date date1) throws Exception
	{
		if(date1 == null) return null;
		//if(val2 == null) return Boolean.TRUE;
		
		Calendar date2 = Calendar.getInstance();
    	date2.setTime(date1);
    	date2.add(Calendar.MONTH,1);
    	
    	return date2.getTime();
	}
	
	public Date moinUnMois(Date date1) throws Exception
	{
		if(date1 == null) return null;
		//if(val2 == null) return Boolean.TRUE;
		
		Calendar date2 = Calendar.getInstance();
    	date2.setTime(date1);
    	date2.add(Calendar.MONTH,-1);
    	
    	return date2.getTime();
	}
	



	public int getAge(Date dateNaissance) {
		if(dateNaissance == null) return 0;
		Calendar curr = Calendar.getInstance();
		Calendar naiss = Calendar.getInstance();
		naiss.setTime(dateNaissance);
		int diff = curr.get(Calendar.YEAR) - naiss.get(Calendar.YEAR);
		curr.add(Calendar.YEAR, -diff);
		if (naiss.after(curr)) {
			diff = diff - 1;
		}
		return diff;

	}
	
	public int getAge_Acte(Date dateNaissance,Date dateActe) {
		if(dateNaissance == null) return 0;
		Calendar curr = Calendar.getInstance();
		curr.setTime(dateActe);
		Calendar naiss = Calendar.getInstance();
		naiss.setTime(dateNaissance);
		int diff = curr.get(Calendar.YEAR) - naiss.get(Calendar.YEAR);
		curr.add(Calendar.YEAR, -diff);
		if (naiss.after(curr)) {
			diff = diff - 1;
		}
		return diff;

	}

	public static int nbMoiDates(String dateString1, String dateString2) throws Exception  {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = sdf.parse(dateString1);
        GregorianCalendar gc1 = new GregorianCalendar();
        gc1.setTime(date1);
        Date date2 = sdf.parse(dateString2);
        GregorianCalendar gc2 = new GregorianCalendar();
        gc2.setTime(date2);
        int gap = 0;
        gc1.add(GregorianCalendar.MONTH, 1);
        while(gc1.compareTo(gc2)<=0) {
            gap++;
            gc1.add(GregorianCalendar.MONTH, 1);
        }
        return gap;
    }
	
	public String getFormatDateSqueletteMorpho (Date date) throws Exception
	{
		if (date == null)
		{
			return "1900-01-01 00:00:00";
		}
		String dateFormate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE_MORPHO);
    	dateFormate= dateFormat.format(date);
		return dateFormate;
	}

	public String getFormatDate (Date date, String formatDate) throws Exception
	{
		if (date == null)
		{
			return null;
		}
		String dateFormate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatDate);
    	dateFormate= dateFormat.format(date);
		return dateFormate;
	}
	
	public String dateDelai()
	{

		Calendar dateJour = Calendar.getInstance();
    	Calendar date1 = (Calendar) dateJour.clone();
    	
    	
    	date1.add(Calendar.MONTH, -3);
    	return dateToString(date1.getTime());
	}
	
	 public  boolean isVide(String chaine ){
			boolean ret = false;
			if (chaine==null || chaine.trim().length()<1)
				ret = true;
			return ret;
		}
	 
	 public String getChaineKey(int idKey)
	 {
		 if (idKey<0) return "0"+idKey;
		 else return String.valueOf(idKey);
	 }
	 
	 public  double sansVirgule(double a) {
			double p = Math.pow(10.0, 0);
			return Math.floor((a*p)+0.5) / p;
		}
}
