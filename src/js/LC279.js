function isPoweredNum(n){
    let sqrtedNum=Math.sqrt(n);
    return Math.floor(sqrtedNum)===sqrtedNum;
}

function dynamicCompute(n){
    let helpArr=[undefined,[1,1]];
    for(let i=2;i<=n;i++){
        if(isPoweredNum(i)) helpArr.push([i,1]);
        else{
            let miniumNum=helpArr[helpArr.length-1][1]+1;
            for(let j=1;j<i;j++){
                if(isPoweredNum(i-j)) miniumNum=Math.min(miniumNum,helpArr[j][1]+1);
            }
            helpArr.push([i,miniumNum]);
        }
    }
    console.log(helpArr);
    return helpArr.pop()[1];
}

/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
    if(isPoweredNum(n)) return 1;
    else{
        return dynamicCompute(n);
    }
};

console.log(numSquares(13));