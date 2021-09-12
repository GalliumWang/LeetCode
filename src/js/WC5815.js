/**
 * @param {number[][]} points
 * @return {number}
 */
var maxPoints = function(points) {
    let m = points.length,n = points[0].length;
    let result = points[0];
    for(let i = 1; i < m;i++){
        let tempArr = [];
        for(let j = 0; j < n; j++){
            let tempResult = -Infinity;
            for(let k = 0; k < n; k++){
                if(points[i][j] + result[k] - Math.abs(j - k) > tempResult) tempResult = points[i][j] + result[k] - Math.abs(j - k);
            }
            tempArr.push(tempResult);
        }
        result = tempArr;
        // console.log(result);
    }
    return Math.max(Math.max(...result));
};