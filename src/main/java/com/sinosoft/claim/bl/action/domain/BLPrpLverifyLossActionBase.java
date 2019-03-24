package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLverifyLoss-������������������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.250<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLverifyLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLverifyLossActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLverifyLossActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLverifyLossDto prpLverifyLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLverifyLossDto prpLverifyLossDto) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        //�����¼
        dbPrpLverifyLoss.insert(prpLverifyLossDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param lossItemCode ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String lossItemCode) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        //ɾ����¼
        dbPrpLverifyLoss.delete(registNo, lossItemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        //������ɾ����¼
        dbPrpLverifyLoss.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLverifyLossDto prpLverifyLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLverifyLossDto prpLverifyLossDto) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        //���¼�¼
        dbPrpLverifyLoss.update(prpLverifyLossDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param lossItemCode ������
     * @return prpLverifyLossDto prpLverifyLossDto
     * @throws Exception
     */
    public PrpLverifyLossDto findByPrimaryKey(DBManager dbManager,String registNo,String lossItemCode) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        //����DTO
        PrpLverifyLossDto prpLverifyLossDto = null;
        //��ѯ����,��ֵ��DTO
        prpLverifyLossDto = dbPrpLverifyLoss.findByPrimaryKey(registNo, lossItemCode);
        return prpLverifyLossDto;
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
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLverifyLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLverifyLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLverifyLossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLverifyLoss.findByConditions(conditions);
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
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLverifyLoss.getCount(conditions);
        return count;
    }
}
