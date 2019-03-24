<%--

****************************************************************************

* DESC       ���ⰸ�������ʼ��

* AUTHOR     ��luqin

* CREATEDATE ��2005-6-8

* MODIFYLIST ��   Name       Date            Reason/Contents

****************************************************************************

--%>



<%-- ����bean�ಿ�� --%>

<%@page import="java.text.*"%>

<%@page import="com.sinosoft.claim.ui.control.action.*"%>

<%@page import="com.sinosoft.claim.dto.custom.*"%>

<%@page import="com.sinosoft.claim.dto.domain.*"%> 

<%@page import="com.sinosoft.claim.util.*"%> 

<%@page import="com.sinosoft.sysframework.common.util.*"%> 

<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 

<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 



<%

  //������������

  String strClaimNo           = "";   //������

  String strPolicyNo          = "";   //������     

  String strKindCode          = "";   //�ձ����

  String strAddress           = "";   //���յص�

  String strInsuredDate       = "";   //�����ڼ�

  String strDamageStartDate   = "";   //����ʱ��
  
  DateTime DateStartDate 		= null;
  DateTime DateEndDate	        = null;



  //���뷭�����

  String strCode    = "";

  String strName    = "";

  boolean isChinese = true; //���ı�־

  

  //�����岿��

  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����

  

  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����

  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");

   

  UICodeAction uiCodeAction = new UICodeAction();

  

  //�õ�prpLclaimDto����

  prpLclaimDto   = claimDto.getPrpLclaimDto();

  

  //�õ�������

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
			strInsuredDate=" �� "+DateStartDate.getYear()
			
							+" �� "+DateStartDate.getMonth()
							
							+" �� "+DateStartDate.getDate()
						    
							+" ����ʱ��";
		}else{
		DateStartDate = prpLclaimDto.getStartDate();
		DateEndDate = prpLclaimDto.getEndDate();
		strInsuredDate=" �� "+DateStartDate.getYear()
		
						+" �� "+DateStartDate.getMonth()
						
						+" �� "+DateStartDate.getDate()
					    
						+" ����ʱ���� " +DateEndDate.getYear()
		
		                + "��" +DateEndDate.getMonth()
		
		                + "��" +DateEndDate.getDate()
		
		                + "�� ��ʮ��ʱֹ";
	}
				
%>                    

    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';

    tdInsuredName.innerHTML  = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>(<%= prpLclaimDto.getDamageTypeName()%>)';

    tdDamageAddress.innerHTML = '<%= prpLclaimDto.getDamageAddress()%>';

<%    

    strDamageStartDate =prpLclaimDto.getDamageStartDate().getYear()

                        + " �� " + prpLclaimDto.getDamageStartDate().getMonth()

                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()

                        + " ��";

%>                    

    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';

<%    

    //�¹�����

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

  