package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitQueDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLbackVisitQue;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLbackVisitQue--�ط���ѯ���ҵ���߼�������<br>
 * ������ 2005-03-23 09:00:24.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitQueActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitQueActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLbackVisitQueActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        //�����¼
        dbPrpLbackVisitQue.insert(prpLbackVisitQueDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @param questionCode �ط���Ŀ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,int backVisitID,String registNo,String backVisitType,String questionCode) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        //ɾ����¼
        dbPrpLbackVisitQue.delete(backVisitID, registNo, backVisitType, questionCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        //������ɾ����¼
        dbPrpLbackVisitQue.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        //���¼�¼
        dbPrpLbackVisitQue.update(prpLbackVisitQueDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @param questionCode �ط���Ŀ����
     * @return prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public PrpLbackVisitQueDto findByPrimaryKey(DBManager dbManager,int backVisitID,String registNo,String backVisitType,String questionCode) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        //����DTO
        PrpLbackVisitQueDto prpLbackVisitQueDto = null;
        //��ѯ����,��ֵ��DTO
        prpLbackVisitQueDto = dbPrpLbackVisitQue.findByPrimaryKey(backVisitID, registNo, backVisitType, questionCode);
        return prpLbackVisitQueDto;
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
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisitQue.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLbackVisitQue.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLbackVisitQueDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLbackVisitQue.findByConditions(conditions);
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
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisitQue.getCount(conditions);
        return count;
    }
}
