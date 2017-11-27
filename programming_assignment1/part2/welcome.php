<html>
	<head>	

	</head>
	<body>

		You have successfully logged in!<br/>
		<a href="index.php">Log Out</a><br/><br/>
		Your Internship Applications Are As Following:<br/>

		<?php 
			include 'config.php';
		
			session_start();
			$sid = $_SESSION['sid'];

			$query = "SELECT * FROM apply WHERE sid='$sid'";
			$result = mysqli_query($con, $query);
			
			// If successfully queried
			if($result)
			{		
				echo "<table width='50%' border='1px solid black'>";
				echo "<tr>";
				echo "<th>ID</th>";
				echo "<th>Name</th>";
				echo "<th>Quota</th>";
				echo "<th>Cancel App</th>";
				echo "</tr>";
					
				// retrieve data from apply table
				while($rowApply = mysqli_fetch_array($result))
				{	
					$result2 = mysqli_query($con, "SELECT * FROM company WHERE cid='$rowApply[1]'");

					// retrieve data from company table
					while($rowCompany = mysqli_fetch_array($result2))
					{						
						echo "<tr>";
						echo	"<td>".$rowCompany[0]."</td>";
						echo	"<td>".$rowCompany[1]."</td>";
						echo	"<td>".$rowCompany[2]."</td>";
						echo	"<td><a href='cancel.php?varname=$rowCompany[0]'>Cancel</a></td>";
						echo "</tr>";
					}
				}
				echo "</table>";
			}

		mysqli_close($con);		
		?>

		<br/><a href="newapp.php">Apply For New Internship</a>
	
	</body>
</html>