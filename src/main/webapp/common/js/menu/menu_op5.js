//UDMv3.4.1.1b



// filter for undefined arrays 
for (f=0;f<mI.length;f++){
if(menuALIGN=="free"){mI[f][2]-=1;}
if(!sP[f]){sP[f]=new Array(mI[f][2],mI[f][3],mI[f][3],0,0);}
if(!cP[f]){cP[f]=new Array;}
if(!sI[f]){sI[f]=new Array;}
if(!cI[f]){cI[f]=new Array;}
for (sf=0;sf<sI[f].length;sf++){
if(!cP[f][sf]){cP[f][sf]=new Array;}
if(!cI[f][sf]){cI[f][sf]=new Array;}
}
}


// appreviations
var bh=baseHREF;
var ttt='<table border=0 cellpadding=0 cellspacing=';
var aL=absLEFT; aT=absTOP;

if(aT<0){aT=0;}
if(aL<0){aL=0;}


// convert shadow type
var shy=false;
if ((typeof shSIZE)=="string") { 
shy=true;
shSIZE=Number(shSIZE); 
}



// find the inner width and height of the browser window
var bW=window.innerWidth;
var bHe=window.innerHeight; 

//override width if defined
if(documentWIDTH>0){bW=documentWIDTH;}

// find the nav width and horizontal space

var endSpace=0;
var nS=0;
for (j=0;j<mI.length;j++){
if(mI[j][2]==""){mI[j][2]=10;}
if(mI[j][1]==""){mI[j][1]='&nbsp;'; 
}
nS+=mI[j][2]+bSIZE; 
}
endSpace=bW-nS-bSIZE;

//if(menuALIGN!="free"&&(bW<nS)){menuALIGN="left"; aL=0; stretchMENU=false; showBORDERS=false;}


// find the nav height

var nH=fSIZE+5+vPADDING;
if (fSIZE<13) { nH+=(13-fSIZE); }
var onH=nH;

// find wrapping links routine by brendan armstrong
var Mrows=new Array;var nlH=new Array;
var thisNH=new Array;var thisAH=new Array;
for(i=0;i<mI.length;i++){
var thisT=mI[i][1];
var splitT=thisT.split('<br>');
Mrows[i]=splitT.length;
if(Mrows[i]==0){Mrows[i]=1;}
nlH[i]=Mrows[i];
}

function cFun(a,b) { return b-a; }
Mrows.sort(cFun);
nH=nH*Mrows[0];

var aH=nH+(bSIZE*2)+1; 


for(i=0;i<mI.length;i++){
thisNH[i]=nH;if(menuALIGN=="free"){thisNH[i]=onH*nlH[i];}
thisAH[i]=nH+(bSIZE*2);if(menuALIGN=="free"){thisAH[i]=thisNH[i]+(2*bSIZE);}
}



// find the subnav item height

var snH=sfSIZE+4+svPADDING;
if (sfSIZE<13) { snH+=(13-sfSIZE); }
var asH=snH+(sbSIZE*2); 


// set values for different alignments
var free=false;
var xp=0;
var aP=new Array;
var aPL=new Array;

if(menuALIGN=="free"){
free=true;
for (xc=0;xc<mI.length;xc++){
aP[xc]=mI[xc][6]+aT;
aPL[xc]=mI[xc][7]+aL;
}
} else {
aP[xp]=aT;
}



var stAdjust=0; var abR; var rL; 

var ralign=false;
if(menuALIGN=="right"){
ralign=true;
abR=aL; 
aL=endSpace-abR;
rL=aL;
if(rL<0){rL=0;}
//if(bW<nS){aL=0;}
}

var calign=false;
if(menuALIGN=="center"){
calign=true;
aL=endSpace / 2;
rL=aL;
if(rL<0){rL=0;}
//if(bW<nS){aL=0;}
}

var lalign=false;
if(menuALIGN=="left"){
//aL+=bSIZE;
lalign=true;
abR=aL;
rL=aL; 
if(stretchMENU&&abR>0){stAdjust=abR+(2*bSIZE);}
if(rL<0){rL=0;}
}

var subLEFT=rL;
if(ralign){subLEFT-=abR;}
if(lalign){subLEFT+=abR;}

// how many main nav items
var ntl=0;
for (intl=0;intl<mI.length;intl++){if(mI[intl][1]!=""){ntl++;}}

var cStyle='cursor:hand';


// do nothing
function doNothing(){}


// find background colors or images

var back_defs=new Array(mCOLOR,bCOLOR,rCOLOR,smCOLOR,sbCOLOR,srCOLOR,shCOLOR);
var useIMG=new Array(false,false,false,false,false,false)
var bks=new Array;

for (b=0;b<7;b++){
bks[b]='bgcolor='+back_defs[b];
if((back_defs[b].indexOf('.gif') != -1) || (back_defs[b].indexOf('.jpg') != -1) || back_defs[b]==''){useIMG[b]=true;}
if(useIMG[b]){
bks[b]='background="'+bh + back_defs[b]+'"'; 
}
if(back_defs[b]==''){bks[b]='';} 
}



var n;
var gridOkay=false;
var pId=0;
var pSId=0;
var pCId=0;
var rTimer;var rCount=0;


// code saving visibility toggles
function miH(hr){if(hr){hr.style.visibility="hidden";}}
function miV(hv){if(hv){hv.style.visibility="visible";}}


// clear submenus
function aCM(n){
clearTimeout(rTimer);rCount=0;
miH(d.getElementById("grid"));
miH(d.getElementById('cgrid'+pId)); 
miH(d.getElementById('gridblocker'+pId));
miH(d.getElementById('gridLblocker'+pId));
miH(d.getElementById('shadow'+pId));
miH(d.getElementById('subnav'+pId)); 
miH(d.getElementById('roll'+pId)); 
for (l=0;l<sI[pId].length;l++){
miH(d.getElementById('sublink'+pId+'-'+l)); 
}
if(sI[pId][pSId]!=undefined){
miH(d.getElementById('subroll'+pId+'-'+pSId)); 
if(cP[pId][pSId]){
if(cP[pId][pSId].length>0){
miH(d.getElementById('childgrid'+pId+'-'+pSId));
miH(d.getElementById('childnav'+pId+'-'+pSId));
miH(d.getElementById('childshadow'+pId+'-'+pSId));
for (cl=0;cl<cI[pId][pSId].length;cl++){
miH(d.getElementById('childlink'+pId+'-'+pSId+'-'+cl));
miH(d.getElementById('childroll'+pId+'-'+pSId+'-'+cl));
}
}
}
}
pId=0; pSId=0;
}






// start menu closing timer
function cM(n){
var opNum=n;
if(rCount==0){
rCount++;
rTimer=setTimeout("cM(pId)",closeTIMER);
} else {
aCM(opNum); 
pId=0;pCId=0;
}
}





// open selected submenu
function oM(n,gridTrue){
if(typeof mI[n]=="undefined") { return false; }
if(typeof gridTrue=="undefined"){miV(d.getElementById("grid"));}else{aCM(n);}
miV(d.getElementById('roll'+n)); 
if(sI[n]!=""){
for (ohm=0;ohm<sI[n].length;ohm++){
miH(d.getElementById('subroll'+n+'-'+ohm)); 
}
miV(d.getElementById('gridblocker'+n));
miV(d.getElementById('gridLblocker'+n));
miV(d.getElementById('subnav'+n)); 
if(sI[n]!=''){miV(d.getElementById('shadow'+n));}
for (l=0;l<sI[n].length;l++){
miV(d.getElementById('sublink'+n+'-'+l)); 
}
}
pId=n;
}



// clear child menus
function cCM(snum,cnum){
if(cP[snum][pCId]&&cI[snum][pCId]){
if(cP[snum][pCId].length>0&&cI[snum][pCId].length>0){
miH(d.getElementById('childgrid'+snum+'-'+pCId));
miH(d.getElementById('childnav'+snum+'-'+pCId));
miH(d.getElementById('childshadow'+snum+'-'+pCId));
for (cl=0;cl<cI[snum][pCId].length;cl++){
miH(d.getElementById('childlink'+snum+'-'+pCId+'-'+cl));
miH(d.getElementById('childroll'+snum+'-'+pCId+'-'+cl));
}
}
}
pCId=0;
}



// open selected child menu
var snum; var cnum;
function oCM(snum,cnum){
if(cP[snum][cnum].length>0&&cI[snum][cnum].length>0){
miV(d.getElementById('childgrid'+snum+'-'+cnum));
miV(d.getElementById('childnav'+snum+'-'+cnum));
if(cI[snum][cnum]!=''){miV(d.getElementById('childshadow'+snum+'-'+cnum));}
for (cl=0;cl<cI[snum][cnum].length;cl++){
miV(d.getElementById('childlink'+snum+'-'+cnum+'-'+cl));
}
}
pCId=cnum;
}







// td click handlers
function goToUrl(cUrl,cTarg){
if(cellCLICK||(cellCLICK==mu)){
if(cTarg=="_self"){self.document.location=cUrl;}
else if(cTarg=="_top"){top.document.location=cUrl;}
else if(cTarg=="_parent"){parent.document.location=cUrl;}
else if(cTarg=="_blank"){var newwin=open(cUrl,"","status=yes,scrollbars=yes,toolbar=yes,menubar=yes,location=yes");}
else {
if(top.frames[cTarg]){top.frames[cTarg].document.location=cUrl} else {
				//to support iframe
				//document.location=cUrl;
   				document.getElementById(cTarg).src=cUrl;
	}
}
}
}







//alert("assemble main nav");

var mnDisplay='';
if(remoteTRIGGERING) { mnDisplay='display:none'; }


var T='';



// menu stretching and event capturing

var opColor=0; if(showBORDERS){opColor=1;}

if(!free){
if(stretchMENU){
T+='<span id="stretchnav" onmouseover="cM()" style="'+mnDisplay+'\;position:absolute\; top:'+aP[xp]+'\; left:0px\; width:'+bW+'\; height:'+aH+'\;"><table cellpadding=0 cellspacing=0 border=0 '+bks[opColor]+' style="width:'+bW+'\; height:'+(aH-1)+'\;"><tr><td></td></tr></table></span>'; 
if(showBORDERS){T+='<span id="stretchnav" onmouseover="cM()" style="'+mnDisplay+'\;position:absolute; top:'+(aP[xp]+bSIZE)+'\; left:'+bSIZE+'px\; width:'+(bW-(2*bSIZE))+'\;"><table cellpadding=0 cellspacing=0 border=0 '+bks[0]+' style="width:'+(bW-(2*bSIZE))+'\; height:'+(nH)+'\;"><tr><td></td></tr></table></span>';}
} else if(showBORDERS){
T+='<span id="stretchnav" onmouseover="cM()" style="'+mnDisplay+'\;position:absolute\; top:'+aP[xp]+'\; left:0px\; width:'+bW+'\;"><table cellpadding=0 cellspacing=0 border=0 '+bks[opColor]+' style="width:'+bW+'\; height:'+(aH-1)+'\;"><tr><td></td></tr></table></span>'; 
}
}



// event capturing layer
var GRw=bW;if(gridWIDTH>0){GRw=gridWIDTH;}
var GRh=bHe;if(gridHEIGHT>0){GRh=gridHEIGHT;}
var GRbc="";if(redGRID){GRbc="background-color:red";}
T+='<span id="grid" style="'+GRbc+'\;visibility:hidden\; position:absolute\; top:0\; left:0\; width:'+GRw+'\; height:'+GRh+'\; z-index:'+(zORDER+1)+'" onmousedown="aCM()" onmouseover="cM()"></span>';


// open frame
//if(ralign&&showBORDERS){rL-=(bSIZE-1);}
if(!free){
T+='<span id="mainnav" style="'+mnDisplay+'\;z-index:'+(zORDER+3)+'\; position:absolute\; top:'+aP[xp]+'px\; left:'+rL+'px\; width:'+(nS+bSIZE)+'px\; height:'+(nH+bSIZE)+'px\;">';
T+='<table cellspacing='+bSIZE+' cellpadding=0 border=0 '+bks[1]+' width='+(nS+bSIZE)+' style="height:'+(nH+bSIZE)+'px\;">';
T+='<tr>';
}


// freeform width adjusters
var opbs=0; 
if(free){opbs=1;}


// container cells
for (i=0;i<mI.length;i++){
if(mI[i][1]!=""){
if(free){
T+='<span style="'+mnDisplay+'\;z-index:'+(zORDER+3)+'\; position:absolute\; top:'+aP[i]+'px\; left:'+aPL[i]+'px\; width:'+(mI[i][2]+(2*bSIZE)+opbs)+'\;">';
T+='<table cellspacing='+bSIZE+' cellpadding=0 border=0 '+bks[1]+' width='+(mI[i][2]+(2*bSIZE)+opbs)+' style="height:'+(thisNH[i]+bSIZE)+'px\;">';
T+='<tr>';
}
T+='<td class=mTD width="'+(mI[i][2])+'"></td>'; 
if(free){T+='</tr></table></span>';}
}
}

// close frame
if(!free){T+='</tr></table></span>';}


// link color behaviour
if(aHOVER==""){aHOVER=aLINK;}
var aRoll=aLINK;
if(rCOLOR==""){aRoll=aHOVER;}
var lHTML='';
if(rCOLOR!=""){lHTML=' color="'+aHOVER+'"';}
var colr=' onmouseover="this.style.color=\''+aRoll+'\'\;" onmouseout="this.style.color=\''+aLINK+'\'\;" ';



// links
var SUBaL=aL+bSIZE;


var space='';

// alt text arrays
var aTxt=new Array;
var sTxt=new Array;
var cTxt=new Array;
var altNull='';

// write alt text to status bar 
function writeStatus(sTxt){window.status=sTxt; return true;}


for (i=0;i<mI.length;i++){


if(free){xp=i; SUBaL=aPL[i]+bSIZE;}

aTxt[i]='';
if(mI[i][5]!="none"){
if(altDISPLAY=="title"){aTxt[i]=' title="'+mI[i][5]+'" ';}
if(altDISPLAY=="status"){aTxt[i]=' onmouseover="return writeStatus(mI['+i+'][5])" onmouseout="return writeStatus(altNull)" ';}
}

// text indentation
var space=' left:0px\;';
if(mI[i][3]=="left"){space=' left:'+tINDENT+'px\;';}
if(mI[i][3]=="right"){space=' left:-'+tINDENT+'px\;';}


// link layers
T+='<div onmouseover="aCM()\; oM('+i+')" style="'+mnDisplay+'\;z-index:'+(zORDER+5)+'\; position:absolute\; top:'+(aP[xp]+bSIZE)+'px\; left:'+SUBaL+'px\; width:'+mI[i][2]+'px\; height:'+thisNH[i]+'px\;" onclick="goToUrl(mI['+i+'][0],mI['+i+'][4])">';
T+='<table cellpadding=0 cellspacing=0 border=0 '+bks[0]+' width='+(mI[i][2]+opbs)+' height='+thisNH[i]+'><tr><td valign=top align='+mI[i][3]+' '+aTxt[i]+'>';
if(mI[i][0]==""){
mI[i][0]="javascript:doNothing()"; 
T+='<a '+colr;
} else {
T+='<a '+colr+' href="'+mI[i][0]+'" target="'+ mI[i][4]+'"';
}
T+=' style="background-color:transparent\;text-decoration:'+aDEC+'\;position:relative\; top:'+((thisNH[i]/2)-((fSIZE*nlH[i])/2)+vtOFFSET)+'px; '+space+' color:'+aLINK+'\; font-weight:'+fWEIGHT+'\; font-size:'+fSIZE+'px\; font-family:'+fFONT+'\; text-decoration:'+aDEC+';">'+mI[i][1]+'</a>';
T+='</td></tr></table></div>';

// rollover layers
T+='<div onmouseover="aCM()\; oM('+i+')" onmouseout="if(!keepLIT){miH(this)}" id="roll'+i+'" style="'+mnDisplay+'\;visibility:hidden\; z-index:'+(zORDER+5)+'\; position:absolute\; top:'+(aP[xp]+bSIZE)+'px\; left:'+SUBaL+'px\; width:'+mI[i][2]+'px\; height:'+thisNH[i]+'px\;" onclick="goToUrl(mI['+i+'][0],mI['+i+'][4])">';
T+='<table cellpadding=0 cellspacing=0 border=0 '+bks[2]+' width='+(mI[i][2]+opbs)+' height='+thisNH[i]+'><tr><td valign=top align='+mI[i][3]+' '+aTxt[i]+'>';
if(mI[i][0]==""){
mI[i][0]="javascript:doNothing()"; 
T+='<a '+colr;
} else {
var tmItem='href="'+mI[i][0]+'" target="'+mI[i][4]+'"';
if((cellCLICK||(cellCLICK==mu))&&mI[i][4]=="_blank"){tmItem='href="'+mI[i][0]+'" onclick="goToUrl(mI['+i+'][0],\'_blank\')\;return false" ';}
T+='<a '+colr + tmItem;
}
T+=' style="background-color:transparent\;text-decoration:'+aDEC+'\;position:relative\; top:'+((thisNH[i]/2)-((fSIZE*nlH[i])/2)+vtOFFSET)+'px; '+space+' color:'+aLINK+'\; font-weight:'+fWEIGHT+'\; font-size:'+fSIZE+'px\; font-family:'+fFONT+'\; text-decoration:'+aDEC+'\;"><font'+lHTML+'>'+mI[i][1]+'</font></a>';
T+='</td></tr></table></div>';

// increase left to next item
if(!free){SUBaL+=(mI[i][2]+bSIZE);}
}




// assemble submenus
var M=''; var C='';

var SUBaL=0;

// sub rollover clearing function
function clearSubRoll(subc,subi){
if(pSId!=subi){
miH(d.getElementById('subroll'+subc+'-'+pSId));
}
pSId=subi;
}


// child rollover clearing function
function clearChildRoll(cuc,cus,cuj){
if(pCId!=cuj){
miH(d.getElementById('childroll'+cuc+'-'+cus+'-'+pCId));
}
pCId=cuj;
}


var chTop=new Array;

// link color behaviour
var saRoll=saLINK;
if(srCOLOR==""){saRoll=saHOVER;}
var slHTML='';
if(srCOLOR!=""){slHTML=' color="'+saHOVER+'"';}
var solr=' onmouseover="this.style.color=\''+saRoll+'\'\;" onmouseout="this.style.color=\''+saLINK+'\'\;" ';

// assemble submenus

var Xrows=new Array;
var XCrows=new Array;

for (c=0;c<mI.length;c++){

Xrows[c]=0;
XCrows[c]=new Array;

chTop[c]=new Array;

sTxt[c]=new Array;
cTxt[c]=new Array;

// text alignment and indentation
var space=' left:0px\;';
if(sP[c][2]=="left"){space=' left:'+stINDENT+'px\;';}
if(sP[c][2]=="right"){space=' left:-'+stINDENT+'px\;';}

// find next submenu position
if(!free){
if(c==0){SUBaL=rL+bSIZE;}
else SUBaL+=mI[(c-1)][2]+bSIZE;
} else {
SUBaL=SUBaL=aPL[c];
xp=c;
}

// specify edge alignment
var acL=SUBaL+hOFFSET+sP[c][4];
if(sP[c][1]=="right"){
acL=SUBaL-(sP[c][0]-mI[c][2])-hOFFSET-sP[c][4];
}

// grid block layer for vertical offset
if((vOFFSET+sP[c][3])>0){M+='<div id="gridblocker'+c+'" style="width:'+sP[c][0]+'px\; height:'+(vOFFSET+sP[c][3]+1)+'\; visibility:hidden\; z-index:'+(zORDER+1)+'\;position:absolute\; top:'+(aP[xp]+thisAH[c]-1)+'px\; left:'+acL+'px\;" onmouseover="clearTimeout(rTimer)\; rCount=0\;"></div>';}

// grid block layer for horizontal offset
var gblw=acL-mI[c][2]-SUBaL;
var gbposL=(SUBaL+mI[c][2]+(2*bSIZE)+1);
if(sP[c][1]=="right"){
gblw=mI[c][7]+bSIZE+aL-sP[c][0]-acL; 
gbposL=(mI[c][7]+bSIZE+aL-gblw);
}


for (i=0;i<sI[c].length;i++){
if(sI[c][i][0]!=''&&sI[c][i][1]!=''){
// find wrapping links routine by brendan armstrong
var thisH=snH;
var thisT=sI[c][i][1];
var splitT=thisT.split('<br>');
var Trows=splitT.length;
if (Trows>1) { Xrows[c]+=(Trows-1); }
}}

//grid blocker for offset
var shb=0;if(shy){shb=(2*shSIZE);}
if(gblw>0){M+='<span id="gridLblocker'+c+'" style="width:'+gblw+'px\; height:'+(((snH+bSIZE)*sI[c].length)+((snH+1)*Xrows[c])+shb+shSIZE)+'px\; visibility:hidden\; z-index:'+(zORDER+6)+'\;position:absolute\; top:'+(aP[xp]+thisAH[c]+vOFFSET+sP[c][3])+'px\; left:'+gbposL+'px\;" onmouseover="clearTimeout(rTimer)\; rCount=0\;"></span>';}


// compile cells
M+='<span id="subnav'+c+'" style="visibility:hidden\; z-index:'+(zORDER+7)+'\; position:absolute\; top:'+(aP[xp]+thisAH[c]+vOFFSET+sP[c][3])+'px\; left:'+acL+'px\; width:'+(sP[c][0]-(sbSIZE*2))+'\;">';
M+='<table cellpadding=0 cellspacing='+sbSIZE+' border=0 '+bks[4]+'>'; 
for (i=0;i<sI[c].length;i++){
if(sI[c][i][0]!=''&&sI[c][i][1]!=''){

// find wrapping links routine by brendan armstrong
var thisH=snH;
var thisT=sI[c][i][1];
var splitT=thisT.split('<br>');
var Trows=splitT.length;
if (Trows>1) { thisH=(snH*Trows); }

M+='<tr><td class=SUBmTD '+bks[3]+' align="'+sP[c][2]+'" style="width:'+(sP[c][0]-(2*sbSIZE))+'px\; height:'+(thisH+1)+'\;"></td></tr>';
}
}
M+='</table></span>';

// compile layers
var SUBaT=aP[xp]+thisAH[c]+vOFFSET+sP[c][3]+sbSIZE+svPADDING+svtOFFSET+2;
var subspace=' left:0px\;';
if(sP[c][2]=="left"){subspace=' left:'+stINDENT+'px\;';}
if(sP[c][2]=="right"){subspace=' left:-'+stINDENT+'px\;';}
for (i=0;i<sI[c].length;i++){

chTop[c][i]=SUBaT;


// find wrapping links routine by brendan armstrong
var thisH=snH;
var thisT=sI[c][i][1];
var splitT=thisT.split('<br>');
var Trows=splitT.length;
if (Trows>1) { thisH=(snH*Trows); }

cTxt[c][i]=new Array;
sTxt[c][i]='';
if(sI[c][i][3]!="none"){
if(altDISPLAY=="title"){sTxt[c][i]=' title="'+sI[c][i][3]+'" ';}
if(altDISPLAY=="status"){sTxt[c][i]=' onmouseover="return writeStatus(sI['+c+']['+i+'][3])" onmouseout="return writeStatus(altNull)" ';}
}

// links
var oppm=2; if(mac){oppm=1;}
var sval="top";if(!sI[c][i][4]){sval="middle";}
M+='<div id="sublink'+c+'-'+i+'" style="visibility:hidden\; z-index:'+(zORDER+8)+'\; width:'+(sP[c][0]-(sbSIZE*2))+'\; position:absolute\; top:'+(SUBaT-2-svPADDING-svtOFFSET)+'px\; left:'+(acL+sbSIZE)+'px\; height:'+(thisH+1)+'px\'" onmouseover="clearTimeout(rTimer)\; rCount=0\; cCM('+c+','+i+')\; oCM('+c+','+i+')\; clearSubRoll('+c+','+i+')\; if(!keepLIT){d.getElementById(\'roll'+c+'\').style.visibility=\'hidden\'\;} if(sI['+c+']['+i+'][4]){d.getElementById(\'subroll'+c+'-'+i+'\').style.visibility=\'visible\'\;}" onclick="goToUrl(sI['+c+']['+i+'][0],sI['+c+']['+i+'][2])">';
M+='<table cellpadding=0 cellspacing=0 border=0 width="100%" height="100%" id="sublink'+c+'-'+i+'"><tr><td valign='+sval+' align='+sP[c][2]+' class=SUBmTD '+sTxt[c][i]+'>';
if(sI[c][i][0]=="#"){
sI[c][i][0]="javascript:doNothing()"; 
M+='<a '+solr;
} else {
M+='<a '+solr+' href="'+sI[c][i][0]+'" target="'+sI[c][i][2]+'" '; 
}
M+='style="background-color:transparent\;text-decoration:'+saDEC+'\;position:relative\; top:'+(svtOFFSET+(parseInt(svPADDING/2))+(3*Trows))+'\; '+subspace+'"><span style="color:'+saLINK+'\; font-weight:'+sfWEIGHT+'\; font-size:'+sfSIZE+'px\; font-family:'+sfFONT+'\; text-decoration:'+saDEC+'\;" onmouseover="this.style.color=\''+saHOVER+'\'" onmouseout="this.style.color=\''+saLINK+'\'">'+sI[c][i][1]+'</span></a>';
M+='</td></tr></table></div>';

// rollovers
M+='<div id="subroll'+c+'-'+i+'" style="visibility:hidden\; z-index:'+(zORDER+9)+'\; width:'+(sP[c][0]-(sbSIZE*2))+'\; position:absolute\; top:'+(SUBaT-2-svPADDING-svtOFFSET)+'px\; left:'+(acL+sbSIZE)+'px\; height:'+(thisH+oppm)+'px\'" onmouseover="clearTimeout(rTimer)\; rCount=0\; cCM('+c+','+i+')\; oCM('+c+','+i+')\;" onclick="goToUrl(sI['+c+']['+i+'][0],sI['+c+']['+i+'][2])">';
M+='<table cellpadding=0 cellspacing=0 border=0 '+bks[5]+' width="100%" height="100%" id="sublink'+c+'-'+i+'"><tr><td valign='+sval+' align='+sP[c][2]+' class=SUBmTD '+sTxt[c][i]+'>';
if(sI[c][i][0]=="#"){
sI[c][i][0]="javascript:doNothing()"; 
M+='<a '+solr;
} else {
var tsItem='href="'+sI[c][i][0]+'" target="'+sI[c][i][2]+'"';
if((cellCLICK||(cellCLICK==mu))&&sI[c][i][2]=="_blank"){tsItem='href="'+sI[c][i][0]+'" onclick="goToUrl(sI['+c+']['+i+'][0],\'_blank\')\;return false" ';}
M+='<a '+solr + tsItem; 
}
M+='style="background-color:transparent\;text-decoration:'+saDEC+'\;position:relative\; top:'+(svtOFFSET+(parseInt(svPADDING/2))+(3*Trows))+'\; '+subspace+'"><span style="color:'+saLINK+'\; font-weight:'+sfWEIGHT+'\; font-size:'+sfSIZE+'px\; font-family:'+sfFONT+'\; text-decoration:'+saDEC+'\;" onmouseover="this.style.color=\''+saHOVER+'\'" onmouseout="this.style.color=\''+saLINK+'\'"><font'+slHTML+'>'+sI[c][i][1]+'</font></span></a>';
M+='</td></tr></table></div>';

// increase top to next item
SUBaT+=thisH+sbSIZE+1;
}

//alert("drop shadow"); 
var shb=0;if(shy){shb=(2*shSIZE);}
if(shCOLOR!=""){M+='<table cellpadding=0 cellspacing=0 border=0 '+bks[6]+' id="shadow'+c+'" style="visibility:hidden\; position:absolute; z-index:'+(zORDER+6)+'\; top:'+(aP[xp]+thisAH[c]+vOFFSET+sP[c][3]+shSIZE-shb)+'px\; left:'+(acL+shSIZE-shb)+'px\; height:'+(SUBaT-(aP[xp]+thisAH[c]+vOFFSET+sP[c][3])-svPADDING-2+shb-svtOFFSET)+'\; width:'+(sP[c][0]+shb)+'\;"><tr><td>&nbsp;</td></tr></table>';}



//alert("assemble child menus");
for (sq=0;sq<sI[c].length;sq++){

if(cP[c][sq].length>0&&cI[c][sq].length>0){

XCrows[c][sq]=0;

// specify edge alignment
var chL;
if(cP[c][sq][1]=="right"){
chL=acL-cP[c][sq][0]-chhOFFSET-cP[c][sq][4];
cgL=chL+cP[c][sq][0];
} else {
chL=acL + sP[c][0]+chhOFFSET+cP[c][sq][4];
cgL=(chL-(chhOFFSET+cP[c][sq][4]));
}


for (cj=0;cj<cI[c][sq].length;cj++){
// find wrapping links routine by brendan armstrong
var thisH=snH;
var thisT=cI[c][sq][cj][1];
var splitT=thisT.split('<br>');
var Trows=splitT.length;
if (Trows>1) { XCrows[c][sq]+=(Trows-1); }
}


// grid block layer for horizontal offset
if((chhOFFSET+cP[c][sq][4])>0){
C+='<table id="childgrid'+c+'-'+sq+'" style="visibility:hidden\; position:absolute; z-index:'+(zORDER+10)+'\; top:'+(((chTop[c][sq]-sbSIZE-svPADDING-2)-svtOFFSET)+chvOFFSET+cP[c][sq][3])+'px\; left:'+cgL+'px\; height:'+(((snH+sbSIZE+1)*cI[c][sq].length)+((snH)*XCrows[c][sq])+sbSIZE+shb+shSIZE)+'\; width:'+(chhOFFSET+cP[c][sq][4])+'\;" cellpadding=0 cellspacing=0 border=0 onmouseover="clearTimeout(rTimer)\; rCount=0\;"><tr><td></td></tr></table>';
}

// compile cells
C+='<span id="childnav'+c+'-'+sq+'" style="visibility:hidden\; z-index:'+(zORDER+11)+'\; position:absolute\; top:'+((chTop[c][sq]-sbSIZE-svPADDING-2)-svtOFFSET+chvOFFSET+cP[c][sq][3])+'px\; left:'+chL+'px\; width:'+(cP[c][sq][0]-(2*sbSIZE))+'px\; height:'+(((snH+(2*sbSIZE))*cI[c][sq].length)+1)+'px\;">';
C+='<table cellpadding=0 cellspacing='+sbSIZE+' border=0 '+bks[4]+'>'; 
for (cj=0;cj<cI[c][sq].length;cj++){

// find wrapping links routine by brendan armstrong
var thisH=snH;
var thisT=cI[c][sq][cj][1];
var splitT=thisT.split('<br>');
var Trows=splitT.length;
if (Trows>1) { thisH=(snH*Trows); }

C+='<tr><td class=SUBmTD '+bks[3]+' align="'+cP[c][sq][2]+'" style="width:'+(cP[c][sq][0]-(2*sbSIZE))+'px\; height:'+(thisH+1)+'\;"></td></tr>';
}
C+='</table></span>';

// compile layers
var csubspace=' left:0px\;';
if(cP[c][sq][2]=="left"){csubspace=' left:'+stINDENT+'px\;';}
if(cP[c][sq][2]=="right"){csubspace=' left:-'+stINDENT+'px\;';}

var subT = ((chTop[c][sq]-(svPADDING))-svtOFFSET+chvOFFSET+cP[c][sq][3]-1);

for (cj=0;cj<cI[c][sq].length;cj++){

// find wrapping links routine by brendan armstrong
var thisH=snH;
var thisT=cI[c][sq][cj][1];
var splitT=thisT.split('<br>');
var Trows=splitT.length;
if (Trows>1) { thisH=(snH*Trows); }


cTxt[c][sq][cj]='';
if(cI[c][sq][cj][3]!="none"){
if(altDISPLAY=="title"){cTxt[c][sq][cj]=' title="'+cI[c][sq][cj][3]+'" ';}
if(altDISPLAY=="status"){cTxt[c][sq][cj]=' onmouseover="return writeStatus(cI['+c+']['+sq+']['+cj+'][3])" onmouseout="return writeStatus(altNull)" ';}
}

var sval="top";if(!cI[c][sq][cj][4]){sval="middle";}
if(cI[c][sq][cj][0]=="#"){cI[c][sq][cj][0]="javascript:doNothing()";}

// links
C+='<div id="childlink'+c+'-'+sq+'-'+cj+'" style="visibility:hidden\; z-index:'+(zORDER+12)+'\; width:'+(cP[c][sq][0]-(sbSIZE*2))+'\; position:absolute\; top:'+subT+'px\; left:'+(chL+sbSIZE)+'px\; height:'+(thisH+1)+'px\'" onmouseover="clearTimeout(rTimer)\; rCount=0\; if(!keepSubLIT){d.getElementById(\'subroll'+c+'-'+sq+'\').style.visibility=\'hidden\'\;}clearChildRoll('+c+','+sq+','+cj+')\; if(cI['+c+']['+sq+']['+cj+'][4]){d.getElementById(\'childroll'+c+'-'+sq+'-'+cj+'\').style.visibility=\'visible\'\;} d.getElementById(\'cgrid'+c+'\').style.visibility=\'visible\'" onclick="goToUrl(cI['+c+']['+sq+']['+cj+'][0],cI['+c+']['+sq+']['+cj+'][2])">';
C+='<table cellpadding=0 cellspacing=0 border=0 width="100%" height="100%" id="childlink'+c+'-'+sq+'-'+cj+'"><tr><td valign='+sval+' align='+cP[c][sq][2]+' class=SUBmTD '+cTxt[c][sq][cj]+'>';
C+='<a href="'+cI[c][sq][cj][0]+'" target="'+cI[c][sq][cj][2]+'" style="background-color:transparent\;text-decoration:'+saDEC+'\;position:relative\; top:'+(svtOFFSET+(parseInt(svPADDING/2))+(3*Trows))+'\; '+csubspace+'"><span style="color:'+saLINK+'\; font-weight:'+sfWEIGHT+'\; font-size:'+sfSIZE+'px\; font-family:'+sfFONT+'\; text-decoration:'+saDEC+'\;" '+solr+'>'+cI[c][sq][cj][1]+'</span></a>';
C+='</td></tr></table></div>';

// rollovers
C+='<div id="childroll'+c+'-'+sq+'-'+cj+'" style="visibility:hidden\; z-index:'+(zORDER+13)+'\; width:'+(cP[c][sq][0]-(sbSIZE*2))+'\; position:absolute\; top:'+(subT-1)+'px\; left:'+(chL+sbSIZE)+'px\; height:'+(thisH+oppm)+'px\'" onmouseover="clearTimeout(rTimer)\; rCount=0\;" onmouseout="miH(this)" onclick="goToUrl(cI['+c+']['+sq+']['+cj+'][0],cI['+c+']['+sq+']['+cj+'][2])">';
C+='<table cellpadding=0 cellspacing=0 border=0 '+bks[5]+' width="100%" height="100%" id="childlink'+c+'-'+sq+'-'+cj+'"><tr><td valign='+sval+' align='+cP[c][sq][2]+' class=SUBmTD '+cTxt[c][sq][cj]+'>';
var tcItem='href="'+cI[c][sq][cj][0]+'" target="'+cI[c][sq][cj][2]+'"';
if((cellCLICK||(cellCLICK==mu))&&cI[c][sq][cj][2]=="_blank"){tcItem='href="'+cI[c][sq][cj][0]+'" onclick="goToUrl(cI['+c+']['+sq+']['+cj+'][0],\'_blank\')\;return false"';}
C+='<a '+tcItem+' style="background-color:transparent\;text-decoration:'+saDEC+'\;position:relative\; top:'+(svtOFFSET+(parseInt(svPADDING/2))+(3*Trows)+1)+'\; '+csubspace+'"><span style="color:'+saLINK+'\; font-weight:'+sfWEIGHT+'\; font-size:'+sfSIZE+'px\; font-family:'+sfFONT+'\; text-decoration:'+saDEC+'\;" '+solr+'><font'+slHTML+'>'+cI[c][sq][cj][1]+'</span></a>';
C+='</td></tr></table></div>';

subT+=thisH+sbSIZE+1;
}

//alert("drop shadow"); 
if(shCOLOR!=""){C+='<table cellpadding=0 cellspacing=0 border=0 '+bks[6]+' id="childshadow'+c+'-'+sq+'" style="visibility:hidden\; position:absolute; z-index:'+(zORDER+10)+'\; top:'+(((chTop[c][sq]-sbSIZE-svPADDING-2)-svtOFFSET)+shSIZE+chvOFFSET+cP[c][sq][3]-shb)+'px\; left:'+(chL+shSIZE-shb)+'px\; height:'+(((snH+sbSIZE+1)*cI[c][sq].length)+((snH)*XCrows[c][sq])+sbSIZE+shb)+'\; width:'+(cP[c][sq][0]+shb)+'\;"><tr><td>&nbsp;</td></tr></table>';}


}
}
// childmenu event capturing layers
C+='<span id="cgrid'+c+'" style="visibility:hidden\; position:absolute\; top:'+(aP[xp]+aH+vOFFSET+sP[c][3])+'\; left:'+acL+'\; width:'+sP[c][0]+'\; height:'+(SUBaT-(aP[xp]+aH+vOFFSET+sP[c][3])-svPADDING-2)+'\; z-index:'+(zORDER+9)+'" onmouseover="miH(this)\; aCM()\; oM('+c+')\;"></span>';

}






// draw child menus
d.write(C);

// draw submenus
d.write(M);

// draw main nav 
d.write(T);




// resize/reload routine
// based on a function by Michael Wallner - http://www.wallner-software.com/

var oldBW=window.innerWidth;
var oldBH=window.innerHeight;
var fws;

function findWindowSize() {
var newBW=window.innerWidth;
var newBH=window.innerHeight;
if (newBW==oldBW&&newBH==oldBH){ 
fws = setTimeout("findWindowSize()",100); 
}
else { 
	clearTimeout(fws); 
	if(window.innerWidth>(nS+absLEFT)) { window.location.reload(); }
	else { fws = setTimeout("findWindowSize()",100); }
	}
}


function windowStart() {
genericOnloadFunction();
if(allowRESIZE==true){findWindowSize();}
}



window.onload=windowStart;

document.onclick=aCM;


//move menu
function activateMenu(mmNum) {
	if(typeof sP[mmNum]=="undefined"||!remoteTRIGGERING) { return false; }
	
	oM(mmNum,false); 
	}
