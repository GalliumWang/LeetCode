function indexOfMax(arr) {
    if (arr.length === 0) {
        return -1;
    }

    var max = arr[0];
    var maxIndex = 0;

    for (var i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            maxIndex = i;
            max = arr[i];
        }
    }

    return maxIndex;
}

function compatibilityTest(stuAns,teacherAns){
    let idx = 0,count = 0;
    while(idx < stuAns.length){
        if(stuAns[idx] == teacherAns[idx]) count++;
        idx++;
    }
    return count;
}

function findMatrixMax(matrix){ 
    let m = matrix.length,n = matrix[0].length;
    let idxsArray = [];
    let maxNum = -1;
    for(let i = 0; i < m; i++) {
        for(let j = 0; j < n; j++) {
            if(matrix[i][j] > maxNum){
                maxNum = matrix[i][j];
                idxsArray = [[i,j]];
            }
            else if(matrix[i][j] == maxNum){
                idxsArray.push([i,j]);
            }
        }
    }

    return idxsArray;
}

function arrClone(currentArray){
    var newArray = [];
    for (var i = 0; i < currentArray.length; i++)
        newArray[i] = currentArray[i].slice();
    return newArray;
}

/**
 * @param {number[][]} students
 * @param {number[][]} mentors
 * @return {number}
 */
var maxCompatibilitySum = function(students, mentors) {
    let pairNum = students.length;
    let record = new Array(pairNum);
    for(i = 0;i < pairNum;i++) {
        record[i] = new Array(pairNum);
    }

    students.map((element, index, array) => { 
        for(let i = 0;i < pairNum;i++) {
            record[index][i] = compatibilityTest(element,mentors[i]);
        }
    })

    let idx = 0;
    let result = 0;

    while(students.length > 0){
        let idxsArray = findMatrixMax(record);
        if(idxsArray.length == 1){
            let idxs = idxsArray[0];
            result += record[idxs[0]][idxs[1]];
            record.splice(idxs[0],1);
            students.splice(idxs[0],1);
            mentors.splice(idxs[1],1);
            for(singleRecord of record){
                singleRecord.splice(idxs[1],1);
            }
            idx++;
        }
        else{
            result += record[idxsArray[0][0]][idxsArray[0][1]];
            let resultArr = [];
            while(idxsArray.length > 0){
                let idxs = idxsArray.shift();
                let stuCopy = arrClone(students);
                let menCopy = arrClone(mentors);
                stuCopy.splice(idxs[0],1);
                menCopy.splice(idxs[1],1);
                resultArr.push(maxCompatibilitySum(stuCopy,menCopy));
            }
            return Math.max(...resultArr) + result;
        }
    }
    
    return result;
};

console.log(maxCompatibilitySum([[1,1,0],[1,0,1],[0,0,1]],[[1,0,0],[0,0,1],[1,1,0]]))