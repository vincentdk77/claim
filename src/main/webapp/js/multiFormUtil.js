/*#############################################################
Name: FormUtil
Version:1.0
Author: zhang dechen
ҳ��htmlԪ�صĸ���JS
#############################################################*/
	
	
	$(document).ready(function(){
		//ҳǩ
		/*var $div_li =$("div..tab_menu ul li");
		   
		    $div_li.click(function(){
				$(this).addClass("selected")
					   .siblings().removeClass("selected");
var parChild=$(this).parent().children();
	            var index =  parChild.index(this);  //�ҵ�<li>�ӽڵ������
var p=$(this).parent().parent().parent();
//alert(p.html());
var tab_box=p.find('div').eq(1).children();
//alert(tab_box.html());

var selectDiv=tab_box.eq(index);
//alert(selectDiv.html());

selectDiv.show();
selectDiv.siblings().hide();
				
			}).hover(function(){//������ȥ����ʽ
				$(this).addClass("hover");
			},function(){
				$(this).removeClass("hover");
		});
		//ҳǩend
		//�˷�����������jquery��ܣ���������
		//inputStyle();//��ʼ�����ش˷���
		//showMax();
		//initDrag();//��ʼ�����϶���
	*/});
	
	function FormUtil(){
		//FormUtil�Ĺ��캯��
		//inputStyle();//��ʼ�����ش˷���
		//����valiCheckType����
		//valiCheckType();
		//checkTextArea();
	}
	FormUtil.prototype.initValidate=function (){
			//��У���������������ͨ������ȥУ��淶����
			if(checkRequired()){
				valiCheckType();
				checkTextArea();				
			}
			
	}
	//У������class=requred��Ϊ����
	function checkRequired(){
		var requireds=getElementsByClassName("required");
			for(i_=0;i_<requireds.length;i_++){
				if(requireds[i_].value.trim()==''||requireds[i_].value=='������'){
					alert(requireds[i_].cnname+'����Ϊ��');
					requireds[i_].focus();
					return false;
				}
			}
			//���ҳ��û�б�������߱�����ͨ��ʱ�򷵻�true
			return true;
	}
	
	
	//����checktypeУ�����������������Ƿ�Ϸ�������Email�Ƿ�Ϸ������������Ƿ���ȷ
	function valiCheckType(){
			
			var allInput=document.getElementsByTagName("input");
			for(i_=0;i_<allInput.length;i_++){
				//ֻ�ж���������������
				
				if(allInput[i_].type=='text'){
					//У�������
					var typename=allInput[i_].checktype;
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
					if(typename!=null){	
						typename=typename.toLowerCase().trim();
						//У����������
						if(typename=='email'){
						   if(!isEmail(values)){
							   alert(name_cn+'��ʽ����ȷ');
							   return false;
						   }
						}
						//������в����к���
						if(typename=='nocn'){
							if(isHaveCn_z(values)&values!=''&values!='������'){
								alert(name_cn+'���ܺ��к���');
								allInput[i_].focus();
								return false;
							}
						}
						//valiCheckType_(typename);							
					}
					if(minlength_!=null){
						
						if(l_<minlength_&values!=''&values!='������'){
							alert(name_cn+'����Ϊ'+minlength_+'λ�ַ�');
							allInput[i_].focus();
							return false;
						}
					}
					if(maxlength_!=null&values!=''&values!='������'){
						if(l_>maxlength_){
							alert(name_cn+'���Ϊ'+maxlength_+'λ�ַ�');
							allInput[i_].focus();
							return false;
						}
					}
				}
			}
	}
	//У�鳤�ȣ�������
	function valiStrLength(){
		var allInput=document.getElementsByTagName("input");
	}
	function checkTextArea(){
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
	function isEmail(str) {
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
	 function isHaveCn_z(str){	
	 	var reg=/[\u4e00-\u9fa5]+/;
	 	return reg.test(str);
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
	
	function inputStyle(){
	//����¼�����,����classΪreadyonly�������
	$('input:text').click(function(){
           			$('input:text').not(".readonly").css({"background-color":""});
           			$('textarea').not(".readonly").css({"background-color":""});
           			$(this).not(".readonly").css('background-color','#FFFF99');
    });
    //�����¼�����
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
    //��������ʽ
    $('.required').each(function(){
    	$(this).after("<font color='red'>*</font>");
    });
   
    var requiredElement=getElementsByClassName('required');
    //������classΪWdate����ʽ����Ϊhand
    var hand=getElementsByClassName('Wdate');
    for(i=0;i<hand.length;i++){
    	hand[i].style.cursor='hand';
    }

}
		
		
		
		//˫��ҳ�����
          var isMax=false;//
		  function showMax(){
		  	 var body_="";
		 	 body_=document.getElementsByTagName("body");
		  	 for(i=0;i<body_.length;i++){
		  	 	body_[i].ondblclick=function(){
		  	 		//���������
		  	 		//if(!isMax){
			  	 		parent.fraSet.cols = "1,*";
			  	 		parent.topFrame.rows = "0,0,0,*";
			  	 		isMax=true;
			  	 	
		  	 		//}
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
		 	 	}
		  	}
		  }
	/**�϶�table�п��*/
function drag(o,r){
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
 function delHtmlTag(str){ 
             return str.replace(/<\/?.+?>/g,"");//ȥ�����е�html��� 
}
/**
	������Ӧ����ʾ�Ŀ��
	���ְ�11PX�㣬������ĸ���Լ���㰴6PX��
*/
function showLength(str){
	str=delHtmlTag(str);
	var oldLen=str.length;//ԭ���ı��ĳ��ȡ�
	var cnLen=str.replace(/[^\u4e00-\u9fa5]/gi,"").length;//�ѷǺ��ֵ��ַ�ȥ����ĳ���,Ҳ���Ǻ��ֵĸ���
	var noCnLen=(Number(oldLen)-Number(cnLen));//�Ǻ��ֵĸ�������7px����
	var countLength=cnLen*14+noCnLen*9;
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
function initDrag(){
	var drag_=getElementsByClassName("resizeDivClass");
	if(drag_!=null){
		for(i=0;i<drag_.length;i++){
			drag(drag_[i]);
		}
	}
}
	/**�϶�table�п��end*/