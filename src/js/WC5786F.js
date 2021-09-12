/**
 * @param {string} s
 * @param {string} p
 * @param {number[]} removable
 * @return {number}
 */
var maximumRemovals = function(s, p, removable) {
    let arr = [];
    let sArr = s.split("");
    let pArr = p.split("");
    for(let i=0;i<removable.length;i++){
        let insertPos = orderlyInsert(arr,removable[i]);
        let bigEleNum = (arr.length - 1) - insertPos;
        let smallEleNum = insertPos;
        sArr.splice(arr[insertPos] - smallEleNum,1);
        // console.log(sArr.join(""));
        // console.log(arr);
        if(!isSubSeq(sArr,pArr)) return i;
    }

    return removable.length;
};

function isSubSeq(mArr,cArr){
    return isSubsequence(cArr.join(""),mArr.join(""));
}

const isSubsequence = (s, t) => {
    // 如果s为空，直接返回true
    if (s.length === 0) return true;
    // 定义两个指针
    let indexS = 0,
        indexT = 0;
    // 遍历t
    while (indexT < t.length) {
        // 如果两个当前两指针值相等，indexS右移
        // 并判断s是否遍历结束，若结束就返回true
        if (s[indexS] === t[indexT]) {
            indexS++;
            if (indexS > s.length - 1) return true;
        }
        // indexT右移
        indexT++;
    }
    // 遍历t遍历完成，还没有返回true，就返回false
    return false;
};

function miniSplice(arr,idx){
    arr.splice(idx,1);
}

// need to optomize to O(log(N))
function orderlyInsert(arr,ele){
    if(arr.length == 0){
        arr.push(ele);
        return 0;
    }
    if(arr[arr.length - 1] < ele){
        arr.push(ele);
        return arr.length - 1;
    }

    if(arr[0] > ele){
        arr.splice(0,0,ele);
        return 0;
    }

    // for(let i = 0;i<arr.length;i++){
    //     if(ele<arr[i]){
    //         arr.splice(i,0,ele);
    //         return i;
    //     }
    // }

    let left = 0,right = arr.length - 1;
    while(true){
        let mid = (left + right)//2;
        if(ele < arr[mid]){
            right = mid -1;
            continue;
        }
        else if(ele > arr[mid + 1]){
            left = mid + 2;
        }
        else{
            // console.log(mid);
            arr.splice(mid + 1,0,ele);
            return mid + 1;
        }
    }
}

// maximumRemovals("qobftgcueho","obue",[5,3,0,6,4,9,10,7,2,8])
// console.log(orderlyInsert([0,3,5,6],4));