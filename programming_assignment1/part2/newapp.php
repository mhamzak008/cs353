<html>
	<head>	

	</head>
	<body>

		<a href="index.php">Log Out</a><br/><br/>

		<?php

		include 'config.php';

		session_start();
		$sid = $_SESSION['sid'];

 		$query = "SELECT * FROM apply WHERE sid='$sid'";
		$result = mysqli_query($con, $query);

		if($result)	// If successfully queried
		{
			$num = mysqli_num_rows($result);

 			if($num >= 3)
 			{
 				echo "Error: You Have Already Applied To 3 Companies!";
 			}
 			else	// If student got space
 			{
 				$query = "SELECT cid, cname FROM company WHERE quota>0 AND cid NOT IN (SELECT cid FROM apply WHERE sid='$sid')";
				$result = mysqli_query($con, $query);

				if($result)	// got some result
				{
					echo "<table width='50%' border='1px solid black'>";
					echo "<tr>";
					echo "<th>ID</th>";
					echo "<th>Name</th>";
					echo "</tr>";

					// retrieve data from company table
					while($row = mysqli_fetch_array($result))
					{			
						echo "<tr>";
						echo	"<td>".$row[0]."</td>";
						echo	"<td>".$row[1]."</td>";
						echo "</tr>";
					}
				}
				else
					echo "No Companies To Apply!";

				echo "<form name='form' method='post' action='submit.php' onsubmit='return validateForm()'>";
				echo "<p>Company ID: <input type='text' name='cid' size='15' value=''/></p>";
				echo "<p><input type='submit' name='submit' value='Submit App'/></p>";
				echo "</form>";
 			}
 		}
 		else
 			echo "Unable to retrieve data";
 
 		echo "<br/><a href='welcome.php'>Go Back</a><br/>";

 		mysqli_close($con);		
		?>

		<script>
		function validateForm() 
		{
    		var x = document.forms["form"]["cid"].value;  
    		if (x == null || x == "") 
    		{
        		alert("Company ID Must Be Filled out");
        		return false;
    		}    
   		}
   		</script>

	</body>
</html>