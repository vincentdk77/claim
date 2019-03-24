package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDlimitDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDlimit;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdlimit��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDlimitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDlimitActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDlimitActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDlimitDto prpDlimitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDlimitDto prpDlimitDto) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //�����¼
        dbPrpDlimit.insert(prpDlimitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param limitCode limitcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String limitCode) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //ɾ����¼
        dbPrpDlimit.delete(riskCode, limitCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //������ɾ����¼
        dbPrpDlimit.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDlimitDto prpDlimitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDlimitDto prpDlimitDto) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //���¼�¼
        dbPrpDlimit.update(prpDlimitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param limitCode limitcode
     * @return prpDlimitDto prpDlimitDto
     * @throws Exception
     */
    public PrpDlimitDto findByPrimaryKey(DBManager dbManager,String riskCode,String limitCode) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //����DTO
        PrpDlimitDto prpDlimitDto = null;
        //��ѯ����,��ֵ��DTO
        prpDlimitDto = dbPrpDlimit.findByPrimaryKey(riskCode, limitCode);
        return prpDlimitDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDlimitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDlimit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDlimit.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDlimitDto�ļ���
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
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDlimit.getCount(conditions);
        return count;
    }
}
