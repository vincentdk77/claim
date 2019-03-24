package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLpayNoticeListFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.utility.string.Money;

public class UILpayNoticePrintEditFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String forward = "success";
		UserDto  user=(UserDto) request.getSession().getAttribute("user");
		//String noticeNo = request.getParameter("noticeNo");//֪ͨ����
		String paymentNo = request.getParameter("paymentNo");//֪ͨ����
		BLPrpLpayNoticeListFacade blPrpLpayNoticeListFacade = new BLPrpLpayNoticeListFacade();
		BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
		BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		int pagePrintSize  = 20;//�����ݽ��������������ļ��У��˴�Ӧ������Ҫ��ʱ����������
		try{
			//ArrayList payList = (ArrayList) blPrplpayFacade.findPrintByNoticeNo(noticeNo);
			Collection prplpayList = new ArrayList();
			String receiverfullname = "";//���������
			//ArrayList noticeList =(ArrayList) blPrplpayFacade.findByConditions(" noticeNo = '"+noticeNo+"'");
			//ArrayList prplpayListNew =(ArrayList) blPrplpayFacade.findByConditions(" serialno = '"+paymentNo+"'");
			ArrayList prplpayListNew =(ArrayList) blPrplpayFacade.findPrintByPaymentNo(paymentNo);
			PrpLpaymainDto prpLpaymainDto = blPrpLpaymainFacade.findByPrimaryKey(paymentNo);
			DateTime dt = new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY);
			if(prpLpaymainDto!=null){
				receiverfullname =prpLpaymainDto.getReceiverFullName();
				dt=prpLpaymainDto.getPayDate();
			}
			if(!prplpayListNew.isEmpty()){
				//PrpLpayNoticeDto prplpaynoticeDto = (PrpLpayNoticeDto)noticeList.get(0);
				PrplpayDto prplpayDto = (PrplpayDto)prplpayListNew.get(0);
				receiverfullname =prplpayDto.getReceiverfullname();
				dt=prplpayDto.getPaydate();
				//receiverfullname = prplpaynoticeDto.getReceiverFullName();
			}
			int talNum = prplpayListNew.size();
			int page = talNum/pagePrintSize;
			int page2 = talNum%pagePrintSize;
			if(page2!=0){
				page = page +1;//�ܹ�ҳ��
			}
			double sumpay = 0.0;//�����ܶ�
//			DateTime dt = new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY);
			ArrayList list2 = new ArrayList();
			//����¼��
			for(int i=0;i<prplpayListNew.size();i++){
				PrplpayDto prplpayDto = (PrplpayDto)prplpayListNew.get(i);
				dt=prplpayDto.getPaydate();
				sumpay += prplpayDto.getPayamount();
				if (i>=pagePrintSize){
					list2.add(prplpayDto);
					continue;
				}
				prplpayList.add(prplpayDto);
				
			}
				
			PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
			Map paymentTypeMap = paymentViewHelper.getPaymentTypeMap();
			//request.setAttribute("noticeNo", noticeNo);
			request.setAttribute("paymentNo", paymentNo);
			request.setAttribute("receiverfullname",receiverfullname);
			request.setAttribute("prplpayList",prplpayList);
			request.setAttribute("paymentTypeMap", paymentTypeMap);
			request.setAttribute("list2", list2);
			request.setAttribute("strpage", page);
			//DateTime dt = new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY);
			request.setAttribute("pagePrintSize",pagePrintSize);
			request.setAttribute("yearTemp", (dt==null||dt.isEmpty())?"  ":dt.getYear());
			request.setAttribute("monthTemp",(dt==null||dt.isEmpty())?"  ":dt.getMonth());
			request.setAttribute("dayTemp", (dt==null||dt.isEmpty())?"  ":dt.getDay());
			if(null!=user){
				request.setAttribute("comCname", user.getComName());
			}else{
				throw new Exception("sessionʧЧ��");
			}
			//�����ܶ��д
			String chineseMoney = Money.toChineseMoney(sumpay,"CNY");
			request.setAttribute("sumpay", sumpay);
			request.setAttribute("chineseMoney", chineseMoney);
			forward = "success";
		}catch(Exception e){
		      e.printStackTrace();
		      ActionErrors errors = new ActionErrors();
		      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
		      errors.add(ActionErrors.GLOBAL_ERROR, error);
		      request.setAttribute("errorMessage",e.getMessage()) ;
		      saveErrors(request, errors);
		      forward = "error";
		}
		
		return actionMapping.findForward(forward);
	}
}
