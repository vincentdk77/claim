package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterCompeFeeAction;
import com.sinosoft.claim.dto.domain.PrpLinterCompeFeeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǽ����������Ϣ��ҵ���߼�����Facade����<br>
 */
public class BLPrpLinterCompeFeeFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeFeeFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCompeFeeFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLinterCompeFeeDto prpLinterCompeFeeDto
     * @throws Exception
     */
    public void insert(PrpLinterCompeFeeDto prpLinterCompeFeeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompeFeeAction blPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLinterCompeFeeAction.insert(dbManager,prpLinterCompeFeeDto);
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
     * @param id ����pk
     * @param serialNo �������pk
     * @throws Exception
     */
    public void delete(String id,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompeFeeAction blPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLinterCompeFeeAction.delete(dbManager,id, serialNo);
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
        BLPrpLinterCompeFeeAction blPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLinterCompeFeeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterCompeFeeDto prpLinterCompeFeeDto
     * @throws Exception
     */
    public void update(PrpLinterCompeFeeDto prpLinterCompeFeeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompeFeeAction blPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLinterCompeFeeAction.update(dbManager,prpLinterCompeFeeDto);
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
     * @param id ����pk
     * @param serialNo �������pk
     * @return prpLinterCompeFeeDto prpLinterCompeFeeDto
     * @throws Exception
     */
    public PrpLinterCompeFeeDto findByPrimaryKey(String id,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompeFeeAction blPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
        //����DTO
        PrpLinterCompeFeeDto prpLinterCompeFeeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLinterCompeFeeDto = blPrpLinterCompeFeeAction.findByPrimaryKey(dbManager,id, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterCompeFeeDto;
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
        BLPrpLinterCompeFeeAction blPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterCompeFeeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLinterCompeFeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterCompeFeeAction blPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterCompeFeeAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterCompeFeeAction blPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterCompeFeeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
