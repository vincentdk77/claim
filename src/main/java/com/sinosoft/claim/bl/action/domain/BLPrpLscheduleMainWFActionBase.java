package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleMainWF;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleMainWF��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleMainWFActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleMainWFActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleMainWFActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleMainWFDto prpLscheduleMainWFDto) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        //�����¼
        dbPrpLscheduleMainWF.insert(prpLscheduleMainWFDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,int scheduleID,String registNo) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        //ɾ����¼
        dbPrpLscheduleMainWF.delete(scheduleID, registNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        //������ɾ����¼
        dbPrpLscheduleMainWF.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleMainWFDto prpLscheduleMainWFDto) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        //���¼�¼
        dbPrpLscheduleMainWF.update(prpLscheduleMainWFDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @return prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @throws Exception
     */
    public PrpLscheduleMainWFDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        //����DTO
        PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
        //��ѯ����,��ֵ��DTO
        prpLscheduleMainWFDto = dbPrpLscheduleMainWF.findByPrimaryKey(scheduleID, registNo);
        return prpLscheduleMainWFDto;
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
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
            
        }
        //modify by zhaolu 20060802 zhaolu start
        int count = dbPrpLscheduleMainWF.getCount(SqlUtils.getWherePartForGetCount(conditions));
        int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
        if(maxQueryCount!=0&&count>maxQueryCount){   
          throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
        }
        //modify by zhaolu 20060802 zhaolu end
        collection = dbPrpLscheduleMainWF.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLscheduleMainWFDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleMainWF.findByConditions(conditions);
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
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleMainWF.getCount(conditions);
        return count;
    }
}
