package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUndoCancelFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpUndoCancelFee;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpUndoCancelFee���ϻ�ɾ�������켣�����ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUndoCancelFeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpUndoCancelFeeActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpUndoCancelFeeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpUndoCancelFeeDto prpUndoCancelFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpUndoCancelFeeDto prpUndoCancelFeeDto) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        //�����¼
        dbPrpUndoCancelFee.insert(prpUndoCancelFeeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param operateTypeCode �������ʹ���
     * @param certiNo ��֤��
     * @param serialNo ���
     * @param currency �ұ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String operateTypeCode,String certiNo,int serialNo,String currency) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        //ɾ����¼
        dbPrpUndoCancelFee.delete(operateTypeCode, certiNo, serialNo, currency);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        //������ɾ����¼
        dbPrpUndoCancelFee.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpUndoCancelFeeDto prpUndoCancelFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpUndoCancelFeeDto prpUndoCancelFeeDto) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        //���¼�¼
        dbPrpUndoCancelFee.update(prpUndoCancelFeeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param operateTypeCode �������ʹ���
     * @param certiNo ��֤��
     * @param serialNo ���
     * @param currency �ұ����
     * @return prpUndoCancelFeeDto prpUndoCancelFeeDto
     * @throws Exception
     */
    public PrpUndoCancelFeeDto findByPrimaryKey(DBManager dbManager,String operateTypeCode,String certiNo,int serialNo,String currency) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        //����DTO
        PrpUndoCancelFeeDto prpUndoCancelFeeDto = null;
        //��ѯ����,��ֵ��DTO
        prpUndoCancelFeeDto = dbPrpUndoCancelFee.findByPrimaryKey(operateTypeCode, certiNo, serialNo, currency);
        return prpUndoCancelFeeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpUndoCancelFeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpUndoCancelFee.getCount(conditions);
        collection = dbPrpUndoCancelFee.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpUndoCancelFee.getCount(conditions);
        return count;
    }
}
