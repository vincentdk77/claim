package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLImpelCrashFacade;
import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.claim.ui.model.CiClaimCompelcrashFindByConditionsCommand;
import com.sinosoft.claim.ui.model.CiClaimCompelcrashInsertCommand;
import com.sinosoft.claim.ui.model.CiClaimCompelcrashUpdateCommand;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.claimciplatform.dto.custom.CompePlatFormRetrunParam;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashAccidentInfor;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashDto;
import com.sinosoft.claimciplatform.dto.custom.Iconstants;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;

public class UILUploadImportCompelCrashInfoFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = ""; // 向前流转
		try {
			String editType = httpServletRequest.getParameter("editType");
			String saveType = httpServletRequest.getParameter("saveType");
			CiClaimCompelcrashDto aCiClaimCompelcrashDto = getACiClaimCompelcrashDto(httpServletRequest);
			setBCiClaimCompelcrashDto(aCiClaimCompelcrashDto,
					httpServletRequest);
			CiClaimCompelcrashDto bCiClaimCompelcrashDto = getBCiClaimCompelcrashDto(httpServletRequest);
			setBCiClaimCompelcrashDto(bCiClaimCompelcrashDto,
					httpServletRequest);

			if ("upload".equals(editType)) {
				CompelCrashDto compelCrashDto = new CompelCrashDto();
				CompelCrashAccidentInfor aAccidentInfo = getAAccidentInfo(httpServletRequest);
				CompelCrashAccidentInfor bAccidentInfo = getBAccidentInfo(httpServletRequest);
				compelCrashDto.setOwnAccidentInfor(aAccidentInfo);
				compelCrashDto.setOtherAccidentInfor(bAccidentInfo);
				CompePlatFormRetrunParam compePlatFormRetrunParam = new CompePlatFormRetrunParam();
				compePlatFormRetrunParam.setCiPlatFormCode("SH");
				compelCrashDto
						.setCompePlatFormRetrunParam(compePlatFormRetrunParam);
				getOtherInfo(compelCrashDto, httpServletRequest);
				try {
					ClaimCiPlatFormException claimCiPlatFormException = new BLImpelCrashFacade()
							.upLoad(Iconstants.RequstType.COMPELCRASH_UPLOAD,
									compelCrashDto);
					aCiClaimCompelcrashDto.setAccidentNo(compelCrashDto
							.getAccidentNo());
					bCiClaimCompelcrashDto.setAccidentNo(compelCrashDto
							.getAccidentNo());
				} catch (ClaimCiPlatFormException e) {
					throw new UserException(1, 3, "工作流", e.toString());
				}

				// httpServletRequest.setAttribute("CIPLATFORMPARAM","上传成功！");
				forward = "success";

			}// if("save".equals(editType)){
			String conditions = "registNo='"
					+ aCiClaimCompelcrashDto.getRegistNo()
					+ "' and relatedRegistNo='"
					+ bCiClaimCompelcrashDto.getRegistNo() + "'";
			CiClaimCompelcrashFindByConditionsCommand ciClaimCompelcrashFindByConditionsCommand = new CiClaimCompelcrashFindByConditionsCommand(
					conditions);
			Collection ciClaimCompelcrashDtoCollection = (Collection) ciClaimCompelcrashFindByConditionsCommand
					.execute();
			if (saveType != null && saveType.equals("update")&&ciClaimCompelcrashDtoCollection != null
					&& ciClaimCompelcrashDtoCollection.size() > 0) {
				CiClaimCompelcrashUpdateCommand aCiClaimCompelcrashUpdateCommand = new CiClaimCompelcrashUpdateCommand(
						aCiClaimCompelcrashDto);
				aCiClaimCompelcrashUpdateCommand.execute();
				CiClaimCompelcrashUpdateCommand bCiClaimCompelcrashUpdateCommand = new CiClaimCompelcrashUpdateCommand(
						bCiClaimCompelcrashDto);
				bCiClaimCompelcrashUpdateCommand.execute();
			} else {
				if (ciClaimCompelcrashDtoCollection != null
						&& ciClaimCompelcrashDtoCollection.size() > 0) {
					CiClaimCompelcrashUpdateCommand aCiClaimCompelcrashUpdateCommand = new CiClaimCompelcrashUpdateCommand(
							aCiClaimCompelcrashDto);
					aCiClaimCompelcrashUpdateCommand.execute();
					CiClaimCompelcrashUpdateCommand bCiClaimCompelcrashUpdateCommand = new CiClaimCompelcrashUpdateCommand(
							bCiClaimCompelcrashDto);
					bCiClaimCompelcrashUpdateCommand.execute();
				} else {
					CiClaimCompelcrashInsertCommand aCiClaimCompelcrashInsertCommand = new CiClaimCompelcrashInsertCommand(
							aCiClaimCompelcrashDto);
					aCiClaimCompelcrashInsertCommand.executeCommand();
					CiClaimCompelcrashInsertCommand bCiClaimCompelcrashInsertCommand = new CiClaimCompelcrashInsertCommand(
							bCiClaimCompelcrashDto);
					bCiClaimCompelcrashInsertCommand.executeCommand();
				}
			}
			// }else
			forward = "success";
			// forward = "save";
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

	private CompelCrashAccidentInfor getAAccidentInfo(
			HttpServletRequest httpServletRequest) {
		CompelCrashAccidentInfor aAccidentInfo = new CompelCrashAccidentInfor();
		aAccidentInfo.setName(httpServletRequest.getParameter("JiaName"));
		aAccidentInfo.setIdNo(httpServletRequest.getParameter("jiaSelfCode"));
		aAccidentInfo.setCarMark(httpServletRequest.getParameter("jiaCarCode"));
		aAccidentInfo.setVehicleType(httpServletRequest
				.getParameter("jiaCarCodeKind"));
		aAccidentInfo.setVehicleModel(httpServletRequest
				.getParameter("jiaCarKind"));
		aAccidentInfo.setTelNo(httpServletRequest.getParameter("JiaAllPhone"));
		aAccidentInfo.setPolicyCode(httpServletRequest
				.getParameter("jiaInsureCode"));
		aAccidentInfo.setCompanyCode(httpServletRequest
				.getParameter("jiaInsureCOM"));
		aAccidentInfo.setPolicyCode(httpServletRequest
				.getParameter("jiaInsureCode"));
		aAccidentInfo.setReportNo(httpServletRequest
				.getParameter("jiaReportCode"));
		aAccidentInfo.setDamagePart(httpServletRequest
				.getParameter("jiaLossPart"));
		return aAccidentInfo;
	}

	private CompelCrashAccidentInfor getBAccidentInfo(
			HttpServletRequest httpServletRequest) {
		CompelCrashAccidentInfor bAccidentInfo = new CompelCrashAccidentInfor();
		bAccidentInfo.setName(httpServletRequest.getParameter("yiName"));
		bAccidentInfo.setIdNo(httpServletRequest.getParameter("yiSelfCode"));
		bAccidentInfo.setCarMark(httpServletRequest.getParameter("yiCarCode"));
		bAccidentInfo.setPolicyCode(httpServletRequest
				.getParameter("yiInsureCode"));
		bAccidentInfo.setVehicleType(httpServletRequest
				.getParameter("yiCarCodeKind"));
		bAccidentInfo.setVehicleModel(httpServletRequest
				.getParameter("yiCarKind"));
		bAccidentInfo.setTelNo(httpServletRequest.getParameter("yiAllPhone"));
		bAccidentInfo.setCompanyCode(httpServletRequest
				.getParameter("yiInsureCOM"));
		bAccidentInfo.setPolicyCode(httpServletRequest
				.getParameter("yiInsureCode"));
		bAccidentInfo.setReportNo(httpServletRequest
				.getParameter("yiReportCode"));
		bAccidentInfo.setDamagePart(httpServletRequest
				.getParameter("yiLossPart"));
		return bAccidentInfo;
	}

	private void getOtherInfo(CompelCrashDto compelCrashDto,
			HttpServletRequest httpServletRequest) {
		compelCrashDto.setFaultParty(httpServletRequest
				.getParameter("faultSide"));
		compelCrashDto.setFaultBehavior(httpServletRequest
				.getParameter("faultAction"));
		compelCrashDto.setAccidentTime(httpServletRequest.getParameter("time"));
		compelCrashDto.setAccidentPlace(httpServletRequest
				.getParameter("address"));
		compelCrashDto.setReportTime(httpServletRequest
				.getParameter("registTime"));
		compelCrashDto.setApplyAssessmentTime(httpServletRequest
				.getParameter("lossApplyTime"));
		compelCrashDto.setAssessStartTime(httpServletRequest
				.getParameter("lossStartTime"));
	}

	private CiClaimCompelcrashDto getACiClaimCompelcrashDto(
			HttpServletRequest httpServletRequest) {
		CiClaimCompelcrashDto aCiClaimCompelcrashDto = new CiClaimCompelcrashDto();
		aCiClaimCompelcrashDto.setDriverName(httpServletRequest
				.getParameter("JiaName"));
		aCiClaimCompelcrashDto.setIdNo(httpServletRequest
				.getParameter("jiaSelfCode"));
		aCiClaimCompelcrashDto.setCarNo(httpServletRequest
				.getParameter("jiaCarCode"));
		aCiClaimCompelcrashDto.setCarKind(httpServletRequest
				.getParameter("jiaCarCodeKind"));
		aCiClaimCompelcrashDto.setTelNo(httpServletRequest
				.getParameter("JiaAllPhone"));
		aCiClaimCompelcrashDto.setComCode(httpServletRequest
				.getParameter("jiaInsureCOM"));
		aCiClaimCompelcrashDto.setPolicyNo(httpServletRequest
				.getParameter("jiaInsureCode"));
		aCiClaimCompelcrashDto.setRegistNo(httpServletRequest
				.getParameter("jiaReportCode"));
		aCiClaimCompelcrashDto.setRelatedRegistNo(httpServletRequest
				.getParameter("yiReportCode"));
		aCiClaimCompelcrashDto.setActorFlag("01");
		aCiClaimCompelcrashDto.setDamagePart(httpServletRequest
				.getParameter("jiaLossPart"));
		return aCiClaimCompelcrashDto;
	}

	private CiClaimCompelcrashDto getBCiClaimCompelcrashDto(
			HttpServletRequest httpServletRequest) {
		CiClaimCompelcrashDto bCiClaimCompelcrashDto = new CiClaimCompelcrashDto();
		bCiClaimCompelcrashDto.setDriverName(httpServletRequest
				.getParameter("yiName"));
		bCiClaimCompelcrashDto.setIdNo(httpServletRequest
				.getParameter("yiSelfCode"));
		bCiClaimCompelcrashDto.setCarNo(httpServletRequest
				.getParameter("yiCarCode"));
		bCiClaimCompelcrashDto.setCarKind(httpServletRequest
				.getParameter("yiCarCodeKind"));
		bCiClaimCompelcrashDto.setTelNo(httpServletRequest
				.getParameter("yiAllPhone"));
		bCiClaimCompelcrashDto.setComCode(httpServletRequest
				.getParameter("yiInsureCOM"));
		bCiClaimCompelcrashDto.setPolicyNo(httpServletRequest
				.getParameter("yiInsureCode"));
		bCiClaimCompelcrashDto.setRegistNo(httpServletRequest
				.getParameter("yiReportCode"));
		bCiClaimCompelcrashDto.setRelatedRegistNo(httpServletRequest
				.getParameter("jiaReportCode"));
		bCiClaimCompelcrashDto.setActorFlag("02");
		bCiClaimCompelcrashDto.setDamagePart(httpServletRequest
				.getParameter("yiLossPart"));
		return bCiClaimCompelcrashDto;
	}

	private void setBCiClaimCompelcrashDto(
			CiClaimCompelcrashDto ciClaimCompelcrashDto,
			HttpServletRequest httpServletRequest) {
		ciClaimCompelcrashDto.setFaultParty(httpServletRequest
				.getParameter("faultSide"));
		ciClaimCompelcrashDto.setFaultBehavior(httpServletRequest
				.getParameter("faultAction"));
		ciClaimCompelcrashDto.setDamageDate(new DateTime(httpServletRequest
				.getParameter("time"), new DateTime().YEAR_TO_SECOND));
		ciClaimCompelcrashDto.setDamageAddress(httpServletRequest
				.getParameter("address"));
		ciClaimCompelcrashDto.setCertainStartTime(new DateTime(
				httpServletRequest.getParameter("lossStartTime"),
				new DateTime().YEAR_TO_SECOND));
		ciClaimCompelcrashDto.setReportDate(new DateTime(httpServletRequest
				.getParameter("registTime"), new DateTime().YEAR_TO_SECOND));
		ciClaimCompelcrashDto.setApplyCertainTime(new DateTime(
				httpServletRequest.getParameter("registTime"),
				new DateTime().YEAR_TO_SECOND));

	}
}
