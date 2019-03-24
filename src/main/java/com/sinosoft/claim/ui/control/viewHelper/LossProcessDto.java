package com.sinosoft.claim.ui.control.viewHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;

import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLRegistRPolicyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.bl.action.domain.BLPrplpayAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.bl.action.domain.BLSwfPathLogAction;
//import com.sinosoft.claim.bl.facade.BLPrplcompensatefranchiseFacade;
//import com.sinosoft.claim.bl.facade.BLPrpllossextFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
//import com.sinosoft.claim.dto.domain.AClaimDto;
//import com.sinosoft.claim.dto.domain.ALossDto;
//import com.sinosoft.claim.dto.domain.BClaimDto;
//import com.sinosoft.claim.dto.domain.BLossDto;
//import com.sinosoft.claim.dto.domain.BusiLossChargeDto;
//import com.sinosoft.claim.dto.domain.BusiLossDto;
//import com.sinosoft.claim.dto.domain.BzClaimDto;
//import com.sinosoft.claim.dto.domain.BzLossDto;
//import com.sinosoft.claim.dto.domain.DClaimDto;
//import com.sinosoft.claim.dto.domain.DLossDto;
//import com.sinosoft.claim.dto.domain.GClaimDto;
//import com.sinosoft.claim.dto.domain.GLossDto;
//import com.sinosoft.claim.dto.domain.LossBusinessDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
//import com.sinosoft.claim.dto.domain.PrplclaimlossextDto;
//import com.sinosoft.claim.dto.domain.PrplcompensatefranchiseDto;
//import com.sinosoft.claim.dto.domain.PrpllossextDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowUWInterFaceFacade;
//import com.sinosoft.claim.ui.view.formbean.PrplClaimLossextForm;
//import com.sinosoft.claim.ui.view.formbean.PrplLossextForm;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 理算处理数据的类
 * */
public class LossProcessDto {
    
    /**
     * 保存支付录入信息
     * 在facade里调用这个方法
     * @throws Exception 
     * */
    /**
     * 保存支付录入信息
     * 在facade里调用这个方法,采用先删后插的方式
     * @throws Exception 
     * */
    public void saveOrUpdatePay(DBManager dbManager,HttpServletRequest request,String compNo,String vFlag) throws Exception{
        String delconditions="";
        UserDto user=(UserDto)request.getSession(true).getAttribute("user");
        BLPrpLRegistRPolicyAction policyAndRegist=new BLPrpLRegistRPolicyAction();
        PrpLRegistRPolicyDto rpDto=new PrpLRegistRPolicyDto();
        BLPrplpayAction payAction=new BLPrplpayAction();
        BLPrpLregistAction bLregistAction= new BLPrpLregistAction();
        PrpLregistDto prpLregistDto;
        //立案号码 ,保单号码。用","分割
        String[] claimno=request.getParameterValues("claimno");
        String flag= request.getParameter("flag");
        //理算书号,或预赔号
        String[]compensateno=request.getParameterValues("compensateno");
        //支付类型
        String[]paytype=request.getParameterValues("paytype");
        //领款人类型
        String[] receivertype=request.getParameterValues("receivertype");
        //支付金额
        String[]payamount=request.getParameterValues("payamount");
        //开户银行
        String[] bank=request.getParameterValues("bank");
        //银行账号
        String[] bankaccount=request.getParameterValues("bankaccount");
        //支付类型
        String[] paymenttype=request.getParameterValues("paymenttype");
        //领款人全称
        String[] receiverfullname=request.getParameterValues("receiverfullname");
        String[] riskcode=request.getParameterValues("riskcode_payment");
        //家庭电话
        String[]familyphone=request.getParameterValues("familyphone");
        //支付说明
        String payremark=request.getParameter("payremark");
        //
        String registno=request.getParameter("registNo_payment");
        //支付标记,已经支付过的不在修改
        String payflag[]=request.getParameterValues("payflag");
        //从配置文件中读取所有交强险的riskCode
        String isbz=AppConfig.get("sysconst.ISBZ");
        PrplpayDto payDto=null;
        List list=new ArrayList();
        if(paytype!=null){
        	prpLregistDto=bLregistAction.findByPrimaryKey(dbManager, registno);
            for(int i=1;i<paytype.length;i++){//隐藏的不取
                payDto=new PrplpayDto();
                
                
                if(flag.equals("comp")){//理算环节
                	if(compensateno!=null&&compensateno[i]!=null&&!compensateno[i].equals("")&&compNo==null){
                        payDto.setCompensateno(compensateno[i]);
                    }else{                    
                        if(compNo!=null){                    
                        	payDto.setCompensateno(compNo);
                        }
                    }
                	if(compNo!=null){
                    	if(compNo.indexOf(claimno[i].split(",")[2])<0){
                        	continue;
                        }
                    }
                    //payDto.setCompensateno(compensateno[i]);
                    payDto.setClaimno(claimno[i].split(",")[0]);
                    payDto.setPolicyno(claimno[i].split(",")[1]);
                    payDto.setRiskcode(claimno[i].split(",")[2]);
                    payDto.setClasscode(claimno[i].split(",")[2].substring(0, 2));
                    payDto.setNode("comp");
                    //理算环节根据报案号，理算书号删除
                    delconditions=" 1=1 and registno='"+registno+"' and COMPENSATENO='"+payDto.getCompensateno()+"' and payflag!=1 ";
                    if("1".equals(vFlag)){//暂存
                    	delconditions += " and vflag = '1'";
                    }
                }else if(flag.equals("prepay")){
                    //预赔时只有一个预赔号，不会同时出现两个
                    payDto.setCompensateno(compensateno[i]);
                    payDto.setClaimno(claimno[i].split(",")[0]);
                    payDto.setPolicyno(claimno[i].split(",")[1]);
                    payDto.setRiskcode(claimno[i].split(",")[2]);
                    payDto.setRiskcode(claimno[i].split(",")[2].substring(0, 2));
                    payDto.setNode("prepay");
                    //已经支付的信息不能删除
                    delconditions=" 1=1 and registno='"+registno+"' and COMPENSATENO = '"+compensateno[i]+"' and payflag!=1";
                    //单证时记没有立案号也没有理算，所以这两个都存序号
                }else if(flag.equals("certify")){
                    //payDto.setCompensateno(i+"");
                    payDto.setNode("certify");
                    String conditions=" 1=1 and registno='"+registno+"'";
                    delconditions=" 1=1 and registno='"+registno+"' and COMPENSATENO is null  and payflag!=1";
                    List prList=(ArrayList)policyAndRegist.findByConditions(dbManager, conditions);
                    
                    if(prList!=null&&prList.size()==2){//如果有两个的话，只取商业险
                        for(int i1=0;i1<prList.size();i1++){
                            rpDto =(PrpLRegistRPolicyDto)prList.get(i1);
                            //商业险
                            if(isbz.indexOf(rpDto.getRiskCode())==-1){
                                payDto.setPolicyno(rpDto.getPolicyNo());
                                //  payDto.setRiskcode(rpDto.getRiskCode());
                            }
                        }
                    }else if(prList.size()!=0){
                        rpDto =(PrpLRegistRPolicyDto)prList.get(0);
                        payDto.setPolicyno(rpDto.getPolicyNo());
                        payDto.setClasscode(rpDto.getRiskCode().substring(0, 2));
                    }
                }
                
                payDto.setPaytype(paytype[i]);
                payDto.setReceivertype(receivertype[i]);
                payDto.setReceiverfullname(receiverfullname[i]);
                payDto.setPayamount(payamount[i]);
                payDto.setBank(bank[i]);
                
                payDto.setPayflag(payflag[i]);
                payDto.setFamilyphone(familyphone[i]);
                payDto.setPayremark(payremark);
                payDto.setRegistno(registno);
                payDto.setOperatorcode(user.getUserCode());
                payDto.setComCode(user.getComCode());
                payDto.setVFlag(vFlag);
                payDto.setPaymenttype(paymenttype[i]);//支付类型
                payDto.setBankaccount(bankaccount[i]);//银行账号
                list.add(payDto);
                
                
            }
        }
        //当带理算号并且没有记录时删除理算记录
        if(compNo!=null&&list.size()==0){                    
        	 /**按删除条件删除*/
        	delconditions=" 1=1 and registno='"+registno+"' and COMPENSATENO='"+compNo+"' and payflag!=1 ";
            this.deleteBycond(dbManager,delconditions);
        }
        if(list.size()!=0){ 
            this.deleteBycond(dbManager,delconditions);
            payAction.insertAll(dbManager, list);
        }
    }
    public void deleteBycond(DBManager dbManager, String conditions) throws Exception{
        new BLPrplpayAction().deleteByConditions(dbManager, conditions);
    }
}
