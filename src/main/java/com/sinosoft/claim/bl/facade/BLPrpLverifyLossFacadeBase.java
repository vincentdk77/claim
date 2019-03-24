package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLverifyLossAction;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLverifyLoss-������������������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLverifyLossFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLverifyLossFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLverifyLossFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLverifyLossDto prpLverifyLossDto
     * @throws Exception
     */
    public void insert(PrpLverifyLossDto prpLverifyLossDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLverifyLossAction blPrpLverifyLossAction = new BLPrpLverifyLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLverifyLossAction.insert(dbManager,prpLverifyLossDto);
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
     * @param registNo ��������
     * @param lossItemCode ������
     * @throws Exception
     */
    public void delete(String registNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLverifyLossAction blPrpLverifyLossAction = new BLPrpLverifyLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLverifyLossAction.delete(dbManager,registNo, lossItemCode);
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
        BLPrpLverifyLossAction blPrpLverifyLossAction = new BLPrpLverifyLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLverifyLossAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLverifyLossDto prpLverifyLossDto
     * @throws Exception
     */
    public void update(PrpLverifyLossDto prpLverifyLossDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLverifyLossAction blPrpLverifyLossAction = new BLPrpLverifyLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLverifyLossAction.update(dbManager,prpLverifyLossDto);
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
     * @param registNo ��������
     * @param lossItemCode ������
     * @return prpLverifyLossDto prpLverifyLossDto
     * @throws Exception
     */
    public PrpLverifyLossDto findByPrimaryKey(String registNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLverifyLossAction blPrpLverifyLossAction = new BLPrpLverifyLossAction();
        //����DTO
        PrpLverifyLossDto prpLverifyLossDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLverifyLossDto = blPrpLverifyLossAction.findByPrimaryKey(dbManager,registNo, lossItemCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLverifyLossDto;
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
        BLPrpLverifyLossAction blPrpLverifyLossAction = new BLPrpLverifyLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLverifyLossAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLverifyLossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLverifyLossAction blPrpLverifyLossAction = new BLPrpLverifyLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLverifyLossAction.findByConditions(dbManager,conditions);
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
        BLPrpLverifyLossAction blPrpLverifyLossAction = new BLPrpLverifyLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLverifyLossAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
