package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckItem;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckItem-�鿱�����ı���������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.218<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckItemActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckItemActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcheckItemActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcheckItemDto prpLcheckItemDto) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        //�����¼
        dbPrpLcheckItem.insert(prpLcheckItemDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @param itemNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,int scheduleID,String registNo,int itemNo) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        //ɾ����¼
        dbPrpLcheckItem.delete(scheduleID, registNo, itemNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        //������ɾ����¼
        dbPrpLcheckItem.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcheckItemDto prpLcheckItemDto) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        //���¼�¼
        dbPrpLcheckItem.update(prpLcheckItemDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @param itemNo ������
     * @return prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public PrpLcheckItemDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo,int itemNo) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        //����DTO
        PrpLcheckItemDto prpLcheckItemDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcheckItemDto = dbPrpLcheckItem.findByPrimaryKey(scheduleID, registNo, itemNo);
        return prpLcheckItemDto;
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
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckItem.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcheckItem.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcheckItemDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcheckItem.findByConditions(conditions);
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
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckItem.getCount(conditions);
        return count;
    }
}
