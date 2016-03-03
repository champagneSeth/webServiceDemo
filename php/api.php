<?php
require 'vendor/autoload.php';

$app = new \Slim\Slim();

// If the url matchs a certain word, it'll go to the function specified
$app-> get('/getTest','getTest');
$app-> get('/getVideo','getVideo');
$app->run();

function getTest () {
    echo '{"woo":' . json_encode('we made it') . '}';
}

function getVideo() {
    // get params from query string
    $app = \Slim\Slim::getInstance();
    $search = $app->request()->params('search');

    // get video data from search

    $video = (object)array("title" => "CLUTCH AD", "src" => "videos/anthony_davis.mp4");
    echo json_encode($video);
}


?>