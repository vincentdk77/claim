package com.sinosoft.claim.ui.control.viewHelper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.facade.BLPrpLcertifyDirectFacade;
import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLqualityCheckDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.ui.control.action.UICertifyAction;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * <p>
 * Title: CertifyViewHelper
 * </p>
 * <p>
 * Description:单证ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 liubvo
 * @version 1.0 <br>
 */

public class DAACertifyCombineViewHelper extends CertifyCombineViewHelper {
	private static final Log logger = LogFactory.getLog(DAACertifyCombineViewHelper.class);

	/**
	 * 保存单证时单证页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * 
	 * @param httpServletRequest
	 * @return certifyDto 单证数据传输数据结构
	 * @throws Exception
	 */
	public CertifyDto viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		// 继承对certify,certifyText表的赋值
		CertifyDto certifyDto = super.viewToDto(httpServletRequest);

		ArrayList prpLqualityCheckDtoList = new ArrayList();
		PrpLqualityCheckDto prpLqualityCheckDto = null;
		String[]  prplcombineRegistNo = httpServletRequest.getParameterValues("prplcombineRegistNo");
	    String[]  CombinenodeStatus   = httpServletRequest.getParameterValues("CombinenodeStatus");
		String strCount = httpServletRequest.getParameter("txtRecordNum");
		int intCount = Integer.parseInt(DataUtils.nullToZero(strCount));
		int j = 0;
		String strQuestionCode = "";
		String strQuestionName = "";
		String strQuestionRemark = "";
		String strVisitBackQueRes = "";
		if(prplcombineRegistNo==null){
	      }else{
	    	  for (int index = 0; index < prplcombineRegistNo.length; index++) {
	    		if(CombinenodeStatus[index]!=null&&"0".equals(CombinenodeStatus[index])){  
		          for (int i = 0; i < intCount; i++) {
		        	j = i + 1;

		           	strQuestionCode = "txtQuestionCode" + j;
			        strQuestionName = "txtQuestionName" + j;
			        strQuestionRemark = "txtQuestionRemark" + j;
			        strVisitBackQueRes = "VisitBackQue" + j;
					prpLqualityCheckDto = new PrpLqualityCheckDto();
					prpLqualityCheckDto.setRegistNo(prplcombineRegistNo[index]);
					prpLqualityCheckDto.setQualityCheckType(httpServletRequest
							.getParameter("qualityCheckType"));
					prpLqualityCheckDto.setSerialNo(i + 1);
					prpLqualityCheckDto.setTypeName(httpServletRequest
							.getParameter(strQuestionName));
					prpLqualityCheckDto.setTypeCode(httpServletRequest
							.getParameter(strQuestionCode));
					prpLqualityCheckDto.setCheckResult(httpServletRequest
							.getParameter(strVisitBackQueRes));
					prpLqualityCheckDto.setCheckRemark(httpServletRequest
							.getParameter(strQuestionRemark));
					prpLqualityCheckDto.setFlag("");
					prpLqualityCheckDtoList.add(prpLqualityCheckDto);
		         }
	    	   }    
	       }
	    }
		// 加到ArrayList中
		certifyDto.setPrpLqualityCheckList(prpLqualityCheckDtoList);
		
		return certifyDto;
	}

	/**
	 * 填写单证页面及查询单证request的生成.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param certifyDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			CertifyDto certifyDto) throws Exception {
	}





	private String getCustomCertifyTypeCode(String[] havedTypeCodeArray,
			int[] startIndex) {
		String typeCode;
		DecimalFormat df = new DecimalFormat("00");
		int index = startIndex == null ? 1 : startIndex[0];
		typeCode = null;
		for (int i = index; i < 100; i++) {
			typeCode = "99" + df.format(i);
			// 判断该typeCode在已保存的列表中是否存在
			if (!ArrayUtils.contains(havedTypeCodeArray, typeCode)) {
				startIndex[0] = i + 1;
				return typeCode;
			}
		}
		throw new RuntimeException("自定义的单证类型太多了,超出了系统的范围");
	}

	private static class CertifyAttribute {
		String policyNo;

		String registNo;

		String riskCode;

		int serialNo;

		public String getPolicyNo() {
			return policyNo;
		}

		public void setPolicyNo(String policyNo) {
			this.policyNo = policyNo;
		}

		public String getRegistNo() {
			return registNo;
		}

		public void setRegistNo(String registNo) {
			this.registNo = registNo;
		}

		public String getRiskCode() {
			return riskCode;
		}

		public void setRiskCode(String riskCode) {
			this.riskCode = riskCode;
		}

		public int getSerialNo() {
			return serialNo;
		}

		public void setSerialNo(int serialNo) {
			this.serialNo = serialNo;
		}
	}
}
