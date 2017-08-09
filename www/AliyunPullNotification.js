var exec = require('cordova/exec');

exports.startPull = function(args, success, error) {
    exec(success, error, "AliyunPullNotification", "startPull", [args]);
};

exports.endPull = function (args, success, error) {
    exec(success, error, "AliyunPullNotification", "endPull", [args]);
};
