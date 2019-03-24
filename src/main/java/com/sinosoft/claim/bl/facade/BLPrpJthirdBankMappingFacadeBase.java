package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpJthirdBankMappingAction;
import com.sinosoft.claim.dto.domain.PrpJthirdBankMappingDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpJthirdBankMapping��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpJthirdBankMappingFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpJthirdBankMappingFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpJthirdBankMappingFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @throws Exception
     */
    public void insert(PrpJthirdBankMappingDto prpJthirdBankMappingDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJthirdBankMappingAction blPrpJthirdBankMappingAction = new BLPrpJthirdBankMappingAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpJthirdBankMappingAction.insert(dbManager,prpJthirdBankMappingDto);
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
     * @param thirdType thirdType
     * @throws Exception
     */
    public void delete(String thirdType)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJthirdBankMappingAction blPrpJthirdBankMappingAction = new BLPrpJthirdBankMappingAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpJthirdBankMappingAction.delete(dbManager,thirdType);
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
        BLPrpJthirdBankMappingAction blPrpJthirdBankMappingAction = new BLPrpJthirdBankMappingAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpJthirdBankMappingAction.deleteByConditions(dbManager,conditions);
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
     * @param prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @throws Exception
     */
    public void update(PrpJthirdBankMappingDto prpJthirdBankMappingDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJthirdBankMappingAction blPrpJthirdBankMappingAction = new BLPrpJthirdBankMappingAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpJthirdBankMappingAction.update(dbManager,prpJthirdBankMappingDto);
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
     * @param thirdType thirdType
     * @return prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @throws Exception
     */
    public PrpJthirdBankMappingDto findByPrimaryKey(String thirdType)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJthirdBankMappingAction blPrpJthirdBankMappingAction = new BLPrpJthirdBankMappingAction();
        //����DTO
        PrpJthirdBankMappingDto prpJthirdBankMappingDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpJthirdBankMappingDto = blPrpJthirdBankMappingAction.findByPrimaryKey(dbManager,thirdType);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpJthirdBankMappingDto;
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
        BLPrpJthirdBankMappingAction blPrpJthirdBankMappingAction = new BLPrpJthirdBankMappingAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpJthirdBankMappingAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpJthirdBankMappingDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpJthirdBankMappingAction blPrpJthirdBankMappingAction = new BLPrpJthirdBankMappingAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpJthirdBankMappingAction.findByConditions(dbManager,conditions);
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
        BLPrpJthirdBankMappingAction blPrpJthirdBankMappingAction = new BLPrpJthirdBankMappingAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpJthirdBankMappingAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
