/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    len=nums.length;
    let index=0;
    for(let i=0;i<len;i++){
        if(!nums[index]){
            nums.splice(index,1);
            nums.push(0);
        }
        else{
            index++;
        }
    }
    return nums;
};

console.log(moveZeroes([0,1,0,3,12]))