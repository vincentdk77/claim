package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;

/**
 * 这是PrpLclaimBillManager的数据访问对象类<br>
 * 创建于 2014-07-30 15:51:55.640<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLclaimBillManager extends DBPrpLclaimBillManagerBase{
    private static Logger logger = Logger.getLogger(DBPrpLclaimBillManager.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimBillManager(DBManager dbManager){
        super(dbManager);
    }

	public Collection findByConditonSum(String conditions,String editType,String back,int rowsPerPage,int pageNo) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
		buffer.append("select registNo, ");
		buffer.append("claimNo, ");
		buffer.append("policyNo, ");
		buffer.append("wmsys.wm_concat(serialNo), ");
		buffer.append("wmsys.wm_concat(compensateNo), ");
		buffer.append("payName, ");
		buffer.append("identifyNumber, ");
		buffer.append("max(provincename) as provincename, ");
		buffer.append("max(cityname) as cityname, ");
		buffer.append("max(accounttype) as accounttype, ");
		buffer.append("max(accountflag) as accountflag, ");
		buffer.append("max(bankname) as bankname, ");
		buffer.append("max(openbank) as openbank, ");
		buffer.append("max(bankaccount) as bankaccount, ");
		buffer.append("max(mobilephone) as mobilephone, ");
		buffer.append("max(address) as address, ");
		buffer.append("sum(sumPaid) as sumPaid, ");
		buffer.append("sum(payAmount) as payAmount, ");
		buffer.append("sum(havPay) as havPay, ");
		buffer.append("wmsys.wm_concat(payAmount) as payAmounts, ");
		buffer.append("max(underwriteenddate) ");
		buffer.append("from (SELECT rr.registNo, ");
		buffer.append("te.claimNo, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("rr.payName, ");
		buffer.append("rr.identifyNumber, ");
		buffer.append("rr.provincename, ");
		buffer.append("rr.cityname, ");
		buffer.append("rr.accounttype, ");
		buffer.append("rr.accountflag, ");
		buffer.append("rr.bankname, ");
		buffer.append("rr.openbank, ");
		buffer.append("rr.bankaccount, ");
		buffer.append("rr.mobilephone,");
		buffer.append("rr.address,");
		buffer.append("sum(rr.sumPaid) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
		if("1".equals(back)){
			buffer.append("(select decode(sum(decode(prplpay.vflag,'3',0,'7',0,'9',0,payamount)),null,0,'',0,sum(decode(prplpay.vflag,'3',0,'7',0,'9',0,payamount))) ");
		}else{
			buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
		}
		buffer.append("from prplpay prplpay ");
		buffer.append("where prplpay.registno = rr.registno ");
		buffer.append("and prplpay.compensateno = rr.compensateno ");
		buffer.append("and prplpay.policyno = rr.policyno ");
		buffer.append("and prplpay.policyno = rr.policyno ");
		buffer.append("and (te.claimrelationno is null or  ");
		buffer.append(" 	(te.claimrelationno is not null   ");
		buffer.append("and prplpay.receiverfullname = rr.payname ");
		buffer.append("and prplpay.certifno = rr.identifynumber )) ");
		buffer.append("and prplpay.paymenttype = 'P60') as havPay, ");
//		if("1".equals(back)){
//			buffer.append("   (select decode(sum(decode(prplpay.vflag,'3',0,'7',0,'9',0,prplpaybill.payamount)),null,0,'',0,sum(decode(prplpay.vflag,'3',0,'7',0,'9',0,prplpaybill.payamount)))   ");
//		}else{
//			buffer.append("		(select decode(sum(prplpaybill.payamount),null,0,'',0,sum(prplpaybill.payamount)) ");
//		}
//            buffer.append("   from prplpaybill prplpaybill,prplpay prplpay ");
//            buffer.append("   where prplpaybill.registno=rr.registno ");
//            buffer.append("   and prplpaybill.serialno=rr.serialno ");
//            buffer.append("   and prplpaybill.compensateno=rr.compensateno ");
//            buffer.append("  and prplpaybill.paymentno<>prplpaybill.paymentno ");
//            buffer.append("  and prplpaybill.registno=prplpay.registno ");
//            buffer.append("  and prplpaybill.compensateno=prplpay.compensateno ");
//            buffer.append("  and prplpaybill.paymentno=prplpay.serialno ");
//            buffer.append("   ) as havPay, ");
		buffer.append("te.underwriteenddate ");
		buffer.append("FROM PrpLclaimBillManager rr, prplcompensate te ");
		buffer.append("WHERE 1=1 ");
		buffer.append("and rr.compensateno = te.compensateno ");
		buffer.append(conditions);
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimNo, te.claimrelationno , ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.payName, ");
		buffer.append("rr.identifyNumber, ");
		buffer.append("rr.compensateno, ");
		buffer.append("rr.identifyNumber, ");
		buffer.append("rr.provincename, ");
		buffer.append("rr.cityname, ");
		buffer.append("rr.accounttype, ");
		buffer.append("rr.bankname, ");
		buffer.append("rr.openbank, ");
		buffer.append("rr.bankaccount, ");
		buffer.append("rr.mobilephone,");
		buffer.append("rr.address,");
		buffer.append("rr.accountflag,");
		buffer.append("te.underwriteenddate ");
		buffer.append(")");
		buffer.append("group by registNo,claimNo, policyNo, payName, identifyNumber ");
		if(!"SHOW".equals(editType)){
			buffer.append("  having sum(payAmount)-sum(havPay)<>0 ");
		}System.err.println(buffer.toString());
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
           // dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLclaimBillManagerDto prpLclaimBillManagerDto = null;
        while(resultSet.next()){
        	count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }
            prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
            prpLclaimBillManagerDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimBillManagerDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLclaimBillManagerDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLclaimBillManagerDto.setFkSerialNo(dbManager.getString(resultSet,4));
            prpLclaimBillManagerDto.setCompensateNo(dbManager.getString(resultSet,5));
            prpLclaimBillManagerDto.setPayName(dbManager.getString(resultSet,6));
            prpLclaimBillManagerDto.setIdentifyNumber(dbManager.getString(resultSet,7));
            prpLclaimBillManagerDto.setProvinceName(dbManager.getString(resultSet,8));
            prpLclaimBillManagerDto.setCityName(dbManager.getString(resultSet,9));
            prpLclaimBillManagerDto.setAccountType(dbManager.getString(resultSet,10));
            prpLclaimBillManagerDto.setAccountFlag(dbManager.getString(resultSet,11));
            prpLclaimBillManagerDto.setBankName(dbManager.getString(resultSet,12));
            prpLclaimBillManagerDto.setOpenBank(dbManager.getString(resultSet,13));
            prpLclaimBillManagerDto.setBankAccount(dbManager.getString(resultSet,14));
            prpLclaimBillManagerDto.setMobilePhone(dbManager.getString(resultSet,15));
            prpLclaimBillManagerDto.setAddress(dbManager.getString(resultSet,16));
            prpLclaimBillManagerDto.setSumPaid(dbManager.getDouble(resultSet,17));
            prpLclaimBillManagerDto.setPayAmount(dbManager.getDouble(resultSet,18));
            prpLclaimBillManagerDto.setHavPaid(dbManager.getDouble(resultSet,19));
            prpLclaimBillManagerDto.setPayAmounts(dbManager.getString(resultSet, 20));
            prpLclaimBillManagerDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,21).toString(DateTime.YEAR_TO_SECOND));
            collection.add(prpLclaimBillManagerDto);
        }
        resultSet.close();
        return collection;
	}

	public void update(String registNo, String compensateNo, int serialNo,
			double payAmount,String userCode, String payFlag) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaimBillManager SET ");
        buffer.append("payAmount = payAmount-?,");
        buffer.append("payFlag = ?, ");
        buffer.append("operatorcode = ?");
        buffer.append("WHERE ");
        buffer.append("registNo = ? ");
        buffer.append("and compensateNo = ? ");
        buffer.append("and serialNo = ?");
        buffer.append("and payFlag <> '"+payFlag+"'");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setDouble(1, payAmount);
        dbManager.setString(2, payFlag);
        dbManager.setString(3, userCode);
      //设置条件字段;
        dbManager.setString(4,registNo);
        dbManager.setString(5,compensateNo);
        dbManager.setInt(6,serialNo);
        dbManager.executePreparedUpdate();
	}
	
	public void update(String registNo, String compensateNo, int serialNo,
			double payAmount, String payFlag) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaimBillManager SET ");
        buffer.append("payAmount = payAmount-?,");
        buffer.append("payFlag = ? ");
        buffer.append("WHERE ");
        buffer.append("registNo = ? ");
        buffer.append("and compensateNo = ? ");
        buffer.append("and serialNo = ?");
        buffer.append("and payFlag <> '"+payFlag+"'");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setDouble(1, payAmount);
        dbManager.setString(2, payFlag);
      //设置条件字段;
        dbManager.setString(3,registNo);
        dbManager.setString(4,compensateNo);
        dbManager.setInt(5,serialNo);
        dbManager.executePreparedUpdate();
	}

	public Collection findByConditonBillSum(String conditions,String editType,int rowsPerPage,int pageNo) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
		buffer.append("select registNo, ");
		buffer.append("claimNo, ");
		buffer.append("policyNo, ");
		buffer.append("wmsys.wm_concat(serialNo), ");
		buffer.append("wmsys.wm_concat(compensateNo), ");
		buffer.append("receiverfullname, ");
		buffer.append("certifno, ");
		buffer.append("provincecode, ");
		buffer.append("citycode, ");
		buffer.append("accounttype, ");
		buffer.append("accountflag, ");
		buffer.append("banktype, ");
		buffer.append("bank, ");
		buffer.append("bankaccount, ");
		buffer.append("mobilephone, ");
		buffer.append("address, ");
		buffer.append("sum(sumPaid) as sumPaid, ");
		buffer.append("sum(payAmount) as payAmount, ");
		buffer.append("sum(havPay) as havPay, ");
		buffer.append("wmsys.wm_concat(payAmount) as payAmounts, ");
		buffer.append("paymentno, ");
		buffer.append("vFlag, ");
		buffer.append("payWay, ");
		buffer.append("payReason, ");
		buffer.append("payPurpose, ");
		buffer.append("max(underwriteenddate) as underwriteenddate, ");
		buffer.append("payremark,realpayway,routenum ");
		buffer.append("from ( ");
		buffer.append("SELECT rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("sum(rr.sumPaid) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
//		buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
//		buffer.append("from prplpay prplpay ");
//		buffer.append("where prplpay.registno = rr.registno ");
//		buffer.append("and prplpay.compensateno = rr.compensateno ");
//		buffer.append("and prplpay.policyno = rr.policyno ");
//		buffer.append("and prplpay.receiverfullname = nn.receiverfullname ");
//		buffer.append("and prplpay.certifno = nn.certifno ");
//		buffer.append("and prplpay.serialno <> ll.paymentno ");
//		buffer.append("and ( te.claimrelationno is not null or ( te.claimrelationno is null and prplpay.serialno = nn.paymentno  ) )  ");
//		buffer.append("and prplpay.paymenttype = 'P60') as havPay, ");
		buffer.append("		(select decode(sum(prplpaybill.payamount),null,0,'',0,sum(prplpaybill.payamount)) ");
        buffer.append("   from prplpaybill prplpaybill,prplpay prplpay ");
        buffer.append("   where prplpaybill.registno=rr.registno ");
        buffer.append("   and prplpaybill.serialno=rr.serialno ");
        buffer.append("   and prplpaybill.compensateno=rr.compensateno ");
        buffer.append("  and prplpaybill.paymentno<>prplpaybill.paymentno ");
        buffer.append("  and prplpaybill.registno=prplpay.registno ");
        buffer.append("  and prplpaybill.compensateno=prplpay.compensateno ");
        buffer.append("  and prplpaybill.paymentno=prplpay.serialno ");
        buffer.append("   ) as havPay, ");
		buffer.append("nn.paymentno, ");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose, ");
		buffer.append("te.underwriteenddate, ");
		buffer.append("nn.payremark,nn.realpayway,nn.routenum ");
		buffer.append("FROM PrpLclaimBillManager rr, prplpaybill ll,prplpaymain nn,prplcompensate te ");
		buffer.append("WHERE  ");
		buffer.append(conditions);
		buffer.append("and te.compensateno=rr.compensateno ");
		buffer.append("and ll.registno = rr.registno ");
		buffer.append("and ll.compensateno = rr.compensateno ");
		buffer.append("and ll.serialno = rr.serialno ");
		buffer.append("and nn.paymentno=ll.paymentno ");
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("ll.paymentno, ");
		buffer.append("rr.compensateno, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("nn.paymentno,");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose, ");
		buffer.append("te.underwriteenddate, te.claimrelationno , ");
		buffer.append("nn.payremark ,");
		buffer.append("nn.realpayway ,");
		buffer.append("nn.routenum ");
		buffer.append(")");
		buffer.append("group by registNo,claimNo, policyNo, receiverfullname, certifno,provincecode,citycode,accounttype,accountflag,banktype,bank,bankaccount,paymentno,mobilephone,address,vFlag,payWay,payReason,payPurpose,payremark,realpayway,routenum ");
		if(!"SHOW".equals(editType)){
			buffer.append("  having sum(payAmount)-sum(havPay)<>0 ");
		}
		System.err.println(buffer.toString());
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            //dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLclaimBillManagerDto prpLclaimBillManagerDto = null;
        while(resultSet.next()){
        	count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }
        	
            prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
            prpLclaimBillManagerDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimBillManagerDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLclaimBillManagerDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLclaimBillManagerDto.setFkSerialNo(dbManager.getString(resultSet,4));
            prpLclaimBillManagerDto.setCompensateNo(dbManager.getString(resultSet,5));
            prpLclaimBillManagerDto.setPayName(dbManager.getString(resultSet,6));
            prpLclaimBillManagerDto.setIdentifyNumber(dbManager.getString(resultSet,7));
            prpLclaimBillManagerDto.setProvinceName(dbManager.getString(resultSet,8));
            prpLclaimBillManagerDto.setCityName(dbManager.getString(resultSet,9));
            prpLclaimBillManagerDto.setAccountType(dbManager.getString(resultSet,10));
            prpLclaimBillManagerDto.setAccountFlag(dbManager.getString(resultSet,11));
            prpLclaimBillManagerDto.setBankName(dbManager.getString(resultSet,12));
            prpLclaimBillManagerDto.setOpenBank(dbManager.getString(resultSet,13));
            prpLclaimBillManagerDto.setBankAccount(dbManager.getString(resultSet,14));
            prpLclaimBillManagerDto.setMobilePhone(dbManager.getString(resultSet,15));
            prpLclaimBillManagerDto.setAddress(dbManager.getString(resultSet,16));
            prpLclaimBillManagerDto.setSumPaid(dbManager.getDouble(resultSet,17));
            prpLclaimBillManagerDto.setPayAmount(dbManager.getDouble(resultSet,18));
            prpLclaimBillManagerDto.setHavPaid(dbManager.getDouble(resultSet,19));
            prpLclaimBillManagerDto.setPayAmounts(dbManager.getString(resultSet, 20));
            prpLclaimBillManagerDto.setPaymentNo(dbManager.getString(resultSet, 21));
            prpLclaimBillManagerDto.setVflag(dbManager.getString(resultSet, 22));
            prpLclaimBillManagerDto.setPayWay(dbManager.getString(resultSet, 23));
            prpLclaimBillManagerDto.setPayReason(dbManager.getString(resultSet, 24));
            prpLclaimBillManagerDto.setPayPurpose(dbManager.getString(resultSet, 25));
            prpLclaimBillManagerDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,26).toString(DateTime.YEAR_TO_SECOND));
            prpLclaimBillManagerDto.setPayReMark(dbManager.getString(resultSet, 27));
            prpLclaimBillManagerDto.setRealPayWay(dbManager.getString(resultSet, 28));
            prpLclaimBillManagerDto.setRouteNum(dbManager.getString(resultSet, 29));
            collection.add(prpLclaimBillManagerDto);
        }
        resultSet.close();
        return collection;
	}
	/**
	 * 新农险非委托险种查询
	 * @param conditions
	 * @param editType
	 * @param rowsPerPage
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	public Collection findByConditonBillSumNew(String conditions,String editType,int rowsPerPage,int pageNo) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
		//拼SQL语句
		buffer.append("select registNo, ");
		buffer.append("claimNo, ");
		buffer.append("policyNo, ");
		buffer.append("wmsys.wm_concat(serialNo), ");
		buffer.append("wmsys.wm_concat(compensateNo), ");
		buffer.append("receiverfullname, ");
		buffer.append("certifno, ");
		buffer.append("provincecode, ");
		buffer.append("citycode, ");
		buffer.append("accounttype, ");
		buffer.append("accountflag, ");
		buffer.append("banktype, ");
		buffer.append("bank, ");
		buffer.append("bankaccount, ");
		buffer.append("mobilephone, ");
		buffer.append("address, ");
		buffer.append("sum(sumPaid) as sumPaid, ");
		buffer.append("sum(payAmount) as payAmount, ");
		buffer.append("sum(havPay) as havPay, ");
		buffer.append("wmsys.wm_concat(payAmount) as payAmounts, ");
		buffer.append("paymentno, ");
		buffer.append("vFlag, ");
		buffer.append("payWay, ");
		buffer.append("payReason, ");
		buffer.append("payPurpose, ");
		buffer.append("max(underwriteenddate) as underwriteenddate, ");
		buffer.append("payremark ,");
		buffer.append("routenum ");
		buffer.append("from ( ");
		buffer.append("SELECT rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("sum(rr.payAmount) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
		buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
		buffer.append("from prplpay prplpay ");
		buffer.append("where prplpay.registno = rr.registno ");
		buffer.append("and prplpay.compensateno = rr.compensateno ");
		buffer.append("and prplpay.policyno = rr.policyno ");
		buffer.append("and prplpay.receiverfullname = nn.receiverfullname ");
		buffer.append("and prplpay.certifno = nn.certifno ");
		buffer.append("and prplpay.serialno <> ll.paymentno ");
		buffer.append("and ( te.claimrelationno is not null or ( te.claimrelationno is null and prplpay.serialno = nn.paymentno  ) )  ");
		buffer.append("and prplpay.paymenttype = 'P60') as havPay, ");
		buffer.append("nn.paymentno, ");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose, ");
		buffer.append("te.underwriteenddate, ");
		buffer.append("nn.payremark, ");
		buffer.append("nn.routenum ");
		buffer.append("FROM prplpay rr, prplpaybill ll,prplpaymain nn,prplcompensate te ");
		buffer.append("WHERE  ");
		buffer.append(conditions);
		buffer.append("and te.compensateno=rr.compensateno ");
		buffer.append("and ll.registno = rr.registno ");
		buffer.append("and ll.compensateno = rr.compensateno ");
		buffer.append("and ll.paymentno = rr.serialno ");
		buffer.append("and nn.paymentno=ll.paymentno ");
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("ll.paymentno, ");
		buffer.append("rr.compensateno, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("nn.paymentno,");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose, ");
		buffer.append("te.underwriteenddate, te.claimrelationno , ");
		buffer.append("nn.payremark, ");
		buffer.append("nn.routenum ");
		//关联预赔信息
		buffer.append(" union all ");
		buffer.append("SELECT rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("sum(rr.payAmount) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
		buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
		buffer.append("from prplpay prplpay ");
		buffer.append("where prplpay.registno = rr.registno ");
		buffer.append("and prplpay.compensateno = rr.compensateno ");
		buffer.append("and prplpay.policyno = rr.policyno ");
		buffer.append("and prplpay.receiverfullname = nn.receiverfullname ");
		buffer.append("and prplpay.certifno = nn.certifno ");
		buffer.append("and prplpay.serialno <> ll.paymentno ");
		buffer.append("and prplpay.serialno = nn.paymentno  ");
		buffer.append("and prplpay.paymenttype = 'P60') as havPay, ");
		buffer.append("nn.paymentno, ");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose, ");
		buffer.append("te.underwriteenddate, ");
		buffer.append("nn.payremark, ");
		buffer.append("nn.routenum ");
		buffer.append("FROM prplpay rr, prplpaybill ll,prplpaymain nn,prplprepay te ");
		buffer.append("WHERE  ");
		buffer.append(conditions);
		buffer.append("and te.precompensateno=rr.compensateno ");
		buffer.append("and ll.registno = rr.registno ");
		buffer.append("and ll.compensateno = rr.compensateno ");
		buffer.append("and ll.paymentno = rr.serialno ");
		buffer.append("and nn.paymentno=ll.paymentno ");
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("ll.paymentno, ");
		buffer.append("rr.compensateno, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("nn.paymentno,");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose, ");
		buffer.append("te.underwriteenddate, ");
		buffer.append("nn.payremark ,");
		buffer.append("nn.routenum ");
		buffer.append(")");
		buffer.append("group by registNo,claimNo, policyNo, receiverfullname, certifno,provincecode,citycode,accounttype,accountflag,banktype,bank,bankaccount,paymentno,mobilephone,address,vFlag,payWay,payReason,payPurpose,payremark ,routenum");
		if(!"SHOW".equals(editType)){
			buffer.append("  having sum(payAmount)-sum(havPay)<>0 ");
		}
		System.err.println(buffer.toString());
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
		int count=0;
		if(pageNo>1){
			//dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
		}
		
		//定义返回结果集合
		Collection collection = new ArrayList(rowsPerPage);
		PrpLclaimBillManagerDto prpLclaimBillManagerDto = null;
		while(resultSet.next()){
			count++;
			if(pageNo>0){
				if(count > rowsPerPage){
					break;
				}
			}
			
			prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
			prpLclaimBillManagerDto.setRegistNo(dbManager.getString(resultSet,1));
			prpLclaimBillManagerDto.setClaimNo(dbManager.getString(resultSet,2));
			prpLclaimBillManagerDto.setPolicyNo(dbManager.getString(resultSet,3));
			prpLclaimBillManagerDto.setFkSerialNo(dbManager.getString(resultSet,4));
			prpLclaimBillManagerDto.setCompensateNo(dbManager.getString(resultSet,5));
			prpLclaimBillManagerDto.setPayName(dbManager.getString(resultSet,6));
			prpLclaimBillManagerDto.setIdentifyNumber(dbManager.getString(resultSet,7));
			prpLclaimBillManagerDto.setProvinceName(dbManager.getString(resultSet,8));
			prpLclaimBillManagerDto.setCityName(dbManager.getString(resultSet,9));
			prpLclaimBillManagerDto.setAccountType(dbManager.getString(resultSet,10));
			prpLclaimBillManagerDto.setAccountFlag(dbManager.getString(resultSet,11));
			prpLclaimBillManagerDto.setBankName(dbManager.getString(resultSet,12));
			prpLclaimBillManagerDto.setOpenBank(dbManager.getString(resultSet,13));
			prpLclaimBillManagerDto.setBankAccount(dbManager.getString(resultSet,14));
			prpLclaimBillManagerDto.setMobilePhone(dbManager.getString(resultSet,15));
			prpLclaimBillManagerDto.setAddress(dbManager.getString(resultSet,16));
			prpLclaimBillManagerDto.setSumPaid(dbManager.getDouble(resultSet,17));
			prpLclaimBillManagerDto.setPayAmount(dbManager.getDouble(resultSet,18));
			prpLclaimBillManagerDto.setHavPaid(dbManager.getDouble(resultSet,19));
			prpLclaimBillManagerDto.setPayAmounts(dbManager.getString(resultSet, 20));
			prpLclaimBillManagerDto.setPaymentNo(dbManager.getString(resultSet, 21));
			prpLclaimBillManagerDto.setVflag(dbManager.getString(resultSet, 22));
			prpLclaimBillManagerDto.setPayWay(dbManager.getString(resultSet, 23));
			prpLclaimBillManagerDto.setPayReason(dbManager.getString(resultSet, 24));
			prpLclaimBillManagerDto.setPayPurpose(dbManager.getString(resultSet, 25));
			prpLclaimBillManagerDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,26).toString(DateTime.YEAR_TO_SECOND));
			prpLclaimBillManagerDto.setPayReMark(dbManager.getString(resultSet, 27));
			prpLclaimBillManagerDto.setRouteNum(dbManager.getString(resultSet, 28));
			collection.add(prpLclaimBillManagerDto);
		}
		resultSet.close();
		return collection;
	}
	/**
	 * 新农险委托险种查询
	 * @param conditions
	 * @param editType
	 * @param rowsPerPage
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	public Collection findByConditonBillSumNewtg(String conditions,String editType,int rowsPerPage,int pageNo) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
		//拼SQL语句
		buffer.append("select registNo, ");
		buffer.append("claimNo, ");
		buffer.append("policyNo, ");
		buffer.append("wmsys.wm_concat(serialNo), ");
		buffer.append("wmsys.wm_concat(compensateNo), ");
		buffer.append("receiverfullname, ");
		buffer.append("certifno, ");
		buffer.append("provincecode, ");
		buffer.append("citycode, ");
		buffer.append("accounttype, ");
		buffer.append("accountflag, ");
		buffer.append("banktype, ");
		buffer.append("bank, ");
		buffer.append("bankaccount, ");
		buffer.append("mobilephone, ");
		buffer.append("address, ");
		buffer.append("sum(sumPaid) as sumPaid, ");
		buffer.append("sum(payAmount) as payAmount, ");
		buffer.append("sum(havPay) as havPay, ");
		buffer.append("wmsys.wm_concat(payAmount) as payAmounts, ");
		buffer.append("paymentno, ");
		buffer.append("vFlag, ");
		buffer.append("payWay, ");
		buffer.append("payReason, ");
		buffer.append("payPurpose, ");
		buffer.append("max(underwriteenddate) as underwriteenddate, ");
		buffer.append("payremark ,");
		buffer.append("routenum ");
		buffer.append("from ( ");
		buffer.append("SELECT rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("sum(rr.payAmount) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
		buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
		buffer.append("from prplpaytg prplpay ");
		buffer.append("where prplpay.registno = rr.registno ");
		buffer.append("and prplpay.compensateno = rr.compensateno ");
		buffer.append("and prplpay.policyno = rr.policyno ");
		buffer.append("and prplpay.receiverfullname = nn.receiverfullname ");
		buffer.append("and prplpay.certifno = nn.certifno ");
		buffer.append("and prplpay.serialno <> ll.paymentno ");
		buffer.append("and ( te.claimrelationno is not null or ( te.claimrelationno is null and prplpay.serialno = nn.paymentno  ) )  ");
		buffer.append("and prplpay.paymenttype = 'P60') as havPay, ");
		buffer.append("nn.paymentno, ");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose, ");
		buffer.append("te.underwriteenddate, ");
		buffer.append("nn.payremark ,");
		buffer.append("nn.routenum ");
		buffer.append("FROM prplpaytg rr, prplpaybilltg ll,prplpaymaintg nn,prplcompensatetg te ");
		buffer.append("WHERE  ");
		buffer.append(conditions);
		buffer.append("and te.compensateno=rr.compensateno ");
		buffer.append("and ll.registno = rr.registno ");
		buffer.append("and ll.compensateno = rr.compensateno ");
		buffer.append("and ll.paymentno = rr.serialno ");
		buffer.append("and nn.paymentno=ll.paymentno ");
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("ll.paymentno, ");
		buffer.append("rr.compensateno, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("nn.paymentno,");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose, ");
		buffer.append("te.underwriteenddate, te.claimrelationno , ");
		buffer.append("nn.payremark, ");
		buffer.append("nn.routenum ");
		//关联预赔信息
		buffer.append(" union all ");
		buffer.append("SELECT rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("sum(rr.payAmount) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
		buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
		buffer.append("from prplpaytg prplpay ");
		buffer.append("where prplpay.registno = rr.registno ");
		buffer.append("and prplpay.compensateno = rr.compensateno ");
		buffer.append("and prplpay.policyno = rr.policyno ");
		buffer.append("and prplpay.receiverfullname = nn.receiverfullname ");
		buffer.append("and prplpay.certifno = nn.certifno ");
		buffer.append("and prplpay.serialno <> ll.paymentno ");
		buffer.append("and prplpay.serialno = nn.paymentno ");
		buffer.append("and prplpay.paymenttype = 'P60') as havPay, ");
		buffer.append("nn.paymentno, ");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose, ");
		buffer.append("te.underwriteenddate, ");
		buffer.append("nn.payremark ,");
		buffer.append("nn.routenum ");
		buffer.append("FROM prplpaytg rr, prplpaybilltg ll,prplpaymaintg nn,prplprepaytg te ");
		buffer.append("WHERE  ");
		buffer.append(conditions);
		buffer.append("and te.precompensateno=rr.compensateno ");
		buffer.append("and ll.registno = rr.registno ");
		buffer.append("and ll.compensateno = rr.compensateno ");
		buffer.append("and ll.paymentno = rr.serialno ");
		buffer.append("and nn.paymentno=ll.paymentno ");
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("ll.paymentno, ");
		buffer.append("rr.compensateno, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("nn.paymentno,");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose, ");
		buffer.append("te.underwriteenddate, ");
		buffer.append("nn.payremark, ");
		buffer.append("nn.routenum ");
		buffer.append(")");
		buffer.append("group by registNo,claimNo, policyNo, receiverfullname, certifno,provincecode,citycode,accounttype,accountflag,banktype,bank,bankaccount,paymentno,mobilephone,address,vFlag,payWay,payReason,payPurpose,payremark,routenum ");
		if(!"SHOW".equals(editType)){
			buffer.append("  having sum(payAmount)-sum(havPay)<>0 ");
		}
		System.err.println(buffer.toString());
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
		int count=0;
		if(pageNo>1){
			//dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
		}
		
		//定义返回结果集合
		Collection collection = new ArrayList(rowsPerPage);
		PrpLclaimBillManagerDto prpLclaimBillManagerDto = null;
		while(resultSet.next()){
			count++;
			if(pageNo>0){
				if(count > rowsPerPage){
					break;
				}
			}
			
			prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
			prpLclaimBillManagerDto.setRegistNo(dbManager.getString(resultSet,1));
			prpLclaimBillManagerDto.setClaimNo(dbManager.getString(resultSet,2));
			prpLclaimBillManagerDto.setPolicyNo(dbManager.getString(resultSet,3));
			prpLclaimBillManagerDto.setFkSerialNo(dbManager.getString(resultSet,4));
			prpLclaimBillManagerDto.setCompensateNo(dbManager.getString(resultSet,5));
			prpLclaimBillManagerDto.setPayName(dbManager.getString(resultSet,6));
			prpLclaimBillManagerDto.setIdentifyNumber(dbManager.getString(resultSet,7));
			prpLclaimBillManagerDto.setProvinceName(dbManager.getString(resultSet,8));
			prpLclaimBillManagerDto.setCityName(dbManager.getString(resultSet,9));
			prpLclaimBillManagerDto.setAccountType(dbManager.getString(resultSet,10));
			prpLclaimBillManagerDto.setAccountFlag(dbManager.getString(resultSet,11));
			prpLclaimBillManagerDto.setBankName(dbManager.getString(resultSet,12));
			prpLclaimBillManagerDto.setOpenBank(dbManager.getString(resultSet,13));
			prpLclaimBillManagerDto.setBankAccount(dbManager.getString(resultSet,14));
			prpLclaimBillManagerDto.setMobilePhone(dbManager.getString(resultSet,15));
			prpLclaimBillManagerDto.setAddress(dbManager.getString(resultSet,16));
			prpLclaimBillManagerDto.setSumPaid(dbManager.getDouble(resultSet,17));
			prpLclaimBillManagerDto.setPayAmount(dbManager.getDouble(resultSet,18));
			prpLclaimBillManagerDto.setHavPaid(dbManager.getDouble(resultSet,19));
			prpLclaimBillManagerDto.setPayAmounts(dbManager.getString(resultSet, 20));
			prpLclaimBillManagerDto.setPaymentNo(dbManager.getString(resultSet, 21));
			prpLclaimBillManagerDto.setVflag(dbManager.getString(resultSet, 22));
			prpLclaimBillManagerDto.setPayWay(dbManager.getString(resultSet, 23));
			prpLclaimBillManagerDto.setPayReason(dbManager.getString(resultSet, 24));
			prpLclaimBillManagerDto.setPayPurpose(dbManager.getString(resultSet, 25));
			prpLclaimBillManagerDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,26).toString(DateTime.YEAR_TO_SECOND));
			prpLclaimBillManagerDto.setPayReMark(dbManager.getString(resultSet, 27));
			prpLclaimBillManagerDto.setRouteNum(dbManager.getString(resultSet, 28));
			collection.add(prpLclaimBillManagerDto);
		}
		resultSet.close();
		return collection;
	}
	
	public Collection findByPaynameIndetSum(String conditions,String fiscalno) throws Exception{
 		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
		buffer.append("Select Payname,					");
		buffer.append("       InsuredCode,			    ");
		buffer.append("       Identifynumber,			");
		buffer.append("       Provincename,				");
		buffer.append("       Cityname,					");
		buffer.append("       Accounttype,				");
		buffer.append("       Bankname,					");
		buffer.append("       Openbank,					");
		buffer.append("       Bankaccount,				");
		buffer.append("       CompensateNo,				");
		buffer.append("       RegistNo,				    ");
		buffer.append("		  (Select '1' As Exist     ");
		buffer.append("		    From Prplfiscalpaydetail Dd ");
		buffer.append("		   Where Dd.Compensateno = Prplclaimbillmanager.Compensateno ");
		buffer.append("		    And Dd.Insuredcode = Prplclaimbillmanager.Insuredcode ");
		if(null!=fiscalno && !"".equals(fiscalno)){
			buffer.append(" And Dd.fiscalno = '"+fiscalno+"'");
		}
		buffer.append(") As Exist,				");
		buffer.append("       Sum(Payamount)			");
		buffer.append("  From Prplclaimbillmanager	    ");
		buffer.append(" Where 							");
		buffer.append(conditions);
		buffer.append(" Group By Payname,				");
		buffer.append("          InsuredCode,		    ");
		buffer.append("          Identifynumber,		");
		buffer.append("          Provincename,			");
		buffer.append("          Cityname,				");
		buffer.append("          Accounttype,			");
		buffer.append("          Bankname,				");
		buffer.append("          Openbank,				");
		buffer.append("          Bankaccount,			");
		buffer.append("          CompensateNo,			");
		buffer.append("          RegistNo               ");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());

        //定义返回结果集合
        Collection collection = new ArrayList();
        PrpLclaimBillManagerDto prpLclaimBillManagerDto = null;
        while(resultSet.next()){
            prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
            prpLclaimBillManagerDto.setPayName(dbManager.getString(resultSet,1));
            prpLclaimBillManagerDto.setInsuredCode(dbManager.getString(resultSet,2));
            prpLclaimBillManagerDto.setIdentifyNumber(dbManager.getString(resultSet,3));
            prpLclaimBillManagerDto.setProvinceName(dbManager.getString(resultSet,4));
            prpLclaimBillManagerDto.setCityName(dbManager.getString(resultSet,5));
            prpLclaimBillManagerDto.setAccountType(dbManager.getString(resultSet,6));
            prpLclaimBillManagerDto.setBankName(dbManager.getString(resultSet,7));
            prpLclaimBillManagerDto.setOpenBank(dbManager.getString(resultSet,8));
            prpLclaimBillManagerDto.setBankAccount(dbManager.getString(resultSet,9));
            prpLclaimBillManagerDto.setCompensateNo(dbManager.getString(resultSet,10));
            prpLclaimBillManagerDto.setRegistNo(dbManager.getString(resultSet, 11));
            prpLclaimBillManagerDto.setExist(dbManager.getString(resultSet, 12));
            prpLclaimBillManagerDto.setPayAmount(dbManager.getDouble(resultSet,13));
            collection.add(prpLclaimBillManagerDto);
        }
        resultSet.close();
        return collection;
	}

	/**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int findByConditonSumCount(String conditions,String editType,String  back,int rowsPerPage,int pageNo) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        //拼SQL语句
        buffer.append(" select count(1) from (");
		buffer.append("select count(1) ");
		buffer.append("from (SELECT rr.registNo, ");
		buffer.append("te.claimNo, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("rr.payName, ");
		buffer.append("rr.identifyNumber, ");
		buffer.append("rr.provincename, ");
		buffer.append("rr.cityname, ");
		buffer.append("rr.accounttype, ");
		buffer.append("rr.accountflag, ");
		buffer.append("rr.bankname, ");
		buffer.append("rr.openbank, ");
		buffer.append("rr.bankaccount, ");
		buffer.append("rr.mobilephone,");
		buffer.append("rr.address,");
		buffer.append("sum(rr.sumPaid) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
		if("1".equals(back)){
			buffer.append("(select decode(sum(decode(prplpay.vflag,'3',0,'7',0,'9',0,payamount)),null,0,'',0,sum(decode(prplpay.vflag,'3',0,'7',0,'9',0,payamount))) ");
		}else{
			buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
		}
		buffer.append("from prplpay prplpay ");
		buffer.append("where prplpay.registno = rr.registno ");
		buffer.append("and prplpay.compensateno = rr.compensateno ");
		buffer.append("and prplpay.policyno = rr.policyno ");
		buffer.append("and (te.claimrelationno is null or  ");
		buffer.append(" 	(te.claimrelationno is not null   ");
		buffer.append("and prplpay.receiverfullname = rr.payname ");
		buffer.append("and prplpay.certifno = rr.identifynumber ))");
		buffer.append("and prplpay.paymenttype = 'P60') as havPay ");
//		if("1".equals(back)){
//			buffer.append("   (select decode(sum(decode(prplpay.vflag,'3',0,'7',0,'9',0,prplpaybill.payamount)),null,0,'',0,sum(decode(prplpay.vflag,'3',0,'7',0,'9',0,prplpaybill.payamount)))   ");
//		}else{
//			buffer.append("		(select decode(sum(prplpaybill.payamount),null,0,'',0,sum(prplpaybill.payamount)) ");
//		}
//            buffer.append("   from prplpaybill prplpaybill,prplpay prplpay ");
//            buffer.append("   where prplpaybill.registno=rr.registno ");
//            buffer.append("   and prplpaybill.serialno=rr.serialno ");
//            buffer.append("   and prplpaybill.compensateno=rr.compensateno ");
//            buffer.append("  and prplpaybill.paymentno<>prplpaybill.paymentno ");
//            buffer.append("  and prplpaybill.registno=prplpay.registno ");
//            buffer.append("  and prplpaybill.compensateno=prplpay.compensateno ");
//            buffer.append("  and prplpaybill.paymentno=prplpay.serialno ");
//            buffer.append("   ) as havPay ");
		buffer.append("FROM PrpLclaimBillManager rr, prplcompensate te ");
		buffer.append("WHERE 1=1 ");
		buffer.append("and rr.compensateno = te.compensateno ");
		buffer.append(conditions);
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimNo,te.claimrelationno ,  ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.payName, ");
		buffer.append("rr.identifyNumber, ");
		buffer.append("rr.compensateno, ");
		buffer.append("rr.identifyNumber, ");
		buffer.append("rr.provincename, ");
		buffer.append("rr.cityname, ");
		buffer.append("rr.accounttype, ");
		buffer.append("rr.bankname, ");
		buffer.append("rr.openbank, ");
		buffer.append("rr.bankaccount, ");
		buffer.append("rr.mobilephone,");
		buffer.append("rr.address,");
		buffer.append("rr.accountflag");
		buffer.append(")");
		buffer.append("group by registNo,claimNo, policyNo, payName, identifyNumber ");
		if(!"SHOW".equals(editType)){
			buffer.append("  having sum(payAmount)-sum(havPay)<>0 ");
		}
		buffer.append(")");
		System.err.println("--->"+buffer.toString());
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }

	public int findByConditonBillSumCount(String conditions, String editType,
			int rowsPerPage, int pageNo) throws Exception {
		 int count = -1;
	     StringBuffer buffer = new StringBuffer(100);
		//拼SQL语句
	    buffer.append("select count(1) from (");
		buffer.append("select count(1) ");
		buffer.append("from ( ");
		buffer.append("SELECT rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("sum(rr.sumPaid) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
//		buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
//		buffer.append("from prplpay prplpay ");
//		buffer.append("where prplpay.registno = rr.registno ");
//		buffer.append("and prplpay.compensateno = rr.compensateno ");
//		buffer.append("and prplpay.policyno = rr.policyno ");
//		buffer.append("and prplpay.receiverfullname = nn.receiverfullname ");
//		buffer.append("and prplpay.certifno = nn.certifno ");
//		buffer.append("and prplpay.serialno <> ll.paymentno ");
//		buffer.append("and ( te.claimrelationno is not null or ( te.claimrelationno is null and prplpay.serialno = nn.paymentno  ) )  ");
//		buffer.append("and prplpay.paymenttype = 'P60') as havPay, ");
		buffer.append("		(select decode(sum(prplpaybill.payamount),null,0,'',0,sum(prplpaybill.payamount)) "); 
		buffer.append("   from prplpaybill prplpaybill,prplpay prplpay ");
         buffer.append("   where prplpaybill.registno=rr.registno ");
         buffer.append("   and prplpaybill.serialno=rr.serialno ");
         buffer.append("   and prplpaybill.compensateno=rr.compensateno ");
         buffer.append("  and prplpaybill.paymentno<>prplpaybill.paymentno ");
         buffer.append("  and prplpaybill.registno=prplpay.registno ");
         buffer.append("  and prplpaybill.compensateno=prplpay.compensateno ");
         buffer.append("  and prplpaybill.paymentno=prplpay.serialno ");
         buffer.append("   ) as havPay, ");
		buffer.append("nn.paymentno, ");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose ");
		buffer.append("FROM PrpLclaimBillManager rr, prplpaybill ll,prplpaymain nn,prplcompensate te ");
		buffer.append("WHERE  ");
		buffer.append(conditions);
		buffer.append("and te.compensateno=rr.compensateno ");
		buffer.append("and ll.registno = rr.registno ");
		buffer.append("and ll.compensateno = rr.compensateno ");
		buffer.append("and ll.serialno = rr.serialno ");
		buffer.append("and nn.paymentno=ll.paymentno ");
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimno,te.claimrelationno , ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("ll.paymentno, ");
		buffer.append("rr.compensateno, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("nn.paymentno,");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose ");
		buffer.append(")");
		buffer.append("group by registNo,claimNo, policyNo, receiverfullname, certifno,provincecode,citycode,accounttype,accountflag,banktype,bank,bankaccount,paymentno,mobilephone,address,vFlag,payWay,payReason,payPurpose ");
		if(!"SHOW".equals(editType)){
			buffer.append("  having sum(payAmount)-sum(havPay)<>0 ");
		}
		buffer.append(")");
		System.err.println(buffer.toString());
		if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
	}
	/**
	 * 新农险非委托险种查询合计值
	 * @param conditions
	 * @param editType
	 * @param rowsPerPage
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	public int findByConditonBillSumCountNew(String conditions, String editType,
			int rowsPerPage, int pageNo) throws Exception {
		int count = -1;
		StringBuffer buffer = new StringBuffer(100);
		//拼SQL语句
		buffer.append("select count(1) from (");
		buffer.append("select count(1) ");
		buffer.append("from ( ");
		buffer.append("SELECT rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("sum(rr.payAmount) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
		buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
		buffer.append("from prplpay prplpay ");
		buffer.append("where prplpay.registno = rr.registno ");
		buffer.append("and prplpay.compensateno = rr.compensateno ");
		buffer.append("and prplpay.policyno = rr.policyno ");
		buffer.append("and prplpay.receiverfullname = nn.receiverfullname ");
		buffer.append("and prplpay.certifno = nn.certifno ");
		buffer.append("and prplpay.serialno <> ll.paymentno ");
		buffer.append("and ( te.claimrelationno is not null or ( te.claimrelationno is null and prplpay.serialno = nn.paymentno  ) )  ");
		buffer.append("and prplpay.paymenttype = 'P60') as havPay, ");
		buffer.append("nn.paymentno, ");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose ");
		buffer.append("FROM prplpay rr, prplpaybill ll,prplpaymain nn,prplcompensate te ");
		buffer.append("WHERE  ");
		buffer.append(conditions);
		buffer.append("and te.compensateno=rr.compensateno ");
		buffer.append("and ll.registno = rr.registno ");
		buffer.append("and ll.compensateno = rr.compensateno ");
		buffer.append("and ll.paymentno = rr.serialno ");
		buffer.append("and nn.paymentno=ll.paymentno ");
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimno,te.claimrelationno , ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("ll.paymentno, ");
		buffer.append("rr.compensateno, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("nn.paymentno,");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose ");
		//关联预赔信息
		buffer.append(" union all ");
		buffer.append("SELECT rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("sum(rr.payAmount) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
		buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
		buffer.append("from prplpay prplpay ");
		buffer.append("where prplpay.registno = rr.registno ");
		buffer.append("and prplpay.compensateno = rr.compensateno ");
		buffer.append("and prplpay.policyno = rr.policyno ");
		buffer.append("and prplpay.receiverfullname = nn.receiverfullname ");
		buffer.append("and prplpay.certifno = nn.certifno ");
		buffer.append("and prplpay.serialno <> ll.paymentno ");
		buffer.append("and prplpay.serialno = nn.paymentno ");
		buffer.append("and prplpay.paymenttype = 'P60') as havPay, ");
		buffer.append("nn.paymentno, ");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose ");
		buffer.append("FROM prplpay rr, prplpaybill ll,prplpaymain nn,prplprepay te ");
		buffer.append("WHERE  ");
		buffer.append(conditions);
		buffer.append("and te.precompensateno=rr.compensateno ");
		buffer.append("and ll.registno = rr.registno ");
		buffer.append("and ll.compensateno = rr.compensateno ");
		buffer.append("and ll.paymentno = rr.serialno ");
		buffer.append("and nn.paymentno=ll.paymentno ");
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("ll.paymentno, ");
		buffer.append("rr.compensateno, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("nn.paymentno,");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose ");
		buffer.append(")");
		buffer.append("group by registNo,claimNo, policyNo, receiverfullname, certifno,provincecode,citycode,accounttype,accountflag,banktype,bank,bankaccount,paymentno,mobilephone,address,vFlag,payWay,payReason,payPurpose ");
		if(!"SHOW".equals(editType)){
			buffer.append("  having sum(payAmount)-sum(havPay)<>0 ");
		}
		buffer.append(")");
		System.err.println(buffer.toString());
		if(logger.isDebugEnabled()){
			logger.debug(buffer.toString());
		}
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
		resultSet.next();
		count = dbManager.getInt(resultSet,1);
		resultSet.close();
		return count;
	}
	/**
	 * 新农险委托险种查询合计值
	 * @param conditions
	 * @param editType
	 * @param rowsPerPage
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	public int findByConditonBillSumCountNewtg(String conditions, String editType,
			int rowsPerPage, int pageNo) throws Exception {
		int count = -1;
		StringBuffer buffer = new StringBuffer(100);
		//拼SQL语句
		buffer.append("select count(1) from (");
		buffer.append("select count(1) ");
		buffer.append("from ( ");
		buffer.append("SELECT rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("sum(rr.payAmount) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
		buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
		buffer.append("from prplpaytg prplpay ");
		buffer.append("where prplpay.registno = rr.registno ");
		buffer.append("and prplpay.compensateno = rr.compensateno ");
		buffer.append("and prplpay.policyno = rr.policyno ");
		buffer.append("and prplpay.receiverfullname = nn.receiverfullname ");
		buffer.append("and prplpay.certifno = nn.certifno ");
		buffer.append("and prplpay.serialno <> ll.paymentno ");
		buffer.append("and ( te.claimrelationno is not null or ( te.claimrelationno is null and prplpay.serialno = nn.paymentno  ) )  ");
		buffer.append("and prplpay.paymenttype = 'P60') as havPay, ");
		buffer.append("nn.paymentno, ");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose ");
		buffer.append("FROM prplpaytg rr, prplpaybilltg ll,prplpaymaintg nn,prplcompensatetg te ");
		buffer.append("WHERE  ");
		buffer.append(conditions);
		buffer.append("and te.compensateno=rr.compensateno ");
		buffer.append("and ll.registno = rr.registno ");
		buffer.append("and ll.compensateno = rr.compensateno ");
		buffer.append("and ll.paymentno = rr.serialno ");
		buffer.append("and nn.paymentno=ll.paymentno ");
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimno,te.claimrelationno , ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("ll.paymentno, ");
		buffer.append("rr.compensateno, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("nn.paymentno,");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose ");
		//关联预赔信息
		buffer.append(" union all ");
		buffer.append("SELECT rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("rr.compensateNo, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("sum(rr.payAmount) as sumPaid, ");
		buffer.append("sum(rr.payAmount) as payAmount, ");
		buffer.append("(select decode(sum(payamount), null, 0, '', 0, sum(payamount)) ");
		buffer.append("from prplpaytg prplpay ");
		buffer.append("where prplpay.registno = rr.registno ");
		buffer.append("and prplpay.compensateno = rr.compensateno ");
		buffer.append("and prplpay.policyno = rr.policyno ");
		buffer.append("and prplpay.receiverfullname = nn.receiverfullname ");
		buffer.append("and prplpay.certifno = nn.certifno ");
		buffer.append("and prplpay.serialno <> ll.paymentno ");
		buffer.append("and prplpay.serialno = nn.paymentno ");
		buffer.append("and prplpay.paymenttype = 'P60') as havPay, ");
		buffer.append("nn.paymentno, ");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose ");
		buffer.append("FROM prplpaytg rr, prplpaybilltg ll,prplpaymaintg nn,prplprepaytg te ");
		buffer.append("WHERE  ");
		buffer.append(conditions);
		buffer.append("and te.precompensateno=rr.compensateno ");
		buffer.append("and ll.registno = rr.registno ");
		buffer.append("and ll.compensateno = rr.compensateno ");
		buffer.append("and ll.paymentno = rr.serialno ");
		buffer.append("and nn.paymentno=ll.paymentno ");
		buffer.append("group by rr.registNo, ");
		buffer.append("te.claimno, ");
		buffer.append("rr.policyNo, ");
		buffer.append("rr.serialNo, ");
		buffer.append("ll.paymentno, ");
		buffer.append("rr.compensateno, ");
		buffer.append("nn.receiverfullname, ");
		buffer.append("nn.certifno, ");
		buffer.append("nn.provincecode, ");
		buffer.append("nn.citycode, ");
		buffer.append("nn.accounttype, ");
		buffer.append("nn.accountflag, ");
		buffer.append("nn.banktype, ");
		buffer.append("nn.bank, ");
		buffer.append("nn.bankaccount, ");
		buffer.append("nn.mobilephone, ");
		buffer.append("nn.address, ");
		buffer.append("nn.paymentno,");
		buffer.append("nn.vFlag, ");
		buffer.append("nn.payWay, ");
		buffer.append("nn.payReason, ");
		buffer.append("nn.payPurpose ");
		buffer.append(")");
		buffer.append("group by registNo,claimNo, policyNo, receiverfullname, certifno,provincecode,citycode,accounttype,accountflag,banktype,bank,bankaccount,paymentno,mobilephone,address,vFlag,payWay,payReason,payPurpose ");
		if(!"SHOW".equals(editType)){
			buffer.append("  having sum(payAmount)-sum(havPay)<>0 ");
		}
		buffer.append(")");
		System.err.println(buffer.toString());
		if(logger.isDebugEnabled()){
			logger.debug(buffer.toString());
		}
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
		resultSet.next();
		count = dbManager.getInt(resultSet,1);
		resultSet.close();
		return count;
	}
	
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxSerialNo(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT max(serialno) FROM PrpLclaimBillManager WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
