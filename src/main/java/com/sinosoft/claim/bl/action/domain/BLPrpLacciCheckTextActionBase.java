package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciCheckTextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheckText;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLacciCheckText--�����ı���Ϣ���ҵ���߼�������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLacciCheckTextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLacciCheckTextActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLacciCheckTextActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLacciCheckTextDto prpLacciCheckTextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLacciCheckTextDto prpLacciCheckTextDto) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        //�����¼
        dbPrpLacciCheckText.insert(prpLacciCheckTextDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param checkNo �����
     * @param textType ����˵������
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String checkNo,String textType,long lineNo) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        //ɾ����¼
        dbPrpLacciCheckText.delete(checkNo, textType, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        //������ɾ����¼
        dbPrpLacciCheckText.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLacciCheckTextDto prpLacciCheckTextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLacciCheckTextDto prpLacciCheckTextDto) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        //���¼�¼
        dbPrpLacciCheckText.update(prpLacciCheckTextDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param checkNo �����
     * @param textType ����˵������
     * @param lineNo �к�
     * @return prpLacciCheckTextDto prpLacciCheckTextDto
     * @throws Exception
     */
    public PrpLacciCheckTextDto findByPrimaryKey(DBManager dbManager,String checkNo,String textType,long lineNo) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        //����DTO
        PrpLacciCheckTextDto prpLacciCheckTextDto = null;
        //��ѯ����,��ֵ��DTO
        prpLacciCheckTextDto = dbPrpLacciCheckText.findByPrimaryKey(checkNo, textType, lineNo);
        return prpLacciCheckTextDto;
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
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLacciCheckText.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLacciCheckText.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLacciCheckTextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLacciCheckText.findByConditions(conditions);
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
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLacciCheckText.getCount(conditions);
        return count;
    }
}
