/*#############################################################
Name: FormUtil
Version:1.0
Author: zhang dechen
页面html元素的辅助JS
#############################################################*/
	
	
	$(document).ready(function(){
		//页签
		/*var $div_li =$("div..tab_menu ul li");
		   
		    $div_li.click(function(){
				$(this).addClass("selected")
					   .siblings().removeClass("selected");
var parChild=$(this).parent().children();
	            var index =  parChild.index(this);  //找到<li>子节点的索引
var p=$(this).parent().parent().parent();
//alert(p.html());
var tab_box=p.find('div').eq(1).children();
//alert(tab_box.html());

var selectDiv=tab_box.eq(index);
//alert(selectDiv.html());

selectDiv.show();
selectDiv.siblings().hide();
				
			}).hover(function(){//鼠标放上去的样式
				$(this).addClass("hover");
			},function(){
				$(this).removeClass("hover");
		});
		//页签end
		//此方法必须依赖jquery框架，否则会出错
		//inputStyle();//初始化加载此方法
		//showMax();
		//initDrag();//初始化可拖动列
	*/});
	
	function FormUtil(){
		//FormUtil的构造函数
		//inputStyle();//初始化加载此方法
		//调用valiCheckType方法
		//valiCheckType();
		//checkTextArea();
	}
	FormUtil.prototype.initValidate=function (){
			//先校验必填项，如果必填项通过则再去校验规范类型
			if(checkRequired()){
				valiCheckType();
				checkTextArea();				
			}
			
	}
	//校验必输项，class=requred的为必输
	function checkRequired(){
		var requireds=getElementsByClassName("required");
			for(i_=0;i_<requireds.length;i_++){
				if(requireds[i_].value.trim()==''||requireds[i_].value=='必填项'){
					alert(requireds[i_].cnname+'不能为空');
					requireds[i_].focus();
					return false;
				}
			}
			//如果页面没有必填项或者必填项通过时则返回true
			return true;
	}
	
	
	//根据checktype校验输入框输入的内容是否合法，比如Email是否合法，数字类型是否正确
	function valiCheckType(){
			
			var allInput=document.getElementsByTagName("input");
			for(i_=0;i_<allInput.length;i_++){
				//只判断输入框里面的内容
				
				if(allInput[i_].type=='text'){
					//校验的类型
					var typename=allInput[i_].checktype;
					//输入框里的值
					var values=allInput[i_].value;
					//中文名称
					var name_cn=allInput[i_].cnname;
					//最少输入值的长度
					var minlength_=allInput[i_].minlen;
					//输入框最大允许输入的值
					var maxlength_=allInput[i_].maxlen;
					//输入框值的长度
					var l_=values.getLength();
					if(typename!=null){	
						typename=typename.toLowerCase().trim();
						//校验邮箱类型
						if(typename=='email'){
						   if(!isEmail(values)){
							   alert(name_cn+'格式不正确');
							   return false;
						   }
						}
						//输入框中不能有汉字
						if(typename=='nocn'){
							if(isHaveCn_z(values)&values!=''&values!='必填项'){
								alert(name_cn+'不能含有汉字');
								allInput[i_].focus();
								return false;
							}
						}
						//valiCheckType_(typename);							
					}
					if(minlength_!=null){
						
						if(l_<minlength_&values!=''&values!='必填项'){
							alert(name_cn+'最少为'+minlength_+'位字符');
							allInput[i_].focus();
							return false;
						}
					}
					if(maxlength_!=null&values!=''&values!='必填项'){
						if(l_>maxlength_){
							alert(name_cn+'最多为'+maxlength_+'位字符');
							allInput[i_].focus();
							return false;
						}
					}
				}
			}
	}
	//校验长度，最长和最短
	function valiStrLength(){
		var allInput=document.getElementsByTagName("input");
	}
	function checkTextArea(){
		var tareas=document.getElementsByTagName('textarea');
		for(i_=0;i_<tareas.length;i_++){
			//校验的类型
			var typename=tareas[i_].checktype;
			//输入框里的值
			var values=tareas[i_].value;
			//中文名称
			var name_cn=tareas[i_].cnname;
			//最少输入值的长度
			var minlength_=tareas[i_].minlen;
			//输入框最大允许输入的值
			var maxlength_=tareas[i_].maxlen;
			//输入框值的长度
			var l_=values.getLength();
			if(minlength_!=null){
						
					if(l_<minlength_&values!=''&values!='必填项'){
							alert(name_cn+'最少为'+minlength_+'位字符');
							tareas[i_].focus();
							return false;
						}
					}
					if(maxlength_!=null&values!=''&values!='必填项'){
						if(l_>maxlength_){
							alert(name_cn+'最多为'+maxlength_+'位字符');
							tareas[i_].focus();
							return false;
						}
					}
		}
	}
	//根据class名字得到页面元素
	function getElementsByClassName(n) {  
	    var el = [], 
	        _el = document.getElementsByTagName('*'); 
	    for (var i=0; i<_el.length; i++ ) { 
	       if (_el[i].className.trim() == n ) { 
	           el[el.length] = _el[i]; 
	        } 
	   } 
	   return el; 
	} 
	//根据checktype(自己定义的检查类型)得到页面元素
	function getElementsByCheckType(n_){
		var el = [], 
	        _el = document.getElementsByTagName('*'); 
	    for (var i=0; i<_el.length; i++ ) { 
	       if (_el[i].checktype == n_ ) { 
	           el[el.length] = _el[i]; 
	        } 
	   } 
	   return el; 	
	}
	//js实现replaceAll
    String.prototype.replaceAll  = function(s1,s2){    
		return this.replace(new RegExp(s1,"gm"),s2);    
	}  
	String.prototype.startWith=function(str){
	  if(str==null||str==""||this.length==0||str.length>this.length)
	   return false;
	  if(this.substr(0,str.length)==str)
	     return true;
	  else
	     return false;
	  return true;
  }
  //去空格
  String.prototype.trim = function() { 
		return this.replace(/(^\s*)|(\s*$)/g, ""); 
  } 
	 //检查输入对象的值是否符合E-Mail格式
	function isEmail(str) {
			var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+.)+[A-Za-z0-9]{2,3}$/;
			if(myReg.test(str)) return true;
			return false;
	}
	//校验长度，包括中文
	String.prototype.getLength = function() {    
				var cArr = this.match(/[^\x00-\xff]/ig);    
				return this.length + (cArr == null ? 0 : cArr.length);    
	} 
	//校验是否含有汉字,如果有汉字的话则返回true;
	 function isHaveCn_z(str){	
	 	var reg=/[\u4e00-\u9fa5]+/;
	 	return reg.test(str);
	 }
	  /**
       * 序号
      */
	 function setIndex(id_){
		$("#"+id_+" .indextd").each(function(index){
				$(this).html(index+1)
		})
	}
	/**
	*复制一个tbody或tr内容，新增一行或多行
	*fromid:被复制的div元素
	*isindex,是否显示序号
	*/
	//声明一个全局变量用来保存html信息
	var copyHTML="";
	function copyRow(fromid,isindex){
		if(copyHTML==""){
			copyHTML=$("#"+fromid+":tr:last").html();
		}
		$("#"+fromid+":tr:last").append(copyHTML);
		if(isindex!=null&&isindex!=""){
			setIndex();
		}
	}
	
	function inputStyle(){
	//点击事件触发,不包class为readyonly的输入框
	$('input:text').click(function(){
           			$('input:text').not(".readonly").css({"background-color":""});
           			$('textarea').not(".readonly").css({"background-color":""});
           			$(this).not(".readonly").css('background-color','#FFFF99');
    });
    //焦点事件触发
    $('input:text').focus(function(){
           			$('input:text').not(".readonly").css({"background-color":""});
           			$('textarea').not(".readonly").css({"background-color":""});
           			$(this).not(".readonly").css('background-color','#FFFF99');
    });
	$('textarea').click(function(){
           			$('input:text').not(".readonly").css({"background-color":""});
           			$('textarea').not(".readonly").css({"background-color":""});
           			$(this).not(".readonly").css('background-color','#FFFF99');
    });
	$('textarea').focus(function(){
           			$('input:text').not(".readonly").css({"background-color":""});
           			$('textarea').not(".readonly").css({"background-color":""});
           			$(this).not(".readonly").css('background-color','#FFFF99');
    });
    //必填项样式
    $('.required').each(function(){
    	$(this).after("<font color='red'>*</font>");
    });
   
    var requiredElement=getElementsByClassName('required');
    //把所有class为Wdate的样式都改为hand
    var hand=getElementsByClassName('Wdate');
    for(i=0;i<hand.length;i++){
    	hand[i].style.cursor='hand';
    }

}
		
		
		
		//双击页面最大化
          var isMax=false;//
		  function showMax(){
		  	 var body_="";
		 	 body_=document.getElementsByTagName("body");
		  	 for(i=0;i<body_.length;i++){
		  	 	body_[i].ondblclick=function(){
		  	 		//工作区最大化
		  	 		//if(!isMax){
			  	 		parent.fraSet.cols = "1,*";
			  	 		parent.topFrame.rows = "0,0,0,*";
			  	 		isMax=true;
			  	 	
		  	 		//}
		  	 	}
		  	 }
		  }
		  document.onkeyup=function(){
		  	//按ESC退出全屏
		  	if(event.keyCode==27){
		  		var body_="";
		 	 	body_=document.getElementsByTagName("body");
		 	 	for(i=0;i<body_.length;i++){
	 	 			parent.fraSet.cols = "150,*";
		  	 		parent.topFrame.rows = "82,0,0,*";
		  	 		isMax=false;
		 	 	}
		  	}
		  }
	/**拖动table列宽度*/
function drag(o,r){
	o.p_p_c_gw=function(index)/*取得 o.parentNode.parentNode.cells的宽度，兼容IE6和Firefox*/{
	if(window.ActiveXObject){
	return o.parentNode.parentNode.cells[o.parentNode.cellIndex+index].offsetWidth;
	}else{
	return parseInt(o.parentNode.parentNode.cells[o.parentNode.cellIndex+index].offsetWidth)-
	parseInt(o.parentNode.parentNode.parentNode.parentNode.cellPadding)*2-2;
	}
}

o.p_p_p_sw=function(index,w)/*设置所有行的第index个单元格为w，在IE下可只设第一行*/{
	for(var i=0;i<o.parentNode.parentNode.parentNode.parentNode.rows.length;i++) {
	o.parentNode.parentNode.parentNode.parentNode.rows[i].cells[index].style.width=w;
	}
}

/**
*正则去html标记
*/
 function delHtmlTag(str){ 
             return str.replace(/<\/?.+?>/g,"");//去掉所有的html标记 
}
/**
	计算列应该显示的宽度
	汉字按11PX算，数字字母，以及标点按6PX算
*/
function showLength(str){
	str=delHtmlTag(str);
	var oldLen=str.length;//原来文本的长度。
	var cnLen=str.replace(/[^\u4e00-\u9fa5]/gi,"").length;//把非汉字的字符去掉后的长度,也就是汉字的个数
	var noCnLen=(Number(oldLen)-Number(cnLen));//非汉字的个数，按7px计算
	var countLength=cnLen*14+noCnLen*9;
	return countLength;
}
var out=document.getElementById('my');

o.firstChild.onmousedown=function(){return false;};
o.ondblclick=function(){

	
	var maxwidth = 0;
	
	// 取得某列的最大宽度
	for(var i=1;i<o.parentNode.parentNode.parentNode.parentNode.rows.length;i++) {
		// o.parentNode.parentNode.parentNode.rows[i].cells[o.parentNode.cellIndex].childNodes[2].innerHTML;
		var innerText = o.parentNode.parentNode.parentNode.parentNode.rows[i].cells[o.parentNode.cellIndex].innerHTML;
		showLength(innerText);
		//alert(innerText);
		if(innerText != null) {
			var textString =  new String(innerText);
			textString=delHtmlTag(textString);
			if(textString.length > maxwidth) {
				maxwidth = showLength(textString);
			}
		}
	}
	//alert(o.parentNode.cellIndex);
	o.p_p_p_sw(o.parentNode.cellIndex,maxwidth==0?"50":maxwidth);
	//o.p_p_p_sw(o.parentNode.cellIndex+1,o.p_p_c_gw(1) + o.p_p_c_gw(0) - maxwidth * 15);
}

o.onmousedown=function(a){
	var d=document;if(!a)a=window.event;
	var lastX=a.clientX;
	var watch_dog=o.p_p_c_gw(0)+o.p_p_c_gw(1);//有时候拖拽过快表格会变大，至于为什么会这样我也不清楚。 watch_dog是为了保证表格不会变大，
	if(o.setCapture)
	o.setCapture();
	else if(window.captureEvents)
	window.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);
	//
	d.onmousemove=function(a){
	if(!a)a=window.event;
	if(o.p_p_c_gw(0)+o.p_p_c_gw(1)>watch_dog){
	o.p_p_p_sw(o.parentNode.cellIndex+1,watch_dog-o.p_p_c_gw(0));
	return;
	}
	var t=a.clientX-lastX;out.innerHTML=t;
	if(t>0) {//right
	if(parseInt(o.parentNode.parentNode.cells[o.parentNode.cellIndex+1].style.width)-t<10)
	return;
	o.p_p_p_sw(o.parentNode.cellIndex,o.p_p_c_gw(0)+t);
	o.p_p_p_sw(o.parentNode.cellIndex+1,o.p_p_c_gw(1)-t);
	} else {//left
	if(parseInt(o.parentNode.parentNode.cells[o.parentNode.cellIndex].style.width)+t<10)
	return;
	o.p_p_p_sw(o.parentNode.cellIndex,o.p_p_c_gw(0)+t);
	o.p_p_p_sw(o.parentNode.cellIndex+1,o.p_p_c_gw(1)-t);
	}
	lastX=a.clientX;
};
d.onmouseup=function(){
	if(o.releaseCapture)
		o.releaseCapture();
		else if(window.captureEvents)
		window.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);
		d.onmousemove=null;
		d.onmouseup=null;
		};
	};
}
//初始化列拖动事件
function initDrag(){
	var drag_=getElementsByClassName("resizeDivClass");
	if(drag_!=null){
		for(i=0;i<drag_.length;i++){
			drag(drag_[i]);
		}
	}
}
	/**拖动table列宽度end*/