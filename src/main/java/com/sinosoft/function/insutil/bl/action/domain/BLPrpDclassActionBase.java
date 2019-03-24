package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDclassDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDclass;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdclass��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDclassActionBase{
    private static Log log = LogFactory.getLog(BLPrpDclassActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDclassActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDclassDto prpDclassDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDclassDto prpDclassDto) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        //�����¼
        dbPrpDclass.insert(prpDclassDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param classCode classcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String classCode) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        //ɾ����¼
        dbPrpDclass.delete(classCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        //������ɾ����¼
        dbPrpDclass.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDclassDto prpDclassDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDclassDto prpDclassDto) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        //���¼�¼
        dbPrpDclass.update(prpDclassDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param classCode classcode
     * @return prpDclassDto prpDclassDto
     * @throws Exception
     */
    public PrpDclassDto findByPrimaryKey(DBManager dbManager,String classCode) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        //����DTO
        PrpDclassDto prpDclassDto = null;
        //��ѯ����,��ֵ��DTO
        prpDclassDto = dbPrpDclass.findByPrimaryKey(classCode);
        return prpDclassDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDclassDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDclass.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDclass.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDclassDto�ļ���
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
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDclass.getCount(conditions);
        return count;
    }
}
