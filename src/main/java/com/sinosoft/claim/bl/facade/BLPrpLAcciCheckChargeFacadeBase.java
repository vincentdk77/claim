package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLAcciCheckChargeAction;
import com.sinosoft.claim.dto.domain.PrpLAcciCheckChargeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǵ�����ñ�-PrpLAcciCheckCharge��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLAcciCheckChargeFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLAcciCheckChargeFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLAcciCheckChargeFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void insert(PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLAcciCheckChargeAction.insert(dbManager,prpLAcciCheckChargeDto);
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
     * @param checkNo �����-CheckNo
     * @param serialNo ���-SerialNo
     * @throws Exception
     */
    public void delete(String checkNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLAcciCheckChargeAction.delete(dbManager,checkNo, serialNo);
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
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLAcciCheckChargeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void update(PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLAcciCheckChargeAction.update(dbManager,prpLAcciCheckChargeDto);
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
     * @param checkNo �����-CheckNo
     * @param serialNo ���-SerialNo
     * @return prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public PrpLAcciCheckChargeDto findByPrimaryKey(String checkNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        //����DTO
        PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = null;
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLAcciCheckChargeDto = blPrpLAcciCheckChargeAction.findByPrimaryKey(dbManager,checkNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLAcciCheckChargeDto;
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
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLAcciCheckChargeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLAcciCheckChargeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLAcciCheckChargeAction.findByConditions(dbManager,conditions);
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
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLAcciCheckChargeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
