package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdealinfoDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdealinfo;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpldealinfo��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLdealinfoActionBase{
    private static Log log = LogFactory.getLog(BLPrpLdealinfoActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpLdealinfoActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLdealinfoDto prpLdealinfoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLdealinfoDto prpLdealinfoDto) throws Exception{
        DBPrpLdealinfo dbPrpLdealinfo = new DBPrpLdealinfo(dbManager);
        //�����¼
        dbPrpLdealinfo.insert(prpLdealinfoDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo) throws Exception{
        DBPrpLdealinfo dbPrpLdealinfo = new DBPrpLdealinfo(dbManager);
        //ɾ����¼
        dbPrpLdealinfo.delete(registNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLdealinfo dbPrpLdealinfo = new DBPrpLdealinfo(dbManager);
        //������ɾ����¼
        dbPrpLdealinfo.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLdealinfoDto prpLdealinfoDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLdealinfoDto prpLdealinfoDto) throws Exception{
        DBPrpLdealinfo dbPrpLdealinfo = new DBPrpLdealinfo(dbManager);
        //���¼�¼
        dbPrpLdealinfo.update(prpLdealinfoDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @return prpLdealinfoDto prpLdealinfoDto
     * @throws Exception
     */
    public PrpLdealinfoDto findByPrimaryKey(DBManager dbManager,String registNo) throws Exception{
        DBPrpLdealinfo dbPrpLdealinfo = new DBPrpLdealinfo(dbManager);
        //����DTO
        PrpLdealinfoDto prpLdealinfoDto = null;
        //��ѯ����,��ֵ��DTO
        prpLdealinfoDto = dbPrpLdealinfo.findByPrimaryKey(registNo);
        return prpLdealinfoDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpLdealinfoDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLdealinfo dbPrpLdealinfo = new DBPrpLdealinfo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLdealinfo.getCount(conditions);
        collection = dbPrpLdealinfo.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLdealinfo dbPrpLdealinfo = new DBPrpLdealinfo(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLdealinfo.getCount(conditions);
        return count;
    }
}
