package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLUtiCodeTransferAction;
import com.sinosoft.claim.dto.domain.UtiCodeTransferDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����UtiCodeTransfer -�������������ձ��ҵ���߼�����Facade����<br>
 * ������ 2005-05-09 09:01:24.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLUtiCodeTransferFacadeBase{
    private static Log logger = LogFactory.getLog(BLUtiCodeTransferFacadeBase.class);

    /**
     * ���캯��
     */
    public BLUtiCodeTransferFacadeBase(){
    }

    /**
     * ����һ������
     * @param utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public void insert(UtiCodeTransferDto utiCodeTransferDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blUtiCodeTransferAction.insert(dbManager,utiCodeTransferDto);
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
     * @param configCode �����д���
     * @throws Exception
     */
    public void delete(String configCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blUtiCodeTransferAction.delete(dbManager,configCode);
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
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blUtiCodeTransferAction.deleteByConditions(dbManager,conditions);
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
     * @param utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public void update(UtiCodeTransferDto utiCodeTransferDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blUtiCodeTransferAction.update(dbManager,utiCodeTransferDto);
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
     * @param configCode �����д���
     * @return utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public UtiCodeTransferDto findByPrimaryKey(String configCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        //����DTO
        UtiCodeTransferDto utiCodeTransferDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            utiCodeTransferDto = blUtiCodeTransferAction.findByPrimaryKey(dbManager,configCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return utiCodeTransferDto;
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
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blUtiCodeTransferAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����utiCodeTransferDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blUtiCodeTransferAction.findByConditions(dbManager,conditions);
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
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blUtiCodeTransferAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
