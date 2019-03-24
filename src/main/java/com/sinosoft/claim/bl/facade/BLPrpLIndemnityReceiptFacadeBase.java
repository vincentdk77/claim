package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLIndemnityReceiptAction;
import com.sinosoft.claim.dto.domain.PrpLIndemnityReceiptDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������վݵ�ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLIndemnityReceiptFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLIndemnityReceiptFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLIndemnityReceiptFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLIndemnityReceiptDto prpLIndemnityReceiptDto
     * @throws Exception
     */
    public void insert(PrpLIndemnityReceiptDto prpLIndemnityReceiptDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLIndemnityReceiptAction blPrpLIndemnityReceiptAction = new BLPrpLIndemnityReceiptAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));            
            dbManager.beginTransaction();
            //�����¼
            blPrpLIndemnityReceiptAction.insert(dbManager,prpLIndemnityReceiptDto);
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
     * @param businessNo ҵ���
     * @throws Exception
     */
    public void delete(String businessNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLIndemnityReceiptAction blPrpLIndemnityReceiptAction = new BLPrpLIndemnityReceiptAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));            
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLIndemnityReceiptAction.delete(dbManager,businessNo);
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
        BLPrpLIndemnityReceiptAction blPrpLIndemnityReceiptAction = new BLPrpLIndemnityReceiptAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));            
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLIndemnityReceiptAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLIndemnityReceiptDto prpLIndemnityReceiptDto
     * @throws Exception
     */
    public void update(PrpLIndemnityReceiptDto prpLIndemnityReceiptDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLIndemnityReceiptAction blPrpLIndemnityReceiptAction = new BLPrpLIndemnityReceiptAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));            
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLIndemnityReceiptAction.update(dbManager,prpLIndemnityReceiptDto);
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
     * @param businessNo ҵ���
     * @return prpLIndemnityReceiptDto prpLIndemnityReceiptDto
     * @throws Exception
     */
    public PrpLIndemnityReceiptDto findByPrimaryKey(String businessNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLIndemnityReceiptAction blPrpLIndemnityReceiptAction = new BLPrpLIndemnityReceiptAction();
        //����DTO
        PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));            
            //��ѯ����,��ֵ��DTO
            prpLIndemnityReceiptDto = blPrpLIndemnityReceiptAction.findByPrimaryKey(dbManager,businessNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLIndemnityReceiptDto;
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
        BLPrpLIndemnityReceiptAction blPrpLIndemnityReceiptAction = new BLPrpLIndemnityReceiptAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));            
            pageRecord = blPrpLIndemnityReceiptAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLIndemnityReceiptDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLIndemnityReceiptAction blPrpLIndemnityReceiptAction = new BLPrpLIndemnityReceiptAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));            
            collection = blPrpLIndemnityReceiptAction.findByConditions(dbManager,conditions);
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
        BLPrpLIndemnityReceiptAction blPrpLIndemnityReceiptAction = new BLPrpLIndemnityReceiptAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));            
            rowCount = blPrpLIndemnityReceiptAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
