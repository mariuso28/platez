<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page trimDirectiveWhitespaces="true" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="../../css/overlaystyle.css">
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<link rel="stylesheet" href="../../css/style.css" />

<html>


<style>



.headingPanel {
			float: left;
			width: 1100px;
			height: 90px;

		}

	.headingPanelMiddle {
			float: left;
			width: 1100px;
			height: 90px;
			margin-left: 20px;
			margin-bottom: 20px;
		}

	.headingPanelRight {
			float: left;
			width: 100px;
			height: 90px;
		}

		.headingPanelLogonHeader {
				float: left;
				width: 1100px;
				height: 18px;
				font-family: myFont;
				font-size: 120%;
				font-style: normal;
				font-weight: 500;
				line-height: 30px;
				color: #28166f;
				margin-left: 0px;
				margin-top: 10px;
			}

			.headingPanelLogonHeaderCell {
					float: left;
					width: 170px;
					height: 12px;
					margin-right: 5px;
					font-family: Arial, Helvetica, sans-serif;
					font-size: 12px;
					font-style: normal;
					font-weight: 700;
					line-height: 18px;
					color: #blue;
					text-align: center;
				}

	.headingPanelMiddleSearchHeader {
			float: left;
			width: 1100px;
			height: 20px;
			font-family: myFont;
			font-size: 120%;
			font-style: normal;
			font-weight: 500;
			line-height: 30px;
			color: #28166f;
			margin-left: 0px;
			margin-top: 10px;
		}

	.headingPanelMiddleSearchHeaderCell {
			float: left;
			width: 65px;
			height: 12px;
			margin-right: 5px;
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			font-style: normal;
			font-weight: 700;
			line-height: 18px;
			color: #aaa;
			text-align: center;
		}

	.headingPanelMiddleSearch{
			float: left;
			height: 60px;
			width: 1100px;
			font-family: myFont;
			font-size: 20px;
			font-style: normal;
			font-weight: bold;
			line-height: 40px;
			color: #d95c00;
			vertical-align: middle;
			margin-left: 0px;
		}

	.headingPanelMiddleSearchCell {
			float: left;
			width: 65px;
			height: 50px;
			margin-right: 5px;
		}

  .headingPanelMiddleSearchSpecialCell {
			float: left;
			width: 150px;
			height: 50px;
			margin-right: 5px;
		}

  .headingPanelMiddleSearchButton {
			float: left;
			width: 120px;
			height: 50px;
			margin-right: 5px;
		}


.prodListContainer {
			float: left;
			height: 100%;
			width: 1100px;
			background-color: #FFF;
		}

		.prodList {
			float: left;
			height: 180px;
			width: 1098px;
			background-color: #00aef0;
			margin-left: 1px;
		}

		.prodListEntry {
			float: left;
			height: 140px;
			width: 200px;
			margin-left: 6px;
			margin-top: 7px;
			margin-right: 3px;
			padding: 4px;
			background-color: #FFF;
			border: solid;
			border-top-width: 1px;
			border-right-width: 1px;
			border-bottom-width: 1px;
			border-left-width: 1px;
		}

    .prodListEntryHeading {
			float: left;
			height: 22px;
			width: 190px;
			background-color: #FFF;
			text-align: center;
			font-family: myFont;
			font-size: 100%;
			font-weight: bold;
		}

    .prodListEntryPrice {
			float: left;
			height: 18px;
			width: 200px;
			text-align: center;
			font-family: myFont;
			font-size: 18px;
			font-weight: normal;
		}

    .numberPlateSpe {
    			font-family: Arial, Helvetica, sans-serif;
    			font-size: 20px;
    			font-weight: 600;
    			text-shadow: 1px 1px 0 #111,
    						  2px 2px 0 #222,
    						  3px 3px 2px #333;
    			color: #fff;
    			background-color:#fce14d;
    			border-radius: 10px;
    			border: 2px solid #666;
    			border-color: #dbc344 #b8a438 #b8a438;
    			box-shadow: 3px 3px 8px #888;
    			width: 180px;
    			height: 50px;
    			text-align: center;
    			line-height: 50px;
    			float: left;
    			margin: 6px;
    			margin-left: 9px;
    			background-image: -webkit-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    			background-image: -moz-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    			background-image: -o-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    			background-image: linear-gradient(to bottom, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    		}

    		.numberPlateSpe2 {
    			font-family: Arial, Helvetica, sans-serif;
    			font-size: 20px;
    			font-weight: 600;
    			text-shadow: 1px 1px 0 #111,
    						  2px 2px 0 #222,
    						  3px 3px 2px #333;
    			color: #fff;
    			background-color:#C0C0C0;
    			border-radius: 10px;
    			border: 2px solid #666;
    			border-color: #dbc344 #b8a438 #b8a438;
    			box-shadow: 3px 3px 8px #888;
    			width: 180px;
    			height: 50px;
    			text-align: center;
    			line-height: 50px;
    			float: left;
    			margin: 6px;
    			margin-left: 9px;
    			background-image: -webkit-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    			background-image: -moz-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    			background-image: -o-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    			background-image: linear-gradient(to bottom, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    		}

    		.numberPlateSpe3 {
    			font-family: Arial, Helvetica, sans-serif;
    			font-size: 20px;
    			font-weight: 600;
    			text-shadow: 1px 1px 0 #111,
    						  2px 2px 0 #222,
    						  3px 3px 2px #333;
    			color: #fff;
    			background-color:#cd7f32;
    			border-radius: 10px;
    			border: 2px solid #666;
    			border-color: #dbc344 #b8a438 #b8a438;
    			box-shadow: 3px 3px 8px #888;
    			width: 180px;
    			height: 50px;
    			text-align: center;
    			line-height: 50px;
    			float: left;
    			margin: 6px;
    			margin-left: 9px;
    			background-image: -webkit-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    			background-image: -moz-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    			background-image: -o-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    			background-image: linear-gradient(to bottom, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0) 50%, rgba(0, 0, 0, 0.12) 51%, rgba(0, 0, 0, 0.04));
    		}

/*-- Publish Plate Modal */

.modal-offer-content {
		width: 730px;
		height: 200px;
		background-color: #fff;
						/*margin: auto;*/
		padding: 10px;
		border: 1px solid #888;
			}

	/* The Close Button */
	.closeOffer {
	color: #333;
	float: right;
	font-size: 28px;
	font-weight: bold;
	line-height: 20px;
	}

	.closeOffer:hover,
	.closeOffer:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
	}

	.offerPanel {
				float: left;
				width: 710px;
				height: 175px;
			}

	.topHiddenOfferBar {
			width: 540px;
			height: 175px;
			background-color: #129c94;
			}

		.offerInfoLine {
			float: left;
			width: 500px;
			height: 20px;
			text-align: left;
			padding-left: 0px;
			font-size: 18px;
		}

	.offerErrorMessage {
		float: left;
		width: 500px;
		height: 20px;
		text-align: left;
		padding-left: 0px;
		 font-size: 18px;
	}

/* PROFILE STUFF */

	.modal-profile-content {
		width: 544px;
		height: 300px;
		background-color: #fff;
		/*margin: auto;*/
		padding: 10px;
		border: 1px solid #888;
	}

	/* The Close Button */
	.closeP {
	color: #333;
	float: right;
	font-size: 28px;
	font-weight: bold;
	line-height: 20px;
	}

	.closeP:hover,
	.closeP:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
	}

	.topBar {
			margin-left: auto;
			margin-right: auto;
			width: 600px;
			height: 104px;
		}

	.profileLogon {
		width: 500px;
		height: 44px;
		/*margin-left: auto;
		margin-right: auto;*/
	}

	.profileTopBar2 {
	width: 500px;
	height: 4px;
	background-color: #129c94;
	}

	.profileTopBar {
	width: 500px;
	height: 44px;
	background-color: #129c94;
	color: #666;
	font-size: 14px;
	line-height: 16px;
	font-weight: 900;
	}

	.profileTopBarMiddle {
	float: left;
	width: 495px;
	height: 40px;
	text-align: left;
	padding-left: 5px;
	}

	.topHiddenBar {
	width: 500px;
	height: 280px;
	background-color: #129c94;
	}

	.profileEntryPanel{
		float: left;
		width: 475px;
		height: 280px;
		text-align: left;
		line-height: 22px;
		padding-left: 5px;
	}

	.profileEntryLine {
		float: left;
		width: 500px;
		height: 28px;
		padding-left: 0px;
		margin-top: 10px;
		margin-bottom: 5px;
	}

	.profileEntryPrompt {
		float: left;
		width: 180px;
		height: 24px;
		text-align: left;
		font-family: myFont;
		font-size: 14px;
		font-weight: 700;
		color: #fff;
		text-shadow: 1px 1px 1px #666;
		line-height: 28px;
		padding-left: 0px;
	}

	.profileEntryInput {
		float: left;
		width: 280px;
		height: 28px;
		text-align: left;
		padding-left: 5px;
	}

	.profileEntryPasswordLine {
		float: left;
		width: 500px;
		height: 28px;
		padding-left: 0px;
	}

	.profileEntryPasswordPrompt {
		float: left;
		width: 180px;
		height: 24px;
		text-align: left;
		font-family: myFont;
		font-size: 14px;
		font-weight: 700;
		color: #fff;
		text-shadow: 1px 1px 1px #666;
		line-height: 28px;
	}

	.profileEntryPasswordInput {
		float: left;
		width: 280px;
		height: 28px;
		text-align: left;
		padding-left: 5px;
		padding-right: 10px;
	}

	.profileEntrySubmitButton {
		float: left;
		width: 70px;
		height: 26px;
		text-align: left;
		padding-left: 5px;
	}

	.profileEntryErrorMessage {
		float: left;
		width: 500px;
		height: 20px;
		text-align: left;
		padding-left: 0px;
		 font-size: 18px;
	}



</style>

<script>

function saveProfile()
{
	err = document.getElementById('profileError');
	err.innerHTML="";

	var email = document.getElementById('email-input');
	var contact = document.getElementById('contact-input');
	var password = document.getElementById('password-input');
	var vpassword = document.getElementById('vpassword-input');
	var phone = document.getElementById('phone-input');

	if (password.value != vpassword.value)
	{
			err.appendChild(document.createTextNode('Password/verify password should match'));
			return;
	}

	var jsonData = {};
	jsonData['email'] = email.value;
	jsonData['contact'] = contact.value;
	jsonData['phone'] = phone.value;
	jsonData['password'] = password.value;

	access_token = sessionStorage.getItem("access_token");
	var bearerHeader = 'Bearer ' + access_token;


	$.ajax({

		type: "POST",
			 url : "/platez/api/agent/updateProfile",
			 headers: { 'Authorization': bearerHeader },
			 cache: false,
			 contentType: 'application/json;',
			 dataType: "json",
			 data:JSON.stringify(jsonData),
				success: function(data) {
					var result = $.parseJSON(JSON.stringify(data));
					if (result.status != 'OK')
					{
						err = document.getElementById('profileError');
						err.appendChild(document.createTextNode(result.message));
						return;
					}
					getAgent();
				},
				error:function (e) {
	  			alert("saveProfile ERROR : " + e.status + " - " + e.statusText);
	      }
	});
}

function setUpModal()
{
	$(document).ready(function(){
		$("#editProfile").click(function(){
				$("#myModalP").modal();
		});
	});
}

var agent;

function getAgent() {

	access_token = sessionStorage.getItem("access_token");
//	alert(access_token);

  var bearerHeader = 'Bearer ' + access_token;
     $.ajax({

    type: "GET",
         url : '/platez/api/agent/getAgent',
    headers: { 'Authorization': bearerHeader },
    cache: false,
    contentType: 'application/json;',
         dataType: "json",
       	 success: function(data) {
  //         alert(JSON.stringify(data));
     			if (data == '')
            {
							alert("could not get agent")
               return null;
            }

          var resultJson = $.parseJSON(JSON.stringify(data));
					if (resultJson.status!='OK')
					{
						alert(resultJson.status + " " + resultJson.message);
					}
					agent = resultJson.result;
					displayAgentProfile();
        },
				error:function (e) {
	  			alert("getAgent ERROR : " + e.status + " - " + e.statusText);
	      }
     });
 }

 function displayAgentPlates() {

 	access_token = sessionStorage.getItem("access_token");
 //	alert(access_token);

   var bearerHeader = 'Bearer ' + access_token;
      $.ajax({

     type: "GET",
          url : '/platez/api/agent/getAgent',
     headers: { 'Authorization': bearerHeader },
     cache: false,
     contentType: 'application/json;',
          dataType: "json",
        	 success: function(data) {
   //         alert(JSON.stringify(data));
      			if (data == '')
             {
 							alert("could not get agent")
                return null;
             }

           var resultJson = $.parseJSON(JSON.stringify(data));
 					if (resultJson.status!='OK')
 					{
 						alert(resultJson.status + " " + resultJson.message);
 					}
 					agent = resultJson.result;
 					displayPlates();
         },
	 				error:function (e) {
	   			alert("displayAgentPlates ERROR : " + e.status + " - " + e.statusText);
	       }
      });
  }

function displayAgentProfile()
{
	// alert(agent.profile.email);
	contact = document.getElementById('contact');
	contact.innerHTML='Hi ' + agent.profile.contact + ' Your Plates Home';
	email = document.getElementById('email');
	email.innerHTML=agent.profile.email;
	phone = document.getElementById('phone');
	phone.innerHTML=agent.profile.phone;

	document.getElementById('email-input').value = agent.profile.email;
	document.getElementById('contact-input').value = agent.profile.contact;
	document.getElementById('phone-input').value = agent.profile.phone;
	document.getElementById('password-input').value = 'Coco2828';
	document.getElementById('vpassword-input').value = 'Coco2828';

	setUpModal();
	setUpPublishModal();
}

function makeOffer(regNo,plateId,listPrice)
{
	var msg = "Please enter your offer for "
								+ regNo + " RM";
	var offer = prompt(msg,listPrice);
	if (offer==null)
		return;

	sendOffer(plateId,offer);
}

function sendOffer(plateId,offer)
{
	var jsonData = {};
  jsonData['plateId'] = plateId;
  jsonData['offer'] = offer;

	access_token = sessionStorage.getItem("access_token");
	var bearerHeader = 'Bearer ' + access_token;

	$.ajax({
		type: "POST",
			 url : "/platez/api/agent/makeOffer",
			 headers: { 'Authorization': bearerHeader },
			cache: false,
			contentType: 'application/json;',
			dataType: "json",
			data:JSON.stringify(jsonData),
			 success: function(data) {
			//    alert(JSON.stringify(data));
					if (data == '')
					{
						 alert('Offer couldnt be made - contact support');
						 return;
					}
					var result = $.parseJSON(JSON.stringify(data));
					if (result.status != 'OK')
					{
						alert(result.message);
						return;
					}
					getAgent();
					getAllPlates();
				},
				error:function (e) {
	  			alert("sendOffer ERROR : " + e.status + " - " + e.statusText);
	      }
		})
}

function viewOffer(regNo)
{
//	 getAgent();
	offer = agent.offers[regNo];
	if (offer.status == 'ACCEPTED')
	{
			alert("Offer status : for " + offer.regNo
							+ " RM" + offer.offer
							+ " - " + offer.status + ' contact agent.');
	}
	else
	if (offer.status == 'REJECTED' || offer.status == 'OFFERED')
	{
		cancel = confirm("Offer status : for " + offer.regNo
						+ " RM" + offer.offer
						+ " - " + offer.status
						+ "\nPRESS OK TO CANCEL AND MAKE ANOTHER?");
		if (cancel)
			cancelOffer(offer.id);
	}
}

function cancelOffer(offerId)
{
	access_token = sessionStorage.getItem("access_token");
	var bearerHeader = 'Bearer ' + access_token;

	$.ajax({
		type: "POST",
		 url : "/platez/api/agent/cancelOffer?offerId="+offerId.toString(),
		 headers: { 'Authorization': bearerHeader },
		cache: false,
		contentType: 'application/json;',
		dataType: "text",
//		data:JSON.stringify(jsonData),
		 success: function(data) {
		//    alert(JSON.stringify(data));
				if (data == '')
				{
					 alert('Offer couldnt be cancelled - contact support');
					 return;
				}
				var result = $.parseJSON(data);
				if (result.status != 'OK')
				{
					alert(result.message);
					return;
				}
				getAgent();
				getAllPlates();
			},
			error:function (e) {
  			alert("cancelOffer ERROR : " + e.status + " - " + e.statusText);
      }
	})
}

function acceptOffer(offerId)
{
	access_token = sessionStorage.getItem("access_token");
	var bearerHeader = 'Bearer ' + access_token;

	$.ajax({
		type: "POST",
		 url : "/platez/api/agent/acceptOffer?offerId="+offerId.toString(),
		 headers: { 'Authorization': bearerHeader },
		cache: false,
		contentType: 'application/json;',
		dataType: "text",
//		data:JSON.stringify(jsonData),
		 success: function(data) {
		//    alert(JSON.stringify(data));
				if (data == '')
				{
					 alert('Offer couldnt be accepted - contact support');
					 return;
				}
				var result = $.parseJSON(data);
				if (result.status != 'OK')
				{
					alert(result.message);
					return;
				}
				getAgent();
				getAllPlates();
			},
			error:function (e) {
  			alert("acceptOffer ERROR : " + e.status + " - " + e.statusText);
      }
	})
}

function rejectOffer(offerId)
{
	access_token = sessionStorage.getItem("access_token");
	var bearerHeader = 'Bearer ' + access_token;

	$.ajax({
		type: "POST",
		 url : "/platez/api/agent/rejectOffer?offerId="+offerId.toString(),
		 headers: { 'Authorization': bearerHeader },
		cache: false,
		contentType: 'application/json;',
		dataType: "text",
//		data:JSON.stringify(jsonData),
		 success: function(data) {
		//    alert(JSON.stringify(data));
				if (data == '')
				{
					 alert('Offer couldnt be rejected - contact support');
					 return;
				}
				var result = $.parseJSON(data);
				if (result.status != 'OK')
				{
					alert(result.message);
					return;
				}
				getAgent();
				getAllPlates();
			},
			error:function (e) {
  			alert("rejectOffer ERROR : " + e.status + " - " + e.statusText);
      }
	})
}

function formatDate(when)
{
    var date=new Date();
    day=date.getDate();
    month=date.getMonth();
    month=month+1;
    if((String(day)).length==1)
    	day='0'+day;
    if((String(month)).length==1)
    	month='0'+month;

    dateT=day+ '.' + month + '.' + date.getFullYear();
  	return dateT;
}

function viewOffers(regNo)
{
	getAgent();
	plateSell = agent.plateSells[regNo];
	var title = document.getElementById("offerTitle");
	var txt = document.createTextNode("Offers for plate " + regNo);
	title.innerHTML = "";
	title.appendChild(txt);

	var ot = document.getElementById("offerTable");
	var cnt = ot.rows.length-1;
	if (cnt>0)
		$('#offerTable tr').slice(cnt*-1).remove();

	plateSell.offers.forEach((offer,i) => {
	  var tr = document.createElement('tr');
		td = document.createElement('td');
		var txt = document.createTextNode(offer.buyerEmail);
  	td.appendChild(txt);
		tr.appendChild(td);
		td = document.createElement('td');
		var txt = document.createTextNode(formatDate(offer.offeredOn));
  	td.appendChild(txt);
		tr.appendChild(td);
		td = document.createElement('td');
		var txt = document.createTextNode(offer.offer.toString());
  	td.appendChild(txt);
		tr.appendChild(td);
		td = document.createElement('td');
		var txt = document.createTextNode(offer.status);
  	td.appendChild(txt);
		tr.appendChild(td);
		td = document.createElement('td');
		if (offer.status=="OFFERED")
		{
			td = document.createElement('td');
			var button = document.createElement("button");
    	button.innerHTML = "Accept";
			funct = "return acceptOffer(" + offer.id + ");"
			button.setAttribute("onclick",funct);
    	td.appendChild(button);
			tr.appendChild(td);
			td = document.createElement('td');
			var button = document.createElement("button");
			funct = "return rejectOffer(" + offer.id + ");"
			button.setAttribute("onclick",funct);
    	button.innerHTML = "Reject";
    	td.appendChild(button);
			tr.appendChild(td);
		}
		ot.appendChild(tr);
	});
	$("#myModalOffer").modal();
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function doClearQuery()
{
  getAllPlates();
  getQueryParams();
}

function doSpecialQuery()
{
  var special = document.getElementById('special');
  var jsonData = {};
  // alert("Cot special : " + special.value);
  jsonData['combo'] = special.value;

  queryPlates(jsonData,'/platez/api/anon/queryDigits');
}

function doParamQuery()
{
  var prefix = document.getElementById('prefix');
  var letter1 = document.getElementById('letter1');
  var letter2 = document.getElementById('letter2');
  var number1 = document.getElementById('number1');
  var number2 = document.getElementById('number2');
  var number3 = document.getElementById('number3');
  var number4 = document.getElementById('number4');
  var suffix = document.getElementById('suffix');

  var jsonData = {};
//  alert(prefix.value+letter1.value+letter2.value+number1.value+number2.value
//        +number3.value+number4.value+suffix.value);

  jsonData['prefix'] = prefix.value;
  jsonData['letter1'] = letter1.value;
  jsonData['letter2'] = letter2.value;
  jsonData['number1'] = number1.value;
  jsonData['number2'] = number2.value;
  jsonData['number3'] = number3.value;
  jsonData['number4'] = number4.value;
  jsonData['suffix'] = suffix.value;

  queryPlates(jsonData,'/platez/api/anon/queryPlate');
}

var plates;

function queryPlates(jsonData,targetUrl) {
		agentToken = sessionStorage.getItem("access_token");

		$.ajax({

    type: "POST",
        url : targetUrl,
        cache: false,
        contentType: 'application/json;',
        dataType: "json",
        data:JSON.stringify(jsonData),
         success: function(data) {
        //    alert(JSON.stringify(data));
	          if (data == '')
            {
               return;
            }

     	      var result = $.parseJSON(JSON.stringify(data));
            if (result.status != 'OK')
            {
              alert(result.message);
              return;
            }
            plates = result.result;
          //  alert('Plates # ' + plates.length);
            displayAgentPlates();
          },
					error:function (e) {
		  			alert("queryPlates ERROR : " + e.status + " - " + e.statusText);
		      }
      })
}


function getAllPlates() {

     $.ajax({

    type: "GET",
         url : '/platez/api/anon/getAllPlates',
    cache: false,
 	 contentType: 'application/json;',
         dataType: "json",
           success: function(data) {
        //    alert(JSON.stringify(data));
	          if (data == '')
            {
               return;
            }

     	      var result = $.parseJSON(JSON.stringify(data));
            if (result.status != 'OK')
            {
              alert(result.message);
              return;
            }
            plates = result.result;
      //      alert('Plates # ' + plates.length);
            displayAgentPlates();
          },
					error:function (e) {
		  			alert("getAllPlates ERROR : " + e.status + " - " + e.statusText);
		      }
      })
}

var queryParams;

function getQueryParams() {

     $.ajax({

    type: "GET",
         url : '/platez/api/anon/getQueryParams',
    cache: false,
 	 contentType: 'application/json;',
         dataType: "json",
        // data: {key:key },
         success: function(data) {
        //    alert(JSON.stringify(data));
	          if (data == '')
            {
               return;
            }
	  //  jdata = JSON.parse(data)

     	      var result = $.parseJSON(JSON.stringify(data));
            if (result.status != 'OK')
            {
              alert(result.message);
              return;
            }
            queryParams = result.result;
            displayQueryParams();
          },
					error:function (e) {
		  			alert("getQueryParams ERROR : " + e.status + " - " + e.statusText);
		      }
      })
}

function displayQueryParams()
{
    var pf = document.getElementById('prefix');
    queryParams.prefix.forEach((choice,i) => {
      var option = createOption(choice);
      pf.appendChild(option);
    });
    var l1 = document.getElementById('letter1');
    queryParams.letter1.forEach((choice,i) => {
      var option = createOption(choice);
      l1.appendChild(option);
    });
    var l2 = document.getElementById('letter2');
    queryParams.letter2.forEach((choice,i) => {
      var option = createOption(choice);
      l2.appendChild(option);
    });
    var n1 = document.getElementById('number1');
    queryParams.number1.forEach((choice,i) => {
      var option = createOption(choice);
      n1.appendChild(option);
    });
    var n2 = document.getElementById('number2');
    queryParams.number2.forEach((choice,i) => {
      var option = createOption(choice);
      n2.appendChild(option);
    });
    var n3 = document.getElementById('number3');
    queryParams.number3.forEach((choice,i) => {
      var option = createOption(choice);
      n3.appendChild(option);
    });
    var n4 = document.getElementById('number4');
    queryParams.number4.forEach((choice,i) => {
      var option = createOption(choice);
      n4.appendChild(option);
    });
    var sf = document.getElementById('suffix');
    queryParams.suffix.forEach((choice,i) => {
      var option = createOption(choice);
      sf.appendChild(option);
    });
    var sp = document.getElementById('special');
    queryParams.specials.forEach((choice,i) => {
      var option = document.createElement('option');
      option.value = choice[1];
      option.text = choice[0];
      sp.appendChild(option);
    });

/* PUBLISH CONTENT */

		var pf = document.getElementById('prefixP');
    queryParams.prefix.forEach((choice,i) => {
      var option = createOption(choice);
      pf.appendChild(option);
    });
    var l1 = document.getElementById('letter1P');
    queryParams.letter1.forEach((choice,i) => {
      var option = createOption(choice);
      l1.appendChild(option);
    });
    var l2 = document.getElementById('letter2P');
    queryParams.letter2.forEach((choice,i) => {
      var option = createOption(choice);
      l2.appendChild(option);
    });
    var n1 = document.getElementById('number1P');
    queryParams.number1.forEach((choice,i) => {
      var option = createOption(choice);
      n1.appendChild(option);
    });
    var n2 = document.getElementById('number2P');
    queryParams.number2.forEach((choice,i) => {
      var option = createOption(choice);
      n2.appendChild(option);
    });
    var n3 = document.getElementById('number3P');
    queryParams.number3.forEach((choice,i) => {
      var option = createOption(choice);
      n3.appendChild(option);
    });
    var n4 = document.getElementById('number4P');
    queryParams.number4.forEach((choice,i) => {
      var option = createOption(choice);
      n4.appendChild(option);
    });
    var sf = document.getElementById('suffixP');
    queryParams.suffix.forEach((choice,i) => {
      var option = createOption(choice);
      sf.appendChild(option);
    });
}

function createOption(choice)
{
  var option = document.createElement('option');
  option.value = choice;
  option.text = choice;
  return option;
}

function displayPlates()
{
    document.getElementById('pc').innerHTML="";
/*
		pl = document.createElement('div');
		pl.className = 'prodList'
		document.getElementById('pc').appendChild(pl);
		var pe = document.createElement('div');
		pe.className = 'prodListEntry';
		var aImg = document.createElement('img');
		aImg.src = '../../img/add.png';
		funct = "return publishPlate();";
		aImg.setAttribute("onclick",funct);
		pe.appendChild(aImg);
		pl.appendChild(pe);
*/
    plates.forEach((plate, i) => {
	/*		if (i>0)
			{
			*/
		    var pe = document.createElement('div');
		    pe.className = 'prodListEntry';

		    var peh = document.createElement('div');
		    peh.className = 'prodListEntryHeading';

				var np = document.createElement('div');
		    if (plate.rating==1)
		    {
		      np.className = 'numberPlateSpe';
		    }
		    else
		    if (plate.rating==2)
		    {
		      	np.className = 'numberPlateSpe2';
		    }
		    else {
		    	np.className = 'numberPlateSpe3';
		    }
				np.appendChild(document.createTextNode(plate.regNo));
				peh.appendChild(np);

		    pe.appendChild(peh);
		    var pp = document.createElement('div');
		    pp.className = 'prodListEntryPrice';
		    var price = numberWithCommas(plate.listPrice);
		    pp.appendChild(document.createTextNode('RM'+price));
		    peh.appendChild(pp);

				var sell = agent.plateSells[plate.regNo];
				pp.appendChild(document.createElement('br'));
				displayPlate = false;
				if (sell != null)
				{
					displayPlate = true;
					if (sell.status == 'SUBMITTED')
						pp.appendChild(document.createTextNode('PENDING');
					else
					if (sell.status == 'RESUBMITPROOF')
					{
						var aTag = document.createElement('a');
						aTag.setAttribute('href',"#");
						funct = "return resubmitProof('" + plate.id + "');"
						aTag.setAttribute("onclick",funct);
						aTag.innerHTML = "RESUBMIT PROOF";
						aTag.style.color = 'RED';
						pp.appendChild(aTag);
					}
					else
					if (sell.status == 'TRANSACT')
						pp.appendChild(document.createTextNode('TRANSACTING');
					else
					if (sell.status == 'APPROVED')
					{
						if (sell.offersDistinctCount==0)
							pp.appendChild(document.createTextNode("Offers : " + sell.offersDistinctCount));
						else {
							var aTag = document.createElement('a');
							aTag.setAttribute('href',"#");
							funct = "return viewOffers('" + plate.regNo + "');"
							aTag.setAttribute("onclick",funct);
							aTag.innerHTML = "Offers : " + sell.offersDistinctCount;
							aTag.style.color = 'BLUE';
							pp.appendChild(aTag);
						}
					}
				}
				else {
					var offer = agent.offers[plate.regNo];
					if (offer!=null)
					{
					//	pp.appendChild(document.createTextNode("Offer : " + offer.offer));
						var aTag = document.createElement('a');
						aTag.setAttribute('href',"#");
						funct = "return viewOffer('" + plate.regNo + "');"
						aTag.setAttribute("onclick",funct);
						if (offer.status == 'REJECTED')
							aTag.style.color = 'RED';
						else
						if (offer.status == 'ACCEPTED')
							aTag.style.color = 'GREEN';
						else
						if (offer.status == 'OFFERED')
							aTag.style.color = 'ORANGE';

						aTag.innerHTML = "Offer : " + offer.offer;
						pp.appendChild(aTag);
					}
					else
					{
						if (sell.status == 'APPROVED')
						{
							var aTag = document.createElement('a');
							aTag.setAttribute('href',"#");
							funct = "return makeOffer('" + plate.regNo + "',"
												+ plate.id + "," + plate.listPrice + ");"
							aTag.setAttribute("onclick",funct);
							aTag.innerHTML = "Make An Offer";
							pp.appendChild(aTag);
							displayPlate = true;
						}
				  }
				}
				if (displayPlate)
				{
		    	if (!(i % 5)) {
		        pl = document.createElement('div');
		        pl.className = 'prodList'
		        document.getElementById('pc').appendChild(pl);
		    	}
		    	pl.appendChild(pe);
				}
  });
}

</script>


<head>

</head>
<body>

	<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
	<div class="headingPanelLogonHeader">
		<div class="headingPanelLogonHeaderCell" id='contact'>
			contact
		</div>
		<div class="headingPanelLogonHeaderCell" id='email'>
			email
		</div>
		<div class="headingPanelLogonHeaderCell" id='phone'>
			123456789
		</div>
		<div class="headingPanelLogonHeaderCell">
			<a id='editProfile' href="#">Edit Profile</a>
		</div>
		<div class="headingPanelLogonHeaderCell">
			<a id='publishPlate' href="#">Publish Plate</a>
		</div>
		<div class="headingPanelLogonHeaderCell">
			<a href="/platez/web/anon/getAllPlates">Home</a>
		</div>

<div id="myModalP" class="modal fade" role="dialog">
	<div class="modal-dialog" style="width=520px">
			<div class="modal-content" style="width=520px">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" style="width=520px">Edit Profile</h4>
					</div>
					<div class="modal-body" style="width=520px">
<!--				<span class="closeP">&times;</span>  -->
						<div id="#129c94r2P" class="topHiddenBar">
							<div class="profileEntryPanel">
								<div class="profileEntryLine">
									<div class="profileEntryPrompt">
										Email:
									</div>
									<div class="profileEntryInput">
											<input id="email-input" type="text" readonly
																	value="" style="height: 26px; width: 240px; font-size: 14px; "/>
									</div>
								</div>
								<div class="profileEntryLine">
									<div class="profileEntryPrompt">
										Contact:
									</div>
									<div class="profileEntryInput">
											<input id="contact-input" type="text"
																	value="" style="height: 26px; width: 240px; font-size: 14px; "/>
									</div>
								</div>
								<div class="profileEntryPasswordLine">
									<div class="profileEntryPasswordPrompt">
													Password:
									</div>
									<div class="profileEntryPasswordInput">
												<input id="password-input" type="password"
													 style="height: 26px; width: 240px; font-size: 14px; "/>
									</div>
								</div>
								<div class="profileEntryPasswordLine">
									<div class="profileEntryPasswordPrompt">
													Verify Password:
									</div>
									<div class="profileEntryPasswordInput">
												<input id="vpassword-input" type="password"
													 style="height: 26px; width: 240px; font-size: 14px; "/>
									</div>
								</div>
								<div class="profileEntryLine">
									<div class="profileEntryPrompt">
										Phone:
									</div>
									<div class="profileEntryInput">
											<input id="phone-input" type="text"
																	value="" style="height: 26px; width: 240px; font-size: 14px; "/>
									</div>
								</div>
								<div class="profileEntrySubmitButton">
										<input type="button" id="profile" value="Save Profile"
											onClick="return saveProfile()"
											class="btn btn-primary"
											style="height: 26px; line-height:0px; font-weight:700; text-shadow:1px 1px 1px #666;" />
								</div>
							</br>
								<div class="profileEntryErrorMessage" id='profileError'>
								</div>
							</div>  <!-- profileEntryPanel -->
						</div>  <!-- topHiddenBar -->
					</div>
			</div>
		</div>
	</div>
</div>  <!-- modalP  -->
<div id="myModalOffer" class="modal fade" role="dialog">
	<div class="modal-dialog" style="width=520px">
			<div class="modal-content" >
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id='offerTitle'</h4>
					</div>
					<div class="modal-body" >
							<div id="#129c94r2P" class="topHiddenOfferBar">
									<div class="offerPanel">
										<div style="height:400px; overflow:auto">
											<table id="offerTable" border="0"
															style="width:520px;" align="left">
	    								<colgroup>
												<col span="1" style="width: 30%;">
       									<col span="1" style="width: 20%;">
       									<col span="1" style="width: 10%;">
												<col span="1" style="width: 20%;">
       									<col span="1" style="width: 15%;">
												<col span="1" style="width: 15%;">
	   								</colgroup>
	    							<tr style="font-family:verdana; color:LightYellow;">
											<td>Buyer</td>
											<td>Date</td>
											<td>Offer</td>
											<td>Status</td>
											<td></td>
											<td></td>
	    								</tr>
										</table>
									</div>
									<div class="offerErrorMessage" id='offerError'>
									</div>
									</div>  <!-- offerPanel -->
								</div>  <!-- topHiddenBar -->
						</div>
				</div>  <!-- modal-content  -->
			</div>
</div>  <!-- myModalOffer  -->

  <div class="headingPanel">
				<div class="headingPanelMiddle">
					<div class="headingPanelMiddleSearchHeader">
            <div class="headingPanelMiddleSearchHeaderCell">
								Prefix
						</div>
            <div class="headingPanelMiddleSearchHeaderCell">
								Letter
						</div>
            <div class="headingPanelMiddleSearchHeaderCell">
								Letter
						</div>
            <div class="headingPanelMiddleSearchHeaderCell">
								Number
						</div>
            <div class="headingPanelMiddleSearchHeaderCell">
								Number
						</div>
            <div class="headingPanelMiddleSearchHeaderCell">
								Number
						</div>
            <div class="headingPanelMiddleSearchHeaderCell">
								Number
						</div>
            <div class="headingPanelMiddleSearchHeaderCell">
								Suffix
						</div>
          	<div class="headingPanelMiddleSearchHeaderCell">
          	</div>
						<div class="headingPanelMiddleSearchHeaderCell">
          	</div>
        		<div class="headingPanelMiddleSearchHeaderCell">
            	Specials
        		</div>
			</div>  <!-- headingPanelMiddleSearchHeader -->

		<div class="headingPanelMiddleSearch">
						<div class="headingPanelMiddleSearchCell">
							<select name='prefixdd' id='prefix' style="width: 65px;
											height: 50px; font-family:myFont; font-size: 16px; padding-left: 15px;">
							</select>
						</div>
            <div class="headingPanelMiddleSearchCell">
							<select name='letter1dd' id='letter1' style="width: 65px;
											height: 50px; font-family:myFont; font-size: 16px; padding-left: 15px;">
							</select>
						</div>
            <div class="headingPanelMiddleSearchCell">
							<select name='letter2dd' id='letter2' style="width: 65px;
											height: 50px; font-family:myFont; font-size: 16px; padding-left: 15px;">
							</select>
						</div>
            <div class="headingPanelMiddleSearchCell">
							<select name='number1dd' id='number1' style="width: 65px;
											height: 50px; font-family:myFont; font-size: 16px; padding-left: 15px;">
							</select>
						</div>
            <div class="headingPanelMiddleSearchCell">
							<select name='number2dd' id='number2' style="width: 65px;
											height: 50px; font-family:myFont; font-size: 16px; padding-left: 15px;">
							</select>
						</div>
            <div class="headingPanelMiddleSearchCell">
							<select name='number3dd' id='number3' style="width: 65px;
											height: 50px; font-family:myFont; font-size: 16px; padding-left: 15px;">
							</select>
						</div>
            <div class="headingPanelMiddleSearchCell">
							<select name='number4dd' id='number4' style="width: 65px;
											height: 50px; font-family:myFont; font-size: 16px; padding-left: 15px;">
							</select>
						</div>
            <div class="headingPanelMiddleSearchCell">
							<select name='suffix' id='suffix' style="width: 65px;
											height: 50px; font-family:myFont; font-size: 16px; ">
							</select>
						</div>
          <div class="headingPanelMiddleSearchButton">
          <input name="query1" value="Search" type="button"
              onClick="return doParamQuery()" style=
              "font-family: myFont; color: green; font-size:20px; font-weight:700; "/>
          </div>
          <div class="headingPanelMiddleSearchSpecialCell">
            <select name='specialdd' id='special' style="width: 150px;
                    height: 50px; font-family:myFont; font-size: 16px; padding-left: 15px;">
            </select>
          </div>
          <div class="headingPanelMiddleSearchButton">
          <input name="query2" value="Search" type="button"
              onClick="return doSpecialQuery()" style=
              "font-family: myFont; color: green; font-size:20px; font-weight:700; "/>
          </div>
          <div class="headingPanelMiddleSearchButton">
          <input name="clear" value="Clear" type="button"
              onClick="return doClearQuery()" style="
              font-family: myFont; color: green; font-size:20px; font-weight:700; "/>
          </div>

      </div>
		</div>
  </div>
  <div id='pc' class='prodListContainer'>
  </div>
</div>
</body>
<script>
	getAgent();
  getAllPlates();
  getQueryParams();
</script>
</html>
