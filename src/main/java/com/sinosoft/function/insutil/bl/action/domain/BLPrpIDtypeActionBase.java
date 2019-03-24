package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpIDtypeDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpIDtype;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpidtype��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpIDtypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpIDtypeActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpIDtypeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpIDtypeDto prpIDtypeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpIDtypeDto prpIDtypeDto) throws Exception{
        DBPrpIDtype dbPrpIDtype = new DBPrpIDtype(dbManager);
        //�����¼
        dbPrpIDtype.insert(prpIDtypeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param codeType codetype
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType) throws Exception{
        DBPrpIDtype dbPrpIDtype = new DBPrpIDtype(dbManager);
        //ɾ����¼
        dbPrpIDtype.delete(codeType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpIDtype dbPrpIDtype = new DBPrpIDtype(dbManager);
        //������ɾ����¼
        dbPrpIDtype.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpIDtypeDto prpIDtypeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpIDtypeDto prpIDtypeDto) throws Exception{
        DBPrpIDtype dbPrpIDtype = new DBPrpIDtype(dbManager);
        //���¼�¼
        dbPrpIDtype.update(prpIDtypeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param codeType codetype
     * @return prpIDtypeDto prpIDtypeDto
     * @throws Exception
     */
    public PrpIDtypeDto findByPrimaryKey(DBManager dbManager,String codeType) throws Exception{
        DBPrpIDtype dbPrpIDtype = new DBPrpIDtype(dbManager);
        //����DTO
        PrpIDtypeDto prpIDtypeDto = null;
        //��ѯ����,��ֵ��DTO
        prpIDtypeDto = dbPrpIDtype.findByPrimaryKey(codeType);
        return prpIDtypeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpIDtypeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpIDtype dbPrpIDtype = new DBPrpIDtype(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpIDtype.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpIDtype.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpIDtypeDto�ļ���
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
        DBPrpIDtype dbPrpIDtype = new DBPrpIDtype(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpIDtype.getCount(conditions);
        return count;
    }
}
