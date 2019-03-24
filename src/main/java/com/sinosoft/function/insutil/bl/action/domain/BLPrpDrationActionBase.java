package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrationDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDration;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdration��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrationActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrationActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDrationActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDrationDto prpDrationDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDrationDto prpDrationDto) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        //�����¼
        dbPrpDration.insert(prpDrationDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param rationType rationtype
     * @param itemCode itemcode
     * @param kindCode kindcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String rationType,String itemCode,String kindCode) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        //ɾ����¼
        dbPrpDration.delete(riskCode, rationType, itemCode, kindCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        //������ɾ����¼
        dbPrpDration.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDrationDto prpDrationDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDrationDto prpDrationDto) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        //���¼�¼
        dbPrpDration.update(prpDrationDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param rationType rationtype
     * @param itemCode itemcode
     * @param kindCode kindcode
     * @return prpDrationDto prpDrationDto
     * @throws Exception
     */
    public PrpDrationDto findByPrimaryKey(DBManager dbManager,String riskCode,String rationType,String itemCode,String kindCode) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        //����DTO
        PrpDrationDto prpDrationDto = null;
        //��ѯ����,��ֵ��DTO
        prpDrationDto = dbPrpDration.findByPrimaryKey(riskCode, rationType, itemCode, kindCode);
        return prpDrationDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDrationDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDration.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDration.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDrationDto�ļ���
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
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDration.getCount(conditions);
        return count;
    }
}
