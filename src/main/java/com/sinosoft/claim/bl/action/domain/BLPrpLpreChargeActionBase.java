package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpreChargeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpreCharge;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLpreChargeActionBase {
	private static Log logger = LogFactory.getLog(BLPrpLpreChargeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpreChargeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param PrpLpreChargeDto PrpLpreChargeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpreChargeDto prpLpreChargeDto) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        //�����¼
        dbPrpLpreCharge.insert(prpLpreChargeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String preCompensateNo,int serialNo) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        //ɾ����¼
        dbPrpLpreCharge.delete(preCompensateNo,serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        //������ɾ����¼
        dbPrpLpreCharge.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param PrpLpreChargeDto PrpLpreChargeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpreChargeDto PrpLpreChargeDto) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        //���¼�¼
        dbPrpLpreCharge.update(PrpLpreChargeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo ���
     * @return PrpLpreChargeDto PrpLpreChargeDto
     * @throws Exception
     */
    public PrpLpreChargeDto findByPrimaryKey(DBManager dbManager,String preCompensateNo,int serialNo) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        //����DTO
        PrpLpreChargeDto PrpLpreChargeDto = null;
        //��ѯ����,��ֵ��DTO
        PrpLpreChargeDto = dbPrpLpreCharge.findByPrimaryKey(preCompensateNo,serialNo);
        return PrpLpreChargeDto;
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
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpreCharge.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpreCharge.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����PrpLpreChargeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpreCharge.findByConditions(conditions);
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
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpreCharge.getCount(conditions);
        return count;
    }
}
