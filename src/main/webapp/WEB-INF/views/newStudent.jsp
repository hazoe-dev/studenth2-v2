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
    <title>New Student</title>
  </head>
  <body>
    <div class="container mt-2">
      <div class="row m-auto">
        <div class="col-8 m-auto">
          <form action="createStudent" method="post">
            <table class="table table-borderless">
              <thead>
                <tr class="text-center">
                  <th  colspan="2">
                    <h2 class="mt-4 mb-2"  style="color: #2261be;">New Student</h2>
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td scope="row" class="text-end"><span style="color:red">*</span>StudentID</td>
                  <td>
                    <input type="text" class="form-control" name="id" required id="studentId"/>
                    <span class="small text-danger" style="display: none;" id="alertStudentId">Invalid: Mã sinh viên đã tồn tại!</span>             
                  </td>
                </tr>
                <tr>
                  <td scope="row" class="text-end"><span style="color:red">*</span>Name</td>
                  <td>
                    <input type="text" class="form-control" name="name" id="name" required/>
                    <span class="small text-danger" style="display: none;" id="alertName">Invalid: Trường tên không được bỏ trống!</span>             
                  </td>
                </tr>
                <tr>
                  <td scope="row" class="text-end">Male</td>
                  <td>
                    <input
                      class="form-check-input"
                      type="checkbox"
                      id="check1"
                      name="male"
                      value="1"
                      checked
                    />
                  </td>
                </tr>
                <tr>
                  <td scope="row" class="text-end">Birthday</td>
                  <td>
                    <input type="date" class="form-control" name="birthday"/>
                  </td>
                </tr>
                <tr>
                  <td class="text-end" scope="row">Place of birth</td>
                  <td>
                    <input
                      type="text"
                      class="form-control"
                      name="placeOfBirth"
                    />
                  </td>
                </tr>
                <tr>
                  <td scope="row" class="text-end">Address</td>
                  <td>
                    <input type="text" class="form-control" name="address" />
                  </td>
                </tr>
                <tr>
                  <td scope="row" class="text-end">Department</td>
                  <td>
                  	<input type="hidden" value"" name="depName" id="depName" >
                    <select class="form-select" id="dropDownId">
                      <option>Anh văn</option>
                      <option>Kinh tế</option>
                      <option>Hóa học</option>
                      <option>Sinh vật học</option>
                      <option>Tin học</option>
                      <option>Vật lý</option>
                    </select>
                  </td>
                </tr>
                <tr class="mb-4">
                  <td class="text-end" colspan="2">
                    <button type="submit" class="btn btn-outline-primary" id="createStudentBtn" > Submit</button>
                    <button type="button" class="btn btn-outline-secondary" onclick="window.location.href='/'"> Cancel </button>
                  </td>
                </tr>
              </tbody>
            </table>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
<script>
$(document).ready(function(){
	/*check validate existed student*/
	  $("#studentId").keyup(function(){
	    if($(this).val()!= '' ){
	    	$.ajax({url: "/checkStudent/"+$(this).val(), success: function(result){
		    	let show = result;
		    	if(show){
			        $("#alertStudentId").css("display", "block");
		    	}else{
		    		$("#alertStudentId").css("display", "none");
		    	}
		    }
	    	});
	    }    
	});
	
});
$(document).ready(function(){
	getDepName();
	$("#dropDownId").change(function() {
		getDepName();
	});
});
function getDepName(){
	let value = $('#dropDownId :selected').text();
	$("#depName").val(value);
}

</script>