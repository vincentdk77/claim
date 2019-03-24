package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPath;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfPath������·���������������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfPathActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPathActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfPathActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfPathDto swfPathDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfPathDto swfPathDto) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        //�����¼
        dbSwfPath.insert(swfPathDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param modelNo ģ����
     * @param pathNo �̱ߺ�
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int pathNo) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        //ɾ����¼
        dbSwfPath.delete(modelNo, pathNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        //������ɾ����¼
        dbSwfPath.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfPathDto swfPathDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfPathDto swfPathDto) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        //���¼�¼
        dbSwfPath.update(swfPathDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param modelNo ģ����
     * @param pathNo �̱ߺ�
     * @return swfPathDto swfPathDto
     * @throws Exception
     */
    public SwfPathDto findByPrimaryKey(DBManager dbManager,int modelNo,int pathNo) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        //����DTO
        SwfPathDto swfPathDto = null;
        //��ѯ����,��ֵ��DTO
        swfPathDto = dbSwfPath.findByPrimaryKey(modelNo, pathNo);
        return swfPathDto;
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
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPath.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfPath.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfPathDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfPath.findByConditions(conditions);
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
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPath.getCount(conditions);
        return count;
    }
}
