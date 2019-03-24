package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDtypeDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDtype;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdtype��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDtypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDtypeActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDtypeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDtypeDto prpDtypeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDtypeDto prpDtypeDto) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        //�����¼
        dbPrpDtype.insert(prpDtypeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param codeType codetype
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        //ɾ����¼
        dbPrpDtype.delete(codeType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        //������ɾ����¼
        dbPrpDtype.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDtypeDto prpDtypeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDtypeDto prpDtypeDto) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        //���¼�¼
        dbPrpDtype.update(prpDtypeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param codeType codetype
     * @return prpDtypeDto prpDtypeDto
     * @throws Exception
     */
    public PrpDtypeDto findByPrimaryKey(DBManager dbManager,String codeType) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        //����DTO
        PrpDtypeDto prpDtypeDto = null;
        //��ѯ����,��ֵ��DTO
        prpDtypeDto = dbPrpDtype.findByPrimaryKey(codeType);
        return prpDtypeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDtypeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDtype.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDtype.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDtypeDto�ļ���
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
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDtype.getCount(conditions);
        return count;
    }
}
