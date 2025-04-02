from typing import List

class Solution:

    def encode(self, strs: List[str]) -> str:

        res = ""

        for s in strs:
            res += str(len(s)) + "#" + s

        return res

    def decode(self, s: str) -> List[str]:

        res = []

        for i in range(len(s)):

            checkpoint = s.find('#', i)
            digitLength = int(s[i : checkpoint])
            valueStr = s[checkpoint + 1: checkpoint + digitLength + 1]

            res.add(valueStr)
            i = digitLength + checkpoint

        return res