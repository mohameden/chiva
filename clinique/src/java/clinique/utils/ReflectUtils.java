package clinique.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.log4j.Logger;

import clinique.servlets.InitServlet;



/**
 * <pre>
 * Utilitaire de gestion des résolutions dynamiques des classes et méthodes.
 * </pre>
 * @version $Date: 2012/02/29 13:42:29 $, $Revision: 1.1 $, branche-$Name:  $  
 * @author $Author: Administrateur $
 */
public class ReflectUtils {
	
	/**
	 * types primitifs
	 */
	private static Logger log = Logger.getLogger(ReflectUtils.class);
	public static final String PRIMITIVES 		= "int;float;double;byte;char;long;short;boolean";
	public static final String SIMPLES_TYPES 	= "String;Integer;Byte;Short;Character;Long;Double;Float;Boolean;Date;Calendar";
	public static final String COLLECTION_TYPES = "Collection;Vector";
	public static final String SIT_PACKAGE 		= "clinique";

	private static final String  SERIAL_ID = "serialVersionUID";
	
	private static final String OPERATEUR_NESTED = ".";
	public static final String OPERATEUR_CONCAT = ", ";

	/**
	 * @param primitive type primitif
	 * @return renvoi est ce que c'est un type primitif
	 */
	public static boolean isPrimitiveType(String primitive) {
		return PRIMITIVES.indexOf (primitive) >= 0;
	}
	
	/**
	 * @param clazz
	 * @return true / false
	 */
	public static boolean isSimpleType(Class clazz) {
		String className = clazz.getName().substring(clazz.getName().lastIndexOf(OPERATEUR_NESTED) + 1);
		return SIMPLES_TYPES.indexOf (className) >= 0;
	}
	
	/**
	 * @param clazz
	 * @return true / false
	 */
	public static boolean isCollectionType(Class clazz) {
		String className = clazz.getName().substring(clazz.getName().lastIndexOf(OPERATEUR_NESTED) + 1);
		return COLLECTION_TYPES.indexOf (className) >= 0;
	}
		
	/**
	 * @param primitive type primitif
	 * @return renvoi le type primitif en question
	 */
	public static Class getPrimitiveType(String primitive) {
		if (primitive.equals("int"))
			return Integer.TYPE;
		else if (primitive.equals("byte"))
			return Byte.TYPE;
		else if (primitive.equals("short"))
			return Short.TYPE;
		else if (primitive.equals("char"))
			return Character.TYPE;
		else if (primitive.equals("long"))
			return Long.TYPE;
		else if (primitive.equals("double"))
			return Double.TYPE;
		else if (primitive.equals("float"))
			return Float.TYPE;
		else if (primitive.equals("boolean"))
			return Boolean.TYPE;
		return null;
	}

	/**
	 * renvoi un objet de type 'type'
	 * @param type classe primitive
	 * @param value valeur à convertir
	 * @return objet de type 'type'
	 */
	public static Object getValueOfPrimitiveCast(Class type, Object value) {
		if (type.isPrimitive()) {
			if (!(value instanceof String)) {
				return value;
			} 
			if (type.equals(Integer.TYPE))
				return new Integer((String) value);
			if (type.equals(Long.TYPE))
				return new Long((String) value);
			if (type.equals(Short.TYPE))
				return new Short((String) value);
			if (type.equals(Double.TYPE))
				return new Double((String) value);
			if (type.equals(Float.TYPE))
				return new Float((String) value);
			if (type.equals(Character.TYPE))
				return new Character(((String) value).charAt(0));
			if (type.equals(Boolean.TYPE))
				return new Boolean((String) value);
		}
		return value;
	}

	/**
	 * @param attrName nom d'attribut
	 * @return renvoi la méthode get correspondante
	 * @see #getAttributeGetMethodName(String,boolean)
	 */
	public static String getAttributeGetMethodName(String attrName) {
		return getAttributeGetMethodName(attrName, true);
	}

	/**
	 * @param attrName nom d'attribut
	 * @param useBeanStyle utiliser le style de 'bean'
	 * @return renvoi la méthode get correspondante
	 */
	public static String getAttributeGetMethodName(String attrName,
			boolean useBeanStyle) {
		if (!useBeanStyle) {
			return attrName;
		}
		return "get" + attrName.substring(0, 1).toUpperCase() + attrName.substring(1);
	}

	/**
	 * @param attrName nom d'attribut
	 * @return renvoi la méthode set correspondante
	 * @see #getAttributeSetMethodName(String,boolean)
	 */
	public static String getAttributeSetMethodName(String attrName) {
		return getAttributeSetMethodName(attrName, true);
	}

	/**
	 * @param attrName nom d'attribut
	 * @param useBeanStyle utiliser le style de 'bean'
	 * @return renvoi la méthode get correspondante
	 */
	public static String getAttributeSetMethodName(String attrName,
			boolean useBeanStyle) {
		if (!useBeanStyle) {
			return attrName;
		}
		return "set" + attrName.substring(0, 1).toUpperCase() + attrName.substring(1);
	}

	/**
	 * @param attrName nom d'attribut
	 * @param clazz classe d'appartenance de l'attribut attrName
	 * @return la méthode correspondante
	 * @throws BaseException
	 * @see #getAttributeGetMethod(String, Class,boolean)
	 */
	public static Method getAttributeGetMethod(String attrName, Class clazz)
			throws Exception {
		return getAttributeGetMethod(attrName, clazz, true);
	}

	/**
	 * @param attrName nom d'attribut
	 * @param clazz classe d'appartenance de l'attribut attrName
	 * @param useBeanStyle utiliser le style de 'bean'
	 * @return la méthode correspondante
	 * @throws Exception
	 */
	public static Method getAttributeGetMethod(String attrName, Class clazz,
			boolean useBeanStyle) throws Exception {
		try {
			return getMethod(clazz, getAttributeGetMethodName(attrName,
					useBeanStyle), (Class[]) null);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public static Method getCascadingAttributeGetMethod(String propertyName,
			Class parentClazz, boolean useBeanStyle)
			throws Exception {
		int indexOfDot = propertyName.indexOf(OPERATEUR_NESTED);
		Class workingClass = parentClazz;
		while (true) {
			if (indexOfDot < 0) {
				return getAttributeGetMethod(propertyName, workingClass,
											useBeanStyle);
			} 
			String innerPropertyName = propertyName
					.substring(0, indexOfDot);
			propertyName = propertyName.substring(indexOfDot + 1);
			indexOfDot = propertyName.indexOf(OPERATEUR_NESTED);
			Method getMethod = ReflectUtils.getAttributeGetMethod(
					innerPropertyName, workingClass);
			workingClass = getMethod.getReturnType();
		}
	}


	/**
	 * @param attrName nom d'attribut
	 * @param clazz classe d'appartenance de l'attribut attrName
	 * @param attrType type d'attribut
	 * @return la méthode correspondante
	 * @throws Exception
	 */
	public static Method getAttributeSetMethod(String attrName, Class clazz,
			Class attrType) throws Exception {
		return getAttributeSetMethod(attrName, clazz, attrType, true);
	}

	/**
	 * @param attrName nom d'attribut
	 * @param clazz classe d'appartenance de l'attribut attrName
	 * @param attrType type d'attribut
	 * @param useBeanStyle utiliser le style de 'bean'
	 * @return la méthode correspondante
	 * @throws Exception
	 */
	public static Method getAttributeSetMethod(String attrName, Class clazz,
			Class attrType, boolean useBeanStyle) throws Exception {
		if (attrType == null) {
			return getAttributeSetMethod(attrName, clazz, (Class[]) null,
					useBeanStyle);
		} 
		return getAttributeSetMethod(attrName, clazz,
				new Class[] { attrType }, useBeanStyle);
	}

	/**
	 * @param propertyName nom de la propriété
	 * @param parentClazz la classe mére
	 * @param propertyType type de la propriété
	 * @param useBeanStyle utiliser le style de 'bean'
	 * @return la méthode correspondante
	 * @throws Exception
	 */
	public static Method getCascadingAttributeSetMethod(String propertyName,
			Class parentClazz, Class propertyType, boolean useBeanStyle)
			throws Exception {
		int indexOfDot = propertyName.indexOf(OPERATEUR_NESTED);
		Class workingClass = parentClazz;
		while (true) {
			if (indexOfDot < 0) {
				return getAttributeSetMethod(propertyName, workingClass,
						propertyType, useBeanStyle);
			} 
			String innerPropertyName = propertyName
					.substring(0, indexOfDot);
			propertyName = propertyName.substring(indexOfDot + 1);
			indexOfDot = propertyName.indexOf(OPERATEUR_NESTED);
			Method getMethod = ReflectUtils.getAttributeGetMethod(
					innerPropertyName, workingClass);
			workingClass = getMethod.getReturnType();
		}
	}

	/**
	 * @param attrName nom d'attribut
	 * @param clazz classe d'appartenance de l'attribut attrName
	 * @param attrType type d'attribut
	 * @return la méthode correspondante
	 * @throws Exception
	 * @see #getAttributeSetMethod(String,Class,Class[],boolean)
	 */
	public static Method getAttributeSetMethod(String attrName, Class clazz,
			Class[] attrType) throws Exception {
		return getAttributeSetMethod(attrName, clazz, attrType, true);
	}

	/**
	 * @param attrName nom d'attribut
	 * @param clazz classe d'appartenance de l'attribut attrName
	 * @param attrType type d'attribut
	 * @param useBeanStyle utiliser le style de 'bean'
	 * @return la méthode correspondante
	 * @throws Exception
	 */
	public static Method getAttributeSetMethod(String attrName, Class clazz,
			Class[] attrType, boolean useBeanStyle) throws Exception {
		try {
			String methodName = attrName;
			if (useBeanStyle) {
				methodName = getAttributeSetMethodName(attrName);
			}
			return getMethod(clazz, methodName, attrType);
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return null;
		}
	}

	/**
	 * @param attrName nom d'attribut
	 * @param clazz classe d'appartenance de l'attribut attrName
	 * @return la méthode correspondante
	 * @throws Exception
	 */
	public static Method getAttributeSetMethod(String attrName, Class clazz)
			throws Exception {
		try {
			return getAttributeSetMethod(attrName, clazz, clazz.getDeclaredField(
					attrName).getType());
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return null;
		} 
	}

    /**
	 * @param obj objet à modifier
	 * @param propName nom de la propriété
	 * @param propType type de la propriété 
	 * @param value valeur de la propriété
	 * @throws Exception
	 */
	public static void setPropertyValue(Object obj, String propName, Class propType, Object value) throws Exception  {
    	setPropertyValue(obj, propName, propType, value, false);
    }
    
    /**
	 * @param obj objet à modifier
	 * @param propName nom de la propriété
	 * @param propType type de la propriété 
	 * @param value valeur de la propriété
	 * @param ignore ignorer s'elle n'existe pas
	 * @throws Exception
	 */
	public static void setPropertyValue(Object obj, String propName, Class propType, Object value, boolean ignore) throws Exception  {
    	if (obj == null) {
    		return;
    	}
    	Method setMethod = null;
    	try {
    		setMethod = getMethod(obj.getClass(), getSetMethod(propName), new Class[] {propType});
    	} catch (Exception mnfex) {
    		try {
				setMethod = getMethod(obj.getClass(), propName, new Class[] {propType});
			} catch (Exception e) {
	    		if (ignore) {
	    			return;
	    		}
				
				log.fatal(e.getMessage());
			}
    	}
    	try {
    		setMethod.invoke (obj, new Object [] {value});
    	} catch (Exception iaex) {
			
			throw iaex;
    	} 
    }
    
    /**
	 * @param obj objet à modifier
	 * @param attrName nom de l'attribut
	 * @param value valeur de l'attribut
	 * @throws Exception
	 */
	public static void setAttributeValue(Object obj, String attrName, Object value) throws Exception  {
        if (obj == null)
            return;
        Method getMethod=null;
		try {
			getMethod = getMethod(obj.getClass(), getGetMethod(attrName));
		} catch (Exception e) {
			log.fatal(e.getMessage());
		}
        Class typeItLike = getMethod.getReturnType();
    	Method setMethod = getMethod(obj.getClass(), getSetMethod(attrName), new Class[] {typeItLike});
    	if(value == null) {
    		if(!isPrimitiveType(typeItLike.getName())) {
	    		try {
	    			setMethod.invoke(obj, new Object[] {null});
	    			return;
	    		} catch (Exception e) {
	    			log.fatal(e.getMessage());
	    		} 
	        } 
	        return;
    	}
    	Object newValue = null;
    	if (typeItLike.equals(Integer.TYPE) || typeItLike.equals(Integer.class)) {
    		newValue = new Integer((String.valueOf(value)));
    	} else if (typeItLike.equals(Character.TYPE) || typeItLike.equals(Character.class)) {
    		newValue = new Character(((String)value).charAt(0));
    	} else if (typeItLike.equals(Byte.TYPE) || typeItLike.equals(Byte.class)) {
    		newValue = new Byte(((String)value).getBytes()[0]);
    	} else if (typeItLike.equals(Short.TYPE) || typeItLike.equals(Short.class)) {
    		newValue = new Short((String)value);
    	} else if (typeItLike.equals(Long.TYPE) || typeItLike.equals(Long.class)) {
    		newValue = new Long((String)value);
    	} else if (typeItLike.equals(Float.TYPE) || typeItLike.equals(Float.class)) {
    		newValue = new Float((String)value);
    	} else if (typeItLike.equals(Double.TYPE) || typeItLike.equals(Double.class)) {
    		newValue = new Double((String)value);
    	} else if (typeItLike.equals(Boolean.TYPE) || typeItLike.equals(Boolean.class)) {
    		newValue = new Boolean((String)value);
        } else if (typeItLike.equals(java.util.Calendar.class)) {
            newValue = UtilDate.getInstance().stringToDate (value.toString());
        } else if (typeItLike.equals(java.sql.Date.class)) {
            newValue = new java.sql.Date (UtilDate.getInstance().stringToDate (value.toString()).getTime());
        } else {
    		newValue = value;
    	}
		try {
			setMethod.invoke(obj, new Object[] {newValue});
		} catch (Exception e) {
			log.fatal(e.getMessage());
		} 
	}

    /**
	 * @param obj objet à explorer
	 * @param attrName attribut à explorer
	 * @return valeur de l'attribut
	 * @throws Exception
	 */
	public static Object getAttributeValue(Object obj, String attrName) throws Exception  {
        if (obj == null)
            return null;
        Method getMethod;
		Object value = null;
		try {
			getMethod = getMethod(obj.getClass(), getGetMethod(attrName));
			value = getMethod.invoke(obj, null);
		} catch (Exception e) {
			log.fatal(e.getMessage());
		}
        if (value == null)
            return null;
        Class typeItLike = value.getClass();
    	// traitement de la valeur pour la convertir en type typetLike
    	if (typeItLike.equals(Integer.TYPE) || typeItLike.equals(Integer.class)) {
    		return String.valueOf(value);
    	} else if (typeItLike.equals(Character.TYPE) || typeItLike.equals(Character.class)) {
    		return String.valueOf(value);
    	} else if (typeItLike.equals(Byte.TYPE) || typeItLike.equals(Byte.class)) {
    		return String.valueOf(value);
    	} else if (typeItLike.equals(Short.TYPE) || typeItLike.equals(Short.class)) {
    		return String.valueOf(value);
    	} else if (typeItLike.equals(Long.TYPE) || typeItLike.equals(Long.class)) {
    		return String.valueOf(value);
    	} else if (typeItLike.equals(Float.TYPE) || typeItLike.equals(Float.class)) {
    		return String.valueOf(value);
    	} else if (typeItLike.equals(Double.TYPE) || typeItLike.equals(Double.class)) {
    		return String.valueOf(value);
    	} else if (typeItLike.equals(Boolean.TYPE) || typeItLike.equals(Boolean.class)) {
    		return String.valueOf(value);
        } else if (typeItLike.equals(java.util.Date.class)) {
            return UtilDate.getInstance().dateToString((java.util.Date)value);
        } else if (typeItLike.equals(java.sql.Date.class)) {
            return UtilDate.getInstance().dateToString((java.sql.Date)value);
        }else if (typeItLike.equals(String.class)) {
            return value.toString();
        } else {
    		return value;
    	}
	}

	/**
	 * @param obj objet à explorer
	 * @param attrName attribut à explorer
	 * @return valeur de l'attribut
	 * @throws Exception
	 */
	public static Object getValue(Object obj, String attrName) throws Exception  {
		if (obj == null)
	       return null;
		try {
		    Method getMethod = getMethod(obj.getClass(), getGetMethod(attrName));
			return getMethod.invoke(obj, null);
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return null;
		}
	}

	/**
	 * @param clazz la classe d'appartenance
	 * @param methodName le nom de la méthode
	 * @return la méthode correspondante
	 * @throws Exception
	 */
	public static Method getMethod(Class clazz, String methodName) throws Exception {
	    
	    return getMethod(clazz,methodName,null);
	}

	/**
	 * @param clazz la classe d'appartenance
	 * @param methodName le nom de la méthode
	 * @param args lee types d'argument de la méthode
	 * @return la méthode correspondante
	 * @throws Exception
	 */
	public static Method getMethod(Class clazz, String methodName, Class[] args) throws Exception {
		try {
			return clazz.getMethod(methodName, args);
		} catch (NoSuchMethodException nsmex) {
			throw new Exception ("la methode ["+methodName+"] avec la signature suivante " + argumentTypesToString(args) + " n'existe pas dans la classe ["+clazz+"]");
		}
	}

	/**
	 * @param fieldName nom du champs
	 * @return le nom de la méthode
	 */
	public static String getGetMethod(String fieldName) {
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	/**
	 * @param fieldName nom du champs
	 * @return le nom de la méthode
	 */
	public static String getSetMethod(String fieldName) {
		return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

    /**
	 * @param fieldName nom du champs
	 * @param clazz la classe d'appartenance
	 * @return le type de l'aggregation en question
	 * @throws Exception
	 */
	public static Class getAgregateType (String fieldName, Class clazz) throws Exception {
        return getMethod(clazz,getGetMethod(fieldName), new Class [] {Integer.TYPE}).getReturnType();
    }
	
	/**
	 * @param obj
	 * @param nestedAttrName : nom de la propriété (parent.refChild...property)
	 * @return valeur de la propriété
	 * @throws Exception
	 */
	public static Object getNestedAttributeValue(Object obj, String nestedAttrName) throws Exception {
    	if(nestedAttrName.indexOf(OPERATEUR_NESTED) < 0)
    		return getAttributeValue(obj, nestedAttrName);
    	StringTokenizer strTks = new StringTokenizer(nestedAttrName, OPERATEUR_NESTED);
    	Object tmpObj = obj;
    	while(strTks.hasMoreTokens() && tmpObj != null){
			String attrName = strTks.nextToken();
			tmpObj = getAttributeValue(tmpObj, attrName);			
		}
		return tmpObj;
    }
	
	public static Object setNestedAttributeValue(Object obj, String nestedAttrName) throws Exception {
    	if(nestedAttrName.indexOf(OPERATEUR_NESTED) < 0)
    		return getAttributeValue(obj, nestedAttrName);
    	StringTokenizer strTks = new StringTokenizer(nestedAttrName,OPERATEUR_NESTED);
    	Object tmpObj = obj;
    	while(strTks.hasMoreTokens() && tmpObj != null){
			String attrName = strTks.nextToken();
			tmpObj = getAttributeValue(tmpObj, attrName);			
		}
		return tmpObj;
    }
	
	public static void setNestedAttributeValue(Object obj, String attrName, Object value)
			throws Exception {
		int indexOfDot = attrName.indexOf(OPERATEUR_NESTED);
		Class workingClass = obj.getClass();
		Object workingObjcet = obj;
		while (true) {
			if (indexOfDot < 0) {
				setAttributeValue(obj, attrName, value);
				return;
			} 
			String innerPropertyName = attrName.substring(0, indexOfDot);
			attrName = attrName.substring(indexOfDot + 1);
			indexOfDot = attrName.indexOf(OPERATEUR_NESTED);
			Method getMethod = ReflectUtils.getAttributeGetMethod(
					innerPropertyName, workingClass);
			workingClass = getMethod.getReturnType();
			Object tmpObject = getAttributeValue(workingObjcet, innerPropertyName);
			if(tmpObject == null) {
			    tmpObject = workingClass.newInstance();
			    setAttributeValue(workingObjcet, innerPropertyName, tmpObject);
			}
			workingObjcet = tmpObject;
		}
	}
	/**
	 * test si un attribut a les méthodes set et get
	 * @param fieldName
	 * @param clazz
	 * @return true / false
	 * @throws Exception
	 */
	public static boolean hasGetSetMethods(String fieldName, Class clazz) 
			throws Exception {
		String getMethodName = ReflectUtils.getAttributeGetMethodName(fieldName);
		String setMethodName = ReflectUtils.getAttributeSetMethodName(fieldName);
		return isMethodExist(getMethodName, clazz) && isMethodExist(setMethodName, clazz); 
	}
		
	/**
	 * test si la méthode existe dans la classe
	 * @param methodName
	 * @param clazz
	 * @return true / false
	 * @throws Exception
	 */
	public static boolean isMethodExist(String methodName, Class clazz) 
			throws Exception {
		Method[] methods = clazz.getMethods();
		for(int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if(methodName.equals(method.getName()))
				return true;
		}
		return false;
	}
	
	/**
	 * @param clazz
	 * @param packageIndex
	 * @return Vecteur de fields de clazz et ses classes mères.
	 * @throws Exception
	 */
	public static Vector getFields(Class clazz, String packageIndex) 
			throws Exception {
		Vector vectFields = new Vector();
		while (clazz.getName().indexOf(packageIndex) >= 0) {
			Field[] fields = clazz.getDeclaredFields();
			for(int i = 0; i < fields.length; i++) {
			    if(!fields[i].getName().equalsIgnoreCase(SERIAL_ID)){
			        vectFields.add(fields[i]);
			    }
			}
			clazz = clazz.getSuperclass();
		}
		return vectFields;
	}
	
	/**
	 * @param clazz
	 * @return Vecteur de fields de clazz et ses classes mères
	 * 			dans le package ma.gov.tax.sit.
	 * @throws Exception
	 */
	public static Vector getFields(Class clazz) 
			throws Exception {
		return getFields(clazz, SIT_PACKAGE);
	}
	/**
	 * @param argTypes
	 * @return String retourne les types de la signature d'une methode
	 * 			dans le package ma.gov.tax.sit.
	 */
	 private static String        argumentTypesToString(Class[] argTypes) {
	        StringBuffer buf = new StringBuffer();
	        buf.append("(");
	        if (argTypes != null) {
	            for (int i = 0; i < argTypes.length; i++) {
	                if (i > 0) {
	                    buf.append(OPERATEUR_CONCAT);
	                }
	                Class c = argTypes[i];
	                buf.append((c == null) ? "null" : c.getName());
	            }
	        }
	        buf.append(")");
	        return buf.toString();
	    }
}