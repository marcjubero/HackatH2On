var db = require('../config/db');

module.exports = {
	savePoint: function(point,onSuccess) {
		var con = db.createConnection();

		con.connect(function(err) {
			if (err) {
				console.error('error connecting: ' + err.stack);
			}
			console.log('connected as id ' + con.threadId);
		});

		console.log("savePoint");
		console.log(point);

		var query = "INSERT INTO point (rate,comment,lat,lon) " + 
					"VALUES (" + point.rate + ", \"" + point.comment + "\"," +point.latitude+ ", " +point.longitude+ ")";

		console.log(query);					

		con.query(query, function(err,rows,fields) {	
			if (err) console.log("err: " + err);
			onSuccess(err,rows);
		});

		con.end();
	},

	getPoints: function(onSuccess) {
		var con = db.createConnection();
		var query = "SELECT * FROM point";

		con.query(query, function(err,rows,fields) {
			if (err) console.log("err: " + err);
			onSuccess(err,rows);
		});

		con.end();
	}
}