package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;

import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymainAction;

/**
 * ����֧����Ϣ�����ҵ�����Facade��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpaymainFacade extends BLPrpLpaymainFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpaymainFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLpaymainFacade(){
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
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpaymainAction.updateByKey(dbManager,paymentNo,vflag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	
    }
    /**
     * �����ո���Ÿ���֧��״̬ add by zhongfen
	* ���ռ�ñ����Ǵ����״̬
     * @param paymentNo �ո����
     * @param vflag ֧��״̬
     * @throws Exception
     */
    public void updateByKeyFor6(String paymentNo,String vflag)throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpaymainAction.updateByKeyFor6(dbManager,paymentNo,vflag);
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
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymainAction.findPayQueryByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymainAction.queryThirdPayByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymainAction.findPayQueryByConditionsNew(dbManager,conditions,pageNo,rowsPerPage);
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
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpaymainAction.updateThirdPayFlag(dbManager,paymentNo,thirdPayFlag);
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
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpaymainAction.updateVflagAndThirdPayFlag(dbManager, paymentNo, vflag, thirdPayFlag);
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
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymainAction.findPayQueryByConditionsBack(dbManager,conditions,conditions1,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
	}
	
	public PageRecord findPayQueryByConditionsBack(String conditions,String conditions1,String conditions2,
			int pageNo, int rowsPerPage) throws Exception {
		PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        if(conditions2.trim().length()==0){
            conditions2 = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymainAction.findPayQueryByConditionsBack(dbManager,conditions,conditions1,conditions2,pageNo,rowsPerPage);
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
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymainAction.findPayStatisticsByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            count = blPrpLpaymainAction.getPayStatisticsCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return count;
    }
}
