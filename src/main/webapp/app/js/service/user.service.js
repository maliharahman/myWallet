'use strict';

App.factory('UserService', ['$http','$q',function ($http, $q) {
    return {
        getUsers: function () {
            return $http.get('http://localhost:8081/api/v1/users/')
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while fetching users');
                        return $q.reject(errResponse);
                    }
                );
        },


        getUserById: function(userId){
            return $http.get('http://localhost:8081/api/v1/users/'+ userId)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while fetching user with ID');
                        return $q.reject(errResponse);
                    }
                )
        },

        updateUserById: function(userId, user){
            return $http.put('http://localhost:8081/api/v1/users/'+ userId, user)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while fetching user with ID');
                        return $q.reject(errResponse);
                    }
                )
        },


        deleteUser: function(userId){
            return $http.delete('http://localhost:8081/api/v1/users/'+ userId)
                .then(
                    function (response) {
                        return response;
                    },
                    function (errResponse) {
                        console.error('Error while deleting user');
                        return $q.reject(errResponse);
                    }
                );
        },


        createUser: function (user) {
            return $http.post('http://localhost:8081/api/v1/users/', user)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while creating user');
                        return $q.reject(errResponse);
                    }
                );
        }
    }
}]);