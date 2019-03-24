package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpaymain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpay;

/**
 * ����֧����Ϣ�����ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpaymainAction extends BLPrpLpaymainActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpaymainAction.class);

    /**
     * ���캯��
     */
    public BLPrpLpaymainAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpaymainDto prpLpaymainDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpaymainDto prpLpaymainDto,String mode)
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
    	 DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
         //���¼�¼
         dbPrpLpaymain.updateByKey(paymentNo,vflag);
    }
    /**
     * �����ո���Ÿ���֧��״̬ add by zhongfen
	* ���ռ�ñ����Ǵ����״̬
     * @param paymentNo �ո����
     * @param vflag ֧��״̬
     * @param vflag
     * @throws Exception
     */
    public void updateByKeyFor6(DBManager dbManager,String paymentNo,String vflag)throws Exception{
    	 DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
         //���¼�¼
         dbPrpLpaymain.updateByKeyFor6(paymentNo,vflag);
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
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.getPayQueryCount(conditions);
        collection = dbPrpLpaymain.findPayQueryByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.queryThirdPayCountByConditions(conditions);
        collection = dbPrpLpaymain.queryThirdPayByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.getPayQueryCountNew(conditions);
        collection = dbPrpLpaymain.findPayQueryByConditionsNew(conditions,pageNo,rowsPerPage);
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
    	 DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
         //���¼�¼
         dbPrpLpaymain.updateThirdPayFlag(paymentNo,thirdPayFlag);
    }
    
    /**
     * �����ո���Ÿ���֧��״̬ add by zhongfen
     * @param paymentNo �ո����
     * @param vflag ֧��״̬
     * @param thirdPayFlag ֧��״̬
     * @throws Exception
     */
    public void updateVflagAndThirdPayFlag(DBManager dbManager,String paymentNo,String vflag,String thirdPayFlag)throws Exception{
    	 DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
         //���¼�¼
         dbPrpLpaymain.updateVflagAndThirdPayFlag(paymentNo,vflag,thirdPayFlag);
    }

	public PageRecord findPayQueryByConditionsBack(DBManager dbManager,
			String conditions,String conditions1, int pageNo, int rowsPerPage) throws Exception {
		DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.getPayQueryCountBack(conditions,conditions1);
        collection = dbPrpLpaymain.findPayQueryByConditionsBack(conditions,conditions1,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
	}
	public PageRecord findPayQueryByConditionsBack(DBManager dbManager,
			String conditions,String conditions1,String conditions2, int pageNo, int rowsPerPage) throws Exception {
		DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        if(conditions2.trim().length()==0){
            conditions2 = "1=1";
        }

        int count = dbPrpLpaymain.getPayQueryCountBack(conditions,conditions1,conditions2);
        collection = dbPrpLpaymain.findPayQueryByConditionsBack(conditions,conditions1,conditions2,pageNo,rowsPerPage);
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
		DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
		Collection collection = new ArrayList();

		if (conditions.trim().length() == 0) {
			conditions = "1=1";
		}

		int count = dbPrpLpaymain.getPayStatisticsCount(conditions);
		collection = dbPrpLpaymain.findPayStatisticsByConditions(conditions,
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
    	DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
    	if (conditions.trim().length() == 0) {
			conditions = "1=1";
		}
    	return dbPrpLpaymain.getPayStatisticsCount(conditions);
	}
}
