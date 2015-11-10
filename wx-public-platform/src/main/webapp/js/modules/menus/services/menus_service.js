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