package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.action.domain.BLPrpLregistExtAction;
import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLchargeFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLprepayFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.bl.facade.BLSwfNodeFacadeBase;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.ClaimProcessViewHelper;

public class UIPrprlpayAddFacade extends org.apache.struts.action.Action{
    public ActionForward execute(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception  {
        
    	String node=request.getParameter("node");
    	String registno=request.getParameter("registno")==null?"":request.getParameter("registno").trim();
        String busino=request.getParameter("busino").trim();
        String paymentFlag =request.getParameter("paymentFlag");
        String paymenttype=request.getParameter("paymenttype");
        String from =request.getParameter("from")==null?"":request.getParameter("from");
        ClaimProcessViewHelper cp=new ClaimProcessViewHelper();
        String claimNo = "";
        try{
	        if (from.equals("undwrt")) {
	        	PrplpayDto prplpayDto=null;
	            BLPrplpayFacade blPrplpayFacade=new  BLPrplpayFacade();
	            List list= (List) blPrplpayFacade.findByConditions("p.compensateno='"+busino+"'");
	            if (list!=null&&!list.isEmpty()) {
	            	prplpayDto=(PrplpayDto) list.get(0);
	            	registno=prplpayDto.getRegistno();
				}
			}
        	if(!node.equals("certify")){
 	           
	            String checkNode="";
	            if(registno.equals("")){
	                checkNode=" 1=1 and businessno='"+busino+"'";
	                
	            }else{
	                checkNode= " 1=1 and registno='"+registno+"' and businessno='"+busino+"'";
	            }
	            List list=new ArrayList();
	           
	                if(!from.equals("compadd")){//理算页面引用
	                    //暂时不用
	                    //list = facade.getSwfLogListByConditions(checkNode);
	                    if(list==null){
	                       // response.setCharacterEncoding("utf-8");
	                        request.setAttribute("pay_msg","请填写合法的报案号和业务号");
	                        return mapping.findForward("noRegist");
	                    }else{
	                        //理算
	                        if(node!=null&&node.equals("comp")){
	                            String cond=" 1=1 and compensateno='"+busino+"' ";
	                            PrpLchargeDto chargerDto=null;
	                            HashMap<String,Double> chargemap=new HashMap<String,Double>();
	                            //取理算书
	                            PrpLcompensateDto compDto=(PrpLcompensateDto)new BLPrpLcompensateFacade().findByPrimaryKey(busino);
	                            List chargeList=(List)new BLPrpLchargeFacade().findByConditions(cond);
	                            Double chageTemp=0d;
	                            for(int i=0;i<chargeList.size();i++){
	                                chargerDto=(PrpLchargeDto)chargeList.get(i);
	                                if(chargemap.containsKey(chargerDto.getChargeName())){
	                                    chageTemp+=chargemap.get(chargerDto.getChargeName());
	                                    chargemap.put(chargerDto.getChargeName(),chageTemp);
	                                }else{
	                                    chargemap.put(chargerDto.getChargeName(),chargerDto.getChargeAmount());
	                                }
	                                
	                            }
	                            request.setAttribute("ChargeList",chargeList);
	                            request.setAttribute("CompDto", compDto);
	                        //预赔
	                        }else if(node!=null&&node.equals("prepay")){
	                            String cond=" 1=1 and precompensateno='"+busino+"'";
	                            List reList=(List)new BLPrpLprepayFacade().findByConditions(cond);
	                            request.setAttribute("prepay_pay_list",reList);
	                        }
	                    }
	                }
	                
	            
	        }
            /*String cond=" 1=1 and compensateno='"+busino+"' ";
            PrpLchargeDto chargerDto=null;
            HashMap<String,Double> chargemap=new HashMap<String,Double>();
            //取理算书
            PrpLcompensateDto compDto=(PrpLcompensateDto)new BLPrpLcompensateFacade().findByPrimaryKey(busino);
            if(compDto!=null){
            	claimNo = compDto.getClaimNo();
            }else{
            	throw new Exception("该理算书不存在");
            }
            PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(claimNo);
            registno = prpLclaimDto.getRegistNo();
            List chargeList=(List)new BLPrpLchargeFacade().findByConditions(cond);
            request.setAttribute("ChargeList",chargeList);
            request.setAttribute("CompDto", compDto);*/
        } catch (Exception e) {
        	e.printStackTrace();
        	throw e;
        }
        //封装 RegistRPolicyList  ClaimDtoList claimno riskcode policyno
        cp.getUpPayInfo(registno, request);
        //费用类型  数据库中支付信息
        cp.getPayInfo(registno, busino,node, request,paymenttype);
        request.setAttribute("node", node);
        request.setAttribute("RegistNo", registno);
        request.setAttribute("BusiNo",busino);
        request.setAttribute("EditType", request.getParameter("editType"));
        return mapping.findForward("s");
    }
    
    
}
