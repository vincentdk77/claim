package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimApprovtgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimApprovtg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimApprov-��������ת��ȷ�ϱ��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimApprovtgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimApprovtgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimApprovtgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimApprovtgDto prpLclaimApprovtgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimApprovtgDto prpLclaimApprovtgDto) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        //�����¼
        dbPrpLclaimApprovtg.insert(prpLclaimApprovtgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        //ɾ����¼
        dbPrpLclaimApprovtg.delete(registNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        //������ɾ����¼
        dbPrpLclaimApprovtg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimApprovtgDto prpLclaimApprovtgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimApprovtgDto prpLclaimApprovtgDto) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        //���¼�¼
        dbPrpLclaimApprovtg.update(prpLclaimApprovtgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @return prpLclaimApprovtgDto prpLclaimApprovtgDto
     * @throws Exception
     */
    public PrpLclaimApprovtgDto findByPrimaryKey(DBManager dbManager,String registNo) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        //����DTO
        PrpLclaimApprovtgDto prpLclaimApprovtgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimApprovtgDto = dbPrpLclaimApprovtg.findByPrimaryKey(registNo);
        return prpLclaimApprovtgDto;
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
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimApprovtg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimApprovtg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimApprovtgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimApprovtg.findByConditions(conditions);
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
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimApprovtg.getCount(conditions);
        return count;
    }
}
