package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfPathLogStoreAction;
import com.sinosoft.claim.dto.domain.SwfPathLogStoreDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SwfPathLogStore��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSwfPathLogStoreFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfPathLogStoreFacadeBase.class);

    /**
     * ���캯��
     */
    public BLSwfPathLogStoreFacadeBase(){
    }

    /**
     * ����һ������
     * @param swfPathLogStoreDto swfPathLogStoreDto
     * @throws Exception
     */
    public void insert(SwfPathLogStoreDto swfPathLogStoreDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPathLogStoreAction blSwfPathLogStoreAction = new BLSwfPathLogStoreAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blSwfPathLogStoreAction.insert(dbManager,swfPathLogStoreDto);
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
     * @param flowID flowID
     * @throws Exception
     */
    public void delete(String flowID)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPathLogStoreAction blSwfPathLogStoreAction = new BLSwfPathLogStoreAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blSwfPathLogStoreAction.delete(dbManager,flowID);
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
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPathLogStoreAction blSwfPathLogStoreAction = new BLSwfPathLogStoreAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blSwfPathLogStoreAction.deleteByConditions(dbManager,conditions);
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
     * @param swfPathLogStoreDto swfPathLogStoreDto
     * @throws Exception
     */
    public void update(SwfPathLogStoreDto swfPathLogStoreDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPathLogStoreAction blSwfPathLogStoreAction = new BLSwfPathLogStoreAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blSwfPathLogStoreAction.update(dbManager,swfPathLogStoreDto);
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
     * @param flowID flowID
     * @return swfPathLogStoreDto swfPathLogStoreDto
     * @throws Exception
     */
    public SwfPathLogStoreDto findByPrimaryKey(String flowID)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPathLogStoreAction blSwfPathLogStoreAction = new BLSwfPathLogStoreAction();
        //����DTO
        SwfPathLogStoreDto swfPathLogStoreDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            swfPathLogStoreDto = blSwfPathLogStoreAction.findByPrimaryKey(dbManager,flowID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfPathLogStoreDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfPathLogStoreAction blSwfPathLogStoreAction = new BLSwfPathLogStoreAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blSwfPathLogStoreAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����swfPathLogStoreDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfPathLogStoreAction blSwfPathLogStoreAction = new BLSwfPathLogStoreAction();
        try{
            dbManager.open("claimDataSource");
            collection = blSwfPathLogStoreAction.findByConditions(dbManager,conditions);
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
        BLSwfPathLogStoreAction blSwfPathLogStoreAction = new BLSwfPathLogStoreAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blSwfPathLogStoreAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
