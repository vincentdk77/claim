
//��ȡ���д���
function SubstrDemo(s){
   var  ss;                // ����������
   ss = s.substr(0, 2); // ��ȡ���ַ�����
   return(ss);               // ���� "Spain"��
}
var residency_hukou_flag=0;	// ��ס�� / �������ڵ�   ����
var residency = {
	// ��ס�����
	Show : function(){
		var k=0;
		var Div=new Array('maincity','allProv');
		while(k<=1){
			var output='<h4>��Ҫ���У�</h4>';
			var arr=maincity,area;
			if(k==1){
				output='<h4>�������У�</h4>';
				arr=allprov;
			}
			for (var i in arr){
				area=arr[i][0];
				output+='<dl><dt>'+area+'</dt><dd>';
				for (var j in arr[i][1] ){
					id=arr[i][1][j];
					if(k==0){
						if(ja[id]=="�Ϸ�"||ja[id]=="֣��"){
							output+='<li onclick="residency.Chk(\''+id+'\')"><font color="red">'+ja[id]+'</font></li>';
						}else{
							output+='<li onclick="residency.Chk(\''+id+'\')">'+ja[id]+'</li>';	
						}
					}else{
						if(area=='����') output+='<li onclick="residency.Chk(\''+id+'\')">'+ja[id]+'</li>';
						else output+='<li onclick="residency.SubLayer(\''+id+'\')">'+ja[id]+'</li>';
					}
				}
				output+='</dd></dl>';
			}
			$('#'+Div[k]).html(output);
			k++;
		}
		$('#drag').width('580px');
		// �����ͣ��ɫ
		$('#residencyAlpha li').hover(function(){$(this).addClass('over')},function(){$(this).removeClass()});
		// ��������Ӳ˵�
		$('#allProv li').click(function(e){$("#sublist").css({top:e.pageY-4,left:e.pageX-4}).hover(function(){$(this).show()},function(){$(this).hide()})})
	},
	// ����ʡ�� ���� ���в˵�
	SubLayer : function(id){
		var output='<div id="sub_city">',width,ischecked,key;
		var arr=getAreaIDs(id);
			width=Math.ceil(Math.sqrt(arr.length-1))*60;
		output+='<ul style="width:'+width+'px"><h4 onclick="residency.Chk(\''+id+'\')"><a href="###">'+ja[id]+'</a></h4>';
		for (var i=1;i<arr.length;i++){
			key=arr[i];
			if(i==1){
				output+='<li><a href="###" onclick="residency.Chk(\''+key+'\')"><font color="red">'+ja[key]+'</font></a></li>';
			}else{
				output+='<li><a href="###" onclick="residency.Chk(\''+key+'\')">'+ja[key]+'</a></li>';	
			}
		}
		output=output+'</ul></div>';
		$("#sublist").html(output).show();
	},


	Chk : function(id){
		if(residency_hukou_flag==0){
			$('#btn_residency').val(ja[id]);
			
			$('#residency').val(id);
		}else{
			$('#btn_hukou').val(ja[id]);
			var cityid = SubstrDemo(id);
			var city = pro[cityid];
			$('#pro').val(city);
			$('#hukou').val(id);
		}
		$("#sublist").hide().empty();
		boxAlpha();
	}
}
	
function hukouSelect(){
	residency_hukou_flag=1;
	var dragHtml ='<div id="residencyAlpha">';		//��ס��
		dragHtml+='		<div id="maincity"></div>';	//��Ҫ����
		dragHtml+='		<div id="allProv"></div>';	//����ʡ��
		dragHtml+='</div>';
	$('#drag_h').html('<b>�տ��˿����������ڵ�</b><span onclick="boxAlpha()">�ر�</span>');
	$('#drag_con').html(dragHtml);
	residency.Show();
	boxAlpha();
	draglayer();
}


/* **************************************************************************** */

var jobArea_Arr = new Array();
//var jobArea_Arr = new Array('0100','0200','2402');

var jobArea = {
	// ��ѡ�����
	init : function(){
		var _str='',_id='';
		if (jobArea_Arr.length>0){
			for (var i in jobArea_Arr){
				_str+=','+ja[jobArea_Arr[i]];
				_id+=','+jobArea_Arr[i];
			}
			$('#btn_jobArea').val(_str.substring(1));
			$('#jobAreaID').val(_id.substring(1));
		}
	},
	Show : function(){
		var k=0,output='',output2='',arr,area,select_ed;
		var Div		= new Array('maincity2','allProv2');
		var Title	= new Array('<h4>��Ҫ���У�</h4>','<h4>����ʡ�ݣ�</h4>');
		var LoopArr	= new Array(maincity,allprov);

		for(var i in jobArea_Arr){
			output2+='<li class="jobArea'+jobArea_Arr[i]+' chkON" onclick="jobArea.Chk(\''+jobArea_Arr[i]+'\')">'+ja[jobArea_Arr[i]]+'</li>';
		}
		$('#jobAreSelected dd').html(output2);

		while(k<=1){
			output	= Title[k];
			arr		= LoopArr[k]
			for (var i in arr){
				area=arr[i][0];
				output+='<dl><dt>'+area+'</dt><dd>';
				for (var j in arr[i][1] ){
					id=arr[i][1][j];
					if(k==0){
						select_ed=in_array(id,jobArea_Arr)?' chkON':'';
						output+='<li class="jobArea'+id+select_ed+'" onclick="jobArea.Chk(\''+id+'\')">'+ja[id]+'</li>';
					}else{
						if(area=='����') output+='<li class="jobArea'+id+'" onclick="jobArea.Chk(\''+id+'\')">'+ja[id]+'</li>';
						else output+='<li onclick="jobArea.SubLayer(\''+id+'\')">'+ja[id]+'</li>';
					}
				}
				output+='</dd></dl>';
			}
			
			$('#'+Div[k]).html(output);
			k++;
		}
		$('#drag').width('580px');
		// �����ͣ��ɫ
		$('#jobAreaAlpha li').hover(function(){$(this).addClass('over')},function(){$(this).removeClass('over')});
		// ��������Ӳ˵�
		$('#allProv2 li').click(function(e){$("#sublist").css({top:e.pageY-4,left:e.pageX-4}).hover(function(){$(this).show()},function(){$(this).hide()})})
	},
	// ����ʡ�� ���� ���в˵�
	SubLayer : function(id){
		var output='<div id="sub_jobArea">',width,select_ed,key;
		select_ed=in_array(id,jobArea_Arr)?' chkON':'';
		var arr=getAreaIDs(id);
			width=Math.ceil(Math.sqrt(arr.length-1))*60;
		output+='<ul style="width:'+width+'px"><h4 onclick="jobArea.Chk(\''+id+'\')">';
		output+='<a href="###" class="jobArea' + id + select_ed +'">'+ja[id]+'</a></h4>';

		for (var i=1;i<arr.length;i++){
			key=arr[i];
			select_ed=in_array(key,jobArea_Arr)?' chkON':'';
			output+='<li><a href="###" class="jobArea' + key + select_ed +'" onclick="jobArea.Chk(\''+key+'\')">'+ja[key]+'</a></li>';
		}
		output=output+'</ul></div>';
		$("#sublist").html(output).show();
	},


	Chk : function(id){
		if(!in_array(id,jobArea_Arr)){
			var subArea,myid;
			if(id.substr(2)=='00'){	// ѡ�и����������
				subArea=getAreaIDs(id);
				for(var i in subArea){
					if(in_array(subArea[i],jobArea_Arr)) this.del(subArea[i]);
				}
			}else{	// ѡ�������������
				myid=id.substr(0,2)+'00';
				if(in_array(myid,jobArea_Arr)) this.del(myid);
			};
			if(jobArea_Arr.length<5){
				jobArea_Arr[jobArea_Arr.length]=id;
				var html='<li class="jobArea'+id+'" onclick="jobArea.Chk(\''+id+'\')">'+ja[id]+'</li>';
				$('#jobAreSelected dd').append(html);
				$('.jobArea'+id).addClass('chkON');
				$('#jobAreSelected li').hover(function(){$(this).addClass('over')},function(){$(this).removeClass('over')});
			}else{
				alert('�������ѡ��5��');
				return false;
			}
		}else{
			this.del(id);
		}
	},
	del : function(id){
		for (var i in jobArea_Arr){
			if(jobArea_Arr[i]==id) jobArea_Arr.splice(i,1);;
		}
		$('#jobAreSelected .jobArea'+id).remove();
		$('.jobArea'+id).removeClass('chkON');
	},
	// ȷ��
	confirm : function(){
		var areaStr='';
		for(var i in jobArea_Arr){
			areaStr+=','+ja[jobArea_Arr[i]];
		}
		areaStr=areaStr.substring(1)?areaStr.substring(1):'��ѡ�����'; 
		$('#btn_jobArea').val(areaStr);
		$('#jobAreaID').val(jobArea_Arr);
		boxAlpha();
		$('#jobAreSelected dd').empty();
	}
}

function jobAreaSelect(){
	var dragHtml ='<div id="jobAreaAlpha">';		//����
		dragHtml+='		<dl id="jobAreSelected"><dt>��ѡ�ص㣺</dt><dd></dd></dl>';
		dragHtml+='		<div id="maincity2"></div>';//��Ҫ����
		dragHtml+='		<div id="allProv2"></div>';	//����ʡ��
		dragHtml+='</div>';
	$('#drag_h').html('<b>��ѡ��������������ѡ��5�</b><span onclick="jobArea.confirm()">ȷ��</span>');
	$('#drag_con').html(dragHtml);

	jobArea.Show();
	boxAlpha();
	draglayer();
}