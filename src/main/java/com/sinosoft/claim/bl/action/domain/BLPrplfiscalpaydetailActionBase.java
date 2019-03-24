package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplfiscalpaydetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplfiscalpaydetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLFISCALDETAILPAY��ҵ���߼�������<br>
 */
public class BLPrplfiscalpaydetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaydetailActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplfiscalpaydetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplfiscaldetailpayDto prplfiscaldetailpayDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplfiscalpaydetailDto prplfiscaldetailpayDto)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //�����¼
        dbPrplfiscaldetailpay.insert(prplfiscaldetailpayDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param fiscalno �������ļ��嵥��
     * @param serialno ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fiscalno,String serialno)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //ɾ����¼
        dbPrplfiscaldetailpay.delete(fiscalno, serialno);
    }
    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param fiscalno �������ļ��嵥��
     * @param serialno ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fiscalno)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //ɾ����¼
        dbPrplfiscaldetailpay.delete(fiscalno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //������ɾ����¼
        dbPrplfiscaldetailpay.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplfiscaldetailpayDto prplfiscaldetailpayDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplfiscalpaydetailDto prplfiscaldetailpayDto)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //���¼�¼
        dbPrplfiscaldetailpay.update(prplfiscaldetailpayDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param fiscalno �������ļ��嵥��
     * @param serialno ���
     * @return prplfiscaldetailpayDto prplfiscaldetailpayDto
     * @throws Exception
     */
    public PrplfiscalpaydetailDto findByPrimaryKey(DBManager dbManager,String fiscalno,String serialno)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //����DTO
        PrplfiscalpaydetailDto prplfiscaldetailpayDto = null;
        //��ѯ����,��ֵ��DTO
        prplfiscaldetailpayDto = dbPrplfiscaldetailpay.findByPrimaryKey(fiscalno, serialno);
        return prplfiscaldetailpayDto;
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
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplfiscaldetailpay.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplfiscaldetailpay.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplfiscaldetailpayDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplfiscaldetailpay.findByConditions(conditions);
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
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplfiscaldetailpay.getCount(conditions);
        return count;
    }
}
