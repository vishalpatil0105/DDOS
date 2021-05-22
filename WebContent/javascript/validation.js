
function firstname()
{
	 var firstname=document.getElementById("fname").value;
	    
	    var invalidChar1="~!@#$%^&*()_+=-:{} ></[].,\"\'1234567890";
	
	    if(firstname.length==0)
	    {
	    	
		   document.getElementById("fnameerror").innerHTML="First Name cannot be empty";
		   document.getElementById("fnameerror").style.visibility="visible";
		   document.getElementById("fnameerror").style.color="red";
		   document.getElementById("firstname").value="";
		   
		   return false;
		}
		for(var i=0;i<firstname.length;i++)
		{
			for(var j=0;j<invalidChar1.length;j++)
				{
				if(firstname.charAt(i)==invalidChar1.charAt(j))
	               {
				       document.getElementById("fnameerror").innerHTML="Only alphabets are allowed";
				       document.getElementById("fnameerror").style.visibility="visible";
					   document.getElementById("fnameerror").style.color="red";
					   document.getElementById("firstname").value="";			
					   return false;
				   }
				
				}
		}

			document.getElementById("fnameerror").style.visibility="hidden";
}

function lastname()
{
	var lastname=document.getElementById("lname").value;
    
    var invalidChar1="~!@#$%^&*()_+=-:{} ></[].,\"\'1234567890";

    if(lastname.length==0)
    {
    	
	   document.getElementById("lnameerror").innerHTML="Last Name cannot be empty";
	   document.getElementById("lnameerror").style.visibility="visible";
	   document.getElementById("lnameerror").style.color="red";
	   document.getElementById("lastname").value="";
	   
	   return false;
	}
	for(var i=0;i<lastname.length;i++)
	{
		for(var j=0;j<invalidChar1.length;j++)
			{
			if(lastname.charAt(i)==invalidChar1.charAt(j))
               {
			       document.getElementById("lnameerror").innerHTML="Only alphabets are allowed";
			       document.getElementById("lnameerror").style.visibility="visible";
				   document.getElementById("lnameerror").style.color="red";
				   document.getElementById("firstname").value="";			
				   return false;
			   }
			
			}
	}

		document.getElementById("lnameerror").style.visibility="hidden";
}

function emailid()
{
	var lname=document.getElementById("email-id").value;
	if(lname.length==0)
		{
		document.getElementById("email-iderror").innerHTML="email should not be empty"; 
		}
	}
