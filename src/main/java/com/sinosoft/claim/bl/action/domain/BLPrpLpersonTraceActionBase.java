package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonTrace;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpersonTrace-���˸��ٱ�(����)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.250<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonTraceActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonTraceActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpersonTraceActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpersonTraceDto prpLpersonTraceDto) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        //�����¼
        dbPrpLpersonTrace.insert(prpLpersonTraceDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param personNo ��Ա���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int personNo) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        //ɾ����¼
        dbPrpLpersonTrace.delete(registNo, personNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        //������ɾ����¼
        dbPrpLpersonTrace.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpersonTraceDto prpLpersonTraceDto) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        //���¼�¼
        dbPrpLpersonTrace.update(prpLpersonTraceDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param personNo ��Ա���
     * @return prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public PrpLpersonTraceDto findByPrimaryKey(DBManager dbManager,String registNo,int personNo) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        //����DTO
        PrpLpersonTraceDto prpLpersonTraceDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpersonTraceDto = dbPrpLpersonTrace.findByPrimaryKey(registNo, personNo);
        return prpLpersonTraceDto;
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
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonTrace.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpersonTrace.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpersonTraceDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpersonTrace.findByConditions(conditions);
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
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonTrace.getCount(conditions);
        return count;
    }
}
