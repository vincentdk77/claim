package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagertgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimBillManagertg;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLclaimBillManager��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLclaimBillManagertgActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLclaimBillManagertgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimBillManagertgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimBillManagertgDto prpLclaimBillManagertgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimBillManagertgDto prpLclaimBillManagertgDto)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        //�����¼
        dbPrpLclaimBillManagertg.insert(prpLclaimBillManagertgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo registNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        //ɾ����¼
        dbPrpLclaimBillManagertg.delete(registNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        //������ɾ����¼
        dbPrpLclaimBillManagertg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimBillManagertgDto prpLclaimBillManagertgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimBillManagertgDto prpLclaimBillManagertgDto)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        //���¼�¼
        dbPrpLclaimBillManagertg.update(prpLclaimBillManagertgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo registNo
     * @return prpLclaimBillManagertgDto prpLclaimBillManagertgDto
     * @throws Exception
     */
    public PrpLclaimBillManagertgDto findByPrimaryKey(DBManager dbManager,String registNo,String compensateNo,int serialNo)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        //����DTO
        PrpLclaimBillManagertgDto prpLclaimBillManagertgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimBillManagertgDto = dbPrpLclaimBillManagertg.findByPrimaryKey(registNo,compensateNo,serialNo);
        return prpLclaimBillManagertgDto;
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
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimBillManagertg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimBillManagertg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimBillManagertgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimBillManagertg.findByConditions(conditions);
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
        DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimBillManagertg.getCount(conditions);
        return count;
    }
}
