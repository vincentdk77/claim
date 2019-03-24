package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.EndorseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPcoins;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPcoinsDetail;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPengage;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPfee;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPhead;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPitemCar;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPitemKind;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPmain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPprofit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPtext;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �������ݿ�������
 * <p>Title: ���������������ݹ���</p>
 * <p>Description: ���������������ݹ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class DBEndorse
{

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBEndorse()
  {

  }

  /*
   * ������ѯ����
   *@param endorseDto ��������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public EndorseDto findByPrimaryKey(DBManager dbManager,String endorseNo)
    throws SQLException,Exception
  {
     EndorseDto endorseDto = new EndorseDto();
     //ȡ���永����
     endorseDto.setPrpPheadDto(new DBPrpPhead(dbManager).findByPrimaryKey(endorseNo));
     endorseDto.setPrpPmainDto(new DBPrpPmain(dbManager).findByPrimaryKey(endorseNo));
     String conditions = " endorseNo = '" + endorseNo + "'";
     endorseDto.setPrpPitemKindDtoList((ArrayList)new DBPrpPitemKind(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPtextDtoList((ArrayList)new DBPrpPtext(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPitem_carDtoList((ArrayList)new DBPrpPitemCar(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPfeeDtoList((ArrayList)new DBPrpPfee(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPprofitDtoList((ArrayList)new DBPrpPprofit(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPengageDtoList((ArrayList)new DBPrpPengage(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPCoinsDtoList((ArrayList)new DBPrpPcoins(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPCoinsDetailDtoList((ArrayList)new DBPrpPcoinsDetail(dbManager).findByConditions(conditions,0,0));
     return endorseDto;
  }

  /*
   * ������ѯ����
   *@param endorseDto ��������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public EndorseDto findByConditions(DBManager dbManager,String policyNo)
    throws SQLException,Exception
  {
     EndorseDto endorseDto = new EndorseDto();
     String conditions = " policyNo = '" + policyNo + "'";
     //ȡ���永����
     endorseDto.setPrpPheadDtoList((ArrayList)new DBPrpPhead(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPmainDtoList((ArrayList)new DBPrpPmain(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPitemKindDtoList((ArrayList)new DBPrpPitemKind(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPtextDtoList((ArrayList)new DBPrpPtext(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPCoinsDtoList((ArrayList)new DBPrpPcoins(dbManager).findByConditions(conditions,0,0));
     endorseDto.setPrpPCoinsDetailDtoList((ArrayList)new DBPrpPcoinsDetail(dbManager).findByConditions(conditions,0,0));
     return endorseDto;
  }
}


