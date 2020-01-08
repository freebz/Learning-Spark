-- 예제 9-40 스파크 SQL로 다중 합계 구하기

SELECT SUM(user.favouritesCount), SUM(retweetCount), user.id FROM tweets
  GROUP BY user.id
