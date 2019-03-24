package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplfiscalpaymainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplfiscalpaymain;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLFISCALMAINPAY��ҵ���߼�������<br>
 */
public class BLPrplfiscalpaymainActionBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaymainActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplfiscalpaymainActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplfiscalmainpayDto prplfiscalmainpayDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplfiscalpaymainDto prplfiscalmainpayDto)
            throws Exception{
        DBPrplfiscalpaymain dbPrplfiscalmainpay = new DBPrplfiscalpaymain(dbManager);
        //�����¼
        dbPrplfiscalmainpay.insert(prplfiscalmainpayDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param fiscalno ֧���嵥��
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fiscalno)
            throws Exception{
        DBPrplfiscalpaymain dbPrplfiscalmainpay = new DBPrplfiscalpaymain(dbManager);
        //ɾ����¼
        dbPrplfiscalmainpay.delete(fiscalno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplfiscalpaymain dbPrplfiscalmainpay = new DBPrplfiscalpaymain(dbManager);
        //������ɾ����¼
        dbPrplfiscalmainpay.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplfiscalmainpayDto prplfiscalmainpayDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplfiscalpaymainDto prplfiscalmainpayDto)
            throws Exception{
        DBPrplfiscalpaymain dbPrplfiscalmainpay = new DBPrplfiscalpaymain(dbManager);
        //���¼�¼
        dbPrplfiscalmainpay.update(prplfiscalmainpayDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param fiscalno ֧���嵥��
     * @return prplfiscalmainpayDto prplfiscalmainpayDto
     * @throws Exception
     */
    public PrplfiscalpaymainDto findByPrimaryKey(DBManager dbManager,String fiscalno)
            throws Exception{
        DBPrplfiscalpaymain dbPrplfiscalmainpay = new DBPrplfiscalpaymain(dbManager);
        //����DTO
        PrplfiscalpaymainDto prplfiscalmainpayDto = null;
        //��ѯ����,��ֵ��DTO
        prplfiscalmainpayDto = dbPrplfiscalmainpay.findByPrimaryKey(fiscalno);
        return prplfiscalmainpayDto;
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
        DBPrplfiscalpaymain dbPrplfiscalmainpay = new DBPrplfiscalpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplfiscalmainpay.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplfiscalmainpay.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplfiscalmainpayDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplfiscalpaymain dbPrplfiscalmainpay = new DBPrplfiscalpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplfiscalmainpay.findByConditions(conditions);
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
        DBPrplfiscalpaymain dbPrplfiscalmainpay = new DBPrplfiscalpaymain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplfiscalmainpay.getCount(conditions);
        return count;
    }
}
