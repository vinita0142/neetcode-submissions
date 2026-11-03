"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        starts=[]
        ends=[]

        for interval in intervals:
            starts.append(interval.start)
            ends.append(interval.end)
        starts.sort()
        ends.sort()
        start=0
        end=0

        rooms=0
        while start<len(starts):
            if (starts[start]<ends[end]):
                rooms+=1
                start+=1
            else:
                #meeting ended use same room
                end+=1
                start+=1
        return rooms
