var config = {
    type: Phaser.AUTO,
    width: 1366,
    height: 768,
    scene: {
        preload: preload,
        create: create,
        update: update
    }
};

var game = new Phaser.Game(config);

function preload (){
    this.load.image('bird','assets/sprites/bird.png');
    this.load.image('sky','assets/prefabs/sky.png');
    this.load.image('stars','assets/prefabs/stars.png');
    this.load.image('ground','assets/prefabs/ground.png');
    this.load.image('clouds','assets/prefabs/clouds.png');
    this.load.image('pipeUp','assets/prefabs/PipeUp.png');
    this.load.image('pipeDown','assets/prefabs/pipeDown.png');
}

function create (){
    
    this.add.image(0,0,'sky').setOrigin(0,0);
    this.add.image(0,0,'stars').setOrigin(0,0);
    platforms = this.physics.add.staticGroup();
    platforms.create(400, 568, 'ground').setScale(2).refreshBody();
    this.add.sprite(150,384,'bird');
}

function update ()
{

}