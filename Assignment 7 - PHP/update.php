<?php
$servername = "localhost:3306";
$username = "Anuj";
$password = "Anuj 16 @ MySql";
$dbname = "wtl_assignment_6";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$id = "";
$city = "";

if (isset($_POST['save'])) {
    $id = $_POST['id'];
    $city = $_POST['new_city'];
}

$sql = "UPDATE students_info SET stud_city='$city' WHERE stud_id='$id'";

if ($conn->query($sql) === TRUE) {
    echo "Record updated successfully";
    sleep(2);
    header('location: Retrieve.php');
} else {
    echo "Error updating record: " . $conn->error;
}
$conn->close();

?>

