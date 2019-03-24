<%--
****************************************************************************
* DESC       ：机动车辆保险结案催告、注销通知书打印初始化
* AUTHOR     ：zhulianyu
* CREATEDATE ：2005-11-14
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- 引入bean类部分 --%>
<%@page import="java.text.*"%> 
<%@ page import="java.util.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 
<%@page import="com.sinosoft.prpall.blsvr.lp.BLPrpLclaimLoss"%>
<%@page import="com.sinosoft.prpall.schema.PrpLclaimLossSchema"%>
<%@page import="com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade"%>

<%
  //变量声明部分
  String strClaimNo         = request.getParameter("ClaimNo"); //立案号
  String strRegistNo        = "";   //报案号
  String strInsuredDate     = "";   //保险期间
  String strDamageStartDate = "";   //出险时间
  Double sumAmount          = 0.0;  // 报损金额 
  String strCancelReason    = "";
  String strTextType        = "";
  String strDamageProcess   = "";  // 出险经过
  String strComCode    = "";
  String comCName      = "";  //保险公司中文名称
  String addressCName  = "";  //保险公司地址
  String postCode      = "";  //保险公司邮编
  String phoneNumber   = "";  //保险公司电话
  String comCName2      = "";  //保险公司中文名称
  String addressCName2  = "";  //保险公司地址
  String postCode2      = "";  //保险公司邮编
  String phoneNumber2   = "";  //保险公司电话

  //代码翻译变量
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //中文标志 
    
  //对象定义部分                                             
  PrpDcompanyDto     prpDcompanyDto     = null;   //打印此通知书user所在的公司                                          
  PrpLregistDto      prpLregistDto      = null;   //RegistDto对象
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto对象
 
  int index = 0;
  //得到ClaimDto,RegistDto,CertainLossDto,PolicyDto对象
  ClaimDto claimDto   = (ClaimDto)request.getAttribute("claimDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  UICodeAction uiCodeAction = new UICodeAction();
  
  //得到prpLclaimDto对象
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  
  // 得到公司信息
  strComCode = prpLclaimDto.getComCode();  // 业务归属部门
  UICompanyAction    uiCompanyAction    = new UICompanyAction();   
  prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strComCode);  
  if(prpDcompanyDto!=null) 
  {
  	comCName        = prpDcompanyDto.getComCName();      //保险公司中文名称
  	addressCName    = prpDcompanyDto.getAddressCName();  //保险公司地址
  	postCode        = prpDcompanyDto.getPostCode();      //保险公司邮编
  	phoneNumber     = prpDcompanyDto.getPhoneNumber();   //保险公司电话
  	comCName2        = prpDcompanyDto.getComCName();      //保险公司中文名称
  	addressCName2    = prpDcompanyDto.getAddressCName();  //保险公司地址
  	postCode2        = prpDcompanyDto.getPostCode();      //保险公司邮编
  	phoneNumber2     = prpDcompanyDto.getPhoneNumber();   //保险公司电话
  }
  
  //得到prpLregistDto对象
  prpLregistDto    = registDto.getPrpLregistDto();
  strRegistNo      = prpLregistDto.getRegistNo();
  
  //获得出险经过,从报案信息表里取,即报案页面上的出现摘要
  PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
  if(registDto.getPrpLregistTextDtoList()!=null){
    for(index=0;index<registDto.getPrpLregistTextDtoList().size();index++)
    {
    	prpLregistTextDto = (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(index);
        strTextType = prpLregistTextDto.getTextType(); 
        if ( strTextType.equals("1"))  // 出现摘要
        {      
        	strDamageProcess = strDamageProcess + StringConvert.encode(prpLregistTextDto.getContext()) ;
        }
    }    
  }
  
  // 获得拒赔理由,从立案信息表取
  PrpLltextDto prpLltextDto = new PrpLltextDto();
  if(claimDto.getPrpLltextDtoList()!=null){
    for(index=0;index<claimDto.getPrpLltextDtoList().size();index++)
    {
      prpLltextDto = (PrpLltextDto)claimDto.getPrpLltextDtoList().get(index);
      strTextType = prpLltextDto.getTextType();
      // 拒赔理由
      if ( strTextType.equals("10"))
      {      
        strCancelReason = strCancelReason + StringConvert.encode(prpLltextDto.getContext()) ;
      }
    }    
  }
  
  //取报损金额
  sumAmount = prpLregistDto.getEstimateLoss();
%>

<script language="javascript">
  function loadForm()
  { 
    tdPolicyNo.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getPolicyNo())%>';
    tdPolicyNo2.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getPolicyNo())%>';
    tdRegistNo.innerHTML = '<%=strRegistNo%>';
    tdRegistNo2.innerHTML = '<%=strRegistNo%>';
    tdInsuredName.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    tdInsuredName2.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    tdDamageCause.innerHTML ='<%=StringConvert.encode(prpLregistDto.getDamageName())%>';
    tdDamageCause2.innerHTML ='<%=StringConvert.encode(prpLregistDto.getDamageName())%>';
    tdCancelReason.innerHTML = '拒赔（注销）理由: </br>&nbsp;&nbsp;&nbsp;&nbsp;' + '<%=strCancelReason%>';
    tdCancelReason2.innerHTML = '拒赔（注销）理由: </br>&nbsp;&nbsp;&nbsp;&nbsp;' + '<%=strCancelReason%>';
    tdDamageProcess.innerHTML = '出险经过: </br>&nbsp;&nbsp;&nbsp;&nbsp;' + '<%=strDamageProcess%>';
    tdDamageProcess2.innerHTML = '出险经过: </br>&nbsp;&nbsp;&nbsp;&nbsp;' + '<%=strDamageProcess%>';
<%     
   if((prpLclaimDto.getStartDate()+"").length()>0)
   strInsuredDate = "自 " + prpLclaimDto.getStartDate().getYear()
                     + " 年 " + prpLclaimDto.getStartDate().getMonth()
                     + " 月 " + prpLclaimDto.getStartDate().getDate()
                     + " 日 " + prpLclaimDto.getEndHour()
                     + " 时起";
   if((prpLclaimDto.getEndDate()+"").length()>0)

      strInsuredDate =  strInsuredDate  + "</br>至 " + prpLclaimDto.getEndDate().getYear()
                     + " 年 " + prpLclaimDto.getEndDate().getMonth()
                     + " 月 " + prpLclaimDto.getEndDate().getDate()
                     + " 日 " + prpLclaimDto.getEndHour()
                     + " 时止";
%>                    
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    tdInsuredDate2.innerHTML = '<%=strInsuredDate%>';
<%
    //出险险种
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getRiskCode());
    strName = uiCodeAction.translateRiskCode(strCode,isChinese);
%>  
    tdTitleName.innerHTML='<%=strName%>'+'拒赔（注销）案件通知书';
    tdTitleName2.innerHTML='<%=strName%>'+'拒赔（注销）案件通知书';
    
<%  // 出险时间  
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " 年 " + prpLclaimDto.getDamageStartDate().getMonth()
                        + " 月 " + prpLclaimDto.getDamageStartDate().getDate()
                        + " 日 " + prpLclaimDto.getDamageStartHour().substring(0,2)+" 时";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
    tdDamageStartDate2.innerHTML = '<%=strDamageStartDate%>';
    tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    tdDamageAddress2.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    
    // 报损金额
    tdSumAmount.innerHTML = '<%=new DecimalFormat("#,##0.00").format(sumAmount)%>' + ' 元';
    tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(sumAmount)%>' + ' 元';
   
  }
</script>
 