package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxendorchgdetailDto;
import com.gyic.claim.bl.action.domain.BLNyxendorchgdetailAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXENDORCHGDETAIL��ҵ���߼�����Facade����<br>
 */
public class BLNyxendorchgdetailFacadeBase{
    private static Logger logger = Logger.getLogger(BLNyxendorchgdetailFacadeBase.class);

    /**
     * ���캯��
     */
    public BLNyxendorchgdetailFacadeBase(){
    }

    /**
     * ����һ������
     * @param nyxendorchgdetailDto nyxendorchgdetailDto
     * @throws Exception
     */
    public void insert(NyxendorchgdetailDto nyxendorchgdetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxendorchgdetailAction blNyxendorchgdetailAction = new BLNyxendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blNyxendorchgdetailAction.insert(dbManager,nyxendorchgdetailDto);
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
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String businessno,String endorseno,String kindcode,String itemcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxendorchgdetailAction blNyxendorchgdetailAction = new BLNyxendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blNyxendorchgdetailAction.delete(dbManager,inusrelistcode, businessno, endorseno, kindcode, itemcode);
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
        BLNyxendorchgdetailAction blNyxendorchgdetailAction = new BLNyxendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blNyxendorchgdetailAction.deleteByConditions(dbManager,conditions);
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
     * @param nyxendorchgdetailDto nyxendorchgdetailDto
     * @throws Exception
     */
    public void update(NyxendorchgdetailDto nyxendorchgdetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxendorchgdetailAction blNyxendorchgdetailAction = new BLNyxendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blNyxendorchgdetailAction.update(dbManager,nyxendorchgdetailDto);
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
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return nyxendorchgdetailDto nyxendorchgdetailDto
     * @throws Exception
     */
    public NyxendorchgdetailDto findByPrimaryKey(String inusrelistcode,String businessno,String endorseno,String kindcode,String itemcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxendorchgdetailAction blNyxendorchgdetailAction = new BLNyxendorchgdetailAction();
        //����DTO
        NyxendorchgdetailDto nyxendorchgdetailDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            nyxendorchgdetailDto = blNyxendorchgdetailAction.findByPrimaryKey(dbManager,inusrelistcode, businessno, endorseno, kindcode, itemcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nyxendorchgdetailDto;
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
        BLNyxendorchgdetailAction blNyxendorchgdetailAction = new BLNyxendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blNyxendorchgdetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����nyxendorchgdetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxendorchgdetailAction blNyxendorchgdetailAction = new BLNyxendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blNyxendorchgdetailAction.findByConditions(dbManager,conditions);
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
        BLNyxendorchgdetailAction blNyxendorchgdetailAction = new BLNyxendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blNyxendorchgdetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
