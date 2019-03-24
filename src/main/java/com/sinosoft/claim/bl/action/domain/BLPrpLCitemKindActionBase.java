package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCitemKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLCitemKind;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLCitemKind-���Ᵽ��Ͷ���ձ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.203<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLCitemKindActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLCitemKindActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLCitemKindActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLCitemKindDto prpLCitemKindDto) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        //�����¼
        dbPrpLCitemKind.insert(prpLCitemKindDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param policyNo ��������
     * @param itemKindNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String policyNo,int itemKindNo) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        //ɾ����¼
        dbPrpLCitemKind.delete(registNo, policyNo, itemKindNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        //������ɾ����¼
        dbPrpLCitemKind.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLCitemKindDto prpLCitemKindDto) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        //���¼�¼
        dbPrpLCitemKind.update(prpLCitemKindDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param policyNo ��������
     * @param itemKindNo ���
     * @return prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public PrpLCitemKindDto findByPrimaryKey(DBManager dbManager,String registNo,String policyNo,int itemKindNo) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        //����DTO
        PrpLCitemKindDto prpLCitemKindDto = null;
        //��ѯ����,��ֵ��DTO
        prpLCitemKindDto = dbPrpLCitemKind.findByPrimaryKey(registNo, policyNo, itemKindNo);
        return prpLCitemKindDto;
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
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCitemKind.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLCitemKind.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLCitemKindDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLCitemKind.findByConditions(conditions);
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
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCitemKind.getCount(conditions);
        return count;
    }
}
