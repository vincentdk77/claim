package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLrepairFeeAction;
import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLrepairFee-��������嵥(�޸�)��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.500<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLrepairFeeFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLrepairFeeFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLrepairFeeFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLrepairFeeDto prpLrepairFeeDto
     * @throws Exception
     */
    public void insert(PrpLrepairFeeDto prpLrepairFeeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrepairFeeAction blPrpLrepairFeeAction = new BLPrpLrepairFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLrepairFeeAction.insert(dbManager,prpLrepairFeeDto);
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
     * @param serialNo ���
     * @param registNo ��������
     * @param lossItemCode ��Ĵ���
     * @throws Exception
     */
    public void delete(int serialNo,String registNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrepairFeeAction blPrpLrepairFeeAction = new BLPrpLrepairFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLrepairFeeAction.delete(dbManager,serialNo, registNo, lossItemCode);
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
        BLPrpLrepairFeeAction blPrpLrepairFeeAction = new BLPrpLrepairFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLrepairFeeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLrepairFeeDto prpLrepairFeeDto
     * @throws Exception
     */
    public void update(PrpLrepairFeeDto prpLrepairFeeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrepairFeeAction blPrpLrepairFeeAction = new BLPrpLrepairFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLrepairFeeAction.update(dbManager,prpLrepairFeeDto);
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
     * @param serialNo ���
     * @param registNo ��������
     * @param lossItemCode ��Ĵ���
     * @return prpLrepairFeeDto prpLrepairFeeDto
     * @throws Exception
     */
    public PrpLrepairFeeDto findByPrimaryKey(int serialNo,String registNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrepairFeeAction blPrpLrepairFeeAction = new BLPrpLrepairFeeAction();
        //����DTO
        PrpLrepairFeeDto prpLrepairFeeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLrepairFeeDto = blPrpLrepairFeeAction.findByPrimaryKey(dbManager,serialNo, registNo, lossItemCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLrepairFeeDto;
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
        BLPrpLrepairFeeAction blPrpLrepairFeeAction = new BLPrpLrepairFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLrepairFeeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLrepairFeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLrepairFeeAction blPrpLrepairFeeAction = new BLPrpLrepairFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLrepairFeeAction.findByConditions(dbManager,conditions);
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
        BLPrpLrepairFeeAction blPrpLrepairFeeAction = new BLPrpLrepairFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLrepairFeeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
