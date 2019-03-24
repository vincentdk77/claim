package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03InsuranceListDto;
import com.gyic.claim.bl.action.domain.BLZh03InsuranceListAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����ZH03InsuranceList��ҵ���߼�����Facade����<br>
 */
public class BLZh03InsuranceListFacadeBase{
    private static Logger logger = Logger.getLogger(BLZh03InsuranceListFacadeBase.class);

    /**
     * ���캯��
     */
    public BLZh03InsuranceListFacadeBase(){
    }

    /**
     * ����һ������
     * @param zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public void insert(Zh03InsuranceListDto zh03InsuranceListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blZh03InsuranceListAction.insert(dbManager,zh03InsuranceListDto);
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
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(String inusreListCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blZh03InsuranceListAction.delete(dbManager,inusreListCode);
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
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blZh03InsuranceListAction.deleteByConditions(dbManager,conditions);
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
     * @param zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public void update(Zh03InsuranceListDto zh03InsuranceListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blZh03InsuranceListAction.update(dbManager,zh03InsuranceListDto);
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
     * @param inusreListCode InusreListCode
     * @return zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public Zh03InsuranceListDto findByPrimaryKey(String inusreListCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        //����DTO
        Zh03InsuranceListDto zh03InsuranceListDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            zh03InsuranceListDto = blZh03InsuranceListAction.findByPrimaryKey(dbManager,inusreListCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return zh03InsuranceListDto;
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
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blZh03InsuranceListAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����zh03InsuranceListDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blZh03InsuranceListAction.findByConditions(dbManager,conditions);
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
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blZh03InsuranceListAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
