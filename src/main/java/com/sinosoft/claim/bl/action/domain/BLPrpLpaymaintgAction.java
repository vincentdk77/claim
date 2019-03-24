package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpaymaintgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpaymaintg;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpay;

/**
 * ����֧����Ϣ�����ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpaymaintgAction extends BLPrpLpaymaintgActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpaymaintgAction.class);

    /**
     * ���캯��
     */
    public BLPrpLpaymaintgAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpaymaintgDto prpLpaymaintgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpaymaintgDto prpLpaymaintgDto,String mode)
            throws Exception{
    }
    
    /**
     * �����ո���Ÿ���֧��״̬ add by zhongfen
     * @param paymentNo �ո����
     * @param vflag ֧��״̬
     * @param vflag
     * @throws Exception
     */
    public void updateByKey(DBManager dbManager,String paymentNo,String vflag)throws Exception{
    	 DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
         //���¼�¼
         dbPrpLpaymaintg.updateByKey(paymentNo,vflag);
    }
    
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findPayQueryByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymaintg.getPayQueryCount(conditions);
        collection = dbPrpLpaymaintg.findPayQueryByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord queryThirdPayByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymaintg.queryThirdPayCountByConditions(conditions);
        collection = dbPrpLpaymaintg.queryThirdPayByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findPayQueryByConditionsNew(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymaintg.getPayQueryCountNew(conditions);
        collection = dbPrpLpaymaintg.findPayQueryByConditionsNew(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    /**
     * �����ո���Ÿ��µ�����֧��״̬ add by zhongfen
     * @param paymentNo �ո����
     * @param thirdPayFlag ֧��״̬
     * @throws Exception
     */
    public void updateThirdPayFlag(DBManager dbManager,String paymentNo,String thirdPayFlag)throws Exception{
    	 DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
         //���¼�¼
         dbPrpLpaymaintg.updateThirdPayFlag(paymentNo,thirdPayFlag);
    }
    
    /**
     * �����ո���Ÿ���֧��״̬ add by zhongfen
     * @param paymentNo �ո����
     * @param vflag ֧��״̬
     * @param thirdPayFlag ֧��״̬
     * @throws Exception
     */
    public void updateVflagAndThirdPayFlag(DBManager dbManager,String paymentNo,String vflag,String thirdPayFlag)throws Exception{
    	 DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
         //���¼�¼
         dbPrpLpaymaintg.updateVflagAndThirdPayFlag(paymentNo,vflag,thirdPayFlag);
    }

	public PageRecord findPayQueryByConditionsBack(DBManager dbManager,
			String conditions,String conditions1, int pageNo, int rowsPerPage) throws Exception {
		DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymaintg.getPayQueryCountBack(conditions,conditions1);
        collection = dbPrpLpaymaintg.findPayQueryByConditionsBack(conditions,conditions1,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
	}
	
	/**
     * ��ѯ֧�����ͳ����Ϣ
     * @param dbManager
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage  ÿҳ������
     * @return
     * @throws Exception
     */
    public PageRecord findPayStatisticsByConditions(DBManager dbManager,
			String conditions, int pageNo, int rowsPerPage) throws Exception {
		DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
		Collection collection = new ArrayList();

		if (conditions.trim().length() == 0) {
			conditions = "1=1";
		}

		int count = dbPrpLpaymaintg.getPayStatisticsCount(conditions);
		collection = dbPrpLpaymaintg.findPayStatisticsByConditions(conditions,
				pageNo, rowsPerPage);
		PageRecord pageRecord = new PageRecord(count, pageNo, 1, rowsPerPage,
				collection);
		return pageRecord;
	}
    
    /**
     * ��ȡͳ�������Ϣ����
     * @param dbManager
     * @param conditions
     * @return
     * @throws Exception
     */
    public int getPayStatisticsCount(DBManager dbManager, String conditions)
			throws Exception {
    	DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
    	if (conditions.trim().length() == 0) {
			conditions = "1=1";
		}
    	return dbPrpLpaymaintg.getPayStatisticsCount(conditions);
	}
}
