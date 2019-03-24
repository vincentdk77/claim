//UDMv3.4.1



// filter for undefined arrays 
for (f=0;f<mI.length;f++){
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

// compensate for lack of scrollbar if applicable
var offsetCenter=true;
if(document.width>=innerWidth&&!mac){
bW-=16; offsetCenter=false;
if(agt.indexOf("winnt")!=-1){bW-=1;}
}

//override width if defined
if(documentWIDTH>0){bW=documentWIDTH;}


// find the nav width and horizontal space

var eS=0;
var nS=0;
for (j=0;j<mI.length;j++){
mI[j][2]+=1;
if(mI[j][1]==""){mI[j][1]="&nbsp;";}
mI[j][2]-=1;
if(mI[j][1]!=""){
nS+=mI[j][2]+bSIZE; 
}
}
eS=bW-nS-bSIZE;

//if(menuALIGN!="free"&&(bW<nS)){menuALIGN="left"; aL=0; stretchMENU=false; showBORDERS=false;}


// find the nav height

var nH=fSIZE+4+vPADDING;
if (fSIZE<13) { nH+=(13-fSIZE); }
var onH=nH;

// find wrapping links routine by brendan armstrong
var Mrows=new Array;var Nrows=new Array;
var thisNH=new Array;var thisAH=new Array;var thisCHtop=new Array;
for(i=0;i<mI.length;i++){
var thisT=mI[i][1];
var splitT=thisT.split('<br>');
Mrows[i]=splitT.length;
Nrows[i]=Mrows[i];
}

function cFun(a,b) { return b-a; }
Mrows.sort(cFun);
nH=nH*Mrows[0];

var aH=nH+(bSIZE*2); 
if(bW<nS){nH-=2; aH-=2;}


for(i=0;i<mI.length;i++){
thisCHtop[i]=new Array;
thisNH[i]=nH;if(menuALIGN=="free"){thisNH[i]=onH*Nrows[i];}
thisAH[i]=nH+(bSIZE*2);if(menuALIGN=="free"){thisAH[i]=thisNH[i]+(2*bSIZE);}
if(bW<nS&&menuALIGN=="free"){thisNH[i]-=2; thisAH[i]-=2;}
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
//alert(aP[xc]);
}
} else {
aP[xp]=aT;
}



var stAdjust=0; var abR; var rL; 

var ralign=false;
if(menuALIGN=="right"){
ralign=true;
abR=aL; 
aL=eS-abR;
rL=aL;
if(rL<0){rL=0;}
aL=0; 
}

var calign=false;
if(menuALIGN=="center"){
calign=true;
aL=parseInt(eS/2);
if(offsetCenter){aL-=8;}
rL=aL;
if(mac){
if(document.width==innerWidth){rL+=8;}
else if(document.width<innerWidth){rL+=1;}
}
if(rL<0){rL=0;}
aL=0; 
}

var lalign=false;
if(menuALIGN=="left"){
lalign=true;
abR=aL;
rL=aL; 
if(stretchMENU&&abR>0){stAdjust=abR+(2*bSIZE);}
if(rL<0){rL=0;}
if(stretchMENU){aL=0;}
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
var mainbacks=new Array;

for (b=0;b<7;b++){
bks[b]='bgcolor='+back_defs[b];
if((back_defs[b].indexOf('.gif') != -1) || (back_defs[b].indexOf('.jpg') != -1) || back_defs[b]==''){useIMG[b]=true;}
if(useIMG[b]){
bks[b]='background="'+bh+back_defs[b]+'"'; 
}
if(back_defs[b]==''){bks[b]='';} 
}


// code saving visibility toggles
function miH(hr){if(hr){hr.visibility="hide";}}
function miV(hv){if(hv){hv.visibility="show";}}




// clear submenus
var pId=0;
var pCId=0;
var rTimer;var rCount=0;

function aCM(n){
rCount=0;clearTimeout(rTimer);
miH(document.layers["grid"]);
var shadid=document.layers["shadow"+pId];
miH(shadid);
miH(document.layers["subnav"+pId]);
miH(document.layers["roll"+pId]); 
var grL=document.layers["gridL"];
var grR=document.layers["gridR"];
miH(grL);
miH(grR);
miH(document.layers["childgrid"+pId+"-"+pCId]);
miH(document.layers["childshadow"+pId+"-"+pCId]);
miH(document.layers["childnav"+pId+"-"+pCId]);
if(cI[pId][pCId]){
for (crc=0;crc<cI[pId][pCId].length;crc++){
miH(document.layers["childroll"+pId+"-"+pCId+"-"+crc]);
}
}
for (rc=0;rc<sI[pId].length;rc++){
miH(document.layers["subroll"+pId+"-"+rc]);
miH(document.layers["defaultSubLayer"+pId+"-"+rc]);
}
pId=0; pCId=0;
usegrid=false;
}





// start menu closing timer
function cM(n){
var nsNum=n;
if(pCId==0&&!usegrid){
aCM(nsNum); 
pId=0;pCId=0;
} else {
if(rCount==0){
rCount++;
rTimer=setTimeout("cM(pId)",closeTIMER);
} else {
aCM(nsNum); 
pId=0;pCId=0;
}
}
}



// special closing for grid
var usegrid=false;
function gridClearMenus(){
rCount=0;clearTimeout(rTimer);
usegrid=true;
cM();
}




// open selected submenu

var n;
var gridOkay=false;

function oM(n,gridTrue){
if(typeof mI[n]=="undefined") { return false; }
aCM();
if(typeof gridTrue=="undefined"){miV(document.layers["grid"]);}
if(!remoteTRIGGERING){miV(document.layers["roll"+n]); }
for (l=0;l<sI[n].length;l++){
miH(document.layers["subroll"+n+"-"+l]);
miV(document.layers["defaultSubLayer"+n+"-"+l]);
miV(document.layers["subnav"+n].document.layers[0].document.layers[l].document.layers[0].document.layers[0].document.layers[0]); 
}
if(sI[n]!=''&&sI[n].length>0){miV(document.layers["shadow"+n]);}
miV(document.layers["subnav"+n]); 
var grL=document.layers["gridL"];
var grR=document.layers["gridR"];
miV(grL);
miV(grR);
pId=n;
}



// clear child menus
function cCM(snum,cnum){
for(jc=0;jc<sI[snum].length;jc++){
miH(document.layers["subroll"+snum+"-"+jc]); 
for(jcc=0;jcc<cI[snum][jc].length;jcc++){
miH(document.layers["childroll"+snum+"-"+jc+"-"+jcc]);
}
}
if(cP[snum][pCId].length>0&&cI[snum][pCId].length>0){
miH(document.layers["childgrid"+snum+"-"+pCId]);
miH(document.layers["childnav"+snum+"-"+pCId]);
miH(document.layers["childshadow"+snum+"-"+pCId]);
}
pCId=0;
}



// open selected child menu
var snum,cnum,finalCMTop,tempSMobj,tempSRobj,tempCMobj,tempCGobj,tempCHobj,tempCRObj,RcmLeft,GcmLeft,shMove,crTopPos;
function oCM(snum,cnum){
	if(!keepLIT){
		miH(document.layers["roll"+snum]);
		}
	if(sI[snum][cnum][4]){
		miV(document.layers["subroll"+snum+"-"+cnum]); 
		}
	if(cP[snum][cnum].length>0&&cI[snum][cnum].length>0){
		miV(document.layers["childgrid"+snum+"-"+cnum]);
		miV(document.layers["childnav"+snum+"-"+cnum]);

		//move if remotely triggered 
		if(remoteTRIGGERING) {
			tempSMobj=document.layers["subnav"+snum];
			tempSRobj=document.layers["subroll"+snum+"-"+cnum];
			tempCMobj=document.layers["childnav"+snum+"-"+cnum];
			tempCGobj=document.layers["childgrid"+snum+"-"+cnum];
			tempCHobj=document.layers["childshadow"+snum+"-"+cnum];
			
			RcmLeft=tempSMobj.pageX;
			GcmLeft=RcmLeft;
			if(cP[snum][cnum][1]=="right"){
				RcmLeft-=(tempCMobj.clip.width+chhOFFSET+cP[snum][cnum][4]);
				GcmLeft-=(chhOFFSET+cP[snum][cnum][4]);
				}
			else{
				RcmLeft+=(tempSMobj.clip.width+chhOFFSET+cP[snum][cnum][4]);
				GcmLeft+=(tempSMobj.clip.width);
				}
			shMove=shSIZE;if(shy){shMove=0-shSIZE;}
			tempCHobj.left=RcmLeft+shMove;
			
			finalCMTop=tempSRobj.pageY+chvOFFSET+cP[snum][cnum][3];
			//if((finalCMTop+tempCMobj.clip.height+shSIZE)>bHe) { 
			//	finalCMTop=finalCMTop-((finalCMTop+tempCMobj.clip.height+shSIZE)-bHe)+tempCMobj.clip.height; 
			//	}
			tempCMobj.top=finalCMTop;
			tempCHobj.top=finalCMTop+shMove;
			
			tempCMobj.left=RcmLeft;
			if(tempCGobj) {
				tempCGobj.left=GcmLeft;
				tempCGobj.top=finalCMTop;
				}
			}

		if(cI[snum][cnum]!=''){
			miV(document.layers["childshadow"+snum+"-"+cnum]);
			}
			
		
		crTopPos=sbSIZE;
		for (cl=0;cl<cI[snum][cnum].length;cl++){
			miV(document.layers["childnav"+snum+"-"+cnum].layers[0].layers[cl].layers[0].layers[0].layers[0]); 
			
			if(remoteTRIGGERING){
				//move if remotely triggered 
				tempCRObj=document.layers["childroll"+snum+"-"+cnum+"-"+cl];
				tempCRObj.left=tempCMobj.left+sbSIZE;
				tempCRObj.top=tempCMobj.top+crTopPos;
				crTopPos+=sbSIZE+document.layers["childnav"+snum+"-"+cnum].layers[0].layers[cl].layers[0].clip.height;
				}
			
			}
		}
	pCId=cnum;
	}



// click handler for cellCLICK active _blank link anchors, to prevent two windows from opening
function activateClick(nsUrl){
var newwin=open(nsUrl);
}



//alert("assemble main nav");

var mnDisplay='';
if(remoteTRIGGERING) { mnDisplay=' visibility=hide '; }


var S='';
var T='';

var tFrame='<table cellpadding=0 cellspacing=0 border=0>';


// event capturing layer
var GRw=bW;if(gridWIDTH>0){GRw=gridWIDTH;}
var GRh=bHe;if(gridHEIGHT>0){GRh=gridHEIGHT;}
var GRbc="";if(redGRID){GRbc="bgcolor=red";}
var gSTR='<layer id="grid" '+GRbc+' top=0 left=0 width='+GRw+' height='+GRh+' visibility=hide onmouseover="gridClearMenus()"></layer>';

// nav stretching
var nsColor=bCOLOR;
if(!showBORDERS){nsColor=mCOLOR;}
var nsMColor=mCOLOR;


if(stretchMENU){
if(showBORDERS){var sbB=1;} else {var sbB=0;}
S+='<layer '+mnDisplay+' id="stretchnav" '+bks[sbB]+' top='+aP[xp]+' left=0 width='+bW+' height='+aH+'>'; 
S+='<layer '+bks[0]+' top='+bSIZE+' left='+bSIZE+' width='+(bW-(2*bSIZE))+' height='+nH+'></layer>'; 
S+='</layer>';
} else if(showBORDERS){
S+='<layer '+mnDisplay+' id="stretchnav" '+bks[1]+' top='+aP[xp]+' left=0 width='+bW+' height='+aH+'>';
S+='</layer>';
}


// background layer
S+='<layer '+mnDisplay+' id="undernav" '+bks[1]+' top='+aP[xp]+' left='+rL+' width='+(nS+bSIZE)+' height='+aH+'></layer>'; 



// open frame
if(!free){T+='<layer '+mnDisplay+' id="mainnav" top='+aP[xp]+' left='+rL+'><table cellpadding=0 cellspacing='+bSIZE+' border=0><tr>';}


// find width of link layer to calculate text indentation
var lc=0;
function findWidths(lyo,lyW,lyH){
if(mI[lc][3]=="left"){lyo.left=tINDENT;}
if(mI[lc][3]=="center"){lyo.left=0;}
if(mI[lc][3]=="right"){lyo.left=(mI[lc][2]-lyW-tINDENT);}
if((lyH<thisNH[lc])){lyo.top=parseInt((thisNH[lc]-lyH)/2)+vtOFFSET;}
lc++;
if(lc==mI.length){lc=0;}
}


// links
for (i=0;i<mI.length;i++){
if(free){T+='<layer '+mnDisplay+' id="free'+i+'" top='+aP[i]+' left='+aPL[i]+' '+bks[1]+'><table cellpadding=0 cellspacing='+bSIZE+' border=0><tr>';}
T+='<td '+bks[1]+' class=mTD height='+(thisNH[i]-(2*bSIZE))+'><ilayer id="ilayer'+i+'"><layer onmouseover="oM('+i+')" width="'+(mI[i][2])+'" height="'+(thisNH[i])+'" '+bks[0]+' id="container'+i+'"><layer width="100%" height="100%" visibility=show><layer left=0 onload="findWidths(this,this.clip.right,this.clip.bottom)" visibility=show><div width="100%" height="100%" align='+mI[i][3]+'><a class="translink" href="'+mI[i][0]+'" target="'+mI[i][4]+'">'+mI[i][1]+'</a></div></layer></layer></layer></ilayer></td>'; 
if(free){T+='</tr></table></layer>';}
}

// close frame
if(!free){T+='</tr></table></layer>';}


// link color behaviour
if(aHOVER==""){aHOVER=aLINK;}
var aRoll=aHOVER;



// alt text arrays
var aTxt=new Array;
var sTxt=new Array;
var cTxt=new Array;
var altNull='';

// write alt text to status bar 
function writeStatus(sTxt){window.status=sTxt; return true;}


// rollover layers
var subDefLeft=rL+bSIZE;
for (i=0;i<mI.length;i++){

aTxt[i]='';
if(mI[i][5]!="none"){
if(altDISPLAY=="status"){aTxt[i]=' onmouseover="return writeStatus(mI['+i+'][5])" onmouseout="return writeStatus(altNull)" ';}
}

if(free){subDefLeft=mI[i][7]+bSIZE+aL; xp=i;}
T+='<layer '+bks[2]+' id="roll'+i+'" visibility=hide top='+(aP[xp]+bSIZE)+' left='+subDefLeft +' width='+mI[i][2]+' height='+(thisNH[i])+' onmouseout="if(!keepLIT){miH(this)}">';
T+='<layer width="100%" height="100%" '+aTxt[i]+'><table cellpadding=0 cellspacing=0 border=0 width="100%" height="100%"><tr><td align=center class=mTD><layer left=0 onload="findWidths(this,this.clip.right,this.clip.bottom)"><div width="100%" height="100%" align='+mI[i][3]+'>';
var tcItem='<a class="translink" href="'+mI[i][0]+'" target="'+mI[i][4]+'" '+aTxt[i]+'>';
if((cellCLICK||(cellCLICK==mu))&&mI[i][4]=="_blank"){tcItem='<a class="translink" href="'+mI[i][0]+'" onclick="activateClick(mI['+i+'][0])\;return false" '+aTxt[i]+'>';}
T+=tcItem+'<font color="'+aRoll+'">'+mI[i][1]+'</font></a>';
T+='</div></layer></td></tr></table></layer>';
T+='</layer>'; 
if(!free){subDefLeft+=(mI[i][2]+bSIZE);}
}



// default cursor layers for non links
var subDefLeft=rL+bSIZE; 
for (i=0;i<mI.length;i++){
if(free){subDefLeft=mI[i][7]+bSIZE+aL; xp=i;}
if(mI[i][0]==""){T+='<layer id="defaultLayer'+i+'" top='+(aP[xp]+bSIZE)+' left='+subDefLeft +' width='+mI[i][2]+' height='+(thisNH[i])+' onmouseover="oM('+i+')"><layer width="100%" height="100%" '+aTxt[i]+'></layer></layer>';}
if(!free){subDefLeft+=(mI[i][2]+bSIZE);}
}



// event gapturing grid
var gdL='<layer id="gridR" visibility=hide';
var gdR='<layer id="gridL" visibility=hide';
var ogcm=' onmouseover="gridClearMenus()" height='+nH;
if(((bW>(nS+bSIZE))||(stAdjust>0))&&(stretchMENU||showBORDERS)&&(!free)){
if(ralign){T+=gdL+' top='+aP[xp]+' left='+aL+' '+ogcm+' width='+(eS-(bSIZE*2)-abR)+'></layer>';}
if(ralign&&abR>0){T+=gdR+' top='+aP[xp]+' left='+(eS-abR+nS)+' '+ogcm+' width='+(abR-(bSIZE*2))+'></layer>';}
if(lalign&&abR>0){T+=gdL+' top='+aP[xp]+' left='+aL+' '+ogcm+' width='+abR+'></layer>';}
if(lalign){T+=gdR+' top='+aP[xp]+' left='+(abR+nS)+' '+ogcm+' width='+(eS-abR)+'></layer>';}
if(calign){
T+=gdL+' top='+aP[xp]+' left=0 '+ogcm+' width='+(eS/2)+'></layer>'; 
T+=gdR+' top='+aP[xp]+' left='+(nS+(eS/2))+' '+ogcm+' width='+(eS/2)+'></layer>'; 
}
}



// assemble submenus

var M='';
var C='';

var SUBaL=0;

// find width of link layer to calculate text indentation
var slc=0;
function findSubWidths(lct,slyo,slyW,slyH,thisLH){
if(sP[lct][2]=="left"){slyo.left=stINDENT;}
if(sP[lct][2]=="center"){slyo.left=0;}
if(sP[lct][2]=="right"){slyo.left=((sP[lct][0]-(2*sbSIZE))-slyW-stINDENT);}
if(slyH<thisLH){slyo.top=(thisLH-slyH)/2+svtOFFSET;}
slc++;
if(slc==sP.length){slc=0;}
}


// find width of child link layer to calculate text indentation
var clc=0;
function findChildWidths(lct,cht,slyo,slyW,slyH,thisLH){
if(cP[lct][cht][2]=="left"){slyo.left=stINDENT;}
if(cP[lct][cht][2]=="center"){slyo.left=0;}
if(cP[lct][cht][2]=="right"){slyo.left=((cP[lct][cht][0]-(2*sbSIZE))-slyW-stINDENT);}
if(slyH<thisLH){slyo.top=(thisLH-slyH)/2+svtOFFSET;}
clc++;
if(clc==cI[lct].length){clc=0;}
}




// find height of menu layers to calculate drop shadow size
var shb=0;if(shy){shb=(2*shSIZE);}
function findLayerHeight(sn,sh){
if(shCOLOR!=""){document.layers["shadow"+sn].clip.bottom=sh+shb;}}
function findChildHeight(cnn,cqn,cch){
if(shCOLOR!=""){document.layers["childshadow"+cnn+"-"+cqn].clip.bottom=cch+shb;}
if((chhOFFSET+cP[cnn][cqn][4])>0){document.layers["childgrid"+cnn+"-"+cqn].clip.bottom=cch+shb+shSIZE;}
}





// cell rollout backup function
function subRollClear(mi){
for (rc=0;rc<sI[mi].length;rc++){
miH(document.layers["subroll"+mi+"-"+rc]);
}
}

// cell rollover function for default cursor layers
function subRollOpen(omic,omis){
if(sI[omic][omis][4]){miV(document.layers["subroll"+omic+"-"+omis]);}
}


// child cell rollout backup function
function childRollClear(cn,cmi){
for (rc=0;rc<cI[cn][cmi].length;rc++){
miH(document.layers["childroll"+cn+"-"+cmi+"-"+rc]);
}
}


// child cell rollover function
function childRollOpen(ocn,ocmi,ocoj){
var childrollopen="childroll"+ocn+"-"+ocmi+"-"+ocoj;
miV(document.layers["childroll"+ocn+"-"+ocmi+"-"+ocoj]);
}



// sublink color behaviour
if(saHOVER==""){saHOVER=saLINK;}
var saRoll=saHOVER;


var chTop=new Array;
for (c=0;c<mI.length;c++){

chTop[c]=new Array;
if(free){xp=c;}

sTxt[c]=new Array;
cTxt[c]=new Array;

// find next submenu position
if(!free){
if(c==0){
SUBaL=rL+bSIZE;
}
else SUBaL+=mI[(c-1)][2]+bSIZE;
} else {
SUBaL=aPL[c];
}


// specify edge alignment
var acL=SUBaL+hOFFSET+sP[c][4];
if(sP[c][1]=="right"){
acL=SUBaL-(sP[c][0]-mI[c][2])-hOFFSET-sP[c][4];
}

// top adjust
var tj=0;
if (menuALIGN=="free") { tj=0; }

//voffset unless remote triggering
var layerVOff=vOFFSET+sP[c][3];
if(remoteTRIGGERING){layerVOff=0;}


// drop shadow 
var shb=0;if(shy){shb=(2*shSIZE);}
if(shCOLOR!=""){M+='<layer id="shadow'+c+'" '+bks[6]+' visibility=hide top='+(aP[xp]+thisAH[c]+layerVOff+shSIZE+tj-shb)+' left='+(acL+shSIZE-shb)+' width='+(sP[c][0]+shb)+' height=10>&nbsp;</layer>';}

var gbWidth=sP[c][0];
var gbLeft=acL;
var algbLeft=0;

if(sP[c][1]=="right"){
var gblw=mI[c][7]+bSIZE+aL-sP[c][0]-acL; 
if(gblw>0){gbWidth=sP[c][0]+gblw;}
} else {
var gblw=acL-mI[c][2]-SUBaL;
if(gblw>0){
gbWidth=sP[c][0]+gblw; 
gbLeft-=gblw;
algbLeft=gblw;
}
}


chTop[c][0]=aP[xp]+thisAH[c]+layerVOff;


// compile cells
if(sI[c]!=''){
M+='<layer visibility=hide id="subnav'+c+'" top='+(aP[xp]+thisAH[c]+tj)+' left='+gbLeft+' width='+gbWidth+' onmouseover="rCount=0\;clearTimeout(rTimer)\;">';
M+='<layer top='+layerVOff+' left='+algbLeft+' '+bks[4]+' onload="findLayerHeight('+c+',this.clip.bottom)"><table cellpadding=0 cellspacing='+sbSIZE+' border=0>'; 
for (i=0;i<sI[c].length;i++){

// find wrapping links routine by brendan armstrong
var thisH=snH;
var thisT=sI[c][i][1];
var splitT=thisT.split('<br>');
var Trows=splitT.length;
if (Trows>1) { thisH=(snH*Trows); }

chTop[c][i+1]=chTop[c][i]+thisH+sbSIZE;

M+='<tr><td><table cellpadding=0 cellspacing=0 border=0><tr><td class=SUBmTD height='+thisH+'><ilayer id="subilayer'+c+'-'+i+'" width="'+(sP[c][0]-(sbSIZE*2))+'"><layer onmouseover="rCount=0\; clearTimeout(rTimer)\; cCM('+c+','+i+')\; oCM('+c+','+i+')\; subRollOpen('+c+','+i+')\; this.document.layers[0].visibility=\'show\'" width="'+(sP[c][0]-(2*sbSIZE))+'" height="'+thisH+'" '+bks[3]+' id="subcontainer'+c+'-'+i+'"><layer width="100%" height="100%" visibility=hide><layer id="sublink'+[c]+'-'+[i]+'" left=0 onload="findSubWidths('+c+',this,this.clip.right,this.clip.bottom,'+thisH+')"><div width="100%" height="100%" align='+sP[c][2]+'><a class="translink" href="'+sI[c][i][0]+'" target="'+sI[c][i][2]+'">'+ sI[c][i][1]+'</a></div></layer></layer></layer></ilayer></td></tr></table></td></tr>';
}
M+='</table></layer></layer>';
} else {
M+='<layer visibility=hide id="subnav'+c+'"></layer>';
}



for (sq=0;sq<sI[c].length;sq++){

thisCHtop[c][sq]=new Array;

// find wrapping links routine by brendan armstrong
var thisH=snH;
var thisT=sI[c][sq][1];
var splitT=thisT.split('<br>');
var Trows=splitT.length;
if (Trows>1) { thisH=(snH*Trows); }

cTxt[c][sq]=new Array;
sTxt[sq]='';
if(sI[c][sq][3]!="none"){
if(altDISPLAY=="status"){sTxt[sq]=' onmouseover="return writeStatus(sI['+c+']['+sq+'][3])" onmouseout="return writeStatus(altNull)" ';}
}

// sub rollover layers
M+='<layer visibility=hide '+bks[5]+' id="subroll'+c+'-'+sq+'" top='+(chTop[c][sq]+sbSIZE+tj)+' left='+(acL+sbSIZE) +' width='+(sP[c][0]-(sbSIZE*2))+' height='+thisH+' onmouseover="rCount=0\; clearTimeout(rTimer)\; oCM('+c+','+sq+')\; subRollOpen('+c+','+sq+')" onmouseout="if(!keepSubLIT){subRollClear('+c+')\;miH(this)}">'; 
M+='<layer width="100%" height="100%" '+sTxt[sq]+'><table cellpadding=0 cellspacing=0 border=0 width="100%" height="100%"><tr><td>';
M+='<layer top=0 left=0 onload="findSubWidths('+c+',this,this.clip.right,this.clip.bottom,'+thisH+')"><div width="100%" height="100%" align='+sP[c][2]+'>';
var tcItem='<a class="translink" href="'+sI[c][sq][0]+'" target="'+sI[c][sq][2]+'" '+sTxt[sq]+'>';
if((cellCLICK||(cellCLICK==mu))&&sI[c][sq][2]=="_blank"){tcItem='<a class="translink" href="'+sI[c][sq][0]+'" onclick="activateClick(sI['+c+']['+sq+'][0])\;return false" '+sTxt[sq]+'>';}
M+='<span class=SUBmTD>'+tcItem+'<font color="'+saRoll+'">'+ sI[c][sq][1]+'</font></a></span></div>';
M+='</layer></td></tr></table></layer></layer>';


// default cursor layer for non-link submenu items
if(sI[c][sq][0]=="#"){
M+='<layer visibility=hide id="defaultSubLayer'+c+'-'+sq+'" top='+(chTop[c][sq]+sbSIZE+tj)+' left='+(acL+sbSIZE) +' width='+(sP[c][0]-(sbSIZE*2))+' height='+thisH+' onmouseover="cCM('+c+','+sq+')\; oCM('+c+','+sq+')\; subRollOpen('+c+','+sq+')" onmouseout="if(!keepSubLIT){subRollClear('+c+')}"><layer width="100%" height="100%" '+sTxt[sq]+'></layer></layer>'; 
}


//alert("assemble child menus");

if(cP[c][sq].length>0&&cI[c][sq].length>0){

// specify edge alignment
var chL;
if(cP[c][sq][1]=="right"){
chL=acL-cP[c][sq][0]-chhOFFSET-cP[c][sq][4];
cgL=chL+cP[c][sq][0];
} else {
chL=acL+sP[c][0]+chhOFFSET+cP[c][sq][4];
cgL=(chL-(chhOFFSET+cP[c][sq][4]));
}


// grid block layer for horizontal offset
if((chhOFFSET+cP[c][sq][4])>0){
C+='<layer id="childgrid'+c+'-'+sq+'" visibility=hide top='+((chTop[c][sq]+chvOFFSET)+cP[c][sq][3]+tj)+' left='+cgL+' width='+(chhOFFSET+cP[c][sq][4])+' height='+(((snH+sbSIZE)*cI[c][sq].length)+sbSIZE)+' onmouseover="rCount=0\;clearTimeout(rTimer)\;"></layer>';
}

// child dropshadow
if(shCOLOR!=""){C+='<layer id="childshadow'+c+'-'+sq+'" '+bks[6]+' visibility=hide top='+((chTop[c][sq]+shSIZE+chvOFFSET)+cP[c][sq][3]+tj-shb)+' left='+(chL+shSIZE-shb)+' width='+(cP[c][sq][0]+shb)+' height=10>&nbsp;</layer>';}

// compile cells
C+='<layer visibility=hide id="childnav'+c+'-'+sq+'" top='+((chTop[c][sq]+chvOFFSET)+cP[c][sq][3]+tj)+' left='+chL+'>';
C+='<layer top=0 left=0 '+bks[4]+' onload="findChildHeight('+c+','+sq+',this.clip.bottom)"><table cellpadding=0 cellspacing='+sbSIZE+' border=0>'; 
for (cj=0;cj<cI[c][sq].length;cj++){

// find wrapping links routine by brendan armstrong
var thisH=snH;
var thisT=cI[c][sq][cj][1];
var splitT=thisT.split('<br>');
var Trows=splitT.length;
if (Trows>1) { thisH=(snH*Trows); }

if(cI[c][sq][cj][0]=="#"){cI[c][sq][cj][0]="javascript:doNothing()";}
if(cI[c][sq].length>0){
C+='<tr><td><table cellpadding=0 cellspacing=0 border=0><tr><td class=SUBmTD height='+thisH+'><ilayer id="childilayer'+c+'-'+sq+'-'+cj+'" width="'+(cP[c][sq][0]-(sbSIZE*2))+'"><layer onmouseover="rCount=0\; clearTimeout(rTimer)\; childRollClear('+c+','+sq+')\; if(cI['+c+']['+sq+']['+cj+'][4]){childRollOpen('+c+','+sq+','+cj+')\;}" width="'+(cP[c][sq][0]-(2*sbSIZE))+'" height="'+thisH+'" '+bks[3]+' id="childcontainer'+c+'-'+sq+'-'+cj+'"><layer width="100%" height="100%"><layer left=0 top='+((svPADDING/2)+svtOFFSET)+' onload="findChildWidths('+c+','+sq+',this,this.clip.right,this.clip.bottom,'+thisH+')"><div width="100%" height="100%" align='+cP[c][sq][2]+'><a class="translink" href="'+cI[c][sq][cj][0]+'" target="'+cI[c][sq][cj][2]+'">'+ cI[c][sq][cj][1]+'</a></div></layer></layer></layer></ilayer></td></tr></table></td></tr>';
}
}

C+='</table></layer></layer>';


// child rollover layers

thisCHtop[c][sq][0] = chTop[c][sq]+chvOFFSET+cP[c][sq][3]+sbSIZE+tj;

for (cj=0;cj<cI[c][sq].length;cj++){

cTxt[c][sq][cj]='';
if(cI[c][sq][cj][3]!="none"){
if(altDISPLAY=="status"){cTxt[c][sq][cj]=' onmouseover="return writeStatus(cI['+c+']['+sq+']['+cj+'][3])" onmouseout="return writeStatus(altNull)" ';}
}

if(cI[c][sq].length>0){

// find wrapping links routine by brendan armstrong
var thisH=snH;
var thisT=cI[c][sq][cj][1];
var splitT=thisT.split('<br>');
var Trows=splitT.length;
if (Trows>1) { thisH=(snH*Trows); }

 
C+='<layer visibility=hide '+bks[5]+' id="childroll'+c+'-'+sq+'-'+cj+'" top='+thisCHtop[c][sq][cj]+' left='+(chL+sbSIZE) +' width='+(cP[c][sq][0]-(2*sbSIZE))+' height='+thisH+' onmouseover="rCount=0\; clearTimeout(rTimer)\;" onmouseout="miH(this)">'; 
C+='<layer width="100%" height="100%" '+cTxt[c][sq][cj]+'><layer left=0 top='+((svPADDING/2)+svtOFFSET)+' onload="findChildWidths('+c+','+sq+',this,this.clip.right,this.clip.bottom,'+thisH+')"><div width="100%" height="100%" align='+cP[c][sq][2]+'>';
var tcItem='<a class="translink" href="'+cI[c][sq][cj][0]+'" target="'+cI[c][sq][cj][2]+'" '+cTxt[c][sq][cj]+'>';
if((cellCLICK||(cellCLICK==mu))&&cI[c][sq][cj][2]=="_blank"){tcItem='<a class="translink" href="'+cI[c][sq][cj][0]+'" onclick="activateClick(cI['+c+']['+sq+']['+cj+'][0])\;return false" '+cTxt[c][sq][cj]+'>';}
C+='<span class=SUBmTD>'+tcItem+'<font color="'+saRoll+'">'+ cI[c][sq][cj][1]+'</font></a></span></div>';
C+='</layer></layer></layer>';

}
thisCHtop[c][sq][cj+1]=thisCHtop[c][sq][cj]+thisH+sbSIZE;
}
}
}
}





// draw grid layer
d.write(gSTR);


// draw stretch layer
if(!free){d.write(S);}


// draw main nav 
d.write(T);


// draw submenus
d.write(M);


// draw child menus
d.write(C);



document.close();

// static positining
function moveObject(mobj,tmob) {if (mobj) {mobj.top=eval(window.pageYOffset)+tmob;}}


// static positioning code
var sTimer;
var stCount=0;
var tj=0;if(free){tj=0;}
var shb=0;if(shy){shb=(2*shSIZE);}
function makeStatic(){

if(!free){
moveObject(d.layers["stretchnav"],aP[0]);
moveObject(d.layers["mainnav"],aP[0]); 
moveObject(d.layers["undernav"],aP[0]); 
moveObject(d.layers["gridL"],aP[0]); 
moveObject(d.layers["gridR"],aP[0]); 
}
moveObject(d.layers["grid"],0); 
for(i=0;i<mI.length;i++){
xp=0;if(free){xp=i};
if(free){ moveObject(d.layers["free"+i],aP[xp]); }
moveObject(d.layers["defaultLayer"+i],(aP[xp]+bSIZE)); 
moveObject(d.layers["roll"+i],(aP[xp]+bSIZE)); 
moveObject(d.layers["subnav"+i],(aP[xp]+thisAH[i]+tj));
moveObject(d.layers["shadow"+i],(aP[xp]+thisAH[i]+vOFFSET+sP[i][3]+shSIZE+tj-shb)); 
if(sI[i]){
for(sq=0;sq<sI[i].length;sq++){
moveObject(d.layers["subroll"+i+"-"+sq],(chTop[i][sq]+sbSIZE+tj));
moveObject(d.layers["defaultSubLayer"+i+"-"+sq],(chTop[i][sq]+sbSIZE+tj));
moveObject(d.layers["childnav"+i+"-"+sq],((chTop[i][sq]+chvOFFSET)+cP[i][sq][3]+tj));
moveObject(d.layers["childgrid"+i+"-"+sq],((chTop[i][sq]+chvOFFSET)+cP[i][sq][3]+tj));
moveObject(d.layers["childshadow"+i+"-"+sq],((chTop[i][sq]+shSIZE+chvOFFSET)+cP[i][sq][3]+tj-shb));
if(cI[i][sq]){
for(cj=0;cj<cI[i][sq].length;cj++){
moveObject(d.layers["childroll"+i+"-"+sq+"-"+cj],thisCHtop[i][sq][cj]);
}}}}}
sTimer=setTimeout("makeStatic()",10);
}



// resize / reload trap
function nsinit(){
if(allowRESIZE==true||allowRESIZE==mu){
if (win) { setTimeout("window.onresize=redo", 1000); }
else { window.onresize=redo; }}
// initialise static positioning
if(staticMENU){makeStatic();}}
function redo(){window.location.reload();}
window.onload=genericOnloadFunction;




// go to url
function goToUrl(cUrl,cTarg){
if(cellCLICK||(cellCLICK==mu)){
if(cTarg=="_self"){self.document.location=cUrl;}
else if(cTarg=="_top"){top.document.location=cUrl;}
else if(cTarg=="_parent"){parent.document.location=cUrl;}
else if(cTarg=="_blank"){var newwin=open(cUrl);}
else {if(top.frames[cTarg]){top.frames[cTarg].document.location=cUrl} else {
				//to support iframe
				//document.location=cUrl;
   				document.getElementById(cTarg).src=cUrl;
}}
document.close();}}


// set up and handle menu clearing event
var grL=document.layers["gridL"];
var grR=document.layers["gridR"];
var gr=document.layers["grid"];

gr.onmousedown=new Function("layerDownHandler()");
gr.captureEvents(Event.MOUSEDOWN);
if(document.layers["gridL"]){
grL.onmousedown=new Function("layerDownHandler()");
grL.captureEvents(Event.MOUSEDOWN);}
if(document.layers["gridR"]){
grR .onmousedown=new Function("layerDownHandler()");
grR .captureEvents(Event.MOUSEDOWN);}
function layerDownHandler(){aCM();document.close();}

document.captureEvents(Event.MOUSEUP);
document.onmouseup=layerDownHandler;
	
//add event listener for remote triggering
if(remoteTRIGGERING) { 
	document.captureEvents(Event.MOUSEMOVE); 
	document.onmousemove=menuListen; 
	}
	


// set up and handle cell click events
if(cellCLICK||(cellCLICK==mu)){
for (me=0;me<mI.length;me++){
document.layers["roll"+me].onclick=new Function("findMainUrl("+me+")")
document.layers["roll"+me].captureEvents(Event.CLICK);
for (se=0;se<sI[me].length;se++){
var serollid="subroll"+me+"-"+se;
document.layers["subroll"+me+"-"+se].onclick=new Function("findSubUrl("+me+","+se+")")
document.layers["subroll"+me+"-"+se].captureEvents(Event.CLICK);
for(ce=0;ce<cI[me][se].length;ce++){
document.layers["childroll"+me+"-"+se+"-"+ce].onclick=new Function("findChildUrl("+me+","+se+","+ce+")")
document.layers["childroll"+me+"-"+se+"-"+ce].captureEvents(Event.CLICK);}}}}


// find info from mouse clicks
function findMainUrl(mId){
var mU=mI[mId][0];
var mT=mI[mId][4];
goToUrl(mU,mT);}

function findSubUrl(mId,sId){
var sU=sI[mId][sId][0];
var sT=sI[mId][sId][2];
goToUrl(sU,sT);}

function findChildUrl(mId,sId,cId){
var cU=cI[mId][sId][cId][0];
var cT=cI[mId][sId][cId][2];
goToUrl(cU,cT);}



//listen for mouse events
var doListen=true;
var mtPos=[0,0];
var mtProps,scaroTop,ecX,ecY;
function menuListen(e) {

	if(doListen) { mtPos=[e.pageX+32,e.pageY]; }
	//window.status=mtPos;

	}


//move menu
var snObj,snhObj,mtDiff,shWidth,srObj,srDiff,sclObj,cnObj;
function activateMenu(mmNum) {
	if(typeof sP[mmNum]=="undefined"||!remoteTRIGGERING) { return false; }
	
	//stop listening
	doListen=false;
	
	//store mouse co-ords
	ecX=mtPos[0];
	ecY=mtPos[1]
	
	//reset offsets
	vOFFSET=0;
	hOFFSET=0;
	sP[mmNum][3]=0;
	sP[mmNum][4]=0;
	
	//remotely create menu
	oM(mmNum,false);

	//find scroll position
	scaroTop=window.pageYOffset;

	//set child menus alignment
	for(i=0;i<sI[mmNum].length;i++){
		cP[mmNum][i][1]="left";
		}
	
	//submenu objects
	snObj=document.layers["subnav"+mmNum];
	snhObj=document.layers["shadow"+mmNum]; 
	srDiff=new Array;
	srObj=new Array;
	sclObj=new Array;
	cnObj=new Array;
	for(i=0;i<sI[mmNum].length;i++){
		srObj[i]=document.layers["subroll"+mmNum+"-"+i];
		sclObj[i]=document.layers["defaultSubLayer"+mmNum+"-"+i];
		srDiff[i]=new Array(sbSIZE,srObj[i].pageY-snObj.pageY);
		}
	
	//convert to useful position
	mtProps=[snObj.clip.width,snObj.clip.height];
	if(mtPos[0]>(bW/2)) { 
		mtPos[0]=ecX-64-mtProps[0]; 
		//set child menus alignment
		for(i=0;i<sI[mmNum].length;i++){
			cP[mmNum][i][1]="right";
			}
		
		}
	if((mtPos[1]+mtProps[1]+shSIZE)>bHe) { 
		mtPos[1]=(ecY)-((mtPos[1]+mtProps[1]+shSIZE)-bHe); 
		}
	hOFFSET=mtPos[0];
	vOFFSET=mtPos[1]+scaroTop;
	
	//submenu object positions
	mtDiff=snhObj.pageY-snObj.pageY;
	shWidth=shSIZE;
	if(shy){shWidth=0-shSIZE;}
		
	//move menu
	snObj.left=hOFFSET;
	snObj.top=vOFFSET;
	snhObj.left=hOFFSET+shWidth;
	snhObj.top=vOFFSET+mtDiff;
	for(i=0;i<sI[mmNum].length;i++){
		srObj[i].left=hOFFSET+srDiff[i][0];
		srObj[i].top=vOFFSET+srDiff[i][1];
		if(typeof sclObj[i]!="undefined"){
			sclObj[i].left=hOFFSET+srDiff[i][0];
			sclObj[i].top=vOFFSET+srDiff[i][1];
			}
		}
		
	//start listening
	doListen=true;
	
	return true;
	}


