<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<script type="text/javascript">
	function getIndex(object,feild){
		var index = 0;
		for(var i=0;i<object.length;i++){
			if(object[i] == feild){
				index = i;
				break;
			}
		}
		return index;
	}
	function linkerSelect(feild){
		//��λѡ�� ��ֹ�ظ�
		var staffPosition = document.getElementsByName("staffPosition");
		var index = getIndex(staffPosition,feild);
		for(var i=0;i<staffPosition.length;i++){
			if(staffPosition[i] != feild){
				if(feild.value != "" && staffPosition[i].value == feild.value){
					alert("��"+ feild.options[feild.selectedIndex].innerText +"��"+"��λ�Ѿ����ڣ�������ѡ��");
					feild.value ="";
					initFeild(index);
				}
			}
		}
		if(feild.value==""){
			initFeild(index);
		}else{
			setStaffUserCode(index);
		}
	}
	function setFun(feild){
		var staffType = document.getElementsByName("staffType");
		var index = getIndex(staffType,feild);
		var staffPosition = document.getElementsByName("staffPosition");
		if(staffPosition[index].value==""){
			alert("��ѡ����ϵ�˸�λ��");
			feild.value="";
			return false;
		}
		initPerson(index);
		setStaffUserCode(index);
		var staffName = document.getElementsByName("staffName");
		if(feild.value == "0"){
			staffName[index].style.cssText = "background-color: #D7E1F6; border: 1px #799AE1 solid; WIDTH: 97%;color:#385F93";
			staffName[index].setAttribute("ondblclick",function(){code_CodeSelect(staffName[index],'JobManagerLinker','-1,1','name','always','none','post');},0);
			staffName[index].setAttribute("onkeyup",function(){code_CodeSelect(staffName[index], 'JobManagerLinker','-1,1','name','always','none','post');},0);
			staffName[index].setAttribute("onblur",function(){code_CodeChange(staffName[index], 'JobManagerLinker','-1,1','name','post','clear');},0);
		}else{
			staffName[index].style.cssText="";
			staffName[index].setAttribute("ondblclick",null);
			staffName[index].setAttribute("onkeyup",null);
			staffName[index].setAttribute("onblur",null);
		}
	}
	function setStaffUserCode(index){
		var staffPosition = fm.staffPosition;
		var staffUserCode = fm.staffUserCode;
		var staffType = fm.staffType;
		if(staffType[index].value=="1"){
			if(staffPosition[index].value=='0'){
				staffUserCode[index].value="999990";
			}else{
				staffUserCode[index].value="999991";
			}
		}else if(staffType[index].value!="0"){
			staffUserCode[index].value="";
		}
	}
	function initFeild(index){
		var staffType = fm.staffType;
		staffType[index].value = "";
		initPerson(index);
	}
	function initPerson(index){
		var staffUserCode = fm.staffUserCode;
		var staffName = fm.staffName;
		var staffPhone = fm.staffPhone;
		staffUserCode[index].value = "";
		staffName[index].value = "";
		staffName[index].style.cssText="";
		staffPhone[index].value = "";
	}
	function init(){
		<bean:define id="isDisplay" value="${editType ne 'EDIT' or editType ne 'SHOW' or (inputButtonType eq 'yes' and editType eq 'ADD') }" />
		<logic:equal value="true" name="isDisplay">
		var staffId = fm.staffId;
		var staffPosition = fm.staffPosition;
		var staffType = fm.staffType;
		var staffUserCode = fm.staffUserCode;
		var staffName = fm.staffName;
		var staffPhone = fm.staffPhone;
		<logic:present name="prpLJobLinkerDtoList">
		<logic:iterate id="prpLJobLinkerDto" name="prpLJobLinkerDtoList" indexId="index">
			staffId[${index}].value="${prpLJobLinkerDto.staffId}";
			staffPosition[${index}].value="${prpLJobLinkerDto.staffPosition}";
			staffType[${index}].value="${prpLJobLinkerDto.staffType}";
			staffUserCode[${index}].value="${prpLJobLinkerDto.staffUserCode}";
			staffName[${index}].value="${prpLJobLinkerDto.staffName}";
			staffPhone[${index}].value="${prpLJobLinkerDto.staffPhone}";
		</logic:iterate>
		</logic:present>
		</logic:equal>
	}
	function beforeNameValidate(feild){
		var staffName = fm.staffName;
		var index = getIndex(staffName,feild);
		var staffPosition = fm.staffPosition;
		var staffType = fm.staffType;
		if(staffPosition[index].value == ""){
			alert("��ѡ����ϵ�˸�λ��");
			return false;
		}
		if(staffType[index].value==""){
			alert("��ѡ����Ա���ͣ�");
			return false;
		}
	}
	function beforePhoneValidate(feild){
		var staffPhone = fm.staffPhone;
		var index = getIndex(staffPhone,feild);
		var staffPosition = fm.staffPosition;
		var staffType = fm.staffType;
		var staffName = fm.staffName;
		if(isNaN(feild.value)){
			feild.value="";
			alert("�绰�����ʽ����ȷ");
			return false;
		}
		if(staffPosition[index].value !="" && staffType[index].value==""){
			alert("��ѡ����Ա���ͣ�");
			return false;
		}
		if(staffPosition[index].value !="" && staffName[index].value==""){
			alert("��������Ա������");
			return false;
		}
	}
</script>
<table id="tab" name="tab"
	style="margin-bottom: 0px" class="common" 
	cellpadding="0" cellspacing="0" border="1" style="border-collapse:collapse;background-color: #F7F7F7;" bordercolor="#3A81C8">
	<thead>
		<tr class="textc">
			<td class="centertitle" colspan="8">��ϵ��</td>
		</tr>
	</thead>
	<tbody>
		<%for(int i=0;i<2;i++){%>
		<tr class="textc">
			<td class="centertitle" style="width: 12%">
				��ϵ�˸�λ
				<input type="hidden" name="staffId" value="" />
			</td>
			<td style="width: 13%">
				<select name="staffPosition" style="width:100%"  onchange="linkerSelect(this);">
					<option value="">��ѡ��</option>
					<option value="0">ת�ӱ�����</option>
					<option value="1">�Խ���</option>
				</select>
			</td>
			<td class="centertitle" style="width: 12%">
				��Ա����
			</td>
			<td style="width: 13%">
				<select name="staffType" style="width:100%" onchange="setFun(this);">
					<option value="">��ѡ��</option>
					<option value="0">��������Ա</option>
					<option value="1">�Ǳ�������Ա</option>
				</select>
			</td>
			<td class='centertitle' style="width: 12%">
				��Ա����
			</td>
			<td style="width: 13%">
				<input type ="hidden" name="staffUserCode" value="">
				<input type ="text" name="staffName" value="" onchange="beforeNameValidate(this);">
			</td>
			<td class="centertitle" style="width: 12%">
				�绰����
			</td>
			<td style="width: 13%">
				<input type ="text" name="staffPhone" value="" onchange="beforePhoneValidate(this);">
			</td>
		</tr>
		<%} %>
	</tbody>
</table>
<script type="text/javascript">
init();
</script>