var db = require('../config/db');

module.exports = {
	savePoint: function(point,onSuccess) {
		var con = db.createConnection();
		con.connect();


		var query = ""

		con.query(query, function(err,rows.fields) {	
			if (err) throw err;
 			
		});

		con.close();
	}
}