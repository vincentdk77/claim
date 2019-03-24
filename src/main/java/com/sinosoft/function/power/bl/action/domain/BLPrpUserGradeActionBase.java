package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpUserGradeDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpUserGrade;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpUserGrade Ա��Ȩ�ޱ��ҵ���߼�������<br>
 * ������ 2004-11-09 10:40:54.658<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUserGradeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpUserGradeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpUserGradeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpUserGradeDto prpUserGradeDto) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //�����¼
        dbPrpUserGrade.insert(prpUserGradeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param userCode Ա������
     * @param groupCode Ȩ����Ŵ���
     * @param taskCode �������
     * @param checkCode Ȩ�޼������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //ɾ����¼
        dbPrpUserGrade.delete(userCode, groupCode, taskCode, checkCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //������ɾ����¼
        dbPrpUserGrade.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpUserGradeDto prpUserGradeDto) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //���¼�¼
        dbPrpUserGrade.update(prpUserGradeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param userCode Ա������
     * @param groupCode Ȩ����Ŵ���
     * @param taskCode �������
     * @param checkCode Ȩ�޼������
     * @return prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public PrpUserGradeDto findByPrimaryKey(DBManager dbManager,String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //����DTO
        PrpUserGradeDto prpUserGradeDto = null;
        //��ѯ����,��ֵ��DTO
        prpUserGradeDto = dbPrpUserGrade.findByPrimaryKey(userCode, groupCode, taskCode, checkCode);
        return prpUserGradeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpUserGrade.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpUserGrade.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpUserGradeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpUserGrade.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpUserGrade.getCount(conditions);
        return count;
    }
}
