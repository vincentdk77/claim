package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplinterAutoClaimDetailAction;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�������Զ�����״̬��ѯ���ҵ���߼�����Facade����<br>
 */
public class BLPrplinterAutoClaimDetailFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplinterAutoClaimDetailFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplinterAutoClaimDetailFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void insert(PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplinterAutoClaimDetailAction.insert(dbManager,prplinterAutoClaimDetailDto);
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
     * @param id ����
     * @param registNo ��������
     * @throws Exception
     */
    public void delete(String id,String registNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplinterAutoClaimDetailAction.delete(dbManager,id, registNo);
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
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplinterAutoClaimDetailAction.deleteByConditions(dbManager,conditions);
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
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void update(PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplinterAutoClaimDetailAction.update(dbManager,prplinterAutoClaimDetailDto);
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
     * @param id ����
     * @param registNo ��������
     * @return prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public PrplinterAutoClaimDetailDto findByPrimaryKey(String id,String registNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        //����DTO
        PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplinterAutoClaimDetailDto = blPrplinterAutoClaimDetailAction.findByPrimaryKey(dbManager,id, registNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplinterAutoClaimDetailDto;
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
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplinterAutoClaimDetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplinterAutoClaimDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplinterAutoClaimDetailAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    
    /**
     * ��SQL����һ������(���������޷����)
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void updateBySQL(String sql)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplinterAutoClaimDetailAction.updateBySQL(dbManager,sql);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
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
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplinterAutoClaimDetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
