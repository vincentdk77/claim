package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpPcoinsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPcoins;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpPcoins��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpPcoinsActionBase{
    private static Logger logger = Logger.getLogger(BLPrpPcoinsActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpPcoinsActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpPcoinsDto prpPcoinsDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPcoinsDto prpPcoinsDto)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        //�����¼
        dbPrpPcoins.insert(prpPcoinsDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo,long serialNo)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        //ɾ����¼
        dbPrpPcoins.delete(endorseNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        //������ɾ����¼
        dbPrpPcoins.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpPcoinsDto prpPcoinsDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPcoinsDto prpPcoinsDto)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        //���¼�¼
        dbPrpPcoins.update(prpPcoinsDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @return prpPcoinsDto prpPcoinsDto
     * @throws Exception
     */
    public PrpPcoinsDto findByPrimaryKey(DBManager dbManager,String endorseNo,long serialNo)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        //����DTO
        PrpPcoinsDto prpPcoinsDto = null;
        //��ѯ����,��ֵ��DTO
        prpPcoinsDto = dbPrpPcoins.findByPrimaryKey(endorseNo, serialNo);
        return prpPcoinsDto;
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
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPcoins.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpPcoins.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpPcoinsDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpPcoins.findByConditions(conditions);
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
        DBPrpPcoins dbPrpPcoins = new DBPrpPcoins(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPcoins.getCount(conditions);
        return count;
    }
}
