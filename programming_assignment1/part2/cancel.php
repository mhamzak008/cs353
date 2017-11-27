<html>
	<head>	

	</head>
	<body>

		<a href="index.php">Log Out</a><br/><br/>

		<?php

		include 'config.php';

		session_start();
		$sid = $_SESSION['sid'];

		$var_value = $_GET['varname'];

 		$result = mysqli_query($con, "DELETE FROM apply WHERE cid='$var_value' AND sid='$sid'");

 		if($result)
 		{
 			$query = "UPDATE company SET quota=quota+1 WHERE cid='$var_value'";
			$result = mysqli_query($con, $query);

			if($result)
			{
 				echo "Application Successfully Cancelled!";
			}
			else	// revert previous changes
			{
				echo "Can't update quota";

				$result = mysqli_query($con, "INSERT INTO apply(sid, cid) VALUES('$sid','$var_value')");  

				if($result)
					echo "changes reverted";				
				else
					echo "can't revert changes";
			}

 		}
 		else
 		{
 			echo "Error: Please Try Again";
 		}
 
 		mysqli_close($con);		
		?>

		<br/><a href='welcome.php'>Go Back</a>

	</body>
</html>