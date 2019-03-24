<%--
****************************************************************************
* DESC       ：查询车型详细信息
* Author     : 东安项目组
* CREATEDATE ： 2005-11-29
* MODIFYLIST ：   Name       Date            Reason/Contents
*                 huzhenyu   20071207        浙江车型查询处理
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
  <title>车型信息</title>
  <!-- 页面样式  -->
  <link rel="stylesheet" type="text/css" href="/prpall/css/Standard.css">
  <script src="/prpall/commonship/pub/UICommon.js"></script>
  <script src="/prpall/commonship/pub/UICodeSelect.js"></script>
  <%-- 代码输入函数 --%>
  
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
    		基本信息
    	</td>	
    </tr>
  </table>
  <table class=common cellpadding="5" cellspacing="1" id="BaseInfo" style="display:">
    <tr>
      <td width="15%" class="page">车型编码：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getModelCode()%>
      </td>
      <td width="15%" class="page">车型正式名称：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getModelName()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">车辆种类：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getCarKind()%>
      </td>
      <td width="15%" class="page">生产状态：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getProductStatus()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">承保类型：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getCarStyle()%>
      </td>
      <td width="15%" class="page">额定载质量：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getTonCount()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">上市年份：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getCarYear()%>
      </td>
      <td width="15%" class="page">风险类型描述：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getRiskType()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">车型系列：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getCarSeriesName()%>
      </td>
      <td width="15%" class="page">排气量：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getExHaustScale()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">额定最小载客人数：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getSeatMin()%>
      </td>
      <td width="15%" class="page">额定最大载客人数：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getSeatMax()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">备注：</td>
      <td colspan=3 width="80%" class="page">
        <%=prpDcarModelNewSchema.getRemark()%>
      </td>
    </tr>                                                            
  </table>
  <table class=common align="center" cellpadding="5" cellspacing="1">
  	<tr>
    	<td class=formtitle colspan="4"> 
    		厂商信息
    	</td>	
    </tr>
  </table>
  <table class=common cellpadding="5" cellspacing="1" id="FactoryInfo" style="display:">
    <tr>
      <td width="15%" class="page">生产厂家：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getFactory()%>
      </td>
      <td width="15%" class="page">品牌：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getCarBrand()%>
      </td>
    </tr>                                                            
  </table>
  <table class=common align="center" cellpadding="5" cellspacing="1">
  	<tr>
    	<td class=formtitle colspan="4"> 
    		其它信息
    	</td>	
    </tr>
  </table>
  <table class=common cellpadding="5" cellspacing="1" id="OtherInfo" style="display:">
    <tr>
      <td width="15%" class="page">变速器类型：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getTransmissionType()%>
      </td>
      <td width="15%" class="page">车型类型：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getVehArea()%>
      </td>
    </tr>                                                            
    <tr>
    	<%
    	if("33".equals(strComCode.substring(0,2))){
    	%>
    	<td width="15%" class="page">行业车价：</td>
    	<%
    	}else{
    	%>
      <td width="15%" class="page">新车购置价：</td>
      <%}%>
      <td width="35%" class="page">
        <%=strPurChasePrice%>
      </td>
      <td width="15%" class="page">禁用标志：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getValidStatus()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">拼音查询码：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getSpellAb()%>
      </td>
      <td width="15%" class="page">型号查询码：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getModelId()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">盗抢险车型分组编码：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getTheftClass()%>
      </td>
      <td width="15%" class="page">车损险车型分组编码：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getDamagedClass()%>
      </td>
    </tr>                                                            
  </table>
  <table class=common align="center" cellpadding="5" cellspacing="1">
  	<tr>
    	<td class=formtitle colspan="4"> 
    		配置信息
    	</td>	
    </tr>
  </table>
  <table class=common cellpadding="5" cellspacing="1" id="EquipmentInfo" style="display:">
    <tr>
      <td width="15%" class="page">有无ABS装置：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getAbsFlag()%>
      </td>
      <td width="15%" class="page">有无防盗装置：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getTheftProof()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">安全气囊数量：</td>
      <td width="35%" class="page">
        <%=prpDcarModelNewSchema.getAirbagCount()%>
      </td>
      <td width="15%" class="page">选装装备：</td>
      <td width="35%" class="page">
      	<%=prpDcarModelNewSchema.getOptionalEquipment()%>
      </td>
    </tr>                                                            
    <tr>
      <td width="15%" class="page">标准装备：</td>
      <td colspan=3 width="80%" class="page">
        <%=prpDcarModelNewSchema.getStandardEquipment()%>
      </td>
    </tr>                                                            
  </table>
</form>
</body>
</html>
