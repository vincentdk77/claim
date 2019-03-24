package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsDslistDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLQsDslist;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLQs_Dslist����ͨ�������ϸ�嵥���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsDslistActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsDslistActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpLQsDslistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLQs_DslistDto prpLQs_DslistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLQsDslistDto prpLQs_DslistDto) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        //�����¼
        dbPrpLQs_Dslist.insert(prpLQs_DslistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param procNo ���㵥���κ�
     * @param serialNo ���ν���˳���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String procNo,int serialNo) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        //ɾ����¼
        dbPrpLQs_Dslist.delete(procNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        //������ɾ����¼
        dbPrpLQs_Dslist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLQs_DslistDto prpLQs_DslistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLQsDslistDto prpLQs_DslistDto) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        //���¼�¼
        dbPrpLQs_Dslist.update(prpLQs_DslistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param procNo ���㵥���κ�
     * @param serialNo ���ν���˳���
     * @return prpLQs_DslistDto prpLQs_DslistDto
     * @throws Exception
     */
    public PrpLQsDslistDto findByPrimaryKey(DBManager dbManager,String procNo,int serialNo) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        //����DTO
        PrpLQsDslistDto prpLQs_DslistDto = null;
        //��ѯ����,��ֵ��DTO
        prpLQs_DslistDto = dbPrpLQs_Dslist.findByPrimaryKey(procNo, serialNo);
        return prpLQs_DslistDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpLQs_DslistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLQs_Dslist.getCount(conditions);
        collection = dbPrpLQs_Dslist.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLQs_Dslist.getCount(conditions);
        return count;
    }
}
