function chargerEntreprises(var1)
{
 var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerEntreprises&id_assureur="+var1.value;
 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].id_entreprise);
 chargerCategories(document.forms[0].id_entreprise);
}
function chargerCategories(var1)
{
 var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerCategories&id_entreprise="+var1.value;
 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].id_categorie);
}
function chargerClasses(var1)
{
 var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerClasses&id_famille_prestation="+var1.value;
 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].id_classe);
 chargerActes(document.forms[0].id_classe);
}
function chargerActes(var1)
{
 var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerActesid_classe="+var1.value;
 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].id_acte);
 chargerActeurs(document.forms[0].id_acte);
}
function chargerActeurs(var1)
{
 var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerActeurs&id_acte="+var1.value;
 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].id_acteur);
}