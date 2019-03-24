/*#############################################################
Name: FormUtil
Version:1.1
Author: zhang dechen
页面html元素的辅助JS
2011年4月27日，对代码进行重构。---张德晨
#############################################################*/
	var Dc,
	fu=Dc=fu||{version:"1.1"};
	var pointLength=2;
	$(document).ready(function(){
		
		fu.option.switchOption();   
		//此方法必须依赖jquery框架，否则会出错
		fu.style.inputStyle();//初始化加载此方法
		fu.object.initDrag();//初始化可拖动列
		fu.style.addRequiredStyle();
	})
	//formUtil简写fu。 fu.option命名空间,此命名空间为操作页签的方法
	fu.option=fu.option||{};
	//fu.validate命名空间，此空间是fu的校验空间
	fu.validate=fu.validate||{};
	//fu.object formutil的辅助方法
	fu.object=fu.object||{};
	//此空间是formUtil操作页面样式空间
	fu.style=fu.style||{};
	/**切换页签*/
	fu.option.switchOption=function(){
		var $div_li =$("div..tab_menu ul li");
		//页签的个数
		var optioncount=$div_li.length;
		var opindex=0;//页签的索引
			//鼠标单击
		    $div_li.click(function(){
				$(this).addClass("selected").siblings().removeClass("selected");
	            opindex =  $div_li.index(this);  //找到<li>子节点的索引
	            $(this).parent("ul").parent("div.tab_menu").parent("div.tab").children("div.tab_box").children("div").eq($(this).parent("ul").children("li").index(this)).show().siblings().hide();
				//$("div.tab_box > div").eq(opindex).show().siblings().hide();
			});
			//给页签加鼠标事件
			$("body").keydown(function(event){
				//Ctrl+左
				if(event.ctrlKey&&event.keyCode=='37'){
		           opindex==0?opindex=0:opindex--;
		           $div_li.eq(opindex).addClass("selected").siblings().removeClass("selected");
		           var divli = $div_li.eq(opindex);
		           $(divli).parent("ul").parent("div.tab_menu").parent("div.tab").children("div.tab_box").children("div").eq($(divli).parent("ul").children("li").index(divli)).show().siblings().hide();
					//$("div.tab_box > div").eq(opindex).show().siblings().hide();
				}if(event.ctrlKey&&event.keyCode=='39'){//右
					opindex==(optioncount-1)?opindex=(optioncount-1):opindex++;
					$div_li.eq(opindex).addClass("selected").siblings().removeClass("selected");
					var divli = $div_li.eq(opindex);
					$(divli).parent("ul").parent("div.tab_menu").parent("div.tab").children("div.tab_box").children("div").eq($(divli).parent("ul").children("li").index(divli)).show().siblings().hide();
					//$("div.tab_box > div").eq(opindex).show().siblings().hide();
				}
			});
		
	}
	//添加必填项样式
	fu.style.addRequiredStyle=function(){
		//必填项样式
	    $('.required').each(function(){
	    	$(this).after("<font color='red'>*</font>");
	    });
	} 
	//控制页签的显隐，index_要显示的页签的序号，下标从0开始
	fu.option.showOrHid=function (index_){
		
		//页签被选中的样式
		$("div..tab_menu ul li").eq(index_).addClass("selected").siblings().removeClass("selected");
		//显示当前页签，隐藏其他页签
		$("div.tab_box > div").eq(index_).show().siblings().hide();
	}
	function FormUtil(){
		
	}
	FormUtil.prototype.initValidate=function (){
			//先校验必填项，如果必填项通过则再去校验规范类型
			return  fu.validate.checkRequired();
	}
	
	//校验必输项，class=requred的为必输
	fu.validate.checkRequired=function(){
		var requireds=$(".required:not(span[notCheckSpan=notCheckSpan] .required)");
			for(i_=0;i_<requireds.length;i_++){
				if(!fu.validate.filterEmpty(requireds[i_])){
					alert(requireds[i_].cnname+'不能为空');
					var index_=requireds[i_].optionindex;//当前输入域所在的页签
					if(index_!=null){						
						fu.option.showOrHid(index_);
					}
					requireds[i_].focus();
					return false;
				}
			}
			//如果页面没有必填项或者必填项通过时则返回true
			return fu.validate.valiCheckType();
	}
	//过滤空的字符
	fu.validate.filterEmpty=function (obj){
		//先判断是不是下拉框
		if(obj[0]==null){//如果不是数组的话，则证明是input输入框或者单选多选框
			//alert('sss'+obj.value.trim());
			if(obj.type=="checkbox"||obj.type=="radio"){
				if(obj.checked==false){//选框没有选中
					return false;
				} 
			}
			if(obj.type=='text'){
				if(obj.value.trim()==''){
					return false;
				}					
			}

			return true;
		}
		if(obj[0]!=null){//下拉框
			//alert(obj[obj.selectedIndex].value);
			if(obj[obj.selectedIndex].value==''||obj[obj.selectedIndex].value=='请选择'){
				return false;
			}return true;
		}
	}
	
	//根据checktype校验输入框输入的内容是否合法，比如Email是否合法，数字类型是否正确
	fu.validate.valiCheckType=function(){
			var allInput=$(":input");
			this.obj=allInput||{};
			//返回标记
			this.reValue=true;
			this.checkAttr=function(args){
				var param=args||{}
				//校验的类型
				this.typename=param.typename||'';
				//输入框里的值
				this.values=param.values||'';
				//中文名称
				this.name_cn=param.name_cn||'';
				//选项卡索引
				this.optionindex_=param.optionindex_||0;
				//元素的索引
				this.attrindex=param.attrindex||0;
				this.minlength_=param.minlength_||0;//最短值
				this.maxlength_=param.maxlength_||0;//最长
				this.valueLength=param.l_||0;//实际输入内容的长度
				this.allInput=param.allInput||{};//页面所有的输入框
				//校验邮箱类型
				this.checkEmail=function(){
					if(!fu.validate.isEmail(this.values)&&this.values!=""){
						alert(this.name_cn+'格式不正确');
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//验证不通过
					}
				}
				//校验金钱格式
				this.checkMoney=function(){
					var temp1=this.values.indexOf(".");
					if(values.substring(temp1).length-1>pointLength){
						alert(this.name_cn+'格式不正确,只允许小数点后'+pointLength+'位');
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//验证不通过
					}else if(!fu.validate.nNegativeNum(this.values)){
						this.msg=this.name_cn+'格式不正确';
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//验证不通过
					}
				}
				//输入框中不能含有汉字
				this.checkNocn=function(){
					if(fu.validate.isHaveCn_z(this.values)&this.values!=''&this.values!='必填项'){
						alert(this.name_cn+'不能含有汉字');
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//验证不通过
					}
				}
				//检验最小值,(不为空时)
				this.checkMin=function(){
					if(this.valueLength<this.minlength_&&this.values!=''&&this.values!='必填项'){
						alert(this.name_cn+'最少为'+this.minlength_+'位字符');
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//验证不通过
					}
				}
				//校验最大输入值
				this.checkMax=function(){
					if(this.valueLength>this.maxlength_){
						alert(this.name_cn+'最多为'+this.maxlength_+'位字符');
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//验证不通过
					}
				}
				//校验是不是正整数
				this.checkPInt=function(){
					if(!fu.validate.valiPInt(this.values)){
						alert(this.name_cn+'只能为整数');
						this.reValue=false;//验证不通过
					}
				}
				return this;
			}
			
			for(i_=0;i_<allInput.length;i_++){
				//只判断输入框里面的内容
				if(allInput[i_].type=='text'){
					//校验的类型
					var typename=allInput[i_].checktype||'';
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
					//当前输入域所在页签的索引，下标从0开始
					var optionindex_=allInput[i_].optionindex;
					typename=typename.toLowerCase().trim();
					var params={typename:typename,values:values,name_cn:name_cn,
					optionindex_:optionindex_,attrindex:i_,minlength_:minlength_,l_:l_,
					maxlength_:maxlength_};
					if(typename!=null&&typename!=""){	
						//校验邮箱类型
						if(typename=='email'){
						  this.checkAttr(params).checkEmail();
						 //金额类型
						}else if(fu.object.splitType(typename)=='money'){
							this.checkAttr(params).checkMoney();
						//输入框中不能有汉字
						}else if(typename=='nocn'){
							this.checkAttr(params).checkNocn();
						//正整数
						}else if(typename=='pinteger'){
							this.checkAttr(params).checkPInt();
						}
					}
					if(minlength_!=null){
						this.checkAttr(params).checkMin();
					}
					if(maxlength_!=null&&values!=''&&values!='必填项'){
						this.checkAttr(params).checkMax();
					}
				}
			}
		
			return this.reValue;
	}
	fu.validate.checkTextArea=function(){
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
	fu.validate.isEmail=function (str) {
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
	 fu.validate.isHaveCn_z=function(str){	
	 	var reg=/[\u4e00-\u9fa5]+/;
	 	return reg.test(str);
	 }
	 //验证是不是非负数, 是非负数的话则返回true
	 fu.validate.nNegativeNum=function(oNum) {   
	  if(oNum==""){return true}
	  if(!oNum) return false;
	  //非负数正则表达式
	  var strP=/^([0-9]\d*|\d+\.\d+)$/;
	  if(!strP.test(oNum)){
	  	return false;
	  } 
	  try{   
	  	if(parseFloat(oNum)!=oNum) return false;   
	  }catch(ex){   
	   	return false;
	  }   
	  	return true;   
	} 
	//校验正整数
	fu.validate.valiPInt=function(str){
		var re = /^[0-9]\d*$/;
		if(!re.test(str)){
			return false;
		}else{return true}
	}
	/**
		格式化金钱类型，比如前台校验类型为meoney(2)//保留小数点后两位,如果不写的话默认为两位
	*/
	fu.object.splitType=function (str){
		var statr=Number(str.indexOf("("))+1;
		var stop=str.indexOf(")");
		if(stop!=-1){
			pointLength =str.substring(statr,stop);
		}
		str=str.replace("(","");
		str=str.replace(")","");
		str=str.replace(pointLength,"");
		return str;
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
	
	fu.style.inputStyle=function(){
    //焦点事件触发
    $('input:text').focus(function(){
		$('textarea').not(".readonly").css({"background-color":""});
		//把背景色设置为空，同时把class为focusinput的设置为input(不直接取classname稍微有点效率问题)
        $("input[ids_fu_=focusTempId]").attr("ids_fu_","").css({"background-color":""});
        //给不包含样式为readyonly的输入框增加样式focusinput,然后设置class为focusinput的背景色（如果在focusinput中直接定义样式的话，第一个次加载的时候不显示样式，刷新一下就好）
        $(this).not(".readonly").attr("ids_fu_","focusTempId").css({"background-color":"#FFFF99"});
    });
	$('textarea').focus(function(){
		$(".focusinput").not(".readonly").attr("class","input");
		$('textarea').not(".readonly").css({"background-color":""});
		$(this).not(".readonly").css('background-color','#FFFF99');
    });
}
		//双击页面最大化
          var isMax=false;//
		  fu.object.showMax=function(){
		  	 var body_="";
		 	 body_=document.getElementsByTagName("body");
		  	 for(i=0;i<body_.length;i++){
		  	 	body_[i].ondblclick=function(){
		  	 		//工作区最大化
		  	 		parent.fraSet.cols = "1,*";
		  	 		parent.topFrame.rows = "0,0,0,*";
		  	 		isMax=true;
		  	 		$(parent.frames["fraInterface"].document).find("div:first").before("<div style='width=100%;height:20px;font-size:12px;text-align:center;padding-top:5px;position:absolute;z-index:100' class='zdc_div'>"
		  	 		+"<div style='position:absolute;z-index:2;background-color:red;width:10%; '>按Esc退出全屏</div>"
		  	 		+"</div>"); 
			  	 	$(parent.frames["fraInterface"].document).find(".zdc_div").fadeOut(2000);
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
		  	 		//退出时清空此页面内容
		  	 		$(parent.frames["fraInterface"].document).find(".zdc_div").remove()
		 	 	}
		  	}
		  }
	/**拖动table列宽度*/
fu.object.drag=function (o,r){
	
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
 fu.object.delHtmlTag=function (str){ 
             return str.replace(/<\/?.+?>/g,"");//去掉所有的html标记 
}
/**
	计算列应该显示的宽度
	汉字按11PX算，数字字母，以及标点按6PX算
*/
fu.object.showLength=function (str){
	str=fu.object.delHtmlTag(str);
	var oldLen=str.length;//原来文本的长度。
	var cnLen=str.replace(/[^\u4e00-\u9fa5]/gi,"").length;//把非汉字的字符去掉后的长度,也就是汉字的个数
	var noCnLen=(Number(oldLen)-Number(cnLen));//非汉字的个数，按7px计算
	var countLength=cnLen*16+noCnLen*9;
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
		fu.object.showLength(innerText);
		//alert(innerText);
		if(innerText != null) {
			var textString =  new String(innerText);
			textString=fu.object.delHtmlTag(textString);
			if(textString.length > maxwidth) {
				maxwidth = fu.object.showLength(textString);
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
fu.object.initDrag=function (){
	//用jQuery的方法，效率高很多
	var drag_=$(".resizeDivClass");
	if(drag_!=null){
		for(i=0;i<drag_.length;i++){
			fu.object.drag(drag_[i]);
		}
	}
}
	/**拖动table列宽度end*/
	
fu.style.niceButton=function (divid,icon){
	var func=$("#"+divid).attr("nclick");
	if(icon==null){
		icon='appgo';
	}
	var botton_table='<table class="button_table over" cellpadding="0" cellspacing="0">'+
		'<tr>'+
		'<td class="b_left"></td>'+
		'<td class="b_center">'+
		'<a class="'+icon+'" onclick='+func+'>'+$("#"+divid).html()+'</a>'+
		'</td>'+
		'<td class="b_right"></td>'+
		'<TD><SPAN class=spacer></SPAN></TD>'+
		'</tr>'+
		'</table>';
	$("#"+divid).html(botton_table);
	$(".button_table").mousedown(function(){
          		$(this).addClass("down");
          		 $(this).bind('mouseup', function () {
		            $(this).removeClass('down');
		            $(this).unbind('mouseup');
          		});
    })  
}
//带下拉框的按钮
fu.style.buttonSelect=function (divid,icon){
	var func=$("#"+divid).attr("nclick");
	var selectFunc=$("#"+divid).attr("selectEvent");
	
	if(icon==null){
		icon='appgo';
	}
	var botton_table='<table class="button_table over" cellpadding="0" cellspacing="0">'+
		'<tr>'+
		'<td class="b_left"></td>'+
		'<td class="b_center"><a style="float:left" class="'+icon+'" onclick="fu.style.creatDiv(this)"></a>'+
		'<a onclick='+func+'>'+$("#"+divid).html()+'</a>'+
		'</td>'+
		'<td class="b_right"></td>'+
		'<TD><SPAN class=spacer></SPAN></TD>'+
		'</tr>'+
		'</table>';
	$("#"+divid).html(botton_table);
	$(".button_table").mousedown(function(){
          		$(this).addClass("down");
          		 $(this).bind('mouseup', function () {
		            $(this).removeClass('down');
		            $(this).unbind('mouseup');
          		});
    }); 
    return this;
}
fu.object.task="";
fu.style.creatDiv=function(obj){
	var $body=$(parent.frames["fraInterface"].document).find("table:first");
	var leftx=event.x-195;
	var panel=$("<div><div style='position:absolute;z-index:10;width:100%;padding-left:"+leftx+"px' id='panel'><div style='position:absolute;z-index:10;background-color:#BFD4F0;width:40%;border:2px solid #268598;'></div></div><div>")
	var ul=$("<ul style=''><ul>");
	var li=fu.object.task;
	
	ul.append(li);
	$(panel).find("#panel div").append($(ul).html());;
	$($body).before($(panel).html());
	$(parent.frames["fraInterface"].document).find("body").click(function(){
		fu.style.removeDiv();
	});
}
fu.style.removeDiv=function(){
	var $body=$(parent.frames["fraInterface"].document).find("body");
	$($body).find("#panel").html("");
}
 fu.style.niceBar=function(divid,icon){
	var func=$("#"+divid).attr("nclick");
	if(icon==null){
		icon='appgo';
	}
	var botton_table='<table class="button_table" cellpadding="0" cellspacing="0">'+
		'<tr>'+
		'<td class="b_left"></td>'+
		'<td class="b_center">'+
		'<a class="'+icon+'" onclick='+func+'>'+$("#"+divid).html()+'</a>'+
		'</td>'+
		'<td class="b_right"></td>'+
		'<TD><SPAN class=spacer></SPAN></TD>'+
		'</tr>'+
		'</table>';
	$("#"+divid).html(botton_table);
	//鼠标按下事件
	$(".button_table").mousedown(function(){
          		$(this).addClass("down");
          		 $(this).bind('mouseup', function () {
		            $(this).removeClass('down');
		            $(this).unbind('mouseup');
          		});
    });
    //鼠标放上事件
    $(".button_table").mouseover(function(){
    	$(this).addClass("over");
    	//鼠标移开
    	$(this).bind('mouseout', function () {
             $(this).removeClass('over');
              $(this).removeClass('down');
            });
    })
}
//可编辑的下拉框
fu.style.editSelect=function(param){
	this.obj=param||{};
	this.divclass=this.obj.divclass;
	this.inputname=this.obj.inputname||"";
	this.options=this.obj.option||[];
	var options="";
	
	for(i1=0;i1<this.options.length;i1++){
		//options+="<option></option>"
		options+="<option value='"+this.options[i1]+"'>"+this.options[i1]+"</option>"
	}
	this.$div=$("."+this.divclass);
	this.$div.addClass("combobx");
	this.input_=$('<input id="inputid1" onclick="fu.object.clearInput(this)" type="text"  name="'+this.$div.attr("name")+'" />');
	this.select=$("<select id='selectid' onchange=fu.object.changeOption(this)>"
	+options+
	"</select>")
	this.$div.append(this.input_);
	fu.object.initEditSelectValue(this.divclass);
	this.$div.append(this.select);
}
fu.object.initEditSelectValue=function(divClass){
	
	$("."+divClass).each(function(){
		$(this).find("input").val($(this).text());
	})
}
fu.object.changeOption=function(param){
	var selectObj1 =$(param).parent().find("select");
    // 将当前选中的下拉框选项文本赋值给TxtBox
    $(param).parent().find("input[type=text]").val(selectObj1.attr("options")[selectObj1.attr("selectedIndex")].innerHTML)
}
fu.object.clearInput=function(obj){
	
	if($(obj).val()=='请选择或者填写'){
		$(obj).val("");
	}
}
function HashMap()  
 {  
     /** Map 大小 **/  
     var size = 0;  
     /** 对象 **/  
     var entry = new Object();  
       
     /** 存 **/  
     this.put = function (key , value)  
     {  
         if(!this.containsKey(key))  
         {  
             size ++ ;  
         }  
         entry[key] = value;  
     }  
       
     /** 取 **/  
     this.get = function (key)  
     {  
         return this.containsKey(key) ? entry[key] : null;  
     }  
       
     /** 删除 **/  
     this.remove = function ( key )  
     {  
         if( this.containsKey(key) && ( delete entry[key] ) )  
         {  
             size --;  
         }  
     }  
       
     /** 是否包含 Key **/  
     this.containsKey = function ( key )  
     {  
         return (key in entry);  
     }  
       
     /** 是否包含 Value **/  
     this.containsValue = function ( value )  
     {  
         for(var prop in entry)  
         {  
             if(entry[prop] == value)  
             {  
                 return true;  
             }  
         }  
         return false;  
     }  
       
     /** 所有 Value **/  
     this.values = function ()  
     {  
         var values = new Array();  
         for(var prop in entry)  
         {  
             values.push(entry[prop]);  
         }  
         return values;  
     }  
       
     /** 所有 Key **/  
     this.keys = function ()  
     {  
         var keys = new Array();  
         for(var prop in entry)  
         {  
             keys.push(prop);  
         }  
         return keys;  
     }  
       
     /** Map Size **/  
     this.size = function ()  
     {  
         return size;  
     }  
       
     /* 清空 */  
     this.clear = function ()  
     {  
         size = 0;  
         entry = new Object();  
     }  
 } 
 /*
 在本页面打开一个层，把数据放到层里面，关闭的时候把数据存到本页面，然后提交后台
 **/
 fu.object.layer=function(param){
 	var temp_layer_div="";
 	//隐藏内容所在的div的ID,
 	var div_id=param.divid||"";
 	//把这个弹出的DIV放到哪个页面元素后面
 	var layeraftertd=param.tdid||"";
 	var event=param.exeEvent||"";
 	if(temp_layer_div==""||temp_layer_div==null){
		temp_layer_div=$("#"+div_id).html();//把导入的DIV里的值赋给中间变量
		$("#"+div_id).html("");//然后把底部数据清空
	}
	var layer_div_html= $("#"+layeraftertd+" div").html();
	if(layer_div_html==null||layer_div_html==""){
		$('#'+layeraftertd+' div').css("display","");
		$('#'+layeraftertd+' div').append("<div id='panel_div_payment' style='position: absolute;z-index: 100;float:rigth;width:970px;text-align:center;border:1px solid #7AA3C4;background-color:#F7F7F7'>"+temp_layer_div+""+
		"<span style='background-color:#F7F7F7;width:100%'><input type='button'  class='button' value='关闭' onclick=\"fu.object.close_layer({divid:'"+div_id+"',tdid:'"+layeraftertd+"',closetype:'0'})\">"+
		"<input type='button' class='button' style='text-align:center' value='保存' onclick=\"fu.object.close_layer({divid:'"+div_id+"',tdid:'"+layeraftertd+"',closetype:'1',exeEvent:'"+event+"'})\">"+
		"</span>"+
		"</div>");
	}else{
			$('#'+layeraftertd+' div').css("display","");
	}
 }
 /**
 	@param:divid
 */
fu.object.Ajaxlayer=function(divid,tdid,uri,param){
 var temp_layer_div="";
 	//内容所在的div的ID
 	var div_id=divid||"";
 	//把这个弹出的DIV放到哪个页面元素后面
 	var layeraftertd=tdid||"";
	var layer_div_html= $("#"+layeraftertd+" div").html();
	
 	if((layer_div_html==null||layer_div_html=="")){
 		var waitImg="<span  style='height:50px;'>程序正在加载，请稍后<img src='/newclaim/images/loading_2.gif'  style='padding-top:20px'/></span>";
 		fu.object.create(waitImg,layer_div_html,layeraftertd,div_id);
 		$.ajax({
 			type:"post",
 			url:uri,
 			//async: false,
 			data:$.param(param),
 			success:function(data){
 				temp_layer_div=data;
 				//清空弹出区域
 				$('#'+layeraftertd+' div').html("");
 				fu.object.create(temp_layer_div,layer_div_html,layeraftertd,div_id);
 			}
 		})
	}else{
		fu.object.create(temp_layer_div,layer_div_html,layeraftertd,div_id);
	}
	
 }
 fu.object.create=function(temp_layer_div,layer_div_html,layeraftertd,div_id){
 	//如果没有内容，则添加
	if(layer_div_html==null||layer_div_html==""){
		//让层显示
		$('#'+layeraftertd+' div').css("display","");
		//向层上添加内容
		$('#'+layeraftertd+' div').append("<div id='panel_div_payment' style='position: absolute;z-index: 100;float:rigth;width:1000px;text-align:center;border:1px solid #7AA3C4;background-color:#F7F7F7'>"+temp_layer_div+""+
		"<span style='background-color:#F7F7F7;width:100%'><input type='button'  class='button' value='关闭' onclick=\"fu.object.close_layer({divid:'"+div_id+"',tdid:'"+layeraftertd+"',closetype:'0'})\">"+
		"<input type='button' class='button' style='text-align:center' value='保存' onclick=\"fu.object.close_layer({divid:'"+div_id+"',tdid:'"+layeraftertd+"',closetype:'1'})\">"+
		"</span>"+
		"</div>");
	//如果有内容，则显示
	}else{
		$('#'+layeraftertd+' div').css("display","");
	}
 }
  fu.object.close_layer=function(params){
  //内容所在的div的ID
 	var div_id=params.divid||"";
 	//把这个弹出的DIV放到哪个页面元素后面
 	var layeraftertd=params.tdid||"";
 	var events=params.exeEvent||"";
 	close_type=params.closetype;
 		//关闭
		if(close_type=='0'){
			$('#'+layeraftertd+' div').css("display","none");
		//保存
		}else if(close_type=='1'){
			//执行方法
	 		var tempFun=eval(events);
			//如果被执行的方法返回false则关闭层
		 	if(tempFun==false){
		 		return ;
		 	}
			$('#'+layeraftertd+' div').css("display","none");
		}
	}
