﻿
var cff1 = new Array();
var flightcitys = cff1;  	 
String.prototype.trim=function(){return this.replace(/(^\s+)|(\s+$)/g,"")};String.prototype.format=function(){var a=arguments;return this.replace(/\{(\d+)\}/g,function(c,b){return a[b]})};function StringBuilder(){this.arr=[]}StringBuilder.prototype.append=function(a){this.arr.push(a)};StringBuilder.prototype.appendFormat=function(){for(var a=arguments[0],c=0;c<arguments.length-1;c++)a=a.replace(new RegExp("\\{"+c+"\\}"),arguments[c+1]);this.arr.push(a)};StringBuilder.prototype.toString=function(){return this.arr.join("")};
function citytab1(a){var c=document.getElementById("cityhead").getElementsByTagName("li");if(c){for(var b=0;b<c.length;b++)c[b].className="search_li01";if(b=document.getElementById("li"+a))b.className="search_li02"}if(c=document.getElementById("city_box").getElementsByTagName("div")){for(b=1;b<c.length;b++)c[b].className="list_main unshow";if(b=document.getElementById("city"+a))b.className="list_main"}document.getElementById("top_getiframe").style.height=document.getElementById("city_box").offsetHeight+2+"px";}
//京
function prefixTab(a,w){
    var c=document.getElementById("city"+w).getElementsByTagName("ul");
if(c)
{
    for(var b=1;b<c.length;b++)
    c[b].className="city_sugg unshow";
    var city_sugg=document.getElementById("ul"+a)
    if(city_sugg)
    city_sugg.className="city_sugg";
 }
 var d=document.getElementById("firstul"+w).getElementsByTagName("a");

 if(d)
 {
 for(var b=0;b<d.length;b++)
 { //alert(d[b].id);
 d[b].className="off";}
 var e =document.getElementById("a_"+a);
 //alert(e.id);
 if(e)
     e.className="on";
 }
    document.getElementById("top_getiframe").style.height=document.getElementById("city_box").offsetHeight+2+"px";
 };
		 
function replaceHtml(el, html) {
    var oldEl = typeof el == "string" ? document.getElementById(el) : el;
    var newEl = oldEl.cloneNode(false);
    newEl.innerHTML = html;
    oldEl.parentNode.replaceChild(newEl, oldEl);
    return newEl;
};

//应市场要求点击空白处也要填上城市值，故设定一个全局的变量，保存当前输入框的id
var global_id='';
var parentbject;
window.city_suggest = function(){
	this.object = '';
	this.id2 = '';
	this.taskid = 0;
	this.delaySec = 100; // 默认延迟多少毫秒出现提示框
	this.hot= [];
	this.letter = [];
	this.hotelcity ={};
	/**
	* 初始化类库
	*/
	this.init_zhaobussuggest=  function(){
		var objBody = document.getElementsByTagName("body").item(0);
		var objiFrame = document.createElement("iframe");
		var objplatform = document.createElement("div");
		objiFrame.setAttribute('id','top_getiframe');
		objiFrame.setAttribute("src","about:blank");
		objiFrame.style.zindex='100';
		objiFrame.style.border='0';
		objiFrame.style.position = 'absolute';
		objplatform.setAttribute('id','top_getplatform');
		objplatform.setAttribute('align','left');
		objplatform.style.position = 'absolute';
		objplatform.style.border = 'solid 1px #7f9db9';
		objplatform.style.background = '#ffffff';
		if(objBody){
		    objBody.appendChild(objiFrame);
		    if(objiFrame){
		        objiFrame.ownerDocument.body.appendChild(objplatform);
		    }
		}
		if(!document.all) {
			
			window.document.addEventListener("click",this.hidden_suggest,false);
		}else{
			window.document.attachEvent("onclick",this.hidden_suggest);
		}
	}
	/***************************************************fix_div_coordinate*********************************************/
	//函数功能：控制提示div的位置，使之刚好出现在文本输入框的下面
	this.fix_div_coordinate = function(){
		var leftpos=0;
		var toppos=0;
		
		var aTag = this.object;
		do {
			aTag = aTag.offsetParent;
			leftpos	+= aTag.offsetLeft;
			toppos += aTag.offsetTop;
		}while(aTag.tagName!="BODY"&&aTag.tagName!="HTML");
		document.getElementById("top_getiframe").style.width = this.object.offsetWidth+50 + 'px';
		if(document.layers){
			document.getElementById("top_getiframe").style.left = this.object.offsetLeft	+ leftpos + "px";
			document.getElementById("top_getiframe").style.top = this.object.offsetTop +	toppos + this.object.offsetHeight + 2 + "px";
		}else{
			document.getElementById("top_getiframe").style.left =this.object.offsetLeft	+ leftpos  +"px";
			document.getElementById("top_getiframe").style.top = this.object.offsetTop +	toppos + this.object.offsetHeight + 'px';
		}
		
		if(document.layers){
			document.getElementById("top_getplatform").style.left = this.object.offsetLeft	+ leftpos + "px";
			document.getElementById("top_getplatform").style.top = this.object.offsetTop +	toppos + this.object.offsetHeight + 2 + "px";
		}else{
			document.getElementById("top_getplatform").style.left =this.object.offsetLeft	+ leftpos  +"px";
			document.getElementById("top_getplatform").style.top = this.object.offsetTop +	toppos + this.object.offsetHeight + 'px';
		}

        ///如果框出屏幕外，向左 245px(城市弹出框宽度-文本框宽度)
	    if ((this.object.offsetLeft+leftpos+370)>screen.width)
	    {
            document.getElementById("top_getiframe").style.left = document.getElementById("top_getplatform").style.left = this.object.offsetLeft	+ leftpos -245 + "px";
	    }

	}

    /***************************************************hidden_suggest*********************************************/
	//函数功能：隐藏提示框
	this.hidden_suggest = function (event){
	//alert("beingdone");
		if (event.target) targ = event.target;  else if (event.srcElement) targ = event.srcElement;
		if(targ.tagName!='LI' && targ.tagName!='A'){	
		    document.getElementById("top_getiframe").style.visibility = "hidden";
		    document.getElementById("top_getplatform").style.visibility = "hidden";
		}
	}
	
	this.hidden = function(){if(document.getElementById("top_getiframe")){document.getElementById("top_getiframe").style.visibility = "hidden";document.getElementById("top_getplatform").style.visibility = "hidden";}}

	/***************************************************show_suggest*********************************************/
	//函数功能：显示提示框
	this.show_suggest = function (){
		document.getElementById("top_getiframe").style.visibility = "visible";
		document.getElementById("top_getplatform").style.visibility = "visible";
	}

	this.is_showsuggest= function (){
		if(document.getElementById("top_getplatform").style.visibility == "visible") return true;else return false;
	}

	this.sleep = function(n){
		var start=new Date().getTime(); //for opera only
		while(true) if(new Date().getTime()-start>n) break;
	}

	this.ltrim = function (strtext){
		return strtext.replace(/[\$&\|\^*%#@! ]+/, '');
	}

    /***************************************************add_input_text*********************************************/
	//函数功能：当用户选中时填充相应的城市名字

	this.add_input_text = function (keys,szm){
		keys=this.ltrim(keys);
		if(this.object.id=='img_showcity')
		    CallDPCityPage(keys);
		else
		{
		    this.object.value = keys;
		    var id=this.object.id;
		    var id2 = this.id2;	
		    if(document.getElementById(this.id2)){
			    document.getElementById(this.id2).value = szm;
		    }
		    document.getElementById(id).style.color="#000000";
		    document.getElementById(id).value=keys;
		    document.getElementById("top_getiframe").style.visibility = "hidden";
		    document.getElementById("top_getplatform").style.visibility = "hidden";
		    //单击时设置自动跳到下一个输入框
		    if(id!=null && id=="C_SearchByPoly1_txt_orgcity")
		    {
		        if(document.getElementById("C_SearchByPoly1_txt_descity"))
		        {
		         Text_OnClick("C_SearchByPoly1_txt_descity");
		        }
		    }
		}
     }
     
     this.ajaxac_getkeycode = function (e){
		var code;
		if (!e) var e = window.event;
		if (e.keyCode) code = e.keyCode;
		else if (e.which) code = e.which;
		return code;
	}

    /***************************************************display*********************************************/
	//函数功能：入口函数，将提示层div显示出来
	//输入参数：object 当前输入所在的对象，如文本框
	//输入参数：e IE事件对象
	this.display = function (object,id2,e){
        if(object)
        {
            object.select();
        }
		this.id2 = id2;
		if(!document.getElementById("top_getplatform")) this.init_zhaobussuggest();
		if (!e) e = window.event;
		e.stopPropagation;
		e.cancelBubble = true;
		if (e.target) targ = e.target;  else if (e.srcElement) targ = e.srcElement;
		if (targ.nodeType == 3)  targ = targ.parentNode;

		this.object = object;
	
		if(window.opera) this.sleep(100);//延迟0.1秒
		parentbject = this;
		if(this.taskid) window.clearTimeout(this.taskid);
        this.taskid=setTimeout("parentbject.localtext();" , this.delaySec);
	}

	//函数功能：从本地js数组中获取要填充到提示层div中的文本内容
	this.localtext = function(){
		var id=this.object.id;
		parentbject.show_suggest();
		parentbject.fill_div('');
		parentbject.fix_div_coordinate();
	}
};


//兼容的onclick
function Text_OnClick(id)
{ 
   var ie=navigator.appName=="Microsoft Internet Explorer" ? true : false;
   if(ie)
   {
       document.getElementById(id).click();
   }
   else
   {
       var a=document.createEvent('MouseEvents');
       a.initEvent('click', true, true);
       document.getElementById(id).dispatchEvent(a);
   }
}
var item_parentbject;
window.item_city_suggest = function(){
	this.item_Remoreurl = ''; // 远程URL地址
	this.item_object = '';
	this.item_id2 = '';
	this.item_taskid = 0;
	this.item_delaySec = 100; // 默认延迟多少毫秒出现提示框
	this.item_lastkeys_val = 0;
	this.item_lastinputstr = '';
	this.item_citys = new Array();
	/**
	*赋值城市数组
	*/
	this.item_setArr_Citys = function(citys){
	    this.item_citys = citys;
	}
	/**
	* 初始化类库
	*/
	/**
	* 初始化类库
	*/
	this.init_zhaobussuggest=  function(){
		var objBody = document.getElementsByTagName("body").item(0);
		var objiFrame = document.createElement("iframe");
		var objplatform = document.createElement("div");
		objiFrame.setAttribute('id','top_getiframe');
		objiFrame.setAttribute("src","about:blank");
		objiFrame.style.zindex='100';
		objiFrame.style.border='0';
		objiFrame.style.position = 'absolute';
		objplatform.setAttribute('id','top_getplatform');
		objplatform.setAttribute('align','left');
		objplatform.style.position = 'absolute';
		objplatform.style.border = 'solid 1px #7f9db9';
		objplatform.style.background = '#ffffff';
		if(objBody){
		    objBody.appendChild(objiFrame);
		    if(objiFrame){
		        objiFrame.ownerDocument.body.appendChild(objplatform);
		    }
		}
		if(!document.all) {
			
			window.document.addEventListener("click",this.hidden_suggest,false);
		}else{
			window.document.attachEvent("onclick",this.hidden_suggest);
		}
	}
	this.item_init_zhaobussuggest1=  function(){
		
		var objBody = document.getElementsByTagName("body").item(0);
		var objiFrame = document.createElement("iframe");
		var objplatform = document.createElement("div");
		objiFrame.setAttribute('id','top_getiframe');
		//ds_input_tips ds_input_tips_full
		objiFrame.style.zindex='100';
		objiFrame.style.border='0';
		objiFrame.style.position = 'absolute';
		objplatform.setAttribute('id','top_getplatform');
		objplatform.setAttribute('align','left');
		objplatform.style.position = 'absolute';
		objplatform.style.border = 'solid 1px #7f9db9';
		objplatform.style.background = '#ffffff';
		objplatform.style.padding = '0px 3px 3px 3px';
		objBody.appendChild(objiFrame);
		objiFrame.ownerDocument.body.appendChild(objplatform);
		if(!document.all) {
			window.document.addEventListener("click",this.item_hidden_suggest1,false);
		}else{
			window.document.attachEvent("onclick",this.item_hidden_suggest1);
		}
	}
    /**********************************************getPinYinByCity()*******************************************/
    
    this.item_getPinYinByCity = function(cityName){
	    var pinYin = "";
	    for(var i = 1,len = this.item_citys.length;i<len;i++){
		    if(cityName == this.item_citys[i][0]){
			    pinYin = this.item_citys[i][1];
			    break;
		    }
	    }
	    return pinYin;
    }
	/***************************************************fill_div()*********************************************/
	//函数功能：动态填充div的内容，该div显示所有的提示内容
	//函数参数：allplat 一个字符串数组，包含了所有可能的提示内容
	this.item_fill_div1 = function(allplat){
		var msgplat = '';
		var all = '';
		var spell = '';
		var chinese = '';
		var platkeys = this.item_object.value;
        platkeys=this.ltrim(platkeys);
        //alert(platkeys);
		if(!platkeys){
			//alert("a");
			
			msgplat += '<div class="ds_input_tips ds_input_tips_no">输入中文或&uarr;&darr;选择</div>';
			
			
			for(i=0;i<allplat.length;i++){
			    all=allplat[i].split(",");
				spell="";
				chinese=all[1];
				szm=all[2];
			    //用于机票-城市附近机场
				if(szm != null && szm != "" && szm.indexOf("$") > -1){
				    msgplat += '<dd><div class="suggest-key" style="color:#0055aa">'+ spell +
			           '</div><div class="suggest-result" style="color:#0055aa">' + chinese + '</div><div style="display:none"></div></dd>';
				    var arr_szm = szm.split("$");//城市附近有机场城市
				    if(arr_szm.length>0){
				        msgplat += '<dl><dt>·该城市无机场</dt></dl>';
				        for(var j=1; j<arr_szm.length; j++){
				            msgplat += '<li onclick="item_parentbject.item_add_input_text(\'' + arr_szm[j].split('-')[0] + '\',\'\')">'
			                        +  '<div class="suggest-key" style="float:left;color:#414141;padding-left:2px">·邻近机场：</div>'
			                        +  '<div class="suggest-result" style="float:left;color:#414141;">' + arr_szm[j].split('-')[0] + '</div>'
			                        +  '<div style="float:left;color:#414141;">' + arr_szm[j].split('-')[1] + '公里</div></li>';
				        }
			        }
				}
				else{
				    msgplat += '<li onclick="item_parentbject.item_add_input_text(\'' + chinese + '\',\'' + spell + '\')"><div class="suggest-key">'+ spell +
				       '</div><div class="suggest-result">' + chinese + '</div><div style="display:none">' + szm + '</div></li>';
				}
			}
        }
		else {
			if(allplat.length < 1 || !allplat[0]){
				msgplat += '<div class="ds_input_tips ds_input_tips_no">对不起，找不到：'+platkeys+'</div>';
			}
			else{
			    if(allplat.length == 1){
			        msgplat += '<div class="ds_input_tips ds_input_tips_one">'+platkeys+'，按中文排序</div>';
			    }
			    else{
			        msgplat += '<div class="ds_input_tips ds_input_tips_full">'+platkeys+'，按中文排序</div>';
			    }
			    for(i=0;i<allplat.length;i++){
					all=allplat[i].split(",");
					var  liId = "liId"+(i+1); 
					//alert("liId:"+liId);
					spell=all[0];
					var firstchar = spell.substring(0,1);
					spell = firstchar.toUpperCase() + spell.substring(1,spell.length);
					chinese=all[1];
					szm=all[2];
					//alert("spell:"+spell+"chinese:"+chinese+"szm:"+szm);
					//用于机票-城市附近机场
				    if(szm != null && szm != "" && szm.indexOf("$") > -1){
				        msgplat += '<dd><div class="suggest-key" style="color:#0055aa">'+ spell +
				           '</div><div class="suggest-result" style="color:#0055aa">' + chinese + '</div><div style="display:none"></div></dd>';
				        var arr_szm = szm.split("$");//城市附近有机场城市
				    }
				    else{
				    	if(i>19){
				        msgplat += '<li id = '+liId+' style="display:none" onclick="item_parentbject.item_add_input_text(\'' + chinese + '\',\'' + spell + '\')"><div class="suggest-key" style="display:none">'+ spell +
				           '</div><div class="suggest-result">' + chinese + '</div><div style="display:none">' + spell + '</div></li>';
				    	}else{
					    msgplat += '<li id = '+liId+' onclick="item_parentbject.item_add_input_text(\'' + chinese + '\',\'' + spell + '\')"><div class="suggest-key" style="display:none">'+ spell +
					          '</div><div class="suggest-result" >' + chinese + '</div><div style="display:none">' + spell + '</div></li>';
				    	}
				    }
				}
 			    msgplat += '<li id = "boxss1" onclick="getMoreTr()" >更多选项</li>'; 
			}
		}
		document.getElementById("top_getplatform").innerHTML =  '<div class="suggest-container1">'+msgplat+'</div>';//城市结果列表呈现

		var nodes = document.getElementById("top_getplatform").childNodes;//列表外框<div>
		var nodes_li = document.getElementById("top_getplatform").getElementsByTagName("li");//城市列表节点
		nodes[0].className = "suggest-container1";
		if(allplat.length >= 1 && allplat[0]){
			nodes_li[0].className = "ds_selected";
		}
		this.item_lastkeys_val = 0;
		for(var i=1;i<nodes_li.length;i++){
			nodes_li[i].onmouseover = function(){
				this.className = "top_mover";
			}

			nodes_li[i].onmouseout = function(){
				if(item_parentbject.lastkeys_val==(item_parentIndexOf(this)-1)){this.className = "ds_selected";}
				else{this.className = "top_mout";}
			}
		}
		document.getElementById("top_getiframe").style.width = document.getElementById("top_getplatform").clientWidth+2;
        document.getElementById("top_getiframe").style.height = document.getElementById("top_getplatform").clientHeight+2;
	}

	/***************************************************fix_div_coordinate*********************************************/
	//函数功能：控制提示div的位置，使之刚好出现在文本输入框的下面
	this.item_fix_div_coordinate = function(){
		var leftpos=0;
		var toppos=0;
		/*
		aTag = this.item_object;
		do {
			aTag = aTag.offsetParent;
			leftpos	+= aTag.offsetLeft;
			toppos += aTag.offsetTop;
		}while(aTag.tagName!="BODY");
		*/
		//linden.guo modify at 2009-04-23 11:35
		var aTag = this.item_object;
		do {
			aTag = aTag.offsetParent;
			leftpos	+= aTag.offsetLeft;
			toppos += aTag.offsetTop;
		}while(aTag.tagName!="BODY"&&aTag.tagName!="HTML");
		document.getElementById("top_getiframe").style.width = '175px';
		if(document.layers){
			document.getElementById("top_getiframe").style.left = this.item_object.offsetLeft	+ leftpos + "px";
			document.getElementById("top_getiframe").style.top = this.item_object.offsetTop +	toppos + this.item_object.offsetHeight + 2 + "px";
		}else{
			document.getElementById("top_getiframe").style.left =this.item_object.offsetLeft	+ leftpos  +"px";
			document.getElementById("top_getiframe").style.top = this.item_object.offsetTop +	toppos + this.item_object.offsetHeight + 'px';
		}
		if(document.layers){
			document.getElementById("top_getplatform").style.left = this.item_object.offsetLeft	+ leftpos + "px";
			document.getElementById("top_getplatform").style.top = this.item_object.offsetTop +	toppos + this.item_object.offsetHeight + 2 + "px";
		}else{
			document.getElementById("top_getplatform").style.left =this.item_object.offsetLeft	+ leftpos  +"px";
			document.getElementById("top_getplatform").style.top = this.item_object.offsetTop +	toppos + this.item_object.offsetHeight + 'px';
		}
	}

    /***************************************************hidden_suggest*********************************************/
	//函数功能：隐藏提示框
	this.item_hidden_suggest1 = function (){
		//this.item_lastkeys_val = 0;
		//当this.item_lastkeys_val有值时,不清零
		if(this.item_lastkeys_val == null || this.item_lastkeys_val < 0){
		    this.item_lastkeys_val = 0;
		}
			var lableDiv = "old";
	    	var boxss1 = document.getElementById("boxss1");
	    	//alert(boxss1.innerHTML);
	    	var nodes_div1 = document.getElementById("top_getplatform").getElementsByTagName("div");
	    	for(var i=0;i<nodes_div1.length;i++){
	    		if("suggest-container1"==nodes_div1[i].className){
	    			lableDiv = "new";
	    			break;
	    		}
	    	}
	    	//alert(lableDiv);
	    	
	    	if("new"==lableDiv){
	    	if(boxss1!=null){
	    	if(boxss1.innerHTML=="更多"){
	    		
				document.getElementById("top_getiframe").style.visibility = "hidden";
				document.getElementById("top_getplatform").style.visibility = "hidden";	
				}else{
					getMoreTr();
				}
	    	}
	    	}else{
				document.getElementById("top_getiframe").style.visibility = "hidden";
				document.getElementById("top_getplatform").style.visibility = "hidden";	
	    	}
	    	
		    
	}
	//函数功能：隐藏提示框
	this.hidden_suggest = function (event){
	//alert("beingdone");
		if (event.target) targ = event.target;  else if (event.srcElement) targ = event.srcElement;
		if(targ.tagName!='LI' && targ.tagName!='A'){	
		    document.getElementById("top_getiframe").style.visibility = "hidden";
		    document.getElementById("top_getplatform").style.visibility = "hidden";
		}
	}
	//函数功能：隐藏提示框
	this.item_hidden_suggestNew = function (){
		//this.item_lastkeys_val = 0;
		//当this.item_lastkeys_val有值时,不清零
		if(this.item_lastkeys_val == null || this.item_lastkeys_val < 0){
		    this.item_lastkeys_val = 0;
		}
		document.getElementById("top_getiframe").style.visibility = "hidden";
		document.getElementById("top_getplatform").style.visibility = "hidden";
	}
    this.item_onblur=function(object){
    //应市场要求鼠标点击空白处，也要填上城市值的处理方法
		var nodes = document.getElementById("top_getplatform").getElementsByTagName("li");
		if(nodes!=null && typeof(nodes)!='undefined'){
		    for(var i=0;i<nodes.length;i++){
			    if(nodes[i].className == "ds_selected"){
			        if(nodes[i].childNodes.length>1){
			            if(object)
			            {
			                object.value=nodes[i].childNodes[1].innerHTML;
			            }
				    }
			    }
		    }
		}
		else{
		    object.value='';
		}
    }
	/***************************************************show_suggest*********************************************/
	//函数功能：显示提示框
	this.item_show_suggest = function (){
		document.getElementById("top_getiframe").style.visibility = "visible";
		document.getElementById("top_getplatform").style.visibility = "visible";
	}

	this.is_showsuggest= function (){
		if(document.getElementById("top_getplatform").style.visibility == "visible") return true;else return false;
	}

	this.sleep = function(n){
		var start=new Date().getTime(); //for opera only
		while(true) if(new Date().getTime()-start>n) break;
	}

	this.ltrim = function (strtext){
		return strtext.replace(/[\$&\|\^*%#@! ]+/, '');
	}

    /***************************************************add_input_text*********************************************/
	//函数功能：当用户选中时填充相应的城市名字

	this.item_add_input_text = function (keys,spell){
		
	    var boxss1 = document.getElementById("boxss1");
	    boxss1.innerHTML = '更多';
		keys=this.ltrim(keys)
		//alert("spell:"+spell+"");
		this.item_object.value = keys;
		var id=this.item_object.id;
		var id2 = this.item_id2;
		//alert("id:"+id+"id2:"+id2);
		if(document.id2){
			document.getElementById(this.item_id2).value = szm;
		}
		if(spell!=null){
			document.getElementById("bankCNameCodeId").value = spell;
		}
		document.getElementById(id).style.color="#000000";
		document.getElementById(id).value=keys;
		document.getElementById("bank").value=keys;
		//输入时设置自动跳到下一个输入框
		if(id!=null && id=="C_SearchByPoly1_txt_orgcity")
		{
		    if(document.getElementById("C_SearchByPoly1_txt_descity"))
		    {
		     Text_OnClick("C_SearchByPoly1_txt_descity");
		    }
		}
     }

	/***************************************************keys_handleup*********************************************/
	//函数功能：用于处理当用户用向上的方向键选择内容时的事件
	this.item_keys_handleup = function (){
		if(this.item_lastkeys_val > 0) this.item_lastkeys_val--;
		var nodes = document.getElementById("top_getplatform").getElementsByTagName("li");
		if(this.item_lastkeys_val < 0) this.item_lastkeys_val = nodes.length-1;
		var b = 0;
		for(var i=0;i<nodes.length;i++){
			if(b == this.item_lastkeys_val){
				nodes[i].className = "ds_selected";
				if(nodes[i].childNodes.length>1){
				    this.item_add_input_text(nodes[i].childNodes[1].innerHTML);
				}
			}else{
				nodes[i].className = "top_mout";
			}
			b++;
		}
	}

	/***************************************************keys_handledown*********************************************/
	//函数功能：用于处理当用户用向下的方向键选择内容时的事件
	this.item_keys_handledown = function (){
		this.item_lastkeys_val++;
		var nodes = document.getElementById("top_getplatform").getElementsByTagName("li");
		if(this.item_lastkeys_val >= nodes.length) {
			this.item_lastkeys_val--;
			return;
		}
		var b = 0;
		for(var i=0;i<nodes.length;i++){
			if(b == this.item_lastkeys_val){
				nodes[i].className = "ds_selected";
				if(nodes[i].childNodes.length>1){
				    this.item_add_input_text(nodes[i].childNodes[1].innerHTML);
				}
			}else{
				nodes[i].className = "top_mout";
			}
			b++;
		}
	}

	this.item_ajaxac_getkeycode = function (e)
	{
		var code;
		if (!e) var e = window.event;
		if (e.keyCode) code = e.keyCode;
		else if (e.which) code = e.which;
		return code;
	}

	/***************************************************keys_enter*********************************************/
	//函数功能：用于处理当用户回车键选择内容时的事件
	this.item_keys_enter = function (){
		var nodes = document.getElementById("top_getplatform").getElementsByTagName("li");
		for(var i=0;i<nodes.length;i++){
			if(nodes[i].className == "ds_selected"){
			    if(nodes[i].childNodes.length>1){
			    	nodes[i].childNodes[1].innerHTML
				    this.item_add_input_text(nodes[i].childNodes[1].innerHTML);
				    if(nodes[i].childNodes[2].innerHTML!=null){
						document.getElementById("bankCNameCodeId").value = nodes[i].childNodes[2].innerHTML;
					}
				}
			}
		}
		this.item_hidden_suggest1();
	}

    /***************************************************display*********************************************/
	//函数功能：入口函数，将提示层div显示出来
	//输入参数：object 当前输入所在的对象，如文本框
	//输入参数：e IE事件对象
	this.item_display1 = function (object,id2,e,citys){
		document.getElementById("bankCNameCodeId").value='';
		var content = object.value;
		validate(content);  
	    //this.item_setArr_Citys(citys);
		
	    /*第二次触发城市控件，默认全选。*/
		var content = object.value;
		global_id=object.id;

		var flag = this.item_getPinYinByCity(content)
		if(flag!="") 
		{
		    object.focus();
		    object.select();
		}
		this.item_id2 = id2;
		if(!document.getElementById("top_getplatform")) this.init_zhaobussuggest();
		if(!document.getElementById("top_getplatform")) this.item_init_zhaobussuggest1(); 
		if (!e) e = window.event;
		e.stopPropagation;
		e.cancelBubble = true;
		if (e.target) targ = e.target;  else if (e.srcElement) targ = e.srcElement;
		if (targ.nodeType == 3)  targ = targ.parentNode;

		var inputkeys = this.item_ajaxac_getkeycode(e);
		switch(inputkeys){
			case 38: //向上方向键
				this.item_keys_handleup(object.id);
			    return;break;
			case 40: //向下方向键
				if(this.is_showsuggest()) this.item_keys_handledown(object.id); else this.item_show_suggest();
			    return;break;
			case 39: //向右方向键
				return;break;
			case 37: //向左方向键
				return;break;
			case 13: //对应回车键
			    this.item_keys_enter();
			    return;break;
			case 18: //对应Alt键
				this.item_hidden_suggest1();
			    return;break;
			case 27: //对应Esc键
				this.item_hidden_suggest1();
			    return;break;
		}

		this.item_object = object;
		if(window.opera) this.sleep(100);//延迟0.1秒
		item_parentbject = this;
		if(this.item_taskid) window.clearTimeout(this.item_taskid);
        this.item_taskid=setTimeout("item_parentbject.item_localtext();" , this.item_delaySec)

	}

	//函数功能：从本地js数组中获取要填充到提示层div中的文本内容
	this.item_localtext = function(){
		var id=this.item_object.id;
        var suggestions="";
        suggestions=this.item_getSuggestionByName();
        if(suggestions==""){
	        item_parentbject.item_show_suggest();
	        item_parentbject.item_fill_div1("");
	        item_parentbject.item_fix_div_coordinate();	
        }
        else{
	        suggestions=suggestions.substring(0,suggestions.length-1);
	        item_parentbject.item_show_suggest();
	        item_parentbject.item_fill_div1(suggestions.split(';'));
	        item_parentbject.item_fix_div_coordinate();	
	    }
	}

	/***************************************************getSuggestionByName*********************************************/
	//函数功能：从本地js数组中获取要填充到提示层div中的城市名字
	this.item_getSuggestionByName = function(){
		platkeys = this.item_object.value;
		var str="";
        platkeys=this.ltrim(platkeys);
		if(!platkeys){
			return str;
        }
		else{
			//alert(platkeys);
		   platkeys=platkeys.toUpperCase();
			for(i=0;i<this.item_citys.length;i++){
			    if((this.item_citys[i][0].toUpperCase().indexOf(platkeys)!=-1)||
				   this.item_getLeftStr(this.item_citys[i][1],platkeys.length).toUpperCase()==platkeys||
				   this.item_getLeftStr(this.item_citys[i][2],platkeys.length).toUpperCase()==platkeys)
					str+=this.item_citys[i][1]+","+this.item_citys[i][0]+","+this.item_citys[i][2]+";";
			}
			return str;
		}
	}

	/***************************************************getLeftStr************* *************************************/
    //函数功能：得到左边的字符串
    this.item_getLeftStr = function(str,len){

        if(isNaN(len)||len==null){
            len = str.length;
        }
        else{
            if(parseInt(len)<0||parseInt(len)>str.length){
                len = str.length;
             }
        }
        return str.substr(0,len);
    }

	/***************************************************parentIndexOf************* *************************************/
    //函数功能：得到子结点在父结点的位置
	function item_parentIndexOf(node){
	  for (var i=0; i<node.parentNode.childNodes.length; i++){
			if(node==node.parentNode.childNodes[i]){return i;}
	  }
   }
   
}
//首先自动加载城市
var item_suggest1 = new item_city_suggest();
item_suggest1.item_citys = flightcitys;

function CallDPCityPage(orgcityname)
{
    var _url = '/flight/ajaxcn.ashx?type=GetCityIdByName&orgcityname='+escape(orgcityname);
    AjaxFuncion(_url, callcitypage);
}

function callcitypage(response)
{
    if (response!='') {
        if (response == "City is Null") {
            alert('当前航班数据为空');
            return false;
        }
        else
            document.location.href='/FlightCommentCity-'+ response +'-1.html';

    }
}

function validate(bankCName){
    //1、创建XMLHttpRequest对象
    //2、需要针对IE和其它浏览器建立这个对象的不同方式写不同的代码
    if(window.XMLHttpRequest){
        //针对FF,Mozilar,Opera,Safari,IE7,IE8
        xmlhttp=new XMLHttpRequest();
        //修正某些浏览器bug
        if(xmlhttp.overrideMimeType){
            xmlhttp.overrideMimeType("text/xml");
        }
    }else if(window.ActiveXObject){
        //针对IE6以下的浏览器
        var activexName=["MSXML2.XMLHTTP","Microsoft.XMLHTTP",""];
        for( var i=0;i<activexName.length;i++){
            try{
                //取出一个控件名称创建,如果创建成功则停止,反之抛出异常
                xmlhttp=new ActiveXObject(activexName[i]);
                break;                
            }catch(e){}
        }
    }
    
    //注册回调函数。注意注册回调函数是不能加括号,加了会把函数的值返回给onreadystatechange
    xmlhttp.onreadystatechange=callback;
    //设置连接信息
    //第一个参数表示http请求方式,支持所有http的请求方式,主要使用get和post
    //第二个参数表示请求的url地址,get方式请求的参数也在urlKh 
    //第三介参数表示采用异步还是同步方式交互,true表示异步

    //发送数据表示和服务器端交互
    //同步方式下,send这名话会在服务器端数据回来后才执行完
   
    
    //异步方式下,send这句话立即完成执行
    //POST方式请求的代码
    xmlhttp.open("POST","/claim/SaBankSelectCode.do?bankCName="+bankCName,false);
    //POST方式需要自己设置http的请求头
    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    //POST方式发送数据
    xmlhttp.send("");
}

//回调函数
function callback(){
    //判断对象的状态是交互完成
    if(xmlhttp.readyState==4){
        //判断http的交互是否成功
        if(xmlhttp.status==200){
            //获取服务器端返回的数据
            //获取服务器端输出的纯文本数据
            var responseText=xmlhttp.responseText;   
            bankCodeDec(responseText);
        }
    }
}
function bankCodeDec(interfaceTypeStr){
	///alert(interfaceTypeStr);
    var interfaceTypeStr1=eval("("+interfaceTypeStr+")");

    for(var i=0;i<interfaceTypeStr1.res.length-1;i++){
    	cff1[i] = new Array();
    	cff1[i][0]=interfaceTypeStr1.res[i].value;
    	cff1[i][1]=interfaceTypeStr1.res[i].name;
    	cff1[i][2]="";
    }
}

function getMoreTr(){
    var trtag = document.getElementsByTagName("li");
    var taglength = trtag.length;
    var index=0;
    for(var i=0;i<taglength;i++){
         index++;
         if(trtag[i].style.display == 'none'){
             break;
         }
    }
    var size = parseInt(index);
    if(size < taglength-3){
        var trsize = size+parseInt(20);
        if(trsize>taglength-3){
            trsize = taglength;
        }
        for(var i=size;i<trsize;i++){
            var trid = "liId"+i;
            document.getElementById(trid).style.display='';
        }
    }else{
        trtag[taglength-1].style.display == 'none'
    } 
	}


