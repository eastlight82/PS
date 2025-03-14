static int LCS(int x, int y) {
		
	// 인덱스 밖 (공집합)일 경우 0 반환
	if(x == -1 || y == -1) {
		return 0;
	}
 
	// 만약 탐색하지 않은 인덱스라면?
	if(dp[x][y] == null) {
		dp[x][y] = 0;
 
		// str1의 x번째 문자와 str2의 y번째 문자가 같은지 검사: Btrck 방식
		if(str1[x] == str2[y]) {
			dp[x][y] = LCS(x - 1, y - 1) + 1;
		}
 
		// 같지 않다면 LCS(dp)[x-1][y]와 LCS(dp)[x,y-1] 중 큰 값으로 초기화
		else {
			dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
		}
	}
	
	return dp[x][y];
}
