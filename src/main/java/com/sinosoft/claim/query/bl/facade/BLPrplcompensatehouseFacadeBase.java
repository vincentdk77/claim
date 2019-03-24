package com.sinosoft.claim.query.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.claim.bl.action.domain.BLPrplcompensatehouseAction;
import java.math.*;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLCOMPENSATEHOUSE��ҵ���߼�����Facade����<br>
 */
public class BLPrplcompensatehouseFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensatehouseFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplcompensatehouseFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public void insert(PrplcompensatehouseDto prplcompensatehouseDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplcompensatehouseAction.insert(dbManager,prplcompensatehouseDto);
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
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @throws Exception
     */
    public void delete(String idcard,String registno,String nodetype,String businessno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplcompensatehouseAction.delete(dbManager,idcard, registno, nodetype, businessno);
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
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplcompensatehouseAction.deleteByConditions(dbManager,conditions);
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
     * @param prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public void update(PrplcompensatehouseDto prplcompensatehouseDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplcompensatehouseAction.update(dbManager,prplcompensatehouseDto);
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
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @return prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public PrplcompensatehouseDto findByPrimaryKey(String idcard,String registno,String nodetype,String businessno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        //����DTO
        PrplcompensatehouseDto prplcompensatehouseDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplcompensatehouseDto = blPrplcompensatehouseAction.findByPrimaryKey(dbManager,idcard, registno, nodetype, businessno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplcompensatehouseDto;
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
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplcompensatehouseAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplcompensatehouseDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            collection = blPrplcompensatehouseAction.findByConditions(dbManager,conditions);
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
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcompensatehouseAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    public BigDecimal getSumCompensate(String idcard,String policyno) 
    throws Exception{
    BigDecimal sum = new BigDecimal(0.00);

    DBManager dbManager = new DBManager();
    BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        sum = blPrplcompensatehouseAction.getSumCompensate(dbManager,idcard,policyno);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return sum;
}
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getInprocessCount(String policyno,String idcard) 
        throws Exception{
        int rowCount=0;

        DBManager dbManager = new DBManager();
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcompensatehouseAction.getInprocessCount(dbManager,policyno,idcard);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
