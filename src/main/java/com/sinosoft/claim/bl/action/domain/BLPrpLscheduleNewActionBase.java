package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleNew;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleNew-�°���������ʾ��(����)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.218<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleNewActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleNewActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleNewActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLscheduleNewDto prpLscheduleNewDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleNewDto prpLscheduleNewDto) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        //�����¼
        dbPrpLscheduleNew.insert(prpLscheduleNewDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ���������
     * @param surveyNo �Ѳ鿱����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int surveyNo) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        //ɾ����¼
        dbPrpLscheduleNew.delete(registNo, surveyNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        //������ɾ����¼
        dbPrpLscheduleNew.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLscheduleNewDto prpLscheduleNewDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleNewDto prpLscheduleNewDto) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        //���¼�¼
        dbPrpLscheduleNew.update(prpLscheduleNewDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ���������
     * @param surveyNo �Ѳ鿱����
     * @return prpLscheduleNewDto prpLscheduleNewDto
     * @throws Exception
     */
    public PrpLscheduleNewDto findByPrimaryKey(DBManager dbManager,String registNo,int surveyNo) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        //����DTO
        PrpLscheduleNewDto prpLscheduleNewDto = null;
        //��ѯ����,��ֵ��DTO
        prpLscheduleNewDto = dbPrpLscheduleNew.findByPrimaryKey(registNo, surveyNo);
        return prpLscheduleNewDto;
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
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleNew.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLscheduleNew.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLscheduleNewDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleNew.findByConditions(conditions);
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
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleNew.getCount(conditions);
        return count;
    }
}
