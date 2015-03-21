var mysql = require('mysql');

module.exports = {
	createConnection: function() {
		var connection = mysql.createConnection(
		{
			host     : 'localhost',
		    user     : 'root',
		    password : '',
		    database : 'HackatH2On',
		});

		return connection;
	}
}