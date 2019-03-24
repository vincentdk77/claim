package com.sinosoft.claim.bl.facade;

import java.util.*;

import com.sinosoft.claim.bl.action.domain.BLPrplPayeeInfoAction;
import com.sinosoft.claim.dto.domain.PrplPayeeInfoDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrplPayeeInfo��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplPayeeInfoFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplPayeeInfoFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplPayeeInfoFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplPayeeInfoDto prplPayeeInfoDto
     * @throws Exception
     */
    public void insert(PrplPayeeInfoDto prplPayeeInfoDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplPayeeInfoAction blPrplPayeeInfoAction = new BLPrplPayeeInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplPayeeInfoAction.insert(dbManager,prplPayeeInfoDto);
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
     * @param receiverFullName receiverFullName
     * @throws Exception
     */
    public void delete(String receiverFullName)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplPayeeInfoAction blPrplPayeeInfoAction = new BLPrplPayeeInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplPayeeInfoAction.delete(dbManager,receiverFullName);
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
        BLPrplPayeeInfoAction blPrplPayeeInfoAction = new BLPrplPayeeInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplPayeeInfoAction.deleteByConditions(dbManager,conditions);
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
     * @param prplPayeeInfoDto prplPayeeInfoDto
     * @throws Exception
     */
    public void update(PrplPayeeInfoDto prplPayeeInfoDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplPayeeInfoAction blPrplPayeeInfoAction = new BLPrplPayeeInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplPayeeInfoAction.update(dbManager,prplPayeeInfoDto);
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
     * @param receiverFullName receiverFullName
     * @return prplPayeeInfoDto prplPayeeInfoDto
     * @throws Exception
     */
    public PrplPayeeInfoDto findByPrimaryKey(String receiverFullName)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplPayeeInfoAction blPrplPayeeInfoAction = new BLPrplPayeeInfoAction();
        //����DTO
        PrplPayeeInfoDto prplPayeeInfoDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplPayeeInfoDto = blPrplPayeeInfoAction.findByPrimaryKey(dbManager,receiverFullName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplPayeeInfoDto;
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
        BLPrplPayeeInfoAction blPrplPayeeInfoAction = new BLPrplPayeeInfoAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplPayeeInfoAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplPayeeInfoDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplPayeeInfoAction blPrplPayeeInfoAction = new BLPrplPayeeInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplPayeeInfoAction.findByConditions(dbManager,conditions);
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
        BLPrplPayeeInfoAction blPrplPayeeInfoAction = new BLPrplPayeeInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplPayeeInfoAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
