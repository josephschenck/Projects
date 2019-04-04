<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
   <head>
      <title>Inserting to a DB</title>
   </head>

   <body style = "font-family: arial, sans-serif" style = "background-color: #F0E68C">
Insert a record to a DB<p>

<?php

extract( $_POST );

$connection = "";
$servername = "localhost";
$username = "Your_ID";     //here goes your own login ID
$password = "password";    //here goes your own MySQL password
$dbname = "Myshowdb";      //here goes the name of your database to be accessed
$table = "Students";       //here goes the particular table of your database to be accessed

        
// Connect to MySQL
if ( !( $connection = mysql_connect( $servername, $username, $password ) ) ) die( "Could not connect to database" );
   
print("Now open a database <br>");
// open the particular database
if ( !mysql_select_db( $dbname, $connection ) ) die( "Could not open the database" );

 
// build INSERT query (specifies table as well)
// Example: 
// We use the following to make it work with the example form data.html:
$query = "INSERT INTO $table (FirstName, LastName, Wnum, Height) VALUES ('$FirstName', '$LastName', '$Wnum', '$Height')";

print("Now query the database<br>");
// query the database
if ( !( $result = mysql_query( $query, $connection ) ) ) {
	print( "Could not execute query! <br />" );
	die( mysql_error() );
	}


mysql_close( $dbname );
		 
print("<p>End of demo<br>");
      ?>


   </body>
</html>

