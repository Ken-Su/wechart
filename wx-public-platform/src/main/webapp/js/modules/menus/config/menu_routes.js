angular.module('menus').config(['$stateProvider', function($stateProvider) {

  $stateProvider.state('menuList',{
    url : '/menu',
    templateUrl : 'modules/menus/views/menu_list_view.html'
  });

}]);
