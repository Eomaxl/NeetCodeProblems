from typing import List

class ContainerWithMostWater:
    @staticmethod
    def container_with_most_water(arr) -> int:
        start = 0
        end = len(arr) - 1
        area = 0
        while start < end:
            area = max(area, min(arr[start], arr[end]) * (end - start))
            if arr[start] < arr[end]:
                start += 1
            else:
                end -= 1

        return area
    
def main():
    input = [1,8,6,2,5,4,8,3,7]
    output = ContainerWithMostWater.container_with_most_water(input)
    print(f"The max area is {output}")

if __name__ == "__main__":
    main()