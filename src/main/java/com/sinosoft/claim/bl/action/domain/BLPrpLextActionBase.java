package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLext;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLext��ҵ���߼�������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLextActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLextActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLextDto prpLextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLextDto prpLextDto) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        //�����¼
        dbPrpLext.insert(prpLextDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param certiNo ����
     * @param certiType ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,String certiType) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        //ɾ����¼
        dbPrpLext.delete(certiNo, certiType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        //������ɾ����¼
        dbPrpLext.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLextDto prpLextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLextDto prpLextDto) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        //���¼�¼
        dbPrpLext.update(prpLextDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param certiNo ����
     * @param certiType ��������
     * @return prpLextDto prpLextDto
     * @throws Exception
     */
    public PrpLextDto findByPrimaryKey(DBManager dbManager,String certiNo,String certiType) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        //����DTO
        PrpLextDto prpLextDto = null;
        //��ѯ����,��ֵ��DTO
        prpLextDto = dbPrpLext.findByPrimaryKey(certiNo, certiType);
        return prpLextDto;
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
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLext.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLext.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLext.findByConditions(conditions);
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
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLext.getCount(conditions);
        return count;
    }
}
