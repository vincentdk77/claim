package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLregist-������Ϣ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.984<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLregistActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLregistActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLregistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLregistDto prpLregistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLregistDto prpLregistDto) throws Exception{
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
        //�����¼
        dbPrpLregist.insert(prpLregistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo) throws Exception{
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
        //ɾ����¼
        dbPrpLregist.delete(registNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
        //������ɾ����¼
        dbPrpLregist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLregistDto prpLregistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLregistDto prpLregistDto) throws Exception{
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
        //���¼�¼
        dbPrpLregist.update(prpLregistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @return prpLregistDto prpLregistDto
     * @throws Exception
     */
    public PrpLregistDto findByPrimaryKey(DBManager dbManager,String registNo) throws Exception{
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
        //����DTO
        PrpLregistDto prpLregistDto = null;
        //��ѯ����,��ֵ��DTO
        prpLregistDto = dbPrpLregist.findByPrimaryKey(registNo);
        return prpLregistDto;
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
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLregist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLregist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLregistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLregist.findByConditions(conditions);
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
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLregist.getCount(conditions);
        return count;
    }
}
