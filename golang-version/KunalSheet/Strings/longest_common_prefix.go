package main

import (
	"fmt"
	"math"
	"strings"
)

// input: strs = ["flower", "flow", "flight"], output : "flu"

func main() {
	strs := []string{"flower", "flow", "flight"}
	fmt.Println(longestCommonPrefix(strs))
}

func longestCommonPrefix(strs []string) string {
	if strs == nil || len(strs) == 0 {
		return ""
	}

	minLen := math.MaxInt32
	for _, str := range strs {
		if len(str) < minLen {
			minLen = len(str)
		}
	}

	low, high := 1, minLen

	for low <= high {
		middle := (low + high) / 2
		if isCommonPrefix(strs, middle) {
			low = middle + 1
		} else {
			high = middle - 1
		}
	}
	return strs[0][:(low+high)/2]
}

func isCommonPrefix(strs []string, length int) bool {
	prefix := strs[0][:length]
	for i := 1; i < len(strs); i++ {
		if !strings.HasPrefix(strs[i], prefix) {
			return false
		}
	}
	return true
}
