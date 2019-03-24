package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcomponentAction;
import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcomponent-������Ŀ�嵥(�޸�)��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.406<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcomponentFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcomponentFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcomponentFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLcomponentDto prpLcomponentDto
     * @throws Exception
     */
    public void insert(PrpLcomponentDto prpLcomponentDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcomponentAction blPrpLcomponentAction = new BLPrpLcomponentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLcomponentAction.insert(dbManager,prpLcomponentDto);
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
     * @param riskCode ����
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @throws Exception
     */
    public void delete(String riskCode,int serialNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcomponentAction blPrpLcomponentAction = new BLPrpLcomponentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLcomponentAction.delete(dbManager,riskCode, serialNo, lossItemCode);
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
        BLPrpLcomponentAction blPrpLcomponentAction = new BLPrpLcomponentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLcomponentAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcomponentDto prpLcomponentDto
     * @throws Exception
     */
    public void update(PrpLcomponentDto prpLcomponentDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcomponentAction blPrpLcomponentAction = new BLPrpLcomponentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLcomponentAction.update(dbManager,prpLcomponentDto);
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
     * @param riskCode ����
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @return prpLcomponentDto prpLcomponentDto
     * @throws Exception
     */
    public PrpLcomponentDto findByPrimaryKey(String riskCode,int serialNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcomponentAction blPrpLcomponentAction = new BLPrpLcomponentAction();
        //����DTO
        PrpLcomponentDto prpLcomponentDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLcomponentDto = blPrpLcomponentAction.findByPrimaryKey(dbManager,riskCode, serialNo, lossItemCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcomponentDto;
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
        BLPrpLcomponentAction blPrpLcomponentAction = new BLPrpLcomponentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLcomponentAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLcomponentDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcomponentAction blPrpLcomponentAction = new BLPrpLcomponentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLcomponentAction.findByConditions(dbManager,conditions);
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
        BLPrpLcomponentAction blPrpLcomponentAction = new BLPrpLcomponentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLcomponentAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
