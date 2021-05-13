/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {
    version1=version1.split(".");
    version2=version2.split(".");
    while(version1[version1.length-1]==0){
        version1.pop();
    }
    while(version2[version2.length-1]==0){
        version2.pop();
    }
    while(version1.length&&version2.length){
        let verNum1=Number(version1.shift());
        let verNum2=Number(version2.shift());
        if(verNum1>verNum2){
            return 1;
        }
        else if(verNum1<verNum2){
            return -1;
        }
    }
    if(version1.length){
        return 1
    }
    else if(version2.length){
        return -1;
    }
    else{
        return 0;
    }
};

compareVersion("1.01","1.001");