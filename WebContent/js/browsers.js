/*
    browser_js_CMM_TAG = " @(#) %browser.js% %release: %"
    "%version: 3 % %date_created: Mon Jun 23 16:31:44 DFT 2008 % "
    "%created_by: poiret % "
    "Instance: facil_1 "
    "Copyright SAGEM, SAGEM Proprietary Information, SAGEM Confidential" ;
*/

////////////////////////////////////////////////////////////////////////////
// Browser related javascript functions
////////////////////////////////////////////////////////////////////////////
function isInternetExplorer()
{
    if (window.ActiveXObject) return true;
    return false;
}

function isActiveXSupported()
{
    if (isInternetExplorer()) return true;
    return false;
}


// Hide toolbar
function hideToolbar(){
    if (isInternetExplorer()) { // If Internet Explorer try to hide toolbar
        var prefix = "mainfacilwindow_";
        var now = new Date();
        var uniqid = now.getTime();
        // If the window is already named with the given prefix
        // then hopefully it was opened with this call to hideToolbar
        // and should already contain no toolbar
        if (window.name.substr(0, prefix.length) != prefix ){
            var response = window.open(window.top.location.href,prefix+uniqid,"scrollbars=yes,resizable=yes");
            response.moveTo(0,0);
            response.resizeTo(screen.width,(screen.height-25));

            var obj_window = window.open('', '_self'); // Trick so that we can close the window without asking the user
            obj_window.opener = window;
            obj_window.focus();
            opener=self;

            if (response != null) {
                response = self.close();
            }
        }
    } // Else give up... no way
}


// hide contextmenu
var message="";
function clickIE()
{
    if (document.all)
    {
        (message);
        return false;
    }
}//end function clickIE

//The event object created with every mouse button action has a property that reveals which
//mouse button the user pressed. NN4’s event model calls that property the which property.
function clickNS(e)
{
    if (document.layers || (document.getElementById && !document.all))
    {
        if (e.which == 2 || e.which == 3)
        {
            (message);
            return false;
        }
    }
}//end function clickNS

//The document.layers property is an array of positioned elements in the document.
//But due to the nonstandard way that NN4 implements positioned elements,
//not every positioned element is represented in the document.layers array.


if (document.layers)
	{
	document.captureEvents(Event.MOUSEDOWN);
	document.onmousedown = clickNS;
	}
else
	{
	document.onmouseup = clickNS;
	// desable contextmenu for webApp without layer
	document.oncontextmenu = clickIE;
	}