package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPitemKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPitemKind;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppitemkind���������Ϣ��ҵ���߼�������<br>
 * ������ 2004-11-22 15:24:31.171<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPitemKindActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPitemKindActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpPitemKindActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpPitemKindDto prpPitemKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPitemKindDto prpPitemKindDto) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        //�����¼
        dbPrpPitemKind.insert(prpPitemKindDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param endorseNo ��������
     * @param itemKindNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo,int itemKindNo) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        //ɾ����¼
        dbPrpPitemKind.delete(endorseNo, itemKindNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        //������ɾ����¼
        dbPrpPitemKind.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpPitemKindDto prpPitemKindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPitemKindDto prpPitemKindDto) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        //���¼�¼
        dbPrpPitemKind.update(prpPitemKindDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param endorseNo ��������
     * @param itemKindNo ���
     * @return prpPitemKindDto prpPitemKindDto
     * @throws Exception
     */
    public PrpPitemKindDto findByPrimaryKey(DBManager dbManager,String endorseNo,int itemKindNo) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        //����DTO
        PrpPitemKindDto prpPitemKindDto = null;
        //��ѯ����,��ֵ��DTO
        prpPitemKindDto = dbPrpPitemKind.findByPrimaryKey(endorseNo, itemKindNo);
        return prpPitemKindDto;
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
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPitemKind.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpPitemKind.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpPitemKindDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpPitemKind.findByConditions(conditions);
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
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPitemKind.getCount(conditions);
        return count;
    }
}
