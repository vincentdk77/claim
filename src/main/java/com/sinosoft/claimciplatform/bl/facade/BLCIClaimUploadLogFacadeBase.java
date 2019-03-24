package com.sinosoft.claimciplatform.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimUploadLogAction;
import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadLogDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����������Ϣ�ϴ�ƽ̨��־���ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadLogFacadeBase{
    private static Log logger = LogFactory.getLog(BLCIClaimUploadLogFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCIClaimUploadLogFacadeBase(){
    }

    /**
     * ����һ������
     * @param cIClaimUploadLogDto cIClaimUploadLogDto
     * @throws Exception
     */
    public void insert(CIClaimUploadLogDto cIClaimUploadLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimUploadLogAction blCIClaimUploadLogAction = new BLCIClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blCIClaimUploadLogAction.insert(dbManager,cIClaimUploadLogDto);
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
     * @param uploadNo �ϴ����
     * @param serialNo ˳���
     * @throws Exception
     */
    public void delete(String uploadNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimUploadLogAction blCIClaimUploadLogAction = new BLCIClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blCIClaimUploadLogAction.delete(dbManager,uploadNo, serialNo);
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
        BLCIClaimUploadLogAction blCIClaimUploadLogAction = new BLCIClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blCIClaimUploadLogAction.deleteByConditions(dbManager,conditions);
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
     * @param cIClaimUploadLogDto cIClaimUploadLogDto
     * @throws Exception
     */
    public void update(CIClaimUploadLogDto cIClaimUploadLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimUploadLogAction blCIClaimUploadLogAction = new BLCIClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blCIClaimUploadLogAction.update(dbManager,cIClaimUploadLogDto);
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
     * @param uploadNo �ϴ����
     * @param serialNo ˳���
     * @return cIClaimUploadLogDto cIClaimUploadLogDto
     * @throws Exception
     */
    public CIClaimUploadLogDto findByPrimaryKey(String uploadNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimUploadLogAction blCIClaimUploadLogAction = new BLCIClaimUploadLogAction();
        //����DTO
        CIClaimUploadLogDto cIClaimUploadLogDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            cIClaimUploadLogDto = blCIClaimUploadLogAction.findByPrimaryKey(dbManager,uploadNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return cIClaimUploadLogDto;
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
        BLCIClaimUploadLogAction blCIClaimUploadLogAction = new BLCIClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blCIClaimUploadLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����cIClaimUploadLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCIClaimUploadLogAction blCIClaimUploadLogAction = new BLCIClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blCIClaimUploadLogAction.findByConditions(dbManager,conditions);
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
        BLCIClaimUploadLogAction blCIClaimUploadLogAction = new BLCIClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blCIClaimUploadLogAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
