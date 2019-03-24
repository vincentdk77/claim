package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLAcciCheckChargeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLAcciCheckCharge;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǵ�����ñ�-PrpLAcciCheckCharge��ҵ���߼�������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLAcciCheckChargeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLAcciCheckChargeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLAcciCheckChargeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        //�����¼
        dbPrpLAcciCheckCharge.insert(prpLAcciCheckChargeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param checkNo �����-CheckNo
     * @param serialNo ���-SerialNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String checkNo,int serialNo)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        //ɾ����¼
        dbPrpLAcciCheckCharge.delete(checkNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        //������ɾ����¼
        dbPrpLAcciCheckCharge.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        //���¼�¼
        dbPrpLAcciCheckCharge.update(prpLAcciCheckChargeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param checkNo �����-CheckNo
     * @param serialNo ���-SerialNo
     * @return prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public PrpLAcciCheckChargeDto findByPrimaryKey(DBManager dbManager,String checkNo,int serialNo)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        //����DTO
        PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = null;
        //��ѯ����,��ֵ��DTO
        prpLAcciCheckChargeDto = dbPrpLAcciCheckCharge.findByPrimaryKey(checkNo, serialNo);
        return prpLAcciCheckChargeDto;
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
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLAcciCheckCharge.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLAcciCheckCharge.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLAcciCheckChargeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLAcciCheckCharge.findByConditions(conditions);
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
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLAcciCheckCharge.getCount(conditions);
        return count;
    }
}
