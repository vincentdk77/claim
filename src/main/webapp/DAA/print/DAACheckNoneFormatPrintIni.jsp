<%--
****************************************************************************
* DESC       ：机动车现场查勘记录打印初始化
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-16
* MODIFYLIST ：   Name       Date            Reason/Contents
--------------------------------------------------------------------------
*                 lirj     20040317        费用分开，按车牌号码打印 
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
  String strClaimNo         = "";   //立案号
  String strRegistNo        = "";   //报案号
  String strPolicyNo        = "";   //保单号
  
  //本车车辆信息
  String strBrandName       = "";   //厂牌型号
  String strEngineNo        = "";   //发动机号
  double strRunDistance     = 0.0d;   //车辆已行驶公里数
  int    strUseYears        = 0;   //车辆实际使用年限
  String strLicenseNo       = "";   //车牌号
  String strFrameNo         = "";   //车架号
  
  //第三方车辆信息
  String strBrandNamethird        = "";   //厂牌型号
  String strEngineNothird         = "";   //发动机号
  double strRunDistancethird      = 0.0d;   //车辆已行驶公里数
  int    strUseYearsthird         = 0;   //车辆实际使用年限
  String strLicenseNothird        = "";   //车牌号
  String strFrameNothird          = "";   //车架号
System.out.println("-------------0---------------");
  
  //代码翻译变量

  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //中文标志
  
  //对象定义部分
 

  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto对象
  PrpLregistDto prpLregistDto = new PrpLregistDto();
  
  int intThirdPartyCount = 0;   //ThirdPartyDto对象的记录数

  
    
  int index = 0; 

  RegistDto registDto = new RegistDto();
  registDto=(RegistDto)request.getAttribute("registDto");

  prpLregistDto = registDto.getPrpLregistDto();
  strPolicyNo = prpLregistDto.getPolicyNo();
  strRegistNo = prpLregistDto.getRegistNo();
  for(index=0;index<registDto.getPrpLthirdPartyDtoList().size();index++)
  {
     prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(index);
     if(index==0)
        strClaimNo =  prpLthirdPartyDto.getClaimNo();
     //取得保险车辆信息
     if(prpLthirdPartyDto.getInsureCarFlag().equals("1"))
     {
         strBrandName    = prpLthirdPartyDto.getBrandName();
         strEngineNo     = prpLthirdPartyDto.getEngineNo();
         strRunDistance  = prpLthirdPartyDto.getRunDistance();
         strUseYears     = prpLthirdPartyDto.getUseYears();
         strLicenseNo    = prpLthirdPartyDto.getLicenseNo();
         strFrameNo      = prpLthirdPartyDto.getFrameNo();
     }
     else
     {
         strBrandNamethird     = prpLthirdPartyDto.getBrandName();
         strEngineNothird      = prpLthirdPartyDto.getEngineNo();
         strRunDistancethird   = prpLthirdPartyDto.getRunDistance();
         strUseYearsthird      = prpLthirdPartyDto.getUseYears();
         strLicenseNothird     = prpLthirdPartyDto.getLicenseNo();
         strFrameNothird       = prpLthirdPartyDto.getFrameNo();
     }
     
  }

 %>
  
  
  
  
  

   
  