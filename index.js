var express = require('express'); 
var app = express(); 
var bodyParser = require('body-parser'); 

app.use(bodyParser.urlencoded({extended:true})); 
app.use(bodyParser.json()); 

var port = process.env.PORT || 8080;

var userTokens = [];

var verifyUser = function(req, res, next){
  if(userTokens[req.headers["authorization"]]==undefined){
    //res.status(407).json({message: "you need signin"})
    console.log("need");
    next();
  }else{
    console.log("don't need");
    next();
  }
}

app.use(verifyUser);

var pool = require('./db'); 
app.use('/users',require('./routes/server/users')(pool,userTokens)); 
app.use('/restaurants',require('./routes/server/restaurants')(pool)); 
app.use('/follows',require('./routes/server/follows')(pool)); 
app.use('/reviews',require('./routes/server/reviews')(pool)); 
app.use('/request',require('./routes/server/user-requests')(pool)); 
app.use('/ad',require('./routes/server/ad')(pool)); 

app.get('/', function (req, res) {
  res.send('Hello World!');
});
 
var server = app.listen(port, function () {
  console.log('서버 동작중.' + port);
});