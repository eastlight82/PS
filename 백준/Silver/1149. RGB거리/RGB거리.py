import sys

# 입력 처리
N = int(input())  # 집의 개수
RGB = [list(map(int, input().split())) for _ in range(N)]

# DP 테이블 초기화
dp = [[0] * 3 for _ in range(N)]

# 첫 번째 집은 초기 비용으로 설정
dp[0][0] = RGB[0][0]  # 첫 번째 집을 빨강으로 칠하는 경우
dp[0][1] = RGB[0][1]  # 첫 번째 집을 초록으로 칠하는 경우
dp[0][2] = RGB[0][2]  # 첫 번째 집을 파랑으로 칠하는 경우

# 두 번째 집부터 N번째 집까지 계산
for i in range(1, N):
    dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + RGB[i][0]  # 빨강을 선택한 경우
    dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + RGB[i][1]  # 초록을 선택한 경우
    dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + RGB[i][2]  # 파랑을 선택한 경우

# 마지막 집에서의 최소 비용을 출력
print(min(dp[N-1]))
