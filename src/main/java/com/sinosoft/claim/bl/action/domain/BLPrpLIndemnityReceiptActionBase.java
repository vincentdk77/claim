package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLIndemnityReceiptDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLIndemnityReceipt;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������վݵ�ҵ���߼�������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLIndemnityReceiptActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLIndemnityReceiptActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLIndemnityReceiptActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLIndemnityReceiptDto prpLIndemnityReceiptDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLIndemnityReceiptDto prpLIndemnityReceiptDto)
            throws Exception{
        DBPrpLIndemnityReceipt dbPrpLIndemnityReceipt = new DBPrpLIndemnityReceipt(dbManager);
        //�����¼
        dbPrpLIndemnityReceipt.insert(prpLIndemnityReceiptDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param businessNo ҵ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo)
            throws Exception{
        DBPrpLIndemnityReceipt dbPrpLIndemnityReceipt = new DBPrpLIndemnityReceipt(dbManager);
        //ɾ����¼
        dbPrpLIndemnityReceipt.delete(businessNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLIndemnityReceipt dbPrpLIndemnityReceipt = new DBPrpLIndemnityReceipt(dbManager);
        //������ɾ����¼
        dbPrpLIndemnityReceipt.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLIndemnityReceiptDto prpLIndemnityReceiptDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLIndemnityReceiptDto prpLIndemnityReceiptDto)
            throws Exception{
        DBPrpLIndemnityReceipt dbPrpLIndemnityReceipt = new DBPrpLIndemnityReceipt(dbManager);
        //���¼�¼
        dbPrpLIndemnityReceipt.update(prpLIndemnityReceiptDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param businessNo ҵ���
     * @return prpLIndemnityReceiptDto prpLIndemnityReceiptDto
     * @throws Exception
     */
    public PrpLIndemnityReceiptDto findByPrimaryKey(DBManager dbManager,String businessNo)
            throws Exception{
        DBPrpLIndemnityReceipt dbPrpLIndemnityReceipt = new DBPrpLIndemnityReceipt(dbManager);
        //����DTO
        PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = null;
        //��ѯ����,��ֵ��DTO
        prpLIndemnityReceiptDto = dbPrpLIndemnityReceipt.findByPrimaryKey(businessNo);
        return prpLIndemnityReceiptDto;
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
        DBPrpLIndemnityReceipt dbPrpLIndemnityReceipt = new DBPrpLIndemnityReceipt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLIndemnityReceipt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLIndemnityReceipt.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLIndemnityReceiptDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLIndemnityReceipt dbPrpLIndemnityReceipt = new DBPrpLIndemnityReceipt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLIndemnityReceipt.findByConditions(conditions);
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
        DBPrpLIndemnityReceipt dbPrpLIndemnityReceipt = new DBPrpLIndemnityReceipt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLIndemnityReceipt.getCount(conditions);
        return count;
    }
}
