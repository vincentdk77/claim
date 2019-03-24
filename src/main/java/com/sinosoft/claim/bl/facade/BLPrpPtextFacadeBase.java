package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpPtextAction;
import com.sinosoft.claim.dto.domain.PrpPtextDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpptext����������Ϣ��ҵ���߼�����Facade����<br>
 * ������ 2004-11-22 15:24:35.625<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPtextFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpPtextFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpPtextFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpPtextDto prpPtextDto
     * @throws Exception
     */
    public void insert(PrpPtextDto prpPtextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpPtextAction.insert(dbManager,prpPtextDto);
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
     * @param endorseNo �����Ŵ�
     * @param policyNo ���յ��Ŵ�
     * @param lineNo ���ĵ��к�
     * @throws Exception
     */
    public void delete(String endorseNo,String policyNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpPtextAction.delete(dbManager,endorseNo, policyNo, lineNo);
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
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpPtextAction.deleteByConditions(dbManager,conditions);
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
     * @param prpPtextDto prpPtextDto
     * @throws Exception
     */
    public void update(PrpPtextDto prpPtextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpPtextAction.update(dbManager,prpPtextDto);
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
     * @param endorseNo �����Ŵ�
     * @param policyNo ���յ��Ŵ�
     * @param lineNo ���ĵ��к�
     * @return prpPtextDto prpPtextDto
     * @throws Exception
     */
    public PrpPtextDto findByPrimaryKey(String endorseNo,String policyNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        //����DTO
        PrpPtextDto prpPtextDto = null;
        try{
            dbManager.open("claimTempDataSource");
            //��ѯ����,��ֵ��DTO
            prpPtextDto = blPrpPtextAction.findByPrimaryKey(dbManager,endorseNo, policyNo, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpPtextDto;
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
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            pageRecord = blPrpPtextAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpPtextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            collection = blPrpPtextAction.findByConditions(dbManager,conditions);
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
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            rowCount = blPrpPtextAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
