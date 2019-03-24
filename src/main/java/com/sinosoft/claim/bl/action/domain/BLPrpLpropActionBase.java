package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprop;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLprop-�Ʋ��˶�����ϸ�嵥��(�޸�)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.062<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpropActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpropActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpropActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpropDto prpLpropDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpropDto prpLpropDto) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        //�����¼
        dbPrpLprop.insert(prpLpropDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param serialNo ���
     * @param registNo ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,int serialNo,String registNo) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        //ɾ����¼
        dbPrpLprop.delete(serialNo, registNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        //������ɾ����¼
        dbPrpLprop.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpropDto prpLpropDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpropDto prpLpropDto) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        //���¼�¼
        dbPrpLprop.update(prpLpropDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serialNo ���
     * @param registNo ��������
     * @return prpLpropDto prpLpropDto
     * @throws Exception
     */
    public PrpLpropDto findByPrimaryKey(DBManager dbManager,int serialNo,String registNo) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        //����DTO
        PrpLpropDto prpLpropDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpropDto = dbPrpLprop.findByPrimaryKey(serialNo, registNo);
        return prpLpropDto;
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
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprop.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLprop.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpropDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLprop.findByConditions(conditions);
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
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprop.getCount(conditions);
        return count;
    }
}
