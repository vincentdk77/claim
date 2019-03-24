package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfFlowMain;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfFlowMain-����������������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.281<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfFlowMainActionBase{
    private static Log logger = LogFactory.getLog(BLSwfFlowMainActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfFlowMainActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfFlowMainDto swfFlowMainDto) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        //�����¼
        dbSwfFlowMain.insert(swfFlowMainDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param flowID ���̱��
     * @throws Exception
     */
    public void delete(DBManager dbManager,String flowID) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        //ɾ����¼
        dbSwfFlowMain.delete(flowID);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        //������ɾ����¼
        dbSwfFlowMain.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfFlowMainDto swfFlowMainDto) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        //���¼�¼
        dbSwfFlowMain.update(swfFlowMainDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param flowID ���̱��
     * @return swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public SwfFlowMainDto findByPrimaryKey(DBManager dbManager,String flowID) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        //����DTO
        SwfFlowMainDto swfFlowMainDto = null;
        //��ѯ����,��ֵ��DTO
        swfFlowMainDto = dbSwfFlowMain.findByPrimaryKey(flowID);
        return swfFlowMainDto;
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
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfFlowMain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfFlowMain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfFlowMainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfFlowMain.findByConditions(conditions);
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
        DBSwfFlowMain dbSwfFlowMain = new DBSwfFlowMain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfFlowMain.getCount(conditions);
        return count;
    }
}
