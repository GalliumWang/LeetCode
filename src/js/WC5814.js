/**
 * @param {number[]} rungs
 * @param {number} dist
 * @return {number}
 */
var addRungs = function(rungs, dist) {
    let currentRung = 0;
    let result = 0;
    for(rung of rungs) {
        let distance = rung - currentRung;
        let rungToInsert = Math.ceil(distance / dist -1);
        if(rungToInsert > 0) result += rungToInsert;
        currentRung = rung;
    }
    return result;
};

addRungs([1,3,5,10],2);