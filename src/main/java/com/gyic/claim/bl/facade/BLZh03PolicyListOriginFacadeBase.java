package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListOriginDto;
import com.gyic.claim.bl.action.domain.BLZh03PolicyListOriginAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����ZH03PolicyListOrigin��ҵ���߼�����Facade����<br>
 */
public class BLZh03PolicyListOriginFacadeBase{
    private static Logger logger = Logger.getLogger(BLZh03PolicyListOriginFacadeBase.class);

    /**
     * ���캯��
     */
    public BLZh03PolicyListOriginFacadeBase(){
    }

    /**
     * ����һ������
     * @param zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @throws Exception
     */
    public void insert(Zh03PolicyListOriginDto zh03PolicyListOriginDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03PolicyListOriginAction blZh03PolicyListOriginAction = new BLZh03PolicyListOriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blZh03PolicyListOriginAction.insert(dbManager,zh03PolicyListOriginDto);
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
     * @throws Exception
     */
    public void delete(String inusrelistcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03PolicyListOriginAction blZh03PolicyListOriginAction = new BLZh03PolicyListOriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blZh03PolicyListOriginAction.delete(dbManager,inusrelistcode);
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
        BLZh03PolicyListOriginAction blZh03PolicyListOriginAction = new BLZh03PolicyListOriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blZh03PolicyListOriginAction.deleteByConditions(dbManager,conditions);
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
     * @param zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @throws Exception
     */
    public void update(Zh03PolicyListOriginDto zh03PolicyListOriginDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03PolicyListOriginAction blZh03PolicyListOriginAction = new BLZh03PolicyListOriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blZh03PolicyListOriginAction.update(dbManager,zh03PolicyListOriginDto);
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
     * @return zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @throws Exception
     */
    public Zh03PolicyListOriginDto findByPrimaryKey(String inusrelistcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03PolicyListOriginAction blZh03PolicyListOriginAction = new BLZh03PolicyListOriginAction();
        //����DTO
        Zh03PolicyListOriginDto zh03PolicyListOriginDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            zh03PolicyListOriginDto = blZh03PolicyListOriginAction.findByPrimaryKey(dbManager,inusrelistcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return zh03PolicyListOriginDto;
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
        BLZh03PolicyListOriginAction blZh03PolicyListOriginAction = new BLZh03PolicyListOriginAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blZh03PolicyListOriginAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����zh03PolicyListOriginDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLZh03PolicyListOriginAction blZh03PolicyListOriginAction = new BLZh03PolicyListOriginAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blZh03PolicyListOriginAction.findByConditions(dbManager,conditions);
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
        BLZh03PolicyListOriginAction blZh03PolicyListOriginAction = new BLZh03PolicyListOriginAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blZh03PolicyListOriginAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
