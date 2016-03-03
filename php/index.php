<?php
require 'dbConnect.php';
require 'vendor/autoload.php';

$app = new \Slim\Slim();

// If the url matchs a certain word, it'll go to the function specified
$app-> get('/getTest','getTest');
$app->run();


function buildApiResponse($sql, $typeOfReading, $dateArray)
{
    try 
    {
        $db = getDb();
        $stmt = $db -> prepare($sql);
        $success = $stmt -> execute($dateArray);
        if ($success)
            $readings = $stmt -> fetchAll(PDO::FETCH_OBJ);
        else throw new Exception('Query failed.');
        $db = null;
        echo $typeOfReading . json_encode($readings) . '}';
    }
    catch(PDOException $e) 
    {
        echo '{"error":{"text":'. $e->getMessage() .'}}';
    }
}

function getTest () 
{
    echo '{"woo":' . json_encode('we made it') . '}';
}

//this function will return the daily readings as a JSON object...Needs to have query written for it
function getDailyReadings()
{
    // get params from query string
    $app = \Slim\Slim::getInstance();
    $start = $app->request()->params('start');
    $end = $app->request()->params('end');

    $query = 'SELECT * FROM dailyReadings 
              WHERE (DATE(dateRead) BETWEEN :start AND :end)';

    $typeOfReading = '{"apiData":';
    $array = array(
        ":start" => $start,
        ":end" => $end
    );

    buildApiResponse($query, $typeOfReading, $array);

    // echo '{"start":' . json_encode($start) . ',"end":' . json_encode($end) . '}';
    // echo '{"woo":' . json_encode('we made it') . '}';
}


?>