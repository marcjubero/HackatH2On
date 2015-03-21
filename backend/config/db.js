var mysql = require('mysql');

module.exports = {
	createConnection: function() {
		var connection;

		connection = mysql.createConnection(
			{
				host     : 'localhost',
			    user     : 'root',
			    password : '',
			    database : 'HackatH2On',
			});

		console.log("connection -> " + connection);

		return connection;
	}
}


/*
var mongo = require('mongodb').MongoClient;

module.exports = {
	createConnection: function() {
		var mongo,
			url = "mongodb://<admin>:<4dm1n>@ds043329.mongolab.com:43329/hackath2on";

		mongo.connect(url, function(err,db) {
			if(!err) mongo = db;
			else console.log("err -> " + err);
		});

		return mongo;
	}
}
*/