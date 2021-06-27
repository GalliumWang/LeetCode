/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number[][]}
 */
var rotateGrid = function(grid, k) {
    let m = grid.length,n = grid[0].length;
    let circleNum = Math.min(m,n) / 2;
    let result = new Array(m);
    for(let i = 0;i < result.length;i++) {
        result[i] = new Array(n);
    }
    for(let i = 0;i < circleNum;i++) {
        rotate(grid,k,i,result);
    }
    console.log(result);
    return result;
};
// circleIdx start from 0
function rotate(grid,k,circleIdx,result){
    let m = grid.length,n = grid[0].length;
    let mCircle = m - 2 * circleIdx,nCircle =n - 2 * circleIdx;
    let circleLen = 2 * mCircle + 2 * nCircle - 4;
    k = k % circleLen;
    let idxArr = [];
    for(let i = circleIdx;i < m - 1 - circleIdx;i++){
        idxArr.push([i,circleIdx]);
    }
    for(let i = circleIdx;i < n - 1 - circleIdx;i++){
        idxArr.push([m - 1 -circleIdx,i]);
    }
    for(let i = m - 1 - circleIdx;i > circleIdx;i--){
        idxArr.push([i,n - 1 - circleIdx]);
    }
    for(let i = n - 1 - circleIdx;i > circleIdx;i--){
        idxArr.push([circleIdx,i]);
    }
    for(let i = 0;i < circleLen;i++){
        let srcIdx = idxArr[i];
        let dstIdx = idxArr[(i + k) % circleLen];
        result[dstIdx[0]][dstIdx[1]] = grid[srcIdx[0]][srcIdx[1]];
    }
}