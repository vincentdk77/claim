<%--

****************************************************************************

* DESC       ：赔案处理报告初始化

* AUTHOR     ：luqin

* CREATEDATE ：2005-6-8

* MODIFYLIST ：   Name       Date            Reason/Contents

****************************************************************************

--%>



<%-- 引入bean类部分 --%>

<%@page import="java.text.*"%>

<%@page import="com.sinosoft.claim.ui.control.action.*"%>

<%@page import="com.sinosoft.claim.dto.custom.*"%>

<%@page import="com.sinosoft.claim.dto.domain.*"%> 

<%@page import="com.sinosoft.claim.util.*"%> 

<%@page import="com.sinosoft.sysframework.common.util.*"%> 

<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 

<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 



<%

  //变量声明部分

  String strClaimNo           = "";   //立案号

  String strPolicyNo          = "";   //保单号     

  String strKindCode          = "";   //险别代码

  String strAddress           = "";   //出险地点

  String strInsuredDate       = "";   //保险期间

  String strDamageStartDate   = "";   //出险时间
  
  DateTime DateStartDate 		= null;
  DateTime DateEndDate	        = null;



  //代码翻译变量

  String strCode    = "";

  String strName    = "";

  boolean isChinese = true; //中文标志

  

  //对象定义部分

  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto对象

  

  //得到ClaimDto,RegistDto,CertainLossDto,PolicyDto对象

  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");

   

  UICodeAction uiCodeAction = new UICodeAction();

  

  //得到prpLclaimDto对象

  prpLclaimDto   = claimDto.getPrpLclaimDto();

  

  //得到保单号

  strPolicyNo = prpLclaimDto.getPolicyNo();

%>



<%@page import="com.sinosoft.utility.string.Date"%>
<script language="javascript">

  function loadForm()

  {

    tdCaseNo.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getCaseNo())%>';

    tdPolicyNo.innerHTML = '<%=strPolicyNo%>';

    tdRiskCode.innerHTML = '<%=prpLclaimDto.getRiskCode()%>';

    tdSumAmount.innerHTML = '<%= new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumAmount())%>';

<%  
	if(prpLclaimDto.getEndDate().isEmpty())
		{
			DateStartDate = prpLclaimDto.getStartDate();
			strInsuredDate=" 自 "+DateStartDate.getYear()
			
							+" 月 "+DateStartDate.getMonth()
							
							+" 日 "+DateStartDate.getDate()
						    
							+" 日零时起";
		}else{
		DateStartDate = prpLclaimDto.getStartDate();
		DateEndDate = prpLclaimDto.getEndDate();
		strInsuredDate=" 自 "+DateStartDate.getYear()
		
						+" 月 "+DateStartDate.getMonth()
						
						+" 日 "+DateStartDate.getDate()
					    
						+" 日零时起至 " +DateEndDate.getYear()
		
		                + "年" +DateEndDate.getMonth()
		
		                + "月" +DateEndDate.getDate()
		
		                + "日 二十四时止";
	}
				
%>                    

    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';

    tdInsuredName.innerHTML  = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>(<%= prpLclaimDto.getDamageTypeName()%>)';

    tdDamageAddress.innerHTML = '<%= prpLclaimDto.getDamageAddress()%>';

<%    

    strDamageStartDate =prpLclaimDto.getDamageStartDate().getYear()

                        + " 年 " + prpLclaimDto.getDamageStartDate().getMonth()

                        + " 月 " + prpLclaimDto.getDamageStartDate().getDate()

                        + " 日";

%>                    

    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';

<%    

    //事故责任

    strCode = ""; 

    strName = "";

    strCode = StringConvert.encode(prpLclaimDto.getIndemnityDuty());

    strName = uiCodeAction.translateCodeCode("IndemnityDuty",strCode,isChinese);

%>

    tdIndemnityDuty.innerHTML     = '<%=strName%>';

    tdSumClaim.innerHTML = '<%=prpLclaimDto.getSumClaim()%>';

    tdSumDefLoss.innerHTML = '<%=prpLclaimDto.getSumDefLoss()%>';

    tdSumPaid.innerHTML = '<%=prpLclaimDto.getSumPaid()%>';

  } 

</script>

  