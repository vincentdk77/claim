package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpaytg;

/**
 * ����PRPLPAY��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplpaytgAction extends BLPrplpaytgActionBase {
    private static Logger logger = Logger.getLogger(BLPrplpaytgAction.class);

    /**
     * ���캯��
     */
    public BLPrplpaytgAction() {
        super();
    }

    /**
     * ת��Dto
     * 
     * @param dbManager
     *            dbManager
     * @param prplpaytgDto
     *            prplpaytgDto
     * @param mode
     *            ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager, PrplpayDto prplpaytgDto,
            String mode) throws Exception {
    }

    /**
     * �����������
     * 
     * @param dbManager
     *            DB������
     * @param prplpaytgDto
     *            prplpaytgDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager, Collection prplpayDtoList)
            throws Exception {
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        // �����¼
        dbPrplpaytg.insertAll(prplpayDtoList);
    }

    public void updatePayFlag(DBManager dbManager, PrplpayDto prplpaytgDto)
            throws Exception {
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        // ���¼�¼
        dbPrplpaytg.updatePayFlag(prplpaytgDto);
    }
    public void updateVFlag(DBManager dbManager, String vflag,String registNo,String compensateNo)
    throws Exception {
		DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
		// ���¼�¼
		dbPrplpaytg.updateVFlag(vflag,registNo,compensateNo);
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
		DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
		// ���¼�¼
		dbPrplpaytg.updateVFlag(vflag,serialno);
    }
    
    /**
     * �����ո���Ÿ����ո�״̬ add by zhongfen
     * @param dbManager
     * @param paymentNo �ո����
     * @param vflag ֧��״̬
     * @throws Exception
     */
    public void updateVflagByPaymentNo(DBManager dbManager, String paymentNo,String vflag)throws Exception{
    	DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
    	dbPrplpaytg.updateVflagByPaymentNo(paymentNo,vflag);
    }
    
    /**
     * ����֪ͨ���Ż�ȡ֧����Ϣ�����ƺ��롢������������ add by zhongfen
     * @param dbManager
     * @param noticeNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByNoticeNo(DBManager dbManager,String noticeNo) throws Exception{
    	DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
    	Collection colls = dbPrplpaytg.findPrintByNoticeNo(noticeNo);
    	return colls ;
    }
    /**
     * ����֧����Ż�ȡ֧����Ϣ�����ƺ��롢������������ add by chu
     * @param paymentNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByPaymentNo(DBManager dbManager,String paymentNo) throws Exception{
    	DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
    	Collection colls = dbPrplpaytg.findPrintByPaymentNo(paymentNo);
    	return colls ;
    }

	public Collection findByConditionsSql(DBManager dbManager, String conditions) throws Exception{
		DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpaytg.findByConditionsSql(conditions);
        return collection;
    	
	}
	/***********************�Ż��޸ģ�start****************************/
	public Collection findByConditionsSqlByPrepered(DBManager dbManager, String conditions,String Serialno,String Compensateno,double Payamount) throws Exception{
		DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpaytg.findByConditionsSqlByprepered(conditions,Serialno,Compensateno,Payamount);
        return collection;
    	
	}
	/***********************�Ż��޸ģ�end*******************************/
}
