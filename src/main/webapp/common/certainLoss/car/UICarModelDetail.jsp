<%--
****************************************************************************
* DESC       ����ѯ������ϸ��Ϣ
* Author     : ������Ŀ��
* CREATEDATE �� 2005-11-29
* MODIFYLIST ��   Name       Date            Reason/Contents
*                 huzhenyu   20071207        �㽭���Ͳ�ѯ����
****************************************************************************
--%>

<%@page import="java.util.*%>
<%@page import="com.sinosoft.utiall.dbsvr.DBPrpDcode"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDuser"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcompany"%>
<%@page import="com.sinosoft.utiall.blsvr.*"%>
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.utiall.schema.*"%>
<%
	String modelCode = request.getParameter("ModelCode");
	String strPurChasePrice = (String)request.getParameter("PurChasePrice");
	String strComCode = (String)session.getValue("ComCode");	
	String strSQL = " Select * From PrpDcarModel Where ModelCode = " + "'" + modelCode + "'";
    if(strComCode == null || strComCode.equals("")){
      strComCode = request.getParameter("ComCode");    
    }
	PrpDcarModelNewSchema prpDcarModelNewSchema = new PrpDcarModelNewSchema();
	DBPrpDcarModelNew dbPrpDcarModelNew = new DBPrpDcarModelNew();
	Vector vec = dbPrpDcarModelNew.findByConditions(strSQL);
	if (vec.get(0) != null) {
		prpDcarModelNewSchema = (PrpDcarModelNewSchema)vec.get(0);
	}
%>

<html>
<head>
  <title>������Ϣ</title>
  <!-- ҳ����ʽ  -->
  <link rel="stylesheet" type="text/css" href="/prpall/css/Standard.css">
  <script src="/prpall/commonship/pub/UICommon.js"></script>
  <script src="/prpall/commonship/pub/UICodeSelect.js"></script>
  <%-- �������뺯�� --%>
  
  <script language=Javascript>
    function showValue() {
    }
  </script>
</head>          
<body class="interface" onload="showValue();">
<form action="/prpall/commonship/pub/UIShipSubmit.jsp?" method=post name=fm>
<input type=hidden name=ComCode value=<%=strComCode%>>
  <table class=common align="center" cellpadding="5" cellspacing="1">
  	<tr>
    	<td class=formtitle colspan="4"> 
    		������Ϣ
    	</td>	
    </tr>
  </table>
  <table class=common cellpadding="5" cellspacing="1" id="BaseInfo" style="display:">
    <tr>
      <td width="15%" class="page">���ͱ��룺</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getModelCode()%>
      </td>
      <td width="15%" class="page">������ʽ���ƣ�</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getModelName()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">�������ࣺ</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getCarKind()%>
      </td>
      <td width="15%" class="page">����״̬��</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getProductStatus()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">�б����ͣ�</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getCarStyle()%>
      </td>
      <td width="15%" class="page">���������</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getTonCount()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">������ݣ�</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getCarYear()%>
      </td>
      <td width="15%" class="page">��������������</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getRiskType()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">����ϵ�У�</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getCarSeriesName()%>
      </td>
      <td width="15%" class="page">��������</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getExHaustScale()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">���С�ؿ�������</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getSeatMin()%>
      </td>
      <td width="15%" class="page">�����ؿ�������</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getSeatMax()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">��ע��</td>
      <td colspan=3 width="80%" class="page">
        <%=prpDcarModelNewSchema.getRemark()%>
      </td>
    </tr>                                                            
  </table>
  <table class=common align="center" cellpadding="5" cellspacing="1">
  	<tr>
    	<td class=formtitle colspan="4"> 
    		������Ϣ
    	</td>	
    </tr>
  </table>
  <table class=common cellpadding="5" cellspacing="1" id="FactoryInfo" style="display:">
    <tr>
      <td width="15%" class="page">�������ң�</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getFactory()%>
      </td>
      <td width="15%" class="page">Ʒ�ƣ�</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getCarBrand()%>
      </td>
    </tr>                                                            
  </table>
  <table class=common align="center" cellpadding="5" cellspacing="1">
  	<tr>
    	<td class=formtitle colspan="4"> 
    		������Ϣ
    	</td>	
    </tr>
  </table>
  <table class=common cellpadding="5" cellspacing="1" id="OtherInfo" style="display:">
    <tr>
      <td width="15%" class="page">���������ͣ�</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getTransmissionType()%>
      </td>
      <td width="15%" class="page">�������ͣ�</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getVehArea()%>
      </td>
    </tr>                                                            
    <tr>
    	<%
    	if("33".equals(strComCode.substring(0,2))){
    	%>
    	<td width="15%" class="page">��ҵ���ۣ�</td>
    	<%
    	}else{
    	%>
      <td width="15%" class="page">�³����üۣ�</td>
      <%}%>
      <td width="35%" class="page">
        <%=strPurChasePrice%>
      </td>
      <td width="15%" class="page">���ñ�־��</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getValidStatus()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">ƴ����ѯ�룺</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getSpellAb()%>
      </td>
      <td width="15%" class="page">�ͺŲ�ѯ�룺</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getModelId()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">�����ճ��ͷ�����룺</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getTheftClass()%>
      </td>
      <td width="15%" class="page">�����ճ��ͷ�����룺</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getDamagedClass()%>
      </td>
    </tr>                                                            
  </table>
  <table class=common align="center" cellpadding="5" cellspacing="1">
  	<tr>
    	<td class=formtitle colspan="4"> 
    		������Ϣ
    	</td>	
    </tr>
  </table>
  <table class=common cellpadding="5" cellspacing="1" id="EquipmentInfo" style="display:">
    <tr>
      <td width="15%" class="page">����ABSװ�ã�</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getAbsFlag()%>
      </td>
      <td width="15%" class="page">���޷���װ�ã�</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getTheftProof()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">��ȫ����������</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getAirbagCount()%>
      </td>
      <td width="15%" class="page">ѡװװ����</td>
      <td width="35%" class="page">
      	<%=prpDcarModelNewSchema.getOptionalEquipment()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">��׼װ����</td>
      <td colspan=3 width="80%" class="page">
        <%=prpDcarModelNewSchema.getStandardEquipment()%>
      </td>
    </tr>                                                            
  </table>
</form>
</body>
</html>
