var express = require('express'),
    bodyParser = require('body-parser'),
    app = express();

app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());

var port = process.env.PORT || 8080;

require('./router/router')(app);

app.listen(port, function() {
	console.log("Magic happens on localhost:" + port);	
});
