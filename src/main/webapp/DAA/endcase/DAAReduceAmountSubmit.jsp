<%--
****************************************************************************
* DESC       ：理赔冲减保额的处理
* Author     : 中国大地项目组
* CREATEDATE ：2003-09-24
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@page errorPage="/UIErrorPage"%> 

<%-- 引入bean类部分 --%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.utility.string.*"%>
<%@page import="com.sinosoft.utility.string.Date"%>
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.prpall.blsvr.lp.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools"%>
<%@page import="com.sinosoft.prpall.pubfun.Bill"%>
<%@page import="com.sinosoft.prpall.blsvr.pg.BLEndorse"%>
<%@page import="com.sinosoft.prpall.blsvr.pg.BLPrpPtext"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.*"%>
<%@page import="com.sinosoft.prpall.schema.*"%>
<%@page import="com.sinosoft.undwrt.bl.facade.BLTaskFacade"%>
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLendorFacade"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLendorDto"%>
<%@page import="com.gyic.claim.bl.facade.BLInsuremainlistFacade"%>

<%
   //定义变量
  
   BLPolicy    blPolicy = null;
   BLEndorse   blEndorse = null;
   BLPrpCvirturlItem blPrpCvirturlItem =null;
   Bill bill = new Bill();
   String EndorseNo = "";
   String strContent =  "";
   String strMessage = "";
   String userCode = "";
   UserDto  userDto   = (UserDto)session.getAttribute("user");
   userCode = userDto.getUserCode();
   try
   {
	   String strPtext =  request.getParameter("oldPtext");
	    
	   blPolicy  = ((BLPolicy)session.getAttribute("Policy"));
	   blEndorse = ((BLEndorse)session.getAttribute("Endorse"));
	   //获取虚拟分户数据对象
	   blPrpCvirturlItem = ((BLPrpCvirturlItem)session.getAttribute("blPrpCvirturlItem"));
	    //批文重新赋值
	   PrpPtextSchema prpPtextSchema = new PrpPtextSchema();
	   prpPtextSchema.setEndorseNo(blEndorse.getBLPrpPhead().getArr(0).getEndorseNo());
	   prpPtextSchema.setPolicyNo(blEndorse.getBLPrpPhead().getArr(0).getPolicyNo());
	   prpPtextSchema.setLineNo("1");
	   prpPtextSchema.setEndorseText(strPtext);
	   prpPtextSchema.setFlag("");
	   blEndorse.setBLPrpPtext(new BLPrpPtext());
	   blEndorse.getBLPrpPtext().setArr(prpPtextSchema);
	   EndorseNo = blEndorse.getBLPrpPhead().getArr(0).getEndorseNo();
	   blEndorse.settleBeforeSave(blPolicy);	   
	   //养殖险冲减保额改造，分户冲减。Start! 
	   String breedingFarmerListFlag = SysConfig.getProperty("BREEDING_FARMER_LIST_FLAG");
	   String riskCode = blPolicy.getBLPrpCmain().getArr(0).getRiskCode();
	   if(null!=breedingFarmerListFlag && !"".equals(breedingFarmerListFlag) && breedingFarmerListFlag.indexOf(riskCode)>-1 && !"3224".equals(riskCode)&& !"3224".equals(riskCode)){
	   		//批单保存
        	blEndorse.settleInsureListBeforeSave(blPolicy);
        	if(blEndorse.getBlHerdEndorChgDetail().getSize()<=0){
	        	strMessage = "分户信息没有变动，不能保存！";
	        	throw new Exception(strMessage);
        	}
        	blEndorse.saveInsureList(blPolicy);
   		}
	   //养殖险冲减保额改造，分户冲减。End!
	   boolean hasHeadInsureList = false;
	   if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3224,3172,3194,3193,3187,3178,3179,3158,3176,0311,3201,3228,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1)){
		      String conditionsOfFatchInsureMainList = " policyNo = '"+blEndorse.getBLPrpPhead().getArr(0).getPolicyNo()+"' and validity = '2' ";
		      BLInsuremainlistFacade blInsureMainListFacade = new BLInsuremainlistFacade();
		        Collection blInsureMainListCollection = blInsureMainListFacade.findByConditions(conditionsOfFatchInsureMainList);
		        if(null!=blInsureMainListCollection && blInsureMainListCollection.size()>0){
		          hasHeadInsureList = true;
		        }
		   }
	   if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176".indexOf(riskCode) > -1)&&hasHeadInsureList){
	          //批单保存
	            blEndorse.settleBeforeSave(blPolicy);
	            if(blEndorse.getBLPlantingEndorChgDetail().getSize()<=0){
	              strMessage = "分户信息没有变动，不能保存！";
	              throw new Exception(strMessage);
	            }
	            blEndorse.savePlantInsureList(blPolicy);
	        }
	   if("3224".equals(riskCode)&&hasHeadInsureList){
	          //批单保存
	            blEndorse.settleBeforeSave(blPolicy);
	            if(blEndorse.getbLNyxEndorChgDetail().getSize()<=0){
	              strMessage = "分户信息没有变动，不能保存！";
	              throw new Exception(strMessage);
	            }
	            blEndorse.saveNyxInsureList(blPolicy);
	        }
	   //yx
	   if("3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1&&hasHeadInsureList){
	          //批单保存
	            blEndorse.settleBeforeSave(blPolicy);
	            if(blEndorse.getbLNyxEndorChgDetail().getSize()<=0){
	              strMessage = "分户信息没有变动，不能保存！";
	              throw new Exception(strMessage);
	            }
	            blEndorse.saveNyxInsureList(blPolicy);
	        }
	   if("0311".equals(riskCode)&&hasHeadInsureList){
	          //批单保存
	            blEndorse.settleBeforeSave(blPolicy);
	            if(blEndorse.getbLTemblorEndorChgDetail().getSize()<=0){
	              strMessage = "分户信息没有变动，不能保存！";
	              throw new Exception(strMessage);
	            }
	            blEndorse.saveTemblorInsureList(blPolicy);
	        }
	   
	   blEndorse.save(blPolicy);
	   //更新分户的信息
	   if(blPrpCvirturlItem != null) {
		   blPrpCvirturlItem.update();  
	   }
	   
	   //丢掉不用的session
	   session.removeAttribute("blPrpCvirturlItem");
	   session.removeAttribute("Policy");
	   session.removeAttribute("Endorse");
	     
	   if("72".equals(blEndorse.getBLPrpPhead().getArr(0).getEndorType())){
	   		strContent = "补收保费成功,生成批单" + EndorseNo;
	   }else if("14".equals(blEndorse.getBLPrpPhead().getArr(0).getEndorType())){
	   		strContent = "冲减保额成功,生成批单" + EndorseNo;	
	   }
%>

		<%-- 包含公共信息显示页面 --%>
		<jsp:include page="/common/pub/UIMessagePage.jsp">
		  <jsp:param name="Picture" value="S" />
		  <jsp:param name="Content" value="<%=strContent%>" />
		</jsp:include>
<%
   }
   catch(Exception e)
   {
      bill.putNo(SysConfig.getProperty("ENDORSRE_TABLE"),EndorseNo);
      e.printStackTrace();
      strContent = Str.encode(e.toString());
%>
	<%-- 包含公共信息显示页面 --%>
	<jsp:include page="/common/pub/UIMessagePage.jsp">
	  <jsp:param name="Picture" value="F" />
	  <jsp:param name="Content" value="<%=strContent%>" />
	</jsp:include>
<%
  }
%>
