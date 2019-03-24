package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfPackageAction;
import com.sinosoft.claim.dto.domain.SwfPackageDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfPackage��������־ҵ����Ϣ����������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.734<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfPackageFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfPackageFacadeBase.class);

    /**
     * ���캯��
     */
    public BLSwfPackageFacadeBase(){
    }

    /**
     * ����һ������
     * @param swfPackageDto swfPackageDto
     * @throws Exception
     */
    public void insert(SwfPackageDto swfPackageDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPackageAction blSwfPackageAction = new BLSwfPackageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blSwfPackageAction.insert(dbManager,swfPackageDto);
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
     * @param packageID ��������Ϣ��ID
     * @param detailNo ��ϸ�����
     * @throws Exception
     */
    public void delete(String packageID,int detailNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPackageAction blSwfPackageAction = new BLSwfPackageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blSwfPackageAction.delete(dbManager,packageID, detailNo);
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
        BLSwfPackageAction blSwfPackageAction = new BLSwfPackageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blSwfPackageAction.deleteByConditions(dbManager,conditions);
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
     * @param swfPackageDto swfPackageDto
     * @throws Exception
     */
    public void update(SwfPackageDto swfPackageDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPackageAction blSwfPackageAction = new BLSwfPackageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blSwfPackageAction.update(dbManager,swfPackageDto);
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
     * @param packageID ��������Ϣ��ID
     * @param detailNo ��ϸ�����
     * @return swfPackageDto swfPackageDto
     * @throws Exception
     */
    public SwfPackageDto findByPrimaryKey(String packageID,int detailNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfPackageAction blSwfPackageAction = new BLSwfPackageAction();
        //����DTO
        SwfPackageDto swfPackageDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            swfPackageDto = blSwfPackageAction.findByPrimaryKey(dbManager,packageID, detailNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfPackageDto;
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
        BLSwfPackageAction blSwfPackageAction = new BLSwfPackageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfPackageAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����swfPackageDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfPackageAction blSwfPackageAction = new BLSwfPackageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blSwfPackageAction.findByConditions(dbManager,conditions);
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
        BLSwfPackageAction blSwfPackageAction = new BLSwfPackageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSwfPackageAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
