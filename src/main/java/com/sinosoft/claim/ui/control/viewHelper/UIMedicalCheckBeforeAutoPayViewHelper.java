package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sinosoft.claim.bl.facade.BLPrpJpayRefRecFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterPayDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterPayRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterPayBackDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterrelationFacade;
import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrplinterPayBackDetailDto;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.claim.webservice.PayExtDto;
import com.sinosoft.claim.webservice.PayRequestInfo;
import com.sinosoft.claim.webservice.PaymentInfoDto;
import com.sinosoft.sff.blsvr.BLPrpJpackDetail;

/**
 * 接口传入参数的合法性校验类
 * 
 * */
public class UIMedicalCheckBeforeAutoPayViewHelper {
	/**
	 * 接口传入参数的合法性校验
	 * @param payRequestInfo
	 * 
	 * */
	public String checkBeforePay(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		returnStr = this.checkNotNullFields(payRequestInfo);
		if(returnStr.equals("")){
			returnStr = this.checkFlagFieldsRange(payRequestInfo);
		}
		if(returnStr.equals("")){
			returnStr = this.checkReceiverAndPaymentType(payRequestInfo);
		}
		if(returnStr.equals("")){
			returnStr = this.checkOutId(payRequestInfo);
		}
		if(returnStr.equals("")){
			returnStr = this.checkRelationOutId(payRequestInfo);
		}
		
		return returnStr;
	}
	
	/**
	 * 非空字段的非空性校验，若有不满足条件的字段属性，返回提示：0^某属性不能为空
	 * @param payRequestInfo
	 * @return String
	 * @throws Exception
	 * */
	public String checkNotNullFields(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		if(null == payRequestInfo){
			returnStr = "0^入参对象不能为空";
			return returnStr;
		}
		
		if(payRequestInfo.getOutId()==null || "".equals(payRequestInfo.getOutId())){
			returnStr = "0^客户端数据主键不能为空";
			return returnStr;
		}
		if(payRequestInfo.getOperateType()==null || "".equals(payRequestInfo.getOperateType())){
			returnStr = "0^操作类型不能为空";
			return returnStr;
		}
		if(payRequestInfo.getReceiverTypeOther()==null || "".equals(payRequestInfo.getReceiverTypeOther())){
			returnStr = "0^领款人类型代码不能为空";
			return returnStr;
		}
		if(payRequestInfo.getReceiverTypeOtherName()==null || "".equals(payRequestInfo.getReceiverTypeOtherName())){
			returnStr = "0^领款人类型名称不能为空";
			return returnStr;
		}
		if(payRequestInfo.getReceiverFullName()==null || "".equals(payRequestInfo.getReceiverFullName())){
			returnStr = "0^领款人名称不能为空";
			return returnStr;
		}
		if(payRequestInfo.getCertifType()==null || "".equals(payRequestInfo.getCertifType())){
			returnStr = "0^领款人证件类型不能为空";
			return returnStr;
		}
		if(payRequestInfo.getCertifNo()==null || "".equals(payRequestInfo.getCertifNo())){
			returnStr = "0^证件号码不能为空";
			return returnStr;
		}
		if(payRequestInfo.getProvinceCode()==null || "".equals(payRequestInfo.getProvinceCode())){
			returnStr = "0^省份名称不能为空";
			return returnStr;
		}
		if(payRequestInfo.getCityCode()==null || "".equals(payRequestInfo.getCityCode())){
			returnStr = "0^城市名称不能为空";
			return returnStr;
		}
		if(payRequestInfo.getAccountType()==null || "".equals(payRequestInfo.getAccountType())){
			returnStr = "0^账号属性不能为空";
			return returnStr;
		}
		if(payRequestInfo.getBankType()==null || "".equals(payRequestInfo.getBankType())){
			returnStr = "0^银行大类不能为空";
			return returnStr;
		}
		if(payRequestInfo.getBank()==null || "".equals(payRequestInfo.getBank())){
			returnStr = "0^开户银行不能为空";
			return returnStr;
		}
		if(payRequestInfo.getBankAccount()==null || "".equals(payRequestInfo.getBankAccount())){
			returnStr = "0^银行账号不能为空";
			return returnStr;
		}
		if(payRequestInfo.getBankAccount2()==null || "".equals(payRequestInfo.getBankAccount2())){
			returnStr = "0^银行账号不能为空";
			return returnStr;
		}
		if(!payRequestInfo.getBankAccount2().equals(payRequestInfo.getBankAccount())){
			returnStr = "0^两次银行账号不一样";
			return returnStr;
		}
		if(payRequestInfo.getMobilePhone()==null || "".equals(payRequestInfo.getMobilePhone())){
			returnStr = "0^手机号码不能为空";
			return returnStr;
		}
		if(payRequestInfo.getAddress()==null || "".equals(payRequestInfo.getAddress())){
			returnStr = "0^详细地址不能为空";
			return returnStr;
		}
		if(payRequestInfo.getPayWay()==null || "".equals(payRequestInfo.getPayWay())){
			returnStr = "0^支付方式不能为空";
			return returnStr;
		}
//		if(payRequestInfo.getPayPurpose()==null || "".equals(payRequestInfo.getPayPurpose())){
//			returnStr = "0^用途说明不能为空";
//			return returnStr;
//		}
		if(payRequestInfo.getOperatorCode() == null || "".equals(payRequestInfo.getOperatorCode())){
			returnStr = "0^操作人代码不能为空";
			return returnStr;
		}
		if(payRequestInfo.getOperatorName() == null || "".equals(payRequestInfo.getOperatorName())){
			returnStr = "0^操作人名称不能为空";
			return returnStr;
		}
		if(payRequestInfo.getMakeCom() == null || "".equals(payRequestInfo.getMakeCom())){
			returnStr = "0^操作人机构不能为空";
			return returnStr;
		}
		if(payRequestInfo.getMakeComName() == null || "".equals(payRequestInfo.getMakeComName())){
			returnStr = "0^操作人机构名称不能为空";
			return returnStr;
		}
		if(payRequestInfo.getOperatorDate()==null || "".equals(payRequestInfo.getOperatorDate())){
			returnStr = "0^操作时间不能为空";
			return returnStr;
		}
		if(payRequestInfo.getHandleText()==null || "".equals(payRequestInfo.getHandleText())){
			returnStr = "0^支付审批意见不能为空";
			return returnStr;
		}
		if(payRequestInfo.getAccountFlag()==null || "".equals(payRequestInfo.getAccountFlag())){
			returnStr = "0^账号类型意见不能为空";
			return returnStr;
		}
		if(payRequestInfo.getHandleDate()==null || "".equals(payRequestInfo.getHandleDate())){
			returnStr = "0^支付审批通过时间不能为空";
			return returnStr;
		}
		if(payRequestInfo.getHandleCode()==null || "".equals(payRequestInfo.getHandleCode())){
			returnStr = "0^支付审批人员代码不能为空";
			return returnStr;
		}
		if(payRequestInfo.getPaymentInfoDto()==null || payRequestInfo.getPaymentInfoDto().length==0){
			returnStr = "0^赔付信息不能为空";
			return returnStr;
		} else {
			PaymentInfoDto[] paymentInfoDtos = payRequestInfo.getPaymentInfoDto();
			PaymentInfoDto paymentInfoDto = null;
			for(int i=0;i<paymentInfoDtos.length;i++){
				if(paymentInfoDtos[i] != null){
					paymentInfoDto = paymentInfoDtos[i];
					if(paymentInfoDto.getRelationOutId()==null || "".equals(paymentInfoDto.getRelationOutId())){
						returnStr = "0^赔付信息中的关联案件外键不能为空";
						return returnStr;
					}
					if(paymentInfoDto.getRelationOutIdType()==null || "".equals(paymentInfoDto.getRelationOutIdType())){
						returnStr = "0^赔付信息中的关联案件类型不能为空";
						return returnStr;
					}else{
						String relationOutIdType = "N,R";
						if(!relationOutIdType.contains(paymentInfoDto.getRelationOutIdType())){
							returnStr = "0^赔付信息中的关联案件类型不合法";
							return returnStr;
						}
					}
					if(paymentInfoDto.getInsuredNamePay()==null || "".equals(paymentInfoDto.getInsuredNamePay())){
						returnStr = "0^赔付信息中的被保险人不能为空";
						return returnStr;
					}
					if(paymentInfoDto.getPaymentType()==null || "".equals(paymentInfoDto.getPaymentType())){
						returnStr = "0^赔付信息中的赔款类型名称不能为空";
						return returnStr;
					}else{
						String paymentType = "预付赔款,赔款,付检验费,付仲裁费 ,付执行费,机构查勘费,付施救费,付诉讼费,付系统内代查勘," +
								"付共损/救助,外部代查勘费,付律师费,付其他,间接理赔费用,代付赔款及查勘费,逃逸案赔付,理赔补收保费,清付款," +
								"预付检验费,预付仲裁费,预付执行费,预付机构查勘费,预付诉讼费,预付内部代查勘费,预付外部代查勘费,预付律师费";
						if(!paymentType.contains(paymentInfoDto.getPaymentType())){
							returnStr = "0^赔付信息中的赔款类型不合法";
							return returnStr;
						}
					}
					if(paymentInfoDto.getPaymentTypeCode()==null || "".equals(paymentInfoDto.getPaymentTypeCode())){
						returnStr = "0^赔付信息中的赔款类型代码不能为空";
						return returnStr;
					}else{
						String paymentTypeCode = "P50,P60,P61,P611,P612,P62,P63,P64,P65,P66,P67,P68,P69,P6B,P70,P71,P72," +
								"P97,Y61,Y611,Y612,Y62,Y64,Y65,Y67,Y68";
						if(!paymentTypeCode.contains(paymentInfoDto.getPaymentTypeCode())){
							returnStr = "0^赔付信息中的赔款类型代码不合法";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^赔付信息不能为空";
					return returnStr;
				}
			}
			
		}
		PayExtDto[] payExtDtos = payRequestInfo.getPayExtDto();
		if(payExtDtos!=null && payExtDtos.length>0){
			PayExtDto payExtDto = null;
			for(int i=0;i<payExtDtos.length;i++){
				if(payExtDtos[i] != null){
					payExtDto = payExtDtos[i];
					if(payExtDto.getOperatorCodeName()==null || "".equals(payExtDto.getOperatorCodeName())){
						returnStr = "0^处理意见中的操作人不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^处理意见不能为空";
					return returnStr;
				}
			}
		}
		
		return returnStr;
	}
	
	/**
	 * 标志位字段的范围校验，若有不满足条件的字段属性，返回提示：0^某属性不合法
	 * @param payRequestInfo
	 * @return String
	 * @throws Exception
	 * */
	public String checkFlagFieldsRange(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		
		String operateType = "A,U";
		if(!operateType.contains(payRequestInfo.getOperateType())){
			returnStr = "0^操作类型不合法";
			return returnStr;
		}
		String receiverTypeOther = "t01,t02,t03,t04,t05,t06,t07,t08,t09,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20";
		if(!receiverTypeOther.contains(payRequestInfo.getReceiverTypeOther())){
			returnStr = "0^领款人类型代码不合法";
			return returnStr;
		}
		String receiverTypeOtherName = "被保险人,查勘直赔中心,玻璃更换单位,查勘人员,人民法院,公估机构,配件维修单位," +
				"调查机构,救援机构,鉴定机构,律师部门,其他个人,其他单位,受害人员,救治医院,民政部门,交警部门,仲裁机构,监护人,委托代理人";
		if(!receiverTypeOtherName.contains(payRequestInfo.getReceiverTypeOtherName())){
			returnStr = "0^领款人类型名称不合法";
			return returnStr;
		}
		String certifType = "01,02,04,05,07,51,71,72,73";
		if(!certifType.contains(payRequestInfo.getCertifType())){
			returnStr = "0^领款人证件类型不合法";
			return returnStr;
		}
		String certifTypeName = "居民身份证,居民户口薄,军官证,士兵证,中国护照,外国护照,组织机构代码证,税务登记证,营业执照";
		if(!certifTypeName.contains(payRequestInfo.getCertifTypeName())){
			returnStr = "0^领款人证件类型名称不合法";
			return returnStr;
		}
		if(payRequestInfo.getUrgentType()!=null && !"".equals(payRequestInfo.getUrgentType())){
			String urgentType = "0.5,1,2,3,4,8,24,48";
			if(!urgentType.contains(payRequestInfo.getUrgentType())){
				returnStr = "0^紧急程度不合法";
				return returnStr;
			}
		}
		if(payRequestInfo.getUrgentTypeName()!=null && !"".equals(payRequestInfo.getUrgentTypeName())){
			String urgentTypeName = "30分钟,1小时,2小时,3小时,4小时,8小时,24小时,48小时";
			if(!urgentTypeName.contains(payRequestInfo.getUrgentTypeName())){
				returnStr = "0^紧急程度名称不合法";
				return returnStr;
			}
		}
		String provinceCode = "北京,上海,天津,重庆,河北,山西,内蒙古,辽宁,吉林,黑龙江,江苏,浙江,安徽,福建,江西,山东," +
				"河南,湖北,湖南,广东,海南,四川 ,贵州,云南,西藏,陕西,甘肃,青海,宁夏,广西,新疆,香港,澳门,台湾";
		if(!provinceCode.contains(payRequestInfo.getProvinceCode())){
			returnStr = "0^省份名称不合法";
			return returnStr;
		}
		/*String cityCode = "北京,上海,广州,东莞,梅州,潮州,汕尾,深圳,茂名,佛山,江门,珠海,清远,韶关,汕头,惠州,河源,湛江,肇庆," +
				"中山,阳江,天津,重庆,南京,镇江,常州,宜兴,苏州,徐州,淮阴,宿迁,东台,泰州,南通,仪征,丹阳,无锡,江阴,常熟,连云港," +
				"淮安,盐城,扬州,兴化,杭州,绍兴,嘉兴,宁波,舟山,椒江,兰溪,衙州,温州,东阳,萧山,湖州,海宁,余姚,临海,金华,丽水," +
				"江山,义乌,瑞安,台州,成都,西昌,得阳,雅安,遂宁,万县,南充,内江,宜宾,涪陵,乐山,攀枝花,绵阳,广元,重庆,达县,华鉴," +
				"自贡,泸州,海口,三亚,通什,福州,南平,厦门,石狮,龙岩,永安,莆田,邵武,泉州,漳州,三明,济南,临清,淄博,东营,诸城,烟台," +
				"青岛,莱芜,济宁,荷泽,日照,藤州,聊城,德州,滨州,潍坊,青州,威海,泰安,新泰,曲阜,临沂,枣庄,南昌,景德镇,鹰潭,新余,赣州," +
				"井冈山,临川,九江,上饶,伊春,萍乡,吉安,抚州,南宁,百色,北海,桂林,柳州,河池,凭祥,钦州,玉林,梧州,贵港,来宾,合肥,蚌埠," +
				"淮北,亳州,巢湖,芜湖,黄山,铜陵,安庆,淮南,宿州,阜阳,六安,滁州,宣城,马鞍山,池州,石家庄,辛集,邢台,邯郸,泊头,唐山,北戴河," +
				"保定,定州,廊坊,南宫,衡水,沙河,沧州,任丘,秦皇岛,承德,涿州,张家口,郑州,焦作,鹤壁,许昌,驻马店,周口,洛阳,义马,开封,新乡," +
				"安阳,濮阳,缧河,信阳,平顶山,三门峡,南阳,商丘,武汉,天门,应城,仙桃,沙市,荆门,鄂州,咸宁,蒲圻,老河口,十堰,枝城,利川,麻城," +
				"孝感,安陆,洪湖,石首,黄石,武穴,襄樊,随州,丹江口,宜昌,恩施,黄冈,长沙,湘乡,益阳,汨罗,津市,大庸,连源,怀化,衡阳,邵阳,永州," +
				"湘潭,株洲,岳阳,常德,吉首,娄底,冷水江,洪江,来阳,彬州,冷水滩,西安,渭南,延安,汉中,咸阳,韩城,宝鸡,铜川,太原,忻州,临汾,运城," +
				"长治,榆次,大同,侯马,阳泉,晋城,哈尔滨,肇东,伊春,鹤岗,双鸭,牡丹江,鸡西,大庆,黑河,阿城,绥化,佳木斯,七台河,同江,绥汾河," +
				"齐齐哈尔,北安,五大连池,沈阳,铁岭,抚顺,海城,大连,本溪,锦州,兴城,北票,盘锦,辽阳,铁法,鞍山,营口,瓦房店,丹东,锦西,朝阳,阜新," +
				"长春,吉林,延吉,龙井,通化,浑江,四平,辽源,洮南,扶余,桦甸,图门,敦化,集安,梅河口,公主岭,白城,昆明,曲靖,开远,大理,宝山,东川," +
				"照通,个旧,楚雄,贵阳,铜仁,都匀,兴义,赤水,六盘水,凯里,安顺,遵义,兰州,临夏,张掖,嘉峪关,金昌,平凉,白银,武威,酒泉,玉门,天水," +
				"西峰,呼和浩特,二连浩特,临河,东胜,满洲里,赤峰,乌兰浩特,霍林郭勒,集宁,包头,乌海,海拉尔,牙克石,锡林浩特,通辽,扎兰屯,银川,吴忠," +
				"青铜峡,石嘴山,拉萨,日喀则,乌鲁木齐,石河子,博乐,塔城,阿勒泰,哈密,阿克苏,阿图什,昌吉,奎屯,克拉玛依,伊宁,吐鲁番,库尔勒,喀什,和田," +
				"西宁,格尔木,德令哈,香港,澳门,台湾";
		if(!cityCode.contains(payRequestInfo.getCityCode())){
			returnStr = "0^城市名称不合法";
			return returnStr;
		}*/
		String accountType = "1,2";
		if(!accountType.contains(payRequestInfo.getAccountType())){
			returnStr = "0^账号属性不合法";
			return returnStr;
		}
		/*String bankType = "农业银行,交通银行,建设银行,光大银行,招商银行,中信银行,工商银行,浦发银行,民生银行,广发银行,中国银行,国家开发银行," +
				"中国进出口银行,中国农业发展银行,华夏银行,广东发展银行,深圳发展银行,兴业银行,城市商业银行,江苏农村商业银行,恒丰银行,浙商银行," +
				"农村合作银行,渤海银行股份有限公司,徽商银行股份有限公司,镇银行有限责任公司,城市信用社,农村信用社含北京农村商业银行,中国邮政储蓄银行," +
				"汇丰银行,东亚银行,南洋商业银行,恒生银行中国有限公司,中国银行香港有限公司,集友银行有限公司,创兴银行有限公司,星展银行中国有限公司," +
				"永亨银行中国有限公司,永隆银行,花旗银行中国有限公司,美国银行有限公司,摩根大通银行中国有限公司,三菱东京日联银行中国有限公司," +
				"日本三井住友银行股份有限公司,香港地区银行,瑞穗实业银行中国有限公司,日本山口银行股份有限公司,韩国外换银行股份有限公司,友利银行中国有限公司," +
				"韩国产业银行,新韩银行中国有限公司,韩国中小企业银行有限公司,韩亚银行中国有限公司,华侨银行中国有限公司,大华银行中国有限公司," +
				"星展银行中国有限公司,泰国盘谷银行大众有限公司,奥地利中央合作银行股份有限公司,比利时联合银行股份有限公司,比利时富通银行有限公司," +
				"荷兰银行,荷兰安智银行股份有限公司,渣打银行,英国苏格兰皇家银行公众有限公司,法国兴业银行中国有限公司,法国东方汇理银行股份有限公司," +
				"法国外贸银行股份有限公司,德国德累斯登银行股份公司,德意志银行中国有限公司,德国商业银行股份有限公司,德国西德银行股份有限公司," +
				"德国巴伐利亚州银行,德国北德意志州银行,意大利联合圣保罗银行股份有限公司,瑞士信贷银行股份有限公司,瑞士银行,加拿大丰业银行有限公司," +
				"加拿大蒙特利尔银行有限公司,澳大利亚和新西兰银行集团有限公司,摩根士丹利国际银行中国有限公司,联合银行中国有限公司,荷兰合作银行有限公司," +
				"厦门国际银行,法国巴黎银行中国有限公司,华商银行,华一银行,澳门地区银行,安徽银行,国家金库,其他银行,农业银行,";
		if(!bankType.contains(payRequestInfo.getBankType())){
			returnStr = "0^银行大类不合法";
			return returnStr;
		}*/
		String payWay = "1,2";
		if(!payWay.contains(payRequestInfo.getPayWay())){
			returnStr = "0^支付方式不合法";
			return returnStr;
		}
		String accountFlag = "00,01,02,03";
		if(!accountFlag.contains(payRequestInfo.getAccountFlag())){
			returnStr = "0^账号类型不合法";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * 校验在不同状态下外部outId是否有效，返回相应流程信息
	 * @param payRequestInfo
	 * @return String
	 * @throwsException
	 * */
	public String checkOutId(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		String outId = payRequestInfo.getOutId();
		String operateType = payRequestInfo.getOperateType();
		BLPrpLinterPayRequestFacade blPrpLinterPayRequestFacade = new BLPrpLinterPayRequestFacade();
		Collection collection = blPrpLinterPayRequestFacade.findByConditions(" outId='"+outId+"' order by inputDate desc ");
		if(operateType.equals("A")){
			if(collection!=null && collection.size()>0){
				returnStr = "2^该数据已经交互过支付系统";
				return returnStr;
			}
		}
		if(operateType.equals("U")){
			if(collection==null || collection.size()<1){
				returnStr = "0^该数据未交互过支付系统，不能进行更新支付信息操作";
				return returnStr;
			}else{
				PrpLinterPayRequestDto prpLinterPayRequest = (PrpLinterPayRequestDto)collection.iterator().next();
				String id = prpLinterPayRequest.getId();
				//根据outid 在prplinterpaydetail表中找到 paymentno
				BLPrpLinterPayDetailFacade blPrpLinterPayDetailFacade = new BLPrpLinterPayDetailFacade();
				BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
				Collection payDetailList = blPrpLinterPayDetailFacade.findByConditions(" outid='"+outId+"' and id='"+id+"' ");
				if(payDetailList!=null && payDetailList.size()>0){
					PrpLinterPayDetailDto prpLinterPayDetailDto = (PrpLinterPayDetailDto)payDetailList.iterator().next();
					if(prpLinterPayDetailDto!=null && "1".equals(prpLinterPayDetailDto.getVericSuccFlag())){
						PrpLpaymainDto prpLpaymainDto = blPrpLpaymainFacade.findByPrimaryKey(prpLinterPayDetailDto.getPaymentNo());
						if(prpLpaymainDto!=null){
							if(!"9".equals(prpLpaymainDto.getVflag())){
								returnStr = "0^数据未处于退回状态，不能进行更新支付信息操作";
								return returnStr;
							}
						}else{
							returnStr = "0^数据未处于退回状态，不能进行更新支付信息操作";
							return returnStr;
						}
					}else{
						returnStr = "0^有未完成的交互操作，不能再次更新";
						return returnStr;
					}
				}else{
					returnStr = "0^没查到相关支付信息，不能进行更新支付信息操作";
					return returnStr;
				}
				//三方支付接口在“U”的时候，增加:退回交易接收成功的判断：中间表记录所有的退回的交易
				BLPrplinterPayBackDetailFacade blPrplinterPayBackDetailFacade = new BLPrplinterPayBackDetailFacade();
				Collection payBackDetailList = blPrplinterPayBackDetailFacade.findByConditions(" relationId='"+id+"' ");
				if(payBackDetailList!=null && payBackDetailList.size()>0){
					PrplinterPayBackDetailDto prplinterPayBackDetailDto = (PrplinterPayBackDetailDto)payBackDetailList.iterator().next();
					String mutualSuccFlag = prplinterPayBackDetailDto.getMutualSuccFlag();
					if(prplinterPayBackDetailDto==null || (!"1".equals(mutualSuccFlag) && !"2".equals(mutualSuccFlag))){
						returnStr = "0^支付退回数据交互失败，不能进行更新支付信息操作";
						return returnStr;
					}
				}else{
					returnStr = "0^没有查到相关支付退回信息，不能进行更新支付信息操作";
					return returnStr;
				}
			}
		}
		return returnStr;
	}
	
	/**
	 * 校验在不同状态下外部relationOutId是否有效，返回相应流程信息
	 * @param payRequestInfo
	 * @return String
	 * @throwsException
	 * */
	public String checkRelationOutId(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		String key = "";
		
		Map<String,PaymentInfoDto> map = new HashMap<String,PaymentInfoDto>();
		PaymentInfoDto[] paymentDtos = payRequestInfo.getPaymentInfoDto();
		for(int i=0;i<paymentDtos.length;i++){
			String relationOutId = paymentDtos[i].getRelationOutId();
			String relationOutIdType = paymentDtos[i].getRelationOutIdType();
			if(relationOutIdType.equals("R")){
				BLPrpLinterRecaseRequestFacade blPrpLinterRecaseRequestFacade = new BLPrpLinterRecaseRequestFacade();
				BLPrpLinterRecaseDetailFacade blPrpLinterRecaseDetailFacade = new BLPrpLinterRecaseDetailFacade();
				Collection recaseList = blPrpLinterRecaseRequestFacade.findByConditions(" outid='"+relationOutId+"' ");
				if(recaseList==null || recaseList.size()<1){
					returnStr = "0^没有相关重开案件";
					return returnStr;
				}
				PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto)recaseList.iterator().next();
				String id = prpLinterRecaseRequestDto.getId();
				Collection recaseDetailList = blPrpLinterRecaseDetailFacade.findByConditions(" id='"+id+"' ");
//				if(recaseDetailList==null || recaseDetailList.size()<1){
//					returnStr = "0^相关重开案件没有结案，不能进行支付操作";
//					return returnStr;
//				}
//				PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = (PrpLinterRecaseDetailDto)recaseDetailList.iterator().next();
//				if(!prpLinterRecaseDetailDto.getEndcaSuccFlag().equals("1")){
//					returnStr = "0^相关重开案件没有结案，不能进行支付操作";
//					return returnStr;
//				}
				
				//需要判断计算书是否送三方支付prpjpayrefrec表
//				BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();
//				String compensateNo = prpLinterRecaseDetailDto.getCompensateNo();
//				String payrefreason = paymentDtos[i].getPaymentTypeCode();
//				String conditions = " certino='"+compensateNo+"' and certitype='C' and visaserialno like '9%' " +
//						"and payrefreason='"+payrefreason+"' and payrefstate in ('00', '01') and payrefdate is null ";
//				Collection prpJpayRefRecList = blPrpJpayRefRecFacade.findByConditions(conditions);
//				//如果有对应的记录，可以进行三方支付,否则提示：0^不存在对应的三方支付信息
//				if(prpJpayRefRecList==null || prpJpayRefRecList.size()<1){
//					returnStr = "0^不存在对应的三方支付信息";
//					return returnStr;
//				}
			}
			if(relationOutIdType.equals("N")){
				BLPrplinterrelationFacade blprplinterrelationFacade = new BLPrplinterrelationFacade();
				BLPrplinterAutoClaimDetailFacade blPrplinterAutoClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
//				Collection prplinterrelationList = blprplinterrelationFacade.findByConditions(" outid='"+relationOutId+"' ");
//				if(prplinterrelationList==null || prplinterrelationList.size()==0){
//					returnStr = "0^没有相关案件";
//					return returnStr;
//				}
//				PrplinterrelationDto prplinterrelationDto = (PrplinterrelationDto)prplinterrelationList.iterator().next();
//				String id = prplinterrelationDto.getId();
//				String registNo = prplinterrelationDto.getRelationRegistNo();
//				PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(id, registNo);
//				if(prplinterAutoClaimDetailDto==null || !"1".equals(prplinterAutoClaimDetailDto.getEndcaSuccFlag())){
//					returnStr = "0^相关案件没有结案，不能进行支付操作";
//					return returnStr;
//				}
				
				//需要判断计算书是否送三方支付prpjpayrefrec表
//				BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();
//				String payrefreason = paymentDtos[i].getPaymentTypeCode();
//				String conditions = " certino = (select compensateno from prplcompensate where times = '1' " +
//						"and claimno in (select claimno from prplclaim where registno = '"+registNo+"')) " +
//						"and certitype='C' and visaserialno like '9%' " +
//						"and payrefreason='"+payrefreason+"' and payrefstate in ('00', '01') and payrefdate is null ";
//				Collection prpJpayRefRecList = blPrpJpayRefRecFacade.findByConditions(conditions);
//				//如果有对应的记录，可以进行三方支付,否则提示：0^不存在对应的三方支付信息
//				if(prpJpayRefRecList==null || prpJpayRefRecList.size()<1){
//					returnStr = "0^不存在对应的三方支付信息";
//					return returnStr;
//				}
				
			}
			
			key = paymentDtos[i].getRelationOutId()+paymentDtos[i].getPaymentType();
			if(map.containsKey(key)){
				returnStr = "0^同一个关联案件外键，赔款类型相同的赔付信息只能有一条";
				return returnStr;
			}
			map.put(key, paymentDtos[i]);
		}
		return returnStr;
	}
	
	
	/**
	 * 校验在不同状态下外部relationOutId是否有效，返回相应流程信息
	 * @param payRequestInfo
	 * @return String
	 * @throwsException
	 * */
	public String checkRelationOutIdByAuto(PrpLinterPayRequestDto prpLinterPayRequestDto) throws Exception{
		String returnStr = "";
		String key = "";
		
		Map<String,PrpLinterPaymentInfoDto> map = new HashMap<String,PrpLinterPaymentInfoDto>();
		PrpLinterPaymentInfoDto[] paymentDtos = prpLinterPayRequestDto.getPrpLinterPaymentInfoDto();
		for(int i=0;i<paymentDtos.length;i++){
			String relationOutId = paymentDtos[i].getRelationOutId();
			String relationOutIdType = paymentDtos[i].getRelationOutIdType();
			if(relationOutIdType.equals("R")){
				BLPrpLinterRecaseRequestFacade blPrpLinterRecaseRequestFacade = new BLPrpLinterRecaseRequestFacade();
				BLPrpLinterRecaseDetailFacade blPrpLinterRecaseDetailFacade = new BLPrpLinterRecaseDetailFacade();
				Collection recaseList = blPrpLinterRecaseRequestFacade.findByConditions(" outid='"+relationOutId+"' ");
				if(recaseList==null || recaseList.size()<1){
					returnStr = "0^没有相关重开案件";
					return returnStr;
				}
				PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto)recaseList.iterator().next();
				String id = prpLinterRecaseRequestDto.getId();
				Collection recaseDetailList = blPrpLinterRecaseDetailFacade.findByConditions(" id='"+id+"' ");
				if(recaseDetailList==null || recaseDetailList.size()<1){
					returnStr = "0^相关重开案件没有结案，不能进行支付操作";
					return returnStr;
				}
				PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = (PrpLinterRecaseDetailDto)recaseDetailList.iterator().next();
				if(!prpLinterRecaseDetailDto.getEndcaSuccFlag().equals("1")){
					returnStr = "0^相关重开案件没有结案，不能进行支付操作";
					return returnStr;
				}
				
				//需要判断计算书是否送三方支付prpjpayrefrec表
				BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();
				String compensateNo = prpLinterRecaseDetailDto.getCompensateNo();
				String payrefreason = paymentDtos[i].getPaymentTypeCode();
				String conditions = " certino='"+compensateNo+"' and certitype='C' and visaserialno like '9%' " +
						"and payrefreason='"+payrefreason+"' and payrefstate in ('00', '01') and payrefdate is null ";
				Collection prpJpayRefRecList = blPrpJpayRefRecFacade.findByConditions(conditions);
				//如果有对应的记录，可以进行三方支付,否则提示：0^不存在对应的三方支付信息
				if(prpJpayRefRecList==null || prpJpayRefRecList.size()<1){
					returnStr = "0^不存在对应的三方支付信息";
					return returnStr;
				}
			}
			if(relationOutIdType.equals("N")){
				BLPrplinterrelationFacade blprplinterrelationFacade = new BLPrplinterrelationFacade();
				BLPrplinterAutoClaimDetailFacade blPrplinterAutoClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
				Collection prplinterrelationList = blprplinterrelationFacade.findByConditions(" outid='"+relationOutId+"' ");
				if(prplinterrelationList==null || prplinterrelationList.size()==0){
					returnStr = "0^没有相关案件";
					return returnStr;
				}
				PrplinterrelationDto prplinterrelationDto = (PrplinterrelationDto)prplinterrelationList.iterator().next();
				String id = prplinterrelationDto.getId();
				String registNo = prplinterrelationDto.getRelationRegistNo();
				PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(id, registNo);
				if(prplinterAutoClaimDetailDto==null || !"1".equals(prplinterAutoClaimDetailDto.getEndcaSuccFlag())){
					returnStr = "0^相关案件没有结案，不能进行支付操作";
					return returnStr;
				}
				
				//需要判断计算书是否送三方支付prpjpayrefrec表
				BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();
				String payrefreason = paymentDtos[i].getPaymentTypeCode();
				String conditions = " certino = (select compensateno from prplcompensate where times = '1' " +
						"and claimno in (select claimno from prplclaim where registno = '"+registNo+"')) " +
						"and certitype='C' and visaserialno like '9%' " +
						"and payrefreason='"+payrefreason+"' and payrefstate in ('00', '01') and payrefdate is null ";
				Collection prpJpayRefRecList = blPrpJpayRefRecFacade.findByConditions(conditions);
				//如果有对应的记录，可以进行三方支付,否则提示：0^不存在对应的三方支付信息
				if(prpJpayRefRecList==null || prpJpayRefRecList.size()<1){
					returnStr = "0^不存在对应的三方支付信息";
					return returnStr;
				}
				
			}
			
			key = paymentDtos[i].getRelationOutId()+paymentDtos[i].getPaymentType();
			if(map.containsKey(key)){
				returnStr = "0^同一个关联案件外键，赔款类型相同的赔付信息只能有一条";
				return returnStr;
			}
			map.put(key, paymentDtos[i]);
		}
		return returnStr;
	}
	
	/**
	 * “领款人类型”和“赔款类型”的规则校验
	 * @param payRequestInfo
	 * @return String
	 * @throwsException
	 */
	public String checkReceiverAndPaymentType(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		String receiverType = payRequestInfo.getReceiverTypeOther();
		String receiverTypeName = payRequestInfo.getReceiverTypeOtherName();
		PaymentInfoDto[] paymentInfoDtos = payRequestInfo.getPaymentInfoDto();
		if(paymentInfoDtos!=null && paymentInfoDtos.length>0){
			PaymentInfoDto paymentInfoDto = null;
			for(int i=0;i<paymentInfoDtos.length;i++){
				if(paymentInfoDtos[i] != null){
					paymentInfoDto = paymentInfoDtos[i];
					String paymentType = paymentInfoDto.getPaymentTypeCode();
					String paymentTypeName = paymentInfoDto.getPaymentType();
					
					if("P60".equals(paymentType)||"P50".equals(paymentType)){//赔款
						if("t04".equals(receiverType)||"t11".equals(receiverType)||"t06".equals(receiverType)||"t08".equals(receiverType)||"t10".equals(receiverType)
								||"t09".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^领款人为“"+receiverTypeName+"”时,不允许支付“"+paymentTypeName+"”";
							return returnStr;
						}
					}else if ("P61".equals(paymentType)||"Y61".equals(paymentType)){//检验费/预付检验费
						if("t02".equals(receiverType)||"t03".equals(receiverType)||"t07".equals(receiverType)||"t04".equals(receiverType)||"t18".equals(receiverType)
								||"t11".equals(receiverType)||"t15".equals(receiverType)||"t16".equals(receiverType)||"t17".equals(receiverType)||"t09".equals(receiverType)){
							returnStr = "0^领款人为“"+receiverTypeName+"”时,不允许支付“"+paymentTypeName+"”";
							return returnStr;
						}
					}else if ("P62".equals(paymentType)||"Y62".equals(paymentType)){//机构查勘费/预付机构查勘费
						if("t01".equals(receiverType)||"t02".equals(receiverType)||"t03".equals(receiverType)||"t05".equals(receiverType)||"t06".equals(receiverType)
								||"t07".equals(receiverType)||"t08".equals(receiverType)||"t09".equals(receiverType)||"t10".equals(receiverType)||"t11".equals(receiverType)
								||"t12".equals(receiverType)||"t13".equals(receiverType)||"t14".equals(receiverType)||"t15".equals(receiverType)||"t16".equals(receiverType)
								||"t17".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^领款人为“"+receiverTypeName+"”时,不允许支付“"+paymentTypeName+"”";
							return returnStr;
						}
					}else if ("P611".equals(paymentType)||"Y611".equals(paymentType)){//仲裁费/预付仲裁费
						if("t02".equals(receiverType)||"t03".equals(receiverType)||"t04".equals(receiverType)||"t05".equals(receiverType)||"t06".equals(receiverType)
								||"t07".equals(receiverType)||"t08".equals(receiverType)||"t09".equals(receiverType)||"t10".equals(receiverType)||"t11".equals(receiverType)
								||"t15".equals(receiverType)||"t16".equals(receiverType)||"t17".equals(receiverType)){
							returnStr = "0^领款人为“"+receiverTypeName+"”时,不允许支付“"+paymentTypeName+"”";
							return returnStr;
						}
					}else if ("P612".equals(paymentType)||"Y612".equals(paymentType)){//执行费/预付执行费
						if("t01".equals(receiverType)||"t02".equals(receiverType)||"t03".equals(receiverType)||"t04".equals(receiverType)||"t06".equals(receiverType)
								||"t07".equals(receiverType)||"t08".equals(receiverType)||"t09".equals(receiverType)||"t10".equals(receiverType)||"t11".equals(receiverType)
								||"t14".equals(receiverType)||"t15".equals(receiverType)||"t16".equals(receiverType)||"t17".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^领款人为“"+receiverTypeName+"”时,不允许支付“"+paymentTypeName+"”";
							return returnStr;
						}
					}else if ("P64".equals(paymentType)||"Y64".equals(paymentType)){//诉讼费/预付诉讼费
						if("t02".equals(receiverType)||"t03".equals(receiverType)||"t04".equals(receiverType)||"t06".equals(receiverType)||"t07".equals(receiverType)
								||"t08".equals(receiverType)||"t09".equals(receiverType)||"t10".equals(receiverType)||"t11".equals(receiverType)||"t15".equals(receiverType)
								||"t16".equals(receiverType)||"t17".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^领款人为“"+receiverTypeName+"”时,不允许支付“"+paymentTypeName+"”";
							return returnStr;
						}
					}
					else if ("P65".equals(paymentType)||"Y65".equals(paymentType)){//内部代查勘费/预付内部代查勘费
						if("t04".equals(receiverType)||"t11".equals(receiverType)||"t06".equals(receiverType)||"t08".equals(receiverType)||"t10".equals(receiverType)||"t09".equals(receiverType)){
							returnStr = "0^领款人为“"+receiverTypeName+"”时,不允许支付“"+paymentTypeName+"”";
							return returnStr;
						}
					}
					else if ("P67".equals(paymentType)||"Y67".equals(paymentType)){//外部代查勘费/预付外部代查勘费
						if("t01".equals(receiverType)||"t02".equals(receiverType)||"t03".equals(receiverType)||"t04".equals(receiverType)||"t05".equals(receiverType)
								||"t07".equals(receiverType)||"t08".equals(receiverType)||"t10".equals(receiverType)||"t11".equals(receiverType)
								||"t12".equals(receiverType)||"t13".equals(receiverType)||"t14".equals(receiverType)||"t15".equals(receiverType)||"t16".equals(receiverType)
								||"t17".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^领款人为“"+receiverTypeName+"”时,不允许支付“"+paymentTypeName+"”";
							return returnStr;
						}
					}else if ("P68".equals(paymentType)||"Y68".equals(paymentType)){//律师费/预付律师费
						if("t02".equals(receiverType)||"t03".equals(receiverType)||"t04".equals(receiverType)||"t06".equals(receiverType)
								||"t07".equals(receiverType)||"t08".equals(receiverType)||"t09".equals(receiverType)||"t10".equals(receiverType)
								||"t15".equals(receiverType)||"t16".equals(receiverType)||"t17".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^领款人为“"+receiverTypeName+"”时,不允许支付“"+paymentTypeName+"”";
							return returnStr;
						}
					}
				}
			}
		}
		
		return returnStr;
	}

	public String checkBeforePayDelete(PrpLinterPayDeleteRequestDto payDeleteRequestInfo) throws Exception{
		String returnStr = "";
		returnStr = this.checkNotNullPayDelete(payDeleteRequestInfo);
		if(returnStr.equals("")){
			returnStr = this.checkPayDeleteOutId(payDeleteRequestInfo);
		}
		return returnStr;
	}
	
	public String checkNotNullPayDelete(PrpLinterPayDeleteRequestDto payDeleteRequestInfo) throws Exception{
		String returnStr = "";
		if(null == payDeleteRequestInfo){
			returnStr = "0^入参对象不能为空";
			return returnStr;
		}
		
		if(payDeleteRequestInfo.getOutId()==null || "".equals(payDeleteRequestInfo.getOutId())){
			returnStr = "0^客户端数据主键不能为空";
			return returnStr;
		}
		if(payDeleteRequestInfo.getOperatorCode() == null || "".equals(payDeleteRequestInfo.getOperatorCode())){
			returnStr = "0^操作人代码不能为空";
			return returnStr;
		}
		if(payDeleteRequestInfo.getOperatorName() == null || "".equals(payDeleteRequestInfo.getOperatorName())){
			returnStr = "0^操作人名称不能为空";
			return returnStr;
		}
		if(payDeleteRequestInfo.getMakeCom() == null || "".equals(payDeleteRequestInfo.getMakeCom())){
			returnStr = "0^操作人机构不能为空";
			return returnStr;
		}
		if(payDeleteRequestInfo.getMakeComName() == null || "".equals(payDeleteRequestInfo.getMakeComName())){
			returnStr = "0^操作人机构名称不能为空";
			return returnStr;
		}
		if(payDeleteRequestInfo.getOperatorDate()==null || "".equals(payDeleteRequestInfo.getOperatorDate())){
			returnStr = "0^操作时间不能为空";
			return returnStr;
		}
		if(payDeleteRequestInfo.getHandleText()==null || "".equals(payDeleteRequestInfo.getHandleText())){
			returnStr = "0^支付删除意见不能为空";
			return returnStr;
		}
		
		return returnStr;
	}
	
	public String checkPayDeleteOutId(PrpLinterPayDeleteRequestDto payDeleteRequestInfo) throws Exception{
		String returnStr = "";
		String outId = payDeleteRequestInfo.getOutId();
		BLPrpLinterPayRequestFacade blPrpLinterPayRequestFacade = new BLPrpLinterPayRequestFacade();
		ArrayList list = (ArrayList)blPrpLinterPayRequestFacade.findByConditions(" outId='"+outId+"' order by inputDate desc ");
		if(list==null || list.size()==0){
			returnStr = "2^该数据已经支付删除或未同步支付系统";
			return returnStr;
		}
		String paymentList = "";
		for(int num=0;num<list.size();num++){
			PrpLinterPayRequestDto iPrpLinterPayRequestDto = (PrpLinterPayRequestDto)list.get(num);
    		if(null!=paymentList && !"".equals(paymentList)){
    			paymentList += ",'"+iPrpLinterPayRequestDto.getPaymentNo()+"'";
    		}else{
    			paymentList += "'"+iPrpLinterPayRequestDto.getPaymentNo()+"'";
    		}
		}
		if(null!=paymentList && !"".equals(paymentList)){
			String queryCondi = " flag='1' and approveflag<>'3' and visaserialno in (select paymentno from prplpaymain where paymentno in ("+paymentList+"))";
			BLPrpJpackDetail blPrpJpackDetail = new BLPrpJpackDetail();
			blPrpJpackDetail.query(queryCondi);
			if(null!=blPrpJpackDetail&&blPrpJpackDetail.getSize()>0){
				returnStr = "2^该数据存在待支付的记录，不需要删除";
			}
		}
		
		return returnStr;
	}
}
