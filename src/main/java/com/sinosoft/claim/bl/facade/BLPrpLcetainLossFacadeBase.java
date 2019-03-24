package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcetainLossAction;
import com.sinosoft.claim.dto.domain.PrpLcetainLossDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcetainLoss��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.765<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcetainLossFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcetainLossFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcetainLossFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLcetainLossDto prpLcetainLossDto
     * @throws Exception
     */
    public void insert(PrpLcetainLossDto prpLcetainLossDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcetainLossAction blPrpLcetainLossAction = new BLPrpLcetainLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLcetainLossAction.insert(dbManager,prpLcetainLossDto);
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
     * @param claimNo �ⰸ��
     * @param itemNo ������
     * @throws Exception
     */
    public void delete(String claimNo,int itemNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcetainLossAction blPrpLcetainLossAction = new BLPrpLcetainLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLcetainLossAction.delete(dbManager,claimNo, itemNo);
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
        BLPrpLcetainLossAction blPrpLcetainLossAction = new BLPrpLcetainLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLcetainLossAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcetainLossDto prpLcetainLossDto
     * @throws Exception
     */
    public void update(PrpLcetainLossDto prpLcetainLossDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcetainLossAction blPrpLcetainLossAction = new BLPrpLcetainLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLcetainLossAction.update(dbManager,prpLcetainLossDto);
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
     * @param claimNo �ⰸ��
     * @param itemNo ������
     * @return prpLcetainLossDto prpLcetainLossDto
     * @throws Exception
     */
    public PrpLcetainLossDto findByPrimaryKey(String claimNo,int itemNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcetainLossAction blPrpLcetainLossAction = new BLPrpLcetainLossAction();
        //����DTO
        PrpLcetainLossDto prpLcetainLossDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLcetainLossDto = blPrpLcetainLossAction.findByPrimaryKey(dbManager,claimNo, itemNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcetainLossDto;
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
        BLPrpLcetainLossAction blPrpLcetainLossAction = new BLPrpLcetainLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLcetainLossAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLcetainLossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcetainLossAction blPrpLcetainLossAction = new BLPrpLcetainLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLcetainLossAction.findByConditions(dbManager,conditions);
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
        BLPrpLcetainLossAction blPrpLcetainLossAction = new BLPrpLcetainLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLcetainLossAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
