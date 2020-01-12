// 예제 10-17 스칼라에서 window()를 사용해 윈도의 데이터를 집계하는 예제

val accessLogsWindow = accessLogsDStream.window(Seconds(30), Seconds(10))
val windowCounts = accessLogsWindow.count()
