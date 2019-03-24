package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleObjectDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleObject;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleObject-���ȶ�����ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.218<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleObjectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleObjectActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleObjectActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLscheduleObjectDto prpLscheduleObjectDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleObjectDto prpLscheduleObjectDto) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        //�����¼
        dbPrpLscheduleObject.insert(prpLscheduleObjectDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param scheduleObjectID ���ȶ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String scheduleObjectID) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        //ɾ����¼
        dbPrpLscheduleObject.delete(scheduleObjectID);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        //������ɾ����¼
        dbPrpLscheduleObject.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLscheduleObjectDto prpLscheduleObjectDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleObjectDto prpLscheduleObjectDto) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        //���¼�¼
        dbPrpLscheduleObject.update(prpLscheduleObjectDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param scheduleObjectID ���ȶ������
     * @return prpLscheduleObjectDto prpLscheduleObjectDto
     * @throws Exception
     */
    public PrpLscheduleObjectDto findByPrimaryKey(DBManager dbManager,String scheduleObjectID) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        //����DTO
        PrpLscheduleObjectDto prpLscheduleObjectDto = null;
        //��ѯ����,��ֵ��DTO
        prpLscheduleObjectDto = dbPrpLscheduleObject.findByPrimaryKey(scheduleObjectID);
        return prpLscheduleObjectDto;
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
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleObject.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLscheduleObject.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLscheduleObjectDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleObject.findByConditions(conditions);
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
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleObject.getCount(conditions);
        return count;
    }
}
