<?php

include 'config.php';

$username = $_POST['username'];
$pass     = $_POST['pass'];

$query = "SELECT * FROM student WHERE sname='$username' and sid='$pass'";
$result = mysqli_query($con, $query);
$num = mysqli_num_rows($result);

if ($num > 0)
{
  	session_start();

	$_SESSION['sid']=$pass;

	header('location:welcome.php');
}
else
{
	echo "Incorrect Username or Password!";
	echo "<br/><a href='index.php'>Go Back</a><br/>";
}

mysqli_close($con);
?>