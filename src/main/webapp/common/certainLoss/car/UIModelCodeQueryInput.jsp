<%--
****************************************************************************
* DESC       ：查询车型代码入口
* Author     : 东安项目组
* CREATEDATE ： 2005-11-29
* MODIFYLIST ：   Name       Date            Reason/Contents
*                chenqiuqiao  2007-3-5
                 zhangruifeng 2007-11-11      在查询车辆信息后带出车辆系列ID
*                 zhouliubin 20071112        整备质量控制
*                 zhouliubin 20071113        把整备质量的控制去掉
*                 huzhenyu   20080108        车型查询结果的动态排序
*                 huzhenyu   20071205        浙江车型查询处理及车型查询优化
*                 huzhenyu   20080122        处理平台和系统中核定载客数不一致的问题
****************************************************************************
--%>

<%@page errorPage="/UIErrorPage"%>
<%@page import="com.sinosoft.utiall.blsvr.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.utility.error.UserException"%>
<%@page import="com.sinosoft.utility.string.*"%>
<%@page import="com.sinosoft.utiall.blsvr.*"%>
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.utiall.schema.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.prpall.*"%>
<% 
	//定义变量
	String trClass = "";
	String strRiskCode = "";
	String strLink = "";
	String iSpuerWherePart = "";
	String strOtherCondition = "";
	String strBizNo = "";
	String srhContext = "";
	String srhJPContext = "";
	String srhContextSuperModel = "";
	String srhContextJPModel = "";
	//add by genglx begin 2007-9-26 
	String srhContextAliasModel = "";
	//add by genglx e n d 2007-9-26 
	String strCarModelSpellAb = "";
	String strCarModelId = "";
	//add by huzhenyu 20071205 begin;
	String strComCode = (String)session.getValue("ComCode");
	if(strComCode == null || strComCode.equals("")){
		   strComCode = request.getParameter("ComCode");	
	}
	 //String strPriceShow = SysConfig.getProperty("ZJ_PRICESHOW");
	 String strPriceShow = "3";
  //add by huzhenyu 20071205 end;
	
	BLPrpDcarModel blPrpDcarModel = new BLPrpDcarModel();
	DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel();
	PrpDcarModelSchema prpDcarModelSchema = null;
	int index = 0;
	int i = 0;
	String striOthWherePart = "";
	int intPageNum = 0;
	int intPageCount = 0;
	String strPageCount = "";
	String strPageNum = request.getParameter("PageNum");
	request.setAttribute("index",request.getParameter("index"));

	if (strPageNum == null || strPageNum.trim().equals(""))
		intPageNum = 1;
	else
		intPageNum = Integer.parseInt(strPageNum.trim());
  if(request.getParameter("SuperModelName")!=null){
	  srhContext = request.getParameter("SuperModelName");
	  srhContextSuperModel = srhContext;
	}
	
	if(request.getParameter("JPModelName")!=null){
	  srhJPContext = request.getParameter("JPModelName");
	}
	//add by genglx begin 2007-9-26 
	if(request.getParameter("AliasName")!=null){
	  srhContextAliasModel = request.getParameter("AliasName");
	}
	//add by genglx e n d 2007-9-26 

	if (!srhJPContext.equals("")) {
	  if(!srhJPContext.trim().equals("")){
			srhContextJPModel = srhJPContext;
			//判断是否有空格
			int td = srhContextJPModel.indexOf(" ");
				if(td == -1){
				  //无空格
				  strCarModelSpellAb=srhContextJPModel;
		  	}else{
			    //有空格
			    String [] sstr=srhContextJPModel.split(" ");
			    strCarModelSpellAb= sstr[0];
			    for(int ss = 1; ss < sstr.length; ss++){
			    	strCarModelId+=sstr[ss];
			    }		    
				}		
			}
	}


	Pattern pen = Pattern.compile("[A-Z]+"); //英文
	Pattern pnum = Pattern.compile("[0-9]+");    //数字
	Pattern pch = Pattern.compile("[\u4E00-\u9FA5]+"); //中文

	Matcher men = pen.matcher(srhContext);
	Matcher mch = pch.matcher(srhContext);
	Matcher mnum = pnum.matcher(srhContext);
	
	Matcher cmen = pen.matcher(strCarModelId);
	Matcher cmnum = pnum.matcher(strCarModelId);
	
	Matcher smen = pen.matcher(srhContextJPModel);

	int iii = 0;
	int j = 0;
	int k = 0;
	
	int cme = 0;
	int cmn = 0;
	int sme = 0;
	
	if (!srhContext.equals("")) {
		while (men != null && men.find()) {
			iii++;
		}

		while (mch != null && mch.find()) {
			j++;
		}

		while (mnum != null && mnum.find()) {
			k++;
		}
	}
	
	if (!srhContextJPModel.equals("")) {
		while (smen != null && smen.find()) {
			sme++;
		}
	}
	
	if (!strCarModelId.equals("")) {
		while (cmen != null && cmen.find()) {
			cme++;
		}

		while (cmnum != null && cmnum.find()) {
			cmn++;
		}
	}
	
	String[] letter = new String[iii];
	String[] chinese = new String[j];
	String[] number = new String[k];
	
  String[] celetter = new String[cme];
	String[] cmnumber = new String[cmn];
	String[] seletter = new String[sme];
	men = pen.matcher(srhContext);
	mch = pch.matcher(srhContext);
	mnum = pnum.matcher(srhContext);
	
	smen = pen.matcher(srhContextJPModel);
	cmen = pen.matcher(strCarModelId);
	cmnum = pnum.matcher(strCarModelId);
   
  iSpuerWherePart = "1=1 and ValidStatus='1' ";  //modify by hzy20070405 增加非通用车型条件
  
	int m = 0;
	int n = 0;
	int v = 0;
	
	int cm = 0;
	int cv = 0;
	int sv = 0;
	//拼凑车型(modelname)代码查询
	if (!srhContext.equals("")) {	
		while (mch != null && mch.find()) {
			chinese[n] = mch.group();
			iSpuerWherePart += " and modelname like '%"	+ mch.group() + "%'";
			n++;
		}

		while (mnum != null && mnum.find()) {
			number[v] = mnum.group();
			iSpuerWherePart += " and modelname like '%"	+ mnum.group() + "%'";
			v++;
		}
		
		while (men != null && men.find()) {
			letter[m] = men.group();
			iSpuerWherePart += " and upper(modelname)  like '%" + men.group() + "%'";
			m++;
		}
		iSpuerWherePart+=" or aliasName like '%"+srhContext+"%'";
	}
	//拼凑(carmodelspellab)简拼SQL
	if (!strCarModelSpellAb.equals("")){
		 iSpuerWherePart += " and ( upper(ALIASSPELLAB) like '%" +srhJPContext + "%'";
		 iSpuerWherePart += "  or upper(shortHandCode) like  '%"+ srhJPContext + "%' ) ";
	}
  //拼凑(CarModelId)参数SQL
  if (!strCarModelId.equals("")) {		
		while (cmnum != null && cmnum.find()) {
			cmnumber[cv] = cmnum.group();
			iSpuerWherePart += " and CarModelId like '%"	+ cmnum.group() + "%'";
			cv++;
		}
		
		while (cmen != null && cmen.find()) {
			celetter[cm] = cmen.group();
			iSpuerWherePart += " and upper(CarModelId)  like '%" + cmen.group() + "%'";
			cm++;
		}		
	}

	//add by genglx begin 2007-9-26 
	if(!srhContextAliasModel.equals("")){
		iSpuerWherePart += " and factory like '%" + srhContextAliasModel + "%'";
	}
	//add by genglx e n d 2007-9-26 
	if(!(srhContext.equals("")&&srhJPContext.equals("")&&srhContextAliasModel.equals(""))){//modify by genglx 2007-9-26
	intPageCount = dbPrpDcarModel.getCount(iSpuerWherePart);
	}

	if (strPageNum == null) {
		if (intPageCount > 0)
			intPageCount = (intPageCount - 1) / 20 + 1;
		else {
			intPageCount = 0;
			intPageNum = 0;
		}
	} else {
		strPageCount = request.getParameter("PageCount");

		if (strPageCount == null || strPageCount.trim().equals("")) {
			intPageCount = 0;
		} else {
			//  intPageCount = Integer.parseInt(strPageCount.trim());
			intPageCount = (intPageCount - 1) / 18 + 1;
	
		}
		//  iSpuerWherePart = request.getParameter("SpuerWherePart");
	}
    if(!(srhContext.equals("")&&srhJPContext.equals("")&&srhContextAliasModel.equals(""))){//modify by genglx 2007-9-26
		  blPrpDcarModel.query(iSpuerWherePart, intPageNum, 18);
		  //add by hzy20070323begin
		  if(blPrpDcarModel.getSize()==0)
		  {
	%>
			<script language="javascript">
	    	alert("没有查到结果，请重新输入查询条件");
	    </script> 
	<%
	    }
	  //add by hzy20070323end	
		}

 %>
<html>
<head>
<title>查询条件页面</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<script language="javascript">
  var intPageWidth=screen.availWidth;
  var intPageHeight=screen.availHeight;
  window.resizeTo(intPageWidth,intPageHeight);
  window.focus();
  function mouseOverbig(field){
    //field.height="100";
  }
  function mouseOutSmall(field){ 
   // field.height="20";
    
  }
</script>
<script src="/claim/common/certainLoss/car/js/UICommon.js"></script>
<script src="/claim/common/certainLoss/car/js/TableAct.js"></script>
<script language=javascript>
    function document_onkeypress() {
			if   (window.event.keyCode==13){
				submitQueryForm();		
			}
	  }
    function submitQueryForm()
    {
        if(fm.SuperModelName.value==""&&fm.JPModelName.value==""&&fm.AliasName.value==""){
        	alert("请输入车型代码或者车型简拼或者车型别名!");
        	fm.SuperModelName.focus();
        	return false;
        }else if((fm.SuperModelName.value == fm.SuperModelNameTemp.value) 
        	&& (fm.JPModelName.value == fm.JPModelNameTemp.value)
        	&& (fm.AliasName.value == fm.AliasNameTemp.value)){
          return false;	
        }else{
        fm.PageNum.value=1;
    		fm.submit();
    	  }
    }
    
    //add by hzy20070405 begin
    function submitUsual()
    {
    	fm.SuperModelName.value = "";
    	fm.JPModelName.value = "";
    	UsualTable.style.display = "";
    	commonTable.style.display = "none";
    	commonButton.style.display = "none";
    }
    //add by hzy20070405 end
    
    function UpperCase(e)
    {
      var keycode = window.event.keyCode;
      if( keycode>=97 && keycode<=122 )
      {
        window.event.keyCode = keycode-32;        
        return pressCustom(e,/[\dA-Z\.]/);
      }
      if(keycode=32){
        
      }
    }
    </script>
<script language="javascript">
      function submitForm(modelName,modelCode,exhaustScale,seatCount,tonCount,carActualValue,purchasePrice,countryNature,curbWeightMin,curbWeightMax,series_Id)
      {
        try
        {
          //modify by zhouliubin;把整被质量自动带出的功能去掉；20071113;begin.
            //var CarShipFlag = window.opener.fm.CarShipFlag.value;
            
             var strindex = "<%=(String)request.getParameter("index")%>";
             var index = parseInt(strindex);
             if(isNaN(index))index = 0;
            if(window.opener.fm.prpLcarLossBrandName != null){
                window.opener.fm.prpLcarLossBrandName.value =  modelName;     //厂牌型号
                window.opener.fm.prpLcarLossModelCode.value =  modelCode;     //车型代码            
            }
            
            if(window.opener.fm.prpLthirdPartyBrandName != null){
                window.opener.fm.prpLthirdPartyBrandName[index].value = modelName;
                window.opener.fm.prpLthirdPartyModelCode[index].value = modelCode
               
            }
            //modify by zhouliubin;处理通用车型。20070315。start.
           /*
            if(modelCode.indexOf("USUAL")==-1)
            {
              window.opener.fm.ExhaustScale.value =  exhaustScale;     //排量/功率
              window.opener.fm.ExhaustScale.onchange();
              window.opener.fm.SeatCount.value =  seatCount;     //核定载客
              window.opener.fm.SeatCount.onchange();
              window.opener.fm.TonCount.value =  tonCount;      //核定载质量                   
              window.opener.fm.TonCount.onchange();
              window.opener.fm.CarActualValue.value =  carActualValue;//新车购置价(原始数据)   
              window.opener.fm.PurchasePrice.value =  purchasePrice; //新车购置价
              window.opener.fm.CarActualValueTrue.value =  purchasePrice; //新车购置价True   
              window.opener.fm.Series_Id.value =  series_Id;  //系列ID	
            }
            */
            /*
            if(CarShipFlag == "1"){
                if(curbWeightMin !=undefined && curbWeightMin !=""&& curbWeightMax !=undefined&& curbWeightMax !="")
                {
            	window.opener.fm.CurbWeightMin.value = curbWeightMin; //整备质量最小值
            	window.opener.fm.CurbWeightMax.value = curbWeightMax; //整备质量最大值
            	window.opener.fm.CompleteKerbMass.value = curbWeightMin; //整备质量
            	}
          	}
          	*/
            //modify by zhouliubin;20070315。end.
            //modify by zhouliubin;把整被质量自动带出的功能去掉；20071113;end.
            window.opener.fm.CountryNature.value =  countryNature; //进口/国产类
            window.opener.fm.FrameNo.focus();
            //window.opener.fm.BrandName.onblur();
            window.opener.fm.BrandName.onchange();
            //window.opener.fm.BrandName.focus();
            
          //}
        }
        catch(e){}
        window.close();
        return;

      }
    </script>
</head>
<body onload="initResultTable(commonTable)">
<form name=fm action="/claim/common/certainLoss/car/UIModelCodeQueryInput.jsp"
	method=post>
<table class=common cellpadding="5" cellspacing="1">
    <input type="hidden" name="index" value="<%=request.getParameter("index") %>">
	<tr>
		<td class=formtitle colspan="10">按条件查询 
			<input type="hidden" name="RiskCode" value="<%=(String)request.getParameter("RiskCode")%>">
			<input type="hidden" name="ComCode" value="<%=strComCode %>">
		</td>
	</tr>
	<tr >
		<td width='10%'>厂牌型号：</td>
		<td width='15%'><input onkeypress="document_onkeypress();return UpperCase(event);" name="SuperModelName" class="common"
			value="<%=srhContextSuperModel%>"/></td>
			<input type='hidden' name="SuperModelNameTemp"value="<%=srhContextSuperModel%>"/> 
		<td width='10%'>简拼录入：</td>
		<td width='15%'><input onkeypress="document_onkeypress();return UpperCase(event);" name="JPModelName" class="common"
			style="width=100px" value="<%=srhContextJPModel%>"/></td>	
			<input type='hidden' name="JPModelNameTemp" value="<%=srhContextJPModel%>"/>    
		<td width='10%'>厂商查询：</td>
		<td width='15%'><input onkeypress="document_onkeypress();return UpperCase(event);" name="AliasName" class="common"
			style="width=100px" value="<%=srhContextAliasModel%>"/></td>	
			<input type='hidden' name="AliasNameTemp" value="<%=srhContextAliasModel%>"/>    
		<td colspan=3 class=button><input class="button" align="left" type="button"
			name="ModelNameSubmit" alt=" 查 询 " value="查 询"
			onclick="submitQueryForm()"></td>
		<%-- add by hzy20070404 begin --%>
		<%--<td colspan=1 class=button><input class="longbutton" align="right" type="button"
			name="UsualModelSubmit" alt=" 使用通用车型 " value="使用通用车型"
			onclick="submitUsual()"></td>	 --%>
		<%-- add by hzy20070404 end --%>
	</tr>
	<%
	if("33".equals(strComCode.substring(0,2)))
	{
	%>
	<tr>
		<td colspan='13' style='color:red'>
			<b>没有行业价格的，请到协会网站进行查询！</b>
		</td>
	</tr>
	<%
	}
	%>
</table>
<table id="commonTable" class=common cellpadding="5" cellspacing="1">
	<thead>
	<tr class=listtitle>
		<td width='10%'>厂牌型号</td>
		<td width='10%'>车型别名</td>
		<td width='10%'>车辆种类</td>
		<td width='10%'>车型类型</td>
		<td width='8%'>排量（L）</td>
		<td width='5%'>核定载客</td>
		<td width='5%'>核定载质量（吨）</td>
	<%
	if("33".equals(strComCode.substring(0,2)))
	{
		if(strPriceShow.equals("1"))
		{
	%>
	  <td width='12%'>车价</td>
	<%
	  }
	  else if(strPriceShow.equals("2"))
	  {
	%>
		<td width='6%'>广信车价</td>
		<td width='6%'>行业车价</td>
	<%
	  }
	}
  else
  {
	%>
	  <td width='12%'>新车购置价</td>
	<%
	}
	%>
		<td width='8%'>上市年份</td>
		<td width='8%'>风险说明</td>
		<td width='9%'>备注</td>
		<td width='5%'>车型详细信息</td>
	</tr>
	</thead>
	<tbody >
	<%
			String strPurChasePrice = "";
			String strPriceType = "";
			for (i = 0; i < blPrpDcarModel.getSize(); i++) {
			prpDcarModelSchema = blPrpDcarModel.getArr(i);
			if("33".equals(strComCode.substring(0,2)))
			{
			  if(strPriceShow.equals("1"))
			  {
			    strPurChasePrice = prpDcarModelSchema.getXH_Price();
			    strPriceType = "行业";
			    if(strPurChasePrice.equals(""))
			    {
			      strPurChasePrice = prpDcarModelSchema.getLB_Price();
			      strPriceType = "类比";
			    }	  
			    if(strPurChasePrice.equals(""))
			    {
			      strPurChasePrice = prpDcarModelSchema.getPurchasePrice();
			      strPriceType = "广信";
			    }
			  }
			  else
				{
				  strPurChasePrice = prpDcarModelSchema.getXH_Price();
			    if(!prpDcarModelSchema.getLB_Price().equals(""))
			    {
			      strPurChasePrice = "";
			    }	
				}
			}
		  else
		  {
		    strPurChasePrice = prpDcarModelSchema.getPurchasePrice();
		  }
		  if(!strPurChasePrice.equals(""))
		  {
		    strPurChasePrice = new DecimalFormat("0.00").format(Double.parseDouble(strPurChasePrice));
		  }
			if (i % 2 == 0) {
				trClass = "listodd";
			} else {
				trClass = "listeven";
			}
	%>
	<tr class="<%=trClass%>"  onmouseover="mouseOverbig(this)" onmouseout="mouseOutSmall(this)">
		<td class=itemLink
			onclick="submitForm('<%=prpDcarModelSchema.getModelName()%>'
      ,'<%=prpDcarModelSchema.getModelCode()%>'
      ,'<%=prpDcarModelSchema.getExHaustScale()%>'
      ,'<%=prpDcarModelSchema.getSeatCount()%>'
      ,'<%=prpDcarModelSchema.getTonCount()%>'
      ,'<%=strPurChasePrice%>'
      ,'<%=strPurChasePrice%>'
      ,'<%=prpDcarModelSchema.getCarStyle()%>'
      ,'<%=prpDcarModelSchema.getCurbWeightMin()%>'
      ,'<%=prpDcarModelSchema.getCurbWeightMax()%>'
      ,'<%=prpDcarModelSchema.getSeries_Id()%>');"
      ><%=prpDcarModelSchema.getModelName()%></td>
        <td><%=prpDcarModelSchema.getAliasName()%></td>
		<td><%=prpDcarModelSchema.getCarKind()%></td>
		<td><%=prpDcarModelSchema.getCarStyle()%></td>
		<td><%=prpDcarModelSchema.getExHaustScale()%></td>
		<td><%=prpDcarModelSchema.getSeatCount()%></td>
		<td><%=prpDcarModelSchema.getTonCount()%></td>
	<%
	if("33".equals(strComCode.substring(0,2)))
	{
		if(strPriceShow.equals("1"))
		{
	%>
		<td>(<%=strPriceType%>)<%=strPurChasePrice%></td>
	<%
	  }
	  else if(strPriceShow.equals("2"))
	  {
			if(strPurChasePrice.equals(""))
			{
			  strPurChasePrice = "无行业价格";
			}
			if(!prpDcarModelSchema.getLB_Price().equals(""))
			{
			  strPurChasePrice = "停产";
			}	
	%>
	  <td><%=new DecimalFormat("0.00").format(Double.parseDouble(prpDcarModelSchema.getPurchasePrice()))%></td>
	  <td><%=strPurChasePrice%></td>
	<%
	  }
	}
  else
  {
	%>
	  <td><%=strPurChasePrice%></td>
	<%
	}
	%>
		<td><%=prpDcarModelSchema.getCarYear()%></td>
		<td><%=prpDcarModelSchema.getRiskType()%></td>
		<td><%=prpDcarModelSchema.getRemark()%></td>
		<td>
			<input align="left" type="button" name="CarModelDetail" alt="详细" value="详细" description="<%=prpDcarModelSchema.getModelCode()%>" onclick="openWindow(this,'<%=strPurChasePrice%>')">
	  </td>
	</tr>
	<%
	}
	%>
	</tbody>
	<tfoot>
	<tr>
		<td colspan=11 class=input align=center>本页共 <%=i%> 条记录 第 <%=intPageNum%>
		页 / 共 <%=intPageCount%> 页</td>
	</tr>
	</tfoot>
</table>
<%-- add by hzy20070404 begin 增加固定通用车型--%>
<table id="UsualTable" style="display:none" class=common cellpadding="5" cellspacing="1">
	<tr class=listtitle>
		<td width='10%'>厂牌型号</td>
		<td width='10%'>车辆种类</td>
		<td width='10%'>车辆别名</td>
		<td width='8%'>A/B类</td>
		<td width='8%'>排量/功率（L/KW）</td>
		<td width='8%'>核定载客</td>
		<td width='8%'>核定载质量</td>
		<td width='10%'>新车购置价</td>
		<td width='8%'>上市年份</td>
		<td width='10%'>风险说明</td>
		<td colspan=2 width='10%'>备注</td>
	</tr>
	<%
	String UsualModelName[] 	= {"通用车型农用型","通用车型10万以下","通用车型10-20万","通用车型20-30万"};
	String UsualModelCode[] 	= {"USUAL002","USUAL003","USUAL004","USUAL005"};
	String UsualSeatCount[] 	= {"","","",""};
	String UsualTonCount[] 		= {"","","",""};
	String UsualPurchasePrice[] = {"","","",""};
	String UsualAliasName[] 		= {"","","",""};
	String UsualCarStyle[] 		= {"","","",""};
	String UsualCarKind[] 		= {"","","",""};
	String UsualCarYear[]			= {"","","",""};
	String UsualRiskType[]		= {"","","",""};
	String UsualRemark[]			= {"","","",""};
		for (i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				trClass = "listodd";
			} else {
				trClass = "listeven";
			}
	%>
	<tr class="<%=trClass%>">
		<td class=itemLink
		onclick="submitForm('<%=UsualModelName[i]%>'
      ,'<%=UsualModelCode[i]%>'
      ,'<%=UsualSeatCount[i]%>'
      ,'<%=UsualTonCount[i]%>'
      ,'<%=UsualPurchasePrice[i]%>'
      ,'<%=UsualPurchasePrice[i]%>'
      ,'<%=UsualCarStyle[i]%>');"
    	><%=UsualModelName[i]%></td>
		<td><%=UsualModelCode[i]%></td>
		<td><%=UsualCarKind[i]%></td>
		<td><%=UsualAliasName[i]%></td>
		<td><%=UsualCarStyle[i]%></td>
		<td><%=UsualSeatCount[i]%></td>
		<td><%=UsualTonCount[i]%></td>
		<td><%=UsualPurchasePrice[i]%></td>
		<td><%=UsualCarYear[i]%></td>
		<td><%=UsualRiskType[i]%></td>
		<td><%=UsualRemark[i]%></td>
	</tr>
	<%
	}
	%>
	<tr>
		<td colspan=10 class=input align=center>通用车型共4种</td>
	</tr>
</table>
<%-- add by hzy20070404 end --%>
<table id="commonButton" class="common" align="center">
	<tr>
		<td align=center><input type="hidden" name="PageNum"
			value="<%=intPageNum%>"> <input type="hidden"
			name="PageCount" value="<%=intPageCount%>"> <input
			type="hidden" name="SpuerWherePart" value="<%=iSpuerWherePart%>">
		<br>
		<%
		if (intPageNum > 1) {
		%> <input class="button" type="button" name="FirstPage"
			onclick="gotoPage('First');" alt=" 首 页 " value="首 页"> <input
			class="button" type="button" name="PreviousPage"
			onclick="gotoPage('Previous');" alt=" 上一页 " value="上一页"> <%
 	}
 	if (intPageNum < intPageCount) {
 %> <input class="button" type="button" name="NextPage"
			onclick="gotoPage('Next');" alt=" 下一页 " value="下一页"> <input
			class="button" type="button" name="FinalPage"
			onclick="gotoPage('Final');" alt=" 最后一页 " value="最后一页"> <%
 	}
 	if (intPageCount > 1) {
 %> 转到第 <input type="text" class=small name="Personal" size="2"
			value="1"> 页 <input class="smallbutton" type="button"
			name="PersonalPage" alt="GO" value="GO"
			onclick="gotoPage('Personal');"> <%
 }
 %>
		</td>
	</tr>
	<script language="javascript">	  
			function openWindow(field,price){
			  var strURL = "/claim/common/certainLoss/car/UICarModelDetail.jsp?ModelCode=" + field.description +
			   "&PurChasePrice=" + price + "&ComCode=<%=strComCode%>";
			  window.open(strURL,'车型信息','width=936,height=700,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
			}
      function gotoPage(strMethod)
      {
        if(parseInt(fm.PageNum.value) == 1)
        {
          fm.NextPage.disabled = true;
          fm.FinalPage.disabled = true;
        }
        else if(parseInt(fm.PageNum.value) == parseInt(fm.PageCount.value))
        {
          fm.FirstPage.disabled = true;
          fm.PreviousPage.disabled = true;
        }
        else
        {
          fm.FirstPage.disabled = true;
          fm.PreviousPage.disabled = true;
          fm.NextPage.disabled = true;
          fm.FinalPage.disabled = true;
        }
        if(parseInt(fm.PageCount.value) > 1)
          fm.PersonalPage.disabled = true;

        if(strMethod=="First")
          fm.PageNum.value = 1;
        else if(strMethod=="Previous")
          fm.PageNum.value = parseInt(fm.PageNum.value) - 1;
        else if(strMethod=="Next")
          fm.PageNum.value = parseInt(fm.PageNum.value) + 1;
        else if(strMethod=="Final")
          fm.PageNum.value = fm.PageCount.value;
        else if(strMethod=="Personal")
        {
          if(parseInt(fm.Personal.value)<1||parseInt(fm.Personal.value)>parseInt(fm.PageCount.value))
          {
            alert("没有这一页，请重试！");
            fm.Personal.focus();
            if(parseInt(fm.PageNum.value) == 1)
            {
              fm.NextPage.disabled = false;
              fm.FinalPage.disabled = false;
            }
            else if(parseInt(fm.PageNum.value) == parseInt(fm.PageCount.value))
            {
              fm.FirstPage.disabled = false;
              fm.PreviousPage.disabled = false;
            }
            else
            {
              fm.FirstPage.disabled = false;
              fm.PreviousPage.disabled = false;
              fm.NextPage.disabled = false;
              fm.FinalPage.disabled = false;
            }
            if(parseInt(fm.PageCount.value) > 1)
              fm.PersonalPage.disabled = false;
            return false;
          }
          else
            fm.PageNum.value = fm.Personal.value;
        }
        
        fm.action = "/claim/common/certainLoss/car/UIModelCodeQueryInput.jsp?index="+ "<%=request.getParameter("index")%>";
        
        fm.submit();
      }
    </script>
</table>
</form>
</body>
</html>

