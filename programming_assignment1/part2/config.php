<?php

// Connect to DB
$con = mysqli_connect("dijkstra.ug.bcc.bilkent.edu.tr","hamza.khan","zcjg1jln","hamza_khan");

// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

?>