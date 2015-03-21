/*data: {
	"score": ,
	"comment": ,
	"date": ,
	"latitude": ,
	"longitude": ,
	"hastags": [],
	"color": ,
}*/

var dbHandler = require('../handlers/dbHandler');


module.exports = function(app) {
	app.get('/', function(req,res) {
		res.send({"message": "HelloWorld!"})
	});

	app.post("/", function(req,res) {
		console.log("Hello " + req.body.name);
	}); 

	app.post("/addPoint", function(req,res) {
		var point = {
				"score" 	: req.body.score,
				"comment" 	: req.body.comment,
				"date" 		: req.body.date,
				"latitude" 	: req.body.latitude,
				"longitude" : req.body.longitude,
				"hastags" 	: req.body.hashtags
		};

		dbHandler.savePoint(point,function(err,res) {});


}