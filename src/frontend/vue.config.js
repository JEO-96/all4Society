const { defineConfig } = require('@vue/cli-service');
const path = require('path');

module.exports = {
  	outputDir:path.resolve(__dirname, "../" + "main/resources/static"),
    devServer: {
	  proxy: {
		  '/' : {
			  target: "http://localhost:8090",
			  ws:true,
			  changeOrgin:true,
		  }
	  }
  }
}
