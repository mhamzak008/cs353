<?php

	echo "<a href='index.php'>Log Out</a><br/><br/>";

	include 'config.php';

	$cid = $_POST['cid'];

	session_start();
	$sid = $_SESSION['sid'];

	$query = "INSERT INTO apply(sid, cid) VALUES('$sid', '$cid')";
	$result = mysqli_query($con, $query);

	if($result)
	{

		$query = "UPDATE company SET quota=quota-1 WHERE cid='$cid' and quota>0";
		$result = mysqli_query($con, $query);

		if($result)
		{
			echo "Successfully Applied To Company!";	

		}
		else
		{
			echo "Error: Can't decrease quota";

			// Revert the previous change
			$query = "DELETE FROM apply WHERE sid='$sid' AND cid='$cid'";
			$result = mysqli_query($con, $query);

			if($result)
				echo "Changes Reverted";
		}

	}
	else
		echo "Error: Can't Apply To This Company";

	echo "<br/><a href='newapp.php'>Go Back</a>";
?>