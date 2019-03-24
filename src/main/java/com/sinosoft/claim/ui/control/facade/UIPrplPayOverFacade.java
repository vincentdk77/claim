package com.sinosoft.claim.ui.control.facade;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 此类供收复系统调用，本系统不体统此类的调用接口
 * */
public class UIPrplPayOverFacade extends Action{
    public ActionForward execute(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) {
        String registno=request.getParameter("registno");
        String busino=request.getParameter("busino");
        String code=request.getParameter("code");
        String paymenttype=request.getParameter("paymenttype");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date= sdf.format(new Date());
        PrplpayDto prplpayDto=new PrplpayDto();
        prplpayDto.setRegistno(registno);
        prplpayDto.setCompensateno(busino);
        prplpayDto.setPaycode(code);
        prplpayDto.setPaymenttype(paymenttype);
        prplpayDto.setPayflag("1");//已支付
        prplpayDto.setPaydate(new DateTime(date));
        try {
            new BLPrplpayFacade().updatePayFlag(prplpayDto);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            try {
                response.getWriter().print("err");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
       
        return mapping.findForward("s");
    }
}
