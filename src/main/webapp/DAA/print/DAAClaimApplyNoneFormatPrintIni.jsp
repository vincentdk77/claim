<%--
****************************************************************************
* DESC       ：机动车辆保险索赔申请书打印初始化
* AUTHOR     ：caopeng
* CREATEDATE ：2005-12-06
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
<%@page import="java.util.Iterator"%>

<%
  //变量声明部分
  String strClaimNo         = "";   //立案号
  String strRegistNo        = "";   //报案号
  String strPolicyNo        = "";   //保单号

  //本车车辆信息
  String strInsuredName	    ="";
  String strDamageAddress   ="";
  String strdamageStartDate	="";
  String strdamageStartHour     ="";
  String strdamageStartMinute   ="";

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
  String strD1="";                     //驾驶员姓名
  String strD2="";                     //驾驶证号码
  String strD3="";                     //驾驶年龄

  String strUseNatureCode         = "" ;//使用性质代码
  String strUseNatureName         = "" ;//使用性质
  String strCheckSite             = "" ;//查勘地点
  String strDamageCode            = "" ;//出险原因代码
  String strDamageClause          = "" ;//出险原因
  String strDamageTypeCode        = "" ;//事故类型代码
  String strDamageTypeName        = "" ;//事故类型说明
  String strRunAreaCode           = "" ;//行驶区域代码
  String strRunAreaName           = "" ;//行驶区域
  String strSexCode               = "" ;//驾驶员性别代码
  String strSexName               = "" ;//驾驶员性别名称


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
  strPolicyNo = prpLregistDto.getPolicyNo();

  strRegistNo = request.getParameter("RegistNo");



  //代码转换
  UICodeAction uiCodeAction = new UICodeAction();
  
  
  //查勘信息
  UICheckAction uiCheckAction = new UICheckAction();
  CheckDto checkDto = uiCheckAction.findByPrimaryKey(strRegistNo);
  PrpLcheckDto prpLcheckDto = checkDto.getPrpLcheckDto();
  if(checkDto.getPrpLcheckDto()!=null)
  {
    strCheckSite    = prpLcheckDto.getCheckSite();
    System.out.println("checkpoint"+strCheckSite);

    strDamageAddress = strCheckSite;
    strPolicyNo = prpLcheckDto.getPolicyNo();

    strDamageCode   = prpLcheckDto.getDamageCode();
    strDamageClause = uiCodeAction.translateCodeCode("DamageCode",strDamageCode,true);
    strDamageTypeCode = prpLcheckDto.getDamageTypeCode();
    strDamageTypeName = uiCodeAction.translateCodeCode("DamageTypeCode",strDamageTypeCode,true);
  }
  //获得保单信息
  UIPolicyAction uiPolicyAction = new UIPolicyAction();
  PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
  PrpCitemCarDto prpCitemCarDto = new PrpCitemCarDto();

  //*****机动车险标的信息表PrpCitemCar*****
  int intItemCarCount = 0 ;//标的子险信息记录数
  intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  System.out.println("共有"+intItemCarCount+"条标的子险信息");
  if(policyDto.getPrpCitemCarDtoList()!=null){
  for(index=0;index<intItemCarCount;index++)
  {
    prpCitemCarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
    strUseNatureCode = prpCitemCarDto.getUseNatureCode();
    strUseNatureName = uiCodeAction.translateCodeCode("UseNature",strUseNatureCode,true);
    strRunAreaCode   = prpCitemCarDto.getRunAreaCode();
    strRunAreaName   = uiCodeAction.translateCodeCode("RunArea",strRunAreaCode,true);
  }
}
  //*****机动车驾驶员关系表
  int intCarDriver  = 0 ;
  intCarDriver     = policyDto.getPrpCcarDriverDtoList().size();

  System.out.println("共有"+intCarDriver+"条驾驶员信息");
  PrpCcarDriverDto prpCcarDriverDto = new PrpCcarDriverDto();
  if(policyDto.getPrpCcarDriverDtoList()!=null){
  for(index=0;index<intCarDriver;index++)
  {
    prpCcarDriverDto = (PrpCcarDriverDto)policyDto.getPrpCcarDriverDtoList().get(index);
    strD1            = prpCcarDriverDto.getDriverName();
    strD2            = prpCcarDriverDto.getDrivingLicenseNo();
    strD3            = String.valueOf(prpCcarDriverDto.getAge());
    strSexCode       = prpCcarDriverDto.getSex();
    strSexName       = uiCodeAction.translateCodeCode("SexCode",strSexCode,true);
  }
}
  prpLregistDto = registDto.getPrpLregistDto();
  strInsuredName =  prpLregistDto.getInsuredName();
  strDamageAddress = prpLregistDto.getDamageAddress();

  strdamageStartDate	=String.valueOf(prpLregistDto.getDamageStartDate());
  strdamageStartHour     =String.valueOf(prpLregistDto.getDamageStartHour());
  strdamageStartMinute   =String.valueOf(prpLregistDto.getDamageStartMinute());
 
    
	PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
	String tempContext = "";
	if (checkDto.getPrpLregistTextDtoList() != null) {
	        Iterator iterator = checkDto.getPrpLregistTextDtoList().iterator();
	        while (iterator.hasNext()) {
	                PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator.next();
	                tempContext = tempContext + prpLregistTextDtoTemp.getContext();
	        }
	}


/*
    UIPolicyAction   uiPolicyAction = new UIPolicyAction();

    PolicyDto   policyDto = new PolicyDto();
    PrpCitemCarDto prpCitemCarDto= new PrpCitemCarDto();
    ArrayList prpCitemCarDtoList  = new ArrayList();
    policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
    prpCitemCarDtoList = policyDto.getprpCitemCarDtoList();
    Iterator ititemkind = prpCitemCarDtoList.iterator();
     while(ititemkind.hasNext())
     {
          PrpCitemCarDto prpCitemCarDto = (PrpCitemCarDto)ititemkind.next();
          if(prpCitemCarDto.getItemNo()==1)
          {
                break;
          }
     }
*/


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