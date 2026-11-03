class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result=[]
        for i in range(len(intervals)):
            #current interval is before the new interval that is to be inserted

            if intervals[i][1]<newInterval[0]:
                result.append(intervals[i])
            #current interval is completely after new interval
            elif intervals[i][0]>newInterval[1]:
                result.append(newInterval)
                result.extend(intervals[i:])
                return result
            else:
                #need to merge
                newInterval[0]=min(newInterval[0],intervals[i][0])
                newInterval[1]=max(newInterval[1],intervals[i][1])
        result.append(newInterval)
        return result