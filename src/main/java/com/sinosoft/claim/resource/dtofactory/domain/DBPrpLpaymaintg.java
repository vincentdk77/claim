package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PayStatisticsDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;

/**
 * 这是支付信息主表的数据访问对象类<br>
 * 创建于 2013-06-26 09:27:54.177<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpaymaintg extends DBPrpLpaymaintgBase{
    private static Logger logger = Logger.getLogger(DBPrpLpaymaintg.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpaymaintg(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * 根据收付编号更新支付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param vflag 支付状态
     * @throws Exception
     */
    public void updateByKey(String paymentNo,String vflag)throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpaymaintg SET ");
        buffer.append("Vflag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("Vflag = '" + vflag + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PaymentNo=").append("'").append(paymentNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,vflag);
        //设置条件字段;
        dbManager.setString(2,paymentNo);
        dbManager.executePreparedUpdate();
    	
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findPayQueryByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT DISTINCT ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,'') as PaymentNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayType,'',PrpLpaymain.PayType,'') as PayType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) as PayAmount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankType,'',PrpLpaymain.BankType,'') as BankType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Bank,'',PrpLpaymain.Bank,'') as Bank,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankSite,'',PrpLpaymain.BankSite,'') as BankSite,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.AccountType,'',PrpLpaymain.AccountType,'') as AccountType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullName,'',PrpLpaymain.ReceiverFullName,'') as ReceiverFullName,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullCode,'',PrpLpaymain.ReceiverFullCode,'') as ReceiverFullCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifType,'',PrpLpaymain.CertifType,'') as CertifType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Address,'',PrpLpaymain.Address,'') as Address,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifNo,'',PrpLpaymain.CertifNo,'') as CertifNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.FamilyPhone,'',PrpLpaymain.FamilyPhone,'') as FamilyPhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OfficePhone,'',PrpLpaymain.OfficePhone,'') as OfficePhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MobilePhone,'',PrpLpaymain.MobilePhone,'') as MobilePhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayRemark,'',PrpLpaymain.PayRemark,'') as PayRemark,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OperatorCode,'',PrpLpaymain.OperatorCode,'') as OperatorCode,");
        buffer.append("min(PrpLpaymain.InputDate),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayDate,'',PrpLpaymain.PayDate,'') as PayDate,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayCode,'',PrpLpaymain.PayCode,'') as PayCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpay.PayFlag,'',PrpLpay.PayFlag,'') as PayFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentType,'',PrpLpaymain.PaymentType,'') as PaymentType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankAccount,'',PrpLpaymain.BankAccount,'') as BankAccount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Node,'',PrpLpaymain.Node,'') as Node,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UpLoadSerialNo,'',PrpLpaymain.UpLoadSerialNo,'') as UpLoadSerialNo,");
        buffer.append("PrpLpaymain.Vflag,");
        buffer.append("PrpLpaymain.ComCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MergerFlag,'',PrpLpaymain.MergerFlag,'') as MergerFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayTotalAmount,'',PrpLpaymain.PayTotalAmount,'') as PayTotalAmount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UrgentType,'',PrpLpaymain.UrgentType,'') as UrgentType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOther,'',PrpLpaymain.ReceiverTypeOther,'') as ReceiverTypeOther,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOtherName,'',PrpLpaymain.ReceiverTypeOtherName,'') as ReceiverTypeOtherName,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.QqNumber,'',PrpLpaymain.QqNumber,'') as QqNumber,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Email,'',PrpLpaymain.Email,'') as Email,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UnitLink,'',PrpLpaymain.UnitLink,'') as UnitLink,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PostCode,'',PrpLpaymain.PostCode,'') as PostCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.VerifyFlag,'',PrpLpaymain.VerifyFlag,'') as VerifyFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.NoticeNo,'',PrpLpaymain.NoticeNo,'') as NoticeNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.provinceCode,'',PrpLpaymain.provinceCode,'') as provinceCode, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.cityCode,'',PrpLpaymain.cityCode,'') as cityCode, ");
        buffer.append("PrpLpaymain.thirdPayFlag, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payWay,'',PrpLpaymain.payWay,'') as payWay, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payReason,'',PrpLpaymain.payReason,'') as payReason, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payPurpose,'',PrpLpaymain.payPurpose,'') as payPurpose, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.accountFlag,'',PrpLpaymain.accountFlag,'') as accountFlag, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.interType,'',PrpLpaymain.interType,'') as interType, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.routeNum,'',PrpLpaymain.routeNum,'') as routeNum, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.billFlag,'',PrpLpaymain.billFlag,'') as billFlag,");
        buffer.append("PrpLpaymain.nobillFlag  as nobillFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billno),");
        buffer.append("decode(prplpaybill.billno,null,'0','',0,'1'),");
        buffer.append("PrpLpaymain.thirdPayType ");
        buffer.append("FROM PrpLpaymaintg PrpLpaymain,prplpaytg prplpay,prplregisttg prplregist,prplpaybilltg prplpaybill,(select billno,sum(payAmount) as payAmount from prplpaybilltg prplpaybill group by billno) kk WHERE ");
        buffer.append(conditions);
        buffer.append("group by ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayType,'',PrpLpaymain.PayType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankType,'',PrpLpaymain.BankType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Bank,'',PrpLpaymain.Bank,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankSite,'',PrpLpaymain.BankSite,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.AccountType,'',PrpLpaymain.AccountType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullName,'',PrpLpaymain.ReceiverFullName,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullCode,'',PrpLpaymain.ReceiverFullCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifType,'',PrpLpaymain.CertifType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Address,'',PrpLpaymain.Address,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifNo,'',PrpLpaymain.CertifNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.FamilyPhone,'',PrpLpaymain.FamilyPhone,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OfficePhone,'',PrpLpaymain.OfficePhone,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MobilePhone,'',PrpLpaymain.MobilePhone,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayRemark,'',PrpLpaymain.PayRemark,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OperatorCode,'',PrpLpaymain.OperatorCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayDate,'',PrpLpaymain.PayDate,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayCode,'',PrpLpaymain.PayCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpay.PayFlag,'',PrpLpay.PayFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentType,'',PrpLpaymain.PaymentType,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankAccount,'',PrpLpaymain.BankAccount,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Node,'',PrpLpaymain.Node,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UpLoadSerialNo,'',PrpLpaymain.UpLoadSerialNo,'') ,");
        buffer.append("PrpLpaymain.Vflag,");
        buffer.append("PrpLpaymain.ComCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MergerFlag,'',PrpLpaymain.MergerFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayTotalAmount,'',PrpLpaymain.PayTotalAmount,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UrgentType,'',PrpLpaymain.UrgentType,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOther,'',PrpLpaymain.ReceiverTypeOther,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOtherName,'',PrpLpaymain.ReceiverTypeOtherName,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.QqNumber,'',PrpLpaymain.QqNumber,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Email,'',PrpLpaymain.Email,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UnitLink,'',PrpLpaymain.UnitLink,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PostCode,'',PrpLpaymain.PostCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.VerifyFlag,'',PrpLpaymain.VerifyFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.NoticeNo,'',PrpLpaymain.NoticeNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.provinceCode,'',PrpLpaymain.provinceCode,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.cityCode,'',PrpLpaymain.cityCode,'') , ");
        buffer.append("PrpLpaymain.thirdPayFlag , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payWay,'',PrpLpaymain.payWay,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payReason,'',PrpLpaymain.payReason,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payPurpose,'',PrpLpaymain.payPurpose,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.accountFlag,'',PrpLpaymain.accountFlag,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.interType,'',PrpLpaymain.interType,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.routeNum,'',PrpLpaymain.routeNum,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.billFlag,'',PrpLpaymain.billFlag,'') ,");
        buffer.append("PrpLpaymain.nobillFlag ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billno),");
        buffer.append("decode(prplpaybill.billno,null,'0','',0,'1'),");
        buffer.append("PrpLpaymain.thirdPayType ");
        buffer.append(" order by min(prplpaymain.inputdate) desc ");
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //目前只对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }System.err.println(buffer.toString());
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLpaymainDto prpLpaymainDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpaymainDto = new PrpLpaymainDto();
            prpLpaymainDto.setPaymentNo(dbManager.getString(resultSet,1));
            prpLpaymainDto.setPayType(dbManager.getString(resultSet,2));
            prpLpaymainDto.setPayAmount(dbManager.getDouble(resultSet,3));
            prpLpaymainDto.setBankType(dbManager.getString(resultSet,4));
            prpLpaymainDto.setBank(dbManager.getString(resultSet,5));
            prpLpaymainDto.setBankSite(dbManager.getString(resultSet,6));
            prpLpaymainDto.setAccountType(dbManager.getString(resultSet,7));
            prpLpaymainDto.setReceiverFullName(dbManager.getString(resultSet,8));
            prpLpaymainDto.setReceiverFullCode(dbManager.getString(resultSet,9));
            prpLpaymainDto.setCertifType(dbManager.getString(resultSet,10));
            prpLpaymainDto.setAddress(dbManager.getString(resultSet,11));
            prpLpaymainDto.setCertifNo(dbManager.getString(resultSet,12));
            prpLpaymainDto.setFamilyPhone(dbManager.getString(resultSet,13));
            prpLpaymainDto.setOfficePhone(dbManager.getString(resultSet,14));
            prpLpaymainDto.setMobilePhone(dbManager.getString(resultSet,15));
            prpLpaymainDto.setPayRemark(dbManager.getString(resultSet,16));
            prpLpaymainDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpLpaymainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,18));
            prpLpaymainDto.setPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,19));
            prpLpaymainDto.setPayCode(dbManager.getString(resultSet,20));
            prpLpaymainDto.setPayFlag(dbManager.getString(resultSet,21));
            prpLpaymainDto.setPaymentType(dbManager.getString(resultSet,22));
            prpLpaymainDto.setBankAccount(dbManager.getString(resultSet,23));
            prpLpaymainDto.setNode(dbManager.getString(resultSet,24));
            prpLpaymainDto.setUpLoadSerialNo(dbManager.getString(resultSet,25));
            prpLpaymainDto.setVflag(dbManager.getString(resultSet,26));
            prpLpaymainDto.setComCode(dbManager.getString(resultSet,27));
            prpLpaymainDto.setMergerFlag(dbManager.getString(resultSet,28));
            prpLpaymainDto.setPayTotalAmount(dbManager.getDouble(resultSet,29));
            prpLpaymainDto.setUrgentType(dbManager.getString(resultSet,30));
            prpLpaymainDto.setReceiverTypeOther(dbManager.getString(resultSet,31));
            prpLpaymainDto.setReceiverTypeOtherName(dbManager.getString(resultSet,32));
            prpLpaymainDto.setQqNumber(dbManager.getString(resultSet,33));
            prpLpaymainDto.setEmail(dbManager.getString(resultSet,34));
            prpLpaymainDto.setUnitLink(dbManager.getString(resultSet,35));
            prpLpaymainDto.setPostCode(dbManager.getString(resultSet,36));
            prpLpaymainDto.setVerifyFlag(dbManager.getString(resultSet,37));
            prpLpaymainDto.setNoticeNo(dbManager.getString(resultSet,38));
            prpLpaymainDto.setProvinceCode(dbManager.getString(resultSet,39));
            prpLpaymainDto.setCityCode(dbManager.getString(resultSet,40));
            prpLpaymainDto.setThirdPayFlag(dbManager.getString(resultSet,41));
            prpLpaymainDto.setPayWay(dbManager.getString(resultSet,42));
            prpLpaymainDto.setPayReason(dbManager.getString(resultSet,43));
            prpLpaymainDto.setPayPurpose(dbManager.getString(resultSet,44));
            prpLpaymainDto.setAccountFlag(dbManager.getString(resultSet,45));
            prpLpaymainDto.setInterType(dbManager.getString(resultSet,46));
            prpLpaymainDto.setRouteNum(dbManager.getString(resultSet,47));
            prpLpaymainDto.setBillFlag(dbManager.getString(resultSet, 48));
            prpLpaymainDto.setNoBillFlag(dbManager.getString(resultSet, 49));
            prpLpaymainDto.setBillNo(dbManager.getString(resultSet, 50));
            prpLpaymainDto.setBillNoFlag(dbManager.getString(resultSet, 51));
            prpLpaymainDto.setThirdPayType(dbManager.getString(resultSet, 52));
            collection.add(prpLpaymainDto);
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
    public int getPayQueryCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(1) FROM ( ");
        buffer.append("SELECT DISTINCT ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,'') as PaymentNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayType,'',PrpLpaymain.PayType,'') as PayType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) as PayAmount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankType,'',PrpLpaymain.BankType,'') as BankType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Bank,'',PrpLpaymain.Bank,'') as Bank,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankSite,'',PrpLpaymain.BankSite,'') as BankSite,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.AccountType,'',PrpLpaymain.AccountType,'') as AccountType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullName,'',PrpLpaymain.ReceiverFullName,'') as ReceiverFullName,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullCode,'',PrpLpaymain.ReceiverFullCode,'') as ReceiverFullCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifType,'',PrpLpaymain.CertifType,'') as CertifType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Address,'',PrpLpaymain.Address,'') as Address,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifNo,'',PrpLpaymain.CertifNo,'') as CertifNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.FamilyPhone,'',PrpLpaymain.FamilyPhone,'') as FamilyPhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OfficePhone,'',PrpLpaymain.OfficePhone,'') as OfficePhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MobilePhone,'',PrpLpaymain.MobilePhone,'') as MobilePhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayRemark,'',PrpLpaymain.PayRemark,'') as PayRemark,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OperatorCode,'',PrpLpaymain.OperatorCode,'') as OperatorCode,");
        buffer.append("min(PrpLpaymain.InputDate),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayDate,'',PrpLpaymain.PayDate,'') as PayDate,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayCode,'',PrpLpaymain.PayCode,'') as PayCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpay.PayFlag,'',PrpLpay.PayFlag,'') as PayFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentType,'',PrpLpaymain.PaymentType,'') as PaymentType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankAccount,'',PrpLpaymain.BankAccount,'') as BankAccount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Node,'',PrpLpaymain.Node,'') as Node,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UpLoadSerialNo,'',PrpLpaymain.UpLoadSerialNo,'') as UpLoadSerialNo,");
        buffer.append("PrpLpaymain.Vflag,");
        buffer.append("PrpLpaymain.ComCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MergerFlag,'',PrpLpaymain.MergerFlag,'') as MergerFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayTotalAmount,'',PrpLpaymain.PayTotalAmount,'') as PayTotalAmount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UrgentType,'',PrpLpaymain.UrgentType,'') as UrgentType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOther,'',PrpLpaymain.ReceiverTypeOther,'') as ReceiverTypeOther,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOtherName,'',PrpLpaymain.ReceiverTypeOtherName,'') as ReceiverTypeOtherName,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.QqNumber,'',PrpLpaymain.QqNumber,'') as QqNumber,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Email,'',PrpLpaymain.Email,'') as Email,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UnitLink,'',PrpLpaymain.UnitLink,'') as UnitLink,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PostCode,'',PrpLpaymain.PostCode,'') as PostCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.VerifyFlag,'',PrpLpaymain.VerifyFlag,'') as VerifyFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.NoticeNo,'',PrpLpaymain.NoticeNo,'') as NoticeNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.provinceCode,'',PrpLpaymain.provinceCode,'') as provinceCode, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.cityCode,'',PrpLpaymain.cityCode,'') as cityCode, ");
        buffer.append("PrpLpaymain.thirdPayFlag, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payWay,'',PrpLpaymain.payWay,'') as payWay, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payReason,'',PrpLpaymain.payReason,'') as payReason, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payPurpose,'',PrpLpaymain.payPurpose,'') as payPurpose, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.accountFlag,'',PrpLpaymain.accountFlag,'') as accountFlag, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.interType,'',PrpLpaymain.interType,'') as interType, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.routeNum,'',PrpLpaymain.routeNum,'') as routeNum, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.billFlag,'',PrpLpaymain.billFlag,'') as billFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billno),");
        buffer.append("decode(prplpaybill.billno,null,'0','',0,'1'),");
        buffer.append("PrpLpaymain.thirdPayType ");
        buffer.append("FROM PrpLpaymaintg PrpLpaymain,prplpaytg prplpay,prplregisttg prplregist,prplpaybilltg prplpaybill,(select billno,sum(payAmount) as payAmount from prplpaybilltg prplpaybill group by billno) kk WHERE ");
        buffer.append(conditions);
        buffer.append("group by ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayType,'',PrpLpaymain.PayType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankType,'',PrpLpaymain.BankType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Bank,'',PrpLpaymain.Bank,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankSite,'',PrpLpaymain.BankSite,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.AccountType,'',PrpLpaymain.AccountType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullName,'',PrpLpaymain.ReceiverFullName,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullCode,'',PrpLpaymain.ReceiverFullCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifType,'',PrpLpaymain.CertifType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Address,'',PrpLpaymain.Address,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifNo,'',PrpLpaymain.CertifNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.FamilyPhone,'',PrpLpaymain.FamilyPhone,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OfficePhone,'',PrpLpaymain.OfficePhone,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MobilePhone,'',PrpLpaymain.MobilePhone,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayRemark,'',PrpLpaymain.PayRemark,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OperatorCode,'',PrpLpaymain.OperatorCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayDate,'',PrpLpaymain.PayDate,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayCode,'',PrpLpaymain.PayCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpay.PayFlag,'',PrpLpay.PayFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentType,'',PrpLpaymain.PaymentType,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankAccount,'',PrpLpaymain.BankAccount,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Node,'',PrpLpaymain.Node,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UpLoadSerialNo,'',PrpLpaymain.UpLoadSerialNo,'') ,");
        buffer.append("PrpLpaymain.Vflag,");
        buffer.append("PrpLpaymain.ComCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MergerFlag,'',PrpLpaymain.MergerFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayTotalAmount,'',PrpLpaymain.PayTotalAmount,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UrgentType,'',PrpLpaymain.UrgentType,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOther,'',PrpLpaymain.ReceiverTypeOther,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOtherName,'',PrpLpaymain.ReceiverTypeOtherName,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.QqNumber,'',PrpLpaymain.QqNumber,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Email,'',PrpLpaymain.Email,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UnitLink,'',PrpLpaymain.UnitLink,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PostCode,'',PrpLpaymain.PostCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.VerifyFlag,'',PrpLpaymain.VerifyFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.NoticeNo,'',PrpLpaymain.NoticeNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.provinceCode,'',PrpLpaymain.provinceCode,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.cityCode,'',PrpLpaymain.cityCode,'') , ");
        buffer.append("PrpLpaymain.thirdPayFlag , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payWay,'',PrpLpaymain.payWay,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payReason,'',PrpLpaymain.payReason,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payPurpose,'',PrpLpaymain.payPurpose,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.accountFlag,'',PrpLpaymain.accountFlag,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.interType,'',PrpLpaymain.interType,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.routeNum,'',PrpLpaymain.routeNum,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.billFlag,'',PrpLpaymain.billFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billno),");
        buffer.append("decode(prplpaybill.billno,null,'0','',0,'1'),");
        buffer.append("PrpLpaymain.thirdPayType ");
        buffer.append(")");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }System.err.println(buffer.toString());
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
    public int getPayQueryCountNew(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(1) FROM ( ");
        buffer.append("SELECT DISTINCT ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,'') as PaymentNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayType,'',PrpLpaymain.PayType,'') as PayType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) as PayAmount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankType,'',PrpLpaymain.BankType,'') as BankType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Bank,'',PrpLpaymain.Bank,'') as Bank,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankSite,'',PrpLpaymain.BankSite,'') as BankSite,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.AccountType,'',PrpLpaymain.AccountType,'') as AccountType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullName,'',PrpLpaymain.ReceiverFullName,'') as ReceiverFullName,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullCode,'',PrpLpaymain.ReceiverFullCode,'') as ReceiverFullCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifType,'',PrpLpaymain.CertifType,'') as CertifType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Address,'',PrpLpaymain.Address,'') as Address,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifNo,'',PrpLpaymain.CertifNo,'') as CertifNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.FamilyPhone,'',PrpLpaymain.FamilyPhone,'') as FamilyPhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OfficePhone,'',PrpLpaymain.OfficePhone,'') as OfficePhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MobilePhone,'',PrpLpaymain.MobilePhone,'') as MobilePhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayRemark,'',PrpLpaymain.PayRemark,'') as PayRemark,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OperatorCode,'',PrpLpaymain.OperatorCode,'') as OperatorCode,");
        buffer.append("min(PrpLpaymain.InputDate),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayDate,'',PrpLpaymain.PayDate,'') as PayDate,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayCode,'',PrpLpaymain.PayCode,'') as PayCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpay.PayFlag,'',PrpLpay.PayFlag,'') as PayFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentType,'',PrpLpaymain.PaymentType,'') as PaymentType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankAccount,'',PrpLpaymain.BankAccount,'') as BankAccount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Node,'',PrpLpaymain.Node,'') as Node,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UpLoadSerialNo,'',PrpLpaymain.UpLoadSerialNo,'') as UpLoadSerialNo,");
        buffer.append("PrpLpaymain.Vflag,");
        buffer.append("PrpLpaymain.ComCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MergerFlag,'',PrpLpaymain.MergerFlag,'') as MergerFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayTotalAmount,'',PrpLpaymain.PayTotalAmount,'') as PayTotalAmount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UrgentType,'',PrpLpaymain.UrgentType,'') as UrgentType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOther,'',PrpLpaymain.ReceiverTypeOther,'') as ReceiverTypeOther,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOtherName,'',PrpLpaymain.ReceiverTypeOtherName,'') as ReceiverTypeOtherName,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.QqNumber,'',PrpLpaymain.QqNumber,'') as QqNumber,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Email,'',PrpLpaymain.Email,'') as Email,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UnitLink,'',PrpLpaymain.UnitLink,'') as UnitLink,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PostCode,'',PrpLpaymain.PostCode,'') as PostCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.VerifyFlag,'',PrpLpaymain.VerifyFlag,'') as VerifyFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.NoticeNo,'',PrpLpaymain.NoticeNo,'') as NoticeNo,");
       
        buffer.append("prplregist.registNo, ");
        buffer.append("prplregist.policyNo, ");
        buffer.append("prplregist.insuredName, ");
        buffer.append("prplregist.licenseNo, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.thirdPayFlag,'',PrpLpaymain.thirdPayFlag,'') as thirdPayFlag, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payWay,'',PrpLpaymain.payWay,'') as payWay, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payReason,'',PrpLpaymain.payReason,'') as payReason, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payPurpose,'',PrpLpaymain.payPurpose,'') as payPurpose, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.accountFlag,'',PrpLpaymain.accountFlag,'') as accountFlag, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.interType,'',PrpLpaymain.interType,'') as interType, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.routeNum,'',PrpLpaymain.routeNum,'') as routeNum, ");
        buffer.append("PrpLpaymain.thirdPayType, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) as payAmountSub, ");
        buffer.append("PrpLpaymain.billFlag, ");
        buffer.append("decode(prplpaybill.billNo,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billNo),");
        buffer.append("decode(prplpaybill.billNo,null,'0','',0,'1')");
        buffer.append("FROM PrpLpaymain,prplpay,prplregist,prplpaybill,(select billno,sum(payAmount) as payAmount from prplpaybill group by billno) kk WHERE ");
        buffer.append(conditions);
        buffer.append("group by ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayType,'',PrpLpaymain.PayType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankType,'',PrpLpaymain.BankType,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Bank,'',PrpLpaymain.Bank,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankSite,'',PrpLpaymain.BankSite,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.AccountType,'',PrpLpaymain.AccountType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullName,'',PrpLpaymain.ReceiverFullName,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullCode,'',PrpLpaymain.ReceiverFullCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifType,'',PrpLpaymain.CertifType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Address,'',PrpLpaymain.Address,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifNo,'',PrpLpaymain.CertifNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.FamilyPhone,'',PrpLpaymain.FamilyPhone,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OfficePhone,'',PrpLpaymain.OfficePhone,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MobilePhone,'',PrpLpaymain.MobilePhone,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayRemark,'',PrpLpaymain.PayRemark,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OperatorCode,'',PrpLpaymain.OperatorCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayDate,'',PrpLpaymain.PayDate,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayCode,'',PrpLpaymain.PayCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpay.PayFlag,'',PrpLpay.PayFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentType,'',PrpLpaymain.PaymentType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankAccount,'',PrpLpaymain.BankAccount,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Node,'',PrpLpaymain.Node,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UpLoadSerialNo,'',PrpLpaymain.UpLoadSerialNo,'') ,");
        buffer.append("PrpLpaymain.Vflag,");
        buffer.append("PrpLpaymain.ComCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MergerFlag,'',PrpLpaymain.MergerFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayTotalAmount,'',PrpLpaymain.PayTotalAmount,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UrgentType,'',PrpLpaymain.UrgentType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOther,'',PrpLpaymain.ReceiverTypeOther,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOtherName,'',PrpLpaymain.ReceiverTypeOtherName,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.QqNumber,'',PrpLpaymain.QqNumber,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Email,'',PrpLpaymain.Email,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UnitLink,'',PrpLpaymain.UnitLink,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PostCode,'',PrpLpaymain.PostCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.VerifyFlag,'',PrpLpaymain.VerifyFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.NoticeNo,'',PrpLpaymain.NoticeNo,'') ,");
       
        buffer.append("prplregist.registNo, ");
        buffer.append("prplregist.policyNo, ");
        buffer.append("prplregist.insuredName, ");
        buffer.append("prplregist.licenseNo, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.thirdPayFlag,'',PrpLpaymain.thirdPayFlag,''), ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payWay,'',PrpLpaymain.payWay,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payReason,'',PrpLpaymain.payReason,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payPurpose,'',PrpLpaymain.payPurpose,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.accountFlag,'',PrpLpaymain.accountFlag,''), ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.interType,'',PrpLpaymain.interType,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.routeNum,'',PrpLpaymain.routeNum,'') , ");
        buffer.append("PrpLpaymain.thirdPayType, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) , ");
        buffer.append("PrpLpaymain.billFlag, ");
        buffer.append("decode(prplpaybill.billNo,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billNo),");
        buffer.append("decode(prplpaybill.billNo,null,'0','',0,'1')");
        buffer.append(")");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        System.out.println("buffercount:"+buffer);
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findPayQueryByConditionsNew(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT DISTINCT ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,'') as PaymentNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayType,'',PrpLpaymain.PayType,'') as PayType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) as PayAmount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankType,'',PrpLpaymain.BankType,'') as BankType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Bank,'',PrpLpaymain.Bank,'') as Bank,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankSite,'',PrpLpaymain.BankSite,'') as BankSite,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.AccountType,'',PrpLpaymain.AccountType,'') as AccountType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullName,'',PrpLpaymain.ReceiverFullName,'') as ReceiverFullName,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullCode,'',PrpLpaymain.ReceiverFullCode,'') as ReceiverFullCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifType,'',PrpLpaymain.CertifType,'') as CertifType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Address,'',PrpLpaymain.Address,'') as Address,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifNo,'',PrpLpaymain.CertifNo,'') as CertifNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.FamilyPhone,'',PrpLpaymain.FamilyPhone,'') as FamilyPhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OfficePhone,'',PrpLpaymain.OfficePhone,'') as OfficePhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MobilePhone,'',PrpLpaymain.MobilePhone,'') as MobilePhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayRemark,'',PrpLpaymain.PayRemark,'') as PayRemark,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OperatorCode,'',PrpLpaymain.OperatorCode,'') as OperatorCode,");
        buffer.append("min(PrpLpaymain.InputDate),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayDate,'',PrpLpaymain.PayDate,'') as PayDate,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayCode,'',PrpLpaymain.PayCode,'') as PayCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpay.PayFlag,'',PrpLpay.PayFlag,'') as PayFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentType,'',PrpLpaymain.PaymentType,'') as PaymentType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankAccount,'',PrpLpaymain.BankAccount,'') as BankAccount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Node,'',PrpLpaymain.Node,'') as Node,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UpLoadSerialNo,'',PrpLpaymain.UpLoadSerialNo,'') as UpLoadSerialNo,");
        buffer.append("PrpLpaymain.Vflag,");
        buffer.append("PrpLpaymain.ComCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MergerFlag,'',PrpLpaymain.MergerFlag,'') as MergerFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayTotalAmount,'',PrpLpaymain.PayTotalAmount,'') as PayTotalAmount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UrgentType,'',PrpLpaymain.UrgentType,'') as UrgentType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOther,'',PrpLpaymain.ReceiverTypeOther,'') as ReceiverTypeOther,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOtherName,'',PrpLpaymain.ReceiverTypeOtherName,'') as ReceiverTypeOtherName,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.QqNumber,'',PrpLpaymain.QqNumber,'') as QqNumber,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Email,'',PrpLpaymain.Email,'') as Email,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UnitLink,'',PrpLpaymain.UnitLink,'') as UnitLink,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PostCode,'',PrpLpaymain.PostCode,'') as PostCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.VerifyFlag,'',PrpLpaymain.VerifyFlag,'') as VerifyFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.NoticeNo,'',PrpLpaymain.NoticeNo,'') as NoticeNo,");
       
        buffer.append("prplregist.registNo, ");
        buffer.append("prplregist.policyNo, ");
        buffer.append("prplregist.insuredName, ");
        buffer.append("prplregist.licenseNo, ");
        buffer.append("PrpLpaymain.thirdPayFlag, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payWay,'',PrpLpaymain.payWay,'') as payWay, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payReason,'',PrpLpaymain.payReason,'') as payReason, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payPurpose,'',PrpLpaymain.payPurpose,'') as payPurpose, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.accountFlag,'',PrpLpaymain.accountFlag,'') as accountFlag, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.interType,'',PrpLpaymain.interType,'') as interType, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.routeNum,'',PrpLpaymain.routeNum,'') as routeNum, ");
        buffer.append("PrpLpaymain.thirdPayType, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) as payAmountSub, ");
        buffer.append("PrpLpaymain.billFlag, ");
        buffer.append("decode(prplpaybill.billNo,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billNo),");
        buffer.append("decode(prplpaybill.billNo,null,'0','',0,'1')");
        buffer.append("FROM PrpLpaymain,prplpay,prplregist,prplpaybill,(select billno,sum(payAmount) as payAmount from prplpaybill group by billno) kk WHERE ");
        buffer.append(conditions);
        buffer.append("group by ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayType,'',PrpLpaymain.PayType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankType,'',PrpLpaymain.BankType,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Bank,'',PrpLpaymain.Bank,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankSite,'',PrpLpaymain.BankSite,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.AccountType,'',PrpLpaymain.AccountType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullName,'',PrpLpaymain.ReceiverFullName,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullCode,'',PrpLpaymain.ReceiverFullCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifType,'',PrpLpaymain.CertifType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Address,'',PrpLpaymain.Address,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifNo,'',PrpLpaymain.CertifNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.FamilyPhone,'',PrpLpaymain.FamilyPhone,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OfficePhone,'',PrpLpaymain.OfficePhone,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MobilePhone,'',PrpLpaymain.MobilePhone,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayRemark,'',PrpLpaymain.PayRemark,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OperatorCode,'',PrpLpaymain.OperatorCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayDate,'',PrpLpaymain.PayDate,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayCode,'',PrpLpaymain.PayCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpay.PayFlag,'',PrpLpay.PayFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentType,'',PrpLpaymain.PaymentType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankAccount,'',PrpLpaymain.BankAccount,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Node,'',PrpLpaymain.Node,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UpLoadSerialNo,'',PrpLpaymain.UpLoadSerialNo,'') ,");
        buffer.append("PrpLpaymain.Vflag,");
        buffer.append("PrpLpaymain.ComCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MergerFlag,'',PrpLpaymain.MergerFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayTotalAmount,'',PrpLpaymain.PayTotalAmount,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UrgentType,'',PrpLpaymain.UrgentType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOther,'',PrpLpaymain.ReceiverTypeOther,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOtherName,'',PrpLpaymain.ReceiverTypeOtherName,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.QqNumber,'',PrpLpaymain.QqNumber,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Email,'',PrpLpaymain.Email,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UnitLink,'',PrpLpaymain.UnitLink,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PostCode,'',PrpLpaymain.PostCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.VerifyFlag,'',PrpLpaymain.VerifyFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.NoticeNo,'',PrpLpaymain.NoticeNo,'') ,");
       
        buffer.append("prplregist.registNo, ");
        buffer.append("prplregist.policyNo, ");
        buffer.append("prplregist.insuredName, ");
        buffer.append("prplregist.licenseNo, ");
        buffer.append("PrpLpaymain.thirdPayFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payWay,'',PrpLpaymain.payWay,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payReason,'',PrpLpaymain.payReason,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payPurpose,'',PrpLpaymain.payPurpose,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.accountFlag,'',PrpLpaymain.accountFlag,''), ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.interType,'',PrpLpaymain.interType,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.routeNum,'',PrpLpaymain.routeNum,'') , ");
        buffer.append("PrpLpaymain.thirdPayType, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) , ");
        buffer.append("PrpLpaymain.billFlag, ");
        buffer.append("decode(prplpaybill.billNo,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billNo),");
        buffer.append("decode(prplpaybill.billNo,null,'0','',0,'1')");
        buffer.append(" order by min(prplpaymain.inputdate) desc ");
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //目前只对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        System.out.println("buffer:"+buffer);
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLpaymainDto prpLpaymainDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpaymainDto = new PrpLpaymainDto();
            prpLpaymainDto.setPaymentNo(dbManager.getString(resultSet,1));
            prpLpaymainDto.setPayType(dbManager.getString(resultSet,2));
            prpLpaymainDto.setPayAmount(dbManager.getDouble(resultSet,3));
            prpLpaymainDto.setBankType(dbManager.getString(resultSet,4));
            prpLpaymainDto.setBank(dbManager.getString(resultSet,5));
            prpLpaymainDto.setBankSite(dbManager.getString(resultSet,6));
            prpLpaymainDto.setAccountType(dbManager.getString(resultSet,7));
            prpLpaymainDto.setReceiverFullName(dbManager.getString(resultSet,8));
            prpLpaymainDto.setReceiverFullCode(dbManager.getString(resultSet,9));
            prpLpaymainDto.setCertifType(dbManager.getString(resultSet,10));
            prpLpaymainDto.setAddress(dbManager.getString(resultSet,11));
            prpLpaymainDto.setCertifNo(dbManager.getString(resultSet,12));
            prpLpaymainDto.setFamilyPhone(dbManager.getString(resultSet,13));
            prpLpaymainDto.setOfficePhone(dbManager.getString(resultSet,14));
            prpLpaymainDto.setMobilePhone(dbManager.getString(resultSet,15));
            prpLpaymainDto.setPayRemark(dbManager.getString(resultSet,16));
            prpLpaymainDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpLpaymainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,18));
            prpLpaymainDto.setPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,19));
            prpLpaymainDto.setPayCode(dbManager.getString(resultSet,20));
            prpLpaymainDto.setPayFlag(dbManager.getString(resultSet,21));
            prpLpaymainDto.setPaymentType(dbManager.getString(resultSet,22));
            prpLpaymainDto.setBankAccount(dbManager.getString(resultSet,23));
            prpLpaymainDto.setNode(dbManager.getString(resultSet,24));
            prpLpaymainDto.setUpLoadSerialNo(dbManager.getString(resultSet,25));
            prpLpaymainDto.setVflag(dbManager.getString(resultSet,26));
            prpLpaymainDto.setComCode(dbManager.getString(resultSet,27));
            prpLpaymainDto.setMergerFlag(dbManager.getString(resultSet,28));
            prpLpaymainDto.setPayTotalAmount(dbManager.getDouble(resultSet,29));
            prpLpaymainDto.setUrgentType(dbManager.getString(resultSet,30));
            prpLpaymainDto.setReceiverTypeOther(dbManager.getString(resultSet,31));
            prpLpaymainDto.setReceiverTypeOtherName(dbManager.getString(resultSet,32));
            prpLpaymainDto.setQqNumber(dbManager.getString(resultSet,33));
            prpLpaymainDto.setEmail(dbManager.getString(resultSet,34));
            prpLpaymainDto.setUnitLink(dbManager.getString(resultSet,35));
            prpLpaymainDto.setPostCode(dbManager.getString(resultSet,36));
            prpLpaymainDto.setVerifyFlag(dbManager.getString(resultSet,37));
            prpLpaymainDto.setNoticeNo(dbManager.getString(resultSet,38));
            prpLpaymainDto.setRegistNo(dbManager.getString(resultSet,39));
            prpLpaymainDto.setPolicyNo(dbManager.getString(resultSet,40));
            prpLpaymainDto.setInsuredName(dbManager.getString(resultSet,41));
            prpLpaymainDto.setLicenseNo(dbManager.getString(resultSet,42));
            prpLpaymainDto.setThirdPayFlag(dbManager.getString(resultSet,43));
            prpLpaymainDto.setPayWay(dbManager.getString(resultSet,44));
            prpLpaymainDto.setPayReason(dbManager.getString(resultSet,45));
            prpLpaymainDto.setPayPurpose(dbManager.getString(resultSet,46));
            prpLpaymainDto.setAccountFlag(dbManager.getString(resultSet,47));
            prpLpaymainDto.setInterType(dbManager.getString(resultSet,48));
            prpLpaymainDto.setRouteNum(dbManager.getString(resultSet,49));
            prpLpaymainDto.setThirdPayType(dbManager.getString(resultSet, 50));
            prpLpaymainDto.setPayAmountSub(dbManager.getDouble(resultSet,51));
            prpLpaymainDto.setBillFlag(dbManager.getString(resultSet, 52));
            prpLpaymainDto.setBillNo(dbManager.getString(resultSet, 53));
            prpLpaymainDto.setBillNoFlag(dbManager.getString(resultSet, 54));
            
            /**
             *  buffer.append("prplregist.registNo, ");
        buffer.append("prplregist.policyNo, ");
        buffer.append("prplregist.insuredName, ");
        buffer.append("prplregist.licenseNo ");
             */
            collection.add(prpLpaymainDto);
        }
        resultSet.close();
        return collection;
    }
    
    /**
     * 根据收付编号更新第三方支付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param thirdPayFlag 支付状态
     * @throws Exception
     */
    public void updateThirdPayFlag(String paymentNo,String thirdPayFlag)throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpaymain SET ");
        buffer.append("thirdPayFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("thirdPayFlag = '" + thirdPayFlag + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PaymentNo=").append("'").append(paymentNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,thirdPayFlag);
        //设置条件字段;
        dbManager.setString(2,paymentNo);
        dbManager.executePreparedUpdate();
    	
    }
    
    /**
     * 根据收付编号更新支付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param vflag 支付状态
     * * @param thirdPayFlag 第三方支付状态
     * @throws Exception
     */
    public void updateVflagAndThirdPayFlag(String paymentNo,String vflag,String thirdPayFlag)throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpaymain SET ");
        buffer.append("Vflag = ? ,");
        buffer.append("thirdPayFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("Vflag = '" + vflag + "', ");
            debugBuffer.append("thirdPayFlag" + thirdPayFlag + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PaymentNo=").append("'").append(paymentNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,vflag);
        dbManager.setString(2,thirdPayFlag);
        //设置条件字段;
        dbManager.setString(3,paymentNo);
        dbManager.executePreparedUpdate();
    	
    }

	public int getPayQueryCountBack(String conditions,String conditions1) throws Exception {
		int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(1) FROM (");
        buffer.append("SELECT DISTINCT ");
        buffer.append("decode(prplpaybill.billNo,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billNo)");
        buffer.append("FROM PrpLpaymain,prplpay,prplregist,prplpaybill,(select billno,sum(payAmount) as payAmount from prplpaybill group by billno) kk WHERE ");
        buffer.append(conditions);
        buffer.append("group by ");
        buffer.append("decode(prplpaybill.billNo,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billNo)");
        buffer.append(" union all ");
        buffer.append("select PrpLfiscalpaymain.fiscalno FROM PrpLfiscalpaymain,prplfiscalpaydetail,prplregist WHERE ");
        buffer.append(conditions1);
        buffer.append(")");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        System.out.println("buffercount:"+buffer);
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
	}

	public Collection findPayQueryByConditionsBack(String conditions,String conditions1,
			int pageNo, int rowsPerPage) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
		buffer.append("select * from (");
		buffer.append("SELECT DISTINCT ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,'') as PaymentNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayType,'',PrpLpaymain.PayType,'') as PayType,");
        buffer.append("sum(PrpLpaymain.PayAmount) as PayAmount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankType,'',PrpLpaymain.BankType,'') as BankType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Bank,'',PrpLpaymain.Bank,'') as Bank,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankSite,'',PrpLpaymain.BankSite,'') as BankSite,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.AccountType,'',PrpLpaymain.AccountType,'') as AccountType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullName,'',PrpLpaymain.ReceiverFullName,'') as ReceiverFullName,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullCode,'',PrpLpaymain.ReceiverFullCode,'') as ReceiverFullCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifType,'',PrpLpaymain.CertifType,'') as CertifType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Address,'',PrpLpaymain.Address,'') as Address,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifNo,'',PrpLpaymain.CertifNo,'') as CertifNo,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.FamilyPhone,'',PrpLpaymain.FamilyPhone,'') as FamilyPhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OfficePhone,'',PrpLpaymain.OfficePhone,'') as OfficePhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MobilePhone,'',PrpLpaymain.MobilePhone,'') as MobilePhone,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayRemark,'',PrpLpaymain.PayRemark,'') as PayRemark,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OperatorCode,'',PrpLpaymain.OperatorCode,'') as OperatorCode,");
        buffer.append("min(PrpLpaymain.InputDate) as InputDate,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayDate,'',PrpLpaymain.PayDate,'') as PayDate,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayCode,'',PrpLpaymain.PayCode,'') as PayCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpay.PayFlag,'',PrpLpay.PayFlag,'') as PayFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentType,'',PrpLpaymain.PaymentType,'') as PaymentType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankAccount,'',PrpLpaymain.BankAccount,'') as BankAccount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Node,'',PrpLpaymain.Node,'') as Node,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UpLoadSerialNo,'',PrpLpaymain.UpLoadSerialNo,'') as UpLoadSerialNo,");
        buffer.append("PrpLpaymain.Vflag,");
        buffer.append("PrpLpaymain.ComCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MergerFlag,'',PrpLpaymain.MergerFlag,'') as MergerFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayTotalAmount,'',PrpLpaymain.PayTotalAmount,'') as PayTotalAmount,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UrgentType,'',PrpLpaymain.UrgentType,'') as UrgentType,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOther,'',PrpLpaymain.ReceiverTypeOther,'') as ReceiverTypeOther,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOtherName,'',PrpLpaymain.ReceiverTypeOtherName,'') as ReceiverTypeOtherName,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.QqNumber,'',PrpLpaymain.QqNumber,'') as QqNumber,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Email,'',PrpLpaymain.Email,'') as Email,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UnitLink,'',PrpLpaymain.UnitLink,'') as UnitLink,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PostCode,'',PrpLpaymain.PostCode,'') as PostCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.VerifyFlag,'',PrpLpaymain.VerifyFlag,'') as VerifyFlag,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.NoticeNo,'',PrpLpaymain.NoticeNo,'') as NoticeNo,");
       
        buffer.append("prplregist.registNo, ");
        buffer.append("prplregist.policyNo, ");
        buffer.append("prplregist.insuredName, ");
        buffer.append("prplregist.licenseNo, ");
        buffer.append("PrpLpaymain.thirdPayFlag, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payWay,'',PrpLpaymain.payWay,'') as payWay, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payReason,'',PrpLpaymain.payReason,'') as payReason, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payPurpose,'',PrpLpaymain.payPurpose,'') as payPurpose, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.accountFlag,'',PrpLpaymain.accountFlag,'') as accountFlag, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.interType,'',PrpLpaymain.interType,'') as interType, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.routeNum,'',PrpLpaymain.routeNum,'') as routeNum, ");
        buffer.append("PrpLpaymain.thirdPayType, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) as payAmountSub, ");
        buffer.append("PrpLpaymain.billFlag, ");
        buffer.append("decode(prplpaybill.billNo,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billNo),");
        buffer.append("decode(prplpaybill.billNo,null,'0','',0,'1')");
        buffer.append("FROM PrpLpaymain,prplpay,prplregist,prplpaybill,(select billno,sum(payAmount) as payAmount from prplpaybill group by billno) kk WHERE ");
        buffer.append(conditions);
        buffer.append("group by ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayType,'',PrpLpaymain.PayType,'') ,");
       // buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankType,'',PrpLpaymain.BankType,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Bank,'',PrpLpaymain.Bank,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankSite,'',PrpLpaymain.BankSite,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.AccountType,'',PrpLpaymain.AccountType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullName,'',PrpLpaymain.ReceiverFullName,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverFullCode,'',PrpLpaymain.ReceiverFullCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifType,'',PrpLpaymain.CertifType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Address,'',PrpLpaymain.Address,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.CertifNo,'',PrpLpaymain.CertifNo,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.FamilyPhone,'',PrpLpaymain.FamilyPhone,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OfficePhone,'',PrpLpaymain.OfficePhone,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MobilePhone,'',PrpLpaymain.MobilePhone,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayRemark,'',PrpLpaymain.PayRemark,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.OperatorCode,'',PrpLpaymain.OperatorCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayDate,'',PrpLpaymain.PayDate,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayCode,'',PrpLpaymain.PayCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpay.PayFlag,'',PrpLpay.PayFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PaymentType,'',PrpLpaymain.PaymentType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.BankAccount,'',PrpLpaymain.BankAccount,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Node,'',PrpLpaymain.Node,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UpLoadSerialNo,'',PrpLpaymain.UpLoadSerialNo,'') ,");
        buffer.append("PrpLpaymain.Vflag,");
        buffer.append("PrpLpaymain.ComCode,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.MergerFlag,'',PrpLpaymain.MergerFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayTotalAmount,'',PrpLpaymain.PayTotalAmount,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UrgentType,'',PrpLpaymain.UrgentType,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOther,'',PrpLpaymain.ReceiverTypeOther,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.ReceiverTypeOtherName,'',PrpLpaymain.ReceiverTypeOtherName,''),");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.QqNumber,'',PrpLpaymain.QqNumber,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.Email,'',PrpLpaymain.Email,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.UnitLink,'',PrpLpaymain.UnitLink,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PostCode,'',PrpLpaymain.PostCode,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.VerifyFlag,'',PrpLpaymain.VerifyFlag,'') ,");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.NoticeNo,'',PrpLpaymain.NoticeNo,'') ,");
       
        buffer.append("prplregist.registNo, ");
        buffer.append("prplregist.policyNo, ");
        buffer.append("prplregist.insuredName, ");
        buffer.append("prplregist.licenseNo, ");
        buffer.append("PrpLpaymain.thirdPayFlag, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payWay,'',PrpLpaymain.payWay,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payReason,'',PrpLpaymain.payReason,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.payPurpose,'',PrpLpaymain.payPurpose,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.accountFlag,'',PrpLpaymain.accountFlag,''), ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.interType,'',PrpLpaymain.interType,'') , ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.routeNum,'',PrpLpaymain.routeNum,'') , ");
        buffer.append("PrpLpaymain.thirdPayType, ");
        buffer.append("decode(prplpaybill.billno,null,PrpLpaymain.PayAmount,'',PrpLpaymain.PayAmount,kk.payamount ) , ");
        buffer.append("PrpLpaymain.billFlag, ");
        buffer.append("decode(prplpaybill.billNo,null,PrpLpaymain.PaymentNo,'',PrpLpaymain.PaymentNo,prplpaybill.billNo),");
        buffer.append("decode(prplpaybill.billNo,null,'0','',0,'1')");
        buffer.append(" union all ");
        buffer.append("SELECT DISTINCT ");
    	buffer.append("PrpLfiscalpaymain.fiscalno as PaymentNo,");
    	buffer.append("'' as PayType ," );
    	buffer.append("Prplfiscalpaydetail.payamount,");
    	buffer.append("'' as  BankType," );
    	buffer.append("'' as  Bank," );
    	buffer.append("'' as  BankSite," );
    	buffer.append("'' as AccountType,");
    	buffer.append("Prplfiscalpaydetail.receiverfullname,");
    	buffer.append("'' as  ReceiverFullCode," );
    	buffer.append("'' as  CertifType," );
    	buffer.append("'' as  Address," );
    	buffer.append("Prplfiscalpaydetail.identifynumber as CertifNo,");
    	buffer.append("'' as  FamilyPhone," );
    	buffer.append("'' as  OfficePhone,");
    	buffer.append("'' as  MobilePhone," );
    	buffer.append("'' as  PayRemark," );
    	buffer.append("PrpLfiscalpaymain.operatorcode,");
    	buffer.append("PrpLfiscalpaymain.inputdate,");
    	buffer.append("date'2010-1-1' as  PayDate," );
    	buffer.append("'' as  PayCode,");
        buffer.append("'' as  PayFlag,");
        buffer.append("'' as  PaymentType,");
        buffer.append("'' as  bankaccount, ");
        buffer.append("'' as  Node,");
        buffer.append("'' as  UpLoadSerialNo,");
        buffer.append("'' as  Vflag,");
        buffer.append("'' as  ComCode,");
        buffer.append("'' as  MergerFlag,");
        buffer.append("Prplfiscalpaydetail.payamount as  PayTotalAmount,");
        buffer.append("'' as  UrgentType,");
        buffer.append("'' as  ReceiverTypeOther,");
        buffer.append("'' as  ReceiverTypeOtherName,");
        buffer.append("'' as  QqNumber,");
        buffer.append("'' as  Email,");
        buffer.append("'' as  UnitLink,");
        buffer.append("'' as  PostCode,");
        buffer.append("'' as  VerifyFlag,");
        buffer.append("'' as  NoticeNo, ");
        buffer.append("PrpLfiscalpaymain.registno,");
        buffer.append("prplregist.policyNo, ");
        buffer.append("prplregist.insuredName, ");
        buffer.append("prplregist.licenseNo, ");
        buffer.append("'' as  thirdPayFlag, ");
        buffer.append("'' as  payWay, ");
        buffer.append("'' as  payReason, ");
        buffer.append("'' as  payPurpose ,");
        buffer.append("'' as  accountFlag ,");
        buffer.append("'' as  interType ,");
        buffer.append("'' as  routeNum ,");
        buffer.append("'' as  thirdPayType, ");
        buffer.append("Prplfiscalpaydetail.payamount as  payAmountSub, ");
        buffer.append("'' as  billFlag, ");
        buffer.append("'' as  billNo,");
        buffer.append("'' as billNoFlag ");
    	buffer.append("FROM PrpLfiscalpaymain,prplfiscalpaydetail,prplregist WHERE ");
    	buffer.append(conditions1);
    	buffer.append(") order by inputdate desc ");
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //目前只对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        System.out.println("buffer:"+buffer);
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLpaymainDto prpLpaymainDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpaymainDto = new PrpLpaymainDto();
            prpLpaymainDto.setPaymentNo(dbManager.getString(resultSet,1));
            prpLpaymainDto.setPayType(dbManager.getString(resultSet,2));
            prpLpaymainDto.setPayAmount(dbManager.getDouble(resultSet,3));
            prpLpaymainDto.setBankType(dbManager.getString(resultSet,4));
            prpLpaymainDto.setBank(dbManager.getString(resultSet,5));
            prpLpaymainDto.setBankSite(dbManager.getString(resultSet,6));
            prpLpaymainDto.setAccountType(dbManager.getString(resultSet,7));
            prpLpaymainDto.setReceiverFullName(dbManager.getString(resultSet,8));
            prpLpaymainDto.setReceiverFullCode(dbManager.getString(resultSet,9));
            prpLpaymainDto.setCertifType(dbManager.getString(resultSet,10));
            prpLpaymainDto.setAddress(dbManager.getString(resultSet,11));
            prpLpaymainDto.setCertifNo(dbManager.getString(resultSet,12));
            prpLpaymainDto.setFamilyPhone(dbManager.getString(resultSet,13));
            prpLpaymainDto.setOfficePhone(dbManager.getString(resultSet,14));
            prpLpaymainDto.setMobilePhone(dbManager.getString(resultSet,15));
            prpLpaymainDto.setPayRemark(dbManager.getString(resultSet,16));
            prpLpaymainDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpLpaymainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,18));
            prpLpaymainDto.setPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,19));
            prpLpaymainDto.setPayCode(dbManager.getString(resultSet,20));
            prpLpaymainDto.setPayFlag(dbManager.getString(resultSet,21));
            prpLpaymainDto.setPaymentType(dbManager.getString(resultSet,22));
            prpLpaymainDto.setBankAccount(dbManager.getString(resultSet,23));
            prpLpaymainDto.setNode(dbManager.getString(resultSet,24));
            prpLpaymainDto.setUpLoadSerialNo(dbManager.getString(resultSet,25));
            prpLpaymainDto.setVflag(dbManager.getString(resultSet,26));
            prpLpaymainDto.setComCode(dbManager.getString(resultSet,27));
            prpLpaymainDto.setMergerFlag(dbManager.getString(resultSet,28));
            prpLpaymainDto.setPayTotalAmount(dbManager.getDouble(resultSet,29));
            prpLpaymainDto.setUrgentType(dbManager.getString(resultSet,30));
            prpLpaymainDto.setReceiverTypeOther(dbManager.getString(resultSet,31));
            prpLpaymainDto.setReceiverTypeOtherName(dbManager.getString(resultSet,32));
            prpLpaymainDto.setQqNumber(dbManager.getString(resultSet,33));
            prpLpaymainDto.setEmail(dbManager.getString(resultSet,34));
            prpLpaymainDto.setUnitLink(dbManager.getString(resultSet,35));
            prpLpaymainDto.setPostCode(dbManager.getString(resultSet,36));
            prpLpaymainDto.setVerifyFlag(dbManager.getString(resultSet,37));
            prpLpaymainDto.setNoticeNo(dbManager.getString(resultSet,38));
            prpLpaymainDto.setRegistNo(dbManager.getString(resultSet,39));
            prpLpaymainDto.setPolicyNo(dbManager.getString(resultSet,40));
            prpLpaymainDto.setInsuredName(dbManager.getString(resultSet,41));
            prpLpaymainDto.setLicenseNo(dbManager.getString(resultSet,42));
            prpLpaymainDto.setThirdPayFlag(dbManager.getString(resultSet,43));
            prpLpaymainDto.setPayWay(dbManager.getString(resultSet,44));
            prpLpaymainDto.setPayReason(dbManager.getString(resultSet,45));
            prpLpaymainDto.setPayPurpose(dbManager.getString(resultSet,46));
            prpLpaymainDto.setAccountFlag(dbManager.getString(resultSet,47));
            prpLpaymainDto.setInterType(dbManager.getString(resultSet,48));
            prpLpaymainDto.setRouteNum(dbManager.getString(resultSet,49));
            prpLpaymainDto.setThirdPayType(dbManager.getString(resultSet, 50));
            prpLpaymainDto.setPayAmountSub(dbManager.getDouble(resultSet,51));
            prpLpaymainDto.setBillFlag(dbManager.getString(resultSet, 52));
            prpLpaymainDto.setBillNo(dbManager.getString(resultSet, 53));
            prpLpaymainDto.setBillNoFlag(dbManager.getString(resultSet, 54));
            
            /**
             *  buffer.append("prplregist.registNo, ");
        buffer.append("prplregist.policyNo, ");
        buffer.append("prplregist.insuredName, ");
        buffer.append("prplregist.licenseNo ");
             */
            collection.add(prpLpaymainDto);
        }
        resultSet.close();
        return collection;
	}
	
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection queryThirdPayByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
		buffer.append("SELECT  ");
        buffer.append(" PRPLPAYMAIN.PaymentNo,");
        buffer.append(" PRPLPAYMAIN.PayType,");
        buffer.append(" PRPLPAYMAIN.PayAmount,");
        buffer.append(" PRPLPAYMAIN.BankType,");
        buffer.append(" PRPLPAYMAIN.Bank,");
        buffer.append(" PRPLPAYMAIN.BankSite,");
        buffer.append(" PRPLPAYMAIN.AccountType,");
        buffer.append(" PRPLPAYMAIN.ReceiverFullName,");
        buffer.append(" PRPLPAYMAIN.ReceiverFullCode,");
        buffer.append(" PRPLPAYMAIN.CertifType,");
        buffer.append(" PRPLPAYMAIN.Address,");
        buffer.append(" PRPLPAYMAIN.CertifNo,");
        buffer.append(" PRPLPAYMAIN.FamilyPhone,");
        buffer.append(" PRPLPAYMAIN.OfficePhone,");
        buffer.append(" PRPLPAYMAIN.MobilePhone,");
        buffer.append(" PRPLPAYMAIN.PayRemark,");
        buffer.append(" PRPLPAYMAIN.OperatorCode,");
        buffer.append(" PRPLPAYMAIN.InputDate,");
//        buffer.append(" PRPLPAYMAIN.paydate,");
        buffer.append(" to_date(prpjpackdetail.paydate,'yyyy-mm-dd hh24:mi:ss'),");
        buffer.append(" PRPLPAYMAIN.PayCode,");
        buffer.append(" PRPLPAYMAIN.PayFlag,");
        buffer.append(" PRPLPAYMAIN.PaymentType,");
        buffer.append(" PRPLPAYMAIN.BankAccount,");
        buffer.append(" PRPLPAYMAIN.Node,");
        buffer.append(" PRPLPAYMAIN.UpLoadSerialNo,");
        buffer.append(" PRPLPAYMAIN.Vflag,");
        buffer.append(" PRPLPAYMAIN.ComCode,");
        buffer.append(" PRPLPAYMAIN.MergerFlag,");
        buffer.append(" PRPLPAYMAIN.PayTotalAmount,");
        buffer.append(" PRPLPAYMAIN.UrgentType,");
        buffer.append(" PRPLPAYMAIN.ReceiverTypeOther,");
        buffer.append(" PRPLPAYMAIN.ReceiverTypeOtherName,");
        buffer.append(" PRPLPAYMAIN.QqNumber,");
        buffer.append(" PRPLPAYMAIN.Email,");
        buffer.append(" PRPLPAYMAIN.UnitLink,");
        buffer.append(" PRPLPAYMAIN.PostCode,");
        buffer.append(" PRPLPAYMAIN.VerifyFlag,");
        buffer.append(" PRPLPAYMAIN.NoticeNo,");
        buffer.append(" PRPLPAYMAIN.provinceCode, ");
        buffer.append(" PRPLPAYMAIN.cityCode, ");
        buffer.append(" PRPLPAYMAIN.thirdPayFlag, ");
        buffer.append(" PRPLPAYMAIN.payWay, ");
        buffer.append(" PRPLPAYMAIN.payReason, ");
        buffer.append(" PRPLPAYMAIN.payPurpose, ");
        buffer.append(" PRPLPAYMAIN.accountFlag, ");
        buffer.append(" PRPLPAYMAIN.interType, ");
        buffer.append(" PRPLPAYMAIN.routeNum, ");
        buffer.append(" PRPLPAYMAIN.billFlag,");
        buffer.append(" PRPLPAYMAIN.thirdPayType ");
/*        buffer.append(" prplpay.compensateno, ");
       // buffer.append(" prplpay.bank bank2, ");
        //buffer.append(" prplpay.paytype paytype2, ");
        buffer.append(" prplpay.claimno , ");
        buffer.append(" prplpay.registno , ");
        buffer.append(" prplpay.policyno , ");
        buffer.append(" prplpay.payremark payremark2, ");
        buffer.append(" prplpay.riskcode ");*/
        buffer.append(" FROM PrpLpaymain,prpjpackdetail    WHERE ");
        buffer.append(conditions);
        buffer.append(" and PrpLpaymain.PaymentNo=prpjpackdetail.visaserialno ");
        buffer.append(" order by PrpLpaymain.PaymentNo desc ");
//        buffer.append(" and PrpLpaymain.paymentno = prplpay.serialno");
         boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //目前只对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLpaymainDto prpLpaymainDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpaymainDto = new PrpLpaymainDto();
            prpLpaymainDto.setPaymentNo(dbManager.getString(resultSet,1));
            prpLpaymainDto.setPayType(dbManager.getString(resultSet,2));
            prpLpaymainDto.setPayAmount(dbManager.getDouble(resultSet,3));
            prpLpaymainDto.setBankType(dbManager.getString(resultSet,4));
            prpLpaymainDto.setBank(dbManager.getString(resultSet,5));
            prpLpaymainDto.setBankSite(dbManager.getString(resultSet,6));
            prpLpaymainDto.setAccountType(dbManager.getString(resultSet,7));
            prpLpaymainDto.setReceiverFullName(dbManager.getString(resultSet,8));
            prpLpaymainDto.setReceiverFullCode(dbManager.getString(resultSet,9));
            prpLpaymainDto.setCertifType(dbManager.getString(resultSet,10));
            prpLpaymainDto.setAddress(dbManager.getString(resultSet,11));
            prpLpaymainDto.setCertifNo(dbManager.getString(resultSet,12));
            prpLpaymainDto.setFamilyPhone(dbManager.getString(resultSet,13));
            prpLpaymainDto.setOfficePhone(dbManager.getString(resultSet,14));
            prpLpaymainDto.setMobilePhone(dbManager.getString(resultSet,15));
            prpLpaymainDto.setPayRemark(dbManager.getString(resultSet,16));
            prpLpaymainDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpLpaymainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,18));
            prpLpaymainDto.setPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,19));
            prpLpaymainDto.setPayCode(dbManager.getString(resultSet,20));
            prpLpaymainDto.setPayFlag(dbManager.getString(resultSet,21));
            prpLpaymainDto.setPaymentType(dbManager.getString(resultSet,22));
            prpLpaymainDto.setBankAccount(dbManager.getString(resultSet,23));
            prpLpaymainDto.setNode(dbManager.getString(resultSet,24));
            prpLpaymainDto.setUpLoadSerialNo(dbManager.getString(resultSet,25));
            prpLpaymainDto.setVflag(dbManager.getString(resultSet,26));
            prpLpaymainDto.setComCode(dbManager.getString(resultSet,27));
            prpLpaymainDto.setMergerFlag(dbManager.getString(resultSet,28));
            prpLpaymainDto.setPayTotalAmount(dbManager.getDouble(resultSet,29));
            prpLpaymainDto.setUrgentType(dbManager.getString(resultSet,30));
            prpLpaymainDto.setReceiverTypeOther(dbManager.getString(resultSet,31));
            prpLpaymainDto.setReceiverTypeOtherName(dbManager.getString(resultSet,32));
            prpLpaymainDto.setQqNumber(dbManager.getString(resultSet,33));
            prpLpaymainDto.setEmail(dbManager.getString(resultSet,34));
            prpLpaymainDto.setUnitLink(dbManager.getString(resultSet,35));
            prpLpaymainDto.setPostCode(dbManager.getString(resultSet,36));
            prpLpaymainDto.setVerifyFlag(dbManager.getString(resultSet,37));
            prpLpaymainDto.setNoticeNo(dbManager.getString(resultSet,38));
            prpLpaymainDto.setProvinceCode(dbManager.getString(resultSet,39));
            prpLpaymainDto.setCityCode(dbManager.getString(resultSet,40));
            prpLpaymainDto.setThirdPayFlag(dbManager.getString(resultSet,41));
            prpLpaymainDto.setPayWay(dbManager.getString(resultSet,42));
            prpLpaymainDto.setPayReason(dbManager.getString(resultSet,43));
            prpLpaymainDto.setPayPurpose(dbManager.getString(resultSet,44));
            prpLpaymainDto.setAccountFlag(dbManager.getString(resultSet,45));
            prpLpaymainDto.setInterType(dbManager.getString(resultSet,46));
            prpLpaymainDto.setRouteNum(dbManager.getString(resultSet,47));
            prpLpaymainDto.setBillFlag(dbManager.getString(resultSet, 48));
            prpLpaymainDto.setThirdPayType(dbManager.getString(resultSet, 49));
/*            prpLpaymainDto.setCompensateNo(dbManager.getString(resultSet, 50));
            prpLpaymainDto.setClaimNo(dbManager.getString(resultSet, 51));
            prpLpaymainDto.setRegistNo(dbManager.getString(resultSet, 52));
            prpLpaymainDto.setPolicyNo(dbManager.getString(resultSet, 53));
            prpLpaymainDto.setPayRemark(dbManager.getString(resultSet, 54));
            prpLpaymainDto.setRiskcode(dbManager.getString(resultSet, 55));*/
            collection.add(prpLpaymainDto);
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
    public int queryThirdPayCountByConditions(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(1) FROM ( ");
        buffer.append("SELECT  ");
        buffer.append(" PrpLpaymain.PaymentNo ");

        buffer.append("FROM PrpLpaymain,prpjpackdetail  WHERE ");
        buffer.append(conditions);
        buffer.append(" and PrpLpaymain.PaymentNo=prpjpackdetail.visaserialno ");
        buffer.append(")");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        System.err.println(buffer.toString());
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    
    /**
     * 获取支付信息的数量
     * @return
     * @throws Exception
     */
    public int getPayStatisticsCount(String conditions)throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        getPayStatisticsSql(buffer,conditions);
        buffer.insert(0, " select count(1) from (");
        buffer.append(")");
        ResultSet rs = dbManager.executeQuery(buffer.toString());
        rs.next();
        int count = dbManager.getInt(rs,1);
        rs.close();
    	return count;
    }
    
    /**
     * 查询支付情况统计信息
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public Collection findPayStatisticsByConditions(String conditions,int pageNo,int rowsPerPage)throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        getPayStatisticsSql(buffer,conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //目前只对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        System.out.println("buffer:"+buffer);
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PayStatisticsDto payStatisticsDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }
            payStatisticsDto = new PayStatisticsDto();
            payStatisticsDto.setComCode(dbManager.getString(resultSet, 1));
            payStatisticsDto.setInputDate(dbManager.getString(resultSet, 2));
            payStatisticsDto.setPayDate(dbManager.getString(resultSet, 3));
            payStatisticsDto.setPayStatus(dbManager.getString(resultSet, 4));
            payStatisticsDto.setRegistNo(dbManager.getString(resultSet, 5));
            payStatisticsDto.setInsuredName(dbManager.getString(resultSet,6));
            payStatisticsDto.setCompensateNo(dbManager.getString(resultSet,7));
            payStatisticsDto.setUnderWriteEnddate(dbManager.getString(resultSet,8));
            payStatisticsDto.setEndCaseDate(dbManager.getString(resultSet, 9));
            payStatisticsDto.setUserName(dbManager.getString(resultSet, 10));
            payStatisticsDto.setSumPaid(dbManager.getString(resultSet, 11));
            payStatisticsDto.setSumDutyPaid(dbManager.getString(resultSet, 12));
            payStatisticsDto.setPayPaid(dbManager.getString(resultSet, 13));
            payStatisticsDto.setComName(dbManager.getString(resultSet, 14));
            payStatisticsDto.setPayStatusName(dbManager.getString(resultSet, 15));
            payStatisticsDto.setPaymentNo(dbManager.getString(resultSet, 16));
            collection.add(payStatisticsDto);
        }
        resultSet.close();
        return collection;
    }
    
    /**
	 * 查询支付统计信息的sql
	 * @param buffer
	 */
	private void getPayStatisticsSql(StringBuffer buffer,String conditions) {
		String[] arr = null;
		if(conditions.indexOf(";")>0)
			arr = conditions.split(";");
		String sqlUnPaid=null;
		String sqlPaid = null;
		String sql = null;
		String sqlUnPaidTmp = null;
		if(arr.length>2){
			sql = arr[0];
			sqlUnPaidTmp = arr[1];
			sqlUnPaid = arr[1];
			sqlPaid = arr[2];
		}
		buffer.append("SELECT DISTINCT ");
        buffer.append("statis.Comcode,");
        buffer.append("statis.Inputdate,");
        buffer.append("statis.Paydate,");
        buffer.append("statis.PayStatus,");
        buffer.append("statis.Registno,");
        buffer.append("statis.Insuredname,");
        buffer.append("statis.Compensateno,");
        buffer.append("to_char(statis.Underwriteenddate,'yyyy-mm-dd HH24:mi:ss') Underwriteenddate,");
        buffer.append("to_char(statis.Endcasedate,'yyyy-mm-dd HH24:mi:ss') Endcasedate,");
        buffer.append("statis.Username,");
        buffer.append("statis.Sumpaid,");
        buffer.append("statis.Sumdutypaid,");
        buffer.append("statis.Paypaid, ");
        buffer.append("statis.comName, ");
        buffer.append("decode(statis.Paystatus,'Q','核赔通过未支付','0','待提交','1','待审核','2','审核不通过','3',"); 
        buffer.append("'支付中心待处理','4','支付中心退回','5','已打包待审核','6','打包审核通过待发送','7','已发往银行 在途','8','银行打回','9','支付成功','m','默认成功','n','银行退回支付中心') payStatusName, ");
        buffer.append(" statis.paymentNo ");
        buffer.append(" from (");
        if(sqlUnPaid.indexOf("Q")>-1){
        	sqlUnPaid = sqlUnPaid.replaceAll("Q", "");
	        buffer.append(" 	select ee.comcode,");
	        buffer.append(" 	( select comcname from prpdcompany where comcode = ee.comcode) as comname,");
	        buffer.append(" 	'' inputdate,");
	        buffer.append(" 	'' paydate,");
	        buffer.append(" 	'Q' paystatus,");
	        buffer.append(" 	(Select Registno From Prplclaim Mm Where Mm.Claimno = Ee.Claimno) As Registno,");
	        buffer.append(" 	(Select Nn.Insuredname From Prpcmain Nn Where Nn.Policyno = Ee.Policyno) As Insuredname,");
	        buffer.append(" 	Ee.Compensateno,");
	        buffer.append(" 	Ee.Underwriteenddate,");
	        buffer.append(" 	(Select Mm.Endcasedate From Prplclaim Mm Where Mm.Claimno = Ee.Claimno) As Endcasedate,");
	        buffer.append(" 	(Select D.Username From Prpduser d Where D.Usercode = Ee.Handlercode) As Username,");
	        buffer.append(" 	Ee.Sumpaid,");
	        buffer.append(" 	Ee.Sumdutypaid,");
	        buffer.append(" 	0 As Paypaid, ");
	        buffer.append(" 	'' Paymentno, ");
	        buffer.append(" 	ee.claimno Claimno ");
	        buffer.append(" 	from Prplcompensate Ee where ");
	        buffer.append(" 		Ee.Underwriteflag In ('1', '3')");
	        buffer.append(" 		and Ee.Sumdutypaid <> 0");
	        buffer.append(" 		And Ee.Classcode <> '05'");
	       
	        buffer.append(sqlUnPaid);
	        buffer.append(" 		And Not Exists (Select 1 From Prpjplanfee f  Where F.Certitype In ('C', 'Y') ");
	        buffer.append(" 		And F.Certino = Ee.Compensateno ");
	        buffer.append(" 		And F.Planfee = F.Realpayreffee ");
	        buffer.append(" 		And F.Payrefstate In ('10', '11')) ");
	        buffer.append(" 		And Not Exists (Select 1 From Prplpay Yy Where Yy.Compensateno = Ee.Compensateno And Yy.Claimno = Ee.Claimno)");
	        buffer.append("         And Exists (Select 1 From Prpjplanfee Where Prpjplanfee.Certino = Ee.Compensateno And Prpjplanfee.Payrefreason In ('P60', 'P50'))");
        }
        if(sqlUnPaidTmp.indexOf("Q")>-1&&sqlPaid.indexOf("Thirdpayflag")>-1){
        	buffer.append("	union all ");
        }
        if(sqlPaid.indexOf("Thirdpayflag")>-1){
	        buffer.append("Select distinct Ee.Comcode,");
	        buffer.append(" 			( select comcname from prpdcompany where comcode = ee.comcode) as comname,");
	        buffer.append(" 			To_Char(Decode((Select Decode(Min(Ii.Inputdate), '', Yy.Inputdate, Null, Yy.Inputdate, ' ', Yy.Inputdate,");
	        buffer.append("             Min(Ii.Inputdate)) From Prplpayhis Ii Where Ii.Claimno = Yy.Claimno And Ii.Registno = Yy.Registno");
	        buffer.append("             And Ii.Compensateno = Yy.Compensateno And Ii.Paymenttype = Yy.Paymenttype), '', Yy.Inputdate,");
	        buffer.append("             (Select Decode(Min(Ii.Inputdate), '', Yy.Inputdate, Null, Yy.Inputdate, ' ', Yy.Inputdate,");
	        buffer.append("             Min(Ii.Inputdate)) From Prplpayhis Ii Where Ii.Claimno = Yy.Claimno And Ii.Registno = Yy.Registno");
	        buffer.append("             And Ii.Compensateno = Yy.Compensateno And Ii.Paymenttype = Yy.Paymenttype)), 'yyyy-MM-dd hh24:mi:ss') As Inputdate,");
	        buffer.append("             To_Char(Zz.Paydate, 'yyyy-MM-dd hh24:mi:ss') As Paydate,");
	        buffer.append("             (Select Thirdpayflag  From Prplpaymain Mm Where Mm.Paymentno = Yy.Serialno) As Paystatus,");
	        buffer.append("             Yy.Registno,");
			buffer.append("             (Select Nn.Insuredname From Prpcmain Nn Where Nn.Policyno = Yy.Policyno) As Insuredname,");
			buffer.append("             Yy.Compensateno,");
			buffer.append("             Ee.Underwriteenddate,");
			buffer.append("             (Select Cm.Endcasedate From Prplclaim Cm Where Cm.Claimno = Yy.Claimno) As Endcasedate,");
			buffer.append("             (Select D.Username From Prpduser d Where D.Usercode = Ee.Handlercode) As Username,");
			buffer.append("             Ee.Sumpaid,");
			buffer.append("             Ee.Sumdutypaid,");
			buffer.append("             Yy.Payamount As Paypaid, ");
			buffer.append("				(Select Paymentno From Prplpaymain Mm Where Mm.Paymentno = Yy.Serialno) As Paymentno,");
			buffer.append("				Yy.claimno");
			buffer.append("				From Prplpay Yy,");
			buffer.append("             	Prplcompensate Ee,");
			buffer.append("             	(Select Ll.Visaserialno, (Select Decode(To_Char(Cc.Payrefdatetime, 'yyyy-MM-dd'), '1970-1-1', Cc.Payrefdate,");
			buffer.append("             	Cc.Payrefdatetime) From Prpjpayrefrec Cc Where Cc.Certitype = Ee.Certitype And Cc.Certino = Ee.Certino");
			buffer.append("             	And Cc.Payrefreason = Ee.Payrefreason And Cc.Serialno = Ee.Serialno");
			buffer.append("             	And Cc.Payreftimes = Ee.Payreftimes) As Paydate");
			buffer.append("             	From Prpjpackrefrec Ee, Prpjpackdetail Ll");
			buffer.append("             		Where Ll.Packno = Ee.Packno");
			buffer.append("                 	And Ll.Visaserialno = Ee.Paymentno");
			buffer.append("               		Order By Ll.Visaserialno Desc) Zz");
			buffer.append("       		Where Yy.Compensateno = Ee.Compensateno");
			buffer.append("         	And Yy.Serialno = Zz.Visaserialno");
			buffer.append("         	And Yy.Classcode <> '05'");
			buffer.append("         	And Yy.Paymenttype In ('P50', 'P60')");
			 buffer.append(" 		And Ee.UnderWriteFlag IN ('1','3')");
			buffer.append(sqlPaid);
			
			buffer.append("	union all ");
			
			buffer.append("Select Distinct Ee.Comcode,                                                              ");
			buffer.append("                (Select Comcname From Prpdcompany Where Comcode = Ee.Comcode) As Comname,");
			buffer.append("                To_Char(Decode((Select Decode(Min(Ii.Inputdate),                         ");
			buffer.append("                                             '',                                         ");
			buffer.append("                                             Yy.Inputdate,                               ");
			buffer.append("                                             Null,                                       ");
			buffer.append("                                             Yy.Inputdate,                               ");
			buffer.append("                                             ' ',                                        ");
			buffer.append("                                             Yy.Inputdate,                               ");
			buffer.append("                                             Min(Ii.Inputdate))                          ");
			buffer.append("                                 From Prplpayhis Ii                                      ");
			buffer.append("                                Where Ii.Claimno = Yy.Claimno                            ");
			buffer.append("                                  And Ii.Registno = Yy.Registno                          ");
			buffer.append("                                  And Ii.Compensateno = Yy.Compensateno                  ");
			buffer.append("                                  And Ii.Paymenttype = Yy.Paymenttype),                  ");
			buffer.append("                               '',                                                       ");
			buffer.append("                               Yy.Inputdate,                                             ");
			buffer.append("                               (Select Decode(Min(Ii.Inputdate),                         ");
			buffer.append("                                              '',                                        ");
			buffer.append("                                              Yy.Inputdate,                              ");
			buffer.append("                                              Null,                                      ");
			buffer.append("                                              Yy.Inputdate,                              ");
			buffer.append("                                              ' ',                                       ");
			buffer.append("                                              Yy.Inputdate,                              ");
			buffer.append("                                              Min(Ii.Inputdate))                         ");
			buffer.append("                                  From Prplpayhis Ii                                     ");
			buffer.append("                                 Where Ii.Claimno = Yy.Claimno                           ");
			buffer.append("                                   And Ii.Registno = Yy.Registno                         ");
			buffer.append("                                   And Ii.Compensateno = Yy.Compensateno                 ");
			buffer.append("                                   And Ii.Paymenttype = Yy.Paymenttype)),                ");
			buffer.append("                        'yyyy-MM-dd hh24:mi:ss') As Inputdate,                           ");
			buffer.append("                '' As Paydate,  	");                                                         
			buffer.append("                (Select Thirdpayflag                                                     ");
			buffer.append("                   From Prplpaymain Mm                                                   ");
			buffer.append("                  Where Mm.Paymentno = Yy.Serialno) As Paystatus,                        ");
			buffer.append("                Yy.Registno,                                                             ");
			buffer.append("                (Select Nn.Insuredname                                                   ");
			buffer.append("                   From Prpcmain Nn                                                      ");
			buffer.append("                  Where Nn.Policyno = Yy.Policyno) As Insuredname,                       ");
			buffer.append("                Yy.Compensateno,                                                         ");
			buffer.append("                Ee.Underwriteenddate,                                                    ");
			buffer.append("                (Select Cm.Endcasedate                                                   ");
			buffer.append("                   From Prplclaim Cm                                                     ");
			buffer.append("                  Where Cm.Claimno = Yy.Claimno) As Endcasedate,                         ");
			buffer.append("                (Select D.Username                                                       ");
			buffer.append("                   From Prpduser d                                                       ");
			buffer.append("                  Where D.Usercode = Ee.Handlercode) As Username,                        ");
			buffer.append("                Ee.Sumpaid,                                                              ");
			buffer.append("                Ee.Sumdutypaid,                                                          ");
			buffer.append("                Yy.Payamount As Paypaid,                                                 ");
			buffer.append("                (Select Paymentno                                                        ");
			buffer.append("                   From Prplpaymain Mm                                                   ");
			buffer.append("                  Where Mm.Paymentno = Yy.Serialno) As Paymentno,                        ");
			buffer.append("                Yy.Claimno                                                               ");
			buffer.append("  From Prplpay Yy,                                                                       ");
			buffer.append("       Prplcompensate Ee                                                                 ");
			buffer.append(" Where Yy.Compensateno = Ee.Compensateno                                                 ");
			buffer.append("   And Yy.Classcode <> '05'                                                               ");
			buffer.append("   And Not Exists (Select 1 from Prpjpackrefrec Rec Where Rec.Certino = Yy.Compensateno And Rec.Paymentno = Yy.Serialno And Rec.Payrefreason = Yy.Paymenttype)");
			buffer.append("   And Yy.Paymenttype In ('P50', 'P60')                                                  ");
			buffer.append(" 		And Ee.UnderWriteFlag IN ('1','3')");
			buffer.append(sqlPaid);
        }
        buffer.append(" ) statis ");
        buffer.append(" where ");
        buffer.append(sql);
        logger.info(buffer.toString());
	}
}
