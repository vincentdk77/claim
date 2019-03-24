package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcompany机构代码表的业务对象扩展类<br>
 * 创建于 2004-08-25 16:51:29.983<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcompanyAction extends BLPrpDcompanyActionBase {
	private static Log logger = LogFactory.getLog(BLPrpDcompanyAction.class);

	/**
	 * 构造函数
	 */
	public BLPrpDcompanyAction() {
		super();
	}

	/**
	 * 转换Dto
	 * 
	 * @param dbManager
	 *            dbManager
	 * @param prpDcompanyDto
	 *            prpDcompanyDto
	 * @param mode
	 *            模式
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
	 *            部门代码
	 * @throw Exception
	 * @desc 根据输入的单位代码，查询该单位所属的核算单位代码,若是农险机构，取核算单位的上级核算结构
	 */
	public String getCenterCode(DBManager dbManager, String iComCode)
			throws Exception {
		String centerCode = "";
		int intReturn = 0;
		DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
		PrpDcompanyDto prpDcompanyDto = null;
		if (iComCode.equals("")) {
			return ""; // 代码空直接返回空字符串
		}
		try {
			while (true) {
				prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(iComCode);
				if (prpDcompanyDto == null) {
					throw new Exception("找不到该出单机构的核算单位");
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
					throw new Exception("该出单机构不归属于任何核算单位");
				}
				iComCode = prpDcompanyDto.getUpperComCode();
			}
		} catch (Exception e) {
			throw e;
		}
		return centerCode;
	}
	
	/**
	 * 翻译代码
	 * 
	 * @param iComCode
	 *            部门代码
	 * @param isChinese
	 *            中外文标识
	 * @throw UserException,Exception
	 * @return 根据中外文标识返回中文或英文名称
	 */
	public String translateCode(DBManager dbManager,String iComCode, boolean isChinese)
			throws Exception {
		if (iComCode.equals("")) {
			return ""; // 代码空直接返回空字符串
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
