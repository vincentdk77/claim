package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfNode;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfNode�������ڵ㶨�����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfNodeActionBase{
    private static Log logger = LogFactory.getLog(BLSwfNodeActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfNodeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfNodeDto swfNodeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfNodeDto swfNodeDto) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        //�����¼
        dbSwfNode.insert(swfNodeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param modelNo ģ����
     * @param nodeNo �ڵ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int nodeNo) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        //ɾ����¼
        dbSwfNode.delete(modelNo, nodeNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        //������ɾ����¼
        dbSwfNode.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfNodeDto swfNodeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfNodeDto swfNodeDto) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        //���¼�¼
        dbSwfNode.update(swfNodeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param modelNo ģ����
     * @param nodeNo �ڵ���
     * @return swfNodeDto swfNodeDto
     * @throws Exception
     */
    public SwfNodeDto findByPrimaryKey(DBManager dbManager,int modelNo,int nodeNo) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        //����DTO
        SwfNodeDto swfNodeDto = null;
        //��ѯ����,��ֵ��DTO
        swfNodeDto = dbSwfNode.findByPrimaryKey(modelNo, nodeNo);
        return swfNodeDto;
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
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfNode.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfNode.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfNodeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfNode.findByConditions(conditions);
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
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfNode.getCount(conditions);
        return count;
    }
}
