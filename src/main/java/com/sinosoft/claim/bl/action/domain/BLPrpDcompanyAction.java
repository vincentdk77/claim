package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcompany����������ҵ�������չ��<br>
 * ������ 2004-08-25 16:51:29.983<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcompanyAction extends BLPrpDcompanyActionBase {
	private static Log logger = LogFactory.getLog(BLPrpDcompanyAction.class);

	/**
	 * ���캯��
	 */
	public BLPrpDcompanyAction() {
		super();
	}

	/**
	 * ת��Dto
	 * 
	 * @param dbManager
	 *            dbManager
	 * @param prpDcompanyDto
	 *            prpDcompanyDto
	 * @param mode
	 *            ģʽ
	 * @throws Exception
	 */
	public void convertDto(DBManager dbManager, PrpDcompanyDto prpDcompanyDto,
			String mode) throws Exception {
	}

	public String getRecursionComCode(DBManager dbManager, String conditions)
			throws Exception {
		DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        String comCode ="";
		if (conditions.trim().length() == 0) {
			conditions = "1=1";
		}
     	 comCode = dbPrpDcompany.getRecursionComCode(conditions);
		return comCode;
	}
	
	/**
	 * @param DBManager,iComCode
	 *            ���Ŵ���
	 * @throw Exception
	 * @desc ��������ĵ�λ���룬��ѯ�õ�λ�����ĺ��㵥λ����,����ũ�ջ�����ȡ���㵥λ���ϼ�����ṹ
	 */
	public String getCenterCode(DBManager dbManager, String iComCode)
			throws Exception {
		String centerCode = "";
		int intReturn = 0;
		DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
		PrpDcompanyDto prpDcompanyDto = null;
		if (iComCode.equals("")) {
			return ""; // �����ֱ�ӷ��ؿ��ַ���
		}
		try {
			while (true) {
				prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(iComCode);
				if (prpDcompanyDto == null) {
					throw new Exception("�Ҳ����ó��������ĺ��㵥λ");
				}
				if (prpDcompanyDto.getCenterFlag().equals("1")) {
					if("2".equals(prpDcompanyDto.getFlag())){
						centerCode = prpDcompanyDto.getUpperComCode();
					}else{
						centerCode = iComCode;
					}
					break;
				}
				if (iComCode.equals(prpDcompanyDto.getUpperComCode())) {
					throw new Exception("�ó����������������κκ��㵥λ");
				}
				iComCode = prpDcompanyDto.getUpperComCode();
			}
		} catch (Exception e) {
			throw e;
		}
		return centerCode;
	}
	
	/**
	 * �������
	 * 
	 * @param iComCode
	 *            ���Ŵ���
	 * @param isChinese
	 *            �����ı�ʶ
	 * @throw UserException,Exception
	 * @return ���������ı�ʶ�������Ļ�Ӣ������
	 */
	public String translateCode(DBManager dbManager,String iComCode, boolean isChinese)
			throws Exception {
		if (iComCode.equals("")) {
			return ""; // �����ֱ�ӷ��ؿ��ַ���
		}
		DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
		PrpDcompanyDto prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(iComCode);
		if (isChinese) {
			return prpDcompanyDto.getComCName();
		} else {
			if (prpDcompanyDto.getComEName() == null || prpDcompanyDto.getComEName().equals("")) {
				return prpDcompanyDto.getComCName();
			} else {
				return prpDcompanyDto.getComEName();
			}
		}
	}

}
