package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimBillManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLclaimBillManager��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLclaimBillManagerActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLclaimBillManagerActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimBillManagerActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimBillManagerDto prpLclaimBillManagerDto)
            throws Exception{
        DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        //�����¼
        dbPrpLclaimBillManager.insert(prpLclaimBillManagerDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo registNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo)
            throws Exception{
        DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        //ɾ����¼
        dbPrpLclaimBillManager.delete(registNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        //������ɾ����¼
        dbPrpLclaimBillManager.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimBillManagerDto prpLclaimBillManagerDto)
            throws Exception{
        DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        //���¼�¼
        dbPrpLclaimBillManager.update(prpLclaimBillManagerDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo registNo
     * @return prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @throws Exception
     */
    public PrpLclaimBillManagerDto findByPrimaryKey(DBManager dbManager,String registNo,String compensateNo,int serialNo)
            throws Exception{
        DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        //����DTO
        PrpLclaimBillManagerDto prpLclaimBillManagerDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimBillManagerDto = dbPrpLclaimBillManager.findByPrimaryKey(registNo,compensateNo,serialNo);
        return prpLclaimBillManagerDto;
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
        DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimBillManager.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimBillManager.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimBillManagerDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimBillManager.findByConditions(conditions);
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
        DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimBillManager.getCount(conditions);
        return count;
    }
}
