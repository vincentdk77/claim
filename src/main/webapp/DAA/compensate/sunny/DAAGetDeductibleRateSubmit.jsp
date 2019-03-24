<%--
****************************************************************************
* DESC       ： 获得免赔率
* AUTHOR     ：liubvo
* CREATEDATE ： 2005-03-02
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>                                   

<%-- 引入bean类部分 --%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="java.util.*"%>

 
<script> 
<%                           
  String modeCode = "";
  double dblDeductibleRate = 0;
  double dblDutyDeductibleRate = 0;
  double dblMainKindDeductibleRate = 0;
  //增加驾驶员免赔率
  double dblDriverDeductibleRate = 0;
  String mainKind = "";
  ArrayList prpCitemKindDtoList = new ArrayList();
  PolicyDto policyDto = new PolicyDto();
  
  String strType           = request.getParameter("Type");  
  String strClauseTypeCode = request.getParameter("prpLcompensateClauseTypeCode");
  String strKindCode       = request.getParameter("KindCode");  
  String strIndemnityDuty  = request.getParameter("prpLcompensateIndemnityDuty");
  String strIndemnityDutyRate = request.getParameter("prpLcompensateIndemnityDutyRate");
  String strDeductibleTerm = request.getParameter("prpLcompensateDeductCond");
  String strEscapeFlag     = request.getParameter("prpLcompensateEscapeFlag");
  String strRiskCode       = request.getParameter("prpLcompensateRiskCode"); 
  String index       = request.getParameter("Index"); 
  String strPolicyNo       = request.getParameter("prpLcompensatePolicyNo");
  String amount            = "";
  try
  {
    UIPolicyAction   uiPolicyAction = new UIPolicyAction();
    
    policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
    prpCitemKindDtoList = policyDto.getPrpCitemKindDtoList();
    Iterator ititemkind = prpCitemKindDtoList.iterator();
     while(ititemkind.hasNext())
     {
          PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)ititemkind.next();
          if(prpCitemKindDto.getKindCode().equals(strKindCode)) 
          {
              
                modeCode = prpCitemKindDto.getModeCode();
                amount   = String.valueOf(prpCitemKindDto.getAmount());
                break; 
          }     
     }
   
    //SunnyCompensateViewHelper sunnyCompensateViewHelper = new SunnyCompensateViewHelper();
    //dblDutyDeductibleRate = sunnyCompensateViewHelper.getDeductibleRateOfAccident(strClauseTypeCode,strKindCode,strIndemnityDuty,strDeductibleTerm,strEscapeFlag,strRiskCode,modeCode);
    dblDutyDeductibleRate = UIDeductCondAction.getInstance().getDeductibleRateOfAccident(strRiskCode,strKindCode,strIndemnityDuty,modeCode,policyDto.getPrpCmainDto().getOperateDate().toString());
    
    //dblDeductibleRate = sunnyCompensateViewHelper.getDeductibleRateOfAbsolute(strClauseTypeCode,strKindCode,strDeductibleTerm,strRiskCode);
    
    //dblDeductibleRate = UIDeductCondAction.getInstance().getDeductibleRateOfAbsolute(strClauseTypeCode,strKindCode,strRiskCode,)
    
     //计算附加险所在主险的绝对免赔率
    if(strKindCode.equals("D2")||strKindCode.equals("D3")||strKindCode.equals("D4")||
       strKindCode.equals("Y")||strKindCode.equals("G0")||strKindCode.equals("L")||
       strKindCode.equals("Z")||strKindCode.equals("X")||strKindCode.equals("H"))
    {
        if(strKindCode.equals("D2")||strKindCode.equals("D3")||strKindCode.equals("D4")||strKindCode.equals("Y")||strKindCode.equals("H"))
        {
            mainKind = "B";
        }
        if(strKindCode.equals("G0")||strKindCode.equals("L")||strKindCode.equals("Z")||strKindCode.equals("X"))
        {
            mainKind = "A";
        }
        dblMainKindDeductibleRate = sunnyCompensateViewHelper.getDeductibleRateOfAbsolute(strClauseTypeCode,mainKind,strDeductibleTerm,strRiskCode);
        System.out.println("所在主险的绝对免赔率"+dblMainKindDeductibleRate);
    }   
    //得到驾驶员免赔率
    
    dblDriverDeductibleRate = sunnyCompensateViewHelper.getDeductibleRateOfDriver(strClauseTypeCode,strKindCode,strDeductibleTerm,strRiskCode);
    
  } 
  catch(Exception e)
  {
    e.printStackTrace();
    out.println("window.status='没有查询到对应的免赔率';");
  }

%>
  var tempFrame = parent.document.frames("fraInterface");
  tempFrame.fm.target="interface";
<%  
  if(strType.equals("lLoss")) //赔付标的
  { 
%>
    tempFrame.fm.all("prpLlossDtoDeductibleRate")[<%= index %>].value  = "<%=dblDeductibleRate%>";
    tempFrame.fm.all("prpLlossDtoDeductibleRate")[<%= index %>].oldValue  = "<%=dblDeductibleRate%>";
    tempFrame.calRealpay(tempFrame.fm.all("prpLlossDtoDeductibleRate")[<%= index %>]);  
<%                                                                      
  }
  else
  {
%>    
    tempFrame.fm.all("prpLpersonLossIndemnityDutyRate")[<%= index %>].value  = "<%=strIndemnityDutyRate%>";
    tempFrame.fm.all("prpLpersonLossDeductibleRate")[<%= index %>].value  = "<%=dblDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossDutyDeductibleRate")[<%= index %>].value  = "<%=dblDutyDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossDriverDeductibleRate")[<%= index %>].value  = "<%=dblDriverDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossMainKindDeductibleRate")[<%= index %>].value  = "<%=dblMainKindDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossDeductibleRate")[<%= index %>].oldValue  = "<%=dblDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossDutyDeductibleRate")[<%= index %>].oldvalue  = "<%=dblDutyDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossDriverDeductibleRate")[<%= index %>].oldvalue  = "<%=dblDriverDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossAmountTmp")[<%= index %>].value  = "<%=amount%>";
    tempFrame.calRealpay2ForSunny(tempFrame.fm.all("prpLpersonLossDeductibleRate")[<%= index %>]);
<%      
  }
%>    
  //介绍一下执行顺序：
  //1.改变险别后，首先执行LossKindCode的onchange事件，但查询免赔率的过程很慢，所以还未查出正确的免赔率，就执行了下一步，
  //2.执行LossKindCode的onblur事件,由于UICodeGet.jsp中执行了arrCodeCodeIndex = Str.split("0,"+coderelation,",")——这样又执行了LossKindCode的onchange事件，
  //  同样查询免赔率的过程很慢，所以还未查出正确的免赔率，就执行了下一步，
  //3.执行了UICodeGet.jsp中的codetype.equals("KindCode3")部分，在这里查出的免赔率为0.0，
  //4.由于险别的变动带动了实际价值的变动，执行了实际价值的onchange事件——执行了calRealpay()方法（按免赔率为0.0进行计算），
  //5.现在，免赔率已经由服务查询出来了，并会在本页执行tempFrame.calRealpay()方法（按正确的免赔率进行计算）。
</script> 
