package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJplanFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJplanFee;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ӧ��Ӧ������Ϣ���ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpJplanFeeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpJplanFeeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpJplanFeeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJplanFeeDto prpJplanFeeDto)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        //�����¼
        dbPrpJplanFee.insert(prpJplanFeeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param certiType ҵ������
     * @param certiNo ��������/��������
     * @param serialNo ���Ѽƻ����
     * @param payRefReason �ո�ԭ��
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiType,String certiNo,int serialNo,String payRefReason)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        //ɾ����¼
        dbPrpJplanFee.delete(certiType, certiNo, serialNo, payRefReason);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        //������ɾ����¼
        dbPrpJplanFee.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJplanFeeDto prpJplanFeeDto)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        //���¼�¼
        dbPrpJplanFee.update(prpJplanFeeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param certiType ҵ������
     * @param certiNo ��������/��������
     * @param serialNo ���Ѽƻ����
     * @param payRefReason �ո�ԭ��
     * @return prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public PrpJplanFeeDto findByPrimaryKey(DBManager dbManager,String certiType,String certiNo,int serialNo,String payRefReason)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        //����DTO
        PrpJplanFeeDto prpJplanFeeDto = null;
        //��ѯ����,��ֵ��DTO
        prpJplanFeeDto = dbPrpJplanFee.findByPrimaryKey(certiType, certiNo, serialNo, payRefReason);
        return prpJplanFeeDto;
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
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJplanFee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpJplanFee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpJplanFeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpJplanFee.findByConditions(conditions);
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
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJplanFee.getCount(conditions);
        return count;
    }
}
