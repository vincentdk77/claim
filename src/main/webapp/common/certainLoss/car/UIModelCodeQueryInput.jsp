<%--
****************************************************************************
* DESC       ����ѯ���ʹ������
* Author     : ������Ŀ��
* CREATEDATE �� 2005-11-29
* MODIFYLIST ��   Name       Date            Reason/Contents
*                chenqiuqiao  2007-3-5
                 zhangruifeng 2007-11-11      �ڲ�ѯ������Ϣ���������ϵ��ID
*                 zhouliubin 20071112        ������������
*                 zhouliubin 20071113        �����������Ŀ���ȥ��
*                 huzhenyu   20080108        ���Ͳ�ѯ����Ķ�̬����
*                 huzhenyu   20071205        �㽭���Ͳ�ѯ�������Ͳ�ѯ�Ż�
*                 huzhenyu   20080122        ����ƽ̨��ϵͳ�к˶��ؿ�����һ�µ�����
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
	//�������
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
			//�ж��Ƿ��пո�
			int td = srhContextJPModel.indexOf(" ");
				if(td == -1){
				  //�޿ո�
				  strCarModelSpellAb=srhContextJPModel;
		  	}else{
			    //�пո�
			    String [] sstr=srhContextJPModel.split(" ");
			    strCarModelSpellAb= sstr[0];
			    for(int ss = 1; ss < sstr.length; ss++){
			    	strCarModelId+=sstr[ss];
			    }		    
				}		
			}
	}


	Pattern pen = Pattern.compile("[A-Z]+"); //Ӣ��
	Pattern pnum = Pattern.compile("[0-9]+");    //����
	Pattern pch = Pattern.compile("[\u4E00-\u9FA5]+"); //����

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
   
  iSpuerWherePart = "1=1 and ValidStatus='1' ";  //modify by hzy20070405 ���ӷ�ͨ�ó�������
  
	int m = 0;
	int n = 0;
	int v = 0;
	
	int cm = 0;
	int cv = 0;
	int sv = 0;
	//ƴ�ճ���(modelname)�����ѯ
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
	//ƴ��(carmodelspellab)��ƴSQL
	if (!strCarModelSpellAb.equals("")){
		 iSpuerWherePart += " and ( upper(ALIASSPELLAB) like '%" +srhJPContext + "%'";
		 iSpuerWherePart += "  or upper(shortHandCode) like  '%"+ srhJPContext + "%' ) ";
	}
  //ƴ��(CarModelId)����SQL
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
	    	alert("û�в鵽����������������ѯ����");
	    </script> 
	<%
	    }
	  //add by hzy20070323end	
		}

 %>
<html>
<head>
<title>��ѯ����ҳ��</title>
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
        	alert("�����복�ʹ�����߳��ͼ�ƴ���߳��ͱ���!");
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
          //modify by zhouliubin;�����������Զ������Ĺ���ȥ����20071113;begin.
            //var CarShipFlag = window.opener.fm.CarShipFlag.value;
            
             var strindex = "<%=(String)request.getParameter("index")%>";
             var index = parseInt(strindex);
             if(isNaN(index))index = 0;
            if(window.opener.fm.prpLcarLossBrandName != null){
                window.opener.fm.prpLcarLossBrandName.value =  modelName;     //�����ͺ�
                window.opener.fm.prpLcarLossModelCode.value =  modelCode;     //���ʹ���            
            }
            
            if(window.opener.fm.prpLthirdPartyBrandName != null){
                window.opener.fm.prpLthirdPartyBrandName[index].value = modelName;
                window.opener.fm.prpLthirdPartyModelCode[index].value = modelCode
               
            }
            //modify by zhouliubin;����ͨ�ó��͡�20070315��start.
           /*
            if(modelCode.indexOf("USUAL")==-1)
            {
              window.opener.fm.ExhaustScale.value =  exhaustScale;     //����/����
              window.opener.fm.ExhaustScale.onchange();
              window.opener.fm.SeatCount.value =  seatCount;     //�˶��ؿ�
              window.opener.fm.SeatCount.onchange();
              window.opener.fm.TonCount.value =  tonCount;      //�˶�������                   
              window.opener.fm.TonCount.onchange();
              window.opener.fm.CarActualValue.value =  carActualValue;//�³����ü�(ԭʼ����)   
              window.opener.fm.PurchasePrice.value =  purchasePrice; //�³����ü�
              window.opener.fm.CarActualValueTrue.value =  purchasePrice; //�³����ü�True   
              window.opener.fm.Series_Id.value =  series_Id;  //ϵ��ID	
            }
            */
            /*
            if(CarShipFlag == "1"){
                if(curbWeightMin !=undefined && curbWeightMin !=""&& curbWeightMax !=undefined&& curbWeightMax !="")
                {
            	window.opener.fm.CurbWeightMin.value = curbWeightMin; //����������Сֵ
            	window.opener.fm.CurbWeightMax.value = curbWeightMax; //�����������ֵ
            	window.opener.fm.CompleteKerbMass.value = curbWeightMin; //��������
            	}
          	}
          	*/
            //modify by zhouliubin;20070315��end.
            //modify by zhouliubin;�����������Զ������Ĺ���ȥ����20071113;end.
            window.opener.fm.CountryNature.value =  countryNature; //����/������
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
		<td class=formtitle colspan="10">��������ѯ 
			<input type="hidden" name="RiskCode" value="<%=(String)request.getParameter("RiskCode")%>">
			<input type="hidden" name="ComCode" value="<%=strComCode %>">
		</td>
	</tr>
	<tr >
		<td width='10%'>�����ͺţ�</td>
		<td width='15%'><input onkeypress="document_onkeypress();return UpperCase(event);" name="SuperModelName" class="common"
			value="<%=srhContextSuperModel%>"/></td>
			<input type='hidden' name="SuperModelNameTemp"value="<%=srhContextSuperModel%>"/> 
		<td width='10%'>��ƴ¼�룺</td>
		<td width='15%'><input onkeypress="document_onkeypress();return UpperCase(event);" name="JPModelName" class="common"
			style="width=100px" value="<%=srhContextJPModel%>"/></td>	
			<input type='hidden' name="JPModelNameTemp" value="<%=srhContextJPModel%>"/>    
		<td width='10%'>���̲�ѯ��</td>
		<td width='15%'><input onkeypress="document_onkeypress();return UpperCase(event);" name="AliasName" class="common"
			style="width=100px" value="<%=srhContextAliasModel%>"/></td>	
			<input type='hidden' name="AliasNameTemp" value="<%=srhContextAliasModel%>"/>    
		<td colspan=3 class=button><input class="button" align="left" type="button"
			name="ModelNameSubmit" alt=" �� ѯ " value="�� ѯ"
			onclick="submitQueryForm()"></td>
		<%-- add by hzy20070404 begin --%>
		<%--<td colspan=1 class=button><input class="longbutton" align="right" type="button"
			name="UsualModelSubmit" alt=" ʹ��ͨ�ó��� " value="ʹ��ͨ�ó���"
			onclick="submitUsual()"></td>	 --%>
		<%-- add by hzy20070404 end --%>
	</tr>
	<%
	if("33".equals(strComCode.substring(0,2)))
	{
	%>
	<tr>
		<td colspan='13' style='color:red'>
			<b>û����ҵ�۸�ģ��뵽Э����վ���в�ѯ��</b>
		</td>
	</tr>
	<%
	}
	%>
</table>
<table id="commonTable" class=common cellpadding="5" cellspacing="1">
	<thead>
	<tr class=listtitle>
		<td width='10%'>�����ͺ�</td>
		<td width='10%'>���ͱ���</td>
		<td width='10%'>��������</td>
		<td width='10%'>��������</td>
		<td width='8%'>������L��</td>
		<td width='5%'>�˶��ؿ�</td>
		<td width='5%'>�˶����������֣�</td>
	<%
	if("33".equals(strComCode.substring(0,2)))
	{
		if(strPriceShow.equals("1"))
		{
	%>
	  <td width='12%'>����</td>
	<%
	  }
	  else if(strPriceShow.equals("2"))
	  {
	%>
		<td width='6%'>���ų���</td>
		<td width='6%'>��ҵ����</td>
	<%
	  }
	}
  else
  {
	%>
	  <td width='12%'>�³����ü�</td>
	<%
	}
	%>
		<td width='8%'>�������</td>
		<td width='8%'>����˵��</td>
		<td width='9%'>��ע</td>
		<td width='5%'>������ϸ��Ϣ</td>
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
			    strPriceType = "��ҵ";
			    if(strPurChasePrice.equals(""))
			    {
			      strPurChasePrice = prpDcarModelSchema.getLB_Price();
			      strPriceType = "���";
			    }	  
			    if(strPurChasePrice.equals(""))
			    {
			      strPurChasePrice = prpDcarModelSchema.getPurchasePrice();
			      strPriceType = "����";
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
			  strPurChasePrice = "����ҵ�۸�";
			}
			if(!prpDcarModelSchema.getLB_Price().equals(""))
			{
			  strPurChasePrice = "ͣ��";
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
			<input align="left" type="button" name="CarModelDetail" alt="��ϸ" value="��ϸ" description="<%=prpDcarModelSchema.getModelCode()%>" onclick="openWindow(this,'<%=strPurChasePrice%>')">
	  </td>
	</tr>
	<%
	}
	%>
	</tbody>
	<tfoot>
	<tr>
		<td colspan=11 class=input align=center>��ҳ�� <%=i%> ����¼ �� <%=intPageNum%>
		ҳ / �� <%=intPageCount%> ҳ</td>
	</tr>
	</tfoot>
</table>
<%-- add by hzy20070404 begin ���ӹ̶�ͨ�ó���--%>
<table id="UsualTable" style="display:none" class=common cellpadding="5" cellspacing="1">
	<tr class=listtitle>
		<td width='10%'>�����ͺ�</td>
		<td width='10%'>��������</td>
		<td width='10%'>��������</td>
		<td width='8%'>A/B��</td>
		<td width='8%'>����/���ʣ�L/KW��</td>
		<td width='8%'>�˶��ؿ�</td>
		<td width='8%'>�˶�������</td>
		<td width='10%'>�³����ü�</td>
		<td width='8%'>�������</td>
		<td width='10%'>����˵��</td>
		<td colspan=2 width='10%'>��ע</td>
	</tr>
	<%
	String UsualModelName[] 	= {"ͨ�ó���ũ����","ͨ�ó���10������","ͨ�ó���10-20��","ͨ�ó���20-30��"};
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
		<td colspan=10 class=input align=center>ͨ�ó��͹�4��</td>
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
			onclick="gotoPage('First');" alt=" �� ҳ " value="�� ҳ"> <input
			class="button" type="button" name="PreviousPage"
			onclick="gotoPage('Previous');" alt=" ��һҳ " value="��һҳ"> <%
 	}
 	if (intPageNum < intPageCount) {
 %> <input class="button" type="button" name="NextPage"
			onclick="gotoPage('Next');" alt=" ��һҳ " value="��һҳ"> <input
			class="button" type="button" name="FinalPage"
			onclick="gotoPage('Final');" alt=" ���һҳ " value="���һҳ"> <%
 	}
 	if (intPageCount > 1) {
 %> ת���� <input type="text" class=small name="Personal" size="2"
			value="1"> ҳ <input class="smallbutton" type="button"
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
			  window.open(strURL,'������Ϣ','width=936,height=700,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
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
            alert("û����һҳ�������ԣ�");
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

