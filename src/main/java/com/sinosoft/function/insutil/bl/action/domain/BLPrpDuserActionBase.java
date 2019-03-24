package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDuserDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDuser;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpduser��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDuserActionBase{
    private static Log log = LogFactory.getLog(BLPrpDuserActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDuserActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDuserDto prpDuserDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDuserDto prpDuserDto) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //�����¼
        dbPrpDuser.insert(prpDuserDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param userCode usercode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String userCode) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //ɾ����¼
        dbPrpDuser.delete(userCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //������ɾ����¼
        dbPrpDuser.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDuserDto prpDuserDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDuserDto prpDuserDto) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //���¼�¼
        dbPrpDuser.update(prpDuserDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param userCode usercode
     * @return prpDuserDto prpDuserDto
     * @throws Exception
     */
    public PrpDuserDto findByPrimaryKey(DBManager dbManager,String userCode) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //����DTO
        PrpDuserDto prpDuserDto = null;
        //��ѯ����,��ֵ��DTO
        prpDuserDto = dbPrpDuser.findByPrimaryKey(userCode);
        return prpDuserDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDuserDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDuser.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDuser.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDuserDto�ļ���
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
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDuser.getCount(conditions);
        return count;
    }
}
