'use strict';

App.controller('UserController', ['$scope', 'UserService', function ($scope, UserService) {
    $scope.users = [];
    $scope.user = {};
    $scope.alert = '';

    $scope.getUsers = function () {
        UserService.getUsers()
            .then(
                function (data) {
                    $scope.users = data.content;
                },
                function (errResponse) {
                    console.error('Error while fetching data');
                }
            );
    };


    $scope.getUserById=function(userId){
        UserService.getUserById(userId)
            .then(
                function (data) {
                    $scope.user=data;
                    console.log(data)
                },
                function (errResponse) {
                    console.error('Error while fetching data');
                }
            );
    };

    $scope.updateUserById=function(userId, user){
        UserService.updateUserById(userId, user)
            .then(
                function (data) {
                    $scope.user=data;
                    console.log(data)
                },
                function (errResponse) {
                    console.error('Error while fetching data');
                }
            );
    };


    $scope.deleteUser=function(userId) {
        UserService.deleteUser(userId)
            .then(
                function (data) {
                    var str=data;
                    alert(str);
                },
                function (errResponse) {
                    console.error('Error while deleting user.');
                }
            );
    };


    $scope.createUser = function (user) {
        UserService.createUser(user)
            .then(
                function (data) {
                    $scope.alert = 'User: ' + data.firstName + ' has been created.';
                    $scope.user = {};
                    $scope.getUsers();
                },
                function (errResponse) {
                    console.error('Error while creating user.');
                }
            );
    };


    $scope.clearList = function () {
        $scope.users = [];
    };


    $scope.clearForm = function () {
        $scope.user = {};
    };
}]);