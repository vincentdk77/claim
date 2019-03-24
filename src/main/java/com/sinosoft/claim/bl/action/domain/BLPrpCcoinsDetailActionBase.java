package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpCcoinsDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcoinsDetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCcoinsDetail��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCcoinsDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpCcoinsDetailActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpCcoinsDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCcoinsDetailDto prpCcoinsDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCcoinsDetailDto prpCcoinsDetailDto)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        //�����¼
        dbPrpCcoinsDetail.insert(prpCcoinsDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @param currency currency
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,long serialNo,String currency)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        //ɾ����¼
        dbPrpCcoinsDetail.delete(policyNo, serialNo, currency);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        //������ɾ����¼
        dbPrpCcoinsDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCcoinsDetailDto prpCcoinsDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCcoinsDetailDto prpCcoinsDetailDto)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        //���¼�¼
        dbPrpCcoinsDetail.update(prpCcoinsDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @param currency currency
     * @return prpCcoinsDetailDto prpCcoinsDetailDto
     * @throws Exception
     */
    public PrpCcoinsDetailDto findByPrimaryKey(DBManager dbManager,String policyNo,long serialNo,String currency)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        //����DTO
        PrpCcoinsDetailDto prpCcoinsDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prpCcoinsDetailDto = dbPrpCcoinsDetail.findByPrimaryKey(policyNo, serialNo, currency);
        return prpCcoinsDetailDto;
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
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCcoinsDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpCcoinsDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpCcoinsDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpCcoinsDetail.findByConditions(conditions);
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
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCcoinsDetail.getCount(conditions);
        return count;
    }
}
