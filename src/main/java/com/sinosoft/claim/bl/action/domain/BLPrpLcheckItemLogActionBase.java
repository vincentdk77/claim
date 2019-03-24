package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckItemLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckItemLog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckItemLog-�鿱������Ϣ������־���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckItemLogActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckItemLogActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcheckItemLogActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcheckItemLogDto prpLcheckItemLogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcheckItemLogDto prpLcheckItemLogDto) throws Exception{
        DBPrpLcheckItemLog dbPrpLcheckItemLog = new DBPrpLcheckItemLog(dbManager);
        //�����¼
        dbPrpLcheckItemLog.insert(prpLcheckItemLogDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @param itemNo ������
     * @param serialNo �������
     * @throws Exception
     */
    public void delete(DBManager dbManager,int scheduleID,String registNo,double itemNo,int serialNo) throws Exception{
        DBPrpLcheckItemLog dbPrpLcheckItemLog = new DBPrpLcheckItemLog(dbManager);
        //ɾ����¼
        dbPrpLcheckItemLog.delete(scheduleID, registNo, itemNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckItemLog dbPrpLcheckItemLog = new DBPrpLcheckItemLog(dbManager);
        //������ɾ����¼
        dbPrpLcheckItemLog.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcheckItemLogDto prpLcheckItemLogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcheckItemLogDto prpLcheckItemLogDto) throws Exception{
        DBPrpLcheckItemLog dbPrpLcheckItemLog = new DBPrpLcheckItemLog(dbManager);
        //���¼�¼
        dbPrpLcheckItemLog.update(prpLcheckItemLogDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @param itemNo ������
     * @param serialNo �������
     * @return prpLcheckItemLogDto prpLcheckItemLogDto
     * @throws Exception
     */
    public PrpLcheckItemLogDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo,double itemNo,int serialNo) throws Exception{
        DBPrpLcheckItemLog dbPrpLcheckItemLog = new DBPrpLcheckItemLog(dbManager);
        //����DTO
        PrpLcheckItemLogDto prpLcheckItemLogDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcheckItemLogDto = dbPrpLcheckItemLog.findByPrimaryKey(scheduleID, registNo, itemNo, serialNo);
        return prpLcheckItemLogDto;
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
        DBPrpLcheckItemLog dbPrpLcheckItemLog = new DBPrpLcheckItemLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckItemLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcheckItemLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcheckItemLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckItemLog dbPrpLcheckItemLog = new DBPrpLcheckItemLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcheckItemLog.findByConditions(conditions);
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
        DBPrpLcheckItemLog dbPrpLcheckItemLog = new DBPrpLcheckItemLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckItemLog.getCount(conditions);
        return count;
    }
}
