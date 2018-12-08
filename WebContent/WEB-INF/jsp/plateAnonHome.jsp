<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="refresh" content="30;url=/pkfz/px4/bidder/backToBidderHome" >
	<meta http-equiv="Pragma" content="no-cache">

	<title>plateBidderHome</title>

	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-45865892-2', 'auto');
	  ga('send', 'pageview');

	</script>


	<style type="text/css">
		@font-face {
			 font-family: myFont;
			src:url(../../fonts/Exo2-Regular.otf);
			font-weight: normal;
			font-style: normal;
		}

		a {
			text-decoration:none;
			color: inherit;

		}

		.middle > * {
			vertical-align: middle;
		}

		.ticker {
			height: 120px;
			width: 1100px;
			background-color: #e4e3e2;
			margin-left: auto ;
				margin-right: auto ;
		}
		.tickerheading {
			height: 20px;
			width: 100%;
			margin-left: auto ;
				margin-right: auto ;
		}
		.tickerthumbs {
			height: 130px;
			width: 130px;
			border-bottom-left-radius: 10px;
			border-bottom-right-radius: 10px;
			border-top-left-radius: 10px;
			border-top-right-radius: 10px;
			padding: 10px;
		}

		.topHeading {
			height: 30px;
			width: 1070px;
			background-color: #00aef0;
			margin-left: auto ;
			 margin-right: auto ;
			font-size: 24px;
			font-style: normal;
			font-weight: bold;
			color: #FFF;
			padding: 15px;
			float: left;
			box-sizing: content-box;
			font-family: myFont;
		}

		.header {
			float: left;
			width: 1098px;
			height: 180px;
			margin-left: auto ;
			margin-right: auto ;
			border: 1px solid #37ca4c;

		}

		.headerLeft {
			float: left;
			width: 200px;
			height: 30px;
		}


		.headerBidderLogo {
			float: left;
			width: 200px;
			height: 150px;
		}

		.updateProfile {
			float: left;
			width: 200px;
			height: 30px;
			font-family: myFont;
			font-size: 14px;
			font-style: normal;
			font-weight: 500;
			line-height: 25px;
			margin-top: 3px;
		}

		.dropDown {
			font-family: myFont;
			font-size: 16px;
			font-style: normal;
			font-weight: 500;
			line-height: 25px;
			color: red;

		}

		.headerWelcome {
			float: left;
			width: 728px;
			height: 200px;
		}

		.headerWelcomeText {
			float: left;
			width: 700px;
			height: 20px;
			font-family: myFont;
			font-size: 16px;
			font-style: normal;
			font-weight: 500;
			line-height: 25px;
			color: #28166f;
			margin-left: 5px;
		}

		.headerWelcomeTextHalf {
			float: left;
			width: 340px;
			height: 20px;
			font-family: myFont;
			font-size: 16px;
			font-style: normal;
			font-weight: 500;
			line-height: 25px;
			color: #28166f;
			margin-left: 5px;
		}

		.headerWelcomeTextAddress {
			float: left;
			width: 700px;
			height: 40px;
			font-family: myFont;
			font-size: 16px;
			font-style: normal;
			font-weight: 500;
			line-height: 25px;
			color: #28166f;
			margin-left: 5px;
		}

		.mallSelection {
			float: left;
			height: 30px;
			width: 340px;
			background-color: #FFF;
			padding: 2px;
			padding-top: 20px;
			font-family: myFont;
			font-size: 16px;
			font-style: normal;
			font-weight: bold;
			color: #d95c00;
		}

		.headerLogo {
			float: left;
			width: 160px;
			height: 160px;
			text-align: right;
			margin-right: 10px;
		}

		.headerLogout {
			float: left;
			width: 160px;
			height: 30px;
			font-family: myFont;
			font-size: 16px;
			font-style: normal;
			font-weight: bold;
			color: #d95c00;
			text-align: right;
			margin-right: 10px;
		}

		.listingHeading{
			float: left;
			height: 20px;
			width: 1100px;
			font-family: myFont;
			font-size: 24px;
			font-style: normal;
			font-weight: bold;
			line-height: 20px;
			color: #d95c00;
			padding: 10px;
			vertical-align: top;
		}

		.headingPanel {
			float: left;
			width: 1100px;
			height: 90px;
		}

		.headingPanelLeft {
			float: left;
			width: 150px;
			height: 90px;
			font-family: myFont;
			font-size: 24px;
			font-style: normal;
			font-weight: bold;
			line-height: 40px;
			color: #d95c00;
			vertical-align: middle;
			margin-left: 0px;
		}

		.headingPanelMiddle {
			float: left;
			width: 930px;
			height: 90px;
			margin-left: 20px;
		}

		.headingPanelRight {
			float: left;
			width: 100px;
			height: 90px;

		}

		.headingPanelMiddleSearchHeader {
			float: left;
			width: 800px;
			height: 20px;
			font-family: myFont;
			font-size: 18px;
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
			width: 950px;
			font-family: myFont;
			font-size: 24px;
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

		.headingPanelLeftJoinMall {
			float: left;
			height: 30px;
			width: 150px;
			margin-top: 14px;
			margin-left: auto;
			margin-right: auto;
			font-size: 16px;
			font-style: normal;
			line-height: 28px;
			text-align: center;
			color: #FFF;
			background-color: #009900;
			border-radius: 15px;
			border: 0px solid #999;
			box-shadow: 1px 1px 2px #666;
			text-shadow: 1px 1px #aaa;
		}

		.headingPanelLeftJoinMallMsg {
			float: left;
			height: 15px;
			width: 150px;
			margin-top: 0px;
			font-size: 14px;
			font-style: normal;
			line-height: 20px;
			text-align: center;
			color: #009900;
		}

		.headingSearchHeader {
			float: left;
			width: 1100px;
			height: 30px;
			font-family: myFont;
			font-size: 18px;
			font-style: normal;
			font-weight: 500;
			line-height: 30px;
			color: #28166f;
			margin-left: 200px;
		}

		.headingSearch{
			float: left;
			height: 60px;
			width: 1100px;
			font-family: myFont;
			font-size: 24px;
			font-style: normal;
			font-weight: bold;
			line-height: 40px;
			color: #d95c00;
			vertical-align: middle;
			margin-left: 200px;
		}

		.prodListContainer {
			float: left;
			height: 100%;
			width: 1100px;
			background-color: #FFF;
		}

		.prodList {
			float: left;
			height: 100%;
			width: 1098px;
			background-color: #00aef0;
			margin-left: 1px;
		}
		#image1 {
				position: absolute;
				top: 40px;
				left: 40px;
		}

		#image2 img {
		width: 80%;
		}

		.prodListEntry {
			float: left;
			height: 280px;
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

		.prodListEntryPicOverlay {
			position: relative;
			width: 200px;
			top: -50px;
			left: 0px;
			z-index: 2;
			opacity: 0.5;
		}

		.prodListEntryPic {
			height: 140px;
			width: 200px;
			background-color: #FFF;
			margin-bottom: 20px;
			text-align: center;
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

		.prodListEntryDesc {
			float: left;
			height: 18px;
			width: 190px;
			background-color: #FFF;
			text-align: center;
			font-family: myFont;
			font-size: 80%;
			font-weight: normal;
		}

		.tickerbelt {
			height: 130px;
			width: 100%;
		}
		.main {
			height: 100%;
			width: 1100px;
			border-top-style: none;
			border-right-style: none;
			border-bottom-style: none;
			border-left-style: none;
			border-top-width: 0px;
			border-right-width: 0px;
			border-bottom-width: 0px;
			border-left-width: 0px;
			margin-left: auto;
			 margin-right: auto;
		}

		.chartgroup {
			float: left;
			height: 180px;
			width: 380px;
			border-top-width: 0px;
			border-right-width: 0px;
			border-bottom-width: 0px;
			border-left-width: 0px;
			border-top-style: none;
			border-right-style: none;
			border-bottom-style: none;
			border-left-style: none;
			padding: 10px;
		}

		.footer {
			height: 20px;
				width: 100%;
			padding-top: 5px;
				background-color: white;
			font-size: small;
			text-align: center;
				position: fixed;
				bottom: 0;
				z-index: 2;
		}

		.buffer30 {
			height: 30px;
				width: 100%;
				z-index: 2;
		}

		table, th, td {
				border-top: 1px solid black;
				border-bottom: 1px solid black;
				border-collapse: collapse;
		}
		th,td {
				padding: 4px;
				padding-top: 1px;
				padding-bottom: 1px;
			text-align: left;
			font-family: myFont;
			font-size: small;
			font-style: normal;
		}

		th {
			font-weight: bold;
		}

		td {
			font-weight: normal;
		}

		/* grid */
		.row {
			margin: 0 -10px;
			margin-bottom: 20px;
		}
		.row:last-child {
			margin-bottom: 0;
		}
		[class*="col-"] {
			padding: 5px;
		}

		.catTabStrip {
			float: left;
			height: 20px;
			width: 1100px;
			background-color: #FFF;
		}

		.catTab {
			float: left;
			height: 20px;
			width: 140px;
			margin-left: 1px;
			padding-left: 6px;
			border-radius: 10px 10px 0px 0px;
			background-color: #00aef0;
			color: #ccc;
			font-family: myFont;
			font-size: 100%;
			font-style: bold;
			text-decoration: none;
		}

		#catTab a:focus {
			color: #fff;

		}

		.mapcontainer{
				margin-left: auto;
				margin-right: auto;
			height: 390px;
			width: 1100px;
		}

		.mapdiv {
			float: left;
			height: 390px;
			width: 520px;
			padding-right: 10px;
		}

		.svmapdiv {
			float: left;
			height: 390px;
			width: 260px;
		}

		.mapgap {
			float: left;
			height: 390px;
			width: 35px;
		}

	</style>

</head>

<script type="text/javascript">

function swapBidderMallFunc(upEmail)
	{
		//alert('INN : ' + upEmail);
		if (upEmail == 'Your Malls')
			return;

		oFormObject = document.forms['myForm'];
		var field = "command.mallUpEmail";
		oformElement = oFormObject.elements[field];
		oformElement.value = upEmail;

		var myin = document.createElement('input');
		myin.type='hidden';
		myin.name='selectBidderMall';
		myin.value='MaHa';
		oFormObject.appendChild(myin);
		oFormObject.submit();

	}

function swapAvailableMallFunc(upEmail)
	{
		if (upEmail == 'Available Malls')
			return;

		oFormObject = document.forms['myForm'];
		var field = "command.mallUpEmail";
		oformElement = oFormObject.elements[field];
		oformElement.value = upEmail;

		var myin = document.createElement('input');
		myin.type='hidden';
		myin.name='selectAvailableMall';
		myin.value='MaHa';
		oFormObject.appendChild(myin);
		oFormObject.submit();
	}

	function submitSpecialQuery(value)
			{
			//	alert('In with ' + value);
				oFormObject = document.forms['myForm'];
				var field = "command.queryValueList[2][0]";
				oformElement = oFormObject.elements[field];
				oformElement.value = value;

				var myin = document.createElement('input');
				myin.type='hidden';
				myin.name='query2';
				myin.value='MaHa';
				oFormObject.appendChild(myin);

	//			alert('submitting');
				oFormObject.submit();
			}

			function submitSpecialQuery3(value)
					{
					//	alert('In with ' + value);
						oFormObject = document.forms['myForm'];
						var field = "command.queryValueList[3][0]";
						oformElement = oFormObject.elements[field];
						oformElement.value = value;

						var myin = document.createElement('input');
						myin.type='hidden';
						myin.name='query3';
						myin.value='MaHa';
						oFormObject.appendChild(myin);

			//			alert('submitting');
						oFormObject.submit();
					}

</script>

<body>

<form:form id="myForm" method="post" action="/pkfz/px4/bidder/submit"
	modelAttribute="pkfzBidderHomeForm">
<div class="main">
	<input type="hidden" name="command.mallUpEmail" value="XXX" />
	<div class="topHeading">
		Bidder Home
	</div>   <!-- topHeading -->

	<div class="header">
		<div class="headerLeft">
			<div class="headerBidderLogo">
				<img src="../../images/${currBidder.image}" width="150" height="150" alt="Bidder Logo" />
			</div>
			<div class="updateProfile">
				<input name="editProfile"
		      	value="Update Your Profile" type="submit"
		      	style="font-family:inherit; font-size:16px; font-weight: bold;"/>
			</div>
		</div>
		<div class="headerWelcome">
			<div class="headerWelcomeTextHalf">
				Welcome <b>${currBidder.email}</b>!
			</div>
			<div class="headerWelcomeTextHalf">
				Your last login was on:
				<fmt:formatDate value="${currBidder.lastLoggedIn}" pattern="dd MMM yyyy"/>
				at <fmt:formatDate value="${currBidder.lastLoggedIn}" pattern="HH:mm"/>
			</div>
			<div class="headerWelcomeTextHalf">
				Name: ${currBidder.name}</b>
			</div>
			<div class="headerWelcomeTextHalf">
				Email: ${currBidder.email}</b>
			</div>
			<div class="headerWelcomeTextHalf">
				Phone: ${currBidder.phone}</b>
			</div>
			<div class="headerWelcomeTextHalf">
				IC/Passport: ${currBidder.icPassport}</b>
			</div>

			<div class="headerWelcomeTextHalf">
				Mobile Phone: ${currBidder.mobphone}</b>
			</div>
			<div class="headerWelcomeTextAddress">
				Address: ${currBidder.address}</b>
			</div>

			<div class="mallSelection">
		      <span class="dropDown">
		      	<c:choose>
				      <c:when test="${fn:length(currBidder.malls)==0}">
					     You Have Not Joined Any Mall.
			  		 	</c:when>
			  		 	<c:otherwise>
			      	<form:select path="" onchange="swapBidderMallFunc(value);">
			      		<option value="">
					      		 Your Malls
				  		 	</option>
					      <c:forEach items="${currBidder.malls}" var="mall" >
				  		 		<option value=${mall.upEmail}>
					      		${mall.name}
				  		 		</option>
				  		 	</c:forEach>
		  		 		</form:select>
		  		 	</c:otherwise>
		  		 	</c:choose>
	  		 	</span>
	      </div> <!-- mallSelection -->
			<div class="mallSelection">
			<c:if test="${fn:length(pkfzBidderHomeForm.mallSummaries)>0}">
		     		<form:select path="" onchange="swapAvailableMallFunc(value);">
		      	<option value="">
					      Available Malls
				  	</option>
			      <c:forEach items="${pkfzBidderHomeForm.mallSummaries}" var="mall" >
			      	<option value=${mall.upEmail}>
		  		 			${mall.name}
		  		 		</option>
		  		 	</c:forEach>
	  		 	</form:select>
	  		 </c:if>
	      </div> <!-- mallSelection -->
		</div>
		<div class="headerLogo">
			<img src="../../images/${currMall.image}" width="120" height="120" />
		</div>  <!-- headerLogo -->
		<div class="headerLogout">
			<a href="/pkfz/px4/logon/signin">Logout</a>
		</div>  <!-- headerLogout -->
	</div>


		<div class="listingHeading">
			<c:if test="${currUserMall==true}">
				Auctioning Products in
			</c:if>
			${currMall.name}
			<c:choose>
				<c:when test="${currMall.auctionType=='AUCTIONTYPEHAMMER'}">
						<img src="../../images/Gavel-A_01.png" width="30" height="30" style="margin-left: 10px;"/>
				</c:when>
				<c:otherwise>
						<img src="../../images/Connected-D_01.png" width="30" height="30" style="margin-left: 10px;"/>
				</c:otherwise>
			</c:choose>
		</div>  <!-- listingHeading -->
		<div class="headingPanel">
			<c:if test="${pkfzBidderHomeForm.queries!=null}">
				<div class="headingPanelLeft">
					<c:if test="${pkfzBidderHomeForm.joinFlag==true}">
						<div class="headingPanelLeftJoinMall">
							<a href="select?joinMall">Join Mall</a>
						</div>
						<div class="headingPanelLeftJoinMallMsg">
							to Participate
						</div>
						<div class="headingPanelLeftJoinMallMsg">
							in Auctions
						</div>
					</c:if>
					<div style="line-height:110px; text-align:right;">Filter:</div>
				</div>	<!-- headingPanelLeft -->

				<div class="headingPanelMiddle">
					<c:if test="${currCategory.code == 'platePre'}">
					<div class="headingPanelMiddleSearchHeader">
						<input type="hidden" name="command.queryNames[2]"
												value="${pkfzBidderHomeForm.queries[2].queryName}" />
						<div class="headingPanelMiddleSearchHeaderCell"style="width:160px;">
								${pkfzBidderHomeForm.queries[2].queryName}
						</div>
						<c:forEach items="${pkfzBidderHomeForm.queries[0].parameters}" var="qp" varStatus="status" >
							<div class="headingPanelMiddleSearchHeaderCell">
								${qp.name}
							</div>
						</c:forEach>
					</div>  <!-- headingPanelMiddleSearchHeader -->
					<div class="headingPanelMiddleSearch">
						<c:set var="qp" value="${pkfzBidderHomeForm.queries[2].parameters[0]}" />
						<div class="headingPanelMiddleSearchCell" style="width:160px; text-align:left;">
							<form:select path="command.queryValueList[2][0]" style="width: 160px;
											height: 50px; font-family:myFont; font-size: 16px; padding-left: 15px;"
											value="${qp.defaultValue}" onchange="submitSpecialQuery(value)">
											<c:forEach items="${qp.values}"
																		var="val">
												<option value="${val[1]}"
													 ${val[1] == qp.defaultValue ? 'selected' : ''}>
													 ${val[0]}
												</option>
											</c:forEach>
							</form:select>
						</div>
						<input type="hidden" name="command.queryNames[0]" value="${pkfzBidderHomeForm.queries[0].queryName}" />
						<c:forEach items="${pkfzBidderHomeForm.queries[0].parameters}" var="qp" varStatus="status" >
							<div class="headingPanelMiddleSearchCell">
								<form:select path="command.queryValueList[0][${status.index}]" style="width: 65px;
												 	height: 50px; font-size: 16px; padding-left: 15px;"
													value="${qp.defaultValue}" >
													<c:forEach items="${qp.values}" var="val">
														<option value="${val}"
															 ${val == qp.defaultValue ? 'selected' : ''}>
															 ${val}
														</option>
													</c:forEach>
								</form:select>
							</div>
						</c:forEach>
						<input name="query1" value="Search" type="submit" style="width:100px; height:50px; font-family: myFont; color: green; font-size:20px; font-weight:700;"/>
						<input name="clearQuery" value="Clear" size="6px" type="submit" style="width:100px; height:50px; font-family: myFont; color: red; font-size:20px; font-weight:700;"/>
					</div>
					</c:if> <!-- headingPanelMiddleSearch -->
					<c:if test="${currCategory.code == 'plateSpe'}">
						<input type="hidden" name="command.queryNames[3]"
												value="${pkfzBidderHomeForm.queries[3].queryName}" />
						<div class="headingPanelMiddleSearchHeader">
							<div class="headingPanelMiddleSearchHeaderCell" style="width:160px;">
									${pkfzBidderHomeForm.queries[3].queryName}
							</div>
						</div>
						<div class="headingPanelMiddleSearch">
							<c:set var="qp" value="${pkfzBidderHomeForm.queries[3].parameters[0]}" />
							<div class="headingPanelMiddleSearchCell" style="width:160px; text-align:left;">
								<form:select path="command.queryValueList[3][0]" style="width: 160px;
												height: 50px; font-family:myFont; font-size: 16px; padding-left: 15px;"
												value="${qp.defaultValue}" onchange="submitSpecialQuery3(value)">
												<c:forEach items="${qp.values}"
																			var="val">
													<option value="${val}"
														 ${val == qp.defaultValue ? 'selected' : ''}>
														 ${val}
													</option>
												</c:forEach>
								</form:select>
							</div>
						<input name="clearQuery" value="Clear" size="6px" type="submit" style="width:100px; height:50px; font-family: myFont; color: red; font-size:20px; font-weight:700;"/>
						</div>	<!-- headingPanelMiddleSearch -->
					</c:if>
				</div>	<!-- headingPanelMiddle -->
			</c:if>
		</div>	<!-- headingPanel -->
		<div class="prodListContainer">
	      <div class="catTabStrip">
			 	<c:forEach items="${currMall.categories}" var="cat" >
			 	<c:if test="${cat.delisted==false}">
			 		<div class="catTab">
			 		<c:choose>
			 		<c:when test="${currCategory.code == cat.code}">
			 			${cat.name}
			 		</c:when>
			 		<c:otherwise>
					 		<font color="#A9A9A9"><a href="select?cat&code=${cat.code}">${cat.name}</a></font>
					</c:otherwise>
					</c:choose>
			 		</div>
			 	</c:if>
				</c:forEach>
			</div>
			<div class="prodList">
				<c:forEach items="${currPopularBaseProducts}" var="bp" >
				<c:if test="${bp.auction.state != 'INITIAL' && currAuctionSuspended==false
						&& bp.auction.state!='CANCELLED'}">
						<c:if test="${currCategory.code == 'plateSpe'}">
							  <div class="prodListEntry">
							  	  <c:if test="${bp.rating == 1}">
								  	<div class="numberPlateSpe">
										<c:choose>
											<c:when test="${currUserMall==true && bp.auction.state=='OPEN'}">
											  	<a href="/pkfz/px4/bidder/product?auctionByCode&id=${bp.id}">
										  				${bp.name}
												</a>
											</c:when>
											<c:otherwise>
												${bp.name}
											</c:otherwise>
										</c:choose>
										<c:choose>
										<c:when test="${currUserMall==true}">
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITREQ'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayPayDeposit.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITPAID'
												&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayCompletionPending.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='TRANSACT'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayTransactionComplete.png" width="180" height="50" />
											  	</div>
											</c:if>
										</c:when>
										</c:choose>
								  </div>
								  </c:if>
								  <c:if test="${bp.rating == 2}">
								  <div class="numberPlateSpe2">
										<c:choose>
											<c:when test="${currUserMall==true && bp.auction.state=='OPEN'}">
											  	<a href="/pkfz/px4/bidder/product?auctionByCode&id=${bp.id}">
										  				${bp.name}
												</a>
											</c:when>
											<c:otherwise>
												${bp.name}
											</c:otherwise>
										</c:choose>
										<c:choose>
										<c:when test="${currUserMall==true}">
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITREQ'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayPayDepositBidder.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITPAID'
												&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayCompletionPending.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='TRANSACT'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayTransactionComplete.png" width="180" height="50" />
											  	</div>
											</c:if>
										</c:when>
										</c:choose>
								  </div>
								  </c:if>
								  <c:if test="${bp.rating == 3}">
								  <div class="numberPlateSpe3">
										<c:choose>
											<c:when test="${currUserMall==true && bp.auction.state=='OPEN'}">
											  	<a href="/pkfz/px4/bidder/product?auctionByCode&id=${bp.id}">
										  				${bp.name}
												</a>
											</c:when>
											<c:otherwise>
												${bp.name}
											</c:otherwise>
										</c:choose>
										<c:choose>
										<c:when test="${currUserMall==true}">
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITREQ'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayPayDeposit.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITPAID'
														&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayCompletionPending.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='TRANSACT'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayTransactionComplete.png" width="180" height="50" />
											  	</div>
											</c:if>
										</c:when>
										</c:choose>
								  </div>
								  </c:if>
								  <div class="prodListEntryHeading">
							  			${bp.name}
								  </div>
								  <div class="prodListEntryDesc">
										<c:if test="${currAuctionSuspended==true}">
											<font color="green"><strong>AUCTION SUSPENDED</strong></font>
										</c:if>
										<c:if test="${currAuctionSuspended==false}">
											<c:if test="${bp.auction.state=='PENDING'}">
												<font color="blue">AUCTION PENDING</font>
												<br/>
												Reserve Price: RM<fmt:formatNumber value="${bp.auction.reservePrice}" pattern="#,###,###"/>
												<br/>
												Opens At: <fmt:formatDate value="${bp.auction.bidOpen}" pattern="yyyy-MM-dd HH:mm"/><br/>
											</c:if>
											<c:if test="${bp.auction.state == 'CLOSED'}">
												<c:if test="${currUserMall==false}">
						  							<font color="red">AUCTION CLOSED</font>
												</c:if>
												<c:if test="${currUserMall==true}">
						  						<a href="/pkfz/px4/bidder/product?auctionByCode&id=${bp.id}">
						  							<font color="red">AUCTION CLOSED</font>
												</a>
												</c:if>
												<br/>
												<c:if test="${bp.auction.highBid==null}">
													Reserve Not Met: RM<fmt:formatNumber value="${bp.auction.reservePrice}" pattern="#,###,###"/>
												</c:if>
												<c:if test="${bp.auction.highBid!=null}">
							  							High Bid: RM<fmt:formatNumber value="${bp.auction.highBid.bid}" pattern="#,###,###"/>
							  							<c:if test="${bp.auction.bidderStatus=='DEPOSITREQ' &&
							  																		currBidder.email==bp.auction.highBid.bidderId}">
															<div class="tooltip"><font color="green"><strong><a href="#popup1">WHAT NOW?</a></strong></font>
																<span class="tooltiptext">Please check your email for payment instructions.</span>
															</div>
														</c:if>
														<div id="popup1" class="overlay">
															<div class="popup">
																<h2>What Now?</h2>
																<a class="close" href="#">&times;</a>
																<div class="content">
																	Please check your email for further information.
																</div>
															</div>
														</div>
														<c:if test="${bp.auction.bidderStatus=='TRANSACT'
																									&& currBidder.email==bp.auction.highBid.bidderId}">
							  			 					<a href="/pkfz/px4/bidder/product?auctionSettled&id=${bp.id}">
												 					<font color="green"><strong>&nbsp;&nbsp;SETTLED</strong></font>
															</a>
														</c:if>
												</c:if>
	<!--											<br/>
												Closed At: <fmt:formatDate value="${bp.auction.bidClose}" pattern="yyyy-MM-dd HH:mm"/>
												<br/>
	-->
						  					</c:if>
					  						<c:if test="${bp.auction.state == 'OPEN' && currUserMall==true}">
					  							<a href="/pkfz/px4/bidder/product?auctionByCode&id=${bp.id}">
						  							<font color="green">AUCTION OPEN</font>
												</a>

												<c:if test="${bp.auction.highBid==null}">
													<br/>
													Reserve Price: RM<fmt:formatNumber value="${bp.auction.reservePrice}" pattern="#,###,###"/>
												</c:if>
												<c:if test="${bp.auction.highBid!=null}">
													<br/>
					  								Last Bid: RM<fmt:formatNumber value="${bp.auction.lastBid.bid}" pattern="#,###,###"/>

					  							</c:if>
					  							<br/>
					  							Closes At: <fmt:formatDate value="${bp.auction.bidClose}" pattern="yyyy-MM-dd HH:mm"/>
					  						</c:if>
										</c:if>
									</div>	<!-- prodListEntryDesc -->
							  </div>	<!-- prodListEntry -->
						</c:if>
						<c:if test="${currCategory.code != 'plateSpe'}">
							<div class="prodListEntry">
								<c:if test="${bp.rating == 1}">
								  	<div class="numberPlate">
										<c:choose>
											<c:when test="${currUserMall==true && bp.auction.state=='OPEN'}">
											  	<a href="/pkfz/px4/bidder/product?auctionByCode&id=${bp.id}">
										  				${bp.name}
												</a>
											</c:when>
											<c:otherwise>
												${bp.name}
											</c:otherwise>
										</c:choose>
										<c:choose>
										<c:when test="${currUserMall==true}">
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITREQ'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayPayDeposit.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITPAID'
												&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayCompletionPending.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='TRANSACT'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayTransactionComplete.png" width="180" height="50" />
											  	</div>
											</c:if>
										</c:when>
										</c:choose>
								  </div>
								  </c:if>
								  <c:if test="${bp.rating == 2}">
								  <div class="numberPlate2">
										<c:choose>
											<c:when test="${currUserMall==true && bp.auction.state=='OPEN'}">
											  	<a href="/pkfz/px4/bidder/product?auctionByCode&id=${bp.id}">
										  				${bp.name}
												</a>
											</c:when>
											<c:otherwise>
												${bp.name}
											</c:otherwise>
										</c:choose>
										<c:choose>
										<c:when test="${currUserMall==true}">
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITREQ'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayPayDepositBidder.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITPAID'
												&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayCompletionPending.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='TRANSACT'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayTransactionComplete.png" width="180" height="50" />
											  	</div>
											</c:if>
										</c:when>
										</c:choose>
								  </div>
								  </c:if>
								  <c:if test="${bp.rating == 3}">
								  <div class="numberPlate3">
										<c:choose>
											<c:when test="${currUserMall==true && bp.auction.state=='OPEN'}">
											  	<a href="/pkfz/px4/bidder/product?auctionByCode&id=${bp.id}">
										  				${bp.name}
												</a>
											</c:when>
											<c:otherwise>
												${bp.name}
											</c:otherwise>
										</c:choose>
										<c:choose>
										<c:when test="${currUserMall==true}">
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITREQ'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayPayDeposit.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='DEPOSITPAID'
														&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayCompletionPending.png" width="180" height="50" />
											  	</div>
											</c:if>
											<c:if test="${bp.auction.state=='CLOSED' && bp.auction.bidderStatus=='TRANSACT'
													&& currBidder.email==bp.auction.highBid.bidderId}">
												<div class="prodListEntryPicOverlay">
											  		<img src="../../images/overlayTransactionComplete.png" width="180" height="50" />
											  	</div>
											</c:if>
										</c:when>
										</c:choose>
								  </div>
								  </c:if>
								  <div class="prodListEntryHeading">
							  			${bp.name}
								  </div>
								  <div class="prodListEntryDesc">
										<c:if test="${currAuctionSuspended==true}">
											<font color="green"><strong>AUCTION SUSPENDED</strong></font>
										</c:if>
										<c:if test="${currAuctionSuspended==false}">
											<c:if test="${bp.auction.state=='PENDING'}">
												<font color="blue">AUCTION PENDING</font>
												<br/>
												Reserve Price: RM<fmt:formatNumber value="${bp.auction.reservePrice}" pattern="#,###,###"/>
												<br/>
												Opens At: <fmt:formatDate value="${bp.auction.bidOpen}" pattern="yyyy-MM-dd HH:mm"/><br/>
											</c:if>
											<c:if test="${bp.auction.state == 'CLOSED'}">
												<c:if test="${currUserMall==false}">
						  							<font color="red">AUCTION CLOSED</font>
												</c:if>
												<c:if test="${currUserMall==true}">
						  						<a href="/pkfz/px4/bidder/product?auctionByCode&id=${bp.id}">
						  							<font color="red">AUCTION CLOSED</font>
												</a>
												</c:if>
												<br/>
												<c:if test="${bp.auction.highBid==null}">
													Reserve Not Met: RM<fmt:formatNumber value="${bp.auction.reservePrice}" pattern="#,###,###"/>
												</c:if>
												<c:if test="${bp.auction.highBid!=null}">
							  							High Bid: RM<fmt:formatNumber value="${bp.auction.highBid.bid}" pattern="#,###,###"/>
							  							<c:if test="${bp.auction.bidderStatus=='DEPOSITREQ' &&
							  																		currBidder.email==bp.auction.highBid.bidderId}">
															<div class="tooltip"><font color="green"><strong><a href="#popup1">WHAT NOW?</a></strong></font>
																<span class="tooltiptext">Please check your email for payment instructions.</span>
															</div>
														</c:if>
														<div id="popup1" class="overlay">
															<div class="popup">
																<h2>What Now?</h2>
																<a class="close" href="#">&times;</a>
																<div class="content">
																	Please check your email for further information.
																</div>
															</div>
														</div>
														<c:if test="${bp.auction.bidderStatus=='TRANSACT'
																									&& currBidder.email==bp.auction.highBid.bidderId}">
							  			 					<a href="/pkfz/px4/bidder/product?auctionSettled&id=${bp.id}">
												 					<font color="green"><strong>&nbsp;&nbsp;SETTLED</strong></font>
															</a>
														</c:if>
												</c:if>
	<!--											<br/>
												Closed At: <fmt:formatDate value="${bp.auction.bidClose}" pattern="yyyy-MM-dd HH:mm"/>
												<br/>
	-->
						  					</c:if>
					  						<c:if test="${bp.auction.state == 'OPEN' && currUserMall==true}">
					  							<a href="/pkfz/px4/bidder/product?auctionByCode&id=${bp.id}">
						  							<font color="green">AUCTION OPEN</font>
												</a>

												<c:if test="${bp.auction.highBid==null}">
													<br/>
													Reserve Price: RM<fmt:formatNumber value="${bp.auction.reservePrice}" pattern="#,###,###"/>
												</c:if>
												<c:if test="${bp.auction.highBid!=null}">
													<br/>
					  								Last Bid: RM<fmt:formatNumber value="${bp.auction.lastBid.bid}" pattern="#,###,###"/>

					  							</c:if>
					  							<br/>
					  							Closes At: <fmt:formatDate value="${bp.auction.bidClose}" pattern="yyyy-MM-dd HH:mm"/>
					  						</c:if>
										</c:if>
									</div>	<!-- prodListEntryDesc -->
							  </div>	<!-- prodListEntry -->
						</c:if>
					</c:if>
				</c:forEach>

	      </div>	<!-- prodList -->
		</div>     <!-- prodListContainer -->

	<div class="buildNumber">
		20161115.1313
	</div>
	<div class="footer">
		&copy Urban Paridigm 2016
	</div>


</div>
	<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
</form:form>
<!--
<a href="/pkfz/px4/bidder/product?auctionByCode&id=${bp.id}">
											 	<img src="../../images/${bp.pics[0]}" width="200" height="150" />
											</a>
-->
</body>
</html>
