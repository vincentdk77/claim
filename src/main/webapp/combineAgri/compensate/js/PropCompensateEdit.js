
function saveForm(field,saveType)
{
  var errorMessage = ""; 
  var riskType = fm.riskType.value;    //����
  fm.buttonSaveType.value = saveType; 
  field.disabled = true;
  fm.submit(); 
  return true;   	
}
 