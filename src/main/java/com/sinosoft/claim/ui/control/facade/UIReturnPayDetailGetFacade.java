package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.platform.bl.facade.BLPrpDcodeFacade;
import com.sinosoft.sysframework.reference.AppConfig;

public class UIReturnPayDetailGetFacade extends org.apache.struts.action.Action{
    public ActionForward execute(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception  {
        
        String certitype=request.getParameter("node");
        String registNo=request.getParameter("registno")==null?"":request.getParameter("registno").trim();
        String busino=request.getParameter("busino").trim();
        String paymenttype=request.getParameter("paymenttype");
        String conditions="";
        String node = "";
        if("Y".equals(certitype)){
        	node = "prepay";
        }else if("C".equals(certitype)){
        	node = "comp";
        }else{
        	node = "certify";
        }
        String payCondition="codetype='NewPayRefReason' and validstatus='1' and codecode like 'P6%'";//理算的费用类型
        //单证,单证环节查询业务号为空的数据
        if(node.equals("certify")){
            conditions=" 1=1 and p.registno="+registNo+" AND p.compensateno IS  NULL ";
        //预赔,理算
        }else{
            if(paymenttype==null){                
                conditions=" 1=1 and p.registno='"+registNo+"' AND p.compensateno='"+busino+"'";
            }else{
                conditions=" 1=1 and p.registno='"+registNo+"' AND p.compensateno='"+busino+"' and p.paymenttype='"+paymenttype+"'";
            }
            //预赔
            if(node!=null&&node.equals("prepay")){
                payCondition="codetype='NewPayRefReason' and validstatus='1' and ( codecode='P50')";
            }
        }
        ArrayList<PrplpayDto> payList=(ArrayList<PrplpayDto>) new BLPrplpayFacade().findByConditions(conditions);
        List paymenttype1=(List) new BLPrpDcodeFacade().findByConditions(payCondition);
        if(payList.size()!=0&&payList!=null){
        	PrplpayDto pay=(PrplpayDto)payList.get(0);
            request.setAttribute("payremark",pay.getPayremark());
           
        }
        ArrayList<PrplpayDto> list1 = (ArrayList<PrplpayDto>)request.getAttribute("payinfoList");
        if(list1!=null&&!list1.isEmpty()){
        	payList.addAll(list1);
        }
        request.setAttribute("payinfoList",payList);
        request.setAttribute("paymenttype1",paymenttype1);

        List claimNoList=(ArrayList) new BLPrpLclaimFacade().findByConditions("registNo='"+registNo+"'");
        if(claimNoList!=null){
            //SwfLogDto swflogDto=new SwfLogDto();
            PrpLclaimDto prpLclaimDto=null;
            //交强险和商业险立案号
            HashMap<String,String> claimNoMap=new HashMap<String,String>();
            //从配置文件中读取所有交强险的riskCode
            String isbz=AppConfig.get("sysconst.ISBZ");
            //立案环节最多有交强险和商业险两条数据
            for(int i=0;i<claimNoList.size();i++){
               // swflogDto=(SwfLogDto)claimNoList.get(i);
                prpLclaimDto =(PrpLclaimDto)claimNoList.get(i);
                //交强险
                if(isbz.indexOf(prpLclaimDto.getRiskCode())!=-1){
                    claimNoMap.put("bzClaimNo",prpLclaimDto.getClaimNo()); 
                }else{//商业险
                    claimNoMap.put("busiClaimNo",prpLclaimDto.getClaimNo());
                }
            }
            request.setAttribute("claimNoMap",claimNoMap);
            request.setAttribute("claimNoList", claimNoList);
        }
    
        request.setAttribute("node", node);
        request.setAttribute("registNo", registNo);
        request.setAttribute("busino",busino);
        request.setAttribute("editType", "SHOW");
        new DAARegistViewHelper().findPrplregistExt(request,registNo);
        return mapping.findForward("success");
    }
    
}
