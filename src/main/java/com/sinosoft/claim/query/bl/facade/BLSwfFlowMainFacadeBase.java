package com.sinosoft.claim.query.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfFlowMainAction;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfFlowMain-����������������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfFlowMainFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfFlowMainFacadeBase.class);

    /**
     * ���캯��
     */
    public BLSwfFlowMainFacadeBase(){
    }

    /**
     * ����һ������
     * @param swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public void insert(SwfFlowMainDto swfFlowMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blSwfFlowMainAction.insert(dbManager,swfFlowMainDto);
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
     * @param flowID ���̱��
     * @throws Exception
     */
    public void delete(String flowID) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blSwfFlowMainAction.delete(dbManager,flowID);
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
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blSwfFlowMainAction.deleteByConditions(dbManager,conditions);
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
     * @param swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public void update(SwfFlowMainDto swfFlowMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blSwfFlowMainAction.update(dbManager,swfFlowMainDto);
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
     * @param flowID ���̱��
     * @return swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public SwfFlowMainDto findByPrimaryKey(String flowID) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        //����DTO
        SwfFlowMainDto swfFlowMainDto = null;
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            //��ѯ����,��ֵ��DTO
            swfFlowMainDto = blSwfFlowMainAction.findByPrimaryKey(dbManager,flowID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfFlowMainDto;
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
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfFlowMainAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����swfFlowMainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blSwfFlowMainAction.findByConditions(dbManager,conditions);
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
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSwfFlowMainAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
