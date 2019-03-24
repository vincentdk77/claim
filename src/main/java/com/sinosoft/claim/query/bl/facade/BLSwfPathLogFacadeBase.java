package com.sinosoft.claim.query.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfPathLogAction;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfPathLog������·����־����������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.734<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfPathLogFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfPathLogFacadeBase.class);

    /**
     * ���캯��
     */
    public BLSwfPathLogFacadeBase(){
    }

    /**
     * ����һ������
     * @param swfPathLogDto swfPathLogDto
     * @throws Exception
     */
    public void insert(SwfPathLogDto swfPathLogDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPathLogAction blSwfPathLogAction = new BLSwfPathLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blSwfPathLogAction.insert(dbManager,swfPathLogDto);
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
     * @param pathNo ���̱ߺ�
     * @throws Exception
     */
    public void delete(String flowID,int pathNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPathLogAction blSwfPathLogAction = new BLSwfPathLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blSwfPathLogAction.delete(dbManager,flowID, pathNo);
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
        BLSwfPathLogAction blSwfPathLogAction = new BLSwfPathLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blSwfPathLogAction.deleteByConditions(dbManager,conditions);
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
     * @param swfPathLogDto swfPathLogDto
     * @throws Exception
     */
    public void update(SwfPathLogDto swfPathLogDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPathLogAction blSwfPathLogAction = new BLSwfPathLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blSwfPathLogAction.update(dbManager,swfPathLogDto);
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
     * @param pathNo ���̱ߺ�
     * @return swfPathLogDto swfPathLogDto
     * @throws Exception
     */
    public SwfPathLogDto findByPrimaryKey(String flowID,int pathNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPathLogAction blSwfPathLogAction = new BLSwfPathLogAction();
        //����DTO
        SwfPathLogDto swfPathLogDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            swfPathLogDto = blSwfPathLogAction.findByPrimaryKey(dbManager,flowID, pathNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfPathLogDto;
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
        BLSwfPathLogAction blSwfPathLogAction = new BLSwfPathLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfPathLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����swfPathLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfPathLogAction blSwfPathLogAction = new BLSwfPathLogAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            collection = blSwfPathLogAction.findByConditions(dbManager,conditions);
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
        BLSwfPathLogAction blSwfPathLogAction = new BLSwfPathLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSwfPathLogAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
