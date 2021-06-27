// out of memory
/**
 * @param {number[]} nums
 * @param {number[][]} queries
 * @return {number[]}
 */
var minDifference = function(nums, queries) {
    let helpArr = preProcess(nums);
    for(let idx1 = 0;idx1 < helpArr.length;idx1++){
        for(let idx2 = 0;idx2 < helpArr.length;idx2++){
            if(helpArr[idx1][idx2] == Infinity) helpArr[idx1][idx2] = -1;
        }
    }
    // console.log(helpArr);
    let result = [];
    for(let idx = 0;idx < queries.length;idx++){
        result.push(helpArr[queries[idx][0]][queries[idx][1]]);
    }
    return result;
};

function preProcess(nums){
    let result = new Array(nums.length);
    for(let idx = 0;idx < nums.length;idx++){
        result[idx] = new Array(nums.length);
    }
    for(let idx = 0;idx < result.length;idx++){
        result[idx][idx] = Infinity;
    }
    for(let length = 2;length <= nums.length;length++){
        for(let start = 0;start + (length - 1) < nums.length;start++){
            let end = start + (length - 1);
            if(length == 2){
                result[start][end] = nums[start] == nums[end] ? Infinity : Math.abs(nums[end] - nums[start]);
            }
            else{
                result[start][end] = Math.min(result[start][end - 1],result[start + 1][end]);
                let newEle = Math.abs(nums[start] - nums[end]);
                if(newEle != 0 && newEle < result[start][end]){
                    result[start][end] = newEle;
                }
            }
        }
    }
    return result;
}

minDifference([4,6,2,2,7],[[0,3],[2,4],[0,4],[0,4],[0,3]]);