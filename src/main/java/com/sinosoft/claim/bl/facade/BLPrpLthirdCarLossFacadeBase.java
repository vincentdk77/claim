package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLthirdCarLossAction;
import com.sinosoft.claim.dto.domain.PrpLthirdCarLossDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdCarLoss-��ʧ��λ(����)��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.656<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdCarLossFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdCarLossFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLthirdCarLossFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLthirdCarLossDto prpLthirdCarLossDto
     * @throws Exception
     */
    public void insert(PrpLthirdCarLossDto prpLthirdCarLossDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdCarLossAction blPrpLthirdCarLossAction = new BLPrpLthirdCarLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLthirdCarLossAction.insert(dbManager,prpLthirdCarLossDto);
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
     * @param serialNo ���
     * @param itemNo ��ʧ��Ŀ���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,int itemNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdCarLossAction blPrpLthirdCarLossAction = new BLPrpLthirdCarLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLthirdCarLossAction.delete(dbManager,registNo, serialNo, itemNo);
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
        BLPrpLthirdCarLossAction blPrpLthirdCarLossAction = new BLPrpLthirdCarLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLthirdCarLossAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLthirdCarLossDto prpLthirdCarLossDto
     * @throws Exception
     */
    public void update(PrpLthirdCarLossDto prpLthirdCarLossDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdCarLossAction blPrpLthirdCarLossAction = new BLPrpLthirdCarLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLthirdCarLossAction.update(dbManager,prpLthirdCarLossDto);
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
     * @param serialNo ���
     * @param itemNo ��ʧ��Ŀ���
     * @return prpLthirdCarLossDto prpLthirdCarLossDto
     * @throws Exception
     */
    public PrpLthirdCarLossDto findByPrimaryKey(String registNo,int serialNo,int itemNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdCarLossAction blPrpLthirdCarLossAction = new BLPrpLthirdCarLossAction();
        //����DTO
        PrpLthirdCarLossDto prpLthirdCarLossDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLthirdCarLossDto = blPrpLthirdCarLossAction.findByPrimaryKey(dbManager,registNo, serialNo, itemNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLthirdCarLossDto;
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
        BLPrpLthirdCarLossAction blPrpLthirdCarLossAction = new BLPrpLthirdCarLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLthirdCarLossAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLthirdCarLossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLthirdCarLossAction blPrpLthirdCarLossAction = new BLPrpLthirdCarLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLthirdCarLossAction.findByConditions(dbManager,conditions);
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
        BLPrpLthirdCarLossAction blPrpLthirdCarLossAction = new BLPrpLthirdCarLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLthirdCarLossAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
