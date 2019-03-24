package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorendorchgdetailDto;
import com.gyic.claim.bl.action.domain.BLTemblorendorchgdetailAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORENDORCHGDETAIL��ҵ���߼�����Facade����<br>
 */
public class BLTemblorendorchgdetailFacadeBase{
    private static Logger logger = Logger.getLogger(BLTemblorendorchgdetailFacadeBase.class);

    /**
     * ���캯��
     */
    public BLTemblorendorchgdetailFacadeBase(){
    }

    /**
     * ����һ������
     * @param temblorendorchgdetailDto temblorendorchgdetailDto
     * @throws Exception
     */
    public void insert(TemblorendorchgdetailDto temblorendorchgdetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorendorchgdetailAction blTemblorendorchgdetailAction = new BLTemblorendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blTemblorendorchgdetailAction.insert(dbManager,temblorendorchgdetailDto);
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
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(String inusrelistcode,String endorseno,String kindcode,String itemcode,String address,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorendorchgdetailAction blTemblorendorchgdetailAction = new BLTemblorendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blTemblorendorchgdetailAction.delete(dbManager,inusrelistcode, endorseno, kindcode, itemcode, address, idcard);
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
        BLTemblorendorchgdetailAction blTemblorendorchgdetailAction = new BLTemblorendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blTemblorendorchgdetailAction.deleteByConditions(dbManager,conditions);
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
     * @param temblorendorchgdetailDto temblorendorchgdetailDto
     * @throws Exception
     */
    public void update(TemblorendorchgdetailDto temblorendorchgdetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorendorchgdetailAction blTemblorendorchgdetailAction = new BLTemblorendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blTemblorendorchgdetailAction.update(dbManager,temblorendorchgdetailDto);
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
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return temblorendorchgdetailDto temblorendorchgdetailDto
     * @throws Exception
     */
    public TemblorendorchgdetailDto findByPrimaryKey(String inusrelistcode,String endorseno,String kindcode,String itemcode,String address,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorendorchgdetailAction blTemblorendorchgdetailAction = new BLTemblorendorchgdetailAction();
        //����DTO
        TemblorendorchgdetailDto temblorendorchgdetailDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            temblorendorchgdetailDto = blTemblorendorchgdetailAction.findByPrimaryKey(dbManager,inusrelistcode, endorseno, kindcode, itemcode, address, idcard);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return temblorendorchgdetailDto;
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
        BLTemblorendorchgdetailAction blTemblorendorchgdetailAction = new BLTemblorendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blTemblorendorchgdetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����temblorendorchgdetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorendorchgdetailAction blTemblorendorchgdetailAction = new BLTemblorendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blTemblorendorchgdetailAction.findByConditions(dbManager,conditions);
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
        BLTemblorendorchgdetailAction blTemblorendorchgdetailAction = new BLTemblorendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorendorchgdetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
