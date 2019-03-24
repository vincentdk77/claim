package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfNotion;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ���ǹ��������������ҵ���߼�������<br>
 * ������ 2005-04-05 10:45:04.500<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfNotionActionBase{
    private static Log logger = LogFactory.getLog(BLSwfNotionActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfNotionActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfNotionDto swfNotionDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfNotionDto swfNotionDto) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        //�����¼
        dbSwfNotion.insert(swfNotionDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param flowID ������ID
     * @param logNo ��־���
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String flowID,int logNo,int lineNo) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        //ɾ����¼
        dbSwfNotion.delete(flowID, logNo, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        //������ɾ����¼
        dbSwfNotion.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfNotionDto swfNotionDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfNotionDto swfNotionDto) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        //���¼�¼
        dbSwfNotion.update(swfNotionDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param flowID ������ID
     * @param logNo ��־���
     * @param lineNo �к�
     * @return swfNotionDto swfNotionDto
     * @throws Exception
     */
    public SwfNotionDto findByPrimaryKey(DBManager dbManager,String flowID,int logNo,int lineNo) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        //����DTO
        SwfNotionDto swfNotionDto = null;
        //��ѯ����,��ֵ��DTO
        swfNotionDto = dbSwfNotion.findByPrimaryKey(flowID, logNo, lineNo);
        return swfNotionDto;
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
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfNotion.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfNotion.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfNotionDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfNotion.findByConditions(conditions);
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
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfNotion.getCount(conditions);
        return count;
    }
}
