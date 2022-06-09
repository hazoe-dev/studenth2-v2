<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="bootstrap.min.css" rel="stylesheet" />
    <script src="bootstrap.min.js"></script>
    <script src="jquery.3.6.min.js"></script>
    <title>Edited Student</title>
  </head>
  <body>
    <div class="container mt-2">
      <div class="row m-auto">
        <div class="col-8 m-auto">
        
        <form:form method="POST" 
          action="/student-edit-${student.id}" modelAttribute="student">
             <table class="table table-borderless">
             <thead>
                <tr class="text-center">
                  <th colspan="2">
                    <h2 class="mt-4 mb-2"  style="color: #2261be;">Edit Student</h2>
                  </th>
                </tr>
              </thead>
                <tr>
                    <td scope="row" class="text-end"><form:label path="id">StudentID</form:label></td>
                    <td><form:input path="id" class="form-control"/></td>
                </tr>
                <tr>
                    <td scope="row" class="text-end"><form:label path="name">Name</form:label></td>
                    <td><form:input path="name" class="form-control"/></td>
                </tr>
                <tr>
                    <td scope="row" class="text-end"><form:label path="male">Male</form:label></td>
                    <td><form:checkbox path="male" class="form-check-input"/></td>
                </tr>
                 <tr>
                    <td scope="row" class="text-end"><form:label path="birthday">Birthday</form:label></td>
                    <td>
                    <form:input type="date" path="birthday" class="form-control" id="birthday"/>
                    </td>
                </tr>
                <tr>
                    <td scope="row" class="text-end"><form:label path="placeOfBirth">Place of birth</form:label></td>
                    <td><form:input path="placeOfBirth" class="form-control" /></td>
                </tr>
                <tr>
                    <td scope="row" class="text-end"><form:label path="address">Address</form:label></td>
                    <td><form:input path="address" class="form-control"/></td>
                </tr>
                <tr>
                    <td scope="row" class="text-end"><form:label path="depName">Department</form:label></td>
                    <td><form:select path="depName" items="${depNames}" class="form-select"/></td>
                </tr>
                 <tr class="mb-4">
                  <td class="text-end" colspan="2">
                    <button type="submit" class="btn btn-outline-primary" onclick="window.location.href='/createStudent'">
                      Update
                    </button>
                    <button type="button" class="btn btn-outline-secondary"
                    	onclick="window.location.href='/'">
                      Cancel
                    </button></td>
                </tr>
            </table>
        </form:form>
        </div>
      </div>
    </div>
  </body>
</html>
<script>
$(document).ready(function(){
	let isMale =  ($("#male").val() === 'true');
	$("#male").prop('checked', isMale);
});



</script>