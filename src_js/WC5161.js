/**
 * @param {string} text
 * @param {string} brokenLetters
 * @return {number}
 */
var canBeTypedWords = function(text, brokenLetters) {
    let originalLetters = text.split(" ");
    // console.log(originalLetters);
    for(letter of brokenLetters.split("")){
        text = text.replaceAll(letter,"");
    }
    let processedLetters = text.split(" ");
    // console.log(processedLetters);
    let idx = 0;
    let count = 0;
    for(word of processedLetters){
        if(word.length == originalLetters[idx].length){
            count++;
        }
        idx++;
    }
    return count;
};