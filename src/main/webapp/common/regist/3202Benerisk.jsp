<%--
****************************************************************************
* DESC       ��������Ϣ����
* AUTHOR     �� Sinosoft 
* CREATEDATE �� 2004-12-09
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@ page import="java.util.*" %>


<script language='javascript'>

//��ť�����¼�,����ţ�Ŵ����б���Ϣ
function buttonOnClickOfBene3202(field,actionName)
{
  var orderCurrent = 0  ;   
  orderCurrent = parseInt(getElementOrder(field));
  var bizType = actionName;
  var familyNo = fm.prpLacciPersonAddress[orderCurrent-1].value;
  if(familyNo==null||familyNo.length<1){
    alert("������ţ��");
  	return;
  }
  var policyno = fm.policyno.value;
  var messagedo="/claim/beneInfoShow.do?serialNo="+familyNo+"&bizType="+bizType+"&policyno="+policyno;
  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
} 

  
</script>



<input title="�鿴���ֱ�����Ϣ"  type=button ACCESSKEY="." value='...' class="smallbutton" name='button_BeneRisk_Open_Context' onclick="buttonOnClickOfBene3202(this,'3202InfoShow');">
    
    