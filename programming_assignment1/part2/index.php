<html>
	<head>	
	</head>

	<body>

		<form name="form1" method="post" action="indexnext.php" onsubmit="return validateForm()">
			<p>Username: <input type="text" name="username" size="15" value=""/></p>
			<p>Password: <input type="password" name="pass" size="15" value=""/></p>
			<p><input type="submit" name="submit" value="Login"/></p>
		</form>

	<script>	
	function validateForm() 
	{
    	var x = document.forms["form1"]["username"].value;    
    	var y = document.forms["form1"]["pass"].value;
    	if (x == null || x == "" ||y == null || y == "") 
    	{
        	alert("Username and Password Must Be Filled out");
        	return false;
    	}    
    }
    </script>

	</body>
</html>