线性规划法
如果不考虑时间复杂度，我们可以枚举出所有子数组并求出他们的和。不过非常遗憾的是，由于长度为n的数组有O(n2)个子数组；
而且求一个长度为n的数组的和的时间复杂度为O(n)。因此这种思路的时间是O(n3)。

很容易理解，当我们加上一个正数时，和会增加；当我们加上一个负数时，和会减少。
如果当前得到的和是个负数，那么这个和在接下来的累加中应该抛弃并重新清零，不然的话这个负数将会减少接下来的和。
时间复杂度O(n)。