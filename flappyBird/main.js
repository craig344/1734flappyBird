var mainState = {
    preload: function(){

    },
    create: function(){

    }, 
    update: function(){
         
    },
};

var game = new Phaser.Game(1920,1080);

game.state.add('main',mainState);
game.state.start('main');