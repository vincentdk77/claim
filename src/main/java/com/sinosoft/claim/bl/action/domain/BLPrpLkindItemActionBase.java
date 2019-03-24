package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLkindItemDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLkindItem;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǳб��ձ��ı��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLkindItemActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLkindItemActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLkindItemActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLkindItemDto prpLkindItemDto)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        //�����¼
        dbPrpLkindItem.insert(prpLkindItemDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @param itemCode �����Ŀ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String kindCode,String itemCode)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        //ɾ����¼
        dbPrpLkindItem.delete(riskCode, kindCode, itemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        //������ɾ����¼
        dbPrpLkindItem.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLkindItemDto prpLkindItemDto)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        //���¼�¼
        dbPrpLkindItem.update(prpLkindItemDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @param itemCode �����Ŀ����
     * @return prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public PrpLkindItemDto findByPrimaryKey(DBManager dbManager,String riskCode,String kindCode,String itemCode)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        //����DTO
        PrpLkindItemDto prpLkindItemDto = null;
        //��ѯ����,��ֵ��DTO
        prpLkindItemDto = dbPrpLkindItem.findByPrimaryKey(riskCode, kindCode, itemCode);
        return prpLkindItemDto;
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
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLkindItem.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLkindItem.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLkindItemDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLkindItem.findByConditions(conditions);
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
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLkindItem.getCount(conditions);
        return count;
    }
}
