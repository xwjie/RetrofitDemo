
var restify = require('restify');

var ip_addr = '127.0.0.1';
var port    =  '8081';

var server = restify.createServer({
    name : "myapp"
});

server.use(restify.queryParser());
server.use(restify.bodyParser());
//server.use(restify.CORS());

var PATH = '/demo'
server.get({path : PATH + '/get1', version : '0.0.1'} , get1);
server.get({path : PATH + '/get2/:param1' , version : '0.0.1'} , get2);
server.get({path : PATH + '/get3' , version : '0.0.1'} , get3);

server.get({path : PATH + '/headtest' , version : '0.0.1'} , headtest);


// listen
server.listen(port ,ip_addr, function(){
    console.log('%s listening at %s ', server.name , server.url);
});

function get1(req, res , next){
    console.log('没有参数的请求');
    
    var result = { msg: '没有带参数的get请求', code: 0};
    res.send(200 , result);
    return next();
}

function get2(req, res , next){
    console.log('带path参数的get请求, 参数值为：', req.params);
    
    var result = { msg: '带path参数的get请求, 参数值为：' + req.params.param1, code: 0};
    res.send(200 , result);
    
    return next();
}

function get3(req, res , next){
    console.log('带query参数的get请求, 参数值为：', req.params);

    var result = { msg: '带query参数的get请求, 参数值为：' + req.params.param2, code: 0};
    res.send(200 , result);
    
    return next();
}

function headtest(req, res , next){
    console.log('headers=', req.headers);
    
    var result = { msg: '打印头测试', code: 0};
    res.send(200 , result);
    
    return next();
}
