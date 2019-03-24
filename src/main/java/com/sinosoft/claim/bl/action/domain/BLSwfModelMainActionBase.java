package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfModelMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfModelMain;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfModelMain-ģ��������������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.296<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfModelMainActionBase{
    private static Log logger = LogFactory.getLog(BLSwfModelMainActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfModelMainActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfModelMainDto swfModelMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfModelMainDto swfModelMainDto) throws Exception{
        DBSwfModelMain dbSwfModelMain = new DBSwfModelMain(dbManager);
        //�����¼
        dbSwfModelMain.insert(swfModelMainDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param modelNo ModelNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo) throws Exception{
        DBSwfModelMain dbSwfModelMain = new DBSwfModelMain(dbManager);
        //ɾ����¼
        dbSwfModelMain.delete(modelNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfModelMain dbSwfModelMain = new DBSwfModelMain(dbManager);
        //������ɾ����¼
        dbSwfModelMain.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfModelMainDto swfModelMainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfModelMainDto swfModelMainDto) throws Exception{
        DBSwfModelMain dbSwfModelMain = new DBSwfModelMain(dbManager);
        //���¼�¼
        dbSwfModelMain.update(swfModelMainDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param modelNo ModelNo
     * @return swfModelMainDto swfModelMainDto
     * @throws Exception
     */
    public SwfModelMainDto findByPrimaryKey(DBManager dbManager,int modelNo) throws Exception{
        DBSwfModelMain dbSwfModelMain = new DBSwfModelMain(dbManager);
        //����DTO
        SwfModelMainDto swfModelMainDto = null;
        //��ѯ����,��ֵ��DTO
        swfModelMainDto = dbSwfModelMain.findByPrimaryKey(modelNo);
        return swfModelMainDto;
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
        DBSwfModelMain dbSwfModelMain = new DBSwfModelMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfModelMain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfModelMain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfModelMainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfModelMain dbSwfModelMain = new DBSwfModelMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfModelMain.findByConditions(conditions);
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
        DBSwfModelMain dbSwfModelMain = new DBSwfModelMain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfModelMain.getCount(conditions);
        return count;
    }
}
