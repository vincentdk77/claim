package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxcpendorchgdetailDto;
import com.gyic.claim.bl.action.domain.BLNyxcpendorchgdetailAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXCPENDORCHGDETAIL��ҵ���߼�����Facade����<br>
 */
public class BLNyxcpendorchgdetailFacadeBase{
    private static Logger logger = Logger.getLogger(BLNyxcpendorchgdetailFacadeBase.class);

    /**
     * ���캯��
     */
    public BLNyxcpendorchgdetailFacadeBase(){
    }

    /**
     * ����һ������
     * @param nyxcpendorchgdetailDto nyxcpendorchgdetailDto
     * @throws Exception
     */
    public void insert(NyxcpendorchgdetailDto nyxcpendorchgdetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxcpendorchgdetailAction blNyxcpendorchgdetailAction = new BLNyxcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blNyxcpendorchgdetailAction.insert(dbManager,nyxcpendorchgdetailDto);
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
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String businessno,String kindcode,String itemcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxcpendorchgdetailAction blNyxcpendorchgdetailAction = new BLNyxcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blNyxcpendorchgdetailAction.delete(dbManager,inusrelistcode, businessno, kindcode, itemcode);
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
        BLNyxcpendorchgdetailAction blNyxcpendorchgdetailAction = new BLNyxcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blNyxcpendorchgdetailAction.deleteByConditions(dbManager,conditions);
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
     * @param nyxcpendorchgdetailDto nyxcpendorchgdetailDto
     * @throws Exception
     */
    public void update(NyxcpendorchgdetailDto nyxcpendorchgdetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxcpendorchgdetailAction blNyxcpendorchgdetailAction = new BLNyxcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blNyxcpendorchgdetailAction.update(dbManager,nyxcpendorchgdetailDto);
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
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return nyxcpendorchgdetailDto nyxcpendorchgdetailDto
     * @throws Exception
     */
    public NyxcpendorchgdetailDto findByPrimaryKey(String inusrelistcode,String businessno,String kindcode,String itemcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxcpendorchgdetailAction blNyxcpendorchgdetailAction = new BLNyxcpendorchgdetailAction();
        //����DTO
        NyxcpendorchgdetailDto nyxcpendorchgdetailDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            nyxcpendorchgdetailDto = blNyxcpendorchgdetailAction.findByPrimaryKey(dbManager,inusrelistcode, businessno, kindcode, itemcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nyxcpendorchgdetailDto;
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
        BLNyxcpendorchgdetailAction blNyxcpendorchgdetailAction = new BLNyxcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blNyxcpendorchgdetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����nyxcpendorchgdetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxcpendorchgdetailAction blNyxcpendorchgdetailAction = new BLNyxcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blNyxcpendorchgdetailAction.findByConditions(dbManager,conditions);
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
        BLNyxcpendorchgdetailAction blNyxcpendorchgdetailAction = new BLNyxcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blNyxcpendorchgdetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
