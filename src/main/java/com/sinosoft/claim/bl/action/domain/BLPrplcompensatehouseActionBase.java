package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;
import java.math.*;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLCOMPENSATEHOUSE��ҵ���߼�������<br>
 */
public class BLPrplcompensatehouseActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensatehouseActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplcompensatehouseActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplcompensatehouseDto prplcompensatehouseDto)
            throws Exception{
        DBPrplcompensatehouse dbPrplcompensatehouse = new DBPrplcompensatehouse(dbManager);
        //�����¼
        dbPrplcompensatehouse.insert(prplcompensatehouseDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String idcard,String registno,String nodetype,String businessno)
            throws Exception{
        DBPrplcompensatehouse dbPrplcompensatehouse = new DBPrplcompensatehouse(dbManager);
        //ɾ����¼
        dbPrplcompensatehouse.delete(idcard, registno, nodetype, businessno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcompensatehouse dbPrplcompensatehouse = new DBPrplcompensatehouse(dbManager);
        //������ɾ����¼
        dbPrplcompensatehouse.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplcompensatehouseDto prplcompensatehouseDto)
            throws Exception{
        DBPrplcompensatehouse dbPrplcompensatehouse = new DBPrplcompensatehouse(dbManager);
        //���¼�¼
        dbPrplcompensatehouse.update(prplcompensatehouseDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @return prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public PrplcompensatehouseDto findByPrimaryKey(DBManager dbManager,String idcard,String registno,String nodetype,String businessno)
            throws Exception{
        DBPrplcompensatehouse dbPrplcompensatehouse = new DBPrplcompensatehouse(dbManager);
        //����DTO
        PrplcompensatehouseDto prplcompensatehouseDto = null;
        //��ѯ����,��ֵ��DTO
        prplcompensatehouseDto = dbPrplcompensatehouse.findByPrimaryKey(idcard, registno, nodetype, businessno);
        return prplcompensatehouseDto;
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
        DBPrplcompensatehouse dbPrplcompensatehouse = new DBPrplcompensatehouse(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcompensatehouse.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplcompensatehouse.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplcompensatehouseDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcompensatehouse dbPrplcompensatehouse = new DBPrplcompensatehouse(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplcompensatehouse.findByConditions(conditions);
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
        DBPrplcompensatehouse dbPrplcompensatehouse = new DBPrplcompensatehouse(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcompensatehouse.getCount(conditions);
        return count;
    }
    
    public BigDecimal getSumCompensate(DBManager dbManager,String idcard,String policyno) 
    throws Exception{
    DBPrplcompensatehouse dbPrplcompensatehouse = new DBPrplcompensatehouse(dbManager);
    BigDecimal sum = dbPrplcompensatehouse.getSumCompensate(idcard,policyno);
    return sum;
}
    
    
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getInprocessCount(DBManager dbManager,String policyno,String idcard) 
        throws Exception{
        DBPrplcompensatehouse dbPrplcompensatehouse = new DBPrplcompensatehouse(dbManager);

        int count = dbPrplcompensatehouse.getInprocessCount(policyno,idcard);
        return count;
    }
}
