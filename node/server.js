var express         = require('express')
,   app             = express()
,   bodyParser      = require('body-parser')
,   fs              = require('fs')
,   db              = require('./data.js')
;


app.use('/lib', express.static(__dirname + '/app/lib'));
app.use('/', express.static(__dirname + '/app'));
app.use(bodyParser.urlencoded({
    extended    : true
,   limit       : '50mb'
}));
app.use(bodyParser.json({
    limit       : '50mb'
}));


app.get('/api/images', function(req, res) {
    res.status(200).json({ 
        images : db.images 
    });
});

app.get('/api/getUser', function(req, res) {
    res.status(200).json({ 
        user    : db.user
    ,   key     : db.secretKey
    });
});

app.get('/api/cow', function(req, res) {
    res.status(200).json({ 
        success     : true 
    ,   description : 'cow' 
    ,   src         : db.cow
    });
});

app.get('/api/seeCow', function(req, res) {
    res.status(200).sendFile(__dirname + db.cow);
});


var server = app.listen(3000, function () {
    var host = server.address().address;
    var port = server.address().port;

    console.log('Magic happening on port ' + port);
    
});


