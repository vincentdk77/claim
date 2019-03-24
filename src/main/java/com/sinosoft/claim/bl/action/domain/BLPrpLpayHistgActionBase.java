package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayHistg;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����prpLpayHis��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayHistgActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayHistgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpayHistgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpayHistgDto prpLpayHistgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpayHisDto prpLpayHistgDto)
            throws Exception{
        DBPrpLpayHistg dbPrpLpayHistg = new DBPrpLpayHistg(dbManager);
        //�����¼
        dbPrpLpayHistg.insert(prpLpayHistgDto);
    }
    
    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpayHistgDto prpLpayHistgDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection collection)
            throws Exception{
        DBPrpLpayHistg dbPrpLpayHistg = new DBPrpLpayHistg(dbManager);
        //�����¼
        dbPrpLpayHistg.insertAll(collection);
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
        DBPrpLpayHistg dbPrpLpayHistg = new DBPrpLpayHistg(dbManager);
        //ɾ����¼
        dbPrpLpayHistg.delete(serialNo, serialNo2);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayHistg dbPrpLpayHistg = new DBPrpLpayHistg(dbManager);
        //������ɾ����¼
        dbPrpLpayHistg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpayHistgDto prpLpayHistgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpayHisDto prpLpayHistgDto)
            throws Exception{
        DBPrpLpayHistg dbPrpLpayHistg = new DBPrpLpayHistg(dbManager);
        //���¼�¼
        dbPrpLpayHistg.update(prpLpayHistgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @return prpLpayHistgDto prpLpayHistgDto
     * @throws Exception
     */
    public PrpLpayHisDto findByPrimaryKey(DBManager dbManager,String serialNo,String serialNo2)
            throws Exception{
        DBPrpLpayHistg dbPrpLpayHistg = new DBPrpLpayHistg(dbManager);
        //����DTO
        PrpLpayHisDto prpLpayHistgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpayHistgDto = dbPrpLpayHistg.findByPrimaryKey(serialNo, serialNo2);
        return prpLpayHistgDto;
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
        DBPrpLpayHistg dbPrpLpayHistg = new DBPrpLpayHistg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayHistg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpayHistg.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLpayHistg dbPrpLpayHistg = new DBPrpLpayHistg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayHistg.findByConditions(conditions);
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
        DBPrpLpayHistg dbPrpLpayHistg = new DBPrpLpayHistg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayHistg.getCount(conditions);
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
        DBPrpLpayHistg dbPrpLpayHistg = new DBPrpLpayHistg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayHistg.getCountByPrepered(conditions,Serialno,Compensateno, Payamount);
        return count;
    }
    /*************************************/
}
