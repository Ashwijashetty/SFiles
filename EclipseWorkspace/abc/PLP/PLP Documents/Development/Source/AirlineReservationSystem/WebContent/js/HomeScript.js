$(function()	{
	 minDate: 0;
		onSelect: function(date) {
	    $("#myDate").datepicker('option', 'minDate', date);
}
});
/*
function validateCity(frm)	{
	var src = frm[2].value;
	var dest = frm[3].value;
	if(src==dest)	{
		alert("Source city and destination city cannot be same");
		return false;	
	}
	return true;	
}



function validateArrCity(frm)	{
	var src = frm[1].value;
	var dest = frm[2].value;
	if(src==dest)	{
		alert("Source city and destination city cannot be same");
		return false;	
	}
	return true;	
}*/