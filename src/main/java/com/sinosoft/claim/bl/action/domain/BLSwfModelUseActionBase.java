package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfModelUse;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfModelUseģ��ʹ�����ã���������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.296<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfModelUseActionBase{
    private static Log logger = LogFactory.getLog(BLSwfModelUseActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfModelUseActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfModelUseDto swfModelUseDto) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //�����¼
        dbSwfModelUse.insert(swfModelUseDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param modelNo ģ����
     * @param riskCode ���ִ���
     * @param comCode ���ű���
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,String riskCode,String comCode) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //ɾ����¼
        dbSwfModelUse.delete(modelNo, riskCode, comCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //������ɾ����¼
        dbSwfModelUse.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfModelUseDto swfModelUseDto) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //���¼�¼
        dbSwfModelUse.update(swfModelUseDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param modelNo ģ����
     * @param riskCode ���ִ���
     * @param comCode ���ű���
     * @return swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public SwfModelUseDto findByPrimaryKey(DBManager dbManager,int modelNo,String riskCode,String comCode) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //����DTO
        SwfModelUseDto swfModelUseDto = null;
        //��ѯ����,��ֵ��DTO
        swfModelUseDto = dbSwfModelUse.findByPrimaryKey(modelNo, riskCode, comCode);
        return swfModelUseDto;
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
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfModelUse.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfModelUse.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfModelUseDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfModelUse.findByConditions(conditions);
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
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfModelUse.getCount(conditions);
        return count;
    }
}
