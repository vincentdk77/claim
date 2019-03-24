package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckLoss-�鿱�¹ʹ�������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.125<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckLossActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcheckLossActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcheckLossDto prpLcheckLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcheckLossDto prpLcheckLossDto) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        //�����¼
        dbPrpLcheckLoss.insert(prpLcheckLossDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ���յǼǺ�
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        //ɾ����¼
        dbPrpLcheckLoss.delete(registNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        //������ɾ����¼
        dbPrpLcheckLoss.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcheckLossDto prpLcheckLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcheckLossDto prpLcheckLossDto) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        //���¼�¼
        dbPrpLcheckLoss.update(prpLcheckLossDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ���յǼǺ�
     * @param serialNo ���
     * @return prpLcheckLossDto prpLcheckLossDto
     * @throws Exception
     */
    public PrpLcheckLossDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        //����DTO
        PrpLcheckLossDto prpLcheckLossDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcheckLossDto = dbPrpLcheckLoss.findByPrimaryKey(registNo, serialNo);
        return prpLcheckLossDto;
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
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcheckLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcheckLossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcheckLoss.findByConditions(conditions);
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
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckLoss.getCount(conditions);
        return count;
    }
}
