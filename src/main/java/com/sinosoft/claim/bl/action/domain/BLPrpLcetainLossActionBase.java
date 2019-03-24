package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcetainLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcetainLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcetainLoss��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.343<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcetainLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcetainLossActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcetainLossActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcetainLossDto prpLcetainLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcetainLossDto prpLcetainLossDto) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        //�����¼
        dbPrpLcetainLoss.insert(prpLcetainLossDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param itemNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int itemNo) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        //ɾ����¼
        dbPrpLcetainLoss.delete(claimNo, itemNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        //������ɾ����¼
        dbPrpLcetainLoss.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcetainLossDto prpLcetainLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcetainLossDto prpLcetainLossDto) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        //���¼�¼
        dbPrpLcetainLoss.update(prpLcetainLossDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param itemNo ������
     * @return prpLcetainLossDto prpLcetainLossDto
     * @throws Exception
     */
    public PrpLcetainLossDto findByPrimaryKey(DBManager dbManager,String claimNo,int itemNo) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        //����DTO
        PrpLcetainLossDto prpLcetainLossDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcetainLossDto = dbPrpLcetainLoss.findByPrimaryKey(claimNo, itemNo);
        return prpLcetainLossDto;
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
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcetainLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcetainLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcetainLossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcetainLoss.findByConditions(conditions);
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
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcetainLoss.getCount(conditions);
        return count;
    }
}
