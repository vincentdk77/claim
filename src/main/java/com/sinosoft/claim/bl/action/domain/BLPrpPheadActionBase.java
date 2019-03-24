package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPheadDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPhead;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpphead������Ϣ���ҵ���߼�������<br>
 * ������ 2004-11-22 15:24:30.890<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPheadActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPheadActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpPheadActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpPheadDto prpPheadDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPheadDto prpPheadDto) throws Exception{
        DBPrpPhead dbPrpPhead = new DBPrpPhead(dbManager);
        //�����¼
        dbPrpPhead.insert(prpPheadDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param endorseNo ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo) throws Exception{
        DBPrpPhead dbPrpPhead = new DBPrpPhead(dbManager);
        //ɾ����¼
        dbPrpPhead.delete(endorseNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPhead dbPrpPhead = new DBPrpPhead(dbManager);
        //������ɾ����¼
        dbPrpPhead.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpPheadDto prpPheadDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPheadDto prpPheadDto) throws Exception{
        DBPrpPhead dbPrpPhead = new DBPrpPhead(dbManager);
        //���¼�¼
        dbPrpPhead.update(prpPheadDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param endorseNo ��������
     * @return prpPheadDto prpPheadDto
     * @throws Exception
     */
    public PrpPheadDto findByPrimaryKey(DBManager dbManager,String endorseNo) throws Exception{
        DBPrpPhead dbPrpPhead = new DBPrpPhead(dbManager);
        //����DTO
        PrpPheadDto prpPheadDto = null;
        //��ѯ����,��ֵ��DTO
        prpPheadDto = dbPrpPhead.findByPrimaryKey(endorseNo);
        return prpPheadDto;
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
        DBPrpPhead dbPrpPhead = new DBPrpPhead(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPhead.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpPhead.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpPheadDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPhead dbPrpPhead = new DBPrpPhead(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpPhead.findByConditions(conditions);
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
        DBPrpPhead dbPrpPhead = new DBPrpPhead(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPhead.getCount(conditions);
        return count;
    }
}
