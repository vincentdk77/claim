//UDMv3.4.1.1b


//**DO NOT EDIT THIS ******************************************
//*************************************************************
if(!exclude){
// document object variable
var d=document;
// adjust for font size discrepancy
if((!mac&&ns4)||(mac&&op5)){fSIZE+=1;sfSIZE+=1;}
// filter for unuseable definitions
if(bSIZE<0)bSIZE=0;if(fSIZE<5)fSIZE=5;if(tINDENT<0)tINDENT=0;if(vPADDING<0)vPADDING=0;if(sbSIZE<0)sbSIZE=0;if(sfSIZE<5) sfSIZE=5;if(stINDENT<0)stINDENT=0;if(svPADDING<0)svPADDING=0;if(fWEIGHT=="")fWEIGHT="normal";if(sfWEIGHT=="")sfWEIGHT="normal";if(shSIZE<0){shSIZE=0;}if(cellCLICK==mu){cellCLICK=true;}
//active remote triggering
if(menuALIGN=="virtual"){remoteTRIGGERING=true;menuALIGN="center";allowRESIZE=true;staticMENU=false;}
// link style definitions
var stySTR='';
if(ns4){stySTR+='<style><!--';stySTR+='.translink\{background-color:transparent\;\}';stySTR+='.mTD A \{color:'+aLINK+'\;font-weight:'+fWEIGHT+'\;\}';stySTR+='.mTD A:Link \{color:'+aLINK+'\}';stySTR+='.mTD A:Visited \{color:'+aLINK+'\}';stySTR+='.mTD A:Active,.mTD A:Link,.mTD A:Visited,.mTD A:Hover\{font-weight:'+fWEIGHT+'\;font-size:'+fSIZE+'px\;font-family:'+fFONT+'\;text-decoration:'+aDEC+'\;position:relative\;\}';stySTR+='.SUBmTD A \{ color:'+saLINK+'\;font-weight:'+sfWEIGHT+'\;\}';stySTR+='.SUBmTD A:Link \{color:'+saLINK+'\}';stySTR+='.SUBmTD A:Visited \{color:'+saLINK+' \}';stySTR+='.SUBmTD A:Active,.SUBmTD A:Link,.SUBmTD A:Visited,.SUBmTD A:Hover\{font-weight:'+sfWEIGHT+'\;font-size:'+sfSIZE+'px\;font-family:'+sfFONT+'\;text-decoration:'+saDEC+'\;\}';}
else{stySTR+='<style><!--';stySTR+='.mTD,.mTD A \{white-space:nowrap;color:'+aLINK+'\;font-weight:'+fWEIGHT+'\;\}';stySTR+='.mTD,.mTD A:Link \{color:'+aLINK+'\}';stySTR+='.mTD A:Visited \{color:'+aLINK+'\}';stySTR+='.mTD,.mTD A:Active,.mTD A:Link,.mTD A:Visited,.mTD A:Hover\{font-weight:'+fWEIGHT+'\;font-size:'+fSIZE+'px\;font-family:'+fFONT+'\;text-decoration:'+aDEC+'\;position:relative\;\}';stySTR+='.SUBmTD,.SUBmTD A \{ white-space:nowrap;color:'+saLINK+'\;font-weight:'+sfWEIGHT+'\;\}';stySTR+='.SUBmTD,.SUBmTD A:Link \{color:'+saLINK+'\}';stySTR+='.SUBmTD A:Visited \{color:'+saLINK+' \}';stySTR+='.SUBmTD,.SUBmTD A:Active,.SUBmTD A:Link,.SUBmTD A:Visited,.SUBmTD A:Hover\{font-weight:'+sfWEIGHT+'\;font-size:'+sfSIZE+'px\;font-family:'+sfFONT+'\;text-decoration:'+saDEC+'\;\}';if(ie&&hideSELECT){stySTR+='select\{visibility:visible\;\}';}if(ie5){stySTR+='.u\{text-decoration:underline\;\}';}}
//*************************************************************
//****##### USE THIS SPACE FOR NEW STYLE DEFINITIONS #####*****






var cl='#0000cc'; var fs=14;
if((win&&ns4)||(mac&&op5)){fs=15;if(ns4){cl='#009600';}}
stySTR+='.roman \{font-size:'+fs+'px\; color:'+cl+'\; background-color:white\; font-family:times new roman\; \}';







//** DO NOT EDIT THIS ****************************************
stySTR+='//--></style>';d.write(stySTR);}
function genericOnloadFunction() {
//*************************************************************
//****##### USE THIS SPACE TO DEFINE ONLOAD FUNCTIONS #####****










//** DO NOT EDIT THIS *****************************************
//*************************************************************
if(ns4){nsinit();}}
//*************************************************************
