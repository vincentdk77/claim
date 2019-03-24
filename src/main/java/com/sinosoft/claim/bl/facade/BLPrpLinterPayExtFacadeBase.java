package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayExtAction;
import com.sinosoft.claim.dto.domain.PrpLinterPayExtDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�������ӱ�------���������ҵ���߼�����Facade����<br>
 */
public class BLPrpLinterPayExtFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayExtFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayExtFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public void insert(PrpLinterPayExtDto prpLinterPayExtDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLinterPayExtAction.insert(dbManager,prpLinterPayExtDto);
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
     * @param id ����id PK
     * @param serialNo ������� PK
     * @throws Exception
     */
    public void delete(String id,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLinterPayExtAction.delete(dbManager,id, serialNo);
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
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLinterPayExtAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public void update(PrpLinterPayExtDto prpLinterPayExtDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLinterPayExtAction.update(dbManager,prpLinterPayExtDto);
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
     * @param id ����id PK
     * @param serialNo ������� PK
     * @return prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public PrpLinterPayExtDto findByPrimaryKey(String id,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        //����DTO
        PrpLinterPayExtDto prpLinterPayExtDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLinterPayExtDto = blPrpLinterPayExtAction.findByPrimaryKey(dbManager,id, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterPayExtDto;
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
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterPayExtAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLinterPayExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterPayExtAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterPayExtAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
