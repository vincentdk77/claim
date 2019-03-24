package com.sinosoft.AgriXZrequest.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.AgriXZrequest.dto.domain.CorrectRequest_TempDto;
import com.sinosoft.AgriXZrequest.bl.action.domain.BLCorrectRequest_TempAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CorrectRequest_Temp��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCorrectRequest_TempFacadeBase{
    private static Logger logger = Logger.getLogger(BLCorrectRequest_TempFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCorrectRequest_TempFacadeBase(){
    }

    /**
     * ����һ������
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void insert(CorrectRequest_TempDto correctRequest_TempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //�����¼
            blCorrectRequest_TempAction.insert(dbManager,correctRequest_TempDto);
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
     * @param batchNo batchNo
     * @throws Exception
     */
    public void delete(String batchNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blCorrectRequest_TempAction.delete(dbManager,batchNo);
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
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blCorrectRequest_TempAction.deleteByConditions(dbManager,conditions);
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
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void update(CorrectRequest_TempDto correctRequest_TempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blCorrectRequest_TempAction.update(dbManager,correctRequest_TempDto);
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
     * @param batchNo batchNo
     * @return correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public CorrectRequest_TempDto findByPrimaryKey(String batchNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        //����DTO
        CorrectRequest_TempDto correctRequest_TempDto = null;
        try{
            dbManager.open("ddccDataSource");
            //��ѯ����,��ֵ��DTO
            correctRequest_TempDto = blCorrectRequest_TempAction.findByPrimaryKey(dbManager,batchNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return correctRequest_TempDto;
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
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            pageRecord = blCorrectRequest_TempAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����correctRequest_TempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blCorrectRequest_TempAction.findByConditions(dbManager,conditions);
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
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            rowCount = blCorrectRequest_TempAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
