//UDMv3.4.1.1b



// filter for undefined arrays
for (f=0;f<mI.length;f++){
if(!sP[f]){sP[f]=new Array(mI[f][2],mI[f][3],mI[f][3],0,0);}
if(!cP[f]){cP[f]=new Array;}
if(!sI[f]){sI[f]=new Array;}
if(!cI[f]){cI[f]=new Array;}
for (sf=0;sf<sI[f].length;sf++){
if(!cP[f][sf]){cP[f][sf]=new Array;}
if(!cI[f][sf]){cI[f][sf]=new Array;}
}}

// set undefined or disallowed values
if(absTOP<0){absTOP=0;}
if(absLEFT<0){absLEFT=0;}
if(vPADDING<0){vPADDING=0;}
if(svPADDING<0){svPADDING=0;}
if(aHOVER=="") { aHOVER=aLINK; }
if(saHOVER=="") { saHOVER=saLINK; }
if(aCURSOR=="pointer"){aCURSOR="hand";}

//find colors or images
var tempImg;
var bnk="";
var bk=new Array(mCOLOR,bCOLOR,rCOLOR,smCOLOR,sbCOLOR,srCOLOR,shCOLOR);
var bks=new Array;
var ui=new Array(false,false,false,false,false,false);
if(bk[2]=="") { bk[2]=mCOLOR; }
if(bk[5]=="") { bk[5]=bk[3]; }

for (b=0;b<bk.length;b++){
	if(bk[b]=="") { bk[b]=""; }
	if((bk[b].indexOf('.gif') != -1) || (bk[b].indexOf('.jpg') != -1)){
		ui[b]=true;
		tempImg=bk[b];
		bk[b]=new Image;
		bk[b].src=baseHREF+tempImg;
		bks[b] = 'background-image:url('+bk[b].src+')\;';
		}
	else {
		if(bk[b]=="") { bks[b] = 'background-color:transparent\;';  }
		else { bks[b] = 'background-color:'+bk[b]+'\;';  }
		}
	}
if(ui[2]&&!ui[0]) { bks[0]+='background-image:url('+bnk+')\;'; }
if(ui[0]&&!ui[2]) { bks[2]+='background-image:url('+bnk+')\;'; }
if(ui[5]&&!ui[3]) { bks[3]+='background-image:url('+bnk+')\;'; }
if(ui[3]&&!ui[5]) { bks[5]+='background-image:url('+bnk+')\;'; }



// find the inner height of the browser window
var bHeight=document.body.clientHeight;


//do nothing
function doNothing(){}


//set nav height for backward compatibility
var navH=fSIZE+5+vPADDING;
if (fSIZE<13) { navH+=(13-fSIZE); }
var origH=navH;

// find wrapping links routine by brendan armstrong
var Mrows=new Array;var Nrows=new Array;
for(i=0;i<mI.length;i++){
var thisT=mI[i][1];
var splitT=thisT.split('<br>');
Mrows[i]=splitT.length;
Nrows[i]=Mrows[i];
}
function cFun(a,b) { return b-a; }
Mrows.sort(cFun);
navH=navH*Mrows[0];

var thisNavH=new Array;
for(i=0;i<mI.length;i++){
	if(menuALIGN=="free"){
		thisNavH[i]=origH*Nrows[i];
		}
	else{
		thisNavH[i]=navH;
		}
	}


// find the subnav item height
var subNavH=sfSIZE+5+svPADDING;
if (sfSIZE<13) { subNavH+=(13-sfSIZE); }


// find the inner width of the browser window
var nWidth=document.body.clientWidth;
var bWidth=nWidth;


if(documentWIDTH>0) { bWidth = documentWIDTH; }


//calculate nav width
var endSpace=0;
var navSpace=0;
for (j=0;j<mI.length;j++){
	if(mI[j][2]==""){mI[j][2]=10;}
	if(mI[j][1]==""){mI[j][1]='&nbsp;';}
	navSpace+=mI[j][2]+bSIZE;
	}
navSpace+=bSIZE;
endSpace=bWidth-navSpace;



//set values for different alignments
var ra=false;
if(menuALIGN=="right"){
ra=true;
absLEFT=endSpace-absLEFT;
}

var ca=false;
if(menuALIGN=="center"){
ca=true;
absLEFT=endSpace / 2;
}

var la=false;
if(menuALIGN=="left"){
la=true;
}


//if(navSpace>bWidth&&menuALIGN!="free") { absLEFT=0; }

var allready=false;

var currentID = [-1,-1,-1];
var previousID = [-1,-1,-1];
var cTimer;
var closeOkay=false;
var fid=0;
var smObj = new Array;
var sminObj = new Array;
var cmObj=new Array;
var cminObj=new Array;
var cshObj=new Array;
var smLeft=new Array;
var smTop=new Array;
var inTop=new Array;
var inLeft=new Array;
var smTopPad=new Array;
var smLeftPad=new Array;
var movedCM=new Array;
var shInc=new Array;
var chInc=new Array;

var mwPad=0;
var xwPad=0;
if(ie5){
	mwPad=2*bSIZE;
	xwPad=2*sbSIZE;
	}


//variables
var tInfo,titleText,master,nav,grid,pObj,nObj,ncObj,nctObj,ncoObj,ncotObj,sObj,snObj,scObj,cObj,cnObj,ccObj,sNode,temSNode,temCNode,shObj,sLeft,slMargin,srMargin,sTop,stMargin,mSize,mNumOf,cNode,cshObj,cLeft,clMargin,crMargin,cTop,ctMargin,cmSize,cNumOf;

//show grid
var grs;
function showGrid() {
	grs=grid.style.visibility;
	if(grs=="hidden"){
		grid.style.visibility="visible";
		//hide select boxes
		if(hideSELECT){hideSelects();}
		}
	}
//hide grid
function hideGrid() {
	grs=grid.style.visibility;
	if(grs=="visible"){
		grid.style.visibility="hidden";
		//show select boxes
		if(hideSELECT){showSelects();}
		}
	}


// write status message
function writeStatus(sTxt){
	window.status=sTxt;
	return true;
	}



// actually clear submenus
function clearSubMenus() {

	if(menuALIGN!="free"){nav.style.zIndex=zORDER+2;}

	if(currentID[0]>-1) {
		for(i=0;i<mI.length;i++){
			ncObj = document.all["maincell-"+i];
			ncObj.style.zIndex = zORDER+3;

			if(smObj[i]) {
				smObj[i].style.visibility="hidden";
				if(sI[i].length>0){
					for(j=0;j<sI[i].length;j++){
						if(cmObj[i][j]) {
							cminObj[i][j].innerHTML='udm';
							cmObj[i][j].style.visibility="hidden";
							}
						}
					}
				}
			}
		ncObj = document.all["maincell-"+currentID[0]];
		if(typeof ncObj != "undefined") {
			if(ui[2]) {
				if(ui[0]) { ncObj.style.backgroundImage = 'url('+bk[0].src+')'; }
				else { ncObj.style.backgroundImage = 'url('+bnk+')'; }
				}
			else {
				if(ui[0]) { ncObj.style.backgroundImage = 'url('+bk[0].src+')'; }
				else { ncObj.style.backgroundColor = bk[0]; }
				}
			nctObj = document.all["mainlinktext-"+currentID[0]];
			nctObj.style.color = aLINK;
			}

		//clearChildMenus();
		}

	writeStatus('');

	currentID = [-1,-1,-1];

	hideGrid();
	clearTimeout(cTimer);
	closeOkay=false;

	}


// start clear menus from grid
function gridClearMenus() {

	if(closeOkay) {
		clearTimeout(cTimer);
		clearSubMenus();
		}
	else {
		closeOkay=true;
		cTimer=setTimeout("gridClearMenus()",closeTIMER);
		}

	}


//clear main rollover
function clearMainRollover(keepObj) {

	if(previousID.length) {
		if(previousID[0]>-1) {

			if(!keepObj&&smObj[previousID[0]]) {
					sminObj[previousID[0]].innerHTML='udm';
					smObj[previousID[0]].style.visibility="hidden";

					if(cmObj[previousID[0]][previousID[1]]) {
							cminObj[previousID[0]][previousID[1]].innerHTML='udm';
							cmObj[previousID[0]][previousID[1]].style.visibility="hidden";
							}

					}

			ncoObj = document.all["maincell-"+previousID[0]];
			if(ui[2]) {
				ncoObj.style.backgroundImage = 'url('+bk[0].src+')';
				}
			else {
				ncoObj.style.backgroundImage = 'url('+bnk+')';
				ncoObj.style.backgroundColor = bk[0];
				}
			ncotObj = document.all["mainlinktext-"+previousID[0]];
			ncotObj.style.color = aLINK;
			}
		}

	}


//main cell rollover
function mainRollover(rmNum) {

	clearMainRollover();

	if(menuALIGN!="free"){nav.style.zIndex=zORDER+19;}

	for(i=0;i<mI.length;i++){
		ncObj = document.all["maincell-"+i];
		ncObj.style.zIndex = zORDER+20;
		}
	ncObj = document.all["maincell-"+rmNum];

	if(ui[2]) {
		ncObj.style.backgroundImage = 'url('+bk[2].src+')';
		}
	else {
		ncObj.style.backgroundImage = 'url('+bnk+')';
		ncObj.style.backgroundColor = bk[2];
		}

	nctObj = document.all["mainlinktext-"+rmNum];
	nctObj.style.color = aHOVER;

	if(altDISPLAY=="status") {
		writeStatus(mI[rmNum][5]);
		}
	else {
		tInfo=mI[rmNum][0];
		if(tInfo=="#") { tInfo = ""; }
		writeStatus(tInfo);
		}

	}




//main cell events
function mainCell(mNum,gridTrue) {

	if(typeof mI[mNum]=="undefined") { return false; }

	if(!allready) { return false; }

	clearTimeout(cTimer);
	closeOkay=false;

	currentID = [mNum,-1,-1];

	mainRollover(mNum);

	previousID = currentID;

	if(sI[mNum].length>0) { openSubMenu(mNum); }

	if(typeof gridTrue=="undefined") { showGrid(); }
	}


//clear submenu rollover
var sctObj,scoObj,scotObj;
function clearSubRollover(keepObj) {

	if(previousID.length) {
		if(previousID[1]>-1) {

			if(!keepObj&&cmObj[previousID[0]][previousID[1]]) {
					cminObj[previousID[0]][previousID[1]].innerHTML='udm';
					cmObj[previousID[0]][previousID[1]].style.visibility="hidden";
					}

			scoObj = document.all['subcell-'+previousID[0]+'-'+previousID[1]];
			if(ui[5]) {
				scoObj.style.backgroundImage = 'url('+bk[3].src+')';
				}
			else {
				scoObj.style.backgroundImage = 'url('+bnk+')';
				scoObj.style.backgroundColor = bk[3];
				}
			scotObj = document.all['subtext-'+previousID[0]+'-'+previousID[1]];
			scotObj.style.color = saLINK;
			}
		}

	}

//submenu rollover
function subRollover(rmNum,rsNum) {

	clearSubRollover();

	if(sI[rmNum][rsNum][4]){
		if(ui[5]) {
			scObj.style.backgroundImage = 'url('+bk[5].src+')';
			}
		else {
			scObj.style.backgroundImage = 'url('+bnk+')';
			scObj.style.backgroundColor = bk[5];
			}
		}

	sctObj = document.all['subtext-'+rmNum+'-'+rsNum];
	sctObj.style.color = saHOVER;

	if(altDISPLAY=="status") {
		writeStatus(sI[rmNum][rsNum][3]);
		}
	else {
		tInfo=sI[rmNum][rsNum][0];
		if(tInfo=="#") { tInfo = ""; }
		writeStatus(tInfo);
		}

	}


//submenu cell events
var cn,ctObj;
function subCell(mNum,sNum) {

	clearTimeout(cTimer);
	closeOkay=false;

	currentID = [mNum,sNum,-1];

	scObj = document.all['subcell-'+mNum+'-'+sNum];

	subRollover(mNum,sNum);

	previousID = currentID;

	if(!keepLIT) { clearMainRollover(true); }

	openChildMenu(mNum,sNum);

	showGrid();
	}



//clear childmenu rollover
var cctObj,ccoObj,ccotObj;
function clearChildRollover() {

	if(previousID.length) {
		if(previousID[2]>-1) {

			ccoObj = document.all['childcell-'+previousID[0]+'-'+previousID[1]+'-'+previousID[2]];
			if(ui[5]) {
				ccoObj.style.backgroundImage = 'url('+bk[3].src+')';
				}
			else {
				ccoObj.style.backgroundImage = 'url('+bnk+')';
				ccoObj.style.backgroundColor = bk[3];
				}
			ccotObj = document.all['childtext-'+previousID[0]+'-'+previousID[1]+'-'+previousID[2]];
			ccotObj.style.color = saLINK;
			}
		}

	}



//childmenu rollover
var ccObj,cctObj;
function childRollover(rmNum,rsNum,rcNum) {

	clearChildRollover();

	if(cI[rmNum][rsNum][rcNum][4]){
		if(ui[5]) {
			ccObj.style.backgroundImage = 'url('+bk[5].src+')';
			}
		else {
			ccObj.style.backgroundImage = 'url('+bnk+')';
			ccObj.style.backgroundColor = bk[5];
			}
		}

	cctObj = document.all['childtext-'+rmNum+'-'+rsNum+'-'+rcNum];
	cctObj.style.color = saHOVER;

	if(altDISPLAY=="status") {
		writeStatus(cI[rmNum][rsNum][rcNum][3]);
		}
	else {
		tInfo=cI[rmNum][rsNum][rcNum][0];
		if(tInfo=="#") { tInfo = ""; }
		writeStatus(tInfo);
		}

	}



//child menu cell events
function childCell(mNum,sNum,cNum){

	clearTimeout(cTimer);
	closeOkay=false;

	currentID = [mNum,sNum,cNum];

	ccObj = document.all['childcell-'+mNum+'-'+sNum+'-'+cNum];

	childRollover(mNum,sNum,cNum);

	previousID = currentID;

	if(!keepSubLIT) { clearSubRollover(true); }

	showGrid();
	}



// td click handlers
var wins = new Array;
var wNum = 0;
function goToUrl(cUrl,cTarg){
	if(cUrl=="~"){return false;}
	if(cUrl.indexOf("mailto:")!=-1){ document.location=cUrl; }
	else if(cUrl!=""){
		if(cTarg=="_self"){self.document.location=cUrl;}
		else if(cTarg=="_top"){top.document.location=cUrl;}
		else if(cTarg=="_parent"){parent.document.location=cUrl;}
		else if(cTarg=="_blank"){
			wins[wNum]=open(cUrl,"","status=yes,scrollbars=yes,scrolling=yes,toolbar=yes,menubar=yes,location=yes,resizable=yes");
			wNum++;
			}
		else {
			if(top[cTarg]){top[cTarg].document.location=cUrl}
			else {
				//to support iframe
				//document.location=cUrl;
   				document.getElementById(cTarg).src=cUrl;
			}
		}
	}
}

//convert shadow type
var shy=0;
var shPad=0;
if(typeof shSIZE == "number") {
	if(shSIZE<0){shSIZE=0;}
	shy=shSIZE;
	shSIZE=(0-shSIZE);
	shPad=0;
	}
if(typeof shSIZE == "string") {
	shSIZE=parseInt(shSIZE);
	shy=(0-shSIZE);
	shPad=(2*shSIZE);
	}


//open submenu
var tsm,smh,shAry,txi,txv;
var cellTopPad,sshHeight;
function openSubMenu(mid) {

	if(smObj[mid]){

		tsm=sminObj[mid].innerHTML;
		//if is not already been written
		if(tsm=="udm"){
			smh='';
			sshHeight=sbSIZE;

			shAry = new Array;
			smh+='<table cellpadding=0 cellspacing='+sbSIZE+' border=0 style="width:'+(sP[mid][0]+xwPad)+'px\;'+bks[4]+'">';
			for(i=0;i<sI[mid].length;i++){

				clcu = '';
				if(cellCLICK&&sI[mid][i][0]!=""&&sI[mid][i][0]!="#"&&sI[mid][i][0]!="~") { clcu = ' cursor:'+aCURSOR+'\;'; }
				cllu=' cursor:default\;';
				if(sI[mid][i][0]!=""&&sI[mid][i][0]!="#"&&sI[mid][i][0]!="~") { cllu = ' cursor:'+aCURSOR+'\;'; }

				// find wrapping links routine by brendan armstrong
				shAry[i]=subNavH;
				var thisT=sI[mid][i][1];
				var splitT=thisT.split('<br>');
				var Trows=splitT.length;
				if (Trows>1) { shAry[i]=(subNavH*Trows)-(svPADDING*(Trows-1)); }

				titleText=""; if(altDISPLAY=="title") { titleText = sI[mid][i][3]; }

				txi='';
				if(sP[mid][2]=="left"){txi='margin-left:'+stINDENT+'px';}
				if(sP[mid][2]=="right"){txi='margin-right:'+stINDENT+'px';}
				txv='';
				if(svtOFFSET>0) { txv='margin-top:'+svtOFFSET+'px'; }
				if(svtOFFSET<0) { txv='margin-bottom:'+(0-svtOFFSET)+'px'; }
				
				if(ie4){
					smh+='<tr><td style="'+clcu+'"><table cellpadding=0 cellspacing=0 border=0 width="100%" title="'+titleText+'" class=SUBmTD onmouseover="subCell('+mid+','+i+')" onclick="if(cellCLICK){goToUrl(sI['+mid+']['+i+'][0],sI['+mid+']['+i+'][2])}" id="subcell-'+mid+'-'+i+'" style="height:'+shAry[i]+'px\;'+bks[3]+'"><tr><td align="'+sP[mid][2]+'"><div style="'+txi+'\;'+txv+'"><a id="subtext-'+mid+'-'+i+'" style="background-color:transparent\;text-decoration:'+saDEC+'\;'+cllu+'font-family:'+sfFONT+'\;font-size:'+sfSIZE+'\;color:'+saLINK+'\;" onclick="if(!cellCLICK){goToUrl(sI['+mid+']['+i+'][0],sI['+mid+']['+i+'][2])}">'+sI[mid][i][1]+'</a></div></td></tr></table></td></tr>';
					}
				else{
					if(i==0){cellTopPad=sbSIZE;}
					else{cellTopPad+=shAry[(i-1)]+sbSIZE;}
					smh+='<tr><td style="'+clcu+'position:absolute;top:'+cellTopPad+';"><div title="'+titleText+'" class=SUBmTD onmouseover="subCell('+mid+','+i+')" onclick="if(cellCLICK){goToUrl(sI['+mid+']['+i+'][0],sI['+mid+']['+i+'][2])}" id="subcell-'+mid+'-'+i+'" style="height:'+shAry[i]+'px;width:'+sP[mid][0]+'px;'+bks[3]+'" align="'+sP[mid][2]+'"><div style="position:relative;top:'+((svPADDING/2)+svtOFFSET)+'px\;'+txi+'\;"><a id="subtext-'+mid+'-'+i+'" style="background-color:transparent\;text-decoration:'+saDEC+'\;'+cllu+'font-family:'+sfFONT+'\;font-size:'+sfSIZE+'\;color:'+saLINK+'\;" onclick="if(!cellCLICK){goToUrl(sI['+mid+']['+i+'][0],sI['+mid+']['+i+'][2])}">'+sI[mid][i][1]+'</a></div></div></td></tr>';
					}
				
				sshHeight+=shAry[i]+sbSIZE;
				}
			smh+='</table>';

			sminObj[mid].innerHTML=smh;
			
			//increase dropshadow height for mac/ie5
			if(!shInc[mid]&&ie5) {
				sshObj[mid].style.height = sshHeight+shPad;
				shInc[mid]=true;
				}			
			
			
			//increase enclosing dropshadow height
			if(!shInc[mid]&&shPad>0) {
					sshObj[mid].style.height = sshObj[mid].offsetHeight+shPad;
					shInc[mid]=true;
					}


			}

		//show menu
		smObj[mid].style.visibility="visible";
		}

	}




//open submenu
var csm,cmh,chAry,cxi,cxv,scObjLeft,scObjTop,cmStyle,chAry,cshHeight;
function openChildMenu(mid,cid) {

	if(cmObj[mid][cid]){

		csm=cminObj[mid][cid].innerHTML;

		//if is not already been written
		if(csm=="udm"){
		
			cshHeight=sbSIZE;

			if(!movedCM[mid][cid]){

				cmStyle=cmObj[mid][cid].style;

				scObjLeft = smLeft[mid]+inLeft[mid]+shy+shSIZE;
				scObjTop = smTop[mid]+inTop[mid]+shy+shSIZE;

				if(cP[mid][cid][1]=="left") { scObjLeft+=sP[mid][0]; }
				if(cP[mid][cid][1]=="right") { scObjLeft-=cP[mid][cid][0]; }

				if(win) { scObjTop += scObj.offsetParent.offsetParent.offsetTop; }
				if(mac) { 
					for(i=0;i<cid;i++){
						scObjTop += shAry[i]+sbSIZE; 
						}
					}

				cmStyle.left=parseInt(cmStyle.left)+scObjLeft;
				cmStyle.top=parseInt(cmStyle.top)+scObjTop;


				movedCM[mid][cid]=true;
				}

			cmh='';
			chAry = new Array;
			cmh+='<table cellpadding=0 cellspacing='+sbSIZE+' border=0 style="width:'+(cP[mid][cid][0]+xwPad)+'px\;'+bks[4]+'">';
			for(i=0;i<cI[mid][cid].length;i++){

				clcu = '';
				if(cellCLICK&&cI[mid][cid][i][0]!=""&&cI[mid][cid][i][0]!="#"&&cI[mid][cid][i][0]!="~") { clcu = ' cursor:'+aCURSOR+'\;'; }
				cllu=' cursor:default\;';
				if(cI[mid][cid][i][0]!=""&&cI[mid][cid][i][0]!="#"&&cI[mid][cid][i][0]!="~") { cllu = ' cursor:'+aCURSOR+'\;'; }

				// find wrapping links routine by brendan armstrong
				chAry[i]=subNavH;
				var thisT=cI[mid][cid][i][1];
				var splitT=thisT.split('<br>');
				var Trows=splitT.length;
				if (Trows>1) { chAry[i]=(subNavH*Trows)-(svPADDING*(Trows-1)); }

				titleText=""; if(altDISPLAY=="title") { titleText = cI[mid][cid][i][3]; }

				cxi='';
				if(cP[mid][cid][2]=="left"){cxi='margin-left:'+stINDENT+'px';}
				if(cP[mid][cid][2]=="right"){cxi='margin-right:'+stINDENT+'px';}
				cxv='';
				if(svtOFFSET>0) { cxv='margin-top:'+svtOFFSET+'px'; }
				if(svtOFFSET<0) { cxv='margin-bottom:'+(0-svtOFFSET)+'px'; }
				
				if(ie4){
					cmh+='';
					cmh+='<tr><td style="'+clcu+'"><table cellpadding=0 cellspacing=0 border=0 width="100%" title="'+titleText+'" class=SUBmTD onmouseover="childCell('+mid+','+cid+','+i+')" onclick="if(cellCLICK){goToUrl(cI['+mid+']['+cid+']['+i+'][0],cI['+mid+']['+cid+']['+i+'][2])}" id="childcell-'+mid+'-'+cid+'-'+i+'" style="height:'+chAry[i]+'px\;'+bks[3]+'"><tr><td align="'+cP[mid][cid][2]+'"><div style="'+cxi+'\;'+cxv+'"><a id="childtext-'+mid+'-'+cid+'-'+i+'" style="background-color:transparent\;text-decoration:'+saDEC+'\;'+cllu+'font-family:'+sfFONT+'\;font-size:'+sfSIZE+'\;color:'+saLINK+'\;" onclick="if(!cellCLICK){goToUrl(cI['+mid+']['+cid+']['+i+'][0],cI['+mid+']['+cid+']['+i+'][2])}">'+cI[mid][cid][i][1]+'</a></div></td></tr></table></td></tr>';
					}
				else{
					if(i==0){cellTopPad=sbSIZE;}
					else{cellTopPad+=chAry[(i-1)]+sbSIZE;}
					cmh+='<tr><td style="'+clcu+'position:absolute;top:'+cellTopPad+';"><div title="'+titleText+'" class=SUBmTD onmouseover="childCell('+mid+','+cid+','+i+')" onclick="if(cellCLICK){goToUrl(cI['+mid+']['+cid+']['+i+'][0],cI['+mid+']['+cid+']['+i+'][2])}" id="childcell-'+mid+'-'+cid+'-'+i+'" style="height:'+chAry[i]+'px;width:'+cP[mid][cid][0]+'px;'+bks[3]+'" align="'+cP[mid][cid][2]+'"><div style="position:relative;top:'+((svPADDING/2)+svtOFFSET)+'px\;'+cxi+'\;"><a id="childtext-'+mid+'-'+cid+'-'+i+'" style="background-color:transparent\;text-decoration:'+saDEC+'\;'+cllu+'font-family:'+sfFONT+'\;font-size:'+sfSIZE+'\;color:'+saLINK+'\;" onclick="if(!cellCLICK){goToUrl(cI['+mid+']['+cid+']['+i+'][0],cI['+mid+']['+cid+']['+i+'][2])}">'+cI[mid][cid][i][1]+'</a></div></div></td></tr>';
					}
				
				cshHeight+=chAry[i]+sbSIZE;
				}
			cmh+='</table>';


			cminObj[mid][cid].innerHTML=cmh;

			//increase dropshadow height for mac/ie5
			if(!chInc[mid][cid]&&ie5) {
				cshObj[mid][cid].style.height = cshHeight+shPad;
				chInc[mid][cid]=true;
				}			

			//increase enclosing dropshadow height
			if(!chInc[mid][cid]&&shPad>0) {
					cshObj[mid][cid].style.height = cshObj[mid][cid].offsetHeight+shPad;
					chInc[mid][cid]=true;
					}

			//show menu
			cmObj[mid][cid].style.visibility="visible";
			}
		}
	}




var mn='';

// event handling grid

var grw = bWidth;
if(gridWIDTH>0) { grw = gridWIDTH; }
var grh = bHeight;
if(gridHEIGHT>0) { grh = gridHEIGHT; }

var grCol='';
if(redGRID){grCol = 'background-color:red';}

mn+='<div id="udm-grid" onmouseover="gridClearMenus()" style="cursor:default\;'+grCol+'\;visibility:hidden\;position:absolute\;top:0px\;left:0px\;z-index:'+(zORDER+10)+'\;width:'+grw+'px\;height:'+grh+'px\;">&nbsp;</div>';


// main navbar
var mbc = bks[1];
var mcbc = bks[0];
var clcu,cllu,mtObj,mcLeft,strCol;

var mnDisplay='';
if(remoteTRIGGERING) { mnDisplay='display:none'; }

if(menuALIGN!="free") {

	//undernav if !free alignment
	strCol=bks[0];
	if(showBORDERS) { strCol=bks[1]; }
	if(stretchMENU||showBORDERS) {
		mn+='<div id="underb" style="'+mnDisplay+'\;cursor:default\;'+strCol+'visibility:visible\;position:absolute\;z-index:'+(zORDER+0)+'\;left:0px\;top:'+absTOP+'px\;width:'+bWidth+'px\;height:'+(navH+(2*bSIZE))+'px\;">';
		if(stretchMENU&&showBORDERS) { mn+='<div style="margin:'+bSIZE+'px\;width:'+(bWidth-(2*bSIZE))+'px\;height:'+navH+'px\;'+bks[0]+'cursor:default">&nbsp;</div>'; }
		mn+='</div>';
		}

	mn+='<div id="udm-navbar" style="'+mnDisplay+'\;'+bks[1]+'position:absolute\;z-index:'+(zORDER+2)+'\;left:'+absLEFT+'px\;top:'+absTOP+'\;width:'+navSpace+'px\;height:'+(navH+(2*bSIZE))+'px\;" class=mTD></div>';
	mcLeft=absLEFT+bSIZE;


	//navbar if !free alignment
	for(i=0;i<mI.length;i++){
		clcu = '';
		if(cellCLICK&&mI[i][0]!=""&&mI[i][0]!="#"&&mI[i][0]!="~") { clcu = ' cursor:'+aCURSOR+'\;'; }
		cllu=' cursor:default\;';
		if(mI[i][0]!=""&&mI[i][0]!="#"&&mI[i][0]!="~") { cllu = ' cursor:'+aCURSOR+'\;'; }
		titleText=""; if(altDISPLAY=="title") { titleText = mI[i][5]; }
		if(ie4){mn+='<div title="'+titleText+'" id="maincell-'+i+'" style="'+mnDisplay+'\;z-index:'+(zORDER+3)+'\;visibility:hidden\;position:absolute\;top:'+(absTOP+bSIZE)+'px\;left:'+mcLeft+'px\;'+clcu+mcbc+'width:'+mI[i][2]+'px\;height:'+thisNavH[i]+'px\;"><table cellpadding=0 cellspacing=0 border=0 id="maintext-'+i+'" style="width:'+mI[i][2]+'px\;height:'+thisNavH[i]+'px\;'+cllu+'position:relative"><tr><td class=mTD align='+mI[i][3]+' onmouseover="mainCell('+i+')" onclick="goToUrl(mI['+i+'][0],mI['+i+'][4],['+i+'])"><a style="background-color:transparent\;text-decoration:'+aDEC+';color:'+aLINK+'" id="mainlinktext-'+i+'" onclick="if(!cellCLICK){goToUrl(mI['+i+'][0],mI['+i+'][4])}">'+mI[i][1]+'</a></td></tr></table></div>';}
		else{mn+='<div title="'+titleText+'" id="maincell-'+i+'" style="'+mnDisplay+'\;z-index:'+(zORDER+3)+'\;visibility:hidden\;position:absolute\;top:'+(absTOP+bSIZE)+'px\;left:'+mcLeft+'px\;'+clcu+mcbc+'width:'+mI[i][2]+'px\;height:'+thisNavH[i]+'px\;"><table cellpadding=0 cellspacing=0 border=0 style="width:'+mI[i][2]+'px\;height:'+thisNavH[i]+'px\;'+cllu+'"><tr><td class=mTD align='+mI[i][3]+' onmouseover="mainCell('+i+')" onclick="goToUrl(mI['+i+'][0],mI['+i+'][4],['+i+'])"><span id="maintext-'+i+'" style="position:relative"><a style="background-color:transparent\;text-decoration:'+aDEC+';color:'+aLINK+'" id="mainlinktext-'+i+'" onclick="if(!cellCLICK){goToUrl(mI['+i+'][0],mI['+i+'][4])}">'+mI[i][1]+'</a></span></td></tr></table></div>';}
		mcLeft+=bSIZE+mI[i][2];
		}

	}

if(menuALIGN=="free") {

	//navbar if free alignment
	for(i=0;i<mI.length;i++){
		clcu = '';
		if(cellCLICK&&mI[i][0]!=""&&mI[i][0]!="#"&&mI[i][0]!="~") { clcu = ' cursor:'+aCURSOR+'\;'; }
		cllu=' cursor:default\;';
		if(mI[i][0]!=""&&mI[i][0]!="#"&&mI[i][0]!="~") { cllu = ' cursor:'+aCURSOR+'\;'; }
		mn+='<div style="'+bks[1]+'z-index:'+(zORDER+2)+'\;position:absolute\;left:'+(absLEFT+mI[i][7])+'px\;top:'+(absTOP+mI[i][6])+'px\;width:'+(mI[i][2]+(2*bSIZE))+'px\;height:'+(thisNavH[i]+(2*bSIZE))+'\px"></div>';
		titleText=""; if(altDISPLAY=="title") { titleText = mI[i][5]; }
		if(ie4){mn+='<div title="'+titleText+'" id="maincell-'+i+'" style="'+mnDisplay+'\;z-index:'+(zORDER+3)+'\;position:absolute\;left:'+(absLEFT+mI[i][7]+bSIZE)+'px\;top:'+(absTOP+mI[i][6]+bSIZE)+'px\;visibility:hidden\;'+clcu+mcbc+'width:'+mI[i][2]+'px\;height:'+thisNavH[i]+'px\;"><table cellpadding=0 cellspacing=0 border=0 id="maintext-'+i+'" style="width:'+mI[i][2]+'px\;height:'+thisNavH[i]+'px\;'+cllu+'position:relative"><tr><td class=mTD align='+mI[i][3]+' onmouseover="mainCell('+i+')" onclick="goToUrl(mI['+i+'][0],mI['+i+'][4],['+i+'])"><a style="background-color:transparent\;text-decoration:'+aDEC+';color:'+aLINK+'" id="mainlinktext-'+i+'" onclick="if(!cellCLICK){goToUrl(mI['+i+'][0],mI['+i+'][4])}">'+mI[i][1]+'</a></td></tr></table></div>';}
		else{mn+='<div title="'+titleText+'" id="maincell-'+i+'" style="'+mnDisplay+'\;z-index:'+(zORDER+3)+'\;position:absolute\;left:'+(absLEFT+mI[i][7]+bSIZE)+'px\;top:'+(absTOP+mI[i][6]+bSIZE)+'px\;visibility:hidden\;'+clcu+mcbc+'width:'+mI[i][2]+'px\;height:'+thisNavH[i]+'px\;"><table cellpadding=0 cellspacing=0 border=0 style="width:'+mI[i][2]+'px\;height:'+thisNavH[i]+'px\;'+cllu+'"><tr><td class=mTD align='+mI[i][3]+' onmouseover="mainCell('+i+')" onclick="goToUrl(mI['+i+'][0],mI['+i+'][4],['+i+'])"><span id="maintext-'+i+'" style="position:relative"><a style="background-color:transparent\;text-decoration:'+aDEC+';color:'+aLINK+'" id="mainlinktext-'+i+'" onclick="if(!cellCLICK){goToUrl(mI['+i+'][0],mI['+i+'][4])}">'+mI[i][1]+'</a></span></td></tr></table></div>';}
		mcLeft+=bSIZE+mI[i][2];
		}

	}



//write navbar
document.write(mn);

//position text layers
for(i=0;i<mI.length;i++){
	mtObj=document.all["maintext-"+i];
	if(mtObj){
		mtObj.style.top = vtOFFSET;
		if(mI[i][3]=="left") { mtObj.style.left = tINDENT; }
		if(mI[i][3]=="right") { mtObj.style.left = 0-tINDENT; }
		document.all["maincell-"+i].style.visibility="visible";
		}
	}

//store some objects
master = document.all["master"];
nav = document.all["udm-navbar"];
grid = document.all["udm-grid"];
var mainCells = new Array;
for(i=0;i<mI.length;i++){
	mainCells[i] = document.all["maincell-"+i];
	}





//draw empty submenu objects
var smStyle,conHeight;
var sn='';
for(i=0;i<mI.length;i++){

	shInc[i]=false;

	if(sI[i].length>0) {

		smTopPad[i] = vOFFSET+sP[i][3];
		smLeftPad[i] = hOFFSET+sP[i][4];

		smStyle=mainCells[i].style;
		smLeft[i]=parseInt(mainCells[i].style.left);
		if(sP[i][1]=="right") {
			smLeft[i]=parseInt(mainCells[i].style.left)-sP[i][0]+mI[i][2];
			}
		smTop[i]=parseInt(smStyle.top)+parseInt(smStyle.height)+bSIZE;

		inLeft[i]=0;
		inTop[i]=0;

		if(smTopPad[i]<0) {
			inTop[i]=0;
			smTop[i]+=smTopPad[i];

			if(smLeftPad[i]<=mI[i][2]) {
					if(sP[i][1]=="left") { smLeft[i]+=smLeftPad[i]; }
					else { smLeft[i]-=smLeftPad[i]; }
					}
			else {
					if(sP[i][1]=="left") { smLeft[i]+=mI[i][2]; inLeft[i]=smLeftPad[i]-mI[i][2]; }
					else { smLeft[i]-=mI[i][2]; inLeft[i]=0-(smLeftPad[i]-mI[i][2]);  }
					}
			}
		else {
			inTop[i]=smTopPad[i];

			inLeft[i]=smLeftPad[i];
			if(sP[i][1]=="right") { inLeft[i]=0-inLeft[i]; }
			}
			
		conHeight='';
		if(ie4){conHeight='height:1px\;';}

		sn+='<div id="submenu-'+i+'" style="position:absolute\;left:'+smLeft[i]+'px\;top:'+smTop[i]+'px\;width:'+(sP[i][0]+xwPad)+'px\;'+conHeight+'z-index:'+(zORDER+40+i)+'\;visibility:hidden">';
		sn+='<div id="subshadow-'+i+'" style="width:'+(sP[i][0]+xwPad+shPad)+'px\;height:1px\;position:relative\;left:'+(inLeft[i]+shy)+'px\;top:'+(inTop[i]+shy)+'px\;'+bks[6]+'">';

		sn+='<div id="subcontent-'+i+'" style="position:relative\;left:'+shSIZE+'px\;top:'+shSIZE+'px\;width:'+(sP[i][0]+xwPad)+'px\;height:1px\;">udm</div>';

		sn+='</div>';
		sn+='</div>';
		}

	}
document.write(sn);

//store objects
var sshObj=new Array;
for(i=0;i<mI.length;i++){

	if(sI[i].length>0) {
		smObj[i]=document.all["submenu-"+i];
		sminObj[i]=document.all["subcontent-"+i];
		sshObj[i]=document.all["subshadow-"+i];
		}

	}



//draw empty child menu objects
var cmLeft,cmTop,cmStyle,cinTop,cinLeft;
var cmTopPad,cmLeftPad;
var cn='';
for(i=0;i<mI.length;i++){

	movedCM[i]=new Array;
	chInc[i]=new Array;

	if(sI[i].length>0) {

		for(j=0;j<sI[i].length;j++) {

			movedCM[i][j]=false;
			chInc[i][j]=false;

			if(cI[i][j].length>0) {

				cmTopPad = chvOFFSET+cP[i][j][3];
				cmLeftPad= chhOFFSET+cP[i][j][4];

				cmLeft=0;
				cinLeft=0;

				if(cmTopPad<0) {
					cmTop=cmTopPad;
					cinTop=0;
					}
				else {
					cmTop=0;
					cinTop=cmTopPad;
					}

				if(cP[i][j][1]=="left"){
					if(cmLeftPad<0) { cmLeft=cmLeftPad; }
					else { cinLeft=cmLeftPad; }
					}
				else {
					if(cmLeftPad<0) { cmLeft=0-cmLeftPad; }
					else { cinLeft=0-cmLeftPad; }
					}

				conHeight='';
				if(ie4){conHeight='height:1px\;';}

				cn+='<div id="childmenu-'+i+'-'+j+'" style="position:absolute\;left:'+cmLeft+'px\;top:'+cmTop+'px\;width:'+(cP[i][j][0]+xwPad)+'px\;'+conHeight+'z-index:'+(zORDER+60+sI[i].length+j)+'\;visibility:hidden">';
				cn+='<div id="childshadow-'+i+'-'+j+'" style="width:'+(cP[i][j][0]+xwPad+shPad)+'px\;height:1px\;position:relative\;left:'+(cinLeft+shy)+'px\;top:'+(cinTop+shy)+'px\;'+bks[6]+'">';

				cn+='<div id="childcontent-'+i+'-'+j+'" style="position:relative\;left:'+shSIZE+'px\;top:'+shSIZE+'px\;width:'+(cP[i][j][0]+xwPad)+'px\;height:1px\;">udm</div>';

				cn+='</div>';
				cn+='</div>';

				}

			}

		}

	}
document.write(cn);


//store objects
for(i=0;i<mI.length;i++){

	cmObj[i]=new Array;
	cminObj[i]=new Array;
	cshObj[i]=new Array;
	if(sI[i].length>0) {
		for(j=0;j<sI[i].length;j++) {
			if(cI[i][j].length>0) {
				cmObj[i][j]=document.all['childmenu-'+i+'-'+j];
				cminObj[i][j]=document.all['childcontent-'+i+'-'+j];
				cshObj[i][j]=document.all['childshadow-'+i+'-'+j];
				}
			}
		}

	}


//click to close
function clickToClose() {
	clearSubMenus();
	if(hideSELECT){showSelects();}
	}
document.onclick = clickToClose;



//load function
function loadFunction() {
	allready=true;
	genericOnloadFunction();
	//if(staticMENU){makeStatic();}
	}

window.onload=loadFunction;




// resize / reload trap
if(allowRESIZE==true){window.onresize=new Function("window.location.reload()");}



//select element hiding routine by Huy Do
var selectSearch = true;
var selectArray = new Array;
var frm = document.forms;
var typeStr,elm;

//hide select elements
function hideSelects(){
	if (selectSearch==true){
		for (i=0;i<frm.length;i++){
			for (j=0;j<frm[i].elements.length; j++){
				elm = document.forms[i].elements;
				typeStr = elm[j].type.toString();
				if(typeStr.substring(0,6)=="select"){
					selectArray[selectArray.length]=elm[j];
					}
				}
			}
			selectSearch = false;
		}

	if (selectArray.length>0){
		for (z=0;z<selectArray.length; z++){
			if(selectArray[z].style){
				if(selectArray[z].style){
					selectArray[z].style.visibility='hidden';
					}
				}
			}
		}
	}

//show select elements
function showSelects(){
	if (selectArray.length>0){
		for (var z=0;z<selectArray.length;z++){
			if (selectArray[z].style){
				selectArray[z].style.visibility='visible';
				}
			}
		}
	}





//move menu
function activateMenu(mmNum) {

	if(typeof sP[mmNum]=="undefined"||!remoteTRIGGERING) { return false; }
	
	mainCell(mmNum,false);
	if(ie&&hideSELECT){hideSelects();}
	}

