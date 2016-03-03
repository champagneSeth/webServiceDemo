var express         = require('express')
,   app             = express()
,   path            = require('path')
,   bodyParser      = require('body-parser')
,   fs              = require('fs')
,   methodOverride  = require('method-override')
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


app.get('/api/image', function(req, res) {
    res.status(200).json({ success : true, description : 'cow', url:''});
});

app.get('/api/actualImage', function(req, res) {
    res.status(200).sendFile(__dirname + '/picture.jpg');
});

var server = app.listen(3000, function () {
    var host = server.address().address;
    var port = server.address().port;

    console.log('Magic happening on port ' + port);
    
});

