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
<%@ page import="java.util.*"%>

<%-- 引入bean类部分 --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>
<%@page import="com.sinosoft.claim.bl.facade.*"%>
<%@page import="com.sinosoft.utiall.dbsvr.DBPrpDcode"%>

<%
  //变量声明部分
  String strClaimNo         = "";   //立案号
  String strRegistNo        = "";   //报案号
  String strPolicyNo        = "";   //保单号
  String strEndorseNo = "";           //批单号
  UIEndorseAction uiEndorseAction = new UIEndorseAction();

  //保单信息
  DateTime dateStartDate         = null;   //报案日期
  String strStartDate            = "" ;//报案日期
  DateTime dateEndDate         = null;   //报案日期
  String strEndDate            = "" ;//报案日期
  
  //报案信息
  String strInsuredName        = "";   //被保险人
  String strDamageAddress      = "";   //出险地点
  String strDamageStartDate    = "";   //出险时间
  String strReportHour         = "";   //出险小时
  String strReceiverName       = "";   //接 待 人
  String strOperatorCode       = "";   //操作员代码
  String strHandleUnit         = "";   //接待部门
 // String strInsuredName      = "";   //接待部门电话
  //本车车辆信息
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
  String strD3="";                     //驾驶证有效期
  //add begin by zhuly 20051107
  String strUseNatureCode         = "" ;//使用性质代码
  String strUseNatureName         = "" ;//使用性质
  String strCheckSite             = "" ;//查勘地点
  String strCheckDate             = "" ;//查勘时间
  String strChecker1              = "" ;//查勘人
  String strDamageCode            = "" ;//出险原因代码
  String strDamageClause          = "" ;//出险原因
  String strRunAreaCode           = "" ;//行驶区域代码
  String strRunAreaName           = "" ;//行驶区域
  String strSexCode               = "" ;//驾驶员性别代码
  String strSexName               = "" ;//驾驶员性别名称
  double strEstimateLoss          = 0.0 ;//估损金额
  DateTime dateReportDate         = null;   //报案日期
  String strReportDate            = "" ;//报案日期
  String strLinkerName = "";       //联系人
  String strPhoneNumber = "";       //联系方式
  String strLossName = "";       //出险标的
  
  //add end by zhuly 20051107

  //代码翻译变量

  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //中文标志

  //对象定义部分


  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto对象
  PrpLregistDto prpLregistDto = new PrpLregistDto();

  int intThirdPartyCount = 0;   //ThirdPartyDto对象的记录数


 System.out.println("<br>registDto=======================:");

  int index = 0;

  RegistDto registDto = new RegistDto();
  registDto=(RegistDto)request.getAttribute("registDto");
 System.out.println("<br>registDto=======================:"+registDto);
  prpLregistDto    = registDto.getPrpLregistDto();
  strPolicyNo = prpLregistDto.getPolicyNo();
  strRegistNo = prpLregistDto.getRegistNo();

//得到批单号
 PrpPheadDto prpPheadDto = new PrpPheadDto();
	Collection prpPheadDtoList = uiEndorseAction.findByPrpPheadConditions(" policyNo='" + strPolicyNo + "'");
	  if (prpPheadDtoList != null) {
           Iterator iterator = prpPheadDtoList.iterator();
            while (iterator.hasNext()) {
             prpPheadDto = (PrpPheadDto) iterator.next();
			 strEndorseNo = prpPheadDto.getEndorseNo();
			}
	    }

  //add begin by zhuly 20051107 车险标地信息
  //代码转换
  UICodeAction uiCodeAction = new UICodeAction();
  //获得保单信息
  UIPolicyAction uiPolicyAction = new UIPolicyAction();
  PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
  PrpCmainDto prpCmainDto  = policyDto.getPrpCmainDto(); //得到保单主表对象
  PrpCitemCarDto prpCitemCarDto = new PrpCitemCarDto();
  //*****机动车险标的信息表PrpCitemCar*****
  int intItemCarCount = 0 ;//标的子险信息记录数
  intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
 /*
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
*/
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
    strSexCode       = prpCcarDriverDto.getSex();
    strSexName       = uiCodeAction.translateCodeCode("SexCode",strSexCode,true);
  }
}
  //add end by zhuly 20051107
  prpLregistDto = registDto.getPrpLregistDto();
  if(prpLregistDto!=null){
  strInsuredName      = prpLregistDto.getInsuredName();
  strLossName      =  prpLregistDto.getLossName();
  strDamageAddress    = prpLregistDto.getDamageAddress();
  strEstimateLoss = prpLregistDto.getEstimateLoss();

  strDamageStartDate  = prpLregistDto.getDamageStartDate().getYear()
                       + "年" + prpLregistDto.getDamageStartDate().getMonth()
                       + "月" + prpLregistDto.getDamageStartDate().getDate()
                       + "日";
  strReportHour       =  prpLregistDto.getReportHour().toString();
  strReceiverName     = prpLregistDto.getReceiverName();
  strHandleUnit       = prpLregistDto.getHandleUnit();
  strOperatorCode     = prpLregistDto.getOperatorCode();
  strLinkerName = prpLregistDto.getLinkerName();
  strPhoneNumber = prpLregistDto.getPhoneNumber();
  dateReportDate    = prpLregistDto.getReportDate();
  strReportDate     = dateReportDate.getYear()
                       + "年" + dateReportDate.getMonth()
                       + "月" + dateReportDate.getDate()
                       + "日";
  }
//保单信息
if(prpCmainDto!=null)
{
  dateStartDate    = prpCmainDto.getStartDate();
  strStartDate     = dateStartDate.getYear()
                       + "年" + dateStartDate.getMonth()
                       + "月" + dateStartDate.getDate()
                       + "日";
  dateEndDate    = prpCmainDto.getEndDate();
  strEndDate     = dateEndDate.getYear()
                       + "年" + dateEndDate.getMonth()
                       + "月" + dateEndDate.getDate()
                       + "日";

}

  //根据操作员代码查询操作员所在部门的联系电话
  PrpDcompanyDto     prpDcompanyDto     = null;   // 部门对象     
  String phone = "";
  if(strOperatorCode.length()>0)
  {
  UICompanyAction    uiCompanyAction    = new UICompanyAction();   
  prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strOperatorCode);      //得到操作员所在部门的对象
	 if(prpDcompanyDto!=null) 
	 {
	  phone     = prpDcompanyDto.getPhoneNumber();   //保险公司电话
	 }
  }
  
  //查勘信息
  UICheckAction uiCheckAction = new UICheckAction();
  CheckDto checkDto = uiCheckAction.findByPrimaryKey(strRegistNo);
  PrpLcheckDto prpLcheckDto = checkDto.getPrpLcheckDto();
  if(checkDto.getPrpLcheckDto()!=null)
  {
    strCheckSite    = prpLcheckDto.getCheckSite();
    strCheckDate    = prpLcheckDto.getCheckDate().getYear()
                       + "年" + prpLcheckDto.getCheckDate().getMonth()
                       + "月" + prpLcheckDto.getCheckDate().getDate()
                       + "日";
    strChecker1     = prpLcheckDto.getChecker1();
    strDamageCode   = prpLcheckDto.getDamageCode();
    //strEstimateLoss = prpLcheckDto.getEstimateLoss();
    strDamageClause = uiCodeAction.translateCodeCode("DamageCode",strDamageCode,true);
  }
	PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
	String tempContext = "";
	if (checkDto.getPrpLregistTextDtoList() != null) {
	        Iterator iterator = checkDto.getPrpLregistTextDtoList().iterator();
	        while (iterator.hasNext()) {
	                PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
	                                .next();
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
//zhulei leave:取 赔款计算书表 数据......
    String conditions = "";
    Collection collection = null;
    conditions = "RegistNo='" + strRegistNo + "' AND TextType='3'";
    BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
    collection = blPrpLregistTextFacade.findByConditions(conditions);
    int i = 0;
    String strContext = "";      //查勘报告
    //String[] arrContext = "";      //查勘报告
    if(collection!=null){
      Iterator iterator1 = collection .iterator();
      //arrContext = new String[collection.size()];
      while (iterator1.hasNext()) {
        prpLregistTextDto = (PrpLregistTextDto) iterator1.next();
        //arrContext[i] = prpLRegistTextDto.getContext();
        strContext = strContext + prpLregistTextDto.getContext();
        i++;
      }
    }
%>

<script language="javascript">
  function loadForm()
  { 
    tdPolicyNo.innerHTML = '<%=strPolicyNo%>';
    tdRegistNo.innerHTML = '报案编号：'+'<%=strRegistNo%>';
    tdLossName.innerHTML = '<%=strLossName%>';
    tdInsuredName.innerHTML = '<%=strInsuredName%>';
    tdDamageAddress.innerHTML = '<%=strDamageAddress%>';
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>'+'&nbsp;'+'<%=strReportHour.substring(0,2)%>'+'时';
   // tdReceiverName.innerHTML = '<%=strReceiverName%>' +'&nbsp;&nbsp;'+'<%=phone%>';
  //  tdHandleUnit.innerHTML = '<%=strHandleUnit%>';
    tdEndorseNo.innerHTML = '<%=strEndorseNo%>';
    tdDamageClause.innerHTML = '<%=strDamageClause%>';
    tdEstimateLoss.innerHTML = '<%=strEstimateLoss%>';
    tdReportDate.innerHTML = '<%=strReportDate%>';
    tdLinkerName.innerHTML = '<%=strLinkerName%>';
    tdPhoneNumber.innerHTML = '<%=strPhoneNumber%>';
    tdDate.innerHTML = '<%=strStartDate%>'+' － '+'<%=strEndDate%>';

  
  }
</script>






