<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="../../css/overlaystyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.1/css/foundation.min.css">
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<link rel="stylesheet" href="../../css/style.css" />

<style>

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
			font-size: 18px;
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
			margin-bottom: 20px;
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
			width: 950px;
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
			height: 180px;
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
</style>

<script>

var plates;

function getAllPlates() {

     $.ajax({

    type: "GET",
         url : '/platez/api/anon/getAllPlates',
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
            plates = result.result;
            alert('Plates # ' + plates.length);
            displayPlates();
          }
      })
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function displayPlates()
{
    plates.forEach((plate, i) => {
    var pe = document.createElement('div');
    pe.className = 'prodListEntry';

    var peh = document.createElement('div');
    peh.className = 'prodListEntryHeading';

    if (plate.rating==1)
    {
      var np = document.createElement('div');
      np.className = 'numberPlateSpe';
      np.appendChild(document.createTextNode(plate.regNo));
      peh.appendChild(np);
    }
    else
    if (plate.rating==2)
    {
        var np = document.createElement('div');
        np.className = 'numberPlateSpe2';
        np.appendChild(document.createTextNode(plate.regNo));
        peh.appendChild(np);
    }
    else {
      var np = document.createElement('div');
      np.className = 'numberPlateSpe3';
      np.appendChild(document.createTextNode(plate.regNo));
      peh.appendChild(np);
    }

    pe.appendChild(peh);
    var pp = document.createElement('div');
    pp.className = 'prodListEntryPrice';
    var price = numberWithCommas(plate.listPrice);
    pp.appendChild(document.createTextNode('RM'+price));
    peh.appendChild(pp);

    if (!(i % 5)) {
        pl = document.createElement('div');
        pl.className = 'prodList'
        document.getElementById('pc').appendChild(pl);
    }

    pl.appendChild(pe);

    });
}

</script>

<html>
<head><table id="table0"></table>
</style>
</head>
<body>
  <div class="headingPanel">
				<div class="headingPanelLeft">
					<div style="line-height:110px; text-align:right;">Filter:</div>
				</div>	<!-- headingPanelLeft -->
				<div class="headingPanelMiddle">
					<c:if test="${currCategory.code == 'platePre'}">
					<div class="headingPanelMiddleSearchHeader">
						<input type="hidden" name="command.queryNames[2]"
												value="${pkfzSupplierHomeForm.queries[2].queryName}" />
						<div class="headingPanelMiddleSearchHeaderCell"style="width:160px;">
								${pkfzSupplierHomeForm.queries[2].queryName}
						</div>
						<c:forEach items="${pkfzSupplierHomeForm.queries[0].parameters}" var="qp" varStatus="status" >
							<div class="headingPanelMiddleSearchHeaderCell">
								${qp.name}
							</div>
						</c:forEach>
					</div>  <!-- headingPanelMiddleSearchHeader -->
					<div class="headingPanelMiddleSearch">
						<c:set var="qp" value="${pkfzSupplierHomeForm.queries[2].parameters[0]}" />
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
						<input type="hidden" name="command.queryNames[0]" value="${pkfzSupplierHomeForm.queries[0].queryName}" />
						<c:forEach items="${pkfzSupplierHomeForm.queries[0].parameters}" var="qp" varStatus="status" >
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
						<div class="headingPanelMiddleSearch">
							<input type="hidden" name="command.queryNames[3]"
													value="${pkfzSupplierHomeForm.queries[3].queryName}" />
							<div class="headingPanelMiddleSearchHeader">
								<div class="headingPanelMiddleSearchHeaderCell" style="width:160px;">
										${pkfzSupplierHomeForm.queries[3].queryName}
								</div>
							</div>
							<div class="headingPanelMiddleSearch">
								<c:set var="qp" value="${pkfzSupplierHomeForm.queries[3].parameters[0]}" />
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
							</div>
						</div>	<!-- headingPanelMiddleSearch -->
				</div>	<!-- headingPanelMiddle -->
			</c:if>

		</div>
  <div id='pc' class='prodListContainer'>
  </div>
</body>
<script>
  getAllPlates();
</script>
</html>
