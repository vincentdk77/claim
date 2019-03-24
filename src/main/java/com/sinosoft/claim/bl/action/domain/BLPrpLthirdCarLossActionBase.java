package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdCarLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdCarLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdCarLoss-��ʧ��λ(����)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.234<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdCarLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdCarLossActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLthirdCarLossActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLthirdCarLossDto prpLthirdCarLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLthirdCarLossDto prpLthirdCarLossDto) throws Exception{
        DBPrpLthirdCarLoss dbPrpLthirdCarLoss = new DBPrpLthirdCarLoss(dbManager);
        //�����¼
        dbPrpLthirdCarLoss.insert(prpLthirdCarLossDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @param itemNo ��ʧ��Ŀ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,int itemNo) throws Exception{
        DBPrpLthirdCarLoss dbPrpLthirdCarLoss = new DBPrpLthirdCarLoss(dbManager);
        //ɾ����¼
        dbPrpLthirdCarLoss.delete(registNo, serialNo, itemNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLthirdCarLoss dbPrpLthirdCarLoss = new DBPrpLthirdCarLoss(dbManager);
        //������ɾ����¼
        dbPrpLthirdCarLoss.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLthirdCarLossDto prpLthirdCarLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLthirdCarLossDto prpLthirdCarLossDto) throws Exception{
        DBPrpLthirdCarLoss dbPrpLthirdCarLoss = new DBPrpLthirdCarLoss(dbManager);
        //���¼�¼
        dbPrpLthirdCarLoss.update(prpLthirdCarLossDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @param itemNo ��ʧ��Ŀ���
     * @return prpLthirdCarLossDto prpLthirdCarLossDto
     * @throws Exception
     */
    public PrpLthirdCarLossDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,int itemNo) throws Exception{
        DBPrpLthirdCarLoss dbPrpLthirdCarLoss = new DBPrpLthirdCarLoss(dbManager);
        //����DTO
        PrpLthirdCarLossDto prpLthirdCarLossDto = null;
        //��ѯ����,��ֵ��DTO
        prpLthirdCarLossDto = dbPrpLthirdCarLoss.findByPrimaryKey(registNo, serialNo, itemNo);
        return prpLthirdCarLossDto;
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
        DBPrpLthirdCarLoss dbPrpLthirdCarLoss = new DBPrpLthirdCarLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLthirdCarLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLthirdCarLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLthirdCarLossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLthirdCarLoss dbPrpLthirdCarLoss = new DBPrpLthirdCarLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLthirdCarLoss.findByConditions(conditions);
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
        DBPrpLthirdCarLoss dbPrpLthirdCarLoss = new DBPrpLthirdCarLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLthirdCarLoss.getCount(conditions);
        return count;
    }
}
