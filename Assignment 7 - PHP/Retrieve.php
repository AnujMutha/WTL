
<?php
$servername = "localhost:3306";
$username = "Anuj";
$password = "Anuj 16 @ MySql";
$dbname = "wtl_assignment_6";
echo "
<style>
		*{
		font-family: Product Sans;
		}
		table{
		background-color: #F5F5F5;
			border-collapse: collapse;
		    margin: 25px 0;
		    font-size: 0.9em;
		    min-width: 400px;
		    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
		}
		table thead tr {
		    background-color: #009879;
		    color: #ffffff;
		    text-align: left;
		}
	    table th,td {
		    padding: 12px 15px;
		}
		table tbody tr {
    		border-bottom: 1px solid #dddddd;
		}
		
		table tbody tr:nth-of-type(even) {
		    background-color: #f3f3f3;
	    	color: #009879;
		}
		
		table tbody tr:last-of-type {
		    border-bottom: 2px solid #009879;
		}
		
}
		
	</style>";
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT stud_id, stud_name, stud_div, stud_city FROM students_info";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    echo "<center><table><tr><th>ID</th><th>Name</th><th>Division</th><th>City</th></tr>";
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>".$row["stud_id"]."</td><td>".$row["stud_name"]."</td><td>".$row["stud_div"]."</td><td>".$row["stud_city"]."</td></tr>";
    }
    echo "</table></center>";
} else {
    echo "0 results";
}
$conn->close();
?>