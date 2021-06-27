/**
 * @param {string} startTime
 * @param {string} finishTime
 * @return {number}
 */
var numberOfRounds = function(startTime, finishTime) {
    let bench1 = timeConvert(startTime),bench2 = timeConvert(finishTime);
    if(bench2 < bench1) bench2 += 24*4;
    bench1 = Math.ceil(bench1);
    bench2 = Math.floor(bench2);
    let result = bench2 - bench1;
    return result;
};

function timeConvert(timeStr){
    let hour,min;
    hour = parseFloat(timeStr.split(":")[0]);
    min = parseFloat(timeStr.split(":")[1]);
    return hour * 4 + min / 15;
}