package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfNotionAction;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ���ǹ��������������ҵ���߼�����Facade����<br>
 * ������ 2005-04-05 10:45:06.859<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfNotionFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfNotionFacadeBase.class);

    /**
     * ���캯��
     */
    public BLSwfNotionFacadeBase(){
    }

    /**
     * ����һ������
     * @param swfNotionDto swfNotionDto
     * @throws Exception
     */
    public void insert(SwfNotionDto swfNotionDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blSwfNotionAction.insert(dbManager,swfNotionDto);
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
     * @param flowID ������ID
     * @param logNo ��־���
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(String flowID,int logNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blSwfNotionAction.delete(dbManager,flowID, logNo, lineNo);
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
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blSwfNotionAction.deleteByConditions(dbManager,conditions);
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
     * @param swfNotionDto swfNotionDto
     * @throws Exception
     */
    public void update(SwfNotionDto swfNotionDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blSwfNotionAction.update(dbManager,swfNotionDto);
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
     * @param flowID ������ID
     * @param logNo ��־���
     * @param lineNo �к�
     * @return swfNotionDto swfNotionDto
     * @throws Exception
     */
    public SwfNotionDto findByPrimaryKey(String flowID,int logNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        //����DTO
        SwfNotionDto swfNotionDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            swfNotionDto = blSwfNotionAction.findByPrimaryKey(dbManager,flowID, logNo, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfNotionDto;
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
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blSwfNotionAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����swfNotionDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            collection = blSwfNotionAction.findByConditions(dbManager,conditions);
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
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blSwfNotionAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
