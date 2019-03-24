package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap; 
import java.util.Iterator;
import java.math.*;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacadeForMedical;
import com.gyic.claim.bl.facade.BLNyxsettlelistFacade;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.gyic.claim.utils.Utils;
import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpropFacade;
import com.sinosoft.claim.bl.facade.BLPrpLverifyLossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLclaimLossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLendorFacade;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;

import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.claim.dto.domain.PrpLinjuryPersonDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AccidentCompensateViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.SunnyCompensateViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.image.bl.facade.BLPrpdcertifycheckFacade;
import com.sinosoft.image.bl.facade.BLPrpdimagecodeFacade;
import com.sinosoft.image.dto.domain.PrpdimagecodeDto;
import com.sinosoft.platform.bl.facade.BLUtiPlatConfigRuleFacade;
import com.sinosoft.platform.dto.domain.UtiPlatConfigRuleDto;
import com.sinosoft.prpall.blsvr.cb.BLCPolicy;
import com.sinosoft.prpall.blsvr.lp.BLPrpLcompensate;
import com.sinosoft.prpall.blsvr.pg.BLEndorse;
import com.sinosoft.prpall.blsvr.pg.BLPrpPhead;
import com.sinosoft.prpall.dbsvr.pg.DBPrpPhead;
import com.sinosoft.prpall.schema.PrpLcompensateSchema;
import com.sinosoft.prpall.schema.PrpPheadSchema;
import com.sinosoft.reins.out.bl.action.custom.BLLDangerGetAction;
import com.sinosoft.reins.out.bl.facade.BLCTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLFhTreatyFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.dto.custom.CReinsTrialDto;
import com.sinosoft.reins.out.dto.domain.FhTreatyDto;
import com.sinosoft.reins.out.dto.domain.PrpCreinsTrialDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.resource.dtofactory.domain.DBWfLog;
import com.sinosoft.utiall.dbsvr.DBPrpDcompany;
import com.sinosoft.utiall.dbsvr.DBPrpDuser;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.database.DbPool;

/**
 * 分发HTTP Post 车险理赔实赔编辑界面
 * <p>
 * Title: 车险理赔实赔编辑界面信息
 * </p>
 * <p>
 * Description: 车险理赔实赔编辑界面信息
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: sinosoft.com.cn
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class UILCompensateEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = ""; // 向前流转
		try {
			// 程序思路:
			// ---------------------------------------------------
			// 如果是第一次保存，只要能将状态变成正在处理就行了。。
			// 其他就是在正在处理的状态栏里进行处理了。
			// ---------------------------------------------------
			// 取赔款计算书号
			String compensateNo = ""; // 赔款计算书号
			String claimRelationNo=httpServletRequest.getParameter("settleListCode");
			String ClaimNo=httpServletRequest.getParameter("prpLcompensateClaimNo");
			String settleListCode=httpServletRequest.getParameter("settleListCode");
			String swfLogFlowID = httpServletRequest
					.getParameter("swfLogFlowID"); // 工作流号码
			String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); // 工作流logno
			//上海意健险上传平台新增字段
			String hospitalName=httpServletRequest.getParameter("prpLcompensateHospitalName");
			String diseaseName=httpServletRequest.getParameter("prpLcompensateDiseaseName");
			int LogNo = Integer.parseInt(swfLogLogNo);
			UICodeAction uiCodeAction = new UICodeAction();
			int newCompensate = -1; // 默认不需要重新生成赔款计算书,后来决定不需要用工作流保存每个计算书的状态
			UserDto user = (UserDto) httpServletRequest.getSession()
					.getAttribute("user");
			String riskCodeTemp = httpServletRequest
					.getParameter("prpLcompensateRiskCode");
			String caseType = httpServletRequest
					.getParameter("prpLcompensateCaseType");
			if (riskCodeTemp != null && riskCodeTemp.trim().length() > 0) {
				user.setRiskCode(riskCodeTemp);
			}
			String comCode = user.getComCode();
			String riskCode = user.getRiskCode();
			int year = DateTime.current().getYear();
			
	        //影像系统添加
	        BLPrpdimagecodeFacade blPrpdimagecodeFacade = new BLPrpdimagecodeFacade();
	        BLPrpdcertifycheckFacade blPrpdcertifycheckFacade = new BLPrpdcertifycheckFacade();
	        PrpdimagecodeDto prpdimagecodeDto = new PrpdimagecodeDto();
	        DBPrpDuser dbPrpDuser = new DBPrpDuser();
	        DBPrpDcompany dbprpDcompany = new DBPrpDcompany();

	        String role = "";
	        String appcode = "";
	        String appname = "";  
	        String username="";
	        String comcode = "";
	        String comname= "";
	        String imgRegistNo="";
	        int t = 0;
	        t = dbPrpDuser.getInfo(user.getUserCode());
	        username=dbPrpDuser.getUserName();
	        t = dbprpDcompany.getInfo(dbPrpDuser.getComCode());
	        comcode = dbPrpDuser.getComCode();
	        comname= dbprpDcompany.getComCName();
	        String result = "";
	        String imgRiskCode = riskCode;
			// ------------------------------------------------------------
			//校验是否注销
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();  
			Utils utils = new Utils();//检查内存
			String remark  = "";
			String strClaimNoTemp = (String) httpServletRequest.getParameter("prpLcompensateClaimNo");
			String condition = "flowId ='"+swfLogFlowID+"' and nodeType='cance' and nodeStatus in ('0','2') and businessno='"+strClaimNoTemp+"'";
		       Collection cancelNodeList = uiWorkFlowAction.findNodesByConditions(condition);
		       if(cancelNodeList!=null&&cancelNodeList.size()>0){
		    	   throw new UserException(1,3,"1234","案件已经申请注销拒赔！");
		       }
			
		     //如果是零赔付校验之前核赔通过计算书的总赔付金额（不含费用）加上本张计算书赔付金额（不含费用）之和是否为零
		     String prpLcompensateZeroLossType =  httpServletRequest.getParameter("prpLcompensateZeroLossType"); 
		     if("1".equals(prpLcompensateZeroLossType)||"2".equals(prpLcompensateZeroLossType)||"3".equals(prpLcompensateZeroLossType)){
		    	 double sumPid = 0;
		    	 double sumThisPaid = Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumThisPaid"));
		    	 BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
		    	 ArrayList<PrpLcompensateDto> prpLcompensateList = (ArrayList<PrpLcompensateDto>)blPrpLcompensateFacade.findByConditions(" claimNo = '"+ClaimNo+"'");
		    	 if(null != prpLcompensateList && prpLcompensateList.size()>0){
		    		 for(int i=0;i<prpLcompensateList.size();i++){
		    			 sumPid += prpLcompensateList.get(i).getSumThisPaid();
		    		 }
		    	 }
		    	 sumPid += sumThisPaid;
		    	 if(sumPid != 0){
		    		 throw new UserException(1,3,"零赔付原因","零赔付赔付金额之和不为零");
		    	 }
			       if(imgRiskCode!="")
			       {
			    	  BLPrpLclaimFacadeBase imgClaimFacade=new BLPrpLclaimFacadeBase();
					  PrpLclaimDto  imgClaimDto= new PrpLclaimDto();
					  imgClaimDto=imgClaimFacade.findByPrimaryKey(ClaimNo);
					  imgRegistNo=imgClaimDto.getRegistNo();
			 		  prpdimagecodeDto = blPrpdimagecodeFacade.findByPrimaryKey(imgRiskCode,"0000000000");
					  role = prpdimagecodeDto.getClaimrole();
					  appcode=prpdimagecodeDto.getClaimcode();
					  appname=prpdimagecodeDto.getClaimname();
					  //String businessno= "1111111111";
					  String businessno = imgRegistNo;
					   StringBuffer s = new StringBuffer();
					   s.append("<?xml version='1.0' encoding='UTF-8'?><root><BASE_DATA>");
					   s.append("<USER_CODE>");
					   s.append(user.getUserCode());
					   s.append("</USER_CODE>");
					   
					   s.append("<USER_NAME>");
					   s.append(username);
					   s.append("</USER_NAME>");
					   
					   s.append("<ORG_CODE>");
					   s.append(comcode);
					   s.append("</ORG_CODE>");
					   
					   s.append("<ORG_NAME>");
					   s.append(comname);
					   s.append("</ORG_NAME>");
					   
					   s.append("<ROLE_CODE>");
					   s.append(role);
					   s.append("</ROLE_CODE>");
					   
					   s.append("</BASE_DATA><META_DATA><BATCH>");
					   
					   s.append("<APP_CODE>");
					   s.append(appcode);
					   s.append("</APP_CODE>");
					   
					   s.append("<APP_NAME>");
					   s.append(appname);
					   s.append("</APP_NAME>");
					   
					   s.append("<BUSI_NO>");
					   s.append(businessno);
					   s.append("</BUSI_NO>");
					   
					   s.append("</BATCH></META_DATA></root>");
					   try{
						   System.err.println(s.toString());
						   result = blPrpdimagecodeFacade.imageStatistics(s.toString());
						   //System.err.println(result);
						   String newxml = blPrpdimagecodeFacade.html2xml(result);
						   String nodeID = "";
						   String strWaning = "";
						   Collection nodes =  new ArrayList();
						   nodes = blPrpdcertifycheckFacade.findAllByPrimaryKey(imgRiskCode,"claim_zero");
						   HashMap hm = blPrpdimagecodeFacade.imageNodeCheck(newxml,nodes);
						   strWaning = blPrpdcertifycheckFacade.checkMustUpload(nodes,hm);
						   if(!strWaning.equals(""))
						   {
							   throw new UserException(1, 3, "单证信息", strWaning);
						   }
						}catch (Exception e){
						e.printStackTrace();
						throw e;
					}
					   
			       }
		     }
		       
			// modify by ww add begin 2005-12-21
			// reason: 防止重复提交
			String strLastAccessedTime = ""
					+ httpServletRequest.getSession().getLastAccessedTime()
					/ 1000;
			String oldLastAccessedTime = (String) httpServletRequest
					.getSession().getAttribute("oldCompensateLastAccessedTime");
			String strRiskType = uiCodeAction
					.translateRiskCodetoRiskType(riskCode);

			/* modify by wuzheng 屏蔽计算书提交成功的提示页面有两个按钮"冲减保额"和"补收保费"，20071112 begin */
			// String isCompensate = "Y";
			String isCompensate = "";
			/* modify by wuzheng 屏蔽计算书提交成功的提示页面有两个按钮"冲减保额"和"补收保费"，20071112 end */

			String isNew = "old";

			// modify by ww add end 2005-11-15
			if (oldLastAccessedTime.trim().equals("")) {
				// modify by ww add begin 2005-11-15
				// reason: 防止重复提交
				httpServletRequest.getSession().setAttribute(
						"oldCompensateLastAccessedTime", strLastAccessedTime);
				// modify by ww add end 2005-11-15
				//防止回退刷新再提交，或多人同时操作提交同一案件。
				condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus ='4'";
			    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
			    if(certifyNodeList!=null&&certifyNodeList.size()>0){
			    	   throw new UserException(1,3,"工作流","该案件计算书节点已处理！");
			    }
				// 业务操作
				compensateNo = httpServletRequest
						.getParameter("prpLcompensateCompensateNo");
				if (compensateNo == null || compensateNo.length() < 1
						|| compensateNo.trim().equals("")) {
					isNew = "new";
					UIBillAction uiBillAction = new UIBillAction();//
					String tableName = "prplcompensate";
					compensateNo = uiBillAction.getNo(tableName,
							httpServletRequest
									.getParameter("prpLcompensateClaimNo"),
							comCode, year);
					newCompensate = 1; // 生成赔款计算书 这种情况由于是多任务处理，无论何时，都需要新插节点
				}
				httpServletRequest.setAttribute("compensateNo", compensateNo);
				// 用viewHelper整理界面输入
				BLPrpLclaimFacadeBase claimFacade=new BLPrpLclaimFacadeBase();
				PrpLclaimDto  claimDto1= new PrpLclaimDto();
				claimDto1=claimFacade.findByPrimaryKey(ClaimNo);
				String registNo=claimDto1.getRegistNo();
				httpServletRequest.setAttribute("registNo", registNo);
				CompensateDto compensateDto = null;
				
				
				//20121115 Pao 临时屏蔽中央政策性种植险自动冲减保额时增加校验  begin
				if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3148,3174,3150,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3179,3158,3176,0311,3177".indexOf(riskCode) > -1)){
			        String strCompensateNo = "";
			        double SumPaid = 0.00;
			        String iWherePart1=" policyno='"+claimDto1.getPolicyNo()+"'";
					BLPrpLcompensate blPrpLcompensate=new BLPrpLcompensate();
	                PrpLcompensateSchema prpLcompensateSchema=new PrpLcompensateSchema();
	                BLPrpPhead blPrpPhead=new BLPrpPhead();
					PrpPheadSchema prpPheadSchema=new PrpPheadSchema();
	                blPrpLcompensate.query(iWherePart1);
				    if(blPrpLcompensate.getSize()>0){
					 for(int i=0;i<blPrpLcompensate.getSize();i++){
						prpLcompensateSchema=blPrpLcompensate.getArr(i);
						if(!"".equals(prpLcompensateSchema.getSumPaid())){
							SumPaid = Double.valueOf(prpLcompensateSchema.getSumPaid());
						}
						if("1".equals(prpLcompensateSchema.getUnderWriteFlag())&&SumPaid!=0){
							String CompensateNo = prpLcompensateSchema.getCompensateNo();
							String Strcondition = "compensateNo='"+CompensateNo+"' and endortype='14' and UnderWriteFlag='1'";
							blPrpPhead.query(Strcondition);
							// 20161129 为了加去冲减控制,启用数据库开关
							BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacade = new BLUtiPlatConfigRuleFacade();
							UtiPlatConfigRuleDto utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("prpall", "CHECKEND_SWITCH", 1);
							// 20161214 去除冲减保额校验
							//if(utiPlatConfigRuleDto!=null && "1".equals(utiPlatConfigRuleDto.getRule())){
							//	if(blPrpPhead.getSize()==0){
							//		throw new UserException(1,3,"525","存在理算书"+CompensateNo+" 未进行冲减保额操作，不允许理算!");
							//	}
							//}
						}
					}
				}
			    }
			   //20121115 Pao 临时屏蔽中央政策性种植险自动冲减保额时增加校验  end
				//多险别多标的种植险理算保存时校验未冲减保额的的理算书 start
				String planting31FarmerListFlagCheck = SysConfig.getProperty("PLNATING_31_FARMER_LIST_FLAG","claim");
				if(null != planting31FarmerListFlagCheck && (planting31FarmerListFlagCheck.indexOf(riskCode) > -1 || riskCode.equals("0311"))){
			        double SumPaid = 0.00;
			        String iWherePart1=" policyno='"+claimDto1.getPolicyNo()+"'";
					BLPrpLcompensate blPrpLcompensate=new BLPrpLcompensate();
	                PrpLcompensateSchema prpLcompensateSchema=new PrpLcompensateSchema();
	                BLPrpPhead blPrpPhead=new BLPrpPhead();
	                blPrpLcompensate.query(iWherePart1);
				    if(blPrpLcompensate.getSize()>0){
					 for(int i=0;i<blPrpLcompensate.getSize();i++){
						prpLcompensateSchema=blPrpLcompensate.getArr(i);
						if(!"".equals(prpLcompensateSchema.getSumPaid())){
							SumPaid = Double.valueOf(prpLcompensateSchema.getSumPaid());
						}
						if("1".equals(prpLcompensateSchema.getUnderWriteFlag())&&SumPaid!=0){
							String CompensateNo = prpLcompensateSchema.getCompensateNo();
							String Strcondition = "compensateNo='"+CompensateNo+"' and endortype='14' and UnderWriteFlag='1'";
							blPrpPhead.query(Strcondition);
							// 20161129 为了加去冲减控制,启用数据库开关
							BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacade = new BLUtiPlatConfigRuleFacade();
							UtiPlatConfigRuleDto utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("prpall", "CHECKEND_SWITCH", 1);
							// 20161214 去除冲减保额校验
							//if(utiPlatConfigRuleDto!=null && "1".equals(utiPlatConfigRuleDto.getRule())){
							//	if(blPrpPhead.getSize()==0){
							//		throw new UserException(1,3,"525","存在理算书"+CompensateNo+" 未进行冲减保额操作，不允许理算!");
							//	}
							//}
						}
					}
				    }
			    }
				//多险别多标的种植险理算保存时校验未冲减保额的的理算书 end

				
				
				// modify by wangli add start 20050519
				if ("D".equals(strRiskType)) {//车险没有做多危险单位的处理
					// modify by liuyanmei 20060221 end
					SunnyCompensateViewHelper sunnyCompensateViewHelper = new SunnyCompensateViewHelper();
					compensateDto = sunnyCompensateViewHelper
							.viewToDto(httpServletRequest);
				} else if ("H".equals(strRiskType) || "I".equals(strRiskType)) {
					AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
					compensateDto = accidentCompensateViewHelper
							.viewToDtoForAgri(httpServletRequest);
				} else if ("J".equals(strRiskType)) {
					AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
					compensateDto = accidentCompensateViewHelper
							.viewToDtoForJprop(httpServletRequest);
				} else {
					AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
					if (riskCode.substring(0, 2).equals("27")
							|| riskCode.substring(0, 2).equals("26")||
							riskCode.substring(0, 2).equals("28")) {
						compensateDto = accidentCompensateViewHelper
								.viewToDtoForAccident(httpServletRequest);
					} else {
						compensateDto = accidentCompensateViewHelper
								.viewToDto(httpServletRequest);
					}
				}
				
				//存储信息--出险人
				/*PrpLinjuryPersonDto  prpLinjuryPersonDto = null;
				prpLinjuryPersonDto = compensateDto.getPrpLinjuryPersonDto();
				String AcciName = prpLinjuryPersonDto.getAcciName();
				String Sex      = prpLinjuryPersonDto.getSex();
				String IdentifyNumber = prpLinjuryPersonDto.getIdentifyNumber();
				BLPrpLinjuryFacadeBase bLPrpLinjuryFacadeBase = new BLPrpLinjuryFacadeBase();
				bLPrpLinjuryFacadeBase.insert(prpLinjuryPersonDto);*/
				/*************************险种为2801时才插入此表 开始*************************/
				BLCompensateFacade bl = new BLCompensateFacade();
				if(bl.checkCompensateRelation(compensateDto)){
					throw new UserException(1,3,"12345","赔付金额不等于赔款金额加费用！");
				}
				
				//养殖险判断耳标号是否有进行重复理算
				//System.err.println("compensateDto:"+compensateDto.getPrpLcompensateeartDtoList().size());
				if(compensateDto.getPrpLcompensateeartDtoList()!=null&&compensateDto.getPrpLcompensateeartDtoList().size()>0){
					String sameflag = "false";
					String prpLcompensatePolicyNo = httpServletRequest.getParameter("prpLcompensatePolicyNo");
					String conditons1= " policyno='"+prpLcompensatePolicyNo+"' and underwriteflag='1'";
					
					BLPrpLcompensateFacade  bLPrpLcompensateFacade = new BLPrpLcompensateFacade();
					BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
					ArrayList compensateeartDtoList = compensateDto.getPrpLcompensateeartDtoList();
					ArrayList  prpLcompensateDtoList = (ArrayList)bLPrpLcompensateFacade.findByConditions(conditons1);
					if(null!=prpLcompensateDtoList&&prpLcompensateDtoList.size()>0){
						String conditoncompp=" nodeType='compe' and compensateno in (";
						for(int i=0;i<prpLcompensateDtoList.size();i++){
					        PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)prpLcompensateDtoList.get(i);
					        conditoncompp = conditoncompp+"'"+prpLcompensateDto.getCompensateNo()+"',";
						}
						conditoncompp = conditoncompp.substring(0, conditoncompp.length()-1);
						conditoncompp = conditoncompp+") and earno not in (select earno from   Prplcompensateear  WHERE nodeType = 'compe'  and compensateno in (";
						for(int i=0;i<prpLcompensateDtoList.size();i++){
					        PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)prpLcompensateDtoList.get(i);
					        conditoncompp = conditoncompp+"'"+prpLcompensateDto.getCompensateNo()+"',";
						}
						conditoncompp = conditoncompp.substring(0, conditoncompp.length()-1);
						conditoncompp = conditoncompp+") group by earno having mod(count(earno),2) = 0)";
						System.out.println(conditoncompp);
						ArrayList  eartDtoList = (ArrayList)bLPrplcompensateearFacade.findByConditions(conditoncompp);
						for(int j=0;j<compensateeartDtoList.size();j++){
							PrplcompensateearDto  thisearDto  =	(PrplcompensateearDto)compensateeartDtoList.get(j);
							String  earNo = thisearDto.getEarno();
							Double  lossesNumber   = compensateDto.getPrpLcompensateDto().getLossesNumber();
							if(lossesNumber<0)
							{
								sameflag = "false";
							}
							else{
								for(int k=0;k<eartDtoList.size();k++){
									PrplcompensateearDto earDto = (PrplcompensateearDto)eartDtoList.get(k);
								    if(earNo.equals(earDto.getEarno())){
								    	sameflag = "true";
								    	break;
								    }
								}
							}
						}
					}
					
					//查询本次理算提交时候耳标号是否在历史理算提交的立标号中存在
					
					if(null!=sameflag&&"true".equals(sameflag)){
						throw new UserException(1,3,"123456","本计算书存在已经赔付的耳标号！");
					}
				}
				
				if(compensateDto.getPrplCompensateHouseDtoList()!=null&&compensateDto.getPrpLcompensateeartDtoList().size()>0){
					String sameflag2 = "false";
					BLPrpCitemKindFacade bLPrpCitemKindFacade = new BLPrpCitemKindFacade();
					double unitamount = 0.00;
					String conditions1 = "";
					ArrayList itemkindlist = new ArrayList();;
			        BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
					ArrayList compensatehouseDtoList = compensateDto.getPrplCompensateHouseDtoList();
					if(compensatehouseDtoList.size() > 0)
					{
						for(int i=0;i<compensatehouseDtoList.size();i++)
						{
							
							PrplcompensatehouseDto  houseDto  =	(PrplcompensatehouseDto)compensatehouseDtoList.get(i);
							String policyno = houseDto.getPolicyno();
							String idcard = houseDto.getIdcard();
							conditions1 = " policyno='" + policyno + "' and ITEMKINDNO=1";
							itemkindlist = (ArrayList)bLPrpCitemKindFacade.findByConditions(conditions1);
							if(itemkindlist != null && itemkindlist.size()>0)
							{
								PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)itemkindlist.get(0);
								if(prpCitemKindDto != null)
								{
									unitamount = prpCitemKindDto.getUnitAmount();
								}
							}
							BigDecimal sumloss = bLPrplcompensatehouseFacade.getSumCompensate(idcard, policyno);
							double loss = 0.00;
							if(sumloss != null)
							{
								loss = sumloss.doubleValue();
							}
							double estimateloss = houseDto.getEstimateloss();
							if((estimateloss + loss) > unitamount)
							{
								sameflag2 = "true";
								break;
							}
							
						}
					}
					if(null!=sameflag2&&"true".equals(sameflag2)){
					   throw new UserException(1,3,"123456","本计算书的身份证号累计赔款金额大于单位保额！");
					}
					
				}
				
				/**
				//农房险判断身份证是否有进行重复理算
				if(compensateDto.getPrplCompensateHouseDtoList()!=null){
					String sameflag = "false";
					String prpLcompensatePolicyNo = httpServletRequest.getParameter("prpLcompensatePolicyNo");
					String conditons1= " policyno='"+prpLcompensatePolicyNo+"' and underwriteflag='1'";
					
					BLPrpLcompensateFacade  bLPrpLcompensateFacade = new BLPrpLcompensateFacade();
					BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
					ArrayList compensatehouseDtoList = compensateDto.getPrplCompensateHouseDtoList();
					ArrayList  prpLcompensateDtoList = (ArrayList)bLPrpLcompensateFacade.findByConditions(conditons1);
					if(null!=prpLcompensateDtoList&&prpLcompensateDtoList.size()>0){
						String conditoncompp=" nodeType='compe' and compensateno in (";
						for(int i=0;i<prpLcompensateDtoList.size();i++){
					        PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)prpLcompensateDtoList.get(i);
					        conditoncompp = conditoncompp+"'"+prpLcompensateDto.getCompensateNo()+"',";
						}
						conditoncompp = conditoncompp.substring(0, conditoncompp.length()-1);
						conditoncompp = conditoncompp+") and idcard not in (select idcard from   Prplcompensatehouse  WHERE nodeType = 'compe'  and compensateno in (";
						for(int i=0;i<prpLcompensateDtoList.size();i++){
					        PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)prpLcompensateDtoList.get(i);
					        conditoncompp = conditoncompp+"'"+prpLcompensateDto.getCompensateNo()+"',";
						}
						conditoncompp = conditoncompp.substring(0, conditoncompp.length()-1);
						conditoncompp = conditoncompp+") group by idcard having mod(count(idcard),2) = 0)";
						System.out.println(conditoncompp);
						ArrayList  idcardDtoList = (ArrayList)bLPrplcompensatehouseFacade.findByConditions(conditoncompp);
						for(int j=0;j<compensatehouseDtoList.size();j++){
							PrplcompensatehouseDto  thisidcardDto  =	(PrplcompensatehouseDto)compensatehouseDtoList.get(j);
							String  idcardNo = thisidcardDto.getIdcard();
							Double  lossesNumber   = compensateDto.getPrpLcompensateDto().getSumLoss();
							System.err.println("lossesNumber:" + lossesNumber);
							if(lossesNumber<0)
							{
								sameflag = "false";
							}
							else{
								for(int k=0;k<idcardDtoList.size();k++){
									PrplcompensatehouseDto idcardDto = (PrplcompensatehouseDto)idcardDtoList.get(k);
								    if(idcardNo.equals(idcardDto.getIdcard())){
								    	sameflag = "true";
								    	break;
								    }
								}
							}
						}
					}
					
					//查询本次理算提交时候耳标号是否在历史理算提交的立标号中存在
					
					if(null!=sameflag&&"true".equals(sameflag)){
						throw new UserException(1,3,"123456","本计算书存在已经赔付的身份证号！");
					}
				}**/
				
				// 农险统计制度
				String claimNo = httpServletRequest.getParameter("prpLcompensateClaimNo");
				UIClaimAction uiClaimAction = new UIClaimAction();
				ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
			    String businessType = claimDto.getPrpLclaimDto().getBusinessType();
				String businessType1 = claimDto.getPrpLclaimDto().getBusinessType1();
				String businessFlag  = claimDto.getPrpLclaimDto().getBusinessFlag();
				String otherFlag	 = claimDto.getPrpLclaimDto().getOtherFlag();
				compensateDto.getPrpLcompensateDto().setBusinessType(businessType);
				compensateDto.getPrpLcompensateDto().setBusinessType1(businessType1);
				compensateDto.getPrpLcompensateDto().setBusinessFlag(businessFlag);
				compensateDto.getPrpLcompensateDto().setOtherFlag(otherFlag);
			
				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				SwfLogDto swfLogDtoDealNode = new SwfLogDto();

				swfLogDtoDealNode.setNewMTask(newCompensate);

				// 子任务的处理 ,单个赔款计算书的处理
				if (!swfLogFlowID.equals("null") && !swfLogLogNo.equals("null")) {
					swfLogDtoDealNode.setFlowID(swfLogFlowID);
					swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils
							.nullToZero(swfLogLogNo)));
				}

				if (newCompensate == 1) {
					swfLogDtoDealNode.setBusinessNo(compensateDto
							.getPrpLcompensateDto().getClaimNo()); // 本节点的查找
					swfLogDtoDealNode.setNextBusinessNo(compensateDto
							.getPrpLcompensateDto().getCompensateNo());

				} else {
					swfLogDtoDealNode.setBusinessNo(compensateDto
							.getPrpLcompensateDto().getCompensateNo()); // 本节点的查找
					swfLogDtoDealNode.setNextBusinessNo(compensateDto
							.getPrpLcompensateDto().getClaimNo());
				}

				swfLogDtoDealNode.setKeyIn(compensateDto.getPrpLcompensateDto()
						.getClaimNo());
				swfLogDtoDealNode.setNodeStatus((String) httpServletRequest
						.getParameter("buttonSaveType"));
				swfLogDtoDealNode.setKeyOut(compensateDto
						.getPrpLcompensateDto().getCompensateNo());

				// add by lixiang start at 2005-12-20
				// reason:如果是特殊赔案进行的核赔提交，则需要将businessno转换成计算书号码。
				if (("3".equals(caseType) || "4".equals(caseType) || "6"
						.equals(caseType))
						&& "4".equals(swfLogDtoDealNode.getNodeStatus())) {
					swfLogDtoDealNode.setNextBusinessNo(compensateDto
							.getPrpLcompensateDto().getCompensateNo());
				}

				WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,
						swfLogDtoDealNode);
				// add by lym 20070327 间接理赔费用分险别-------
				String kindCode = "";
			    double chargeAmount = 0.00;
				double sumrealPay = 0.00;
				int serialNo = compensateDto.getPrpLchargeDtoList().size() + 1;
				int chargecount = compensateDto.getPrpLchargeDtoList().size() + 1;
				String policyno = compensateDto.getPrpLcompensateDto()
						.getPolicyNo();
				Collection prpLchargeDtoList = new ArrayList();

				boolean inderect = true;
				if (inderect) {
					if (compensateDto.getPrpLchargeDtoList() != null
							&& compensateDto.getPrpLchargeDtoList().size() > 0) {
						for (Iterator PrpLcharge = compensateDto
								.getPrpLchargeDtoList().iterator(); PrpLcharge
								.hasNext();) {
							PrpLchargeDto prpLchargeDto = (PrpLchargeDto) PrpLcharge
									.next();
							if (!"28".equals(prpLchargeDto.getChargeCode())) {
								PrpLchargeDto prpLchargeKindDto = new PrpLchargeDto();
								kindCode = prpLchargeDto.getKindCode();
								chargeAmount = prpLchargeDto.getChargeAmount();
								sumrealPay = chargeAmount;
								prpLchargeKindDto.setCompensateNo(compensateNo);
								prpLchargeKindDto.setRiskCode(riskCode);
								prpLchargeKindDto.setKindCode(kindCode);
								prpLchargeKindDto.setPolicyNo(policyno);
								prpLchargeKindDto.setSerialNo(serialNo);
								prpLchargeKindDto.setChargeCode("28");
								prpLchargeKindDto.setChargeName("间接理赔费用");
								prpLchargeKindDto.setCurrency("CNY");
								prpLchargeKindDto.setChargeAmount(chargeAmount);
								prpLchargeKindDto.setSumRealPay(sumrealPay);
								prpLchargeDtoList.add(prpLchargeKindDto);
								serialNo = serialNo + 1;
							}

						}
						inderect = false;

					} else {

						inderect = false;
					}

				}
				if (!inderect) {
					if (compensateDto.getPrpLlossDtoList() != null
							&& compensateDto.getPrpLlossDtoList().size() > 0) {
						for (Iterator prplloss = compensateDto
								.getPrpLlossDtoList().iterator(); prplloss
								.hasNext();) {
							PrpLlossDto prpLlossDto = (PrpLlossDto) prplloss
									.next();
							PrpLchargeDto prpLchargeKindDto = new PrpLchargeDto();
							kindCode = prpLlossDto.getKindCode();
							chargeAmount = prpLlossDto.getSumRealPay();
							sumrealPay = chargeAmount;
							prpLchargeKindDto.setCompensateNo(compensateNo);
							prpLchargeKindDto.setRiskCode(riskCode);
							prpLchargeKindDto.setKindCode(kindCode);
							prpLchargeKindDto.setPolicyNo(policyno);
							prpLchargeKindDto.setSerialNo(serialNo);
							prpLchargeKindDto.setChargeCode("28");
							prpLchargeKindDto.setChargeName("间接理赔费用");
							prpLchargeKindDto.setCurrency("CNY");
							prpLchargeKindDto.setChargeAmount(chargeAmount);
							prpLchargeKindDto.setSumRealPay(sumrealPay);
							prpLchargeDtoList.add(prpLchargeKindDto);
							serialNo = serialNo + 1;

						}
					}
					if (compensateDto.getPrpLpersonLossDtoList() != null
							&& compensateDto.getPrpLpersonLossDtoList().size() > 0) {
						for (Iterator prpLpersonLoss = compensateDto
								.getPrpLpersonLossDtoList().iterator(); prpLpersonLoss
								.hasNext();) {
							PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) prpLpersonLoss
									.next();
							PrpLchargeDto prpLchargeKindDto = new PrpLchargeDto();
							kindCode = prpLpersonLossDto.getKindCode();
							chargeAmount = prpLpersonLossDto.getSumRealPay();
							sumrealPay = chargeAmount;
							prpLchargeKindDto.setCompensateNo(compensateNo);
							prpLchargeKindDto.setRiskCode(riskCode);
							prpLchargeKindDto.setKindCode(kindCode);
							prpLchargeKindDto.setPolicyNo(policyno);
							prpLchargeKindDto.setSerialNo(serialNo);
							prpLchargeKindDto.setChargeCode("28");
							prpLchargeKindDto.setChargeName("间接理赔费用");
							prpLchargeKindDto.setCurrency("CNY");
							prpLchargeKindDto.setChargeAmount(chargeAmount);
							prpLchargeKindDto.setSumRealPay(sumrealPay);
							prpLchargeDtoList.add(prpLchargeKindDto);
							serialNo = serialNo + 1;

						}

					}

				}
				int m = chargecount;
				Collection prpLchargeList = new ArrayList();
				HashMap hashMapTemp = new HashMap();
				hashMapTemp = new HashMap();

				PrpLchargeDto prpLchargeKindDto = new PrpLchargeDto();
				if (prpLchargeDtoList != null && prpLchargeDtoList.size() > 0) {
					for (Iterator it = prpLchargeDtoList.iterator(); it
							.hasNext();) {
						PrpLchargeDto prpLchargeDto = (PrpLchargeDto) it.next();
						if (!"04".equals(prpLchargeDto.getChargeCode())
								&& !"18".equals(prpLchargeDto.getChargeCode())) {
							kindCode = prpLchargeDto.getKindCode();
							//关闭间接理赔费用
							//chargeAmount = (prpLchargeDto.getChargeAmount() * 0.025);
							  chargeAmount = (prpLchargeDto.getChargeAmount() * 0);
							//关闭间接理赔费用
							sumrealPay = chargeAmount;
							if (hashMapTemp.containsKey(kindCode)) {
								prpLchargeKindDto = (PrpLchargeDto) hashMapTemp
										.get(kindCode);
								prpLchargeKindDto
										.setChargeAmount(prpLchargeKindDto
												.getChargeAmount()
												+ chargeAmount);
								prpLchargeKindDto
										.setSumRealPay(prpLchargeKindDto
												.getSumRealPay()
												+ sumrealPay);

							} else {
								prpLchargeKindDto = new PrpLchargeDto();
								prpLchargeKindDto.setKindCode(kindCode);
								prpLchargeKindDto
										.setKindName(uiCodeAction
												.translateKindCode(
														prpLchargeDto
																.getRiskCode(),
														kindCode, true));
								prpLchargeKindDto.setCompensateNo(compensateNo);
								prpLchargeKindDto.setRiskCode(riskCode);
								prpLchargeKindDto.setPolicyNo(policyno);
								prpLchargeKindDto.setSerialNo(m);
								prpLchargeKindDto.setChargeCode("28");
								prpLchargeKindDto.setChargeName("间接理赔费用");
								prpLchargeKindDto.setCurrency("CNY");
								prpLchargeKindDto.setChargeAmount(chargeAmount);
								prpLchargeKindDto.setSumRealPay(sumrealPay);
								m++;
							}

							hashMapTemp.put(kindCode, prpLchargeKindDto);
						}
					}
				}

				double sumThisPaid = Double.parseDouble(httpServletRequest
						.getParameter("prpLcompensateSumThisPaid"));
				double sumPaid = compensateDto.getPrpLcompensateDto()
						.getSumPaid();
				double sumDutyPaid = compensateDto.getPrpLcompensateDto()
						.getSumDutyPaid();

				// 把hashmap里面的值取出来
				Collection collection = hashMapTemp.values();
				if (collection.size() > 0) {
					prpLchargeList = new ArrayList();
				}
				Iterator iterator = collection.iterator();
				while (iterator.hasNext()) {
					PrpLchargeDto prpLchargeKindDtotemp = (PrpLchargeDto) iterator
							.next();
					/*
					 * GYNB-170 FENGLEI 国元版本不需要间接理赔费用 satrt
					 */
					// prpLchargeList.add(prpLchargeKindDtotemp);
					/*
					 * GYNB-170 FENGLEI 国元版本不需要间接理赔费用 end
					 */
					// sumPaid += prpLchargeKindDtotemp.getChargeAmount();
					// sumDutyPaid +=prpLchargeKindDtotemp.getChargeAmount();
					// sumThisPaid += prpLchargeKindDtotemp.getChargeAmount();
					// compensateDto.getPrpLcompensateDto().setSumPaid(sumPaid);
					// compensateDto.getPrpLcompensateDto().setSumDutyPaid(sumDutyPaid);
					// compensateDto.getPrpLcompensateDto().setSumThisPaid(sumThisPaid);
				}
				//关闭间接理赔费用开始
			
//			    compensateDto.getPrpLcompensateDto().setSumPaid(
//			 			sumPaid + sumPaid * 0.025);
//				compensateDto.getPrpLcompensateDto().setSumDutyPaid(
//						sumDutyPaid + sumPaid * 0.025);
//				compensateDto.getPrpLcompensateDto().setSumThisPaid(
//						sumThisPaid + sumPaid * 0.025);
				compensateDto.getPrpLcompensateDto().setSumPaid(
						sumPaid);
				compensateDto.getPrpLcompensateDto().setSumDutyPaid(
						sumDutyPaid);
				compensateDto.getPrpLcompensateDto().setSumThisPaid(
						sumThisPaid);
				//关闭间接理赔费用结束
				compensateDto.getPrpLchargeDtoList().addAll(prpLchargeList);

				String endorseNo = "";
				BLPrpLendorFacade blPrpLendorFacade = new BLPrpLendorFacade();
				int count = -1;
				String Sql = "CompensateNo = '" + compensateNo
						+ "' and EndorType = '14'";
				count = blPrpLendorFacade.getCount(Sql);
				if (count > 0) {
					ArrayList prpLendorDtoList = new ArrayList();
					prpLendorDtoList = (ArrayList) blPrpLendorFacade
							.findByConditions(Sql);
					PrpLendorDto prpLendorDto = new PrpLendorDto();
					prpLendorDto = (PrpLendorDto) prpLendorDtoList.get(0);
					endorseNo = prpLendorDto.getEndorseNo();
					blPrpLendorFacade.deleteByConditions(Sql);

					DbPool dbPool = new DbPool();
					dbPool.open(SysConfig.getProperty("DDCCDATASOURCE"));
					DBManager dbManager = dbPool.getDBManager(SysConfig
							.getProperty("DDCCDATASOURCE"));

					BLCPolicy blCPolicy = new BLCPolicy();
					BLEndorse blEndorse = new BLEndorse();
					DBPrpPhead dbPrpPhead = new DBPrpPhead();
					DBWfLog dbWfLog = new DBWfLog(dbManager);
					try {
						dbPool.beginTransaction();
						dbPrpPhead.getInfo(dbPool, endorseNo);
						blCPolicy.cancel(dbPool, policyno, "Y");
						blEndorse.cancel(dbPool, endorseNo);
						dbWfLog.deleteUWTrace(dbManager, endorseNo);
						dbPool.commitTransaction();
					} catch (Exception e) {
						dbPool.rollbackTransaction();
					}finally{
						dbManager.close();
						dbPool.close();//增加finally,保证数据库连接正常关闭
					}
				}

				int count2 = -1;
				String Sql2 = "CompensateNo = '" + compensateNo
						+ "' and EndorType = '72'";
				count2 = blPrpLendorFacade.getCount(Sql2);
				if (count2 > 0) {
					ArrayList prpLendorDtoList = new ArrayList();
					prpLendorDtoList = (ArrayList) blPrpLendorFacade
							.findByConditions(Sql2);
					PrpLendorDto prpLendorDto = new PrpLendorDto();
					prpLendorDto = (PrpLendorDto) prpLendorDtoList.get(0);
					endorseNo = prpLendorDto.getEndorseNo();
					blPrpLendorFacade.deleteByConditions(Sql2);

					DbPool dbPool = new DbPool();
					dbPool.open(SysConfig.getProperty("DDCCDATASOURCE"));
					DBManager dbManager = dbPool.getDBManager(SysConfig
							.getProperty("DDCCDATASOURCE"));

					BLCPolicy blCPolicy = new BLCPolicy();
					BLEndorse blEndorse = new BLEndorse();
					DBPrpPhead dbPrpPhead = new DBPrpPhead();
					DBWfLog dbWfLog = new DBWfLog(dbManager);
					try {
						dbPool.beginTransaction();
						dbPrpPhead.getInfo(dbPool, endorseNo);
						blCPolicy.cancel(dbPool, policyno, "Y");
						blEndorse.cancel(dbPool, endorseNo);
						dbWfLog.deleteUWTrace(dbManager, endorseNo);
						dbPool.commitTransaction();
					} catch (Exception e) {
						dbPool.rollbackTransaction();
					}finally{
						dbManager.close();
						dbPool.close();//增加finally,保证数据库连接正常关闭
					}
				}
				// ------------------------------------------------------------
				// 保存赔款计算书信息
				//compensateDto.getPrpLcompensateDto().setFinallyFlag("1");
				UICompensateAction uiCompensateAction = new UICompensateAction();
				int vericLogNo = 0;
				if (workFlowViewHelper.checkDealDto(workFlowDto)) {
					// 增加对核保核赔系统的接口调用。
					if (swfLogDtoDealNode.getNodeStatus().equals("4")) {

						// modify by lixiang start at 2006-08-22
						// reason:直接保存业务数据导致工作流数据丢失，所以提交前需要暂时保存到正在处理的状态。
						// 提交前的暂时保存
						WorkFlowDto workFlowDtoTemp = null;
						swfLogDtoDealNode.setNodeStatus("2");
						workFlowDtoTemp = workFlowViewHelper.viewToDto(user,
								swfLogDtoDealNode);
						// 暂存计算书节点时将理算节点状态置为已处理
						UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
						SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(
								swfLogFlowID, LogNo);
						if (swfLogDto.getNodeType().equals("compe")) {
							swfLogDto.setNodeStatus("4");
							workFlowDtoTemp.setUpdate(true);
							workFlowDtoTemp.setUpdateSwfLog2Dto(swfLogDto);
						}
						
						// 如果提交核赔失败则状态为0
						compensateDto.getPrpLcompensateDto().setUnderWriteFlag(
								"0");
						uiCompensateAction.save(compensateDto, workFlowDtoTemp);

						// 如果提交核赔则状态为9
						if (httpServletRequest.getParameter("buttonSaveType")
								.equals("4")) {
							compensateDto.getPrpLcompensateDto()
									.setUnderWriteFlag("9");
						}
						// modify by lixiang end at 2006-08-22
						if (workFlowDto.getSubmitSwfLogDtoList() != null
								&& workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
							vericLogNo = ((SwfLogDto) workFlowDto
									.getSubmitSwfLogDtoList().get(0))
									.getLogNo();
						}

						// add end 2005-10-19
						UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade = new UIWorkFlowUWInterFaceFacade();
						String UWflowID = uiWorkFlowUWInterFaceFacade
								.submitVericTask(workFlowDto
										.getUpdateSwfLogDto().getFlowID(),
										vericLogNo + "", "22", "C",
										compensateDto.getPrpLcompensateDto()
												.getCompensateNo(),
										compensateDto.getPrpLcompensateDto()
												.getRiskCode(), compensateDto
												.getPrpLcompensateDto()
												.getClassCode(), compensateDto
												.getPrpLcompensateDto()
												.getComCode(), compensateDto
												.getPrpLcompensateDto()
												.getHandlerCode(),
										compensateDto.getPrpLcompensateDto()
												.getMakeCom(), user
												.getUserCode(), compensateDto
												.getPrpLcompensateDto()
												.getHandler1Code(), "");
						if (UWflowID.length() < 15) {
							String msg = "案件'" + compensateNo
									+ "'提交双核系统失败，请重新提交或者与管理员联系!";
							throw new UserException(1, 3, "工作流", msg);
						}

						// add by lixiang start at 2006-08-22
						// reason:直接保存业务数据导致工作流数据丢失，所以提交前需要暂时保存到正在处理的状态，但是发送双核成功后，需要变更成提交数据。
						if (newCompensate == 1) { // 要整理新的workFlowDto为提交的状态。
							// 休整 workFlowDtoTemp 和workFlowDto
							int newCompeLogNo = 0;
							if (workFlowDtoTemp.getSubmitSwfLogDtoList() != null) {
								newCompeLogNo = ((SwfLogDto) workFlowDtoTemp
										.getSubmitSwfLogDtoList().get(0))
										.getLogNo();
								((SwfLogDto) workFlowDtoTemp
										.getSubmitSwfLogDtoList().get(0))
										.setNodeStatus("4");
								workFlowDto.setUpdate(true);
								workFlowDto
										.setUpdateSwfLogDto((SwfLogDto) workFlowDtoTemp
												.getSubmitSwfLogDtoList()
												.get(0));
							}
							if (workFlowDto.getSubmitSwfLogDtoList() != null) {
								// 删除多余的点
								for (int i = 0; i < workFlowDto
										.getSubmitSwfLogDtoList().size(); i++) {
									if (((SwfLogDto) workFlowDto
											.getSubmitSwfLogDtoList().get(i))
											.getLogNo() == newCompeLogNo) {
										workFlowDto.getSubmitSwfLogDtoList()
												.remove(i);
										break;
									}

								}
							}

							if (workFlowDto.getSubmitSwfPathLogDtoList() != null) {
								// 删除多余的边
								for (int i = 0; i < workFlowDto
										.getSubmitSwfPathLogDtoList().size(); i++) {
									if (((SwfPathLogDto) workFlowDto
											.getSubmitSwfPathLogDtoList()
											.get(i)).getEndNodeNo() == newCompeLogNo) {
										workFlowDto
												.getSubmitSwfPathLogDtoList()
												.remove(i);
										break;
									}

								}
							}
							// add by lixiang end at 2006-08-22
						}

					}
					// 此处修改理算节点状态，主要在理算暂存时使用。
					UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(
							swfLogFlowID, LogNo);
					if (swfLogDto.getNodeType().equals("compe")) {
						swfLogDto.setNodeStatus("4");
						workFlowDto.setUpdate(true);
						workFlowDto.setUpdateSwfLog2Dto(swfLogDto);
					}
					//add by hu 20120116 begin Reason：内存检查
					remark = "理算书号："+compensateNo+" 保存开始";
					utils.getPhisicaMemory(remark);
					//add by hu 20120116 begin end：内存检查
					
					//上海意健险上传平台新增字段
					uiCompensateAction.save(compensateDto, workFlowDto);
					//add by hu 20120116 begin Reason：内存检查
					remark = "理算书号："+compensateNo+" 保存结束";
					utils.getPhisicaMemory(remark);
					//add by hu 20120116 begin end：内存检查
					// Modify by chenrenda begin 20070704
					// 给康振加上注释开发原因，间接理赔费用尾差处理
					/*
					 * 冯雷 GYNB-170 国元版本不需要间接理赔费用 start
					 */
					// chargeAmount = sumPaid*0.025;
					// BLPrpLchargeFacade blPrpLchargeFacade = new
					// BLPrpLchargeFacade();
					// String conditions = "chargeCode = '28' and compensateno =
					// '" +
					// compensateDto.getPrpLcompensateDto().getCompensateNo()+"'
					// order by serialNo";
					// Collection prpLcharge28DtoList =
					// blPrpLchargeFacade.findByConditions(conditions);
					// if(prpLcharge28DtoList.size()==1){}
					// else{
					// BLPrpLchargeFacade blPrpLchargeFacade1 = new
					// BLPrpLchargeFacade();
					// int maxSerialNo =
					// blPrpLchargeFacade1.getMaxSerialNo(conditions);
					// Iterator iterator1 = prpLcharge28DtoList.iterator();
					// double chargeAmount28 = 0;
					// while(iterator1.hasNext()){
					// PrpLchargeDto prpLchargeDtoTemp = (PrpLchargeDto)
					// iterator1.next();
					// if(prpLchargeDtoTemp.getSerialNo()!=maxSerialNo){
					// chargeAmount28 += prpLchargeDtoTemp.getChargeAmount();
					// }
					// }
					// PrpLchargeDto prpLchargeDtoTemp =
					// blPrpLchargeFacade1.findByPrimaryKey(compensateNo,
					// maxSerialNo);
					// prpLchargeDtoTemp.setSumRealPay(chargeAmount-chargeAmount28);
					// prpLchargeDtoTemp.setChargeAmount(chargeAmount-chargeAmount28);
					// blPrpLchargeFacade1.update(prpLchargeDtoTemp);
					// }
					/*
					 * 冯雷 GYNB-170 国元版本不需要间接理赔费用 end
					 */
					// //Modify by chenrenda end 20070704
					compensateDto.getPrpLcompensateDto().setRemark("remark");
					user.setUserMessage(compensateNo);
				} else {
					uiCompensateAction.save(compensateDto);
					user
							.setUserMessage(compensateNo
									+ ";注意:没有发现与工作流流程相关任何数据！！");
				}
				
				//获取计算书号
				String compensateNo1 = compensateDto.getPrpLcompensateDto().getCompensateNo();
				//判断是否需要现金赔款
				getControlFlag(claimDto,sumPaid,compensateNo1);

				httpServletRequest.setAttribute("prpLcompensateDto",
						compensateDto.getPrpLcompensateDto());
				//理算保存向理赔清单回写理算书号
				if(null!=compensateDto.getPrpLcompensateDto()&&null!=compensateDto.getPrpLcompensateDto().getRiskCode()&&!"".equals(compensateDto.getPrpLcompensateDto().getRiskCode())
						&&"0311,3101,3107,3108,3114,3122,3126,3143,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3148,3174,3150,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3177,3163,3168,3169,3182".indexOf(compensateDto.getPrpLcompensateDto().getRiskCode())>-1){
					if(!"".equals(settleListCode)&&null!=settleListCode){
					BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
					SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
					settlemainlistDto=blSettlemainlistFacade.findByPrimaryKey(settleListCode);
					settlemainlistDto.setCompensateno(compensateDto.getPrpLcompensateDto().getCompensateNo());
					blSettlemainlistFacade.update(settlemainlistDto);
					}
				}
				if(null!=compensateDto.getPrpLcompensateDto()&&null!=compensateDto.getPrpLcompensateDto().getRiskCode()&&!"".equals(compensateDto.getPrpLcompensateDto().getRiskCode())
						&&"2801".indexOf(compensateDto.getPrpLcompensateDto().getRiskCode())>-1){
					if(!"".equals(settleListCode)&&null!=settleListCode){
					BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
					SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
					settlemainlistDto=blSettlemainlistFacadeForMedical.findByPrimaryKey(settleListCode);
					settlemainlistDto.setCompensateno(compensateDto.getPrpLcompensateDto().getCompensateNo());
					blSettlemainlistFacadeForMedical.update(settlemainlistDto);
					}
				}
				if(null!=compensateDto.getPrpLcompensateDto()&&null!=compensateDto.getPrpLcompensateDto().getRiskCode()&&!"".equals(compensateDto.getPrpLcompensateDto().getRiskCode())
						&&"2607".indexOf(compensateDto.getPrpLcompensateDto().getRiskCode())>-1){
					if(!"".equals(settleListCode)&&null!=settleListCode){
					BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
					SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
					settlemainlistDto=blSettlemainlistFacadeForMedical.findByPrimaryKey(settleListCode);
					settlemainlistDto.setCompensateno(compensateDto.getPrpLcompensateDto().getCompensateNo());
					blSettlemainlistFacadeForMedical.update(settlemainlistDto);
					}
				}
				if(null!=compensateDto.getPrpLcompensateDto()&&null!=compensateDto.getPrpLcompensateDto().getRiskCode()&&!"".equals(compensateDto.getPrpLcompensateDto().getRiskCode())
						&&"2605".indexOf(compensateDto.getPrpLcompensateDto().getRiskCode())>-1){
					if(!"".equals(settleListCode)&&null!=settleListCode){
					BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
					SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
					settlemainlistDto=blSettlemainlistFacadeForMedical.findByPrimaryKey(settleListCode);
					settlemainlistDto.setCompensateno(compensateDto.getPrpLcompensateDto().getCompensateNo());
					blSettlemainlistFacadeForMedical.update(settlemainlistDto);
					}
				}
				if(null!=compensateDto.getPrpLcompensateDto()&&null!=compensateDto.getPrpLcompensateDto().getRiskCode()&&!"".equals(compensateDto.getPrpLcompensateDto().getRiskCode())
						&&"2606".indexOf(compensateDto.getPrpLcompensateDto().getRiskCode())>-1){
					if(!"".equals(settleListCode)&&null!=settleListCode){
					BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
					SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
					settlemainlistDto=blSettlemainlistFacadeForMedical.findByPrimaryKey(settleListCode);
					settlemainlistDto.setCompensateno(compensateDto.getPrpLcompensateDto().getCompensateNo());
					blSettlemainlistFacadeForMedical.update(settlemainlistDto);
					}
				}
				if(null!=compensateDto.getPrpLcompensateDto()&&null!=compensateDto.getPrpLcompensateDto().getRiskCode()&&!"".equals(compensateDto.getPrpLcompensateDto().getRiskCode())
						&&"2609".indexOf(compensateDto.getPrpLcompensateDto().getRiskCode())>-1){
					if(!"".equals(settleListCode)&&null!=settleListCode){
					BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
					SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
					settlemainlistDto=blSettlemainlistFacadeForMedical.findByPrimaryKey(settleListCode);
					settlemainlistDto.setCompensateno(compensateDto.getPrpLcompensateDto().getCompensateNo());
					blSettlemainlistFacadeForMedical.update(settlemainlistDto);
					}
				}
				
				//上一环节以缮制清单，本环节未缮制直接点击保存,需要将清单子表数据变更节点状态转储
				if(("3101,3107,3108,3122,3114,3126,3143,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3148,3174,3150,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3177".indexOf(riskCode) > -1)){
					if(!"".equals(settleListCode)&&null!=settleListCode){
					PlantingsettlelistDto plantingsettlelistDto=null;
					BLPlantingsettlelistFacade blPlantingsettlelist=new BLPlantingsettlelistFacade();
					String strCondition=" settleListCode='"+settleListCode+"' and nodetype='compe'";
					String strCondition1=" settleListCode='"+settleListCode+"' and nodetype='claim'";
					Collection plantingsettlelist=blPlantingsettlelist.findByConditions(strCondition);
					ArrayList plantingsettlelist1=(ArrayList)blPlantingsettlelist.findByConditions(strCondition1);
					ArrayList arrPlantingsettlelist=new ArrayList();
					if(plantingsettlelist.size()<1){
						if(plantingsettlelist1.size()>=1){
							for(int i=0;i<plantingsettlelist1.size();i++){
							plantingsettlelistDto=new PlantingsettlelistDto();
							plantingsettlelistDto=(PlantingsettlelistDto)plantingsettlelist1.get(i);
							plantingsettlelistDto.setNodetype("compe");
							arrPlantingsettlelist.add(plantingsettlelistDto);
							}
							remark = "中央政策性种植险 理赔清单号："+settleListCode+" 将清单子表数据变更节点状态转储 begin";
							utils.getPhisicaMemory(remark);
							blPlantingsettlelist.insert(arrPlantingsettlelist);
							remark = "中央政策性种植险 理赔清单号："+settleListCode+" 将清单子表数据变更节点状态转储 end";
							utils.getPhisicaMemory(remark);
						}		
					}
					}
				}
				//yx
				//if("3224".equals(riskCode)){
				if("3224,3201,3204,3238,3215,3228,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode)>-1){
					if(!"".equals(settleListCode)&&null!=settleListCode){
				    NyxsettlelistDto nyxsettlelistDto=null;
				    BLNyxsettlelistFacade blNyxsettlelistFacade=new BLNyxsettlelistFacade();
					String strCondition=" settleListCode='"+settleListCode+"' and nodetype='compe'";
					String strCondition1=" settleListCode='"+settleListCode+"' and nodetype='claim'";
					Collection plantingsettlelist=blNyxsettlelistFacade.findByConditions(strCondition);
					ArrayList plantingsettlelist1=(ArrayList)blNyxsettlelistFacade.findByConditions(strCondition1);
					ArrayList arrPlantingsettlelist=new ArrayList();
					if(plantingsettlelist.size()<1){
						if(plantingsettlelist1.size()>=1){
							for(int i=0;i<plantingsettlelist1.size();i++){
								nyxsettlelistDto=new NyxsettlelistDto();
								nyxsettlelistDto=(NyxsettlelistDto)plantingsettlelist1.get(i);
								nyxsettlelistDto.setNodetype("compe");
							arrPlantingsettlelist.add(nyxsettlelistDto);
							}
							remark = "淡水鱼 理赔清单号："+settleListCode+" 将清单子表数据变更节点状态转储 begin";
							utils.getPhisicaMemory(remark);
							blNyxsettlelistFacade.insert(arrPlantingsettlelist);
							remark = "淡水鱼 理赔清单号："+settleListCode+" 将清单子表数据变更节点状态转储 end";
							utils.getPhisicaMemory(remark);
						}		
					}
					}
				}
				
				
				
				
				
				//中央政策性种植险理赔回写 农户电子档案信息
				if(null!=compensateDto.getPrpLcompensateDto()&&null!=compensateDto.getPrpLcompensateDto().getRiskCode()&&!"".equals(compensateDto.getPrpLcompensateDto().getRiskCode())
						&&"3101,3107,3108,3114,3122,3126,3143,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3148,3174,3150,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3177,3163,3168,3169,3182".indexOf(compensateDto.getPrpLcompensateDto().getRiskCode())>-1){
					String claimRelateNo = "";//理赔清单号
					String strClaimNo = "";//立案号
					String strRegistNo = "";//报案号
					String strCompensateNo = "";//理算书号
					claimRelateNo = compensateDto.getPrpLcompensateDto().getClaimRelationNo();
					strClaimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
					strCompensateNo = compensateDto.getPrpLcompensateDto().getCompensateNo();
					if(null!=strClaimNo&&!"".equals(strClaimNo)){
						PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(strClaimNo);
						if(null!=prpLclaimDto){
							strRegistNo = prpLclaimDto.getRegistNo();
						}
					}
					if(null!=claimRelateNo&&!"".equals(claimRelateNo)){
						new BLPrpLcompensateFacade().update(strRegistNo, strClaimNo, strCompensateNo, claimRelateNo);
					}
				}
				//非中央政策性险种理算保存向理赔清单回写理算书号
				if(null!=compensateDto.getPrpLcompensateDto()&&null!=compensateDto.getPrpLcompensateDto().getRiskCode()&&!"".equals(compensateDto.getPrpLcompensateDto().getRiskCode())){
		            String planting31FarmerListFlag = SysConfig.getProperty("PLNATING_31_FARMER_LIST_FLAG","claim");
					if(!"".equals(settleListCode)&&null!=settleListCode&& null!=planting31FarmerListFlag && planting31FarmerListFlag.indexOf(compensateDto.getPrpLcompensateDto().getRiskCode())>-1){
						BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
						SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
						settlemainlistDto=blSettlemainlistFacade.findByPrimaryKey(settleListCode);
						settlemainlistDto.setRegistercode(compensateDto.getPrpLcompensateDto().getClaimNo());
						settlemainlistDto.setCompensateno(compensateDto.getPrpLcompensateDto().getCompensateNo());
						blSettlemainlistFacade.update(settlemainlistDto);
					}
				}
				if(null!=compensateDto.getPrpLcompensateDto()&&null!=compensateDto.getPrpLcompensateDto().getRiskCode()&&!"".equals(compensateDto.getPrpLcompensateDto().getRiskCode()))
				{
					String classCodeForTemp = compensateDto.getPrpLcompensateDto().getRiskCode().substring(0, 2);
					//String registNoForTemp = compensateDto.getPrpLcompensateDto().getRegistNo();
					//System.err.println("自动立案：" + registNoForTemp);
					
					if("32".equals(classCodeForTemp))
					{
						BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
						boolean isautoclaim = blPrpLclaimFacade.IsAutoClaim(ClaimNo);
						
						if(isautoclaim)
						{
							BLPrpLclaimLossFacade blPrpLclaimLossFacade = new BLPrpLclaimLossFacade();
							BLPrpLpropFacade blPrpLpropFacade = new BLPrpLpropFacade();
							BLPrpLverifyLossFacade blPrpLverifyLossFacade = new BLPrpLverifyLossFacade();
							PrpLclaimDto claimDtoForTemp = blPrpLclaimFacade.findByPrimaryKey(ClaimNo);
							String registNoForTemp = claimDtoForTemp.getRegistNo();
							PrpLclaimLossDto claimlossDtoForTemp = blPrpLclaimLossFacade.findByPrimaryKey(ClaimNo, 1);
							PrpLverifyLossDto verifyLossDtoForTemp = blPrpLverifyLossFacade.findByPrimaryKey(registNoForTemp, "-2");
							PrpLpropDto propDtoForTemp = blPrpLpropFacade.findByPrimaryKey(1, registNoForTemp);
							
							if(null != claimDtoForTemp)
							{
								claimDtoForTemp.setSumClaim(compensateDto.getPrpLcompensateDto().getSumThisPaid());
								claimDtoForTemp.setLossesNumber(compensateDto.getPrpLcompensateDto().getLossesNumber());
								claimDtoForTemp.setDamageInsured(compensateDto.getPrpLcompensateDto().getDamageInsured());
								claimDtoForTemp.setDeathQuantity(compensateDto.getPrpLcompensateDto().getDeathQuantity());
								claimDtoForTemp.setKillQuantity(compensateDto.getPrpLcompensateDto().getKillQuantity());
								
								blPrpLclaimFacade.update(claimDtoForTemp);
							}
							if(null != claimlossDtoForTemp)
							{
								claimlossDtoForTemp.setKindLoss(compensateDto.getPrpLcompensateDto().getSumThisPaid());
								claimlossDtoForTemp.setSumClaim(compensateDto.getPrpLcompensateDto().getSumThisPaid());
								blPrpLclaimLossFacade.update(claimlossDtoForTemp);
								
							}
							if(null != verifyLossDtoForTemp)
							{
								boolean needupdate = false;
								double lossesNumbertemp = verifyLossDtoForTemp.getLossesNumber();
								//System.err.println("lossesNumbertemp：" + registNoForTemp);
								
								if(lossesNumbertemp == 0)
								{
									verifyLossDtoForTemp.setLossesNumber(compensateDto.getPrpLcompensateDto().getLossesNumber());
									needupdate = true;
								}
								
								double damageInsuredtemp = verifyLossDtoForTemp.getDamageInsured();
								
								if(damageInsuredtemp == 0)
								{
									verifyLossDtoForTemp.setDamageInsured(compensateDto.getPrpLcompensateDto().getDamageInsured());
									needupdate = true;
								}
								
								double DeathQuantitytemp = verifyLossDtoForTemp.getDeathQuantity();
								if(DeathQuantitytemp == 0)
								{
									verifyLossDtoForTemp.setDeathQuantity(compensateDto.getPrpLcompensateDto().getDeathQuantity());
									needupdate = true;
								}
								
								double KillQuantitytemp = verifyLossDtoForTemp.getKillQuantity();
								if(KillQuantitytemp == 0)
								{
									verifyLossDtoForTemp.setKillQuantity(compensateDto.getPrpLcompensateDto().getKillQuantity());
									needupdate = true;
								}
								
								if(needupdate)
								{
									blPrpLverifyLossFacade.update(verifyLossDtoForTemp);
								}
							}
							
							if(null != propDtoForTemp)
							{
								double sumlosstemp = propDtoForTemp.getSumLoss();
								if(sumlosstemp == 0)
								{
									propDtoForTemp.setSumLoss(compensateDto.getPrpLcompensateDto().getSumThisPaid());
									propDtoForTemp.setSumDefLoss(compensateDto.getPrpLcompensateDto().getSumThisPaid());
									blPrpLpropFacade.update(propDtoForTemp);
									
								}
							}
							
							
						}
					}
				}
				//重新进行危险单位生成===begain 2017-08-16
				if(compensateDto.getPrplRiskUnitDtoList() != null && compensateDto.getPrplRiskUnitDtoList().size() > 0){
				}else{
					DBManager dbManager1 = new DBManager();
					BLLDangerGetAction ldangerGetAction = new BLLDangerGetAction();
					try{
			            dbManager1.open(AppConfig.get("sysconst.REINS_JNDI"));
			            dbManager1.beginTransaction();
			            //重新生成
			            ldangerGetAction.getLDangerInfoNewC(compensateNo, dbManager1);
			            dbManager1.commitTransaction();
			        }catch(Exception exception){
			            dbManager1.rollbackTransaction();
			            throw exception;
			        }finally{
			            dbManager1.close();
			        }
				}
				//重新进行危险单位生成===end
			} else {
				throw new UserException(1, 3, "工作流", "请不要重复提交");
			}
			ActionMessages messages = new ActionMessages();

			if (httpServletRequest.getParameter("buttonSaveType").trim()
					.equals("4")) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.compensate.submit"));
			} else {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.compensate.save"));
			}
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"db.prpLcompensate.compensateNo"));
			saveMessages(httpServletRequest, messages);

			String buttonSaveType = httpServletRequest.getParameter(
					"buttonSaveType").trim();
			httpServletRequest.setAttribute("compensateNo", compensateNo);
			httpServletRequest.setAttribute("isCompensate", isCompensate);
			httpServletRequest.setAttribute("isNew", isNew);
			httpServletRequest.setAttribute("buttonSaveType", buttonSaveType);

			forward = "success";
			String printFlag = httpServletRequest
					.getParameter("prpLcompensatePrintFlag");
			if (printFlag != null && printFlag.trim().equals("1")) {
				httpServletResponse
						.sendRedirect("/claim/ClaimPrint.do?printType=Compensate&CompensateNo="
								+ compensateNo);
			}
			
			
		} catch (UserException usee) {
			usee.printStackTrace();
			// 错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage(
					"title.compensateBeforeEdit.editCompensate");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee
					.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			// 错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage(
					"title.compensateBeforeEdit.editCompensate");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		}
		return actionMapping.findForward(forward);
	}
	/**
	 * 将页面中的出险人信息转化为dto
	 * @param httpServletRequest
	 */
	private PrpLinjuryPersonDto viewToDto(HttpServletRequest httpServletRequest) {
		String injuryPersonName = (String)httpServletRequest.getParameter("injuryPersonName");
		String injuryPersonGender = (String)httpServletRequest.getParameter("injuryPersonGender");
		String injuryPersonIdNum = (String)httpServletRequest.getParameter("injuryPersonIdNum");
		PrpLinjuryPersonDto prpLinjuryPerson = new PrpLinjuryPersonDto();
		prpLinjuryPerson.setAcciName(injuryPersonName);
		prpLinjuryPerson.setSex(injuryPersonGender);
		prpLinjuryPerson.setIdentifyNumber(injuryPersonIdNum);
		prpLinjuryPerson.setCompensateNo((String)httpServletRequest.getAttribute("compensateNo"));
		return prpLinjuryPerson;
	}
	/**
	 * 理算环节确认是否需要现金赔款
	 * @param ClaimDto 立案Dto
	 * @return String 提示信息:是否需要现金赔款、共同理赔
	 */
	private String getControlFlag(ClaimDto claimDto,double sumPaid,String compensateNo1) {
		String setControlFlagMsg = ""; //返回提示信息
		String reinsMode = ""; //分保方式 [1]=2：合约
		String treatyNo = ""; //合约编码
		String strControlFlag = ""; //是否“共同理赔/理赔控制”
		String strCashLossFlag = ""; //"1"为"立案(合约)估损，"0"为"危险单位估损"
		boolean blnCashLoss = false;
		PrpCreinsTrialDto prpCreinsTrialDto = new PrpCreinsTrialDto();
		BLFhTreatyFacade blFhTreatyFacade = new BLFhTreatyFacade();
		FhTreatyDto fhTreatyDto = new FhTreatyDto();
		BLCTrialFacade blCTrialFacade = new BLCTrialFacade();

		try {
			CReinsTrialDto cReinsTrialDto = blCTrialFacade.getCTrialInfo(
					claimDto.getPrpLclaimDto().getPolicyNo(), 
					1, 
					claimDto.getPrpLclaimDto().getDamageStartDate().toString()
					);

			ArrayList prpCreinsTrialDtoList = (ArrayList) cReinsTrialDto.getPrpCreinsTrialDtoList();
			Iterator itTrial = prpCreinsTrialDtoList.iterator();
			boolean flag = false; 
			ArrayList cTrialList = new ArrayList();
			while (itTrial.hasNext()) {
				prpCreinsTrialDto = (PrpCreinsTrialDto) itTrial.next();
				reinsMode = prpCreinsTrialDto.getReinsMode().substring(0, 1);
				if (reinsMode.equals("2")) { //为合约分保
					flag = false; 
					treatyNo = prpCreinsTrialDto.getTreatyNo();
					//根据合约号到fhTreaty表中获取合约信息
					fhTreatyDto = blFhTreatyFacade.findByPrimaryKey(treatyNo);
					prpCreinsTrialDto.setTreatyNo(fhTreatyDto.getTreatyFormalNo());
					strControlFlag = fhTreatyDto.getControlFlag();
					if (strControlFlag == null
							|| "".equals(strControlFlag)
							|| strControlFlag.length() < 1) {
						continue;
					}
					if(!"".equals(fhTreatyDto.getCashLossFlag())){
						prpCreinsTrialDto.setFlag(fhTreatyDto.getControlFlag().substring(1,2)+fhTreatyDto.getCashLossFlag());
					}else{
						prpCreinsTrialDto.setFlag(fhTreatyDto.getControlFlag().substring(1,2)+"2");
					}
					prpCreinsTrialDto.setAmount(fhTreatyDto.getCashLossValue());
					Iterator itTrial1 = cTrialList.iterator();
					while (itTrial1.hasNext()) {
						PrpCreinsTrialDto trialDto = (PrpCreinsTrialDto) itTrial1.next();
						if(trialDto.getTreatyNo().equals(fhTreatyDto.getTreatyFormalNo())){
							trialDto.setShareRate(trialDto.getShareRate()+prpCreinsTrialDto.getShareRate());
							flag = true ; 
							break ; 
						}
					}
					if(flag == false){
						cTrialList.add(prpCreinsTrialDto);
					}
				}
			}
			if(cTrialList.size() > 0 ){
				Iterator it = cTrialList.iterator();
				while (it.hasNext()) {
					prpCreinsTrialDto = (PrpCreinsTrialDto) it.next();
					strControlFlag = prpCreinsTrialDto.getFlag().substring(0, 1);
					strCashLossFlag = prpCreinsTrialDto.getFlag().substring(1, 2);
					if("1".equals(strControlFlag)){
						if("0".equals(strCashLossFlag)){//整个案子的赔款
							if(sumPaid >= prpCreinsTrialDto.getAmount()){
								cashlossUpdate("1",compensateNo1);
								setControlFlagMsg = setControlFlagMsg + "此案需要现金赔款.";
								blnCashLoss = true;
							}else{
								cashlossUpdate("0",compensateNo1);
							}
						}else if("1".equals(strCashLossFlag)){
							if(sumPaid*prpCreinsTrialDto.getShareRate()/100 >= prpCreinsTrialDto.getAmount()){
								cashlossUpdate("1",compensateNo1);
								setControlFlagMsg = setControlFlagMsg + "此案需要现金赔款.";
								blnCashLoss = true;
							}
						}
					}
					if (blnCashLoss == true) {
						break;
					}
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return setControlFlagMsg;
	}
	/*
	 * 现金赔款通知标志的更新方法
	 */
	public void cashlossUpdate(String cashLossFlag,String compensateNo1){
		String cashClaimConditions = "update prpldangerunit p set p.cashlossflag = '"+cashLossFlag+"' where p.certiNo = '"+compensateNo1+"'";
		try {
			new BLPrpLdangerUnitFacade().updateByconditions(cashClaimConditions);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}