package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.platform.bl.facade.BLPrpDcodeFacade;

public class ClaimProcessViewHelper {
	
	/**
     * 根据报案号得到支付信息，用于添加的时候显示历史填写的支付信息
     * @param registNo
     * @param request
     * @throws Exception 
     * */
    public void getUpPayInfo(String registNo,HttpServletRequest request) throws Exception{

        String conditions=" 1=1 and registno='"+registNo+"' and VALIDSTATUS='1' ";
        ArrayList<PrpLRegistRPolicyDto> registRPolicyList=null;
        ArrayList<PrpLclaimDto> claimDtoList=null;
        ArrayList<PrplpayDto> payList=new ArrayList();
        try {
            registRPolicyList=(ArrayList<PrpLRegistRPolicyDto>)new BLPrpLRegistRPolicyFacade().findByConditions(conditions);
            if(registRPolicyList!=null&&registRPolicyList.size()!=0){
                request.setAttribute("RegistRPolicyList", registRPolicyList);
            }
            
            claimDtoList=(ArrayList) new BLPrpLclaimFacade().findByConditions("registNo='"+registNo+"'");
            if(claimDtoList!=null){
                PrpLclaimDto prpLclaimDto = (PrpLclaimDto)claimDtoList.get(0);
                request.setAttribute("ClaimDtoList", claimDtoList);
                request.setAttribute("RiskCode", prpLclaimDto.getRiskCode());
                request.setAttribute("PolicyNo", prpLclaimDto.getPolicyNo());
                request.setAttribute("ClaimNo", prpLclaimDto.getClaimNo());
            }
            
            //存放缓存信息，给页面快速选择账户信息
            String type = (String)request.getParameter("type");
            conditions=" 1=1 and registNo ='"+registNo+"'";
            if("2".equals(type)){//暂存
            	conditions += " and vflag ='1'";
            }
            payList=(ArrayList<PrplpayDto>) new BLPrplpayFacade().findByConditions(conditions);
            request.setAttribute("UppayList",payList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 得到支付信息已保存数据信息
     * @throws Exception 
     * */
    public void getPayInfo(String registNo,String busino,String node,HttpServletRequest request,String paymentytype) throws Exception{
        String conditions="";
        String payCondition="codetype='NewPayRefReason' and validstatus='1' and codecode like 'P6%'";//理算的费用类型
        
        if(node.equals("certify")){
            conditions=" 1=1 and registno="+registNo+" AND compensateno IS  NULL ";
        //预赔,理算
        }else{
        	if(paymentytype==null){
                conditions=" 1=1 and registno="+registNo+" AND compensateno='"+busino+"'";
            }else{
                conditions=" 1=1 and registno='"+registNo+"' AND compensateno='"+busino+"' and paymenttype='"+paymentytype+"'";
            }
        	//预赔
            if(node!=null&&node.equals("prepay")){
                payCondition="codetype='NewPayRefReason' and validstatus='1' and ( codecode='P50')";
            }
        }
        String type = (String)request.getParameter("type");
        if("2".equals(type)){
        	conditions += " and vflag='1'";
        }
        List payList=(List) new BLPrplpayFacade().findByConditions(conditions);
        if(payList.size()!=0&&payList!=null){
        	PrplpayDto pay=(PrplpayDto)payList.get(0);
            request.setAttribute("payremark",pay.getPayremark());
            String editType="";
            if(pay.getVFlag()==null||"".equals(pay.getVFlag())){
			}else if(pay.getVFlag().equals("3")){
			}else if(pay.getVFlag().equals("2")){
			 editType="SHOW";
			}else if(pay.getVFlag().equals("4")){
			 editType="SHOW";
			}
            request.setAttribute("editType", editType);
        }
        ArrayList<PrplpayDto> list1 = (ArrayList<PrplpayDto>)request.getAttribute("PayInfoList");
        if(list1!=null&&!list1.isEmpty()){
        	payList.addAll(list1);
        }
        request.setAttribute("PayInfoList",payList);
        
        //理算的费用类型
        List paymenttype=(List) new BLPrpDcodeFacade().findByConditions(payCondition);
        request.setAttribute("PaymentType",paymenttype);
        
    }
}
