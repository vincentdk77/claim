function check_AreasProvince(field,codetype) {
	code_CodeSelect(field,codetype,'-1' ,'name','post','clear');
}

function clear_AreasProvince() {
	if(""==fm.AreasProvinceName.value)
		fm.AreasProvince.value = "";
	fm.AreasCity.value = "";
	fm.AreasCityName.value = "";
	fm.AreasTown.value = "";
	fm.AreasTownName.value = "";
	fm.AreasCountry.value = "";
	fm.AreasCountryName.value = "";
	fm.AreasVillage.value = "";
	fm.AreasVillageName.value = "";
	//deleteAllRichFlyAndFeild();
}

function setAreasCodeAndName(){
	if(fm.AreasVillage.value!=null && ""!=fm.AreasVillage.value){
		fm.AreasCode.value = fm.AreasVillage.value;
		fm.AreasCName.value = fm.AreasVillageName.value;
	}else if (fm.AreasCountry.value!=null && ""!=fm.AreasCountry.value){
		fm.AreasCode.value = fm.AreasCountry.value;
		fm.AreasCName.value = fm.AreasCountryName.value;
	}else if (fm.AreasTown.value!=null && ""!=fm.AreasTown.value){
		fm.AreasCode.value = fm.AreasTown.value;
		fm.AreasCName.value = fm.AreasTownName.value;
	}else if (fm.AreasCity.value!=null && ""!=fm.AreasCity.value){
		fm.AreasCode.value = fm.AreasCity.value;
		fm.AreasCName.value = fm.AreasCityName.value;
	}else if (fm.AreasProvince.value!=null && ""!=fm.AreasProvince.value){
		fm.AreasCode.value = fm.AreasProvince.value;
		fm.AreasCName.value = fm.AreasProvinceName.value;
	}
}

function clear_AreasCity() {
	if(""==fm.AreasCityName.value)
		fm.AreasCity.value = "";
	fm.AreasTown.value = "";
	fm.AreasTownName.value = "";
	fm.AreasCountry.value = "";
	fm.AreasCountryName.value = "";
	fm.AreasVillage.value = "";
	fm.AreasVillageName.value = "";
	//deleteAllRichFlyAndFeild();
}

function clear_AreasTown() {
	if(""==fm.AreasTownName.value)
		fm.AreasTown.value = "";
	fm.AreasCountry.value = "";
	fm.AreasCountryName.value = "";
	fm.AreasVillage.value = "";
	fm.AreasVillageName.value = "";
	//deleteAllRichFlyAndFeild();
}

function clear_AreasCountry() {
	if(""==fm.AreasCountryName.value)
		fm.AreasCountry.value = "";
	fm.AreasVillage.value = "";
	fm.AreasVillageName.value = "";
	//deleteAllRichFlyAndFeild();
}

function clear_AreasVillage() {
	if(""==fm.AreasVillageName.value)
		fm.AreasVillage.value = "";
	// fm.AreasVillage.value = "";
	// fm.AreasVillageName.value = "";
	//deleteAllRichFlyAndFeild();
}
