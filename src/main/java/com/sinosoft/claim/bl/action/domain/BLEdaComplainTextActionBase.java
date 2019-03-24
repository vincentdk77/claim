package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaComplainTextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBEdaComplainText;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaComplainTextͶ�����ֱ��ҵ���߼�������<br>
 * ������ 2005-08-20 17:56:01.525<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainTextActionBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainTextActionBase.class);

    /**
     * ���캯��
     */
    public BLEdaComplainTextActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,EdaComplainTextDto edaComplainTextDto) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        //�����¼
        dbEdaComplainText.insert(edaComplainTextDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param acceptNo Ͷ�ߵǼǺ�
     * @param textType �ı�����
     * @param serialNo ���
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(DBManager dbManager,double acceptNo,String textType,double serialNo,double lineNo) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        //ɾ����¼
        dbEdaComplainText.delete(acceptNo, textType, serialNo, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        //������ɾ����¼
        dbEdaComplainText.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,EdaComplainTextDto edaComplainTextDto) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        //���¼�¼
        dbEdaComplainText.update(edaComplainTextDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param acceptNo Ͷ�ߵǼǺ�
     * @param textType �ı�����
     * @param serialNo ���
     * @param lineNo �к�
     * @return edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public EdaComplainTextDto findByPrimaryKey(DBManager dbManager,double acceptNo,String textType,double serialNo,double lineNo) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        //����DTO
        EdaComplainTextDto edaComplainTextDto = null;
        //��ѯ����,��ֵ��DTO
        edaComplainTextDto = dbEdaComplainText.findByPrimaryKey(acceptNo, textType, serialNo, lineNo);
        return edaComplainTextDto;
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
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaComplainText.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbEdaComplainText.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����edaComplainTextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbEdaComplainText.findByConditions(conditions);
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
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaComplainText.getCount(conditions);
        return count;
    }
}
