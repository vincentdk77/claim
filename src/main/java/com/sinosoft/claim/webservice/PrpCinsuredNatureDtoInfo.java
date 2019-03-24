package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

public class PrpCinsuredNatureDtoInfo implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Թ�ϵ�˱�־ */
    private String insuredFlag = "";
    /** �����Ա� */
    private String sex = "";
    /** �������� */
    private int age = 0;
    /** ���Գ������� */
    private Date birthday = new Date();
    /** ���Խ���״̬ */
    private String health = "";
    /** ����ְ�� */
    private String jobTitle = "";
    /** �����ڱ��ع������� */
    private int loacalWorkYears = 0;
    /** ����ѧ�� */
    private String education = "";
    /** �����ܹ��� */
    private int totalWorkYears = 0;
    /** ���Ե�λ���� */
    private String unit = "";
    /** ���Ե�λ�绰 */
    private String unitPhoneNumber = "";
    /** ���Ե�λ��ַ */
    private String unitAddress = "";
    /** ���Ե�λ�ʱ� */
    private String unitPostCode = "";
    /** ���Ե�λ���� */
    private String unitType = "";
    /** ������ְ���� */
    private String dutyLevel = "";
    /** ������ְ���� */
    private String dutyType = "";
    /** ���Լ�ְְҵ/���ִ��� */
    private String occupationcode = "";
    /** ���Է���״�� */
    private String houseProperty = "";
    /** ���Ի������ڵ��ɳ������� */
    private String localPoliceStation = "";
    /** ���Ծ���ס���� */
    private String roomAddress = "";
    /** ������������ */
    private String roompostcode = "";
    /** ���Ա��������� */
    private double selfMonthIncome = 0d;
    /** ���Լ�ͥ������ */
    private double familyMonthIncome = 0d;
    /** ����������Դ */
    private String incomeSource = "";
    /** ���Գ�ס���绰 */
    private String roomPhone = "";
    /** ��������绰 */
    private String mobile = "";
    /** ���Լ�ͥ�˿� */
    private int familySumQuantity = 0;
    /** ���Ի���״�� */
    private String marriage = "";
    /** ������ż���� */
    private String spouseName = "";
    /** ������ż�������� */
    private Date spouseBornDate = new Date();
    /** ������ż���֤���� */
    private String spouseID = "";
    /** ������ż��λ */
    private String spouseUnit = "";
    /** ������żְ�� */
    private String spouseJobTitle = "";
    /** ������ż��λ�绰 */
    private String spouseUnitPhone = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCinsuredNatureDtoBase����
     */
    public PrpCinsuredNatureDtoInfo(){
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Թ�ϵ�˱�־
     * @param insuredFlag �����õ����Թ�ϵ�˱�־��ֵ
     */
    public void setInsuredFlag(String insuredFlag){
        this.insuredFlag = StringUtils.rightTrim(insuredFlag);
    }

    /**
     * ��ȡ���Թ�ϵ�˱�־
     * @return ���Թ�ϵ�˱�־��ֵ
     */
    public String getInsuredFlag(){
        return insuredFlag;
    }

    /**
     * ���������Ա�
     * @param sex �����õ������Ա��ֵ
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * ��ȡ�����Ա�
     * @return �����Ա��ֵ
     */
    public String getSex(){
        return sex;
    }

    /**
     * ������������
     * @param age �����õ����������ֵ
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public int getAge(){
        return age;
    }

    /**
     * �������Գ�������
     * @param birthday �����õ����Գ������ڵ�ֵ
     */
    public void setBirthday(DateTime birthday){
        this.birthday = birthday;
    }

   

    /**
     * �������Խ���״̬
     * @param health �����õ����Խ���״̬��ֵ
     */
    public void setHealth(String health){
        this.health = StringUtils.rightTrim(health);
    }

    /**
     * ��ȡ���Խ���״̬
     * @return ���Խ���״̬��ֵ
     */
    public String getHealth(){
        return health;
    }

    /**
     * ��������ְ��
     * @param jobTitle �����õ�����ְ�Ƶ�ֵ
     */
    public void setJobTitle(String jobTitle){
        this.jobTitle = StringUtils.rightTrim(jobTitle);
    }

    /**
     * ��ȡ����ְ��
     * @return ����ְ�Ƶ�ֵ
     */
    public String getJobTitle(){
        return jobTitle;
    }

    /**
     * ���������ڱ��ع�������
     * @param loacalWorkYears �����õ������ڱ��ع������޵�ֵ
     */
    public void setLoacalWorkYears(int loacalWorkYears){
        this.loacalWorkYears = loacalWorkYears;
    }

    /**
     * ��ȡ�����ڱ��ع�������
     * @return �����ڱ��ع������޵�ֵ
     */
    public int getLoacalWorkYears(){
        return loacalWorkYears;
    }

    /**
     * ��������ѧ��
     * @param education �����õ�����ѧ����ֵ
     */
    public void setEducation(String education){
        this.education = StringUtils.rightTrim(education);
    }

    /**
     * ��ȡ����ѧ��
     * @return ����ѧ����ֵ
     */
    public String getEducation(){
        return education;
    }

    /**
     * ���������ܹ���
     * @param totalWorkYears �����õ������ܹ����ֵ
     */
    public void setTotalWorkYears(int totalWorkYears){
        this.totalWorkYears = totalWorkYears;
    }

    /**
     * ��ȡ�����ܹ���
     * @return �����ܹ����ֵ
     */
    public int getTotalWorkYears(){
        return totalWorkYears;
    }

    /**
     * �������Ե�λ����
     * @param unit �����õ����Ե�λ���Ƶ�ֵ
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * ��ȡ���Ե�λ����
     * @return ���Ե�λ���Ƶ�ֵ
     */
    public String getUnit(){
        return unit;
    }

    /**
     * �������Ե�λ�绰
     * @param unitPhoneNumber �����õ����Ե�λ�绰��ֵ
     */
    public void setUnitPhoneNumber(String unitPhoneNumber){
        this.unitPhoneNumber = StringUtils.rightTrim(unitPhoneNumber);
    }

    /**
     * ��ȡ���Ե�λ�绰
     * @return ���Ե�λ�绰��ֵ
     */
    public String getUnitPhoneNumber(){
        return unitPhoneNumber;
    }

    /**
     * �������Ե�λ��ַ
     * @param unitAddress �����õ����Ե�λ��ַ��ֵ
     */
    public void setUnitAddress(String unitAddress){
        this.unitAddress = StringUtils.rightTrim(unitAddress);
    }

    /**
     * ��ȡ���Ե�λ��ַ
     * @return ���Ե�λ��ַ��ֵ
     */
    public String getUnitAddress(){
        return unitAddress;
    }

    /**
     * �������Ե�λ�ʱ�
     * @param unitPostCode �����õ����Ե�λ�ʱ��ֵ
     */
    public void setUnitPostCode(String unitPostCode){
        this.unitPostCode = StringUtils.rightTrim(unitPostCode);
    }

    /**
     * ��ȡ���Ե�λ�ʱ�
     * @return ���Ե�λ�ʱ��ֵ
     */
    public String getUnitPostCode(){
        return unitPostCode;
    }

    /**
     * �������Ե�λ����
     * @param unitType �����õ����Ե�λ���͵�ֵ
     */
    public void setUnitType(String unitType){
        this.unitType = StringUtils.rightTrim(unitType);
    }

    /**
     * ��ȡ���Ե�λ����
     * @return ���Ե�λ���͵�ֵ
     */
    public String getUnitType(){
        return unitType;
    }

    /**
     * ����������ְ����
     * @param dutyLevel �����õ�������ְ�����ֵ
     */
    public void setDutyLevel(String dutyLevel){
        this.dutyLevel = StringUtils.rightTrim(dutyLevel);
    }

    /**
     * ��ȡ������ְ����
     * @return ������ְ�����ֵ
     */
    public String getDutyLevel(){
        return dutyLevel;
    }

    /**
     * ����������ְ����
     * @param dutyType �����õ�������ְ�����ֵ
     */
    public void setDutyType(String dutyType){
        this.dutyType = StringUtils.rightTrim(dutyType);
    }

    /**
     * ��ȡ������ְ����
     * @return ������ְ�����ֵ
     */
    public String getDutyType(){
        return dutyType;
    }

    /**
     * �������Լ�ְְҵ/���ִ���
     * @param occupationcode �����õ����Լ�ְְҵ/���ִ����ֵ
     */
    public void setOccupationcode(String occupationcode){
        this.occupationcode = StringUtils.rightTrim(occupationcode);
    }

    /**
     * ��ȡ���Լ�ְְҵ/���ִ���
     * @return ���Լ�ְְҵ/���ִ����ֵ
     */
    public String getOccupationcode(){
        return occupationcode;
    }

    /**
     * �������Է���״��
     * @param houseProperty �����õ����Է���״����ֵ
     */
    public void setHouseProperty(String houseProperty){
        this.houseProperty = StringUtils.rightTrim(houseProperty);
    }

    /**
     * ��ȡ���Է���״��
     * @return ���Է���״����ֵ
     */
    public String getHouseProperty(){
        return houseProperty;
    }

    /**
     * �������Ի������ڵ��ɳ�������
     * @param localPoliceStation �����õ����Ի������ڵ��ɳ������Ƶ�ֵ
     */
    public void setLocalPoliceStation(String localPoliceStation){
        this.localPoliceStation = StringUtils.rightTrim(localPoliceStation);
    }

    /**
     * ��ȡ���Ի������ڵ��ɳ�������
     * @return ���Ի������ڵ��ɳ������Ƶ�ֵ
     */
    public String getLocalPoliceStation(){
        return localPoliceStation;
    }

    /**
     * �������Ծ���ס����
     * @param roomAddress �����õ����Ծ���ס���ص�ֵ
     */
    public void setRoomAddress(String roomAddress){
        this.roomAddress = StringUtils.rightTrim(roomAddress);
    }

    /**
     * ��ȡ���Ծ���ס����
     * @return ���Ծ���ס���ص�ֵ
     */
    public String getRoomAddress(){
        return roomAddress;
    }

    /**
     * ����������������
     * @param roompostcode �����õ��������������ֵ
     */
    public void setRoompostcode(String roompostcode){
        this.roompostcode = StringUtils.rightTrim(roompostcode);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getRoompostcode(){
        return roompostcode;
    }

    /**
     * �������Ա���������
     * @param selfMonthIncome �����õ����Ա����������ֵ
     */
    public void setSelfMonthIncome(double selfMonthIncome){
        this.selfMonthIncome = selfMonthIncome;
    }

    /**
     * ��ȡ���Ա���������
     * @return ���Ա����������ֵ
     */
    public double getSelfMonthIncome(){
        return selfMonthIncome;
    }

    /**
     * �������Լ�ͥ������
     * @param familyMonthIncome �����õ����Լ�ͥ�������ֵ
     */
    public void setFamilyMonthIncome(double familyMonthIncome){
        this.familyMonthIncome = familyMonthIncome;
    }

    /**
     * ��ȡ���Լ�ͥ������
     * @return ���Լ�ͥ�������ֵ
     */
    public double getFamilyMonthIncome(){
        return familyMonthIncome;
    }

    /**
     * ��������������Դ
     * @param incomeSource �����õ�����������Դ��ֵ
     */
    public void setIncomeSource(String incomeSource){
        this.incomeSource = StringUtils.rightTrim(incomeSource);
    }

    /**
     * ��ȡ����������Դ
     * @return ����������Դ��ֵ
     */
    public String getIncomeSource(){
        return incomeSource;
    }

    /**
     * �������Գ�ס���绰
     * @param roomPhone �����õ����Գ�ס���绰��ֵ
     */
    public void setRoomPhone(String roomPhone){
        this.roomPhone = StringUtils.rightTrim(roomPhone);
    }

    /**
     * ��ȡ���Գ�ס���绰
     * @return ���Գ�ס���绰��ֵ
     */
    public String getRoomPhone(){
        return roomPhone;
    }

    /**
     * ������������绰
     * @param mobile �����õ���������绰��ֵ
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * ��ȡ��������绰
     * @return ��������绰��ֵ
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * �������Լ�ͥ�˿�
     * @param familySumQuantity �����õ����Լ�ͥ�˿ڵ�ֵ
     */
    public void setFamilySumQuantity(int familySumQuantity){
        this.familySumQuantity = familySumQuantity;
    }

    /**
     * ��ȡ���Լ�ͥ�˿�
     * @return ���Լ�ͥ�˿ڵ�ֵ
     */
    public int getFamilySumQuantity(){
        return familySumQuantity;
    }

    /**
     * �������Ի���״��
     * @param marriage �����õ����Ի���״����ֵ
     */
    public void setMarriage(String marriage){
        this.marriage = StringUtils.rightTrim(marriage);
    }

    /**
     * ��ȡ���Ի���״��
     * @return ���Ի���״����ֵ
     */
    public String getMarriage(){
        return marriage;
    }

    /**
     * ����������ż����
     * @param spouseName �����õ�������ż������ֵ
     */
    public void setSpouseName(String spouseName){
        this.spouseName = StringUtils.rightTrim(spouseName);
    }

    /**
     * ��ȡ������ż����
     * @return ������ż������ֵ
     */
    public String getSpouseName(){
        return spouseName;
    }

    /**
     * ����������ż��������
     * @param spouseBornDate �����õ�������ż�������µ�ֵ
     */
    public void setSpouseBornDate(DateTime spouseBornDate){
        this.spouseBornDate = spouseBornDate;
    }

   

    /**
     * ����������ż���֤����
     * @param spouseID �����õ�������ż���֤�����ֵ
     */
    public void setSpouseID(String spouseID){
        this.spouseID = StringUtils.rightTrim(spouseID);
    }

    /**
     * ��ȡ������ż���֤����
     * @return ������ż���֤�����ֵ
     */
    public String getSpouseID(){
        return spouseID;
    }

    /**
     * ����������ż��λ
     * @param spouseUnit �����õ�������ż��λ��ֵ
     */
    public void setSpouseUnit(String spouseUnit){
        this.spouseUnit = StringUtils.rightTrim(spouseUnit);
    }

    /**
     * ��ȡ������ż��λ
     * @return ������ż��λ��ֵ
     */
    public String getSpouseUnit(){
        return spouseUnit;
    }

    /**
     * ����������żְ��
     * @param spouseJobTitle �����õ�������żְ���ֵ
     */
    public void setSpouseJobTitle(String spouseJobTitle){
        this.spouseJobTitle = StringUtils.rightTrim(spouseJobTitle);
    }

    /**
     * ��ȡ������żְ��
     * @return ������żְ���ֵ
     */
    public String getSpouseJobTitle(){
        return spouseJobTitle;
    }

    /**
     * ����������ż��λ�绰
     * @param spouseUnitPhone �����õ�������ż��λ�绰��ֵ
     */
    public void setSpouseUnitPhone(String spouseUnitPhone){
        this.spouseUnitPhone = StringUtils.rightTrim(spouseUnitPhone);
    }

    /**
     * ��ȡ������ż��λ�绰
     * @return ������ż��λ�绰��ֵ
     */
    public String getSpouseUnitPhone(){
        return spouseUnitPhone;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getSpouseBornDate() {
		return spouseBornDate;
	}

	public void setSpouseBornDate(Date spouseBornDate) {
		this.spouseBornDate = spouseBornDate;
	}
    
}

