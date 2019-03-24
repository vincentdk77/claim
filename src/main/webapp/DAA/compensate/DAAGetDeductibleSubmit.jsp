<%--
****************************************************************************
* DESC       ： 刷新不计免赔
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-11-05
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>                                  

<%-- 引入bean类部分 --%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.*"%>

<script>
<%                                                             
  String strClauseTypeCode = request.getParameter("prpLcompensateClauseTypeCode");
  String Index = request.getParameter("Index"); 
  String strIndemnityDuty  = request.getParameter("prpLcompensateIndemnityDuty");
  String strDeductibleTerm = request.getParameter("prpLcompensateDeductCond");
  String strEscapeFlag     = request.getParameter("prpLcompensateEscapeFlag");
  String strRiskCode       = request.getParameter("prpLcompensateRiskCode"); 
  String[] arrLossKindCode = request.getParameterValues("prpLlossDtoKindCode");
  String[] arrLossRealPay  = request.getParameterValues("prpLlossDtoSumRealPay");
  String[] arrLossFeeTypeCode  = request.getParameterValues("prpLlossDtoFeeTypeCode");
  String[] arrLDeductibleRate  = request.getParameterValues("prpLlossDtoDeductibleRate");
  //String[] arrLossDutyRate = request.getParameterValues("LossDutyRate");
   
  String[] arrPersonNo2        = request.getParameterValues("personLossSerialNo"); //内部
  String[] arrPersonNo1        = request.getParameterValues("prpLpersonLossPersonNo"); //外部，只人员的序号
  String[] arrPDeductibleRate  = request.getParameterValues("prpLpersonLossDeductibleRate"); 
  String[] arrKindCode         = request.getParameterValues("prpLpersonLossKindCode");    
  String[] arrRealpay          = request.getParameterValues("prpLpersonLossSumRealPay");           
  //String[] arrDeductibleRate   = request.getParameterValues("PersonLossDeductibleRate");
                          
  String strPolicyNo        = request.getParameter("PolicyNo"); 
  String strDamageStartDate = request.getParameter("DamageStartDate"); 
  String strFlag = "";
  double dblPDeductibleRate = 0;
  double dblDeductibleRate = 0;
  double dblDeductible = 0;
  double dblDeductibleTmp = 0;
  int intCount = 0;

  //BLPolicy       blPolicy       = new BLPolicy();
  //BLEndorse      blEndorse      = new BLEndorse();
  //BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
  try 
  {
    EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
    PolicyDto policyDto = endorseViewHelper.findForEndorBefore(strPolicyNo,strDamageStartDate); //findForEndorBeforeCar?? getRate1() ??
    //blPolicy = blEndorse.findForEndorBeforeCar(strPolicyNo,strDamageStartDate);
    //blPrpCitemKind = blPolicy.getBLPrpCitemKind();
    List prpCitemKindList =  (ArrayList)policyDto.getPrpCitemKindDtoList();
    for(int i=1; i<arrLossKindCode.length; i++)
    {
      strFlag = "";
      if(arrLossKindCode[i].equals("M")||arrLossFeeTypeCode[i].equals("27"))
      {
        continue;
      }      
      for(int j=0;j<prpCitemKindList.size();j++) 
      {
        PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)prpCitemKindList.get(j);
        if(prpCitemKindDto.getFlag().length()>4 && prpCitemKindDto.getFlag().substring(4,5).equals("1") &&
           arrLossKindCode[i].equals(prpCitemKindDto.getKindCode()))
        {
          strFlag = prpCitemKindDto.getFlag().substring(4,5);
          break;
        }
      }
      if(strFlag.equals("1"))
      { 
        DAACompensateViewHelper dAACompensateViewHelper = new DAACompensateViewHelper();
        dblDeductibleRate = dAACompensateViewHelper.getRate(strClauseTypeCode,arrLossKindCode[i],strIndemnityDuty,strDeductibleTerm,strEscapeFlag,strRiskCode);  //getrate1()?
        if(Double.parseDouble(arrLDeductibleRate[i])!=100)
        {
        dblDeductibleTmp = Double.parseDouble(arrLossRealPay[i])*dblDeductibleRate/100/(1-Double.parseDouble(arrLDeductibleRate[i])/100);
        }
        dblDeductible = dblDeductible+dblDeductibleTmp;
      }   
    }
    
    for(int i=1; i<arrRealpay.length; i++)
    {
      strFlag = ""; 
      for(int j=0;j<prpCitemKindList.size();j++)
      {
        for(int k=1;k<arrKindCode.length;k++)
        {
          PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)prpCitemKindList.get(j);
          if(prpCitemKindDto.getFlag().length()>4 && prpCitemKindDto.getFlag().substring(4,5).equals("1") &&
             arrKindCode[k].equals(prpCitemKindDto.getKindCode()))
          {
            strFlag = prpCitemKindDto.getFlag().substring(4,5);
            break;
          }
        }
      }
      if(strFlag.equals("1"))
      {
  
        DAACompensateViewHelper dAACompensateViewHelper = new DAACompensateViewHelper();
        dblDeductibleRate = dAACompensateViewHelper.getRate(strClauseTypeCode,arrKindCode[i],strIndemnityDuty,strDeductibleTerm,strEscapeFlag,strRiskCode);
        dblPDeductibleRate = Double.parseDouble(arrPDeductibleRate[i])/100;
  
        if(dblPDeductibleRate!=100)
        {
        dblDeductibleTmp = Double.parseDouble(arrRealpay[i])*dblDeductibleRate/100/(1-dblPDeductibleRate);
        }
        dblDeductible = dblDeductible+dblDeductibleTmp;
      }
    }
    out.println("window.status='';");
  }
  catch(Exception e)  
  {
    e.printStackTrace();
    out.println("window.status='刷新不计免赔失败';");
  }

%>
  var tempFrame = parent.document.frames("fraInterface");
  tempFrame.fm.target="interface";
  if(tempFrame.fm.prpLlossDtoKindCode[<%= Index %>].value == "M")  
  {
    var prpLcompensateSumDutyPaid = parseFloat(tempFrame.fm.prpLcompensateSumDutyPaid.value) - parseFloat(tempFrame.fm.prpLlossDtoSumRealPay[<%= Index %>].value);
    var prpLcompensateSumPaid     = parseFloat(tempFrame.fm.prpLcompensateSumPaid.value) - parseFloat(tempFrame.fm.prpLlossDtoSumRealPay[<%= Index %>].value);
    var prpLcompensateSumThisPaid = parseFloat(tempFrame.fm.prpLcompensateSumThisPaid.value) - parseFloat(tempFrame.fm.prpLlossDtoSumRealPay[<%= Index %>].value);
    tempFrame.fm.prpLlossDtoSumRealPay[<%= Index %>].value  = "<%=dblDeductible%>"; 
    tempFrame.fm.prpLcompensateSumDutyPaid.value  = parseFloat(prpLcompensateSumDutyPaid) + parseFloat(tempFrame.fm.prpLlossDtoSumRealPay[<%= Index %>].value);  
    tempFrame.fm.prpLcompensateSumPaid.value      = parseFloat(prpLcompensateSumPaid) + parseFloat(tempFrame.fm.prpLlossDtoSumRealPay[<%= Index %>].value);  
    tempFrame.fm.prpLcompensateSumThisPaid.value  = parseFloat(prpLcompensateSumThisPaid) + parseFloat(tempFrame.fm.prpLlossDtoSumRealPay[<%= Index %>].value);  
    <%
      System.out.println("---刷新不计免赔的画面---dblDeductible----"+dblDeductible);
    %>
  } 
  
</script>
