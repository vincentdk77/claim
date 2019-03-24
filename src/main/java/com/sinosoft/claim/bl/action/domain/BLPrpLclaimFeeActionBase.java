package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimFee;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimFee-��������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.984<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFeeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFeeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimFeeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimFeeDto prpLclaimFeeDto) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        //�����¼
        dbPrpLclaimFee.insert(prpLclaimFeeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ�ź�
     * @param currency �ұ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String currency) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        //ɾ����¼
        dbPrpLclaimFee.delete(claimNo, currency);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        //������ɾ����¼
        dbPrpLclaimFee.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimFeeDto prpLclaimFeeDto) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        //���¼�¼
        dbPrpLclaimFee.update(prpLclaimFeeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ�ź�
     * @param currency �ұ����
     * @return prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public PrpLclaimFeeDto findByPrimaryKey(DBManager dbManager,String claimNo,String currency) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        //����DTO
        PrpLclaimFeeDto prpLclaimFeeDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimFeeDto = dbPrpLclaimFee.findByPrimaryKey(claimNo, currency);
        return prpLclaimFeeDto;
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
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimFee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimFee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimFeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimFee.findByConditions(conditions);
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
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimFee.getCount(conditions);
        return count;
    }
}
