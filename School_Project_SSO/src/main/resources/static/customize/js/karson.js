//userlist delete user
function deleteuser(a){
    	if (confirm("Are you sure to delete ?") == true) {
    		location.href='/user/delete/'+a;
    	}
    }
 
  //userlist dataTables  
  $(function () {
    $('#dataTables').DataTable({
      'paging'      : true,
      'lengthChange': true,
      'searching'   : true,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
  })
  //rolelist delete role
  function deleterole(a){
    	if (confirm("Are you sure to delete ?") == true) {
    		location.href='/role/delete/'+a;
    	}
    }
  function deletesignuprole(a){
  	if (confirm("Are you sure to delete ?") == true) {
  		location.href='/signuprule/delete/'+a;
  	}
  }
   
  function goBack() {
      window.history.back();
  }
  
  function checkAll(who, obj){
  	var curCheckBox = document.getElementsByName(who);
  	for(i = 0; i < curCheckBox.length; i++){
  		curCheckBox.item(i).checked = obj.checked;
  	}
  }
  
  function checkAll(who){
	  	var curCheckBox = document.getElementsByName(who);
	  	for(i = 0; i < curCheckBox.length; i++){
	  		curCheckBox.item(i).checked = true;
	  	}
	  }
  
  function formSubmit(url){
	
	  var checkedValue = null; 
	  var inputElements =  document.getElementsByName("id");
	  for(var i=0; inputElements[i]; ++i){
	        if(inputElements[i].checked){
	             checkedValue = inputElements[i].value;
	             break;
	        }
	  }
	  if(checkedValue == null){
		  alert("Please Select Object");
	  }else{ 
	  location.href=url+'/'+checkedValue;
	  }
  }
 
  
  
	