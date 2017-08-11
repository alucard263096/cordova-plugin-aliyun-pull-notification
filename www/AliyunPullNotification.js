var argscheck = require('cordova/argscheck'),
    exec = require('cordova/exec');


module.exports = {

    startPull: function (args, success, error) {
        exec(success, error, "AliyunPullNotification", "startPull", [args]);
    },
    endPull: function (args, success, error) {
        exec(success, error, "AliyunPullNotification", "endPull", [args]);
    }

};