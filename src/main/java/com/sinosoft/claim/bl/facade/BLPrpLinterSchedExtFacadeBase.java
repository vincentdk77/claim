package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterSchedExtAction;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǲ���˵����Ϣ��ҵ���߼�����Facade����<br>
 */
public class BLPrpLinterSchedExtFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterSchedExtFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterSchedExtFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLinterSchedExtDto prpLinterSchedExtDto
     * @throws Exception
     */
    public void insert(PrpLinterSchedExtDto prpLinterSchedExtDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterSchedExtAction blPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLinterSchedExtAction.insert(dbManager,prpLinterSchedExtDto);
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
     * @throws Exception
     */
    public void delete(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterSchedExtAction blPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLinterSchedExtAction.delete(dbManager,id);
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
        BLPrpLinterSchedExtAction blPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLinterSchedExtAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterSchedExtDto prpLinterSchedExtDto
     * @throws Exception
     */
    public void update(PrpLinterSchedExtDto prpLinterSchedExtDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterSchedExtAction blPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLinterSchedExtAction.update(dbManager,prpLinterSchedExtDto);
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
     * @return prpLinterSchedExtDto prpLinterSchedExtDto
     * @throws Exception
     */
    public PrpLinterSchedExtDto findByPrimaryKey(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterSchedExtAction blPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
        //����DTO
        PrpLinterSchedExtDto prpLinterSchedExtDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLinterSchedExtDto = blPrpLinterSchedExtAction.findByPrimaryKey(dbManager,id);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterSchedExtDto;
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
        BLPrpLinterSchedExtAction blPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterSchedExtAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLinterSchedExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterSchedExtAction blPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterSchedExtAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterSchedExtAction blPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterSchedExtAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
