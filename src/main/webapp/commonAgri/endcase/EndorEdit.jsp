<%--
****************************************************************************
* DESC       ：农险冲减保额主画面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-26
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.PrpLlossDto"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sinosoft.utility.SysConfig"%>
<%@ page import="com.sinosoft.claim.dto.domain.PrpLlossDto"%>
<%@ page import="com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade"%>
<%@ page import="com.sinosoft.claim.dto.domain.PrpCitemKindDto"%>
<%@ page import="java.util.List"%>

<%
   String claimNo = (String)request.getAttribute("claimNo");
   PrpLlossDto prpLlossDto = (PrpLlossDto)request.getAttribute("prpLlossDto");
   Map numberListBaseOnHerdSettleList = (Map)request.getAttribute("numberListBaseOnHerdSettleList");
   String planting31FarmerListFlag = SysConfig.getProperty("PLNATING_31_FARMER_LIST_FLAG");
   String strHerdRiskCodes = SysConfig.getProperty("FamilySplittingFlag","claim");
   String riskCode = prpLlossDto.getRiskCode();
   String policyNo = prpLlossDto.getPolicyNo();
   double SettleArea=0;
%>


<html:html locale="true">
<head>
  <title>冲减保额</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/endcase/js/DAAEndcaseEdit.js"></script>
  <script language='javascript'>
    /**
     @author      liubvo
     @description 校验窗体方法
     @param       无
     @return      boolean,合法返回true,不合法返回false
    */
    function checkForm()
    {
      if(isEmpty(fm.ClaimNo))
      {
        fm.ClaimNo.focus();
        errorMessage("立案号不能为空!");
        return false;
      }
      else if(trim(fm.ClaimNo.value).length!=22)
      {
        fm.ClaimNo.focus();
        errorMessage("立案号应为22位长!");
        return false;
      }

      if(!isEmpty(fm.CompensateNo))
      {
        if(trim(fm.CompensateNo.value).length!=22)
        {
          fm.CompensateNo.focus();
          errorMessage("赔款计算书号应为22位长!");
          return false;
        }
      }

      return true;
    }

    /**
     @author      liubvo
     @description 提交窗体方法
     @param       无
     @return      无
     @see         checkForm
    */
    function submitForm()
    {
    /*
      if(checkForm()==true)
      {
        fm.submit();
      }
      */
        fm.buttonSave.disabled = true;
        fm.submit();

     }

    function resetForm()
    {
      fm.reset();
    }
    //提示客户正常情况下输入负值冲减保额，但是也可以出负的计算机输入正值来冲减保额  国元项目组 韦吉亮
    function check(field)
    {
  
       var index = getElementOrder(field)-1;
       var count=getElementCount("EndorGrossQuantity");
       var quantity=0;
       if(count==1){
          quantity = parseFloat(fm.EndorGrossQuantity.value);
       }else{
          quantity = parseFloat(fm.EndorGrossQuantity[index].value);
       } 
      if(quantity>0){
          alert("请输入负数！");
          return false;
       }
    }
  </script>
</head>

<body  class="interface" onload="initPage();">

<%-- 调用loadForm 初始化页面 --%>
<body class="interface" onload="initPage();">
  <form name=fm action="/claim/endor.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

    <table class="common" cellpadding="5" cellspacing="1">
      <tr>
        <td class=formtitle colspan="4">冲减保额登记
        </td>
      </tr>
      <tr>
        <td class="title">立案号：</td>
        <td class="input">
          <input type='hidden' name='RiskCode' value="<bean:write name='prpLlossDto' property='riskCode' />">
          <input name="ClaimNo" class="readonly" readonly value="<%= claimNo%>">
        </td>
        <td class="title">保单号：</td>
        <td class="input">
          <input name="PolicyNo" class="readonly" readonly value="<bean:write name='prpLlossDto' property='policyNo' />">
        </td>
      </tr>
    </table>

    <table class="common" align=center>
      <%--冲减保额登记清单--%>
      <tr class=mline>
        <td class="common" colspan="4" style="text-align:left">
          <table class="common" cellpadding="5" cellspacing="1">
            <tr>
              <td class="subformtitle">冲减保额信息
              </td>
            </tr>
          </table>

          <span id="spanEndorAll" >
            <table class=common cellpadding="5" cellspacing="1" id="Endor">
              <thead>
                <tr>
                  <td class="centertitle" style="width:20%">赔款计算书号</td>
                  <td class="centertitle" style="width:10%">分户名称</td>
                  <td class="centertitle" style="width:10%">标的项目类别</td>
                  <td class="centertitle" style="width:15%">标的项目名称</td>
                  <td class="centertitle" style="width:15%">险别名称</td>
                  <td class="centertitle" style="width:10%">币别</td>
                  <%if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3179,3158,3178,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1)){%>
                  <td class="centertitle" style="width:10%">损失率</td>
                  <%}%>
                  <%if(planting31FarmerListFlag.indexOf(riskCode) > -1){%>
                  <td class="centertitle" style="width:10%">损失率</td>
                  <%}%>   
                  <td class="centertitle" style="width:10%">冲减保额</td>
                  <td class="centertitle" style="width:10%">冲减单位数量</td>
                </tr>
              </thead>
              <tfoot>
              </tfoot>
              <tbody>
        <%
        //Added by GYIC LiYang, 2011-09-21 为需要清单的养殖险自动带出冲减数量和金额，并且不可修改。原有逻辑不变。
        if(null!=strHerdRiskCodes && null!=riskCode && strHerdRiskCodes.indexOf(riskCode)>-1){
          Collection prpLlossList = prpLlossDto.getPrpLlossList();
          if(null!=prpLlossList && prpLlossList.size()>0){
            Iterator iterator = prpLlossList.iterator();
            while(iterator.hasNext()){
              PrpLlossDto prpLlossDtoTemp = (PrpLlossDto)iterator.next();
              %>
              <tr class=common>
                  <td>
                    <input name=CompensateNo class="readonly" readonly style='width:160px' value="<%=prpLlossDtoTemp.getCompensateNo()%>">
                  </td>
                  <td>
                    <input name=familyName class="readonly" readonly style='width:40px' value="<%=prpLlossDtoTemp.getFamilyName()%>">
                  </td>
                  <td>
                    <input name="ItemCode" class="readonly" readonly style="width:40px" value="<%=prpLlossDtoTemp.getItemCode()%>">
                  </td>
                  <td>
                    <input name="ItemName" class="readonly" readonly style="width:110px" value="<%=prpLlossDtoTemp.getLossName()%>">
                  </td>
                  <td>
                    <input type='hidden' name="ItemKindNo" value="<%=prpLlossDtoTemp.getItemKindNo()%>">
                    <input type='hidden' name="KindCode" value="<%=prpLlossDtoTemp.getKindCode()%>">
                    <input type="input" name=KindName class="readonly" readonly style='width:105px' value="<%=prpLlossDtoTemp.getKindName()%>">
                  </td>
                  <td>
                    <input type='hidden' name="Currency" value="<%=prpLlossDtoTemp.getCurrency()%>">
                    <input name="CurrencyName" class="readonly" readonly style="width:40px" value="<%=prpLlossDtoTemp.getCurrencyName()%>">
                  </td>
                  <td>
                    <input class="input" class="readonly" readonly  name="EndorAmount"   style="width:70px" value="-<%=prpLlossDtoTemp.getSumRealPay()%>">
                  </td>
                  <%
                    String keyInMap = prpLlossDtoTemp.getCompensateNo()+"_"+prpLlossDtoTemp.getRiskCode()+"_"+prpLlossDtoTemp.getKindCode();
                    int reduceNumber = 0;
                    if(null!=numberListBaseOnHerdSettleList.get(keyInMap))
                      reduceNumber = Integer.parseInt(String.valueOf(numberListBaseOnHerdSettleList.get(keyInMap)));
                   %>
                  <td>
                    <input class="input" class="readonly" readonly name="EndorGrossQuantity" value="<%=reduceNumber%>" style="width:60px">
                    <input type="hidden" name="EndorType" value="14">
                  </td>
                </tr>
            <%  
            }
          }
        }
        else if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176".indexOf(riskCode) > -1)){
          Collection prpLlossList = prpLlossDto.getPrpLlossList();
          if(null!=prpLlossList && prpLlossList.size()>0){
            Iterator iterator = prpLlossList.iterator();
            while(iterator.hasNext()){
              PrpLlossDto prpLlossDtoTemp = (PrpLlossDto)iterator.next();
              %>
              <tr class=common>
                  <td>
                    <input name=CompensateNo class="readonly" readonly style='width:160px' value="<%=prpLlossDtoTemp.getCompensateNo()%>">
                  </td>
                  <td>
                    <input name=familyName class="readonly" readonly style='width:40px' value="<%=prpLlossDtoTemp.getFamilyName()%>">
                  </td>
                  <td>
                    <input name="ItemCode" class="readonly" readonly style="width:40px" value="<%=prpLlossDtoTemp.getItemCode()%>">
                  </td>
                  <td>
                    <input name="ItemName" class="readonly" readonly style="width:110px" value="<%=prpLlossDtoTemp.getLossName()%>">
                  </td>
                  <td>
                    <input type='hidden' name="ItemKindNo" value="<%=prpLlossDtoTemp.getItemKindNo()%>">
                    <input type='hidden' name="KindCode" value="<%=prpLlossDtoTemp.getKindCode()%>">
                    <input type="input" name=KindName class="readonly" readonly style='width:105px' value="<%=prpLlossDtoTemp.getKindName()%>">
                  </td>
                  <td>
                    <input type='hidden' name="Currency" value="<%=prpLlossDtoTemp.getCurrency()%>">
                    <input name="CurrencyName" class="readonly" readonly style="width:40px" value="<%=prpLlossDtoTemp.getCurrencyName()%>">
                  </td>
                  <td>
                    <input name="lossRate" class="readonly" readonly style="width:40px" value="<%=prpLlossDtoTemp.getIndemnityDutyRate()%>">
                  </td>
                  <td>
                    <input class="readonly" readonly  name="EndorAmount"   style="width:70px" value="<%=-prpLlossDtoTemp.getSumRealPay()%>">
                  </td>
                  <%
                  double lossRate=prpLlossDtoTemp.getLossrate();
                  if(lossRate>=80){
                    SettleArea=prpLlossDtoTemp.getSettleArea();
                  }else{
                	  SettleArea=0;
                  }
                  // 3177不冲减面积
                  if(prpLlossDtoTemp.getRiskCode().equals("3177")) {
                	  SettleArea=0;
                  }
                  %>
                  <td>
                    <input  class="readonly" readonly name="EndorGrossQuantity" value="<%=-SettleArea%>" style="width:60px">
                    <input type="hidden" name="EndorType" value="14">
                  </td>
                </tr>
            <%  
            }
        }
        //yx
        //}else if("3224".equals(riskCode)){
        }else if("3224,3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode)>-1){
            Collection prpLlossList = prpLlossDto.getPrpLlossList();
            if(null!=prpLlossList && prpLlossList.size()>0){
            	BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
                List listCitemKind = (List)blPrpCitemKindFacade.findByConditions(" policyNo = '"+policyNo+"'");
              Iterator iterator = prpLlossList.iterator();
              //Iterator iterator1 = prpLlossList.iterator();
              boolean hasMain = false;
              double totalPay = 0.0;
              //while(iterator1.hasNext()){
            //	  PrpLlossDto prpLlossDtoTemp1 = (PrpLlossDto)iterator1.next();
            	//  totalPay += prpLlossDtoTemp1.getSumRealPay();
            //	  String kindcode = prpLlossDtoTemp1.getKindCode();
            	//  if("001".equals(kindcode))
            //	  {
            //		  hasMain = true;
            //	  }
            	  
            //  }
              
             // if(!hasMain)
             // {
            	  
            	  
            //  }
              
              
              while(iterator.hasNext()){
                PrpLlossDto prpLlossDtoTemp = (PrpLlossDto)iterator.next();
                %>
                <tr class=common>
                    <td>
                      <input name=CompensateNo class="readonly" readonly style='width:160px' value="<%=prpLlossDtoTemp.getCompensateNo()%>">
                    </td>
                    <td>
                      <input name=familyName class="readonly" readonly style='width:40px' value="<%=prpLlossDtoTemp.getFamilyName()%>">
                    </td>
                    <td>
                      <input name="ItemCode" class="readonly" readonly style="width:40px" value="<%=prpLlossDtoTemp.getItemCode()%>">
                    </td>
                    <td>
                      <input name="ItemName" class="readonly" readonly style="width:110px" value="<%=prpLlossDtoTemp.getLossName()%>">
                    </td>
                    <td>
                      <input type='hidden' name="ItemKindNo" value="<%=prpLlossDtoTemp.getItemKindNo()%>">
                      <input type='hidden' name="KindCode" value="<%=prpLlossDtoTemp.getKindCode()%>">
                      <input type="input" name=KindName class="readonly" readonly style='width:105px' value="<%=prpLlossDtoTemp.getKindName()%>">
                    </td>
                    <td>
                      <input type='hidden' name="Currency" value="<%=prpLlossDtoTemp.getCurrency()%>">
                      <input name="CurrencyName" class="readonly" readonly style="width:40px" value="<%=prpLlossDtoTemp.getCurrencyName()%>">
                    </td>
                    <td>
                      <input name="lossRate" class="readonly" readonly style="width:40px" value="<%=prpLlossDtoTemp.getIndemnityDutyRate()%>">
                    </td>
                    <td>
                      <input class="readonly" readonly  name="EndorAmount"   style="width:70px" value="<%=-prpLlossDtoTemp.getSumRealPay()%>">
                    </td>
                    <%
                    
                    double lossRate=prpLlossDtoTemp.getLossrate();
                    if(lossRate>=100){
                      SettleArea=prpLlossDtoTemp.getSettleArea();
                    }else{
                  	  SettleArea=0;
                    }
                    %>
                    <td>
                      <input  class="readonly" readonly name="EndorGrossQuantity" value="<%=-SettleArea%>" style="width:60px">
                      <input type="hidden" name="EndorType" value="14">
                    </td>
                  </tr>
              <%  
              }}
          
          }else if(planting31FarmerListFlag.indexOf(riskCode) > -1){
          Collection prpLlossList = prpLlossDto.getPrpLlossList();
          if(null!=prpLlossList && prpLlossList.size()>0){
            BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
            List listCitemKind = (List)blPrpCitemKindFacade.findByConditions(" policyNo = '"+policyNo+"'");
            Iterator iterator = prpLlossList.iterator();
            while(iterator.hasNext()){
              PrpLlossDto prpLlossDtoTemp = (PrpLlossDto)iterator.next();
              %>
              <tr class=common>
                  <td>
                    <input name=CompensateNo class="readonly" readonly style='width:160px' value="<%=prpLlossDtoTemp.getCompensateNo()%>">
                  </td>
                  <td>
                    <input name=familyName class="readonly" readonly style='width:40px' value="<%=prpLlossDtoTemp.getFamilyName()%>">
                  </td>
                  <td>
                    <input name="ItemCode" class="readonly" readonly style="width:40px" value="<%=prpLlossDtoTemp.getItemCode()%>">
                  </td>
                  <td>
                    <input name="ItemName" class="readonly" readonly style="width:110px" value="<%=prpLlossDtoTemp.getLossName()%>">
                  </td>
                  <td>
                    <input type='hidden' name="ItemKindNo" value="<%=prpLlossDtoTemp.getItemKindNo()%>">
                    <input type='hidden' name="KindCode" value="<%=prpLlossDtoTemp.getKindCode()%>">
                    <input type="input" name=KindName class="readonly" readonly style='width:105px' value="<%=prpLlossDtoTemp.getKindName()%>">
                  </td>
                  <td>
                    <input type='hidden' name="Currency" value="<%=prpLlossDtoTemp.getCurrency()%>">
                    <input name="CurrencyName" class="readonly" readonly style="width:40px" value="<%=prpLlossDtoTemp.getCurrencyName()%>">
                  </td>
                  <td>
                    <input name="lossRate" class="readonly" readonly style="width:40px" value="<%=prpLlossDtoTemp.getIndemnityDutyRate()%>">
                  </td>
                  <td>
                    <input class="readonly" readonly  name="EndorAmount"   style="width:70px" value="<%=-prpLlossDtoTemp.getSumRealPay()%>">
                  </td>
                  <%
                  double lossRate=prpLlossDtoTemp.getLossrate();
                  if(listCitemKind != null && listCitemKind.size()>0){
                  		for(int indexCitemKind =0;indexCitemKind<listCitemKind.size() ; indexCitemKind ++){
                  			PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)listCitemKind.get(indexCitemKind);
                  			if(prpCitemKindDto.getItemCode().equals(prpLlossDtoTemp.getItemCode()) && prpCitemKindDto.getKindCode().equals(prpLlossDtoTemp.getKindCode())){
                  				if(lossRate>=prpCitemKindDto.getTotalLossRatio()){
                  					SettleArea=prpLlossDtoTemp.getSettleArea();
                  					break;
                  				}
                  			}else SettleArea=0;
                  		}
                  }else 
                  	SettleArea=0;
                  %>
                  <td>
                    <input  class="readonly" readonly name="EndorGrossQuantity" value="<%=-SettleArea%>" style="width:60px">
                    <input type="hidden" name="EndorType" value="14">
                  </td>
                </tr>
            <%  
            }
        }
        }else{
        %>
    <logic:notEmpty  name="prpLlossDto"  property="prpLlossList">
        <logic:iterate id="lossList" name="prpLlossDto" property="prpLlossList">
        
                <tr class=common>
                  <td>
                    <input name=CompensateNo class="readonly" readonly style='width:160px' value="<bean:write name='lossList' property='compensateNo' />">
                  </td>
                  <td>
                    <input name=familyName class="readonly" readonly style='width:40px' value="<bean:write name='lossList' property='familyName' />">
                  </td>
                  <td>
                    <input name="ItemCode" class="readonly" readonly style="width:40px" value="<bean:write name='lossList' property='itemCode' />">
                  </td>
                  <td>
                    <input name="ItemName" class="readonly" readonly style="width:110px" value="<bean:write name='lossList' property='lossName' />">
                  </td>
                  <td>
                    <input type='hidden' name="ItemKindNo" value="<bean:write name='lossList' property='itemKindNo' />">
                    <input type='hidden' name="KindCode" value="<bean:write name='lossList' property='kindCode' />">
                    <input type="input" name=KindName class="readonly" readonly style='width:105px' value="<bean:write name='lossList' property='kindName' />">
                  </td>
                  <td>
                    <input type='hidden' name="Currency" value="<bean:write name='lossList' property='currency' />">
                    <input name="CurrencyName" class="readonly" readonly style="width:40px" value="<bean:write name='lossList' property='currencyName' />">
                  </td>
                   <td>
                    <input class="input" name="EndorAmount"   style="width:70px" value="-<bean:write name='lossList' property='sumRealPay' />">
                  </td>
                  <td>
                    <input class="input" name="EndorGrossQuantity" value="" style="width:60px" onblur="check(this);">
                    <input type="hidden" name="EndorType" value="14">
                  </td>
                </tr>
        </logic:iterate>
      </logic:notEmpty>
            <%
            }
             %>
              </tbody>
            </table>
          </span>
        </td>
      </tr>
    </table>

  <input type="hidden" name="editType" value="SAVE">
  <table class="common" align="center">
    <tr>
      <td class="button" >
        <input type="button" name="buttonSave" value=" 下一步 " class="button" onclick="submitForm();">
      </td>
      <td class="button" >
        <input type="button" name="buttonCancel" value=" 取 消 " class="button" onclick="resetForm();">
      </td>
    </tr>
  </table>
</form>
</body>
<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
