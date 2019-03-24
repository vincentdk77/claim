package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLcertifyImgFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.image.bl.facade.BLPrpdcertifycheckFacade;
import com.sinosoft.image.bl.facade.BLPrpdimagecodeFacade;
import com.sinosoft.image.dto.domain.PrpdimagecodeDto;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utiall.dbsvr.DBPrpDcompany;
import com.sinosoft.utiall.dbsvr.DBPrpDuser;

public class UILClaimCancelCheckCertifyFacade extends Action {

	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = "";
		String conditions = "";
		PrintWriter printWriter = httpServletResponse.getWriter();
        //影像系统添加
		UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
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
        int t = 0;
        t = dbPrpDuser.getInfo(user.getUserCode());
        username=dbPrpDuser.getUserName();
        t = dbprpDcompany.getInfo(dbPrpDuser.getComCode());
        comcode = dbPrpDuser.getComCode();
        comname= dbprpDcompany.getComCName();
        String result = "";
        String imgRiskCode = "";//BusinessRuleUtil.getRiskCode(claimDto.getPrpLclaimDto().getClaimNo(),"RegistNo" );
        String caseType = "";
		try {
			String type = httpServletRequest.getParameter("type");// 1立案注销，2重开赔案
			if ("1".equals(type)) {
				String registNo = httpServletRequest.getParameter("registNo");
				imgRiskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo" );
//				conditions = " businessNo = '" + registNo
//						+ "'  and ValidStatus ='1' and typeCode ='0102' ";
			       if(imgRiskCode!=null)
			       {
			 		  prpdimagecodeDto = blPrpdimagecodeFacade.findByPrimaryKey(imgRiskCode,"0000000000");
					  role = prpdimagecodeDto.getClaimrole();
					  appcode=prpdimagecodeDto.getClaimcode();
					  appname=prpdimagecodeDto.getClaimname();
					  //String businessno= "1111111111";
					  String businessno = registNo;
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
						   caseType = httpServletRequest.getParameter("caseType");
						   if(caseType.equals("0") )
						   {
							   nodes = blPrpdcertifycheckFacade.findAllByPrimaryKey(imgRiskCode,"claim_close");
						   }else
						   {
							   nodes = blPrpdcertifycheckFacade.findAllByPrimaryKey(imgRiskCode,"claim_reject");
						   }
						   HashMap hm = blPrpdimagecodeFacade.imageNodeCheck(newxml,nodes);
						   strWaning = blPrpdcertifycheckFacade.checkMustUpload(nodes,hm);
						   if(!strWaning.equals(""))
						   {
							   forward = "1";
							   System.err.println(strWaning);
						   }
						}catch (Exception e){
						e.printStackTrace();
						throw e;
					}
					   
			       }
			} else if ("2".equals(type)) {
				String claimNo = httpServletRequest.getParameter("ClaimNo");
				BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				PrpLclaimDto prpLclaimDto = blPrpLclaimFacade
						.findByPrimaryKey(claimNo.trim());
				conditions = " businessNo = '" + prpLclaimDto.getRegistNo()
						+ "'  and ValidStatus ='1' and typeCode ='0105' ";
			}

//			BLPrpLcertifyImgFacade blPrpLcertifyImgFacade = new BLPrpLcertifyImgFacade();
//			ArrayList<PrpLcertifyImgDto> PrpLcertifyImgDtoList = (ArrayList<PrpLcertifyImgDto>) blPrpLcertifyImgFacade
//					.findByConditions(conditions);
//			if (null == PrpLcertifyImgDtoList
//					|| PrpLcertifyImgDtoList.size() == 0) {
//				forward = "1";
//			}
			printWriter.println(forward);

		} catch (UserException usee) {
			usee.printStackTrace();
			// 错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("照片是否上传");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", usee
					.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} catch (SQLException sqle) {
			StringWriter stringWriter = new StringWriter();
			sqle.printStackTrace(new PrintWriter(stringWriter));
			sqle.printStackTrace();
			// 错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("照片是否上传");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			// 错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("照片是否上传");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} finally {
			printWriter.close();
		}
		return null;
	}

}
