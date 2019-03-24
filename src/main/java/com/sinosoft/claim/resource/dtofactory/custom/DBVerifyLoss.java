package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcarLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcomponent;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLperson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonWound;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprop;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrepairFee;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLossExt;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;

/**
 * �������ݿ�������
 * <p>Title: �������ⶨ�����ݹ���</p>
 * <p>Description: �������ⶨ�����ݹ���</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBVerifyLoss
{
  private DBManager dbManager = null; //��Դ������

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */ 
  public DBVerifyLoss()
  {

  }

  /**
   * ���𱣴淽��
   *@param verifyLossDto �������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,VerifyLossDto verifyLossDto)
    throws SQLException,Exception
  {

    if (verifyLossDto.getPrpLverifyLossDto() ==null)
    {
             throw new Exception();
    }
    PrpLclaimStatusDto prpLclaimStatusDto=verifyLossDto.getPrpLclaimStatusDto();

    PrpLverifyLossDto prpLverifyLossDto = verifyLossDto.getPrpLverifyLossDto();

    //�������� �ؼ���
    String registNo = prpLverifyLossDto.getRegistNo();
    String lossItemCode = prpLverifyLossDto.getLossItemCode();
    //����ɾ��ԭ����������� 
    deleteSubInfo(dbManager,registNo,lossItemCode);

    new DBPrpLverifyLoss(dbManager).insert(verifyLossDto.getPrpLverifyLossDto());
    //��������
    if(verifyLossDto.getPrpLcarLossDtoList()!=null)
    {
       new DBPrpLcarLoss(dbManager).insertAll(verifyLossDto.getPrpLcarLossDtoList());
    }
    //��������嵥
    if(verifyLossDto.getPrpLrepairFeeDtoList()!=null)
    {
       new DBPrpLrepairFee(dbManager).insertAll(verifyLossDto.getPrpLrepairFeeDtoList());
    }
    //������Ŀ�嵥
    if(verifyLossDto.getPrpLcomponentDtoList()!=null)
    {
       new DBPrpLcomponent(dbManager).insertAll(verifyLossDto.getPrpLcomponentDtoList());
    }
    //��Ա������ϸ��Ϣ��
    if(verifyLossDto.getPrpLpersonDtoList()!=null)
    {
       new DBPrpLperson(dbManager).insertAll(verifyLossDto.getPrpLpersonDtoList());
    }
    //�Ʋ��˶�����ϸ�嵥��
    if(verifyLossDto.getPrpLpropDtoList()!=null)
    {
       new DBPrpLprop(dbManager).insertAll(verifyLossDto.getPrpLpropDtoList());
    }
    //���������ı�
    /*
    if(verifyLossDto.getPrpLverifyLossItemDtoList()!=null&&verifyLossDto.getPrpLverifyLossItemDtoList().size()>0){
      new DBPrpLverifyLossItem(dbManager).insertAll(verifyLossDto.getPrpLverifyLossItemDtoList());
    }*/
    //������Ϣ��
    if(verifyLossDto.getPrpLpersonWoundDtoList()!=null&&verifyLossDto.getPrpLpersonWoundDtoList().size()>0){
      new DBPrpLpersonWound(dbManager).insertAll(verifyLossDto.getPrpLpersonWoundDtoList());
    }
    //System.err.println("size3:"+ verifyLossDto.getPrplCompensateHouseDtoList().size());
    if(verifyLossDto.getPrplCompensateHouseDtoList()!=null && verifyLossDto.getPrplCompensateHouseDtoList().size() > 0)
    {
        PrplcompensatehouseDto PrplcompensatehouseDto = (PrplcompensatehouseDto)verifyLossDto.getPrplCompensateHouseDtoList().get(0);
		String registno = PrplcompensatehouseDto.getRegistno();
		String nodetype = PrplcompensatehouseDto.getNodetype();
		String condition = " registno='" + registno + "' and nodetype='" + nodetype + "'";
		new DBPrplcompensatehouse(dbManager).deleteByConditions(condition);
        new DBPrplcompensatehouse(dbManager).insertAll(verifyLossDto.getPrplCompensateHouseDtoList());
    }
    //��������չ��Ϣ 
    if(verifyLossDto.getPrpLverifyLossExtDtoList()!=null)
    {
       new DBPrpLverifyLossExt(dbManager).insertAll(verifyLossDto.getPrpLverifyLossExtDtoList());
    }
    //��չ��Ϣ 
    if(verifyLossDto.getPrpLregistExtDtoList()!=null)
    {
       new DBPrpLregistExt(dbManager).insertAll(verifyLossDto.getPrpLregistExtDtoList());
    }
    //����״̬�ĸı�
    updateClaimStatus(dbManager,verifyLossDto);
  }

  /**
   * ����ɾ���ӱ���Ϣ
   * @param registNo //������
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    String condition = " registNo = " + "'" + registNo.trim() + "'";
    //ʾ��δ���
    String statement = "";
    //��������嵥
    statement = " DELETE FROM prpLrepairFee Where " + condition;
    dbManager.executeUpdate(statement);
    //������Ŀ�嵥
    statement = " DELETE FROM prpLcomponent Where " + condition;
    dbManager.executeUpdate(statement);
    //��Ա������ϸ��Ϣ
    statement = " DELETE FROM prpLperson Where " + condition;
    dbManager.executeUpdate(statement);
    //�Ʋ��˶�����ϸ
    statement = " DELETE FROM prpLprop Where " + condition;
    dbManager.executeUpdate(statement);
    //��������
    statement = " DELETE FROM prpLcarLoss Where " + condition;
    dbManager.executeUpdate(statement);

    //������Ϣ��
    statement = " DELETE FROM PrpLpersonWound Where " + condition;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM PrpLverifyLoss Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /**
   * ����ɾ���ӱ���Ϣ
   * @param registNo //������
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,String registNo,String lossItemCode)
    throws SQLException,Exception
  {
    String condition = " registNo = " + "'" + registNo.trim() + "'  ";
    String condition1 = " registNo = " + "'" + registNo.trim() + "' and  lossItemCode ='" + lossItemCode + "'";
    //ʾ��δ���
    String statement = ""; 
    //ɾ����������չ��Ϣ
    statement =  " DELETE FROM PrpLverifyLossExt Where " + condition1;
    dbManager.executeUpdate(statement);
    //ɾ����չ��Ϣ
    statement =  " DELETE FROM PrpLregistExt Where " + condition;
    dbManager.executeUpdate(statement);

    int i = Integer.parseInt(DataUtils.nullToZero(lossItemCode));
    if(i > 0){
      //condition = condition + " and LossItemCode='"+lossItemCode+"'";
      //��������嵥
      statement = " DELETE FROM prpLrepairFee Where " + condition + " and LossItemCode='"+lossItemCode+"'";
      dbManager.executeUpdate(statement);
      //������Ŀ�嵥
      statement = " DELETE FROM prpLcomponent Where " + condition + " and LossItemCode='"+lossItemCode+"'";
      dbManager.executeUpdate(statement);
      //��������
      statement = " DELETE FROM prpLcarLoss Where " + condition + " and LossItemCode='"+lossItemCode+"'";
      dbManager.executeUpdate(statement);
    }else if(i == 0){
      //��Ա������ϸ��Ϣ
      statement = " DELETE FROM prpLperson Where " + condition;
      dbManager.executeUpdate(statement);
      //������Ϣ��
      statement = " DELETE FROM PrpLpersonWound Where " + condition;
      dbManager.executeUpdate(statement);

    }else if(i == -1){
      //�Ʋ��˶�����ϸ
      statement = " DELETE FROM prpLprop Where " + condition;
      dbManager.executeUpdate(statement);
    }else if(i == -2){
      // �Ʋ��˶�����ϸ
        statement = " DELETE FROM prpLprop Where " + condition;
        dbManager.executeUpdate(statement);
    }
      //modify by liujianbo modify 20050315 start
      //reason:���������� 
      /*
      if(i==1){
        statement = " DELETE FROM prpLprop Where " + condition;
        dbManager.executeUpdate(statement);
      }
    */
      //modify by liujianbo modify 20050315 end
    //statement = " DELETE FROM PrpLverifyLossitem Where " + condition +" and serialNo="+lossItemCode;
    //statement = " DELETE FROM PrpLverifyLossitem Where " + condition;
    //dbManager.executeUpdate(statement);

   
    condition = condition + " and LossItemCode='"+lossItemCode+"'";
    statement = " DELETE FROM PrpLverifyLoss Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /**
   * ����ɾ��
   * @param verifyLossNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo,String nodeType)
    throws SQLException,Exception
{
  String condition = " registNo = " + "'" + registNo.trim() + "'";
  String condition1 = " businessNo = " + "'" + registNo.trim() + "' AND NodeType ='" + nodeType.trim() + "'";
  //ʾ��δ���
  String statement = "";
  //��������嵥
  statement = " DELETE FROM prpLrepairFee Where " + condition;
  dbManager.executeUpdate(statement);
  //������Ŀ�嵥
  statement = " DELETE FROM prpLcomponent Where " + condition;
  dbManager.executeUpdate(statement);
  //��Ա������ϸ��Ϣ
  statement = " DELETE FROM prpLperson Where " + condition;
  dbManager.executeUpdate(statement);
  //�Ʋ��˶�����ϸ
  statement = " DELETE FROM prpLprop Where " + condition;
  dbManager.executeUpdate(statement);
  //��������
  statement = " DELETE FROM prpLcarLoss Where " + condition;
  dbManager.executeUpdate(statement);
  //״̬
  statement = " DELETE FROM prplclaimstatus Where " + condition1;
  dbManager.executeUpdate(statement);
  //��������
  statement = " DELETE FROM PrpLverifyLoss Where " + condition;
  dbManager.executeUpdate(statement);

}

  /**
	 * �������Ĳ���״̬�ķ���
	 * 
	 * @param verifyLossDto
	 *            ��������
	 * @throws SQLException
	 * @throws Exception
	 * @return ��
	 */
	public void updateClaimStatus(DBManager dbManager,
			VerifyLossDto verifyLossDto) throws SQLException, Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// ʾ��δ���
		String statement = "";
		String riskCode = verifyLossDto.getPrpLverifyLossDto().getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		if (!strRiskType.equals("H")) {
			if (verifyLossDto.getPrpLclaimStatusDto() != null) {
				// ���Ƿ�����Ҫ��д�ģ���ɾ���˰�
				String condition3 = " BusinessNo='"
						+ verifyLossDto.getPrpLclaimStatusDto().getBusinessNo()
								.trim()
						+ "' "
						+ " and nodeType='"
						+ verifyLossDto.getPrpLclaimStatusDto().getNodeType()
								.trim() + "' " + " AND serialNo="
						+ verifyLossDto.getPrpLclaimStatusDto().getSerialNo();

				statement = " DELETE FROM prpLclaimStatus Where " + condition3;
				dbManager.executeUpdate(statement);
				new DBPrpLclaimStatus(dbManager).insert(verifyLossDto
						.getPrpLclaimStatusDto());
			}
		}
	}

  /*
   * �����ѯ����
   *@param verifyLossDto �������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */

  public VerifyLossDto findByPrimaryKey(DBManager dbManager,String registNo,String lossItemCode,String nodeType)
    throws SQLException,Exception
  {

     String conditions = " registNo = '"+registNo+"'"; 
     String conditions1 = " registNo = '"+registNo+"' AND LossItemCode='"+lossItemCode+"'";
     String conditions2 = "registNo = '"+ registNo +"' order by personNo";
     VerifyLossDto verifyLossDto = new VerifyLossDto();
     
     verifyLossDto.setPrpLverifyLossExtDtoList((ArrayList)new DBPrpLverifyLossExt(dbManager).findByConditions(conditions1,0,0));
     verifyLossDto.setPrpLregistExtDtoList((ArrayList)new DBPrpLregistExt(dbManager).findByConditions(conditions,0,0));
     verifyLossDto.setPrpLverifyLossDto(new DBPrpLverifyLoss(dbManager).findByPrimaryKey(registNo,lossItemCode));
     //verifyLossDto.setPrpLverifyLossItemDtoList((ArrayList)new DBPrpLverifyLossItem(dbManager).findByConditions(conditions,0,0));
     verifyLossDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(registNo,nodeType,Integer.parseInt(DataUtils.nullToZero(lossItemCode))));
     verifyLossDto.setPrpLpersonDtoList((ArrayList)new DBPrpLperson(dbManager).findByConditions(conditions2,0,0));
     verifyLossDto.setPrpLpropDtoList((ArrayList)new DBPrpLprop(dbManager).findByConditions(conditions,0,0));
     verifyLossDto.setPrpLpersonWoundDtoList((ArrayList)new DBPrpLpersonWound(dbManager).findByConditions(conditions,0,0));
     conditions = " registNo = '"+registNo+"' AND LossItemCode='"+lossItemCode+"'";
     verifyLossDto.setPrpLrepairFeeDtoList((ArrayList)new DBPrpLrepairFee(dbManager).findByConditions(conditions,0,0));
     verifyLossDto.setPrpLcarLossDtoList((ArrayList)new DBPrpLcarLoss(dbManager).findByConditions(conditions,0,0));
     verifyLossDto.setPrpLcomponentDtoList((ArrayList)new DBPrpLcomponent(dbManager).findByConditions(conditions,0,0));
     return verifyLossDto;
  }

}
 