package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDpersonPayAction;
import com.sinosoft.claim.dto.domain.PrpDpersonPayDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDpersonPay��Ա�⸶��׼�����ҵ���߼�����Facade����<br>
 * ������ 2004-09-20 14:11:32.263<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDpersonPayFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonPayFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpDpersonPayFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public void insert(PrpDpersonPayDto prpDpersonPayDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpDpersonPayAction.insert(dbManager,prpDpersonPayDto);
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
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpDpersonPayAction.delete(dbManager,serialNo);
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
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpDpersonPayAction.deleteByConditions(dbManager,conditions);
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
     * @param prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public void update(PrpDpersonPayDto prpDpersonPayDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpDpersonPayAction.update(dbManager,prpDpersonPayDto);
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
     * @param serialNo ���
     * @return prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public PrpDpersonPayDto findByPrimaryKey(int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        //����DTO
        PrpDpersonPayDto prpDpersonPayDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpDpersonPayDto = blPrpDpersonPayAction.findByPrimaryKey(dbManager,serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDpersonPayDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpDpersonPayAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpDpersonPayDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpDpersonPayAction.findByConditions(dbManager,conditions);
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
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDpersonPayAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
