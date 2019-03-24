package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleItem;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleItem-���������ı�(��������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.234<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleItemActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleItemActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleItemActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLscheduleItemDto prpLscheduleItemDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleItemDto prpLscheduleItemDto) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        //�����¼
        dbPrpLscheduleItem.insert(prpLscheduleItemDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @param itemNo ITEMNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,int scheduleID,String registNo,int itemNo) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        //ɾ����¼
        dbPrpLscheduleItem.delete(scheduleID, registNo, itemNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        //������ɾ����¼
        dbPrpLscheduleItem.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLscheduleItemDto prpLscheduleItemDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleItemDto prpLscheduleItemDto) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        //���¼�¼
        dbPrpLscheduleItem.update(prpLscheduleItemDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @param itemNo ITEMNO
     * @return prpLscheduleItemDto prpLscheduleItemDto
     * @throws Exception
     */
    public PrpLscheduleItemDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo,int itemNo) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        //����DTO
        PrpLscheduleItemDto prpLscheduleItemDto = null;
        //��ѯ����,��ֵ��DTO
        prpLscheduleItemDto = dbPrpLscheduleItem.findByPrimaryKey(scheduleID, registNo, itemNo);
        return prpLscheduleItemDto;
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
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        //modify by zhaolu 20060802 start
        int count = dbPrpLscheduleItem.getCount(SqlUtils.getWherePartForGetCount(conditions));
        int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
        if(maxQueryCount!=0&&count>maxQueryCount){   
          throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
        }
        //modify by zhaolu 10060802 end
        collection = dbPrpLscheduleItem.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLscheduleItemDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleItem.findByConditions(conditions);
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
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleItem.getCount(conditions);
        return count;
    }
}
