// req.params.xxxxx 从path中的变量
// req.query.xxxxx 从get中的?xxxx=中
// req.body.xxxxx 从post中的变量

angular.module('menus').controller('MenuController', ['$scope', 'Menus', function($scope, Menus) {

    $scope.getMenu = function(){
        $scope.menus = Menus.query();
    };
}]);