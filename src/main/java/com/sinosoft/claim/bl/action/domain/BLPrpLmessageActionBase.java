package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLmessage;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLmessage������ת�������Ա��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLmessageActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLmessageActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLmessageActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLmessageDto prpLmessageDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLmessageDto prpLmessageDto) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        //�����¼
        dbPrpLmessage.insert(prpLmessageDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,int lineNo) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        //ɾ����¼
        dbPrpLmessage.delete(registNo, serialNo, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        //������ɾ����¼
        dbPrpLmessage.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLmessageDto prpLmessageDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLmessageDto prpLmessageDto) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        //���¼�¼
        dbPrpLmessage.update(prpLmessageDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @param lineNo �к�
     * @return prpLmessageDto prpLmessageDto
     * @throws Exception
     */
    public PrpLmessageDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,int lineNo) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        //����DTO
        PrpLmessageDto prpLmessageDto = null;
        //��ѯ����,��ֵ��DTO
        prpLmessageDto = dbPrpLmessage.findByPrimaryKey(registNo, serialNo, lineNo);
        return prpLmessageDto;
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
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLmessage.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLmessage.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLmessageDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLmessage.findByConditions(conditions);
        return collection;
    }
    /**
     * ��������ѯ��������(�������Ľӿ�ʹ�ã�������������Ϊ(yyyy-mm-dd hh24:mi:ss))
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLmessageDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions1(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLmessage.findByConditions1(conditions);
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
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLmessage.getCount(conditions);
        return count;
    }
}
