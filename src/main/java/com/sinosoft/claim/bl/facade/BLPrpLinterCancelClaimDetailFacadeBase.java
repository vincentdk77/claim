package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterCancelClaimDetailAction;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������ע��������Ϣ�������ҵ���߼�����Facade����<br>
 */
public class BLPrpLinterCancelClaimDetailFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCancelClaimDetailFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCancelClaimDetailFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public void insert(PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLinterCancelClaimDetailAction.insert(dbManager,prpLinterCancelClaimDetailDto);
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
     * @throws Exception
     */
    public void delete(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLinterCancelClaimDetailAction.delete(dbManager,id);
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
        BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLinterCancelClaimDetailAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public void update(PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLinterCancelClaimDetailAction.update(dbManager,prpLinterCancelClaimDetailDto);
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
     * @return prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public PrpLinterCancelClaimDetailDto findByPrimaryKey(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
        //����DTO
        PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLinterCancelClaimDetailDto = blPrpLinterCancelClaimDetailAction.findByPrimaryKey(dbManager,id);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterCancelClaimDetailDto;
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
        BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterCancelClaimDetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLinterCancelClaimDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterCancelClaimDetailAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterCancelClaimDetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
