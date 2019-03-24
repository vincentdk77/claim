package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayExtFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * ֧����������
 * @author Administrator
 *
 */
public class UILpaymainRevokeFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		try{
			String paymentNo = httpServletRequest.getParameter("paymentNo");
			String registNo = httpServletRequest.getParameter("registNo");
			BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
			BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
			BLPrpLpayExtFacade blPrpLpayExtFacade = new BLPrpLpayExtFacade();
			UserDto user = (UserDto)httpServletRequest.getSession().getAttribute("user");
	        if (user==null) {
				throw new Exception("sessionʧЧ");
			}
			String businessNo = null;
			businessNo = paymentNo;
			//�жϰ����Ƿ񶳽�end
			if(registNo!=null&&!"".equals(registNo)){
				PrpLregistDto prpLregistDto = new BLPrpLregistFacade().findByPrimaryKey(registNo);
				UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
				String UWflowID = uiWorkFlowApprovalInterFaceFacade
				.submitApprovalPlatform("PayMentRevoke",
						"00", "00", businessNo,
						prpLregistDto.getRiskCode(),
						prpLregistDto.getClassCode(),
						prpLregistDto.getComCode(),
						user.getUserCode(), prpLregistDto.getMakeCom(),
						user.getUserCode(), user.getUserCode(),
						businessNo);
				if (UWflowID.length() < 15) {
					String msg = "����'"
						+ businessNo
						+ "'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
					throw new UserException(1, 3, "������", msg);
				}
			}
			/*** ����ע�������ƽ̨ end****/
			new BLPrplpayFacade().updateVFlag("7", businessNo);//����Ϊ��������״̬
			new BLPrpLpaymainFacade().updateByKey(businessNo, "7");
			//����֧��ռ�ô�������Ĳ���
			PrpLpayExtDto prpLpayExtDto = new PrpLpayExtDto();
			prpLpayExtDto.setPaymentNo(businessNo);
			int count = new BLPrpLpayExtFacade().getMaxSerialNo(businessNo);
			prpLpayExtDto.setSerialNo(count);
			prpLpayExtDto.setComCode(user.getComCode());
			prpLpayExtDto.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
			prpLpayExtDto.setNodeType("apay");
			prpLpayExtDto.setNodeName("֧��¼��");
			prpLpayExtDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
			//String inputHour = new DateTime(DateTime.current(),DateTime.HOUR_TO_SECOND).toString();
			prpLpayExtDto.setOperatorCode(user.getUserCode());
			prpLpayExtDto.setOperatorCodeName(user.getUserName());
			prpLpayExtDto.setFlag("Y");
			prpLpayExtDto.setNotionCode("7");
			prpLpayExtDto.setNotionName("��������");
			prpLpayExtDto.setContext("��������");
			new BLPrpLpayExtFacade().insert(prpLpayExtDto);
			
//			blPrpLpaymainFacade.delete(paymentNo);
//			blPrplpayFacade.deleteByConditions(" serialno='"+paymentNo+"' ");
//			blPrpLpayExtFacade.deleteByConditions(" registNo='"+registNo+"' and taskId='"+paymentNo+"' ");
			httpServletResponse.getWriter().write("true");
		}catch(Exception e){
			e.printStackTrace();
			httpServletResponse.getWriter().write(e.getMessage());
			
		}
		return null;
	}
}
