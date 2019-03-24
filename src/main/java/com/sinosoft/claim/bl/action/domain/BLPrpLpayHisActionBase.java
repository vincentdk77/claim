package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayHis;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����prpLpayHis��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayHisActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayHisActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpayHisActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpayHisDto prpLpayHisDto)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //�����¼
        dbPrpLpayHis.insert(prpLpayHisDto);
    }
    
    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection collection)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //�����¼
        dbPrpLpayHis.insertAll(collection);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @throws Exception
     */
    public void delete(DBManager dbManager,String serialNo,String serialNo2)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //ɾ����¼
        dbPrpLpayHis.delete(serialNo, serialNo2);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //������ɾ����¼
        dbPrpLpayHis.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpayHisDto prpLpayHisDto)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //���¼�¼
        dbPrpLpayHis.update(prpLpayHisDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @return prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public PrpLpayHisDto findByPrimaryKey(DBManager dbManager,String serialNo,String serialNo2)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        //����DTO
        PrpLpayHisDto prpLpayHisDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpayHisDto = dbPrpLpayHis.findByPrimaryKey(serialNo, serialNo2);
        return prpLpayHisDto;
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
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayHis.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpayHis.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpayHisDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayHis.findByConditions(conditions);
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
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayHis.getCount(conditions);
        return count;
    }
    /*************************************/
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCountByPrepered(DBManager dbManager,String conditions,String Serialno,String Compensateno,double Payamount) 
        throws Exception{
        DBPrpLpayHis dbPrpLpayHis = new DBPrpLpayHis(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayHis.getCountByPrepered(conditions,Serialno,Compensateno, Payamount);
        return count;
    }
    /*************************************/
}
