
function afterOrEqual(var1,var2)
		{
		  var1=renverseStrDate(var1);
		  var2=renverseStrDate(var2);
		  if (var1 >= var2)
		  {
		    return true;
		  }
		  else return false;
		}

function renverseStrDate(sIn) { //1ere procedure renverse date
	var sOut = "";

	sOut = sIn.charAt(6) + sIn.charAt(7) + sIn.charAt(8)+ sIn.charAt(9) + "/" + sIn.charAt(3)+ sIn.charAt(4) + "/" + sIn.charAt(0)+ sIn.charAt(1);

	return(sOut);
	}



function Patient()
{
	 this.patientId;
	 this.nom;
	 this.prenom;
	 this.dateNaissance;
	 this.lieuNaissance;
	 this.telephone;
	 this.adresse;
	 this.cni;
	 this.nni;
	 this.numeroBadge;
	 this.datePremiereVisite;
	 this.dateDerniereVisite;

	 this.loadPatient=function(objXML){
		 var noeudUnites = objXML.selectNodes ("/patients/patient");
		 var noeudErreur = objXML.selectNodes("/errors/error");
		 /*if(noeudErreur.length>0)
		 {
			 alert(noeudErreur[0].selectSingleNode('msg').text);
			 return null;
		 }*/
		 if(noeudUnites.length==0)
		 {
			 alert('Le numero du patient est incorrect ');
			 return null;
		 }
		 else
		 {
			 this.exist="true";
			 if (noeudUnites[0].selectSingleNode("patientId").text.replace(/[\n]/gi, "" )=="null")  {this.patientId=""; }
			 else {
				 this.patientId=noeudUnites[0].selectSingleNode("patientId").text;
				 }

			 if (noeudUnites[0].selectSingleNode("nom").text.replace(/[\n]/gi, "" )=="null")  {this.nom=""; }
			 else {this.nom=noeudUnites[0].selectSingleNode("nom").text;}

			 if (noeudUnites[0].selectSingleNode("prenom").text.replace(/[\n]/gi, "" )=="null")  {this.prenom=""; }
			 else {this.prenom=noeudUnites[0].selectSingleNode("prenom").text;}
			 
			 if (noeudUnites[0].selectSingleNode("dateNaissance").text.replace(/[\n]/gi, "" )=="null")  {this.dateNaissance=""; }
			 else {this.dateNaissance=noeudUnites[0].selectSingleNode("dateNaissance").text;}
			 
			 if (noeudUnites[0].selectSingleNode("lieuNaissance").text.replace(/[\n]/gi, "" )=="null")  {this.lieuNaissance=""; }
			 else {this.lieuNaissance=noeudUnites[0].selectSingleNode("lieuNaissance").text;}
			 
			 if (noeudUnites[0].selectSingleNode("telephone").text.replace(/[\n]/gi, "" )=="null")  {this.telephone=""; }
			 else {this.telephone=noeudUnites[0].selectSingleNode("telephone").text;}

			 if (noeudUnites[0].selectSingleNode("adresse").text.replace(/[\n]/gi, "" )=="null")  {this.adresse=""; }
			 else {this.adresse=noeudUnites[0].selectSingleNode("adresse").text;}
			 
			 if (noeudUnites[0].selectSingleNode("cni").text.replace(/[\n]/gi, "" )=="null")  {this.cni=""; }
			 else {this.cni=noeudUnites[0].selectSingleNode("cni").text;}

			 if (noeudUnites[0].selectSingleNode("nni").text.replace(/[\n]/gi, "" )=="null")  {this.nni=""; }
			 else {this.nni=noeudUnites[0].selectSingleNode("nni").text;}
			 
			 if (noeudUnites[0].selectSingleNode("numeroBadge").text.replace(/[\n]/gi, "" )=="null")  {this.numeroBadge=""; }
			 else {this.numeroBadge=noeudUnites[0].selectSingleNode("numeroBadge").text;}
			 
			 if (noeudUnites[0].selectSingleNode("datePremiereVisite").text.replace(/[\n]/gi, "" )=="null")  {this.datePremiereVisite=""; }
			 else {this.datePremiereVisite=noeudUnites[0].selectSingleNode("datePremiereVisite").text;}
			 
			 if (noeudUnites[0].selectSingleNode("dateDerniereVisite").text.replace(/[\n]/gi, "" )=="null")  {this.dateDerniereVisite=""; }
			 else {this.dateDerniereVisite=noeudUnites[0].selectSingleNode("dateDerniereVisite").text;}
			 
			 

		 }
	 

	 };
}




function age(d)
{

	var elem = d.split('/');
	jour = elem[0];
	mois= elem[1];
	annee = elem[2];

	actu=new Date();
	if((actu.getMonth()+1)>=mois)
	{
	if((actu.getMonth()+1)==mois)
	{
	if(actu.getDate()>=jour)
	{
	m=(actu.getMonth()+1)-mois;
	an=actu.getFullYear()-annee;
	}
	else
	{
	m=(12-mois)+(actu.getMonth()+1);
	an=actu.getFullYear()-annee-1;
	}
	}
	else
	{
	m=(actu.getMonth()+1)-mois;
	an=actu.getFullYear()-annee;
	}
	}
	else
	{
	m=(12-mois)+(actu.getMonth()+1);
	an=actu.getFullYear()-annee-1;
	}
	if(actu.getDate()>jour)
	{
	j=actu.getDate()-jour;
	}
	else
	{
	j=(30-jour)+(actu.getDate());
	}
	while(j>30)
	{
	j-=30;
	m+=1;
	}
	while(m>12)
	{
	m-=12;
	an+=1;
	}

	return an+1;
}
function age(date_naissance,date_ref)
{
	var elem = date_naissance.split('/');
	jour = elem[0];
	mois = elem[1];
	annee = elem[2];

	actu = new Date(date_ref);
	if((actu.getMonth()+1)>=mois)
	{
	if((actu.getMonth()+1)==mois)
	{
	if(actu.getDate()>=jour)
	{
	m=(actu.getMonth()+1)-mois;
	an=actu.getFullYear()-annee;
	}
	else
	{
	m=(12-mois)+(actu.getMonth()+1);
	an=actu.getFullYear()-annee-1;
	}
	}
	else
	{
	m=(actu.getMonth()+1)-mois;
	an=actu.getFullYear()-annee;
	}
	}
	else
	{
	m=(12-mois)+(actu.getMonth()+1);
	an=actu.getFullYear()-annee-1;
	}
	if(actu.getDate()>jour)
	{
	j=actu.getDate()-jour;
	}
	else
	{
	j=(30-jour)+(actu.getDate());
	}
	while(j>30)
	{
	j-=30;
	m+=1;
	}
	while(m>12)
	{
	m-=12;
	an+=1;
	}

	return an+1;
}
function verifierDate(date)
{
	if((date.length<10) || (date.length>10))
	{
		return false;
	}
	if(date.substring(2,3)!="/" || date.substring(5,6)!="/")
	{
	  return false;
	}
	jour=date.substring(0,2);
	mois=date.substring(3,5);
	annee=date.substring(6,10);
	if(((annee % 4 != 0) || (annee % 100 == 0)) && (annee % 400 != 0))
	{
		if(mois=="02")
		{
		       if(jour>"28")
		         {
			        return false;
		         }
		}
	}
	else
	{
		if(mois=="02")
		{
			if(jour>"29")
		      {
			   return false;
		      }
		}
	}
	if(mois=="00")
	{
		return false;
	}
	if(mois>"12")
	{
		return false;
	}
	if(jour=="00")
	{
		return false;
	}
	if(jour>"31")
	{
		return false;
	}
}
function compterNbrOccurence(str,lettre)
{
	j=0;
	for(i=0;i<str.length;i++)
	{
		if(str.charAt(i)==lettre)
		{
			j++;
		}
	}
	return j;
}
function clic(e)
{
  var message = "Click Droit Interdit";

  if(!document.rightClickDisabled) // initialize
  {
    if(document.layers)
    {
      document.captureEvents(Event.MOUSEDOWN);
      document.onmousedown = clic;
    }
    else document.oncontextmenu = clic;
    return document.rightClickDisabled = true;
  }
  if(document.layers || (document.getElementById && !document.all))
  {
    if (e.which==2||e.which==3)
    {
     // alert(message);
      return false;
    }
  }
  else
  {
    //alert(message);
    return false;
  }
}


function basculerClavierFrancais()
{
   var wshshell=new ActiveXObject("wscript.shell");
	//var WshShell = new ActiveXObject("WScript.Shell");
	wshshell.sendKeys("^+2");
}
function basculerClavierArabe()
{
    var wshshell=new ActiveXObject("wscript.shell");
	//var WshShell = new ActiveXObject("WScript.Shell");
	wshshell.sendKeys("^+1");

}

function interdireColler()
{
  if(event.ctrlKey) event.returnValue = false;
}

   function clavierArabe()
{
  if ((event.keyCode>=1569 && event.keyCode<=1610) || event.keyCode==32) event.returnValue = true;
  else event.returnValue = false;
   }

function clavierFrancais()
{

  if ((event.keyCode>=65 && event.keyCode<=122 && event.keyCode!=95 && event.keyCode != 91 && event.keyCode != 92 && event.keyCode != 93)
  || (event.keyCode>=192 && event.keyCode<=255)
  || event.keyCode==45 || event.keyCode==8 || event.keyCode==32 || event.keyCode==39 )
   event.returnValue = true;

  else event.returnValue = false;
   }



function checkDate(obj)
        {
	        if(obj.value.length==0)
	        {
                  Numerique();
	        	 if((event.keyCode < 48)||(event.keyCode > 51)) event.returnValue = false;
	          	 if((event.which < 48) ||(event.which >51) )  return false;
	        }
	        if(obj.value.length==1)
	        {
			Numerique();
                 if(obj.value.substring(0,1)=="3")
                 {
    	        	 if((event.keyCode < 48)||(event.keyCode > 49)) event.returnValue = false;
    	          	 if((event.which < 48) ||(event.which >49) )  return false;
                 }
                 else if(obj.value.substring(0,1)=="0")
                 {
                	 if((event.keyCode < 49)||(event.keyCode > 57)) event.returnValue = false;
    	          	 if((event.which < 49) ||(event.which >57) )  return false;
                 }
                 else
                 {
	        	 if((event.keyCode < 48)||(event.keyCode > 57)) event.returnValue = false;
	          	 if((event.which < 48) ||(event.which >57) )  return false;
                 }
	        }
	        if(obj.value.length==2)
	        {
	        	obj.value=obj.value+"/";
	        }
	        if(obj.value.length==3)
	        {
			Numerique();
	        	 if((event.keyCode < 48)||(event.keyCode > 49)) event.returnValue = false;
	          	 if((event.which < 48) ||(event.which >49) )  return false;
	        }
	        if(obj.value.length==4)
	        {
			     Numerique();
                if(obj.value.substring(0,1)=="3" && obj.value.substring(1,2)=="1")
                {
        	        if(obj.value.substring(3,4)=="1")
        	        {
            	        if((event.keyCode < 48)||(event.keyCode ==49)||(event.keyCode > 50)) event.returnValue = false;
       	          	    if((event.which < 48) ||(event.which ==49)||(event.which >50) )  return false;
        	        }
        	        else
        	        {
        	        	if((event.keyCode < 49)||(event.keyCode == 50) || (event.keyCode == 52)||(event.keyCode == 54)||(event.keyCode > 56)) event.returnValue = false;
       	          	    if((event.which < 49) ||(event.which ==50)|| (event.which == 52) ||(event.which ==54)||(event.which > 56))  return false;
        	        }

                }
                else if(obj.value.substring(0,1)=="3" && obj.value.substring(1,2)=="0")
                {
                	 if(obj.value.substring(3,4)=="1")
         	        {
             	        if((event.keyCode < 48) || (event.keyCode > 50)) event.returnValue = false;
        	          	    if((event.which < 48) ||(event.which > 50))  return false;
         	        }
         	        else
         	        {
         	        	if((event.keyCode < 49)||(event.keyCode == 50) ||(event.keyCode > 57)) event.returnValue = false;
        	          	    if((event.which < 49) ||(event.which ==50)||(event.which > 57))  return false;
         	        }
                }
                else
                {
               	 if(obj.value.substring(3,4)>"0")
               	 {
   	        	 if((event.keyCode < 48)||(event.keyCode > 50)) event.returnValue = false;
   	          	 if((event.which < 48) ||(event.which >50) )  return false;
               	 }
               	 else
               	 {
       	        	 if((event.keyCode < 49)||(event.keyCode > 57)) event.returnValue = false;
       	          	 if((event.which < 49) ||(event.which >57) )  return false;
               	 }
                }
	        }
	        if(obj.value.length==5)
	        {
	        	obj.value=obj.value+"/";
	        	//if((event.keyCode < 47)||(event.keyCode > 47)) event.returnValue = false;
	          	//if((event.which < 47) ||(event.which > 47) )  return false;
	        }
	        if(obj.value.length==6)
	        {
                  Numerique();
  	        	 if((event.keyCode < 48)||(event.keyCode > 57)) event.returnValue = false;
  	          	 if((event.which < 48) ||(event.which >57) )  return false;
	        }
	        if(obj.value.length==7)
	        {
			Numerique();

  	        	 if((event.keyCode < 48)||(event.keyCode > 57)) event.returnValue = false;
  	          	 if((event.which < 48) ||(event.which >57) )  return false;
	        }
	        if(obj.value.length==8)
	        {
			Numerique();
     	        	 if((event.keyCode < 48)||(event.keyCode > 57)) event.returnValue = false;
     	          	 if((event.which < 48) ||(event.which >57) )  return false;

	        }
	        if(obj.value.length==9)
	        {
			Numerique();
                if(obj.value.substring(0,1)=="2" && obj.value.substring(1,2)=="9" && obj.value.substring(3,4)=="0"&& obj.value.substring(4,5)=="2")
                {
                	if(obj.value.substring(8,9)=="0" || obj.value.substring(8,9)=="2" ||obj.value.substring(8,9)=="4"||obj.value.substring(8,9)=="6" ||obj.value.substring(8,9)=="8")
                	{

        	        	 if((event.keyCode < 48)||(event.keyCode == 49)||(event.keyCode == 50)||(event.keyCode == 51)||(event.keyCode == 53)||(event.keyCode == 54)||(event.keyCode == 55)||(event.keyCode > 56)) event.returnValue = false;
        	          	 if((event.which < 48) ||(event.which ==49) ||(event.which ==50) ||(event.which ==51) ||(event.which ==53) ||(event.which ==54) ||(event.which ==55) ||(event.which >56))  return false;
                	}
                	if(obj.value.substring(8,9)=="1" || obj.value.substring(8,9)=="3" ||obj.value.substring(8,9)=="5"||obj.value.substring(8,9)=="7" ||obj.value.substring(8,9)=="9")
                	{

        	        	 if((event.keyCode < 50)||(event.keyCode == 51)||(event.keyCode == 52)||(event.keyCode == 53)||(event.keyCode > 54)) event.returnValue = false;
        	          	 if((event.which < 50) ||(event.which >54))  return false;

                	}

                }
                else
                {
    	        	 if((event.keyCode < 48)||(event.keyCode > 57)) event.returnValue = false;
    	          	 if((event.which < 48) ||(event.which >57) )  return false;
                }
	        }

	      }
        function Numerique()
		{
		             if((event.keyCode < 48)||(event.keyCode > 57)) event.returnValue = false;
    	          	 //if((event.which < 48) ||(event.which >57) )  return false;
		}
function validerFormParAction(action,methodeName, confirmationText) {
	this.disabled = true;
	if(window.opener==null){
		if (confirmationText  != null ){
		   if ( confirm(confirmationText) ){
				document.forms[0].action = action;
				document.forms[0].dispatch.value = methodeName;
				document.forms[0].submit();
		   }
		}else {
		document.forms[0].action = action;
		document.forms[0].dispatch.value = methodeName;
		document.forms[0].submit();
	  }
  }
}

function openPoPup(url) {
	var acte_id =  document.forms[0].acte_id.value;
	window.open(url+"&acteId="+acte_id, null, 'height=650,width=980,status=yes,scrollbars=yes,resizable=yes,toolbar=no');
}
function openPoPupMention(url) {
	var mention_id =  document.forms[0].mention_id.value;
	window.open(url+"&acteId="+mention_id, null, 'height=650,width=980,status=yes,scrollbars=yes,resizable=yes,toolbar=no');
}


function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

//-->
function CheckSousCompte(){
	if(document.Frm.SousCompte.checked){
		document.Frm.LstSousCompte.disabled=false;
	}
	else{
		document.Frm.LstSousCompte.disabled=true;
	}
}

function Transfert(){
	if(document.Frm.CheckTransfert.checked){
		document.getElementById("Transfert").className = 'OuvrirLeNoue';
	}
	else{
		document.getElementById("Transfert").className = 'FermerLeNoue';
	}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
    function afficherInfoBullOption (obj)
	{
	//	document.write('<div style="position:absolute;display:none" id="bulleOption"></div>');
		var balOption=false;
		var bulleOption=document.getElementById('bulle');
        ns= (navigator.appName.search("Nestcape")!=-1) ? window.pageXOffset : 0;
        ns2= (navigator.appName.search("Nestcape")!=-1) ? window.pageYOffset : 0;
        posx= (!e) ? event.clientX+document.documentElement.scrollLeft : e.pageX+ns;
        posy= (!e) ? event.clientY+document.documentElement.scrollTop : e.pageY+ns2;
        hori=(posx > (screen.availWidth - 200)) ? -250 : 0;
        bulleOption.style.left= posx+hori+"px";
        bulleOption.style.top= posy+"px";
        bulleOption.style.display='block';
        //gestion du type d'élément
        balOption=document.createElement('div');
        balOption.style.fontWeight=100;
        balOption.style.backgroundColor="#FFFFDD";
        bal2=document.createTextNode(obj.text);

        bal.appendChild(bal2);
        bulleOption.appendChild(bal);
	}



var contextPath;
//XMLResponse.

function getXMLResponse (urlXML)
{
	if (urlXML == null)
	{
		return null;
	}
	if (window.XMLHttpRequest){
	          // If IE7, Mozilla, Safari, etc: Use native object
	     var xmlHttp = new XMLHttpRequest();
	}
	else
	{
	if (window.ActiveXObject){
	          // ...otherwise, use the ActiveX control for IE5.x and IE6
	      var xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	}
	xmlHttp.open("GET", urlXML+"&counter="+Math.random(), false);
	xmlHttp.send(null);
	/*var reponseText;
	xmlHttp.onreadystatechange = function() {
              if(xmlHttp.readyState == 4)
              reponseText = xmlHttp.responseText;
              }*/

	var objXmlDom = new ActiveXObject ("Microsoft.XMLDOM");
	objXmlDom = xmlHttp.responseXML;

	return objXmlDom;
}

//Ajax




function EcrireListEntity (objXml, objSelect)
{
	if (objXml == null)
	{
		return;
	}
	if (objSelect == null)
	{
		return;
	}
	var noeudUnites = objXml.selectNodes ("/entities/entity");
	var noeudErreurs = objXml.selectNodes ("/errors/error");

	if (noeudErreurs.length > 0)
	{
	//	alert (noeudErreurs[0].selectSingleNode ("msg").text);
	}

	objSelect.options.length = 0;

	//alert("Nombre de noeuds:" +noeudUnites.length);
	for (i = 0; i < noeudUnites.length; i++)
	{
		c = new Option (noeudUnites[i].selectSingleNode ("libelle").text, noeudUnites[i].selectSingleNode ("code").text, false, false);
		objSelect.options[i] = c;
	}

}

function ConstruireTableauFromListEntity (objXml)
{
	
	var result="";
	if (objXml == null)
	{
		result=result+ "<table> <tr align=\"center\" style=\"background:\#FF6600; font-size:14;"
		+ "font-weight:bold; color: #00253E;  \">";
		result = result + "<td> Aucun element a afficher</td>";
		result=result+ "</tr></table>";
		return "result ";
	}
	
	var noeudUnites = objXml.selectNodes ("/entities/entity");
	var noeudErreurs = objXml.selectNodes ("/errors/error");

	if (noeudErreurs.length > 0)
	{
	//	alert (noeudErreurs[0].selectSingleNode ("msg").text);
	}

	

	 result="<table border=\"1\" bordercolor=\"\#FFFFFF\"  width=\"100%\" align=\"center\" style=\"background:\#00253E; font-size:14;"
					+ "font-weight:bold; color: white;  \">";
	
		result=result+ "<tr align=\"center\" style=\"background:\#FF6600; font-size:14;"
					+ "font-weight:bold; color: #00253E;  \">";
		result = result + "<td> Acte </td>";
		result = result + "<td> Nombre </td>";
		result = result + "<td> Prix </td>";
		result = result + "<td> Total </td>";
		result=result+ "</tr>";
		
	//alert("Nombre de noeuds:" +noeudUnites.length);
	for (i = 0; i < noeudUnites.length; i++)
	{
		        result=result+ "<tr align=\"center\">";
				result = result + "<td>" + noeudUnites[i].selectSingleNode ("nom").text+"</td>";
				result = result + "<td>" + noeudUnites[i].selectSingleNode ("nombre").text+"</td>";
				result = result + "<td>" + noeudUnites[i].selectSingleNode ("prix").text+"</td>";
				result = result + "<td>" + noeudUnites[i].selectSingleNode ("total").text+"</td>";
				result=result+ "</tr>";
				
	}
	
	return result+"</table>";

}


function getInfoFromAjaxRequest (objXml)
{
	if (objXml == null)
	{
		return "";
	}
	var noeudUnites = objXml.selectNodes ("/info");
	var noeudErreurs = objXml.selectNodes ("/errors/error");

	if (noeudErreurs.length > 0)
	{
		alert (noeudErreurs[0].selectSingleNode ("msg").text);
	}

	var info = "";
	if (noeudUnites.length > 0)
	{
		info = noeudUnites[0].selectSingleNode ("libelle").text;
	}
	return info;
}

function getNombrePatients (objXml)
{
	
	if (objXml == null)
	{
		return 0;
	}
	var noeudUnites = objXml.selectNodes ("/entities/entity");
	//var noeudErreurs = objXml.selectNodes ("/errors/error");
	/*if (noeudErreurs.length > 0)
	{
		alert('babs');
		//alert (noeudErreurs[0].selectSingleNode ("msg").text);
		return 0;
	}*/
	
		return noeudUnites[0].selectSingleNode ("nbre").text;

	
}



function getInfoArrayFromAjaxRequest (objXml)
{
	if (objXml == null)
	{
		return;
	}
	var noeudUnites = objXml.selectNodes ("/info/libelle");
	var noeudErreurs = objXml.selectNodes ("/errors/error");
	if (noeudErreurs.length > 0)
	{
		alert (noeudErreurs[0].selectSingleNode ("msg").text);
	}
	var info = new Array();
	for (i = 0; i < noeudUnites.length; i++)
	{
		info[i] = noeudUnites[i].text;

	}

	return info;
}

function remplirHtmlSelectFromAjaxRequest (urlXml, objSelect)
{
	var xmlHttp = getXMLResponse (urlXml);
	EcrireListEntity (xmlHttp, objSelect);
}



//Post

function getXMLResponsePOST(url) {

	
	var index = url.lastIndexOf('?');
    alert(index);
	var parameters = null;
	if (index > 0)
	{
		parameters = url.substring(index + 1);
		url = url.substring(0, index);
	}

	http_request = false;
   if (window.XMLHttpRequest) { // Mozilla, Safari,...
	http_request = new XMLHttpRequest();
	if (http_request.overrideMimeType) {         // set type accordingly to anticipated content type
	//http_request.overrideMimeType('text/xml');
		http_request.overrideMimeType('text/html');
	}
   }
   else if (window.ActiveXObject) { // IE
	 try {
		 http_request = new ActiveXObject("Msxml2.XMLHTTP");
	 }
	 catch (e) {
		 try {
			 http_request = new ActiveXObject("Microsoft.XMLHTTP");
		 } catch (e) {}
	 }
 }
 if (!http_request) {
	 alert('Cannot create XMLHTTP instance');
	 return false;
 }
//				 http_request.onreadystatechange = null;
 http_request.open('POST', url, false);
 http_request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
 http_request.setRequestHeader("Content-length", parameters.length);
 http_request.setRequestHeader("Connection", "close");
 http_request.send(parameters);

 var objXmlDom = new ActiveXObject ("Microsoft.XMLDOM");
 objXmlDom = http_request.responseXML;
 return objXmlDom;
}


function remplirHtmlSelectFromAjaxRequestPOST (urlXml, objSelect)
{
	var xmlHttp = getXMLResponsePOST (urlXml);
	EcrireListEntity (xmlHttp, objSelect);
}

function recupererInfoFromAjaxRequest (urlXml)
{
	var xmlHttp = getXMLResponse (urlXml);
	var info = getInfoFromAjaxRequest (xmlHttp);
	return info;
}

function recupererInfoArrayFromAjaxRequest (urlXml)
{
	var xmlHttp = getXMLResponse (urlXml);
	var info = getInfoArrayFromAjaxRequest (xmlHttp);
	return info;
}

function elminerEspace(element) {
	var a=element.value;
	var b='';
	for(i=0; i < a.length; i++) {
		var c= a.substring(i,i+1);
		if (c != ' ') {
			b = b+c;
		}
	}
	element.value = b;
}
function IsNumeric(sText)
{
   var ValidChars = "0123456789";
   var IsNumber=true;
   var Char;


   for (i = 0; i < sText.length && IsNumber == true; i++)
      {
      Char = sText.charAt(i);
      if (ValidChars.indexOf(Char) == -1)
         {
         IsNumber = false;
         }
      }
   return IsNumber;

   }
function IsDecimal(sText)
{
   var ValidChars = "0123456789.";
   var IsNumber=true;
   var Char;


   for (i = 0; i < sText.length && IsNumber == true; i++)
      {
      Char = sText.charAt(i);
      if (ValidChars.indexOf(Char) == -1)
         {
         IsNumber = false;
         }
      }
   return IsNumber;

   }

   function estChampMontant (objTxt)
   {
	   	elminerEspace(objTxt);
		return IsDecimal(objTxt.value);
   }
function afficherMessageErreur (msg)
{
	alert (msg);
}

function estDate1ApresDate2 (strDate1, strDate2) // format des date dd/mm/yyyy
{
	var annee1 = strDate1.substring(6);
	var mois1 = strDate1.substring(3,5);
	var jour1 = strDate1.substring(0,2);

	var annee2 = strDate2.substring(6);
	var mois2 = strDate2.substring(3,5);
	var jour2 = strDate2.substring(0,2);

	if (annee1 > annee2)
	{
			return true;
	}
	else if ((annee1 == annee2) && (mois1 > mois2))
	{
			return true;
	}
	else if ((annee1 == annee2) && (mois1 == mois2) && (jour1 >= jour2))
	{
			return true;
	}
	else
	{
			return false;
	}
}
function afficherDiv (idDiv)
{
	objDiv = document.getElementById (idDiv);
	objDiv.style.display = 'block';
}
function cacherDiv (idDiv)
{
	objDiv = document.getElementById (idDiv);
	objDiv.style.display = 'none';
}
function Reponse()
{
	 this.reponse;
	 this.loadReponse=function(objXML){
		 var noeudUnites = objXML.selectNodes("/reponses/reponse");
		 var noeudErreur = objXML.selectNodes("/errors/error");
		 if(noeudUnites.length==0)
		 {
			 alert('Erreur ');
			 return null;
		 }
		 else
		 {
			 this.reponse=noeudUnites[0].selectSingleNode('text').text;
		 }
	 };
	 
}

function Produit()
{
	 this.exist="false";
	 this.produit_id;
	 this.nom_produit;
	 this.nom_classe;
	 this.prix;
	 this.quantite_disponible;
	 this.seuil_minimum;
	 
	 this.loadProduit=function(objXML)
	 {
		 var noeudUnites = objXML.selectNodes("/produits/produit");
		 var noeudErreur = objXML.selectNodes("/errors/error");

         if(noeudUnites.length!=0)
		 {
			 this.exist="true";
			 if (noeudUnites[0].selectSingleNode("produit_id").text.replace(/[\n]/gi, "" )=="null")  {
				 this.produit_id=""; }
			 else {this.nni=noeudUnites[0].selectSingleNode("produit_id").text;}


				 if (noeudUnites[0].selectSingleNode("nom_produit").text.replace(/[\n]/gi, "" )=="null")

					 {this.nom_produit="";}
				 else {this.nom_produit=noeudUnites[0].selectSingleNode("nom_produit").text; }



				 if (noeudUnites[0].selectSingleNode("nom_classe").text.replace(/[\n]/gi, "" )=="null")  {
					 this.nom_classe="";
				 } else {
					 this.nom_classe=noeudUnites[0].selectSingleNode("nom_classe").text;
					 }


				 if (noeudUnites[0].selectSingleNode("prix").text.replace(/[\n]/gi, "" )=="null")  {
					 this.prix="";
				  }
				 else {
					 this.prix=noeudUnites[0].selectSingleNode("prix").text;
				 }

				 if (noeudUnites[0].selectSingleNode("quantite_disponible").text.replace(/[\n]/gi, "" )=="null")
				 {
					 this.quantite_disponible="";
					  }
				 else {
					 this.quantite_disponible=noeudUnites[0].selectSingleNode("quantite_disponible").text;
				 				 }

				 if (noeudUnites[0].selectSingleNode("seuil_minimum").text.replace(/[\n]/gi, "" )=="null")  {
					 this.seuil_minimum="";
				     }
				 else {

					 this.seuil_minimum=noeudUnites[0].selectSingleNode("seuil_minimum").text;
				    }
		 }
	 };
}







