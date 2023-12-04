<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Runway Details</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/runwaysheet.css">
</head>
<body>
    <div class="save-runways-item">
        <form action="getrunwaysData">
            <label for="runwaylength">Length:</label>
            <input type="number" name="runwaylength" id="runwaylength">
            <br>
            <label for="runwayWidth">Width:</label>
            <input type="number" name="runwayWidth" id="runwayWidth">  
            <br>
            
            <label for="suit">Suit:</label>
            <select id="suit" name="suit">
                <option value="small">Small</option>
                <option value="medium">Medium</option>
                <option value="large">Large</option>
            </select>
            <br>
            
            <br>
            <div ="radiobutions">
            <label>Direction:</label>
	            <label for="east">East</label>
	            <input type="radio" id="east" name="direction" value="east">
	        
	             <label for="west">West</label>
	            <input type="radio" id="west" name="direction" value="west">
	          
	            <label for="north">North</label>
	            <input type="radio" id="north" name="direction" value="north">
	          
	              <label for="south">South</label>
	            <input type="radio" id="south" name="direction" value="south">
            </div>
            <input type="submit" value="submit">
        </form>
    </div>
</body>
</html>
