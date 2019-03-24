package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcomRepairBillDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcomRepairBill;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcomRepairBill-����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcomRepairBillActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcomRepairBillActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcomRepairBillActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcomRepairBillDto prpLcomRepairBillDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcomRepairBillDto prpLcomRepairBillDto) throws Exception{
        DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);
        //�����¼
        dbPrpLcomRepairBill.insert(prpLcomRepairBillDto);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
    	DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);
        //������ɾ����¼
    	dbPrpLcomRepairBill.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcomRepairBillDto prpLcomRepairBillDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcomRepairBillDto prpLcomRepairBillDto) throws Exception{
    	DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);
        //���¼�¼
    	dbPrpLcomRepairBill.update(prpLcomRepairBillDto);
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    	DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcomRepairBill.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcomRepairBill.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcomRepairBillDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
    	DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcomRepairBill.findByConditions(conditions);
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
    	DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcomRepairBill.getCount(conditions);
        return count;
    }
}
