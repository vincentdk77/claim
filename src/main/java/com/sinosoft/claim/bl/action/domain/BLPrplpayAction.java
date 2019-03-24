package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpay;

/**
 * ����PRPLPAY��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplpayAction extends BLPrplpayActionBase {
    private static Logger logger = Logger.getLogger(BLPrplpayAction.class);

    /**
     * ���캯��
     */
    public BLPrplpayAction() {
        super();
    }

    /**
     * ת��Dto
     * 
     * @param dbManager
     *            dbManager
     * @param prplpayDto
     *            prplpayDto
     * @param mode
     *            ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager, PrplpayDto prplpayDto,
            String mode) throws Exception {
    }

    /**
     * �����������
     * 
     * @param dbManager
     *            DB������
     * @param prplpayDto
     *            prplpayDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager, Collection prplpayDtoList)
            throws Exception {
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        // �����¼
        dbPrplpay.insertAll(prplpayDtoList);
    }

    public void updatePayFlag(DBManager dbManager, PrplpayDto prplpayDto)
            throws Exception {
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        // ���¼�¼
        dbPrplpay.updatePayFlag(prplpayDto);
    }
    public void updateVFlag(DBManager dbManager, String vflag,String registNo,String compensateNo)
    throws Exception {
		DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
		// ���¼�¼
		dbPrplpay.updateVFlag(vflag,registNo,compensateNo);
    }
    /**
     * ����֧��״̬
     * @param dbManager
     * @param vflag
     * @param serialno
     * @throws Exception
     */
    public void updateVFlag(DBManager dbManager, String vflag,String serialno)
    throws Exception {
		DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
		// ���¼�¼
		dbPrplpay.updateVFlag(vflag,serialno);
    }
    /**
     * ����֧��״̬
	* ���ռ�ñ����Ǵ����״̬
     * @param dbManager
     * @param vflag
     * @param serialno
     * @throws Exception
     */
    public void updateVFlagFor6(DBManager dbManager, String vflag,String serialno)
    throws Exception {
		DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
		// ���¼�¼
		dbPrplpay.updateVFlagFor6(vflag,serialno);
    }
    
    /**
     * �����ո���Ÿ����ո�״̬ add by zhongfen
     * @param dbManager
     * @param paymentNo �ո����
     * @param vflag ֧��״̬
     * @throws Exception
     */
    public void updateVflagByPaymentNo(DBManager dbManager, String paymentNo,String vflag)throws Exception{
    	DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
    	dbPrplpay.updateVflagByPaymentNo(paymentNo,vflag);
    }
    
    /**
     * ����֪ͨ���Ż�ȡ֧����Ϣ�����ƺ��롢������������ add by zhongfen
     * @param dbManager
     * @param noticeNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByNoticeNo(DBManager dbManager,String noticeNo) throws Exception{
    	DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
    	Collection colls = dbPrplpay.findPrintByNoticeNo(noticeNo);
    	return colls ;
    }
    /**
     * ����֧����Ż�ȡ֧����Ϣ�����ƺ��롢������������ add by chu
     * @param paymentNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByPaymentNo(DBManager dbManager,String paymentNo) throws Exception{
    	DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
    	Collection colls = dbPrplpay.findPrintByPaymentNo(paymentNo);
    	return colls ;
    }

	public Collection findByConditionsSql(DBManager dbManager, String conditions) throws Exception{
		DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpay.findByConditionsSql(conditions);
        return collection;
    	
	}
	/***********************�Ż��޸ģ�start****************************/
	public Collection findByConditionsSqlByPrepered(DBManager dbManager, String conditions,String Serialno,String Compensateno,double Payamount) throws Exception{
		DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpay.findByConditionsSqlByprepered(conditions,Serialno,Compensateno,Payamount);
        return collection;
    	
	}
	/***********************�Ż��޸ģ�end*******************************/
}
