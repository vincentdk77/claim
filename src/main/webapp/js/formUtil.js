/*#############################################################
Name: FormUtil
Version:1.1
Author: zhang dechen
ҳ��htmlԪ�صĸ���JS
2011��4��27�գ��Դ�������ع���---�ŵ³�
#############################################################*/
	var Dc,
	fu=Dc=fu||{version:"1.1"};
	var pointLength=2;
	$(document).ready(function(){
		
		fu.option.switchOption();   
		//�˷�����������jquery��ܣ���������
		fu.style.inputStyle();//��ʼ�����ش˷���
		fu.object.initDrag();//��ʼ�����϶���
		fu.style.addRequiredStyle();
	})
	//formUtil��дfu�� fu.option�����ռ�,�������ռ�Ϊ����ҳǩ�ķ���
	fu.option=fu.option||{};
	//fu.validate�����ռ䣬�˿ռ���fu��У��ռ�
	fu.validate=fu.validate||{};
	//fu.object formutil�ĸ�������
	fu.object=fu.object||{};
	//�˿ռ���formUtil����ҳ����ʽ�ռ�
	fu.style=fu.style||{};
	/**�л�ҳǩ*/
	fu.option.switchOption=function(){
		var $div_li =$("div..tab_menu ul li");
		//ҳǩ�ĸ���
		var optioncount=$div_li.length;
		var opindex=0;//ҳǩ������
			//��굥��
		    $div_li.click(function(){
				$(this).addClass("selected").siblings().removeClass("selected");
	            opindex =  $div_li.index(this);  //�ҵ�<li>�ӽڵ������
	            $(this).parent("ul").parent("div.tab_menu").parent("div.tab").children("div.tab_box").children("div").eq($(this).parent("ul").children("li").index(this)).show().siblings().hide();
				//$("div.tab_box > div").eq(opindex).show().siblings().hide();
			});
			//��ҳǩ������¼�
			$("body").keydown(function(event){
				//Ctrl+��
				if(event.ctrlKey&&event.keyCode=='37'){
		           opindex==0?opindex=0:opindex--;
		           $div_li.eq(opindex).addClass("selected").siblings().removeClass("selected");
		           var divli = $div_li.eq(opindex);
		           $(divli).parent("ul").parent("div.tab_menu").parent("div.tab").children("div.tab_box").children("div").eq($(divli).parent("ul").children("li").index(divli)).show().siblings().hide();
					//$("div.tab_box > div").eq(opindex).show().siblings().hide();
				}if(event.ctrlKey&&event.keyCode=='39'){//��
					opindex==(optioncount-1)?opindex=(optioncount-1):opindex++;
					$div_li.eq(opindex).addClass("selected").siblings().removeClass("selected");
					var divli = $div_li.eq(opindex);
					$(divli).parent("ul").parent("div.tab_menu").parent("div.tab").children("div.tab_box").children("div").eq($(divli).parent("ul").children("li").index(divli)).show().siblings().hide();
					//$("div.tab_box > div").eq(opindex).show().siblings().hide();
				}
			});
		
	}
	//��ӱ�������ʽ
	fu.style.addRequiredStyle=function(){
		//��������ʽ
	    $('.required').each(function(){
	    	$(this).after("<font color='red'>*</font>");
	    });
	} 
	//����ҳǩ��������index_Ҫ��ʾ��ҳǩ����ţ��±��0��ʼ
	fu.option.showOrHid=function (index_){
		
		//ҳǩ��ѡ�е���ʽ
		$("div..tab_menu ul li").eq(index_).addClass("selected").siblings().removeClass("selected");
		//��ʾ��ǰҳǩ����������ҳǩ
		$("div.tab_box > div").eq(index_).show().siblings().hide();
	}
	function FormUtil(){
		
	}
	FormUtil.prototype.initValidate=function (){
			//��У���������������ͨ������ȥУ��淶����
			return  fu.validate.checkRequired();
	}
	
	//У������class=requred��Ϊ����
	fu.validate.checkRequired=function(){
		var requireds=$(".required:not(span[notCheckSpan=notCheckSpan] .required)");
			for(i_=0;i_<requireds.length;i_++){
				if(!fu.validate.filterEmpty(requireds[i_])){
					alert(requireds[i_].cnname+'����Ϊ��');
					var index_=requireds[i_].optionindex;//��ǰ���������ڵ�ҳǩ
					if(index_!=null){						
						fu.option.showOrHid(index_);
					}
					requireds[i_].focus();
					return false;
				}
			}
			//���ҳ��û�б�������߱�����ͨ��ʱ�򷵻�true
			return fu.validate.valiCheckType();
	}
	//���˿յ��ַ�
	fu.validate.filterEmpty=function (obj){
		//���ж��ǲ���������
		if(obj[0]==null){//�����������Ļ�����֤����input�������ߵ�ѡ��ѡ��
			//alert('sss'+obj.value.trim());
			if(obj.type=="checkbox"||obj.type=="radio"){
				if(obj.checked==false){//ѡ��û��ѡ��
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
		if(obj[0]!=null){//������
			//alert(obj[obj.selectedIndex].value);
			if(obj[obj.selectedIndex].value==''||obj[obj.selectedIndex].value=='��ѡ��'){
				return false;
			}return true;
		}
	}
	
	//����checktypeУ�����������������Ƿ�Ϸ�������Email�Ƿ�Ϸ������������Ƿ���ȷ
	fu.validate.valiCheckType=function(){
			var allInput=$(":input");
			this.obj=allInput||{};
			//���ر��
			this.reValue=true;
			this.checkAttr=function(args){
				var param=args||{}
				//У�������
				this.typename=param.typename||'';
				//��������ֵ
				this.values=param.values||'';
				//��������
				this.name_cn=param.name_cn||'';
				//ѡ�����
				this.optionindex_=param.optionindex_||0;
				//Ԫ�ص�����
				this.attrindex=param.attrindex||0;
				this.minlength_=param.minlength_||0;//���ֵ
				this.maxlength_=param.maxlength_||0;//�
				this.valueLength=param.l_||0;//ʵ���������ݵĳ���
				this.allInput=param.allInput||{};//ҳ�����е������
				//У����������
				this.checkEmail=function(){
					if(!fu.validate.isEmail(this.values)&&this.values!=""){
						alert(this.name_cn+'��ʽ����ȷ');
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//��֤��ͨ��
					}
				}
				//У���Ǯ��ʽ
				this.checkMoney=function(){
					var temp1=this.values.indexOf(".");
					if(values.substring(temp1).length-1>pointLength){
						alert(this.name_cn+'��ʽ����ȷ,ֻ����С�����'+pointLength+'λ');
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//��֤��ͨ��
					}else if(!fu.validate.nNegativeNum(this.values)){
						this.msg=this.name_cn+'��ʽ����ȷ';
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//��֤��ͨ��
					}
				}
				//������в��ܺ��к���
				this.checkNocn=function(){
					if(fu.validate.isHaveCn_z(this.values)&this.values!=''&this.values!='������'){
						alert(this.name_cn+'���ܺ��к���');
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//��֤��ͨ��
					}
				}
				//������Сֵ,(��Ϊ��ʱ)
				this.checkMin=function(){
					if(this.valueLength<this.minlength_&&this.values!=''&&this.values!='������'){
						alert(this.name_cn+'����Ϊ'+this.minlength_+'λ�ַ�');
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//��֤��ͨ��
					}
				}
				//У���������ֵ
				this.checkMax=function(){
					if(this.valueLength>this.maxlength_){
						alert(this.name_cn+'���Ϊ'+this.maxlength_+'λ�ַ�');
						if(this.optionindex_!=null){fu.option.showOrHid(this.optionindex_);}
						this.obj[this.attrindex].focus();
						this.reValue=false;//��֤��ͨ��
					}
				}
				//У���ǲ���������
				this.checkPInt=function(){
					if(!fu.validate.valiPInt(this.values)){
						alert(this.name_cn+'ֻ��Ϊ����');
						this.reValue=false;//��֤��ͨ��
					}
				}
				return this;
			}
			
			for(i_=0;i_<allInput.length;i_++){
				//ֻ�ж���������������
				if(allInput[i_].type=='text'){
					//У�������
					var typename=allInput[i_].checktype||'';
					//��������ֵ
					var values=allInput[i_].value;
					//��������
					var name_cn=allInput[i_].cnname;
					//��������ֵ�ĳ���
					var minlength_=allInput[i_].minlen;
				
					//�����������������ֵ
					var maxlength_=allInput[i_].maxlen;
					//�����ֵ�ĳ���
					var l_=values.getLength();
					//��ǰ����������ҳǩ���������±��0��ʼ
					var optionindex_=allInput[i_].optionindex;
					typename=typename.toLowerCase().trim();
					var params={typename:typename,values:values,name_cn:name_cn,
					optionindex_:optionindex_,attrindex:i_,minlength_:minlength_,l_:l_,
					maxlength_:maxlength_};
					if(typename!=null&&typename!=""){	
						//У����������
						if(typename=='email'){
						  this.checkAttr(params).checkEmail();
						 //�������
						}else if(fu.object.splitType(typename)=='money'){
							this.checkAttr(params).checkMoney();
						//������в����к���
						}else if(typename=='nocn'){
							this.checkAttr(params).checkNocn();
						//������
						}else if(typename=='pinteger'){
							this.checkAttr(params).checkPInt();
						}
					}
					if(minlength_!=null){
						this.checkAttr(params).checkMin();
					}
					if(maxlength_!=null&&values!=''&&values!='������'){
						this.checkAttr(params).checkMax();
					}
				}
			}
		
			return this.reValue;
	}
	fu.validate.checkTextArea=function(){
		var tareas=document.getElementsByTagName('textarea');
		for(i_=0;i_<tareas.length;i_++){
			//У�������
			var typename=tareas[i_].checktype;
			//��������ֵ
			var values=tareas[i_].value;
			//��������
			var name_cn=tareas[i_].cnname;
			//��������ֵ�ĳ���
			var minlength_=tareas[i_].minlen;
			//�����������������ֵ
			var maxlength_=tareas[i_].maxlen;
			//�����ֵ�ĳ���
			var l_=values.getLength();
			if(minlength_!=null){
						
					if(l_<minlength_&values!=''&values!='������'){
							alert(name_cn+'����Ϊ'+minlength_+'λ�ַ�');
							tareas[i_].focus();
							return false;
						}
					}
					if(maxlength_!=null&values!=''&values!='������'){
						if(l_>maxlength_){
							alert(name_cn+'���Ϊ'+maxlength_+'λ�ַ�');
							tareas[i_].focus();
							return false;
						}
					}
		}
	}
	//����class���ֵõ�ҳ��Ԫ��
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
	//����checktype(�Լ�����ļ������)�õ�ҳ��Ԫ��
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
	//jsʵ��replaceAll
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
  //ȥ�ո�
  String.prototype.trim = function() { 
		return this.replace(/(^\s*)|(\s*$)/g, ""); 
  } 
	 //�����������ֵ�Ƿ����E-Mail��ʽ
	fu.validate.isEmail=function (str) {
			var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+.)+[A-Za-z0-9]{2,3}$/;
			if(myReg.test(str)) return true;
			return false;
	}
	//У�鳤�ȣ���������
	String.prototype.getLength = function() {    
				var cArr = this.match(/[^\x00-\xff]/ig);    
				return this.length + (cArr == null ? 0 : cArr.length);    
	} 
	//У���Ƿ��к���,����к��ֵĻ��򷵻�true;
	 fu.validate.isHaveCn_z=function(str){	
	 	var reg=/[\u4e00-\u9fa5]+/;
	 	return reg.test(str);
	 }
	 //��֤�ǲ��ǷǸ���, �ǷǸ����Ļ��򷵻�true
	 fu.validate.nNegativeNum=function(oNum) {   
	  if(oNum==""){return true}
	  if(!oNum) return false;
	  //�Ǹ���������ʽ
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
	//У��������
	fu.validate.valiPInt=function(str){
		var re = /^[0-9]\d*$/;
		if(!re.test(str)){
			return false;
		}else{return true}
	}
	/**
		��ʽ����Ǯ���ͣ�����ǰ̨У������Ϊmeoney(2)//����С�������λ,�����д�Ļ�Ĭ��Ϊ��λ
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
       * ���
      */
	 function setIndex(id_){
		$("#"+id_+" .indextd").each(function(index){
				$(this).html(index+1)
		})
	}
	/**
	*����һ��tbody��tr���ݣ�����һ�л����
	*fromid:�����Ƶ�divԪ��
	*isindex,�Ƿ���ʾ���
	*/
	//����һ��ȫ�ֱ�����������html��Ϣ
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
    //�����¼�����
    $('input:text').focus(function(){
		$('textarea').not(".readonly").css({"background-color":""});
		//�ѱ���ɫ����Ϊ�գ�ͬʱ��classΪfocusinput������Ϊinput(��ֱ��ȡclassname��΢�е�Ч������)
        $("input[ids_fu_=focusTempId]").attr("ids_fu_","").css({"background-color":""});
        //����������ʽΪreadyonly�������������ʽfocusinput,Ȼ������classΪfocusinput�ı���ɫ�������focusinput��ֱ�Ӷ�����ʽ�Ļ�����һ���μ��ص�ʱ����ʾ��ʽ��ˢ��һ�¾ͺã�
        $(this).not(".readonly").attr("ids_fu_","focusTempId").css({"background-color":"#FFFF99"});
    });
	$('textarea').focus(function(){
		$(".focusinput").not(".readonly").attr("class","input");
		$('textarea').not(".readonly").css({"background-color":""});
		$(this).not(".readonly").css('background-color','#FFFF99');
    });
}
		//˫��ҳ�����
          var isMax=false;//
		  fu.object.showMax=function(){
		  	 var body_="";
		 	 body_=document.getElementsByTagName("body");
		  	 for(i=0;i<body_.length;i++){
		  	 	body_[i].ondblclick=function(){
		  	 		//���������
		  	 		parent.fraSet.cols = "1,*";
		  	 		parent.topFrame.rows = "0,0,0,*";
		  	 		isMax=true;
		  	 		$(parent.frames["fraInterface"].document).find("div:first").before("<div style='width=100%;height:20px;font-size:12px;text-align:center;padding-top:5px;position:absolute;z-index:100' class='zdc_div'>"
		  	 		+"<div style='position:absolute;z-index:2;background-color:red;width:10%; '>��Esc�˳�ȫ��</div>"
		  	 		+"</div>"); 
			  	 	$(parent.frames["fraInterface"].document).find(".zdc_div").fadeOut(2000);
		  	 	}
		  	 }
		  }
		  document.onkeyup=function(){
		  	//��ESC�˳�ȫ��
		  	if(event.keyCode==27){
		  		var body_="";
		 	 	body_=document.getElementsByTagName("body");
		 	 	for(i=0;i<body_.length;i++){
	 	 			parent.fraSet.cols = "150,*";
		  	 		parent.topFrame.rows = "82,0,0,*";
		  	 		isMax=false;
		  	 		//�˳�ʱ��մ�ҳ������
		  	 		$(parent.frames["fraInterface"].document).find(".zdc_div").remove()
		 	 	}
		  	}
		  }
	/**�϶�table�п��*/
fu.object.drag=function (o,r){
	
	o.p_p_c_gw=function(index)/*ȡ�� o.parentNode.parentNode.cells�Ŀ�ȣ�����IE6��Firefox*/{
	if(window.ActiveXObject){
	return o.parentNode.parentNode.cells[o.parentNode.cellIndex+index].offsetWidth;
	}else{
	return parseInt(o.parentNode.parentNode.cells[o.parentNode.cellIndex+index].offsetWidth)-
	parseInt(o.parentNode.parentNode.parentNode.parentNode.cellPadding)*2-2;
	}
}

o.p_p_p_sw=function(index,w)/*���������еĵ�index����Ԫ��Ϊw����IE�¿�ֻ���һ��*/{
	for(var i=0;i<o.parentNode.parentNode.parentNode.parentNode.rows.length;i++) {
	o.parentNode.parentNode.parentNode.parentNode.rows[i].cells[index].style.width=w;
	}
}

/**
*����ȥhtml���
*/
 fu.object.delHtmlTag=function (str){ 
             return str.replace(/<\/?.+?>/g,"");//ȥ�����е�html��� 
}
/**
	������Ӧ����ʾ�Ŀ��
	���ְ�11PX�㣬������ĸ���Լ���㰴6PX��
*/
fu.object.showLength=function (str){
	str=fu.object.delHtmlTag(str);
	var oldLen=str.length;//ԭ���ı��ĳ��ȡ�
	var cnLen=str.replace(/[^\u4e00-\u9fa5]/gi,"").length;//�ѷǺ��ֵ��ַ�ȥ����ĳ���,Ҳ���Ǻ��ֵĸ���
	var noCnLen=(Number(oldLen)-Number(cnLen));//�Ǻ��ֵĸ�������7px����
	var countLength=cnLen*16+noCnLen*9;
	return countLength;
}
var out=document.getElementById('my');

o.firstChild.onmousedown=function(){return false;};
o.ondblclick=function(){
	var maxwidth = 0;
	// ȡ��ĳ�е������
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
	var watch_dog=o.p_p_c_gw(0)+o.p_p_c_gw(1);//��ʱ����ק�������������Ϊʲô��������Ҳ������� watch_dog��Ϊ�˱�֤��񲻻���
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
//��ʼ�����϶��¼�
fu.object.initDrag=function (){
	//��jQuery�ķ�����Ч�ʸߺܶ�
	var drag_=$(".resizeDivClass");
	if(drag_!=null){
		for(i=0;i<drag_.length;i++){
			fu.object.drag(drag_[i]);
		}
	}
}
	/**�϶�table�п��end*/
	
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
//��������İ�ť
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
	//��갴���¼�
	$(".button_table").mousedown(function(){
          		$(this).addClass("down");
          		 $(this).bind('mouseup', function () {
		            $(this).removeClass('down');
		            $(this).unbind('mouseup');
          		});
    });
    //�������¼�
    $(".button_table").mouseover(function(){
    	$(this).addClass("over");
    	//����ƿ�
    	$(this).bind('mouseout', function () {
             $(this).removeClass('over');
              $(this).removeClass('down');
            });
    })
}
//�ɱ༭��������
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
    // ����ǰѡ�е�������ѡ���ı���ֵ��TxtBox
    $(param).parent().find("input[type=text]").val(selectObj1.attr("options")[selectObj1.attr("selectedIndex")].innerHTML)
}
fu.object.clearInput=function(obj){
	
	if($(obj).val()=='��ѡ�������д'){
		$(obj).val("");
	}
}
function HashMap()  
 {  
     /** Map ��С **/  
     var size = 0;  
     /** ���� **/  
     var entry = new Object();  
       
     /** �� **/  
     this.put = function (key , value)  
     {  
         if(!this.containsKey(key))  
         {  
             size ++ ;  
         }  
         entry[key] = value;  
     }  
       
     /** ȡ **/  
     this.get = function (key)  
     {  
         return this.containsKey(key) ? entry[key] : null;  
     }  
       
     /** ɾ�� **/  
     this.remove = function ( key )  
     {  
         if( this.containsKey(key) && ( delete entry[key] ) )  
         {  
             size --;  
         }  
     }  
       
     /** �Ƿ���� Key **/  
     this.containsKey = function ( key )  
     {  
         return (key in entry);  
     }  
       
     /** �Ƿ���� Value **/  
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
       
     /** ���� Value **/  
     this.values = function ()  
     {  
         var values = new Array();  
         for(var prop in entry)  
         {  
             values.push(entry[prop]);  
         }  
         return values;  
     }  
       
     /** ���� Key **/  
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
       
     /* ��� */  
     this.clear = function ()  
     {  
         size = 0;  
         entry = new Object();  
     }  
 } 
 /*
 �ڱ�ҳ���һ���㣬�����ݷŵ������棬�رյ�ʱ������ݴ浽��ҳ�棬Ȼ���ύ��̨
 **/
 fu.object.layer=function(param){
 	var temp_layer_div="";
 	//�����������ڵ�div��ID,
 	var div_id=param.divid||"";
 	//�����������DIV�ŵ��ĸ�ҳ��Ԫ�غ���
 	var layeraftertd=param.tdid||"";
 	var event=param.exeEvent||"";
 	if(temp_layer_div==""||temp_layer_div==null){
		temp_layer_div=$("#"+div_id).html();//�ѵ����DIV���ֵ�����м����
		$("#"+div_id).html("");//Ȼ��ѵײ��������
	}
	var layer_div_html= $("#"+layeraftertd+" div").html();
	if(layer_div_html==null||layer_div_html==""){
		$('#'+layeraftertd+' div').css("display","");
		$('#'+layeraftertd+' div').append("<div id='panel_div_payment' style='position: absolute;z-index: 100;float:rigth;width:970px;text-align:center;border:1px solid #7AA3C4;background-color:#F7F7F7'>"+temp_layer_div+""+
		"<span style='background-color:#F7F7F7;width:100%'><input type='button'  class='button' value='�ر�' onclick=\"fu.object.close_layer({divid:'"+div_id+"',tdid:'"+layeraftertd+"',closetype:'0'})\">"+
		"<input type='button' class='button' style='text-align:center' value='����' onclick=\"fu.object.close_layer({divid:'"+div_id+"',tdid:'"+layeraftertd+"',closetype:'1',exeEvent:'"+event+"'})\">"+
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
 	//�������ڵ�div��ID
 	var div_id=divid||"";
 	//�����������DIV�ŵ��ĸ�ҳ��Ԫ�غ���
 	var layeraftertd=tdid||"";
	var layer_div_html= $("#"+layeraftertd+" div").html();
	
 	if((layer_div_html==null||layer_div_html=="")){
 		var waitImg="<span  style='height:50px;'>�������ڼ��أ����Ժ�<img src='/newclaim/images/loading_2.gif'  style='padding-top:20px'/></span>";
 		fu.object.create(waitImg,layer_div_html,layeraftertd,div_id);
 		$.ajax({
 			type:"post",
 			url:uri,
 			//async: false,
 			data:$.param(param),
 			success:function(data){
 				temp_layer_div=data;
 				//��յ�������
 				$('#'+layeraftertd+' div').html("");
 				fu.object.create(temp_layer_div,layer_div_html,layeraftertd,div_id);
 			}
 		})
	}else{
		fu.object.create(temp_layer_div,layer_div_html,layeraftertd,div_id);
	}
	
 }
 fu.object.create=function(temp_layer_div,layer_div_html,layeraftertd,div_id){
 	//���û�����ݣ������
	if(layer_div_html==null||layer_div_html==""){
		//�ò���ʾ
		$('#'+layeraftertd+' div').css("display","");
		//������������
		$('#'+layeraftertd+' div').append("<div id='panel_div_payment' style='position: absolute;z-index: 100;float:rigth;width:1000px;text-align:center;border:1px solid #7AA3C4;background-color:#F7F7F7'>"+temp_layer_div+""+
		"<span style='background-color:#F7F7F7;width:100%'><input type='button'  class='button' value='�ر�' onclick=\"fu.object.close_layer({divid:'"+div_id+"',tdid:'"+layeraftertd+"',closetype:'0'})\">"+
		"<input type='button' class='button' style='text-align:center' value='����' onclick=\"fu.object.close_layer({divid:'"+div_id+"',tdid:'"+layeraftertd+"',closetype:'1'})\">"+
		"</span>"+
		"</div>");
	//��������ݣ�����ʾ
	}else{
		$('#'+layeraftertd+' div').css("display","");
	}
 }
  fu.object.close_layer=function(params){
  //�������ڵ�div��ID
 	var div_id=params.divid||"";
 	//�����������DIV�ŵ��ĸ�ҳ��Ԫ�غ���
 	var layeraftertd=params.tdid||"";
 	var events=params.exeEvent||"";
 	close_type=params.closetype;
 		//�ر�
		if(close_type=='0'){
			$('#'+layeraftertd+' div').css("display","none");
		//����
		}else if(close_type=='1'){
			//ִ�з���
	 		var tempFun=eval(events);
			//�����ִ�еķ�������false��رղ�
		 	if(tempFun==false){
		 		return ;
		 	}
			$('#'+layeraftertd+' div').css("display","none");
		}
	}
