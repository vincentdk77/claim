package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLreplevyAction;
import com.sinosoft.claim.dto.domain.PrpLreplevyDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLreplevy-Ȩ��ת�ü�׷����Ϣ��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.562<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLreplevyFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLreplevyFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLreplevyFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLreplevyDto prpLreplevyDto
     * @throws Exception
     */
    public void insert(PrpLreplevyDto prpLreplevyDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLreplevyAction blPrpLreplevyAction = new BLPrpLreplevyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLreplevyAction.insert(dbManager,prpLreplevyDto);
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
     * @param claimNo �ⰸ��
     * @param times ����
     * @throws Exception
     */
    public void delete(String claimNo,int times) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLreplevyAction blPrpLreplevyAction = new BLPrpLreplevyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLreplevyAction.delete(dbManager,claimNo, times);
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
        BLPrpLreplevyAction blPrpLreplevyAction = new BLPrpLreplevyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLreplevyAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLreplevyDto prpLreplevyDto
     * @throws Exception
     */
    public void update(PrpLreplevyDto prpLreplevyDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLreplevyAction blPrpLreplevyAction = new BLPrpLreplevyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLreplevyAction.update(dbManager,prpLreplevyDto);
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
     * @param claimNo �ⰸ��
     * @param times ����
     * @return prpLreplevyDto prpLreplevyDto
     * @throws Exception
     */
    public PrpLreplevyDto findByPrimaryKey(String claimNo,int times) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLreplevyAction blPrpLreplevyAction = new BLPrpLreplevyAction();
        //����DTO
        PrpLreplevyDto prpLreplevyDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLreplevyDto = blPrpLreplevyAction.findByPrimaryKey(dbManager,claimNo, times);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLreplevyDto;
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
        BLPrpLreplevyAction blPrpLreplevyAction = new BLPrpLreplevyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLreplevyAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLreplevyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLreplevyAction blPrpLreplevyAction = new BLPrpLreplevyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLreplevyAction.findByConditions(dbManager,conditions);
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
        BLPrpLreplevyAction blPrpLreplevyAction = new BLPrpLreplevyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLreplevyAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
