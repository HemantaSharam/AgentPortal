function validateCreatePolicy() {
    var temp1 = document.getElementById('assuredSum').value;
    var assuredSum = parseInt(temp1,10);
    var temp2 = document.getElementById('tenure').value;
    var tenure = parseInt(temp2,10);


    var flag = true;

    if (assuredSum <= 100000) {
        document.getElementById("sum_error").innerHTML = "<font color=red> Assured sum must be greater than 1Lakh</font>";
        flag = false;
    }
    if (tenure < 2) {
        document.getElementById("tenure_error").innerHTML = "<font color=red> Tenure cannot be greater than 1 year</font>";
        flag = false;
    }
    return flag;
}


function validateCreateBusiness() {
	var temp = document.getElementById('turnOver').value;
	var turnOver = parseInt(temp,10);
	var temp1 = document.getElementById('capitalInvested').value;
	var ci = parseInt(temp1,10);
	var temp2 = document.getElementById('noOfEmployees').value;
	var noe = parseInt(temp2,10);
	var flag = true;
	if (turnOver <= 100000) {
		document.getElementById("turnover_error").innerHTML = "<font color=red> Turnover Must be greater than 1Lakh</font>";
		flag = false;
	}
	if (ci < 10000) {
		document.getElementById("CI_error").innerHTML = "<font color=red>Capital Invested Must be greater than 10,000</font>";
		flag = false;
	}
	if (noe <= 0) {
		document.getElementById("NOE_error").innerHTML = "<font color=red> Number of Employees cannot be 0</font>";
		flag = false;
	}

	return flag;
}

function validateProperty() {
    var temp = document.getElementById('buildingArea').value;
    var buildingArea = parseInt(temp,10);
    var temp1 = document.getElementById('buildingStorey').value;
    var buildingStorey = parseInt(temp1,10);
    var temp2 = document.getElementById('buildingAge').value;
    var buildingAge = parseInt(temp2,10);
    var temp3 = document.getElementById('salvageValue').value;
    var salvageValue = parseInt(temp3,10);
    var temp4 = document.getElementById('costOfAsset').value;
    var costOfAsset = parseInt(temp4,10);
    var temp5 = document.getElementById('usefulLife').value;
    var usefulLife = parseInt(temp5,10);

    var flag = true;


    if (buildingArea < 100) {
        document.getElementById("buildingArea_error").innerHTML = "<font color=red> Building Area must be Greater than 100 SQ.FT.</font>";
        flag = false;
    }

    if (buildingStorey <= 0) {
        document.getElementById("buildingStorey_error").innerHTML = "<font color=red> Please input value greater than 0</font>";
        flag = false;
    }
if (buildingAge <= 0) {
        document.getElementById("buildingAge_error").innerHTML = "<font color=red> Please enter a Valid Age</font>";
        flag = false;
    }
    if (buildingAge >= 100) {
        document.getElementById("buildingAge_error").innerHTML = "<font color=red> No Policy for such Property</font>";
        flag = false;
    }
    if (costOfAsset <= 50000) {
        document.getElementById("COA_error").innerHTML = "<font color=red> No Policy for such property</font>";
        flag = false;
    }

    if (salvageValue > costOfAsset) {
        document.getElementById("SV_error").innerHTML = "<font color=red> Please Enter Correct Salvage Value</font>";
        flag = false;
    }
    if (usefulLife <= 5) {
        document.getElementById("UL_error").innerHTML = "<font color=red>Useful life should be greater than 5</font>";
        flag = false;
    }

    return flag;
}

