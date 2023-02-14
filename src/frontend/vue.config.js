
module.exports = {
  	outputDir:path.resolve(__dirname, "../" + "main/resources/static"),
  	lintOnSave: false,
    devServer: {
	  proxy: {
		  '/' : {
			  target: "http://localhost:8090",
			  ws: false,
			  changeOrgin:true,
		  }
	  }
  }
}
