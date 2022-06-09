<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="bootstrap.min.css" rel="stylesheet" />
    <script src="bootstrap.min.js"></script>
    <script src="jquery.3.6.min.js"></script>
    <title>Student Manager</title>
  </head>
  <body>
    <div class="container">
      <h2 class="mt-5 mb-4">Student Manager</h2>
      <h4 class="bg-primary text-white mb-4 pt-2 pb-2 ps-2 pe-2">Student List (${students.size() })</h4>
      <div class="mb-4">
        <button type="button" class="btn btn-outline-primary" onclick="window.location.href='/student-new'" >New student</button>
        <button type="button" class="btn btn-outline-secondary" id="delete-btn"> Delete  </button>
      </div>
      <table class="table table-bordered table-responsive align-middle">
        <thead>
          <tr class="table-info">
            <th style="width:20%">Edit</th>
            <th style="width:5%">Selected</th>
             <th style="width:10%">StudentID</th>
            <th style="width:10%">Department</th>
            <th>Name</th>
            <th style="width:5%">Gender</th>
            <th style="width:10%">Birthday</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="student" items="${students}">
          <tr id="student-${student.id}">
            <td>
                <button type="button" class="btn btn-outline-primary" onclick="window.location.href='/student-edit-${student.id}'">Edit student</button>
            </td>
            <td  class="text-center">
                <input class="form-check-input" type="checkbox" id="id" name="id" value="${student.id}" checked>
            </td>
            <td>
                <a href="/student-${student.id}" title="Show detail">${student.id}</a>
            </td>
            <td>
                ${student.depName}
            </td>
            <td>
                ${student.name}
            </td>
            <td>
            	<c:if test = "${student.male}">Male</c:if>
            	<c:if test = "${not student.male}">Female</c:if>
            </td>
            <td>
            	<input type="date" value="${student.birthday}" readonly style="border: none; outline: none;"/>
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
<script>
function formatDate(date){
	if(date != null && date != ""){
		var d = new Date(date);
	    var day = d.getDate();
	    var month = d.getMonth() + 1;
	    var year = d.getFullYear();
	    if (day < 10) {
	        day = "0" + day;
	    }
	    if (month < 10) {
	        month = "0" + month;
	    }
	    return day + "-" + month + "-" + year;
	}
	return "";
}
$(document).ready(function(){
	let birthday =  $("#birthday").text() ;
	let formatBirthday = formatDate(birthday);
	$("#birthday").text(formatBirthday);
	console.log(formatBirthday)
	
	
	$("#delete-btn").click(function(){
		let ids = [];
		$('input:checkbox:checked').each(function () {
			ids.push($(this).val());
		  });
		let params =[];
		for (var i in ids){
			params.push("ids="+ids[i]);
		}
		let queryStr = params.join("&");
		  
		  $.ajax({ 
              url: "/deleteStudent?"+queryStr, 
              type: "DELETE", 
              success : function(data) {
                  $.each(data, function( index, value ) {
                	  $("#student-"+value).css("display","none");
                	});
               },
               error : function(data) {
                      openAlertDialog("Error", data.message, "Continue", "manage-assets");
              },
  			});
	});
	
});



</script>