package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.claim.log.PayQueryConditionLogger;
import com.sinosoft.platform.bl.facade.BLUtiPlatConfigRuleFacade;
import com.sinosoft.platform.dto.domain.UtiPlatConfigRuleDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 支付信息列表展示类
 * @author Administrator
 *
 */
public class DBPrpLpayShow {
	 /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLpayShow.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpayShow(DBManager dbManager){
        this.dbManager = dbManager;
    }
	/**
	 * 支付信息查询列表显示方法
	 * @param payType	支付类型
	 * @param paymentType	赔款类型
	 * @param comCode	机构号码
	 * @param paymentNo	支付编号
	 * @param judgeFlag	判断加核赔标志 
	 * @param registNos	报案号集合
	 * @param certiNos	业务号集合
	 * @param status	支付状态（0:新增，1：暂存，4：查询）
	 * @return
	 * @throws Exception
	 */
    public ArrayList<PrpLpayShowDto> getShowList(String payType,String paymentType,String comCode,String paymentNo,boolean judgeFlag,
    		ArrayList<String> registNos,ArrayList<String> certiNos,String status)throws Exception{
    	System.err.println(111111+"单笔支付-整单支付");
    	String comCodeStr = comCode.substring(0, 6);
    	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
    	StringBuffer buffer = new StringBuffer(200);
    	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
    	buffer.append(" select registno,Policyno,Policytype,Certino,Claimno,coinscode,Insuredname,Licenseno,Sumthispaid,Underwriteenddate,Paytype,Comcode,(select cop.comcname from prpdcompany cop where cop.comcode = c.comcode) as Comcname,Havpay,nowPay,exist,Certitype,Payrefreason,vFlag ");
    	buffer.append(" from (  ");
    	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
    	//--赔款
    	buffer.append(" select r.registno, ");
    	buffer.append(" t.policyno, ");
		buffer.append(" '' as policyType, ");
    	buffer.append(" t.compensateno as certino, ");
    	buffer.append(" c.claimNo, ");
    	buffer.append(" '' as coinscode, ");
    	buffer.append(" r.insuredname, ");
    	buffer.append(" r.licenseno, ");
		buffer.append("  t.sumthispaid, ");
        buffer.append("   t.underwriteenddate, ");
        buffer.append("  '赔款' as payType, ");
        buffer.append(" r.comcode, ");
        buffer.append(" '' as comcname, ");
    	buffer.append(" (select sum(payamount) ");
        buffer.append(" from prplpay prplpay ");
        buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno = t.compensateno ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and prplpay.paymenttype = 'P60' ");
        if(payType != null &&!"".equals(payType)&&!"P3".equals(payType)&&!"P5".equals(payType)){
        	buffer.append(" and prplpay.paytype = 'P3' ");
        }
        if(paymentNo!=null&&!"".equals(paymentNo)){
        	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
        }
        buffer.append(" ) as havPay , ");//--已支付
        buffer.append(" pay.payamount as nowPay,  ");//--本次支付金额
        buffer.append(" pay.exist ,   ");//--是否勾选
        buffer.append(" 'C' as certitype,  ");
        buffer.append(" 'P60' as payrefreason,  ");
        buffer.append(" pay.vFlag   ");
        buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
        buffer.append(" ,(select distinct payamount, compensateno, '1' as exist,vFlag ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"'");
        buffer.append(" and paymenttype='P60' ) pay ");
        buffer.append(" where t.claimno = c.claimno ");
        buffer.append(" and c.registno = r.registno "); 
        if("0".equals(status)){
        	buffer.append(" and (select t.sumthispaid - nvl(sum(payamount), 0) "); 
        	buffer.append("         from prplpay "); 
        	buffer.append("        where prplpay.registno = r.registno "); 
        	buffer.append("          and prplpay.compensateno = t.compensateno "); 
        	buffer.append("          and prplpay.policyno = t.policyno "); 
        	buffer.append("          and prplpay.paymenttype = 'P60' "); 
        	//buffer.append("          and prplpay.paytype = 'P3') <> 0 "); 
        	buffer.append("          ) <> 0 "); 
        }
        
        //buffer.append(" and r.registno in ('报案号码') ");// --？（选择添加）
        if(registNos!=null&&registNos.size()>0){
    		buffer.append(" and r.registNo in ( ");
    		for(int i=0;i<registNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+registNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
        if(payType != null &&!"".equals(payType)&&!"P3".equals(payType) && !"P5".equals(payType)){
        	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
        }
        if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){
        	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
        }
        if(judgeFlag){//判断标志，当从预赔理算环节进入支付信息页面，无需判断费用是否核赔通过
        	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
        }
        //buffer.append(" and t.compensateno in ('理算书号') ");
        if(certiNos!=null&&certiNos.size()>0){
    		buffer.append(" and t.compensateno in ( ");
    		for(int i=0;i<certiNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+certiNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
        if(paymentNo!=null&&!"".equals(paymentNo)&&!"1".equals(status)){
        	buffer.append(" and pay.compensateno = t.compensateno ");
        }else{
        	buffer.append(" and pay.compensateno(+) = t.compensateno ");
        }
        buffer.append(" and 1=1 ");
        // buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//（此处去除 20130828 ）
        
        //代付共保赔款赔付信息
        buffer.append(" union all ");
        buffer.append(" select r.registno, ");
    	buffer.append(" t.policyno, ");
		buffer.append(" '' as policyType, ");
    	buffer.append(" co.businessno as certino, ");
    	buffer.append(" c.claimNo, ");
    	buffer.append(" co.coinscode, ");
    	buffer.append("  co.coinsname, ");
    	buffer.append(" r.licenseno, ");
		buffer.append("   co.coinssumpaid, ");
        buffer.append("   t.underwriteenddate, ");
        buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
        buffer.append("  changechargecodetochargenamegt(co.chargecode)) as payType, ");
        buffer.append(" r.comcode, ");
        buffer.append(" '' as comcname, ");
    	buffer.append(" (select sum(payamount) ");
        buffer.append(" from prplpay prplpay ");
        buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno =  co.businessno  and prplpay.coinscode=co.coinscode ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode	Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
        if(payType != null &&!"".equals(payType)&&!"P3".equals(payType)&&!"P5".equals(payType)){
        	buffer.append(" and prplpay.paytype = 'P3' ");
        }
        if(paymentNo!=null&&!"".equals(paymentNo)){
        	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
        }
        buffer.append(" ) as havPay , ");//--已支付
        buffer.append(" pay.payamount as nowPay,  ");//--本次支付金额
        buffer.append(" pay.exist ,   ");//--是否勾选
        buffer.append(" 'C' as certitype,  ");
        buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
        buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason , ");
        buffer.append(" pay.vFlag   ");
        buffer.append(" from prplcompensate t, prplclaim c, prplregist r ,prplcfeecoins co");
        buffer.append(" ,(select distinct payamount,paymenttype, compensateno, '1' as exist,vFlag ,coinscode");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"'");
        buffer.append(" and paymenttype in ("+utiPlatConfigRuleDto.getRule()+") ) pay ");
        buffer.append(" where t.claimno = c.claimno  and t.compensateno = co.businessno  and pay.coinscode(+)=co.coinscode ");
        buffer.append(" and c.registno = r.registno "); 
        if(paymentNo!=null&&!"".equals(paymentNo)){
        buffer.append(" and (chanpaymenttypetochargecodegt(pay.paymenttype) = co.chargecode Or (pay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
        }
        if("0".equals(status)){
        	buffer.append(" and (select co.coinssumpaid - nvl(sum(payamount), 0) "); 
        	buffer.append("         from prplpay "); 
        	buffer.append("        where prplpay.registno = r.registno "); 
        	buffer.append("          and prplpay.compensateno =  co.businessno  and prplpay.coinscode=co.coinscode "); 
        	buffer.append("          and prplpay.policyno = t.policyno "); 
        	buffer.append("          and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) "); 
        	//buffer.append("          and prplpay.paytype = 'P3') <> 0 "); 
        	buffer.append("          ) <> 0 "); 
        }
        
        //buffer.append(" and r.registno in ('报案号码') ");// --？（选择添加）
        if(registNos!=null&&registNos.size()>0){
    		buffer.append(" and r.registNo in ( ");
    		for(int i=0;i<registNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+registNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
        if(payType != null &&!"".equals(payType)&&!"P3".equals(payType) && !"P5".equals(payType)){
        	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
        }
        if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){
        	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
        }
        if(judgeFlag){//判断标志，当从预赔理算环节进入支付信息页面，无需判断费用是否核赔通过
        	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
        }
        //buffer.append(" and t.compensateno in ('理算书号') ");
        if(certiNos!=null&&certiNos.size()>0){
    		buffer.append(" and t.compensateno in ( ");
    		for(int i=0;i<certiNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+certiNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
        if(paymentNo!=null&&!"".equals(paymentNo)&&!"1".equals(status)){
        	buffer.append(" and pay.compensateno =  co.businessno ");
        }else{
        	buffer.append(" and pay.compensateno(+) =  co.businessno ");
        }
        buffer.append(" and 1=1 ");
        // buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//（此处去除 20130828 ）
        
		//--赔付费用
        buffer.append(" union all ");
        buffer.append(" select r.registno, ");
        buffer.append(" t.policyno, ");
		buffer.append(" '' as policyType, ");
        buffer.append("  t.compensateno as certino, ");
        buffer.append(" c.claimNo, ");
        buffer.append(" '' as coinscode, ");
        buffer.append(" r.insuredname, ");
        buffer.append(" r.licenseno, ");
        buffer.append(" ch.chargeamount as sumthispaid, ");
        buffer.append(" t.underwriteenddate, ");
        buffer.append(" changechargecodetochargename(ch.chargecode) as payType, ");
        buffer.append(" r.comcode, ");
        buffer.append(" '' as comcname, ");
        buffer.append(" (select sum(payamount) ");
        buffer.append(" from prplpay prplpay ");
       	buffer.append(" where prplpay.registno = r.registno ");
       	buffer.append(" and prplpay.compensateno = t.compensateno ");
       	buffer.append(" and prplpay.policyno = t.policyno ");
       	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
       	if(payType != null &&!"".equals(payType)&&!"P3".equals(payType)&&!"P5".equals(payType)){
       		buffer.append("  and prplpay.paytype = 'P3' ");
       	}
        if(paymentNo!=null&&!"".equals(paymentNo)){
        	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
        }
        buffer.append(" ) as havPay , ");//--已支付
        buffer.append(" pay.payamount as nowPay,  ");//--本次支付金额
        buffer.append(" pay.exist ,   ");//--是否勾选
        buffer.append(" 'C' as certitype,  ");
        //buffer.append(" 'P60' as payrefreason  ");//
        /*buffer.append(" case ch.chargecode  ");
		buffer.append(" when '05' then  ");
		buffer.append("  'P64'  ");
		buffer.append(" when '07' then  ");
		buffer.append("  'P61'  ");
		buffer.append(" when '15' then  ");
		buffer.append("  'P68'  ");
		buffer.append(" when '29' then  ");
		buffer.append("  'P611'  ");
		buffer.append(" when '30' then  ");
		buffer.append("  'P612'  ");
		buffer.append(" when '14' then  ");
		buffer.append("  'P65'  ");
		buffer.append(" when '13' then  ");
		buffer.append("  'P67'  ");
		buffer.append(" when '04' then  ");
		buffer.append("  'P62'  ");
		buffer.append(" else  ");
		buffer.append("  ''  ");
		buffer.append("  end as payrefreason,  ");*/
        buffer.append("  changechargecodetopaymenttype(Ch.Chargecode) as payrefreason,  ");
		buffer.append("  pay.vFlag  ");
		
		buffer.append(" from prplclaim c, prplregist r ,  prplcompensate t ");
		buffer.append(" join ");
		buffer.append(" (select compensateno, chargecode, sum(nvl(chargeamount,0)-nvl(prechargeamount,0)-nvl(sumrealpay,0)) as chargeamount ");
		buffer.append(" from prplcharge  where  chargecode<>'14' group by compensateno, chargecode) ch ");
		buffer.append(" on t.compensateno = ch.compensateno ");
		buffer.append(" left join ");
		buffer.append(" (select distinct payamount, compensateno, '1' as exist,vFlag,paymenttype ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"' " );
        buffer.append(" and paymentType not in ('P60','P50') and paymentType  like 'P%'"); 
        buffer.append(" and payamount<>0 ");
        buffer.append(") pay ");        
		buffer.append(" on ch.compensateno=pay.compensateno ");
		buffer.append(" and changepaymenttypetochargecode(pay.paymenttype)=ch.chargecode ");
		/**
       	buffer.append(" from (select compensateno, chargecode, sum(chargeamount) as chargeamount ");
       	buffer.append("  from prplcharge ");
       	buffer.append(" group by compensateno, chargecode) ch, ");
       	buffer.append("  prplcompensate t, prplclaim c, prplregist r ");
       	buffer.append(" ,(select distinct payamount, compensateno, '1' as exist,vFlag,paymenttype ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"' " );
        buffer.append(" and paymentType not in ('P60','P50') and paymentType  like 'P%'"); 
        buffer.append(" and payamount<>0 ");
        buffer.append(") pay ");
        */
       	buffer.append(" where ch.compensateno = t.compensateno ");
       	buffer.append(" and t.claimno = c.claimno ");
       	buffer.append(" and c.registno = r.registno ");
       	if("0".equals(status)){
       		buffer.append(" and (select ch.chargeamount - nvl(sum(payamount), 0) ");
       		buffer.append("          from prplpay ");
       		buffer.append("        where prplpay.registno = r.registno ");
       		buffer.append("          and prplpay.compensateno = t.compensateno ");
       		buffer.append("          and prplpay.policyno = t.policyno ");
       		buffer.append("          and changepaymenttypetochargecode(prplpay.paymenttype) = ");
       		buffer.append("              ch.chargecode ");
       		//buffer.append(" and prplpay.paytype = 'P3') <> 0 ");
       		buffer.append(" ) <> 0 ");
       	}
        
       	//buffer.append(" and r.registno in ('报案号码') ");// --？（选择添加）
       	if(registNos!=null&&registNos.size()>0){
    		buffer.append(" and r.registNo in ( ");
    		for(int i=0;i<registNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+registNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
       	//@@@@@@@@@@@@@@@@@@@@@@@@
       	if(paymentNo!=null && !"".equals(paymentNo)&&!"1".equals(status)){
       		//buffer.append(" and  ch.chargecode = changepaymenttypetochargecode(pay.paymenttype) ");
    	}
       	if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType) &&!"P5".equals(payType)){
       		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
       	}
       	if(judgeFlag){//判断标志，当从预赔理算环节进入支付信息页面，无需判断费用是否核赔通过
        	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
        }
      	//buffer.append(" and t.compensateno in ('理算输号') ");
      	if(certiNos!=null&&certiNos.size()>0){
    		buffer.append(" and t.compensateno in ( ");//需更改
    		for(int i=0;i<certiNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+certiNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
      	 if(paymentNo!=null&&!"".equals(paymentNo)&&!"1".equals(status)){
      		 buffer.append(" and pay.compensateno = t.compensateno ");
      	 }else{
      		//buffer.append(" and pay.compensateno(+) = t.compensateno ");
      	 }
      	 buffer.append(" and ch.chargeamount<>0 ");
      	//buffer.append(" and r.comcode like '"+comCodeStr+"%' ");// --？（默认添加）
    	}
      	//--预赔赔款
		//buffer.append(" union all ");
    	if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
		buffer.append(" select r.registno, ");
		buffer.append(" pre.policyno, ");
		buffer.append(" '' as policyType, ");
		buffer.append(" pre.precompensateno as certino, ");
		buffer.append(" c.claimNo, ");
		buffer.append(" '' as coinscode, ");
		buffer.append(" r.insuredname, ");
		buffer.append(" r.licenseno, ");
		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
		buffer.append(" pre.underwriteenddate, ");
		buffer.append(" '预赔赔款' as payType, ");
		buffer.append(" r.comcode, ");
		buffer.append(" '' as comcname, ");
		buffer.append(" (select sum(payamount) ");
		buffer.append(" from prplpay ");
		buffer.append(" where registno = r.registno ");
		buffer.append(" and compensateno = pre.precompensateno ");
		buffer.append(" and policyno = pre.policyno ");
		buffer.append(" and paymenttype = 'P50' "); 
		if(payType!=null&&!"".equals(payType) && !"P5".equals(payType)){
			buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
		}
		if(paymentNo!=null&&!"".equals(paymentNo)){
	    	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
	    }
	    buffer.append(" ) as havPay , ");//--已支付
		buffer.append(" pay.payamount as nowPay,  ");//--本次支付金额
	    buffer.append(" pay.exist  ,  ");//--是否勾选
	    buffer.append(" 'Y' as certitype,  ");
        buffer.append(" 'P50' as payrefreason,  ");
        buffer.append(" pay.vFlag  ");
		buffer.append(" from prplprepay pre, prplclaim c, prplregist r ");
		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist,vFlag ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"' " );
        buffer.append(" and paymenttype = 'P50' ) pay ");
		buffer.append(" where pre.claimno = c.claimno ");
		buffer.append(" and c.registno = r.registno ");
		if("0".equals(status)){
			buffer.append(" and (select pre.sumprepaid - nvl(sum(payamount), 0) ");
			buffer.append("         from prplpay ");
			buffer.append("        where registno = r.registno ");
			buffer.append("          and compensateno = pre.precompensateno ");
			buffer.append("          and policyno = pre.policyno ");
			buffer.append("          and paymenttype = 'P50' ");
			//buffer.append("          and changepaytypetocasetype(paytype) = ");
			//buffer.append("              pre.casetype) <> 0 ");
			buffer.append("              ) <> 0 ");
		}
                     
		//buffer.append(" and r.registno in ('') ");// --？（选择添加）
		if(registNos!=null&&registNos.size()>0){
    		buffer.append(" and r.registNo in ( ");
    		for(int i=0;i<registNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+registNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
		//buffer.append(" and paymenttype = 'P50' ");// 如果选择项不是赔款，需要加1<>1
		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){
			buffer.append(" and 1<>1 ");
		}
		//@@@@@@@@@@@@@@@@@@@@@@@@
		if(payType!=null&&!"".equals(payType) && !"P5".equals(payType)){
			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
		}
		if(judgeFlag){//判断标志，当从预赔理算环节进入支付信息页面，无需判断费用是否核赔通过
        	buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
        }
		//buffer.append(" and pre.precompensateno in ('805073408002011000005') ");
		if(certiNos!=null&&certiNos.size()>0){
    		buffer.append(" and pre.precompensateno in ( ");//需更改
    		for(int i=0;i<certiNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+certiNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
		if(paymentNo!=null&&!"".equals(paymentNo)&&!"1".equals(status)){
			buffer.append(" and pay.compensateno = pre.precompensateno ");
		}else{
			buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
		}
		//buffer.append(" and r.comcode like '"+comCodeStr+"%' ");// --？（默认添加）
		//--预赔费用
		buffer.append(" union all ");
		buffer.append(" select r.registno, ");
		buffer.append(" pre.policyno, ");
		buffer.append(" '' as policyType, ");
		buffer.append(" pch.precompensateno as certino, ");
		buffer.append(" c.claimNo, ");
		buffer.append(" '' as coinscode, ");
		buffer.append(" r.insuredname, ");
		buffer.append(" r.licenseno, ");
		buffer.append(" pch.sumprepaid as sumthispaid, ");
		buffer.append(" pre.underwriteenddate, ");
		buffer.append(" '预赔费用' as payType, ");
		buffer.append(" r.comcode, ");
		buffer.append(" '' as comcname, ");
		buffer.append(" (select sum(payamount) ");
		buffer.append(" from prplpay ");
		buffer.append(" where registno = r.registno ");
		buffer.append(" and compensateno = pre.precompensateno ");
		buffer.append(" and policyno = pre.policyno ");
		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
		if(payType!=null&&!"".equals(payType) && !"P5".equals(payType)){
			buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
		}
		if(paymentNo!=null&&!"".equals(paymentNo)){
	    	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
	    }
	    buffer.append(" ) as havPay , ");//--已支付
		buffer.append(" pay.payamount as nowPay,  ");//--本次支付金额
	    buffer.append(" pay.exist  ,  ");//--是否勾选
	    buffer.append(" 'Y' as certitype,  ");
        //buffer.append(" 'P60' as payrefreason  ");//
        /*buffer.append(" case pch.chargecode  ");
		buffer.append(" when '05' then  ");
		buffer.append("  'Y64'  ");
		buffer.append(" when '07' then  ");
		buffer.append("  'Y61'  ");
		buffer.append(" when '15' then  ");
		buffer.append("  'Y68'  ");
		buffer.append(" when '29' then  ");
		buffer.append("  'Y611'  ");
		buffer.append(" when '30' then  ");
		buffer.append("  'Y612'  ");
		buffer.append(" when '14' then  ");
		buffer.append("  'Y65'  ");
		buffer.append(" when '13' then  ");
		buffer.append("  'Y67'  ");
		buffer.append(" when '04' then  ");
		buffer.append("  'Y62'  ");
		buffer.append(" else  ");
		buffer.append("  'Y69'  ");
		buffer.append("  end as payrefreason,  ");*/
	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason,  ");
	    
		buffer.append("  pay.vFlag  ");
		//buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ");
		
		buffer.append(" from  prplclaim c, prplregist r,prplprepay pre ");
		buffer.append(" join ");
		buffer.append("(select claimno,precompensateno,chargecode, ");
		buffer.append(" sum(sumprepaid) as sumprepaid ");
		buffer.append(" from prplprecharge ");
		buffer.append(" group by claimno, precompensateno, chargecode) pch ");
		buffer.append(" on pre.precompensateno = pch.precompensateno  ");
		buffer.append(" left join ");
		buffer.append(" (select distinct payamount, compensateno, '1' as exist,vFlag,paymenttype ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"' " );
        buffer.append(" and paymenttype  not in ('P50','P60') and paymenttype like 'Y%' ) pay ");
        buffer.append(" on pch.precompensateno = pay.compensateno ");
        buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode(pay.paymenttype) ");
		/**
		buffer.append(" from (select claimno,precompensateno,chargecode, ");
		buffer.append(" sum(sumprepaid) as sumprepaid ");
		buffer.append(" from prplprecharge ");
		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
		buffer.append("  prplprepay pre, prplclaim c, prplregist r ");
		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist,vFlag,paymenttype ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"' " );
        buffer.append(" and paymenttype  not in ('P50','P60') and paymenttype like 'Y%' ) pay ");
        */
        
		buffer.append(" where pch.claimno = c.claimno ");
		buffer.append(" and pch.precompensateno = pre.precompensateno ");
		buffer.append(" and c.registno = r.registno ");
		if("0".equals(status)){
			buffer.append(" and (select pch.sumprepaid - nvl(sum(payamount), 0) ");
			buffer.append("         from prplpay ");
			buffer.append("        where registno = r.registno ");
			buffer.append("          and compensateno = pre.precompensateno ");
			buffer.append("          and policyno = pre.policyno ");
			buffer.append("          and pchangepaymenttypetochargecode(paymenttype) = ");
			buffer.append("             pch.chargecode ");
			//buffer.append("         and changepaytypetocasetype(paytype) = ");
			//buffer.append("             pre.casetype) <> 0 ");
			buffer.append("              ) <> 0 ");
		}
		//buffer.append(" and r.registno in ('报案号码')  ");//--？（选择添加）
		if(registNos!=null&&registNos.size()>0){
    		buffer.append(" and r.registNo in ( ");
    		for(int i=0;i<registNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+registNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
		//@@@@@@@@@@@@@@@@@@@@@@@@
		if(paymentNo!=null&&!"".equals(paymentNo)&&!"1".equals(status)){
			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode(pay.paymenttype) ");
		}
		if(payType!=null&&!"".equals(payType)&& !"P5".equals(payType)){
			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
		}
		
		if(judgeFlag){//判断标志，当从预赔理算环节进入支付信息页面，无需判断费用是否核赔通过
        	buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
        }
		//buffer.append(" and pre.precompensateno in ('预赔号码') ");
		if(certiNos!=null&&certiNos.size()>0){
    		buffer.append(" and pre.precompensateno in ( ");//需更改
    		for(int i=0;i<certiNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+certiNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
		if(paymentNo!=null&&!"".equals(paymentNo)&&!"1".equals(status)){
			buffer.append(" and pay.compensateno = pre.precompensateno ");
		}else{
			//buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
		}
		//buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//--？（默认添加）
    	}
		buffer.append("  ) c  ");
		if(judgeFlag){
			buffer.append("  where exists (select 1  ");
//			buffer.append("  from prpjplanfee rf  ");
			 buffer.append("  from ( select 																										");
			 buffer.append("  certitype        ,						                                    ");
			 buffer.append("  certino          ,                                                ");
			 buffer.append("  policyno         ,                                                ");
			 buffer.append("  serialno         ,                                                ");
			 buffer.append("  payrefreason     ,                                                ");
			 buffer.append("  claimno          ,                                                ");
			 buffer.append("  classcode        ,                                                ");
			 buffer.append("  riskcode         ,                                                ");
			 buffer.append("  contractno       ,                                                ");
			 buffer.append("  applicode        ,                                                ");
			 buffer.append("  appliname        ,                                                ");
			 buffer.append("  insuredcode      ,                                                ");
			 buffer.append("  insuredname      ,                                                ");
			 buffer.append("  startdate        ,                                                ");
			 buffer.append("  enddate          ,                                                ");
			 buffer.append("  validdate        ,                                                ");
			 buffer.append("  payno            ,                                                ");
			 buffer.append("  currency1        ,                                                ");
			 buffer.append("  planfee          ,                                                ");
			 buffer.append("  plandate         ,                                                ");
			 buffer.append("  comcode          ,                                                ");
			 buffer.append("  makecom          ,                                                ");
			 buffer.append("  agentcode        ,                                                ");
			 buffer.append("  handler1code     ,                                                ");
			 buffer.append("  handlercode      ,                                                ");
			 buffer.append("  underwritedate   ,                                                ");
			 buffer.append("  coinsflag        ,                                                ");
			 buffer.append("  coinscode        ,                                                ");
			 buffer.append("  coinsname        ,                                                ");
			 buffer.append("  coinstype        ,                                                ");
			 buffer.append("  centercode       ,                                                ");
			 buffer.append("  branchcode       ,                                                ");
			 buffer.append("  accbooktype      ,                                                ");
			 buffer.append("  accbookcode      ,                                                ");
			 buffer.append("  yearmonth        ,                                                ");
			 buffer.append("  voucherno        ,                                                ");
			 buffer.append("  exchangerate     ,                                                ");
			 buffer.append("  planfeecny       ,                                                ");
			 buffer.append("  payreffee        ,                                                ");
			 buffer.append("  realpayreffee    ,                                                ");
			 buffer.append("  flag             ,                                                ");
			 buffer.append("  businessnature   ,                                                ");
			 buffer.append("  othflag          ,                                                ");
			 buffer.append("  carnaturecode    ,                                                ");
			 buffer.append("  usenaturecode    ,                                                ");
			 buffer.append("  carproperty      ,                                                ");
			 buffer.append("  paycomcode       ,                                                ");
			 buffer.append("  businesstype     ,                                                ");
			 buffer.append("  businesstype1    ,                                                ");
			 buffer.append("  payrefstate      ,                                                ");
			 buffer.append("  recoveryserialno ,                                                ");
			 buffer.append("  update_by        ,                                                ");
			 buffer.append("  update_date      ,                                                ");
			 buffer.append("  vatax            ,                                                ");
			 buffer.append("  ntplanfee        ,                                                ");
			 buffer.append("  dutyratio     from prpjplanfeecoins                               ");
			 buffer.append("  Where Certitype = 'C' And Payrefreason in ("+utiPlatConfigRuleDto.getRule()+") ");
			 buffer.append("  union all                                                         ");
			 buffer.append("  select                                                            ");
			 buffer.append("  certitype        ,						                                    ");
			 buffer.append("  certino          ,                                                ");
			 buffer.append("  policyno         ,                                                ");
			 buffer.append("  serialno         ,                                                ");
			 buffer.append("  payrefreason     ,                                                ");
			 buffer.append("  claimno          ,                                                ");
			 buffer.append("  classcode        ,                                                ");
			 buffer.append("  riskcode         ,                                                ");
			 buffer.append("  contractno       ,                                                ");
			 buffer.append("  applicode        ,                                                ");
			 buffer.append("  appliname        ,                                                ");
			 buffer.append("  insuredcode      ,                                                ");
			 buffer.append("  insuredname      ,                                                ");
			 buffer.append("  startdate        ,                                                ");
			 buffer.append("  enddate          ,                                                ");
			 buffer.append("  validdate        ,                                                ");
			 buffer.append("  payno            ,                                                ");
			 buffer.append("  currency1        ,                                                ");
			 buffer.append("  planfee          ,                                                ");
			 buffer.append("  plandate         ,                                                ");
			 buffer.append("  comcode          ,                                                ");
			 buffer.append("  makecom          ,                                                ");
			 buffer.append("  agentcode        ,                                                ");
			 buffer.append("  handler1code     ,                                                ");
			 buffer.append("  handlercode      ,                                                ");
			 buffer.append("  underwritedate   ,                                                ");
			 buffer.append("  coinsflag        ,                                                ");
			 buffer.append("  coinscode        ,                                                ");
			 buffer.append("  coinsname        ,                                                ");
			 buffer.append("  coinstype        ,                                                ");
			 buffer.append("  centercode       ,                                                ");
			 buffer.append("  branchcode       ,                                                ");
			 buffer.append("  accbooktype      ,                                                ");
			 buffer.append("  accbookcode      ,                                                ");
			 buffer.append("  yearmonth        ,                                                ");
			 buffer.append("  voucherno        ,                                                ");
			 buffer.append("  exchangerate     ,                                                ");
			 buffer.append("  planfeecny       ,                                                ");
			 buffer.append("  payreffee        ,                                                ");
			 buffer.append("  realpayreffee    ,                                                ");
			 buffer.append("  flag             ,                                                ");
			 buffer.append("  businessnature   ,                                                ");
			 buffer.append("  othflag          ,                                                ");
			 buffer.append("  carnaturecode    ,                                                ");
			 buffer.append("  usenaturecode    ,                                                ");
			 buffer.append("  carproperty      ,                                                ");
			 buffer.append("  paycomcode       ,                                                ");
			 buffer.append("  businesstype     ,                                                ");
			 buffer.append("  businesstype1    ,                                                ");
			 buffer.append("  payrefstate      ,                                                ");
			 buffer.append("  recoveryserialno ,                                                ");
			 buffer.append("  update_by        ,                                                ");
			 buffer.append("  update_date      ,                                                ");
			 buffer.append("  vatax            ,                                                ");
			 buffer.append("  ntplanfee        ,                                                ");
			 buffer.append("  dutyratio     from prpjplanfee                                    ");
			 buffer.append("  Where Certitype In ('C', 'Y', 'Z')  ) rf                          ");
			buffer.append("  where c.certino = rf.certino  ");
			buffer.append("   and  rf.certitype = c.certitype  ");
			buffer.append("   and rf.payrefreason = c.payrefreason  ");
			/*if("0".equals(status)){
				buffer.append("   and rf.payrefstate not in ('11','10') ");
			}*/
			/*buffer.append("   and rf.planfee > rf.realpayreffee  ");
			buffer.append("  and rf.planfee > 0");第三方支付赔款支付信息新增修改*/
			//控制三方支付上线前数据不能与上线后数据合并支付 add by chu 20140327
			if("0".equals(status)){
				buffer.append("  and exists (select 1  ");
//				buffer.append("  from prpjpayrefrec ff  ");
		        buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
		        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
		        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
		        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
		        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
		        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
		        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
		        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
		        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
		        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
		        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
		        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
		        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
		        buffer.append( "   Where Certitype = 'C' And Payrefreason in ("+utiPlatConfigRuleDto.getRule()+")      ");
		        buffer.append( "  Union All                                                                            ");
		        buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
		        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
		        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
		        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
		        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
		        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
		        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
		        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
		        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
		        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
		        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
		        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
		        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
		        buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           ff                                   ");
				buffer.append("  where c.certino = ff.certino  ");
				buffer.append("   and  ff.certitype = c.certitype  ");
				buffer.append("   and ff.payrefreason = c.payrefreason  ");
				buffer.append("   and ff.visaserialno is not null and ff.visaserialno like '9%' ");
				buffer.append("   and ff.payrefstate not in ('11','10') ");
				buffer.append(") ");
			}
			buffer.append(") ");
		}
    	
    	
    	
//    	if(registNos.size()>0){
//    		buffer.append(" and r.registNo in ( ");
//    		for(int i=0;i<registNos.size();i++){
//    			if(i!=0)buffer.append(" , ");
//    			buffer.append(" '"+registNos.get(i).trim()+"' ");
//    		}
//    		buffer.append(" ) ");
//    	}
//    	if(certiNos.size()>0){
//    		buffer.append(" and t.compensateno in ( ");//需更改
//    		for(int i=0;i<certiNos.size();i++){
//    			if(i!=0)buffer.append(" , ");
//    			buffer.append(" '"+certiNos.get(i).trim()+"' ");
//    		}
//    		buffer.append(" ) ");
//    	}
		System.err.println(buffer.toString());
		PayQueryConditionLogger.payQueryConditionData("getShowList方法：<br>"+buffer.toString());
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
    	PrpLpayShowDto prpLpayShowDto =null;
    	while(resultSet.next()){
    		prpLpayShowDto = new PrpLpayShowDto();
    		prpLpayShowDto.setRegistNo(dbManager.getString(resultSet,"RegistNo"));
    		prpLpayShowDto.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
    		prpLpayShowDto.setPolicyType(dbManager.getString(resultSet,"PolicyType"));
    		prpLpayShowDto.setCertiNo(dbManager.getString(resultSet,"CertiNo"));
    		prpLpayShowDto.setClaimNo(dbManager.getString(resultSet,"ClaimNo"));
    		prpLpayShowDto.setCoinsCode(dbManager.getString(resultSet,"coinscode"));
    		prpLpayShowDto.setInsuredName(dbManager.getString(resultSet,"InsuredName"));
    		prpLpayShowDto.setLicenseNo(dbManager.getString(resultSet,"LicenseNo"));
    		prpLpayShowDto.setSumPaid(dbManager.getDouble(resultSet,"sumthispaid"));
    		prpLpayShowDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"UnderWriteEndDate").toString(DateTime.YEAR_TO_SECOND));
    		prpLpayShowDto.setPayType(dbManager.getString(resultSet,"PayType"));
    		prpLpayShowDto.setComCode(dbManager.getString(resultSet,"ComCode"));
    		prpLpayShowDto.setComCodeName(dbManager.getString(resultSet,"ComCName"));
    		prpLpayShowDto.setHavPaid(dbManager.getDouble(resultSet,"HavPay"));
    		prpLpayShowDto.setNowPaid(dbManager.getDouble(resultSet,"NowPay"));
    		prpLpayShowDto.setExist(dbManager.getString(resultSet,"Exist"));
    		prpLpayShowDto.setVflag(dbManager.getString(resultSet, "vFlag"));
    		prpLpayShowDto.setPayrefreason(dbManager.getString(resultSet, "payrefreason"));
    		prpLpayShowDto.setClassCode(dbManager.getString(resultSet,"RegistNo"));
    		list.add(prpLpayShowDto);
    	}
    	resultSet.close();
    	return list;
    }
    /**
	 * 支付信息查询列表显示方法
	 * @param payType	支付类型
	 * @param paymentType	赔款类型
	 * @param comCode	机构号码
	 * @param registNos	报案号集合
	 * @param certiNos	业务号集合
	 * @return
	 * @throws Exception
	 */
    public ArrayList<PrpLpayShowDto> getNewQueryShowList(String payType,String paymentType,String conditions,int pageNo,int rowsPerPage)throws Exception{
    	//String comCodeStr = comCode.substring(0, 6);
    	//String conditions="";
    	//String paymentNo="";
    	System.err.println(222222);
    	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
    	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
    	StringBuffer buffer = new StringBuffer(200);
    	buffer.append(" select registno,Policyno,Policytype,Certino,Claimno,Insuredname,Licenseno,Sumthispaid,Underwriteenddate,Paytype,Comcode,(select cop.comcname from prpdcompany cop where cop.comcode = c.comcode) as Comcname,Havpay,Certitype,Payrefreason,Flowid ");
    	buffer.append(" from (  ");
    	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
    	//--赔款
    	buffer.append(" select r.registno, ");
    	buffer.append(" t.policyno, ");
		buffer.append(" '' as policyType, ");
    	buffer.append(" t.compensateno as certino, ");
    	buffer.append(" c.claimNo, ");
    	buffer.append(" r.insuredname, ");
    	buffer.append(" r.licenseno, ");
		buffer.append("  t.sumthispaid, ");
        //buffer.append("   t.underwriteenddate, ");
        buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
        buffer.append("  '赔款' as payType, ");
        buffer.append(" r.comcode, ");
        buffer.append(" '' as comcname, ");
    	buffer.append(" (select sum(payamount) ");
        buffer.append(" from prplpay prplpay ");
        buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno = t.compensateno ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and prplpay.paymenttype = 'P60' ");
        buffer.append(" and prplpay.paytype = 'P3' ");
        
        /**
        if(paymentNo!=null&&!"".equals(paymentNo)){
        	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
        }
        */
        
        buffer.append(" ) as havPay,  ");//--已支付
        buffer.append(" 'C' as certitype,  ");
        buffer.append(" 'P60' as payrefreason,  ");
        buffer.append(" '0' as flowid ");
        buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
        /**
        buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
        buffer.append(" pay.exist    ");//--是否勾选
        
        buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
        buffer.append(" and pay.compensateno(+) = t.compensateno ");
        */
        buffer.append(" where t.claimno = c.claimno ");
        buffer.append(" and c.registno = r.registno "); 
        if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
        	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
        }
        if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
        	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
        }
        buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
        buffer.append(" and r.classcode<>'05' ");
        //添加已支付完成的查询不出来条件
		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
		buffer.append(" from prplpay ");
		buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno = t.compensateno ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and prplpay.paymenttype = 'P60' ");
        buffer.append(" and prplpay.paytype = 'P3' ");
		//buffer.append(" and payflag='1' ");
	    buffer.append(" )>0  ");//--已支付
	    //添加已支付完成的查询不出来条件
        buffer.append(conditions);
        /**
        if(registNos!=null&&registNos.size()>0){
    		buffer.append(" and r.registNo in ( ");
    		for(int i=0;i<registNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+registNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
        
        //buffer.append(" and t.compensateno in ('理算书号') ");
        if(certiNos!=null&&certiNos.size()>0){
    		buffer.append(" and t.compensateno in ( ");
    		for(int i=0;i<certiNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+certiNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
        buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//--？（默认添加）
        */
        buffer.append(" and 2=2 ");
        
        //代付共保赔款
        buffer.append(" union all ");
    	buffer.append(" select r.registno, ");
    	buffer.append(" t.policyno, ");
		buffer.append(" '' as policyType, ");
    	buffer.append(" co.businessno as certino, ");
    	buffer.append(" c.claimNo, ");
    	buffer.append(" r.insuredname, ");
    	buffer.append(" r.licenseno, ");
		buffer.append("   co.coinssumpaid as Sumthispaid, ");
        //buffer.append("   t.underwriteenddate, ");
        buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
        buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
        buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
        buffer.append(" r.comcode, ");
        buffer.append(" '' as comcname, ");
    	buffer.append(" (select sum(payamount) ");
        buffer.append(" from prplpay prplpay ");
        buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno =  co.businessno and prplpay.coinscode=co.coinscode ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
        buffer.append(" and prplpay.paytype = 'P3' ");
        
        /**
        if(paymentNo!=null&&!"".equals(paymentNo)){
        	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
        }
        */
        
        buffer.append(" ) as havPay,  ");//--已支付
        buffer.append(" 'C' as certitype,  ");
        buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
        buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason,  ");
        buffer.append(" '0' as flowid ");
        buffer.append(" from prplcompensate t, prplclaim c, prplregist r,prplcfeecoins  co ");
        /**
        buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
        buffer.append(" pay.exist    ");//--是否勾选
        
        buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
        buffer.append(" and pay.compensateno(+) = t.compensateno ");
        */
        buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
        buffer.append(" and c.registno = r.registno "); 
        if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
        	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
        }
        if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
        	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
        }
        buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
        buffer.append(" and r.classcode<>'05' ");
        //添加已支付完成的查询不出来条件
		buffer.append(" and (select co.coinssumpaid-nvl(sum(payamount),0) ");
		buffer.append(" from prplpay ");
		buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
        buffer.append(" and prplpay.paytype = 'P3' ");
		//buffer.append(" and payflag='1' ");
	    buffer.append(" )>0  ");//--已支付
	    //添加已支付完成的查询不出来条件
        buffer.append(conditions);
        /**
        if(registNos!=null&&registNos.size()>0){
    		buffer.append(" and r.registNo in ( ");
    		for(int i=0;i<registNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+registNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
        
        //buffer.append(" and t.compensateno in ('理算书号') ");
        if(certiNos!=null&&certiNos.size()>0){
    		buffer.append(" and t.compensateno in ( ");
    		for(int i=0;i<certiNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+certiNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
        buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//--？（默认添加）
        */
        buffer.append(" and 2=2 ");
        
        
        
        
        
		//--赔付费用
        buffer.append(" union all ");
        buffer.append(" select r.registno, ");
        buffer.append(" t.policyno, ");
		buffer.append(" '' as policyType, ");
        buffer.append("  t.compensateno as certino, ");
        buffer.append(" c.claimNo, ");
        buffer.append(" r.insuredname, ");
        buffer.append(" r.licenseno, ");
        buffer.append(" nvl(ch.chargeamount,0)-nvl(ch.sumrealpay,0) as sumthispaid, ");
        //buffer.append(" t.underwriteenddate, ");
        buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
       // buffer.append(" '赔付费用' as payType, ");
        /*buffer.append(" case ch.chargecode ");
	    buffer.append(" when '05' then '诉讼费' "); 
	    buffer.append(" when '07' then '检验鉴定费' ");  
	    buffer.append("  when '15' then '律师费'  ");
	    buffer.append(" when '29' then '仲裁费'  ");
	    buffer.append(" when '30' then '执行费'   ");
	    buffer.append(" when '14' then '内部代查勘费'  ");
	    buffer.append(" when '13' then '外部代查勘费'  "); 
	    buffer.append(" when '04' then '机构查勘费'  ");
	    buffer.append("  else '' end as paytype, ");*/
        buffer.append("  changechargecodetochargename(ch.chargecode) as paytype, ");
        buffer.append(" r.comcode, ");
        buffer.append(" '' as comcname, ");
        buffer.append(" (select sum(payamount) ");
        buffer.append(" from prplpay prplpay ");
       	buffer.append(" where prplpay.registno = r.registno ");
       	buffer.append(" and prplpay.compensateno = t.compensateno ");
       	buffer.append(" and prplpay.policyno = t.policyno ");
       	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
       	buffer.append("  and prplpay.paytype = 'P3' ");
       	
       	/**
        if(paymentNo!=null&&!"".equals(paymentNo)){
        	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
        }
        */
       	
        buffer.append(" ) as havPay , ");//--已支付
        buffer.append(" 'C' as certitype,  ");
        /*buffer.append(" case ch.chargecode  ");
		buffer.append(" when '05' then  ");
		buffer.append("  'P64'  ");
		buffer.append(" when '07' then  ");
		buffer.append("  'P61'  ");
		buffer.append(" when '15' then  ");
		buffer.append("  'P68'  ");
		buffer.append(" when '29' then  ");
		buffer.append("  'P611'  ");
		buffer.append(" when '30' then  ");
		buffer.append("  'P612'  ");
		buffer.append(" when '14' then  ");
		buffer.append("  'P65'  ");
		buffer.append(" when '13' then  ");
		buffer.append("  'P67'  ");
		buffer.append(" when '04' then  ");
		buffer.append("  'P62'  ");
		buffer.append(" else  ");
		buffer.append("  ''  ");
		buffer.append("  end as payrefreason,  ");*/
        buffer.append("  changechargecodetopaymenttype(ch.chargecode) as payrefreason,  ");
		buffer.append(" '0' as flowid ");
       	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r  ");
       	/**
       	buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
       	buffer.append(" pay.exist    ");//--是否勾选
       	buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
       	buffer.append(" and pay.compensateno(+) = t.compensateno ");
        */
       	
       	buffer.append(" where ch.compensateno = t.compensateno ");
       	buffer.append(" and t.claimno = c.claimno ");
       	buffer.append(" and c.registno = r.registno ");
       	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
       		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
       	}
       	if(payType != null&&!"".equals(payType)&&!"P3".equals(payType)){
       		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
       	}
       	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
       	buffer.append(" and r.classcode<>'05' ");
       	//添加已支付完成的查询不出来条件
		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
		buffer.append(" from prplpay ");
		buffer.append(" where prplpay.registno = r.registno ");
       	buffer.append(" and prplpay.compensateno = t.compensateno ");
       	buffer.append(" and prplpay.policyno = t.policyno ");
       	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
       	buffer.append(" and prplpay.paytype = 'P3' ");
		//buffer.append(" and payflag='1' ");
	    buffer.append(" )>0  ");//--已支付
	    //添加已支付完成的查询不出来条件
       	buffer.append(conditions);
       	
       	/**
       	if(registNos!=null&&registNos.size()>0){
    		buffer.append(" and r.registNo in ( ");
    		for(int i=0;i<registNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+registNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
      	if(certiNos!=null&&certiNos.size()>0){
    		buffer.append(" and t.compensateno in ( ");//需更改
    		for(int i=0;i<certiNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+certiNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
      	buffer.append(" and r.comcode like '"+comCodeStr+"%' ");// --？（默认添加）
      	*/
    	}
      	//--预赔赔款
		//buffer.append(" union all ");
    	if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
		buffer.append(" select r.registno, ");
		buffer.append(" pre.policyno, ");
		buffer.append(" '' as policyType, ");
		buffer.append(" pre.precompensateno as certino, ");
		buffer.append(" c.claimNo, ");
		buffer.append(" r.insuredname, ");
		buffer.append(" r.licenseno, ");
		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
		//buffer.append(" pre.underwriteenddate, ");
		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
		buffer.append(" '预赔赔款' as payType, ");
		buffer.append(" r.comcode, ");
		buffer.append(" '' as comcname, ");
		buffer.append(" (select sum(payamount) ");
		buffer.append(" from prplpay ");
		buffer.append(" where registno = r.registno ");
		buffer.append(" and compensateno = pre.precompensateno ");
		buffer.append(" and policyno = pre.policyno ");
		buffer.append(" and paymenttype = 'P50' "); 
		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
		
		/**
		if(paymentNo!=null&&!"".equals(paymentNo)){
	    	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
	    }
	    */
		
	    buffer.append(" ) as havPay , ");//--已支付
	    buffer.append(" 'Y' as certitype, ");
	    buffer.append(" 'P50' as payrefreason, ");
	    buffer.append(" '0' as flowid ");
		buffer.append(" from prplprepay pre, prplclaim c, prplregist r  ");
		/**
		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
		buffer.append(" pay.exist    ");//--是否勾选
		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
        */
		buffer.append(" where pre.claimno = c.claimno ");
		buffer.append(" and c.registno = r.registno ");
		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
			buffer.append(" and 1<>1 ");
		}
		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
		if(payType==null||"".equals(payType)){
			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
		}else{
			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
		}
		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
		buffer.append(" and r.classcode<>'05' ");
		//添加已支付完成的查询不出来条件
		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
		buffer.append(" from prplpay ");
		buffer.append(" where registno = r.registno ");
		buffer.append(" and compensateno = pre.precompensateno ");
		buffer.append(" and policyno = pre.policyno ");
		buffer.append(" and paymenttype = 'P50' "); 
		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
		//buffer.append(" and payflag='1' ");
	    buffer.append(" )>0  ");//--已支付
	    //添加已支付完成的查询不出来条件
		buffer.append(conditions);
		
		/**
		if(registNos!=null&&registNos.size()>0){
    		buffer.append(" and r.registNo in ( ");
    		for(int i=0;i<registNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+registNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
		//buffer.append(" and pre.precompensateno in ('805073408002011000005') ");
		if(certiNos!=null&&certiNos.size()>0){
    		buffer.append(" and pre.precompensateno in ( ");//需更改
    		for(int i=0;i<certiNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+certiNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
		*/
		
		
		//--预赔费用
		buffer.append(" union all ");
		buffer.append(" select r.registno, ");
		buffer.append(" pre.policyno, ");
		buffer.append(" '' as policyType, ");
		buffer.append(" pch.precompensateno as certino, ");
		buffer.append(" c.claimNo, ");
		buffer.append(" r.insuredname, ");
		buffer.append(" r.licenseno, ");
		buffer.append(" pch.sumprepaid as sumthispaid, ");
		//buffer.append(" pre.underwriteenddate, ");
		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
		//buffer.append(" '预赔费用' as payType, ");
		/*buffer.append(" case pch.chargecode  ");
		buffer.append(" when '05' then '诉讼费'  ");
	    buffer.append(" when '07' then '检验鉴定费'   ");
	    buffer.append(" when '15' then '律师费'  ");
	    buffer.append(" when '29' then '仲裁费'  ");
	    buffer.append(" when '30' then '执行费'  "); 
	    buffer.append(" when '14' then '内部代查勘费' "); 
	    buffer.append(" when '13' then '外部代查勘费'  "); 
	    buffer.append(" when '04' then '机构查勘费'  ");
	    buffer.append(" else '' end as payType,");*/
		buffer.append(" pchangechargecodetochargename(pch.chargecode) as payType,");
		buffer.append(" r.comcode, ");
		buffer.append(" '' as comcname, ");
		buffer.append(" (select sum(payamount) ");
		buffer.append(" from prplpay ");
		buffer.append(" where registno = r.registno ");
		buffer.append(" and compensateno = pre.precompensateno ");
		buffer.append(" and policyno = pre.policyno ");
		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
	    buffer.append(" ) as havPay,  ");//--已支付
	    buffer.append(" 'Y' as certitype, ");
	    /*buffer.append(" case pch.chargecode  ");
		buffer.append(" when '05' then  ");
		buffer.append("  'Y64'  ");
		buffer.append(" when '07' then  ");
		buffer.append("  'Y61'  ");
		buffer.append(" when '15' then  ");
		buffer.append("  'Y68'  ");
		buffer.append(" when '29' then  ");
		buffer.append("  'Y611'  ");
		buffer.append(" when '30' then  ");
		buffer.append("  'Y612'  ");
		buffer.append(" when '14' then  ");
		buffer.append("  'Y65'  ");
		buffer.append(" when '13' then  ");
		buffer.append("  'Y67'  ");
		buffer.append(" when '04' then  ");
		buffer.append("  'Y62'  ");
		buffer.append(" else  ");
		buffer.append("  'Y69'  ");
		buffer.append("  end as payrefreason,  ");*/
	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason,  ");
		buffer.append(" '0' as flowid ");
		buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r  ");
		/**
		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
		buffer.append(" pay.exist    ");//--是否勾选
		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
        */
		buffer.append(" where pch.claimno = c.claimno ");
		buffer.append(" and pch.precompensateno = pre.precompensateno ");
		buffer.append(" and c.registno = r.registno ");
		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
		}
		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
		if(payType==null||"".equals(payType)){
			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
		}else{
			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
		}
		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
		buffer.append(" and r.classcode<>'05' ");
		//添加已支付完成的查询不出来条件
		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
		buffer.append(" from prplpay ");
		buffer.append(" where registno = r.registno ");
		buffer.append(" and compensateno = pre.precompensateno ");
		buffer.append(" and policyno = pre.policyno ");
		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
		//buffer.append(" and payflag='1' ");
	    buffer.append(" )>0  ");//--已支付
	    //添加已支付完成的查询不出来条件
		buffer.append(conditions);
		/**
		 * 
		if(registNos!=null&&registNos.size()>0){
    		buffer.append(" and r.registNo in ( ");
    		for(int i=0;i<registNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+registNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
		//buffer.append(" and pre.precompensateno in ('预赔号码') ");
		if(certiNos!=null&&certiNos.size()>0){
    		buffer.append(" and pre.precompensateno in ( ");//需更改
    		for(int i=0;i<certiNos.size();i++){
    			if(i!=0)buffer.append(" , ");
    			buffer.append(" '"+certiNos.get(i).trim()+"' ");
    		}
    		buffer.append(" ) ");
    	}
		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
		
		*/
    	}
		buffer.append(" ) c  ");
		buffer.append("  where exists (select 1  ");
//		buffer.append("  from prpjplanfee rf  ");
		 buffer.append("  from ( select 																										");
		 buffer.append("  certitype        ,						                                    ");
		 buffer.append("  certino          ,                                                ");
		 buffer.append("  policyno         ,                                                ");
		 buffer.append("  serialno         ,                                                ");
		 buffer.append("  payrefreason     ,                                                ");
		 buffer.append("  claimno          ,                                                ");
		 buffer.append("  classcode        ,                                                ");
		 buffer.append("  riskcode         ,                                                ");
		 buffer.append("  contractno       ,                                                ");
		 buffer.append("  applicode        ,                                                ");
		 buffer.append("  appliname        ,                                                ");
		 buffer.append("  insuredcode      ,                                                ");
		 buffer.append("  insuredname      ,                                                ");
		 buffer.append("  startdate        ,                                                ");
		 buffer.append("  enddate          ,                                                ");
		 buffer.append("  validdate        ,                                                ");
		 buffer.append("  payno            ,                                                ");
		 buffer.append("  currency1        ,                                                ");
		 buffer.append("  planfee          ,                                                ");
		 buffer.append("  plandate         ,                                                ");
		 buffer.append("  comcode          ,                                                ");
		 buffer.append("  makecom          ,                                                ");
		 buffer.append("  agentcode        ,                                                ");
		 buffer.append("  handler1code     ,                                                ");
		 buffer.append("  handlercode      ,                                                ");
		 buffer.append("  underwritedate   ,                                                ");
		 buffer.append("  coinsflag        ,                                                ");
		 buffer.append("  coinscode        ,                                                ");
		 buffer.append("  coinsname        ,                                                ");
		 buffer.append("  coinstype        ,                                                ");
		 buffer.append("  centercode       ,                                                ");
		 buffer.append("  branchcode       ,                                                ");
		 buffer.append("  accbooktype      ,                                                ");
		 buffer.append("  accbookcode      ,                                                ");
		 buffer.append("  yearmonth        ,                                                ");
		 buffer.append("  voucherno        ,                                                ");
		 buffer.append("  exchangerate     ,                                                ");
		 buffer.append("  planfeecny       ,                                                ");
		 buffer.append("  payreffee        ,                                                ");
		 buffer.append("  realpayreffee    ,                                                ");
		 buffer.append("  flag             ,                                                ");
		 buffer.append("  businessnature   ,                                                ");
		 buffer.append("  othflag          ,                                                ");
		 buffer.append("  carnaturecode    ,                                                ");
		 buffer.append("  usenaturecode    ,                                                ");
		 buffer.append("  carproperty      ,                                                ");
		 buffer.append("  paycomcode       ,                                                ");
		 buffer.append("  businesstype     ,                                                ");
		 buffer.append("  businesstype1    ,                                                ");
		 buffer.append("  payrefstate      ,                                                ");
		 buffer.append("  recoveryserialno ,                                                ");
		 buffer.append("  update_by        ,                                                ");
		 buffer.append("  update_date      ,                                                ");
		 buffer.append("  vatax            ,                                                ");
		 buffer.append("  ntplanfee        ,                                                ");
		 buffer.append("  dutyratio     from prpjplanfeecoins                               ");
		 buffer.append("  Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+") ");
		 buffer.append("  union all                                                         ");
		 buffer.append("  select                                                            ");
		 buffer.append("  certitype        ,						                                    ");
		 buffer.append("  certino          ,                                                ");
		 buffer.append("  policyno         ,                                                ");
		 buffer.append("  serialno         ,                                                ");
		 buffer.append("  payrefreason     ,                                                ");
		 buffer.append("  claimno          ,                                                ");
		 buffer.append("  classcode        ,                                                ");
		 buffer.append("  riskcode         ,                                                ");
		 buffer.append("  contractno       ,                                                ");
		 buffer.append("  applicode        ,                                                ");
		 buffer.append("  appliname        ,                                                ");
		 buffer.append("  insuredcode      ,                                                ");
		 buffer.append("  insuredname      ,                                                ");
		 buffer.append("  startdate        ,                                                ");
		 buffer.append("  enddate          ,                                                ");
		 buffer.append("  validdate        ,                                                ");
		 buffer.append("  payno            ,                                                ");
		 buffer.append("  currency1        ,                                                ");
		 buffer.append("  planfee          ,                                                ");
		 buffer.append("  plandate         ,                                                ");
		 buffer.append("  comcode          ,                                                ");
		 buffer.append("  makecom          ,                                                ");
		 buffer.append("  agentcode        ,                                                ");
		 buffer.append("  handler1code     ,                                                ");
		 buffer.append("  handlercode      ,                                                ");
		 buffer.append("  underwritedate   ,                                                ");
		 buffer.append("  coinsflag        ,                                                ");
		 buffer.append("  coinscode        ,                                                ");
		 buffer.append("  coinsname        ,                                                ");
		 buffer.append("  coinstype        ,                                                ");
		 buffer.append("  centercode       ,                                                ");
		 buffer.append("  branchcode       ,                                                ");
		 buffer.append("  accbooktype      ,                                                ");
		 buffer.append("  accbookcode      ,                                                ");
		 buffer.append("  yearmonth        ,                                                ");
		 buffer.append("  voucherno        ,                                                ");
		 buffer.append("  exchangerate     ,                                                ");
		 buffer.append("  planfeecny       ,                                                ");
		 buffer.append("  payreffee        ,                                                ");
		 buffer.append("  realpayreffee    ,                                                ");
		 buffer.append("  flag             ,                                                ");
		 buffer.append("  businessnature   ,                                                ");
		 buffer.append("  othflag          ,                                                ");
		 buffer.append("  carnaturecode    ,                                                ");
		 buffer.append("  usenaturecode    ,                                                ");
		 buffer.append("  carproperty      ,                                                ");
		 buffer.append("  paycomcode       ,                                                ");
		 buffer.append("  businesstype     ,                                                ");
		 buffer.append("  businesstype1    ,                                                ");
		 buffer.append("  payrefstate      ,                                                ");
		 buffer.append("  recoveryserialno ,                                                ");
		 buffer.append("  update_by        ,                                                ");
		 buffer.append("  update_date      ,                                                ");
		 buffer.append("  vatax            ,                                                ");
		 buffer.append("  ntplanfee        ,                                                ");
		 buffer.append("  dutyratio     from prpjplanfee                                    ");
		 buffer.append("  Where Certitype In ('C', 'Y', 'Z')  ) rf                          ");
		buffer.append("  where c.certino = rf.certino  ");
		buffer.append("   and  rf.certitype = c.certitype  ");
		buffer.append("   and rf.payrefreason = c.payrefreason  ");
		buffer.append("   and rf.planfee > rf.realpayreffee  ");
		buffer.append("  and rf.planfee > 0) order by underwriteenddate ");
		if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                //supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                //supportPaging=true;
            }
        }System.err.println(buffer.toString());
		PayQueryConditionLogger.payQueryConditionData("getNewQueryShowList——1方法：<br>"+buffer.toString());
    	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
    	PrpLpayShowDto prpLpayShowDto =null;
    	while(resultSet.next()){
    		prpLpayShowDto = new PrpLpayShowDto();
    		prpLpayShowDto.setRegistNo(dbManager.getString(resultSet,"RegistNo"));
    		prpLpayShowDto.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
    		prpLpayShowDto.setPolicyType(dbManager.getString(resultSet,"PolicyType"));
    		prpLpayShowDto.setCertiNo(dbManager.getString(resultSet,"CertiNo"));
    		prpLpayShowDto.setClaimNo(dbManager.getString(resultSet,"ClaimNo"));
    		prpLpayShowDto.setInsuredName(dbManager.getString(resultSet,"InsuredName"));
    		prpLpayShowDto.setLicenseNo(dbManager.getString(resultSet,"LicenseNo"));
    		prpLpayShowDto.setSumPaid(dbManager.getDouble(resultSet,"sumthispaid"));
    		prpLpayShowDto.setUnderWriteEndDate(dbManager.getString(resultSet,"UnderWriteEndDate"));
    		prpLpayShowDto.setPayType(dbManager.getString(resultSet,"PayType"));
    		prpLpayShowDto.setComCode(dbManager.getString(resultSet,"ComCode"));
    		prpLpayShowDto.setComCodeName(dbManager.getString(resultSet,"ComCName"));
    		prpLpayShowDto.setHavPaid(dbManager.getDouble(resultSet,"HavPay"));
    		prpLpayShowDto.setFlowId(dbManager.getString(resultSet, "flowid"));
    		prpLpayShowDto.setPayrefreason(dbManager.getString(resultSet, "payrefreason"));
    		//prpLpayShowDto.setNowPaid(dbManager.getDouble(resultSet,"NowPay"));
    		//prpLpayShowDto.setExist(dbManager.getString(resultSet,"Exist"));
    		list.add(prpLpayShowDto);
    	}
    	resultSet.close();
    	return list;
    }
    
    /**
   	 * 支付信息查询列表显示方法
   	 * @param payType	支付类型
   	 * @param paymentType	赔款类型
   	 * @param comCode	机构号码
   	 * @param registNos	报案号集合
   	 * @param certiNos	业务号集合
   	 * @return
   	 * @throws Exception
   	 */
       public ArrayList<PrpLpayShowDto> getNewQueryShowList(String payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
       	//String comCodeStr = comCode.substring(0, 6);
       	//String conditions="";
       	//String paymentNo="";
    	   System.err.println(333333+"单笔支付-确定");
    	DateTime billUpDate = new DateTime(AppConfig.get("sysconst.BILLUpDATE"),DateTime.YEAR_TO_DAY); 
       	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
       	StringBuffer buffer = new StringBuffer(200);
       	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
       	buffer.append(" select registno,Policyno,Policytype,Certino,Claimno,Insuredname,Licenseno,Sumthispaid,Underwriteenddate,Paytype,Comcode,(select cop.comcname from prpdcompany cop where cop.comcode = c.comcode) as Comcname,Havpay,Certitype,Payrefreason,Flowid,claimrelationno ");
       	buffer.append(" from (  ");
       	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
       	//--赔款
       	buffer.append(" select r.registno, ");
       	buffer.append(" t.policyno, ");
   		buffer.append(" '' as policyType, ");
       	buffer.append(" t.compensateno as certino, ");
       	buffer.append(" c.claimNo, ");
       	buffer.append(" r.insuredname, ");
       	buffer.append(" r.licenseno, ");
   		buffer.append("  t.sumthispaid, ");
           //buffer.append("   t.underwriteenddate, ");
           buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
           buffer.append("  '赔款' as payType, ");
           buffer.append(" r.comcode, ");
           buffer.append(" '' as comcname, ");
       	buffer.append(" (select sum(payamount) ");
           buffer.append(" from prplpay prplpay ");
           buffer.append(" where prplpay.registno = r.registno ");
           buffer.append(" and prplpay.compensateno = t.compensateno ");
           buffer.append(" and prplpay.policyno = t.policyno ");
           buffer.append(" and prplpay.paymenttype = 'P60' ");
           buffer.append(" and prplpay.paytype = 'P3' ");
           
           /**
           if(paymentNo!=null&&!"".equals(paymentNo)){
           	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
           }
           */
           
           buffer.append(" ) as havPay,  ");//--已支付
           buffer.append(" 'C' as certitype,  ");
           buffer.append(" 'P60' as payrefreason,  ");
           buffer.append(" '0' as flowid, ");
           buffer.append(" case when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='31' then ");
           buffer.append(" t.claimrelationno ");
           buffer.append(" when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='32' then  ");
           buffer.append(" (select distinct aa.compensateno from prplclaimbillmanager aa where aa.compensateno=t.compensateno) ");
           buffer.append(" else ");
           buffer.append(" '' ");
           buffer.append(" end as claimrelationno ");
           buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
           /**
           buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
           buffer.append(" pay.exist    ");//--是否勾选
           
           buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
           buffer.append(" from prplpay ");
           buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
           buffer.append(" and pay.compensateno(+) = t.compensateno ");
           */
           buffer.append(" where t.claimno = c.claimno ");
           buffer.append(" and c.registno = r.registno "); 
           if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
           	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
           }
           if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
           	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
           }
           buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
           if("mechanism".equals(casesType)){
         	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
         	 
           }else if("agnet".equals(casesType)){
         	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
           }
           buffer.append(" and r.classcode<>'05' ");
           //添加已支付完成的查询不出来条件
   		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
   		buffer.append(" from prplpay ");
   		buffer.append(" where prplpay.registno = r.registno ");
           buffer.append(" and prplpay.compensateno = t.compensateno ");
           buffer.append(" and prplpay.policyno = t.policyno ");
           buffer.append(" and prplpay.paymenttype = 'P60' ");
           buffer.append(" and prplpay.paytype = 'P3' ");
   		//buffer.append(" and payflag='1' ");
   	    buffer.append(" )<> 0  ");//--已支付
   	    //添加已支付完成的查询不出来条件
           buffer.append(conditions);
           /**
           if(registNos!=null&&registNos.size()>0){
       		buffer.append(" and r.registNo in ( ");
       		for(int i=0;i<registNos.size();i++){
       			if(i!=0)buffer.append(" , ");
       			buffer.append(" '"+registNos.get(i).trim()+"' ");
       		}
       		buffer.append(" ) ");
       	}
           
           //buffer.append(" and t.compensateno in ('理算书号') ");
           if(certiNos!=null&&certiNos.size()>0){
       		buffer.append(" and t.compensateno in ( ");
       		for(int i=0;i<certiNos.size();i++){
       			if(i!=0)buffer.append(" , ");
       			buffer.append(" '"+certiNos.get(i).trim()+"' ");
       		}
       		buffer.append(" ) ");
       	}
           buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//--？（默认添加）
           */
   	buffer.append(" and 3=3 ");   
   	
   	
   	//代付共保赔款
    buffer.append(" union all ");
	buffer.append(" select r.registno, ");
   	buffer.append(" t.policyno, ");
		buffer.append(" '' as policyType, ");
   	buffer.append(" co.businessno as certino, ");
   	buffer.append(" c.claimNo, ");
   	buffer.append(" co.coinsname AS Insuredname, ");
   	buffer.append(" r.licenseno, ");
		buffer.append("  co.coinssumpaid, ");
       //buffer.append("   t.underwriteenddate, ");
       buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
       buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
       buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
       buffer.append(" r.comcode, ");
       buffer.append(" '' as comcname, ");
   	buffer.append(" (select sum(payamount) ");
       buffer.append(" from prplpay prplpay ");
       buffer.append(" where prplpay.registno = r.registno ");
       buffer.append(" and prplpay.compensateno =co.businessno  and prplpay.coinscode=co.coinscode ");
       buffer.append(" and prplpay.policyno = t.policyno ");
       buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
       buffer.append(" and prplpay.paytype = 'P3' ");
       
       /**
       if(paymentNo!=null&&!"".equals(paymentNo)){
       	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
       }
       */
       
       buffer.append(" ) as havPay,  ");//--已支付
       buffer.append(" 'C' as certitype,  ");
       buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
       buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason,  ");
       buffer.append(" '0' as flowid, ");
       buffer.append(" case when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='31' then ");
       buffer.append(" t.claimrelationno ");
       buffer.append(" when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='32' then  ");
       buffer.append(" (select distinct aa.compensateno from prplclaimbillmanager aa where aa.compensateno=t.compensateno) ");
       buffer.append(" else ");
       buffer.append(" '' ");
       buffer.append(" end as claimrelationno ");
       buffer.append(" from prplcompensate t, prplclaim c, prplregist r ,prplcfeecoins co");
       /**
       buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
       buffer.append(" pay.exist    ");//--是否勾选
       
       buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
       buffer.append(" from prplpay ");
       buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
       buffer.append(" and pay.compensateno(+) = t.compensateno ");
       */
       buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
       buffer.append(" and c.registno = r.registno "); 
       if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
       	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
       }
       if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
       	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
       }
       buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
       if("mechanism".equals(casesType)){
     	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
     	 
       }else if("agnet".equals(casesType)){
     	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
       }
       buffer.append(" and r.classcode<>'05' ");
       //添加已支付完成的查询不出来条件
		buffer.append(" and (select co.coinssumpaid-nvl(sum(payamount),0) ");
		buffer.append(" from prplpay ");
		buffer.append(" where prplpay.registno = r.registno ");
       buffer.append(" and prplpay.compensateno = co.businessno  and prplpay.coinscode=co.coinscode ");
       buffer.append(" and prplpay.policyno = t.policyno ");
       buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
       buffer.append(" and prplpay.paytype = 'P3' ");
		//buffer.append(" and payflag='1' ");
	    buffer.append(" )<> 0  ");//--已支付
	    //添加已支付完成的查询不出来条件
       buffer.append(conditions);
       /**
       if(registNos!=null&&registNos.size()>0){
   		buffer.append(" and r.registNo in ( ");
   		for(int i=0;i<registNos.size();i++){
   			if(i!=0)buffer.append(" , ");
   			buffer.append(" '"+registNos.get(i).trim()+"' ");
   		}
   		buffer.append(" ) ");
   	}
       
       //buffer.append(" and t.compensateno in ('理算书号') ");
       if(certiNos!=null&&certiNos.size()>0){
   		buffer.append(" and t.compensateno in ( ");
   		for(int i=0;i<certiNos.size();i++){
   			if(i!=0)buffer.append(" , ");
   			buffer.append(" '"+certiNos.get(i).trim()+"' ");
   		}
   		buffer.append(" ) ");
   	}
       buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//--？（默认添加）
       */
	buffer.append(" and 3=3 ");   
   	
   	
   		//--赔付费用
           buffer.append(" union all ");
           buffer.append(" select r.registno, ");
           buffer.append(" t.policyno, ");
   		buffer.append(" '' as policyType, ");
           buffer.append("  t.compensateno as certino, ");
           buffer.append(" c.claimNo, ");
           buffer.append(" r.insuredname, ");
           buffer.append(" r.licenseno, ");
           buffer.append(" ch.chargeamount as sumthispaid, ");
           //buffer.append(" t.underwriteenddate, ");
           buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
          // buffer.append(" '赔付费用' as payType, ");
           /*buffer.append(" case ch.chargecode ");
   	    buffer.append(" when '05' then '诉讼费' "); 
   	    buffer.append(" when '07' then '检验鉴定费' ");  
   	    buffer.append("  when '15' then '律师费'  ");
   	    buffer.append(" when '29' then '仲裁费'  ");
   	    buffer.append(" when '30' then '执行费'   ");
   	    buffer.append(" when '14' then '内部代查勘费'  ");
   	    buffer.append(" when '13' then '外部代查勘费'  "); 
   	    buffer.append(" when '04' then '机构查勘费'  ");
   	    buffer.append("  else '' end as paytype, ");*/
           buffer.append("  changechargecodetochargename(ch.chargecode) as paytype, ");
           buffer.append(" r.comcode, ");
           buffer.append(" '' as comcname, ");
           buffer.append(" (select sum(payamount) ");
           buffer.append(" from prplpay prplpay ");
          	buffer.append(" where prplpay.registno = r.registno ");
          	buffer.append(" and prplpay.compensateno = t.compensateno ");
          	buffer.append(" and prplpay.policyno = t.policyno ");
          	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
          	buffer.append("  and prplpay.paytype = 'P3' ");
          	
          	/**
           if(paymentNo!=null&&!"".equals(paymentNo)){
           	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
           }
           */
          	
           buffer.append(" ) as havPay , ");//--已支付
           buffer.append(" 'C' as certitype,  ");
           /*buffer.append(" case ch.chargecode  ");
   		buffer.append(" when '05' then  ");
   		buffer.append("  'P64'  ");
   		buffer.append(" when '07' then  ");
   		buffer.append("  'P61'  ");
   		buffer.append(" when '15' then  ");
   		buffer.append("  'P68'  ");
   		buffer.append(" when '29' then  ");
   		buffer.append("  'P611'  ");
   		buffer.append(" when '30' then  ");
   		buffer.append("  'P612'  ");
   		buffer.append(" when '14' then  ");
   		buffer.append("  'P65'  ");
   		buffer.append(" when '13' then  ");
   		buffer.append("  'P67'  ");
   		buffer.append(" when '04' then  ");
   		buffer.append("  'P62'  ");
   		buffer.append(" else  ");
   		buffer.append("  ''  ");
   		buffer.append("  end as payrefreason,  ");*/
        buffer.append("  changechargecodetopaymenttype(Ch.Chargecode) as payrefreason,  ");
   		buffer.append(" '0' as flowid, ");
   		buffer.append(" '' as claimrelationno ");
   		buffer.append(" from (select compensateno, chargecode, sum(nvl(chargeamount,0)-nvl(prechargeamount,0)-nvl(sumrealpay,0)) as chargeamount ");
       	buffer.append("  from prplcharge  where  chargecode<>'14' ");
       	buffer.append(" group by compensateno, chargecode) ch, ");
       	buffer.append("  prplcompensate t, prplclaim c, prplregist r  ");
        //	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r ,swflog g,swflogstore re ");
          	/**
          	buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
          	buffer.append(" pay.exist    ");//--是否勾选
          	buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
           buffer.append(" from prplpay ");
           buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
          	buffer.append(" and pay.compensateno(+) = t.compensateno ");
           */
          	
          	buffer.append(" where ch.compensateno = t.compensateno ");
          	buffer.append(" and t.claimno = c.claimno ");
          	buffer.append(" and c.registno = r.registno ");
          	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
          		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
          	}
          	if(payType != null&&!"".equals(payType)&&!"P3".equals(payType)){
          		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
          	}
          	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
          	if("mechanism".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
          	buffer.append(" and r.classcode<>'05' ");
          	//添加已支付完成的查询不出来条件
   		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
   		buffer.append(" from prplpay ");
   		buffer.append(" where prplpay.registno = r.registno ");
          	buffer.append(" and prplpay.compensateno = t.compensateno ");
          	buffer.append(" and prplpay.policyno = t.policyno ");
          	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
          	buffer.append(" and prplpay.paytype = 'P3' ");
   		//buffer.append(" and payflag='1' ");
   	    buffer.append(" )<>0  ");//--已支付
   	    //添加已支付完成的查询不出来条件
          	buffer.append(conditions);
          	
          	/**
          	if(registNos!=null&&registNos.size()>0){
       		buffer.append(" and r.registNo in ( ");
       		for(int i=0;i<registNos.size();i++){
       			if(i!=0)buffer.append(" , ");
       			buffer.append(" '"+registNos.get(i).trim()+"' ");
       		}
       		buffer.append(" ) ");
       	}
         	if(certiNos!=null&&certiNos.size()>0){
       		buffer.append(" and t.compensateno in ( ");//需更改
       		for(int i=0;i<certiNos.size();i++){
       			if(i!=0)buffer.append(" , ");
       			buffer.append(" '"+certiNos.get(i).trim()+"' ");
       		}
       		buffer.append(" ) ");
       	}
         	buffer.append(" and r.comcode like '"+comCodeStr+"%' ");// --？（默认添加）
         	*/
       	}
         	//--预赔赔款
   		//buffer.append(" union all ");
       	if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
   		buffer.append(" select r.registno, ");
   		buffer.append(" pre.policyno, ");
   		buffer.append(" '' as policyType, ");
   		buffer.append(" pre.precompensateno as certino, ");
   		buffer.append(" c.claimNo, ");
   		buffer.append(" r.insuredname, ");
   		buffer.append(" r.licenseno, ");
   		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
   		//buffer.append(" pre.underwriteenddate, ");
   		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
   		buffer.append(" '预赔赔款' as payType, ");
   		buffer.append(" r.comcode, ");
   		buffer.append(" '' as comcname, ");
   		buffer.append(" (select sum(payamount) ");
   		buffer.append(" from prplpay ");
   		buffer.append(" where registno = r.registno ");
   		buffer.append(" and compensateno = pre.precompensateno ");
   		buffer.append(" and policyno = pre.policyno ");
   		buffer.append(" and paymenttype = 'P50' "); 
   		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
   		
   		/**
   		if(paymentNo!=null&&!"".equals(paymentNo)){
   	    	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
   	    }
   	    */
   		
   	    buffer.append(" ) as havPay , ");//--已支付
   	    buffer.append(" 'Y' as certitype, ");
   	    buffer.append(" 'P50' as payrefreason, ");
   	    buffer.append(" '0' as flowid, ");
   	    buffer.append(" '' as claimrelationno ");
   		buffer.append(" from prplprepay pre, prplclaim c, prplregist r  ");
   		/**
   		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
   		buffer.append(" pay.exist    ");//--是否勾选
   		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
           buffer.append(" from prplpay ");
           buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
   		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
           */
   		buffer.append(" where pre.claimno = c.claimno ");
   		buffer.append(" and c.registno = r.registno ");
   		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
   			buffer.append(" and 1<>1 ");
   		}
   		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
   		if(payType==null||"".equals(payType)){
   			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
   		}else{
   			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
   		}
   		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
   		if("mechanism".equals(casesType)){
      	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
      	 
        }else if("agnet".equals(casesType)){
      	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
        }
   		buffer.append(" and r.classcode<>'05' ");
   		//添加已支付完成的查询不出来条件
   		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
   		buffer.append(" from prplpay ");
   		buffer.append(" where registno = r.registno ");
   		buffer.append(" and compensateno = pre.precompensateno ");
   		buffer.append(" and policyno = pre.policyno ");
   		buffer.append(" and paymenttype = 'P50' "); 
   		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
   		//buffer.append(" and payflag='1' ");
   	    buffer.append(" )<>0  ");//--已支付
   	    //添加已支付完成的查询不出来条件
   		buffer.append(conditions);
   		
   		/**
   		if(registNos!=null&&registNos.size()>0){
       		buffer.append(" and r.registNo in ( ");
       		for(int i=0;i<registNos.size();i++){
       			if(i!=0)buffer.append(" , ");
       			buffer.append(" '"+registNos.get(i).trim()+"' ");
       		}
       		buffer.append(" ) ");
       	}
   		//buffer.append(" and pre.precompensateno in ('805073408002011000005') ");
   		if(certiNos!=null&&certiNos.size()>0){
       		buffer.append(" and pre.precompensateno in ( ");//需更改
       		for(int i=0;i<certiNos.size();i++){
       			if(i!=0)buffer.append(" , ");
       			buffer.append(" '"+certiNos.get(i).trim()+"' ");
       		}
       		buffer.append(" ) ");
       	}
   		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
   		*/
   		
   		
   		//--预赔费用
   		buffer.append(" union all ");
   		buffer.append(" select r.registno, ");
   		buffer.append(" pre.policyno, ");
   		buffer.append(" '' as policyType, ");
   		buffer.append(" pch.precompensateno as certino, ");
   		buffer.append(" c.claimNo, ");
   		buffer.append(" r.insuredname, ");
   		buffer.append(" r.licenseno, ");
   		buffer.append(" pch.sumprepaid as sumthispaid, ");
   		//buffer.append(" pre.underwriteenddate, ");
   		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
   		//buffer.append(" '预赔费用' as payType, ");
   		/*buffer.append(" case pch.chargecode  ");
   		buffer.append(" when '05' then '预付诉讼费'  ");
   	    buffer.append(" when '07' then '预付检验鉴定费'   ");
   	    buffer.append(" when '15' then '预付律师费'  ");
   	    buffer.append(" when '29' then '预付仲裁费'  ");
   	    buffer.append(" when '30' then '预付执行费'  "); 
   	    buffer.append(" when '14' then '预付内部代查勘费' "); 
   	    buffer.append(" when '13' then '预付外部代查勘费'  "); 
   	    buffer.append(" when '04' then '预付机构查勘费'  ");
   	    buffer.append(" else '' end as payType,");*/
   		buffer.append(" pchangechargecodetochargename(pch.chargecode) as payType,");
   		buffer.append(" r.comcode, ");
   		buffer.append(" '' as comcname, ");
   		buffer.append(" (select sum(payamount) ");
   		buffer.append(" from prplpay ");
   		buffer.append(" where registno = r.registno ");
   		buffer.append(" and compensateno = pre.precompensateno ");
   		buffer.append(" and policyno = pre.policyno ");
   		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
   		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
   	    buffer.append(" ) as havPay,  ");//--已支付
   	    buffer.append(" 'Y' as certitype, ");
   	    /*buffer.append(" case pch.chargecode  ");
   		buffer.append(" when '05' then  ");
   		buffer.append("  'Y64'  ");
   		buffer.append(" when '07' then  ");
   		buffer.append("  'Y61'  ");
   		buffer.append(" when '15' then  ");
   		buffer.append("  'Y68'  ");
   		buffer.append(" when '29' then  ");
   		buffer.append("  'Y611'  ");
   		buffer.append(" when '30' then  ");
   		buffer.append("  'Y612'  ");
   		buffer.append(" when '14' then  ");
   		buffer.append("  'Y65'  ");
   		buffer.append(" when '13' then  ");
   		buffer.append("  'Y67'  ");
   		buffer.append(" when '04' then  ");
   		buffer.append("  'Y62'  ");
   		buffer.append(" else  ");
   		buffer.append("  'Y69'  ");
   		buffer.append("  end as payrefreason,  ");*/
   	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason,  ");
   		buffer.append(" '0' as flowid, ");
   		buffer.append(" '' as claimrelationno ");
   		buffer.append(" from (select claimno,precompensateno,chargecode, ");
		buffer.append(" sum(sumprepaid) as sumprepaid ");
		buffer.append(" from prplprecharge ");
		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
		buffer.append("  prplprepay pre, prplclaim c, prplregist r  ");
   		//buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ,swflog g,swflogstore re ");
   		/**
   		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
   		buffer.append(" pay.exist    ");//--是否勾选
   		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
           buffer.append(" from prplpay ");
           buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
   		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
           */
   		buffer.append(" where pch.claimno = c.claimno ");
   		buffer.append(" and pch.precompensateno = pre.precompensateno ");
   		buffer.append(" and c.registno = r.registno ");
   		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
   			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
   		}
   		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
   		if(payType==null||"".equals(payType)){
   			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
   		}else{
   			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
   		}
   		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
   		if("mechanism".equals(casesType)){
      	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
      	 
        }else if("agnet".equals(casesType)){
      	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
        }
   		buffer.append(" and r.classcode<>'05' ");
   		//添加已支付完成的查询不出来条件
   		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
   		buffer.append(" from prplpay ");
   		buffer.append(" where registno = r.registno ");
   		buffer.append(" and compensateno = pre.precompensateno ");
   		buffer.append(" and policyno = pre.policyno ");
   		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
   		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
   		//buffer.append(" and payflag='1' ");
   	    buffer.append(" )<>0  ");//--已支付 
   	    //添加已支付完成的查询不出来条件
   		buffer.append(conditions);
   		/**
   		 * 
   		if(registNos!=null&&registNos.size()>0){
       		buffer.append(" and r.registNo in ( ");
       		for(int i=0;i<registNos.size();i++){
       			if(i!=0)buffer.append(" , ");
       			buffer.append(" '"+registNos.get(i).trim()+"' ");
       		}
       		buffer.append(" ) ");
       	}
   		//buffer.append(" and pre.precompensateno in ('预赔号码') ");
   		if(certiNos!=null&&certiNos.size()>0){
       		buffer.append(" and pre.precompensateno in ( ");//需更改
       		for(int i=0;i<certiNos.size();i++){
       			if(i!=0)buffer.append(" , ");
       			buffer.append(" '"+certiNos.get(i).trim()+"' ");
       		}
       		buffer.append(" ) ");
       	}
   		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
   		
   		*/
       	}
   		buffer.append(" ) c  ");
   		buffer.append("  where  exists (select 1  ");
//   		buffer.append("          from prpjpayrefrec rec ");
        buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
        buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
        buffer.append( "  Union All                                                                            ");
        buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
        buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
   		buffer.append("         where rec.certino = c.certino  ");
   		buffer.append("           and rec.certitype = c.certitype ");
   		buffer.append("           and rec.visaserialno like '9%' ");
   		buffer.append("           and rec.payrefreason = c.payrefreason ");
   		buffer.append("           and rec.payrefstate in ('00', '01') ");
   		buffer.append("           and rec.payrefdate is null) ");
   		buffer.append(" order by underwriteenddate ");
   		if (pageNo > 0){
               //对Oracle优化
               if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                   buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                   buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                   //supportPaging=true;
               }
               else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                   String sql = buffer.toString();
                   buffer.setLength(0);
                   buffer.append("select * from ( select rownumber() over(");
                   int orderByIndex = sql.toLowerCase().indexOf("order by");
                   if ( orderByIndex>0 ) {
                      buffer.append( sql.substring(orderByIndex) );
                   }
                   buffer.append(") as rownumber_,");
                   buffer.append(sql.substring( 6 ));
                   buffer.append(" ) as temp_ where rownumber_");
                   buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                   //supportPaging=true;
               }
           }System.err.println(buffer.toString());
   		PayQueryConditionLogger.payQueryConditionData("getNewQueryShowList——2方法：<br>"+buffer.toString());
       	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
       	PrpLpayShowDto prpLpayShowDto =null;
       	while(resultSet.next()){
       		prpLpayShowDto = new PrpLpayShowDto();
       		prpLpayShowDto.setRegistNo(dbManager.getString(resultSet,"RegistNo"));
       		prpLpayShowDto.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
       		prpLpayShowDto.setPolicyType(dbManager.getString(resultSet,"PolicyType"));
       		prpLpayShowDto.setCertiNo(dbManager.getString(resultSet,"CertiNo"));
       		prpLpayShowDto.setClaimNo(dbManager.getString(resultSet,"ClaimNo"));
       		prpLpayShowDto.setInsuredName(dbManager.getString(resultSet,"InsuredName"));
       		prpLpayShowDto.setLicenseNo(dbManager.getString(resultSet,"LicenseNo"));
       		prpLpayShowDto.setSumPaid(dbManager.getDouble(resultSet,"sumthispaid"));
       		prpLpayShowDto.setUnderWriteEndDate(dbManager.getString(resultSet,"UnderWriteEndDate"));
       		prpLpayShowDto.setPayType(dbManager.getString(resultSet,"PayType"));
       		prpLpayShowDto.setComCode(dbManager.getString(resultSet,"ComCode"));
       		prpLpayShowDto.setComCodeName(dbManager.getString(resultSet,"ComCName"));
       		prpLpayShowDto.setHavPaid(dbManager.getDouble(resultSet,"HavPay"));
       		prpLpayShowDto.setFlowId(dbManager.getString(resultSet, "flowid"));
       		prpLpayShowDto.setPayrefreason(dbManager.getString(resultSet, "payrefreason"));
       		prpLpayShowDto.setRiskCode(dbManager.getString(resultSet,"CertiNo"));
       		prpLpayShowDto.setClassCode(dbManager.getString(resultSet,"CertiNo"));
       		prpLpayShowDto.setClaimRelationNo(dbManager.getString(resultSet,"claimrelationno"));
       		//prpLpayShowDto.setNowPaid(dbManager.getDouble(resultSet,"NowPay"));
       		//prpLpayShowDto.setExist(dbManager.getString(resultSet,"Exist"));
       		list.add(prpLpayShowDto);
       	}
       	resultSet.close();
       	return list;
       }
       
       /**
      	 * 支付信息查询列表显示方法
      	 * @param payType	支付类型
      	 * @param paymentType	赔款类型
      	 * @param comCode	机构号码
      	 * @param registNos	报案号集合
      	 * @param certiNos	业务号集合
      	 * @return
      	 * @throws Exception
      	 */
          public ArrayList<PrpLpayShowDto> getNewQueryShowRegistList(String payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode,String type)throws Exception{
          	//String comCodeStr = comCode.substring(0, 6);
          	//String conditions="";
          	//String paymentNo="";
        	  System.err.println(444444+"单笔支付");
          	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
          	StringBuffer buffer = new StringBuffer(200);
          	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
    		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
    		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
          	buffer.append(" select distinct tt.registno,tt.policyno,tt.damageenddate,tt.startdate,tt.enddate,tt.insuredname,c.comcode,(select cop.comcname  from prpdcompany cop  where cop.comcode = c.comcode) as comcname ");
          	buffer.append(" from (  ");
          	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
          	//--赔款
          	buffer.append(" select r.registno, ");
          	buffer.append(" t.policyno, ");
      		buffer.append(" '' as policyType, ");
          	buffer.append(" t.compensateno as certino, ");
          	buffer.append(" c.claimNo, ");
          	buffer.append(" r.insuredname, ");
          	buffer.append(" r.licenseno, ");
      		buffer.append("  t.sumthispaid, ");
              //buffer.append("   t.underwriteenddate, ");
              buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
              buffer.append("  '赔款' as payType, ");
              buffer.append(" r.comcode, ");
              buffer.append(" '' as comcname, ");
          	buffer.append(" (select sum(payamount) ");
              buffer.append(" from prplpay prplpay ");
              buffer.append(" where prplpay.registno = r.registno ");
              buffer.append(" and prplpay.compensateno = t.compensateno ");
              buffer.append(" and prplpay.policyno = t.policyno ");
              buffer.append(" and prplpay.paymenttype = 'P60' ");
              buffer.append(" and prplpay.paytype = 'P3' ");
              
              /**
              if(paymentNo!=null&&!"".equals(paymentNo)){
              	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
              }
              */
              
              buffer.append(" ) as havPay,  ");//--已支付
              buffer.append(" 'C' as certitype,  ");
              buffer.append(" 'P60' as payrefreason,  ");
              buffer.append(" '0' as flowid ");
              buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
              /**
              buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
              buffer.append(" pay.exist    ");//--是否勾选
              
              buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
              buffer.append(" from prplpay ");
              buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
              buffer.append(" and pay.compensateno(+) = t.compensateno ");
              */
              buffer.append(" where t.claimno = c.claimno ");
              buffer.append(" and c.registno = r.registno "); 
              if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
              	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
              }
              if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
              	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
              }
              buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
              if("mechanism".equals(casesType)){
            	  if("3477000000".equals(userComcode)){
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
            	  }else
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
            	 
              }else if("agnet".equals(casesType)){
            	  if("3477000000".equals(userComcode)){
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
            	  }else
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
              }
              buffer.append(" and r.classcode<>'05' ");
              //添加已支付完成的查询不出来条件
      		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where prplpay.registno = r.registno ");
              buffer.append(" and prplpay.compensateno = t.compensateno ");
              buffer.append(" and prplpay.policyno = t.policyno ");
              buffer.append(" and prplpay.paymenttype = 'P60' ");
              buffer.append(" and prplpay.paytype = 'P3' ");
      		//buffer.append(" and payflag='1' ");
      	    buffer.append(" )<> 0  ");//--已支付
      	    //添加已支付完成的查询不出来条件
              buffer.append(conditions);
              
              //新增代付共保赔款
              buffer.append(" union all ");
              buffer.append(" select r.registno, ");
            	buffer.append(" t.policyno, ");
        		buffer.append(" '' as policyType, ");
            	buffer.append("  co.businessno as certino, ");
            	buffer.append(" c.claimNo, ");
            	buffer.append(" r.insuredname, ");
            	buffer.append(" r.licenseno, ");
        		buffer.append("  co.coinssumpaid, ");
                //buffer.append("   t.underwriteenddate, ");
                buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
                buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
                buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
                buffer.append(" r.comcode, ");
                buffer.append(" '' as comcname, ");
            	buffer.append(" (select sum(payamount) ");
                buffer.append(" from prplpay prplpay ");
                buffer.append(" where prplpay.registno = r.registno ");
                buffer.append(" and prplpay.compensateno =  co.businessno  and prplpay.coinscode=co.coinscode ");
                buffer.append(" and prplpay.policyno = t.policyno ");
                buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
                buffer.append(" and prplpay.paytype = 'P3' ");
                
                /**
                if(paymentNo!=null&&!"".equals(paymentNo)){
                	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
                }
                */
                
                buffer.append(" ) as havPay,  ");//--已支付
                buffer.append(" 'C' as certitype,  ");
                buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
                buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason,  ");
                buffer.append(" '0' as flowid ");
                buffer.append(" from prplcompensate t, prplclaim c, prplregist r ,prplcfeecoins co");
                /**
                buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
                buffer.append(" pay.exist    ");//--是否勾选
                
                buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
                buffer.append(" from prplpay ");
                buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
                buffer.append(" and pay.compensateno(+) = t.compensateno ");
                */
                buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
                buffer.append(" and c.registno = r.registno "); 
                if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
                	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
                }
                if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
                	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
                }
                buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
                if("mechanism".equals(casesType)){
              	  if("3477000000".equals(userComcode)){
              		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
              	  }else
              	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
              	 
                }else if("agnet".equals(casesType)){
              	  if("3477000000".equals(userComcode)){
              		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
              	  }else
              	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
                }
                buffer.append(" and r.classcode<>'05' ");
                //添加已支付完成的查询不出来条件
        		buffer.append(" and (select  co.coinssumpaid -nvl(sum(payamount),0) ");
        		buffer.append(" from prplpay ");
        		buffer.append(" where prplpay.registno = r.registno ");
                buffer.append(" and prplpay.compensateno = co.businessno  and prplpay.coinscode=co.coinscode ");
                buffer.append(" and prplpay.policyno = t.policyno ");
                buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
                buffer.append(" and prplpay.paytype = 'P3' ");
        		//buffer.append(" and payflag='1' ");
        	    buffer.append(" )<> 0  ");//--已支付
        	    //添加已支付完成的查询不出来条件
                buffer.append(conditions);
              
              
              
              /**
              if(registNos!=null&&registNos.size()>0){
          		buffer.append(" and r.registNo in ( ");
          		for(int i=0;i<registNos.size();i++){
          			if(i!=0)buffer.append(" , ");
          			buffer.append(" '"+registNos.get(i).trim()+"' ");
          		}
          		buffer.append(" ) ");
          	}
              
              //buffer.append(" and t.compensateno in ('理算书号') ");
              if(certiNos!=null&&certiNos.size()>0){
          		buffer.append(" and t.compensateno in ( ");
          		for(int i=0;i<certiNos.size();i++){
          			if(i!=0)buffer.append(" , ");
          			buffer.append(" '"+certiNos.get(i).trim()+"' ");
          		}
          		buffer.append(" ) ");
          	}
              buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//--？（默认添加）
              */
              
      		//--赔付费用
              buffer.append(" union all ");
              buffer.append(" select r.registno, ");
              buffer.append(" t.policyno, ");
      		buffer.append(" '' as policyType, ");
              buffer.append("  t.compensateno as certino, ");
              buffer.append(" c.claimNo, ");
              buffer.append(" r.insuredname, ");
              buffer.append(" r.licenseno, ");
              buffer.append(" ch.chargeamount as sumthispaid, ");
              //buffer.append(" t.underwriteenddate, ");
              buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
             // buffer.append(" '赔付费用' as payType, ");
             /* buffer.append(" case ch.chargecode ");
      	    buffer.append(" when '05' then '诉讼费' "); 
      	    buffer.append(" when '07' then '检验鉴定费' ");  
      	    buffer.append("  when '15' then '律师费'  ");
      	    buffer.append(" when '29' then '仲裁费'  ");
      	    buffer.append(" when '30' then '执行费'   ");
      	    buffer.append(" when '14' then '内部代查勘费'  ");
      	    buffer.append(" when '13' then '外部代查勘费'  "); 
      	    buffer.append(" when '04' then '机构查勘费'  ");
      	    buffer.append("  else '' end as paytype, ");*/
              buffer.append(" changechargecodetochargename(ch.chargecode) as paytype, ");
              buffer.append(" r.comcode, ");
              buffer.append(" '' as comcname, ");
              buffer.append(" (select sum(payamount) ");
              buffer.append(" from prplpay prplpay ");
             	buffer.append(" where prplpay.registno = r.registno ");
             	buffer.append(" and prplpay.compensateno = t.compensateno ");
             	buffer.append(" and prplpay.policyno = t.policyno ");
             	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
             	buffer.append("  and prplpay.paytype = 'P3' ");
             	
             	/**
              if(paymentNo!=null&&!"".equals(paymentNo)){
              	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
              }
              */
             	
              buffer.append(" ) as havPay , ");//--已支付
              buffer.append(" 'C' as certitype,  ");
              /*buffer.append(" case ch.chargecode  ");
      		buffer.append(" when '05' then  ");
      		buffer.append("  'P64'  ");
      		buffer.append(" when '07' then  ");
      		buffer.append("  'P61'  ");
      		buffer.append(" when '15' then  ");
      		buffer.append("  'P68'  ");
      		buffer.append(" when '29' then  ");
      		buffer.append("  'P611'  ");
      		buffer.append(" when '30' then  ");
      		buffer.append("  'P612'  ");
      		buffer.append(" when '14' then  ");
      		buffer.append("  'P65'  ");
      		buffer.append(" when '13' then  ");
      		buffer.append("  'P67'  ");
      		buffer.append(" when '04' then  ");
      		buffer.append("  'P62'  ");
      		buffer.append(" else  ");
      		buffer.append("  ''  ");
      		buffer.append("  end as payrefreason,  ");*/
            buffer.append("  changechargecodetopaymenttype(ch.chargecode) as payrefreason,  ");
      		buffer.append(" '0' as flowid ");
      		buffer.append(" from (select compensateno, chargecode, sum(nvl(chargeamount,0)-nvl(prechargeamount,0)-nvl(sumrealpay,0)) as chargeamount ");
          	buffer.append("  from prplcharge  where  chargecode<>'14' ");
          	buffer.append(" group by compensateno, chargecode) ch, ");
          	buffer.append("  prplcompensate t, prplclaim c, prplregist r  ");
           //	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r ,swflog g,swflogstore re ");
             	/**
             	buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
             	buffer.append(" pay.exist    ");//--是否勾选
             	buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
              buffer.append(" from prplpay ");
              buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
             	buffer.append(" and pay.compensateno(+) = t.compensateno ");
              */
             	
             	buffer.append(" where ch.compensateno = t.compensateno ");
             	buffer.append(" and t.claimno = c.claimno ");
             	buffer.append(" and c.registno = r.registno ");
             	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
             		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
             	}
             	if(payType != null&&!"".equals(payType)&&!"P3".equals(payType)){
             		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
             	}
             	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
             	if("mechanism".equals(casesType)){
             		if("3477000000".equals(userComcode)){
              		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
              	  }else
             	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
             	 
               }else if("agnet".equals(casesType)){
            	   if("3477000000".equals(userComcode)){
             		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
             	  }else
             	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
               }
             	buffer.append(" and r.classcode<>'05' ");
             	//添加已支付完成的查询不出来条件
      		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where prplpay.registno = r.registno ");
             	buffer.append(" and prplpay.compensateno = t.compensateno ");
             	buffer.append(" and prplpay.policyno = t.policyno ");
             	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
             	buffer.append(" and prplpay.paytype = 'P3' ");
      		//buffer.append(" and payflag='1' ");
      	    buffer.append(" )<>0  ");//--已支付
      	    //添加已支付完成的查询不出来条件
             	buffer.append(conditions);
             	
             	/**
             	if(registNos!=null&&registNos.size()>0){
          		buffer.append(" and r.registNo in ( ");
          		for(int i=0;i<registNos.size();i++){
          			if(i!=0)buffer.append(" , ");
          			buffer.append(" '"+registNos.get(i).trim()+"' ");
          		}
          		buffer.append(" ) ");
          	}
            	if(certiNos!=null&&certiNos.size()>0){
          		buffer.append(" and t.compensateno in ( ");//需更改
          		for(int i=0;i<certiNos.size();i++){
          			if(i!=0)buffer.append(" , ");
          			buffer.append(" '"+certiNos.get(i).trim()+"' ");
          		}
          		buffer.append(" ) ");
          	}
            	buffer.append(" and r.comcode like '"+comCodeStr+"%' ");// --？（默认添加）
            	*/
          }	
            	//--预赔赔款
      		//buffer.append(" union all ");
          if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
      		buffer.append(" select r.registno, ");
      		buffer.append(" pre.policyno, ");
      		buffer.append(" '' as policyType, ");
      		buffer.append(" pre.precompensateno as certino, ");
      		buffer.append(" c.claimNo, ");
      		buffer.append(" r.insuredname, ");
      		buffer.append(" r.licenseno, ");
      		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
      		//buffer.append(" pre.underwriteenddate, ");
      		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
      		buffer.append(" '预赔赔款' as payType, ");
      		buffer.append(" r.comcode, ");
      		buffer.append(" '' as comcname, ");
      		buffer.append(" (select sum(payamount) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where registno = r.registno ");
      		buffer.append(" and compensateno = pre.precompensateno ");
      		buffer.append(" and policyno = pre.policyno ");
      		buffer.append(" and paymenttype = 'P50' "); 
      		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
      		
      		/**
      		if(paymentNo!=null&&!"".equals(paymentNo)){
      	    	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
      	    }
      	    */
      		
      	    buffer.append(" ) as havPay , ");//--已支付
      	    buffer.append(" 'Y' as certitype, ");
      	    buffer.append(" 'P50' as payrefreason, ");
      	    buffer.append(" '0' as flowid ");
      		buffer.append(" from prplprepay pre, prplclaim c, prplregist r  ");
      		/**
      		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
      		buffer.append(" pay.exist    ");//--是否勾选
      		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
              buffer.append(" from prplpay ");
              buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
      		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
              */
      		buffer.append(" where pre.claimno = c.claimno ");
      		buffer.append(" and c.registno = r.registno ");
      		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
      			buffer.append(" and 1<>1 ");
      		}
      		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
      		if(payType==null||"".equals(payType)){
      			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
      		}else{
      			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
      		}
      		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
      		if("mechanism".equals(casesType)){
      			if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  }else
         	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
         	 
           }else if("agnet".equals(casesType)){
        	   if("3477000000".equals(userComcode)){
         		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
         	  }else
         	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
           }
      		buffer.append(" and r.classcode<>'05' ");
      		//添加已支付完成的查询不出来条件
      		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where registno = r.registno ");
      		buffer.append(" and compensateno = pre.precompensateno ");
      		buffer.append(" and policyno = pre.policyno ");
      		buffer.append(" and paymenttype = 'P50' "); 
      		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
      		//buffer.append(" and payflag='1' ");
      	    buffer.append(" )<>0  ");//--已支付
      	    //添加已支付完成的查询不出来条件
      		buffer.append(conditions);
      		
      		/**
      		if(registNos!=null&&registNos.size()>0){
          		buffer.append(" and r.registNo in ( ");
          		for(int i=0;i<registNos.size();i++){
          			if(i!=0)buffer.append(" , ");
          			buffer.append(" '"+registNos.get(i).trim()+"' ");
          		}
          		buffer.append(" ) ");
          	}
      		//buffer.append(" and pre.precompensateno in ('805073408002011000005') ");
      		if(certiNos!=null&&certiNos.size()>0){
          		buffer.append(" and pre.precompensateno in ( ");//需更改
          		for(int i=0;i<certiNos.size();i++){
          			if(i!=0)buffer.append(" , ");
          			buffer.append(" '"+certiNos.get(i).trim()+"' ");
          		}
          		buffer.append(" ) ");
          	}
      		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
      		*/
      		
      		
      		//--预赔费用
      		buffer.append(" union all ");
      		buffer.append(" select r.registno, ");
      		buffer.append(" pre.policyno, ");
      		buffer.append(" '' as policyType, ");
      		buffer.append(" pch.precompensateno as certino, ");
      		buffer.append(" c.claimNo, ");
      		buffer.append(" r.insuredname, ");
      		buffer.append(" r.licenseno, ");
      		buffer.append(" pch.sumprepaid as sumthispaid, ");
      		//buffer.append(" pre.underwriteenddate, ");
      		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
      		//buffer.append(" '预赔费用' as payType, ");
      		/*buffer.append(" case pch.chargecode  ");
      		buffer.append(" when '05' then '预付诉讼费'  ");
      	    buffer.append(" when '07' then '预付检验鉴定费'   ");
      	    buffer.append(" when '15' then '预付律师费'  ");
      	    buffer.append(" when '29' then '预付仲裁费'  ");
      	    buffer.append(" when '30' then '预付执行费'  "); 
      	    buffer.append(" when '14' then '预付内部代查勘费' "); 
      	    buffer.append(" when '13' then '预付外部代查勘费'  "); 
      	    buffer.append(" when '04' then '预付机构查勘费'  ");
      	    buffer.append(" else '' end as payType,");*/
      		buffer.append(" pchangechargecodetochargename(pch.chargecode) as payType,");
      		buffer.append(" r.comcode, ");
      		buffer.append(" '' as comcname, ");
      		buffer.append(" (select sum(payamount) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where registno = r.registno ");
      		buffer.append(" and compensateno = pre.precompensateno ");
      		buffer.append(" and policyno = pre.policyno ");
      		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
      		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
      	    buffer.append(" ) as havPay,  ");//--已支付
      	    buffer.append(" 'Y' as certitype, ");
      	    /*buffer.append(" case pch.chargecode  ");
      		buffer.append(" when '05' then  ");
      		buffer.append("  'Y64'  ");
      		buffer.append(" when '07' then  ");
      		buffer.append("  'Y61'  ");
      		buffer.append(" when '15' then  ");
      		buffer.append("  'Y68'  ");
      		buffer.append(" when '29' then  ");
      		buffer.append("  'Y611'  ");
      		buffer.append(" when '30' then  ");
      		buffer.append("  'Y612'  ");
      		buffer.append(" when '14' then  ");
      		buffer.append("  'Y65'  ");
      		buffer.append(" when '13' then  ");
      		buffer.append("  'Y67'  ");
      		buffer.append(" when '04' then  ");
      		buffer.append("  'Y62'  ");
      		buffer.append(" else  ");
      		buffer.append("  'Y69'  ");
      		buffer.append("  end as payrefreason,  ");*/
      	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason,  ");
      		buffer.append(" '0' as flowid ");
      		buffer.append(" from (select claimno,precompensateno,chargecode, ");
   		buffer.append(" sum(sumprepaid) as sumprepaid ");
   		buffer.append(" from prplprecharge ");
   		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
   		buffer.append("  prplprepay pre, prplclaim c, prplregist r  ");
      		//buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ,swflog g,swflogstore re ");
      		/**
      		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
      		buffer.append(" pay.exist    ");//--是否勾选
      		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
              buffer.append(" from prplpay ");
              buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
      		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
              */
      		buffer.append(" where pch.claimno = c.claimno ");
      		buffer.append(" and pch.precompensateno = pre.precompensateno ");
      		buffer.append(" and c.registno = r.registno ");
      		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
      			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
      		}
      		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
      		if(payType==null||"".equals(payType)){
      			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
      		}else{
      			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
      		}
      		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
      		if("mechanism".equals(casesType)){
      			if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  }else
         	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
         	 
           }else if("agnet".equals(casesType)){
        	   if("3477000000".equals(userComcode)){
         		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
         	  }else
         	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
           }
      		buffer.append(" and r.classcode<>'05' ");
      		//添加已支付完成的查询不出来条件
      		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where registno = r.registno ");
      		buffer.append(" and compensateno = pre.precompensateno ");
      		buffer.append(" and policyno = pre.policyno ");
      		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
      		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
      		//buffer.append(" and payflag='1' ");
      	    buffer.append(" )<>0  ");//--已支付 
      	    //添加已支付完成的查询不出来条件
      		buffer.append(conditions);
      		/**
      		 * 
      		if(registNos!=null&&registNos.size()>0){
          		buffer.append(" and r.registNo in ( ");
          		for(int i=0;i<registNos.size();i++){
          			if(i!=0)buffer.append(" , ");
          			buffer.append(" '"+registNos.get(i).trim()+"' ");
          		}
          		buffer.append(" ) ");
          	}
      		//buffer.append(" and pre.precompensateno in ('预赔号码') ");
      		if(certiNos!=null&&certiNos.size()>0){
          		buffer.append(" and pre.precompensateno in ( ");//需更改
          		for(int i=0;i<certiNos.size();i++){
          			if(i!=0)buffer.append(" , ");
          			buffer.append(" '"+certiNos.get(i).trim()+"' ");
          		}
          		buffer.append(" ) ");
          	}
      		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
      		
      		*/
          }
      		buffer.append(" ) c ,prplclaim tt ");
      		buffer.append("  where  c.registno = tt.registno");
      		buffer.append(" and exists (select 1  ");
//      		buffer.append("          from prpjpayrefrec rec ");
            buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
            buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
            buffer.append( "  Union All                                                                            ");
            buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
            buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
      		buffer.append("         where rec.certino = c.certino  ");
      		buffer.append("           and rec.certitype = c.certitype ");
      		buffer.append("           and rec.visaserialno like '9%' ");
      		buffer.append("           and rec.payrefreason = c.payrefreason ");
      		buffer.append("           and rec.payrefstate in ('00', '01') ");
      		buffer.append("           and rec.payrefdate is null) ");
      		buffer.append("	And Not Exists (Select 1 ");
     		buffer.append("          From Prplinterrelation Nn ");
     		buffer.append("         Where Nn.Relationregistno = C.Registno) ");
      		if(null!=type && "5".equals(type)){
      			buffer.append(" and exists ( select 1 ");
      			buffer.append("             from prplclaimbillmanager bill ");
      			buffer.append("             where bill.compensateno = c.certino ");
      			buffer.append("              and  bill.registno = c.registno ) ");
      		}
      		buffer.append(" ");
      		
      		
      		if (pageNo > 0){
                  //对Oracle优化
                  if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                      buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                      buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                      //supportPaging=true;
                  }
                  else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                      String sql = buffer.toString();
                      buffer.setLength(0);
                      buffer.append("select * from ( select rownumber() over(");
                      int orderByIndex = sql.toLowerCase().indexOf("order by");
                      if ( orderByIndex>0 ) {
                         buffer.append( sql.substring(orderByIndex) );
                      }
                      buffer.append(") as rownumber_,");
                      buffer.append(sql.substring( 6 ));
                      buffer.append(" ) as temp_ where rownumber_");
                      buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                      //supportPaging=true;
                  }
              }System.err.println(buffer.toString());
          	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
          	PrpLpayShowDto prpLpayShowDto =null;
          	while(resultSet.next()){
          		prpLpayShowDto = new PrpLpayShowDto();
          		prpLpayShowDto.setRegistNo(dbManager.getString(resultSet,"registno"));
          		prpLpayShowDto.setPolicyNo(dbManager.getString(resultSet,"policyno"));
          		prpLpayShowDto.setDamageDate(dbManager.getDateTime(resultSet,"damageenddate").toString());
          		prpLpayShowDto.setStartDate(dbManager.getDateTime(resultSet,"startdate").toString());
          		prpLpayShowDto.setEndDate(dbManager.getDateTime(resultSet, "enddate").toString());
          		prpLpayShowDto.setInsuredName(dbManager.getString(resultSet,"insuredname"));
          		prpLpayShowDto.setComCode(dbManager.getString(resultSet,"comcode"));
          		prpLpayShowDto.setComCodeName(dbManager.getString(resultSet,"comcname"));
          		list.add(prpLpayShowDto);
          	}
          	resultSet.close();
          	return list;
          }
    /**
	 * 支付信息查询列表显示方法
	 * @param payType	支付类型
	 * @param paymentType	赔款类型
	 * @param comCode	机构号码
	 * @return
	 * @throws Exception
	 */
    public int getNewQueryCount(String payType,String paymentType,String conditions )throws Exception{
    	//String comCodeStr = comCode.substring(0, 6);
    	//String conditions="";
    	//String paymentNo="";
    	System.err.println(555555);
    	int count = -1;
    	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
    	StringBuffer buffer = new StringBuffer(200);
    	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
    	buffer.append("SELECT count(1) FROM ( ");
    	buffer.append(" select * ");
    	buffer.append(" from (  ");
    	//--赔款
    	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
    	buffer.append(" select r.registno, ");
    	buffer.append(" t.policyno, ");
//		buffer.append(" (select case grp.policytype ");
//		buffer.append(" when '1' then '商业险' ");
//		buffer.append(" when '3' then '交强险' ");
//		buffer.append(" else '' end ");
//		buffer.append(" from prplregistrpolicy grp ");
//		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
    	buffer.append(" t.compensateno as certino, ");
    	buffer.append(" c.claimNo, ");
    	buffer.append(" r.insuredname, ");
    	buffer.append(" r.licenseno, ");
		buffer.append("  t.sumthispaid, ");
        //buffer.append("   t.underwriteenddate, ");
        buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
        buffer.append("  '赔款' as payType, ");
        buffer.append(" r.comcode, ");
        buffer.append(" '' as comcname, ");
    	buffer.append(" (select sum(payamount) ");
        buffer.append(" from prplpay prplpay ");
        buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno = t.compensateno ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and prplpay.paymenttype = 'P60' ");
        buffer.append(" and prplpay.paytype = 'P3' ");
        
        buffer.append(" ) as havPay , ");//--已支付
        buffer.append(" 'C' as certitype,  ");
        buffer.append(" 'P60' as payrefreason  ");
        buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
        buffer.append(" where t.claimno = c.claimno ");
        buffer.append(" and c.registno = r.registno "); 
        if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
        	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
        }
        if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
        	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
        }
        buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
        buffer.append(" and r.classcode<>'05' ");
        //添加已支付完成的查询不出来条件
		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
		buffer.append(" from prplpay ");
		buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno = t.compensateno ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and prplpay.paymenttype = 'P60' ");
        buffer.append(" and prplpay.paytype = 'P3' ");
		//buffer.append(" and payflag='1' ");
	    buffer.append(" )>0  ");//--已支付
	    //添加已支付完成的查询不出来条件
        buffer.append(conditions);
        buffer.append(" and 4=4 ");
        
        //新增代付共保赔款
        buffer.append(" union all ");
        buffer.append(" select r.registno, ");
    	buffer.append(" t.policyno, ");
//		buffer.append(" (select case grp.policytype ");
//		buffer.append(" when '1' then '商业险' ");
//		buffer.append(" when '3' then '交强险' ");
//		buffer.append(" else '' end ");
//		buffer.append(" from prplregistrpolicy grp ");
//		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
    	buffer.append(" co.businessno as certino,");
    	buffer.append(" c.claimNo, ");
    	buffer.append("  co.coinsname as insuredname ,");
    	buffer.append(" r.licenseno, ");
		buffer.append("    co.coinssumpaid as sumthispaid, ");
        //buffer.append("   t.underwriteenddate, ");
        buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
        buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
        buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
        buffer.append(" r.comcode, ");
        buffer.append(" '' as comcname, ");
    	buffer.append(" (select sum(payamount) ");
        buffer.append(" from prplpay prplpay ");
        buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno =  co.businessno and prplpay.coinscode=co.coinscode ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
        buffer.append(" and prplpay.paytype = 'P3' ");
        
        buffer.append(" ) as havPay , ");//--已支付
        buffer.append(" 'C' as certitype,  ");
        buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
        buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason   ");
        buffer.append(" from prplcompensate t, prplclaim c, prplregist r ,prplcfeecoins co ");
        buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
        buffer.append(" and c.registno = r.registno "); 
        if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
        	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
        }
        if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
        	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
        }
        buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
        buffer.append(" and r.classcode<>'05' ");
        //添加已支付完成的查询不出来条件
		buffer.append(" and (select co.coinssumpaid -nvl(sum(payamount),0) ");
		buffer.append(" from prplpay ");
		buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno =  co.businessno  and prplpay.coinscode=co.coinscode ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
        buffer.append(" and prplpay.paytype = 'P3' ");
		//buffer.append(" and payflag='1' ");
	    buffer.append(" )>0  ");//--已支付
	    //添加已支付完成的查询不出来条件
        buffer.append(conditions);
        buffer.append(" and 4=4 ");
        
        
		//--赔付费用
        buffer.append(" union all ");
        buffer.append(" select r.registno, ");
        buffer.append(" t.policyno, ");
//		buffer.append(" (select case grp.policytype ");
//		buffer.append(" when '1' then '商业险' ");
//		buffer.append(" when '3' then '交强险' ");
//		buffer.append(" else '' end ");
//		buffer.append(" from prplregistrpolicy grp ");
//		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
        buffer.append("  t.compensateno as certino, ");
        buffer.append(" c.claimNo, ");
        buffer.append(" r.insuredname, ");
        buffer.append(" r.licenseno, ");
        buffer.append(" nvl(ch.chargeamount,0)-nvl(ch.sumrealpay,0) as sumthispaid, ");
        //buffer.append(" t.underwriteenddate, ");
        buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
        buffer.append(" '赔付费用' as payType, ");
        buffer.append(" r.comcode, ");
        buffer.append(" '' as comcname, ");
        buffer.append(" (select sum(payamount) ");
        buffer.append(" from prplpay prplpay ");
       	buffer.append(" where prplpay.registno = r.registno ");
       	buffer.append(" and prplpay.compensateno = t.compensateno ");
       	buffer.append(" and prplpay.policyno = t.policyno ");
       	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
       	buffer.append("  and prplpay.paytype = 'P3' ");
       	
        buffer.append(" ) as havPay , ");	//--已支付
        buffer.append(" 'C' as certitype,  ");
        /*buffer.append(" case ch.chargecode  ");
		buffer.append(" when '05' then  ");
		buffer.append("  'P64'  ");
		buffer.append(" when '07' then  ");
		buffer.append("  'P61'  ");
		buffer.append(" when '15' then  ");
		buffer.append("  'P68'  ");
		buffer.append(" when '29' then  ");
		buffer.append("  'P611'  ");
		buffer.append(" when '30' then  ");
		buffer.append("  'P612'  ");
		buffer.append(" when '14' then  ");
		buffer.append("  'P65'  ");
		buffer.append(" when '13' then  ");
		buffer.append("  'P67'  ");
		buffer.append(" when '04' then  ");
		buffer.append("  'P62'  ");
		buffer.append(" else  ");
		buffer.append("  ''  ");
		buffer.append("  end as payrefreason  ");*/
        buffer.append("  changechargecodetopaymenttype(ch.chargecode) as payrefreason  ");
       	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r ");
       	
       	buffer.append(" where ch.compensateno = t.compensateno ");
       	buffer.append(" and t.claimno = c.claimno ");
       	buffer.append(" and c.registno = r.registno ");
       	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
       		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
       	}
       	if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
       		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
       	}
       	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
       	buffer.append(" and r.classcode<>'05' ");
       	//添加已支付完成的查询不出来条件
		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
		buffer.append(" from prplpay ");
		buffer.append(" where prplpay.registno = r.registno ");
       	buffer.append(" and prplpay.compensateno = t.compensateno ");
       	buffer.append(" and prplpay.policyno = t.policyno ");
       	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
       	buffer.append(" and prplpay.paytype = 'P3' ");
		//buffer.append(" and payflag='1' ");
	    buffer.append(" )>0  ");//--已支付
	    //添加已支付完成的查询不出来条件
       	buffer.append(conditions);
    	}
      	//--预赔赔款
		//buffer.append(" union all ");
    	if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
		buffer.append(" select r.registno, ");
		buffer.append(" pre.policyno, ");
//		buffer.append(" (select case grp.policytype ");
//		buffer.append(" when '1' then '商业险' ");
//		buffer.append(" when '3' then '交强险' ");
//		buffer.append(" else '' end ");
//		buffer.append(" from prplregistrpolicy grp ");
//		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
		buffer.append(" pre.precompensateno as certino, ");
		buffer.append(" c.claimNo, ");
		buffer.append(" r.insuredname, ");
		buffer.append(" r.licenseno, ");
		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
		//buffer.append(" pre.underwriteenddate, ");
		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
		buffer.append(" '预赔赔款' as payType, ");
		buffer.append(" r.comcode, ");
		buffer.append(" '' as comcname, ");
		buffer.append(" (select sum(payamount) ");
		buffer.append(" from prplpay ");
		buffer.append(" where registno = r.registno ");
		buffer.append(" and compensateno = pre.precompensateno ");
		buffer.append(" and policyno = pre.policyno ");
		buffer.append(" and paymenttype = 'P50' "); 
		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
		
		
		
	    buffer.append(" ) as havPay , ");//--已支付
	    buffer.append(" 'Y' as certitype,  ");
        buffer.append(" 'P50' as payrefreason  ");
		buffer.append(" from prplprepay pre, prplclaim c, prplregist r ");
		
		buffer.append(" where pre.claimno = c.claimno ");
		buffer.append(" and c.registno = r.registno ");
		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
			buffer.append(" and 1<>1 ");
		}
		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
		if(payType!=null&&!"".equals(payType)){
			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
		}else{
			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
		}
		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
		buffer.append(" and r.classcode<>'05' ");
		//添加已支付完成的查询不出来条件
		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
		buffer.append(" from prplpay ");
		buffer.append(" where registno = r.registno ");
		buffer.append(" and compensateno = pre.precompensateno ");
		buffer.append(" and policyno = pre.policyno ");
		buffer.append(" and paymenttype = 'P50' "); 
		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
		//buffer.append(" and payflag='1' ");
	    buffer.append(" )>0  ");//--已支付
	    //添加已支付完成的查询不出来条件
		buffer.append(conditions);
		
		//--预赔费用
		buffer.append(" union all ");
		buffer.append(" select r.registno, ");
		buffer.append(" pre.policyno, ");
//		buffer.append(" (select case grp.policytype ");
//		buffer.append(" when '1' then '商业险' ");
//		buffer.append(" when '3' then '交强险' ");
//		buffer.append(" else '' end ");
//		buffer.append(" from prplregistrpolicy grp ");
//		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
		buffer.append(" pch.precompensateno as certino, ");
		buffer.append(" c.claimNo, ");
		buffer.append(" r.insuredname, ");
		buffer.append(" r.licenseno, ");
		buffer.append(" pch.sumprepaid as sumthispaid, ");
		//buffer.append(" pre.underwriteenddate, ");
		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
		buffer.append(" '预赔费用' as payType, ");
		
		buffer.append(" r.comcode, ");
		buffer.append(" '' as comcname, ");
		buffer.append(" (select sum(payamount) ");
		buffer.append(" from prplpay ");
		buffer.append(" where registno = r.registno ");
		buffer.append(" and compensateno = pre.precompensateno ");
		buffer.append(" and policyno = pre.policyno ");
		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
		
	    buffer.append(" ) as havPay , ");//--已支付
	    buffer.append(" 'Y' as certitype,  ");
	    /*buffer.append(" case pch.chargecode  ");
		buffer.append(" when '05' then  ");
		buffer.append("  'Y64'  ");
		buffer.append(" when '07' then  ");
		buffer.append("  'Y61'  ");
		buffer.append(" when '15' then  ");
		buffer.append("  'Y68'  ");
		buffer.append(" when '29' then  ");
		buffer.append("  'Y611'  ");
		buffer.append(" when '30' then  ");
		buffer.append("  'Y612'  ");
		buffer.append(" when '14' then  ");
		buffer.append("  'Y65'  ");
		buffer.append(" when '13' then  ");
		buffer.append("  'Y67'  ");
		buffer.append(" when '04' then  ");
		buffer.append("  'Y62'  ");
		buffer.append(" else  ");
		buffer.append("  'Y69'  ");
		buffer.append("  end as payrefreason  ");*/
	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason  ");
		buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ");
		
		buffer.append(" where pch.claimno = c.claimno ");
		buffer.append(" and pch.precompensateno = pre.precompensateno ");
		buffer.append(" and c.registno = r.registno ");
		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
		}
		if(payType!=null&&!"".equals(payType)){
			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
		}else{
			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
		}
		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
		buffer.append(" and r.classcode<>'05' ");
		//添加已支付完成的查询不出来条件
		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
		buffer.append(" from prplpay ");
		buffer.append(" where registno = r.registno ");
		buffer.append(" and compensateno = pre.precompensateno ");
		buffer.append(" and policyno = pre.policyno ");
		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
		//buffer.append(" and payflag='1' ");
	    buffer.append(" )>0  ");//--已支付
	    //添加已支付完成的查询不出来条件
		buffer.append(conditions);
    	}
		
		
		buffer.append(" ) c  ");
		buffer.append("  where exists (select 1  ");
//		buffer.append("  from prpjplanfee rf  ");
		 buffer.append("  from ( select 																										");
		 buffer.append("  certitype        ,						                                    ");
		 buffer.append("  certino          ,                                                ");
		 buffer.append("  policyno         ,                                                ");
		 buffer.append("  serialno         ,                                                ");
		 buffer.append("  payrefreason     ,                                                ");
		 buffer.append("  claimno          ,                                                ");
		 buffer.append("  classcode        ,                                                ");
		 buffer.append("  riskcode         ,                                                ");
		 buffer.append("  contractno       ,                                                ");
		 buffer.append("  applicode        ,                                                ");
		 buffer.append("  appliname        ,                                                ");
		 buffer.append("  insuredcode      ,                                                ");
		 buffer.append("  insuredname      ,                                                ");
		 buffer.append("  startdate        ,                                                ");
		 buffer.append("  enddate          ,                                                ");
		 buffer.append("  validdate        ,                                                ");
		 buffer.append("  payno            ,                                                ");
		 buffer.append("  currency1        ,                                                ");
		 buffer.append("  planfee          ,                                                ");
		 buffer.append("  plandate         ,                                                ");
		 buffer.append("  comcode          ,                                                ");
		 buffer.append("  makecom          ,                                                ");
		 buffer.append("  agentcode        ,                                                ");
		 buffer.append("  handler1code     ,                                                ");
		 buffer.append("  handlercode      ,                                                ");
		 buffer.append("  underwritedate   ,                                                ");
		 buffer.append("  coinsflag        ,                                                ");
		 buffer.append("  coinscode        ,                                                ");
		 buffer.append("  coinsname        ,                                                ");
		 buffer.append("  coinstype        ,                                                ");
		 buffer.append("  centercode       ,                                                ");
		 buffer.append("  branchcode       ,                                                ");
		 buffer.append("  accbooktype      ,                                                ");
		 buffer.append("  accbookcode      ,                                                ");
		 buffer.append("  yearmonth        ,                                                ");
		 buffer.append("  voucherno        ,                                                ");
		 buffer.append("  exchangerate     ,                                                ");
		 buffer.append("  planfeecny       ,                                                ");
		 buffer.append("  payreffee        ,                                                ");
		 buffer.append("  realpayreffee    ,                                                ");
		 buffer.append("  flag             ,                                                ");
		 buffer.append("  businessnature   ,                                                ");
		 buffer.append("  othflag          ,                                                ");
		 buffer.append("  carnaturecode    ,                                                ");
		 buffer.append("  usenaturecode    ,                                                ");
		 buffer.append("  carproperty      ,                                                ");
		 buffer.append("  paycomcode       ,                                                ");
		 buffer.append("  businesstype     ,                                                ");
		 buffer.append("  businesstype1    ,                                                ");
		 buffer.append("  payrefstate      ,                                                ");
		 buffer.append("  recoveryserialno ,                                                ");
		 buffer.append("  update_by        ,                                                ");
		 buffer.append("  update_date      ,                                                ");
		 buffer.append("  vatax            ,                                                ");
		 buffer.append("  ntplanfee        ,                                                ");
		 buffer.append("  dutyratio     from prpjplanfeecoins                               ");
		 buffer.append("  Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+") ");
		 buffer.append("  union all                                                         ");
		 buffer.append("  select                                                            ");
		 buffer.append("  certitype        ,						                                    ");
		 buffer.append("  certino          ,                                                ");
		 buffer.append("  policyno         ,                                                ");
		 buffer.append("  serialno         ,                                                ");
		 buffer.append("  payrefreason     ,                                                ");
		 buffer.append("  claimno          ,                                                ");
		 buffer.append("  classcode        ,                                                ");
		 buffer.append("  riskcode         ,                                                ");
		 buffer.append("  contractno       ,                                                ");
		 buffer.append("  applicode        ,                                                ");
		 buffer.append("  appliname        ,                                                ");
		 buffer.append("  insuredcode      ,                                                ");
		 buffer.append("  insuredname      ,                                                ");
		 buffer.append("  startdate        ,                                                ");
		 buffer.append("  enddate          ,                                                ");
		 buffer.append("  validdate        ,                                                ");
		 buffer.append("  payno            ,                                                ");
		 buffer.append("  currency1        ,                                                ");
		 buffer.append("  planfee          ,                                                ");
		 buffer.append("  plandate         ,                                                ");
		 buffer.append("  comcode          ,                                                ");
		 buffer.append("  makecom          ,                                                ");
		 buffer.append("  agentcode        ,                                                ");
		 buffer.append("  handler1code     ,                                                ");
		 buffer.append("  handlercode      ,                                                ");
		 buffer.append("  underwritedate   ,                                                ");
		 buffer.append("  coinsflag        ,                                                ");
		 buffer.append("  coinscode        ,                                                ");
		 buffer.append("  coinsname        ,                                                ");
		 buffer.append("  coinstype        ,                                                ");
		 buffer.append("  centercode       ,                                                ");
		 buffer.append("  branchcode       ,                                                ");
		 buffer.append("  accbooktype      ,                                                ");
		 buffer.append("  accbookcode      ,                                                ");
		 buffer.append("  yearmonth        ,                                                ");
		 buffer.append("  voucherno        ,                                                ");
		 buffer.append("  exchangerate     ,                                                ");
		 buffer.append("  planfeecny       ,                                                ");
		 buffer.append("  payreffee        ,                                                ");
		 buffer.append("  realpayreffee    ,                                                ");
		 buffer.append("  flag             ,                                                ");
		 buffer.append("  businessnature   ,                                                ");
		 buffer.append("  othflag          ,                                                ");
		 buffer.append("  carnaturecode    ,                                                ");
		 buffer.append("  usenaturecode    ,                                                ");
		 buffer.append("  carproperty      ,                                                ");
		 buffer.append("  paycomcode       ,                                                ");
		 buffer.append("  businesstype     ,                                                ");
		 buffer.append("  businesstype1    ,                                                ");
		 buffer.append("  payrefstate      ,                                                ");
		 buffer.append("  recoveryserialno ,                                                ");
		 buffer.append("  update_by        ,                                                ");
		 buffer.append("  update_date      ,                                                ");
		 buffer.append("  vatax            ,                                                ");
		 buffer.append("  ntplanfee        ,                                                ");
		 buffer.append("  dutyratio     from prpjplanfee                                    ");
		 buffer.append("  Where Certitype In ('C', 'Y', 'Z')  ) rf                          ");
		buffer.append("  where c.certino = rf.certino  ");
		buffer.append("   and rf.certitype in ('C', 'Y')  ");
		//buffer.append("   and rf.payrefdate is null  ");
		buffer.append("   and rf.planfee > rf.realpayreffee  ");
		buffer.append("  and rf.planfee > 0)  ");
		buffer.append("  )  ");
		PayQueryConditionLogger.payQueryConditionData("getNewQueryCount——1方法：<br>"+buffer.toString());
    	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    /**
  	 * 支付信息查询列表显示方法
  	 * @param payType	支付类型
  	 * @param paymentType	赔款类型
  	 * @param comCode	机构号码
  	 * @return
  	 * @throws Exception
  	 */
      public int getNewQueryCount(String payType,String paymentType,String conditions ,String casesType,String userComcode)throws Exception{
      	//String comCodeStr = comCode.substring(0, 6);
      	//String conditions="";
      	//String paymentNo="";
    	  System.err.println(666666+"单笔支付-确定");
      	int count = -1;
      	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
      	StringBuffer buffer = new StringBuffer(200);
      	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
      	buffer.append("SELECT count(1) FROM ( ");
      	buffer.append(" select * ");
      	buffer.append(" from (  ");
      	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
      	//--赔款
      	buffer.append(" select r.registno, ");
      	buffer.append(" t.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
      	buffer.append(" t.compensateno as certino, ");
      	buffer.append(" c.claimNo, ");
      	buffer.append(" r.insuredname, ");
      	buffer.append(" r.licenseno, ");
  		buffer.append("  t.sumthispaid, ");
          //buffer.append("   t.underwriteenddate, ");
          buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
          buffer.append("  '赔款' as payType, ");
          buffer.append(" r.comcode, ");
          buffer.append(" '' as comcname, ");
      	buffer.append(" (select sum(payamount) ");
          buffer.append(" from prplpay prplpay ");
          buffer.append(" where prplpay.registno = r.registno ");
          buffer.append(" and prplpay.compensateno = t.compensateno ");
          buffer.append(" and prplpay.policyno = t.policyno ");
          buffer.append(" and prplpay.paymenttype = 'P60' ");
          buffer.append(" and prplpay.paytype = 'P3' ");
          
          buffer.append(" ) as havPay , ");//--已支付
          buffer.append(" 'C' as certitype,  ");
          buffer.append(" 'P60' as payrefreason  ");
          buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
          buffer.append(" where t.claimno = c.claimno ");
          buffer.append(" and c.registno = r.registno "); 
          if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
          	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
          }
          if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
          	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
          }
          buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
          buffer.append(" and r.classcode<>'05' ");
          if("mechanism".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
          }else if("agnet".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
          }
          //添加已支付完成的查询不出来条件
  		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where prplpay.registno = r.registno ");
          buffer.append(" and prplpay.compensateno = t.compensateno ");
          buffer.append(" and prplpay.policyno = t.policyno ");
          buffer.append(" and prplpay.paymenttype = 'P60' ");
          buffer.append(" and prplpay.paytype = 'P3' ");
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
          buffer.append(conditions);
          buffer.append(" and 5=5 ");
          
         //代付共保赔款
          buffer.append(" union all ");
          buffer.append(" select r.registno, ");
        	buffer.append(" t.policyno, ");
//    		buffer.append(" (select case grp.policytype ");
//    		buffer.append(" when '1' then '商业险' ");
//    		buffer.append(" when '3' then '交强险' ");
//    		buffer.append(" else '' end ");
//    		buffer.append(" from prplregistrpolicy grp ");
//    		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
        	buffer.append("co.businessno as certino, ");
        	buffer.append(" c.claimNo, ");
        	buffer.append("  co.coinsname as insuredname, ");
        	buffer.append(" r.licenseno, ");
    		buffer.append("  co.coinssumpaid, ");
            //buffer.append("   t.underwriteenddate, ");
            buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
            buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
            buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
            buffer.append(" r.comcode, ");
            buffer.append(" '' as comcname, ");
        	buffer.append(" (select sum(payamount) ");
            buffer.append(" from prplpay prplpay ");
            buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
            buffer.append(" and prplpay.paytype = 'P3' ");
            
            buffer.append(" ) as havPay , ");//--已支付
            buffer.append(" 'C' as certitype,  ");
            buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
            buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason  ");
            buffer.append(" from prplcompensate t, prplclaim c, prplregist r,prplcfeecoins co ");
            buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
            buffer.append(" and c.registno = r.registno "); 
            if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
            	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
            }
            if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
            	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
            }
            buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
            buffer.append(" and r.classcode<>'05' ");
            if("mechanism".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
            //添加已支付完成的查询不出来条件
    		buffer.append(" and (select co.coinssumpaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
            buffer.append(" and prplpay.paytype = 'P3' ");
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
            buffer.append(conditions);
            buffer.append(" and 5=5 ");
          
  		//--赔付费用
          buffer.append(" union all ");
          buffer.append(" select r.registno, ");
          buffer.append(" t.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
          buffer.append("  t.compensateno as certino, ");
          buffer.append(" c.claimNo, ");
          buffer.append(" r.insuredname, ");
          buffer.append(" r.licenseno, ");
          buffer.append(" ch.chargeamount as sumthispaid, ");
          //buffer.append(" t.underwriteenddate, ");
          buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
          buffer.append(" '赔付费用' as payType, ");
          buffer.append(" r.comcode, ");
          buffer.append(" '' as comcname, ");
          buffer.append(" (select sum(payamount) ");
          buffer.append(" from prplpay prplpay ");
         	buffer.append(" where prplpay.registno = r.registno ");
         	buffer.append(" and prplpay.compensateno = t.compensateno ");
         	buffer.append(" and prplpay.policyno = t.policyno ");
         	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
         	buffer.append("  and prplpay.paytype = 'P3' ");
         	
          buffer.append(" ) as havPay , ");	//--已支付
          buffer.append(" 'C' as certitype,  ");
         /* buffer.append(" case ch.chargecode  ");
  		buffer.append(" when '05' then  ");
  		buffer.append("  'P64'  ");
  		buffer.append(" when '07' then  ");
  		buffer.append("  'P61'  ");
  		buffer.append(" when '15' then  ");
  		buffer.append("  'P68'  ");
  		buffer.append(" when '29' then  ");
  		buffer.append("  'P611'  ");
  		buffer.append(" when '30' then  ");
  		buffer.append("  'P612'  ");
  		buffer.append(" when '14' then  ");
  		buffer.append("  'P65'  ");
  		buffer.append(" when '13' then  ");
  		buffer.append("  'P67'  ");
  		buffer.append(" when '04' then  ");
  		buffer.append("  'P62'  ");
  		buffer.append(" when '99' then  ");
  		buffer.append("  'P69'  ");
  		buffer.append(" else  ");
  		buffer.append("  ''  ");
  		buffer.append("  end as payrefreason  ");*/
        buffer.append("  changechargecodetopaymenttype(ch.chargecode) as payrefreason ");      
  		buffer.append(" from (select compensateno, chargecode,sum(nvl(chargeamount,0)-nvl(prechargeamount,0)-nvl(sumrealpay,0)) as chargeamount ");
       	buffer.append("  from prplcharge where  chargecode<>'14' ");
       	buffer.append(" group by compensateno, chargecode) ch, ");
       	buffer.append("  prplcompensate t, prplclaim c, prplregist r ");
        // 	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r ");
         	
         	buffer.append(" where ch.compensateno = t.compensateno ");
         	buffer.append(" and t.claimno = c.claimno ");
         	buffer.append(" and c.registno = r.registno ");
         	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
         		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
         	}
         	if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
         		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
         	}
         	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
         	buffer.append(" and r.classcode<>'05' ");
         	if("mechanism".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
         	//添加已支付完成的查询不出来条件
  		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where prplpay.registno = r.registno ");
         	buffer.append(" and prplpay.compensateno = t.compensateno ");
         	buffer.append(" and prplpay.policyno = t.policyno ");
         	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
         	buffer.append(" and prplpay.paytype = 'P3' ");
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
         	buffer.append(conditions);
      	}
      	if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
        	//--预赔赔款
  		//buffer.append(" union all ");
  		buffer.append(" select r.registno, ");
  		buffer.append(" pre.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
  		buffer.append(" pre.precompensateno as certino, ");
  		buffer.append(" c.claimNo, ");
  		buffer.append(" r.insuredname, ");
  		buffer.append(" r.licenseno, ");
  		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
  		//buffer.append(" pre.underwriteenddate, ");
  		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
  		buffer.append(" '预赔赔款' as payType, ");
  		buffer.append(" r.comcode, ");
  		buffer.append(" '' as comcname, ");
  		buffer.append(" (select sum(payamount) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and paymenttype = 'P50' "); 
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		
  		
  		
  	    buffer.append(" ) as havPay , ");//--已支付
  	    buffer.append(" 'Y' as certitype,  ");
          buffer.append(" 'P50' as payrefreason  ");
  		buffer.append(" from prplprepay pre, prplclaim c, prplregist r ");
  		
  		buffer.append(" where pre.claimno = c.claimno ");
  		buffer.append(" and c.registno = r.registno ");
  		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
  			buffer.append(" and 1<>1 ");
  		}
  		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		if(payType!=null&&!"".equals(payType)){
  			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
  		}else{
  			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		}
  		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
  		buffer.append(" and r.classcode<>'05' ");
  		if("mechanism".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
          }else if("agnet".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
          }
  		//添加已支付完成的查询不出来条件
  		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and paymenttype = 'P50' "); 
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
  		buffer.append(conditions);
  		
  		//--预赔费用
  		buffer.append(" union all ");
  		buffer.append(" select r.registno, ");
  		buffer.append(" pre.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
  		buffer.append(" pch.precompensateno as certino, ");
  		buffer.append(" c.claimNo, ");
  		buffer.append(" r.insuredname, ");
  		buffer.append(" r.licenseno, ");
  		buffer.append(" pch.sumprepaid as sumthispaid, ");
  		//buffer.append(" pre.underwriteenddate, ");
  		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
  		buffer.append(" '预赔费用' as payType, ");
  		
  		buffer.append(" r.comcode, ");
  		buffer.append(" '' as comcname, ");
  		buffer.append(" (select sum(payamount) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		
  	    buffer.append(" ) as havPay , ");//--已支付
  	    buffer.append(" 'Y' as certitype,  ");
  	    /*buffer.append(" case pch.chargecode  ");
  		buffer.append(" when '05' then  ");
  		buffer.append("  'Y64'  ");
  		buffer.append(" when '07' then  ");
  		buffer.append("  'Y61'  ");
  		buffer.append(" when '15' then  ");
  		buffer.append("  'Y68'  ");
  		buffer.append(" when '29' then  ");
  		buffer.append("  'Y611'  ");
  		buffer.append(" when '30' then  ");
  		buffer.append("  'Y612'  ");
  		buffer.append(" when '14' then  ");
  		buffer.append("  'Y65'  ");
  		buffer.append(" when '13' then  ");
  		buffer.append("  'Y67'  ");
  		buffer.append(" when '04' then  ");
  		buffer.append("  'Y62'  ");
  		buffer.append(" else  ");
  		buffer.append("  'Y69'  ");
  		buffer.append("  end as payrefreason  ");*/
  	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason  "); 
  		buffer.append(" from (select claimno,precompensateno,chargecode, ");
		buffer.append(" sum(sumprepaid) as sumprepaid ");
		buffer.append(" from prplprecharge ");
		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
		buffer.append("  prplprepay pre, prplclaim c, prplregist r ");
  		//buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ");
  		
  		buffer.append(" where pch.claimno = c.claimno ");
  		buffer.append(" and pch.precompensateno = pre.precompensateno ");
  		buffer.append(" and c.registno = r.registno ");
  		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
  			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
  		}
  		if(payType!=null&&!"".equals(payType)){
  			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
  		}else{
  			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		}
  		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
  		buffer.append(" and r.classcode<>'05' ");
  		if("mechanism".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
          }else if("agnet".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
          }
  		//添加已支付完成的查询不出来条件
  		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
  		buffer.append(conditions);
      	}
  		
  		
  		buffer.append(" ) c  ");
  		buffer.append("  where  exists (select 1  ");
        buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
        buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
        buffer.append( "  Union All                                                                            ");
        buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
        buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
   		buffer.append("         where rec.certino = c.certino  ");
   		buffer.append("           and rec.certitype = c.certitype ");
   		buffer.append("           and rec.payrefreason = c.payrefreason ");
   		buffer.append("           and rec.payrefstate in ('00', '01') ");
   		buffer.append("           and rec.payrefdate is null) ");
//  		buffer.append("  where exists (select 1  ");
//  		buffer.append("  from prpjplanfee rf  ");
//  		buffer.append("  where c.certino = rf.certino  ");
//  		buffer.append("   and rf.certitype in ('C', 'Y')  ");
//  		//buffer.append("   and rf.payrefdate is null  ");
//  		buffer.append("   and rf.planfee > rf.realpayreffee  ");
//  		buffer.append("  and rf.planfee > 0)  ");
  		buffer.append("  )  ");
  		PayQueryConditionLogger.payQueryConditionData("getNewQueryCount——2方法：<br>"+buffer.toString());
      	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
          resultSet.next();
          count = dbManager.getInt(resultSet,1);
          resultSet.close();
          return count;
      }
      
      /**
    	 * 支付信息查询列表显示方法
    	 * @param payType	支付类型
    	 * @param paymentType	赔款类型
    	 * @param comCode	机构号码
    	 * @return
    	 * @throws Exception
    	 */
        public int getNewQueryRegistCount(String payType,String paymentType,String conditions ,String casesType,String userComcode)throws Exception{
        	//String comCodeStr = comCode.substring(0, 6);
        	//String conditions="";
        	//String paymentNo="";
        	System.err.println(777777+"单笔支付");
        	int count = -1;
        	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
        	StringBuffer buffer = new StringBuffer(200);
        	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
    		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
    		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
        	buffer.append("SELECT count(1) FROM ( ");
        	buffer.append(" select distinct tt.registno,tt.policyno,tt.damageenddate,tt.startdate,tt.enddate,tt.insuredname,c.comcode,c.comcname ");
        	buffer.append(" from (  ");
        	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
        	//--赔款
        	buffer.append(" select r.registno, ");
        	buffer.append(" t.policyno, ");
//    		buffer.append(" (select case grp.policytype ");
//    		buffer.append(" when '1' then '商业险' ");
//    		buffer.append(" when '3' then '交强险' ");
//    		buffer.append(" else '' end ");
//    		buffer.append(" from prplregistrpolicy grp ");
//    		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
        	buffer.append(" t.compensateno as certino, ");
        	buffer.append(" c.claimNo, ");
        	buffer.append(" r.insuredname, ");
        	buffer.append(" r.licenseno, ");
    		buffer.append("  t.sumthispaid, ");
            //buffer.append("   t.underwriteenddate, ");
            buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
            buffer.append("  '赔款' as payType, ");
            buffer.append(" r.comcode, ");
            buffer.append(" '' as comcname, ");
        	buffer.append(" (select sum(payamount) ");
            buffer.append(" from prplpay prplpay ");
            buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = t.compensateno ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and prplpay.paymenttype = 'P60' ");
            buffer.append(" and prplpay.paytype = 'P3' ");
            
            buffer.append(" ) as havPay , ");//--已支付
            buffer.append(" 'C' as certitype,  ");
            buffer.append(" 'P60' as payrefreason  ");
            buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
            buffer.append(" where t.claimno = c.claimno ");
            buffer.append(" and c.registno = r.registno "); 
            if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
            	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
            }
            if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
            	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
            }
            buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
            buffer.append(" and r.classcode<>'05' ");
            if("mechanism".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
            //添加已支付完成的查询不出来条件
    		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = t.compensateno ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and prplpay.paymenttype = 'P60' ");
            buffer.append(" and prplpay.paytype = 'P3' ");
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
            buffer.append(conditions);
            
          //新增代付共保赔款
            buffer.append(" union all ");
            buffer.append(" select r.registno, ");
        	buffer.append(" t.policyno, ");
//    		buffer.append(" (select case grp.policytype ");
//    		buffer.append(" when '1' then '商业险' ");
//    		buffer.append(" when '3' then '交强险' ");
//    		buffer.append(" else '' end ");
//    		buffer.append(" from prplregistrpolicy grp ");
//    		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
        	buffer.append(" co.businessno as certino, ");
        	buffer.append(" c.claimNo, ");
        	buffer.append(" r.insuredname, ");
        	buffer.append(" r.licenseno, ");
    		buffer.append("  co.coinssumpaid as sumthispaid, ");
            //buffer.append("   t.underwriteenddate, ");
            buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
            buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
            buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
            buffer.append(" r.comcode, ");
            buffer.append(" '' as comcname, ");
        	buffer.append(" (select sum(payamount) ");
            buffer.append(" from prplpay prplpay ");
            buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
            buffer.append(" and prplpay.paytype = 'P3' ");
            
            buffer.append(" ) as havPay , ");//--已支付
            buffer.append(" 'C' as certitype,  ");
            buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
            buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason  ");
            buffer.append(" from prplcompensate t, prplclaim c, prplregist r ,prplcfeecoins  co");
            buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
            buffer.append(" and c.registno = r.registno "); 
            if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
            	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
            }
            if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
            	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
            }
            buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
            buffer.append(" and r.classcode<>'05' ");
            if("mechanism".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
            //添加已支付完成的查询不出来条件
    		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno =  co.businessno and prplpay.coinscode=co.coinscode ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
            buffer.append(" and prplpay.paytype = 'P3' ");
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
            buffer.append(conditions);
            
    		//--赔付费用
            buffer.append(" union all ");
            buffer.append(" select r.registno, ");
            buffer.append(" t.policyno, ");
//    		buffer.append(" (select case grp.policytype ");
//    		buffer.append(" when '1' then '商业险' ");
//    		buffer.append(" when '3' then '交强险' ");
//    		buffer.append(" else '' end ");
//    		buffer.append(" from prplregistrpolicy grp ");
//    		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
            buffer.append("  t.compensateno as certino, ");
            buffer.append(" c.claimNo, ");
            buffer.append(" r.insuredname, ");
            buffer.append(" r.licenseno, ");
            buffer.append(" ch.chargeamount as sumthispaid, ");
            //buffer.append(" t.underwriteenddate, ");
            buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
            buffer.append(" '赔付费用' as payType, ");
            buffer.append(" r.comcode, ");
            buffer.append(" '' as comcname, ");
            buffer.append(" (select sum(payamount) ");
            buffer.append(" from prplpay prplpay ");
           	buffer.append(" where prplpay.registno = r.registno ");
           	buffer.append(" and prplpay.compensateno = t.compensateno ");
           	buffer.append(" and prplpay.policyno = t.policyno ");
           	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
           	buffer.append("  and prplpay.paytype = 'P3' ");
           	
            buffer.append(" ) as havPay , ");	//--已支付
            buffer.append(" 'C' as certitype,  ");
            /*buffer.append(" case ch.chargecode  ");
    		buffer.append(" when '05' then  ");
    		buffer.append("  'P64'  ");
    		buffer.append(" when '07' then  ");
    		buffer.append("  'P61'  ");
    		buffer.append(" when '15' then  ");
    		buffer.append("  'P68'  ");
    		buffer.append(" when '29' then  ");
    		buffer.append("  'P611'  ");
    		buffer.append(" when '30' then  ");
    		buffer.append("  'P612'  ");
    		buffer.append(" when '14' then  ");
    		buffer.append("  'P65'  ");
    		buffer.append(" when '13' then  ");
    		buffer.append("  'P67'  ");
    		buffer.append(" when '04' then  ");
    		buffer.append("  'P62'  ");
    		buffer.append(" else  ");
    		buffer.append("  ''  ");
    		buffer.append("  end as payrefreason  ");*/
            buffer.append("  changechargecodetopaymenttype(ch.chargecode) as payrefreason  ");
    		buffer.append(" from (select compensateno, chargecode,sum(nvl(chargeamount,0)-nvl(prechargeamount,0)-nvl(sumrealpay,0)) as chargeamount ");
         	buffer.append("  from prplcharge where  chargecode<>'14' ");
         	buffer.append(" group by compensateno, chargecode) ch, ");
         	buffer.append("  prplcompensate t, prplclaim c, prplregist r ");
          // 	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r ");
           	
           	buffer.append(" where ch.compensateno = t.compensateno ");
           	buffer.append(" and t.claimno = c.claimno ");
           	buffer.append(" and c.registno = r.registno ");
           	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
           		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
           	}
           	if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
           		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
           	}
           	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
           	buffer.append(" and r.classcode<>'05' ");
           	if("mechanism".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
            	 
              }else if("agnet".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
              }
           	//添加已支付完成的查询不出来条件
    		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where prplpay.registno = r.registno ");
           	buffer.append(" and prplpay.compensateno = t.compensateno ");
           	buffer.append(" and prplpay.policyno = t.policyno ");
           	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
           	buffer.append(" and prplpay.paytype = 'P3' ");
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
           	buffer.append(conditions);
        	}
        	if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
          	//--预赔赔款
    		//buffer.append(" union all ");
    		buffer.append(" select r.registno, ");
    		buffer.append(" pre.policyno, ");
//    		buffer.append(" (select case grp.policytype ");
//    		buffer.append(" when '1' then '商业险' ");
//    		buffer.append(" when '3' then '交强险' ");
//    		buffer.append(" else '' end ");
//    		buffer.append(" from prplregistrpolicy grp ");
//    		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
    		buffer.append(" pre.precompensateno as certino, ");
    		buffer.append(" c.claimNo, ");
    		buffer.append(" r.insuredname, ");
    		buffer.append(" r.licenseno, ");
    		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
    		//buffer.append(" pre.underwriteenddate, ");
    		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
    		buffer.append(" '预赔赔款' as payType, ");
    		buffer.append(" r.comcode, ");
    		buffer.append(" '' as comcname, ");
    		buffer.append(" (select sum(payamount) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and paymenttype = 'P50' "); 
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    		
    		
    		
    	    buffer.append(" ) as havPay , ");//--已支付
    	    buffer.append(" 'Y' as certitype,  ");
            buffer.append(" 'P50' as payrefreason  ");
    		buffer.append(" from prplprepay pre, prplclaim c, prplregist r ");
    		
    		buffer.append(" where pre.claimno = c.claimno ");
    		buffer.append(" and c.registno = r.registno ");
    		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
    			buffer.append(" and 1<>1 ");
    		}
    		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
    		if(payType!=null&&!"".equals(payType)){
    			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
    		}else{
    			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
    		}
    		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
    		buffer.append(" and r.classcode<>'05' ");
    		if("mechanism".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
    		//添加已支付完成的查询不出来条件
    		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and paymenttype = 'P50' "); 
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
    		buffer.append(conditions);
    		
    		//--预赔费用
    		buffer.append(" union all ");
    		buffer.append(" select r.registno, ");
    		buffer.append(" pre.policyno, ");
//    		buffer.append(" (select case grp.policytype ");
//    		buffer.append(" when '1' then '商业险' ");
//    		buffer.append(" when '3' then '交强险' ");
//    		buffer.append(" else '' end ");
//    		buffer.append(" from prplregistrpolicy grp ");
//    		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
    		buffer.append(" pch.precompensateno as certino, ");
    		buffer.append(" c.claimNo, ");
    		buffer.append(" r.insuredname, ");
    		buffer.append(" r.licenseno, ");
    		buffer.append(" pch.sumprepaid as sumthispaid, ");
    		//buffer.append(" pre.underwriteenddate, ");
    		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
    		buffer.append(" '预赔费用' as payType, ");
    		
    		buffer.append(" r.comcode, ");
    		buffer.append(" '' as comcname, ");
    		buffer.append(" (select sum(payamount) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    		
    	    buffer.append(" ) as havPay , ");//--已支付
    	    buffer.append(" 'Y' as certitype,  ");
    	    /*buffer.append(" case pch.chargecode  ");
    		buffer.append(" when '05' then  ");
    		buffer.append("  'Y64'  ");
    		buffer.append(" when '07' then  ");
    		buffer.append("  'Y61'  ");
    		buffer.append(" when '15' then  ");
    		buffer.append("  'Y68'  ");
    		buffer.append(" when '29' then  ");
    		buffer.append("  'Y611'  ");
    		buffer.append(" when '30' then  ");
    		buffer.append("  'Y612'  ");
    		buffer.append(" when '14' then  ");
    		buffer.append("  'Y65'  ");
    		buffer.append(" when '13' then  ");
    		buffer.append("  'Y67'  ");
    		buffer.append(" when '04' then  ");
    		buffer.append("  'Y62'  ");
    		buffer.append(" else  ");
    		buffer.append("  'Y69'  ");
    		buffer.append("  end as payrefreason  ");*/
    	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason ");
    		buffer.append(" from (select claimno,precompensateno,chargecode, ");
  		buffer.append(" sum(sumprepaid) as sumprepaid ");
  		buffer.append(" from prplprecharge ");
  		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
  		buffer.append("  prplprepay pre, prplclaim c, prplregist r ");
    		//buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ");
    		
    		buffer.append(" where pch.claimno = c.claimno ");
    		buffer.append(" and pch.precompensateno = pre.precompensateno ");
    		buffer.append(" and c.registno = r.registno ");
    		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
    			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
    		}
    		if(payType!=null&&!"".equals(payType)){
    			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
    		}else{
    			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
    		}
    		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
    		buffer.append(" and r.classcode<>'05' ");
    		if("mechanism".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
    		//添加已支付完成的查询不出来条件
    		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
    		buffer.append(conditions);
        	}
    		buffer.append(" ) c ,prplclaim tt ");
    		buffer.append("  where  c.registno = tt.registno");
     		buffer.append(" and exists (select 1  ");
//     		buffer.append("          from prpjpayrefrec rec ");
            buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
            buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
            buffer.append( "  Union All                                                                            ");
            buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
            buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
     		buffer.append("         where rec.certino = c.certino  ");
     		buffer.append("           and rec.certitype = c.certitype ");
     		buffer.append("           and rec.payrefreason = c.payrefreason ");
     		buffer.append("           and rec.payrefstate in ('00', '01') ");
     		buffer.append("           and rec.payrefdate is null) ");
     		buffer.append("	And Not Exists (Select 1 ");
     		buffer.append("          From Prplinterrelation Nn ");
     		buffer.append("         Where Nn.Relationregistno = C.Registno) ");
//    		buffer.append("  where exists (select 1  ");
//    		buffer.append("  from prpjplanfee rf  ");
//    		buffer.append("  where c.certino = rf.certino  ");
//    		buffer.append("   and rf.certitype in ('C', 'Y')  ");
//    		//buffer.append("   and rf.payrefdate is null  ");
//    		buffer.append("   and rf.planfee > rf.realpayreffee  ");
//    		buffer.append("  and rf.planfee > 0)  ");
    		buffer.append("  )  ");
    		
    		System.err.println(buffer.toString());
        	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
            resultSet.next();
            count = dbManager.getInt(resultSet,1);
            resultSet.close();
            return count;
        }
	public ArrayList<PrpLpayShowDto> getShowBillList(String payType,
			String paymentType, String comCode, String paymentNo, String payName, String identifyNumber,
			String registNo, String compensateNo,  boolean flag, String status,String back) throws Exception{
		System.err.println(888888);
    	String comCodeStr = comCode.substring(0, 6);
    	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
    	StringBuffer buffer = new StringBuffer(200);
    	buffer.append(" select registno,Policyno,Policytype,Certino,Claimno,Insuredname,Licenseno,Sumthispaid,Underwriteenddate,Paytype,Comcode,(select cop.comcname from prpdcompany cop where cop.comcode = c.comcode) as Comcname,Havpay,nowPay,exist,Certitype,Payrefreason,vFlag,claimrelationno,fkSerialNo,billPaid,billHavPay   ");
    	buffer.append(" from (  ");
    	//--赔款
    	buffer.append(" select r.registno, ");
    	buffer.append(" t.policyno, ");
		buffer.append(" '' as policyType, ");
    	buffer.append(" t.compensateno as certino, ");
    	buffer.append(" c.claimNo, ");
    	buffer.append(" kk.payname as InsuredName, ");
    	buffer.append(" r.licenseno, ");
		buffer.append("  t.sumthispaid as sumthispaid, ");
        buffer.append("   t.underwriteenddate, ");
        buffer.append("  '赔款' as payType, ");
        buffer.append(" r.comcode, ");
        buffer.append(" '' as comcname, ");
    	if("1".equals(back)){
        	buffer.append(" (select nvl(sum(decode(prplpay.vflag,'3',0,'7',0,'9',0,payamount)), 0) ");
        }else{
        	buffer.append(" (select sum(payamount) ");
        }
        buffer.append(" from prplpay prplpay ");
        buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno = t.compensateno ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and prplpay.paymenttype = 'P60' ");
        if(payType != null &&!"".equals(payType)&&!"P3".equals(payType)&&!"P5".equals(payType)){
        	buffer.append(" and prplpay.paytype = 'P3' ");
        }
        if(paymentNo!=null&&!"".equals(paymentNo)){
        	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
        }
        buffer.append(" ) as havPay , ");//--已支付
        buffer.append(" sum(pay.payamount) as nowPay,  ");//--本次支付金额
        buffer.append(" pay.exist ,   ");//--是否勾选
        buffer.append(" 'C' as certitype,  ");
        buffer.append(" 'P60' as payrefreason,  ");
        buffer.append(" pay.vFlag,   ");
        buffer.append(" t.claimrelationno, ");
        buffer.append(" wmsys.wm_concat(kk.serialno) as fkSerialNo,");
        buffer.append(" sum(kk.sumpaid) as billPaid,");
        if("1".equals(back)){
        	buffer.append(" (select nvl(sum(decode(prplpay.vflag,'3',0,'7',0,'9',0,payamount)), 0) ");
        }else{
        	buffer.append(" (select sum(payamount) ");
        }
        buffer.append(" from prplpay prplpay ");
        buffer.append(" where prplpay.registno = r.registno ");
        buffer.append(" and prplpay.compensateno = t.compensateno ");
        buffer.append(" and prplpay.policyno = t.policyno ");
        buffer.append(" and prplpay.paymenttype = 'P60' ");
        buffer.append(" and prplpay.receiverfullname=kk.payname ");
        buffer.append(" and prplpay.certifno=kk.identifynumber ");
        if(payType != null &&!"".equals(payType)&&!"P3".equals(payType)&&!"P5".equals(payType)){
        	buffer.append(" and prplpay.paytype = 'P3' ");
        }
        if(paymentNo!=null&&!"".equals(paymentNo)){
        	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
        }
        buffer.append(" ) as billHavPay  ");//--已支付
        buffer.append(" from prplcompensate t, prplclaim c, prplregist r,prplclaimbillmanager kk ");
        buffer.append(" ,(select distinct payamount, compensateno, '1' as exist,vFlag ");
        buffer.append(" from prplpay ");
        buffer.append(" where serialno = '"+paymentNo+"'");
        buffer.append(" and paymenttype='P60' ) pay ");
        buffer.append(" where t.claimno = c.claimno ");
        buffer.append(" and c.registno = r.registno "); 
        buffer.append(" and kk.compensateno=t.compensateno ");
        buffer.append(" and kk.payname='"+payName+"' ");
        buffer.append(" and kk.identifynumber='"+identifyNumber+"' ");
        if("0".equals(status)){
        	if("1".equals(back)){
        		buffer.append(" and (select kk.sumpaid - nvl(sum(decode(prplpay.vflag,'3',0,'7',0,'9',0,payamount)), 0) "); 
        	}else{
        		buffer.append(" and (select kk.sumpaid - nvl(sum(payamount), 0) "); 
        	}
        	buffer.append("         from prplpay "); 
        	buffer.append("        where prplpay.registno = r.registno "); 
        	buffer.append("          and prplpay.compensateno = t.compensateno "); 
        	buffer.append("          and prplpay.policyno = t.policyno "); 
        	buffer.append("			 and prplpay.receiverfullname = kk.payname ");
        	buffer.append("          and prplpay.certifno = kk.identifynumber ");
        	buffer.append("          and prplpay.paymenttype = 'P60' "); 
        	//buffer.append("          and prplpay.paytype = 'P3') <> 0 "); 
        	buffer.append("          ) <> 0 "); 
        }
        
        //buffer.append(" and r.registno in ('报案号码') ");// --？（选择添加）
        if(registNo!=null&&!"".equals(registNo)){
    		buffer.append(" and r.registNo = '"+registNo+"'");
    	}
        if(payType != null &&!"".equals(payType)&&!"P3".equals(payType) && !"P5".equals(payType)){
        	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
        }
        if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){
        	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
        }
        if(flag){//判断标志，当从预赔理算环节进入支付信息页面，无需判断费用是否核赔通过
        	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
        }
        //buffer.append(" and t.compensateno in ('理算书号') ");
        if(compensateNo!=null&&!"".equals(compensateNo)){
    		buffer.append(" and t.compensateno in ("+compensateNo+")");
    	}
        if(paymentNo!=null&&!"".equals(paymentNo)&&!"1".equals(status)){
        	buffer.append(" and pay.compensateno = t.compensateno ");
        }else{
        	buffer.append(" and pay.compensateno(+) = t.compensateno ");
        }
        buffer.append(" group by r.registno,t.policyno,t.compensateno,c.claimNo,kk.payname,kk.identifynumber,r.licenseno,t.sumthispaid,t.underwriteenddate,r.comcode,pay.exist,pay.vFlag,t.claimrelationno ");
        // buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//（此处去除 20130828 ）
		buffer.append("  ) c  ");
		if(flag){
			buffer.append("  where exists (select 1  ");
			buffer.append("  from prpjplanfee rf  ");
			buffer.append("  where c.certino = rf.certino  ");
			buffer.append("   and  rf.certitype = c.certitype  ");
			buffer.append("   and rf.payrefreason = c.payrefreason  ");
			/*if("0".equals(status)){
				buffer.append("   and rf.payrefstate not in ('11','10') ");
			}*/
			/*buffer.append("   and rf.planfee > rf.realpayreffee  ");
			buffer.append("  and rf.planfee > 0");第三方支付赔款支付信息新增修改*/
			//控制三方支付上线前数据不能与上线后数据合并支付 add by chu 20140327
			if("0".equals(status)){
				buffer.append("  and exists (select 1  ");
				buffer.append("  from prpjpayrefrec ff  ");
				buffer.append("  where c.certino = ff.certino  ");
				buffer.append("   and  ff.certitype = c.certitype  ");
				buffer.append("   and ff.payrefreason = c.payrefreason  ");
				buffer.append("   and ff.visaserialno is not null and ff.visaserialno like '9%' ");
				buffer.append("   and ff.payrefstate not in ('11','10') ");
				buffer.append(") ");
			}
			buffer.append(") ");
		}
    	
		System.err.println(buffer.toString());
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
    	PrpLpayShowDto prpLpayShowDto =null;
    	while(resultSet.next()){
    		prpLpayShowDto = new PrpLpayShowDto();
    		prpLpayShowDto.setRegistNo(dbManager.getString(resultSet,"RegistNo"));
    		prpLpayShowDto.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
    		prpLpayShowDto.setPolicyType(dbManager.getString(resultSet,"PolicyType"));
    		prpLpayShowDto.setCertiNo(dbManager.getString(resultSet,"CertiNo"));
    		prpLpayShowDto.setClaimNo(dbManager.getString(resultSet,"ClaimNo"));
    		prpLpayShowDto.setInsuredName(dbManager.getString(resultSet,"InsuredName"));
    		prpLpayShowDto.setLicenseNo(dbManager.getString(resultSet,"LicenseNo"));
    		prpLpayShowDto.setSumPaid(dbManager.getDouble(resultSet,"sumthispaid"));
    		prpLpayShowDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"UnderWriteEndDate").toString(DateTime.YEAR_TO_SECOND));
    		prpLpayShowDto.setPayType(dbManager.getString(resultSet,"PayType"));
    		prpLpayShowDto.setComCode(dbManager.getString(resultSet,"ComCode"));
    		prpLpayShowDto.setComCodeName(dbManager.getString(resultSet,"ComCName"));
    		prpLpayShowDto.setHavPaid(dbManager.getDouble(resultSet,"HavPay"));
    		prpLpayShowDto.setNowPaid(dbManager.getDouble(resultSet,"NowPay"));
    		prpLpayShowDto.setExist(dbManager.getString(resultSet,"Exist"));
    		prpLpayShowDto.setVflag(dbManager.getString(resultSet, "vFlag"));
    		prpLpayShowDto.setPayrefreason(dbManager.getString(resultSet, "payrefreason"));
    		prpLpayShowDto.setClassCode(dbManager.getString(resultSet,"RegistNo"));
    		prpLpayShowDto.setClaimRelationNo(dbManager.getString(resultSet, "claimrelationno"));
    		prpLpayShowDto.setFkSerialNo(dbManager.getString(resultSet, "fkSerialNo"));
    		prpLpayShowDto.setBillPaid(dbManager.getDouble(resultSet, "billPaid"));
    		prpLpayShowDto.setBillHavPay(dbManager.getDouble(resultSet, "billHavPay"));
    		list.add(prpLpayShowDto);
    	}
    	resultSet.close();
    	return list;
    
	}
	
	/**
  	 * 支付信息查询列表显示方法
  	 * @param payType	支付类型
  	 * @param paymentType	赔款类型
  	 * @param comCode	机构号码
  	 * @return
  	 * @throws Exception
  	 */
      public int getFiscalQueryRegistCount(String payType,String paymentType,String back,String userCode,String conditions ,String casesType,String userComcode)throws Exception{
      	//String comCodeStr = comCode.substring(0, 6);
      	//String conditions="";
      	//String paymentNo="";
    	  System.err.println(999999);
      	int count = -1;
      	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
      	StringBuffer buffer = new StringBuffer(200);
      	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
      	buffer.append("SELECT count(1) FROM ( ");
      	buffer.append(" select distinct tt.registno,tt.policyno,tt.damageenddate,tt.startdate,tt.enddate,tt.insuredname,c.comcode,c.comcname ");
      	buffer.append(" from (  ");
      	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
      	//--赔款
      	buffer.append(" select r.registno, ");
      	buffer.append(" t.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
      	buffer.append(" t.compensateno as certino, ");
      	buffer.append(" c.claimNo, ");
      	buffer.append(" r.insuredname, ");
      	buffer.append(" r.licenseno, ");
  		buffer.append("  t.sumthispaid, ");
          //buffer.append("   t.underwriteenddate, ");
          buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
          buffer.append("  '赔款' as payType, ");
          buffer.append(" r.comcode, ");
          buffer.append(" '' as comcname, ");
      	buffer.append(" (select sum(payamount) ");
          buffer.append(" from prplpay prplpay ");
          buffer.append(" where prplpay.registno = r.registno ");
          buffer.append(" and prplpay.compensateno = t.compensateno ");
          buffer.append(" and prplpay.policyno = t.policyno ");
          buffer.append(" and prplpay.paymenttype = 'P60' ");
          buffer.append(" and prplpay.paytype = 'P3' ");
          
          buffer.append(" ) as havPay , ");//--已支付
          buffer.append(" 'C' as certitype,  ");
          buffer.append(" 'P60' as payrefreason  ");
          buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
          buffer.append(" where t.claimno = c.claimno ");
          buffer.append(" and c.registno = r.registno "); 
          if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
          	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
          }
          if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
          	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
          }
          buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
          buffer.append(" and r.classcode<>'05' ");
          if("mechanism".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
          }else if("agnet".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
          }
          //添加已支付完成的查询不出来条件
  		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where prplpay.registno = r.registno ");
          buffer.append(" and prplpay.compensateno = t.compensateno ");
          buffer.append(" and prplpay.policyno = t.policyno ");
          buffer.append(" and prplpay.paymenttype = 'P60' ");
          buffer.append(" and prplpay.paytype = 'P3' ");
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
          buffer.append(conditions);
          
          //代付共保赔款
            buffer.append(" union all ");
        	buffer.append(" select r.registno, ");
        	buffer.append(" t.policyno, ");
//    		buffer.append(" (select case grp.policytype ");
//    		buffer.append(" when '1' then '商业险' ");
//    		buffer.append(" when '3' then '交强险' ");
//    		buffer.append(" else '' end ");
//    		buffer.append(" from prplregistrpolicy grp ");
//    		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
        	buffer.append("  co.businessno as certino, ");
        	buffer.append(" c.claimNo, ");
        	buffer.append(" r.insuredname, ");
        	buffer.append(" r.licenseno, ");
    		buffer.append("   co.coinssumpaid as sumthispaid, ");
            //buffer.append("   t.underwriteenddate, ");
            buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
            buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
            buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
            buffer.append(" r.comcode, ");
            buffer.append(" '' as comcname, ");
        	buffer.append(" (select sum(payamount) ");
            buffer.append(" from prplpay prplpay ");
            buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
            buffer.append(" and prplpay.paytype = 'P3' ");
            
            buffer.append(" ) as havPay , ");//--已支付
            buffer.append(" 'C' as certitype,  ");
            buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
            buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason  ");
            buffer.append(" from prplcompensate t, prplclaim c, prplregist r ,prplcfeecoins co");
            buffer.append(" where t.claimno = c.claimno  and t.compensateno = co.businessno ");
            buffer.append(" and c.registno = r.registno "); 
            if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
            	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
            }
            if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
            	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
            }
            buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
            buffer.append(" and r.classcode<>'05' ");
            if("mechanism".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
            //添加已支付完成的查询不出来条件
    		buffer.append(" and (select co.coinssumpaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
            buffer.append(" and prplpay.paytype = 'P3' ");
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
            buffer.append(conditions);
          
          
          
  		//--赔付费用
          buffer.append(" union all ");
          buffer.append(" select r.registno, ");
          buffer.append(" t.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
          buffer.append("  t.compensateno as certino, ");
          buffer.append(" c.claimNo, ");
          buffer.append(" r.insuredname, ");
          buffer.append(" r.licenseno, ");
          buffer.append(" ch.chargeamount as sumthispaid, ");
          //buffer.append(" t.underwriteenddate, ");
          buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
          buffer.append(" '赔付费用' as payType, ");
          buffer.append(" r.comcode, ");
          buffer.append(" '' as comcname, ");
          buffer.append(" (select sum(payamount) ");
          buffer.append(" from prplpay prplpay ");
         	buffer.append(" where prplpay.registno = r.registno ");
         	buffer.append(" and prplpay.compensateno = t.compensateno ");
         	buffer.append(" and prplpay.policyno = t.policyno ");
         	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
         	buffer.append("  and prplpay.paytype = 'P3' ");
         	
          buffer.append(" ) as havPay , ");	//--已支付
          buffer.append(" 'C' as certitype,  ");
          /*buffer.append(" case ch.chargecode  ");
  		buffer.append(" when '05' then  ");
  		buffer.append("  'P64'  ");
  		buffer.append(" when '07' then  ");
  		buffer.append("  'P61'  ");
  		buffer.append(" when '15' then  ");
  		buffer.append("  'P68'  ");
  		buffer.append(" when '29' then  ");
  		buffer.append("  'P611'  ");
  		buffer.append(" when '30' then  ");
  		buffer.append("  'P612'  ");
  		buffer.append(" when '14' then  ");
  		buffer.append("  'P65'  ");
  		buffer.append(" when '13' then  ");
  		buffer.append("  'P67'  ");
  		buffer.append(" when '04' then  ");
  		buffer.append("  'P62'  ");
  		buffer.append(" else  ");
  		buffer.append("  ''  ");
  		buffer.append("  end as payrefreason  ");*/
        buffer.append("  changechargecodetopaymenttype(ch.chargecode) as payrefreason  ");
  		buffer.append(" from (select compensateno, chargecode,sum(nvl(chargeamount,0)-nvl(prechargeamount,0)-nvl(sumrealpay,0)) as chargeamount ");
       	buffer.append("  from prplcharge where  chargecode<>'14' ");
       	buffer.append(" group by compensateno, chargecode) ch, ");
       	buffer.append("  prplcompensate t, prplclaim c, prplregist r ");
        // 	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r ");
         	
         	buffer.append(" where ch.compensateno = t.compensateno ");
         	buffer.append(" and t.claimno = c.claimno ");
         	buffer.append(" and c.registno = r.registno ");
         	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
         		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
         	}
         	if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
         		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
         	}
         	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
         	buffer.append(" and r.classcode<>'05' ");
         	if("mechanism".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
         	//添加已支付完成的查询不出来条件
  		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where prplpay.registno = r.registno ");
         	buffer.append(" and prplpay.compensateno = t.compensateno ");
         	buffer.append(" and prplpay.policyno = t.policyno ");
         	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
         	buffer.append(" and prplpay.paytype = 'P3' ");
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
         	buffer.append(conditions);
      	}	
        	//--预赔赔款
  		//buffer.append(" union all ");
      	if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
  		buffer.append(" select r.registno, ");
  		buffer.append(" pre.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
  		buffer.append(" pre.precompensateno as certino, ");
  		buffer.append(" c.claimNo, ");
  		buffer.append(" r.insuredname, ");
  		buffer.append(" r.licenseno, ");
  		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
  		//buffer.append(" pre.underwriteenddate, ");
  		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
  		buffer.append(" '预赔赔款' as payType, ");
  		buffer.append(" r.comcode, ");
  		buffer.append(" '' as comcname, ");
  		buffer.append(" (select sum(payamount) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and paymenttype = 'P50' "); 
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		
  		
  		
  	    buffer.append(" ) as havPay , ");//--已支付
  	    buffer.append(" 'Y' as certitype,  ");
          buffer.append(" 'P50' as payrefreason  ");
  		buffer.append(" from prplprepay pre, prplclaim c, prplregist r ");
  		
  		buffer.append(" where pre.claimno = c.claimno ");
  		buffer.append(" and c.registno = r.registno ");
  		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
  			buffer.append(" and 1<>1 ");
  		}
  		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		if(payType!=null&&!"".equals(payType)){
  			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
  		}else{
  			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		}
  		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
  		buffer.append(" and r.classcode<>'05' ");
  		if("mechanism".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
          }else if("agnet".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
          }
  		//添加已支付完成的查询不出来条件
  		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and paymenttype = 'P50' "); 
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
  		buffer.append(conditions);
  		
  		//--预赔费用
  		buffer.append(" union all ");
  		buffer.append(" select r.registno, ");
  		buffer.append(" pre.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
  		buffer.append(" pch.precompensateno as certino, ");
  		buffer.append(" c.claimNo, ");
  		buffer.append(" r.insuredname, ");
  		buffer.append(" r.licenseno, ");
  		buffer.append(" pch.sumprepaid as sumthispaid, ");
  		//buffer.append(" pre.underwriteenddate, ");
  		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
  		buffer.append(" '预赔费用' as payType, ");
  		
  		buffer.append(" r.comcode, ");
  		buffer.append(" '' as comcname, ");
  		buffer.append(" (select sum(payamount) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		
  	    buffer.append(" ) as havPay , ");//--已支付
  	    buffer.append(" 'Y' as certitype,  ");
  	    /*buffer.append(" case pch.chargecode  ");
  		buffer.append(" when '05' then  ");
  		buffer.append("  'Y64'  ");
  		buffer.append(" when '07' then  ");
  		buffer.append("  'Y61'  ");
  		buffer.append(" when '15' then  ");
  		buffer.append("  'Y68'  ");
  		buffer.append(" when '29' then  ");
  		buffer.append("  'Y611'  ");
  		buffer.append(" when '30' then  ");
  		buffer.append("  'Y612'  ");
  		buffer.append(" when '14' then  ");
  		buffer.append("  'Y65'  ");
  		buffer.append(" when '13' then  ");
  		buffer.append("  'Y67'  ");
  		buffer.append(" when '04' then  ");
  		buffer.append("  'Y62'  ");
  		buffer.append(" else  ");
  		buffer.append("  'Y69'  ");
  		buffer.append("  end as payrefreason  ");*/
  	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason  ");
  		buffer.append(" from (select claimno,precompensateno,chargecode, ");
		buffer.append(" sum(sumprepaid) as sumprepaid ");
		buffer.append(" from prplprecharge ");
		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
		buffer.append("  prplprepay pre, prplclaim c, prplregist r ");
  		//buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ");
  		
  		buffer.append(" where pch.claimno = c.claimno ");
  		buffer.append(" and pch.precompensateno = pre.precompensateno ");
  		buffer.append(" and c.registno = r.registno ");
  		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
  			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
  		}
  		if(payType!=null&&!"".equals(payType)){
  			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
  		}else{
  			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		}
  		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
  		buffer.append(" and r.classcode<>'05' ");
  		if("mechanism".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
          }else if("agnet".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
          }
  		//添加已支付完成的查询不出来条件
  		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
  		buffer.append(conditions);
      	}
  		if(back!=null && "1".equals(back)){
   			buffer.append(" union all ");
   			buffer.append("SELECT distinct prplpay.registno,                                                          "); 
   			buffer.append("                prplregist.policyno,                                                       ");
   			buffer.append("                prplpay.compensateno,                                                      ");
   			buffer.append("                prplpay.claimno,                                                           ");
   			buffer.append("                PrpLpaymain.Receiverfullname,                                              ");
   			buffer.append("                '',                                                                        ");
   			buffer.append("                case                                                                       ");
   			buffer.append("                  when prplpay.paymenttype = 'P50' then                                    ");
   			buffer.append("                   (select pp.sumprepaid                                                   ");
   			buffer.append("                      from prplprepay pp                                                   ");
   			buffer.append("                     where pp.precompensateno = prplpay.compensateno)                      ");
   			buffer.append("                  when prplpay.paymenttype = 'Y61' then                                    ");
   			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
   			buffer.append("                      from prplprecharge pp                                                ");
   			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
   			buffer.append("                       and pp.chargecode = '07')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'Y64' then                                    ");
   			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
   			buffer.append("                      from prplprecharge pp                                                ");
   			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
   			buffer.append("                       and pp.chargecode = '05')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'Y68' then                                    ");
   			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
   			buffer.append("                      from prplprecharge pp                                                ");
   			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
   			buffer.append("                       and pp.chargecode = '15')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'Y611' then                                   ");
   			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
   			buffer.append("                      from prplprecharge pp                                                ");
   			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
   			buffer.append("                       and pp.chargecode = '29')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'Y612' then                                   ");
   			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
   			buffer.append("                      from prplprecharge pp                                                ");
   			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
   			buffer.append("                       and pp.chargecode = '30')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'Y65' then                                    ");
   			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
   			buffer.append("                      from prplprecharge pp                                                ");
   			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
   			buffer.append("                       and pp.chargecode = '14')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'Y67' then                                    ");
   			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
   			buffer.append("                      from prplprecharge pp                                                ");
   			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
   			buffer.append("                       and pp.chargecode = '13')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'Y62' then                                    ");
   			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
   			buffer.append("                      from prplprecharge pp                                                ");
   			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
   			buffer.append("                       and pp.chargecode = '04')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'P60' then                                    ");
   			buffer.append("                   (select sum(pp.sumthispaid)                                             ");
   			buffer.append("                      from prplcompensate pp                                               ");
   			buffer.append("                     where pp.compensateno = prplpay.compensateno)                         ");
   			buffer.append("                  when prplpay.paymenttype = 'P64' then                                    ");
   			buffer.append("                   (select sum(ge.chargeamount)                                            ");
   			buffer.append("                      from prplcharge ge                                                   ");
   			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
   			buffer.append("                       and ge.chargecode = '05')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'P61' then                                    ");
   			buffer.append("                   (select sum(ge.chargeamount)                                            ");
   			buffer.append("                      from prplcharge ge                                                   ");
   			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
   			buffer.append("                       and ge.chargecode = '07')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'P68' then                                    ");
   			buffer.append("                   (select sum(ge.chargeamount)                                            ");
   			buffer.append("                      from prplcharge ge                                                   ");
   			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
   			buffer.append("                       and ge.chargecode = '15')                                           ");
   			
   			buffer.append("                  when prplpay.paymenttype = 'P69' then                                    ");
   			buffer.append("                   (select sum(ge.chargeamount)                                            ");
   			buffer.append("                      from prplcharge ge                                                   ");
   			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
   			buffer.append("                       and ge.chargecode = '99')                                           ");
   			
   			buffer.append("                  when prplpay.paymenttype = 'P611' then                                   ");
   			buffer.append("                   (select sum(ge.chargeamount)                                            ");
   			buffer.append("                      from prplcharge ge                                                   ");
   			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
   			buffer.append("                       and ge.chargecode = '29')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'P612' then                                   ");
   			buffer.append("                   (select sum(ge.chargeamount)                                            ");
   			buffer.append("                      from prplcharge ge                                                   ");
   			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
   			buffer.append("                       and ge.chargecode = '30')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'P65' then                                    ");
   			buffer.append("                   (select sum(ge.chargeamount)                                            ");
   			buffer.append("                      from prplcharge ge                                                   ");
   			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
   			buffer.append("                       and ge.chargecode = '14')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'P67' then                                    ");
   			buffer.append("                   (select sum(ge.chargeamount)                                            ");
   			buffer.append("                      from prplcharge ge                                                   ");
   			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
   			buffer.append("                       and ge.chargecode = '13')                                           ");
   			buffer.append("                  when prplpay.paymenttype = 'P62' then                                    ");
   			buffer.append("                   (select sum(ge.chargeamount)                                            ");
   			buffer.append("                      from prplcharge ge                                                   ");
   			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
   			buffer.append("                       and ge.chargecode = '04')                                           ");
   			buffer.append("                end as sumthispaid,                                                        ");
   			buffer.append("                round(trunc(sysdate) - trunc(PrpLpaymain.Inputdate)) as underwriteenddate, ");
   			buffer.append("                case                                                                       ");
   			buffer.append("                  when prplpay.paymenttype = 'P50' then                                    ");
   			buffer.append("                   '预赔赔款'                                                              ");
   			buffer.append("                  when prplpay.paymenttype = 'Y61' then                                    ");
   			buffer.append("                   '预付检验鉴定费'                                                        ");
   			buffer.append("                  when prplpay.paymenttype = 'Y64' then                                    ");
   			buffer.append("                   '预付诉讼费'                                                            ");
   			buffer.append("                  when prplpay.paymenttype = 'Y68' then                                    ");
   			buffer.append("                   '预付律师费'                                                            ");
   			buffer.append("                  when prplpay.paymenttype = 'Y611' then                                   ");
   			buffer.append("                   '预付仲裁费'                                                            ");
   			buffer.append("                  when prplpay.paymenttype = 'Y612' then                                   ");
   			buffer.append("                   '预付执行费'                                                            ");
   			buffer.append("                  when prplpay.paymenttype = 'Y65' then                                    ");
   			buffer.append("                   '预付内部代查勘费'                                                      ");
   			buffer.append("                  when prplpay.paymenttype = 'Y67' then                                    ");
   			buffer.append("                   '预付外部代查勘费'                                                      ");
   			buffer.append("                  when prplpay.paymenttype = 'Y62' then                                    ");
   			buffer.append("                   '预付机构查勘费'                                                        ");
   			buffer.append("                  when prplpay.paymenttype = 'P60' then                                    ");
   			buffer.append("                   '赔款'                                                                  ");
   			buffer.append("                  when prplpay.paymenttype = 'P64' then                                    ");
   			buffer.append("                   '诉讼费'                                                                ");
   			buffer.append("                  when prplpay.paymenttype = 'P61' then                                    ");
   			buffer.append("                   '检验费'                                                                ");
   			buffer.append("                  when prplpay.paymenttype = 'P68' then                                    ");
   			buffer.append("                   '律师费'                                                                ");
   			buffer.append("                  when prplpay.paymenttype = 'P611' then                                   ");
   			buffer.append("                   '仲裁费	'                                                               ");
   			buffer.append("                  when prplpay.paymenttype = 'P612' then                                   ");
   			buffer.append("                   '执行费'                                                                ");
   			buffer.append("                  when prplpay.paymenttype = 'P65' then                                    ");
   			buffer.append("                   '内部代查勘费'                                                          ");
   			buffer.append("                  when prplpay.paymenttype = 'P67' then                                    ");
   			buffer.append("                   '外部代查勘费'                                                          ");
   			
   			buffer.append("                  when prplpay.paymenttype = 'P69' then                                    ");
   			buffer.append("                   '付其他'                                                          ");
   			
   			buffer.append("                  when prplpay.paymenttype = 'P62' then                                    ");
   			buffer.append("                   '机构查勘费'                                                            ");
   			buffer.append("                end as payType,                                                            ");
   			buffer.append("                PrpLpaymain.Comcode,                                                       ");
   			buffer.append("                '' as comcname,                    ");
   			buffer.append("                (select sum(payamount)                                                     ");
   			buffer.append("                   from prplpay pay                                                        ");
   			buffer.append("                  where pay.registno = prplpay.registno                                    ");
   			buffer.append("                    and pay.compensateno = prplpay.compensateno                            ");
   			buffer.append("                    and pay.paymenttype = prplpay.paymenttype                              ");
   			buffer.append("                    and pay.serialno <> prplpay.serialno) as havPay,                       ");
   			buffer.append(" case when prplpay.compensateno like '8%' then											");
   			buffer.append(" 'Y' ");
   			buffer.append(" else ");
   			buffer.append(" 'C' ");
   			buffer.append(" end as certitype, ");
   			buffer.append(" prplpay.paymenttype as payrefreason   ");
   			buffer.append("  FROM PrpLpaymain, prplpay, prplregist                                                    ");
   			buffer.append(" WHERE 1 = 1                                                                               ");
   			buffer.append(" and prplpaymain.operatorcode = '"+userCode+"'");	
   			buffer.append("   and prplpaymain.vflag in ('3', '7', '9')                                                ");
   			buffer.append("   and prplpay.classcode <> '05'                                                           ");
   			buffer.append("   and prplpaymain.paymentno = prplpay.serialno                                            ");
   			buffer.append("   and prplpay.registno = prplregist.registno                                             ");
   		}
  		
  		buffer.append(" ) c ,prplclaim tt ");
  		buffer.append("  where c.registno = tt.registno");
   		buffer.append(" and exists (select 1  ");
//   		buffer.append("          from prpjpayrefrec rec ");
        buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
        buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
        buffer.append( "  Union All                                                                            ");
        buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
        buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
   		buffer.append("         where rec.certino = c.certino  ");
   		buffer.append("           and rec.certitype = c.certitype ");
   		buffer.append("           and rec.payrefreason = c.payrefreason ");
   		buffer.append("           and rec.payrefstate in ('00', '01') ");
   		buffer.append("           and rec.payrefdate is null) ");
//  		buffer.append("  where exists (select 1  ");
//  		buffer.append("  from prpjplanfee rf  ");
//  		buffer.append("  where c.certino = rf.certino  ");
//  		buffer.append("   and rf.certitype in ('C', 'Y')  ");
//  		//buffer.append("   and rf.payrefdate is null  ");
//  		buffer.append("   and rf.planfee > rf.realpayreffee  ");
//  		buffer.append("  and rf.planfee > 0)  ");
  		buffer.append("  )  ");
      	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
          resultSet.next();
          count = dbManager.getInt(resultSet,1);
          resultSet.close();
          return count;
      }
      
      /**
  	 * 支付信息查询列表显示方法
  	 * @param payType	支付类型
  	 * @param paymentType	赔款类型
  	 * @param comCode	机构号码
  	 * @param registNos	报案号集合
  	 * @param certiNos	业务号集合
  	 * @return
  	 * @throws Exception
  	 */
      public ArrayList<PrpLpayShowDto> getFiscalQueryShowRegistList(String payType,String paymentType,String back,String userCode,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
      	//String comCodeStr = comCode.substring(0, 6);
      	//String conditions="";
      	//String paymentNo="";
    	  System.err.println(101010);
      	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
      	StringBuffer buffer = new StringBuffer(200);
      	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
      	buffer.append(" select distinct tt.registno,tt.policyno,tt.damageenddate,tt.startdate,tt.enddate,tt.insuredname,c.comcode,(select cop.comcname from prpdcompany cop where cop.comcode = c.comcode) as comcname ");
      	buffer.append(" from (  ");
      	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
      	//--赔款
      	buffer.append(" select r.registno, ");
      	buffer.append(" t.policyno, ");
  		buffer.append(" '' as policyType, ");
      	buffer.append(" t.compensateno as certino, ");
      	buffer.append(" c.claimNo, ");
      	buffer.append(" r.insuredname, ");
      	buffer.append(" r.licenseno, ");
  		buffer.append("  t.sumthispaid, ");
          //buffer.append("   t.underwriteenddate, ");
          buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
          buffer.append("  '赔款' as payType, ");
          buffer.append(" r.comcode, ");
          buffer.append(" '' as comcname, ");
      	buffer.append(" (select sum(payamount) ");
          buffer.append(" from prplpay prplpay ");
          buffer.append(" where prplpay.registno = r.registno ");
          buffer.append(" and prplpay.compensateno = t.compensateno ");
          buffer.append(" and prplpay.policyno = t.policyno ");
          buffer.append(" and prplpay.paymenttype = 'P60' ");
          buffer.append(" and prplpay.paytype = 'P3' ");
          
          /**
          if(paymentNo!=null&&!"".equals(paymentNo)){
          	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
          }
          */
          
          buffer.append(" ) as havPay,  ");//--已支付
          buffer.append(" 'C' as certitype,  ");
          buffer.append(" 'P60' as payrefreason,  ");
          buffer.append(" '0' as flowid ");
          buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
          /**
          buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
          buffer.append(" pay.exist    ");//--是否勾选
          
          buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
          buffer.append(" from prplpay ");
          buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
          buffer.append(" and pay.compensateno(+) = t.compensateno ");
          */
          buffer.append(" where t.claimno = c.claimno ");
          buffer.append(" and c.registno = r.registno "); 
          if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
          	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
          }
          if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
          	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
          }
          buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
          if("mechanism".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
          }else if("agnet".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
          }
          buffer.append(" and r.classcode<>'05' ");
          //添加已支付完成的查询不出来条件
  		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where prplpay.registno = r.registno ");
          buffer.append(" and prplpay.compensateno = t.compensateno ");
          buffer.append(" and prplpay.policyno = t.policyno ");
          buffer.append(" and prplpay.paymenttype = 'P60' ");
          buffer.append(" and prplpay.paytype = 'P3' ");
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )<> 0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
          buffer.append(conditions);
          /**
          if(registNos!=null&&registNos.size()>0){
      		buffer.append(" and r.registNo in ( ");
      		for(int i=0;i<registNos.size();i++){
      			if(i!=0)buffer.append(" , ");
      			buffer.append(" '"+registNos.get(i).trim()+"' ");
      		}
      		buffer.append(" ) ");
      	}
          
          //buffer.append(" and t.compensateno in ('理算书号') ");
          if(certiNos!=null&&certiNos.size()>0){
      		buffer.append(" and t.compensateno in ( ");
      		for(int i=0;i<certiNos.size();i++){
      			if(i!=0)buffer.append(" , ");
      			buffer.append(" '"+certiNos.get(i).trim()+"' ");
      		}
      		buffer.append(" ) ");
      	}
          buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//--？（默认添加）
          */
          
          //代付共保赔款
          buffer.append(" union all ");
        	buffer.append(" select r.registno, ");
        	buffer.append(" t.policyno, ");
    		buffer.append(" '' as policyType, ");
        	buffer.append(" co.businessno as certino,, ");
        	buffer.append(" c.claimNo, ");
        	buffer.append(" r.insuredname, ");
        	buffer.append(" r.licenseno, ");
    		buffer.append("  co.coinssumpaid as sumthispaid, ");
            //buffer.append("   t.underwriteenddate, ");
            buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
            buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
            buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
            buffer.append(" r.comcode, ");
            buffer.append(" '' as comcname, ");
        	buffer.append(" (select sum(payamount) ");
            buffer.append(" from prplpay prplpay ");
            buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
            buffer.append(" and prplpay.paytype = 'P3' ");
            
            /**
            if(paymentNo!=null&&!"".equals(paymentNo)){
            	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
            }
            */
            
            buffer.append(" ) as havPay,  ");//--已支付
            buffer.append(" 'C' as certitype,  ");
            buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
            buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason , ");
            buffer.append(" '0' as flowid ");
            buffer.append(" from prplcompensate t, prplclaim c, prplregist r ,prplcfeecoins co");
            /**
            buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
            buffer.append(" pay.exist    ");//--是否勾选
            
            buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
            buffer.append(" from prplpay ");
            buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
            buffer.append(" and pay.compensateno(+) = t.compensateno ");
            */
            buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
            buffer.append(" and c.registno = r.registno "); 
            if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
            	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
            }
            if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
            	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
            }
            buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
            if("mechanism".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
            buffer.append(" and r.classcode<>'05' ");
            //添加已支付完成的查询不出来条件
    		buffer.append(" and (select co.coinssumpaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
            buffer.append(" and prplpay.paytype = 'P3' ");
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )<> 0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
            buffer.append(conditions);
          
          
  		//--赔付费用
          buffer.append(" union all ");
          buffer.append(" select r.registno, ");
          buffer.append(" t.policyno, ");
  		buffer.append(" '' as policyType, ");
          buffer.append("  t.compensateno as certino, ");
          buffer.append(" c.claimNo, ");
          buffer.append(" r.insuredname, ");
          buffer.append(" r.licenseno, ");
          buffer.append(" ch.chargeamount as sumthispaid, ");
          //buffer.append(" t.underwriteenddate, ");
          buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
         // buffer.append(" '赔付费用' as payType, ");
          /*buffer.append(" case ch.chargecode ");
  	    buffer.append(" when '05' then '诉讼费' "); 
  	    buffer.append(" when '07' then '检验鉴定费' ");  
  	    buffer.append("  when '15' then '律师费'  ");
  	    buffer.append(" when '29' then '仲裁费'  ");
  	    buffer.append(" when '30' then '执行费'   ");
  	    buffer.append(" when '14' then '内部代查勘费'  ");
  	    buffer.append(" when '13' then '外部代查勘费'  "); 
  	    buffer.append(" when '04' then '机构查勘费'  ");
  	    buffer.append("  else '' end as paytype, ");*/
          buffer.append("  changechargecodetochargename(ch.chargecode) as paytype, ");
          buffer.append(" r.comcode, ");
          buffer.append(" '' as comcname, ");
          buffer.append(" (select sum(payamount) ");
          buffer.append(" from prplpay prplpay ");
         	buffer.append(" where prplpay.registno = r.registno ");
         	buffer.append(" and prplpay.compensateno = t.compensateno ");
         	buffer.append(" and prplpay.policyno = t.policyno ");
         	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
         	buffer.append("  and prplpay.paytype = 'P3' ");
         	
         	/**
          if(paymentNo!=null&&!"".equals(paymentNo)){
          	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
          }
          */
         	
          buffer.append(" ) as havPay , ");//--已支付
          buffer.append(" 'C' as certitype,  ");
          /*buffer.append(" case ch.chargecode  ");
  		buffer.append(" when '05' then  ");
  		buffer.append("  'P64'  ");
  		buffer.append(" when '07' then  ");
  		buffer.append("  'P61'  ");
  		buffer.append(" when '15' then  ");
  		buffer.append("  'P68'  ");
  		buffer.append(" when '29' then  ");
  		buffer.append("  'P611'  ");
  		buffer.append(" when '30' then  ");
  		buffer.append("  'P612'  ");
  		buffer.append(" when '14' then  ");
  		buffer.append("  'P65'  ");
  		buffer.append(" when '13' then  ");
  		buffer.append("  'P67'  ");
  		buffer.append(" when '04' then  ");
  		buffer.append("  'P62'  ");
  		buffer.append(" else  ");
  		buffer.append("  ''  ");
  		buffer.append("  end as payrefreason,  ");*/
        buffer.append("  changechargecodetopaymenttype(ch.chargecode) as payrefreason,  ");
  		buffer.append(" '0' as flowid ");
  		buffer.append(" from (select compensateno, chargecode, sum(nvl(chargeamount,0)-nvl(prechargeamount,0)-nvl(sumrealpay,0)) as chargeamount ");
      	buffer.append("  from prplcharge  where  chargecode<>'14' ");
      	buffer.append(" group by compensateno, chargecode) ch, ");
      	buffer.append("  prplcompensate t, prplclaim c, prplregist r  ");
       //	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r ,swflog g,swflogstore re ");
         	/**
         	buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
         	buffer.append(" pay.exist    ");//--是否勾选
         	buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
          buffer.append(" from prplpay ");
          buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
         	buffer.append(" and pay.compensateno(+) = t.compensateno ");
          */
         	
         	buffer.append(" where ch.compensateno = t.compensateno ");
         	buffer.append(" and t.claimno = c.claimno ");
         	buffer.append(" and c.registno = r.registno ");
         	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
         		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
         	}
         	if(payType != null&&!"".equals(payType)&&!"P3".equals(payType)){
         		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
         	}
         	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
         	if("mechanism".equals(casesType)){
         	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
         	 
           }else if("agnet".equals(casesType)){
         	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
           }
         	buffer.append(" and r.classcode<>'05' ");
         	//添加已支付完成的查询不出来条件
  		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where prplpay.registno = r.registno ");
         	buffer.append(" and prplpay.compensateno = t.compensateno ");
         	buffer.append(" and prplpay.policyno = t.policyno ");
         	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
         	buffer.append(" and prplpay.paytype = 'P3' ");
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )<>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
         	buffer.append(conditions);
         	
         	/**
         	if(registNos!=null&&registNos.size()>0){
      		buffer.append(" and r.registNo in ( ");
      		for(int i=0;i<registNos.size();i++){
      			if(i!=0)buffer.append(" , ");
      			buffer.append(" '"+registNos.get(i).trim()+"' ");
      		}
      		buffer.append(" ) ");
      	}
        	if(certiNos!=null&&certiNos.size()>0){
      		buffer.append(" and t.compensateno in ( ");//需更改
      		for(int i=0;i<certiNos.size();i++){
      			if(i!=0)buffer.append(" , ");
      			buffer.append(" '"+certiNos.get(i).trim()+"' ");
      		}
      		buffer.append(" ) ");
      	}
        	buffer.append(" and r.comcode like '"+comCodeStr+"%' ");// --？（默认添加）
        	*/
      	}
      	
        	//--预赔赔款
  		//buffer.append(" union all ");
      	if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
  		buffer.append(" select r.registno, ");
  		buffer.append(" pre.policyno, ");
  		buffer.append(" '' as policyType, ");
  		buffer.append(" pre.precompensateno as certino, ");
  		buffer.append(" c.claimNo, ");
  		buffer.append(" r.insuredname, ");
  		buffer.append(" r.licenseno, ");
  		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
  		//buffer.append(" pre.underwriteenddate, ");
  		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
  		buffer.append(" '预赔赔款' as payType, ");
  		buffer.append(" r.comcode, ");
  		buffer.append(" '' as comcname, ");
  		buffer.append(" (select sum(payamount) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and paymenttype = 'P50' "); 
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		
  		/**
  		if(paymentNo!=null&&!"".equals(paymentNo)){
  	    	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
  	    }
  	    */
  		
  	    buffer.append(" ) as havPay , ");//--已支付
  	    buffer.append(" 'Y' as certitype, ");
  	    buffer.append(" 'P50' as payrefreason, ");
  	    buffer.append(" '0' as flowid ");
  		buffer.append(" from prplprepay pre, prplclaim c, prplregist r ");
  		/**
  		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
  		buffer.append(" pay.exist    ");//--是否勾选
  		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
          buffer.append(" from prplpay ");
          buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
  		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
          */
  		buffer.append(" where pre.claimno = c.claimno ");
  		buffer.append(" and c.registno = r.registno ");
  		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
  			buffer.append(" and 1<>1 ");
  		}
  		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		if(payType==null||"".equals(payType)){
  			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
  		}else{
  			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		}
  		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
  		if("mechanism".equals(casesType)){
     	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
     	 
       }else if("agnet".equals(casesType)){
     	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
       }
  		buffer.append(" and r.classcode<>'05' ");
  		//添加已支付完成的查询不出来条件
  		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and paymenttype = 'P50' "); 
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )<>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
  		buffer.append(conditions);
  		
  		/**
  		if(registNos!=null&&registNos.size()>0){
      		buffer.append(" and r.registNo in ( ");
      		for(int i=0;i<registNos.size();i++){
      			if(i!=0)buffer.append(" , ");
      			buffer.append(" '"+registNos.get(i).trim()+"' ");
      		}
      		buffer.append(" ) ");
      	}
  		//buffer.append(" and pre.precompensateno in ('805073408002011000005') ");
  		if(certiNos!=null&&certiNos.size()>0){
      		buffer.append(" and pre.precompensateno in ( ");//需更改
      		for(int i=0;i<certiNos.size();i++){
      			if(i!=0)buffer.append(" , ");
      			buffer.append(" '"+certiNos.get(i).trim()+"' ");
      		}
      		buffer.append(" ) ");
      	}
  		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
  		*/
  		
  		
  		//--预赔费用
  		buffer.append(" union all ");
  		buffer.append(" select r.registno, ");
  		buffer.append(" pre.policyno, ");
  		buffer.append(" '' as policyType, ");
  		buffer.append(" pch.precompensateno as certino, ");
  		buffer.append(" c.claimNo, ");
  		buffer.append(" r.insuredname, ");
  		buffer.append(" r.licenseno, ");
  		buffer.append(" pch.sumprepaid as sumthispaid, ");
  		//buffer.append(" pre.underwriteenddate, ");
  		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
  		//buffer.append(" '预赔费用' as payType, ");
  		/*buffer.append(" case pch.chargecode  ");
  		buffer.append(" when '05' then '预付诉讼费'  ");
  	    buffer.append(" when '07' then '预付检验鉴定费'   ");
  	    buffer.append(" when '15' then '预付律师费'  ");
  	    buffer.append(" when '29' then '预付仲裁费'  ");
  	    buffer.append(" when '30' then '预付执行费'  "); 
  	    buffer.append(" when '14' then '预付内部代查勘费' "); 
  	    buffer.append(" when '13' then '预付外部代查勘费'  "); 
  	    buffer.append(" when '04' then '预付机构查勘费'  ");
  	    buffer.append(" else '' end as payType,");*/
  		buffer.append(" pchangechargecodetochargename(pch.chargecode) as payType,");
  		buffer.append(" r.comcode, ");
  		buffer.append(" '' as comcname, ");
  		buffer.append(" (select sum(payamount) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  	    buffer.append(" ) as havPay,  ");//--已支付
  	    buffer.append(" 'Y' as certitype, ");
  	    /*buffer.append(" case pch.chargecode  ");
  		buffer.append(" when '05' then  ");
  		buffer.append("  'Y64'  ");
  		buffer.append(" when '07' then  ");
  		buffer.append("  'Y61'  ");
  		buffer.append(" when '15' then  ");
  		buffer.append("  'Y68'  ");
  		buffer.append(" when '29' then  ");
  		buffer.append("  'Y611'  ");
  		buffer.append(" when '30' then  ");
  		buffer.append("  'Y612'  ");
  		buffer.append(" when '14' then  ");
  		buffer.append("  'Y65'  ");
  		buffer.append(" when '13' then  ");
  		buffer.append("  'Y67'  ");
  		buffer.append(" when '04' then  ");
  		buffer.append("  'Y62'  ");
  		buffer.append(" else  ");
  		buffer.append("  'Y69'  ");
  		buffer.append("  end as payrefreason,  ");*/
  	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason,  ");
  		buffer.append(" '0' as flowid ");
  		buffer.append(" from (select claimno,precompensateno,chargecode, ");
		buffer.append(" sum(sumprepaid) as sumprepaid ");
		buffer.append(" from prplprecharge ");
		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
		buffer.append("  prplprepay pre, prplclaim c, prplregist r  ");
  		//buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ,swflog g,swflogstore re ");
  		/**
  		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
  		buffer.append(" pay.exist    ");//--是否勾选
  		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
          buffer.append(" from prplpay ");
          buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
  		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
          */
  		buffer.append(" where pch.claimno = c.claimno ");
  		buffer.append(" and pch.precompensateno = pre.precompensateno ");
  		buffer.append(" and c.registno = r.registno ");
  		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
  			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
  		}
  		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		if(payType==null||"".equals(payType)){
  			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
  		}else{
  			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		}
  		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
  		if("mechanism".equals(casesType)){
     	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
     	 
       }else if("agnet".equals(casesType)){
     	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
       }
  		buffer.append(" and r.classcode<>'05' ");
  		//添加已支付完成的查询不出来条件
  		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )<>0  ");//--已支付 
  	    //添加已支付完成的查询不出来条件
  		buffer.append(conditions);
  		/**
  		 * 
  		if(registNos!=null&&registNos.size()>0){
      		buffer.append(" and r.registNo in ( ");
      		for(int i=0;i<registNos.size();i++){
      			if(i!=0)buffer.append(" , ");
      			buffer.append(" '"+registNos.get(i).trim()+"' ");
      		}
      		buffer.append(" ) ");
      	}
  		//buffer.append(" and pre.precompensateno in ('预赔号码') ");
  		if(certiNos!=null&&certiNos.size()>0){
      		buffer.append(" and pre.precompensateno in ( ");//需更改
      		for(int i=0;i<certiNos.size();i++){
      			if(i!=0)buffer.append(" , ");
      			buffer.append(" '"+certiNos.get(i).trim()+"' ");
      		}
      		buffer.append(" ) ");
      	}
  		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
  		
  		*/
      	}
  		if(back!=null && "1".equals(back)){
  			buffer.append(" union all ");
  			buffer.append("SELECT distinct prplpay.registno,                                                          "); 
  			buffer.append("				   prplregist.policyno,                                                       "); 
  			buffer.append("                '商业险' as policytype,                                                                  ");
  			buffer.append("                prplpay.compensateno as certino,                                                      ");
  			buffer.append("                prplpay.claimno,                                                           ");
  			buffer.append("                PrpLpaymain.Receiverfullname as InsuredName,                                              ");
  			buffer.append("                'TH' as LicenseNo,                                                                        ");
  			buffer.append("                case                                                                       ");
  			buffer.append("                  when prplpay.paymenttype = 'P50' then                                    ");
  			buffer.append("                   (select pp.sumprepaid                                                   ");
  			buffer.append("                      from prplprepay pp                                                   ");
  			buffer.append("                     where pp.precompensateno = prplpay.compensateno)                      ");
  			buffer.append("                  when prplpay.paymenttype = 'Y61' then                                    ");
  			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
  			buffer.append("                      from prplprecharge pp                                                ");
  			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
  			buffer.append("                       and pp.chargecode = '07')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'Y64' then                                    ");
  			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
  			buffer.append("                      from prplprecharge pp                                                ");
  			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
  			buffer.append("                       and pp.chargecode = '05')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'Y68' then                                    ");
  			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
  			buffer.append("                      from prplprecharge pp                                                ");
  			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
  			buffer.append("                       and pp.chargecode = '15')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'Y611' then                                   ");
  			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
  			buffer.append("                      from prplprecharge pp                                                ");
  			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
  			buffer.append("                       and pp.chargecode = '29')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'Y612' then                                   ");
  			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
  			buffer.append("                      from prplprecharge pp                                                ");
  			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
  			buffer.append("                       and pp.chargecode = '30')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'Y65' then                                    ");
  			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
  			buffer.append("                      from prplprecharge pp                                                ");
  			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
  			buffer.append("                       and pp.chargecode = '14')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'Y67' then                                    ");
  			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
  			buffer.append("                      from prplprecharge pp                                                ");
  			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
  			buffer.append("                       and pp.chargecode = '13')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'Y62' then                                    ");
  			buffer.append("                   (select sum(pp.sumprepaid)                                              ");
  			buffer.append("                      from prplprecharge pp                                                ");
  			buffer.append("                     where pp.precompensateno = prplpay.compensateno                       ");
  			buffer.append("                       and pp.chargecode = '04')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'P60' then                                    ");
  			buffer.append("                   (select sum(pp.sumthispaid)                                             ");
  			buffer.append("                      from prplcompensate pp                                               ");
  			buffer.append("                     where pp.compensateno = prplpay.compensateno)                         ");
  			buffer.append("                  when prplpay.paymenttype = 'P64' then                                    ");
  			buffer.append("                   (select sum(ge.chargeamount)                                            ");
  			buffer.append("                      from prplcharge ge                                                   ");
  			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
  			buffer.append("                       and ge.chargecode = '05')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'P61' then                                    ");
  			buffer.append("                   (select sum(ge.chargeamount)                                            ");
  			buffer.append("                      from prplcharge ge                                                   ");
  			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
  			buffer.append("                       and ge.chargecode = '07')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'P68' then                                    ");
  			buffer.append("                   (select sum(ge.chargeamount)                                            ");
  			buffer.append("                      from prplcharge ge                                                   ");
  			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
  			buffer.append("                       and ge.chargecode = '15')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'P611' then                                   ");
  			buffer.append("                   (select sum(ge.chargeamount)                                            ");
  			buffer.append("                      from prplcharge ge                                                   ");
  			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
  			buffer.append("                       and ge.chargecode = '29')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'P612' then                                   ");
  			buffer.append("                   (select sum(ge.chargeamount)                                            ");
  			buffer.append("                      from prplcharge ge                                                   ");
  			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
  			buffer.append("                       and ge.chargecode = '30')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'P65' then                                    ");
  			buffer.append("                   (select sum(ge.chargeamount)                                            ");
  			buffer.append("                      from prplcharge ge                                                   ");
  			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
  			buffer.append("                       and ge.chargecode = '14')                                           ");
  			
  			buffer.append("                  when prplpay.paymenttype = 'P69' then                                    ");
  			buffer.append("                   (select sum(ge.chargeamount)                                            ");
  			buffer.append("                      from prplcharge ge                                                   ");
  			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
  			buffer.append("                       and ge.chargecode = '99')                                           ");
  			
  			buffer.append("                  when prplpay.paymenttype = 'P67' then                                    ");
  			buffer.append("                   (select sum(ge.chargeamount)                                            ");
  			buffer.append("                      from prplcharge ge                                                   ");
  			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
  			buffer.append("                       and ge.chargecode = '13')                                           ");
  			buffer.append("                  when prplpay.paymenttype = 'P62' then                                    ");
  			buffer.append("                   (select sum(ge.chargeamount)                                            ");
  			buffer.append("                      from prplcharge ge                                                   ");
  			buffer.append("                     where ge.compensateno = prplpay.compensateno                          ");
  			buffer.append("                       and ge.chargecode = '04')                                           ");
  			buffer.append("                end as sumthispaid,                                                        ");
  			buffer.append("                round(trunc(sysdate) - trunc(PrpLpaymain.Inputdate)) as underwriteenddate, ");
  			buffer.append("                case                                                                       ");
  			buffer.append("                  when prplpay.paymenttype = 'P50' then                                    ");
  			buffer.append("                   '预赔赔款'                                                              ");
  			buffer.append("                  when prplpay.paymenttype = 'Y61' then                                    ");
  			buffer.append("                   '预付检验鉴定费'                                                        ");
  			buffer.append("                  when prplpay.paymenttype = 'Y64' then                                    ");
  			buffer.append("                   '预付诉讼费'                                                            ");
  			buffer.append("                  when prplpay.paymenttype = 'Y68' then                                    ");
  			buffer.append("                   '预付律师费'                                                            ");
  			buffer.append("                  when prplpay.paymenttype = 'Y611' then                                   ");
  			buffer.append("                   '预付仲裁费'                                                            ");
  			buffer.append("                  when prplpay.paymenttype = 'Y612' then                                   ");
  			buffer.append("                   '预付执行费'                                                            ");
  			buffer.append("                  when prplpay.paymenttype = 'Y65' then                                    ");
  			buffer.append("                   '预付内部代查勘费'                                                      ");
  			buffer.append("                  when prplpay.paymenttype = 'Y67' then                                    ");
  			buffer.append("                   '预付外部代查勘费'                                                      ");
  			buffer.append("                  when prplpay.paymenttype = 'Y62' then                                    ");
  			buffer.append("                   '预付机构查勘费'                                                        ");
  			buffer.append("                  when prplpay.paymenttype = 'P60' then                                    ");
  			buffer.append("                   '赔款'                                                                  ");
  			buffer.append("                  when prplpay.paymenttype = 'P64' then                                    ");
  			buffer.append("                   '诉讼费'                                                                ");
  			buffer.append("                  when prplpay.paymenttype = 'P61' then                                    ");
  			buffer.append("                   '检验费'                                                                ");
  			buffer.append("                  when prplpay.paymenttype = 'P68' then                                    ");
  			buffer.append("                   '律师费'                                                                ");
  			buffer.append("                  when prplpay.paymenttype = 'P611' then                                   ");
  			buffer.append("                   '仲裁费	'                                                               ");
  			buffer.append("                  when prplpay.paymenttype = 'P612' then                                   ");
  			buffer.append("                   '执行费'                                                                ");
  			buffer.append("                  when prplpay.paymenttype = 'P65' then                                    ");
  			buffer.append("                   '内部代查勘费'                                                          ");
  			buffer.append("                  when prplpay.paymenttype = 'P67' then                                    ");
  			buffer.append("                   '外部代查勘费'                                                          ");
  			
  			buffer.append("                  when prplpay.paymenttype = 'P69' then                                    ");
  			buffer.append("                   '付其他'                                                          ");
  			
  			buffer.append("                  when prplpay.paymenttype = 'P62' then                                    ");
  			buffer.append("                   '机构查勘费'                                                            ");
  			buffer.append("                end as payType,                                                            ");
  			buffer.append("                PrpLpaymain.Comcode,                                                       ");
  			buffer.append("                '' as comcname,                    ");
  			buffer.append("                (select sum(payamount)                                                     ");
  			buffer.append("                   from prplpay pay                                                        ");
  			buffer.append("                  where pay.registno = prplpay.registno                                    ");
  			buffer.append("                    and pay.compensateno = prplpay.compensateno                            ");
  			buffer.append("                    and pay.paymenttype = prplpay.paymenttype                              ");
  			buffer.append("                    and pay.serialno <> prplpay.serialno) as havPay,                       ");
  			buffer.append("                case                                                                       ");
  			buffer.append("                  when prplpay.compensateno like '8%' then                                 ");
  			buffer.append("                   'Y'                                                                     ");
  			buffer.append("                  else                                                                     ");
  			buffer.append("                   'C'                                                                     ");
  			buffer.append("                end as certitype,                                                          ");
  			buffer.append("                prplpay.paymenttype as payrefreason,                                       ");
  			buffer.append("                PrpLpaymain.paymentno as  flowid                                                   ");
  			buffer.append("  FROM PrpLpaymain, prplpay, prplregist                                                    ");
  			buffer.append(" WHERE 1 = 1                                                                               ");
  			buffer.append(" and prplpaymain.operatorcode = '"+userCode+"'");	
  			buffer.append("   and prplpaymain.vflag in ('3', '7', '9')                                                ");
  			buffer.append("   and prplpay.classcode <> '05'                                                           ");
  			buffer.append("   and prplpaymain.paymentno = prplpay.serialno                                            ");
  			buffer.append("   and prplpay.registno = prplregist.registno                                             ");
  		}
  		
  		buffer.append(" ) c ,prplclaim tt ");
  		buffer.append("  where c.registno = tt.registno");
  		buffer.append(" and exists (select 1  ");
//  		buffer.append("          from prpjpayrefrec rec ");
        buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
        buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
        buffer.append( "  Union All                                                                            ");
        buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
        buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
  		buffer.append("         where rec.certino = c.certino  ");
  		buffer.append("           and rec.certitype = c.certitype ");
  		buffer.append("           and rec.visaserialno like '9%' ");
  		buffer.append("           and rec.payrefreason = c.payrefreason ");
  		buffer.append("           and rec.payrefstate in ('00', '01') ");
  		buffer.append("           and rec.payrefdate is null) ");
  		buffer.append("   AND EXISTS (SELECT 1                                  ");  
  		buffer.append("          FROM PRPLCLAIMBILLMANAGER BM                   "); 
  		buffer.append("         WHERE BM.COMPENSATENO = C.CERTINO               "); 
  		buffer.append("           AND BM.REGISTNO = TT.REGISTNO");
  		buffer.append("			  And Bm.Insuredcode Not In");
  		buffer.append("   			(Select Dd.Insuredcode");
  		buffer.append("      			From Prplfiscalpaydetail Dd");
  		buffer.append("      			Where Dd.Compensateno = Bm.Compensateno)");
  		buffer.append(")                "); 
  		buffer.append(" ");
  		
  		
  		if (pageNo > 0){
              //对Oracle优化
              if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                  buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                  buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                  //supportPaging=true;
              }
              else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                  String sql = buffer.toString();
                  buffer.setLength(0);
                  buffer.append("select * from ( select rownumber() over(");
                  int orderByIndex = sql.toLowerCase().indexOf("order by");
                  if ( orderByIndex>0 ) {
                     buffer.append( sql.substring(orderByIndex) );
                  }
                  buffer.append(") as rownumber_,");
                  buffer.append(sql.substring( 6 ));
                  buffer.append(" ) as temp_ where rownumber_");
                  buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                  //supportPaging=true;
              }
          }System.err.println(buffer.toString());
      	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
      	PrpLpayShowDto prpLpayShowDto =null;
      	while(resultSet.next()){
      		prpLpayShowDto = new PrpLpayShowDto();
      		prpLpayShowDto.setRegistNo(dbManager.getString(resultSet,"registno"));
      		prpLpayShowDto.setPolicyNo(dbManager.getString(resultSet,"policyno"));
      		prpLpayShowDto.setDamageDate(dbManager.getDateTime(resultSet,"damageenddate").toString());
      		prpLpayShowDto.setStartDate(dbManager.getDateTime(resultSet,"startdate").toString());
      		prpLpayShowDto.setEndDate(dbManager.getDateTime(resultSet, "enddate").toString());
      		prpLpayShowDto.setInsuredName(dbManager.getString(resultSet,"insuredname"));
      		prpLpayShowDto.setComCode(dbManager.getString(resultSet,"comcode"));
      		prpLpayShowDto.setComCodeName(dbManager.getString(resultSet,"comcname"));
      		list.add(prpLpayShowDto);
      	}
      	resultSet.close();
      	return list;
      }
      
      public int getNewAddQueryCount(String[] payTypes,String paymentType,String conditions ,String casesType,String userComcode)throws Exception{
    	  String newPayType = "";
    	  if(null!=payTypes&&payTypes.length>0){
    		  for(int i=0;i<payTypes.length;i++){
    			  if(null!=newPayType&&!"".equals(newPayType)){
    				  newPayType += ",'"+payTypes[i]+"'";
    			  }else{
    				  newPayType = "'"+payTypes[i]+"'";
    			  }
    		  }
    	  }
    	  System.err.println(121212+"单笔-整单-加号");
        	int count = -1;
        	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
        	StringBuffer buffer = new StringBuffer(200);
        	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
    		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
    		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
        	buffer.append("SELECT count(1) FROM ( ");
        	buffer.append(" select * ");
        	buffer.append(" from (  ");
        	if(null!=newPayType&&!"".equals(newPayType)&&newPayType.contains("P3")){
        	//--赔款
        	buffer.append(" select r.registno, ");
        	buffer.append(" t.policyno, ");
        	buffer.append(" t.compensateno as certino, ");
        	buffer.append(" c.claimNo, ");
        	buffer.append(" r.insuredname, ");
        	buffer.append(" r.licenseno, ");
    		buffer.append("  t.sumthispaid, ");
            buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
            buffer.append("  '赔款' as payType, ");
            buffer.append(" r.comcode, ");
            buffer.append(" '' as comcname, ");
        	buffer.append(" (select sum(payamount) ");
            buffer.append(" from prplpay prplpay ");
            buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = t.compensateno ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and prplpay.paymenttype = 'P60' ");
            buffer.append(" and prplpay.paytype = 'P3' ");
            
            buffer.append(" ) as havPay , ");//--已支付
            buffer.append(" 'C' as certitype,  ");
            buffer.append(" 'P60' as payrefreason  ");
            buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
            buffer.append(" where t.claimno = c.claimno ");
            buffer.append(" and c.registno = r.registno "); 
            //if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
            if(null!=newPayType&&!"".equals(newPayType)&&!newPayType.contains("P3")){
            	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
            }
            if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
            	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
            }
            buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
            buffer.append(" and r.classcode<>'05' ");
            if("mechanism".equals(casesType)){
            	if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  	}else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
            	if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  	}else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
            //添加已支付完成的查询不出来条件
    		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = t.compensateno ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and prplpay.paymenttype = 'P60' ");
            buffer.append(" and prplpay.paytype = 'P3' ");
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
            buffer.append(conditions);
            buffer.append(" and 5=5 ");
            
            //代付共保赔款
            buffer.append(" union all ");
            buffer.append(" select r.registno, ");
        	buffer.append(" t.policyno, ");
        	buffer.append(" co.businessno as certino, ");
        	buffer.append(" c.claimNo, ");
        	buffer.append(" r.insuredname, ");
        	buffer.append(" r.licenseno, ");
    		buffer.append(" co.coinssumpaid as sumthispaid, ");
            buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
            buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
            buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
            buffer.append(" r.comcode, ");
            buffer.append(" '' as comcname, ");
        	buffer.append(" (select sum(payamount) ");
            buffer.append(" from prplpay prplpay ");
            buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno =  co.businessno and prplpay.coinscode=co.coinscode ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
            buffer.append(" and prplpay.paytype = 'P3' ");
            
            buffer.append(" ) as havPay , ");//--已支付
            buffer.append(" 'C' as certitype,  ");
            buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
            buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason  ");
            buffer.append(" from prplcompensate t, prplclaim c, prplregist r,prplcfeecoins co ");
            buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
            buffer.append(" and c.registno = r.registno "); 
            //if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
            if(null!=newPayType&&!"".equals(newPayType)&&!newPayType.contains("P3")){
            	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
            }
            if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
            	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
            }
            buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
            buffer.append(" and r.classcode<>'05' ");
            if("mechanism".equals(casesType)){
            	if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  	}else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
            	if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  	}else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
            //添加已支付完成的查询不出来条件
    		buffer.append(" and (select co.coinssumpaid -nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
            buffer.append(" and prplpay.paytype = 'P3' ");
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
            buffer.append(conditions);
            buffer.append(" and 5=5 ");
            
            
    		//--赔付费用
            buffer.append(" union all ");
            buffer.append(" select r.registno, ");
            buffer.append(" t.policyno, ");
            buffer.append("  t.compensateno as certino, ");
            buffer.append(" c.claimNo, ");
            buffer.append(" r.insuredname, ");
            buffer.append(" r.licenseno, ");
            buffer.append(" ch.chargeamount as sumthispaid, ");
            buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
            buffer.append(" '赔付费用' as payType, ");
            buffer.append(" r.comcode, ");
            buffer.append(" '' as comcname, ");
            buffer.append(" (select sum(payamount) ");
            buffer.append(" from prplpay prplpay ");
           	buffer.append(" where prplpay.registno = r.registno ");
           	buffer.append(" and prplpay.compensateno = t.compensateno ");
           	buffer.append(" and prplpay.policyno = t.policyno ");
           	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
           	buffer.append("  and prplpay.paytype = 'P3' ");
           	
            buffer.append(" ) as havPay , ");	//--已支付
            buffer.append(" 'C' as certitype,  ");
            buffer.append("  changechargecodetopaymenttype(ch.chargecode) as payrefreason ");      
    		buffer.append(" from (select compensateno, chargecode,sum(nvl(chargeamount,0)-nvl(prechargeamount,0)-nvl(sumrealpay,0)) as chargeamount ");
         	buffer.append("  from prplcharge where  chargecode<>'14' ");
         	buffer.append(" group by compensateno, chargecode) ch, ");
         	buffer.append("  prplcompensate t, prplclaim c, prplregist r ");
           	
           	buffer.append(" where ch.compensateno = t.compensateno ");
           	buffer.append(" and t.claimno = c.claimno ");
           	buffer.append(" and c.registno = r.registno ");
           	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
           		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
           	}
           	//if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
           	if(null!=newPayType&&!"".equals(newPayType)&&!newPayType.contains("P3")){
           		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
           	}
           	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
           	buffer.append(" and r.classcode<>'05' ");
           	if("mechanism".equals(casesType)){
           		if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
           		}else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
            	 
              }else if("agnet".equals(casesType)){
            	  if("3477000000".equals(userComcode)){
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
            	  }else
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
              }
           	//添加已支付完成的查询不出来条件
    		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where prplpay.registno = r.registno ");
           	buffer.append(" and prplpay.compensateno = t.compensateno ");
           	buffer.append(" and prplpay.policyno = t.policyno ");
           	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
           	buffer.append(" and prplpay.paytype = 'P3' ");
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
           	buffer.append(conditions);
        	}
          	//--预赔赔款
        	if(null!=newPayType&&!"".equals(newPayType)&&newPayType.contains("P3")&&(newPayType.contains("P1")||newPayType.contains("P2")||newPayType.contains("P4"))){
    			buffer.append(" union all ");
        	}
        	if(null!=newPayType&&!"".equals(newPayType)&&(newPayType.contains("P1")||newPayType.contains("P2")||newPayType.contains("P4"))){
    		buffer.append(" select r.registno, ");
    		buffer.append(" pre.policyno, ");
    		buffer.append(" pre.precompensateno as certino, ");
    		buffer.append(" c.claimNo, ");
    		buffer.append(" r.insuredname, ");
    		buffer.append(" r.licenseno, ");
    		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
    		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
    		buffer.append(" '预赔赔款' as payType, ");
    		buffer.append(" r.comcode, ");
    		buffer.append(" '' as comcname, ");
    		buffer.append(" (select sum(payamount) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and paymenttype = 'P50' "); 
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    		
    		
    		
    	    buffer.append(" ) as havPay , ");//--已支付
    	    buffer.append(" 'Y' as certitype,  ");
            buffer.append(" 'P50' as payrefreason  ");
    		buffer.append(" from prplprepay pre, prplclaim c, prplregist r ");
    		
    		buffer.append(" where pre.claimno = c.claimno ");
    		buffer.append(" and c.registno = r.registno ");
    		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
    			buffer.append(" and 1<>1 ");
    		}
    		if(newPayType!=null&&!"".equals(newPayType)){
    			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
    		}else{
    			String[] payTypeList = newPayType.split(",");
     			buffer.append("and (");
     			for(int num=0;num<payTypeList.length;num++){
     				if(num==0){
     					buffer.append("  pre.casetype = changepaytypetocasetype("+payTypeList[num]+") ");// --支付类型
     				}else{
     					buffer.append(" or pre.casetype = changepaytypetocasetype("+payTypeList[num]+") ");// --支付类型
     				}
     			}
     			buffer.append(")");
    		}
    		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
    		buffer.append(" and r.classcode<>'05' ");
    		if("mechanism".equals(casesType)){
    			if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  }else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
            	if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  }else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
    		//添加已支付完成的查询不出来条件
    		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and paymenttype = 'P50' "); 
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
    		buffer.append(conditions);
    		
    		//--预赔费用
    		buffer.append(" union all ");
    		buffer.append(" select r.registno, ");
    		buffer.append(" pre.policyno, ");
    		buffer.append(" pch.precompensateno as certino, ");
    		buffer.append(" c.claimNo, ");
    		buffer.append(" r.insuredname, ");
    		buffer.append(" r.licenseno, ");
    		buffer.append(" pch.sumprepaid as sumthispaid, ");
    		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
    		buffer.append(" '预赔费用' as payType, ");
    		
    		buffer.append(" r.comcode, ");
    		buffer.append(" '' as comcname, ");
    		buffer.append(" (select sum(payamount) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    		
    	    buffer.append(" ) as havPay , ");//--已支付
    	    buffer.append(" 'Y' as certitype,  ");
    	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason  "); 
    		buffer.append(" from (select claimno,precompensateno,chargecode, ");
	  		buffer.append(" sum(sumprepaid) as sumprepaid ");
	  		buffer.append(" from prplprecharge ");
	  		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
	  		buffer.append("  prplprepay pre, prplclaim c, prplregist r ");
    		
    		buffer.append(" where pch.claimno = c.claimno ");
    		buffer.append(" and pch.precompensateno = pre.precompensateno ");
    		buffer.append(" and c.registno = r.registno ");
    		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
    			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
    		}
    		if(newPayType!=null&&!"".equals(newPayType)){
    			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
    		}else{
    			String[] payTypeList = newPayType.split(",");
     			buffer.append("and (");
     			for(int num=0;num<payTypeList.length;num++){
     				if(num==0){
     					buffer.append("  pre.casetype = changepaytypetocasetype("+payTypeList[num]+") ");// --支付类型
     				}else{
     					buffer.append(" or pre.casetype = changepaytypetocasetype("+payTypeList[num]+") ");// --支付类型
     				}
     			}
     			buffer.append(")");
     			
    		}
    		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
    		buffer.append(" and r.classcode<>'05' ");
    		if("mechanism".equals(casesType)){
    			if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	    }else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
            	if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  	}else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
    		//添加已支付完成的查询不出来条件
    		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
    		buffer.append(conditions);
        	}
    		
    		buffer.append(" ) c  ");
    		buffer.append("  where  exists (select 1  ");
//     		buffer.append("          from prpjpayrefrec rec ");
            buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
            buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
            buffer.append( "  Union All                                                                            ");
            buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
            buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
     		buffer.append("         where rec.certino = c.certino  ");
     		buffer.append("           and rec.certitype = c.certitype ");
     		buffer.append("           and rec.payrefreason = c.payrefreason ");
     		buffer.append("           and rec.payrefstate in ('00', '01') ");
     		buffer.append("           and rec.payrefdate is null) ");
    		buffer.append("  )  ");
    		PayQueryConditionLogger.payQueryConditionData("getNewQueryCount——2方法：<br>"+buffer.toString());
        	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
            resultSet.next();
            count = dbManager.getInt(resultSet,1);
            resultSet.close();
            return count;
        }
      
      public ArrayList<PrpLpayShowDto> getNewAddQueryShowList(String[] payTypes,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
    	  String newPayType = "";
    	  if(null!=payTypes&&payTypes.length>0){
    		  for(int i=0;i<payTypes.length;i++){
    			  if(null!=newPayType&&!"".equals(newPayType)){
    				  newPayType += ",'"+payTypes[i]+"'";
    			  }else{
    				  newPayType = "'"+payTypes[i]+"'";
    			  }
    		  }
    	  }
    	  System.err.println(131313+"单笔-整单-加号");
      		DateTime billUpDate = new DateTime(AppConfig.get("sysconst.BILLUpDATE"),DateTime.YEAR_TO_DAY); 
         	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
         	StringBuffer buffer = new StringBuffer(200);
         	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
    		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
    		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
         	buffer.append(" select registno,Policyno,Policytype,Certino,Claimno,Insuredname,coinsCode,Licenseno,Sumthispaid,Underwriteenddate,Paytype,Comcode,(select cop.comcname from prpdcompany cop where cop.comcode = c.comcode) as Comcname,Havpay,Certitype,Payrefreason,Flowid,claimrelationno ");
         	buffer.append(" from (  ");
         	if(!"".equals(newPayType)&&newPayType != null&&newPayType.contains("P3")){
         	//--赔款
         	buffer.append(" select r.registno, ");
         	buffer.append(" t.policyno, ");
     		buffer.append(" '' as policyType, ");
         	buffer.append(" t.compensateno as certino, ");
         	buffer.append(" c.claimNo, ");
         	buffer.append(" r.insuredname, ");
         	buffer.append(" '' as coinsCode, ");
         	buffer.append(" r.licenseno, ");
     		buffer.append("  t.sumthispaid, ");
             buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
             buffer.append("  '赔款' as payType, ");
             buffer.append(" r.comcode, ");
             buffer.append(" '' as comcname, ");
         	buffer.append(" (select sum(payamount) ");
             buffer.append(" from prplpay prplpay ");
             buffer.append(" where prplpay.registno = r.registno ");
             buffer.append(" and prplpay.compensateno = t.compensateno ");
             buffer.append(" and prplpay.policyno = t.policyno ");
             buffer.append(" and prplpay.paymenttype = 'P60' ");
             buffer.append(" and prplpay.paytype = 'P3' ");
             
             buffer.append(" ) as havPay,  ");//--已支付
             buffer.append(" 'C' as certitype,  ");
             buffer.append(" 'P60' as payrefreason,  ");
             buffer.append(" '0' as flowid, ");
             buffer.append(" case when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='31' then ");
             buffer.append(" t.claimrelationno ");
             buffer.append(" when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='32' then  ");
             buffer.append(" (select distinct aa.compensateno from prplclaimbillmanager aa where aa.compensateno=t.compensateno) ");
             buffer.append(" else ");
             buffer.append(" '' ");
             buffer.append(" end as claimrelationno ");
             buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
             buffer.append(" where t.claimno = c.claimno ");
             buffer.append(" and c.registno = r.registno "); 
             //if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
             if(!"".equals(newPayType)&&newPayType != null&&!newPayType.contains("P3")){
             	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
             }
             if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
             	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
             }
             buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
             if("mechanism".equals(casesType)){
            	 if("3477000000".equals(userComcode)){
           		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
           	  	}else
           		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
           	 
             }else if("agnet".equals(casesType)){
            	if("3477000000".equals(userComcode)){
           		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
           	  	}else
           		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
             }
             buffer.append(" and r.classcode<>'05' ");
             //添加已支付完成的查询不出来条件
     		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
     		buffer.append(" from prplpay ");
     		buffer.append(" where prplpay.registno = r.registno ");
             buffer.append(" and prplpay.compensateno = t.compensateno ");
             buffer.append(" and prplpay.policyno = t.policyno ");
             buffer.append(" and prplpay.paymenttype = 'P60' ");
             buffer.append(" and prplpay.paytype = 'P3' ");
     		//buffer.append(" and payflag='1' ");
     	    buffer.append(" )<> 0  ");//--已支付
     	    //添加已支付完成的查询不出来条件
             buffer.append(conditions);
             buffer.append(" and 3=3 ");   
             
             //代付共保赔款
             buffer.append(" union all ");
             buffer.append(" select r.registno, ");
          	buffer.append(" t.policyno, ");
      		buffer.append(" '' as policyType, ");
          	buffer.append(" co.businessno as certino,");
          	buffer.append(" c.claimNo, ");
          	buffer.append(" r.insuredname, ");
          	buffer.append(" co.coinsCode as coinsCode, ");
          	buffer.append(" r.licenseno, ");
      		buffer.append("    co.coinssumpaid as sumthispaid,");
              buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
              buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
              buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
              buffer.append(" r.comcode, ");
              buffer.append(" '' as comcname, ");
          	buffer.append(" (select sum(payamount) ");
              buffer.append(" from prplpay prplpay ");
              buffer.append(" where prplpay.registno = r.registno ");
              buffer.append(" and prplpay.compensateno =  co.businessno and prplpay.coinscode=co.coinscode ");
              buffer.append(" and prplpay.policyno = t.policyno ");
              buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
              buffer.append(" and prplpay.paytype = 'P3' ");
              
              buffer.append(" ) as havPay,  ");//--已支付
              buffer.append(" 'C' as certitype,  ");
              buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
              buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason , ");
              buffer.append(" '0' as flowid, ");
              buffer.append(" case when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='31' then ");
              buffer.append(" t.claimrelationno ");
              buffer.append(" when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='32' then  ");
              buffer.append(" (select distinct aa.compensateno from prplclaimbillmanager aa where aa.compensateno=t.compensateno) ");
              buffer.append(" else ");
              buffer.append(" '' ");
              buffer.append(" end as claimrelationno ");
              buffer.append(" from prplcompensate t, prplclaim c, prplregist r,prplcfeecoins co ");
              buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
              buffer.append(" and c.registno = r.registno "); 
              //if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
              if(!"".equals(newPayType)&&newPayType != null&&!newPayType.contains("P3")){
              	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
              }
              if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
              	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
              }
              buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
              if("mechanism".equals(casesType)){
             	 if("3477000000".equals(userComcode)){
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
            	  	}else
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
            	 
              }else if("agnet".equals(casesType)){
             	if("3477000000".equals(userComcode)){
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
            	  	}else
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
              }
              buffer.append(" and r.classcode<>'05' ");
              //添加已支付完成的查询不出来条件
      		buffer.append(" and (select  co.coinssumpaid-nvl(sum(payamount),0) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where prplpay.registno = r.registno ");
              buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
              buffer.append(" and prplpay.policyno = t.policyno ");
              buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
              buffer.append(" and prplpay.paytype = 'P3' ");
      		//buffer.append(" and payflag='1' ");
      	    buffer.append(" )<> 0  ");//--已支付
      	    //添加已支付完成的查询不出来条件
              buffer.append(conditions);
              buffer.append(" and 3=3 ");   
      		
             
     		//--赔付费用
             buffer.append(" union all ");
             buffer.append(" select r.registno, ");
             buffer.append(" t.policyno, ");
     		buffer.append(" '' as policyType, ");
             buffer.append("  t.compensateno as certino, ");
             buffer.append(" c.claimNo, ");
             buffer.append(" r.insuredname, ");
             buffer.append(" '' as coinsCode , ");
             buffer.append(" r.licenseno, ");
             buffer.append(" ch.chargeamount as sumthispaid, ");
             buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
             buffer.append("  changechargecodetochargename(ch.chargecode) as paytype, ");
             buffer.append(" r.comcode, ");
             buffer.append(" '' as comcname, ");
             buffer.append(" (select sum(payamount) ");
             buffer.append(" from prplpay prplpay ");
            	buffer.append(" where prplpay.registno = r.registno ");
            	buffer.append(" and prplpay.compensateno = t.compensateno ");
            	buffer.append(" and prplpay.policyno = t.policyno ");
            	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
            	buffer.append("  and prplpay.paytype = 'P3' ");
            	
             buffer.append(" ) as havPay , ");//--已支付
             buffer.append(" 'C' as certitype,  ");
             buffer.append("  changechargecodetopaymenttype(Ch.Chargecode) as payrefreason,  ");
     		buffer.append(" '0' as flowid, ");
     		buffer.append(" '' as claimrelationno ");
     		buffer.append(" from (select compensateno, chargecode, sum(nvl(chargeamount,0)-nvl(prechargeamount,0)-nvl(sumrealpay,0)) as chargeamount ");
         	buffer.append("  from prplcharge  where  chargecode<>'14' ");
         	buffer.append(" group by compensateno, chargecode) ch, ");
         	buffer.append("  prplcompensate t, prplclaim c, prplregist r ");
            	buffer.append(" where ch.compensateno = t.compensateno ");
            	buffer.append(" and t.claimno = c.claimno ");
            	buffer.append(" and c.registno = r.registno ");
            	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
            		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
            	}
            	//if(payType != null&&!"".equals(payType)&&!"P3".equals(payType)){
            	if(newPayType != null&&!"".equals(newPayType)&&!newPayType.contains("P3")){
            	
            		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
            	}
            	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
            	if("mechanism".equals(casesType)){
            	  if("3477000000".equals(userComcode)){
              		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
              	  }else
              		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
            	 
              }else if("agnet".equals(casesType)){
            	  if("3477000000".equals(userComcode)){
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
            	  }else
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
              }
            	buffer.append(" and r.classcode<>'05' ");
            	//添加已支付完成的查询不出来条件
     		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
     		buffer.append(" from prplpay ");
     		buffer.append(" where prplpay.registno = r.registno ");
        	buffer.append(" and prplpay.compensateno = t.compensateno ");
        	buffer.append(" and prplpay.policyno = t.policyno ");
        	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
        	buffer.append(" and prplpay.paytype = 'P3' ");
     		//buffer.append(" and payflag='1' ");
     	    buffer.append(" )<>0  ");//--已支付
     	    //添加已支付完成的查询不出来条件
            	buffer.append(conditions);
         	}
           	//--预赔赔款
         	if(!"".equals(newPayType)&&newPayType != null&&newPayType.contains("P3")&&(newPayType.contains("P1")||newPayType.contains("P2")||newPayType.contains("P4"))){
         		buffer.append(" union all ");
         	}
     		if(!"".equals(newPayType)&&newPayType != null&&(newPayType.contains("P1")||newPayType.contains("P2")||newPayType.contains("P4"))){
     		buffer.append(" select r.registno, ");
     		buffer.append(" pre.policyno, ");
     		buffer.append(" '' as policyType, ");
     		buffer.append(" pre.precompensateno as certino, ");
     		buffer.append(" c.claimNo, ");
     		buffer.append(" r.insuredname, ");
     		buffer.append(" '' as coinsCode , ");
     		buffer.append(" r.licenseno, ");
     		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
     		//buffer.append(" pre.underwriteenddate, ");
     		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
     		buffer.append(" '预赔赔款' as payType, ");
     		buffer.append(" r.comcode, ");
     		buffer.append(" '' as comcname, ");
     		buffer.append(" (select sum(payamount) ");
     		buffer.append(" from prplpay ");
     		buffer.append(" where registno = r.registno ");
     		buffer.append(" and compensateno = pre.precompensateno ");
     		buffer.append(" and policyno = pre.policyno ");
     		buffer.append(" and paymenttype = 'P50' "); 
     		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
     		
     		
     	    buffer.append(" ) as havPay , ");//--已支付
     	    buffer.append(" 'Y' as certitype, ");
     	    buffer.append(" 'P50' as payrefreason, ");
     	    buffer.append(" '0' as flowid, ");
     	    buffer.append(" '' as claimrelationno ");
     		buffer.append(" from prplprepay pre, prplclaim c, prplregist r  ");
     		buffer.append(" where pre.claimno = c.claimno ");
     		buffer.append(" and c.registno = r.registno ");
     		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
     			buffer.append(" and 1<>1 ");
     		}
     		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
     		if(newPayType==null||"".equals(newPayType)){
     			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
     		}else{
     			String[] payTypeList = newPayType.split(",");
     			buffer.append("and (");
     			for(int num=0;num<payTypeList.length;num++){
     				if(num==0){
     					buffer.append("  pre.casetype = changepaytypetocasetype("+payTypeList[num]+") ");// --支付类型
     				}else{
     					buffer.append(" or pre.casetype = changepaytypetocasetype("+payTypeList[num]+") ");// --支付类型
     				}
     			}
     			buffer.append(")");
     		}
     		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
     		if("mechanism".equals(casesType)){
     			if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
     			}else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
            }else if("agnet".equals(casesType)){
            	if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  	}else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
     		buffer.append(" and r.classcode<>'05' ");
     		//添加已支付完成的查询不出来条件
     		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
     		buffer.append(" from prplpay ");
     		buffer.append(" where registno = r.registno ");
     		buffer.append(" and compensateno = pre.precompensateno ");
     		buffer.append(" and policyno = pre.policyno ");
     		buffer.append(" and paymenttype = 'P50' "); 
     		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
     		//buffer.append(" and payflag='1' ");
     	    buffer.append(" )<>0  ");//--已支付
     	    //添加已支付完成的查询不出来条件
     		buffer.append(conditions);
     		
     		
     		
     		//--预赔费用
     		buffer.append(" union all ");
     		buffer.append(" select r.registno, ");
     		buffer.append(" pre.policyno, ");
     		buffer.append(" '' as policyType, ");
     		buffer.append(" pch.precompensateno as certino, ");
     		buffer.append(" c.claimNo, ");
     		buffer.append(" r.insuredname, ");
     		buffer.append(" '' as coinsCode , ");
     		buffer.append(" r.licenseno, ");
     		buffer.append(" pch.sumprepaid as sumthispaid, ");
     		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
     		buffer.append(" pchangechargecodetochargename(pch.chargecode) as payType,");
     		buffer.append(" r.comcode, ");
     		buffer.append(" '' as comcname, ");
     		buffer.append(" (select sum(payamount) ");
     		buffer.append(" from prplpay ");
     		buffer.append(" where registno = r.registno ");
     		buffer.append(" and compensateno = pre.precompensateno ");
     		buffer.append(" and policyno = pre.policyno ");
     		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
     		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
     	    buffer.append(" ) as havPay,  ");//--已支付
     	    buffer.append(" 'Y' as certitype, ");
     	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason,  ");
     		buffer.append(" '0' as flowid, ");
     		buffer.append(" '' as claimrelationno ");
     		buffer.append(" from (select claimno,precompensateno,chargecode, ");
	  		buffer.append(" sum(sumprepaid) as sumprepaid ");
	  		buffer.append(" from prplprecharge ");
	  		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
	  		buffer.append("  prplprepay pre, prplclaim c, prplregist r  ");
     		buffer.append(" where pch.claimno = c.claimno ");
     		buffer.append(" and pch.precompensateno = pre.precompensateno ");
     		buffer.append(" and c.registno = r.registno ");
     		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
     			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
     		}
     		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
     		if(newPayType==null||"".equals(newPayType)){
     			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
     		}else{
     			String[] payTypeList = newPayType.split(",");
     			buffer.append("and (");
     			for(int num=0;num<payTypeList.length;num++){
     				if(num==0){
     					buffer.append("  pre.casetype = changepaytypetocasetype("+payTypeList[num]+") ");// --支付类型
     				}else{
     					buffer.append(" or pre.casetype = changepaytypetocasetype("+payTypeList[num]+") ");// --支付类型
     				}
     			}
     			buffer.append(")");
     			
     		}
     		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
     		if("mechanism".equals(casesType)){
     			if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
     			}else
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
     		}else if("agnet".equals(casesType)){
        	  if("3477000000".equals(userComcode)){
        		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
        	  }else
        		  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
     		}
     		buffer.append(" and r.classcode<>'05' ");
     		//添加已支付完成的查询不出来条件
     		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
     		buffer.append(" from prplpay ");
     		buffer.append(" where registno = r.registno ");
     		buffer.append(" and compensateno = pre.precompensateno ");
     		buffer.append(" and policyno = pre.policyno ");
     		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
     		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
     		//buffer.append(" and payflag='1' ");
     	    buffer.append(" )<>0  ");//--已支付 
     	    //添加已支付完成的查询不出来条件
     		buffer.append(conditions);
         	}
     		buffer.append(" ) c  ");
     		buffer.append("  where  exists (select 1  ");
//     		buffer.append("          from prpjpayrefrec rec ");
            buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
            buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
            buffer.append( "  Union All                                                                            ");
            buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
            buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
     		buffer.append("         where rec.certino = c.certino  ");
     		buffer.append("           and rec.certitype = c.certitype ");
     		buffer.append("           and rec.visaserialno like '9%' ");
     		buffer.append("           and rec.payrefreason = c.payrefreason ");
     		buffer.append("           and rec.payrefstate in ('00', '01') ");
     		buffer.append("           and rec.payrefdate is null) ");
     		buffer.append(" order by underwriteenddate ");
     		if (pageNo > 0){
                 //对Oracle优化
                 if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                     buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                     buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                     //supportPaging=true;
                 }
                 else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                     String sql = buffer.toString();
                     buffer.setLength(0);
                     buffer.append("select * from ( select rownumber() over(");
                     int orderByIndex = sql.toLowerCase().indexOf("order by");
                     if ( orderByIndex>0 ) {
                        buffer.append( sql.substring(orderByIndex) );
                     }
                     buffer.append(") as rownumber_,");
                     buffer.append(sql.substring( 6 ));
                     buffer.append(" ) as temp_ where rownumber_");
                     buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                     //supportPaging=true;
                 }
             }System.err.println(buffer.toString());
     		PayQueryConditionLogger.payQueryConditionData("getNewQueryShowList——2方法：<br>"+buffer.toString());
         	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
         	PrpLpayShowDto prpLpayShowDto =null;
         	while(resultSet.next()){
         		prpLpayShowDto = new PrpLpayShowDto();
         		prpLpayShowDto.setRegistNo(dbManager.getString(resultSet,"RegistNo"));
         		prpLpayShowDto.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
         		prpLpayShowDto.setPolicyType(dbManager.getString(resultSet,"PolicyType"));
         		prpLpayShowDto.setCertiNo(dbManager.getString(resultSet,"CertiNo"));
         		prpLpayShowDto.setClaimNo(dbManager.getString(resultSet,"ClaimNo"));
         		prpLpayShowDto.setCoinsCode(dbManager.getString(resultSet,"coinsCode"));
         		prpLpayShowDto.setInsuredName(dbManager.getString(resultSet,"InsuredName"));
         		prpLpayShowDto.setLicenseNo(dbManager.getString(resultSet,"LicenseNo"));
         		prpLpayShowDto.setSumPaid(dbManager.getDouble(resultSet,"sumthispaid"));
         		prpLpayShowDto.setUnderWriteEndDate(dbManager.getString(resultSet,"UnderWriteEndDate"));
         		prpLpayShowDto.setPayType(dbManager.getString(resultSet,"PayType"));
         		prpLpayShowDto.setComCode(dbManager.getString(resultSet,"ComCode"));
         		prpLpayShowDto.setComCodeName(dbManager.getString(resultSet,"ComCName"));
         		prpLpayShowDto.setHavPaid(dbManager.getDouble(resultSet,"HavPay"));
         		prpLpayShowDto.setFlowId(dbManager.getString(resultSet, "flowid"));
         		prpLpayShowDto.setPayrefreason(dbManager.getString(resultSet, "payrefreason"));
         		prpLpayShowDto.setRiskCode(dbManager.getString(resultSet,"CertiNo"));
         		prpLpayShowDto.setClassCode(dbManager.getString(resultSet,"CertiNo"));
         		prpLpayShowDto.setClaimRelationNo(dbManager.getString(resultSet,"claimrelationno"));
         		//prpLpayShowDto.setNowPaid(dbManager.getDouble(resultSet,"NowPay"));
         		//prpLpayShowDto.setExist(dbManager.getString(resultSet,"Exist"));
         		list.add(prpLpayShowDto);
         	}
         	resultSet.close();
         	return list;
         }
      
      
      /**************************优化修改：start*********************************/
      /**
  	 * 支付信息查询列表显示方法
  	 * @param payType	支付类型
  	 * @param paymentType	赔款类型
  	 * @param comCode	机构号码
  	 * @return
  	 * @throws Exception
  	 */
      public int getNewQueryRegistCountNew(String payType,String paymentType,String condition ,String casesType,String userComcode)throws Exception{
      	//String comCodeStr = comCode.substring(0, 6);
      	//String conditions="";
      	//String paymentNo="";
    	//将原条件和额外拼接的条件分开获取
    	String conditionsAdd = "";
      	String conditions = "";
      	if(null!=condition && !"".equals(condition) && condition.indexOf("ABCD")>0){
      		conditionsAdd = condition.substring(0,condition.indexOf("ABCD"));
      		conditions = condition.substring(condition.indexOf("ABCD")+4);
      	}else{
      		conditions = condition;
      	}
    	  
      	int count = -1;
      	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
      	StringBuffer buffer = new StringBuffer(200);
      	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
      	buffer.append("SELECT count(1) FROM ( ");
      	buffer.append(" select distinct tt.registno,tt.policyno,tt.damageenddate,tt.startdate,tt.enddate,tt.insuredname,c.comcode,c.comcname ");
      	buffer.append(" from (  ");
      	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
      	//--赔款
      	buffer.append(" select r.registno, ");
      	buffer.append(" t.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
      	buffer.append(" t.compensateno as certino, ");
      	buffer.append(" c.claimNo, ");
      	buffer.append(" r.insuredname, ");
      	buffer.append(" r.licenseno, ");
  		buffer.append("  t.sumthispaid, ");
          //buffer.append("   t.underwriteenddate, ");
          buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
          buffer.append("  '赔款' as payType, ");
          buffer.append(" r.comcode, ");
          buffer.append(" '' as comcname, ");
      	buffer.append(" (select sum(payamount) ");
          buffer.append(" from prplpay prplpay ");
          buffer.append(" where prplpay.registno = r.registno ");
          buffer.append(" and prplpay.compensateno = t.compensateno ");
          buffer.append(" and prplpay.policyno = t.policyno ");
          buffer.append(" and prplpay.paymenttype = 'P60' ");
          buffer.append(" and prplpay.paytype = 'P3' ");
          
          buffer.append(" ) as havPay , ");//--已支付
          buffer.append(" 'C' as certitype,  ");
          buffer.append(" 'P60' as payrefreason  ");
          buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
          buffer.append(" where t.claimno = c.claimno ");
          buffer.append(" and c.registno = r.registno "); 
          if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
          	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
          }
          if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
          	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
          }
          buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
          buffer.append(" and r.classcode<>'05' ");
          if("mechanism".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
          }else if("agnet".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
          }
          //添加已支付完成的查询不出来条件
  		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where prplpay.registno = r.registno ");
          buffer.append(" and prplpay.compensateno = t.compensateno ");
          buffer.append(" and prplpay.policyno = t.policyno ");
          buffer.append(" and prplpay.paymenttype = 'P60' ");
          buffer.append(" and prplpay.paytype = 'P3' ");
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
          buffer.append(conditions);
          
        //新增代付共保赔款
          buffer.append(" union all ");
          buffer.append(" select r.registno, ");
      	buffer.append(" t.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
      	buffer.append(" co.businessno as certino, ");
      	buffer.append(" c.claimNo, ");
      	buffer.append(" r.insuredname, ");
      	buffer.append(" r.licenseno, ");
  		buffer.append("  co.coinssumpaid as sumthispaid, ");
          //buffer.append("   t.underwriteenddate, ");
          buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
          buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
          buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
          buffer.append(" r.comcode, ");
          buffer.append(" '' as comcname, ");
      	buffer.append(" (select sum(payamount) ");
          buffer.append(" from prplpay prplpay ");
          buffer.append(" where prplpay.registno = r.registno ");
          buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
          buffer.append(" and prplpay.policyno = t.policyno ");
          buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
          buffer.append(" and prplpay.paytype = 'P3' ");
          
          buffer.append(" ) as havPay , ");//--已支付
          buffer.append(" 'C' as certitype,  ");
          buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
          buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason  ");
          buffer.append(" from prplcompensate t, prplclaim c, prplregist r ,prplcfeecoins  co");
          buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
          buffer.append(" and c.registno = r.registno "); 
          if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
          	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
          }
          if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
          	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
          }
          buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
          buffer.append(" and r.classcode<>'05' ");
          if("mechanism".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
          }else if("agnet".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
          }
          //添加已支付完成的查询不出来条件
  		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where prplpay.registno = r.registno ");
          buffer.append(" and prplpay.compensateno =  co.businessno and prplpay.coinscode=co.coinscode ");
          buffer.append(" and prplpay.policyno = t.policyno ");
          buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
          buffer.append(" and prplpay.paytype = 'P3' ");
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
          buffer.append(conditions);
          
  		//--赔付费用
          buffer.append(" union all ");
          buffer.append(" select r.registno, ");
          buffer.append(" t.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
          buffer.append("  t.compensateno as certino, ");
          buffer.append(" c.claimNo, ");
          buffer.append(" r.insuredname, ");
          buffer.append(" r.licenseno, ");
          buffer.append(" ch.chargeamount as sumthispaid, ");
          //buffer.append(" t.underwriteenddate, ");
          buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
          buffer.append(" '赔付费用' as payType, ");
          buffer.append(" r.comcode, ");
          buffer.append(" '' as comcname, ");
          buffer.append(" (select sum(payamount) ");
          buffer.append(" from prplpay prplpay ");
         	buffer.append(" where prplpay.registno = r.registno ");
         	buffer.append(" and prplpay.compensateno = t.compensateno ");
         	buffer.append(" and prplpay.policyno = t.policyno ");
         	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
         	buffer.append("  and prplpay.paytype = 'P3' ");
         	
          buffer.append(" ) as havPay , ");	//--已支付
          buffer.append(" 'C' as certitype,  ");
          /*buffer.append(" case ch.chargecode  ");
  		buffer.append(" when '05' then  ");
  		buffer.append("  'P64'  ");
  		buffer.append(" when '07' then  ");
  		buffer.append("  'P61'  ");
  		buffer.append(" when '15' then  ");
  		buffer.append("  'P68'  ");
  		buffer.append(" when '29' then  ");
  		buffer.append("  'P611'  ");
  		buffer.append(" when '30' then  ");
  		buffer.append("  'P612'  ");
  		buffer.append(" when '14' then  ");
  		buffer.append("  'P65'  ");
  		buffer.append(" when '13' then  ");
  		buffer.append("  'P67'  ");
  		buffer.append(" when '04' then  ");
  		buffer.append("  'P62'  ");
  		buffer.append(" else  ");
  		buffer.append("  ''  ");
  		buffer.append("  end as payrefreason  ");*/
          buffer.append("  changechargecodetopaymenttype(ch.chargecode) as payrefreason  ");
  		buffer.append(" from (select ph.compensateno, ph.chargecode,sum(nvl(ph.chargeamount,0)-nvl(ph.prechargeamount,0)-nvl(ph.sumrealpay,0)) as chargeamount ");
       	buffer.append("  from prplcharge ph, prplcompensate t where ph.compensateno = t.compensateno and ph.chargecode<>'14' and t.underwriteflag in ('0', '2', '1', '3', '9') ");
       	buffer.append(conditionsAdd);
       	buffer.append(" group by ph.compensateno, ph.chargecode) ch, ");
       	buffer.append("  prplcompensate t, prplclaim c, prplregist r ");
        // 	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r ");
         	
         	buffer.append(" where ch.compensateno = t.compensateno ");
         	buffer.append(" and t.claimno = c.claimno ");
         	buffer.append(" and c.registno = r.registno ");
         	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
         		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
         	}
         	if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
         		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
         	}
         	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
         	buffer.append(" and r.classcode<>'05' ");
         	if("mechanism".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
         	//添加已支付完成的查询不出来条件
  		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where prplpay.registno = r.registno ");
         	buffer.append(" and prplpay.compensateno = t.compensateno ");
         	buffer.append(" and prplpay.policyno = t.policyno ");
         	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
         	buffer.append(" and prplpay.paytype = 'P3' ");
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
         	buffer.append(conditions);
      	}
      	if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
        	//--预赔赔款
  		//buffer.append(" union all ");
  		buffer.append(" select r.registno, ");
  		buffer.append(" pre.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
  		buffer.append(" pre.precompensateno as certino, ");
  		buffer.append(" c.claimNo, ");
  		buffer.append(" r.insuredname, ");
  		buffer.append(" r.licenseno, ");
  		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
  		//buffer.append(" pre.underwriteenddate, ");
  		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
  		buffer.append(" '预赔赔款' as payType, ");
  		buffer.append(" r.comcode, ");
  		buffer.append(" '' as comcname, ");
  		buffer.append(" (select sum(payamount) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and paymenttype = 'P50' "); 
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		
  		
  		
  	    buffer.append(" ) as havPay , ");//--已支付
  	    buffer.append(" 'Y' as certitype,  ");
          buffer.append(" 'P50' as payrefreason  ");
  		buffer.append(" from prplprepay pre, prplclaim c, prplregist r ");
  		
  		buffer.append(" where pre.claimno = c.claimno ");
  		buffer.append(" and c.registno = r.registno ");
  		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
  			buffer.append(" and 1<>1 ");
  		}
  		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		if(payType!=null&&!"".equals(payType)){
  			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
  		}else{
  			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		}
  		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
  		buffer.append(" and r.classcode<>'05' ");
  		if("mechanism".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
          }else if("agnet".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
          }
  		//添加已支付完成的查询不出来条件
  		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and paymenttype = 'P50' "); 
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
  		buffer.append(conditions);
  		
  		//--预赔费用
  		buffer.append(" union all ");
  		buffer.append(" select r.registno, ");
  		buffer.append(" pre.policyno, ");
//  		buffer.append(" (select case grp.policytype ");
//  		buffer.append(" when '1' then '商业险' ");
//  		buffer.append(" when '3' then '交强险' ");
//  		buffer.append(" else '' end ");
//  		buffer.append(" from prplregistrpolicy grp ");
//  		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
  		buffer.append(" pch.precompensateno as certino, ");
  		buffer.append(" c.claimNo, ");
  		buffer.append(" r.insuredname, ");
  		buffer.append(" r.licenseno, ");
  		buffer.append(" pch.sumprepaid as sumthispaid, ");
  		//buffer.append(" pre.underwriteenddate, ");
  		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
  		buffer.append(" '预赔费用' as payType, ");
  		
  		buffer.append(" r.comcode, ");
  		buffer.append(" '' as comcname, ");
  		buffer.append(" (select sum(payamount) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		
  	    buffer.append(" ) as havPay , ");//--已支付
  	    buffer.append(" 'Y' as certitype,  ");
  	    /*buffer.append(" case pch.chargecode  ");
  		buffer.append(" when '05' then  ");
  		buffer.append("  'Y64'  ");
  		buffer.append(" when '07' then  ");
  		buffer.append("  'Y61'  ");
  		buffer.append(" when '15' then  ");
  		buffer.append("  'Y68'  ");
  		buffer.append(" when '29' then  ");
  		buffer.append("  'Y611'  ");
  		buffer.append(" when '30' then  ");
  		buffer.append("  'Y612'  ");
  		buffer.append(" when '14' then  ");
  		buffer.append("  'Y65'  ");
  		buffer.append(" when '13' then  ");
  		buffer.append("  'Y67'  ");
  		buffer.append(" when '04' then  ");
  		buffer.append("  'Y62'  ");
  		buffer.append(" else  ");
  		buffer.append("  'Y69'  ");
  		buffer.append("  end as payrefreason  ");*/
  	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason ");
  		buffer.append(" from (select claimno,precompensateno,chargecode, ");
		buffer.append(" sum(sumprepaid) as sumprepaid ");
		buffer.append(" from prplprecharge ");
		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
		buffer.append("  prplprepay pre, prplclaim c, prplregist r ");
  		//buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ");
  		
  		buffer.append(" where pch.claimno = c.claimno ");
  		buffer.append(" and pch.precompensateno = pre.precompensateno ");
  		buffer.append(" and c.registno = r.registno ");
  		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
  			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
  		}
  		if(payType!=null&&!"".equals(payType)){
  			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
  		}else{
  			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
  		}
  		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
  		buffer.append(" and r.classcode<>'05' ");
  		if("mechanism".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
        	 
          }else if("agnet".equals(casesType)){
        	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
          }
  		//添加已支付完成的查询不出来条件
  		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
  		buffer.append(" from prplpay ");
  		buffer.append(" where registno = r.registno ");
  		buffer.append(" and compensateno = pre.precompensateno ");
  		buffer.append(" and policyno = pre.policyno ");
  		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
  		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
  		//buffer.append(" and payflag='1' ");
  	    buffer.append(" )>0  ");//--已支付
  	    //添加已支付完成的查询不出来条件
  		buffer.append(conditions);
      	}
  		buffer.append(" ) c ,prplclaim tt ");
  		buffer.append("  where  c.registno = tt.registno");
   		buffer.append(" and exists (select 1  ");
   		//buffer.append("          from prpjpayrefrec rec ");
   		buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
        buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
        buffer.append( "  Union All                                                                            ");
        buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
        buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
        buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
        buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
        buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
        buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
        buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
        buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
        buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
        buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
        buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
        buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
        buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
        buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
   		buffer.append("         where rec.certino = c.certino  ");
   		buffer.append("           and rec.certitype = c.certitype ");
   		buffer.append("           and rec.payrefreason = c.payrefreason ");
   		buffer.append("           and rec.payrefstate in ('00', '01') ");
   		buffer.append("           and rec.payrefdate is null) ");
   		buffer.append("	And Not Exists (Select 1 ");
   		buffer.append("          From Prplinterrelation Nn ");
   		buffer.append("         Where Nn.Relationregistno = C.Registno) ");
//  		buffer.append("  where exists (select 1  ");
//  		buffer.append("  from prpjplanfee rf  ");
//  		buffer.append("  where c.certino = rf.certino  ");
//  		buffer.append("   and rf.certitype in ('C', 'Y')  ");
//  		//buffer.append("   and rf.payrefdate is null  ");
//  		buffer.append("   and rf.planfee > rf.realpayreffee  ");
//  		buffer.append("  and rf.planfee > 0)  ");
        //屏蔽新农险案件查询
   		buffer.append("	And Not Exists (Select 1 ");
   		buffer.append("         from prpcmain cm ");
   		buffer.append("         WHERE cm.policyno = c.policyno AND cm.systemflag = 'agri' ) ");
  		buffer.append("  )  ");
      	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
      	System.err.print(buffer.toString());
          resultSet.next();
          count = dbManager.getInt(resultSet,1);
          resultSet.close();
          return count;
      }
      /**
    	 * 支付信息查询列表显示方法
    	 * @param payType	支付类型
    	 * @param paymentType	赔款类型
    	 * @param comCode	机构号码
    	 * @param registNos	报案号集合
    	 * @param certiNos	业务号集合
    	 * @return
    	 * @throws Exception
    	 */
        public ArrayList<PrpLpayShowDto> getNewQueryShowRegistListNew(String payType,String paymentType,String condition,int pageNo,int rowsPerPage,String casesType,String userComcode,String type)throws Exception{
        	//String comCodeStr = comCode.substring(0, 6);
        	//String conditions="";
        	//String paymentNo="";
        	//将原条件和额外拼接的条件分开获取
        	String conditionsAdd = "";
        	String conditions = "";
        	if(null!=condition && !"".equals(condition) && condition.indexOf("ABCD")>0){
        		conditionsAdd = condition.substring(0,condition.indexOf("ABCD"));
        		conditions = condition.substring(condition.indexOf("ABCD")+4);
        	}else{
        		conditions = condition;
        	}
        	
        	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
        	StringBuffer buffer = new StringBuffer(200);
        	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
    		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
    		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
        	buffer.append(" select distinct tt.registno,tt.policyno,tt.damageenddate,tt.startdate,tt.enddate,tt.insuredname,c.comcode,(select cop.comcname  from prpdcompany cop  where cop.comcode = c.comcode) as comcname ");
        	buffer.append(" from (  ");
        	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
        	//--赔款
        	buffer.append(" select r.registno, ");
        	buffer.append(" t.policyno, ");
    		buffer.append(" '' as policyType, ");
        	buffer.append(" t.compensateno as certino, ");
        	buffer.append(" c.claimNo, ");
        	buffer.append(" r.insuredname, ");
        	buffer.append(" r.licenseno, ");
    		buffer.append("  t.sumthispaid, ");
            //buffer.append("   t.underwriteenddate, ");
            buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
            buffer.append("  '赔款' as payType, ");
            buffer.append(" r.comcode, ");
            buffer.append(" '' as comcname, ");
        	buffer.append(" (select sum(payamount) ");
            buffer.append(" from prplpay prplpay ");
            buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = t.compensateno ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and prplpay.paymenttype = 'P60' ");
            buffer.append(" and prplpay.paytype = 'P3' ");
            
            /**
            if(paymentNo!=null&&!"".equals(paymentNo)){
            	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
            }
            */
            
            buffer.append(" ) as havPay,  ");//--已支付
            buffer.append(" 'C' as certitype,  ");
            buffer.append(" 'P60' as payrefreason,  ");
            buffer.append(" '0' as flowid ");
            buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
            /**
            buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
            buffer.append(" pay.exist    ");//--是否勾选
            
            buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
            buffer.append(" from prplpay ");
            buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
            buffer.append(" and pay.compensateno(+) = t.compensateno ");
            */
            buffer.append(" where t.claimno = c.claimno ");
            buffer.append(" and c.registno = r.registno "); 
            if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
            	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
            }
            if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
            	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
            }
            buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
            if("mechanism".equals(casesType)){
          	  if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  }else
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
          	 
            }else if("agnet".equals(casesType)){
          	  if("3477000000".equals(userComcode)){
          		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
          	  }else
          	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
            }
            buffer.append(" and r.classcode<>'05' ");
            //添加已支付完成的查询不出来条件
    		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where prplpay.registno = r.registno ");
            buffer.append(" and prplpay.compensateno = t.compensateno ");
            buffer.append(" and prplpay.policyno = t.policyno ");
            buffer.append(" and prplpay.paymenttype = 'P60' ");
            buffer.append(" and prplpay.paytype = 'P3' ");
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )<> 0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
            buffer.append(conditions);
            
          //新增代付共保赔款
            buffer.append(" union all ");
            buffer.append(" select r.registno, ");
          	buffer.append(" t.policyno, ");
      		buffer.append(" '' as policyType, ");
          	buffer.append("  co.businessno as certino, ");
          	buffer.append(" c.claimNo, ");
          	buffer.append(" r.insuredname, ");
          	buffer.append(" r.licenseno, ");
      		buffer.append("  co.coinssumpaid, ");
              //buffer.append("   t.underwriteenddate, ");
              buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
              buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
              buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
              buffer.append(" r.comcode, ");
              buffer.append(" '' as comcname, ");
          	buffer.append(" (select sum(payamount) ");
              buffer.append(" from prplpay prplpay ");
              buffer.append(" where prplpay.registno = r.registno ");
              buffer.append(" and prplpay.compensateno =  co.businessno  and prplpay.coinscode=co.coinscode ");
              buffer.append(" and prplpay.policyno = t.policyno ");
              buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
              buffer.append(" and prplpay.paytype = 'P3' ");
              
              /**
              if(paymentNo!=null&&!"".equals(paymentNo)){
              	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
              }
              */
              
              buffer.append(" ) as havPay,  ");//--已支付
              buffer.append(" 'C' as certitype,  ");
              buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
              buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason , ");
              buffer.append(" '0' as flowid ");
              buffer.append(" from prplcompensate t, prplclaim c, prplregist r ,prplcfeecoins co");
              /**
              buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
              buffer.append(" pay.exist    ");//--是否勾选
              
              buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
              buffer.append(" from prplpay ");
              buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
              buffer.append(" and pay.compensateno(+) = t.compensateno ");
              */
              buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
              buffer.append(" and c.registno = r.registno "); 
              if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
              	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
              }
              if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
              	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
              }
              buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
              if("mechanism".equals(casesType)){
            	  if("3477000000".equals(userComcode)){
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
            	  }else
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
            	 
              }else if("agnet".equals(casesType)){
            	  if("3477000000".equals(userComcode)){
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
            	  }else
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
              }
              buffer.append(" and r.classcode<>'05' ");
              //添加已支付完成的查询不出来条件
      		buffer.append(" and (select  co.coinssumpaid -nvl(sum(payamount),0) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where prplpay.registno = r.registno ");
              buffer.append(" and prplpay.compensateno = co.businessno  and prplpay.coinscode=co.coinscode ");
              buffer.append(" and prplpay.policyno = t.policyno ");
              buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
              buffer.append(" and prplpay.paytype = 'P3' ");
      		//buffer.append(" and payflag='1' ");
      	    buffer.append(" )<> 0  ");//--已支付
      	    //添加已支付完成的查询不出来条件
              buffer.append(conditions);
            
            /**
            if(registNos!=null&&registNos.size()>0){
        		buffer.append(" and r.registNo in ( ");
        		for(int i=0;i<registNos.size();i++){
        			if(i!=0)buffer.append(" , ");
        			buffer.append(" '"+registNos.get(i).trim()+"' ");
        		}
        		buffer.append(" ) ");
        	}
            
            //buffer.append(" and t.compensateno in ('理算书号') ");
            if(certiNos!=null&&certiNos.size()>0){
        		buffer.append(" and t.compensateno in ( ");
        		for(int i=0;i<certiNos.size();i++){
        			if(i!=0)buffer.append(" , ");
        			buffer.append(" '"+certiNos.get(i).trim()+"' ");
        		}
        		buffer.append(" ) ");
        	}
            buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//--？（默认添加）
            */
            
    		//--赔付费用
            buffer.append(" union all ");
            buffer.append(" select r.registno, ");
            buffer.append(" t.policyno, ");
    		buffer.append(" '' as policyType, ");
            buffer.append("  t.compensateno as certino, ");
            buffer.append(" c.claimNo, ");
            buffer.append(" r.insuredname, ");
            buffer.append(" r.licenseno, ");
            buffer.append(" ch.chargeamount as sumthispaid, ");
            //buffer.append(" t.underwriteenddate, ");
            buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
           // buffer.append(" '赔付费用' as payType, ");
           /* buffer.append(" case ch.chargecode ");
    	    buffer.append(" when '05' then '诉讼费' "); 
    	    buffer.append(" when '07' then '检验鉴定费' ");  
    	    buffer.append("  when '15' then '律师费'  ");
    	    buffer.append(" when '29' then '仲裁费'  ");
    	    buffer.append(" when '30' then '执行费'   ");
    	    buffer.append(" when '14' then '内部代查勘费'  ");
    	    buffer.append(" when '13' then '外部代查勘费'  "); 
    	    buffer.append(" when '04' then '机构查勘费'  ");
    	    buffer.append("  else '' end as paytype, ");*/
            buffer.append(" changechargecodetochargename(ch.chargecode) as paytype, ");
            buffer.append(" r.comcode, ");
            buffer.append(" '' as comcname, ");
            buffer.append(" (select sum(payamount) ");
            buffer.append(" from prplpay prplpay ");
           	buffer.append(" where prplpay.registno = r.registno ");
           	buffer.append(" and prplpay.compensateno = t.compensateno ");
           	buffer.append(" and prplpay.policyno = t.policyno ");
           	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
           	buffer.append("  and prplpay.paytype = 'P3' ");
           	
           	/**
            if(paymentNo!=null&&!"".equals(paymentNo)){
            	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
            }
            */
           	
            buffer.append(" ) as havPay , ");//--已支付
            buffer.append(" 'C' as certitype,  ");
            /*buffer.append(" case ch.chargecode  ");
    		buffer.append(" when '05' then  ");
    		buffer.append("  'P64'  ");
    		buffer.append(" when '07' then  ");
    		buffer.append("  'P61'  ");
    		buffer.append(" when '15' then  ");
    		buffer.append("  'P68'  ");
    		buffer.append(" when '29' then  ");
    		buffer.append("  'P611'  ");
    		buffer.append(" when '30' then  ");
    		buffer.append("  'P612'  ");
    		buffer.append(" when '14' then  ");
    		buffer.append("  'P65'  ");
    		buffer.append(" when '13' then  ");
    		buffer.append("  'P67'  ");
    		buffer.append(" when '04' then  ");
    		buffer.append("  'P62'  ");
    		buffer.append(" else  ");
    		buffer.append("  ''  ");
    		buffer.append("  end as payrefreason,  ");*/
          buffer.append("  changechargecodetopaymenttype(ch.chargecode) as payrefreason,  ");
    		buffer.append(" '0' as flowid ");
    		buffer.append(" from (select ph.compensateno, ph.chargecode,sum(nvl(ph.chargeamount,0)-nvl(ph.prechargeamount,0)-nvl(ph.sumrealpay,0)) as chargeamount ");
           	buffer.append("  from prplcharge ph, prplcompensate t where ph.compensateno = t.compensateno and ph.chargecode<>'14' and t.underwriteflag in ('0', '2', '1', '3', '9') ");
           	buffer.append(conditionsAdd);
           	buffer.append(" group by ph.compensateno, ph.chargecode) ch, ");
        	buffer.append("  prplcompensate t, prplclaim c, prplregist r  ");
         //	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r ,swflog g,swflogstore re ");
           	/**
           	buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
           	buffer.append(" pay.exist    ");//--是否勾选
           	buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
            buffer.append(" from prplpay ");
            buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
           	buffer.append(" and pay.compensateno(+) = t.compensateno ");
            */
           	
           	buffer.append(" where ch.compensateno = t.compensateno ");
           	buffer.append(" and t.claimno = c.claimno ");
           	buffer.append(" and c.registno = r.registno ");
           	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
           		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
           	}
           	if(payType != null&&!"".equals(payType)&&!"P3".equals(payType)){
           		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
           	}
           	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
           	if("mechanism".equals(casesType)){
           		if("3477000000".equals(userComcode)){
            		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
            	  }else
           	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
           	 
             }else if("agnet".equals(casesType)){
          	   if("3477000000".equals(userComcode)){
           		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
           	  }else
           	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
             }
           	buffer.append(" and r.classcode<>'05' ");
           	//添加已支付完成的查询不出来条件
    		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where prplpay.registno = r.registno ");
           	buffer.append(" and prplpay.compensateno = t.compensateno ");
           	buffer.append(" and prplpay.policyno = t.policyno ");
           	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
           	buffer.append(" and prplpay.paytype = 'P3' ");
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )<>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
           	buffer.append(conditions);
           	
           	/**
           	if(registNos!=null&&registNos.size()>0){
        		buffer.append(" and r.registNo in ( ");
        		for(int i=0;i<registNos.size();i++){
        			if(i!=0)buffer.append(" , ");
        			buffer.append(" '"+registNos.get(i).trim()+"' ");
        		}
        		buffer.append(" ) ");
        	}
          	if(certiNos!=null&&certiNos.size()>0){
        		buffer.append(" and t.compensateno in ( ");//需更改
        		for(int i=0;i<certiNos.size();i++){
        			if(i!=0)buffer.append(" , ");
        			buffer.append(" '"+certiNos.get(i).trim()+"' ");
        		}
        		buffer.append(" ) ");
        	}
          	buffer.append(" and r.comcode like '"+comCodeStr+"%' ");// --？（默认添加）
          	*/
        }	
          	//--预赔赔款
    		//buffer.append(" union all ");
        if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
    		buffer.append(" select r.registno, ");
    		buffer.append(" pre.policyno, ");
    		buffer.append(" '' as policyType, ");
    		buffer.append(" pre.precompensateno as certino, ");
    		buffer.append(" c.claimNo, ");
    		buffer.append(" r.insuredname, ");
    		buffer.append(" r.licenseno, ");
    		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
    		//buffer.append(" pre.underwriteenddate, ");
    		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
    		buffer.append(" '预赔赔款' as payType, ");
    		buffer.append(" r.comcode, ");
    		buffer.append(" '' as comcname, ");
    		buffer.append(" (select sum(payamount) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and paymenttype = 'P50' "); 
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    		
    		/**
    		if(paymentNo!=null&&!"".equals(paymentNo)){
    	    	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
    	    }
    	    */
    		
    	    buffer.append(" ) as havPay , ");//--已支付
    	    buffer.append(" 'Y' as certitype, ");
    	    buffer.append(" 'P50' as payrefreason, ");
    	    buffer.append(" '0' as flowid ");
    		buffer.append(" from prplprepay pre, prplclaim c, prplregist r  ");
    		/**
    		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
    		buffer.append(" pay.exist    ");//--是否勾选
    		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
            buffer.append(" from prplpay ");
            buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
    		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
            */
    		buffer.append(" where pre.claimno = c.claimno ");
    		buffer.append(" and c.registno = r.registno ");
    		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
    			buffer.append(" and 1<>1 ");
    		}
    		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
    		if(payType==null||"".equals(payType)){
    			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
    		}else{
    			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
    		}
    		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
    		if("mechanism".equals(casesType)){
    			if("3477000000".equals(userComcode)){
        		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
        	  }else
       	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
       	 
         }else if("agnet".equals(casesType)){
      	   if("3477000000".equals(userComcode)){
       		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
       	  }else
       	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
         }
    		buffer.append(" and r.classcode<>'05' ");
    		//添加已支付完成的查询不出来条件
    		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and paymenttype = 'P50' "); 
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )<>0  ");//--已支付
    	    //添加已支付完成的查询不出来条件
    		buffer.append(conditions);
    		
    		/**
    		if(registNos!=null&&registNos.size()>0){
        		buffer.append(" and r.registNo in ( ");
        		for(int i=0;i<registNos.size();i++){
        			if(i!=0)buffer.append(" , ");
        			buffer.append(" '"+registNos.get(i).trim()+"' ");
        		}
        		buffer.append(" ) ");
        	}
    		//buffer.append(" and pre.precompensateno in ('805073408002011000005') ");
    		if(certiNos!=null&&certiNos.size()>0){
        		buffer.append(" and pre.precompensateno in ( ");//需更改
        		for(int i=0;i<certiNos.size();i++){
        			if(i!=0)buffer.append(" , ");
        			buffer.append(" '"+certiNos.get(i).trim()+"' ");
        		}
        		buffer.append(" ) ");
        	}
    		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
    		*/
    		
    		
    		//--预赔费用
    		buffer.append(" union all ");
    		buffer.append(" select r.registno, ");
    		buffer.append(" pre.policyno, ");
    		buffer.append(" '' as policyType, ");
    		buffer.append(" pch.precompensateno as certino, ");
    		buffer.append(" c.claimNo, ");
    		buffer.append(" r.insuredname, ");
    		buffer.append(" r.licenseno, ");
    		buffer.append(" pch.sumprepaid as sumthispaid, ");
    		//buffer.append(" pre.underwriteenddate, ");
    		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
    		//buffer.append(" '预赔费用' as payType, ");
    		/*buffer.append(" case pch.chargecode  ");
    		buffer.append(" when '05' then '预付诉讼费'  ");
    	    buffer.append(" when '07' then '预付检验鉴定费'   ");
    	    buffer.append(" when '15' then '预付律师费'  ");
    	    buffer.append(" when '29' then '预付仲裁费'  ");
    	    buffer.append(" when '30' then '预付执行费'  "); 
    	    buffer.append(" when '14' then '预付内部代查勘费' "); 
    	    buffer.append(" when '13' then '预付外部代查勘费'  "); 
    	    buffer.append(" when '04' then '预付机构查勘费'  ");
    	    buffer.append(" else '' end as payType,");*/
    		buffer.append(" pchangechargecodetochargename(pch.chargecode) as payType,");
    		buffer.append(" r.comcode, ");
    		buffer.append(" '' as comcname, ");
    		buffer.append(" (select sum(payamount) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    	    buffer.append(" ) as havPay,  ");//--已支付
    	    buffer.append(" 'Y' as certitype, ");
    	    /*buffer.append(" case pch.chargecode  ");
    		buffer.append(" when '05' then  ");
    		buffer.append("  'Y64'  ");
    		buffer.append(" when '07' then  ");
    		buffer.append("  'Y61'  ");
    		buffer.append(" when '15' then  ");
    		buffer.append("  'Y68'  ");
    		buffer.append(" when '29' then  ");
    		buffer.append("  'Y611'  ");
    		buffer.append(" when '30' then  ");
    		buffer.append("  'Y612'  ");
    		buffer.append(" when '14' then  ");
    		buffer.append("  'Y65'  ");
    		buffer.append(" when '13' then  ");
    		buffer.append("  'Y67'  ");
    		buffer.append(" when '04' then  ");
    		buffer.append("  'Y62'  ");
    		buffer.append(" else  ");
    		buffer.append("  'Y69'  ");
    		buffer.append("  end as payrefreason,  ");*/
    	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason,  ");
    		buffer.append(" '0' as flowid ");
    		buffer.append(" from (select claimno,precompensateno,chargecode, ");
 		buffer.append(" sum(sumprepaid) as sumprepaid ");
 		buffer.append(" from prplprecharge ");
 		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
 		buffer.append("  prplprepay pre, prplclaim c, prplregist r  ");
    		//buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ,swflog g,swflogstore re ");
    		/**
    		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
    		buffer.append(" pay.exist    ");//--是否勾选
    		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
            buffer.append(" from prplpay ");
            buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
    		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
            */
    		buffer.append(" where pch.claimno = c.claimno ");
    		buffer.append(" and pch.precompensateno = pre.precompensateno ");
    		buffer.append(" and c.registno = r.registno ");
    		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
    			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
    		}
    		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
    		if(payType==null||"".equals(payType)){
    			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
    		}else{
    			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
    		}
    		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
    		if("mechanism".equals(casesType)){
    			if("3477000000".equals(userComcode)){
        		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
        	  }else
       	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
       	 
         }else if("agnet".equals(casesType)){
      	   if("3477000000".equals(userComcode)){
       		  buffer.append(" and r.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ");
       	  }else
       	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
         }
    		buffer.append(" and r.classcode<>'05' ");
    		//添加已支付完成的查询不出来条件
    		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
    		buffer.append(" from prplpay ");
    		buffer.append(" where registno = r.registno ");
    		buffer.append(" and compensateno = pre.precompensateno ");
    		buffer.append(" and policyno = pre.policyno ");
    		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
    		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
    		//buffer.append(" and payflag='1' ");
    	    buffer.append(" )<>0  ");//--已支付 
    	    //添加已支付完成的查询不出来条件
    		buffer.append(conditions);
    		/**
    		 * 
    		if(registNos!=null&&registNos.size()>0){
        		buffer.append(" and r.registNo in ( ");
        		for(int i=0;i<registNos.size();i++){
        			if(i!=0)buffer.append(" , ");
        			buffer.append(" '"+registNos.get(i).trim()+"' ");
        		}
        		buffer.append(" ) ");
        	}
    		//buffer.append(" and pre.precompensateno in ('预赔号码') ");
    		if(certiNos!=null&&certiNos.size()>0){
        		buffer.append(" and pre.precompensateno in ( ");//需更改
        		for(int i=0;i<certiNos.size();i++){
        			if(i!=0)buffer.append(" , ");
        			buffer.append(" '"+certiNos.get(i).trim()+"' ");
        		}
        		buffer.append(" ) ");
        	}
    		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
    		
    		*/
        }
    		buffer.append(" ) c ,prplclaim tt ");
    		buffer.append("  where  c.registno = tt.registno");
    		buffer.append(" and exists (select 1  ");
    		//buffer.append("          from prpjpayrefrec rec ");
    		buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
            buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
            buffer.append( "  Union All                                                                            ");
            buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
            buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
    		buffer.append("         where rec.certino = c.certino  ");
    		buffer.append("           and rec.certitype = c.certitype ");
    		buffer.append("           and rec.visaserialno like '9%' ");
    		buffer.append("           and rec.payrefreason = c.payrefreason ");
    		buffer.append("           and rec.payrefstate in ('00', '01') ");
    		buffer.append("           and rec.payrefdate is null) ");
    		buffer.append("	And Not Exists (Select 1 ");
   		buffer.append("          From Prplinterrelation Nn ");
   		buffer.append("         Where Nn.Relationregistno = C.Registno) ");
    		if(null!=type && "5".equals(type)){
    			buffer.append(" and exists ( select 1 ");
    			buffer.append("             from prplclaimbillmanager bill ");
    			buffer.append("             where bill.compensateno = c.certino ");
    			buffer.append("              and  bill.registno = c.registno ) ");
    		}
    		buffer.append(" ");
    		//添加区分新农险数据
    		buffer.append(" and (c.registno in (select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='regis')");
    		buffer.append(" or c.registno in (select registno from swflogstore where (systemflag is null or systemflag <> 'agri') and nodetype='regis'))");
    		
    		
    		if (pageNo > 0){
                //对Oracle优化
                if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                    buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                    buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                    //supportPaging=true;
                }
                else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                    String sql = buffer.toString();
                    buffer.setLength(0);
                    buffer.append("select * from ( select rownumber() over(");
                    int orderByIndex = sql.toLowerCase().indexOf("order by");
                    if ( orderByIndex>0 ) {
                       buffer.append( sql.substring(orderByIndex) );
                    }
                    buffer.append(") as rownumber_,");
                    buffer.append(sql.substring( 6 ));
                    buffer.append(" ) as temp_ where rownumber_");
                    buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                    //supportPaging=true;
                }
            }System.err.println(buffer.toString());
        	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        	System.err.print(buffer.toString());
        	PrpLpayShowDto prpLpayShowDto =null;
        	while(resultSet.next()){
        		prpLpayShowDto = new PrpLpayShowDto();
        		prpLpayShowDto.setRegistNo(dbManager.getString(resultSet,"registno"));
        		prpLpayShowDto.setPolicyNo(dbManager.getString(resultSet,"policyno"));
        		prpLpayShowDto.setDamageDate(dbManager.getDateTime(resultSet,"damageenddate").toString());
        		prpLpayShowDto.setStartDate(dbManager.getDateTime(resultSet,"startdate").toString());
        		prpLpayShowDto.setEndDate(dbManager.getDateTime(resultSet, "enddate").toString());
        		prpLpayShowDto.setInsuredName(dbManager.getString(resultSet,"insuredname"));
        		prpLpayShowDto.setComCode(dbManager.getString(resultSet,"comcode"));
        		prpLpayShowDto.setComCodeName(dbManager.getString(resultSet,"comcname"));
        		list.add(prpLpayShowDto);
        	}
        	resultSet.close();
        	return list;
        }
        /**
      	 * 支付信息查询列表显示方法
      	 * @param payType	支付类型
      	 * @param paymentType	赔款类型
      	 * @param comCode	机构号码
      	 * @return
      	 * @throws Exception
      	 */
          public int getNewQueryCountNew(String payType,String paymentType,String condition ,String casesType,String userComcode)throws Exception{
          	//String comCodeStr = comCode.substring(0, 6);
          	//String conditions="";
          	//String paymentNo="";
        	//将原条件和额外拼接的条件分开获取
        	String conditionsAdd = "";
          	String conditions = "";
          	if(null!=condition && !"".equals(condition) && condition.indexOf("ABCD")>0){
          		conditionsAdd = condition.substring(0,condition.indexOf("ABCD"));
          		conditions = condition.substring(condition.indexOf("ABCD")+4);
          	}else{
          		conditions = condition;
          	}
          	int count = -1;
          	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
          	StringBuffer buffer = new StringBuffer(200);
          	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
    		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
    		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
          	buffer.append("SELECT count(1) FROM ( ");
          	buffer.append(" select * ");
          	buffer.append(" from (  ");
          	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
          	//--赔款
          	buffer.append(" select r.registno, ");
          	buffer.append(" t.policyno, ");
//      		buffer.append(" (select case grp.policytype ");
//      		buffer.append(" when '1' then '商业险' ");
//      		buffer.append(" when '3' then '交强险' ");
//      		buffer.append(" else '' end ");
//      		buffer.append(" from prplregistrpolicy grp ");
//      		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
          	buffer.append(" t.compensateno as certino, ");
          	buffer.append(" c.claimNo, ");
          	buffer.append(" r.insuredname, ");
          	buffer.append(" r.licenseno, ");
      		buffer.append("  t.sumthispaid, ");
              //buffer.append("   t.underwriteenddate, ");
              buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
              buffer.append("  '赔款' as payType, ");
              buffer.append(" r.comcode, ");
              buffer.append(" '' as comcname, ");
          	buffer.append(" (select sum(payamount) ");
              buffer.append(" from prplpay prplpay ");
              buffer.append(" where prplpay.registno = r.registno ");
              buffer.append(" and prplpay.compensateno = t.compensateno ");
              buffer.append(" and prplpay.policyno = t.policyno ");
              buffer.append(" and prplpay.paymenttype = 'P60' ");
              buffer.append(" and prplpay.paytype = 'P3' ");
              
              buffer.append(" ) as havPay , ");//--已支付
              buffer.append(" 'C' as certitype,  ");
              buffer.append(" 'P60' as payrefreason  ");
              buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
              buffer.append(" where t.claimno = c.claimno ");
              buffer.append(" and c.registno = r.registno "); 
              if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
              	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
              }
              if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
              	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
              }
              buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
              buffer.append(" and r.classcode<>'05' ");
              if("mechanism".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
            	 
              }else if("agnet".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
              }
              //添加已支付完成的查询不出来条件
      		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where prplpay.registno = r.registno ");
              buffer.append(" and prplpay.compensateno = t.compensateno ");
              buffer.append(" and prplpay.policyno = t.policyno ");
              buffer.append(" and prplpay.paymenttype = 'P60' ");
              buffer.append(" and prplpay.paytype = 'P3' ");
      		//buffer.append(" and payflag='1' ");
      	    buffer.append(" )>0  ");//--已支付
      	    //添加已支付完成的查询不出来条件
              buffer.append(conditions);
              buffer.append(" and 5=5 ");
              
            //代付共保保费
              buffer.append(" union all ");
              buffer.append(" select r.registno, ");
            	buffer.append(" t.policyno, ");
//        		buffer.append(" (select case grp.policytype ");
//        		buffer.append(" when '1' then '商业险' ");
//        		buffer.append(" when '3' then '交强险' ");
//        		buffer.append(" else '' end ");
//        		buffer.append(" from prplregistrpolicy grp ");
//        		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
            	buffer.append("co.businessno as certino, ");
            	buffer.append(" c.claimNo, ");
            	buffer.append("  co.coinsname as insuredname, ");
            	buffer.append(" r.licenseno, ");
        		buffer.append("  co.coinssumpaid, ");
                //buffer.append("   t.underwriteenddate, ");
                buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
                buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
                buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
                buffer.append(" r.comcode, ");
                buffer.append(" '' as comcname, ");
            	buffer.append(" (select sum(payamount) ");
                buffer.append(" from prplpay prplpay ");
                buffer.append(" where prplpay.registno = r.registno ");
                buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
                buffer.append(" and prplpay.policyno = t.policyno ");
                buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
                buffer.append(" and prplpay.paytype = 'P3' ");
                
                buffer.append(" ) as havPay , ");//--已支付
                buffer.append(" 'C' as certitype,  ");
                buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
                buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason  ");
                buffer.append(" from prplcompensate t, prplclaim c, prplregist r,prplcfeecoins co ");
                buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
                buffer.append(" and c.registno = r.registno "); 
                if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
                	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
                }
                if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
                	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
                }
                buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
                buffer.append(" and r.classcode<>'05' ");
                if("mechanism".equals(casesType)){
              	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
              	 
                }else if("agnet".equals(casesType)){
              	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
                }
                //添加已支付完成的查询不出来条件
        		buffer.append(" and (select co.coinssumpaid-nvl(sum(payamount),0) ");
        		buffer.append(" from prplpay ");
        		buffer.append(" where prplpay.registno = r.registno ");
                buffer.append(" and prplpay.compensateno = co.businessno and prplpay.coinscode=co.coinscode ");
                buffer.append(" and prplpay.policyno = t.policyno ");
                buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
                buffer.append(" and prplpay.paytype = 'P3' ");
        		//buffer.append(" and payflag='1' ");
        	    buffer.append(" )>0  ");//--已支付
        	    //添加已支付完成的查询不出来条件
                buffer.append(conditions);
                buffer.append(" and 5=5 ");
              
      		//--赔付费用
              buffer.append(" union all ");
              buffer.append(" select r.registno, ");
              buffer.append(" t.policyno, ");
//      		buffer.append(" (select case grp.policytype ");
//      		buffer.append(" when '1' then '商业险' ");
//      		buffer.append(" when '3' then '交强险' ");
//      		buffer.append(" else '' end ");
//      		buffer.append(" from prplregistrpolicy grp ");
//      		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
              buffer.append("  t.compensateno as certino, ");
              buffer.append(" c.claimNo, ");
              buffer.append(" r.insuredname, ");
              buffer.append(" r.licenseno, ");
              buffer.append(" ch.chargeamount as sumthispaid, ");
              //buffer.append(" t.underwriteenddate, ");
              buffer.append("  round(trunc(sysdate ) - t.underwriteenddate) as underwriteenddate, ");
              buffer.append(" '赔付费用' as payType, ");
              buffer.append(" r.comcode, ");
              buffer.append(" '' as comcname, ");
              buffer.append(" (select sum(payamount) ");
              buffer.append(" from prplpay prplpay ");
             	buffer.append(" where prplpay.registno = r.registno ");
             	buffer.append(" and prplpay.compensateno = t.compensateno ");
             	buffer.append(" and prplpay.policyno = t.policyno ");
             	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
             	buffer.append("  and prplpay.paytype = 'P3' ");
             	
              buffer.append(" ) as havPay , ");	//--已支付
              buffer.append(" 'C' as certitype,  ");
             /* buffer.append(" case ch.chargecode  ");
      		buffer.append(" when '05' then  ");
      		buffer.append("  'P64'  ");
      		buffer.append(" when '07' then  ");
      		buffer.append("  'P61'  ");
      		buffer.append(" when '15' then  ");
      		buffer.append("  'P68'  ");
      		buffer.append(" when '29' then  ");
      		buffer.append("  'P611'  ");
      		buffer.append(" when '30' then  ");
      		buffer.append("  'P612'  ");
      		buffer.append(" when '14' then  ");
      		buffer.append("  'P65'  ");
      		buffer.append(" when '13' then  ");
      		buffer.append("  'P67'  ");
      		buffer.append(" when '04' then  ");
      		buffer.append("  'P62'  ");
      		buffer.append(" when '99' then  ");
      		buffer.append("  'P69'  ");
      		buffer.append(" else  ");
      		buffer.append("  ''  ");
      		buffer.append("  end as payrefreason  ");*/
            buffer.append("  changechargecodetopaymenttype(ch.chargecode) as payrefreason ");      
            buffer.append(" from (select ph.compensateno, ph.chargecode,sum(nvl(ph.chargeamount,0)-nvl(ph.prechargeamount,0)-nvl(ph.sumrealpay,0)) as chargeamount ");
           	buffer.append("  from prplcharge ph, prplcompensate t where ph.compensateno = t.compensateno and ph.chargecode<>'14' and t.underwriteflag in ('0', '2', '1', '3', '9') ");
           	buffer.append(conditionsAdd);
           	buffer.append(" group by ph.compensateno, ph.chargecode) ch, ");
           	buffer.append("  prplcompensate t, prplclaim c, prplregist r ");
            // 	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r ");
             	
             	buffer.append(" where ch.compensateno = t.compensateno ");
             	buffer.append(" and t.claimno = c.claimno ");
             	buffer.append(" and c.registno = r.registno ");
             	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
             		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
             	}
             	if(payType!=null&&!"".equals(payType)&&!"P3".equals(payType)){
             		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
             	}
             	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
             	buffer.append(" and r.classcode<>'05' ");
             	if("mechanism".equals(casesType)){
              	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
              	 
                }else if("agnet".equals(casesType)){
              	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
                }
             	//添加已支付完成的查询不出来条件
      		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where prplpay.registno = r.registno ");
             	buffer.append(" and prplpay.compensateno = t.compensateno ");
             	buffer.append(" and prplpay.policyno = t.policyno ");
             	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
             	buffer.append(" and prplpay.paytype = 'P3' ");
      		//buffer.append(" and payflag='1' ");
      	    buffer.append(" )>0  ");//--已支付
      	    //添加已支付完成的查询不出来条件
             	buffer.append(conditions);
          	}
          	if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
            	//--预赔赔款
      		//buffer.append(" union all ");
      		buffer.append(" select r.registno, ");
      		buffer.append(" pre.policyno, ");
//      		buffer.append(" (select case grp.policytype ");
//      		buffer.append(" when '1' then '商业险' ");
//      		buffer.append(" when '3' then '交强险' ");
//      		buffer.append(" else '' end ");
//      		buffer.append(" from prplregistrpolicy grp ");
//      		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
      		buffer.append(" pre.precompensateno as certino, ");
      		buffer.append(" c.claimNo, ");
      		buffer.append(" r.insuredname, ");
      		buffer.append(" r.licenseno, ");
      		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
      		//buffer.append(" pre.underwriteenddate, ");
      		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
      		buffer.append(" '预赔赔款' as payType, ");
      		buffer.append(" r.comcode, ");
      		buffer.append(" '' as comcname, ");
      		buffer.append(" (select sum(payamount) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where registno = r.registno ");
      		buffer.append(" and compensateno = pre.precompensateno ");
      		buffer.append(" and policyno = pre.policyno ");
      		buffer.append(" and paymenttype = 'P50' "); 
      		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
      		
      		
      		
      	    buffer.append(" ) as havPay , ");//--已支付
      	    buffer.append(" 'Y' as certitype,  ");
              buffer.append(" 'P50' as payrefreason  ");
      		buffer.append(" from prplprepay pre, prplclaim c, prplregist r ");
      		
      		buffer.append(" where pre.claimno = c.claimno ");
      		buffer.append(" and c.registno = r.registno ");
      		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
      			buffer.append(" and 1<>1 ");
      		}
      		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
      		if(payType!=null&&!"".equals(payType)){
      			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
      		}else{
      			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
      		}
      		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
      		buffer.append(" and r.classcode<>'05' ");
      		if("mechanism".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
            	 
              }else if("agnet".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
              }
      		//添加已支付完成的查询不出来条件
      		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where registno = r.registno ");
      		buffer.append(" and compensateno = pre.precompensateno ");
      		buffer.append(" and policyno = pre.policyno ");
      		buffer.append(" and paymenttype = 'P50' "); 
      		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
      		//buffer.append(" and payflag='1' ");
      	    buffer.append(" )>0  ");//--已支付
      	    //添加已支付完成的查询不出来条件
      		buffer.append(conditions);
      		
      		//--预赔费用
      		buffer.append(" union all ");
      		buffer.append(" select r.registno, ");
      		buffer.append(" pre.policyno, ");
//      		buffer.append(" (select case grp.policytype ");
//      		buffer.append(" when '1' then '商业险' ");
//      		buffer.append(" when '3' then '交强险' ");
//      		buffer.append(" else '' end ");
//      		buffer.append(" from prplregistrpolicy grp ");
//      		buffer.append(" where grp.policyno = r.policyno) as policyType, ");
      		buffer.append(" pch.precompensateno as certino, ");
      		buffer.append(" c.claimNo, ");
      		buffer.append(" r.insuredname, ");
      		buffer.append(" r.licenseno, ");
      		buffer.append(" pch.sumprepaid as sumthispaid, ");
      		//buffer.append(" pre.underwriteenddate, ");
      		buffer.append("  round(trunc(sysdate ) - pre.underwriteenddate) as underwriteenddate, ");
      		buffer.append(" '预赔费用' as payType, ");
      		
      		buffer.append(" r.comcode, ");
      		buffer.append(" '' as comcname, ");
      		buffer.append(" (select sum(payamount) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where registno = r.registno ");
      		buffer.append(" and compensateno = pre.precompensateno ");
      		buffer.append(" and policyno = pre.policyno ");
      		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
      		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
      		
      	    buffer.append(" ) as havPay , ");//--已支付
      	    buffer.append(" 'Y' as certitype,  ");
      	    /*buffer.append(" case pch.chargecode  ");
      		buffer.append(" when '05' then  ");
      		buffer.append("  'Y64'  ");
      		buffer.append(" when '07' then  ");
      		buffer.append("  'Y61'  ");
      		buffer.append(" when '15' then  ");
      		buffer.append("  'Y68'  ");
      		buffer.append(" when '29' then  ");
      		buffer.append("  'Y611'  ");
      		buffer.append(" when '30' then  ");
      		buffer.append("  'Y612'  ");
      		buffer.append(" when '14' then  ");
      		buffer.append("  'Y65'  ");
      		buffer.append(" when '13' then  ");
      		buffer.append("  'Y67'  ");
      		buffer.append(" when '04' then  ");
      		buffer.append("  'Y62'  ");
      		buffer.append(" else  ");
      		buffer.append("  'Y69'  ");
      		buffer.append("  end as payrefreason  ");*/
      	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason  "); 
      		buffer.append(" from (select claimno,precompensateno,chargecode, ");
    		buffer.append(" sum(sumprepaid) as sumprepaid ");
    		buffer.append(" from prplprecharge ");
    		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
    		buffer.append("  prplprepay pre, prplclaim c, prplregist r ");
      		//buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ");
      		
      		buffer.append(" where pch.claimno = c.claimno ");
      		buffer.append(" and pch.precompensateno = pre.precompensateno ");
      		buffer.append(" and c.registno = r.registno ");
      		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
      			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
      		}
      		if(payType!=null&&!"".equals(payType)){
      			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
      		}else{
      			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
      		}
      		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
      		buffer.append(" and r.classcode<>'05' ");
      		if("mechanism".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
            	 
              }else if("agnet".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
              }
      		//添加已支付完成的查询不出来条件
      		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
      		buffer.append(" from prplpay ");
      		buffer.append(" where registno = r.registno ");
      		buffer.append(" and compensateno = pre.precompensateno ");
      		buffer.append(" and policyno = pre.policyno ");
      		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
      		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
      		//buffer.append(" and payflag='1' ");
      	    buffer.append(" )>0  ");//--已支付
      	    //添加已支付完成的查询不出来条件
      		buffer.append(conditions);
          	}
      		
      		
      		buffer.append(" ) c  ");
      		buffer.append("  where  exists (select 1  ");
       		//buffer.append("          from prpjpayrefrec rec ");
      		buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
            buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
            buffer.append( "  Union All                                                                            ");
            buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
            buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
            buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
            buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
            buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
            buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
            buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
            buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
            buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
            buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
            buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
            buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
            buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
            buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
       		buffer.append("         where rec.certino = c.certino  ");
       		buffer.append("           and rec.certitype = c.certitype ");
       		buffer.append("           and rec.payrefreason = c.payrefreason ");
       		buffer.append("           and rec.payrefstate in ('00', '01') ");
       		buffer.append("           and rec.payrefdate is null) ");
//      		buffer.append("  where exists (select 1  ");
//      		buffer.append("  from prpjplanfee rf  ");
//      		buffer.append("  where c.certino = rf.certino  ");
//      		buffer.append("   and rf.certitype in ('C', 'Y')  ");
//      		//buffer.append("   and rf.payrefdate is null  ");
//      		buffer.append("   and rf.planfee > rf.realpayreffee  ");
//      		buffer.append("  and rf.planfee > 0)  ");
      		buffer.append("  )  ");
      		PayQueryConditionLogger.payQueryConditionData("getNewQueryCount——2方法：<br>"+buffer.toString());
          	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
              resultSet.next();
              count = dbManager.getInt(resultSet,1);
              resultSet.close();
              return count;
          }
          /**
         	 * 支付信息查询列表显示方法
         	 * @param payType	支付类型
         	 * @param paymentType	赔款类型
         	 * @param comCode	机构号码
         	 * @param registNos	报案号集合
         	 * @param certiNos	业务号集合
         	 * @return
         	 * @throws Exception
         	 */
             public ArrayList<PrpLpayShowDto> getNewQueryShowListNew(String payType,String paymentType,String condition,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
             	//String comCodeStr = comCode.substring(0, 6);
             	//String conditions="";
             	//String paymentNo="";
            	//将原条件和额外拼接的条件分开获取
            	String conditionsAdd = "";
             	String conditions = "";
             	if(null!=condition && !"".equals(condition) && condition.indexOf("ABCD")>0){
             		conditionsAdd = condition.substring(0,condition.indexOf("ABCD"));
             		conditions = condition.substring(condition.indexOf("ABCD")+4);
             	}else{
             		conditions = condition;
             	}
             	
          	DateTime billUpDate = new DateTime(AppConfig.get("sysconst.BILLUpDATE"),DateTime.YEAR_TO_DAY); 
             	ArrayList<PrpLpayShowDto> list = new ArrayList<PrpLpayShowDto>();
             	StringBuffer buffer = new StringBuffer(200);
             	UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
        		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
        		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
             	buffer.append(" select registno,Policyno,Policytype,Certino,Claimno,Insuredname,Licenseno,Sumthispaid,Underwriteenddate,Paytype,Comcode,(select cop.comcname from prpdcompany cop where cop.comcode = c.comcode) as Comcname,Havpay,Certitype,Payrefreason,Flowid,claimrelationno ");
             	buffer.append(" from (  ");
             	if(!"".equals(payType)&&payType != null&&"P3".equals(payType)){
             	//--赔款
             	buffer.append(" select r.registno, ");
             	buffer.append(" t.policyno, ");
         		buffer.append(" '' as policyType, ");
             	buffer.append(" t.compensateno as certino, ");
             	buffer.append(" c.claimNo, ");
             	buffer.append(" r.insuredname, ");
             	buffer.append(" r.licenseno, ");
         		buffer.append("  t.sumthispaid, ");
                 //buffer.append("   t.underwriteenddate, ");
                 buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
                 buffer.append("  '赔款' as payType, ");
                 buffer.append(" r.comcode, ");
                 buffer.append(" '' as comcname, ");
             	buffer.append(" (select sum(payamount) ");
                 buffer.append(" from prplpay prplpay ");
                 buffer.append(" where prplpay.registno = r.registno ");
                 buffer.append(" and prplpay.compensateno = t.compensateno ");
                 buffer.append(" and prplpay.policyno = t.policyno ");
                 buffer.append(" and prplpay.paymenttype = 'P60' ");
                 buffer.append(" and prplpay.paytype = 'P3' ");
                 
                 /**
                 if(paymentNo!=null&&!"".equals(paymentNo)){
                 	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
                 }
                 */
                 
                 buffer.append(" ) as havPay,  ");//--已支付
                 buffer.append(" 'C' as certitype,  ");
                 buffer.append(" 'P60' as payrefreason,  ");
                 buffer.append(" '0' as flowid, ");
                 buffer.append(" case when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='31' then ");
                 buffer.append(" t.claimrelationno ");
                 buffer.append(" when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='32' then  ");
                 buffer.append(" (select distinct aa.compensateno from prplclaimbillmanager aa where aa.compensateno=t.compensateno) ");
                 buffer.append(" else ");
                 buffer.append(" '' ");
                 buffer.append(" end as claimrelationno ");
                 buffer.append(" from prplcompensate t, prplclaim c, prplregist r ");
                 /**
                 buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
                 buffer.append(" pay.exist    ");//--是否勾选
                 
                 buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
                 buffer.append(" from prplpay ");
                 buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
                 buffer.append(" and pay.compensateno(+) = t.compensateno ");
                 */
                 buffer.append(" where t.claimno = c.claimno ");
                 buffer.append(" and c.registno = r.registno "); 
                 if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
                 	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
                 }
                 if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
                 	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
                 }
                 buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
                 if("mechanism".equals(casesType)){
               	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
               	 
                 }else if("agnet".equals(casesType)){
               	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
                 }
                 buffer.append(" and r.classcode<>'05' ");
                 //添加已支付完成的查询不出来条件
         		buffer.append(" and (select t.sumthispaid-nvl(sum(payamount),0) ");
         		buffer.append(" from prplpay ");
         		buffer.append(" where prplpay.registno = r.registno ");
                 buffer.append(" and prplpay.compensateno = t.compensateno ");
                 buffer.append(" and prplpay.policyno = t.policyno ");
                 buffer.append(" and prplpay.paymenttype = 'P60' ");
                 buffer.append(" and prplpay.paytype = 'P3' ");
         		//buffer.append(" and payflag='1' ");
         	    buffer.append(" )<> 0  ");//--已支付
         	    //添加已支付完成的查询不出来条件
                 buffer.append(conditions);
                 /**
                 if(registNos!=null&&registNos.size()>0){
             		buffer.append(" and r.registNo in ( ");
             		for(int i=0;i<registNos.size();i++){
             			if(i!=0)buffer.append(" , ");
             			buffer.append(" '"+registNos.get(i).trim()+"' ");
             		}
             		buffer.append(" ) ");
             	}
                 
                 //buffer.append(" and t.compensateno in ('理算书号') ");
                 if(certiNos!=null&&certiNos.size()>0){
             		buffer.append(" and t.compensateno in ( ");
             		for(int i=0;i<certiNos.size();i++){
             			if(i!=0)buffer.append(" , ");
             			buffer.append(" '"+certiNos.get(i).trim()+"' ");
             		}
             		buffer.append(" ) ");
             	}
                 buffer.append(" and r.comcode like '"+comCodeStr+"%'  ");//--？（默认添加）
                 */
         	buffer.append(" and 3=3 ");   
         		//--赔付费用
                 buffer.append(" union all ");
                 buffer.append(" select r.registno, ");
                 buffer.append(" t.policyno, ");
         		buffer.append(" '' as policyType, ");
                 buffer.append("  t.compensateno as certino, ");
                 buffer.append(" c.claimNo, ");
                 buffer.append(" r.insuredname, ");
                 buffer.append(" r.licenseno, ");
                 buffer.append(" ch.chargeamount as sumthispaid, ");
                 //buffer.append(" t.underwriteenddate, ");
                 buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
                // buffer.append(" '赔付费用' as payType, ");
                 /*buffer.append(" case ch.chargecode ");
         	    buffer.append(" when '05' then '诉讼费' "); 
         	    buffer.append(" when '07' then '检验鉴定费' ");  
         	    buffer.append("  when '15' then '律师费'  ");
         	    buffer.append(" when '29' then '仲裁费'  ");
         	    buffer.append(" when '30' then '执行费'   ");
         	    buffer.append(" when '14' then '内部代查勘费'  ");
         	    buffer.append(" when '13' then '外部代查勘费'  "); 
         	    buffer.append(" when '04' then '机构查勘费'  ");
         	    buffer.append("  else '' end as paytype, ");*/
                 buffer.append("  changechargecodetochargename(ch.chargecode) as paytype, ");
                 buffer.append(" r.comcode, ");
                 buffer.append(" '' as comcname, ");
                 buffer.append(" (select sum(payamount) ");
                 buffer.append(" from prplpay prplpay ");
                	buffer.append(" where prplpay.registno = r.registno ");
                	buffer.append(" and prplpay.compensateno = t.compensateno ");
                	buffer.append(" and prplpay.policyno = t.policyno ");
                	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
                	buffer.append("  and prplpay.paytype = 'P3' ");
                	
                	/**
                 if(paymentNo!=null&&!"".equals(paymentNo)){
                 	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
                 }
                 */
                	
                 buffer.append(" ) as havPay , ");//--已支付
                 buffer.append(" 'C' as certitype,  ");
                 /*buffer.append(" case ch.chargecode  ");
         		buffer.append(" when '05' then  ");
         		buffer.append("  'P64'  ");
         		buffer.append(" when '07' then  ");
         		buffer.append("  'P61'  ");
         		buffer.append(" when '15' then  ");
         		buffer.append("  'P68'  ");
         		buffer.append(" when '29' then  ");
         		buffer.append("  'P611'  ");
         		buffer.append(" when '30' then  ");
         		buffer.append("  'P612'  ");
         		buffer.append(" when '14' then  ");
         		buffer.append("  'P65'  ");
         		buffer.append(" when '13' then  ");
         		buffer.append("  'P67'  ");
         		buffer.append(" when '04' then  ");
         		buffer.append("  'P62'  ");
         		buffer.append(" else  ");
         		buffer.append("  ''  ");
         		buffer.append("  end as payrefreason,  ");*/
              buffer.append("  changechargecodetopaymenttype(Ch.Chargecode) as payrefreason,  ");
         		buffer.append(" '0' as flowid, ");
         		buffer.append(" '' as claimrelationno ");
         		buffer.append(" from (select ph.compensateno, ph.chargecode,sum(nvl(ph.chargeamount,0)-nvl(ph.prechargeamount,0)-nvl(ph.sumrealpay,0)) as chargeamount ");
               	buffer.append("  from prplcharge ph, prplcompensate t where ph.compensateno = t.compensateno and ph.chargecode<>'14' and t.underwriteflag in ('0', '2', '1', '3', '9') ");
               	buffer.append(conditionsAdd);
               	buffer.append(" group by ph.compensateno, ph.chargecode) ch, ");
             	buffer.append("  prplcompensate t, prplclaim c, prplregist r  ");
              //	buffer.append(" from prplcharge ch, prplcompensate t, prplclaim c, prplregist r ,swflog g,swflogstore re ");
                	/**
                	buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
                	buffer.append(" pay.exist    ");//--是否勾选
                	buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
                 buffer.append(" from prplpay ");
                 buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
                	buffer.append(" and pay.compensateno(+) = t.compensateno ");
                 */
                	
                	buffer.append(" where ch.compensateno = t.compensateno ");
                	buffer.append(" and t.claimno = c.claimno ");
                	buffer.append(" and c.registno = r.registno ");
                	if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
                		buffer.append(" and ch.chargecode = changepaymenttypetochargecode('"+paymentType+"') ");
                	}
                	if(payType != null&&!"".equals(payType)&&!"P3".equals(payType)){
                		buffer.append(" and  1<>1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
                	}
                	buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
                	if("mechanism".equals(casesType)){
                	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
                	 
                  }else if("agnet".equals(casesType)){
                	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
                  }
                	buffer.append(" and r.classcode<>'05' ");
                	//添加已支付完成的查询不出来条件
         		buffer.append(" and (select ch.chargeamount-nvl(sum(payamount),0) ");
         		buffer.append(" from prplpay ");
         		buffer.append(" where prplpay.registno = r.registno ");
                	buffer.append(" and prplpay.compensateno = t.compensateno ");
                	buffer.append(" and prplpay.policyno = t.policyno ");
                	buffer.append(" and changepaymenttypetochargecode(prplpay.paymenttype) = ch.chargecode  ");//--费用类型
                	buffer.append(" and prplpay.paytype = 'P3' ");
         		//buffer.append(" and payflag='1' ");
         	    buffer.append(" )<>0  ");//--已支付
         	    //添加已支付完成的查询不出来条件
                	buffer.append(conditions);
                	
                	
                	//代付共保赔款
                    buffer.append(" union all ");
                	buffer.append(" select r.registno, ");
                   	buffer.append(" t.policyno, ");
                		buffer.append(" '' as policyType, ");
                   	buffer.append(" co.businessno as certino, ");
                   	buffer.append(" c.claimNo, ");
                   	buffer.append(" co.coinsname AS Insuredname, ");
                   	buffer.append(" r.licenseno, ");
                		buffer.append("  co.coinssumpaid, ");
                       //buffer.append("   t.underwriteenddate, ");
                       buffer.append("  round(trunc(sysdate ) - trunc(t.underwriteenddate)) as underwriteenddate, ");
                       buffer.append("  decode(changechargecodetochargenamegt(co.chargecode),'','代付共保赔款', ");
                       buffer.append(" changechargecodetochargenamegt(co.chargecode)) as payType, ");
                       buffer.append(" r.comcode, ");
                       buffer.append(" '' as comcname, ");
                   	buffer.append(" (select sum(payamount) ");
                       buffer.append(" from prplpay prplpay ");
                       buffer.append(" where prplpay.registno = r.registno ");
                       buffer.append(" and prplpay.compensateno =co.businessno  and prplpay.coinscode=co.coinscode ");
                       buffer.append(" and prplpay.policyno = t.policyno ");
                       buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C'))");
                       buffer.append(" and prplpay.paytype = 'P3' ");
                       
                       /**
                       if(paymentNo!=null&&!"".equals(paymentNo)){
                       	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
                       }
                       */
                       
                       buffer.append(" ) as havPay,  ");//--已支付
                       buffer.append(" 'C' as certitype,  ");
                       buffer.append(" decode(chanchargecodetopaymenttypegt(co.Chargecode),'','GS60', ");
                       buffer.append(" chanchargecodetopaymenttypegt(co.Chargecode)) as payrefreason , ");
                       buffer.append(" '0' as flowid, ");
                       buffer.append(" case when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='31' then ");
                       buffer.append(" t.claimrelationno ");
                       buffer.append(" when to_char(t.underwriteenddate,'yyyy-mm-dd')>'"+billUpDate+"' and t.classcode='32' then  ");
                       buffer.append(" (select distinct aa.compensateno from prplclaimbillmanager aa where aa.compensateno=t.compensateno) ");
                       buffer.append(" else ");
                       buffer.append(" '' ");
                       buffer.append(" end as claimrelationno ");
                       buffer.append(" from prplcompensate t, prplclaim c, prplregist r ,prplcfeecoins co");
                       /**
                       buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
                       buffer.append(" pay.exist    ");//--是否勾选
                       
                       buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
                       buffer.append(" from prplpay ");
                       buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
                       buffer.append(" and pay.compensateno(+) = t.compensateno ");
                       */
                       buffer.append(" where t.claimno = c.claimno and t.compensateno = co.businessno ");
                       buffer.append(" and c.registno = r.registno "); 
                       if(!"".equals(payType)&&payType != null&&!"P3".equals(payType)){
                       	buffer.append("  and  1<>1 ");//赔款类型只有赔款，当勾选的不是赔款时，直接拼接 and 1 <> 1
                       }
                       if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P60".equals(paymentType)){//为空表示赔款费用都查询出来
                       	buffer.append(" and  1<> 1 ");//支付类型只有赔付，当勾选不是赔付时，直接拼接 and 1 <> 1
                       }
                       buffer.append(" and t.underwriteflag in ('0', '2', '1', '3', '9') ");
                       if("mechanism".equals(casesType)){
                     	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
                     	 
                       }else if("agnet".equals(casesType)){
                     	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
                       }
                       buffer.append(" and r.classcode<>'05' ");
                       //添加已支付完成的查询不出来条件
                		buffer.append(" and (select co.coinssumpaid-nvl(sum(payamount),0) ");
                		buffer.append(" from prplpay ");
                		buffer.append(" where prplpay.registno = r.registno ");
                       buffer.append(" and prplpay.compensateno = co.businessno  and prplpay.coinscode=co.coinscode ");
                       buffer.append(" and prplpay.policyno = t.policyno ");
                       buffer.append(" and (chanpaymenttypetochargecodegt(prplpay.paymenttype) = co.chargecode Or (Prplpay.Paymenttype = 'GS60' And Co.Chargecode Is Null And co.lossfeetype='C')) ");
                       buffer.append(" and prplpay.paytype = 'P3' ");
                		//buffer.append(" and payflag='1' ");
                	    buffer.append(" )<> 0  ");//--已支付
                	    //添加已支付完成的查询不出来条件
                       buffer.append(conditions);
                	
                	/**
                	if(registNos!=null&&registNos.size()>0){
             		buffer.append(" and r.registNo in ( ");
             		for(int i=0;i<registNos.size();i++){
             			if(i!=0)buffer.append(" , ");
             			buffer.append(" '"+registNos.get(i).trim()+"' ");
             		}
             		buffer.append(" ) ");
             	}
               	if(certiNos!=null&&certiNos.size()>0){
             		buffer.append(" and t.compensateno in ( ");//需更改
             		for(int i=0;i<certiNos.size();i++){
             			if(i!=0)buffer.append(" , ");
             			buffer.append(" '"+certiNos.get(i).trim()+"' ");
             		}
             		buffer.append(" ) ");
             	}
               	buffer.append(" and r.comcode like '"+comCodeStr+"%' ");// --？（默认添加）
               	*/
             	}
               	//--预赔赔款
         		//buffer.append(" union all ");
             	if(!"".equals(payType)&&payType != null&&("P1".equals(payType)||"P2".equals(payType)||"P4".equals(payType))){
         		buffer.append(" select r.registno, ");
         		buffer.append(" pre.policyno, ");
         		buffer.append(" '' as policyType, ");
         		buffer.append(" pre.precompensateno as certino, ");
         		buffer.append(" c.claimNo, ");
         		buffer.append(" r.insuredname, ");
         		buffer.append(" r.licenseno, ");
         		buffer.append(" pre.SUMPREPAID as sumthispaid, ");// --总支付金额
         		//buffer.append(" pre.underwriteenddate, ");
         		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
         		buffer.append(" '预赔赔款' as payType, ");
         		buffer.append(" r.comcode, ");
         		buffer.append(" '' as comcname, ");
         		buffer.append(" (select sum(payamount) ");
         		buffer.append(" from prplpay ");
         		buffer.append(" where registno = r.registno ");
         		buffer.append(" and compensateno = pre.precompensateno ");
         		buffer.append(" and policyno = pre.policyno ");
         		buffer.append(" and paymenttype = 'P50' "); 
         		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
         		
         		/**
         		if(paymentNo!=null&&!"".equals(paymentNo)){
         	    	buffer.append(" and prplpay.serialno <> '"+paymentNo+"' ");
         	    }
         	    */
         		
         	    buffer.append(" ) as havPay , ");//--已支付
         	    buffer.append(" 'Y' as certitype, ");
         	    buffer.append(" 'P50' as payrefreason, ");
         	    buffer.append(" '0' as flowid, ");
         	    buffer.append(" '' as claimrelationno ");
         		buffer.append(" from prplprepay pre, prplclaim c, prplregist r  ");
         		/**
         		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
         		buffer.append(" pay.exist    ");//--是否勾选
         		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
                 buffer.append(" from prplpay ");
                 buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
         		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
                 */
         		buffer.append(" where pre.claimno = c.claimno ");
         		buffer.append(" and c.registno = r.registno ");
         		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)&&!"P50".equals(paymentType)){//为空表示赔款费用都查询出来
         			buffer.append(" and 1<>1 ");
         		}
         		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
         		if(payType==null||"".equals(payType)){
         			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
         		}else{
         			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
         		}
         		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
         		if("mechanism".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
            	 
              }else if("agnet".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
              }
         		buffer.append(" and r.classcode<>'05' ");
         		//添加已支付完成的查询不出来条件
         		buffer.append(" and (select pre.sumprepaid-nvl(sum(payamount),0) ");
         		buffer.append(" from prplpay ");
         		buffer.append(" where registno = r.registno ");
         		buffer.append(" and compensateno = pre.precompensateno ");
         		buffer.append(" and policyno = pre.policyno ");
         		buffer.append(" and paymenttype = 'P50' "); 
         		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
         		//buffer.append(" and payflag='1' ");
         	    buffer.append(" )<>0  ");//--已支付
         	    //添加已支付完成的查询不出来条件
         		buffer.append(conditions);
         		
         		/**
         		if(registNos!=null&&registNos.size()>0){
             		buffer.append(" and r.registNo in ( ");
             		for(int i=0;i<registNos.size();i++){
             			if(i!=0)buffer.append(" , ");
             			buffer.append(" '"+registNos.get(i).trim()+"' ");
             		}
             		buffer.append(" ) ");
             	}
         		//buffer.append(" and pre.precompensateno in ('805073408002011000005') ");
         		if(certiNos!=null&&certiNos.size()>0){
             		buffer.append(" and pre.precompensateno in ( ");//需更改
             		for(int i=0;i<certiNos.size();i++){
             			if(i!=0)buffer.append(" , ");
             			buffer.append(" '"+certiNos.get(i).trim()+"' ");
             		}
             		buffer.append(" ) ");
             	}
         		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
         		*/
         		
         		
         		//--预赔费用
         		buffer.append(" union all ");
         		buffer.append(" select r.registno, ");
         		buffer.append(" pre.policyno, ");
         		buffer.append(" '' as policyType, ");
         		buffer.append(" pch.precompensateno as certino, ");
         		buffer.append(" c.claimNo, ");
         		buffer.append(" r.insuredname, ");
         		buffer.append(" r.licenseno, ");
         		buffer.append(" pch.sumprepaid as sumthispaid, ");
         		//buffer.append(" pre.underwriteenddate, ");
         		buffer.append("  round(trunc(sysdate ) - trunc(pre.underwriteenddate)) as underwriteenddate, ");
         		//buffer.append(" '预赔费用' as payType, ");
         		/*buffer.append(" case pch.chargecode  ");
         		buffer.append(" when '05' then '预付诉讼费'  ");
         	    buffer.append(" when '07' then '预付检验鉴定费'   ");
         	    buffer.append(" when '15' then '预付律师费'  ");
         	    buffer.append(" when '29' then '预付仲裁费'  ");
         	    buffer.append(" when '30' then '预付执行费'  "); 
         	    buffer.append(" when '14' then '预付内部代查勘费' "); 
         	    buffer.append(" when '13' then '预付外部代查勘费'  "); 
         	    buffer.append(" when '04' then '预付机构查勘费'  ");
         	    buffer.append(" else '' end as payType,");*/
         		buffer.append(" pchangechargecodetochargename(pch.chargecode) as payType,");
         		buffer.append(" r.comcode, ");
         		buffer.append(" '' as comcname, ");
         		buffer.append(" (select sum(payamount) ");
         		buffer.append(" from prplpay ");
         		buffer.append(" where registno = r.registno ");
         		buffer.append(" and compensateno = pre.precompensateno ");
         		buffer.append(" and policyno = pre.policyno ");
         		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
         		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
         	    buffer.append(" ) as havPay,  ");//--已支付
         	    buffer.append(" 'Y' as certitype, ");
         	    /*buffer.append(" case pch.chargecode  ");
         		buffer.append(" when '05' then  ");
         		buffer.append("  'Y64'  ");
         		buffer.append(" when '07' then  ");
         		buffer.append("  'Y61'  ");
         		buffer.append(" when '15' then  ");
         		buffer.append("  'Y68'  ");
         		buffer.append(" when '29' then  ");
         		buffer.append("  'Y611'  ");
         		buffer.append(" when '30' then  ");
         		buffer.append("  'Y612'  ");
         		buffer.append(" when '14' then  ");
         		buffer.append("  'Y65'  ");
         		buffer.append(" when '13' then  ");
         		buffer.append("  'Y67'  ");
         		buffer.append(" when '04' then  ");
         		buffer.append("  'Y62'  ");
         		buffer.append(" else  ");
         		buffer.append("  'Y69'  ");
         		buffer.append("  end as payrefreason,  ");*/
         	    buffer.append("  pchangechargecodetopaymenttype(pch.chargecode) as payrefreason,  ");
         		buffer.append(" '0' as flowid, ");
         		buffer.append(" '' as claimrelationno ");
         		buffer.append(" from (select claimno,precompensateno,chargecode, ");
      		buffer.append(" sum(sumprepaid) as sumprepaid ");
      		buffer.append(" from prplprecharge ");
      		buffer.append(" group by claimno, precompensateno, chargecode) pch, ");
      		buffer.append("  prplprepay pre, prplclaim c, prplregist r  ");
         		//buffer.append(" from prplprecharge pch, prplprepay pre, prplclaim c, prplregist r ,swflog g,swflogstore re ");
         		/**
         		buffer.append(" ,pay.payamount as nowPay,  ");//--本次支付金额
         		buffer.append(" pay.exist    ");//--是否勾选
         		buffer.append(" ,(select distinct payamount, compensateno, '1' as exist ");
                 buffer.append(" from prplpay ");
                 buffer.append(" where serialno = '"+paymentNo+"' ) pay ");
         		buffer.append(" and pay.compensateno(+) = pre.precompensateno ");
                 */
         		buffer.append(" where pch.claimno = c.claimno ");
         		buffer.append(" and pch.precompensateno = pre.precompensateno ");
         		buffer.append(" and c.registno = r.registno ");
         		if(paymentType!=null&&!"".equals(paymentType)&&!"P6".equals(paymentType)){
         			buffer.append(" and pch.chargecode = pchangepaymenttypetochargecode('"+paymentType+"') ");
         		}
         		//buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
         		if(payType==null||"".equals(payType)){
         			buffer.append(" and pre.casetype in ('5','7','8') ");// --支付类型
         		}else{
         			buffer.append(" and pre.casetype = changepaytypetocasetype('"+payType+"') ");// --支付类型
         		}
         		buffer.append(" and pre.underwriteflag in ('0', '2', '1', '3', '9') ");
         		if("mechanism".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') ");
            	 
              }else if("agnet".equals(casesType)){
            	  buffer.append(" and r.comcode  in (select comcode from prpdcompany connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComcode+"') "); 
              }
         		buffer.append(" and r.classcode<>'05' ");
         		//添加已支付完成的查询不出来条件
         		buffer.append(" and (select pch.sumprepaid-nvl(sum(payamount),0) ");
         		buffer.append(" from prplpay ");
         		buffer.append(" where registno = r.registno ");
         		buffer.append(" and compensateno = pre.precompensateno ");
         		buffer.append(" and policyno = pre.policyno ");
         		buffer.append(" and pchangepaymenttypetochargecode(paymenttype) = pch.chargecode ");
         		buffer.append(" and changepaytypetocasetype(paytype) = pre.casetype ");//--支付类型
         		//buffer.append(" and payflag='1' ");
         	    buffer.append(" )<>0  ");//--已支付 
         	    //添加已支付完成的查询不出来条件
         		buffer.append(conditions);
         		/**
         		 * 
         		if(registNos!=null&&registNos.size()>0){
             		buffer.append(" and r.registNo in ( ");
             		for(int i=0;i<registNos.size();i++){
             			if(i!=0)buffer.append(" , ");
             			buffer.append(" '"+registNos.get(i).trim()+"' ");
             		}
             		buffer.append(" ) ");
             	}
         		//buffer.append(" and pre.precompensateno in ('预赔号码') ");
         		if(certiNos!=null&&certiNos.size()>0){
             		buffer.append(" and pre.precompensateno in ( ");//需更改
             		for(int i=0;i<certiNos.size();i++){
             			if(i!=0)buffer.append(" , ");
             			buffer.append(" '"+certiNos.get(i).trim()+"' ");
             		}
             		buffer.append(" ) ");
             	}
         		buffer.append(" and r.comcode like '"+comCodeStr+"%' ");
         		
         		*/
             	}
         		buffer.append(" ) c  ");
         		buffer.append("  where  exists (select 1  ");
         		//buffer.append("          from prpjpayrefrec rec ");
         		buffer.append( "  from (Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,   ");          
                buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
                buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
                buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
                buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
                buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
                buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
                buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
                buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
                buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
                buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
                buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
                buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefreccoins                        ");
                buffer.append( "   Where Certitype = 'C' And Payrefreason in("+utiPlatConfigRuleDto.getRule()+")       ");
                buffer.append( "  Union All                                                                            ");
                buffer.append( "  Select Certitype,Certino,Policyno,Serialno,Payrefreason,Payreftimes,Claimno,         ");
                buffer.append( "  Classcode,Riskcode,Contractno,Applicode,Appliname,Insuredcode,Insuredname,           ");
                buffer.append( "  Startdate,Enddate,Validdate,Payno,Currency1,Planfee,Plandate,Comcode,                ");
                buffer.append( "  Makecom,Agentcode,Handler1code,Handlercode,Underwritedate,Coinsflag,                 ");
                buffer.append( "  Coinscode,Coinsname,Coinstype,Operatedate,Operatorcode,Operateunit,                  ");
                buffer.append( "  Currency2,Exchangerate,Payreffee,Visacode,Visaname,Visaserialno,Printdate,           ");
                buffer.append( "  Printercode,Visahandler,Payrefname,Identifytype,Identifynumber,Remark,               ");
                buffer.append( "  Payrefno,Payrefdate,Flag,Businessnature,Othflag,Taxfee,Carnaturecode,                ");
                buffer.append( "  Usenaturecode,Carproperty,Centercode,Branchcode,Accbooktype,Accbookcode,             ");
                buffer.append( "  Yearmonth,Voucherno,Paycomcode,Businesstype,Businesstype1,Businessfee,               ");
                buffer.append( "  Personalfee,Constructionfee,Educationfee,Paycommissionflag,Payrefstate,              ");
                buffer.append( "  Recoveryserialno,Handlepayrefdate,Update_By,Update_Date,Vatax,                       ");
                buffer.append( "  Ntplanfee,Dutyratio,Localeducationfee From Prpjpayrefrec                             ");
                buffer.append( "   Where Certitype In ('C', 'Y', 'Z'))           rec                                   ");
         		buffer.append("         where rec.certino = c.certino  ");
         		buffer.append("           and rec.certitype = c.certitype ");
         		buffer.append("           and rec.visaserialno like '9%' ");
         		buffer.append("           and rec.payrefreason = c.payrefreason ");
         		buffer.append("           and rec.payrefstate in ('00', '01') ");
         		buffer.append("           and rec.payrefdate is null) ");
         		buffer.append(" order by underwriteenddate ");
         		if (pageNo > 0){
                     //对Oracle优化
                     if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                         buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                         buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                         //supportPaging=true;
                     }
                     else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                         String sql = buffer.toString();
                         buffer.setLength(0);
                         buffer.append("select * from ( select rownumber() over(");
                         int orderByIndex = sql.toLowerCase().indexOf("order by");
                         if ( orderByIndex>0 ) {
                            buffer.append( sql.substring(orderByIndex) );
                         }
                         buffer.append(") as rownumber_,");
                         buffer.append(sql.substring( 6 ));
                         buffer.append(" ) as temp_ where rownumber_");
                         buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                         //supportPaging=true;
                     }
                 }System.err.println(buffer.toString());
         		PayQueryConditionLogger.payQueryConditionData("getNewQueryShowList——2方法：<br>"+buffer.toString());
             	ResultSet resultSet = dbManager.executeQuery(buffer.toString());
             	PrpLpayShowDto prpLpayShowDto =null;
             	while(resultSet.next()){
             		prpLpayShowDto = new PrpLpayShowDto();
             		prpLpayShowDto.setRegistNo(dbManager.getString(resultSet,"RegistNo"));
             		prpLpayShowDto.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
             		prpLpayShowDto.setPolicyType(dbManager.getString(resultSet,"PolicyType"));
             		prpLpayShowDto.setCertiNo(dbManager.getString(resultSet,"CertiNo"));
             		prpLpayShowDto.setClaimNo(dbManager.getString(resultSet,"ClaimNo"));
             		prpLpayShowDto.setInsuredName(dbManager.getString(resultSet,"InsuredName"));
             		prpLpayShowDto.setLicenseNo(dbManager.getString(resultSet,"LicenseNo"));
             		prpLpayShowDto.setSumPaid(dbManager.getDouble(resultSet,"sumthispaid"));
             		prpLpayShowDto.setUnderWriteEndDate(dbManager.getString(resultSet,"UnderWriteEndDate"));
             		prpLpayShowDto.setPayType(dbManager.getString(resultSet,"PayType"));
             		prpLpayShowDto.setComCode(dbManager.getString(resultSet,"ComCode"));
             		prpLpayShowDto.setComCodeName(dbManager.getString(resultSet,"ComCName"));
             		prpLpayShowDto.setHavPaid(dbManager.getDouble(resultSet,"HavPay"));
             		prpLpayShowDto.setFlowId(dbManager.getString(resultSet, "flowid"));
             		prpLpayShowDto.setPayrefreason(dbManager.getString(resultSet, "payrefreason"));
             		prpLpayShowDto.setRiskCode(dbManager.getString(resultSet,"CertiNo"));
             		prpLpayShowDto.setClassCode(dbManager.getString(resultSet,"CertiNo"));
             		prpLpayShowDto.setClaimRelationNo(dbManager.getString(resultSet,"claimrelationno"));
             		//prpLpayShowDto.setNowPaid(dbManager.getDouble(resultSet,"NowPay"));
             		//prpLpayShowDto.setExist(dbManager.getString(resultSet,"Exist"));
             		list.add(prpLpayShowDto);
             	}
             	resultSet.close();
             	return list;
             }
      /**************************优化修改：end*********************************/
}
