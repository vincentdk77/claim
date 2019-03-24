package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayBill;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����prpLpayBill��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayBillActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayBillActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpayBillActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpayBillDto prpLpayBillDto)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //�����¼
        dbPrpLpayBill.insert(prpLpayBillDto);
    }
    
    /**
     * �����������
     * @param dbManager DB������
     * @param prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection collection)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //�����¼
        dbPrpLpayBill.insertAll(collection);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String paymentNo,String registNo,String compensateNo,int serialNo)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //ɾ����¼
        dbPrpLpayBill.delete(paymentNo, registNo, compensateNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //������ɾ����¼
        dbPrpLpayBill.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpayBillDto prpLpayBillDto)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //���¼�¼
        dbPrpLpayBill.update(prpLpayBillDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @return prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public PrpLpayBillDto findByPrimaryKey(DBManager dbManager,String paymentNo,String registNo,String compensateNo,int serialNo)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //����DTO
        PrpLpayBillDto prpLpayBillDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpayBillDto = dbPrpLpayBill.findByPrimaryKey(paymentNo, registNo, compensateNo, serialNo);
        return prpLpayBillDto;
    }
    
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayBill.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpayBill.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpayBillDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayBill.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayBill.getCount(conditions);
        return count;
    }
    /*********************�Ż��޸ģ�start********************/
    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditionsByPrepered(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //������ɾ����¼
        dbPrpLpayBill.deleteByConditionsByPrepered(conditions);
    }
    /***********************�Ż��޸ģ�end******************/
}
