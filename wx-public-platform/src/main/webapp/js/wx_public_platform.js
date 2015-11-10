ApplicationConfiguration.registerModule('menus');
angular.module('menus').config(['$stateProvider', function($stateProvider) {

  $stateProvider.state('menuList',{
    url : '/menu',
    templateUrl : 'js/modules/menus/views/menu_list_view.html'
  });

}]);

// req.params.xxxxx 从path中的变量
// req.query.xxxxx 从get中的?xxxx=中
// req.body.xxxxx 从post中的变量

angular.module('menus').controller('MenuController', ['$scope', 'Menus', function($scope, Menus) {

    $scope.getMenu = function(){
        $scope.menus = Menus.query();
    };
}]);
angular.module('menus').factory('Menus', ['$resource',
    function($resource) {
        return $resource('menu', {}, {
            update: {
                method: 'PUT'
            },
            query: { 
                isArray:false
            }
        });
    }

]);