package com.sinosoft.ciplatform.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.ciplatform.bl.action.domain.BLCIClaimUploadRegistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����������Ϣƽ̨�ϴ�ע����ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadRegistFacadeBase{
    private static Logger logger = Logger.getLogger(BLCIClaimUploadRegistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCIClaimUploadRegistFacadeBase(){
    }
    

    /**
     * ����һ������
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public void insert(CIClaimUploadRegistDto cIClaimUploadRegistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimUploadRegistAction blCIClaimUploadRegistAction = new BLCIClaimUploadRegistAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blCIClaimUploadRegistAction.insert(dbManager,cIClaimUploadRegistDto);
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
     * @throws Exception
     */
    public void delete(String uploadNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimUploadRegistAction blCIClaimUploadRegistAction = new BLCIClaimUploadRegistAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blCIClaimUploadRegistAction.delete(dbManager,uploadNo);
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
        BLCIClaimUploadRegistAction blCIClaimUploadRegistAction = new BLCIClaimUploadRegistAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blCIClaimUploadRegistAction.deleteByConditions(dbManager,conditions);
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
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public void update(CIClaimUploadRegistDto cIClaimUploadRegistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimUploadRegistAction blCIClaimUploadRegistAction = new BLCIClaimUploadRegistAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blCIClaimUploadRegistAction.update(dbManager,cIClaimUploadRegistDto);
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
     * @return cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public CIClaimUploadRegistDto findByPrimaryKey(String uploadNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimUploadRegistAction blCIClaimUploadRegistAction = new BLCIClaimUploadRegistAction();
        //����DTO
        CIClaimUploadRegistDto cIClaimUploadRegistDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            cIClaimUploadRegistDto = blCIClaimUploadRegistAction.findByPrimaryKey(dbManager,uploadNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return cIClaimUploadRegistDto;
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
        BLCIClaimUploadRegistAction blCIClaimUploadRegistAction = new BLCIClaimUploadRegistAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blCIClaimUploadRegistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����cIClaimUploadRegistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCIClaimUploadRegistAction blCIClaimUploadRegistAction = new BLCIClaimUploadRegistAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blCIClaimUploadRegistAction.findByConditions(dbManager,conditions);
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
        BLCIClaimUploadRegistAction blCIClaimUploadRegistAction = new BLCIClaimUploadRegistAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blCIClaimUploadRegistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
