package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleMain;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleMain-�������������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.140<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleMainActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleMainActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleMainActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleMainDto prpLscheduleMainDto) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        //�����¼
        dbPrpLscheduleMain.insert(prpLscheduleMainDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,int scheduleID,String registNo,int serialNo) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        //ɾ����¼
        dbPrpLscheduleMain.delete(scheduleID, registNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        //������ɾ����¼
        dbPrpLscheduleMain.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleMainDto prpLscheduleMainDto) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        //���¼�¼
        dbPrpLscheduleMain.update(prpLscheduleMainDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @param serialNo ���
     * @return prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public PrpLscheduleMainDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo,int serialNo) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        //����DTO
        PrpLscheduleMainDto prpLscheduleMainDto = null;
        //��ѯ����,��ֵ��DTO
        prpLscheduleMainDto = dbPrpLscheduleMain.findByPrimaryKey(scheduleID, registNo, serialNo);
        return prpLscheduleMainDto;
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
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleMain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLscheduleMain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLscheduleMainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleMain.findByConditions(conditions);
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
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleMain.getCount(conditions);
        return count;
    }
}
