package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLltextAction;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLltext-�������ֱ��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.437<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLltextFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLltextFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLltextFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLltextDto prpLltextDto
     * @throws Exception
     */
    public void insert(PrpLltextDto prpLltextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLltextAction blPrpLltextAction = new BLPrpLltextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLltextAction.insert(dbManager,prpLltextDto);
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
     * @param claimNo �ⰸ����
     * @param textType ����˵������ ��
--** ����ժҪ/�鿱����/�᰸����
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(String claimNo,String textType,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLltextAction blPrpLltextAction = new BLPrpLltextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLltextAction.delete(dbManager,claimNo, textType, lineNo);
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
        BLPrpLltextAction blPrpLltextAction = new BLPrpLltextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLltextAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLltextDto prpLltextDto
     * @throws Exception
     */
    public void update(PrpLltextDto prpLltextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLltextAction blPrpLltextAction = new BLPrpLltextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLltextAction.update(dbManager,prpLltextDto);
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
     * @param claimNo �ⰸ����
     * @param textType ����˵������ ��
--** ����ժҪ/�鿱����/�᰸����
     * @param lineNo �к�
     * @return prpLltextDto prpLltextDto
     * @throws Exception
     */
    public PrpLltextDto findByPrimaryKey(String claimNo,String textType,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLltextAction blPrpLltextAction = new BLPrpLltextAction();
        //����DTO
        PrpLltextDto prpLltextDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLltextDto = blPrpLltextAction.findByPrimaryKey(dbManager,claimNo, textType, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLltextDto;
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
        BLPrpLltextAction blPrpLltextAction = new BLPrpLltextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLltextAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLltextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLltextAction blPrpLltextAction = new BLPrpLltextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLltextAction.findByConditions(dbManager,conditions);
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
        BLPrpLltextAction blPrpLltextAction = new BLPrpLltextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLltextAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
