/**
 * @param {number} n
 * @return {number}
 */

const modNum = Math.pow(10,9) + 7;

var countGoodNumbers = function(n) {
    let bitArr = [];
    while (n){
        let reminder = n % 2;
        if(reminder){
            n = (n - 1) / 2;
        }
        else{
            n = n / 2;
        }

        bitArr.push(reminder);
    }

    bitArr.reverse();

    bitArr.shift();
    let currentNum = 1;
    let result = 5;
    let idx = 0;
    for(bit of bitArr){
        if(currentNum % 2 == 0){
            result = (result * result) % modNum;
            if(bit) result = (result * 4) % modNum;
        }
        else{
            result = (result * result / 5 * 4) % modNum; // FIXME: can't use divide to calculate mod
            if(bit) result = (result * 5) % modNum;;
        }
        currentNum = currentNum *2 + bit;
        idx++;
    }

    return result;
};