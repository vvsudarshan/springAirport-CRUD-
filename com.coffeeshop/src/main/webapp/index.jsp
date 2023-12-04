<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <style type="text/css">
		    
		.footer {
		    background-color: #333;
		    color: #fff;
		    padding: 5px;
		    text-align: center;
		    bottom: 0;
		    position: relative;
		    font:5px;
		}
		
		.footer-content {
		    display: flex;
		    justify-content: space-between;
		    max-width: 1200px;
		    margin: 0 auto;
		}
		
		.left-bottom, .right-bottom {
		    flex: 1;
		    text-align: left;
		}
		
		.center-bottom {
		    flex: 1;
		    text-align: center;
		}
		
		.creator, .contact, .mail {
		    padding: 10px;
		}
		
		.tech-heading {
		    color: #fff;
		    margin-bottom: 5px;
		    margin-top: 10px;
		}
		
		.tech-list {
		    list-style-type: none;
		    padding: 0;
		}
		
		.tech-list li {
		    margin-bottom: 5px;
		}
		
		.footer a {
		    color: #fff;
		    text-decoration: none;
		    transition: color 0.3s ease;
		}
		
		.footer a:hover {
		    color: #00cc00;
		}
		
		.footer a:active {
		    color: rgb(0, 255, 64);
		}
		
		.footer a:visited {
		    color: #9900cc;
		}
    
    </style>
    <title>Home Page</title>
</head>
<body>
	<header>
	
		<h>Airport Management(CRUD)</h>
	</header>
	  <div class="save-items">
		<form  action="getDatafromHtml" id="a">
			<label for="airportName">Airport Name:</label>
			<input type="text" id="airportName" name="airportName">
			<br>
			<br>
			<label for="airportLocation">Airport Location:</label>
			<input type="text" id="airportLocation" name="airportLocation">
			<br>
			<br>
			<label for="noOfPlanes">NO OF PLANES:</label>
			<input type="number" id="noOfPlanes" name="noOfPlanes">
			<br>
			<br>
			<label for="noOfRunways">NO OF RUNWAYS:</label>
			<input type="number" id="noOfRunways" name="noOfRunways">
			<br>
			<br>
			<input type="submit" value="Submit">		
		</form>
		
		<h>${savesuccess}</h>
		<h>${saveerror}</h>
	</div>
		
		<div class="search-items">
	    <div class="search-by-id-items">
	        <h>Search By ID</h>
	        <form action="searchById">
	            <label for="search">Search ID :</label>
	            <input type="number" name="search" id="search">
	            <input type="submit" value="Search" class="animated">
	        </form>
	        <p>${airportName}</p>
	        <p>${airportLocation}</p>
	        <p>${noOfPlanes}</p>
	        <p>${noOfRunways}</p>
	        <p style="color:red">${notregister}</p>
	        <p style="color:red">${error}</p>
	    </div>
	
	    <div class="search-by-name-items">
	        <h>Search By name</h>
	        <form action="searchByName">
	            <label for="searchName">Search NAME: </label>
	            <input type="text" name="searchName" id="searchName">
	            <input type="submit" value="Search" class="animated">
	        </form>
	        <pre>
	            <p>${airportNamename}</p>
	            <p>${airportLocationname}</p>
	            <p>${noOfPlanesname}</p>
	            <p>${noOfRunwaysname}</p>
	            <p style="color:red">${entitynottfound}</p>
	            <p style="color:red">${Incorrectname}</p>
	        </pre>
	    </div>
	</div>
	
	<div class="delete-items">
			<div class="delete-by-id">
				<h1>Delete Airport Id<h1>
				<form action="deleteById">
				 
				 <label for="Id">Delete By ID: </label>
				 		   
				 <input type="number" name="Id" id="Id">
				 <input type="submit" value="Delete">
						 <p>${success}</p> 
				           <p style="color:red">${notsucces}</p> 
				           <p style="color:red">${Deletenothappen}</p> 
				</form>
				
				
			</div>
			<div class="delete-by-id">
				<h1>Delete Airport By name:<h1>
				<form action="deleteByName">
				 
				 <label for="Name">Delete By Name: </label>
				 		   
				 <input type="text" name="Name" id="Name">
				 <input type="submit" value="Delete">
						   <p >${success}</p> 
				           <p style="color:red">${notsucces}</p> 
				           <p style="color:red">${Deletenothappen}</p> 
				</form>		
			</div>
		</div>
	</form>
	
	<div class="button-container">
	  <div class="button"><a href="getAllAirports">All Airport Table</a></div>
	  
	  <p style="color:red">${nodata}</p>
	  <p>${success}</p>
	  <p>${delete}</p>
	</div>
	<br>
	<br>
	
	<div class="airport-Table">
		<table border="1">
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>Name</th>
	            <th>Location</th>
	            <th>No. of Planes</th>
	            <th>No. of Runways</th>
	            <th>EDIT</th>
	            <th>DELETE</th>
	            
	        </tr>
	    </thead>
		 	<tbody>
		        <c:forEach var="airport" items="${airportList}">
		            <tr>
		                <td>${airport.airport_id}</td>
		                <td>${airport.airport_name}</td>
		                <td>${airport.airport_location}</td>
		                <td>${airport.no_of_planes}</td>
		                <td>${airport.no_of_runways}</td>
		                <td><button><a href="editAirport/${airport.airport_id}">Edit</a></button></td>
		                <td><button><a href="deleteAirport/${airport.airport_id}">DELETE</a></button> </td>
		            </tr>
		        </c:forEach>
		    </tbody>
		</table>
		
											

	
	</div>
	<footer class="footer">
	    <div class="footer-content">
	        <div class="left-bottom">
	            <p class="creator"><a href="#">Creator:Velpula Venkata Sudarshan</a></p>
	            <p class="contact"><a href="#">Contact:<a href="#">6300450613</a> </p>
	            <p class="mail"><a href="#">Mail:<a href="#">velpulasudarshan1@gmail.com</a> </p>
	        </div>
	        <div class="center-bottom">
	            <!-- You can add content here if needed -->
	        </div>
	        <div class="right-bottom">
	            <h class="tech-heading"><a href="#">Technologies used :</a></h>
	            <ul class="tech-list">
	                <li><a href="#">Spring MVC (version: 5.28)</a></li>
	                <li><a href="#">Hibernate (version: 5.28)</a></li>
	                <li><a href="#">Tomcat Server (version: 9)</a></li>
	                <li><a href="#">JSP</a></li>
	                <li><a href="#">CSS</a></li>
	                <li><a href="#">XML</a></li>
	            </ul>
	        </div>
	    </div>
	</footer>
	

</body>
</html> 