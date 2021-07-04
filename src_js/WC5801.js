/**
 * @param {number[]} dist
 * @param {number[]} speed
 * @return {number}
 */
var eliminateMaximum = function(dist, speed) {
    let arriveTime = dist.map((num,idx)=>{return num/speed[idx];}).map((num)=>{return Math.ceil(num)});
    arriveTime.sort(function(a, b) {
        return a - b;
      });

    // console.log(arriveTime);

    let idx = 0;
    for(num of arriveTime){
        if(num <= idx){
            return idx;
        }
        idx++;
    }

    return arriveTime.length;
};