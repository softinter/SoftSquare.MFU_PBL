<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
  <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
  <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
 
    <body>
    <a download id="downloadFile" hidden></a>
    <div class="nav-div-header-menu" style="position:fixed; width:100%; z-index:300" >
    <nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		    <span class="sr-only">Toggle navigation</span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
		     <span class="icon-bar"></span>
		  </button>
	      <a class="navbar-brand" href="${domainSystem}">Clinic </a>
	    </div>
	   <div class="collapse navbar-collapse">
	    <ul class="nav navbar-nav">
	    <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage User and Role
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	        	<li><a href="${domainSystem}register.html">Register</a></li>
	        	<li><a href="${domainSystem}manageRole.html">Manage Role</a></li>
	        </ul>
	      </li>
	      
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Employee and Position
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	        	<li><a href="${domainSystem}manageEmployee.html">Manage Employee</a></li>
	        	<li><a href="${domainSystem}managePosition.html">Manage Position</a></li>
	        </ul>
	      </li>
	      
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Medicine and Type
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	        	<li><a href="${domainSystem}manageType.html">Manage Type</a></li>
	        	<li><a href="${domainSystem}manageMedicine.html">Medicine</a></li>
	        </ul>
	      </li>
	      
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Patient
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	        	<li><a href="${domainSystem}managePatient.html">Manage Patient</a></li>
	        	
	        </ul>
	      </li>
	      
	      
	    
	    </ul>
	  <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span>${userNameUserSystem}
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a>User Name : ${userNameUserSystem}</a></li>
	           <li><a>User Role : ${roleUserSystem}</a></li>
	        </ul>
	      </li>
	       <li><a href="${domainSystem}logoutpage.html"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
      </ul>
      <!--    <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Language
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="?lang=en">English</a></li>
	          <li><a href="?lang=th">Thai</a></li>
	        </ul>
	      </li>
      </ul>
	 -->
	  </div>
	  </div>
	</nav>
</div>
    </body>
</html>