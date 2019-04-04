<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
   <head>
      <title>Search Results</title>
   </head>

   <body style = "font-family: arial, sans-serif" 
      style = "background-color: #F0E68C">

Example - Searching a DB<p>

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


if ($select == "") { $select = '*'; }  //This normally should come from the user form that posts to this handler

// build SELECT query for the search (specifies table as well)
$query = "SELECT " . $select . " FROM $table";


if ($search_key == "") {
	$query = "SELECT $select FROM $table"; // Get the user submitted $select column
	} else {
	$query = "SELECT $select FROM $table WHERE $select LIKE '$search_key%'"; // with matching values
// Other Example Queries:
// $query = "SELECT FirstName, LastName, Wnum, Height FROM $table"; // select everything without any qualifier
// $query = "SELECT * FROM $table WHERE FirstName LIKE 'Alan%'"; // Qualifier is: FirstName starts with Alan and followed by anything else
// $query = "SELECT * FROM $table WHERE LastName  '%t%'"; // The user submitted $select column contains a 't'
// $query = "SELECT * FROM $table WHERE $select LIKE 'Alan%'"; // The user submitted $select column contains a 't'

}

print("Now query the database<br>");
// query the database
if ( !( $result = mysql_query( $query, $connection ) ) ) {
	print( "Could not execute query! <br />" );
	die( mysql_error() );
	}



// fetch each record in result set
for ( $counter = 0; $row = mysql_fetch_row( $result ); $counter++ ){

	// build table to display results
	print( "<table><tr>" );

	foreach ( $row as $key => $value ) print( "<td>$value</td>" );
	print( "</tr>" );
       }

print( "</table>" );

mysql_close( $dbname );
?> 

Done!
   </body>
</html>

