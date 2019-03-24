package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;
import com.sinosoft.claim.bl.action.domain.BLPrpljobmanagertimeAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLJOBMANAGERTIME��ҵ���߼�����Facade����<br>
 */
public class BLPrpljobmanagertimeFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpljobmanagertimeFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpljobmanagertimeFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void insert(PrpljobmanagertimeDto prpljobmanagertimeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpljobmanagertimeAction.insert(dbManager,prpljobmanagertimeDto);
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
     * @param fid FID
     * @throws Exception
     */
    public void delete(String fid)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpljobmanagertimeAction.delete(dbManager,fid);
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
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpljobmanagertimeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void update(PrpljobmanagertimeDto prpljobmanagertimeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpljobmanagertimeAction.update(dbManager,prpljobmanagertimeDto);
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
     * @param fid FID
     * @return prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public PrpljobmanagertimeDto findByPrimaryKey(String fid)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        //����DTO
        PrpljobmanagertimeDto prpljobmanagertimeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpljobmanagertimeDto = blPrpljobmanagertimeAction.findByPrimaryKey(dbManager,fid);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpljobmanagertimeDto;
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
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpljobmanagertimeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpljobmanagertimeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpljobmanagertimeAction.findByConditions(dbManager,conditions);
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
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpljobmanagertimeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
