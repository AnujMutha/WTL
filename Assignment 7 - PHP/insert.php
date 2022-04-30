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
$name = "";
$div = "";
$city = "";

if (isset($_POST['save'])) {
    $id = $_POST['id'];
    $name = $_POST['name'];
    $div = $_POST['division'];
    $city = $_POST['city'];

    mysqli_query($conn, "INSERT INTO students_info VALUES ('$id', '$name', '$div', '$city')");
    $_SESSION['message'] = "Address saved";
    header('location: Retrieve.php');
}
