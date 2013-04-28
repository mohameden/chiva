/**
 * 
 */
package clinique.dao;


/**
 *
 */
public final class QueryDao {

	// private static final QueryDao INSTANCE = new QueryDao();
	//
	// private static final Logger logger = Logger.getLogger(QueryDao.class);
	//
	// private final QueryBuilderImpl queryBuilder = new QueryBuilderImpl();
	//
	// private static final String ESPACE = " ";
	// private static final String VALEUR_SEPARATOR_NESTED = ".";
	//
	// public QueryDao() {
	// try {
	// queryBuilder.setClassLoader(getClass().getClassLoader());
	// Collection<String> repositories = new ArrayList<String>(1);
	// repositories.add("query_filtre_patient.xml");
	// repositories.add("query_filtre_gestion_stock.xml");
	// queryBuilder.setRepositories(repositories);
	// queryBuilder.buildQueries();
	// } catch (QueryBuilderException e) {
	// throw new RuntimeException(e);
	// }
	// }
	//
	// /**
	// * @return the instance
	// */
	// public static QueryDao getInstance() {
	// return INSTANCE;
	// }
	//
	// public Collection <?> findResultQueryByNamedParams(String queryName,
	// final Map<String, Object> params) throws Exception {
	// try {
	// final Query query = queryBuilder.getQuerie(queryName);
	// Map mapParamsToBind = null;
	// String queryString = null;
	// if(params == null){
	// queryString = query.getQueryBodies().iterator().next().getBody();
	// } else {
	// trimParams(params);
	// mapParamsToBind = new HashMap();
	// StringBuilder builder = new StringBuilder();
	// QueryBody queryBody = null;
	// for (Iterator<QueryBody> iterator = query.getQueryBodies().iterator();
	// iterator.hasNext();) {
	// queryBody = iterator.next();
	// if( queryBody.getParam() == null){
	// builder.append(ESPACE+queryBody.getBody());
	// } else {
	// if (params.get(queryBody.getParam()) != null) {
	// if (queryBody.getBody().indexOf(queryBody.getParam())>=0){
	// mapParamsToBind.put(queryBody.getParam(),
	// params.get(queryBody.getParam()));
	// }
	// builder.append(ESPACE+queryBody.getBody());
	// }
	// }
	// }
	// queryString = builder.toString();
	// }
	// Session session = SessionFactoryUtil.getInstance().getCurrentSession();
	//
	// logger.debug(queryString);
	//
	// org.hibernate.Query q = session.createSQLQuery(queryString);
	//
	// for (Iterator<Entry<String, Object>> itr =
	// mapParamsToBind.entrySet().iterator(); itr.hasNext(); ){
	// Entry<String, Object> entry = itr.next();
	//
	// q.setParameter(entry.getKey(), entry.getValue());
	// }
	//
	// logger.debug(mapParamsToBind.toString());
	//
	// return buildResult(q.list(),query);
	// } catch (Exception e) {
	// throw e;
	// }
	// }
	//
	//
	// private Collection <Object> buildResult(Collection<Object[]>
	// results,Query query)throws Exception{
	// if(results == null || results.isEmpty()) return null;
	// Object[] object = null;
	// Collection<Object> resultatsConvert = new
	// ArrayList<Object>(results.size());
	//
	// QueryMapping[] mappings = query.getQueryMappings().toArray(new
	// QueryMapping[]{});
	// for (Iterator <Object[]> iterator = results.iterator();
	// iterator.hasNext();) {
	// object = iterator.next();
	// Object resulat = query.getResultClass().newInstance();
	// for (int j = 0; j < object.length; j++) {
	// ReflectUtils.setAttributeValue(resulat, mappings[j].getProperty(),
	// object[j]);
	// }
	// resultatsConvert.add(resulat);
	// }
	// return resultatsConvert;
	// }
	//
	// private Object getNestedAttributeValue(Object obj, String nestedAttrName)
	// throws Exception {
	// if(nestedAttrName.indexOf(VALEUR_SEPARATOR_NESTED) < 0)
	// return ReflectUtils.getValue(obj, nestedAttrName);
	// StringTokenizer strTks = new StringTokenizer(nestedAttrName,
	// VALEUR_SEPARATOR_NESTED);
	// Object tmpObj = obj;
	// while(strTks.hasMoreTokens() && tmpObj != null){
	// String attrName = strTks.nextToken();
	// tmpObj = ReflectUtils.getValue(tmpObj, attrName);
	// }
	// return tmpObj;
	// }
	//
	// private void trimParams(Map params) throws Exception {
	// if(params == null) return;
	// for (Iterator<Entry<String, Object>> itr = params.entrySet().iterator();
	// itr.hasNext(); ){
	// Entry<String, Object> entry = itr.next();
	// if(entry.getValue() == null ||
	// entry.getValue().toString().trim().length() == 0){
	// itr.remove();
	// }
	// }
	// }
	//
	//

}
