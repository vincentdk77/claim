/**
 * 
 */
package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLImpelCrashFacade;
import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormCrashPublicMethod;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashArgDto;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashDto;
import com.sinosoft.claimciplatform.dto.custom.Iconstants;
/**
 * @author sinosoft
 *
 */
public class UILBeforeImportCompelCrashInfoFacade 
extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = ""; //向前流转
		try {		
			String myRegistNo = (String) httpServletRequest
					.getParameter("ownRegistNo");
			String otherRegistNo = (String) httpServletRequest
					.getParameter("otherRegistNo");
			String nodeType = (String) httpServletRequest
					.getParameter("nodeType");
			CompelCrashArgDto compelCrashArgDto = new CompelCrashArgDto();
			compelCrashArgDto.setARegsitNo(myRegistNo);
			compelCrashArgDto.setBRegsitNo(otherRegistNo);
			compelCrashArgDto.setCiPlatFormCode("SH");// 需要改进，目前只针对上海
	    	CompelCrashDto compelCrashDto=new BLImpelCrashFacade().downLoad(Iconstants.RequstType.COMPELCRASH_DOWNLOAD,compelCrashArgDto);
	    	if (!compelCrashDto.getAccidentNo().equals("") && !nodeType.equals("add")) {
				if (Iconstants.ReturnType.SUCCESS.equals(compelCrashDto
						.getCompePlatFormRetrunParam().getResponseCode())) {
					CiClaimCompelcrashDto aCiClaimCompelcrashDto = BLCIClaimPlatFormCrashPublicMethod
							.trasferACiClaimCompelcrashDto(compelCrashDto);
					BLCIClaimPlatFormCrashPublicMethod
							.setCiClaimCompelcrashDtoPubInfo(
									aCiClaimCompelcrashDto, compelCrashDto);
					httpServletRequest.setAttribute("aCiClaimCompelcrashDto",
							aCiClaimCompelcrashDto);
					CiClaimCompelcrashDto bCiClaimCompelcrashDto = BLCIClaimPlatFormCrashPublicMethod
							.trasferBCiClaimCompelcrashDto(compelCrashDto);
					BLCIClaimPlatFormCrashPublicMethod
							.setCiClaimCompelcrashDtoPubInfo(
									bCiClaimCompelcrashDto, compelCrashDto);
					httpServletRequest.setAttribute("bCiClaimCompelcrashDto",
							bCiClaimCompelcrashDto);
					httpServletRequest.setAttribute("saveType","update");
					if(nodeType!=null && nodeType.equals("query")){
						httpServletRequest.setAttribute("nodeType",nodeType);
					}

					forward = "success";
				} else if (Iconstants.ReturnType.INVALID_INPUTDATA
						.equals(compelCrashDto.getCompePlatFormRetrunParam()
								.getResponseCode())) {
					// throw new UserException(1, 3,
					// "输入数据有误，无法返回正常值",compelCrashDto.getCompePlatFormRetrunParam().getErrorMessage());
					forward = "failde";
				} else {
					forward = "failde";
					// throw new UserException(1, 3, "未知错！",
					// compelCrashDto.getCompePlatFormRetrunParam().getErrorMessage());
				}
			} else {
				if(nodeType.equals("query")){
					httpServletRequest.setAttribute("nodeType","query");
				}
				if (Iconstants.ReturnType.SUCCESS
						.equals(compelCrashDto.getCompePlatFormRetrunParam()
								.getResponseCode())){
					CiClaimCompelcrashDto aCiClaimCompelcrashDto =new CiClaimCompelcrashDto();
					CiClaimCompelcrashDto bCiClaimCompelcrashDto =new CiClaimCompelcrashDto();
					aCiClaimCompelcrashDto.setComCode("AAIC01");
					aCiClaimCompelcrashDto.setRegistNo(myRegistNo);
					bCiClaimCompelcrashDto.setRegistNo(otherRegistNo);
					httpServletRequest.setAttribute("aCiClaimCompelcrashDto",
							aCiClaimCompelcrashDto);
					httpServletRequest.setAttribute("bCiClaimCompelcrashDto",
							bCiClaimCompelcrashDto);
					forward = "success";
				}else{
					forward = "failde";
				}
				
			}
			httpServletRequest.setAttribute("editType", "query");

			// }catch (UserException usee) {
			// usee.printStackTrace();
			// //错误信息处理
			// ActionMessages errors = new ActionMessages();
			// ActionMessage error = new
			// ActionMessage("title.compensateBeforeEdit.editCompensate");
			// errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			// httpServletRequest.setAttribute("errorMessage",
			// usee.getErrorMessage());
			//			saveErrors(httpServletRequest, errors);
			//			forward = "error";

		}  catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.claimBeforeEdit.editClaim");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} finally {

		}
		return actionMapping.findForward(forward);
	}
}
