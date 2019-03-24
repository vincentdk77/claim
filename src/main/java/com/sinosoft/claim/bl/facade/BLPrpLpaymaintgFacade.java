package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;

import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymaintgAction;

/**
 * ����֧����Ϣ�����ҵ�����Facade��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpaymaintgFacade extends BLPrpLpaymaintgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpaymaintgFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLpaymaintgFacade(){
        super();
    }
    
    /**
     * �����ո���Ÿ���֧��״̬ add by zhongfen
     * @param paymentNo �ո����
     * @param vflag ֧��״̬
     * @throws Exception
     */
    public void updateByKey(String paymentNo,String vflag)throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpaymaintgAction.updateByKey(dbManager,paymentNo,vflag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	
    }
    
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findPayQueryByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymaintgAction.findPayQueryByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord queryThirdPayByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymaintgAction.queryThirdPayByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findPayQueryByConditionsNew(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymaintgAction.findPayQueryByConditionsNew(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
     * �����ո���Ÿ��µ�����֧��״̬ add by zhongfen
     * @param paymentNo �ո����
     * @param thirdPayFlag ֧��״̬
     * @throws Exception
     */
    public void updateThirdPayFlag(String paymentNo,String thirdPayFlag)throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpaymaintgAction.updateThirdPayFlag(dbManager,paymentNo,thirdPayFlag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	
    }
    
    /**
     * �����ո���Ÿ��µ�����֧��״̬ add by zhongfen
     * @param paymentNo �ո����
     * @param thirdPayFlag ֧��״̬
     * @throws Exception
     */
    public void updateVflagAndThirdPayFlag(String paymentNo,String vflag,String thirdPayFlag)throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpaymaintgAction.updateVflagAndThirdPayFlag(dbManager, paymentNo, vflag, thirdPayFlag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	
    }

	public PageRecord findPayQueryByConditionsBack(String conditions,String conditions1,
			int pageNo, int rowsPerPage) throws Exception {
		PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymaintgAction.findPayQueryByConditionsBack(dbManager,conditions,conditions1,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
	}
	
	/**
     * ��ȡ֧�����ͳ����Ϣ
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public PageRecord findPayStatisticsByConditions(String conditions,int pageNo,int rowsPerPage)throws Exception{
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymaintgAction.findPayStatisticsByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
     * ��ȡ֧��ͳ����Ϣ����
     * @return
     * @throws Exception
     */
    public int getPayStatisticsCount(String conditions)throws Exception{
    	if(conditions.trim().length()==0){
            conditions = "1=1";
        }
    	int count=0;
        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            count = blPrpLpaymaintgAction.getPayStatisticsCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return count;
    }
}
