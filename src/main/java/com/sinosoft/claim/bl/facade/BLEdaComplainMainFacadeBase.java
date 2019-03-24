package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLEdaComplainMainAction;
import com.sinosoft.claim.dto.domain.EdaComplainMainDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaComplainMainͶ����Ϣ���ҵ���߼�����Facade����<br>
 * ������ 2005-08-20 17:56:02.116<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainMainFacadeBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainMainFacadeBase.class);

    /**
     * ���캯��
     */
    public BLEdaComplainMainFacadeBase(){
    }

    /**
     * ����һ������
     * @param edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public void insert(EdaComplainMainDto edaComplainMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //�����¼
            blEdaComplainMainAction.insert(dbManager,edaComplainMainDto);
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
     * @param acceptNo Ͷ�ߵǼǺ�
     * @throws Exception
     */
    public void delete(int acceptNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //ɾ����¼
            blEdaComplainMainAction.delete(dbManager,acceptNo);
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
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //������ɾ����¼
            blEdaComplainMainAction.deleteByConditions(dbManager,conditions);
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
     * @param edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public void update(EdaComplainMainDto edaComplainMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //���¼�¼
            blEdaComplainMainAction.update(dbManager,edaComplainMainDto);
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
     * @param acceptNo Ͷ�ߵǼǺ�
     * @return edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public EdaComplainMainDto findByPrimaryKey(int acceptNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        //����DTO
        EdaComplainMainDto edaComplainMainDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //��ѯ����,��ֵ��DTO
            edaComplainMainDto = blEdaComplainMainAction.findByPrimaryKey(dbManager,acceptNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return edaComplainMainDto;
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
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blEdaComplainMainAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����edaComplainMainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blEdaComplainMainAction.findByConditions(dbManager,conditions);
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
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blEdaComplainMainAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
