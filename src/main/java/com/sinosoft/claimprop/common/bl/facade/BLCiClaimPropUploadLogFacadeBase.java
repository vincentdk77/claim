package com.sinosoft.claimprop.common.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropUploadLogDto;
import com.sinosoft.claimprop.common.bl.action.domain.BLCiClaimPropUploadLogAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CiClaimPropUploadLog��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimPropUploadLogFacadeBase{
    private static Logger logger = Logger.getLogger(BLCiClaimPropUploadLogFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCiClaimPropUploadLogFacadeBase(){
    }

    /**
     * ����һ������
     * @param ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public void insert(CiClaimPropUploadLogDto ciClaimPropUploadLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //�����¼
            blCiClaimPropUploadLogAction.insert(dbManager,ciClaimPropUploadLogDto);
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
     * @param businessNo businessNo
     * @throws Exception
     */
    public void delete(String businessNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blCiClaimPropUploadLogAction.delete(dbManager,businessNo);
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
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blCiClaimPropUploadLogAction.deleteByConditions(dbManager,conditions);
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
     * @param ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public void update(CiClaimPropUploadLogDto ciClaimPropUploadLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blCiClaimPropUploadLogAction.update(dbManager,ciClaimPropUploadLogDto);
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
     * @param businessNo businessNo
     * @return ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public CiClaimPropUploadLogDto findByPrimaryKey(String businessNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        //����DTO
        CiClaimPropUploadLogDto ciClaimPropUploadLogDto = null;
        try{
            dbManager.open("daaplatformDataSource");
            //��ѯ����,��ֵ��DTO
            ciClaimPropUploadLogDto = blCiClaimPropUploadLogAction.findByPrimaryKey(dbManager,businessNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return ciClaimPropUploadLogDto;
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
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            pageRecord = blCiClaimPropUploadLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����ciClaimPropUploadLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            collection = blCiClaimPropUploadLogAction.findByConditions(dbManager,conditions);
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
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            rowCount = blCiClaimPropUploadLogAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
