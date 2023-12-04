<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT</title>
<style>
	    .edit-form-items {
	        text-align: center;
	        margin-top: 50px; /* Adjust the margin-top value as needed */
	    }
	
	    form {
	        display: inline-block;
	        text-align: left;
	        padding: 20px;
	        border: 1px solid #ccc;
	        border-radius: 5px;
	        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	    }
	
	    label {
	        display: block;
	        margin-bottom: 8px;
	    }
	
	    input {
	        width: 100%;
	        padding: 8px;
	        margin-bottom: 15px;
	        box-sizing: border-box;
	    }
	
	    input[type="submit"] {
	        background-color: #4caf50;
	        color: white;
	        cursor: pointer;
	    }
	
	    pre {
	        text-align: center;
	        margin-top: 20px; /* Adjust the margin-top value as needed */
	    }
	</style>

	
</head>
<body>

	<div class="edit-form-items">
	   <form action="${pageContext.request.contextPath}/updateAirport" >

	
		<label for="airportId">Airport ID:</label>
		<input type="number" id="airportId" name="airportId" value="${ID}">
		<br>
		<label for="airportName">Airport Name:</label>
		<input type="text" id="airportName" name="airportName" value="${NAME}">
		<br>
		<br>
		<label for="airportLocation">Airport Location:</label>
		<input type="text" id="airportLocation" name="airportLocation" value="${LOCATION}">
		<br>
		<br>
		<label for="noOfPlanes">NO OF PLANES:</label>
		<input type="number" id="noOfPlanes" name="noOfPlanes" value="${NO_OF_PLANES}">
		<br>
		<br>
		<label for="noOfRunways">NO OF RUNWAYS:</label>
		<input type="number" id="noOfRunways" name="noOfRunways" value="${NO_OF_RUNWAYS}">
		<br>
		<br>
		<input type="submit" value="Update">		
	  </form>
	  <pre>
									<p>${responseMessage}</p>
									
	 </pre>
	</div>
	
</body>
</html>