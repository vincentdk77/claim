package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpPcoinsDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPcoinsDetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpPcoinsDetail��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpPcoinsDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpPcoinsDetailActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpPcoinsDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPcoinsDetailDto prpPcoinsDetailDto)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        //�����¼
        dbPrpPcoinsDetail.insert(prpPcoinsDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @param currency currency
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo,long serialNo,String currency)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        //ɾ����¼
        dbPrpPcoinsDetail.delete(endorseNo, serialNo, currency);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        //������ɾ����¼
        dbPrpPcoinsDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPcoinsDetailDto prpPcoinsDetailDto)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        //���¼�¼
        dbPrpPcoinsDetail.update(prpPcoinsDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @param currency currency
     * @return prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public PrpPcoinsDetailDto findByPrimaryKey(DBManager dbManager,String endorseNo,long serialNo,String currency)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        //����DTO
        PrpPcoinsDetailDto prpPcoinsDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prpPcoinsDetailDto = dbPrpPcoinsDetail.findByPrimaryKey(endorseNo, serialNo, currency);
        return prpPcoinsDetailDto;
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
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPcoinsDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpPcoinsDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpPcoinsDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpPcoinsDetail.findByConditions(conditions);
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
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPcoinsDetail.getCount(conditions);
        return count;
    }
}
