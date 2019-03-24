package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.action.domain.BLPrplfiscalpaymainAction;
import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrplfiscalpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplfiscalpaydetailDto;
import com.sinosoft.claim.dto.domain.PrplfiscalpaymainDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;
import com.sinosoft.claim.ui.view.formbean.PrplFiscalPayForm;
import com.sinosoft.claim.ui.view.formbean.PrplPayForm;
import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.claim.util.TurnPageUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.workbench.claim.dto.domain.PrpLregistDto;

public class UIPrprlfiscalpaySearchFacade extends Action{
    public ActionForward execute(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        PrplfiscalpaymainDto fiscalpayDto=new PrplfiscalpaymainDto();
        PrplFiscalPayForm fiscalpayForm=(PrplFiscalPayForm)form;
        try {
        	 //ÿҳ��ʾ������
            int rowsPerPage = TurnPageUtil.PERPAGE;
            //ҳ��
            int pageNo     = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
            
            String conditions=this.getConditions(fiscalpayForm,request);
            
            if (request.getParameter("condition")!=null) {
            	conditions=request.getParameter("condition");
			}
            request.setAttribute("type", request.getParameter("type")) ;
            request.setAttribute("doQuery", request.getParameter("doQuery")) ;
            String type = request.getParameter("type");
            Collection fiscalpaymainList  = new ArrayList();
            if("4".equals(type)){
              PageRecord pr= new BLPrplfiscalpaymainFacade().findPayQueryByConditions(conditions, pageNo, rowsPerPage);
              TurnPageDto pageDto=TurnPageUtil.getTurnPage(pr,request,conditions);
              fiscalpayDto.setTurnPageDto(pageDto);
              fiscalpaymainList = pr.getResult() ;
            }else{
              PageRecord pr= new BLPrplfiscalpaymainFacade().findPayQueryByConditions(conditions, pageNo, rowsPerPage);
              TurnPageDto pageDto=TurnPageUtil.getTurnPage(pr,request,conditions);
              fiscalpayDto.setTurnPageDto(pageDto);
              fiscalpaymainList = pr.getResult() ;
            }
            
            String nowTime = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND)+"";
            if(null!=fiscalpaymainList&&!fiscalpaymainList.isEmpty()){
        			for(Iterator<PrplfiscalpaymainDto> itr=fiscalpaymainList.iterator();itr.hasNext();){
        				PrplfiscalpaymainDto prplfiscalpaymainDto = itr.next();
            			//����ʱ��ȡ��
            			String totalInputDate = DateCompute.betweenDate(prplfiscalpaymainDto.getInputdate()+"", nowTime);
            			totalInputDate = totalInputDate.split("����")[0];
            			prplfiscalpaymainDto.setTotalInputDate(totalInputDate);
            			//�б���������ȡ��
            			BLPrpDcompanyFacade  blPrpDcompanyFacade = new BLPrpDcompanyFacade();
            			PrpDcompanyDto prpDcompanyDto = blPrpDcompanyFacade.findByPrimaryKey(prplfiscalpaymainDto.getOperatorcomcode());
            			if(null!=prpDcompanyDto&&!"".equals(prpDcompanyDto)){
            				prplfiscalpaymainDto.setComName(prpDcompanyDto.getComCName());
            			}
                	}
        	}
            PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
            String prevPageUrl = request.getParameter("prevPageUrl");
            request.setAttribute("prevPageUrl", prevPageUrl);
            request.setAttribute("paymentTypeMap",paymentViewHelper.getPaymentTypeMap());
            request.setAttribute("VFlagMap",paymentViewHelper.getVFlagMap());
            request.setAttribute("payTypeMap",paymentViewHelper.getPayTypeMap());
            request.setAttribute("fiscalpaymainList", fiscalpaymainList);
            request.setAttribute("fiscalpayDto", fiscalpayDto);
            request.setAttribute("thirdPayFlagMap", paymentViewHelper.getThirdPayFlagMap());
            if("4".equals(type)){
            return mapping.findForward("success");
            }else{
            return mapping.findForward("true");
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
       
    }
    public String getConditions(PrplFiscalPayForm fiscalPayForm, HttpServletRequest request) throws Exception{
        StringBuffer sb=new StringBuffer();
        PrplfiscalpaymainDto fiscalpaymainDto=fiscalPayForm.getPrplfiscalpaymainDto();
        PrplfiscalpaydetailDto fiscalpaydetailDto=fiscalPayForm.getPrplfiscalpaydetailDto();
        PrpLregistDto registDto=fiscalPayForm.getPrplregist();
        String registnoSign = request.getParameter("registnoSign");
        String fiscalnoSign = request.getParameter("fiscalnoSign");
        UserDto  user=(UserDto) request.getSession().getAttribute("user");
        String userComCode = user.getComCode();
        
        String mechanism = request.getParameter("mechanism");
        String agnet = request.getParameter("agnet");
        
        String[] vflag = request.getParameterValues("vflag");
        String type = request.getParameter("type");
        sb.append(" 1=1 ");
        
        if (user==null) {
			throw new Exception("sessionʧЧ");
		}else {
			//�滻Ϊ,�˴��������ί�д����д���--�˴�Ϊ����ί�д�����,Ȩ�޹����Ϊϵͳ������¼���ģʽ
			//sb.append("");
			if(type!=null&&"4".equals(type)){
				UIPowerInterface uiPowerInterface = new UIPowerInterface();
				String sqlStr = uiPowerInterface.addPower(user, "prplfiscalpaymain", "", "operatorComCode");
				sb.append("   "+sqlStr+"  ");
			}else{
				sb.append(" and prplfiscalpaymain.operatorcode = '" + user.getUserCode() + "'");
			}
			if(type!=null&&!"".equals(type)&&!"4".equals(type)){
				sb.append(" and prplfiscalpaymain.status = '"+type+"'"); 
			}
		}
        
        try {
        	
        	sb.append(" and prplfiscalpaymain.fiscalno = prplfiscalpaydetail.fiscalno");
        	sb.append(" and prplfiscalpaymain.registno = prplregist.registno ");
        	//��������
        	if (!fiscalpaymainDto.getRegistno().equals("")) {
        		if("*".equals(registnoSign)){
        			sb.append(" and prplfiscalpaymain.registno like '%"+fiscalpaymainDto.getRegistno()+"%'");
        		}else if("=".equals(registnoSign)){
        			sb.append(" and prplfiscalpaymain.registno = '"+fiscalpaymainDto.getRegistno()+"'");
        		}
        	}
        	//֧���嵥��
        	if (!fiscalpaymainDto.getFiscalno().equals("")) {
        		if("*".equals(fiscalnoSign)){
        			sb.append(" and prplfiscalpaymain.fiscalno like '%"+fiscalpaymainDto.getFiscalno()+"%'");
        		}else if("=".equals(fiscalnoSign)){
        			sb.append(" and prplfiscalpaymain.fiscalno = '"+fiscalpaymainDto.getFiscalno()+"'");
        		}
        	}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return sb.toString();
    }
}
