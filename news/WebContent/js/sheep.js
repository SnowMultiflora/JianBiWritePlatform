(function () {
    //定义控制羊移动数据池
    var obj = {
        frequency: 70, //协调频率，频率越小跑的越快
        stage: document.getElementsByClassName('stage')[0],
        num: 0,
        cot: 0,
        speed: 7,// 移动速度 
        maxSheep: 8//最大数量超过

    }
    //描述羊对象
    function Sheep(data) {
        this.sheep = document.createElement('div');//创建羊图片展示容器
        data.stage.appendChild(this.sheep);//将羊图片展示容器插入html结构中
        this.stage = data.stage;//为羊对象Sheep添加stage属性，属性值为羊图片的大容器
        this.sheep.className = 'sheep';//为羊图片容器添加class类名，让羊图片容器拥有样式
        this.frequencyNum = Math.floor(Math.random() * data.frequency) + 30;//随机产生羊移动的协调频率
        console.log(this.frequencyNum)
        this.sheepWith = this.sheep.offsetWidth;//获取羊容器的的宽度
        this.sheepLeft = this.sheep.offsetLeft;//获取羊容器的高度
        this.cot = data.cot;
        this.num = data.num;//羊图片让羊腿上一次动作过度到下一个动作的距离
        this.speed = data.speed;//获取羊的移动速度
        this.top = 0;
    }
    init();
    /*入口函数*/
    function init() {
        cteatSheep();
    }
    function cteatSheep() {
        var timer = setInterval(function () {
            var sheepNum = obj.stage.children.length;
            if (sheepNum > obj.maxSheep - 1) {
                return false;
            } else {
                var sheep = new Sheep(obj);
                sheepRun(sheep);
            }

        }, 1500)
    }

    function sheepRun(sheep) {
        var sheepAnimate = setInterval(function () {
            sheep.num = sheep.num + sheep.sheepWith;
            if (sheep.num == (sheep.sheepWith * 8)) {
                sheep.num = 0;
            }
            sheep.sheep.style.backgroundPosition = -sheep.num + 'px ' + sheep.top + 'px';
        }, sheep.frequencyNum);
        var sheepRun = setInterval(function () {
            sheep.cot = sheep.sheep.offsetLeft - sheep.speed;
            if (sheep.cot <= -sheep.sheepWith) {
                clearInterval(sheepRun);
                clearInterval(sheepAnimate);
                sheep.stage.removeChild(sheep.sheep);
            }
            sheep.sheep.style.left = sheep.cot + 'px';
        }, sheep.frequencyNum)
        // 添加拖     
        sheep.sheep.addEventListener('mousedown', function (e) {
            var event = event || e;

            sheep.top = -128;
            sheep.speed = 0;
            sheep.x = event.pageX;
            sheep.y = event.pageY;
            document.addEventListener('mousemove', sheepMove)
            function sheepMove(e) {
                var event = event || e;
                sheep.sheep.style.left = sheep.sheep.offsetLeft + (event.pageX - sheep.x) + 'px';
                sheep.sheep.style.top = sheep.sheep.offsetTop + (event.pageY - sheep.y) + 'px';
                sheep.x = event.pageX;
                sheep.y = event.pageY;
            }
            sheep.sheep.addEventListener('mouseup', function (e) {
                var event = event || e;

                sheep.top = 0;
                sheep.speed = obj.speed;
                document.removeEventListener('mousemove', sheepMove)
            })
        });
    }
})()