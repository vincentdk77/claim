package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLrtextAction;
import com.sinosoft.claim.dto.domain.PrpLrtextDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLrtext-׷����������˵����ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.500<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLrtextFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLrtextFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLrtextFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public void insert(PrpLrtextDto prpLrtextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLrtextAction.insert(dbManager,prpLrtextDto);
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
     * @param serialNo ���
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(String claimNo,String textType,int serialNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLrtextAction.delete(dbManager,claimNo, textType, serialNo, lineNo);
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
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLrtextAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public void update(PrpLrtextDto prpLrtextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLrtextAction.update(dbManager,prpLrtextDto);
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
     * @param serialNo ���
     * @param lineNo �к�
     * @return prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public PrpLrtextDto findByPrimaryKey(String claimNo,String textType,int serialNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        //����DTO
        PrpLrtextDto prpLrtextDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLrtextDto = blPrpLrtextAction.findByPrimaryKey(dbManager,claimNo, textType, serialNo, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLrtextDto;
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
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLrtextAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLrtextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLrtextAction.findByConditions(dbManager,conditions);
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
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLrtextAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
