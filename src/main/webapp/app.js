app.service('UserCRUDService', ['$http', function ($http) {

    this.getUsers = function getUser(userId){
        return $http({
            method: 'GET',
            url: '/api/v1/users/' + userId
        });
    }

    this.createUsers = function createUsers(name, email){
        return $http({
            method: 'POST',
            url: '/api/v1/users/',
            data:{
                name: name,
                email:email
            }
        });
    }
}]);