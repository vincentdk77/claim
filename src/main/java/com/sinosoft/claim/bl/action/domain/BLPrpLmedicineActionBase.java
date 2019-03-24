package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmedicineDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLmedicine;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLmedicine-��Աҽҩ���嵥���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.031<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLmedicineActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLmedicineActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLmedicineActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLmedicineDto prpLmedicineDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLmedicineDto prpLmedicineDto) throws Exception{
        DBPrpLmedicine dbPrpLmedicine = new DBPrpLmedicine(dbManager);
        //�����¼
        dbPrpLmedicine.insert(prpLmedicineDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLmedicine dbPrpLmedicine = new DBPrpLmedicine(dbManager);
        //ɾ����¼
        dbPrpLmedicine.delete(claimNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmedicine dbPrpLmedicine = new DBPrpLmedicine(dbManager);
        //������ɾ����¼
        dbPrpLmedicine.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLmedicineDto prpLmedicineDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLmedicineDto prpLmedicineDto) throws Exception{
        DBPrpLmedicine dbPrpLmedicine = new DBPrpLmedicine(dbManager);
        //���¼�¼
        dbPrpLmedicine.update(prpLmedicineDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @return prpLmedicineDto prpLmedicineDto
     * @throws Exception
     */
    public PrpLmedicineDto findByPrimaryKey(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLmedicine dbPrpLmedicine = new DBPrpLmedicine(dbManager);
        //����DTO
        PrpLmedicineDto prpLmedicineDto = null;
        //��ѯ����,��ֵ��DTO
        prpLmedicineDto = dbPrpLmedicine.findByPrimaryKey(claimNo, serialNo);
        return prpLmedicineDto;
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
        DBPrpLmedicine dbPrpLmedicine = new DBPrpLmedicine(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLmedicine.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLmedicine.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLmedicineDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmedicine dbPrpLmedicine = new DBPrpLmedicine(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLmedicine.findByConditions(conditions);
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
        DBPrpLmedicine dbPrpLmedicine = new DBPrpLmedicine(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLmedicine.getCount(conditions);
        return count;
    }
}
