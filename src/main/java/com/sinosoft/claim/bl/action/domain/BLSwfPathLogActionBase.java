package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPathLog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfPathLog������·����־����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfPathLogActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPathLogActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfPathLogActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfPathLogDto swfPathLogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfPathLogDto swfPathLogDto) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        //�����¼
        dbSwfPathLog.insert(swfPathLogDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param flowID ���̱��
     * @param pathNo ���̱ߺ�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String flowID,int pathNo) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        //ɾ����¼
        dbSwfPathLog.delete(flowID, pathNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        //������ɾ����¼
        dbSwfPathLog.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfPathLogDto swfPathLogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfPathLogDto swfPathLogDto) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        //���¼�¼
        dbSwfPathLog.update(swfPathLogDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param flowID ���̱��
     * @param pathNo ���̱ߺ�
     * @return swfPathLogDto swfPathLogDto
     * @throws Exception
     */
    public SwfPathLogDto findByPrimaryKey(DBManager dbManager,String flowID,int pathNo) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        //����DTO
        SwfPathLogDto swfPathLogDto = null;
        //��ѯ����,��ֵ��DTO
        swfPathLogDto = dbSwfPathLog.findByPrimaryKey(flowID, pathNo);
        return swfPathLogDto;
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
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPathLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfPathLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfPathLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfPathLog.findByConditions(conditions);
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
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPathLog.getCount(conditions);
        return count;
    }
}
