package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcfeecoins;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLcfeecoins��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLcfeecoinsActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLcfeecoinsActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcfeecoinsActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcfeecoinsDto prpLcfeecoinsDto)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        //�����¼
        dbPrpLcfeecoins.insert(prpLcfeecoinsDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param businessNo businessNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo,int serialNo)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        //ɾ����¼
        dbPrpLcfeecoins.delete(businessNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        //������ɾ����¼
        dbPrpLcfeecoins.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcfeecoinsDto prpLcfeecoinsDto)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        //���¼�¼
        dbPrpLcfeecoins.update(prpLcfeecoinsDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param businessNo businessNo
     * @param serialNo serialNo
     * @return prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public PrpLcfeecoinsDto findByPrimaryKey(DBManager dbManager,String businessNo,int serialNo)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        //����DTO
        PrpLcfeecoinsDto prpLcfeecoinsDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcfeecoinsDto = dbPrpLcfeecoins.findByPrimaryKey(businessNo, serialNo);
        return prpLcfeecoinsDto;
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
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcfeecoins.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcfeecoins.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcfeecoinsDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcfeecoins.findByConditions(conditions);
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
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcfeecoins.getCount(conditions);
        return count;
    }
}
