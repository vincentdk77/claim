package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLbackVisit;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLbackVisit--�ط���Ϣ�����ҵ���߼�������<br>
 * ������ 2005-03-25 20:44:46.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLbackVisitActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLbackVisitDto prpLbackVisitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLbackVisitDto prpLbackVisitDto) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        //�����¼
        dbPrpLbackVisit.insert(prpLbackVisitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,int backVisitID,String registNo,String backVisitType) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        //ɾ����¼
        dbPrpLbackVisit.delete(backVisitID, registNo, backVisitType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        //������ɾ����¼
        dbPrpLbackVisit.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLbackVisitDto prpLbackVisitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLbackVisitDto prpLbackVisitDto) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        //���¼�¼
        dbPrpLbackVisit.update(prpLbackVisitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @return prpLbackVisitDto prpLbackVisitDto
     * @throws Exception
     */
    public PrpLbackVisitDto findByPrimaryKey(DBManager dbManager,int backVisitID,String registNo,String backVisitType) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        //����DTO
        PrpLbackVisitDto prpLbackVisitDto = null;
        //��ѯ����,��ֵ��DTO
        prpLbackVisitDto = dbPrpLbackVisit.findByPrimaryKey(backVisitID, registNo, backVisitType);
        return prpLbackVisitDto;
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
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLbackVisit.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLbackVisitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLbackVisit.findByConditions(conditions);
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
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisit.getCount(conditions);
        return count;
    }
}
