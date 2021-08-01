const reducer = (accumulator, curr) => accumulator + curr;

var numberOfWeeks = function(milestones) {
    if(milestones.length == 1) return milestones[0] > 0 ? 1 : 0;
    milestones.sort(function(a, b) {
        return a - b;
      });
      ;
    const taskNum = milestones.length;
    const maxMilestone = milestones[taskNum - 1];
    const otherMilestones = milestones.slice(0, taskNum - 1);
    const otherMilestonesSum = otherMilestones.reduce(reducer);
    const milestonesSum = otherMilestonesSum + maxMilestone;
    return otherMilestonesSum < maxMilestone ? otherMilestonesSum * 2 + 1 : milestonesSum;
};