module.exports = function(app) {
	app.get('/', function(req,res) {
		res.send({"message": "HelloWorld!"})
	});

	app.post("/", function(req,res) {
		console.log("Hello " + req.body.name);
	}); 
}