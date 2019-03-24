package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLloss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLlossFG;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLloss-�⸶�����Ϣ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.031<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLlossActionBaseFG{
    private static Log logger = LogFactory.getLog(BLPrpLlossActionBaseFG.class);

    /**
     * ���캯��
     */
    public BLPrpLlossActionBaseFG(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLlossDto prpLlossDto) throws Exception{
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        //�����¼
        dbPrpLloss.insert(prpLlossDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo �⸶������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        //ɾ����¼
        dbPrpLloss.delete(compensateNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        //������ɾ����¼
        dbPrpLloss.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLlossDto prpLlossDto) throws Exception{
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        //���¼�¼
        dbPrpLloss.update(prpLlossDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo �⸶������
     * @return prpLlossDto prpLlossDto
     * @throws Exception
     */
    public PrpLlossDto findByPrimaryKey(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        //����DTO
        PrpLlossDto prpLlossDto = null;
        //��ѯ����,��ֵ��DTO
        prpLlossDto = dbPrpLloss.findByPrimaryKey(compensateNo, serialNo);
        return prpLlossDto;
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
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLloss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLloss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLlossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLlossFG dbPrpLloss = new DBPrpLlossFG(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLloss.findByConditions(conditions);
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
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLloss.getCount(conditions);
        return count;
    }
}
