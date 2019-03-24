package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.claim.ui.model.CiClaimCompelcrashFindByConditionsCommand;
import com.sinosoft.claim.util.StringConvert;

public class UILAccidentInfoQueryFacade
	extends Action {
		public ActionForward execute(ActionMapping actionMapping,
				ActionForm actionForm, HttpServletRequest httpServletRequest,
				HttpServletResponse httpServletResponse) throws Exception {
		String forward = ""; // 向前流转
		try {
		    String nodeType = httpServletRequest.getParameter("nodeType");
			String accidentNo = httpServletRequest.getParameter("accidentNo");
			String aRegistNo = httpServletRequest.getParameter("myRegistNo");
			String bRegistNo = httpServletRequest.getParameter("otherRegistNo");
			System.out.println("======accidentNo==="+accidentNo);
			String editAccidentInfo = httpServletRequest
					.getParameter("editAccidentInfo");
			System.out.println("======editAccidentInfo==="+editAccidentInfo);
			System.out.println("====111==nodeType==1111="+nodeType);
			if (editAccidentInfo != null && editAccidentInfo.equals("edit")) {
				String conditions1 = "registNo='" + aRegistNo+"'";
//						+ "' and actorFlag='1'";
				CiClaimCompelcrashFindByConditionsCommand ciClaimCompelcrashFindByConditionsCommand1 = new CiClaimCompelcrashFindByConditionsCommand(
						conditions1);
				Collection ciClaimCompelcrashCollection1 = (Collection) ciClaimCompelcrashFindByConditionsCommand1
						.execute();
				for (Iterator it1 = ciClaimCompelcrashCollection1.iterator(); it1.hasNext();) {
					
					CiClaimCompelcrashDto ciClaimCompelcrashDto = (CiClaimCompelcrashDto) it1.next();
					httpServletRequest.setAttribute("aCiClaimCompelcrashDto",
							ciClaimCompelcrashDto);

				}
				
				String conditions2 = "registNo='" + aRegistNo+"'";
//						+ "' and actorFlag='2'";
				CiClaimCompelcrashFindByConditionsCommand ciClaimCompelcrashFindByConditionsCommand2 = new CiClaimCompelcrashFindByConditionsCommand(
						conditions2);
				Collection ciClaimCompelcrashCollection2 = (Collection) ciClaimCompelcrashFindByConditionsCommand2
						.execute();
				for (Iterator it2 = ciClaimCompelcrashCollection2.iterator(); it2
						.hasNext();) {
					CiClaimCompelcrashDto ciClaimCompelcrashDto = (CiClaimCompelcrashDto) it2
							.next();
					httpServletRequest.setAttribute("bCiClaimCompelcrashDto",
							ciClaimCompelcrashDto);
				}
				httpServletRequest.setAttribute("saveType","update");
				httpServletRequest.setAttribute("nodeType",nodeType);
				forward = "edit";
			} else {
				String conditions = "1=1";
				if (accidentNo.length() > 0) {
					conditions = conditions
							+ StringConvert.convertString("AccidentNo",
									accidentNo, httpServletRequest
											.getParameter("accidentSign"));
				}
				if (aRegistNo.length() > 0) {
					conditions = conditions
							+ StringConvert.convertString("RegistNo",
									aRegistNo, httpServletRequest
											.getParameter("reportMySign"));
					// + " and actorFlag='1'";
					if (bRegistNo.length() > 0) {
						conditions = conditions
								+ StringConvert.convertString(
										"RelatedRegistNo", bRegistNo,
										httpServletRequest
												.getParameter("otherSign"));
					}

				} else {
					if (bRegistNo.length() > 0) {
						conditions = conditions
								+ StringConvert.convertString(
										"RelatedRegistNo", bRegistNo,
										httpServletRequest
												.getParameter("otherSign"));
						// + " and actorFlag='2'";
					}
				}
				CiClaimCompelcrashFindByConditionsCommand ciClaimCompelcrashFindByConditionsCommand = new CiClaimCompelcrashFindByConditionsCommand(
						conditions);
				Collection ciClaimCompelcrashCollection = (Collection) ciClaimCompelcrashFindByConditionsCommand
						.execute();
				httpServletRequest.setAttribute("ciClaimCompelcrashCollection",
						ciClaimCompelcrashCollection);
				httpServletRequest.setAttribute("editType", "query");
				forward = "query";
				httpServletRequest.setAttribute("nodeType", nodeType);
			}

		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			// 错误信息处理
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
		System.out.println(forward);
		return actionMapping.findForward(forward);
	}
		
}
