package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDdbsDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDdbs;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpddbs��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDdbsActionBase{
    private static Log log = LogFactory.getLog(BLPrpDdbsActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDdbsActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDdbsDto prpDdbsDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDdbsDto prpDdbsDto) throws Exception{
        DBPrpDdbs dbPrpDdbs = new DBPrpDdbs(dbManager);
        //�����¼
        dbPrpDdbs.insert(prpDdbsDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param comCode comcode
     * @param riskCode riskcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comCode,String riskCode) throws Exception{
        DBPrpDdbs dbPrpDdbs = new DBPrpDdbs(dbManager);
        //ɾ����¼
        dbPrpDdbs.delete(comCode, riskCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDdbs dbPrpDdbs = new DBPrpDdbs(dbManager);
        //������ɾ����¼
        dbPrpDdbs.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDdbsDto prpDdbsDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDdbsDto prpDdbsDto) throws Exception{
        DBPrpDdbs dbPrpDdbs = new DBPrpDdbs(dbManager);
        //���¼�¼
        dbPrpDdbs.update(prpDdbsDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param comCode comcode
     * @param riskCode riskcode
     * @return prpDdbsDto prpDdbsDto
     * @throws Exception
     */
    public PrpDdbsDto findByPrimaryKey(DBManager dbManager,String comCode,String riskCode) throws Exception{
        DBPrpDdbs dbPrpDdbs = new DBPrpDdbs(dbManager);
        //����DTO
        PrpDdbsDto prpDdbsDto = null;
        //��ѯ����,��ֵ��DTO
        prpDdbsDto = dbPrpDdbs.findByPrimaryKey(comCode, riskCode);
        return prpDdbsDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDdbsDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDdbs dbPrpDdbs = new DBPrpDdbs(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDdbs.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDdbs.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDdbsDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getCount(){
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDdbs dbPrpDdbs = new DBPrpDdbs(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDdbs.getCount(conditions);
        return count;
    }
}
