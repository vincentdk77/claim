package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpPheadAction;
import com.sinosoft.claim.dto.domain.PrpPheadDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpphead������Ϣ���ҵ���߼�����Facade����<br>
 * ������ 2004-11-22 15:24:35.156<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPheadFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpPheadFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpPheadFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpPheadDto prpPheadDto
     * @throws Exception
     */
    public void insert(PrpPheadDto prpPheadDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPheadAction blPrpPheadAction = new BLPrpPheadAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpPheadAction.insert(dbManager,prpPheadDto);
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
     * @param endorseNo ��������
     * @throws Exception
     */
    public void delete(String endorseNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPheadAction blPrpPheadAction = new BLPrpPheadAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpPheadAction.delete(dbManager,endorseNo);
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
        BLPrpPheadAction blPrpPheadAction = new BLPrpPheadAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpPheadAction.deleteByConditions(dbManager,conditions);
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
     * @param prpPheadDto prpPheadDto
     * @throws Exception
     */
    public void update(PrpPheadDto prpPheadDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPheadAction blPrpPheadAction = new BLPrpPheadAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpPheadAction.update(dbManager,prpPheadDto);
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
     * @param endorseNo ��������
     * @return prpPheadDto prpPheadDto
     * @throws Exception
     */
    public PrpPheadDto findByPrimaryKey(String endorseNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPheadAction blPrpPheadAction = new BLPrpPheadAction();
        //����DTO
        PrpPheadDto prpPheadDto = null;
        try{
            dbManager.open("claimTempDataSource");
            //��ѯ����,��ֵ��DTO
            prpPheadDto = blPrpPheadAction.findByPrimaryKey(dbManager,endorseNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpPheadDto;
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
        BLPrpPheadAction blPrpPheadAction = new BLPrpPheadAction();
        try{
            dbManager.open("claimTempDataSource");
            pageRecord = blPrpPheadAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpPheadDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpPheadAction blPrpPheadAction = new BLPrpPheadAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpPheadAction.findByConditions(dbManager,conditions);
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
        BLPrpPheadAction blPrpPheadAction = new BLPrpPheadAction();
        try{
            dbManager.open("claimTempDataSource");
            rowCount = blPrpPheadAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
