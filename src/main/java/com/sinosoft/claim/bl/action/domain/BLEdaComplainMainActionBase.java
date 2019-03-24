package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaComplainMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBEdaComplainMain;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaComplainMainͶ����Ϣ���ҵ���߼�������<br>
 * ������ 2005-08-20 17:56:01.505<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainMainActionBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainMainActionBase.class);

    /**
     * ���캯��
     */
    public BLEdaComplainMainActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,EdaComplainMainDto edaComplainMainDto) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        //�����¼
        dbEdaComplainMain.insert(edaComplainMainDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param acceptNo Ͷ�ߵǼǺ�
     * @throws Exception
     */
    public void delete(DBManager dbManager,int acceptNo) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        //ɾ����¼
        dbEdaComplainMain.delete(acceptNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        //������ɾ����¼
        dbEdaComplainMain.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,EdaComplainMainDto edaComplainMainDto) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        //���¼�¼
        dbEdaComplainMain.update(edaComplainMainDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param acceptNo Ͷ�ߵǼǺ�
     * @return edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public EdaComplainMainDto findByPrimaryKey(DBManager dbManager,int acceptNo) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        //����DTO
        EdaComplainMainDto edaComplainMainDto = null;
        //��ѯ����,��ֵ��DTO
        edaComplainMainDto = dbEdaComplainMain.findByPrimaryKey(acceptNo);
        return edaComplainMainDto;
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
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaComplainMain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbEdaComplainMain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����edaComplainMainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbEdaComplainMain.findByConditions(conditions);
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
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaComplainMain.getCount(conditions);
        return count;
    }
}
