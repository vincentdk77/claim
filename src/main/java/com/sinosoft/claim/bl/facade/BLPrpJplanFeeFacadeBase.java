package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpJplanFeeAction;
import com.sinosoft.claim.dto.domain.PrpJplanFeeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ӧ��Ӧ������Ϣ���ҵ���߼�����Facade����<br>
 */
public class BLPrpJplanFeeFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpJplanFeeFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpJplanFeeFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public void insert(PrpJplanFeeDto prpJplanFeeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpJplanFeeAction.insert(dbManager,prpJplanFeeDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ������ɾ��һ������
     * @param certiType ҵ������
     * @param certiNo ��������/��������
     * @param serialNo ���Ѽƻ����
     * @param payRefReason �ո�ԭ��
     * @throws Exception
     */
    public void delete(String certiType,String certiNo,int serialNo,String payRefReason)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();            dbManager.beginTransaction();
            //ɾ����¼
            blPrpJplanFeeAction.delete(dbManager,certiType, certiNo, serialNo, payRefReason);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ������ɾ������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpJplanFeeAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public void update(PrpJplanFeeDto prpJplanFeeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            dbManager.beginTransaction();
            //���¼�¼
            blPrpJplanFeeAction.update(dbManager,prpJplanFeeDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����������һ������
     * @param certiType ҵ������
     * @param certiNo ��������/��������
     * @param serialNo ���Ѽƻ����
     * @param payRefReason �ո�ԭ��
     * @return prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public PrpJplanFeeDto findByPrimaryKey(String certiType,String certiNo,int serialNo,String payRefReason)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        //����DTO
        PrpJplanFeeDto prpJplanFeeDto = null;
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //��ѯ����,��ֵ��DTO
            prpJplanFeeDto = blPrpJplanFeeAction.findByPrimaryKey(dbManager,certiType, certiNo, serialNo, payRefReason);
            dbManager.commitTransaction();
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpJplanFeeDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            pageRecord = blPrpJplanFeeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
            dbManager.commitTransaction();
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
     * @return Collection ����prpJplanFeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            collection = blPrpJplanFeeAction.findByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            rowCount = blPrpJplanFeeAction.getCount(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
