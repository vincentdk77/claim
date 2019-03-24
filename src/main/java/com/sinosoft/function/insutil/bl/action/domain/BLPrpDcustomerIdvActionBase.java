package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcustomerIdvDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDcustomerIdv;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcustomeridv��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:19<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerIdvActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerIdvActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDcustomerIdvActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDcustomerIdvDto prpDcustomerIdvDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        //�����¼
        dbPrpDcustomerIdv.insert(prpDcustomerIdvDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param customerCode customercode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        //ɾ����¼
        dbPrpDcustomerIdv.delete(customerCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        //������ɾ����¼
        dbPrpDcustomerIdv.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDcustomerIdvDto prpDcustomerIdvDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        //���¼�¼
        dbPrpDcustomerIdv.update(prpDcustomerIdvDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param customerCode customercode
     * @return prpDcustomerIdvDto prpDcustomerIdvDto
     * @throws Exception
     */
    public PrpDcustomerIdvDto findByPrimaryKey(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        //����DTO
        PrpDcustomerIdvDto prpDcustomerIdvDto = null;
        //��ѯ����,��ֵ��DTO
        prpDcustomerIdvDto = dbPrpDcustomerIdv.findByPrimaryKey(customerCode);
        return prpDcustomerIdvDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDcustomerIdvDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDcustomerIdv.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDcustomerIdv.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDcustomerIdvDto�ļ���
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
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcustomerIdv.getCount(conditions);
        return count;
    }
}
