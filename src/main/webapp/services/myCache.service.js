(function() {
    angular
    .module('spotifyWebApp')
    .factory('MyCacheService', ['$cacheFactory', MyCacheService]);

    function MyCacheService($cacheFactory) {
        return $cacheFactory('myData');   
    }
    
})();