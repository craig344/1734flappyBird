var config = {
    type: Phaser.AUTO,
    width: 1366,
    height: 768,
    physics: {
        default: 'arcade',
        arcade: {
            gravity: { y: 300 },
            debug: false
        }
    },
    scene: {
        preload: preload,
        create: create,
        update: update
    }
};

var game = new Phaser.Game(config);

function preload() {
    this.load.image('bird', 'assets/sprites/bird.png');
    this.load.image('sky', 'assets/prefabs/sky.png');
    this.load.image('stars', 'assets/prefabs/stars.png');
    this.load.image('ground', 'assets/prefabs/ground.png');
    this.load.image('clouds', 'assets/prefabs/clouds.png');
    this.load.image('pipeUp', 'assets/prefabs/PipeUp.png');
    this.load.image('pipeDown', 'assets/prefabs/pipeDown.png');
}

function create() {

    this.add.image(0, 0, 'sky').setOrigin(0, 0);
    this.add.image(0, 0, 'stars').setOrigin(0, 0).setScale(0.73);

    platforms = this.physics.add.staticGroup();
    platforms.create(700, 1000, 'pipeDown').refreshBody();
    this.add.image(0, 730, 'ground').setOrigin(0, 0).setScale(0.45);
    
    player = this.physics.add.sprite(100, 450, 'bird');
    

    player.setBounce(0.2);
    player.setCollideWorldBounds(true);
    cursors = this.input.keyboard.createCursorKeys();
    this.physics.add.collider(player, platforms);

    this.anims.create({
         key: 'left',
         frameRate: 10,
         repeat: -1
     });
 
     this.anims.create({
         key: 'turn',
         frameRate: 20
     });
 
     this.anims.create({
         key: 'right',
         frameRate: 10,
         repeat: -1
     }); 
}

function update() {
    
    if (cursors.left.isDown) {
        player.setVelocityX(-160);
    }
    else if (cursors.right.isDown) {
        player.setVelocityX(160);
    }
    else {
        player.setVelocityX(0);
    }

    if (cursors.up.isDown) {
        player.setVelocityY(-330);
    }
}