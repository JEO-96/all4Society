
const path = require('path');

module.exports = {
  	outputDir:path.resolve(__dirname, "../" + "main/resources/static"),
  	lintOnSave: false,
    devServer: {
	  proxy: {
		  '/' : {
			  target: "http://localhost:8080",
			  ws: false,
			  changeOrgin:true,
		  }
	  }
  }
}
