class MergeIntervals:
    @staticmethod
    def merge_intervals(intervals):
        if not intervals:
            return []
        
        intervals.sort(key=lambda x: x[0])

        merged = []

        for interval in intervals:
            if not merged or merged[-1][1] < interval[0]:
                merged.append(interval[:])
            else:
                merged[-1][1] = max(merged[-1][1], interval[1])

        return merged

def merge_short(intervals):
    intervals.sort(key = lambda x:x[0])
    merged = []

    for start,end in intervals:
        if not merged or merged[-1][1] < start:
            merged.append([start,end])
        else:
            merged[-1][1] = max(merged[-1][1],end)
    return merged


def main():
    intervals = [[1,3],[2,6],[8,10],[15,18]] 
    output = MergeIntervals.merge_intervals(intervals)

    for i in output:
        print(f"[{i[0]}, {i[1]}]")
    
if __name__ == "__main__":
    main()