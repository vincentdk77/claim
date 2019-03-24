package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplpayDto;

/**
 * 这是PRPLPAY的数据访问对象类<br>
 * 创建于 2011-02-15 15:16:49.454<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplpaytg extends DBPrplpaytgBase{
    private static Logger logger = Logger.getLogger(DBPrplpaytg.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplpaytg(DBManager dbManager){
        super(dbManager);
    }
    /**
     * 更新支付标记，
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void updatePayFlag(PrplpayDto prplpayDto)
    throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplpaytg SET ");
        buffer.append("Paydate = ?, ");
        buffer.append("Paycode = ?, ");
        buffer.append("Payflag = ? ");
        buffer.append("WHERE ");
        buffer.append("registno = ? And ");
        buffer.append("Compensateno = ? and");
        buffer.append(" paymenttype =?");
        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setDateTime(1,prplpayDto.getPaydate());
        dbManager.setString(2,prplpayDto.getPaycode());
        dbManager.setString(3,prplpayDto.getPayflag());
        //设置条件字段;
        dbManager.setString(4,prplpayDto.getRegistno());
        dbManager.setString(5,prplpayDto.getCompensateno());
        dbManager.setString(6,prplpayDto.getPaymenttype());
        dbManager.executePreparedUpdate();
        
    }
    
    /**
     * 更新支付标记，
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void updateVFlag(String vflag,String registNo,String compensateNo)
    throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplpaytg SET ");
        buffer.append("vflag = ? ");
        buffer.append("WHERE ");
        //buffer.append("registno = ? And ");
        buffer.append("Compensateno = ? ");
        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,vflag);
        //设置条件字段;
        //dbManager.setString(2,registNo);
        dbManager.setString(2,compensateNo);
        dbManager.executePreparedUpdate();
        
    }
    /**
     * 更新支付标记，
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void updateVFlag(String vflag,String serialno)
    throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplpaytg SET ");
        buffer.append("vflag = ? ");
        buffer.append("WHERE ");
        //buffer.append("registno = ? And ");
        buffer.append("serialno = ? ");
        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,vflag);
        //设置条件字段;
        //dbManager.setString(2,registNo);
        dbManager.setString(2,serialno);
        dbManager.executePreparedUpdate();
        
    }
    
    /**
     * 根据收付编号更新收付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param vflag 支付状态
     * @throws Exception
     */
    public void updateVflagByPaymentNo(String paymentNo,String vflag)throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplpaytg SET ");
        buffer.append("vflag = ? ");
        buffer.append("WHERE ");
        buffer.append("serialno = ? ");
        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,vflag);
        //设置条件字段;
        dbManager.setString(2,paymentNo);
        dbManager.executePreparedUpdate();
    	
    }
    
    /**
     * 根据通知单号获取支付信息、车牌号码、被保险人名称 add by zhongfen
     * @param noticeNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByNoticeNo(String noticeNo) throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        //buffer.append("pay.*,");
        buffer.append("pay.Claimno,");
        buffer.append("pay.Serialno,");
        buffer.append("pay.Compensateno,");
        buffer.append("pay.Classcode,");
        buffer.append("pay.Riskcode,");
        buffer.append("pay.Registno,");
        buffer.append("pay.Policyno,");
        buffer.append("pay.Paytype,");
        buffer.append("pay.Receivertype,");
        buffer.append("pay.Payamount,");
        buffer.append("pay.Banktype,");
        buffer.append("pay.Bank,");
        buffer.append("pay.Banksite,");
        buffer.append("pay.Accounttype,");
        buffer.append("pay.Receiverfullname,");
        buffer.append("pay.Certiftype,");
        buffer.append("pay.Address,");
        buffer.append("pay.Certifno,");
        buffer.append("pay.Familyphone,");
        buffer.append("pay.Officephone,");
        buffer.append("pay.Mobilephone,");
        buffer.append("pay.Payremark,");
        buffer.append("pay.Operatorcode,");
        buffer.append("pay.Inputdate,");
        buffer.append("pay.Paydate,");
        buffer.append("pay.Paycode,");
        buffer.append("pay.Payflag,");
        buffer.append("pay.Paymenttype,");
        buffer.append("pay.Bankaccount,");
        buffer.append("pay.Node,");
        buffer.append("pay.Uploadserialno,");
        buffer.append("pay.Vflag,");
        buffer.append("pay.Comcode,");
        buffer.append("pay.Serialno2, ");
        buffer.append("r.licenseno, r.insuredname ");
        buffer.append(" from prplpay pay, prplregist r");
        buffer.append(" where pay.registno = r.registno ");
        buffer.append("  and pay.serialno in ");
        buffer.append(" (select paymentno from prplpaynoticelist where NOTICENO = '");
        buffer.append(noticeNo);
        buffer.append("')");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());

        //定义返回结果集合
        Collection collection = new ArrayList();
        PrplpayDto prplpayDto = null;
        while(resultSet.next()){

            prplpayDto = new PrplpayDto();
            prplpayDto.setClaimno(dbManager.getString(resultSet,"Claimno"));
            prplpayDto.setSerialno(dbManager.getString(resultSet,"Serialno"));
            prplpayDto.setCompensateno(dbManager.getString(resultSet,"Compensateno"));
            prplpayDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            prplpayDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            prplpayDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplpayDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prplpayDto.setPaytype(dbManager.getString(resultSet,"Paytype"));
            prplpayDto.setReceivertype(dbManager.getString(resultSet,"Receivertype"));
            prplpayDto.setPayamount(dbManager.getDouble(resultSet,"Payamount"));
            prplpayDto.setBanktype(dbManager.getString(resultSet,"Banktype"));
            prplpayDto.setBank(dbManager.getString(resultSet,"Bank"));
            prplpayDto.setBanksite(dbManager.getString(resultSet,"Banksite"));
            prplpayDto.setAccounttype(dbManager.getString(resultSet,"Accounttype"));
            prplpayDto.setReceiverfullname(dbManager.getString(resultSet,"Receiverfullname"));
            prplpayDto.setCertiftype(dbManager.getString(resultSet,"Certiftype"));
            prplpayDto.setAddress(dbManager.getString(resultSet,"Address"));
            prplpayDto.setCertifno(dbManager.getString(resultSet,"Certifno"));
            prplpayDto.setFamilyphone(dbManager.getString(resultSet,"Familyphone"));
            prplpayDto.setOfficephone(dbManager.getString(resultSet,"Officephone"));
            prplpayDto.setMobilephone(dbManager.getString(resultSet,"Mobilephone"));
            prplpayDto.setPayremark(dbManager.getString(resultSet,"Payremark"));
            prplpayDto.setOperatorcode(dbManager.getString(resultSet,"Operatorcode"));
            prplpayDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Inputdate"));
            prplpayDto.setPaydate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Paydate"));
            prplpayDto.setPaycode(dbManager.getString(resultSet,"Paycode"));
            prplpayDto.setPayflag(dbManager.getString(resultSet,"Payflag"));
            prplpayDto.setPaymenttype(dbManager.getString(resultSet,"paymenttype"));
            prplpayDto.setBankaccount(dbManager.getString(resultSet,"bankaccount"));
            prplpayDto.setNode(dbManager.getString(resultSet,"node"));
            prplpayDto.setUploadserialno(dbManager.getString(resultSet,"uploadserialno"));
            prplpayDto.setVFlag(dbManager.getString(resultSet,"vflag"));
            prplpayDto.setComCode(dbManager.getString(resultSet,"comcode"));
            prplpayDto.setSerialNo2(dbManager.getString(resultSet,"Serialno2"));
            //商业险平台标志字段
            //车牌号码
            prplpayDto.setLicenseNo(dbManager.getString(resultSet,"licenseNo"));
            //被保险人名称
            prplpayDto.setInsuredName(dbManager.getString(resultSet,"insuredName"));
            collection.add(prplpayDto);
        }
        resultSet.close();
        return collection;
    	
    	
    }
    /**
     * 根据支付编号获取支付信息、车牌号码、被保险人名称 add by chu
     * @param paymentNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByPaymentNo(String paymentNo) throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        //buffer.append("pay.*,");
        buffer.append("pay.Claimno,");
        buffer.append("pay.Serialno,");
        buffer.append("pay.Compensateno,");
        buffer.append("pay.Classcode,");
        buffer.append("pay.Riskcode,");
        buffer.append("pay.Registno,");
        buffer.append("pay.Policyno,");
        buffer.append("pay.Paytype,");
        buffer.append("pay.Receivertype,");
        buffer.append("pay.Payamount,");
        buffer.append("pay.Banktype,");
        buffer.append("pay.Bank,");
        buffer.append("pay.Banksite,");
        buffer.append("pay.Accounttype,");
        buffer.append("pay.Receiverfullname,");
        buffer.append("pay.Certiftype,");
        buffer.append("pay.Address,");
        buffer.append("pay.Certifno,");
        buffer.append("pay.Familyphone,");
        buffer.append("pay.Officephone,");
        buffer.append("pay.Mobilephone,");
        buffer.append("pay.Payremark,");
        buffer.append("pay.Operatorcode,");
        buffer.append("pay.Inputdate,");
        buffer.append("pay.Paydate,");
        buffer.append("pay.Paycode,");
        buffer.append("pay.Payflag,");
        buffer.append("pay.Paymenttype,");
        buffer.append("pay.Bankaccount,");
        buffer.append("pay.Node,");
        buffer.append("pay.Uploadserialno,");
        buffer.append("pay.Vflag,");
        buffer.append("pay.Comcode,");
        buffer.append("pay.Serialno2, ");
        buffer.append("r.licenseno, r.insuredname ");
        buffer.append(" from prplpay pay, prplregist r");
        buffer.append(" where pay.registno = r.registno ");
        buffer.append("  and pay.serialno ='"+paymentNo+"' ");
//        buffer.append(" (select paymentno from prplpaynoticelist where NOTICENO = '");
//        buffer.append(noticeNo);
//        buffer.append("')");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());

        //定义返回结果集合
        Collection collection = new ArrayList();
        PrplpayDto prplpayDto = null;
        while(resultSet.next()){

            prplpayDto = new PrplpayDto();
            prplpayDto.setClaimno(dbManager.getString(resultSet,"Claimno"));
            prplpayDto.setSerialno(dbManager.getString(resultSet,"Serialno"));
            prplpayDto.setCompensateno(dbManager.getString(resultSet,"Compensateno"));
            prplpayDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            prplpayDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            prplpayDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplpayDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prplpayDto.setPaytype(dbManager.getString(resultSet,"Paytype"));
            prplpayDto.setReceivertype(dbManager.getString(resultSet,"Receivertype"));
            prplpayDto.setPayamount(dbManager.getDouble(resultSet,"Payamount"));
            prplpayDto.setBanktype(dbManager.getString(resultSet,"Banktype"));
            prplpayDto.setBank(dbManager.getString(resultSet,"Bank"));
            prplpayDto.setBanksite(dbManager.getString(resultSet,"Banksite"));
            prplpayDto.setAccounttype(dbManager.getString(resultSet,"Accounttype"));
            prplpayDto.setReceiverfullname(dbManager.getString(resultSet,"Receiverfullname"));
            prplpayDto.setCertiftype(dbManager.getString(resultSet,"Certiftype"));
            prplpayDto.setAddress(dbManager.getString(resultSet,"Address"));
            prplpayDto.setCertifno(dbManager.getString(resultSet,"Certifno"));
            prplpayDto.setFamilyphone(dbManager.getString(resultSet,"Familyphone"));
            prplpayDto.setOfficephone(dbManager.getString(resultSet,"Officephone"));
            prplpayDto.setMobilephone(dbManager.getString(resultSet,"Mobilephone"));
            prplpayDto.setPayremark(dbManager.getString(resultSet,"Payremark"));
            prplpayDto.setOperatorcode(dbManager.getString(resultSet,"Operatorcode"));
            prplpayDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Inputdate"));
            prplpayDto.setPaydate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Paydate"));
            prplpayDto.setPaycode(dbManager.getString(resultSet,"Paycode"));
            prplpayDto.setPayflag(dbManager.getString(resultSet,"Payflag"));
            prplpayDto.setPaymenttype(dbManager.getString(resultSet,"paymenttype"));
            prplpayDto.setBankaccount(dbManager.getString(resultSet,"bankaccount"));
            prplpayDto.setNode(dbManager.getString(resultSet,"node"));
            prplpayDto.setUploadserialno(dbManager.getString(resultSet,"uploadserialno"));
            prplpayDto.setVFlag(dbManager.getString(resultSet,"vflag"));
            prplpayDto.setComCode(dbManager.getString(resultSet,"comcode"));
            prplpayDto.setSerialNo2(dbManager.getString(resultSet,"Serialno2"));
            //商业险平台标志字段
            //车牌号码
            prplpayDto.setLicenseNo(dbManager.getString(resultSet,"licenseNo"));
            //被保险人名称
            prplpayDto.setInsuredName(dbManager.getString(resultSet,"insuredName"));
            collection.add(prplpayDto);
        }
        resultSet.close();
        return collection;
    	
    	
    }
	public Collection findByConditionsSql(String conditions) throws Exception{
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Claimno,");
        buffer.append("Serialno,");
        buffer.append("Compensateno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Paytype,");
        buffer.append("Receivertype,");
        buffer.append("Payamount,");
        buffer.append("Banktype,");
        buffer.append("Bank,");
        buffer.append("Banksite,");
        buffer.append("Accounttype,");
        buffer.append("Receiverfullname,");
        buffer.append("Certiftype,");
        buffer.append("Address,");
        buffer.append("Certifno,");
        buffer.append("Familyphone,");
        buffer.append("Officephone,");
        buffer.append("Mobilephone,");
        buffer.append("Payremark,");
        buffer.append("Operatorcode,");
        buffer.append("Inputdate,");
        buffer.append("Paydate,");
        buffer.append("Paycode,");
        buffer.append("Payflag,");
        buffer.append("Paymenttype,");
        buffer.append("Bankaccount,");
        buffer.append("Node,");
        buffer.append("Uploadserialno,");
        buffer.append("Vflag,");
        buffer.append("Comcode,");
        buffer.append("Serialno2, ");
        buffer.append("operatorComCode, ");
        buffer.append("coinsCode ");
        buffer.append("FROM Prplpaytg where ");
        buffer.append(conditions);
        Collection collection = new ArrayList();
        PrplpayDto prplpayDto = null;System.err.println(buffer.toString());
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        while(resultSet.next()){
        	prplpayDto = new PrplpayDto();
            prplpayDto.setClaimno(dbManager.getString(resultSet,1));
            prplpayDto.setSerialno(dbManager.getString(resultSet,2));
            prplpayDto.setCompensateno(dbManager.getString(resultSet,3));
            prplpayDto.setClasscode(dbManager.getString(resultSet,4));
            prplpayDto.setRiskcode(dbManager.getString(resultSet,5));
            prplpayDto.setRegistno(dbManager.getString(resultSet,6));
            prplpayDto.setPolicyno(dbManager.getString(resultSet,7));
            prplpayDto.setPaytype(dbManager.getString(resultSet,8));
            prplpayDto.setReceivertype(dbManager.getString(resultSet,9));
            prplpayDto.setPayamount(dbManager.getDouble(resultSet,10));
            prplpayDto.setBanktype(dbManager.getString(resultSet,11));
            prplpayDto.setBank(dbManager.getString(resultSet,12));
            prplpayDto.setBanksite(dbManager.getString(resultSet,13));
            prplpayDto.setAccounttype(dbManager.getString(resultSet,14));
            prplpayDto.setReceiverfullname(dbManager.getString(resultSet,15));
            prplpayDto.setCertiftype(dbManager.getString(resultSet,16));
            prplpayDto.setAddress(dbManager.getString(resultSet,17));
            prplpayDto.setCertifno(dbManager.getString(resultSet,18));
            prplpayDto.setFamilyphone(dbManager.getString(resultSet,19));
            prplpayDto.setOfficephone(dbManager.getString(resultSet,20));
            prplpayDto.setMobilephone(dbManager.getString(resultSet,21));
            prplpayDto.setPayremark(dbManager.getString(resultSet,22));
            prplpayDto.setOperatorcode(dbManager.getString(resultSet,23));
            prplpayDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,24));
            prplpayDto.setPaydate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,25));
            prplpayDto.setPaycode(dbManager.getString(resultSet,26));
            prplpayDto.setPayflag(dbManager.getString(resultSet,27));
            prplpayDto.setPaymenttype(dbManager.getString(resultSet,28));
            prplpayDto.setBankaccount(dbManager.getString(resultSet,29));
            prplpayDto.setNode(dbManager.getString(resultSet,30));
            prplpayDto.setUploadserialno(dbManager.getString(resultSet,31));
            prplpayDto.setVFlag(dbManager.getString(resultSet,32));
            prplpayDto.setComCode(dbManager.getString(resultSet,33));
            prplpayDto.setSerialNo2(dbManager.getString(resultSet,34));
            prplpayDto.setOperatorComCode(dbManager.getString(resultSet,35));
            prplpayDto.setCoinsCode(dbManager.getString(resultSet,36));
        	collection.add(prplpayDto);
        }
        resultSet.close();
        return collection;
	}
	/*****************************优化修改：start*********************************/
	public Collection findByConditionsSqlByprepered(String conditions,String Serialno,String Compensateno,double Payamount) throws Exception{
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Claimno,");
        buffer.append("Serialno,");
        buffer.append("Compensateno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Paytype,");
        buffer.append("Receivertype,");
        buffer.append("Payamount,");
        buffer.append("Banktype,");
        buffer.append("Bank,");
        buffer.append("Banksite,");
        buffer.append("Accounttype,");
        buffer.append("Receiverfullname,");
        buffer.append("Certiftype,");
        buffer.append("Address,");
        buffer.append("Certifno,");
        buffer.append("Familyphone,");
        buffer.append("Officephone,");
        buffer.append("Mobilephone,");
        buffer.append("Payremark,");
        buffer.append("Operatorcode,");
        buffer.append("Inputdate,");
        buffer.append("Paydate,");
        buffer.append("Paycode,");
        buffer.append("Payflag,");
        buffer.append("Paymenttype,");
        buffer.append("Bankaccount,");
        buffer.append("Node,");
        buffer.append("Uploadserialno,");
        buffer.append("Vflag,");
        buffer.append("Comcode,");
        buffer.append("Serialno2, ");
        buffer.append("operatorComCode , ");
        buffer.append("coinsCode ");
        buffer.append("FROM Prplpaytg where ");
        buffer.append(conditions);
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1, Serialno);
        dbManager.setString(2, Compensateno);
        dbManager.setDouble(3, Payamount);
        
        Collection collection = new ArrayList();
        PrplpayDto prplpayDto = null;System.err.println(buffer.toString());
        ResultSet resultSet = dbManager.executePreparedQuery();
        while(resultSet.next()){
        	prplpayDto = new PrplpayDto();
            prplpayDto.setClaimno(dbManager.getString(resultSet,1));
            prplpayDto.setSerialno(dbManager.getString(resultSet,2));
            prplpayDto.setCompensateno(dbManager.getString(resultSet,3));
            prplpayDto.setClasscode(dbManager.getString(resultSet,4));
            prplpayDto.setRiskcode(dbManager.getString(resultSet,5));
            prplpayDto.setRegistno(dbManager.getString(resultSet,6));
            prplpayDto.setPolicyno(dbManager.getString(resultSet,7));
            prplpayDto.setPaytype(dbManager.getString(resultSet,8));
            prplpayDto.setReceivertype(dbManager.getString(resultSet,9));
            prplpayDto.setPayamount(dbManager.getDouble(resultSet,10));
            prplpayDto.setBanktype(dbManager.getString(resultSet,11));
            prplpayDto.setBank(dbManager.getString(resultSet,12));
            prplpayDto.setBanksite(dbManager.getString(resultSet,13));
            prplpayDto.setAccounttype(dbManager.getString(resultSet,14));
            prplpayDto.setReceiverfullname(dbManager.getString(resultSet,15));
            prplpayDto.setCertiftype(dbManager.getString(resultSet,16));
            prplpayDto.setAddress(dbManager.getString(resultSet,17));
            prplpayDto.setCertifno(dbManager.getString(resultSet,18));
            prplpayDto.setFamilyphone(dbManager.getString(resultSet,19));
            prplpayDto.setOfficephone(dbManager.getString(resultSet,20));
            prplpayDto.setMobilephone(dbManager.getString(resultSet,21));
            prplpayDto.setPayremark(dbManager.getString(resultSet,22));
            prplpayDto.setOperatorcode(dbManager.getString(resultSet,23));
            prplpayDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,24));
            prplpayDto.setPaydate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,25));
            prplpayDto.setPaycode(dbManager.getString(resultSet,26));
            prplpayDto.setPayflag(dbManager.getString(resultSet,27));
            prplpayDto.setPaymenttype(dbManager.getString(resultSet,28));
            prplpayDto.setBankaccount(dbManager.getString(resultSet,29));
            prplpayDto.setNode(dbManager.getString(resultSet,30));
            prplpayDto.setUploadserialno(dbManager.getString(resultSet,31));
            prplpayDto.setVFlag(dbManager.getString(resultSet,32));
            prplpayDto.setComCode(dbManager.getString(resultSet,33));
            prplpayDto.setSerialNo2(dbManager.getString(resultSet,34));
            prplpayDto.setOperatorComCode(dbManager.getString(resultSet,35));
            prplpayDto.setCoinsCode(dbManager.getString(resultSet,36));
        	collection.add(prplpayDto);
        }
        resultSet.close();
        return collection;
	}
	/*****************************优化修改：end*********************************/
}
